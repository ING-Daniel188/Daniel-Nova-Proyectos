package co.edu.unbosque.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class BalotoDTO.
 */
public class Baloto extends Apuesta implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The numeros seleccionados. */
	private int[] numerosSeleccionados;

	/**
	 * Instantiates a new baloto DTO.
	 *
	 * @param nombreSede Nombre de la sede en la que se realiza la apuesta de tipo baloto
	 * @param cedulaApostador Cedula del apostador que realiza la apuesta de tipo baloto
	 * @param dia Dia en el que el apostador realiza la apuesta
	 * @param valor Monto total de la apuesta baloto
	 * @param numerosSeleccionados Numeros seleccionados por el apostador de la apuesta de tipo baloto
	 */
	public Baloto(String nombreSede, String cedulaApostador, String dia, double valor, int[] numerosSeleccionados) {
		super("Baloto", nombreSede, cedulaApostador, dia, valor);
		this.numerosSeleccionados = numerosSeleccionados;
		verificarInvariante();
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
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * Verificar invariante.
	 * Verificar que el arreglo de numeros seleccionados proveido tenga 6 elementos en total,
	 * ya que la apuesta de baloto consiste en ingresar estrictamente 6 numeros
	 */
	public void verificarInvariante() {
		assert this.numerosSeleccionados.length == 6: "Los números del baloto deben ser 6"; 
	}
	
}
