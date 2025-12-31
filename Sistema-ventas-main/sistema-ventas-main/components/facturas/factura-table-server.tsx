//Importa el elemento obtenerFacturas desde el componente factura-actions
import { obtenerFacturas } from "@/app/actions/factura-actions";
//Importa el elemento FacturaTable desde el componente factura-table
import { FacturaTable } from "./factura-table";
/**
 *La siguiente funcion obtiene y carga la información sobre facturas
 *@return retorna la informacion y si ocurre algun error devuelve el respectivo mensaje de error
 */
export async function FacturaTableServer() {
  const { success, data = [], error } = await obtenerFacturas();

  if (!success) {
    return (
      <div className="rounded-md border p-8 text-center">
        <p className="text-red-500">
          Error al cargar las facturas: {String(error)}
        </p>
      </div>
    );
  }

  return <FacturaTable initialData={data} />;
}
