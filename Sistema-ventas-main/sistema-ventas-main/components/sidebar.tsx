//Este componente se ejecuta desde el lado del cliente
"use client";
//Se importa la funcion cn desde el componente utils
import { cn } from "@/lib/utils";
//Importa iconos desde el componente lucide-react
import {
  BarChart3,
  Building,
  FileText,
  Home,
  Map,
  Menu,
  Package,
  PieChart,
  ShoppingCart,
  Truck,
  Users,
  X,
} from "lucide-react";
//Importa el elemento Link desde el componente link
import Link from "next/link";
//Importa el elemento usePathname desde el componente navigation
import { usePathname } from "next/navigation";
//Importa elementos desde el componente react
import { useEffect, useState } from "react";
//Define las rutas de navegacion
const routes = [
  {
    label: "Panel Principal",
    icon: Home,
    href: "/",
    color: "text-sky-500",
  },
  {
    label: "Distritos",
    icon: Map,
    href: "/distritos",
    color: "text-violet-500",
  },
  {
    label: "Proveedores",
    icon: Truck,
    href: "/proveedores",
    color: "text-pink-700",
  },
  {
    label: "Vendedores",
    icon: Users,
    href: "/vendedores",
    color: "text-orange-500",
  },
  {
    label: "Clientes",
    icon: Building,
    href: "/clientes",
    color: "text-emerald-500",
  },
  {
    label: "Productos",
    icon: Package,
    href: "/productos",
    color: "text-green-500",
  },
  {
    label: "Facturas",
    icon: FileText,
    href: "/facturas",
    color: "text-blue-500",
  },
  {
    label: "Órdenes de Compra",
    icon: ShoppingCart,
    href: "/ordenes-compra",
    color: "text-yellow-500",
  },
  {
    label: "Reportes",
    icon: PieChart,
    href: "/reportes",
    color: "text-purple-500",
  },
  {
    label: "Auditoría",
    icon: BarChart3,
    href: "/auditoria",
    color: "text-red-500",
  },
];
//Realisa configuraciones como el cambio de la barra lateral en caso de que el sitio se abra en telefono
export default function Sidebar() {
  const pathname = usePathname();
  const [isMobileMenuOpen, setIsMobileMenuOpen] = useState(false);

  // Cierra el menú cuando cambia la ruta en dispositivos móviles
  useEffect(() => {
    setIsMobileMenuOpen(false);
  }, [pathname]);

  // Evita el scroll cuando el menú está abierto en móviles
  useEffect(() => {
    if (isMobileMenuOpen) {
      document.body.style.overflow = "hidden";
    } else {
      document.body.style.overflow = "auto";
    }

    return () => {
      document.body.style.overflow = "auto";
    };
  }, [isMobileMenuOpen]);

  return (
    <>
      {/* Botón de menú móvil */}
      <button
        onClick={() => setIsMobileMenuOpen(true)}
        className="lg:hidden fixed top-4 left-4 z-50 p-2 rounded-md text-slate-900 dark:text-slate-50 hover:bg-slate-200/20 dark:hover:bg-slate-800/20 transition-colors backdrop-filter backdrop-blur-md bg-white/30 dark:bg-slate-900/30"
        aria-label="Abrir menú"
      >
        <Menu className="h-6 w-6" />
      </button>

      {/* Overlay para cuando el menú está abierto en móvil */}
      <div
        className={cn(
          "lg:hidden fixed inset-0 bg-black/40 backdrop-filter backdrop-blur-sm z-40 transition-opacity duration-300",
          isMobileMenuOpen ? "opacity-100" : "opacity-0 pointer-events-none",
        )}
        onClick={() => setIsMobileMenuOpen(false)}
      />

      {/* Sidebar */}
      <div
        className={cn(
          "fixed inset-y-0 left-0 z-50 w-72 space-y-4 py-4 flex flex-col h-full bg-slate-50/90 dark:bg-slate-900/90 backdrop-filter backdrop-blur-md text-slate-900 dark:text-slate-50 border-r shadow-lg transition-transform duration-300 ease-in-out lg:shadow-none lg:translate-x-0 lg:relative lg:z-0",
          isMobileMenuOpen ? "translate-x-0" : "-translate-x-full",
        )}
      >
        <div className="px-3 py-2 flex-1">
          <div className="flex items-center justify-between mb-10 pt-2">
            <Link href="/" className="flex items-center">
              <h1 className="text-2xl font-bold">SistemaVentas</h1>
            </Link>
            <button
              onClick={() => setIsMobileMenuOpen(false)}
              className="lg:hidden p-2 rounded-md hover:bg-slate-200/70 dark:hover:bg-slate-800/70 backdrop-filter backdrop-blur-sm"
              aria-label="Cerrar menú"
            >
              <X className="h-5 w-5" />
            </button>
          </div>
          <div className="space-y-1">
            {routes.map((route) => (
              <Link
                key={route.href}
                href={route.href}
                className={cn(
                  "text-sm group flex p-3 w-full justify-start font-medium cursor-pointer hover:text-slate-900 dark:hover:text-slate-50 hover:bg-slate-100 dark:hover:bg-slate-800 rounded-lg transition",
                  pathname === route.href
                    ? "bg-slate-100 dark:bg-slate-800 text-slate-900 dark:text-slate-50"
                    : "text-slate-500 dark:text-slate-400",
                )}
              >
                <div className="flex items-center flex-1">
                  <route.icon className={cn("h-5 w-5 mr-3", route.color)} />
                  {route.label}
                </div>
              </Link>
            ))}
          </div>
        </div>
        <div className="px-3 py-2">
          <div className="bg-slate-100/80 dark:bg-slate-800/80 backdrop-filter backdrop-blur-sm rounded-lg p-3">
            <div className="text-sm font-medium">Sistema de Gestión</div>
            <div className="text-xs text-slate-500 dark:text-slate-400">
              Versión 1.0.0
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
