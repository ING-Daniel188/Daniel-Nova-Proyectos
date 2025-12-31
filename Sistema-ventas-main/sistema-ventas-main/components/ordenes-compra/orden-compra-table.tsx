"use client";

// Importación de acciones de servidor relacionadas con órdenes de compra
import {
  actualizarEstadoOrdenCompra,
  eliminarOrdenCompra,
  obtenerOrdenCompra,
  obtenerOrdenesCompra,
} from "@/app/actions/orden-compra-actions";
// Importación de componentes de interfaz para alertas y tablas
import {
  AlertDialog,
  AlertDialogAction,
  AlertDialogCancel,
  AlertDialogContent,
  AlertDialogDescription,
  AlertDialogFooter,
  AlertDialogHeader,
  AlertDialogTitle,
  AlertDialogTrigger,
} from "@/components/ui/alert-dialog";
import { Badge } from "@/components/ui/badge";
import { Button } from "@/components/ui/button";
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { Input } from "@/components/ui/input";
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
// Iconos importados de lucide-react
import { Download, Eye, PlusCircle, Printer, Trash2 } from "lucide-react";
import { useState } from "react";
// Componentes personalizados
import { OrdenCompraDetails } from "./orden-compra-details";
import { OrdenCompraForm } from "./orden-compra-form";

interface OrdenCompraTableProps {
  initialData: any[];
}

//Componente que muestra una tabla de Órdenes de Compra con opciones de búsqueda, visualización, impresión, exportación a PDF, y cambio de estado (completar/anular).
export function OrdenCompraTable({ initialData }: OrdenCompraTableProps) {
  const { toast } = useToast();
  const [loading, setLoading] = useState<string | null>(null);
  const [data, setData] = useState(initialData);
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedOrder, setSelectedOrder] = useState<any>(null);
  const [isCompleteDialogOpen, setIsCompleteDialogOpen] = useState(false);
  const [fechaAtencion, setFechaAtencion] = useState(
    new Date().toISOString().split("T")[0],
  );
  const [isNewDialogOpen, setIsNewDialogOpen] = useState(false);
  const [isViewDialogOpen, setIsViewDialogOpen] = useState(false);
  const [viewOrden, setViewOrden] = useState<any>(null);
  const [viewOrdenData, setViewOrdenData] = useState<any>(null);
  const [viewLoading, setViewLoading] = useState(false);

  // Estado dictionary for display (numeric codes)
  const estadoTexto: Record<string, string> = {
    "1": "PENDIENTE",
    "2": "COMPLETADA",
    "3": "ANULADA",
  };

  // Get badge variant based on order status
  const getBadgeVariant = (status: string) => {
    switch (status) {
      case "2":
        return "success";
      case "1":
        return "warning";
      case "3":
        return "destructive";
      default:
        return "secondary";
    }
  };

  const handleDelete = async (numOco: string) => {
    try {
      setLoading(numOco);
      const result = await eliminarOrdenCompra(numOco);

      if (result.success) {
        // Fetch updated data from server
        const updated = await obtenerOrdenesCompra();
        if (updated.success) {
          setData(updated.data);
        } else {
          setData(data.filter((orden) => orden.num_oco !== numOco));
        }
        toast({
          title: "Orden de compra eliminada",
          description: "La orden de compra ha sido eliminada correctamente.",
        });
      } else {
        throw new Error(String(result.error));
      }
    } catch (error) {
      toast({
        title: "Error",
        description: "No se pudo eliminar la orden de compra: " + String(error),
        variant: "destructive",
      });
    } finally {
      setLoading(null);
    }
  };

  const handleComplete = async () => {
    try {
      if (!selectedOrder) return;
      setLoading(selectedOrder.num_oco);
      const result = await actualizarEstadoOrdenCompra(
        selectedOrder.num_oco,
        "2",
        fechaAtencion,
      );
      if (result.success) {
        setData(
          data.map((orden) =>
            orden.num_oco === selectedOrder.num_oco
              ? { ...orden, est_oco: "2", fat_oco: fechaAtencion }
              : orden,
          ),
        );
        toast({
          title: "Orden de compra completada",
          description:
            "La orden de compra ha sido marcada como completada correctamente.",
        });
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
      setLoading(null);
    }
  };

  const handleOrdenCompraCreated = async (newOrden: any) => {
    toast({
      title: "Orden de compra creada",
      description: "La orden de compra ha sido creada correctamente.",
    });
    // Fetch updated data from server
    const updated = await obtenerOrdenesCompra();
    if (updated.success) {
      setData(updated.data);
    }
    setIsNewDialogOpen(false);
  };

  // Format date for display (dd/mm/yyyy, always consistent)
  const formatDate = (dateString: string | null) => {
    if (!dateString) return "Pendiente";
    const date = new Date(dateString);
    if (isNaN(date.getTime())) return "Pendiente";
    const day = String(date.getDate()).padStart(2, "0");
    const month = String(date.getMonth() + 1).padStart(2, "0");
    const year = date.getFullYear();
    return `${day}/${month}/${year}`;
  };

  // Filter ordenes based on search term
  const filteredData = data.filter(
    (orden) =>
      orden.num_oco.toLowerCase().includes(searchTerm.toLowerCase()) ||
      orden.proveedor.toLowerCase().includes(searchTerm.toLowerCase()),
  );

  // Print order
  const printOrden = (orden: any) => {
    const html = `
      <html>
        <head>
          <title>Orden de Compra ${orden.num_oco}</title>
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
          <div class="orden-titulo">Orden de Compra ${orden.num_oco}</div>
          <div class="orden-header">
            <div class="orden-section">
              <div><b>Número:</b> ${orden.num_oco}</div>
              <div><b>Fecha:</b> ${formatDate(orden.fec_oco)}</div>
              <div><b>Estado:</b> ${
                estadoTexto[orden.est_oco] || orden.est_oco
              }</div>
              <div><b>Fecha de Atención:</b> ${formatDate(orden.fat_oco)}</div>
            </div>
            <div class="orden-section">
              <div><b>Proveedor:</b> ${orden.proveedor}</div>
              <div><b>Código:</b> ${orden.cod_prv}</div>
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
              ${(orden.DETALLES || [])
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
              orden.DETALLES || []
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
  const pdfOrden = async (orden: any) => {
    const jsPDF = (await import("jspdf")).default;
    const autoTable = (await import("jspdf-autotable")).default;
    const doc = new jsPDF();
    doc.setFontSize(16);
    doc.text(`Orden de Compra ${orden.num_oco}`, 14, 16);
    doc.setFontSize(10);
    doc.text(`Fecha: ${formatDate(orden.fec_oco)}`, 14, 24);
    doc.text(`Proveedor: ${orden.proveedor}`, 14, 32);
    doc.text(`Código: ${orden.cod_prv}`, 14, 38);
    doc.text(`Estado: ${estadoTexto[orden.est_oco] || orden.est_oco}`, 14, 44);
    doc.text(`Fecha de Atención: ${formatDate(orden.fat_oco)}`, 14, 50);
    autoTable(doc, {
      startY: 58,
      head: [["Código", "Descripción", "Cantidad"]],
      body: (orden.DETALLES || []).map((d: any) => [
        d.cod_pro,
        d.des_pro,
        d.can_det,
      ]),
    });
    const finalY = (doc as any).lastAutoTable.finalY || 70;
    doc.text(
      `Total de Productos: ${(orden.DETALLES || []).reduce(
        (sum: number, item: any) => sum + Number(item.can_det),
        0,
      )}`,
      140,
      finalY + 10,
    );
    doc.save(`OrdenCompra_${orden.num_oco}.pdf`);
  };

  return (
    <div className="space-y-4">
      <div className="flex flex-col gap-4 md:flex-row md:items-center md:justify-between">
        <div className="flex flex-col gap-4 md:flex-row md:items-center">
          <Input
            placeholder="Buscar órdenes de compra..."
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
            className="max-w-sm"
          />
        </div>
        <Button onClick={() => setIsNewDialogOpen(true)}>
          <PlusCircle className="mr-2 h-4 w-4" />
          Nueva Orden de Compra
        </Button>
      </div>
      <div className="rounded-md border">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead>Número</TableHead>
              <TableHead>Fecha</TableHead>
              <TableHead>Proveedor</TableHead>
              <TableHead>Estado</TableHead>
              <TableHead>Fecha Atención</TableHead>
              <TableHead className="text-right">Acciones</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {filteredData.length === 0 ? (
              <TableRow>
                <TableCell colSpan={6} className="h-24 text-center">
                  No hay órdenes de compra que coincidan con la búsqueda.
                </TableCell>
              </TableRow>
            ) : (
              filteredData.map((orden) => {
                return (
                  <TableRow key={orden.num_oco}>
                    <TableCell className="font-medium">
                      {orden.num_oco}
                    </TableCell>
                    <TableCell>{formatDate(orden.fec_oco)}</TableCell>
                    <TableCell>{orden.proveedor}</TableCell>
                    <TableCell>
                      <Badge
                        variant={
                          getBadgeVariant(
                            estadoTexto[orden.est_oco] || orden.est_oco,
                          ) as any
                        }
                        className="flex items-center w-fit"
                      >
                        {estadoTexto[orden.est_oco] || orden.est_oco}
                      </Badge>
                    </TableCell>
                    <TableCell>{formatDate(orden.fat_oco)}</TableCell>
                    <TableCell className="text-right">
                      <div className="flex justify-end gap-2">
                        <Button
                          variant="outline"
                          size="icon"
                          onClick={async () => {
                            setViewOrden(orden);
                            setViewLoading(true);
                            const result = await obtenerOrdenCompra(
                              orden.num_oco,
                            );
                            if (result.success) {
                              setViewOrdenData(result.data);
                            } else {
                              setViewOrdenData({ error: result.error });
                            }
                            setViewLoading(false);
                            setIsViewDialogOpen(true);
                          }}
                        >
                          <Eye className="h-4 w-4" />
                        </Button>
                        <Button
                          variant="outline"
                          size="icon"
                          onClick={async () => {
                            let fullOrden = orden;
                            if (!orden.DETALLES) {
                              const result = await obtenerOrdenCompra(
                                orden.num_oco,
                              );
                              if (result.success) fullOrden = result.data;
                            }
                            printOrden(fullOrden);
                          }}
                        >
                          <Printer className="h-4 w-4" />
                        </Button>
                        <Button
                          variant="outline"
                          size="icon"
                          onClick={async () => {
                            let fullOrden = orden;
                            if (!orden.DETALLES) {
                              const result = await obtenerOrdenCompra(
                                orden.num_oco,
                              );
                              if (result.success) fullOrden = result.data;
                            }
                            pdfOrden(fullOrden);
                          }}
                        >
                          <Download className="h-4 w-4" />
                        </Button>
                        {orden.est_oco === "1" && (
                          <Dialog
                            open={
                              isCompleteDialogOpen &&
                              selectedOrder?.num_oco === orden.num_oco
                            }
                            onOpenChange={(open) => {
                              setIsCompleteDialogOpen(open);
                              if (open) setSelectedOrder(orden);
                            }}
                          >
                            <DialogTrigger asChild>
                              <Button variant="outline" size="sm">
                                Completar
                              </Button>
                            </DialogTrigger>
                            <DialogContent>
                              <DialogHeader>
                                <DialogTitle>
                                  Completar Orden de Compra
                                </DialogTitle>
                                <DialogDescription>
                                  Ingrese la fecha de atención para marcar la
                                  orden como completada.
                                </DialogDescription>
                              </DialogHeader>
                              <div className="grid gap-4 py-4">
                                <div className="grid grid-cols-4 items-center gap-4">
                                  <label
                                    htmlFor="fechaAtencion"
                                    className="text-right"
                                  >
                                    Fecha de Atención
                                  </label>
                                  <Input
                                    id="fechaAtencion"
                                    type="date"
                                    value={fechaAtencion}
                                    onChange={(e) =>
                                      setFechaAtencion(e.target.value)
                                    }
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
                                <Button
                                  onClick={handleComplete}
                                  disabled={loading === orden.num_oco}
                                >
                                  {loading === orden.num_oco
                                    ? "Procesando..."
                                    : "Confirmar"}
                                </Button>
                              </DialogFooter>
                            </DialogContent>
                          </Dialog>
                        )}
                        <AlertDialog>
                          <AlertDialogTrigger asChild>
                            <Button variant="destructive" size="icon">
                              <Trash2 className="h-4 w-4" />
                            </Button>
                          </AlertDialogTrigger>
                          <AlertDialogContent>
                            <AlertDialogHeader>
                              <AlertDialogTitle>¿Está seguro?</AlertDialogTitle>
                              <AlertDialogDescription>
                                Esta acción no se puede deshacer. Esto eliminará
                                permanentemente la orden de compra{" "}
                                {orden.num_oco} y sus datos asociados.
                              </AlertDialogDescription>
                            </AlertDialogHeader>
                            <AlertDialogFooter>
                              <AlertDialogCancel>Cancelar</AlertDialogCancel>
                              <AlertDialogAction
                                onClick={() => handleDelete(orden.num_oco)}
                                disabled={loading === orden.num_oco}
                              >
                                {loading === orden.num_oco
                                  ? "Eliminando..."
                                  : "Eliminar"}
                              </AlertDialogAction>
                            </AlertDialogFooter>
                          </AlertDialogContent>
                        </AlertDialog>
                      </div>
                    </TableCell>
                  </TableRow>
                );
              })
            )}
          </TableBody>
        </Table>
      </div>
      <Dialog open={isNewDialogOpen} onOpenChange={setIsNewDialogOpen}>
        <DialogContent className="max-w-3xl">
          <DialogHeader>
            <DialogTitle>Nueva Orden de Compra</DialogTitle>
          </DialogHeader>
          <OrdenCompraForm inDialog onSuccess={handleOrdenCompraCreated} />
        </DialogContent>
      </Dialog>
      <Dialog
        open={isViewDialogOpen}
        onOpenChange={(open) => {
          setIsViewDialogOpen(open);
          if (!open) {
            setViewOrden(null);
            setViewOrdenData(null);
          }
        }}
      >
        <DialogContent className="max-w-4xl">
          <DialogHeader>
            <DialogTitle>Detalles de Orden de Compra</DialogTitle>
          </DialogHeader>
          {viewLoading && <div className="p-8 text-center">Cargando...</div>}
          {viewOrdenData && !viewOrdenData.error && (
            <OrdenCompraDetails data={viewOrdenData} />
          )}
          {viewOrdenData && viewOrdenData.error && (
            <div className="rounded-md border p-8 text-center text-red-500">
              Error al cargar la orden: {String(viewOrdenData.error)}
            </div>
          )}
        </DialogContent>
      </Dialog>
    </div>
  );
}
