//Importa la función clsx y el tipo ClassValue desde clsx
import { clsx, type ClassValue } from "clsx";
//Impoprta la función twMerge desde tailwind-merge 
import { twMerge } from "tailwind-merge";
//Funcion para combinar nombres de clase CSS para resolver conflictos entre clases de Tailwind CSS
export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs));
}
