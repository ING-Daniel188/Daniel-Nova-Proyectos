/*
 * 
 */
package co.edu.unbosque.model.persistence;

import java.util.List;

import co.edu.unbosque.model.CiclistaContrarrelojista;

// TODO: Auto-generated Javadoc
/**
 * The Class CiclistaContrarrelojistaDAO.
 */
public class CiclistaContrarrelojistaDAO implements CrudOperation<CiclistaContrarrelojista> {
	
	/** The lista de ciclistas contrarrelojistas. */
	private List<CiclistaContrarrelojista> listaDeCiclistasContrarrelojistas;

	/**
	 * Instantiates a new ciclista contrarrelojista DAO.
	 */
	public CiclistaContrarrelojistaDAO() {
		listaDeCiclistasContrarrelojistas = FileHandler.leerBinario("BDCiclistasContrarrelojistas.out");
	}

	/**
	 * Obtener por numero de documento.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @return the ciclista contrarrelojista
	 */
	public CiclistaContrarrelojista obtenerPorNumeroDeDocumento(String numeroDeDocumento) {
		for (CiclistaContrarrelojista ciclistaContrarrelojista : listaDeCiclistasContrarrelojistas) {
			if (ciclistaContrarrelojista.getNumeroDeDocumento().equals(numeroDeDocumento)) {
				return ciclistaContrarrelojista;
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
	public void agregar(CiclistaContrarrelojista ciclista) {
		listaDeCiclistasContrarrelojistas.add(ciclista);
		FileHandler.escribirBinario(listaDeCiclistasContrarrelojistas, "BDCiclistasContrarrelojistas.out");
	}

	/**
	 * Obtener.
	 *
	 * @return the list
	 */
	@Override
	public List<CiclistaContrarrelojista> obtener() {
		listaDeCiclistasContrarrelojistas = FileHandler.leerBinario("BDCiclistasContrarrelojistas.out");
		return listaDeCiclistasContrarrelojistas;
	}

	/**
	 * Actualizar.
	 *
	 * @param indice the indice
	 * @param ciclista the ciclista
	 */
	@Override
	public void actualizar(int indice, CiclistaContrarrelojista ciclista) {
		listaDeCiclistasContrarrelojistas.set(indice, ciclista);
		FileHandler.escribirBinario(listaDeCiclistasContrarrelojistas, "BDCiclistasContrarrelojistas.out");
	}

	/**
	 * Eliminar.
	 *
	 * @param indice the indice
	 */
	@Override
	public void eliminar(int indice) {
		listaDeCiclistasContrarrelojistas.remove(indice);
		FileHandler.escribirBinario(listaDeCiclistasContrarrelojistas, "BDCiclistasContrarrelojistas.out");
	}

	/**
	 * Gets the lista de ciclistas contrarrelojistas.
	 *
	 * @return the lista de ciclistas contrarrelojistas
	 */
	public List<CiclistaContrarrelojista> getListaDeCiclistasContrarrelojistas() {
		return listaDeCiclistasContrarrelojistas;
	}

	/**
	 * Sets the lista de ciclistas contrarrelojistas.
	 *
	 * @param listaDeCiclistasContrarrelojistas the new lista de ciclistas contrarrelojistas
	 */
	public void setListaDeCiclistasContrarrelojistas(List<CiclistaContrarrelojista> listaDeCiclistasContrarrelojistas) {
		this.listaDeCiclistasContrarrelojistas = listaDeCiclistasContrarrelojistas;
	}

}
