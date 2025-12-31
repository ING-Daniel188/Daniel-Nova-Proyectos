"use client"; // Indica que este componente se ejecuta del lado del cliente en Next.js
// Acciones del cliente y tipos
import {
  actualizarCliente,
  crearCliente,
  type Cliente,
} from "@/app/actions/cliente-actions";
// Acción para obtener los distritos desde el backend
import { obtenerDistritos } from "@/app/actions/distrito-actions";
// Componentes reutilizables de UI
import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
// Componentes del sistema de formularios
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
// Campo de entrada de texto
import { Input } from "@/components/ui/input";
// Componentes de selección
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
// Importa el elemento useToast del componente use-toast
import { useToast } from "@/components/ui/use-toast";
// Importa el elemento zodResolver del componente zod
import { zodResolver } from "@hookform/resolvers/zod";
// Importa el elemento useRouter del componente Navigation
import { useRouter } from "next/navigation";
// Importa elementos del componente react
import { useEffect, useState } from "react";
// Importa el elemento useForm del componente react-hook-form
import { useForm } from "react-hook-form";
// Importa todos los elementos del componente zod como z
import * as z from "zod";

// Mensajes de advertencia al momento de rellenar campos para inserción de clientes con el objetivo de cumplir con especificaciones
const formSchema = z.object({
  COD_CLI: z.string().length(5, {
    message: "El código debe tener exactamente 5 caracteres",
  }),
  RCO_CLI: z
    .string()
    .min(2, {
      message: "La razón comercial debe tener al menos 2 caracteres",
    })
    .max(50, {
      message: "La razón comercial no puede tener más de 50 caracteres",
    }),
  DIR_CLI: z
    .string()
    .min(5, {
      message: "La dirección debe tener al menos 5 caracteres",
    })
    .max(100, {
      message: "La dirección no puede tener más de 100 caracteres",
    }),
  TLF_CLI: z
    .string()
    .min(6, {
      message: "El teléfono debe tener al menos 6 caracteres",
    })
    .max(9, {
      message: "El teléfono no puede tener más de 9 caracteres",
    }),
  RUC_CLI: z
    .string()
    .min(8, {
      message: "El RUC/DNI debe tener al menos 8 caracteres (DNI)",
    })
    .max(11, {
      message: "El RUC/DNI no puede tener más de 11 caracteres (RUC)",
    }),
  COD_DIS: z.string().min(1, {
    message: "Debe seleccionar un distrito",
  }),
  FEC_REG: z.string().min(1, {
    message: "La fecha de registro es requerida",
  }),
  TIP_CLI: z.string().min(1, {
    message: "El tipo de cliente es requerido",
  }),
  CON_CLI: z
    .string()
    .min(2, {
      message: "El nombre del contacto debe tener al menos 2 caracteres",
    })
    .max(30, {
      message: "El nombre del contacto no puede tener más de 30 caracteres",
    }),
});

type ClienteFormValues = z.infer<typeof formSchema>;
// Define las propiedades esperadas por el componente ClienteForm
interface ClienteFormProps {
  readonly initialData?: Cliente; // Datos iniciales
  readonly isEditing?: boolean; // Si se está editando o creando
  readonly inDialog?: boolean; // Si está en un diálogo
  readonly onSuccess?: (data: ClienteFormValues) => void;
  readonly onCancel?: () => void;
}
/**
 * Componente ClienteForm
 * Formulario para crear o editar clientes.
 */
export function ClienteForm({
  initialData,
  isEditing = false,
  inDialog = false,
  onSuccess,
  onCancel,
}: ClienteFormProps) {
  const router = useRouter();
  const { toast } = useToast();
  const [loading, setLoading] = useState(false);
  const [distritos, setDistritos] = useState<any[]>([]);

  // Helper para normalizar el tipo de cliente
  const normalizarTipoCliente = (tipo: any): string => {
    if (tipo === 1 || tipo === "1" || tipo === "PERSONA") return "PERSONA";
    if (tipo === 2 || tipo === "2" || tipo === "EMPRESA") return "EMPRESA";
    return tipo || "";
  };

  // Format date for input
  const formatDateForInput = (dateString: string) => {
    const date = new Date(dateString);
    return date.toISOString().split("T")[0];
  };

  // Valores por defecto del formulario
  const defaultValues: Partial<ClienteFormValues> = {
    COD_CLI: initialData?.COD_CLI ?? "",
    RCO_CLI: initialData?.RCO_CLI ?? "",
    DIR_CLI: initialData?.DIR_CLI ?? "",
    TLF_CLI: initialData?.TLF_CLI ?? "",
    RUC_CLI: initialData?.RUC_CLI ?? "",
    COD_DIS: initialData?.COD_DIS ?? "",
    FEC_REG: initialData?.FEC_REG
      ? formatDateForInput(initialData.FEC_REG)
      : formatDateForInput(new Date().toISOString()),
    TIP_CLI: normalizarTipoCliente(initialData?.TIP_CLI),
    CON_CLI: initialData?.CON_CLI ?? "",
  };

  const form = useForm<ClienteFormValues>({
    resolver: zodResolver(formSchema),
    defaultValues,
  });

  // Resetear el formulario cuando cambie initialData
  useEffect(() => {
    if (initialData) {
      const formData = {
        COD_CLI: initialData.COD_CLI ?? "",
        RCO_CLI: initialData.RCO_CLI ?? "",
        DIR_CLI: initialData.DIR_CLI ?? "",
        TLF_CLI: initialData.TLF_CLI ?? "",
        RUC_CLI: initialData.RUC_CLI ?? "",
        COD_DIS: initialData.COD_DIS ?? "",
        FEC_REG: initialData.FEC_REG
          ? formatDateForInput(initialData.FEC_REG)
          : formatDateForInput(new Date().toISOString()),
        TIP_CLI: normalizarTipoCliente(initialData.TIP_CLI),
        CON_CLI: initialData.CON_CLI ?? "",
      };
      form.reset(formData);
    }
  }, [initialData, form]);

  useEffect(() => {
    const fetchDistritos = async () => {
      const result = await obtenerDistritos();
      if (result.success) {
        setDistritos(result.data);
      }
    };

    fetchDistritos();
  }, []);

  async function onSubmit(data: ClienteFormValues) {
    try {
      setLoading(true);

      let result;
      if (isEditing) {
        result = await actualizarCliente(data);
      } else {
        result = await crearCliente(data);
      }

      if (!result.success) {
        throw new Error(String(result.error));
      }

      // Esperar un momento para asegurar que la base de datos se ha actualizado
      await new Promise((resolve) => setTimeout(resolve, 300));

      if (onSuccess) {
        // Pasar los datos actualizados inmediatamente
        onSuccess(data);
      } else {
        toast({
          title: isEditing ? "Cliente actualizado" : "Cliente creado",
          description: isEditing
            ? "El cliente ha sido actualizado correctamente."
            : "El cliente ha sido creado correctamente.",
        });

        router.push("/clientes");
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
      router.push("/clientes");
    }
  };

  const formContent = (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-6">
        <div className="grid grid-cols-1 gap-6 md:grid-cols-2">
          <FormField
            control={form.control}
            name="COD_CLI"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Código</FormLabel>
                <FormControl>
                  <Input
                    placeholder="C0001"
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
            name="RCO_CLI"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Razón Comercial</FormLabel>
                <FormControl>
                  <Input
                    placeholder="Nombre de la empresa o persona"
                    {...field}
                  />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="DIR_CLI"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Dirección</FormLabel>
                <FormControl>
                  <Input
                    placeholder="Dirección del cliente"
                    maxLength={100}
                    {...field}
                  />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="TLF_CLI"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Teléfono</FormLabel>
                <FormControl>
                  <Input
                    placeholder="Teléfono de contacto"
                    maxLength={9}
                    {...field}
                  />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="RUC_CLI"
            render={({ field }) => (
              <FormItem>
                <FormLabel>RUC/DNI</FormLabel>
                <FormControl>
                  <Input placeholder="Número de RUC o DNI" {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="CON_CLI"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Contacto</FormLabel>
                <FormControl>
                  <Input
                    placeholder="Nombre de la persona de contacto"
                    maxLength={30}
                    {...field}
                  />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="FEC_REG"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Fecha de Registro</FormLabel>
                <FormControl>
                  <Input type="date" {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="TIP_CLI"
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
                    <SelectItem value="EMPRESA">EMPRESA</SelectItem>
                    <SelectItem value="PERSONA">PERSONA</SelectItem>
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
    return formContent;
  }

  return (
    <Card>
      <CardContent className="pt-6">{formContent}</CardContent>
    </Card>
  );
}
