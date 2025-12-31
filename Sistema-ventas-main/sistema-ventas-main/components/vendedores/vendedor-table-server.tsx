import { obtenerVendedores } from "@/app/actions/vendedor-actions"; // Acción para obtener la lista de vendedores desde el servidor
import { VendedorTable } from "./vendedor-table"; // Componente de tabla de vendedores.
/*
* Componente VendedorTableServer
* Solicita la tabla de vendedores y maneja los errores si se presentan
*/
export async function VendedorTableServer() {
  const { success, data = [], error } = await obtenerVendedores();

  if (!success) {
    return (
      <div className="rounded-md border p-8 text-center">
        <p className="text-red-500">
          Error al cargar los vendedores: {String(error)}
        </p>
      </div>
    );
  }

  return <VendedorTable initialData={data} />;
}
