//Se indica que se ejecuta del lado del cliente
"use client";
//Importa el elemento badge desde el componente badge
import { Badge } from "@/components/ui/badge";
//Importa el elemento Button desde el componente button
import { Button } from "@/components/ui/button";
//Importa elementos desde el componente card
import {
  Card,
  CardContent,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
//Importa elementos desde el componente table
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
//Importa el elemento eseToast desde el componente use-toast
import { useToast } from "@/components/ui/use-toast";
//importa el elemento jsPDF desde el componente jspdf
import jsPDF from "jspdf";
//Importa el elemento autoTable desde el componente jspdf-autotable
import autoTable from "jspdf-autotable";
//Impoporta los elementos Download y Printes desde el componente lucid-react
import { Download, Printer } from "lucide-react";
//Ajusta los componentes requeridos para el componente FacturaDetails
interface FacturaDetailsProps {
  data: any;
}

//La siguiente función permite mostrar la informacion de factura ademas y permitir su descarga en PDF

export function FacturaDetails({ data }: FacturaDetailsProps) {
  const { toast } = useToast();

  // Format date for display
  const formatDate = (dateValue: string | Date | null | undefined) => {
    if (!dateValue) return "N/A";
    let dateStr = "";
    if (typeof dateValue === "string") {
      // Si es formato ISO o contiene espacio, extrae solo la parte de fecha
      const match = /(\d{4})-(\d{2})-(\d{2})/.exec(dateValue);
      if (match) {
        const [, year, month, day] = match;
        return `${day}/${month}/${year}`;
      }
      // Si es otro formato, intenta parsear como Date
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

  const handlePrint = () => {
    const factura = document.getElementById("factura-print-area");
    if (!factura) return;
    const html = `
      <html>
        <head>
          <title>Factura ${data.num_fac}</title>
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
          <div class="factura-titulo">Factura ${data.num_fac}</div>
          <div class="factura-header">
            <div class="factura-section">
              <div><b>Número:</b> ${data.num_fac}</div>
              <div><b>Fecha:</b> ${formatDate(data.fec_fac)}</div>
              <div><b>Estado:</b> ${
                estadoTexto[data.est_fac] || data.est_fac
              }</div>
              <div><b>Fecha de Pago:</b> ${
                data.fec_can ? formatDate(data.fec_can) : "N/A"
              }</div>
              <div><b>Vendedor:</b> ${data.vendedor}</div>
              <div><b>IGV:</b> ${data.por_igv}%</div>
            </div>
            <div class="factura-section">
              <div><b>Cliente:</b> ${data.cliente}</div>
              <div><b>RUC:</b> ${data.ruc_cli}</div>
              <div><b>Dirección:</b> ${data.dir_cli}</div>
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
              ${data.DETALLES.map(
                (d: any) => `
                <tr>
                  <td>${d.cod_pro}</td>
                  <td>${d.des_pro}</td>
                  <td class="text-right">${d.can_ven}</td>
                  <td class="text-right">$${Number(d.pre_ven).toFixed(2)}</td>
                  <td class="text-right">$${Number(d.subtotal).toFixed(2)}</td>
                </tr>
              `,
              ).join("")}
            </tbody>
          </table>
          <div style="margin-top:18px; text-align:right;">
            <div>Subtotal: <span class="resaltado">$${Number(
              data.SUBTOTAL,
            ).toFixed(2)}</span></div>
            <div>IGV (${data.por_igv}%): <span class="resaltado">$${Number(
              data.IGV,
            ).toFixed(2)}</span></div>
            <div>Total: <span class="resaltado">$${Number(data.TOTAL).toFixed(
              2,
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

  const handleDownload = () => {
    const doc = new jsPDF();
    doc.setFontSize(16);
    doc.text(`Factura ${data.num_fac}`, 14, 16);
    doc.setFontSize(10);
    doc.text(`Fecha: ${formatDate(data.fec_fac)}`, 14, 24);
    doc.text(`Cliente: ${data.cliente}`, 14, 32);
    doc.text(`RUC: ${data.ruc_cli}`, 14, 38);
    doc.text(`Dirección: ${data.dir_cli}`, 14, 44);
    doc.text(`Vendedor: ${data.vendedor}`, 14, 50);
    doc.text(`Estado: ${estadoTexto[data.est_fac] || data.est_fac}`, 14, 56);
    doc.text(`IGV: ${data.por_igv}%`, 14, 62);
    autoTable(doc, {
      startY: 70,
      head: [["Código", "Descripción", "Cantidad", "Precio Unit.", "Subtotal"]],
      body: data.DETALLES.map((d: any) => [
        d.cod_pro,
        d.des_pro,
        d.can_ven,
        `$${Number(d.pre_ven).toFixed(2)}`,
        `$${Number(d.subtotal).toFixed(2)}`,
      ]),
    });
    const finalY = (doc as any).lastAutoTable.finalY || 80;
    doc.text(
      `Subtotal: $${Number(data.SUBTOTAL).toFixed(2)}`,
      140,
      finalY + 10,
    );
    doc.text(
      `IGV (${data.por_igv}%): $${Number(data.IGV).toFixed(2)}`,
      140,
      finalY + 16,
    );
    doc.setFontSize(12);
    doc.text(`Total: $${Number(data.TOTAL).toFixed(2)}`, 140, finalY + 24);
    doc.save(`Factura_${data.num_fac}.pdf`);
  };

  const estadoTexto: Record<string, string> = {
    "1": "PENDIENTE",
    "2": "PAGADA",
    "3": "ANULADA",
    PENDIENTE: "PENDIENTE",
    PAGADA: "PAGADA",
    ANULADA: "ANULADA",
  };

  return (
    <div
      className="space-y-6 print:bg-white print:p-0 print:m-0"
      id="factura-print-area"
    >
      <div className="flex justify-end gap-2 not-print">
        <Button variant="outline" onClick={handlePrint}>
          <Printer className="mr-2 h-4 w-4" />
          Imprimir
        </Button>
        <Button variant="outline" onClick={handleDownload}>
          <Download className="mr-2 h-4 w-4" />
          Descargar PDF
        </Button>
      </div>
      <div className="grid gap-6 md:grid-cols-2">
        <Card className="print:shadow-none print:border-none print:p-0">
          <CardHeader>
            <CardTitle className="text-xl text-center print:text-2xl print:mb-2">
              Información de Factura
            </CardTitle>
          </CardHeader>
          <CardContent className="grid gap-4">
            <div className="grid grid-cols-2 gap-4">
              <div>
                <p className="text-sm font-medium">Número:</p>
                <p className="font-bold text-lg print:text-xl">
                  {data.num_fac}
                </p>
              </div>
              <div>
                <p className="text-sm font-medium">Fecha:</p>
                <p className="font-bold">{formatDate(data.fec_fac)}</p>
              </div>
              <div>
                <p className="text-sm font-medium">Estado:</p>
                <Badge
                  variant={getBadgeVariant(data.est_fac) as any}
                  className="print:bg-gray-200 print:text-black print:border print:border-gray-400"
                >
                  {estadoTexto[data.est_fac] || data.est_fac}
                </Badge>
              </div>
              <div>
                <p className="text-sm font-medium">Fecha de Pago:</p>
                <p>{formatDate(data.fec_can)}</p>
              </div>
              <div>
                <p className="text-sm font-medium">Vendedor:</p>
                <p>{data.vendedor}</p>
              </div>
              <div>
                <p className="text-sm font-medium">IGV:</p>
                <p>{data.por_igv}%</p>
              </div>
            </div>
          </CardContent>
        </Card>
        <Card className="print:shadow-none print:border-none print:p-0">
          <CardHeader>
            <CardTitle className="text-xl text-center print:text-2xl print:mb-2">
              Información del Cliente
            </CardTitle>
          </CardHeader>
          <CardContent className="grid gap-4">
            <div className="grid gap-2">
              <div>
                <p className="text-sm font-medium">Cliente:</p>
                <p className="font-bold">{data.cliente}</p>
              </div>
              <div>
                <p className="text-sm font-medium">RUC:</p>
                <p>{data.ruc_cli}</p>
              </div>
              <div>
                <p className="text-sm font-medium">Dirección:</p>
                <p>{data.dir_cli}</p>
              </div>
            </div>
          </CardContent>
        </Card>
      </div>
      <Card className="print:shadow-none print:border-none print:p-0">
        <CardHeader>
          <CardTitle className="text-xl text-center print:text-2xl print:mb-2">
            Detalle de Productos
          </CardTitle>
        </CardHeader>
        <CardContent>
          <Table className="print:text-xs print:mt-2">
            <TableHeader>
              <TableRow>
                <TableHead>Código</TableHead>
                <TableHead>Descripción</TableHead>
                <TableHead className="text-right">Cantidad</TableHead>
                <TableHead className="text-right">Precio Unit.</TableHead>
                <TableHead className="text-right">Subtotal</TableHead>
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
                    {detalle.can_ven}
                  </TableCell>
                  <TableCell className="text-right">
                    ${Number(detalle.pre_ven).toFixed(2)}
                  </TableCell>
                  <TableCell className="text-right">
                    ${Number(detalle.subtotal).toFixed(2)}
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </CardContent>
        <CardFooter className="flex justify-end print:justify-end">
          <div className="space-y-2 text-right print:text-xs">
            <div className="flex justify-between gap-10">
              <span className="font-medium">Subtotal:</span>
              <span>${Number(data.SUBTOTAL).toFixed(2)}</span>
            </div>
            <div className="flex justify-between gap-10">
              <span className="font-medium">IGV ({data.por_igv}%):</span>
              <span>${Number(data.IGV).toFixed(2)}</span>
            </div>
            <div className="flex justify-between gap-10 text-lg font-bold print:text-base">
              <span>Total:</span>
              <span>${Number(data.TOTAL).toFixed(2)}</span>
            </div>
          </div>
        </CardFooter>
      </Card>
      <style jsx global>{`
        @media print {
          .not-print {
            display: none !important;
          }
          body {
            background: white !important;
          }
        }
      `}</style>
    </div>
  );
}
