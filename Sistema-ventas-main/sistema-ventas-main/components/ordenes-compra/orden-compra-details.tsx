//Se indica que se ejecuta del lado del cliente
"use client";
//Importa el elemento actualizarEstadoOrdenCompra desde el componente orden-compra-actions
import { actualizarEstadoOrdenCompra } from "@/app/actions/orden-compra-actions";
//Importa el elemento Badge desde el componente badge
import { Badge } from "@/components/ui/badge";
//Importa el elemento Button desde el componente button
import { Button } from "@/components/ui/button";
//importa elementos desde el componente card
import {
  Card,
  CardContent,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
//Importa elementos desde del compoente dialog
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
//Importa el elemento Input desde el componente input
import { Input } from "@/components/ui/input";
//Importa elementos desde el compoente table
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
//Importa el elemento useToast desde el componente use-toast
import { useToast } from "@/components/ui/use-toast";
//Importa el elemento jsPDF desde el compoente jspdf
import jsPDF from "jspdf";
//Importa el elemento autoTable desde el componente sdpdf-autotable
import autoTable from "jspdf-autotable";
//Importa los elementos Download y Printer desde el compoente lucide-react
import { Download, Printer } from "lucide-react";
//Importa el elemento useState desde el componente react
import { useState } from "react";
//Ajusta los componentes requeridos para OrdenCompraDetails
interface OrdenCompraDetailsProps {
  data: any;
}
//La siguiente funcion permite mostrar la informacion de las ordenes de compra ademas de permitir su descarga en PDF
export function OrdenCompraDetails({ data }: OrdenCompraDetailsProps) {
  const { toast } = useToast();
  const [loading, setLoading] = useState(false);
  const [isCompleteDialogOpen, setIsCompleteDialogOpen] = useState(false);
  const [fechaAtencion, setFechaAtencion] = useState(
    new Date().toISOString().split("T")[0],
  );

  // Format date for display
  const formatDate = (dateString: string | null) => {
    if (!dateString) return "Pendiente";
    return new Date(dateString).toLocaleDateString();
  };

  // Estado dictionary for display (numeric codes)
  const estadoTexto: Record<string, string> = {
    "1": "PENDIENTE",
    "2": "COMPLETADA",
    "3": "ANULADA",
    PENDIENTE: "PENDIENTE",
    COMPLETADA: "COMPLETADA",
    ANULADA: "ANULADA",
  };

  // Get badge variant based on order status
  const getBadgeVariant = (status: string) => {
    switch (status) {
      case "COMPLETADA":
        return "success";
      case "PENDIENTE":
        return "warning";
      case "ANULADA":
        return "destructive";
      default:
        return "secondary";
    }
  };

  const handlePrint = () => {
    toast({
      title: "Imprimiendo orden de compra",
      description: `Preparando impresión de la orden de compra ${data.num_oco}`,
    });
  };

  const handleDownload = () => {
    toast({
      title: "Descargando orden de compra",
      description: `Preparando descarga de la orden de compra ${data.num_oco} en formato PDF`,
    });
  };

  const handleComplete = async () => {
    try {
      setLoading(true);
      const result = await actualizarEstadoOrdenCompra(
        data.num_oco,
        "2",
        fechaAtencion,
      );

      if (result.success) {
        toast({
          title: "Orden de compra completada",
          description:
            "La orden de compra ha sido marcada como completada correctamente.",
        });

        data.est_oco = "2";
        data.fat_oco = fechaAtencion;

        setIsCompleteDialogOpen(false);
      } else {
        throw new Error(String(result.error));
      }
    } catch (error) {
      toast({
        title: "Error",
        description:
          "No se pudo completar la orden de compra: " + String(error),
        variant: "destructive",
      });
    } finally {
      setLoading(false);
    }
  };

  // Calculate total items
  const totalItems = data.DETALLES.reduce(
    (sum: number, item: any) => sum + Number(item.can_det),
    0,
  );

  // Print order
  const printOrden = () => {
    const html = `
      <html>
        <head>
          <title>Orden de Compra ${data.num_oco}</title>
          <style>
            body { font-family: Arial, sans-serif; margin: 40px; background: white; }
            h1, h2, h3 { text-align: center; margin: 0 0 12px 0; }
            .orden-header { display: flex; justify-content: space-between; margin-bottom: 24px; }
            .orden-section { margin-bottom: 18px; }
            .orden-titulo { text-align: center; font-size: 1.5rem; font-weight: bold; margin-bottom: 18px; }
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
          <div class="orden-titulo">Orden de Compra ${data.num_oco}</div>
          <div class="orden-header">
            <div class="orden-section">
              <div><b>Número:</b> ${data.num_oco}</div>
              <div><b>Fecha:</b> ${formatDate(data.fec_oco)}</div>
              <div><b>Estado:</b> ${
                estadoTexto[data.est_oco] || data.est_oco
              }</div>
              <div><b>Fecha de Atención:</b> ${formatDate(data.fat_oco)}</div>
            </div>
            <div class="orden-section">
              <div><b>Proveedor:</b> ${data.proveedor}</div>
              <div><b>Código:</b> ${data.cod_prv}</div>
            </div>
          </div>
          <div class="orden-titulo" style="font-size:1.2rem;">Detalle de Productos</div>
          <table>
            <thead>
              <tr>
                <th>Código</th>
                <th>Descripción</th>
                <th class="text-right">Cantidad</th>
              </tr>
            </thead>
            <tbody>
              ${(data.DETALLES || [])
                .map(
                  (d: any) => `
                <tr>
                  <td>${d.cod_pro}</td>
                  <td>${d.des_pro}</td>
                  <td class="text-right">${d.can_det}</td>
                </tr>
              `,
                )
                .join("")}
            </tbody>
          </table>
          <div style="margin-top:18px; text-align:right;">
            <div>Total de Productos: <span class="resaltado">${(
              data.DETALLES || []
            ).reduce(
              (sum: number, item: any) => sum + Number(item.can_det),
              0,
            )}</span></div>
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

  // PDF order
  const pdfOrden = () => {
    const doc = new jsPDF();
    doc.setFontSize(16);
    doc.text(`Orden de Compra ${data.num_oco}`, 14, 16);
    doc.setFontSize(10);
    doc.text(`Fecha: ${formatDate(data.fec_oco)}`, 14, 24);
    doc.text(`Proveedor: ${data.proveedor}`, 14, 32);
    doc.text(`Código: ${data.cod_prv}`, 14, 38);
    doc.text(`Estado: ${estadoTexto[data.est_oco] || data.est_oco}`, 14, 44);
    doc.text(`Fecha de Atención: ${formatDate(data.fat_oco)}`, 14, 50);
    autoTable(doc, {
      startY: 58,
      head: [["Código", "Descripción", "Cantidad"]],
      body: (data.DETALLES || []).map((d: any) => [
        d.cod_pro,
        d.des_pro,
        d.can_det,
      ]),
    });
    const finalY = (doc as any).lastAutoTable.finalY || 70;
    doc.text(
      `Total de Productos: ${(data.DETALLES || []).reduce(
        (sum: number, item: any) => sum + Number(item.can_det),
        0,
      )}`,
      140,
      finalY + 10,
    );
    doc.save(`OrdenCompra_${data.num_oco}.pdf`);
  };

  return (
    <div className="space-y-6">
      <div className="flex justify-end gap-2">
        <Button variant="outline" onClick={printOrden}>
          <Printer className="mr-2 h-4 w-4" />
          Imprimir
        </Button>
        <Button variant="outline" onClick={pdfOrden}>
          <Download className="mr-2 h-4 w-4" />
          Descargar PDF
        </Button>
        {data.est_oco === "1" && (
          <Dialog
            open={isCompleteDialogOpen}
            onOpenChange={setIsCompleteDialogOpen}
          >
            <DialogTrigger asChild>
              <Button>Completar Orden</Button>
            </DialogTrigger>
            <DialogContent>
              <DialogHeader>
                <DialogTitle>Completar Orden de Compra</DialogTitle>
                <DialogDescription>
                  Ingrese la fecha de atención para marcar la orden como
                  completada.
                </DialogDescription>
              </DialogHeader>
              <div className="grid gap-4 py-4">
                <div className="grid grid-cols-4 items-center gap-4">
                  <label htmlFor="fechaAtencion" className="text-right">
                    Fecha de Atención
                  </label>
                  <Input
                    id="fechaAtencion"
                    type="date"
                    value={fechaAtencion}
                    onChange={(e) => setFechaAtencion(e.target.value)}
                    className="col-span-3"
                  />
                </div>
              </div>
              <DialogFooter>
                <Button
                  variant="outline"
                  onClick={() => setIsCompleteDialogOpen(false)}
                >
                  Cancelar
                </Button>
                <Button onClick={handleComplete} disabled={loading}>
                  {loading ? "Procesando..." : "Confirmar"}
                </Button>
              </DialogFooter>
            </DialogContent>
          </Dialog>
        )}
      </div>

      <div className="grid gap-6 md:grid-cols-2">
        <Card>
          <CardHeader>
            <CardTitle>Información de Orden de Compra</CardTitle>
          </CardHeader>
          <CardContent className="grid gap-4">
            <div className="grid grid-cols-2 gap-4">
              <div>
                <p className="text-sm font-medium">Número:</p>
                <p>{data.num_oco}</p>
              </div>
              <div>
                <p className="text-sm font-medium">Fecha:</p>
                <p>{formatDate(data.fec_oco)}</p>
              </div>
              <div>
                <p className="text-sm font-medium">Estado:</p>
                <Badge
                  variant={
                    getBadgeVariant(
                      estadoTexto[data.est_oco] || data.est_oco,
                    ) as any
                  }
                  className="flex items-center w-fit"
                >
                  {estadoTexto[data.est_oco] || data.est_oco}
                </Badge>
              </div>
              <div>
                <p className="text-sm font-medium">Fecha de Atención:</p>
                <p>{formatDate(data.fat_oco)}</p>
              </div>
            </div>
          </CardContent>
        </Card>

        <Card>
          <CardHeader>
            <CardTitle>Información del Proveedor</CardTitle>
          </CardHeader>
          <CardContent className="grid gap-4">
            <div className="grid gap-2">
              <div>
                <p className="text-sm font-medium">Proveedor:</p>
                <p>{data.proveedor}</p>
              </div>
              <div>
                <p className="text-sm font-medium">Código:</p>
                <p>{data.cod_prv}</p>
              </div>
            </div>
          </CardContent>
        </Card>
      </div>

      <Card>
        <CardHeader>
          <CardTitle>Detalle de Productos</CardTitle>
        </CardHeader>
        <CardContent>
          <Table>
            <TableHeader>
              <TableRow>
                <TableHead>Código</TableHead>
                <TableHead>Descripción</TableHead>
                <TableHead className="text-right">Cantidad</TableHead>
              </TableRow>
            </TableHeader>
            <TableBody>
              {data.DETALLES.map((detalle: any) => (
                <TableRow key={detalle.cod_pro}>
                  <TableCell className="font-medium">
                    {detalle.cod_pro}
                  </TableCell>
                  <TableCell>{detalle.des_pro}</TableCell>
                  <TableCell className="text-right">
                    {detalle.can_det}
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </CardContent>
        <CardFooter className="flex justify-end">
          <div className="space-y-2 text-right">
            <div className="flex justify-between gap-10 text-lg font-bold">
              <span>Total de Productos:</span>
              <span>{totalItems}</span>
            </div>
          </div>
        </CardFooter>
      </Card>
    </div>
  );
}
