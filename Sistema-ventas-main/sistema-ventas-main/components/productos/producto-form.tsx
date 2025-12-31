//Este componente se ejecuta del lado del cliente
"use client";
//Importacion de acciones para optener la actualisacion y creacion de un producto
import {
  actualizarProducto,
  crearProducto,
  type Producto,
} from "@/app/actions/producto-actions";
//Importa componentes reutilisables de UI
import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
//Imprta componentes del sistema de formularios
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
//Importa el campo de entrada de texto
import { Input } from "@/components/ui/input";
//Importa componentes de seleccion
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
//Importa el elemento useToast dese el componente use-toast 
import { useToast } from "@/components/ui/use-toast";
//Importa el elemento zodResolver desde el componente zod
import { zodResolver } from "@hookform/resolvers/zod";
//Importa el elemento useRouter desde el componente navigation
import { useRouter } from "next/navigation";
//Importa elementos desde el componente react
import { useEffect, useState } from "react";
//Importa el elemento useForm desde el componente react-hook-form
import { useForm } from "react-hook-form";
//Importa todos los elementos del componente zod como z
import * as z from "zod";
//Mensages de adverttencia a la hora de rellenar campos para agregar un producto
const formSchema = z.object({
  COD_PRO: z.string().length(5, {
    message: "El código debe tener exactamente 5 caracteres",
  }),
  DES_PRO: z
    .string()
    .min(2, {
      message: "La descripción debe tener al menos 2 caracteres",
    })
    .max(100, {
      message: "La descripción no puede tener más de 100 caracteres",
    }),
  PRE_PRO: z.coerce
    .number()
    .min(0, {
      message: "El precio no puede ser negativo",
    })
    .max(100000, {
      message: "El precio no puede ser mayor a 100,000",
    }),
  STO_PRO: z.coerce
    .number()
    .min(0, {
      message: "El stock no puede ser negativo",
    })
    .max(100000, {
      message: "El stock no puede ser mayor a 100,000",
    }),
  SMI_PRO: z.coerce
    .number()
    .min(0, {
      message: "El stock mínimo no puede ser negativo",
    })
    .max(100000, {
      message: "El stock mínimo no puede ser mayor a 100,000",
    }),
  UNI_PRO: z
    .string()
    .min(1, {
      message: "La unidad es requerida",
    })
    .max(50, {
      message: "La unidad no puede tener más de 50 caracteres",
    }),
  UBI_PRO: z
    .string()
    .max(100, {
      message: "La ubicación no puede tener más de 100 caracteres",
    })
    .optional(),
  IMP_PRO: z
    .string()
    .max(50, {
      message: "El tipo de importación no puede tener más de 50 caracteres",
    })
    .optional(),
});

type ProductoFormValues = z.infer<typeof formSchema>;
//Define propiedades esperadas por el componente ProductoFormProps
interface ProductoFormProps {
  initialData?: Producto;
  isEditing?: boolean;
  inDialog?: boolean;
  onSuccess?: (data: ProductoFormValues) => void;
  onCancel?: () => void;
}
/**
*Componente ProductoForm
*Formulario para crear o editar productos
*/
export function ProductoForm({
  initialData,
  isEditing = false,
  inDialog = false,
  onSuccess,
  onCancel,
}: ProductoFormProps) {
  const router = useRouter();
  const { toast } = useToast();
  const [loading, setLoading] = useState(false);

  const defaultValues: Partial<ProductoFormValues> = initialData || {
    COD_PRO: "",
    DES_PRO: "",
    PRE_PRO: 0,
    STO_PRO: 0,
    SMI_PRO: 0,
    UNI_PRO: "",
    UBI_PRO: "",
    IMP_PRO: "",
  };

  const form = useForm<ProductoFormValues>({
    resolver: zodResolver(formSchema),
    defaultValues,
  });

  // Resetear el formulario cuando cambie initialData
  useEffect(() => {
    if (initialData) {
      form.reset({
        COD_PRO: initialData.COD_PRO || "",
        DES_PRO: initialData.DES_PRO || "",
        PRE_PRO: initialData.PRE_PRO ?? 0,
        STO_PRO: initialData.STO_PRO ?? 0,
        SMI_PRO: initialData.SMI_PRO ?? 0,
        UNI_PRO: initialData.UNI_PRO || "",
        UBI_PRO: initialData.UBI_PRO || "",
        IMP_PRO: initialData.IMP_PRO || "",
      });
    }
  }, [initialData, form]);

  async function onSubmit(data: ProductoFormValues) {
    try {
      setLoading(true);

      if (isEditing) {
        const result = await actualizarProducto(data);
        if (!result.success) {
          throw new Error(String(result.error));
        }
      } else {
        const result = await crearProducto(data);
        if (!result.success) {
          throw new Error(String(result.error));
        }
      }

      if (onSuccess) {
        onSuccess(data);
      } else {
        toast({
          title: isEditing ? "Producto actualizado" : "Producto creado",
          description: isEditing
            ? "El producto ha sido actualizado correctamente."
            : "El producto ha sido creado correctamente.",
        });

        router.push("/productos");
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

  const formContent = (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-6">
        <div className="grid grid-cols-1 gap-6 md:grid-cols-2">
          <FormField
            control={form.control}
            name="COD_PRO"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Código</FormLabel>
                <FormControl>
                  <Input
                    placeholder="P0001"
                    {...field}
                    disabled={isEditing}
                    maxLength={5}
                  />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="DES_PRO"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Descripción</FormLabel>
                <FormControl>
                  <Input placeholder="Descripción del producto" {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="PRE_PRO"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Precio</FormLabel>
                <FormControl>
                  <Input
                    type="number"
                    step="0.01"
                    placeholder="0.00"
                    {...field}
                  />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="UNI_PRO"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Unidad</FormLabel>
                <FormControl>
                  <Input placeholder="UNI" maxLength={3} {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="STO_PRO"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Stock Actual</FormLabel>
                <FormControl>
                  <Input type="number" placeholder="0" {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="SMI_PRO"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Stock Mínimo</FormLabel>
                <FormControl>
                  <Input type="number" placeholder="0" {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="UBI_PRO"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Ubicación</FormLabel>
                <FormControl>
                  <Input
                    placeholder="Ubicación en almacén"
                    {...field}
                    value={field.value || ""}
                  />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="IMP_PRO"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Tipo de Importación</FormLabel>
                <Select
                  onValueChange={field.onChange}
                  defaultValue={field.value}
                  value={field.value || ""}
                >
                  <FormControl>
                    <SelectTrigger>
                      <SelectValue placeholder="Seleccione un tipo" />
                    </SelectTrigger>
                  </FormControl>
                  <SelectContent>
                    <SelectItem value="F">F</SelectItem>
                    <SelectItem value="V">V</SelectItem>
                  </SelectContent>
                </Select>
                <FormMessage />
              </FormItem>
            )}
          />
        </div>
        <div className="flex justify-end gap-2">
          {inDialog ? (
            <>
              <Button
                type="button"
                variant="outline"
                onClick={onCancel}
                disabled={loading}
              >
                Cancelar
              </Button>
              <Button type="submit" disabled={loading}>
                {loading ? "Guardando..." : isEditing ? "Actualizar" : "Crear"}
              </Button>
            </>
          ) : (
            <>
              <Button
                type="button"
                variant="outline"
                onClick={() => router.push("/productos")}
                disabled={loading}
              >
                Cancelar
              </Button>
              <Button type="submit" disabled={loading}>
                {loading ? "Guardando..." : isEditing ? "Actualizar" : "Crear"}
              </Button>
            </>
          )}
        </div>
      </form>
    </Form>
  );

  if (inDialog) {
    return formContent;
  }

  return (
    <Card>
      <CardContent className="pt-6">{formContent}</CardContent>
    </Card>
  );
}
