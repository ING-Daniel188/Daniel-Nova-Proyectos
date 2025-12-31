"use server";

import { executeQuery, convertParams } from "@/lib/db"; // Utilidades para ejecutar consultas SQL y convertir parámetros.
import { revalidatePath } from "next/cache";
/** 
 * Interfaz Vendedor
 * Representa la estructura de un vendedor en el sistema
 */
export interface Vendedor {
  COD_VEN: string;
  NOM_VEN: string;
  APE_VEN: string;
  SUE_VEN: number;
  FIN_VEN: string;
  TIP_VEN: string;
  COD_DIS: string;
}
// Obtiene todos los vendedores de la base de datos
export async function obtenerVendedores() {
  try {
    const query = `
      SELECT v.*, d.NOM_DIS 
      FROM VENDEDOR v
      JOIN DISTRITO d ON v.COD_DIS = d.COD_DIS
      ORDER BY v.APE_VEN, v.NOM_VEN
    `;
    // Asegurarnos de no usar caché para esta consulta
    const result = await executeQuery(query, [], false);
    return { success: true, data: result.rows };
  } catch (error) {
    console.error("Error al obtener vendedores:", error);
    return { success: false, error };
  }
}
// Obtiene un vendedor especifico según su código
export async function obtenerVendedor(codigo: string) {
  try {
    const { query, params } = convertParams(
      `
      SELECT v.*, d.NOM_DIS 
      FROM VENDEDOR v
      JOIN DISTRITO d ON v.COD_DIS = d.COD_DIS
      WHERE v.COD_VEN = :codigo
      `,
      { codigo },
    );
    // No usar caché para esta consulta
    const result = await executeQuery(query, params, false);

    if (result.rows.length === 0) {
      return { success: false, error: "Vendedor no encontrado" };
    }

    return { success: true, data: result.rows[0] };
  } catch (error) {
    console.error("Error al obtener vendedor:", error);
    return { success: false, error };
  }
}
// Crea un nuevo vendedor
export async function crearVendedor(vendedor: Vendedor) {
  try {
    const { query, params } = convertParams(
      `
      INSERT INTO VENDEDOR (COD_VEN, NOM_VEN, APE_VEN, SUE_VEN, FIN_VEN, TIP_VEN, COD_DIS)
      VALUES (:codigo, :nombre, :apellido, :sueldo, :fechaIngreso, :tipo, :codigoDistrito)
      `,
      {
        codigo: vendedor.COD_VEN,
        nombre: vendedor.NOM_VEN,
        apellido: vendedor.APE_VEN,
        sueldo: vendedor.SUE_VEN,
        fechaIngreso: vendedor.FIN_VEN,
        tipo: vendedor.TIP_VEN,
        codigoDistrito: vendedor.COD_DIS,
      },
    );

    // Ejecutar la consulta y esperar a que se complete
    await executeQuery(query, params, false);

    // Verificar que el vendedor se haya creado correctamente
    const checkResult = await obtenerVendedor(vendedor.COD_VEN);
    if (!checkResult.success) {
      throw new Error("No se pudo verificar la creación del vendedor");
    }

    // Revalidar la ruta para actualizar los datos
    revalidatePath("/vendedores");

    // Forzar la revalidación de la caché global
    revalidatePath("/");

    return { success: true, data: checkResult.data };
  } catch (error) {
    console.error("Error al crear vendedor:", error);
    return { success: false, error };
  }
}
// Actualiza los datos de un vendedor
export async function actualizarVendedor(vendedor: Vendedor) {
  try {
    // Primero verificamos si el vendedor existe
    const checkResult = await obtenerVendedor(vendedor.COD_VEN);
    if (!checkResult.success) {
      return { success: false, error: "Vendedor no encontrado" };
    }

    const { query, params } = convertParams(
      `
      UPDATE VENDEDOR
      SET NOM_VEN = :nombre,
          APE_VEN = :apellido,
          SUE_VEN = :sueldo,
          FIN_VEN = :fechaIngreso,
          TIP_VEN = :tipo,
          COD_DIS = :codigoDistrito
      WHERE COD_VEN = :codigo
      `,
      {
        codigo: vendedor.COD_VEN,
        nombre: vendedor.NOM_VEN,
        apellido: vendedor.APE_VEN,
        sueldo: vendedor.SUE_VEN,
        fechaIngreso: vendedor.FIN_VEN,
        tipo: vendedor.TIP_VEN,
        codigoDistrito: vendedor.COD_DIS,
      },
    );

    // Ejecutar la consulta y esperar a que se complete
    await executeQuery(query, params, false);

    // Verificar que el vendedor se haya actualizado correctamente
    const verifyResult = await obtenerVendedor(vendedor.COD_VEN);
    if (!verifyResult.success) {
      throw new Error("No se pudo verificar la actualización del vendedor");
    }

    // Verificar que los datos se hayan actualizado correctamente
    const updatedData = verifyResult.data;
    if (
      updatedData.nom_ven !== vendedor.NOM_VEN ||
      updatedData.ape_ven !== vendedor.APE_VEN ||
      Number(updatedData.sue_ven) !== Number(vendedor.SUE_VEN) ||
      updatedData.tip_ven !== vendedor.TIP_VEN ||
      updatedData.cod_dis !== vendedor.COD_DIS
    ) {
      throw new Error("Los datos no se actualizaron correctamente");
    }

    // Revalidar la ruta para actualizar los datos
    revalidatePath("/vendedores");

    // Forzar la revalidación de la caché global
    revalidatePath("/");

    return { success: true, data: verifyResult.data };
  } catch (error) {
    console.error("Error al actualizar vendedor:", error);
    return { success: false, error };
  }
}
// Elimina un vendedor específico según su código
export async function eliminarVendedor(codigo: string) {
  try {
    // Primero verificamos si el vendedor existe
    const checkResult = await obtenerVendedor(codigo);
    if (!checkResult.success) {
      return { success: false, error: "Vendedor no encontrado" };
    }

    const { query, params } = convertParams(
      "DELETE FROM VENDEDOR WHERE COD_VEN = :codigo",
      { codigo },
    );

    // Ejecutar la consulta y esperar a que se complete
    await executeQuery(query, params, false);

    // Verificar que el vendedor se haya eliminado correctamente
    const verifyResult = await obtenerVendedor(codigo);
    if (verifyResult.success) {
      throw new Error("El vendedor no se eliminó correctamente");
    }

    // Revalidar la ruta para actualizar los datos
    revalidatePath("/vendedores");

    // Forzar la revalidación de la caché global
    revalidatePath("/");

    return { success: true };
  } catch (error) {
    console.error("Error al eliminar vendedor:", error);
    return { success: false, error };
  }
}
