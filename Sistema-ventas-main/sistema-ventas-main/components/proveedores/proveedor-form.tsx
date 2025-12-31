//este componente se ejecuta del lado del cliente
"use client";
//Importa elementos desde el componente react
import { useState, useEffect } from "react";
//Importa el elemento useRouter desde el componente navigwtion
import { useRouter } from "next/navigation";
//Importa el elemento zodResolver desde el componente zod
import { zodResolver } from "@hookform/resolvers/zod";
//Importa el elmento useForm desde el componente react-hook-form
import { useForm } from "react-hook-form";
//Importa los elementos de zod como z
import * as z from "zod";
//Componente reutilizable UI
import { Button } from "@/components/ui/button";
//Importa componentes del sistema de formularios
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
//Importa el campo de entrada del texto
import { Input } from "@/components/ui/input";
//Importa el elemento useToast desde el compoenente use-toast
import { useToast } from "@/components/ui/use-toast";
//Importa componente reutilisable de UI
import { Card, CardContent } from "@/components/ui/card";
//Importa componentes de seleccion
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
//Importa acciones para actualizar y crar proveedoresd desde proveedor-actions
import {
  crearProveedor,
  actualizarProveedor,
  type Proveedor,
} from "@/app/actions/proveedor-actions";
//Importa la accion de obtener registros desde distrito-actions
import { obtenerDistritos } from "@/app/actions/distrito-actions";

//Mensajes de advertencia al momanto de rellenar los campos para la incercion o edicion de clientes
const formSchema = z.object({
  COD_PRV: z.string().length(5, {
    message: "El código debe tener exactamente 5 caracteres",
  }),
  RSO_PRV: z
    .string()
    .min(2, {
      message: "La razón social debe tener al menos 2 caracteres",
    })
    .max(100, {
      message: "La razón social no puede tener más de 100 caracteres",
    }),
  DIR_PRV: z
    .string()
    .min(5, {
      message: "La dirección debe tener al menos 5 caracteres",
    })
    .max(200, {
      message: "La dirección no puede tener más de 200 caracteres",
    }),
  TEL_PRV: z
    .string()
    .min(6, {
      message: "El teléfono debe tener al menos 6 caracteres",
    })
    .max(20, {
      message: "El teléfono no puede tener más de 20 caracteres",
    }),
  COD_DIS: z.string().min(1, {
    message: "Debe seleccionar un distrito",
  }),
  REP_PRO: z
    .string()
    .min(2, {
      message: "El nombre del representante debe tener al menos 2 caracteres",
    })
    .max(100, {
      message:
        "El nombre del representante no puede tener más de 100 caracteres",
    }),
});

type ProveedorFormValues = z.infer<typeof formSchema>;
//Define las propiedades esperadas por el componente de ProveedorFormProps
interface ProveedorFormProps {
  initialData?: Proveedor; //datos iniciales
  isEditing?: boolean; //Si esta editado o creado
  inDialog?: boolean; //Si esta en dialogo
  onSuccess?: (data: ProveedorFormValues) => void;
  onCancel?: () => void;
}

export function ProveedorForm({
  initialData,
  isEditing = false,
  inDialog = false,
  onSuccess,
  onCancel,
}: ProveedorFormProps) {
  const router = useRouter();
  const { toast } = useToast();
  const [loading, setLoading] = useState(false);
  const [distritos, setDistritos] = useState<any[]>([]);

  // Asegurarse de que initialData tenga todos los campos necesarios
  const defaultValues: Partial<ProveedorFormValues> = {
    COD_PRV: initialData?.COD_PRV || "",
    RSO_PRV: initialData?.RSO_PRV || "",
    DIR_PRV: initialData?.DIR_PRV || "",
    TEL_PRV: initialData?.TEL_PRV || "",
    COD_DIS: initialData?.COD_DIS || "",
    REP_PRO: initialData?.REP_PRO || "",
  };

  console.log("Valores iniciales del formulario:", defaultValues);

  const form = useForm<ProveedorFormValues>({
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

  // Actualizar el formulario cuando cambian los datos iniciales
  useEffect(() => {
    if (initialData) {
      console.log("Actualizando formulario con datos:", initialData);
      form.reset({
        COD_PRV: initialData.COD_PRV,
        RSO_PRV: initialData.RSO_PRV,
        DIR_PRV: initialData.DIR_PRV,
        TEL_PRV: initialData.TEL_PRV,
        COD_DIS: initialData.COD_DIS,
        REP_PRO: initialData.REP_PRO,
      });
    }
  }, [initialData, form]);

  async function onSubmit(data: ProveedorFormValues) {
    try {
      setLoading(true);
      console.log("Enviando datos:", data);

      // Asegurarse de que todos los campos estén presentes
      const proveedorData: Proveedor = {
        COD_PRV: data.COD_PRV,
        RSO_PRV: data.RSO_PRV,
        DIR_PRV: data.DIR_PRV,
        TEL_PRV: data.TEL_PRV,
        COD_DIS: data.COD_DIS,
        REP_PRO: data.REP_PRO,
      };

      let result;
      if (isEditing) {
        result = await actualizarProveedor(proveedorData);
      } else {
        result = await crearProveedor(proveedorData);
      }

      if (!result.success) {
        throw new Error(String(result.error));
      }

      toast({
        title: isEditing ? "Proveedor actualizado" : "Proveedor creado",
        description: isEditing
          ? "El proveedor ha sido actualizado correctamente."
          : "El proveedor ha sido creado correctamente.",
      });

      if (onSuccess) {
        onSuccess(data);
      } else if (!inDialog) {
        router.push("/proveedores");
      }

      router.refresh();
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
      router.push("/proveedores");
    }
  };

  const content = (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-6">
        <div className="grid grid-cols-1 gap-6 md:grid-cols-2">
          <FormField
            control={form.control}
            name="COD_PRV"
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
            name="RSO_PRV"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Razón Social</FormLabel>
                <FormControl>
                  <Input placeholder="Nombre de la empresa" {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="DIR_PRV"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Dirección</FormLabel>
                <FormControl>
                  <Input placeholder="Dirección del proveedor" {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="TEL_PRV"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Teléfono</FormLabel>
                <FormControl>
                  <Input placeholder="Teléfono de contacto" {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="REP_PRO"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Representante</FormLabel>
                <FormControl>
                  <Input placeholder="Nombre del representante" {...field} />
                </FormControl>
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
                <Select onValueChange={field.onChange} value={field.value}>
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
