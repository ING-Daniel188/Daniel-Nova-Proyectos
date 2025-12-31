"use server";

import { convertParams, executeQuery } from "@/lib/db"; // Utilidades para ejecutar consultas SQL y convertir parámetros.
import { revalidatePath } from "next/cache";

/**
 * Interfaz `OrdenCompra`
 *
 * Representa la estructura de una nueva orden de compra en el sistema.
 */
export interface OrdenCompra {
  NUM_OCO: string;
  FEC_OCO: string;
  COD_PRV: string;
  FAT_OCO?: string | null;
  EST_OCO: string;
}
/**
 * Interfaz `DetalleCompra`
 *
 * Representa la estructura de un detalle de orden de compra (línea de productos) en el sistema.
 */
export interface DetalleCompra {
  NUM_OCO: string;
  COD_PRO: string;
  CAN_DET: number;
}
// Obtiene todas las órdenes de compra registradas en el sistema
export async function obtenerOrdenesCompra() {
  try {
    const query = `
      SELECT o.*, p.RSO_PRV as PROVEEDOR
      FROM ORDEN_COMPRA o
      JOIN PROVEEDOR p ON o.COD_PRV = p.COD_PRV
      ORDER BY o.FEC_OCO DESC
    `;
    const result = await executeQuery(query, [], false);
    return { success: true, data: result.rows };
  } catch (error) {
    console.error("Error al obtener órdenes de compra:", error);
    return { success: false, error };
  }
}
// Obtiene una orden de compra específica según su código
export async function obtenerOrdenCompra(numOco: string) {
  try {
    // Get orden de compra
    const { query, params } = convertParams(
      `
      SELECT o.*, p.RSO_PRV as PROVEEDOR
      FROM ORDEN_COMPRA o
      JOIN PROVEEDOR p ON o.COD_PRV = p.COD_PRV
      WHERE o.NUM_OCO = :numOco
      `,
      { numOco },
    );
    const ordenResult = await executeQuery(query, params, false);

    if (ordenResult.rows.length === 0) {
      return { success: false, error: "Orden de compra no encontrada" };
    }

    const orden = ordenResult.rows[0];

    // Get detalles
    const { query: detallesQuery, params: detallesParams } = convertParams(
      `
      SELECT d.*, p.DES_PRO, p.PRE_PRO
      FROM DETALLE_COMPRA d
      JOIN PRODUCTO p ON d.COD_PRO = p.COD_PRO
      WHERE d.NUM_OCO = :numOco
      `,
      { numOco },
    );

    const detallesResult = await executeQuery(
      detallesQuery,
      detallesParams,
      false,
    );
    const detalles = detallesResult.rows;

    return {
      success: true,
      data: {
        ...orden,
        DETALLES: detalles,
      },
    };
  } catch (error) {
    console.error("Error al obtener orden de compra:", error);
    return { success: false, error };
  }
}
// Crea una nueva orden de compra
export async function crearOrdenCompra(
  orden: OrdenCompra,
  detalles: DetalleCompra[],
) {
  try {
    // Start transaction
    await executeQuery("BEGIN");

    // Insert orden de compra
    const { query, params } = convertParams(
      `
      INSERT INTO ORDEN_COMPRA (NUM_OCO, FEC_OCO, COD_PRV, FAT_OCO, EST_OCO)
      VALUES (:numOco, :fechaOco, :codPrv, :fechaAtencion, :estado)
      `,
      {
        numOco: orden.NUM_OCO,
        fechaOco: orden.FEC_OCO,
        codPrv: orden.COD_PRV,
        fechaAtencion: orden.FAT_OCO,
        estado: orden.EST_OCO,
      },
    );

    await executeQuery(query, params);

    // Insert detalles
    for (const detalle of detalles) {
      const { query: detalleQuery, params: detalleParams } = convertParams(
        `
        INSERT INTO DETALLE_COMPRA (NUM_OCO, COD_PRO, CAN_DET)
        VALUES (:numOco, :codPro, :cantidad)
        `,
        {
          numOco: detalle.NUM_OCO,
          codPro: detalle.COD_PRO,
          cantidad: detalle.CAN_DET,
        },
      );

      await executeQuery(detalleQuery, detalleParams);
    }

    // Commit transaction
    await executeQuery("COMMIT");

    revalidatePath("/ordenes-compra");
    revalidatePath("/");
    return { success: true };
  } catch (error) {
    // Rollback transaction
    await executeQuery("ROLLBACK");
    console.error("Error al crear orden de compra:", error);
    return { success: false, error };
  }
}
// Actualiza el estado de una orden de compra
export async function actualizarEstadoOrdenCompra(
  numOco: string,
  estado: string,
  fechaAtencion?: string,
) {
  try {
    let query, params;

    if (fechaAtencion) {
      ({ query, params } = convertParams(
        `
        UPDATE ORDEN_COMPRA
        SET EST_OCO = :estado, FAT_OCO = :fechaAtencion
        WHERE NUM_OCO = :numOco
        `,
        {
          numOco,
          estado,
          fechaAtencion,
        },
      ));
    } else {
      ({ query, params } = convertParams(
        `
        UPDATE ORDEN_COMPRA
        SET EST_OCO = :estado
        WHERE NUM_OCO = :numOco
        `,
        {
          numOco,
          estado,
        },
      ));
    }

    const result = await executeQuery(query, params);

    if (result.rowCount === 0) {
      return { success: false, error: "Orden de compra no encontrada" };
    }

    // If the order is completed, update product stock
    if (estado === "2") {
      // Get order details
      const { query: detallesQuery, params: detallesParams } = convertParams(
        `
        SELECT * FROM DETALLE_COMPRA
        WHERE NUM_OCO = :numOco
        `,
        { numOco },
      );

      const detallesResult = await executeQuery(detallesQuery, detallesParams);
      const detalles = detallesResult.rows;

      // Update stock for each product
      for (const detalle of detalles) {
        await executeQuery(`CALL sp_restock_producto($1, $2)`, [
          detalle.cod_pro,
          detalle.can_det,
        ]);
      }
    }

    revalidatePath("/ordenes-compra");
    revalidatePath("/");
    return { success: true };
  } catch (error) {
    console.error("Error al actualizar estado de orden de compra:", error);
    return { success: false, error };
  }
}
// Elimina una orden de compra
export async function eliminarOrdenCompra(numOco: string) {
  try {
    // Start transaction
    await executeQuery("BEGIN");

    // Delete detalles
    const { query: detallesQuery, params: detallesParams } = convertParams(
      "DELETE FROM DETALLE_COMPRA WHERE NUM_OCO = :numOco",
      { numOco },
    );
    await executeQuery(detallesQuery, detallesParams, false);

    // Delete orden
    const { query, params } = convertParams(
      "DELETE FROM ORDEN_COMPRA WHERE NUM_OCO = :numOco",
      { numOco },
    );
    const result = await executeQuery(query, params, false);

    if (result.rowCount === 0) {
      // Rollback transaction
      await executeQuery("ROLLBACK");
      return { success: false, error: "Orden de compra no encontrada" };
    }

    // Commit transaction
    await executeQuery("COMMIT");

    revalidatePath("/ordenes-compra");
    revalidatePath("/");
    return { success: true };
  } catch (error) {
    // Rollback transaction
    await executeQuery("ROLLBACK");
    console.error("Error al eliminar orden de compra:", error);
    return { success: false, error };
  }
}
