## Descripción del proyecto
Este proyecto consiste en una **Pokedex desarrollada en Java**, cuyo objetivo es gestionar información de Pokémon de manera organizada y estructurada. El sistema permite **registrar, visualizar y administrar Pokémon**, aplicando conceptos fundamentales de la programación orientada a objetos y una arquitectura basada en el patrón **MVC (Modelo – Vista – Controlador)**.

El proyecto fue realizado con fines académicos y está orientado a reforzar el uso de buenas prácticas de programación, así como la correcta separación de responsabilidades dentro del código.

## Objetivo del proyecto
El objetivo principal de esta Pokedex es **aplicar los conceptos vistos en clase** relacionados con:

- Programación Orientada a Objetos
- Manejo de datos
- Organización del código en capas
- Persistencia básica de información

Además, el proyecto busca simular el funcionamiento de una Pokedex de manera sencilla, priorizando la comprensión del código sobre la complejidad del sistema.

## Funcionamiento general
El sistema permite al usuario interactuar con una interfaz gráfica donde puede:

- Agregar Pokémon al sistema  
- Visualizar la información de los Pokémon registrados  
- Gestionar los datos de forma ordenada  

Internamente, el programa utiliza una estructura bien definida donde:

- **La vista** se encarga de la interfaz gráfica y la interacción con el usuario.
- **El controlador** gestiona la comunicación entre la vista y el modelo.
- **El modelo** administra los datos, la lógica del sistema y la persistencia de la información.

La información de los Pokémon se maneja a través de objetos y se apoya en clases DAO y DTO para un mejor control de los datos.

## Estructura del proyecto
El proyecto está organizado en paquetes siguiendo una arquitectura clara:

- `controller`: contiene las clases que controlan el flujo del programa.
- `model`: gestiona la lógica del sistema y los objetos principales.  
  - `persistence`: maneja el guardado y recuperación de información.
- `view`: contiene las clases relacionadas con la interfaz gráfica.
- `DTO`: representa los objetos de transferencia de datos.
- `DAO`: se encarga del acceso y manejo de los datos.

Esta organización facilita la lectura del código y el mantenimiento del proyecto.

## Conceptos aplicados
Durante el desarrollo de este proyecto se aplicaron los siguientes conceptos:

- Programación Orientada a Objetos (POO)
- Clases y objetos
- Encapsulamiento
- Separación de responsabilidades
- Patrón de diseño MVC
- Uso de DAO y DTO
- Manejo de archivos
- Interfaces gráficas en Java (Swing)

## Tecnologías utilizadas
- Lenguaje de programación: **Java**
- Entorno de desarrollo: **Eclipse IDE**
- Paradigma: **Programación Orientada a Objetos**
- Interfaz gráfica: **Java Swing**

## Enfoque académico
Este proyecto tiene un enfoque **educativo**, por lo que no busca replicar una Pokedex real a nivel comercial. Su finalidad es demostrar el aprendizaje adquirido durante el curso y la correcta aplicación de los conceptos fundamentales de programación.

## Autor
**Nombre:** Daniel Nova Reina  
Proyecto académico – Programación en Java  