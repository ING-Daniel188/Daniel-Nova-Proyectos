package co.edu.unbosque.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class DirectorDeportivo.
 */
public class DirectorDeportivo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5375372698108803327L;
	
	/** The numero de documento. */
	private String numeroDeDocumento;
	
	/** The nombre. */
	private String nombre;
	
	/** The nacionalidad. */
	private String nacionalidad;

	/**
	 * Instantiates a new director deportivo.
	 */
	public DirectorDeportivo() {

	}

	/**
	 * Instantiates a new director deportivo.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @param nombre the nombre
	 * @param nacionalidad the nacionalidad
	 */
	public DirectorDeportivo(String numeroDeDocumento, String nombre, String nacionalidad) {
		this.numeroDeDocumento = numeroDeDocumento;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
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
	 * Gets the nacionalidad.
	 *
	 * @return the nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * Sets the nacionalidad.
	 *
	 * @param nacionalidad the new nacionalidad
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
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
