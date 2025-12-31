"use client";

import { useState, useEffect } from "react";
import { useRouter } from "next/navigation";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import * as z from "zod";
import { Button } from "@/components/ui/button";
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import { useToast } from "@/components/ui/use-toast";
import { Card, CardContent } from "@/components/ui/card";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import {
  crearVendedor,
  actualizarVendedor,
  type Vendedor,
} from "@/app/actions/vendedor-actions";
import { obtenerDistritos } from "@/app/actions/distrito-actions";
// Esquema de validación para la información introducida en el formulario
const formSchema = z.object({
  COD_VEN: z.string().length(5, {
    message: "El código debe tener exactamente 5 caracteres",
  }),
  NOM_VEN: z
    .string()
    .min(2, {
      message: "El nombre debe tener al menos 2 caracteres",
    })
    .max(50, {
      message: "El nombre no puede tener más de 50 caracteres",
    }),
  APE_VEN: z
    .string()
    .min(2, {
      message: "El apellido debe tener al menos 2 caracteres",
    })
    .max(50, {
      message: "El apellido no puede tener más de 50 caracteres",
    }),
  SUE_VEN: z.coerce
    .number()
    .min(0, {
      message: "El sueldo no puede ser negativo",
    })
    .max(100000, {
      message: "El sueldo no puede ser mayor a 100,000",
    }),
  FIN_VEN: z.string().min(1, {
    message: "La fecha de ingreso es requerida",
  }),
  TIP_VEN: z.string().min(1, {
    message: "El tipo de vendedor es requerido",
  }),
  COD_DIS: z.string().min(1, {
    message: "Debe seleccionar un distrito",
  }),
});

type VendedorFormValues = z.infer<typeof formSchema>;
// Props esperados por el componente VendedorForm
interface VendedorFormProps {
  readonly initialData?: Vendedor;
  readonly isEditing?: boolean;
  readonly inDialog?: boolean;
  readonly onSuccess?: (data: VendedorFormValues) => void;
  readonly onCancel?: () => void;
}
/*
* Componente VendedorForm
* Gestiona el formulario para crear o editar un vendedor, con sus respectivas validaciones, manejo de estados y comunicación con el backend.
*/
export function VendedorForm({
  initialData,
  isEditing = false,
  inDialog = false,
  onSuccess,
  onCancel,
}: VendedorFormProps) {
  const router = useRouter();
  const { toast } = useToast();
  const [loading, setLoading] = useState(false);
  const [distritos, setDistritos] = useState<any[]>([]);

  // Format date for input with consistent format to avoid hydration issues
  const formatDateForInput = (dateString: string) => {
    if (!dateString) return "";
    const date = new Date(dateString);
    // Verificar si la fecha es válida
    if (isNaN(date.getTime())) return "";
    // Formato YYYY-MM-DD para evitar problemas de localización
    return date.toISOString().split("T")[0];
  };
  // Valores por defecto del formulario
  const defaultValues: Partial<VendedorFormValues> = {
    COD_VEN: initialData?.COD_VEN ?? "",
    NOM_VEN: initialData?.NOM_VEN ?? "",
    APE_VEN: initialData?.APE_VEN ?? "",
    SUE_VEN: initialData?.SUE_VEN ?? 0,
    FIN_VEN: initialData?.FIN_VEN
      ? formatDateForInput(initialData.FIN_VEN)
      : "",
    TIP_VEN: initialData?.TIP_VEN ?? "",
    COD_DIS: initialData?.COD_DIS ?? "",
  };
  // Configuraciones del formulario con validaciones y valores por defecto
  const form = useForm<VendedorFormValues>({
    resolver: zodResolver(formSchema),
    defaultValues,
  });

  useEffect(() => {
    const fetchDistritos = async () => {
      const result = await obtenerDistritos();
      if (result.success) {
        setDistritos(result.data);
      }
    };

    fetchDistritos();
  }, []);

  async function onSubmit(data: VendedorFormValues) {
    try {
      setLoading(true);

      let result;
      // Ejecutar la acción correspondiente según si estamos editando o creando
      if (isEditing) {
        result = await actualizarVendedor(data);
      } else {
        result = await crearVendedor(data);
      }

      // Verificar si la operación fue exitosa
      if (!result.success) {
        throw new Error(String(result.error));
      }

      // Esperar un momento para asegurar que la base de datos se ha actualizado
      await new Promise((resolve) => setTimeout(resolve, 300));

      // Si todo salió bien y estamos en un diálogo, llamar al callback de éxito
      if (onSuccess) {
        // Importante: No llamar onSuccess directamente, sino después de un pequeño retraso
        // para evitar problemas de renderizado
        const dataToPass = { ...data };
        setTimeout(() => {
          onSuccess(dataToPass);
        }, 10);
      } else {
        toast({
          title: isEditing ? "Vendedor actualizado" : "Vendedor creado",
          description: isEditing
            ? "El vendedor ha sido actualizado correctamente."
            : "El vendedor ha sido creado correctamente.",
        });

        router.push("/vendedores");
        router.refresh();
      }
    } catch (error) {
      console.error("Error en el formulario:", error);
      toast({
        title: "Error",
        description: String(error),
        variant: "destructive",
      });
    } finally {
      setLoading(false);
    }
  }

  const handleCancel = () => {
    if (onCancel) {
      onCancel();
    } else if (!inDialog) {
      router.push("/vendedores");
    }
  };

  const content = (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-6">
        <div className="grid grid-cols-1 gap-6 md:grid-cols-2">
          <FormField
            control={form.control}
            name="COD_VEN"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Código</FormLabel>
                <FormControl>
                  <Input
                    placeholder="V0001"
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
            name="NOM_VEN"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Nombre</FormLabel>
                <FormControl>
                  <Input placeholder="Nombre del vendedor" {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="APE_VEN"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Apellido</FormLabel>
                <FormControl>
                  <Input placeholder="Apellido del vendedor" {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="SUE_VEN"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Sueldo</FormLabel>
                <FormControl>
                  <Input type="number" placeholder="0.00" {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="FIN_VEN"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Fecha de Ingreso</FormLabel>
                <FormControl>
                  <Input type="date" {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="TIP_VEN"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Tipo</FormLabel>
                <Select
                  onValueChange={field.onChange}
                  defaultValue={field.value}
                  value={field.value}
                >
                  <FormControl>
                    <SelectTrigger>
                      <SelectValue placeholder="Seleccione un tipo" />
                    </SelectTrigger>
                  </FormControl>
                  <SelectContent>
                    <SelectItem value="1">SENIOR</SelectItem>
                    <SelectItem value="2">JUNIOR</SelectItem>
                  </SelectContent>
                </Select>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="COD_DIS"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Distrito</FormLabel>
                <Select
                  onValueChange={field.onChange}
                  defaultValue={field.value}
                  value={field.value}
                >
                  <FormControl>
                    <SelectTrigger>
                      <SelectValue placeholder="Seleccione un distrito" />
                    </SelectTrigger>
                  </FormControl>
                  <SelectContent>
                    {distritos.map((distrito) => (
                      <SelectItem
                        key={distrito.cod_dis}
                        value={distrito.cod_dis}
                      >
                        {distrito.nom_dis}
                      </SelectItem>
                    ))}
                  </SelectContent>
                </Select>
                <FormMessage />
              </FormItem>
            )}
          />
        </div>
        <div className="flex justify-end gap-2">
          <Button
            type="button"
            variant="outline"
            onClick={handleCancel}
            disabled={loading}
          >
            Cancelar
          </Button>
          <Button type="submit" disabled={loading}>
            {loading ? "Guardando..." : isEditing ? "Actualizar" : "Crear"}
          </Button>
        </div>
      </form>
    </Form>
  );

  if (inDialog) {
    return content;
  }

  return (
    <Card>
      <CardContent className="pt-6">{content}</CardContent>
    </Card>
  );
}
