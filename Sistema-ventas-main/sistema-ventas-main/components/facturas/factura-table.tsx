"use client"; // El componente se ejecuta por el lado del cliente

//Importación de acciones y componentes personalizados
import { obtenerFactura, obtenerFacturas } from "@/app/actions/factura-actions";
import { Badge } from "@/components/ui/badge";
import { Button } from "@/components/ui/button";
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from "@/components/ui/dialog";
import { Input } from "@/components/ui/input";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
// Importa el elemento useToast del componente use-toast
import { useToast } from "@/components/ui/use-toast";
// Importa la clase jsPDF para generar archivos PDF en el cliente
import jsPDF from "jspdf";
// Importa el plugin autoTable para agregar tablas automáticamente a los PDFs generados con jsPDF
import autoTable from "jspdf-autotable";
// Iconos importados de lucide-react
import { Download, Eye, Plus, Printer } from "lucide-react";
import { useState } from "react";
// Componente que muestra los detalles de una factura seleccionada
import { FacturaDetails } from "./factura-details";
// Componente que renderiza el formulario para crear o editar una factura
import { FacturaForm } from "./factura-form";

interface FacturaTableProps {
  initialData: any[];
}

/**
 * Componente principal que renderiza una tabla interactiva de facturas con funcionalidades de:
 * - Búsqueda por número o cliente
 * - Filtro por estado (PENDIENTE, PAGADA, ANULADA)
 * - Visualización de detalles de la factura
 * - Creación de nuevas facturas
 * - Exportación a PDF e impresión de facturas
 */
export function FacturaTable({ initialData }: FacturaTableProps) {
  const { toast } = useToast();
  const [searchTerm, setSearchTerm] = useState("");
  const [statusFilter, setStatusFilter] = useState("");
  const [data, setData] = useState(initialData);
  const [selectedFactura, setSelectedFactura] = useState<any>(null);
  const [isViewDialogOpen, setIsViewDialogOpen] = useState(false);
  const [isNewDialogOpen, setIsNewDialogOpen] = useState(false);
  const [viewFactura, setViewFactura] = useState<any>(null);
  const [viewFacturaData, setViewFacturaData] = useState<any>(null);
  const [viewLoading, setViewLoading] = useState(false);

  // Diccionario para mostrar el estado en letras
  const estadoTexto: Record<string, string> = {
    "1": "PENDIENTE",
    "2": "PAGADA",
    "3": "ANULADA",
    PENDIENTE: "PENDIENTE",
    PAGADA: "PAGADA",
    ANULADA: "ANULADA",
  };

  // Format date for display
  const formatDate = (dateValue: string | Date | null | undefined) => {
    if (!dateValue) return "N/A";
    let dateStr = "";
    if (typeof dateValue === "string") {
      const match = /\d{4}-\d{2}-\d{2}/.exec(dateValue);
      if (match) {
        const [year, month, day] = match[0].split("-");
        return `${day}/${month}/${year}`;
      }
      const d = new Date(dateValue);
      if (!isNaN(d.getTime())) {
        const day = String(d.getDate()).padStart(2, "0");
        const month = String(d.getMonth() + 1).padStart(2, "0");
        const year = d.getFullYear();
        return `${day}/${month}/${year}`;
      }
      return "N/A";
    } else if (dateValue instanceof Date) {
      const day = String(dateValue.getDate()).padStart(2, "0");
      const month = String(dateValue.getMonth() + 1).padStart(2, "0");
      const year = dateValue.getFullYear();
      return `${day}/${month}/${year}`;
    }
    return "N/A";
  };

  // Get badge color based on status
  const getBadgeVariant = (status: string) => {
    switch (status) {
      case "PAGADA":
        return "success";
      case "PENDIENTE":
        return "warning";
      case "ANULADA":
        return "destructive";
      default:
        return "secondary";
    }
  };

  // Filter facturas based on search term and status
  const filteredData = data.filter((factura) => {
    const matchSearch =
      factura.num_fac.toLowerCase().includes(searchTerm.toLowerCase()) ||
      factura.cliente.toLowerCase().includes(searchTerm.toLowerCase());

    let estadoFactura;

    switch (factura.est_fac) {
      case "1":
        estadoFactura = "PENDIENTE";
        break;
      case "2":
        estadoFactura = "PAGADA";
        break;
      case "3":
        estadoFactura = "ANULADA";
        break;
      default:
        estadoFactura = "ALL";
        
    }

    const matchStatus =
      statusFilter && statusFilter !== "ALL"
        ? estadoFactura === statusFilter
        : true;

    return matchSearch && matchStatus;
  });

  const handlePrint = (numFac: string) => {
    toast({
      title: "Imprimiendo factura",
      description: `Preparando impresión de la factura ${numFac}`,
    });
  };

  const handleFacturaCreated = async (newFactura: any) => {
    toast({
      title: "Factura creada",
      description: "La factura ha sido creada correctamente.",
    });
    const result = await obtenerFacturas();
    if (result.success) {
      setData(result.data);
    }
    setIsNewDialogOpen(false);
  };

  const printFactura = (factura: any) => {
    const html = `
      <html>
        <head>
          <title>Factura ${factura.num_fac}</title>
          <style>
            body { font-family: Arial, sans-serif; margin: 40px; background: white; }
            h1, h2, h3 { text-align: center; margin: 0 0 12px 0; }
            .factura-header { display: flex; justify-content: space-between; margin-bottom: 24px; }
            .factura-section { margin-bottom: 18px; }
            .factura-titulo { text-align: center; font-size: 1.5rem; font-weight: bold; margin-bottom: 18px; }
            table { width: 100%; border-collapse: collapse; margin-top: 12px; font-size: 13px; }
            th, td { border: 1px solid #ccc; padding: 6px 8px; text-align: left; }
            th { background: #f5f5f5; }
            .totales { text-align: right; font-weight: bold; }
            .resaltado { font-weight: bold; font-size: 1.1rem; }
            .text-right { text-align: right; }
            .text-center { text-align: center; }
          </style>
        </head>
        <body>
          <div class="factura-titulo">Factura ${factura.num_fac}</div>
          <div class="factura-header">
            <div class="factura-section">
              <div><b>Número:</b> ${factura.num_fac}</div>
              <div><b>Fecha:</b> ${formatDate(factura.fec_fac)}</div>
              <div><b>Estado:</b> ${
                estadoTexto[factura.est_fac] || factura.est_fac
              }</div>
              <div><b>Fecha de Pago:</b> ${
                factura.fec_can ? formatDate(factura.fec_can) : "N/A"
              }</div>
              <div><b>Vendedor:</b> ${factura.vendedor}</div>
              <div><b>IGV:</b> ${factura.por_igv}%</div>
            </div>
            <div class="factura-section">
              <div><b>Cliente:</b> ${factura.cliente}</div>
              <div><b>RUC:</b> ${factura.ruc_cli}</div>
              <div><b>Dirección:</b> ${factura.dir_cli}</div>
            </div>
          </div>
          <div class="factura-titulo" style="font-size:1.2rem;">Detalle de Productos</div>
          <table>
            <thead>
              <tr>
                <th>Código</th>
                <th>Descripción</th>
                <th class="text-right">Cantidad</th>
                <th class="text-right">Precio Unit.</th>
                <th class="text-right">Subtotal</th>
              </tr>
            </thead>
            <tbody>
              ${(factura.DETALLES || [])
                .map(
                  (d: any) => `
                <tr>
                  <td>${d.cod_pro}</td>
                  <td>${d.des_pro}</td>
                  <td class="text-right">${d.can_ven}</td>
                  <td class="text-right">$${Number(d.pre_ven).toFixed(2)}</td>
                  <td class="text-right">$${Number(d.subtotal).toFixed(2)}</td>
                </tr>
              `,
                )
                .join("")}
            </tbody>
          </table>
          <div style="margin-top:18px; text-align:right;">
            <div>Subtotal: <span class="resaltado">$${Number(
              factura.SUBTOTAL || factura.subtotal || factura.total || 0,
            ).toFixed(2)}</span></div>
            <div>IGV (${factura.por_igv}%): <span class="resaltado">$${Number(
              factura.IGV || factura.igv || 0,
            ).toFixed(2)}</span></div>
            <div>Total: <span class="resaltado">$${Number(
              factura.TOTAL || factura.total || 0,
            ).toFixed(2)}</span></div>
          </div>
        </body>
      </html>
    `;
    const printWindow = window.open("", "_blank");
    if (!printWindow) return;
    printWindow.document.write(html);
    printWindow.document.close();
    printWindow.focus();
    printWindow.print();
    printWindow.close();
  };

  const pdfFactura = (factura: any) => {
    const doc = new jsPDF();
    doc.setFontSize(16);
    doc.text(`Factura ${factura.num_fac}`, 14, 16);
    doc.setFontSize(10);
    doc.text(`Fecha: ${formatDate(factura.fec_fac)}`, 14, 24);
    doc.text(`Cliente: ${factura.cliente}`, 14, 32);
    doc.text(`RUC: ${factura.ruc_cli}`, 14, 38);
    doc.text(`Dirección: ${factura.dir_cli}`, 14, 44);
    doc.text(`Vendedor: ${factura.vendedor}`, 14, 50);
    doc.text(
      `Estado: ${estadoTexto[factura.est_fac] || factura.est_fac}`,
      14,
      56,
    );
    doc.text(`IGV: ${factura.por_igv}%`, 14, 62);
    autoTable(doc, {
      startY: 70,
      head: [["Código", "Descripción", "Cantidad", "Precio Unit.", "Subtotal"]],
      body: (factura.DETALLES || []).map((d: any) => [
        d.cod_pro,
        d.des_pro,
        d.can_ven,
        `$${Number(d.pre_ven).toFixed(2)}`,
        `$${Number(d.subtotal).toFixed(2)}`,
      ]),
    });
    const finalY = (doc as any).lastAutoTable.finalY || 80;
    doc.text(
      `Subtotal: $${Number(
        factura.SUBTOTAL || factura.subtotal || factura.total || 0,
      ).toFixed(2)}`,
      140,
      finalY + 10,
    );
    doc.text(
      `IGV (${factura.por_igv}%): $${Number(
        factura.IGV || factura.igv || 0,
      ).toFixed(2)}`,
      140,
      finalY + 16,
    );
    doc.setFontSize(12);
    doc.text(
      `Total: $${Number(factura.TOTAL || factura.total || 0).toFixed(2)}`,
      140,
      finalY + 24,
    );
    doc.save(`Factura_${factura.num_fac}.pdf`);
  };

  return (
    <div className="space-y-4">
      <div className="flex flex-col gap-4 md:flex-row md:items-center md:justify-between">
        <div className="flex flex-col gap-4 md:flex-row md:items-center">
          <Input
            placeholder="Buscar por número o cliente..."
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
            className="max-w-sm"
          />
          <Select value={statusFilter} onValueChange={setStatusFilter}>
            <SelectTrigger className="w-[180px]">
              <SelectValue placeholder="Estado" />
            </SelectTrigger>
            <SelectContent>
              <SelectItem value="ALL">Todos</SelectItem>
              <SelectItem value="PAGADA">Pagada</SelectItem>
              <SelectItem value="PENDIENTE">Pendiente</SelectItem>
              <SelectItem value="ANULADA">Anulada</SelectItem>
            </SelectContent>
          </Select>
        </div>
        <Button onClick={() => setIsNewDialogOpen(true)}>
          <Plus className="mr-2 h-4 w-4" />
          Nueva Factura
        </Button>
      </div>

      <div className="rounded-md border">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead>Número</TableHead>
              <TableHead>Fecha</TableHead>
              <TableHead>Cliente</TableHead>
              <TableHead>Vendedor</TableHead>
              <TableHead>Total</TableHead>
              <TableHead>Estado</TableHead>
              <TableHead className="text-right">Acciones</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {filteredData.length === 0 ? (
              <TableRow>
                <TableCell colSpan={7} className="h-24 text-center">
                  No hay facturas que coincidan con la búsqueda.
                </TableCell>
              </TableRow>
            ) : (
              filteredData.map((factura) => (
                <TableRow key={factura.num_fac}>
                  <TableCell className="font-medium">
                    {factura.num_fac}
                  </TableCell>
                  <TableCell>{formatDate(factura.fec_fac)}</TableCell>
                  <TableCell>{factura.cliente}</TableCell>
                  <TableCell>{factura.vendedor}</TableCell>
                  <TableCell>${Number(factura.total).toFixed(2)}</TableCell>
                  <TableCell>
                    <Badge
                      variant={
                        getBadgeVariant(
                          estadoTexto[factura.est_fac] || factura.est_fac,
                        ) as any
                      }
                    >
                      {estadoTexto[factura.est_fac] || factura.est_fac}
                    </Badge>
                  </TableCell>
                  <TableCell className="text-right">
                    <div className="flex justify-end gap-2">
                      <Button
                        variant="outline"
                        size="icon"
                        onClick={async () => {
                          setViewFactura(factura);
                          setViewLoading(true);
                          const result = await obtenerFactura(factura.num_fac);
                          if (result.success) {
                            setViewFacturaData(result.data);
                          } else {
                            setViewFacturaData({ error: result.error });
                          }
                          setViewLoading(false);
                        }}
                        disabled={viewLoading}
                      >
                        <Eye className="h-4 w-4" />
                      </Button>
                      <Button
                        variant="outline"
                        size="icon"
                        onClick={async () => {
                          let fullFactura = factura;
                          if (!factura.DETALLES) {
                            const result = await obtenerFactura(
                              factura.num_fac,
                            );
                            if (result.success) fullFactura = result.data;
                          }
                          printFactura(fullFactura);
                        }}
                      >
                        <Printer className="h-4 w-4" />
                      </Button>
                      <Button
                        variant="outline"
                        size="icon"
                        onClick={async () => {
                          let fullFactura = factura;
                          if (!factura.DETALLES) {
                            const result = await obtenerFactura(
                              factura.num_fac,
                            );
                            if (result.success) fullFactura = result.data;
                          }
                          pdfFactura(fullFactura);
                        }}
                      >
                        <Download className="h-4 w-4" />
                      </Button>
                    </div>
                  </TableCell>
                </TableRow>
              ))
            )}
          </TableBody>
        </Table>
      </div>

      {/* View Factura Dialog */}
      <Dialog
        open={!!viewFactura}
        onOpenChange={(open) => {
          if (!open) {
            setViewFactura(null);
            setViewFacturaData(null);
          }
        }}
      >
        <DialogContent className="max-w-4xl">
          <DialogHeader>
            <DialogTitle>Detalles de Factura</DialogTitle>
          </DialogHeader>
          {viewLoading && <div className="p-8 text-center">Cargando...</div>}
          {viewFacturaData && !viewFacturaData.error && (
            <FacturaDetails data={viewFacturaData} />
          )}
          {viewFacturaData && viewFacturaData.error && (
            <div className="rounded-md border p-8 text-center text-red-500">
              Error al cargar la factura: {String(viewFacturaData.error)}
            </div>
          )}
        </DialogContent>
      </Dialog>

      {/* New Factura Dialog */}
      <Dialog
        open={isNewDialogOpen}
        onOpenChange={(open) => {
          setIsNewDialogOpen(open);
        }}
      >
        <DialogContent className="max-w-4xl">
          <DialogHeader>
            <DialogTitle>Nueva Factura</DialogTitle>
          </DialogHeader>
          {isNewDialogOpen && (
            <FacturaForm onSuccess={handleFacturaCreated} inDialog={true} />
          )}
        </DialogContent>
      </Dialog>
    </div>
  );
}
