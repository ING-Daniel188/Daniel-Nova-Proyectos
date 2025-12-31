//Se importa el componente ProveedorTableServer desde 
import { ProveedorTableServer } from "@/components/proveedores/proveedor-table-server";
//Funcion que renderiza el diseño de la página, con su encabezado, una tabla dinámica con la información de los clientes
export default async function ProveedoresPage() {
  return (
    <div className="flex flex-col gap-4">
      <div className="flex items-center justify-between">
        <h1 className="text-3xl font-bold">Proveedores</h1>
      </div>
      <ProveedorTableServer />
    </div>
  );
}
