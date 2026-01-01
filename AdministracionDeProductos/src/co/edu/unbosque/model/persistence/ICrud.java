package co.edu.unbosque.model.persistence;

/**
 * Interfaz para operaciones basicas de CRUD.
 * 
 * @param <T> El tipo de objeto.
 */
public interface ICrud<T extends Object> {
	
	/**
	 * Agregar.
	 *
	 * @param objeto the objeto
	 */
	public void agregar(T objeto);
	
	/**
	 * Obtener.
	 *
	 * @param indice the indice
	 * @return the t
	 */
	public T obtener(int indice);
	
	/**
	 * Actualizar.
	 *
	 * @param indice the indice
	 * @param objeto the objeto
	 * @return true, if successful
	 */
	public boolean actualizar(int indice, T objeto);
	
	/**
	 * Eliminar.
	 *
	 * @param indice the indice
	 * @return true, if successful
	 */
	public boolean eliminar(int indice);
}
