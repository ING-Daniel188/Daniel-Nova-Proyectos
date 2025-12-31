# Sistema de Gestión de Ventas e Inventario

Este proyecto es un sistema completo diseñado para la gestión eficiente de ventas e inventario. Permite a los usuarios administrar productos, proveedores, órdenes de compra, facturas y clientes, además de ofrecer análisis visuales sobre el rendimiento del negocio.

Este es el proyecto final de la asignatura "Bases de Datos 2".

## Descripción del Proyecto

El sistema está construido como una aplicación web moderna y responsiva, enfocada en proporcionar una interfaz de usuario intuitiva y herramientas robustas para la toma de decisiones. Las funcionalidades clave incluyen:

- Gestión de Inventario: Seguimiento de niveles de stock, alertas de stock bajo, y administración de productos.
- Proceso de Compras: Creación y seguimiento de órdenes de compra a proveedores.
- Proceso de Ventas: Generación de facturas y gestión de clientes.
- Gestión de Entidades: Administración de catálogos de productos, proveedores, clientes y vendedores.
- Análisis y Reportes: Visualización de datos clave como ventas por vendedor, productos con mayor stock, y alertas de inventario a través de gráficos interactivos.

## Tecnologías Implementadas

El proyecto utiliza un stack tecnológico moderno para asegurar un desarrollo eficiente, un rendimiento óptimo y una excelente experiencia de usuario:

- Framework Frontend/Backend: [Next.js](https://nextjs.org/) (utilizando App Router)
  - Next.js proporciona renderizado del lado del servidor (SSR), generación de sitios estáticos (SSG), y funcionalidades de backend (Server Actions) para una aplicación React robusta y performante.
- Librería UI: [React](https://react.dev/)
  - Utilizado para construir interfaces de usuario interactivas y componentizadas.
- Lenguaje de Programación: [TypeScript](https://www.typescriptlang.org/)
  - Añade tipado estático a JavaScript, mejorando la robustez del código y la experiencia de desarrollo.
- Componentes UI: [Shadcn UI](https://ui.shadcn.com/)
  - Una colección de componentes UI reutilizables, construidos sobre Tailwind CSS y Radix UI, que permiten crear interfaces de usuario elegantes y accesibles rápidamente. Se evidencia su uso por la importación de componentes desde `@/components/ui`.
- Estilos: [Tailwind CSS](https://tailwindcss.com/)
  - Un framework CSS "utility-first" para construir diseños personalizados rápidamente sin salir del HTML.
- Visualización de Datos: [Recharts](https://recharts.org/)
  - Una librería de gráficos composable construida sobre componentes React, utilizada para mostrar los análisis en el dashboard.
- Base de Datos: (No especificado directamente en el código revisado, pero las acciones en `app/actions/orden-compra-actions.ts` indican el uso de SQL para interactuar con una base de datos relacional).

## Estructura del Proyecto

- `app/`: Contiene las rutas, layouts y lógica principal de la aplicación Next.js (App Router).
  - `app/actions/`: Lógica del lado del servidor (Server Actions) para interactuar con la base de datos y realizar otras operaciones de backend.
- `components/`: Alberga los componentes reutilizables de React utilizados en toda la aplicación.
  - `components/dashboard/`: Componentes específicos para el panel de análisis.
  - `components/ui/`: Componentes de la librería Shadcn UI.
- `lib/`: Módulos de utilidad, como la conexión a la base de datos (`db.ts`).
- `public/`: Archivos estáticos.

## Autor
Nombre: Daniel Nova Reina  