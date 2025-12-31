"use server";

import { executeQuery, convertParams } from "@/lib/db"; // Utilidades para ejecutar consultas SQL y convertir parámetros.
import { revalidatePath } from "next/cache";
/*
* Interfaz Cliente
* Representa la estructura de un cliente en el sistema
*/
export interface Cliente {
  COD_CLI: string;
  RCO_CLI: string;
  DIR_CLI: string;
  TLF_CLI: string;
  RUC_CLI: string;
  COD_DIS: string;
  FEC_REG: string;
  TIP_CLI: string;
  CON_CLI: string;
}
// Obtiene la lista de todos los clientes
export async function obtenerClientes() {
  try {
    const query = `
      SELECT c.*, d.NOM_DIS 
      FROM CLIENTE c
      JOIN DISTRITO d ON c.COD_DIS = d.COD_DIS
      ORDER BY c.RCO_CLI
    `;
    const result = await executeQuery(query);
    return { success: true, data: result.rows };
  } catch (error) {
    console.error("Error al obtener clientes:", error);
    return { success: false, error };
  }
}
// Obtiene un cliente específico por su código
export async function obtenerCliente(codigo: string) {
  try {
    const { query, params } = convertParams(
      `
      SELECT c.*, d.NOM_DIS 
      FROM CLIENTE c
      JOIN DISTRITO d ON c.COD_DIS = d.COD_DIS
      WHERE c.COD_CLI = :codigo
      `,
      { codigo },
    );
    const result = await executeQuery(query, params);

    if (result.rows.length === 0) {
      return { success: false, error: "Cliente no encontrado" };
    }

    return { success: true, data: result.rows[0] };
  } catch (error) {
    console.error("Error al obtener cliente:", error);
    return { success: false, error };
  }
}
// Crea un nuevo cliente en la base de datos
export async function crearCliente(cliente: Cliente) {
  try {
    const { query, params } = convertParams(
      `
      INSERT INTO CLIENTE (COD_CLI, RCO_CLI, DIR_CLI, TLF_CLI, RUC_CLI, COD_DIS, FEC_REG, TIP_CLI, CON_CLI)
      VALUES (:codigo, :razonComercial, :direccion, :telefono, :ruc, :codigoDistrito, :fechaRegistro, :tipo, :contacto)
      `,
      {
        codigo: cliente.COD_CLI,
        razonComercial: cliente.RCO_CLI,
        direccion: cliente.DIR_CLI,
        telefono: cliente.TLF_CLI,
        ruc: cliente.RUC_CLI,
        codigoDistrito: cliente.COD_DIS,
        fechaRegistro: cliente.FEC_REG,
        tipo: cliente.TIP_CLI,
        contacto: cliente.CON_CLI,
      },
    );

    await executeQuery(query, params);
    revalidatePath("/clientes");
    return { success: true };
  } catch (error) {
    console.error("Error al crear cliente:", error);
    return { success: false, error };
  }
}
// Actualiza los datos del cliente
export async function actualizarCliente(cliente: Cliente) {
  try {
    const { query, params } = convertParams(
      `
      UPDATE CLIENTE
      SET RCO_CLI = :razonComercial,
          DIR_CLI = :direccion,
          TLF_CLI = :telefono,
          RUC_CLI = :ruc,
          COD_DIS = :codigoDistrito,
          FEC_REG = :fechaRegistro,
          TIP_CLI = :tipo,
          CON_CLI = :contacto
      WHERE COD_CLI = :codigo
      `,
      {
        codigo: cliente.COD_CLI,
        razonComercial: cliente.RCO_CLI,
        direccion: cliente.DIR_CLI,
        telefono: cliente.TLF_CLI,
        ruc: cliente.RUC_CLI,
        codigoDistrito: cliente.COD_DIS,
        fechaRegistro: cliente.FEC_REG,
        tipo: cliente.TIP_CLI,
        contacto: cliente.CON_CLI,
      },
    );

    const result = await executeQuery(query, params);

    if (result.rowCount === 0) {
      return { success: false, error: "Cliente no encontrado" };
    }

    revalidatePath("/clientes");
    return { success: true };
  } catch (error) {
    console.error("Error al actualizar cliente:", error);
    return { success: false, error };
  }
}
// Elimina un cliente en específico según su código
export async function eliminarCliente(codigo: string) {
  try {
    const { query, params } = convertParams(
      "DELETE FROM CLIENTE WHERE COD_CLI = :codigo",
      { codigo },
    );

    const result = await executeQuery(query, params);

    if (result.rowCount === 0) {
      return { success: false, error: "Cliente no encontrado" };
    }

    revalidatePath("/clientes");
    return { success: true };
  } catch (error) {
    console.error("Error al eliminar cliente:", error);
    return { success: false, error };
  }
}
