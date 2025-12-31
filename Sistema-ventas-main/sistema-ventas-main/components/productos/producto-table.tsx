"use client";
// Acciones para manejar productos (eliminar, obtener).
import {
  eliminarProducto,
  obtenerProducto,
} from "@/app/actions/producto-actions";
// Componentes reutilizables de UI
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
// Iconos de la biblioteca lucide-react.
import { AlertTriangle, Edit, Plus, Trash2 } from "lucide-react";
// Importa el elemento useRouter del componente navigation
import { useRouter } from "next/navigation";
// Importa el elemento useState del componente react
import { useState } from "react";
// Formulario para manejo de productos.
import { ProductoForm } from "./producto-form";

// Props de ProductoTable con los datos iniciales de productos
interface ProductoTableProps {
  initialData: any[];
}
// Muestra una tabla de productos, con funcionalidades para buscar, crear, editar y eliminar productos, y mostrar alertas de stock bajo
export function ProductoTable({ initialData }: ProductoTableProps) {
  const { toast } = useToast();
  const router = useRouter();
  const [loading, setLoading] = useState<string | null>(null);
  const [data, setData] = useState(initialData);
  const [searchTerm, setSearchTerm] = useState("");

  const [isNewDialogOpen, setIsNewDialogOpen] = useState(false);
  const [selectedProduct, setSelectedProduct] = useState<any>(null);
  const [isDeleteDialogOpen, setIsDeleteDialogOpen] = useState(false);
  // Maneja la eliminación de un producto 
  const handleDelete = async (codigo: string) => {
    try {
      setLoading(codigo);
      const result = await eliminarProducto(codigo);

      if (result.success) {
        // Update local state to remove the deleted item
        setData(data.filter((producto) => producto.cod_pro !== codigo));

        toast({
          title: "Producto eliminado",
          description: "El producto ha sido eliminado correctamente.",
        });
        setIsDeleteDialogOpen(false);
      } else {
        throw new Error(String(result.error));
      }
    } catch (error) {
      toast({
        title: "Error",
        description: "No se pudo eliminar el producto: " + String(error),
        variant: "destructive",
      });
    } finally {
      setLoading(null);
    }
  };
  // Actualiza el producto tras su edición
  const handleProductUpdated = (updatedProduct: any) => {
    setData(
      data.map((p) =>
        p.cod_pro === updatedProduct.COD_PRO
          ? {
              ...p,
              des_pro: updatedProduct.DES_PRO,
              pre_pro: updatedProduct.PRE_PRO,
              sto_pro: updatedProduct.STO_PRO,
              smi_pro: updatedProduct.SMI_PRO,
              uni_pro: updatedProduct.UNI_PRO,
              ubi_pro: updatedProduct.UBI_PRO,
              imp_pro: updatedProduct.IMP_PRO,
            }
          : p,
      ),
    );
    setSelectedProduct(null);
    toast({
      title: "Producto actualizado",
      description: "El producto ha sido actualizado correctamente.",
    });
    router.refresh();
  };
  // Agrega un nuevo producto a la tabla
  const handleProductCreated = (newProduct: any) => {
    setData([
      ...data,
      {
        cod_pro: newProduct.COD_PRO,
        des_pro: newProduct.DES_PRO,
        pre_pro: newProduct.PRE_PRO,
        sto_pro: newProduct.STO_PRO,
        smi_pro: newProduct.SMI_PRO,
        uni_pro: newProduct.UNI_PRO,
        ubi_pro: newProduct.UBI_PRO,
        imp_pro: newProduct.IMP_PRO,
      },
    ]);
    setIsNewDialogOpen(false);
    toast({
      title: "Producto creado",
      description: "El producto ha sido creado correctamente.",
    });
  };

  // Nuevo handler asíncrono para editar
  const handleEditClick = async (producto: any) => {
    try {
      setLoading(producto.cod_pro);
      const result = await obtenerProducto(producto.cod_pro);
      if (result.success) {
        setSelectedProduct(result.data);
      } else {
        toast({
          title: "Error",
          description: "No se pudo cargar el producto: " + String(result.error),
          variant: "destructive",
        });
      }
    } finally {
      setLoading(null);
    }
  };

  // Filter products based on search term
  const filteredData = data.filter(
    (producto) =>
      producto.des_pro.toLowerCase().includes(searchTerm.toLowerCase()) ||
      producto.cod_pro.toLowerCase().includes(searchTerm.toLowerCase()),
  );

  return (
    <div className="space-y-4">
      <div className="flex items-center justify-between">
        <Input
          placeholder="Buscar productos..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          className="max-w-sm"
        />
        <Button onClick={() => setIsNewDialogOpen(true)}>
          <Plus className="mr-2 h-4 w-4" /> Nuevo Producto
        </Button>
      </div>
      <div className="rounded-md border">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead>Código</TableHead>
              <TableHead>Descripción</TableHead>
              <TableHead>Precio</TableHead>
              <TableHead>Stock</TableHead>
              <TableHead>Tipo</TableHead>
              <TableHead>Ubicación</TableHead>
              <TableHead className="text-right">Acciones</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {filteredData.length === 0 ? (
              <TableRow>
                <TableCell colSpan={7} className="h-24 text-center">
                  No hay productos que coincidan con la búsqueda.
                </TableCell>
              </TableRow>
            ) : (
              filteredData.map((producto) => (
                <TableRow key={producto.cod_pro}>
                  <TableCell className="font-medium">
                    {producto.cod_pro}
                  </TableCell>
                  <TableCell>{producto.des_pro}</TableCell>
                  <TableCell>${Number(producto.pre_pro).toFixed(2)}</TableCell>
                  <TableCell>
                    <div className="flex items-center gap-2">
                      {producto.sto_pro < producto.smi_pro ? (
                        <AlertTriangle className="h-4 w-4 text-red-500" />
                      ) : null}
                      {producto.sto_pro}
                      {producto.sto_pro < producto.smi_pro ? (
                        <Badge variant="destructive" className="ml-2">
                          Bajo
                        </Badge>
                      ) : null}
                    </div>
                  </TableCell>
                  <TableCell>
                    {producto.imp_pro ? producto.imp_pro : "Sin tipo"}
                  </TableCell>
                  <TableCell>{producto.ubi_pro}</TableCell>
                  <TableCell className="text-right">
                    <div className="flex justify-end gap-2">
                      <Button
                        variant="outline"
                        size="icon"
                        onClick={() => handleEditClick(producto)}
                        disabled={loading === producto.cod_pro}
                      >
                        <Edit className="h-4 w-4" />
                      </Button>
                      <Button
                        variant="destructive"
                        size="icon"
                        onClick={() => {
                          setSelectedProduct(producto);
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
        open={!!selectedProduct}
        onOpenChange={(open) => {
          if (!open) setSelectedProduct(null);
        }}
      >
        <DialogContent className="max-w-3xl">
          <DialogHeader>
            <DialogTitle>Editar Producto</DialogTitle>
          </DialogHeader>
          {selectedProduct && (
            <ProductoForm
              initialData={{
                COD_PRO: selectedProduct.cod_pro,
                DES_PRO: selectedProduct.des_pro,
                PRE_PRO: selectedProduct.pre_pro,
                STO_PRO: selectedProduct.sto_pro,
                SMI_PRO: selectedProduct.smi_pro,
                UNI_PRO: selectedProduct.uni_pro,
                UBI_PRO: selectedProduct.ubi_pro,
                IMP_PRO: selectedProduct.imp_pro,
              }}
              isEditing={true}
              onSuccess={(data) => {
                handleProductUpdated(data);
                setSelectedProduct(null);
              }}
              inDialog={true}
              onCancel={() => setSelectedProduct(null)}
            />
          )}
        </DialogContent>
      </Dialog>

      {/* New Product Dialog */}
      <Dialog open={isNewDialogOpen} onOpenChange={setIsNewDialogOpen}>
        <DialogContent className="max-w-3xl">
          <DialogHeader>
            <DialogTitle>Nuevo Producto</DialogTitle>
          </DialogHeader>
          <ProductoForm
            onSuccess={handleProductCreated}
            inDialog={true}
            onCancel={() => setIsNewDialogOpen(false)}
          />
        </DialogContent>
      </Dialog>

      {/* Delete Confirmation Dialog */}
      <Dialog open={isDeleteDialogOpen} onOpenChange={setIsDeleteDialogOpen}>
        <DialogContent>
          <DialogHeader>
            <DialogTitle>¿Está seguro?</DialogTitle>
          </DialogHeader>
          {selectedProduct && (
            <div className="py-4">
              <p>
                Esta acción no se puede deshacer. Esto eliminará permanentemente
                el producto {selectedProduct.des_pro} y sus datos asociados.
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
              onClick={() => handleDelete(selectedProduct?.cod_pro)}
              disabled={loading === selectedProduct?.cod_pro}
            >
              {loading === selectedProduct?.cod_pro
                ? "Eliminando..."
                : "Eliminar"}
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>
    </div>
  );
}
