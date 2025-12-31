//Indica que se ejecuta del lado del cliente
"use client";
/**
 *Importa el elemento eseState desde el componente react
 */
import { useState } from "react";
/**
 *Importa el elemento useRoutes desde el componente navigation
 */
import { useRouter } from "next/navigation";
/**
 *Importa el elemento zodResolver desde el componente zod
 */
import { zodResolver } from "@hookform/resolvers/zod";
/*
 *Importa el elemento useForm desde el componente react-hook-form
 */
import { useForm } from "react-hook-form";
/**
 *Importa todos los elementos de zod como z
 */
import * as z from "zod";
/**
 *Importa el elemento Button del componente button
 */
import { Button } from "@/components/ui/button";
/**
 *Importa elementos desde el componente form
 */
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
/**
 *Importa el elemento Input desde el componente input
 */
import { Input } from "@/components/ui/input";
/**
 *Importa el elemento useToast desde el componente use-toast
 */
import { useToast } from "@/components/ui/use-toast";
/**
 *Importa los elementos Card y CardContent desde el componente card
 */
import { Card, CardContent } from "@/components/ui/card";
/**
 *Importa elementos desde el componente distrito-actions
 */
import {
  crearDistrito,
  actualizarDistrito,
  type Distrito,
} from "@/app/actions/distrito-actions";
/**
 *Se crean mensajes de advertencia a la hora de rellenar campos para que cumplan con las especificaciones
 */
const formSchema = z.object({
  COD_DIS: z.string().length(5, {
    message: "El código debe tener exactamente 5 caracteres",
  }),
  NOM_DIS: z
    .string()
    .min(2, {
      message: "El nombre debe tener al menos 2 caracteres",
    })
    .max(50, {
      message: "El nombre no puede tener más de 50 caracteres",
    }),
});
/**
 *Define propiedades espradas por el componente DistritoForm
 */
type DistritoFormValues = z.infer<typeof formSchema>;

interface DistritoFormProps {
  initialData?: Distrito;
  isEditing?: boolean;
  inDialog?: boolean;
  onSuccess?: (data: DistritoFormValues) => void;
  onCancel?: () => void;
}
/**
 *Llama la función distrito form creando el formulario para que el usuario lo llene
 */
export function DistritoForm({
  initialData,
  isEditing = false,
  inDialog = false,
  onSuccess,
  onCancel,
}: DistritoFormProps) {
  const router = useRouter();
  const { toast } = useToast();
  const [loading, setLoading] = useState(false);

  const defaultValues: Partial<DistritoFormValues> = {
    COD_DIS: initialData?.COD_DIS || "",
    NOM_DIS: initialData?.NOM_DIS || "",
  };

  const form = useForm<DistritoFormValues>({
    resolver: zodResolver(formSchema),
    defaultValues,
  });

  async function onSubmit(data: DistritoFormValues) {
    try {
      setLoading(true);

      let result;
      if (isEditing) {
        result = await actualizarDistrito(data);
      } else {
        result = await crearDistrito(data);
      }

      if (!result.success) {
        throw new Error(String(result.error));
      }

      // Esperar un momento para asegurar que la base de datos se ha actualizado
      await new Promise((resolve) => setTimeout(resolve, 300));

      if (onSuccess) {
        onSuccess(data);
      } else {
        toast({
          title: isEditing ? "Distrito actualizado" : "Distrito creado",
          description: isEditing
            ? "El distrito ha sido actualizado correctamente."
            : "El distrito ha sido creado correctamente.",
        });

        router.push("/distritos");
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
      router.push("/distritos");
    }
  };

  const formContent = (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-6">
        <FormField
          control={form.control}
          name="COD_DIS"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Código</FormLabel>
              <FormControl>
                <Input
                  placeholder="D0001"
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
          name="NOM_DIS"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Nombre</FormLabel>
              <FormControl>
                <Input
                  placeholder="Nombre del distrito"
                  {...field}
                  maxLength={50}
                />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
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
