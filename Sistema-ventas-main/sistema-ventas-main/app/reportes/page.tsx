import Link from "next/link";
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { FileText, Users } from "lucide-react";

export default function ReportesPage() {
  return (
    <div className="container mx-auto py-6 space-y-6">
      <div className="flex flex-col space-y-2">
        <h1 className="text-3xl font-bold tracking-tight">Reportes</h1>
        <p className="text-muted-foreground">
          Acceda a los diferentes reportes del sistema
        </p>
      </div>

      <div className="grid gap-6 md:grid-cols-2 lg:grid-cols-3">
        {/* Reporte de Auditoría */}
        <Card>
          <CardHeader className="pb-2">
            <CardTitle className="text-xl">Reporte de Auditoría</CardTitle>
            <CardDescription>
              Visualice los registros de auditoría filtrados por fecha
            </CardDescription>
          </CardHeader>
          <CardContent>
            <div className="flex justify-center py-4">
              <FileText className="h-16 w-16 text-primary opacity-80" />
            </div>
          </CardContent>
          <CardFooter>
            <Button asChild className="w-full">
              <Link href="/reportes/auditoria">Ver Reporte</Link>
            </Button>
          </CardFooter>
        </Card>

        {/* Reporte de Vendedores con Ventas Bajas */}
        <Card>
          <CardHeader className="pb-2">
            <CardTitle className="text-xl">Vendedores con Ventas Bajas</CardTitle>
            <CardDescription>
              Visualice los vendedores con menor rendimiento en ventas
            </CardDescription>
          </CardHeader>
          <CardContent>
            <div className="flex justify-center py-4">
              <Users className="h-16 w-16 text-primary opacity-80" />
            </div>
          </CardContent>
          <CardFooter>
            <Button asChild className="w-full">
              <Link href="/reportes/vendedores-bajas">Ver Reporte</Link>
            </Button>
          </CardFooter>
        </Card>
      </div>
    </div>
  );
}