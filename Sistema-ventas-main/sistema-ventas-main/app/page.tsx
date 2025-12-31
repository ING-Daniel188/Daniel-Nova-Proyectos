//Importa el elemento AnalyticsServer desde analytics-server 
import { AnalyticsServer } from "@/components/dashboard/analytics-server";
//Importa elementos desde el compoente card
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
//Importa la funcion executeQuery desde db 
import { executeQuery } from "@/lib/db";
//Importa iconos desde lucide-react
import { FileText, Package, ShoppingCart, Users } from "lucide-react";
/*
*Funcio para buscar el numero de productos, clientes, facturas y vendedores con facturas
*@return retorna un objeto con el total y si ocurre un error lo retorna con ceros
*/
async function getDashboardData() {
  try {
    // Get total products
    const productsResult = await executeQuery(
      "SELECT COUNT(*) as total FROM PRODUCTO",
    );
    const totalProducts = Number.parseInt(productsResult.rows[0]?.total || "0");

    // Get total clients
    const clientsResult = await executeQuery(
      "SELECT COUNT(*) as total FROM CLIENTE",
    );
    const totalClients = Number.parseInt(clientsResult.rows[0]?.total || "0");

    // Get total invoices
    const invoicesResult = await executeQuery(
      "SELECT COUNT(*) as total FROM FACTURA",
    );
    const totalInvoices = Number.parseInt(invoicesResult.rows[0]?.total || "0");

    // Get total facturas por vendedor
    const vendedorFacturasTotal = await executeQuery(
      "SELECT COUNT(DISTINCT f.COD_VEN) as total FROM FACTURA f",
    );
    const totalVendedorFacturas = Number.parseInt(
      vendedorFacturasTotal.rows[0]?.total || "0",
    );

    return {
      totalProducts,
      totalClients,
      totalInvoices,
      totalVendedorFacturas,
    };
  } catch (error) {
    console.error("Error fetching dashboard data:", error);
    return {
      totalProducts: 0,
      totalClients: 0,
      totalInvoices: 0,
      totalRevenue: 0,
    };
  }
}
//Funcion para cargar la pagina principal
export default async function Home() {
  const { totalProducts, totalClients, totalInvoices, totalVendedorFacturas } =
    await getDashboardData();

  return (
    <div className="flex flex-col gap-4">
      <h1 className="text-3xl font-bold">Panel Principal</h1>
      <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-4">
        <Card>
          <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
            <CardTitle className="text-sm font-medium">
              Facturas Vendedores Totales
            </CardTitle>
            <FileText className="h-4 w-4 text-muted-foreground" />
          </CardHeader>
          <CardContent>
            <div className="text-2xl font-bold">+{totalVendedorFacturas}</div>
          </CardContent>
        </Card>
        <Card>
          <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
            <CardTitle className="text-sm font-medium">Productos</CardTitle>
            <Package className="h-4 w-4 text-muted-foreground" />
          </CardHeader>
          <CardContent>
            <div className="text-2xl font-bold">+{totalProducts}</div>
          </CardContent>
        </Card>
        <Card>
          <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
            <CardTitle className="text-sm font-medium">Ventas</CardTitle>
            <ShoppingCart className="h-4 w-4 text-muted-foreground" />
          </CardHeader>
          <CardContent>
            <div className="text-2xl font-bold">+{totalInvoices}</div>
          </CardContent>
        </Card>
        <Card>
          <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
            <CardTitle className="text-sm font-medium">
              Clientes Activos
            </CardTitle>
            <Users className="h-4 w-4 text-muted-foreground" />
          </CardHeader>
          <CardContent>
            <div className="text-2xl font-bold">+{totalClients}</div>
          </CardContent>
        </Card>
      </div>
      <div className="space-y-4">
        <div>
          <AnalyticsServer />
        </div>
      </div>
    </div>
  );
}
