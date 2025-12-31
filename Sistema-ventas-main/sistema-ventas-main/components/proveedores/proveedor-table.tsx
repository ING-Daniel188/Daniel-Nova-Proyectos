//El componente se ejecuta por el lado del cliente
"use client";
//Importacion de acciones para manejas proveedores mediante acciones del servidor
import {
  eliminarProveedor,
  obtenerProveedor,
} from "@/app/actions/proveedor-actions";
//Componentes UI reutilizables
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
//Importa el elemento useToast desde el componente use-toast
import { useToast } from "@/components/ui/use-toast";
//Importa iconos
import { Edit, Phone, Plus, Trash2 } from "lucide-react";
//Importa el elemento useRouter desde el componente navigation 
import { useRouter } from "next/navigation";
//Importa elemetos desde el componente react
import { useEffect, useState, useTransition } from "react";
//Importa el componente del formulario de proveedores
import { ProveedorForm } from "./proveedor-form";
//Valores necesarios para el componente ProveedorTable
interface ProveedorTableProps {
  initialData: any[];
}
//Componenete para gestionar y visualisar la tabla de proveedores
export function ProveedorTable({ initialData }: ProveedorTableProps) {
  const { toast } = useToast();
  const router = useRouter();
  const [isPending, startTransition] = useTransition();
  const [loading, setLoading] = useState<string | null>(null);
  const [loadingEdit, setLoadingEdit] = useState<string | null>(null);
  const [data, setData] = useState(initialData);
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedProveedor, setSelectedProveedor] = useState<any>(null);
  const [isDeleteDialogOpen, setIsDeleteDialogOpen] = useState(false);
  const [isEditDialogOpen, setIsEditDialogOpen] = useState(false);
  const [isNewDialogOpen, setIsNewDialogOpen] = useState(false);

  // Sincronizar datos cuando cambian los datos iniciales
  useEffect(() => {
    setData(initialData);
  }, [initialData]);

  const handleDelete = async (codigo: string) => {
    try {
      setLoading(codigo);
      const result = await eliminarProveedor(codigo);

      if (result.success) {
        // Actualización optimista: Eliminar el proveedor del estado local
        setData(data.filter((proveedor) => proveedor.cod_prv !== codigo));

        toast({
          title: "Proveedor eliminado",
          description: "El proveedor ha sido eliminado correctamente.",
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
        description: "No se pudo eliminar el proveedor: " + String(error),
        variant: "destructive",
      });
    } finally {
      setLoading(null);
    }
  };

  const handleEditClick = async (proveedor: any) => {
    try {
      setLoadingEdit(proveedor.cod_prv);

      // Obtener los datos actualizados del proveedor desde el servidor
      const result = await obtenerProveedor(proveedor.cod_prv);

      if (result.success) {
        // Convertir los nombres de campo a mayúsculas para el formulario
        setSelectedProveedor({
          COD_PRV: result.data.cod_prv,
          RSO_PRV: result.data.rso_prv,
          DIR_PRV: result.data.dir_prv,
          TEL_PRV: result.data.tel_prv,
          COD_DIS: result.data.cod_dis,
          REP_PRO: result.data.rep_pro,
        });
        setIsEditDialogOpen(true);
      } else {
        throw new Error(String(result.error));
      }
    } catch (error) {
      toast({
        title: "Error",
        description: "No se pudo cargar el proveedor: " + String(error),
        variant: "destructive",
      });
    } finally {
      setLoadingEdit(null);
    }
  };

  const handleProveedorCreated = (newProveedor: any) => {
    // Actualización optimista: Agregar el proveedor al estado local
    setData([
      ...data,
      {
        cod_prv: newProveedor.COD_PRV,
        rso_prv: newProveedor.RSO_PRV,
        dir_prv: newProveedor.DIR_PRV,
        tel_prv: newProveedor.TEL_PRV,
        cod_dis: newProveedor.COD_DIS,
        rep_pro: newProveedor.REP_PRO,
        nom_dis: "Actualizado", // Se actualizará al recargar
      },
    ]);
    setIsNewDialogOpen(false);
    toast({
      title: "Proveedor creado",
      description: "El proveedor ha sido creado correctamente.",
    });

    // Revalidar y actualizar la UI
    startTransition(() => {
      router.refresh();
    });
  };

  const handleProveedorUpdated = (updatedProveedor: any) => {
    // Actualización optimista: Actualizar el proveedor en el estado local
    setData(
      data.map((p) =>
        p.cod_prv === updatedProveedor.COD_PRV
          ? {
              ...p,
              rso_prv: updatedProveedor.RSO_PRV,
              dir_prv: updatedProveedor.DIR_PRV,
              tel_prv: updatedProveedor.TEL_PRV,
              cod_dis: updatedProveedor.COD_DIS,
              rep_pro: updatedProveedor.REP_PRO,
            }
          : p,
      ),
    );
    setIsEditDialogOpen(false);
    toast({
      title: "Proveedor actualizado",
      description: "El proveedor ha sido actualizado correctamente.",
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

  // Filter proveedores based on search term
  const filteredData = data.filter(
    (proveedor) =>
      proveedor.rso_prv.toLowerCase().includes(searchTerm.toLowerCase()) ||
      proveedor.cod_prv.toLowerCase().includes(searchTerm.toLowerCase()) ||
      proveedor.rep_pro.toLowerCase().includes(searchTerm.toLowerCase()),
  );

  return (
    <div className="space-y-4">
      <div className="flex items-center justify-between">
        <Input
          placeholder="Buscar proveedores..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          className="max-w-sm"
        />
        <Button onClick={() => setIsNewDialogOpen(true)}>
          <Plus className="mr-2 h-4 w-4" />
          Nuevo Proveedor
        </Button>
      </div>

      <div className="rounded-md border">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead>Código</TableHead>
              <TableHead>Razón Social</TableHead>
              <TableHead>Representante</TableHead>
              <TableHead>Teléfono</TableHead>
              <TableHead>Distrito</TableHead>
              <TableHead className="text-right">Acciones</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {filteredData.length === 0 ? (
              <TableRow>
                <TableCell colSpan={6} className="h-24 text-center">
                  No hay proveedores que coincidan con la búsqueda.
                </TableCell>
              </TableRow>
            ) : (
              filteredData.map((proveedor) => (
                <TableRow key={proveedor.cod_prv}>
                  <TableCell className="font-medium">
                    {proveedor.cod_prv}
                  </TableCell>
                  <TableCell>{proveedor.rso_prv}</TableCell>
                  <TableCell>{proveedor.rep_pro}</TableCell>
                  <TableCell>
                    <div className="flex items-center gap-1">
                      <Phone className="h-4 w-4 text-muted-foreground" />
                      {proveedor.tel_prv}
                    </div>
                  </TableCell>
                  <TableCell>{proveedor.nom_dis}</TableCell>
                  <TableCell className="text-right">
                    <div className="flex justify-end gap-2">
                      <Button
                        variant="outline"
                        size="icon"
                        onClick={() => handleEditClick(proveedor)}
                        disabled={loadingEdit === proveedor.cod_prv}
                      >
                        <Edit className="h-4 w-4" />
                      </Button>
                      <Button
                        variant="destructive"
                        size="icon"
                        onClick={() => {
                          setSelectedProveedor(proveedor);
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

      {/* Diálogo para crear nuevo proveedor */}
      <Dialog open={isNewDialogOpen} onOpenChange={setIsNewDialogOpen}>
        <DialogContent className="max-w-3xl">
          <DialogHeader>
            <DialogTitle>Nuevo Proveedor</DialogTitle>
          </DialogHeader>
          <ProveedorForm
            onSuccess={handleProveedorCreated}
            onCancel={handleCancelNew}
            inDialog={true}
          />
        </DialogContent>
      </Dialog>

      {/* Diálogo para editar proveedor */}
      <Dialog open={isEditDialogOpen} onOpenChange={setIsEditDialogOpen}>
        <DialogContent className="max-w-3xl">
          <DialogHeader>
            <DialogTitle>Editar Proveedor</DialogTitle>
          </DialogHeader>
          {selectedProveedor && (
            <ProveedorForm
              initialData={selectedProveedor}
              isEditing={true}
              onSuccess={handleProveedorUpdated}
              onCancel={handleCancelEdit}
              inDialog={true}
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
          {selectedProveedor && (
            <div className="py-4">
              <p>
                Esta acción no se puede deshacer. Esto eliminará permanentemente
                el proveedor{" "}
                {selectedProveedor.rso_prv || selectedProveedor.RSO_PRV} y sus
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
                  selectedProveedor?.cod_prv || selectedProveedor?.COD_PRV,
                )
              }
              disabled={
                loading ===
                (selectedProveedor?.cod_prv || selectedProveedor?.COD_PRV)
              }
            >
              {loading ===
              (selectedProveedor?.cod_prv || selectedProveedor?.COD_PRV)
                ? "Eliminando..."
                : "Eliminar"}
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>
    </div>
  );
}
