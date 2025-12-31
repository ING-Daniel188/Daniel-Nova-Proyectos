# Sistema de Gestión de Restaurante con Oracle 11g

Este proyecto implementa una aplicación de gestión para restaurantes utilizando Oracle 11g Express Edition como base de datos.

## Características

- Interfaz gráfica de usuario para gestionar restaurantes
- Conexión configurable a Oracle 11g Express Edition
- Modo de depuración para probar la interfaz sin conexión a la base de datos

## Solución a problemas de compatibilidad

La aplicación está diseñada para funcionar con Oracle 11g, pero la biblioteca python-oracledb tiene limitaciones de compatibilidad:

1. **Modo thin**: Por defecto, python-oracledb utiliza un modo "thin" que no es compatible con Oracle 11g
2. **Modo thick**: Requiere instalación de Oracle Client, pero ofrece compatibilidad con Oracle 11g

Para solucionar este problema, la aplicación:

- Intenta usar el modo "thick" si Oracle Client está disponible
- Proporciona información clara sobre el estado de la conexión
- Incluye un botón de depuración para probar la interfaz sin necesidad de conexión

## Archivos principales

- `run.py`: Punto de entrada de la aplicación
- `login.py`: Ventana de login con opciones de conexión a Oracle
- `database.py`: Implementación de la conexión a la base de datos
- `database_helper.py`: Funciones auxiliares para la conexión
- `gui.py`: Interfaz gráfica principal
- `INSTALACION.md`: Guía detallada de instalación

## Requisitos

- Python 3.6 o superior
- Oracle 11g Express Edition
- Bibliotecas cliente de Oracle (recomendado)

Para más detalles sobre la instalación, consulta el archivo [INSTALACION.md](INSTALACION.md).

## Ejecución

```bash
python run.py
``` 
## Autor
Nombre: Daniel Nova Reina  