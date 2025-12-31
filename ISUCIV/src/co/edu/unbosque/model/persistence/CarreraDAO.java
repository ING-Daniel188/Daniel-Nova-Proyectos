/*
 * 
 */
package co.edu.unbosque.model.persistence;

import java.util.List;

import co.edu.unbosque.model.Carrera;

// TODO: Auto-generated Javadoc
/**
 * The Class CarreraDAO.
 */
public class CarreraDAO implements CrudOperation<Carrera> {
	
	/** The lista de carreras. */
	private List<Carrera> listaDeCarreras;

	/**
	 * Instantiates a new carrera DAO.
	 */
	public CarreraDAO() {
		this.listaDeCarreras = FileHandler.leerBinario("BDCarreras.out");
	}

	/**
	 * Agregar.
	 *
	 * @param carrera the carrera
	 */
	@Override
	public void agregar(Carrera carrera) {
		listaDeCarreras.add(carrera);
		FileHandler.escribirBinario(listaDeCarreras, "BDCarreras.out");
	}

	/**
	 * Obtener.
	 *
	 * @return the list
	 */
	@Override
	public List<Carrera> obtener() {
		listaDeCarreras = FileHandler.leerBinario("BDCarreras.out");
		return listaDeCarreras;
	}

	/**
	 * Actualizar.
	 *
	 * @param indice the indice
	 * @param carrera the carrera
	 */
	@Override
	public void actualizar(int indice, Carrera carrera) {
		listaDeCarreras.set(indice, carrera);
		FileHandler.escribirBinario(listaDeCarreras, "BDCarreras.out");
	}

	/**
	 * Eliminar.
	 *
	 * @param indice the indice
	 */
	@Override
	public void eliminar(int indice) {
		listaDeCarreras.remove(indice);
		FileHandler.escribirBinario(listaDeCarreras, "BDCarreras.out");
	}

}
