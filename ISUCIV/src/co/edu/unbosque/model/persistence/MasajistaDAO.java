/*
 * 
 */
package co.edu.unbosque.model.persistence;

import java.util.List;

import co.edu.unbosque.model.Masajista;

// TODO: Auto-generated Javadoc
/**
 * The Class MasajistaDAO.
 */
public class MasajistaDAO implements CrudOperation<Masajista> {
	
	/** The lista de masajistas. */
	private List<Masajista> listaDeMasajistas;

	/**
	 * Instantiates a new masajista DAO.
	 */
	public MasajistaDAO() {
		listaDeMasajistas = FileHandler.leerBinario("BDMasajistas.out");
	}

	/**
	 * Obtener por numero de documento.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @return the masajista
	 */
	public Masajista obtenerPorNumeroDeDocumento(String numeroDeDocumento) {
		for (Masajista masajista : listaDeMasajistas) {
			if (masajista.getNumeroDeDocumento().equals(numeroDeDocumento)) {
				return masajista;
			}
		}
		return null;
	}

	/**
	 * Agregar.
	 *
	 * @param masajista the masajista
	 */
	@Override
	public void agregar(Masajista masajista) {
		listaDeMasajistas.add(masajista);
		FileHandler.escribirBinario(listaDeMasajistas, "BDMasajistas.out");
	}

	/**
	 * Obtener.
	 *
	 * @return the list
	 */
	@Override
	public List<Masajista> obtener() {
		listaDeMasajistas = FileHandler.leerBinario("BDMasajistas.out");
		return listaDeMasajistas;
	}

	/**
	 * Actualizar.
	 *
	 * @param indice the indice
	 * @param masajista the masajista
	 */
	@Override
	public void actualizar(int indice, Masajista masajista) {
		listaDeMasajistas.set(indice, masajista);
		FileHandler.escribirBinario(listaDeMasajistas, "BDMasajistas.out");
	}

	/**
	 * Eliminar.
	 *
	 * @param indice the indice
	 */
	@Override
	public void eliminar(int indice) {
		listaDeMasajistas.remove(indice);
		FileHandler.escribirBinario(listaDeMasajistas, "BDMasajistas.out");
	}

	/**
	 * Gets the lista de masajistas.
	 *
	 * @return the lista de masajistas
	 */
	public List<Masajista> getListaDeMasajistas() {
		return listaDeMasajistas;
	}

	/**
	 * Sets the lista de masajistas.
	 *
	 * @param listaDeMasajistas the new lista de masajistas
	 */
	public void setListaDeMasajistas(List<Masajista> listaDeMasajistas) {
		this.listaDeMasajistas = listaDeMasajistas;
	}

}
