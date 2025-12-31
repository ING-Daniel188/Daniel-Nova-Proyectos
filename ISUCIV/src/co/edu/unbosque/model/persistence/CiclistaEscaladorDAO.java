/*
 * 
 */
package co.edu.unbosque.model.persistence;

import java.util.List;

import co.edu.unbosque.model.CiclistaEscalador;

// TODO: Auto-generated Javadoc
/**
 * The Class CiclistaEscaladorDAO.
 */
public class CiclistaEscaladorDAO implements CrudOperation<CiclistaEscalador> {
	
	/** The lista de ciclistas escaladores. */
	private List<CiclistaEscalador> listaDeCiclistasEscaladores;

	/**
	 * Instantiates a new ciclista escalador DAO.
	 */
	public CiclistaEscaladorDAO() {
		listaDeCiclistasEscaladores = FileHandler.leerBinario("BDCiclistasEscaladores.out");
	}

	/**
	 * Obtener por numero de documento.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @return the ciclista escalador
	 */
	public CiclistaEscalador obtenerPorNumeroDeDocumento(String numeroDeDocumento) {
		for (CiclistaEscalador ciclistaEscalador : listaDeCiclistasEscaladores) {
			if (ciclistaEscalador.getNumeroDeDocumento().equals(numeroDeDocumento)) {
				return ciclistaEscalador;
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
	public void agregar(CiclistaEscalador ciclista) {
		listaDeCiclistasEscaladores.add(ciclista);
		FileHandler.escribirBinario(listaDeCiclistasEscaladores, "BDCiclistasEscaladores.out");
	}

	/**
	 * Obtener.
	 *
	 * @return the list
	 */
	@Override
	public List<CiclistaEscalador> obtener() {
		listaDeCiclistasEscaladores = FileHandler.leerBinario("BDCiclistasEscaladores.out");
		return listaDeCiclistasEscaladores;
	}

	/**
	 * Actualizar.
	 *
	 * @param indice the indice
	 * @param ciclista the ciclista
	 */
	@Override
	public void actualizar(int indice, CiclistaEscalador ciclista) {
		listaDeCiclistasEscaladores.set(indice, ciclista);
		FileHandler.escribirBinario(listaDeCiclistasEscaladores, "BDCiclistasEscaladores.out");
	}

	/**
	 * Eliminar.
	 *
	 * @param indice the indice
	 */
	@Override
	public void eliminar(int indice) {
		listaDeCiclistasEscaladores.remove(indice);
		FileHandler.escribirBinario(listaDeCiclistasEscaladores, "BDCiclistasEscaladores.out");
	}

	/**
	 * Gets the lista de ciclistas escaladores.
	 *
	 * @return the lista de ciclistas escaladores
	 */
	public List<CiclistaEscalador> getListaDeCiclistasEscaladores() {
		return listaDeCiclistasEscaladores;
	}

	/**
	 * Sets the lista de ciclistas escaladores.
	 *
	 * @param listaDeCiclistasEscaladores the new lista de ciclistas escaladores
	 */
	public void setListaDeCiclistasEscaladores(List<CiclistaEscalador> listaDeCiclistasEscaladores) {
		this.listaDeCiclistasEscaladores = listaDeCiclistasEscaladores;
	}

}
