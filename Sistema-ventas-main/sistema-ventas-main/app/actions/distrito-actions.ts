"use server";

import { executeQuery, convertParams } from "@/lib/db"; // Utilidades para ejecutar consultas SQL y convertir parámetros.
import { revalidatePath } from "next/cache";

/*
* Interfaz Distrito
* Representa la estructura de un distrito en el sistema
*/
export interface Distrito {
  COD_DIS: string;
  NOM_DIS: string;
}
// Obtiene la lista de todos los distritos
export async function obtenerDistritos() {
  try {
    // Asegurarnos de no usar caché para esta consulta
    const result = await executeQuery(
      "SELECT * FROM DISTRITO ORDER BY NOM_DIS",
      [],
      false,
    );
    return { success: true, data: result.rows };
  } catch (error) {
    console.error("Error al obtener distritos:", error);
    return { success: false, error };
  }
}
// Obtiene la lista de todos los distritos
export async function obtenerDistrito(codigo: string) {
  try {
    const { query, params } = convertParams(
      "SELECT * FROM DISTRITO WHERE COD_DIS = :codigo",
      { codigo },
    );
    // No usar caché para esta consulta
    const result = await executeQuery(query, params, false);

    if (result.rows.length === 0) {
      return { success: false, error: "Distrito no encontrado" };
    }

    return { success: true, data: result.rows[0] };
  } catch (error) {
    console.error("Error al obtener distrito:", error);
    return { success: false, error: `Error al obtener distrito: ${error}` };
  }
}
// Crea un nuevo distrito en la base de datos
export async function crearDistrito(distrito: Distrito) {
  try {
    const { query, params } = convertParams(
      "INSERT INTO DISTRITO (COD_DIS, NOM_DIS) VALUES (:codigo, :nombre)",
      {
        codigo: distrito.COD_DIS,
        nombre: distrito.NOM_DIS,
      },
    );

    // Ejecutar la consulta y esperar a que se complete
    await executeQuery(query, params, false);

    // Verificar que el distrito se haya creado correctamente
    const checkResult = await obtenerDistrito(distrito.COD_DIS);
    if (!checkResult.success) {
      throw new Error("No se pudo verificar la creación del distrito");
    }

    // Revalidar la ruta para actualizar los datos
    revalidatePath("/distritos");

    // Forzar la revalidación de la caché global
    revalidatePath("/");

    return { success: true, data: checkResult.data };
  } catch (error) {
    console.error("Error al crear distrito:", error);
    return { success: false, error };
  }
}
// Actualiza los datos del distrito
export async function actualizarDistrito(distrito: Distrito) {
  try {
    // Primero verificamos si el distrito existe
    const checkResult = await obtenerDistrito(distrito.COD_DIS);
    if (!checkResult.success) {
      return { success: false, error: "Distrito no encontrado" };
    }

    const { query, params } = convertParams(
      "UPDATE DISTRITO SET NOM_DIS = :nombre WHERE COD_DIS = :codigo",
      {
        codigo: distrito.COD_DIS,
        nombre: distrito.NOM_DIS,
      },
    );

    // Ejecutar la consulta y esperar a que se complete
    await executeQuery(query, params, false);

    // Verificar que el distrito se haya actualizado correctamente
    const verifyResult = await obtenerDistrito(distrito.COD_DIS);
    if (
      !verifyResult.success ||
      verifyResult.data.nom_dis !== distrito.NOM_DIS
    ) {
      throw new Error("No se pudo verificar la actualización del distrito");
    }

    // Revalidar la ruta para actualizar los datos
    revalidatePath("/distritos");

    // Forzar la revalidación de la caché global
    revalidatePath("/");

    return { success: true, data: verifyResult.data };
  } catch (error) {
    console.error("Error al actualizar distrito:", error);
    return { success: false, error: `Error al actualizar distrito: ${error}` };
  }
}
// Elimina un distrito en específico según su código
export async function eliminarDistrito(codigo: string) {
  try {
    // Primero verificamos si el distrito existe
    const checkResult = await obtenerDistrito(codigo);
    if (!checkResult.success) {
      return { success: false, error: "Distrito no encontrado" };
    }

    const { query, params } = convertParams(
      "DELETE FROM DISTRITO WHERE COD_DIS = :codigo",
      { codigo },
    );

    // Ejecutar la consulta y esperar a que se complete
    await executeQuery(query, params, false);

    // Verificar que el distrito se haya eliminado correctamente
    const verifyResult = await obtenerDistrito(codigo);
    if (verifyResult.success) {
      throw new Error("El distrito no se eliminó correctamente");
    }

    // Revalidar la ruta para actualizar los datos
    revalidatePath("/distritos");

    // Forzar la revalidación de la caché global
    revalidatePath("/");

    return { success: true };
  } catch (error) {
    console.error("Error al eliminar distrito:", error);
    return { success: false, error: `Error al eliminar distrito: ${error}` };
  }
}
