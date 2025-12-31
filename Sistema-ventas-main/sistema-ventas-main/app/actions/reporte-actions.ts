"use server";

import { executeQuery } from "@/lib/db";
import { DateRange } from "react-day-picker";

/**
 * Obtiene auditorías filtradas por rango de fechas
 */
export async function obtenerAuditoriaPorFecha(
  dateRange: DateRange | undefined,
  pagina = 1,
  porPagina = 10,
) {
  try {
    let query = "SELECT * FROM AUDITORIA WHERE 1=1";
    const params: any[] = [];
    let paramIndex = 1;

    // Aplicar filtro de rango de fechas si está definido
    if (dateRange?.from) {
      // Formatear la fecha para que incluya el inicio del día
      const fromDate = new Date(dateRange.from);
      fromDate.setHours(0, 0, 0, 0);

      query += ` AND FECHA >= $${paramIndex++}`;
      params.push(fromDate.toISOString());

      if (dateRange.to) {
        // Formatear la fecha para que incluya el final del día
        const toDate = new Date(dateRange.to);
        toDate.setHours(23, 59, 59, 999);

        query += ` AND FECHA <= $${paramIndex++}`;
        params.push(toDate.toISOString());
      }
    }

    // Obtener el conteo total para la paginación
    const countQuery = query.replace("SELECT *", "SELECT COUNT(*) as total");
    const countResult = await executeQuery(countQuery, params);
    const total = Number.parseInt(countResult.rows[0].total);

    // Agregar ordenamiento y paginación
    query += " ORDER BY FECHA DESC, ID_AUDIT DESC";
    query += ` LIMIT $${paramIndex++} OFFSET $${paramIndex++}`;
    params.push(porPagina);
    params.push((pagina - 1) * porPagina);

    const result = await executeQuery(query, params);

    return {
      success: true,
      data: result.rows,
      pagination: {
        total,
        pagina,
        porPagina,
        totalPaginas: Math.ceil(total / porPagina),
      },
    };
  } catch (error) {
    console.error("Error al obtener auditorías por fecha:", error);
    return { success: false, error };
  }
}

/**
 * Obtiene los vendedores con ventas más bajas
 */
export async function obtenerVendedoresVentasBajas(limite: number = 5) {
  try {
    const query = `
      SELECT 
        v.COD_VEN,
        v.NOM_VEN || ' ' || v.APE_VEN as nombre_vendedor,
        v.SUE_VEN as sueldo,
        COALESCE(SUM(df.CAN_VEN * df.PRE_VEN), 0) as total_ventas,
        COUNT(DISTINCT f.NUM_FAC) as cantidad_facturas
      FROM 
        VENDEDOR v
      LEFT JOIN FACTURA f ON v.COD_VEN = f.COD_VEN
      LEFT JOIN DETALLE_FACTURA df ON f.NUM_FAC = df.NUM_FAC
      GROUP BY 
        v.COD_VEN, v.NOM_VEN, v.APE_VEN, v.SUE_VEN
      ORDER BY 
        total_ventas ASC
      LIMIT $1
    `;

    const result = await executeQuery(query, [limite]);

    return { success: true, data: result.rows };
  } catch (error) {
    console.error("Error al obtener vendedores con ventas bajas:", error);
    return { success: false, error };
  }
}