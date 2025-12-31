//Indica que se ejecuta del lado del cliente
"use client";
//Importa el elemento crearOrdenCompra desde el componete orden-compra-action
import { crearOrdenCompra } from "@/app/actions/orden-compra-actions";
//Importa el elemento obtenerProductos desde el componente producto-actions
import { obtenerProductos } from "@/app/actions/producto-actions";
//Importa el elemento obtenerProveedores desde el componente proveedor-actions
import { obtenerProveedores } from "@/app/actions/proveedor-actions";
//Importa el elemento Button desde el componente button
import { Button } from "@/components/ui/button";
//Importa elementos desde el componente card
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
//Importa elementos desde el componente form
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
//Importa el elemento Input desde el componente imput
import { Input } from "@/components/ui/input";
//Importa elementos desde el componente select
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
//Importa elementos desde el componente table
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
//importa el elemento zodResolver desde el componente zod
import { zodResolver } from "@hookform/resolvers/zod";
//Importa los elementos Plush y Trash2 desde el componente lucide-react
import { Plus, Trash2 } from "lucide-react";
//Importa el elemento useRoutes desde el componente navigation
import { useRouter } from "next/navigation";
//Importa los elementos useEffect y useState desde el componente react
import { useEffect, useState } from "react";
//Importa los elementos useFieldArray y useForm desde el componente ract-hook-form
import { useFieldArray, useForm } from "react-hook-form";
//Importa los elementos de zod como z
import * as z from "zod";
//Determina restricciones a la hora de ingrasar datos
const detalleSchema = z.object({
  COD_PRO: z.string().min(1, {
    message: "Debe seleccionar un producto",
  }),
  CAN_DET: z.coerce
    .number()
    .min(1, {
      message: "La cantidad debe ser al menos 1",
    })
    .max(10000, {
      message: "La cantidad no puede ser mayor a 10,000",
    }),
});
//Determina restricciones a la hora de ingrasar datos
const formSchema = z.object({
  NUM_OCO: z.string().min(1, {
    message: "El número de orden es requerido",
  }),
  FEC_OCO: z.string().min(1, {
    message: "La fecha de orden es requerida",
  }),
  COD_PRV: z.string().min(1, {
    message: "Debe seleccionar un proveedor",
  }),
  EST_OCO: z.string().min(1, {
    message: "El estado es requerido",
  }),
  DETALLES: z.array(detalleSchema).min(1, {
    message: "Debe agregar al menos un producto",
  }),
});
//Define propieddades por el componente OrdenCompraForm
type OrdenCompraFormValues = z.infer<typeof formSchema>;

//Llama la funcion OrdenCompraForm para crear un formulacio v¿con el objetivo de añadir una orden de compra
export function OrdenCompraForm({
  onSuccess,
  inDialog,
}: {
  onSuccess?: (data: OrdenCompraFormValues) => void;
  inDialog?: boolean;
}) {
  const router = useRouter();
  const { toast } = useToast();
  const [loading, setLoading] = useState(false);
  const [proveedores, setProveedores] = useState<any[]>([]);
  const [productos, setProductos] = useState<any[]>([]);

  const defaultValues: Partial<OrdenCompraFormValues> = {
    NUM_OCO: "",
    FEC_OCO: new Date().toISOString().split("T")[0],
    COD_PRV: "",
    EST_OCO: "P", // Pendiente por defecto
    DETALLES: [{ COD_PRO: "", CAN_DET: 1 }],
  };

  const form = useForm<OrdenCompraFormValues>({
    resolver: zodResolver(formSchema),
    defaultValues,
  });

  const { fields, append, remove } = useFieldArray({
    control: form.control,
    name: "DETALLES",
  });

  useEffect(() => {
    const fetchData = async () => {
      const proveedoresResult = await obtenerProveedores();
      if (proveedoresResult.success) {
        setProveedores(proveedoresResult.data);
      }

      const productosResult = await obtenerProductos();
      if (productosResult.success) {
        setProductos(productosResult.data);
      }
    };

    fetchData();
  }, []);

  async function onSubmit(data: OrdenCompraFormValues) {
    try {
      setLoading(true);
      const orden = {
        NUM_OCO: data.NUM_OCO,
        FEC_OCO: data.FEC_OCO,
        COD_PRV: data.COD_PRV,
        EST_OCO: data.EST_OCO,
      };
      const detalles = data.DETALLES.map((detalle) => ({
        NUM_OCO: data.NUM_OCO,
        COD_PRO: detalle.COD_PRO,
        CAN_DET: detalle.CAN_DET,
      }));
      const result = await crearOrdenCompra(orden, detalles);
      if (!result.success) {
        throw new Error(String(result.error));
      }
      toast({
        title: "Orden de compra creada",
        description: "La orden de compra ha sido creada correctamente.",
      });
      if (onSuccess) {
        onSuccess(data);
      }
    } catch (error) {
      toast({
        title: "Error",
        description: String(error),
        variant: "destructive",
      });
    } finally {
      setLoading(false);
    }
  }

  // Get product details by code
  const getProductDetails = (codPro: string) => {
    return productos.find((producto) => producto.cod_pro === codPro);
  };

  return (
    <Card>
      <CardContent className="pt-6">
        <Form {...form}>
          <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-6">
            <div className="grid grid-cols-1 gap-6 md:grid-cols-2">
              <FormField
                control={form.control}
                name="NUM_OCO"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Número de Orden</FormLabel>
                    <FormControl>
                      <Input placeholder="OC001" {...field} maxLength={5} />
                    </FormControl>
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="FEC_OCO"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Fecha de Orden</FormLabel>
                    <FormControl>
                      <Input type="date" {...field} />
                    </FormControl>
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="COD_PRV"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Proveedor</FormLabel>
                    <Select
                      onValueChange={field.onChange}
                      defaultValue={field.value}
                      value={field.value}
                    >
                      <FormControl>
                        <SelectTrigger>
                          <SelectValue placeholder="Seleccione un proveedor" />
                        </SelectTrigger>
                      </FormControl>
                      <SelectContent>
                        {proveedores.map((proveedor) => (
                          <SelectItem
                            key={proveedor.cod_prv}
                            value={proveedor.cod_prv}
                          >
                            {proveedor.rso_prv}
                          </SelectItem>
                        ))}
                      </SelectContent>
                    </Select>
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="EST_OCO"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Estado</FormLabel>
                    <Select
                      onValueChange={field.onChange}
                      defaultValue={field.value}
                      value={field.value}
                    >
                      <FormControl>
                        <SelectTrigger>
                          <SelectValue placeholder="Seleccione un estado" />
                        </SelectTrigger>
                      </FormControl>
                      <SelectContent>
                        <SelectItem value="1">Pendiente</SelectItem>
                        <SelectItem value="2">Completada</SelectItem>
                        <SelectItem value="3">Anulada</SelectItem>
                      </SelectContent>
                    </Select>
                    <FormMessage />
                  </FormItem>
                )}
              />
            </div>

            <Card>
              <CardHeader>
                <CardTitle>Detalle de Productos</CardTitle>
              </CardHeader>
              <CardContent>
                <Table>
                  <TableHeader>
                    <TableRow>
                      <TableHead>Producto</TableHead>
                      <TableHead>Cantidad</TableHead>
                      <TableHead className="text-right">Acciones</TableHead>
                    </TableRow>
                  </TableHeader>
                  <TableBody>
                    {fields.map((field, index) => (
                      <TableRow key={field.id}>
                        <TableCell>
                          <FormField
                            control={form.control}
                            name={`DETALLES.${index}.COD_PRO`}
                            render={({ field }) => (
                              <FormItem>
                                <Select
                                  onValueChange={field.onChange}
                                  defaultValue={field.value}
                                  value={field.value}
                                >
                                  <FormControl>
                                    <SelectTrigger>
                                      <SelectValue placeholder="Seleccione un producto" />
                                    </SelectTrigger>
                                  </FormControl>
                                  <SelectContent>
                                    {productos.map((producto) => (
                                      <SelectItem
                                        key={producto.cod_pro}
                                        value={producto.cod_pro}
                                      >
                                        {producto.des_pro}
                                      </SelectItem>
                                    ))}
                                  </SelectContent>
                                </Select>
                                <FormMessage />
                              </FormItem>
                            )}
                          />
                        </TableCell>
                        <TableCell>
                          <FormField
                            control={form.control}
                            name={`DETALLES.${index}.CAN_DET`}
                            render={({ field }) => (
                              <FormItem>
                                <FormControl>
                                  <Input type="number" min="1" {...field} />
                                </FormControl>
                                <FormMessage />
                              </FormItem>
                            )}
                          />
                        </TableCell>
                        <TableCell className="text-right">
                          <Button
                            type="button"
                            variant="destructive"
                            size="icon"
                            onClick={() => remove(index)}
                            disabled={fields.length === 1}
                          >
                            <Trash2 className="h-4 w-4" />
                          </Button>
                        </TableCell>
                      </TableRow>
                    ))}
                  </TableBody>
                </Table>
                <Button
                  type="button"
                  variant="outline"
                  size="sm"
                  className="mt-4"
                  onClick={() => append({ COD_PRO: "", CAN_DET: 1 })}
                >
                  <Plus className="mr-2 h-4 w-4" />
                  Agregar Producto
                </Button>
                <FormField
                  control={form.control}
                  name="DETALLES"
                  render={() => (
                    <FormItem>
                      <FormMessage />
                    </FormItem>
                  )}
                />
              </CardContent>
            </Card>

            <div className="flex justify-end gap-2">
              <Button
                type="button"
                variant="outline"
                onClick={() => {
                  if (onSuccess) {
                    onSuccess(form.getValues());
                  }
                }}
                disabled={loading}
              >
                Cancelar
              </Button>
              <Button type="submit" disabled={loading}>
                {loading ? "Guardando..." : "Crear Orden de Compra"}
              </Button>
            </div>
          </form>
        </Form>
      </CardContent>
    </Card>
  );
}
