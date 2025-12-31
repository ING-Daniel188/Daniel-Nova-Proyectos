import { ClienteTableServer } from "@/components/clientes/cliente-table-server"; // Importa la carga de datos desde el servidor

// Metadata de la página
export const metadata = {
  title: "Clientes",
};
/**
 * Componente ClientesPage
 * Renderiza el diseño de la página, con su encabezado y una tabla con la información de los clientes
 */
export default function ClientesPage() {
  return (
    <div className="flex flex-col gap-4">
      <div className="flex items-center justify-between">
        <h1 className="text-3xl font-bold">Clientes</h1>
      </div>
      {/* ClienteTableServer es un componente de servidor que obtiene los datos */}
      <ClienteTableServer />
    </div>
  );
}
