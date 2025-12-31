//Importa acciones para obtener productos
import { obtenerProductos } from "@/app/actions/producto-actions";
//Impoerta la tabla de productos desde producto-table
import { ProductoTable } from "./producto-table";
/*
*Obtiene la informacion sobre los productos
*@return retorna la informacion y si ocurre algun error devuelve el respectivo mensaje indicandolo
*/
export async function ProductoTableServer() {
  const { success, data = [], error } = await obtenerProductos();

  if (!success) {
    return (
      <div className="rounded-md border p-8 text-center">
        <p className="text-red-500">
          Error al cargar los productos: {String(error)}
        </p>
      </div>
    );
  }

  return <ProductoTable initialData={data} />;
}
