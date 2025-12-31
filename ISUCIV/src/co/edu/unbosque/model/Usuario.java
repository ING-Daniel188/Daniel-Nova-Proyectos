package co.edu.unbosque.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
public class Usuario implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5389475301071261387L;
	
	/** The numero de documento. */
	private String numeroDeDocumento;
	
	/** The nombre. */
	private String nombre;
	
	/** The genero. */
	private String genero;
	
	/** The correo. */
	private String correo;
	
	/** The clave. */
	private String clave;

	/**
	 * Instantiates a new usuario.
	 */
	public Usuario() {

	}

	/**
	 * Instantiates a new usuario.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @param nombre the nombre
	 * @param genero the genero
	 * @param correo the correo
	 * @param clave the clave
	 */
	public Usuario(String numeroDeDocumento, String nombre, String genero, String correo, String clave) {
		this.numeroDeDocumento = numeroDeDocumento;
		this.nombre = nombre;
		this.genero = genero;
		this.correo = correo;
		this.clave = clave;
	}

	/**
	 * Gets the numero de documento.
	 *
	 * @return the numero de documento
	 */
	public String getNumeroDeDocumento() {
		return numeroDeDocumento;
	}

	/**
	 * Sets the numero de documento.
	 *
	 * @param numeroDeDocumento the new numero de documento
	 */
	public void setNumeroDeDocumento(String numeroDeDocumento) {
		this.numeroDeDocumento = numeroDeDocumento;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the genero.
	 *
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Sets the genero.
	 *
	 * @param genero the new genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Gets the correo.
	 *
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Sets the correo.
	 *
	 * @param correo the new correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Gets the clave.
	 *
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * Sets the clave.
	 *
	 * @param clave the new clave
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
