//Se importa el elemento Suspense desde react
import { Suspense } from "react";
//Se importa el componente AudotoriaTable desde auditoria
import { AuditoriaTable } from "@/components/auditoria/auditoria-table";
//Se importa el componente AuditoriaTableSkeleton desde auditoria
import { AuditoriaTableSkeleton } from "@/components/auditoria/auditoria-table-skeleton";
//Se importan funciones para gestion de auditorias desde auditoria-actions
import {
  obtenerTablas,
  obtenerOperaciones,
} from "@/app/actions/auditoria-actions";
/*
*Funccion que permita obtener las tablas y las funciones de auditoria para poder mostrarlo 
*en la pagina utilisando el AuditoriaTableSkeleton mientras se carga la informacion
*/
export default async function AuditoriaPage({
  searchParams,
}: {
  searchParams: {
    tabla?: string;
    operacion?: string;
    busqueda?: string;
    pagina?: string;
  };
}) {
  const { data: tablas = [] } = await obtenerTablas();
  const { data: operaciones = [] } = await obtenerOperaciones();

  return (
    <div className="space-y-4">
      <div className="flex items-center justify-between">
        <h1 className="text-3xl font-bold">Auditoría</h1>
      </div>
      <Suspense fallback={<AuditoriaTableSkeleton />}>
        <AuditoriaTable
          tablas={tablas}
          operaciones={operaciones}
          initialTabla={searchParams.tabla || ""}
          initialOperacion={searchParams.operacion || ""}
          initialBusqueda={searchParams.busqueda || ""}
          initialPagina={
            searchParams.pagina ? Number.parseInt(searchParams.pagina) : 1
          }
        />
      </Suspense>
    </div>
  );
}
