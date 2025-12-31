//Importa el elemento Sidebar desde sidebar
import Sidebar from "@/components/sidebar";
//Importa el elemento ThemeProvider desde theme-provider
import { ThemeProvider } from "@/components/theme-provider";
//Importa el elemento Toaster desde el componente toaster
import { Toaster } from "@/components/ui/toaster";
//Importa la definicion de tipo Metadata desde next
import type { Metadata } from "next";
//Importa la funcion Inter desde google
import { Inter } from "next/font/google";
//Importa el elemento React dede el componente react
import type React from "react";
//Importa las definicionesd e estilos
import "./globals.css";
//Configura una intancia de inter para usar caracteres latinos
const inter = Inter({ subsets: ["latin"] });
//Metadata de la pagina
export const metadata: Metadata = {
  title: "Sistema de Gestión de Ventas e Inventario",
  description: "Un sistema completo de gestión de ventas e inventario",
  generator: "v0.dev",
};
//Funcion para definir una estructurade la aplicacion ademas de definir el idioma en español
export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="es" suppressHydrationWarning>
      <body className={inter.className}>
        <ThemeProvider
          attribute="class"
          defaultTheme="system"
          enableSystem
          disableTransitionOnChange
        >
          <div className="flex h-screen overflow-hidden">
            <Sidebar />
            <main className="flex-1 overflow-auto p-6 w-full lg:w-auto">
              {children}
            </main>
          </div>
          <Toaster />
        </ThemeProvider>
      </body>
    </html>
  );
}
