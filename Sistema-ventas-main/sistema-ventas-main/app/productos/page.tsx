//Se importa el componente ProductoTableServer desde productos
import { ProductoTableServer } from "@/components/productos/producto-table-server";
//Se importa el componente ProductoTable desde productos 
import { ProductoTableSkeleton } from "@/components/productos/producto-table-skeleton";
//Se importa el elemento Suspense desde react
import { Suspense } from "react";
//Metadata de la pagina
export const metadata = {
  title: "Productos",
};
//Funcion que renderiza el diseño de la página, con su encabezado, una tabla dinámica con la información de los clientes, y un esqueleto que se muestra mientras carga la tabla
export default function ProductosPage() {
  return (
    <div className="flex flex-col gap-4">
      <div className="flex items-center justify-between">
        <h1 className="text-3xl font-bold">Productos</h1>
      </div>
      <Suspense fallback={<ProductoTableSkeleton />}>
        <ProductoTableServer />
      </Suspense>
    </div>
  );
}
