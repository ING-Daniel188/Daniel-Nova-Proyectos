"use client"; // Este componente se ejecuta del lado del cliente

// Importación de funciones para manejar distritos desde acciones del servidor
import {
  eliminarDistrito,
  obtenerDistrito,
} from "@/app/actions/distrito-actions";
// Componentes UI reutilizables
import { Button } from "@/components/ui/button";
import {
  Dialog,
  DialogContent,
  DialogFooter,
  DialogHeader,
  DialogTitle,
} from "@/components/ui/dialog";
import { Input } from "@/components/ui/input";
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
import { useToast } from "@/components/ui/use-toast";
// Iconos
import { Edit, Plus, Trash2 } from "lucide-react";
import { useRouter } from "next/navigation";
import { useEffect, useState, useTransition } from "react";
// Componente para el formulario de distritos
import { DistritoForm } from "./distrito-form";

// Valores necesarios para el componente DistritoTable
interface DistritoTableProps {
  initialData: any[];
}
// Componente principal para visualizar y gestionar la tabla de distritos
export function DistritoTable({ initialData }: DistritoTableProps) {
  const { toast } = useToast();
  const router = useRouter();
  const [isPending, startTransition] = useTransition();
  const [loading, setLoading] = useState<string | null>(null);
  const [loadingEdit, setLoadingEdit] = useState<string | null>(null);
  const [data, setData] = useState(initialData);
  const [searchTerm, setSearchTerm] = useState("");
  const [isEditDialogOpen, setIsEditDialogOpen] = useState(false);
  const [isNewDialogOpen, setIsNewDialogOpen] = useState(false);
  const [isDeleteDialogOpen, setIsDeleteDialogOpen] = useState(false);
  const [selectedDistrito, setSelectedDistrito] = useState<any>(null);
  const [forceRefresh, setForceRefresh] = useState(0);

  // Actualizar los datos cuando cambian los initialData
  useEffect(() => {
    setData(initialData);
  }, [initialData]);

  // Filtrar los datos basados en el término de búsqueda
  const filteredData = data.filter(
    (distrito) =>
      distrito.nom_dis.toLowerCase().includes(searchTerm.toLowerCase()) ||
      distrito.cod_dis.toLowerCase().includes(searchTerm.toLowerCase()),
  );

  const handleDelete = async (codigo: string) => {
    try {
      setLoading(codigo);
      const result = await eliminarDistrito(codigo);

      if (result.success) {
        // Actualización optimista: Eliminar el distrito del estado local
        setData(data.filter((distrito) => distrito.cod_dis !== codigo));

        toast({
          title: "Distrito eliminado",
          description: "El distrito ha sido eliminado correctamente.",
        });
        setIsDeleteDialogOpen(false);

        // Revalidar y actualizar la UI
        startTransition(() => {
          router.refresh();
        });
      } else {
        throw new Error(String(result.error));
      }
    } catch (error) {
      toast({
        title: "Error",
        description: "No se pudo eliminar el distrito: " + String(error),
        variant: "destructive",
      });
    } finally {
      setLoading(null);
    }
  };

  const handleEditClick = async (distrito: any) => {
    try {
      setLoadingEdit(distrito.cod_dis);
      setSelectedDistrito(null); // Clear previous data first

      // Add timestamp to force a fresh server request and bypass cache
      const timestamp = new Date().getTime();

      // Obtener los datos actualizados del distrito desde el servidor
      const result = await obtenerDistrito(distrito.cod_dis);

      if (result.success) {
        // Convertir los nombres de campo a mayúsculas para el formulario
        const formattedDistrito = {
          COD_DIS: result.data.cod_dis,
          NOM_DIS: result.data.nom_dis,
          _timestamp: timestamp, // Add timestamp to the data to ensure it's fresh
        };

        // Breve pausa para asegurar que la UI se actualice correctamente
        await new Promise((resolve) => setTimeout(resolve, 50));
        setSelectedDistrito(formattedDistrito);
        setIsEditDialogOpen(true);
      } else {
        throw new Error(String(result.error));
      }
    } catch (error) {
      toast({
        title: "Error",
        description: "No se pudo cargar el distrito: " + String(error),
        variant: "destructive",
      });
    } finally {
      setLoadingEdit(null);
    }
  };

  const handleDistritoUpdated = async (updatedDistrito: any) => {
    try {
      // Actualización optimista: Actualizar el distrito en el estado local
      setData(
        data.map((d) =>
          d.cod_dis === updatedDistrito.COD_DIS
            ? {
                ...d,
                nom_dis: updatedDistrito.NOM_DIS,
              }
            : d,
        ),
      );
      setIsEditDialogOpen(false);
      toast({
        title: "Distrito actualizado",
        description: "El distrito ha sido actualizado correctamente.",
      });

      // Revalidar y actualizar la UI
      startTransition(() => {
        router.refresh();
      });
    } catch (error) {
      toast({
        title: "Error",
        description: "Error al actualizar la tabla: " + String(error),
        variant: "destructive",
      });
    }
  };

  const handleDistritoCreated = async (newDistrito: any) => {
    try {
      // Actualización optimista: Añadir el nuevo distrito al estado local
      setData([
        ...data,
        {
          cod_dis: newDistrito.COD_DIS,
          nom_dis: newDistrito.NOM_DIS,
        },
      ]);
      setIsNewDialogOpen(false);
      toast({
        title: "Distrito creado",
        description: "El distrito ha sido creado correctamente.",
      });

      // Revalidar y actualizar la UI
      startTransition(() => {
        router.refresh();
      });
    } catch (error) {
      toast({
        title: "Error",
        description: "Error al actualizar la tabla: " + String(error),
        variant: "destructive",
      });
    }
  };

  const handleCancelEdit = () => {
    setIsEditDialogOpen(false);
  };

  const handleCancelNew = () => {
    setIsNewDialogOpen(false);
  };

  // Function to force cache invalidation and refetching data
  const forceDataRefresh = async () => {
    // Force revalidation of the router
    router.refresh();

    // Force component re-render with the new state
    setForceRefresh((prev) => prev + 1);
  };

  return (
    <div className="space-y-4">
      <div className="flex justify-between items-center gap-4">
        <div className="flex-1">
          <Input
            placeholder="Buscar distrito..."
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
            className="max-w-sm"
          />
        </div>
        <Button onClick={() => setIsNewDialogOpen(true)}>
          <Plus className="mr-2 h-4 w-4" />
          Nuevo Distrito
        </Button>
      </div>

      <div className="rounded-md border">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead>Código</TableHead>
              <TableHead>Nombre</TableHead>
              <TableHead className="text-right">Acciones</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {filteredData.length === 0 ? (
              <TableRow>
                <TableCell colSpan={3} className="h-24 text-center">
                  No hay distritos registrados.
                </TableCell>
              </TableRow>
            ) : (
              filteredData.map((distrito) => (
                <TableRow key={distrito.cod_dis}>
                  <TableCell className="font-medium">
                    {distrito.cod_dis}
                  </TableCell>
                  <TableCell>{distrito.nom_dis}</TableCell>
                  <TableCell className="text-right">
                    <div className="flex justify-end gap-2">
                      <Button
                        variant="outline"
                        size="icon"
                        onClick={() => handleEditClick(distrito)}
                        disabled={loadingEdit === distrito.cod_dis}
                      >
                        <Edit className="h-4 w-4" />
                      </Button>
                      <Button
                        variant="destructive"
                        size="icon"
                        onClick={() => {
                          setSelectedDistrito(distrito);
                          setIsDeleteDialogOpen(true);
                        }}
                      >
                        <Trash2 className="h-4 w-4" />
                      </Button>
                    </div>
                  </TableCell>
                </TableRow>
              ))
            )}
          </TableBody>
        </Table>
      </div>

      {/* Edit Dialog */}
      <Dialog
        open={isEditDialogOpen}
        onOpenChange={(open) => {
          if (!open) {
            // When dialog closes, clear selected distrito and refresh data
            setSelectedDistrito(null);
            forceDataRefresh();
          }
          setIsEditDialogOpen(open);
        }}
      >
        <DialogContent>
          <DialogHeader>
            <DialogTitle>Editar Distrito</DialogTitle>
          </DialogHeader>
          {selectedDistrito && (
            <DistritoForm
              key={`distrito-form-${selectedDistrito.COD_DIS}-${
                selectedDistrito._timestamp || "default"
              }`}
              initialData={selectedDistrito}
              isEditing={true}
              onSuccess={handleDistritoUpdated}
              onCancel={handleCancelEdit}
              inDialog={true}
            />
          )}
        </DialogContent>
      </Dialog>

      {/* New Distrito Dialog */}
      <Dialog
        open={isNewDialogOpen}
        onOpenChange={(open) => {
          if (!open) {
            // When dialog closes, refresh data
            forceDataRefresh();
          }
          setIsNewDialogOpen(open);
        }}
      >
        <DialogContent>
          <DialogHeader>
            <DialogTitle>Nuevo Distrito</DialogTitle>
          </DialogHeader>
          <DistritoForm
            key={`new-distrito-form-${forceRefresh}`}
            onSuccess={handleDistritoCreated}
            onCancel={handleCancelNew}
            inDialog={true}
          />
        </DialogContent>
      </Dialog>

      {/* Delete Confirmation Dialog */}
      <Dialog open={isDeleteDialogOpen} onOpenChange={setIsDeleteDialogOpen}>
        <DialogContent>
          <DialogHeader>
            <DialogTitle>¿Está seguro?</DialogTitle>
          </DialogHeader>
          {selectedDistrito && (
            <div className="py-4">
              <p>
                Esta acción no se puede deshacer. Esto eliminará permanentemente
                el distrito{" "}
                {selectedDistrito.nom_dis || selectedDistrito.NOM_DIS} y sus
                datos asociados.
              </p>
            </div>
          )}
          <DialogFooter>
            <Button
              variant="outline"
              onClick={() => setIsDeleteDialogOpen(false)}
            >
              Cancelar
            </Button>
            <Button
              variant="destructive"
              onClick={() =>
                handleDelete(
                  selectedDistrito?.cod_dis || selectedDistrito?.COD_DIS,
                )
              }
              disabled={
                loading ===
                (selectedDistrito?.cod_dis || selectedDistrito?.COD_DIS)
              }
            >
              {loading ===
              (selectedDistrito?.cod_dis || selectedDistrito?.COD_DIS)
                ? "Eliminando..."
                : "Eliminar"}
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>
    </div>
  );
}
