package co.edu.unbosque.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Ciclista.
 */
public class Ciclista implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2040465160703837340L;
	
	/** The tipo. */
	protected String tipo;
	
	/** The numero de documento. */
	protected String numeroDeDocumento;
	
	/** The nombre. */
	protected String nombre;
	
	/** The tiempo acumulado de carrera. */
	protected int tiempoAcumuladoDeCarrera;
	
	/** The contextura. */
	protected String contextura;
	
	/** The especialidad. */
	protected String especialidad;
	
	/** The cadencia. */
	protected float cadencia;

	/**
	 * Instantiates a new ciclista.
	 */
	public Ciclista() {

	}

	/**
	 * Instantiates a new ciclista.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @param nombre the nombre
	 * @param contextura the contextura
	 * @param especialidad the especialidad
	 * @param cadencia the cadencia
	 */
	public Ciclista(String numeroDeDocumento, String nombre, String contextura, String especialidad, float cadencia) {
		this.numeroDeDocumento = numeroDeDocumento;
		this.nombre = nombre;
		this.tiempoAcumuladoDeCarrera = 0;
		this.contextura = contextura;
		this.especialidad = especialidad;
		this.cadencia = cadencia;
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 *
	 * @param tipo the new tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	 * Gets the tiempo acumulado de carrera.
	 *
	 * @return the tiempo acumulado de carrera
	 */
	public int getTiempoAcumuladoDeCarrera() {
		return tiempoAcumuladoDeCarrera;
	}

	/**
	 * Sets the tiempo acumulado de carrera.
	 *
	 * @param tiempoAcumuladoDeCarrera the new tiempo acumulado de carrera
	 */
	public void setTiempoAcumuladoDeCarrera(int tiempoAcumuladoDeCarrera) {
		this.tiempoAcumuladoDeCarrera = tiempoAcumuladoDeCarrera;
	}

	/**
	 * Gets the contextura.
	 *
	 * @return the contextura
	 */
	public String getContextura() {
		return contextura;
	}

	/**
	 * Sets the contextura.
	 *
	 * @param contextura the new contextura
	 */
	public void setContextura(String contextura) {
		this.contextura = contextura;
	}

	/**
	 * Gets the especialidad.
	 *
	 * @return the especialidad
	 */
	public String getEspecialidad() {
		return especialidad;
	}

	/**
	 * Sets the especialidad.
	 *
	 * @param especialidad the new especialidad
	 */
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	/**
	 * Gets the cadencia.
	 *
	 * @return the cadencia
	 */
	public float getCadencia() {
		return cadencia;
	}

	/**
	 * Sets the cadencia.
	 *
	 * @param cadencia the new cadencia
	 */
	public void setCadencia(float cadencia) {
		this.cadencia = cadencia;
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
