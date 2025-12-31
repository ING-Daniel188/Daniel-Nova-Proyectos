/*
 * 
 */
package co.edu.unbosque.model.persistence;

import java.util.List;

import co.edu.unbosque.model.Ciclista;
import co.edu.unbosque.model.DirectorDeportivo;
import co.edu.unbosque.model.Escuadra;
import co.edu.unbosque.model.Masajista;

// TODO: Auto-generated Javadoc
/**
 * The Class EscuadraDAO.
 */
public class EscuadraDAO implements CrudOperation<Escuadra> {
	
	/** The lista de escuadras. */
	private List<Escuadra> listaDeEscuadras;

	/**
	 * Instantiates a new escuadra DAO.
	 */
	public EscuadraDAO() {
		listaDeEscuadras = FileHandler.leerBinario("BDEscuadras.out");
	}

	/**
	 * Obtener por nombre.
	 *
	 * @param nombre the nombre
	 * @return the escuadra
	 */
	public Escuadra obtenerPorNombre(String nombre) {
		listaDeEscuadras = FileHandler.leerBinario("BDEscuadras.out");
		for (Escuadra escuadra : listaDeEscuadras) {
			if (escuadra.getNombre().equalsIgnoreCase(nombre)) {
				return escuadra;
			}
		}
		return null;
	}

	/**
	 * Ciclista ya en escuadra.
	 *
	 * @param ciclista the ciclista
	 * @param escuadra the escuadra
	 * @return true, if successful
	 */
	public boolean ciclistaYaEnEscuadra(Ciclista ciclista, Escuadra escuadra) {
		listaDeEscuadras = FileHandler.leerBinario("BDEscuadras.out");
		for (Ciclista ciclistaExistente : escuadra.getCiclistas()) {
			if (ciclistaExistente.getNumeroDeDocumento().equals(ciclista.getNumeroDeDocumento())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Agregar ciclista A escuadra.
	 *
	 * @param ciclista the ciclista
	 * @param escuadra the escuadra
	 */
	public void agregarCiclistaAEscuadra(Ciclista ciclista, Escuadra escuadra) {
		if (!ciclistaYaEnEscuadra(ciclista, escuadra)) {
			for (Escuadra escuadraExistente : listaDeEscuadras) {
				if (escuadraExistente.getNombre().equals(escuadra.getNombre())) {
					List<Ciclista> ciclistas = escuadraExistente.getCiclistas();
					ciclistas.add(ciclista);
					escuadraExistente.setCiclistas(ciclistas);
				}
			}
			actualizarSumaDeTiempos();
			FileHandler.escribirBinario(listaDeEscuadras, "BDEscuadras.out");
		}
	}

	/**
	 * Eliminar ciclista de escuadra.
	 *
	 * @param ciclista the ciclista
	 * @param escuadra the escuadra
	 */
	public void eliminarCiclistaDeEscuadra(Ciclista ciclista, Escuadra escuadra) {
		if (ciclistaYaEnEscuadra(ciclista, escuadra)) {
			for (Escuadra escuadraExistente : listaDeEscuadras) {
				if (escuadraExistente.getNombre().equals(escuadra.getNombre())) {
					List<Ciclista> ciclistas = escuadraExistente.getCiclistas();
					for (Ciclista ciclistaExistente : ciclistas) {
						if (ciclistaExistente.getNumeroDeDocumento().equals(ciclista.getNumeroDeDocumento())) {
							ciclistas.remove(ciclistaExistente);
							break;
						}
					}
					escuadraExistente.setCiclistas(ciclistas);
				}
			}
			actualizarSumaDeTiempos();
			FileHandler.escribirBinario(listaDeEscuadras, "BDEscuadras.out");
		}
	}

	/**
	 * Actualizar suma de tiempos.
	 */
	public void actualizarSumaDeTiempos() {
		for (Escuadra escuadra : listaDeEscuadras) {
			int sumaDeTiempos = 0;
			for (Ciclista ciclista : escuadra.getCiclistas()) {
				sumaDeTiempos += ciclista.getTiempoAcumuladoDeCarrera();
			}
			escuadra.setSumaTiemposAcumulados(sumaDeTiempos);
		}
	}

	/**
	 * Masajista ya en escuadra.
	 *
	 * @param masajista the masajista
	 * @param escuadra the escuadra
	 * @return true, if successful
	 */
	public boolean masajistaYaEnEscuadra(Masajista masajista, Escuadra escuadra) {
		for (Escuadra escuadraExistente : listaDeEscuadras) {
			if (escuadraExistente.getNombre().equals(escuadra.getNombre())) {
				if (escuadraExistente.getMasajista() != null) {
					if (escuadraExistente.getMasajista().getNumeroDeDocumento()
							.equals(masajista.getNumeroDeDocumento())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Agregar masajista A escuadra.
	 *
	 * @param masajista the masajista
	 * @param escuadra the escuadra
	 */
	public void agregarMasajistaAEscuadra(Masajista masajista, Escuadra escuadra) {
		if (!masajistaYaEnEscuadra(masajista, escuadra)) {
			for (Escuadra escuadraExistente : listaDeEscuadras) {
				if (escuadraExistente.getNombre().equals(escuadra.getNombre())) {
					escuadraExistente.setMasajista(masajista);
					break;
				}
			}
			FileHandler.escribirBinario(listaDeEscuadras, "BDEscuadras.out");
		}
	}

	/**
	 * Director ya en escuadra.
	 *
	 * @param director the director
	 * @param escuadra the escuadra
	 * @return true, if successful
	 */
	public boolean directorYaEnEscuadra(DirectorDeportivo director, Escuadra escuadra) {
		for (Escuadra escuadraExistente : listaDeEscuadras) {
			if (escuadraExistente.getNombre().equals(escuadra.getNombre())) {
				if (escuadraExistente.getDirectorDeportivo() != null) {
					if (escuadraExistente.getDirectorDeportivo().getNumeroDeDocumento()
							.equals(director.getNumeroDeDocumento())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Agregar director A escuadra.
	 *
	 * @param director the director
	 * @param escuadra the escuadra
	 */
	public void agregarDirectorAEscuadra(DirectorDeportivo director, Escuadra escuadra) {
		if (!directorYaEnEscuadra(director, escuadra)) {
			for (Escuadra escuadraExistente : listaDeEscuadras) {
				if (escuadraExistente.getNombre().equals(escuadra.getNombre())) {
					escuadraExistente.setDirectorDeportivo(director);
					break;
				}
			}
			FileHandler.escribirBinario(listaDeEscuadras, "BDEscuadras.out");
		}
	}

	/**
	 * Agregar.
	 *
	 * @param escuadra the escuadra
	 */
	@Override
	public void agregar(Escuadra escuadra) {
		listaDeEscuadras.add(escuadra);
		FileHandler.escribirBinario(listaDeEscuadras, "BDEscuadras.out");
	}

	/**
	 * Obtener.
	 *
	 * @return the list
	 */
	@Override
	public List<Escuadra> obtener() {
		listaDeEscuadras = FileHandler.leerBinario("BDEscuadras.out");
		return listaDeEscuadras;
	}

	/**
	 * Actualizar.
	 *
	 * @param indice the indice
	 * @param escuadra the escuadra
	 */
	@Override
	public void actualizar(int indice, Escuadra escuadra) {
		listaDeEscuadras.set(indice, escuadra);
		FileHandler.escribirBinario(listaDeEscuadras, "BDEscuadras.out");
	}

	/**
	 * Eliminar.
	 *
	 * @param indice the indice
	 */
	@Override
	public void eliminar(int indice) {
		listaDeEscuadras.remove(indice);
		FileHandler.escribirBinario(listaDeEscuadras, "BDEscuadras.out");
	}

	/**
	 * Gets the lista de escuadras.
	 *
	 * @return the lista de escuadras
	 */
	public List<Escuadra> getListaDeEscuadras() {
		return listaDeEscuadras;
	}

	/**
	 * Sets the lista de escuadras.
	 *
	 * @param listaDeEscuadras the new lista de escuadras
	 */
	public void setListaDeEscuadras(List<Escuadra> listaDeEscuadras) {
		this.listaDeEscuadras = listaDeEscuadras;
	}

}
