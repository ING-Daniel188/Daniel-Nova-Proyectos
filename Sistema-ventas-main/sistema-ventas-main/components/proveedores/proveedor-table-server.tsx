//Importa las acciones para obtener proveedores
import { obtenerProveedores } from "@/app/actions/proveedor-actions";
//Importa la tabla de proveedores desde proveedor-table
import { ProveedorTable } from "./proveedor-table";

/*
*Obtiene la informacion sobre los proveedores
*@return retorna la informacion y si ocurre algun error devuelve el respectivo mensaje indicandolo
*/
export async function ProveedorTableServer() {
  try {
    // Obtener datos en el servidor
    const { success, data = [], error } = await obtenerProveedores();

    if (!success) {
      return (
        <div className="rounded-md border p-8 text-center">
          <p className="text-red-500">
            Error al cargar los proveedores: {String(error)}
          </p>
        </div>
      );
    }

    // Pasar los datos al componente cliente
    return <ProveedorTable initialData={data} />;
  } catch (error) {
    return (
      <div className="rounded-md border p-8 text-center">
        <p className="text-red-500">
          Error al cargar los proveedores: {String(error)}
        </p>
      </div>
    );
  }
}
