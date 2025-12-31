/*
 * 
 */
package co.edu.unbosque.model.persistence;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface CrudOperation.
 *
 * @param <T> the generic type
 */
public interface CrudOperation<T> {
	
	/**
	 * Agregar.
	 *
	 * @param objeto the objeto
	 */
	public void agregar(T objeto);

	/**
	 * Obtener.
	 *
	 * @return the list
	 */
	public List<T> obtener();

	/**
	 * Actualizar.
	 *
	 * @param indice the indice
	 * @param objeto the objeto
	 */
	public void actualizar(int indice, T objeto);

	/**
	 * Eliminar.
	 *
	 * @param indice the indice
	 */
	public void eliminar(int indice);
}
