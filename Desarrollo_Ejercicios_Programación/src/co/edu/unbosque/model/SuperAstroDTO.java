package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * The Class SuperAstroDTO.
 */
public class SuperAstroDTO extends ApuestaDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The numeros seleccionados. */
	private int[] numerosSeleccionados;
	
	/** The signo del zodiaco. */
	private String signoDelZodiaco;

	/**
	 * Instantiates a new super astro DTO.
	 *
	 * @param nombreSede El nombre de la sede en la que se realiza la apuesta de superastro
	 * @param cedulaApostador La cedula del apostador que realiza la apuesta de superastro
	 * @param fecha La fecha en la cual se realiza la apuesta de superastro
	 * @param valor El monto total de la apuesta de superastro
	 * @param numerosSeleccionados Los numeros de superastro seleccionados por el apostador
	 * @param signoDelZodiaco El signo del zodiaco seleccionado por el apostador
	 */
	public SuperAstroDTO(String nombreSede, String cedulaApostador, String fecha, double valor,
			int[] numerosSeleccionados, String signoDelZodiaco) {
		super("SuperAstro", nombreSede, cedulaApostador, fecha, valor);
		this.numerosSeleccionados = numerosSeleccionados;
		this.signoDelZodiaco = signoDelZodiaco;
	}

	
	/**
	 * Gets the numeros seleccionados.
	 *
	 * @return the numeros seleccionados
	 */
	public int[] getNumerosSeleccionados() {
		return numerosSeleccionados;
	}

	/**
	 * Sets the numeros seleccionados.
	 *
	 * @param numerosSeleccionados the new numeros seleccionados
	 */
	public void setNumerosSeleccionados(int[] numerosSeleccionados) {
		this.numerosSeleccionados = numerosSeleccionados;
	}

	/**
	 * Gets the signo del zodiaco.
	 *
	 * @return the signo del zodiaco
	 */
	public String getSignoDelZodiaco() {
		return signoDelZodiaco;
	}

	/**
	 * Sets the signo del zodiaco.
	 *
	 * @param signoDelZodiaco the new signo del zodiaco
	 */
	public void setSignoDelZodiaco(String signoDelZodiaco) {
		this.signoDelZodiaco = signoDelZodiaco;
	}

}
