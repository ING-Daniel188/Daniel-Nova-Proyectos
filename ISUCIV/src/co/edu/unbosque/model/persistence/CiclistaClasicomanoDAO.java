/*
 * 
 */
package co.edu.unbosque.model.persistence;

import java.util.List;

import co.edu.unbosque.model.CiclistaClasicomano;

// TODO: Auto-generated Javadoc
/**
 * The Class CiclistaClasicomanoDAO.
 */
public class CiclistaClasicomanoDAO implements CrudOperation<CiclistaClasicomano> {
	
	/** The lista de ciclistas clasicomanos. */
	private List<CiclistaClasicomano> listaDeCiclistasClasicomanos;

	/**
	 * Instantiates a new ciclista clasicomano DAO.
	 */
	public CiclistaClasicomanoDAO() {
		listaDeCiclistasClasicomanos = FileHandler.leerBinario("BDCiclistasClasicomanos.out");
	}

	/**
	 * Obtener por numero de documento.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @return the ciclista clasicomano
	 */
	public CiclistaClasicomano obtenerPorNumeroDeDocumento(String numeroDeDocumento) {
		for (CiclistaClasicomano ciclistaClasicomano : listaDeCiclistasClasicomanos) {
			if (ciclistaClasicomano.getNumeroDeDocumento().equals(numeroDeDocumento)) {
				return ciclistaClasicomano;
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
	public void agregar(CiclistaClasicomano ciclista) {
		listaDeCiclistasClasicomanos.add(ciclista);
		FileHandler.escribirBinario(listaDeCiclistasClasicomanos, "BDCiclistasClasicomanos.out");
	}

	/**
	 * Obtener.
	 *
	 * @return the list
	 */
	@Override
	public List<CiclistaClasicomano> obtener() {
		listaDeCiclistasClasicomanos = FileHandler.leerBinario("BDCiclistasClasicomanos.out");
		return listaDeCiclistasClasicomanos;
	}

	/**
	 * Actualizar.
	 *
	 * @param indice the indice
	 * @param ciclista the ciclista
	 */
	@Override
	public void actualizar(int indice, CiclistaClasicomano ciclista) {
		listaDeCiclistasClasicomanos.set(indice, ciclista);
		FileHandler.escribirBinario(listaDeCiclistasClasicomanos, "BDCiclistasClasicomanos.out");
	}

	/**
	 * Eliminar.
	 *
	 * @param indice the indice
	 */
	@Override
	public void eliminar(int indice) {
		listaDeCiclistasClasicomanos.remove(indice);
		FileHandler.escribirBinario(listaDeCiclistasClasicomanos, "BDCiclistasClasicomanos.out");
	}

	/**
	 * Gets the lista de ciclistas clasicomanos.
	 *
	 * @return the lista de ciclistas clasicomanos
	 */
	public List<CiclistaClasicomano> getListaDeCiclistasClasicomanos() {
		return listaDeCiclistasClasicomanos;
	}

	/**
	 * Sets the lista de ciclistas clasicomanos.
	 *
	 * @param listaDeCiclistasClasicomanos the new lista de ciclistas clasicomanos
	 */
	public void setListaDeCiclistasClasicomanos(List<CiclistaClasicomano> listaDeCiclistasClasicomanos) {
		this.listaDeCiclistasClasicomanos = listaDeCiclistasClasicomanos;
	}

}
