//Este componente se ejecuta del lado del servidor
"use server";
//Importa la funcion executeQuery desde el componente db
import { executeQuery } from "@/lib/db";
//Se crea una interfaz para reprecentar el objeto Auditoria
export interface Auditoria {
  id_audit: number;
  tabla: string;
  operacion: string;
  usuario: string;
  fecha: string;
  datos_antiguos: any;
  datos_nuevos: any;
}
//Funcion para obtener la informacion de auditorias
export async function obtenerAuditorias(
  filtroTabla?: string,
  filtroOperacion?: string,
  busqueda?: string,
  pagina = 1,
  porPagina = 10,
) {
  try {
    let query = "SELECT * FROM AUDITORIA WHERE 1=1";
    const params: any[] = [];
    let paramIndex = 1;

    if (filtroTabla && filtroTabla !== "ALL") {
      query += ` AND TABLA = $${paramIndex++}`;
      params.push(filtroTabla);
    }

    if (filtroOperacion && filtroOperacion !== "ALL") {
      query += ` AND OPERACION = $${paramIndex++}`;
      params.push(filtroOperacion);
    }

    if (busqueda) {
      query += ` AND (
        TABLA ILIKE $${paramIndex} OR
        OPERACION ILIKE $${paramIndex} OR
        USUARIO ILIKE $${paramIndex} OR
        CAST(DATOS_ANTIGUOS AS TEXT) ILIKE $${paramIndex} OR
        CAST(DATOS_NUEVOS AS TEXT) ILIKE $${paramIndex}
      )`;
      params.push(`%${busqueda}%`);
      paramIndex++;
    }

    // Get total count
    const countQuery = query.replace("SELECT *", "SELECT COUNT(*) as total");
    const countResult = await executeQuery(countQuery, params);
    const total = Number.parseInt(countResult.rows[0].total);

    // Add order and pagination
    query += " ORDER BY ID_AUDIT DESC";
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
    console.error("Error al obtener auditorías:", error);
    return { success: false, error };
  }
}
//Funcion para obtener tablas de auditorias
export async function obtenerTablas() {
  try {
    const query = `
      SELECT DISTINCT TABLA as tabla
      FROM AUDITORIA
      ORDER BY TABLA
    `;
    const result = await executeQuery(query);
    return { success: true, data: result.rows };
  } catch (error) {
    console.error("Error al obtener tablas:", error);
    return { success: false, error };
  }
}
//Funcion que selecciona las operaciones de la tabla auditoria
export async function obtenerOperaciones() {
  try {
    const query = `
      SELECT DISTINCT OPERACION as operacion
      FROM AUDITORIA
      ORDER BY OPERACION
    `;
    const result = await executeQuery(query);
    return { success: true, data: result.rows };
  } catch (error) {
    console.error("Error al obtener operaciones:", error);
    return { success: false, error };
  }
}
