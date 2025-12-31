"use client";

import { exportarReporteAuditoriaPDF } from "@/lib/pdf-utils";
import { format } from "date-fns";
import { es } from "date-fns/locale";
import { Calendar as CalendarIcon, Download } from "lucide-react";
import { useState } from "react";
import { DateRange } from "react-day-picker";

import { Badge } from "@/components/ui/badge";
import { Button } from "@/components/ui/button";
import { Calendar } from "@/components/ui/calendar";
import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import {
  Pagination,
  PaginationContent,
  PaginationEllipsis,
  PaginationItem,
  PaginationLink,
  PaginationNext,
  PaginationPrevious,
} from "@/components/ui/pagination";
import {
  Popover,
  PopoverContent,
  PopoverTrigger,
} from "@/components/ui/popover";
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
import { Eye } from "lucide-react";

interface ReporteAuditoriaProps {
  auditorias: any[];
  pagination: {
    total: number;
    pagina: number;
    porPagina: number;
    totalPaginas: number;
  };
  onDateRangeChange: (range: DateRange | undefined) => void;
  onPageChange: (page: number) => void;
  dateRange: DateRange | undefined;
  loading: boolean;
}

export function ReporteAuditoria({
  auditorias,
  pagination,
  onDateRangeChange,
  onPageChange,
  dateRange,
  loading,
}: ReporteAuditoriaProps) {
  const [selectedAudit, setSelectedAudit] = useState<any>(null);

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

  return (
    <div className="space-y-4">
      <div className="flex flex-col gap-4 md:flex-row md:items-center md:justify-between">
        <Card className="w-full md:w-auto">
          <CardHeader className="pb-2">
            <CardTitle>Filtrar por fecha</CardTitle>
            <CardDescription>
              Seleccione un rango de fechas para filtrar los registros
            </CardDescription>
          </CardHeader>
          <CardContent>
            <div className="grid gap-2">
              <Popover>
                <PopoverTrigger asChild>
                  <Button
                    id="date"
                    variant={"outline"}
                    className={"w-full justify-start text-left font-normal"}
                  >
                    <CalendarIcon className="mr-2 h-4 w-4" />
                    {dateRange?.from ? (
                      dateRange.to ? (
                        <>
                          {format(dateRange.from, "dd/MM/yyyy", {
                            locale: es,
                          })}{" "}
                          - {format(dateRange.to, "dd/MM/yyyy", { locale: es })}
                        </>
                      ) : (
                        format(dateRange.from, "dd/MM/yyyy", { locale: es })
                      )
                    ) : (
                      <span>Seleccionar fechas</span>
                    )}
                  </Button>
                </PopoverTrigger>
                <PopoverContent className="w-auto p-0" align="start">
                  <Calendar
                    initialFocus
                    mode="range"
                    defaultMonth={dateRange?.from}
                    selected={dateRange}
                    onSelect={onDateRangeChange}
                    numberOfMonths={2}
                    locale={es}
                  />
                </PopoverContent>
              </Popover>
            </div>
          </CardContent>
        </Card>
        <Button
          variant="outline"
          className="h-10 px-4 py-2"
          onClick={() => exportarReporteAuditoriaPDF(auditorias, dateRange)}
          disabled={loading || auditorias.length === 0}
        >
          <Download className="mr-2 h-4 w-4" />
          Exportar a PDF
        </Button>
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
              <TableRow>
                <TableCell colSpan={6} className="h-24 text-center">
                  Cargando datos...
                </TableCell>
              </TableRow>
            ) : auditorias.length === 0 ? (
              <TableRow>
                <TableCell colSpan={6} className="h-24 text-center">
                  No hay registros para el período seleccionado.
                </TableCell>
              </TableRow>
            ) : (
              auditorias.map((auditoria) => (
                <TableRow key={auditoria.id_audit}>
                  <TableCell className="font-medium">
                    {auditoria.id_audit}
                  </TableCell>
                  <TableCell>{auditoria.tabla}</TableCell>
                  <TableCell>
                    <Badge
                      variant={
                        getBadgeVariant(auditoria.operacion) as
                          | "default"
                          | "secondary"
                          | "destructive"
                          | "outline"
                          | "success"
                          | "warning"
                      }
                    >
                      {auditoria.operacion}
                    </Badge>
                  </TableCell>
                  <TableCell>{auditoria.usuario}</TableCell>
                  <TableCell>{formatDate(auditoria.fecha)}</TableCell>
                  <TableCell className="text-right">
                    <Dialog>
                      <DialogTrigger asChild>
                        <Button
                          variant="outline"
                          size="icon"
                          onClick={() => setSelectedAudit(auditoria)}
                        >
                          <Eye className="h-4 w-4" />
                        </Button>
                      </DialogTrigger>
                      <DialogContent className="max-w-4xl">
                        <DialogHeader>
                          <DialogTitle>Detalles de Auditoría</DialogTitle>
                        </DialogHeader>
                        <div className="grid gap-4 py-4">
                          <div className="grid grid-cols-4 items-center gap-4">
                            <div className="font-medium">ID:</div>
                            <div className="col-span-3">
                              {selectedAudit?.id_audit}
                            </div>
                          </div>
                          <div className="grid grid-cols-4 items-center gap-4">
                            <div className="font-medium">Tabla:</div>
                            <div className="col-span-3">
                              {selectedAudit?.tabla}
                            </div>
                          </div>
                          <div className="grid grid-cols-4 items-center gap-4">
                            <div className="font-medium">Operación:</div>
                            <div className="col-span-3">
                              <Badge
                                variant={
                                  getBadgeVariant(
                                    selectedAudit?.operacion,
                                  ) as any
                                }
                              >
                                {selectedAudit?.operacion}
                              </Badge>
                            </div>
                          </div>
                          <div className="grid grid-cols-4 items-center gap-4">
                            <div className="font-medium">Usuario:</div>
                            <div className="col-span-3">
                              {selectedAudit?.usuario}
                            </div>
                          </div>
                          <div className="grid grid-cols-4 items-center gap-4">
                            <div className="font-medium">Fecha:</div>
                            <div className="col-span-3">
                              {selectedAudit && formatDate(selectedAudit.fecha)}
                            </div>
                          </div>
                          <div className="grid grid-cols-1 gap-4">
                            <div className="font-medium">Datos Antiguos:</div>
                            <div className="rounded-md bg-muted p-4 overflow-auto max-h-40">
                              <pre className="text-xs">
                                {selectedAudit &&
                                  JSON.stringify(
                                    selectedAudit.datos_antiguos,
                                    null,
                                    2,
                                  )}
                              </pre>
                            </div>
                          </div>
                          <div className="grid grid-cols-1 gap-4">
                            <div className="font-medium">Datos Nuevos:</div>
                            <div className="rounded-md bg-muted p-4 overflow-auto max-h-40">
                              <pre className="text-xs">
                                {selectedAudit &&
                                  JSON.stringify(
                                    selectedAudit.datos_nuevos,
                                    null,
                                    2,
                                  )}
                              </pre>
                            </div>
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
                  if (pagination.pagina > 1) {
                    onPageChange(pagination.pagina - 1);
                  }
                }}
                className={
                  pagination.pagina <= 1 ? "pointer-events-none opacity-50" : ""
                }
              />
            </PaginationItem>
            {Array.from(
              { length: pagination.totalPaginas },
              (_, i) => i + 1,
            ).map((page) => {
              // Mostrar solo algunas páginas para no sobrecargar la UI
              if (
                page === 1 ||
                page === pagination.totalPaginas ||
                (page >= pagination.pagina - 1 && page <= pagination.pagina + 1)
              ) {
                return (
                  <PaginationItem key={page}>
                    <PaginationLink
                      href="#"
                      onClick={(e) => {
                        e.preventDefault();
                        onPageChange(page);
                      }}
                      isActive={page === pagination.pagina}
                    >
                      {page}
                    </PaginationLink>
                  </PaginationItem>
                );
              } else if (
                page === pagination.pagina - 2 ||
                page === pagination.pagina + 2
              ) {
                return (
                  <PaginationItem key={page}>
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
                  if (pagination.pagina < pagination.totalPaginas) {
                    onPageChange(pagination.pagina + 1);
                  }
                }}
                className={
                  pagination.pagina >= pagination.totalPaginas
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
