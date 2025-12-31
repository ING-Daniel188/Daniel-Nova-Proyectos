"use client";

import { Badge } from "@/components/ui/badge";
import { Button } from "@/components/ui/button";
import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
import { exportarReporteVendedoresBajasPDF } from "@/lib/pdf-utils";
import { Download } from "lucide-react";

interface ReporteVendedoresBajasProps {
  vendedores: any[];
  loading: boolean;
  onLimiteChange: (limite: number) => void;
  limite: number;
}

export function ReporteVendedoresBajas({
  vendedores,
  loading,
  onLimiteChange,
  limite,
}: ReporteVendedoresBajasProps) {
  // Formatea el valor monetario
  const formatCurrency = (value: number) => {
    return new Intl.NumberFormat("es-CO", {
      style: "currency",
      currency: "COP",
      minimumFractionDigits: 0,
    }).format(value);
  };

  // Opciones para el selector de límite
  const opcionesLimite = [3, 5, 10, 15, 20];

  return (
    <div className="space-y-4">
      <div className="flex flex-col gap-4 md:flex-row md:items-center md:justify-between">
        <Card className="w-full md:w-auto">
          <CardHeader className="pb-2">
            <CardTitle>Filtrar cantidad</CardTitle>
            <CardDescription>
              Seleccione la cantidad de vendedores a mostrar
            </CardDescription>
          </CardHeader>
          <CardContent>
            <div className="grid gap-2">
              <Select
                value={limite.toString()}
                onValueChange={(value) => onLimiteChange(parseInt(value))}
              >
                <SelectTrigger className="w-[180px]">
                  <SelectValue placeholder="Seleccionar cantidad" />
                </SelectTrigger>
                <SelectContent>
                  {opcionesLimite.map((opcion) => (
                    <SelectItem key={opcion} value={opcion.toString()}>
                      {opcion} vendedores
                    </SelectItem>
                  ))}
                </SelectContent>
              </Select>
            </div>
          </CardContent>
        </Card>
        <Button
          variant="outline"
          className="h-10 px-4 py-2"
          onClick={() => exportarReporteVendedoresBajasPDF(vendedores)}
          disabled={loading || vendedores.length === 0}
        >
          <Download className="mr-2 h-4 w-4" />
          Exportar a PDF
        </Button>
      </div>

      <div className="rounded-md border">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead>Código</TableHead>
              <TableHead>Nombre</TableHead>
              <TableHead>Sueldo</TableHead>
              <TableHead>Total Ventas</TableHead>
              <TableHead>Facturas</TableHead>
              <TableHead>Rendimiento</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {loading ? (
              <TableRow>
                <TableCell colSpan={6} className="h-24 text-center">
                  Cargando datos...
                </TableCell>
              </TableRow>
            ) : vendedores.length === 0 ? (
              <TableRow>
                <TableCell colSpan={6} className="h-24 text-center">
                  No hay datos disponibles.
                </TableCell>
              </TableRow>
            ) : (
              vendedores.map((vendedor) => {
                // Calcular el rendimiento (ventas/sueldo)
                const rendimiento =
                  vendedor.sueldo > 0
                    ? vendedor.total_ventas / vendedor.sueldo
                    : 0;

                // Determinar el color del badge según el rendimiento
                let badgeVariant = "destructive";
                if (rendimiento >= 2) {
                  badgeVariant = "success";
                } else if (rendimiento >= 1) {
                  badgeVariant = "warning";
                }

                return (
                  <TableRow key={vendedor.cod_ven}>
                    <TableCell className="font-medium">
                      {vendedor.cod_ven}
                    </TableCell>
                    <TableCell>{vendedor.nombre_vendedor}</TableCell>
                    <TableCell>{formatCurrency(vendedor.sueldo)}</TableCell>
                    <TableCell>
                      {formatCurrency(vendedor.total_ventas)}
                    </TableCell>
                    <TableCell>{vendedor.cantidad_facturas}</TableCell>
                    <TableCell>
                      <Badge
                        variant={
                          badgeVariant as
                            | "default"
                            | "secondary"
                            | "destructive"
                            | "outline"
                            | "success"
                            | "warning"
                        }
                      >
                        {rendimiento.toFixed(2)}x
                      </Badge>
                    </TableCell>
                  </TableRow>
                );
              })
            )}
          </TableBody>
        </Table>
      </div>
    </div>
  );
}
