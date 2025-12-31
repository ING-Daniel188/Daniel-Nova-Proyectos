/*
 * 
 */
package co.edu.unbosque.model.persistence;

import java.util.List;

import co.edu.unbosque.model.CiclistaGregario;

// TODO: Auto-generated Javadoc
/**
 * The Class CiclistaGregarioDAO.
 */
public class CiclistaGregarioDAO implements CrudOperation<CiclistaGregario> {
	
	/** The lista de ciclistas gregarios. */
	private List<CiclistaGregario> listaDeCiclistasGregarios;

	/**
	 * Instantiates a new ciclista gregario DAO.
	 */
	public CiclistaGregarioDAO() {
		listaDeCiclistasGregarios = FileHandler.leerBinario("BDCiclistasGregarios.out");
	}

	/**
	 * Obtener por numero de documento.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @return the ciclista gregario
	 */
	public CiclistaGregario obtenerPorNumeroDeDocumento(String numeroDeDocumento) {
		for (CiclistaGregario ciclistaGregario : listaDeCiclistasGregarios) {
			if (ciclistaGregario.getNumeroDeDocumento().equals(numeroDeDocumento)) {
				return ciclistaGregario;
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
	public void agregar(CiclistaGregario ciclista) {
		listaDeCiclistasGregarios.add(ciclista);
		FileHandler.escribirBinario(listaDeCiclistasGregarios, "BDCiclistasGregarios.out");
	}

	/**
	 * Obtener.
	 *
	 * @return the list
	 */
	@Override
	public List<CiclistaGregario> obtener() {
		listaDeCiclistasGregarios = FileHandler.leerBinario("BDCiclistasGregarios.out");
		return listaDeCiclistasGregarios;
	}

	/**
	 * Actualizar.
	 *
	 * @param indice the indice
	 * @param ciclista the ciclista
	 */
	@Override
	public void actualizar(int indice, CiclistaGregario ciclista) {
		listaDeCiclistasGregarios.set(indice, ciclista);
		FileHandler.escribirBinario(listaDeCiclistasGregarios, "BDCiclistasGregarios.out");
	}

	/**
	 * Eliminar.
	 *
	 * @param indice the indice
	 */
	@Override
	public void eliminar(int indice) {
		listaDeCiclistasGregarios.remove(indice);
		FileHandler.escribirBinario(listaDeCiclistasGregarios, "BDCiclistasGregarios.out");
	}

	/**
	 * Gets the lista de ciclistas gregarios.
	 *
	 * @return the lista de ciclistas gregarios
	 */
	public List<CiclistaGregario> getListaDeCiclistasGregarios() {
		return listaDeCiclistasGregarios;
	}

	/**
	 * Sets the lista de ciclistas gregarios.
	 *
	 * @param listaDeCiclistasGregarios the new lista de ciclistas gregarios
	 */
	public void setListaDeCiclistasGregarios(List<CiclistaGregario> listaDeCiclistasGregarios) {
		this.listaDeCiclistasGregarios = listaDeCiclistasGregarios;
	}

}
