//Importa el elemento obtener Factura desde el componente factura-actions
import { obtenerFactura } from "@/app/actions/factura-actions";
//Importa el elemento FacturaDetails desde el componente factura-details
import { FacturaDetails } from "./factura-details";

//Ajusta los componentes requeridos para el componente FacturaDetailsServer
interface FacturaDetailsServerProps {
  id: string;
}
/**
 *La siguiente función obtiene la información sobre el id de la factura
 *@return retorna la informacion sobre el id de la factura y en caso de que haya un error en la carga muestra el respectivo mensaje de error
 */
export async function FacturaDetailsServer({ id }: FacturaDetailsServerProps) {
  const { success, data, error } = await obtenerFactura(id);

  if (!success) {
    return (
      <div className="rounded-md border p-8 text-center">
        <p className="text-red-500">
          Error al cargar la factura: {String(error)}
        </p>
      </div>
    );
  }

  return <FacturaDetails data={data} />;
}
