"use client";

import { obtenerVendedoresVentasBajas } from "@/app/actions/reporte-actions";
import { ReporteVendedoresBajas } from "@/components/reportes/reporte-vendedores-bajas";
import { useEffect, useState } from "react";

export default function ReporteVendedoresBajasPage() {
  const [vendedores, setVendedores] = useState<any[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [limite, setLimite] = useState<number>(5);

  // Función para cargar los datos de vendedores con ventas bajas
  const fetchVendedores = async () => {
    setLoading(true);
    try {
      const result = await obtenerVendedoresVentasBajas(limite);
      if (result.success) {
        setVendedores(result.data);
      }
    } catch (error) {
      console.error("Error al obtener vendedores:", error);
    } finally {
      setLoading(false);
    }
  };

  // Cargar datos cuando cambie el límite
  useEffect(() => {
    fetchVendedores();
  }, [limite]);

  // Manejar cambio en el límite de vendedores
  const handleLimiteChange = (nuevoLimite: number) => {
    setLimite(nuevoLimite);
  };

  return (
    <div className="container mx-auto py-6 space-y-6">
      <div className="flex flex-col space-y-2">
        <h1 className="text-3xl font-bold tracking-tight">
          Vendedores con Ventas Más Bajas
        </h1>
        <p className="text-muted-foreground">
          Visualice los vendedores con menor rendimiento en ventas
        </p>
      </div>

      <ReporteVendedoresBajas
        vendedores={vendedores}
        loading={loading}
        onLimiteChange={handleLimiteChange}
        limite={limite}
      />
    </div>
  );
}
