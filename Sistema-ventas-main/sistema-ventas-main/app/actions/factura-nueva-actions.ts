"use server";

import { executeQuery, convertParams } from "@/lib/db"; // Utilidades para ejecutar consultas SQL y convertir parámetros.
import { revalidatePath } from "next/cache";

/**
 * Interfaz `FacturaNueva`
 *
 * Representa la estructura de una nueva factura en el sistema.
 */
export interface FacturaNueva {
  NUM_FAC: string;
  FEC_FAC: string;
  COD_CLI: string;
  EST_FAC: string;
  COD_VEN: string;
  POR_IGV: number;
}
/**
 * Interfaz `DetalleFacturaNuevo`
 *
 * Representa la estructura de un detalle de factura (línea de productos) en el sistema.
 */
export interface DetalleFacturaNuevo {
  NUM_FAC: string;
  COD_PRO: string;
  CAN_VEN: number;
  PRE_VEN: number;
}
// Crea una nueva factura, garantizando que la información sea insertada correctamente en la base de datos
export async function crearFactura(
  factura: FacturaNueva,
  detalles: DetalleFacturaNuevo[],
) {
  try {
    // Start transaction
    await executeQuery("BEGIN");

    // Insert factura
    const { query, params } = convertParams(
      `
      INSERT INTO FACTURA (NUM_FAC, FEC_FAC, COD_CLI, EST_FAC, COD_VEN, POR_IGV)
      VALUES (:numFac, :fechaFac, :codCli, :estado, :codVen, :porIgv)
      `,
      {
        numFac: factura.NUM_FAC,
        fechaFac: factura.FEC_FAC,
        codCli: factura.COD_CLI,
        estado: factura.EST_FAC,
        codVen: factura.COD_VEN,
        porIgv: factura.POR_IGV,
      },
    );

    await executeQuery(query, params);

    // Insert detalles
    for (const detalle of detalles) {
      const { query: detalleQuery, params: detalleParams } = convertParams(
        `
        INSERT INTO DETALLE_FACTURA (NUM_FAC, COD_PRO, CAN_VEN, PRE_VEN)
        VALUES (:numFac, :codPro, :cantidad, :precio)
        `,
        {
          numFac: detalle.NUM_FAC,
          codPro: detalle.COD_PRO,
          cantidad: detalle.CAN_VEN,
          precio: detalle.PRE_VEN,
        },
      );

      await executeQuery(detalleQuery, detalleParams);
    }

    // Commit transaction
    await executeQuery("COMMIT");

    revalidatePath("/facturas");
    return { success: true };
  } catch (error) {
    // Rollback transaction
    await executeQuery("ROLLBACK");
    console.error("Error al crear factura:", error);
    return { success: false, error };
  }
}
