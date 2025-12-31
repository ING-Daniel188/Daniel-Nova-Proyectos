/**
 *Impora el elemento obtenerClientes desde la componente cliente-actions
 */
import { obtenerClientes } from "@/app/actions/cliente-actions";
/**
 *Importa el elemento ClienteTable desde el componente cliente-table
 */
import { ClienteTable } from "./cliente-table";
/**
 *La siguiente función utilisa el elemento obtenerClientes para llamar la obtener la informacion sobre los clientes
 *@return retorna la información sobre los clientes y en caso de un error indica el problema junto con el mendaje de error
 */
export async function ClienteTableServer() {
  try {
    // Obtener datos en el servidor
    const { success, data = [], error } = await obtenerClientes();

    if (!success) {
      return (
        <div className="rounded-md border p-8 text-center">
          <p className="text-red-500">
            Error al cargar los clientes: {String(error)}
          </p>
        </div>
      );
    }

    // Pasar los datos al componente cliente
    return <ClienteTable initialData={data} />;
  } catch (error) {
    return (
      <div className="rounded-md border p-8 text-center">
        <p className="text-red-500">
          Error al cargar los clientes: {String(error)}
        </p>
      </div>
    );
  }
}
