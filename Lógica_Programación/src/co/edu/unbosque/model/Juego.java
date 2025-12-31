package co.edu.unbosque.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class JuegoDTO.
 */
public class Juego implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The nombre del juego. */
	private String nombreDelJuego;
	
	/** The tipo de juego. */
	private String tipoDeJuego;
	
	/** The presupuesto. */
	private double presupuesto;
	
	/**
	 * Instantiates a new juego DTO.
	 *
	 * @param nombreDelJuego Nombre del juego (Loteria, superastro, baloto, betplay o chance)
	 * @param tipoDeJuego Tipo de Juego (Juego de azar, deportivo, etc.)
	 * @param presupuesto Presupuesto total que la casa de apuestas tiene para repartir premios
	 */
	public Juego(String nombreDelJuego, String tipoDeJuego, double presupuesto) {
		super();
		this.nombreDelJuego = nombreDelJuego;
		this.tipoDeJuego = tipoDeJuego;
		this.presupuesto = presupuesto;
	}

	/**
	 * Gets the nombre del juego.
	 *
	 * @return the nombre del juego
	 */
	public String getNombreDelJuego() {
		return nombreDelJuego;
	}

	/**
	 * Sets the nombre del juego.
	 *
	 * @param nombreDelJuego the new nombre del juego
	 */
	public void setNombreDelJuego(String nombreDelJuego) {
		this.nombreDelJuego = nombreDelJuego;
	}

	/**
	 * Gets the tipo de juego.
	 *
	 * @return the tipo de juego
	 */
	public String getTipoDeJuego() {
		return tipoDeJuego;
	}

	/**
	 * Sets the tipo de juego.
	 *
	 * @param tipoDeJuego the new tipo de juego
	 */
	public void setTipoDeJuego(String tipoDeJuego) {
		this.tipoDeJuego = tipoDeJuego;
	}

	/**
	 * Gets the presupuesto.
	 *
	 * @return the presupuesto
	 */
	public double getPresupuesto() {
		return presupuesto;
	}

	/**
	 * Sets the presupuesto.
	 *
	 * @param presupuesto the new presupuesto
	 */
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
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
