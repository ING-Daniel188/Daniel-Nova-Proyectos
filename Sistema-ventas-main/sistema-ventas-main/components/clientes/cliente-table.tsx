"use client"; // El componente se ejecuta por el lado del cliente

//Importación de acciones y componentes personalizados
import { eliminarCliente, obtenerCliente } from "@/app/actions/cliente-actions";
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
// Importa el elemento useToast del componente use-toast
import { useToast } from "@/components/ui/use-toast";
// Importa elementos del componente lucide-react
import { Building2, Edit, Phone, Plus, Trash2, User } from "lucide-react";
// Importa el elemento useRouter del componente navigation
import { useRouter } from "next/navigation";
// Importa elementos del componente react
import { useEffect, useState, useTransition } from "react";
// Formulario reutilizable para cliente
import { ClienteForm } from "./cliente-form";

// Valores esperados por el componente ClienteTable
interface ClienteTableProps {
  initialData: any[];
}
/**
 * Componente que renderiza una tabla de clientes con funcionalidades de búsqueda, creación, edición y eliminación.
 */
export function ClienteTable({ initialData }: ClienteTableProps) {
  const { toast } = useToast();
  const router = useRouter();
  const [isPending, startTransition] = useTransition();
  const [loading, setLoading] = useState<string | null>(null);
  const [loadingEdit, setLoadingEdit] = useState<string | null>(null);
  const [data, setData] = useState(initialData);
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedCliente, setSelectedCliente] = useState<any>(null);
  const [isDeleteDialogOpen, setIsDeleteDialogOpen] = useState(false);
  const [isEditDialogOpen, setIsEditDialogOpen] = useState(false);
  const [isNewDialogOpen, setIsNewDialogOpen] = useState(false);
  const [forceRefresh, setForceRefresh] = useState(0); // New state to force re-renders

  // Sincronizar datos cuando cambian los datos iniciales o forceRefresh
  useEffect(() => {
    setData(initialData);
  }, [initialData, forceRefresh]);

  // Function to force cache invalidation and refetching data
  const forceDataRefresh = async () => {
    // Force revalidation of the router
    router.refresh();

    // Force component re-render with the new state
    setForceRefresh((prev) => prev + 1);
  };

  const handleDelete = async (codigo: string) => {
    try {
      setLoading(codigo);
      const result = await eliminarCliente(codigo);

      if (result.success) {
        // Actualización optimista: Eliminar el cliente del estado local
        setData(data.filter((cliente) => cliente.cod_cli !== codigo));

        toast({
          title: "Cliente eliminado",
          description: "El cliente ha sido eliminado correctamente.",
        });
        setIsDeleteDialogOpen(false);

        // Forzar revalidación completa con limpieza de caché
        await forceDataRefresh();
      } else {
        throw new Error(String(result.error));
      }
    } catch (error) {
      toast({
        title: "Error",
        description: "No se pudo eliminar el cliente: " + String(error),
        variant: "destructive",
      });
    } finally {
      setLoading(null);
    }
  };

  const handleEditClick = async (cliente: any) => {
    try {
      setLoadingEdit(cliente.cod_cli);
      setSelectedCliente(null); // Clear previous data first

      // Add timestamp to force a fresh server request and bypass cache
      const timestamp = new Date().getTime();

      // Obtener los datos actualizados del cliente desde el servidor
      const result = await obtenerCliente(cliente.cod_cli);

      if (result.success) {
        const cliente = result.data;
        // Convertir los nombres de campo a mayúsculas para el formulario y asegurar que todos los campos estén presentes
        const formattedCliente = {
          COD_CLI: cliente.cod_cli || "",
          RCO_CLI: cliente.rco_cli || "",
          DIR_CLI: cliente.dir_cli || "",
          TLF_CLI: cliente.tlf_cli || "",
          RUC_CLI: cliente.ruc_cli || "",
          COD_DIS: cliente.cod_dis || "",
          FEC_REG: cliente.fec_reg || new Date().toISOString(),
          TIP_CLI: cliente.tip_cli || "",
          CON_CLI: cliente.con_cli || "",
          _timestamp: timestamp, // Add timestamp to the data to ensure it's fresh
        };

        // Breve pausa para asegurar que la UI se actualice correctamente
        await new Promise((resolve) => setTimeout(resolve, 50));
        setSelectedCliente(formattedCliente);
        setIsEditDialogOpen(true);
      } else {
        throw new Error(String(result.error));
      }
    } catch (error) {
      toast({
        title: "Error",
        description: "No se pudo cargar el cliente: " + String(error),
        variant: "destructive",
      });
    } finally {
      setLoadingEdit(null);
    }
  };

  const handleClienteCreated = async (newCliente: any) => {
    try {
      // Actualización optimista: Añadir el nuevo cliente al estado local
      setData([
        ...data,
        {
          cod_cli: newCliente.COD_CLI,
          rco_cli: newCliente.RCO_CLI,
          dir_cli: newCliente.DIR_CLI,
          tlf_cli: newCliente.TLF_CLI,
          ruc_cli: newCliente.RUC_CLI,
          cod_dis: newCliente.COD_DIS,
          fec_reg: newCliente.FEC_REG,
          tip_cli: newCliente.TIP_CLI,
          con_cli: newCliente.CON_CLI,
          nom_dis: "Actualizado", // Se actualizará al recargar
        },
      ]);
      setIsNewDialogOpen(false);
      toast({
        title: "Cliente creado",
        description: "El cliente ha sido creado correctamente.",
      });

      // Esperar brevemente y forzar revalidación completa con limpieza de caché
      await new Promise((resolve) => setTimeout(resolve, 300));
      await forceDataRefresh();
    } catch (error) {
      toast({
        title: "Error",
        description: "Error al actualizar la tabla: " + String(error),
        variant: "destructive",
      });
    }
  };

  const handleClienteUpdated = async (updatedCliente: any) => {
    try {
      // Actualización optimista: Actualizar el cliente en el estado local
      setData(
        data.map((c) =>
          c.cod_cli === updatedCliente.COD_CLI
            ? {
                ...c,
                rco_cli: updatedCliente.RCO_CLI,
                dir_cli: updatedCliente.DIR_CLI,
                tlf_cli: updatedCliente.TLF_CLI,
                ruc_cli: updatedCliente.RUC_CLI,
                cod_dis: updatedCliente.COD_DIS,
                fec_reg: updatedCliente.FEC_REG,
                tip_cli: updatedCliente.TIP_CLI,
                con_cli: updatedCliente.CON_CLI,
              }
            : c,
        ),
      );

      setIsEditDialogOpen(false);
      toast({
        title: "Cliente actualizado",
        description: "El cliente ha sido actualizado correctamente.",
      });

      // Esperar brevemente y forzar revalidación completa con limpieza de caché
      await new Promise((resolve) => setTimeout(resolve, 300));
      await forceDataRefresh();
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

  // Format date for display
  const formatDate = (dateString: string) => {
    return new Date(dateString).toLocaleDateString();
  };

  // Get badge variant and icon based on client type
  const getClientTypeInfo = (tipo: string) => {
    switch (tipo) {
      case "EMPRESA":
        return {
          variant: "default",
          icon: <Building2 className="mr-1 h-3 w-3" />,
        };
      case "PERSONA":
        return {
          variant: "secondary",
          icon: <User className="mr-1 h-3 w-3" />,
        };
      default:
        return {
          variant: "outline",
          icon: null,
        };
    }
  };

  // Filter clientes based on search term
  const filteredData = data.filter(
    (cliente) =>
      (cliente.rco_cli?.toLowerCase() || "").includes(
        searchTerm.toLowerCase(),
      ) ||
      (cliente.cod_cli?.toLowerCase() || "").includes(
        searchTerm.toLowerCase(),
      ) ||
      (cliente.con_cli?.toLowerCase() || "").includes(
        searchTerm.toLowerCase(),
      ) ||
      (cliente.ruc_cli?.toLowerCase() || "").includes(searchTerm.toLowerCase()),
  );

  return (
    <div className="space-y-4">
      <div className="flex items-center justify-between">
        <Input
          placeholder="Buscar clientes..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          className="max-w-sm"
        />
        <div className="flex gap-2">
          <Button
            variant="outline"
            onClick={forceDataRefresh}
            disabled={isPending}
          >
            {isPending ? "Actualizando..." : "Actualizar"}
          </Button>
          <Button onClick={() => setIsNewDialogOpen(true)}>
            <Plus className="mr-2 h-4 w-4" /> Nuevo Cliente
          </Button>
        </div>
      </div>
      <div className="rounded-md border">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead>Código</TableHead>
              <TableHead>Razón Comercial</TableHead>
              <TableHead>Contacto</TableHead>
              <TableHead>Teléfono</TableHead>
              <TableHead>Tipo</TableHead>
              <TableHead>Distrito</TableHead>
              <TableHead className="text-right">Acciones</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {filteredData.length === 0 ? (
              <TableRow>
                <TableCell colSpan={7} className="h-24 text-center">
                  No hay clientes que coincidan con la búsqueda.
                </TableCell>
              </TableRow>
            ) : (
              filteredData.map((cliente) => (
                <TableRow key={cliente.cod_cli}>
                  <TableCell className="font-medium">
                    {cliente.cod_cli}
                  </TableCell>
                  <TableCell>{cliente.rco_cli}</TableCell>
                  <TableCell>{cliente.con_cli}</TableCell>
                  <TableCell>
                    <div className="flex items-center gap-1">
                      <Phone className="h-4 w-4 text-muted-foreground" />
                      {cliente.tlf_cli}
                    </div>
                  </TableCell>
                  <TableCell>
                    <Badge
                      variant={
                        getClientTypeInfo(cliente.tip_cli).variant as any
                      }
                      className="flex items-center"
                    >
                      {getClientTypeInfo(cliente.tip_cli).icon}
                      {cliente.tip_cli === 1 ||
                      cliente.tip_cli === "1" ||
                      cliente.tip_cli === "PERSONA"
                        ? "Natural"
                        : cliente.tip_cli === 2 ||
                          cliente.tip_cli === "2" ||
                          cliente.tip_cli === "EMPRESA"
                        ? "Jurídico"
                        : cliente.tip_cli}
                    </Badge>
                  </TableCell>
                  <TableCell>{cliente.nom_dis}</TableCell>
                  <TableCell className="text-right">
                    <div className="flex justify-end gap-2">
                      <Button
                        variant="outline"
                        size="icon"
                        onClick={() => handleEditClick(cliente)}
                        disabled={loadingEdit === cliente.cod_cli}
                      >
                        <Edit className="h-4 w-4" />
                      </Button>
                      <Button
                        variant="destructive"
                        size="icon"
                        onClick={() => {
                          setSelectedCliente(cliente);
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

      {/* Diálogo para crear nuevo cliente */}
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
        <DialogContent className="max-w-3xl">
          <DialogHeader>
            <DialogTitle>Nuevo Cliente</DialogTitle>
          </DialogHeader>
          <ClienteForm
            key={`new-cliente-form-${forceRefresh}`}
            onSuccess={handleClienteCreated}
            inDialog={true}
            onCancel={handleCancelNew}
          />
        </DialogContent>
      </Dialog>

      {/* Diálogo para editar cliente */}
      <Dialog
        open={isEditDialogOpen}
        onOpenChange={(open) => {
          if (!open) {
            // When dialog closes, clear selected client and refresh data
            setSelectedCliente(null);
            forceDataRefresh();
          }
          setIsEditDialogOpen(open);
        }}
      >
        <DialogContent className="max-w-3xl">
          <DialogHeader>
            <DialogTitle>Editar Cliente</DialogTitle>
          </DialogHeader>
          {selectedCliente && (
            <ClienteForm
              key={`cliente-form-${selectedCliente.COD_CLI}-${
                selectedCliente._timestamp || "default"
              }`}
              initialData={selectedCliente}
              isEditing={true}
              onSuccess={handleClienteUpdated}
              inDialog={true}
              onCancel={handleCancelEdit}
            />
          )}
        </DialogContent>
      </Dialog>

      {/* Diálogo de confirmación para eliminar */}
      <Dialog open={isDeleteDialogOpen} onOpenChange={setIsDeleteDialogOpen}>
        <DialogContent>
          <DialogHeader>
            <DialogTitle>¿Está seguro?</DialogTitle>
          </DialogHeader>
          {selectedCliente && (
            <div className="py-4">
              <p>
                Esta acción no se puede deshacer. Esto eliminará permanentemente
                al cliente {selectedCliente.rco_cli} y sus datos asociados.
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
              onClick={() => handleDelete(selectedCliente?.cod_cli)}
              disabled={loading === selectedCliente?.cod_cli}
            >
              {loading === selectedCliente?.cod_cli
                ? "Eliminando..."
                : "Eliminar"}
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>
    </div>
  );
}
