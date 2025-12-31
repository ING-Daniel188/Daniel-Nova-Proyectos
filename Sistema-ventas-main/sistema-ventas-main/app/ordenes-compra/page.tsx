//Se importa el componente OrdenCompraTableServer desde odenes-compra
import { OrdenCompraTableServer } from "@/components/ordenes-compra/orden-compra-table-server";
//Se importa el componente OrdenCompraTableSkeleton desde ordenes-compra 
import { OrdenCompraTableSkeleton } from "@/components/ordenes-compra/orden-compra-table-skeleton";
//Se importa el elemento Suspense desde react
import { Suspense } from "react";
//Funcion para cargar los componentes de la pagina incluyedo el skeleton
export default function OrdenesCompraPage() {
  return (
    <div className="flex flex-col gap-4">
      <div className="flex items-center justify-between">
        <h1 className="text-3xl font-bold">Órdenes de Compra</h1>
      </div>
      <Suspense fallback={<OrdenCompraTableSkeleton />}>
        <OrdenCompraTableServer />
      </Suspense>
    </div>
  );
}
