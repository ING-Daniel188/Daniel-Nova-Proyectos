/*
 * 
 */
package co.edu.unbosque.model.persistence;

import java.util.List;

import co.edu.unbosque.model.DirectorDeportivo;

// TODO: Auto-generated Javadoc
/**
 * The Class DirectorDeportivoDAO.
 */
public class DirectorDeportivoDAO implements CrudOperation<DirectorDeportivo> {
	
	/** The lista de directores deportivos. */
	private List<DirectorDeportivo> listaDeDirectoresDeportivos;

	/**
	 * Instantiates a new director deportivo DAO.
	 */
	public DirectorDeportivoDAO() {
		listaDeDirectoresDeportivos = FileHandler.leerBinario("BDDirectoresDeportivos.out");
	}

	/**
	 * Obtener por numero de documento.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @return the director deportivo
	 */
	public DirectorDeportivo obtenerPorNumeroDeDocumento(String numeroDeDocumento) {
		for (DirectorDeportivo directorDeportivo : listaDeDirectoresDeportivos) {
			if (directorDeportivo.getNumeroDeDocumento().equals(numeroDeDocumento)) {
				return directorDeportivo;
			}
		}
		return null;
	}

	/**
	 * Agregar.
	 *
	 * @param directorDeportivo the director deportivo
	 */
	@Override
	public void agregar(DirectorDeportivo directorDeportivo) {
		listaDeDirectoresDeportivos.add(directorDeportivo);
		FileHandler.escribirBinario(listaDeDirectoresDeportivos, "BDDirectoresDeportivos.out");
	}

	/**
	 * Obtener.
	 *
	 * @return the list
	 */
	@Override
	public List<DirectorDeportivo> obtener() {
		listaDeDirectoresDeportivos = FileHandler.leerBinario("BDDirectoresDeportivos.out");
		return listaDeDirectoresDeportivos;
	}

	/**
	 * Actualizar.
	 *
	 * @param indice the indice
	 * @param directorDeportivo the director deportivo
	 */
	@Override
	public void actualizar(int indice, DirectorDeportivo directorDeportivo) {
		listaDeDirectoresDeportivos.set(indice, directorDeportivo);
		FileHandler.escribirBinario(listaDeDirectoresDeportivos, "BDDirectoresDeportivos.out");
	}

	/**
	 * Eliminar.
	 *
	 * @param indice the indice
	 */
	@Override
	public void eliminar(int indice) {
		listaDeDirectoresDeportivos.remove(indice);
		FileHandler.escribirBinario(listaDeDirectoresDeportivos, "BDDirectoresDeportivos.out");
	}

	/**
	 * Gets the lista de directores deportivos.
	 *
	 * @return the lista de directores deportivos
	 */
	public List<DirectorDeportivo> getListaDeDirectoresDeportivos() {
		return listaDeDirectoresDeportivos;
	}

	/**
	 * Sets the lista de directores deportivos.
	 *
	 * @param listaDeDirectoresDeportivos the new lista de directores deportivos
	 */
	public void setListaDeDirectoresDeportivos(List<DirectorDeportivo> listaDeDirectoresDeportivos) {
		this.listaDeDirectoresDeportivos = listaDeDirectoresDeportivos;
	}

}
