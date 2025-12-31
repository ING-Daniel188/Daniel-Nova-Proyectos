"use client";

import { obtenerAuditoriaPorFecha } from "@/app/actions/reporte-actions";
import { ReporteAuditoria } from "@/components/reportes/reporte-auditoria";
import { useEffect, useState } from "react";
import { DateRange } from "react-day-picker";

export default function ReporteAuditoriaPage() {
  const [auditorias, setAuditorias] = useState<any[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [dateRange, setDateRange] = useState<DateRange | undefined>();
  const [pagination, setPagination] = useState<{
    total: number;
    pagina: number;
    porPagina: number;
    totalPaginas: number;
  }>({
    total: 0,
    pagina: 1,
    porPagina: 10,
    totalPaginas: 0,
  });

  // Función para cargar los datos de auditoría
  const fetchAuditorias = async () => {
    setLoading(true);
    try {
      const result = await obtenerAuditoriaPorFecha(
        dateRange,
        pagination.pagina,
        pagination.porPagina,
      );
      if (result.success) {
        setAuditorias(result.data);
        setPagination(result.pagination!);
      }
    } catch (error) {
      console.error("Error al obtener auditorías:", error);
    } finally {
      setLoading(false);
    }
  };

  // Cargar datos cuando cambie el rango de fechas o la página
  useEffect(() => {
    fetchAuditorias();
  }, [dateRange, pagination.pagina]);

  // Manejar cambio en el rango de fechas
  const handleDateRangeChange = (range: DateRange | undefined) => {
    setDateRange(range);
    setPagination({ ...pagination, pagina: 1 }); // Volver a la primera página
  };

  // Manejar cambio de página
  const handlePageChange = (page: number) => {
    setPagination({ ...pagination, pagina: page });
  };

  return (
    <div className="container mx-auto py-6 space-y-6">
      <div className="flex flex-col space-y-2">
        <h1 className="text-3xl font-bold tracking-tight">
          Reporte de Auditoría
        </h1>
        <p className="text-muted-foreground">
          Visualice los registros de auditoría filtrados por fecha
        </p>
      </div>

      <ReporteAuditoria
        auditorias={auditorias}
        pagination={pagination}
        onDateRangeChange={handleDateRangeChange}
        onPageChange={handlePageChange}
        dateRange={dateRange}
        loading={loading}
      />
    </div>
  );
}
