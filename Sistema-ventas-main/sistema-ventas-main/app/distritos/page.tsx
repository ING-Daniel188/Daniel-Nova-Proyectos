//Se importa el componente DistritoTableServer desde distritos 
import { DistritoTableServer } from "@/components/distritos/distrito-table-server";
//Funcion que carga los componentes de la pagiana
export default async function DistritosPage() {
  return (
    <div className="flex flex-col gap-4">
      <div className="flex items-center justify-between">
        <h1 className="text-3xl font-bold">Distritos</h1>
      </div>
      {/* DistritoTableServer es un componente de servidor que obtiene los datos */}
      <DistritoTableServer />
    </div>
  );
}
