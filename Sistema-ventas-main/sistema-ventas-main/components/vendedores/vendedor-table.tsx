//Este componente se ejecuta del lado del cliente
"use client";
//Importa informacion de funciones para gestionar vendedores
import {
  eliminarVendedor,
  obtenerVendedor,
} from "@/app/actions/vendedor-actions";
//Componentes UI reutilizables
import { Badge } from "@/components/ui/badge";
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
//Importa el elemento useToast desde use-toast
import { useToast } from "@/components/ui/use-toast";
//Importa iconos desde lucide-react
import { Edit, Plus, Trash2 } from "lucide-react";
import { useRouter } from "next/navigation";
import { useEffect, useState, useTransition } from "react";
//Componente para el formulario de vendedores
import { VendedorForm } from "./vendedor-form";
//Valores necesarios para el componente VendedorTable
interface VendedorTableProps {
  initialData: any[];
}
//Componente para gestionar y visualisar la tabla de vendedores
export function VendedorTable({ initialData }: VendedorTableProps) {
  const { toast } = useToast();
  const router = useRouter();
  const [, startTransition] = useTransition();
  const [loading, setLoading] = useState<string | null>(null);
  const [loadingEdit, setLoadingEdit] = useState<string | null>(null);
  const [data, setData] = useState(initialData);
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedVendedor, setSelectedVendedor] = useState<any>(null);
  const [isDeleteDialogOpen, setIsDeleteDialogOpen] = useState(false);
  const [isEditDialogOpen, setIsEditDialogOpen] = useState(false);
  const [isNewDialogOpen, setIsNewDialogOpen] = useState(false);

  // Actualizar los datos cuando cambian los initialData
  useEffect(() => {
    setData(initialData);
  }, [initialData]);

  const handleDelete = async (codigo: string) => {
    try {
      setLoading(codigo);
      const result = await eliminarVendedor(codigo);

      if (result.success) {
        // Actualización optimista: Eliminar el vendedor del estado local
        setData(data.filter((vendedor) => vendedor.cod_ven !== codigo));

        toast({
          title: "Vendedor eliminado",
          description: "El vendedor ha sido eliminado correctamente.",
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
        description: "No se pudo eliminar el vendedor: " + String(error),
        variant: "destructive",
      });
    } finally {
      setLoading(null);
    }
  };

  const handleEditClick = async (vendedor: any) => {
    try {
      setLoadingEdit(vendedor.cod_ven);

      // Obtener los datos actualizados del vendedor desde el servidor
      const result = await obtenerVendedor(vendedor.cod_ven);

      if (result.success) {
        // Convertir los nombres de campo a mayúsculas para el formulario
        setSelectedVendedor({
          COD_VEN: result.data.cod_ven,
          NOM_VEN: result.data.nom_ven,
          APE_VEN: result.data.ape_ven,
          SUE_VEN: result.data.sue_ven,
          FIN_VEN: result.data.fin_ven,
          TIP_VEN: result.data.tip_ven,
          COD_DIS: result.data.cod_dis,
        });
        setIsEditDialogOpen(true);
      } else {
        throw new Error(String(result.error));
      }
    } catch (error) {
      toast({
        title: "Error",
        description: "No se pudo cargar el vendedor: " + String(error),
        variant: "destructive",
      });
    } finally {
      setLoadingEdit(null);
    }
  };

  const handleVendedorCreated = (newVendedor: any) => {
    // Actualizar el estado local (actualización optimista)
    setData([
      ...data,
      {
        cod_ven: newVendedor.COD_VEN,
        nom_ven: newVendedor.NOM_VEN,
        ape_ven: newVendedor.APE_VEN,
        sue_ven: newVendedor.SUE_VEN,
        fin_ven: newVendedor.FIN_VEN,
        tip_ven: newVendedor.TIP_VEN,
        cod_dis: newVendedor.COD_DIS,
        nom_dis: "Actualizado", // Se actualizará al recargar
      },
    ]);

    // Cerrar el diálogo después de actualizar el estado
    setIsNewDialogOpen(false);

    toast({
      title: "Vendedor creado",
      description: "El vendedor ha sido creado correctamente.",
    });

    // Revalidar y actualizar la UI
    startTransition(() => {
      router.refresh();
    });
  };

  const handleVendedorUpdated = (updatedVendedor: any) => {
    // Actualizar el estado local (actualización optimista)
    setData(
      data.map((v) =>
        v.cod_ven === updatedVendedor.COD_VEN
          ? {
              ...v,
              nom_ven: updatedVendedor.NOM_VEN,
              ape_ven: updatedVendedor.APE_VEN,
              sue_ven: updatedVendedor.SUE_VEN,
              fin_ven: updatedVendedor.FIN_VEN,
              tip_ven: updatedVendedor.TIP_VEN,
              cod_dis: updatedVendedor.COD_DIS,
            }
          : v,
      ),
    );

    // Cerrar el diálogo después de actualizar el estado
    setIsEditDialogOpen(false);

    toast({
      title: "Vendedor actualizado",
      description: "El vendedor ha sido actualizado correctamente.",
    });

    // Revalidar y actualizar la UI
    startTransition(() => {
      router.refresh();
    });
  };

  const handleCancelEdit = () => {
    setIsEditDialogOpen(false);
  };

  const handleCancelNew = () => {
    setIsNewDialogOpen(false);
  };

  // Format date for display with a consistent format to avoid hydration errors
  const formatDate = (dateString: string) => {
    const date = new Date(dateString);
    // Usar formato ISO para evitar problemas de localización
    return `${date.getFullYear()}-${String(date.getMonth() + 1).padStart(2, "0")}-${String(date.getDate()).padStart(2, "0")}`;
  };

  // Función eliminada: formatCurrency ya no es necesaria porque usamos toLocaleString directamente

  // Get badge variant and text based on vendedor type
  const getVendedorTypeInfo = (tipo: string) => {
    switch (tipo) {
      case "SENIOR":
      case "1":
        return { variant: "success", text: "SENIOR" };
      case "JUNIOR":
      case "2":
        return { variant: "secondary", text: "JUNIOR" };
      default:
        return { variant: "default", text: tipo };
    }
  };

  // Filter vendedores based on search term
  const filteredData = data.filter(
    (vendedor) =>
      vendedor.nom_ven.toLowerCase().includes(searchTerm.toLowerCase()) ||
      vendedor.ape_ven.toLowerCase().includes(searchTerm.toLowerCase()) ||
      vendedor.cod_ven.toLowerCase().includes(searchTerm.toLowerCase()),
  );

  return (
    <div className="space-y-4">
      <div className="flex items-center justify-between">
        <Input
          placeholder="Buscar vendedores..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          className="max-w-sm"
        />
        <Button onClick={() => setIsNewDialogOpen(true)}>
          <Plus className="mr-2 h-4 w-4" /> Nuevo Vendedor
        </Button>
      </div>

      <div className="rounded-md border">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead>Código</TableHead>
              <TableHead>Nombre</TableHead>
              <TableHead>Sueldo</TableHead>
              <TableHead>Fecha Ingreso</TableHead>
              <TableHead>Tipo</TableHead>
              <TableHead>Distrito</TableHead>
              <TableHead className="text-right">Acciones</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {filteredData.length === 0 ? (
              <TableRow>
                <TableCell colSpan={7} className="h-24 text-center">
                  No hay vendedores que coincidan con la búsqueda.
                </TableCell>
              </TableRow>
            ) : (
              filteredData.map((vendedor) => (
                <TableRow key={vendedor.cod_ven}>
                  <TableCell className="font-medium">
                    {vendedor.cod_ven}
                  </TableCell>
                  <TableCell>{`${vendedor.nom_ven} ${vendedor.ape_ven}`}</TableCell>
                  <TableCell>
                    {Number(vendedor.sue_ven).toLocaleString("es-CO", {
                      style: "currency",
                      currency: "COP",
                    })}
                  </TableCell>
                  <TableCell>{formatDate(vendedor.fin_ven)}</TableCell>
                  <TableCell>
                    {(() => {
                      const typeInfo = getVendedorTypeInfo(vendedor.tip_ven);
                      return (
                        <Badge variant={typeInfo.variant as any}>
                          {typeInfo.text}
                        </Badge>
                      );
                    })()}
                  </TableCell>
                  <TableCell>{vendedor.nom_dis}</TableCell>
                  <TableCell className="text-right">
                    <div className="flex justify-end gap-2">
                      <Button
                        variant="outline"
                        size="icon"
                        onClick={() => handleEditClick(vendedor)}
                        disabled={loadingEdit === vendedor.cod_ven}
                      >
                        <Edit className="h-4 w-4" />
                      </Button>
                      <Button
                        variant="destructive"
                        size="icon"
                        onClick={() => {
                          setSelectedVendedor(vendedor);
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
      {/* New Vendedor Dialog */}
      <Dialog open={isNewDialogOpen} onOpenChange={setIsNewDialogOpen}>
        <DialogContent className="max-w-3xl">
          <DialogHeader>
            <DialogTitle>Nuevo Vendedor</DialogTitle>
          </DialogHeader>
          <VendedorForm
            onSuccess={handleVendedorCreated}
            onCancel={handleCancelNew}
            inDialog={true}
          />
        </DialogContent>
      </Dialog>

      {/* Edit Vendedor Dialog */}
      <Dialog open={isEditDialogOpen} onOpenChange={setIsEditDialogOpen}>
        <DialogContent className="max-w-3xl">
          <DialogHeader>
            <DialogTitle>Editar Vendedor</DialogTitle>
          </DialogHeader>
          {selectedVendedor && (
            <VendedorForm
              initialData={selectedVendedor}
              onSuccess={handleVendedorUpdated}
              onCancel={handleCancelEdit}
              inDialog={true}
              isEditing={true}
            />
          )}
        </DialogContent>
      </Dialog>

      {/* Delete Confirmation Dialog */}
      <Dialog open={isDeleteDialogOpen} onOpenChange={setIsDeleteDialogOpen}>
        <DialogContent>
          <DialogHeader>
            <DialogTitle>¿Está seguro?</DialogTitle>
          </DialogHeader>
          {selectedVendedor && (
            <div className="py-4">
              <p>
                Esta acción no se puede deshacer. Esto eliminará permanentemente
                al vendedor{" "}
                {selectedVendedor.nom_ven ?? selectedVendedor.NOM_VEN}{" "}
                {selectedVendedor.ape_ven ?? selectedVendedor.APE_VEN} y sus
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
                  selectedVendedor?.cod_ven ?? selectedVendedor?.COD_VEN,
                )
              }
              disabled={
                loading ===
                (selectedVendedor?.cod_ven ?? selectedVendedor?.COD_VEN)
              }
            >
              {loading ===
              (selectedVendedor?.cod_ven ?? selectedVendedor?.COD_VEN)
                ? "Eliminando..."
                : "Eliminar"}
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>
    </div>
  );
}
