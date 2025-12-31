/*
 * 
 */
package co.edu.unbosque.model.persistence;

import java.util.List;

import co.edu.unbosque.model.CiclistaEmbalador;

// TODO: Auto-generated Javadoc
/**
 * The Class CiclistaEmbaladorDAO.
 */
public class CiclistaEmbaladorDAO implements CrudOperation<CiclistaEmbalador> {
	
	/** The lista de ciclistas embaladores. */
	private List<CiclistaEmbalador> listaDeCiclistasEmbaladores;

	/**
	 * Instantiates a new ciclista embalador DAO.
	 */
	public CiclistaEmbaladorDAO() {
		listaDeCiclistasEmbaladores = FileHandler.leerBinario("BDCiclistasEmbaladores.out");
	}

	/**
	 * Obtener por numero de documento.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @return the ciclista embalador
	 */
	public CiclistaEmbalador obtenerPorNumeroDeDocumento(String numeroDeDocumento) {
		for (CiclistaEmbalador ciclistaEmbalador : listaDeCiclistasEmbaladores) {
			if (ciclistaEmbalador.getNumeroDeDocumento().equals(numeroDeDocumento)) {
				return ciclistaEmbalador;
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
	public void agregar(CiclistaEmbalador ciclista) {
		listaDeCiclistasEmbaladores.add(ciclista);
		FileHandler.escribirBinario(listaDeCiclistasEmbaladores, "BDCiclistasEmbaladores.out");
	}

	/**
	 * Obtener.
	 *
	 * @return the list
	 */
	@Override
	public List<CiclistaEmbalador> obtener() {
		listaDeCiclistasEmbaladores = FileHandler.leerBinario("BDCiclistasEmbaladores.out");
		return listaDeCiclistasEmbaladores;
	}

	/**
	 * Actualizar.
	 *
	 * @param indice the indice
	 * @param ciclista the ciclista
	 */
	@Override
	public void actualizar(int indice, CiclistaEmbalador ciclista) {
		listaDeCiclistasEmbaladores.set(indice, ciclista);
		FileHandler.escribirBinario(listaDeCiclistasEmbaladores, "BDCiclistasEmbaladores.out");
	}

	/**
	 * Eliminar.
	 *
	 * @param indice the indice
	 */
	@Override
	public void eliminar(int indice) {
		listaDeCiclistasEmbaladores.remove(indice);
		FileHandler.escribirBinario(listaDeCiclistasEmbaladores, "BDCiclistasEmbaladores.out");
	}

	/**
	 * Gets the lista de ciclistas embaladores.
	 *
	 * @return the lista de ciclistas embaladores
	 */
	public List<CiclistaEmbalador> getListaDeCiclistasEmbaladores() {
		return listaDeCiclistasEmbaladores;
	}

	/**
	 * Sets the lista de ciclistas embaladores.
	 *
	 * @param listaDeCiclistasEmbaladores the new lista de ciclistas embaladores
	 */
	public void setListaDeCiclistasEmbaladores(List<CiclistaEmbalador> listaDeCiclistasEmbaladores) {
		this.listaDeCiclistasEmbaladores = listaDeCiclistasEmbaladores;
	}

}
