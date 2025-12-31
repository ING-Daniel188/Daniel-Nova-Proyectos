/*
 * 
 */
package co.edu.unbosque.model.persistence;

import java.util.List;

import co.edu.unbosque.model.CiclistaRodador;

// TODO: Auto-generated Javadoc
/**
 * The Class CiclistaRodadorDAO.
 */
public class CiclistaRodadorDAO implements CrudOperation<CiclistaRodador> {
	
	/** The lista de ciclistas rodadores. */
	private List<CiclistaRodador> listaDeCiclistasRodadores;

	/**
	 * Instantiates a new ciclista rodador DAO.
	 */
	public CiclistaRodadorDAO() {
		listaDeCiclistasRodadores = FileHandler.leerBinario("BDCiclistasRodadores.out");
	}

	/**
	 * Obtener por numero de documento.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @return the ciclista rodador
	 */
	public CiclistaRodador obtenerPorNumeroDeDocumento(String numeroDeDocumento) {
		for (CiclistaRodador ciclistaRodador : listaDeCiclistasRodadores) {
			if (ciclistaRodador.getNumeroDeDocumento().equals(numeroDeDocumento)) {
				return ciclistaRodador;
			}
		}
		return null;
	}

	/**
	 * Agregar.
	 *
	 * @param ciclista the ciclista
	 */
	@Override
	public void agregar(CiclistaRodador ciclista) {
		listaDeCiclistasRodadores.add(ciclista);
		FileHandler.escribirBinario(listaDeCiclistasRodadores, "BDCiclistasRodadores.out");
	}

	/**
	 * Obtener.
	 *
	 * @return the list
	 */
	@Override
	public List<CiclistaRodador> obtener() {
		listaDeCiclistasRodadores = FileHandler.leerBinario("BDCiclistasRodadores.out");
		return listaDeCiclistasRodadores;
	}

	/**
	 * Actualizar.
	 *
	 * @param indice the indice
	 * @param ciclista the ciclista
	 */
	@Override
	public void actualizar(int indice, CiclistaRodador ciclista) {
		listaDeCiclistasRodadores.set(indice, ciclista);
		FileHandler.escribirBinario(listaDeCiclistasRodadores, "BDCiclistasRodadores.out");
	}

	/**
	 * Eliminar.
	 *
	 * @param indice the indice
	 */
	@Override
	public void eliminar(int indice) {
		listaDeCiclistasRodadores.remove(indice);
		FileHandler.escribirBinario(listaDeCiclistasRodadores, "BDCiclistasRodadores.out");
	}

	/**
	 * Gets the lista de ciclistas rodadores.
	 *
	 * @return the lista de ciclistas rodadores
	 */
	public List<CiclistaRodador> getListaDeCiclistasRodadores() {
		return listaDeCiclistasRodadores;
	}

	/**
	 * Sets the lista de ciclistas rodadores.
	 *
	 * @param listaDeCiclistasRodadores the new lista de ciclistas rodadores
	 */
	public void setListaDeCiclistasRodadores(List<CiclistaRodador> listaDeCiclistasRodadores) {
		this.listaDeCiclistasRodadores = listaDeCiclistasRodadores;
	}

}
