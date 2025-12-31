/*
 * 
 */
package co.edu.unbosque.model.persistence;

import java.util.List;

import co.edu.unbosque.model.Usuario;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioDAO.
 */
public class UsuarioDAO implements CrudOperation<Usuario> {
	
	/** The lista de usuarios. */
	private List<Usuario> listaDeUsuarios;

	/**
	 * Instantiates a new usuario DAO.
	 */
	public UsuarioDAO() {
		listaDeUsuarios = FileHandler.leerBinario("BDUsuarios.out");
	}

	/**
	 * Obtener por numero de documento.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @return the usuario
	 */
	public Usuario obtenerPorNumeroDeDocumento(String numeroDeDocumento) {
		for (Usuario usuario : listaDeUsuarios) {
			if (usuario.getNumeroDeDocumento().equals(numeroDeDocumento)) {
				return usuario;
			}
		}
		return null;
	}

	/**
	 * Agregar.
	 *
	 * @param usuario the usuario
	 */
	@Override
	public void agregar(Usuario usuario) {
		listaDeUsuarios.add(usuario);
		FileHandler.escribirBinario(listaDeUsuarios, "BDUsuarios.out");
	}

	/**
	 * Obtener.
	 *
	 * @return the list
	 */
	@Override
	public List<Usuario> obtener() {
		listaDeUsuarios = FileHandler.leerBinario("BDUsuarios.out");
		return listaDeUsuarios;
	}

	/**
	 * Actualizar.
	 *
	 * @param indice the indice
	 * @param usuario the usuario
	 */
	@Override
	public void actualizar(int indice, Usuario usuario) {
		listaDeUsuarios.set(indice, usuario);
		FileHandler.escribirBinario(listaDeUsuarios, "BDUsuarios.out");
	}

	/**
	 * Eliminar.
	 *
	 * @param indice the indice
	 */
	@Override
	public void eliminar(int indice) {
		listaDeUsuarios.remove(indice);
		FileHandler.escribirBinario(listaDeUsuarios, "BDUsuarios.out");
	}

	/**
	 * Gets the lista de usuarios.
	 *
	 * @return the lista de usuarios
	 */
	public List<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}

	/**
	 * Sets the lista de usuarios.
	 *
	 * @param listaDeUsuarios the new lista de usuarios
	 */
	public void setListaDeUsuarios(List<Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}

}
