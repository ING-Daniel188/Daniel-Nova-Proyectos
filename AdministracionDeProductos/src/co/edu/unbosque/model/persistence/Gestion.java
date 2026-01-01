package co.edu.unbosque.model.persistence;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Implementacion de la interfaz ICrud usando un ArrayList para almacenamiento.
 * 
 * @param <T> El tipo de objeto.
 */
public class Gestion<T extends Object> implements ICrud<T> {

	/** The lista objetos. */
	private ArrayList<T> listaObjetos;
	
	/** The indice A actualizar. */
	private int indiceAActualizar;

	/**
	 * Instantiates a new gestion.
	 */
	public Gestion() {
		this.listaObjetos = new ArrayList<>();
	}

	/**
	 * Agregar.
	 *
	 * @param objeto the objeto
	 */
	@Override
	public void agregar(T objeto) {
		if (objeto != null) {
			listaObjetos.add(objeto);
		}
	}

	/**
	 * Obtener.
	 *
	 * @param indice the indice
	 * @return the t
	 */
	@Override
	public T obtener(int indice) {
		if (indice >= 0 && indice < listaObjetos.size()) {
			return listaObjetos.get(indice);
		}
		return null;
	}

	/**
	 * Actualizar.
	 *
	 * @param indice the indice
	 * @param objeto the objeto
	 * @return true, if successful
	 */
	@Override
	public boolean actualizar(int indice, T objeto) {
		if (indice >= 0 && indice < listaObjetos.size() && objeto != null) {
			listaObjetos.set(indice, objeto);
			return true;
		}
		return false;
	}

	/**
	 * Eliminar.
	 *
	 * @param indice the indice
	 * @return true, if successful
	 */
	@Override
	public boolean eliminar(int indice) {
		if (indice >= 0 && indice < listaObjetos.size()) {
			listaObjetos.remove(indice);
			return true;
		}
		return false;
	}

	/**
	 * Obtener objetos.
	 *
	 * @return the object[][]
	 */
	public Object[][] obtenerObjetos() {
		int numeroObjetos = getListaObjetos().size();
		int numeroAtributos = 0;

		if (numeroObjetos > 0) {
			numeroAtributos = obtenerTodosLosAtributos(getListaObjetos().get(0).getClass()).length;
		}

		Object[][] objetos = new Object[numeroObjetos][numeroAtributos];

		for (int i = 0; i < numeroObjetos; i++) {
			T t = getListaObjetos().get(i);
			Field[] atributos = obtenerTodosLosAtributos(t.getClass());

			for (int j = 0; j < numeroAtributos; j++) {
				try {
					atributos[j].setAccessible(true);
					objetos[i][j] = atributos[j].get(t);
				} catch (IllegalAccessException e) {
					return null;
				}
			}
		}

		return objetos;
	}

	/**
	 * Obtener todos los atributos.
	 *
	 * @param clase the clase
	 * @return the field[]
	 */
	public Field[] obtenerTodosLosAtributos(Class<?> clase) {
		ArrayList<Field> atributos = new ArrayList<>();

		ArrayList<Class<?>> clases = new ArrayList<>();
		while (clase != null) {
			clases.add(clase);
			clase = clase.getSuperclass();
		}

		Collections.reverse(clases);

		for (Class<?> type : clases) {
			for (Field atributo : type.getDeclaredFields()) {
				atributos.add(atributo);
			}
		}

		return atributos.toArray(new Field[0]);
	}

	/**
	 * Gets the lista objetos.
	 *
	 * @return the lista objetos
	 */
	public ArrayList<T> getListaObjetos() {
		return listaObjetos;
	}

	/**
	 * Gets the indice A actualizar.
	 *
	 * @return the indice A actualizar
	 */
	public int getIndiceAActualizar() {
		return indiceAActualizar;
	}

	/**
	 * Sets the indice A actualizar.
	 *
	 * @param objetoAActualizar the new indice A actualizar
	 */
	public void setIndiceAActualizar(T objetoAActualizar) {
		this.indiceAActualizar = listaObjetos.indexOf(objetoAActualizar);
	}

}
