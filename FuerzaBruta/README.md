# Proyecto: Búsqueda de Texto – Fuerza Bruta vs KMP

## Descripción general

Este proyecto fue desarrollado con el objetivo de analizar y comparar dos algoritmos de búsqueda de texto:  
el método Fuerza Bruta y el algoritmo Knuth-Morris-Pratt (KMP).

La idea principal del proyecto es mostrar, de forma práctica, cómo diferentes enfoques algorítmicos pueden afectar el rendimiento al buscar una palabra o patrón dentro de un texto, especialmente cuando el volumen de datos aumenta.

Este trabajo hace parte de un ejercicio académico enfocado en comprender la complejidad algorítmica, no solo desde la teoría, sino también desde la implementación real.


## Objetivo del proyecto

- Implementar el algoritmo de búsqueda Fuerza Bruta.
- Implementar el algoritmo KMP.
- Comparar ambos métodos en términos de:
  - Tiempo de ejecución
  - Número de comparaciones
  - Eficiencia general
- Evidenciar por qué KMP es más eficiente que Fuerza Bruta en ciertos escenarios.


## ¿Por qué estos algoritmos?

- Fuerza Bruta es sencillo de entender e implementar, pero poco eficiente cuando los textos son largos.
- KMP utiliza información previa del patrón para evitar comparaciones innecesarias, logrando un mejor rendimiento.

Compararlos permite entender claramente la importancia de diseñar algoritmos optimizados.


## Tecnologías utilizadas

- Lenguaje: Java  
- Interfaz gráfica: Java Swing  
- Arquitectura: MVC (Modelo – Vista – Controlador)  
- Paradigma: Programación orientada a objetos


## Estructura del proyecto

El proyecto está organizado de manera que el código sea fácil de entender y mantener:

- Modelo: lógica de los algoritmos de búsqueda
- Vista: interfaz gráfica para la interacción con el usuario
- Controlador: conexión entre la vista y la lógica del sistema


## Funcionamiento general

1. El usuario ingresa un texto o selecciona un archivo.
2. Se define el patrón que se desea buscar.
3. El sistema ejecuta la búsqueda usando:
   - Fuerza Bruta
   - KMP
4. Se muestran los resultados y métricas de cada algoritmo para poder compararlos.


## Resultados esperados

- Visualizar claramente la diferencia de rendimiento entre ambos algoritmos.
- Comprobar que KMP reduce el número de comparaciones frente al método de Fuerza Bruta.
- Reforzar conceptos de eficiencia y complejidad algorítmica.


## Contexto académico

Este proyecto fue desarrollado para fortalecer la comprensión práctica de los algoritmos de búsqueda de patrones y su impacto en el rendimiento de los sistemas.


## Autor

Daniel Nova Reina  
Estudiante de Ingeniería de Sistemas  
Universidad El Bosque