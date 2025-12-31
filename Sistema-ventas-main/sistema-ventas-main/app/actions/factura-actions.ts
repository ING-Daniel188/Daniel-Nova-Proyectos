//Este componente se ejecuta del lado del servidor
"use server";
//Importa la funcion executeQuery desde el componente db
import { convertParams, executeQuery } from "@/lib/db";
//Se crea una interfaz para reprecentar el objeto Factura
export interface Factura {
  NUM_FAC: string;
  FEC_FAC: string;
  COD_CLI: string;
  FEC_CAN?: string | null;
  EST_FAC: string;
  COD_VEN: string;
  POR_IGV: number;
}
//Se crea una interfaz para reprecentar el objeto DetalleFactura
export interface DetalleFactura {
  NUM_FAC: string;
  COD_PRO: string;
  CAN_VEN: number;
  PRE_VEN: number;
}
//Funcion para obtener la informacion de las facturas
export async function obtenerFacturas() {
  try {
    const query = `
      SELECT 
        f.NUM_FAC, 
        f.FEC_FAC, 
        f.COD_CLI, 
        c.RCO_CLI as CLIENTE,
        f.FEC_CAN, 
        f.EST_FAC, 
        f.COD_VEN,
        v.NOM_VEN || ' ' || v.APE_VEN as VENDEDOR,
        fn_calcular_total_factura(f.NUM_FAC) as TOTAL
      FROM 
        FACTURA f
        JOIN CLIENTE c ON f.COD_CLI = c.COD_CLI
        JOIN VENDEDOR v ON f.COD_VEN = v.COD_VEN
      ORDER BY 
        f.FEC_FAC DESC
    `;
    const result = await executeQuery(query, [], false);
    return { success: true, data: result.rows };
  } catch (error) {
    console.error("Error al obtener facturas:", error);
    return { success: false, error };
  }
}
//Funcion para obtener la infomacion de una factura por el numero de factura
export async function obtenerFactura(numFac: string) {
  try {
    // Get factura
    const { query, params } = convertParams(
      `
      SELECT 
        f.NUM_FAC, 
        f.FEC_FAC, 
        f.COD_CLI, 
        c.RCO_CLI as CLIENTE,
        c.DIR_CLI,
        c.RUC_CLI,
        f.FEC_CAN, 
        f.EST_FAC, 
        f.COD_VEN,
        v.NOM_VEN || ' ' || v.APE_VEN as VENDEDOR,
        f.POR_IGV
      FROM 
        FACTURA f
        JOIN CLIENTE c ON f.COD_CLI = c.COD_CLI
        JOIN VENDEDOR v ON f.COD_VEN = v.COD_VEN
      WHERE 
        f.NUM_FAC = :numFac
    `,
      { numFac },
    );

    const facturaResult = await executeQuery(query, params);

    if (facturaResult.rows.length === 0) {
      return { success: false, error: "Factura no encontrada" };
    }

    const factura = facturaResult.rows[0];

    // Get detalles
    const { query: detallesQuery, params: detallesParams } = convertParams(
      `
      SELECT 
        df.NUM_FAC,
        df.COD_PRO,
        p.DES_PRO,
        df.CAN_VEN,
        df.PRE_VEN,
        df.CAN_VEN * df.PRE_VEN as SUBTOTAL
      FROM 
        DETALLE_FACTURA df
        JOIN PRODUCTO p ON df.COD_PRO = p.COD_PRO
      WHERE 
        df.NUM_FAC = :numFac
    `,
      { numFac },
    );

    const detallesResult = await executeQuery(detallesQuery, detallesParams);
    const detalles = detallesResult.rows;

    // Calculate totals
    const subtotal = detalles.reduce(
      (sum: number, item: any) => sum + Number(item.subtotal),
      0,
    );
    const igv = subtotal * (Number(factura.por_igv) / 100);
    const total = subtotal + igv;

    return {
      success: true,
      data: {
        ...factura,
        DETALLES: detalles,
        SUBTOTAL: subtotal,
        IGV: igv,
        TOTAL: total,
      },
    };
  } catch (error) {
    console.error("Error al obtener factura:", error);
    return { success: false, error };
  }
}
