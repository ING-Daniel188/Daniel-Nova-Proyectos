"use client"; // Indica que este componente se ejecuta del lado del cliente

// Importaciones desde React
import type React from "react";
import { useState, useEffect } from "react";
// Next.js navigation
import { useRouter, usePathname } from "next/navigation";
// Importa elementos del componente table
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
// Selects para filtros de tabla
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
// Botones reutilizables
import { Button } from "@/components/ui/button";
// Input para campo de búsqueda
import { Input } from "@/components/ui/input";
// Íconos de Lucide
import { Search, Eye } from "lucide-react";
// Detalles de auditoría
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
// Etiquetas para operaciones
import { Badge } from "@/components/ui/badge";
// Contenedores para datos
import { Card, CardContent } from "@/components/ui/card";
// Acción para obtener datos de auditoría desde el backend
import { obtenerAuditorias } from "@/app/actions/auditoria-actions";
// Componentes de paginación
import {
  Pagination,
  PaginationContent,
  PaginationEllipsis,
  PaginationItem,
  PaginationLink,
  PaginationNext,
  PaginationPrevious,
} from "@/components/ui/pagination";

interface AuditoriaTableProps {
  tablas: any[];
  operaciones: any[];
  initialTabla?: string;
  initialOperacion?: string;
  initialBusqueda?: string;
  initialPagina?: number;
}
/**
 * Componente Auditoria-Table
 * Muestra una tabla de auditorías con filtros, busqueda, paginación y detalles
 */
export function AuditoriaTable({
  tablas,
  operaciones,
  initialTabla = "",
  initialOperacion = "",
  initialBusqueda = "",
  initialPagina = 1,
}: AuditoriaTableProps) {
  const router = useRouter();
  const pathname = usePathname();
  const [filtroTabla, setFiltroTabla] = useState<string>(initialTabla);
  const [filtroOperacion, setFiltroOperacion] =
    useState<string>(initialOperacion);
  const [busqueda, setBusqueda] = useState<string>(initialBusqueda);
  const [pagina, setPagina] = useState<number>(initialPagina);
  const [selectedAudit, setSelectedAudit] = useState<any>(null);
  const [auditorias, setAuditorias] = useState<any[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [pagination, setPagination] = useState<{
    total: number;
    pagina: number;
    porPagina: number;
    totalPaginas: number;
  }>({
    total: 0,
    pagina: initialPagina,
    porPagina: 10,
    totalPaginas: 0,
  });
  /**
   * Obtiene auditorías desde el backend con los filtros actuales
   */
  const fetchAuditorias = async () => {
    setLoading(true);
    try {
      const result = await obtenerAuditorias(
        filtroTabla === "ALL" ? "" : filtroTabla,
        filtroOperacion === "ALL" ? "" : filtroOperacion,
        busqueda,
        pagina,
        10,
      );
      if (result.success) {
        setAuditorias(result.data);
        setPagination(result.pagination!);
      }
    } catch (error) {
      console.error("Error fetching auditorias:", error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchAuditorias();

    // Sincroniza los filtros con la URL
    const params = new URLSearchParams();
    if (filtroTabla) params.set("tabla", filtroTabla);
    if (filtroOperacion) params.set("operacion", filtroOperacion);
    if (busqueda) params.set("busqueda", busqueda);
    if (pagina > 1) params.set("pagina", pagina.toString());

    const url = `${pathname}?${params.toString()}`;
    router.push(url, { scroll: false });
  }, [filtroTabla, filtroOperacion, busqueda, pagina]);

  // Formatea fecha legible desde el string
  const formatDate = (dateString: string) => {
    return new Date(dateString).toLocaleString();
  };

  // Devuelve el color de la etiqueta basado en el tipo de operación
  const getBadgeVariant = (operacion: string) => {
    switch (operacion) {
      case "INSERT":
        return "success";
      case "UPDATE":
        return "warning";
      case "DELETE":
        return "destructive";
      case "ALERTA":
        return "destructive";
      case "RESTOCK":
        return "success";
      default:
        return "secondary";
    }
  };

  // Maneja el envío del formulario
  const handleSearch = (e: React.FormEvent) => {
    e.preventDefault();
    setPagina(1); // Regresa a la primera página para una nueva búsqueda
  };

  return (
    <div className="space-y-4">
      <div className="flex flex-col gap-4 md:flex-row">
        <form
          onSubmit={handleSearch}
          className="flex w-full max-w-sm items-center space-x-2"
        >
          <Input
            placeholder="Buscar..."
            value={busqueda}
            onChange={(e) => setBusqueda(e.target.value)}
          />
          <Button type="submit" size="icon">
            <Search className="h-4 w-4" />
          </Button>
        </form>
        <div className="flex gap-2">
          <Select
            value={filtroTabla}
            onValueChange={(value) => {
              setFiltroTabla(value);
              setPagina(1);
            }}
          >
            <SelectTrigger className="w-[180px]">
              <SelectValue placeholder="Tabla" />
            </SelectTrigger>
            <SelectContent>
              <SelectItem value="ALL">Todas</SelectItem>
              {tablas.map((tabla, index) => (
                <SelectItem key={index} value={tabla.tabla}>
                  {tabla.tabla}
                </SelectItem>
              ))}
            </SelectContent>
          </Select>
          <Select
            value={filtroOperacion}
            onValueChange={(value) => {
              setFiltroOperacion(value);
              setPagina(1);
            }}
          >
            <SelectTrigger className="w-[180px]">
              <SelectValue placeholder="Operación" />
            </SelectTrigger>
            <SelectContent>
              <SelectItem value="ALL">Todas</SelectItem>
              {operaciones.map((op, index) => (
                <SelectItem key={index} value={op.operacion}>
                  {op.operacion}
                </SelectItem>
              ))}
            </SelectContent>
          </Select>
        </div>
      </div>

      <div className="rounded-md border">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead>ID</TableHead>
              <TableHead>Tabla</TableHead>
              <TableHead>Operación</TableHead>
              <TableHead>Usuario</TableHead>
              <TableHead>Fecha</TableHead>
              <TableHead className="text-right">Acciones</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {loading ? (
              Array.from({ length: 5 }).map((_, index) => (
                <TableRow key={index}>
                  <TableCell colSpan={6} className="h-12">
                    <div className="h-4 w-full animate-pulse rounded bg-gray-200 dark:bg-gray-700"></div>
                  </TableCell>
                </TableRow>
              ))
            ) : auditorias.length === 0 ? (
              <TableRow>
                <TableCell colSpan={6} className="h-24 text-center">
                  No hay registros de auditoría que coincidan con los filtros.
                </TableCell>
              </TableRow>
            ) : (
              auditorias.map((audit) => (
                <TableRow key={audit.id_audit}>
                  <TableCell className="font-medium">
                    {audit.id_audit}
                  </TableCell>
                  <TableCell>{audit.tabla}</TableCell>
                  <TableCell>
                    <Badge variant={getBadgeVariant(audit.operacion) as any}>
                      {audit.operacion}
                    </Badge>
                  </TableCell>
                  <TableCell>{audit.usuario}</TableCell>
                  <TableCell>{formatDate(audit.fecha)}</TableCell>
                  <TableCell className="text-right">
                    <Dialog>
                      <DialogTrigger asChild>
                        <Button
                          variant="outline"
                          size="icon"
                          onClick={() => setSelectedAudit(audit)}
                        >
                          <Eye className="h-4 w-4" />
                        </Button>
                      </DialogTrigger>
                      <DialogContent className="max-w-3xl">
                        <DialogHeader>
                          <DialogTitle>
                            Detalles de Auditoría #{audit.id_audit}
                          </DialogTitle>
                        </DialogHeader>
                        <div className="grid gap-4 py-4">
                          <div className="grid grid-cols-2 gap-4">
                            <div>
                              <p className="text-sm font-medium">Tabla:</p>
                              <p>{audit.tabla}</p>
                            </div>
                            <div>
                              <p className="text-sm font-medium">Operación:</p>
                              <Badge
                                variant={
                                  getBadgeVariant(audit.operacion) as any
                                }
                              >
                                {audit.operacion}
                              </Badge>
                            </div>
                            <div>
                              <p className="text-sm font-medium">Usuario:</p>
                              <p>{audit.usuario}</p>
                            </div>
                            <div>
                              <p className="text-sm font-medium">Fecha:</p>
                              <p>{formatDate(audit.fecha)}</p>
                            </div>
                          </div>

                          <div className="grid grid-cols-2 gap-4">
                            <Card>
                              <CardContent className="pt-6">
                                <h3 className="font-medium mb-2">
                                  Datos Antiguos
                                </h3>
                                {audit.datos_antiguos ? (
                                  <pre className="bg-slate-100 dark:bg-slate-800 p-2 rounded-md overflow-auto text-xs">
                                    {JSON.stringify(
                                      audit.datos_antiguos,
                                      null,
                                      2,
                                    )}
                                  </pre>
                                ) : (
                                  <p className="text-muted-foreground">
                                    No hay datos antiguos
                                  </p>
                                )}
                              </CardContent>
                            </Card>
                            <Card>
                              <CardContent className="pt-6">
                                <h3 className="font-medium mb-2">
                                  Datos Nuevos
                                </h3>
                                {audit.datos_nuevos ? (
                                  <pre className="bg-slate-100 dark:bg-slate-800 p-2 rounded-md overflow-auto text-xs">
                                    {JSON.stringify(
                                      audit.datos_nuevos,
                                      null,
                                      2,
                                    )}
                                  </pre>
                                ) : (
                                  <p className="text-muted-foreground">
                                    No hay datos nuevos
                                  </p>
                                )}
                              </CardContent>
                            </Card>
                          </div>
                        </div>
                      </DialogContent>
                    </Dialog>
                  </TableCell>
                </TableRow>
              ))
            )}
          </TableBody>
        </Table>
      </div>

      {pagination.totalPaginas > 1 && (
        <Pagination>
          <PaginationContent>
            <PaginationItem>
              <PaginationPrevious
                href="#"
                onClick={(e) => {
                  e.preventDefault();
                  if (pagina > 1) setPagina(pagina - 1);
                }}
                className={pagina <= 1 ? "pointer-events-none opacity-50" : ""}
              />
            </PaginationItem>

            {Array.from({ length: pagination.totalPaginas }).map((_, i) => {
              const pageNumber = i + 1;
              // Show first page, last page, current page, and pages around current page
              if (
                pageNumber === 1 ||
                pageNumber === pagination.totalPaginas ||
                (pageNumber >= pagina - 1 && pageNumber <= pagina + 1)
              ) {
                return (
                  <PaginationItem key={pageNumber}>
                    <PaginationLink
                      href="#"
                      onClick={(e) => {
                        e.preventDefault();
                        setPagina(pageNumber);
                      }}
                      isActive={pageNumber === pagina}
                    >
                      {pageNumber}
                    </PaginationLink>
                  </PaginationItem>
                );
              }

              // Show ellipsis for gaps
              if (
                (pageNumber === 2 && pagina > 3) ||
                (pageNumber === pagination.totalPaginas - 1 &&
                  pagina < pagination.totalPaginas - 2)
              ) {
                return (
                  <PaginationItem key={pageNumber}>
                    <PaginationEllipsis />
                  </PaginationItem>
                );
              }

              return null;
            })}

            <PaginationItem>
              <PaginationNext
                href="#"
                onClick={(e) => {
                  e.preventDefault();
                  if (pagina < pagination.totalPaginas) setPagina(pagina + 1);
                }}
                className={
                  pagina >= pagination.totalPaginas
                    ? "pointer-events-none opacity-50"
                    : ""
                }
              />
            </PaginationItem>
          </PaginationContent>
        </Pagination>
      )}
    </div>
  );
}
