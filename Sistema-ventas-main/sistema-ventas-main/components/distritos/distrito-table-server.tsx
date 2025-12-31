//Importa el elemento obtenerDistritos desde el componente districto-actions
import { obtenerDistritos } from "@/app/actions/distrito-actions";
//Importa el elemento DistritoTable desde el componente distrito-table
import { DistritoTable } from "./distrito-table";
/**
 *La siguiente función obtiene la informacion de distritos
 *@return retorna la informacion de distritos y en caso de que se presente un error muestra el respectivo mensaje
 */
export async function DistritoTableServer() {
  try {
    // Obtener datos en el servidor
    const { success, data = [], error } = await obtenerDistritos();

    if (!success) {
      return (
        <div className="rounded-md border p-8 text-center">
          <p className="text-red-500">
            Error al cargar los distritos: {String(error)}
          </p>
        </div>
      );
    }

    // Pasar los datos al componente cliente
    return <DistritoTable initialData={data} />;
  } catch (error) {
    return (
      <div className="rounded-md border p-8 text-center">
        <p className="text-red-500">
          Error al cargar los distritos: {String(error)}
        </p>
      </div>
    );
  }
}
