import { VendedorTableServer } from "@/components/vendedores/vendedor-table-server"; // Importa la carga de datos desde el servidor

/**
 * Componente VendedoresPage
 * Renderiza el diseño de la página, con su encabezado, una tabla dinámica con la información de los vendedores
 */
export default async function VendedoresPage() {
  return (
    <div className="flex flex-col gap-4">
      <div className="flex items-center justify-between">
        <h1 className="text-3xl font-bold">Vendedores</h1>
      </div>
      <VendedorTableServer />
    </div>
  );
}
