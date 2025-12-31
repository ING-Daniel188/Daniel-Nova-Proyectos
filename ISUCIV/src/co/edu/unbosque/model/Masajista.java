package co.edu.unbosque.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Masajista.
 */
public class Masajista implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6622896623503156575L;
	
	/** The numero de documento. */
	private String numeroDeDocumento;
	
	/** The nombre. */
	private String nombre;
	
	/** The anios experiencia. */
	private int aniosExperiencia;

	/**
	 * Instantiates a new masajista.
	 */
	public Masajista() {

	}

	/**
	 * Instantiates a new masajista.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @param nombre the nombre
	 * @param aniosExperiencia the anios experiencia
	 */
	public Masajista(String numeroDeDocumento, String nombre, int aniosExperiencia) {
		this.numeroDeDocumento = numeroDeDocumento;
		this.nombre = nombre;
		this.aniosExperiencia = aniosExperiencia;
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
	 * Gets the anios experiencia.
	 *
	 * @return the anios experiencia
	 */
	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	/**
	 * Sets the anios experiencia.
	 *
	 * @param aniosExperiencia the new anios experiencia
	 */
	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
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
