"use client"; // Este componente se ejecuta del lado del cliente

// Importación de acciones para obtener clientes, productos, vendedores y crear facturas
import { obtenerClientes } from "@/app/actions/cliente-actions";
import { crearFactura } from "@/app/actions/factura-nueva-actions";
import { obtenerProductos } from "@/app/actions/producto-actions";
import { obtenerVendedores } from "@/app/actions/vendedor-actions";
// Componentes UI personalizados
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
import { useToast } from "@/components/ui/use-toast";
import { zodResolver } from "@hookform/resolvers/zod";
import { Plus } from "lucide-react";
import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";
import { useFieldArray, useForm } from "react-hook-form";
import * as z from "zod";

// Esquema de validación para los detalles de la factura
const detalleSchema = z.object({
  COD_PRO: z.string().min(1, {
    message: "Debe seleccionar un producto",
  }),
  CAN_VEN: z.coerce
    .number()
    .min(1, {
      message: "La cantidad debe ser al menos 1",
    })
    .max(10000, {
      message: "La cantidad no puede ser mayor a 10,000",
    }),
  PRE_VEN: z.coerce
    .number()
    .min(0, {
      message: "El precio no puede ser negativo",
    })
    .max(100000, {
      message: "El precio no puede ser mayor a 100,000",
    }),
});

// Esquema de validación para la factura principal
const formSchema = z.object({
  NUM_FAC: z.string().min(1, {
    message: "El número de factura es requerido",
  }),
  FEC_FAC: z.string().min(1, {
    message: "La fecha de factura es requerida",
  }),
  COD_CLI: z.string().min(1, {
    message: "Debe seleccionar un cliente",
  }),
  EST_FAC: z.string().min(1, {
    message: "El estado es requerido",
  }),
  COD_VEN: z.string().min(1, {
    message: "Debe seleccionar un vendedor",
  }),
  POR_IGV: z.coerce
    .number()
    .min(0, {
      message: "El porcentaje de IGV no puede ser negativo",
    })
    .max(100, {
      message: "El porcentaje de IGV no puede ser mayor a 100",
    }),
  DETALLES: z.array(detalleSchema).min(1, {
    message: "Debe agregar al menos un producto",
  }),
});

type FacturaFormValues = z.infer<typeof formSchema>;

interface FacturaFormProps {
  onSuccess?: (data: FacturaFormValues) => void;
  inDialog?: boolean;
  initialData?: Partial<FacturaFormValues>;
  readOnly?: boolean;
}
// Componente principal para la creación de facturas
export function FacturaForm({
  onSuccess,
  inDialog,
  initialData,
  readOnly,
}: FacturaFormProps) {
  const router = useRouter();
  const { toast } = useToast();
  const [loading, setLoading] = useState(false);
  const [clientes, setClientes] = useState<any[]>([]);
  const [vendedores, setVendedores] = useState<any[]>([]);
  const [productos, setProductos] = useState<any[]>([]);

  // Valores por defecto para el formulario
  const defaultValues: Partial<FacturaFormValues> = initialData || {
    NUM_FAC: "",
    FEC_FAC: new Date().toISOString().split("T")[0],
    COD_CLI: "",
    EST_FAC: "PENDIENTE", // Pendiente por defecto
    COD_VEN: "",
    POR_IGV: 18, // 18% por defecto
    DETALLES: [{ COD_PRO: "", CAN_VEN: 1, PRE_VEN: 0 }],
  };
  // Inicialización del formulario con React Hook Form
  const form = useForm<FacturaFormValues>({
    resolver: zodResolver(formSchema),
    defaultValues,
  });

  const { fields, append, remove } = useFieldArray({
    control: form.control,
    name: "DETALLES",
  });

  useEffect(() => {
    const fetchData = async () => {
      const clientesResult = await obtenerClientes();
      if (clientesResult.success) {
        setClientes(clientesResult.data);
      }

      const vendedoresResult = await obtenerVendedores();
      if (vendedoresResult.success) {
        setVendedores(vendedoresResult.data);
      }

      const productosResult = await obtenerProductos();
      if (productosResult.success) {
        setProductos(productosResult.data);
      }
    };

    fetchData();
  }, []);

  async function onSubmit(data: FacturaFormValues) {
    if (readOnly) return;
    try {
      setLoading(true);

      // Prepare data for API
      const factura = {
        NUM_FAC: data.NUM_FAC,
        FEC_FAC: data.FEC_FAC,
        COD_CLI: data.COD_CLI,
        EST_FAC: data.EST_FAC,
        COD_VEN: data.COD_VEN,
        POR_IGV: data.POR_IGV,
      };

      const detalles = data.DETALLES.map((detalle) => ({
        NUM_FAC: data.NUM_FAC,
        COD_PRO: detalle.COD_PRO,
        CAN_VEN: detalle.CAN_VEN,
        PRE_VEN: detalle.PRE_VEN,
      }));

      const result = await crearFactura(factura, detalles);
      if (!result.success) {
        throw new Error(String(result.error));
      }

      toast({
        title: "Factura creada",
        description: "La factura ha sido creada correctamente.",
      });

      if (onSuccess) {
        onSuccess(data);
      } else {
        router.push("/facturas");
        router.refresh();
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

  // Update price when product changes
  const updatePrice = (index: number, codPro: string) => {
    const producto = getProductDetails(codPro);
    if (producto) {
      form.setValue(`DETALLES.${index}.PRE_VEN`, producto.pre_pro);
    }
  };

  // Calculate subtotal
  const calculateSubtotal = () => {
    const detalles = form.getValues("DETALLES");
    return detalles.reduce(
      (sum, detalle) => sum + detalle.CAN_VEN * detalle.PRE_VEN,
      0,
    );
  };

  // Calculate IGV
  const calculateIGV = () => {
    const subtotal = calculateSubtotal();
    const porIgv = form.getValues("POR_IGV");
    return subtotal * (porIgv / 100);
  };

  // Calculate total
  const calculateTotal = () => {
    const subtotal = calculateSubtotal();
    const igv = calculateIGV();
    return subtotal + igv;
  };

  return (
    <Card>
      <CardContent className="pt-6">
        <Form {...form}>
          <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-6">
            <div className="grid grid-cols-1 gap-6 md:grid-cols-2">
              <FormField
                control={form.control}
                name="NUM_FAC"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Número de Factura</FormLabel>
                    <FormControl>
                      <Input
                        placeholder="F00001"
                        {...field}
                        disabled={readOnly}
                        maxLength={5}
                      />
                    </FormControl>
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="FEC_FAC"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Fecha de Factura</FormLabel>
                    <FormControl>
                      <Input type="date" {...field} disabled={readOnly} />
                    </FormControl>
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="COD_CLI"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Cliente</FormLabel>
                    <Select
                      onValueChange={field.onChange}
                      defaultValue={field.value}
                      value={field.value}
                      disabled={readOnly}
                    >
                      <FormControl>
                        <SelectTrigger>
                          <SelectValue placeholder="Seleccione un cliente" />
                        </SelectTrigger>
                      </FormControl>
                      <SelectContent>
                        {clientes.map((cliente) => (
                          <SelectItem
                            key={cliente.cod_cli}
                            value={cliente.cod_cli}
                          >
                            {cliente.rco_cli}
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
                name="COD_VEN"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Vendedor</FormLabel>
                    <Select
                      onValueChange={field.onChange}
                      defaultValue={field.value}
                      value={field.value}
                      disabled={readOnly}
                    >
                      <FormControl>
                        <SelectTrigger>
                          <SelectValue placeholder="Seleccione un vendedor" />
                        </SelectTrigger>
                      </FormControl>
                      <SelectContent>
                        {vendedores.map((vendedor) => (
                          <SelectItem
                            key={vendedor.cod_ven}
                            value={vendedor.cod_ven}
                          >
                            {`${vendedor.nom_ven} ${vendedor.ape_ven}`}
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
                name="EST_FAC"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Estado</FormLabel>
                    <Select
                      onValueChange={field.onChange}
                      defaultValue={field.value}
                      value={field.value}
                      disabled={readOnly}
                    >
                      <FormControl>
                        <SelectTrigger>
                          <SelectValue placeholder="Seleccione un estado" />
                        </SelectTrigger>
                      </FormControl>
                      <SelectContent>
                        <SelectItem value="1">PENDIENTE</SelectItem>
                        <SelectItem value="2">PAGADA</SelectItem>
                        <SelectItem value="3">ANULADA</SelectItem>
                      </SelectContent>
                    </Select>
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="POR_IGV"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Porcentaje IGV (%)</FormLabel>
                    <FormControl>
                      <Input type="number" {...field} disabled={readOnly} />
                    </FormControl>
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
                      <TableHead>Precio Unit.</TableHead>
                      <TableHead>Subtotal</TableHead>
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
                                  onValueChange={(value) => {
                                    field.onChange(value);
                                    updatePrice(index, value);
                                  }}
                                  defaultValue={field.value}
                                  value={field.value}
                                  disabled={readOnly}
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
                            name={`DETALLES.${index}.CAN_VEN`}
                            render={({ field }) => (
                              <FormItem>
                                <FormControl>
                                  <Input
                                    type="number"
                                    min="1"
                                    {...field}
                                    disabled={readOnly}
                                  />
                                </FormControl>
                                <FormMessage />
                              </FormItem>
                            )}
                          />
                        </TableCell>
                        <TableCell>
                          <FormField
                            control={form.control}
                            name={`DETALLES.${index}.PRE_VEN`}
                            render={({ field }) => (
                              <FormItem>
                                <FormControl>
                                  <Input
                                    type="number"
                                    step="0.01"
                                    {...field}
                                    disabled={readOnly}
                                  />
                                </FormControl>
                                <FormMessage />
                              </FormItem>
                            )}
                          />
                        </TableCell>
                      </TableRow>
                    ))}
                  </TableBody>
                </Table>
                {!readOnly && (
                  <Button
                    type="button"
                    variant="outline"
                    size="sm"
                    className="mt-4"
                    onClick={() =>
                      append({ COD_PRO: "", CAN_VEN: 1, PRE_VEN: 0 })
                    }
                  >
                    <Plus className="mr-2 h-4 w-4" />
                    Agregar Producto
                  </Button>
                )}
              </CardContent>
            </Card>

            <div className="grid grid-cols-1 gap-6 md:grid-cols-3">
              <div>
                <p className="font-semibold">
                  Subtotal: {calculateSubtotal().toFixed(2)}
                </p>
              </div>
              <div>
                <p className="font-semibold">
                  IGV: {calculateIGV().toFixed(2)}
                </p>
              </div>
              <div>
                <p className="font-semibold">
                  Total: {calculateTotal().toFixed(2)}
                </p>
              </div>
            </div>

            {!readOnly && (
              <Button type="submit" disabled={loading}>
                {loading && (
                  <svg
                    className="mr-2 h-4 w-4 animate-spin"
                    viewBox="0 0 24 24"
                  >
                    <circle
                      className="opacity-25"
                      cx="12"
                      cy="12"
                      r="10"
                      stroke="currentColor"
                      strokeWidth="4"
                    />
                    <path
                      className="opacity-75"
                      fill="currentColor"
                      d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"
                    />
                  </svg>
                )}
                Crear Factura
              </Button>
            )}
          </form>
        </Form>
      </CardContent>
    </Card>
  );
}
