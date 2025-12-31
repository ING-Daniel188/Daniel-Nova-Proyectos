//Este componente se ejecuta del lado del servidor
"use server";
//Importa la funcion executeQuery y converParamsdesde el componente db
import { executeQuery, convertParams } from "@/lib/db";
//Importa la funcion revalidatePath desde el componente cache
import { revalidatePath } from "next/cache";
//Se crea una interfaz para reprecentar el objeto Proveedor
export interface Proveedor {
  COD_PRV: string;
  RSO_PRV: string;
  DIR_PRV: string;
  TEL_PRV: string;
  COD_DIS: string;
  REP_PRO: string;
}
//Funcion para obtener la información de los proveedores
export async function obtenerProveedores() {
  try {
    const query = `
      SELECT p.*, d.NOM_DIS 
      FROM PROVEEDOR p
      JOIN DISTRITO d ON p.COD_DIS = d.COD_DIS
      ORDER BY p.RSO_PRV
    `;
    // Asegurarnos de no usar caché para esta consulta
    const result = await executeQuery(query, [], false);
    return { success: true, data: result.rows };
  } catch (error) {
    console.error("Error al obtener proveedores:", error);
    return { success: false, error: String(error) };
  }
}
//Funcion para obtener la información de un proveedor por el codigo de proveedor
export async function obtenerProveedor(codigo: string) {
  try {
    const { query, params } = convertParams(
      `
      SELECT p.*, d.NOM_DIS 
      FROM PROVEEDOR p
      JOIN DISTRITO d ON p.COD_DIS = d.COD_DIS
      WHERE p.COD_PRV = :codigo
      `,
      { codigo },
    );
    // No usar caché para esta consulta
    const result = await executeQuery(query, params, false);

    if (result.rows.length === 0) {
      return { success: false, error: "Proveedor no encontrado" };
    }

    return { success: true, data: result.rows[0] };
  } catch (error) {
    console.error("Error al obtener proveedor:", error);
    return { success: false, error: String(error) };
  }
}
//Función para crear un proveedor
export async function crearProveedor(proveedor: Proveedor) {
  try {
    const { query, params } = convertParams(
      `
      INSERT INTO PROVEEDOR (COD_PRV, RSO_PRV, DIR_PRV, TEL_PRV, COD_DIS, REP_PRO)
      VALUES (:codigo, :razonSocial, :direccion, :telefono, :codigoDistrito, :representante)
      `,
      {
        codigo: proveedor.COD_PRV,
        razonSocial: proveedor.RSO_PRV,
        direccion: proveedor.DIR_PRV,
        telefono: proveedor.TEL_PRV,
        codigoDistrito: proveedor.COD_DIS,
        representante: proveedor.REP_PRO,
      },
    );

    // Ejecutar la consulta y esperar a que se complete
    await executeQuery(query, params, false);

    // Verificar que el proveedor se haya creado correctamente
    const checkResult = await obtenerProveedor(proveedor.COD_PRV);
    if (!checkResult.success) {
      throw new Error("No se pudo verificar la creación del proveedor");
    }

    // Revalidar la ruta para actualizar los datos
    revalidatePath("/proveedores");

    // Forzar la revalidación de la caché global
    revalidatePath("/");

    return { success: true, data: checkResult.data };
  } catch (error) {
    console.error("Error al crear proveedor:", error);
    return { success: false, error: String(error) };
  }
}
//Función para actualizar un proveedor
export async function actualizarProveedor(proveedor: Proveedor) {
  try {
    // Primero verificamos si el proveedor existe
    const checkResult = await obtenerProveedor(proveedor.COD_PRV);
    if (!checkResult.success) {
      return { success: false, error: "Proveedor no encontrado" };
    }

    const { query, params } = convertParams(
      `
      UPDATE PROVEEDOR
      SET RSO_PRV = :razonSocial,
          DIR_PRV = :direccion,
          TEL_PRV = :telefono,
          COD_DIS = :codigoDistrito,
          REP_PRO = :representante
      WHERE COD_PRV = :codigo
      `,
      {
        codigo: proveedor.COD_PRV,
        razonSocial: proveedor.RSO_PRV,
        direccion: proveedor.DIR_PRV,
        telefono: proveedor.TEL_PRV,
        codigoDistrito: proveedor.COD_DIS,
        representante: proveedor.REP_PRO,
      },
    );

    // Ejecutar la consulta y esperar a que se complete
    await executeQuery(query, params, false);

    // Verificar que el proveedor se haya actualizado correctamente
    const verifyResult = await obtenerProveedor(proveedor.COD_PRV);
    if (!verifyResult.success) {
      throw new Error("No se pudo verificar la actualización del proveedor");
    }

    // Verificar que los datos se hayan actualizado correctamente
    const updatedData = verifyResult.data;
    if (
      updatedData.rso_prv !== proveedor.RSO_PRV ||
      updatedData.dir_prv !== proveedor.DIR_PRV ||
      updatedData.tel_prv !== proveedor.TEL_PRV ||
      updatedData.cod_dis !== proveedor.COD_DIS ||
      updatedData.rep_pro !== proveedor.REP_PRO
    ) {
      throw new Error("Los datos no se actualizaron correctamente");
    }

    // Revalidar la ruta para actualizar los datos
    revalidatePath("/proveedores");

    // Forzar la revalidación de la caché global
    revalidatePath("/");

    return { success: true, data: verifyResult.data };
  } catch (error) {
    console.error("Error al actualizar proveedor:", error);
    return { success: false, error: String(error) };
  }
}
//Funcion para eliminar un proveedor segun el codigo de proveedor
export async function eliminarProveedor(codigo: string) {
  try {
    // Primero verificamos si el proveedor existe
    const checkResult = await obtenerProveedor(codigo);
    if (!checkResult.success) {
      return { success: false, error: "Proveedor no encontrado" };
    }

    const { query, params } = convertParams(
      "DELETE FROM PROVEEDOR WHERE COD_PRV = :codigo",
      { codigo },
    );

    // Ejecutar la consulta y esperar a que se complete
    await executeQuery(query, params, false);

    // Verificar que el proveedor se haya eliminado correctamente
    const verifyResult = await obtenerProveedor(codigo);
    if (verifyResult.success) {
      throw new Error("El proveedor no se eliminó correctamente");
    }

    // Revalidar la ruta para actualizar los datos
    revalidatePath("/proveedores");

    // Forzar la revalidación de la caché global
    revalidatePath("/");

    return { success: true };
  } catch (error) {
    console.error("Error al eliminar proveedor:", error);
    return { success: false, error: String(error) };
  }
}
