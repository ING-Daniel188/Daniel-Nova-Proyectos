"use client"; // Indica que este componente se renderiza del lado del cliente

// Importación de componentes UI personalizados
import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";

// Importación de íconos
import { AlertTriangle } from "lucide-react";

// Importación de componentes gráficos de la librería Recharts
import {
  Bar,
  BarChart,
  CartesianGrid,
  Legend,
  ResponsiveContainer,
  Tooltip,
  XAxis,
  YAxis,
} from "recharts";

// Definición del tipo de las propiedades que recibe el componente
interface AnalyticsProps {
  data: {
    topStockProducts: any[]; // Productos con más stock
    supplierOrders: any[]; // Pedidos por proveedor
    lowStockProducts: any[]; // Productos con bajo stock
    vendedorFacturas: any[]; // Facturas por vendedor
  };
}
/**
 * Componente Analytics
 * Visualiza diferentes métricas del sistema, como facturas por vendedor, productos con bajo stock, etc.
 */
export default function Analytics({ data }: AnalyticsProps) {
  return (
    <div className="grid gap-4">
      {/* Facturas por Vendedor */}
      <Card className="col-span-1">
        <CardHeader>
          <CardTitle>Facturas por Vendedor</CardTitle>
          <CardDescription>
            Cantidad de facturas emitidas por vendedor
          </CardDescription>
        </CardHeader>
        <CardContent>
          <div className="h-64 flex items-center justify-center">
            <ResponsiveContainer width="100%" height="100%">
              <BarChart
                data={data.vendedorFacturas}
                margin={{ top: 20, right: 30, left: 20, bottom: 5 }}
              >
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis
                  dataKey="name"
                  angle={-45}
                  textAnchor="end"
                  height={70}
                />
                <YAxis allowDecimals={false} />
                <Tooltip formatter={(value) => [value, "Facturas"]} />
                <Legend />
                <Bar dataKey="count" name="Facturas" fill="#8884d8" />
              </BarChart>
            </ResponsiveContainer>
          </div>
        </CardContent>
      </Card>
      {/* Productos con más stock */}
      <Card className="col-span-1">
        <CardHeader>
          <CardTitle>Productos con más stock</CardTitle>
          <CardDescription>
            Los 5 productos con mayor cantidad en inventario
          </CardDescription>
        </CardHeader>
        <CardContent>
          <div className="h-80">
            <ResponsiveContainer width="100%" height="100%">
              <BarChart
                data={data.topStockProducts}
                margin={{ top: 20, right: 30, left: 20, bottom: 5 }}
                layout="vertical"
              >
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis type="number" />
                <YAxis type="category" dataKey="name" width={150} />
                <Tooltip formatter={(value) => [value, "Stock"]} />
                <Legend />
                <Bar dataKey="stock" name="Stock" fill="#0ea5e9" />
              </BarChart>
            </ResponsiveContainer>
          </div>
        </CardContent>
      </Card>

      {/* Productos con Stock Bajo */}
      <Card>
        <CardHeader>
          <CardTitle>Alerta de Stock</CardTitle>
          <CardDescription>
            Productos con stock por debajo del mínimo
          </CardDescription>
        </CardHeader>
        <CardContent>
          <div className="space-y-4">
            {data.lowStockProducts.length === 0 ? (
              <p className="text-center text-muted-foreground py-8">
                No hay productos con stock bajo
              </p>
            ) : (
              data.lowStockProducts.map((product) => (
                <div
                  key={product.cod_pro}
                  className="flex items-center justify-between border-b pb-2"
                >
                  <div className="flex items-center gap-2">
                    <AlertTriangle className="h-4 w-4 text-amber-500" />
                    <span className="font-medium">{product.name}</span>
                  </div>
                  <div className="text-sm">
                    <span className="text-red-500 font-medium">
                      {product.stock}
                    </span>
                    <span className="text-muted-foreground">
                      {" "}
                      / {product.min_stock}
                    </span>
                  </div>
                </div>
              ))
            )}
          </div>
        </CardContent>
      </Card>
    </div>
  );
}
