import { Suspense } from "react";
import { FacturaTableServer } from "@/components/facturas/factura-table-server"; // Importa la carga de datos desde el servidor
import { FacturaTableSkeleton } from "@/components/facturas/factura-table-skeleton"; // Importa el placeholder de tabla mientras se obtienen los datos de la base de datos

/**
 * Componente FacturasPage
 * Renderiza el diseño de la página, con su encabezado, una tabla dinámica con la información de las facturas, y un esqueleto que se muestra mientras carga la tabla
 */
export default function FacturasPage() {
  return (
    <div className="flex flex-col gap-4">
      <div className="flex items-center justify-between">
        <h1 className="text-3xl font-bold">Facturas</h1>
      </div>
      <Suspense fallback={<FacturaTableSkeleton />}>
        <FacturaTableServer />
      </Suspense>
    </div>
  );
}
