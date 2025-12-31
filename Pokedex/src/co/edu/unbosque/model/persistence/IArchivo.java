package co.edu.unbosque.model.persistence;

import java.util.List;

/**
 * Esta interfaz define las operaciones básicas para la manipulación de archivos binarios
 * que contienen colecciones de objetos de un tipo específico. Permite escribir una colección
 * de objetos al archivo y leer la colección de objetos desde el archivo. Estas operaciones
 * facilitan la persistencia de datos complejos y su recuperación en aplicaciones que requieren
 * almacenamiento y gestión de datos en formato binario.
 * 
 * @param <T> El tipo de objeto que se manejará en las operaciones de archivo, donde T debe ser
 * una colección que extiende de {@code List<?>}. Esto permite que la interfaz sea flexible y
 * pueda trabajar con diferentes tipos de colecciones de objetos.
 */
public interface IArchivo<T extends List<?>> {

    /**
     * Escribe una colección de objetos al archivo binario.
     * 
     * @param object La colección de objetos de tipo T a escribir en el archivo.
     * @return Un entero que representa el resultado de la operación de escritura. Un valor
     * positivo puede indicar éxito y la cantidad de objetos escritos, mientras que un valor
     * negativo puede indicar un fallo en la operación.
     */
    public int escribir(T object);
    
    /**
     * Lee una colección de objetos desde el archivo binario.
     * 
     * @return La colección de objetos de tipo T leída desde el archivo. Si la operación falla
     * o el archivo está vacío, puede retornar {@code null} o una colección vacía.
     */
    public T leer();
    
}
