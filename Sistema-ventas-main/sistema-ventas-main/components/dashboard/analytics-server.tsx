/**
 *Se importan la funcion de executeQuery desde @/lib/db
 */
import { executeQuery } from "@/lib/db";
/**
 *Importa una clase desde ./analytics
 */
import Analytics from "./analytics";
/**
 *La siguiente función muestra una lista de los 5 vendedores con mas facturas junto con la cantidad de de facturas que tiene
 *@returns retorna el resultado de la consulta
 */
export async function getVendedorFacturasData() {
  try {
    const query = `
      SELECT v.NOM_VEN || ' ' || v.APE_VEN as name, COUNT(f.NUM_FAC) as count
      FROM FACTURA f
      JOIN VENDEDOR v ON f.COD_VEN = v.COD_VEN
      GROUP BY v.NOM_VEN, v.APE_VEN
      ORDER BY count DESC
      LIMIT 5
    `;
    const result = await executeQuery(query);
    return result.rows;
  } catch (error) {
    console.error("Error fetching vendedor facturas data:", error);
    return [];
  }
}
/**
 *La siguiente función retorna una serie de consultas realiasdas a la base de datos para obtener información como los productos con mas stock, clientes registrados por mes, proveedores activos entre otras
 *@returns se retorna el resultado de la consulta y de ser necesario se maneja el error
 */
export async function getAnalyticsData() {
  try {
    // 1. Productos con más stock
    const topStockProductsQuery = `
      SELECT COD_PRO, DES_PRO as name, STO_PRO as stock
      FROM PRODUCTO
      ORDER BY STO_PRO DESC
      LIMIT 5
    `;
    const topStockProducts = await executeQuery(topStockProductsQuery);

    // 2. Clientes registrados por mes (últimos 12 meses)
    const clientsByMonthQuery = `
      SELECT TO_CHAR(FEC_REG, 'YYYY-MM') as month, TO_CHAR(FEC_REG, 'Mon') as month_name, COUNT(*) as count
      FROM CLIENTE
      WHERE FEC_REG >= CURRENT_DATE - INTERVAL '12 months'
      GROUP BY TO_CHAR(FEC_REG, 'YYYY-MM'), TO_CHAR(FEC_REG, 'Mon'), EXTRACT(MONTH FROM FEC_REG)
      ORDER BY EXTRACT(MONTH FROM FEC_REG)
    `;
    const clientsByMonth = await executeQuery(clientsByMonthQuery);

    // 3. Proveedores activos (cantidad de órdenes por proveedor)
    const supplierOrdersQuery = `
      SELECT p.RSO_PRV as name, COUNT(o.NUM_OCO) as count
      FROM ORDEN_COMPRA o
      JOIN PROVEEDOR p ON o.COD_PRV = p.COD_PRV
      GROUP BY p.RSO_PRV
      ORDER BY count DESC
      LIMIT 6
    `;
    const supplierOrders = await executeQuery(supplierOrdersQuery);

    // 4. Productos con stock bajo (ya existe)
    const lowStockQuery = `
      SELECT COD_PRO, DES_PRO as name, STO_PRO as stock, SMI_PRO as min_stock
      FROM PRODUCTO
      WHERE STO_PRO < SMI_PRO
      ORDER BY (SMI_PRO - STO_PRO) DESC
      LIMIT 5
    `;
    const lowStockProducts = await executeQuery(lowStockQuery);

    // 5. Obtener facturas por vendedor
    const vendedorFacturas = await getVendedorFacturasData();

    return {
      topStockProducts: topStockProducts.rows,
      clientsByMonth: clientsByMonth.rows,
      supplierOrders: supplierOrders.rows,
      lowStockProducts: lowStockProducts.rows,
      vendedorFacturas: vendedorFacturas,
    };
  } catch (error) {
    console.error("Error fetching analytics data:", error);
    return {
      topStockProducts: [],
      clientsByMonth: [],
      supplierOrders: [],
      lowStockProducts: [],
      vendedorFacturas: [],
    };
  }
}
/**
 *La siguiente función cambia el contenido de la pagina segun el resultado de la funcion getAnalyticsData
 */
export async function AnalyticsServer() {
  const data = await getAnalyticsData();
  return (
    <div>
      <Analytics data={data} />
    </div>
  );
}
