package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * The Class ApuestaDTO.
 */
public abstract class ApuestaDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The tipo de apuesta. */
	private String tipoDeApuesta;
	
	/** The nombre sede. */
	private String nombreSede;
	
	/** The cedula apostador. */
	private String cedulaApostador;
	
	/** The fecha. */
	private String fecha;
	
	/** The valor. */
	private double valor;
	

	/**
	 * Instantiates a new apuesta DTO.
	 *
	 * @param tipoDeApuesta Tipo de apuesta (Lotería, superastro, baloto, betplay y chance) de tipo String
	 * @param nombreSede Nombre de la sede en la que se realizo la apuesta
	 * @param cedulaApostador Cedula del apostador previamente registrado
	 * @param fecha Fecha en la que se realizo la apuesta
	 * @param valor Total en dinero del monto de la apuesta
	 */
	public ApuestaDTO(String tipoDeApuesta, String nombreSede, String cedulaApostador, String fecha, double valor) {
		super();
		this.tipoDeApuesta = tipoDeApuesta;
		this.nombreSede = nombreSede;
		this.cedulaApostador = cedulaApostador;
		this.fecha = fecha;
		this.valor = valor;
	}

	/**
	 * Gets the tipo de apuesta.
	 *
	 * @return the tipo de apuesta
	 */
	public String getTipoDeApuesta() {
		return tipoDeApuesta;
	}

	/**
	 * Sets the tipo de apuesta.
	 *
	 * @param tipoDeApuesta the new tipo de apuesta
	 */
	public void setTipoDeApuesta(String tipoDeApuesta) {
		this.tipoDeApuesta = tipoDeApuesta;
	}

	/**
	 * Gets the nombre sede.
	 *
	 * @return the nombre sede
	 */
	public String getNombreSede() {
		return nombreSede;
	}

	/**
	 * Sets the nombre sede.
	 *
	 * @param nombreSede the new nombre sede
	 */
	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}

	/**
	 * Gets the cedula apostador.
	 *
	 * @return the cedula apostador
	 */
	public String getCedulaApostador() {
		return cedulaApostador;
	}

	/**
	 * Sets the cedula apostador.
	 *
	 * @param cedulaApostador the new cedula apostador
	 */
	public void setCedulaApostador(String cedulaApostador) {
		this.cedulaApostador = cedulaApostador;
	}

	/**
	 * Gets the fecha.
	 *
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Sets the fecha.
	 *
	 * @param fecha the new fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Gets the valor.
	 *
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * Sets the valor.
	 *
	 * @param valor the new valor
	 */
	public void setValor(double valor) {
		this.valor = valor;
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
