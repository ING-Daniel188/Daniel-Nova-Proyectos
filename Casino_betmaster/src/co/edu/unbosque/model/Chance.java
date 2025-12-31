package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class ChanceDTO.
 */
public class Chance extends Apuesta implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private int[] numerosSeleccionados;
	private Random r;

	/**
	 * Instantiates a new chance DTO.
	 */
	public Chance() {
		super("Chance", "", "", "", 0);
	}
	
	/**
	 * Instantiates a new chance DTO.
	 *
	 * @param nombreSede Nombre de la sede en la que el apostador realiza la apuesta de tipo chance
	 * @param cedulaApostador La cedula del apostador que realiza la apuesta de tipo chance
	 * @param dia El dia en el cual se realiza la apuesta de tipo chance
	 * @param valor El monto total de la apuesta de chance
	 * @param nombre El nombre de la loteria del pais selecccionada por el apostador
	 * @param numerosSeleccionados Arreglo con los numeros seleccionados por el apostador
	 */
	public Chance(String nombreSede, String cedulaApostador, String dia, double valor, String nombre,
			int[] numerosSeleccionados) {
		super("Chance", nombreSede, cedulaApostador, dia, valor);
		this.nombre = nombre;
		this.numerosSeleccionados = numerosSeleccionados;
	}
	
	
	/**
	 * Generar numeros.
	 *
	 * @return Arreglo de enteros con 4 numeros aleatorios en un rango del 0 al 9
	 */
	public int[] generarNumeros() {
		
		int[] numerosChance = new int[4];
		
		r = new Random();
		for (int i = 0; i < 4; i++)
			numerosChance[i] = r.nextInt(9);
		
		return numerosChance;
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

}
