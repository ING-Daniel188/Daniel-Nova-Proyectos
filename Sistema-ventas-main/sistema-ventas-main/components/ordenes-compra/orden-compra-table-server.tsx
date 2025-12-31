//Importa el elemento obtenerOrdenesCompra desde el componente orden-compra-actions
import { obtenerOrdenesCompra } from "@/app/actions/orden-compra-actions";
//Importa el elemento OrdenCompraTable desde el componente orden-compra-table
import { OrdenCompraTable } from "./orden-compra-table";
/**
 *Obtiene la informacion de OrdenesCompra y la carga
 *@return retorna la informacion y en caso de que ocurra un error en la carga muestra el correspondiente mensaje de error
 */
export async function OrdenCompraTableServer() {
  const { success, data = [], error } = await obtenerOrdenesCompra();

  if (!success) {
    return (
      <div className="rounded-md border p-8 text-center">
        <p className="text-red-500">
          Error al cargar las órdenes de compra: {String(error)}
        </p>
      </div>
    );
  }

  return <OrdenCompraTable initialData={data} />;
}
