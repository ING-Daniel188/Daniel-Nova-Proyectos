package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Random;

/**
 * The Class LoteriaDTO.
 */
public class LoteriaDTO extends ApuestaDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The nombre. */
	private String nombre;
	
	/** The numero loteria. */
	private int numeroLoteria;
	
	/** The serie. */
	private int serie;
	
	/** The r. */
	private Random r;

	/**
	 * Instantiates a new loteria DTO.
	 */
	public LoteriaDTO() {
		this("", "", "", "", 0, "", 0, 0);
	}
	
	/**
	 * Instantiates a new loteria DTO.
	 *
	 * @param tipoDeApuesta Tipo de apuesta que el apostador realiza
	 * @param nombreSede Nombre de la sede en la cual el apostador realiza la apuesta de loteria
	 * @param cedulaApostador Cedula del apostador que realiza la apuesta de loteria
	 * @param fecha Fecha en la que se realiza la apuesta de loteria
	 * @param valor Monto total de la apuesta de loteria
	 * @param nombre Nombre de la loteria de la apuesta de loteria
	 * @param numeroLoteria Numero de loteria seleccionado aleatoriamente dependiendo de la serie
	 * @param serie Serie de la loteria que define el numero de la loteria
	 */
	public LoteriaDTO(String tipoDeApuesta, String nombreSede, String cedulaApostador, String fecha, double valor,
			String nombre, int numeroLoteria, int serie) {
		super(tipoDeApuesta, nombreSede, cedulaApostador, fecha, valor);
		this.nombre = nombre;
		this.numeroLoteria = numeroLoteria;
		this.serie = serie;
	}
	
	/**
	 * Generar serie.
	 *
	 * @return Entero que contiene una serie seleccionada aleatoriamente de 3 cifras (100 - 999)
	 */
	public int generarSerie() {
		// Generar una serie de tres cifras
		r = new Random();
		return r.nextInt(100, 1000);
	}
	
	/**
	 * Generar numero loteria serie 1.
	 *
	 * @return Entero que contiene una numero de loteria seleccionado aleatoriamente en un rango del 1 al 2500
	 */
	public int generarNumeroLoteriaSerie1() {
		// 0001 - 2499 
		r = new Random();
		return r.nextInt(1, 2500);
	}
	
	/**
	 * Generar numero loteria serie 2.
	 *
	 * @return Entero que contiene un numero de loteria seleccionado aleatoriamente en un rango del 2500 al 4999
	 */
	public int generarNumeroLoteriaSerie2() {
		// 2500 - 5000 
		r = new Random();
		return r.nextInt(2500, 5000);
	}
	
	/**
	 * Generar numero loteria serie 3.
	 *
	 * @return Entero que contiene un numero de loteria seleccionado aleatoriamente en un rango del 5000 al 7499
	 */
	public int generarNumeroLoteriaSerie3() {
		// 5000 - 7500 
		r = new Random();
		return r.nextInt(5000, 7500);
	}
	
	/**
	 * Generar numero loteria serie 4.
	 *
	 * @return Entero que contiene un numero de loteria seleccionado aleatoriamente en un rango del 7500 al 9999
	 */
	public int generarNumeroLoteriaSerie4() {
		// 7500 - 9999 
		r = new Random();
		return r.nextInt(7500, 10000);
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
	 * Gets the numero loteria.
	 *
	 * @return the numero loteria
	 */
	public int getNumeroLoteria() {
		return numeroLoteria;
	}

	/**
	 * Sets the numero loteria.
	 *
	 * @param numeroLoteria the new numero loteria
	 */
	public void setNumeroLoteria(int numeroLoteria) {
		this.numeroLoteria = numeroLoteria;
	}

	/**
	 * Gets the r.
	 *
	 * @return the r
	 */
	public Random getR() {
		return r;
	}

	/**
	 * Sets the r.
	 *
	 * @param r the new r
	 */
	public void setR(Random r) {
		this.r = r;
	}

	/**
	 * Gets the serie.
	 *
	 * @return the serie
	 */
	public int getSerie() {
		return serie;
	}

	/**
	 * Sets the serie.
	 *
	 * @param serie the new serie
	 */
	public void setSerie(int serie) {
		this.serie = serie;
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
