package co.edu.unbosque.model.persistence;

/**
 * Esta interfaz define las operaciones básicas de CRUD (Crear, Leer, Actualizar, Eliminar) 
 * para manejar colecciones de objetos de un tipo genérico. Proporciona métodos para agregar 
 * un nuevo objeto, obtener un objeto por su índice, actualizar un objeto existente en un 
 * índice específico y eliminar un objeto de un índice dado. Estas operaciones facilitan 
 * la manipulación de datos y la gestión de colecciones de objetos en aplicaciones de software.
 * 
 * @param <T> El tipo de objeto que se manejará en las operaciones CRUD. Este tipo es genérico 
 * y puede ser cualquier clase que extienda de {@code Object}.
 */
public interface ICrud<T extends Object> {
	
    /**
     * Agrega un nuevo objeto al conjunto de datos.
     * 
     * @param objeto el objeto de tipo T a agregar.
     */
	public void agregar(T objeto);
	
    /**
     * Obtiene un objeto por su índice.
     * 
     * @param indice el índice del objeto a obtener.
     * @return el objeto de tipo T en el índice especificado.
     */
	public T obtener(int indice);
	
    /**
     * Actualiza un objeto existente en un índice específico.
     * 
     * @param indice el índice del objeto a actualizar.
     * @param objeto el nuevo objeto de tipo T que reemplazará al existente.
     * @return true si el objeto fue actualizado exitosamente, false en caso contrario.
     */
	public boolean actualizar(int indice, T objeto);
	
    /**
     * Elimina un objeto de un índice dado.
     * 
     * @param indice el índice del objeto a eliminar.
     * @return true si el objeto fue eliminado exitosamente, false en caso contrario.
     */
	public boolean eliminar(int indice);
}
