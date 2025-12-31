import { format } from "date-fns";
import { es } from "date-fns/locale";
import jsPDF from "jspdf";
import autoTable from "jspdf-autotable";

import { DateRange } from "react-day-picker";

// Función para exportar el reporte de auditoría a PDF
export const exportarReporteAuditoriaPDF = (
  auditorias: any[],
  dateRange?: DateRange,
) => {
  // Crear un nuevo documento PDF
  const doc = new jsPDF();

  // Configurar el título
  doc.setFontSize(18);
  doc.text("Reporte de Auditoría", 14, 22);

  // Agregar fecha de generación
  doc.setFontSize(11);
  doc.text(
    `Generado: ${format(new Date(), "dd/MM/yyyy HH:mm", { locale: es })}`,
    14,
    30,
  );

  // Agregar rango de fechas si existe
  if (dateRange?.from && dateRange.from instanceof Date) {
    const fechaDesde = format(dateRange.from, "dd/MM/yyyy", { locale: es });
    const fechaHasta = dateRange.to && dateRange.to instanceof Date
      ? format(dateRange.to, "dd/MM/yyyy", { locale: es })
      : "Actual";
    doc.text(`Período: ${fechaDesde} - ${fechaHasta}`, 14, 38);
  }

  // Preparar los datos para la tabla
  const tableColumn = ["ID", "Tabla", "Operación", "Usuario", "Fecha"];
  const tableRows = auditorias.map((auditoria) => [
    auditoria.id_audit,
    auditoria.tabla,
    auditoria.operacion,
    auditoria.usuario,
    new Date(auditoria.fecha).toLocaleString(),
  ]);

  // Generar la tabla
  autoTable(doc, {
    head: [tableColumn],
    body: tableRows,
    startY: 45,
    styles: { fontSize: 10, cellPadding: 3 },
    headStyles: { fillColor: [75, 75, 150] },
    alternateRowStyles: { fillColor: [240, 240, 255] },
  });

  // Guardar el PDF
  doc.save("reporte-auditoria.pdf");
};

// Función para exportar el reporte de vendedores con bajas ventas a PDF
export const exportarReporteVendedoresBajasPDF = (vendedores: any[]) => {
  // Crear un nuevo documento PDF
  const doc = new jsPDF();

  // Configurar el título
  doc.setFontSize(18);
  doc.text("Reporte de Vendedores con Bajas Ventas", 14, 22);

  // Agregar fecha de generación
  doc.setFontSize(11);
  doc.text(
    `Generado: ${format(new Date(), "dd/MM/yyyy HH:mm", { locale: es })}`,
    14,
    30,
  );

  // Formatear moneda
  const formatCurrency = (value: number) => {
    return new Intl.NumberFormat("es-PY", {
      style: "currency",
      currency: "PYG",
      minimumFractionDigits: 0,
    }).format(value);
  };

  // Preparar los datos para la tabla
  const tableColumn = [
    "Código",
    "Nombre",
    "Sueldo",
    "Total Ventas",
    "Facturas",
    "Rendimiento",
  ];
  const tableRows = vendedores.map((vendedor) => {
    const rendimiento =
      vendedor.sueldo > 0 ? vendedor.total_ventas / vendedor.sueldo : 0;
    return [
      vendedor.cod_ven,
      vendedor.nombre_vendedor,
      formatCurrency(vendedor.sueldo),
      formatCurrency(vendedor.total_ventas),
      vendedor.cantidad_facturas,
      `${rendimiento.toFixed(2)}x`,
    ];
  });

  // Generar la tabla
  autoTable(doc, {
    head: [tableColumn],
    body: tableRows,
    startY: 38,
    styles: { fontSize: 10, cellPadding: 3 },
    headStyles: { fillColor: [75, 75, 150] },
    alternateRowStyles: { fillColor: [240, 240, 255] },
  });

  // Guardar el PDF
  doc.save("reporte-vendedores-bajas.pdf");
};
