package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Random;

/**
 * The Class BetPlayDTO.
 */
public class BetPlayDTO extends ApuestaDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The partidos Y resultados escogidos. */
	private String[][] partidosYResultadosEscogidos;

	/** The r. */
	private Random r;

	/**
	 * Instantiates a new bet play DTO.
	 */
	public BetPlayDTO() {
		super(null, null, null, null, 0);
		r = new Random();
	}

	/**
	 * Instantiates a new bet play DTO.
	 *
	 * @param nombreSede El nombre de la sede en la que se realiza la apuesta de tipo betplay
	 * @param cedulaApostador La cedula del apostador que realiza la apuesta de tipo betplay
	 * @param fecha La fecha en la cual el apostador realiza la apuesta de tipo betplay
	 * @param valor El monto total de la apuesta de tipo betplay
	 * @param partidosYResultadosEscogidos Matriz que contiene los 14 partidos seleccionados aleatoriamente
	 * y los resultados escogidos por el apostador para cada uno de los partidos
	 */
	public BetPlayDTO(String nombreSede, String cedulaApostador, String fecha, double valor,
			String[][] partidosYResultadosEscogidos) {
		super("BetPlay", nombreSede, cedulaApostador, fecha, valor);
		this.partidosYResultadosEscogidos = partidosYResultadosEscogidos;
		r = new Random();
	}

	/**
	 * Obtener partidos.
	 *
	 * @param equipos Arreglo de equipos para formar 14 partidos de forma aleatoria
	 * @return Matriz con los partidos formados aleatoriamente
	 */
	public String[][] obtenerPartidos(String[] equipos) {

		final int numeroDePartidos = 14;

		String[][] partidos = new String[2][numeroDePartidos];

		// Llenar la primera fila de la matriz de partidos con equipos 1
		String equipo;
		int indicePartido = 0;
		while (indicePartido < 14) {
			int indiceAleatorio = r.nextInt(equipos.length);
			equipo = equipos[indiceAleatorio];

			if (equipo != null) {
				partidos[0][indicePartido] = equipo;
				equipos[indiceAleatorio] = null;
				indicePartido++;
			}
		}

		// LLenar la segunda fila de la matriz de partidos con equipos 2
		indicePartido = 0;
		while (indicePartido < 14) {
			int indiceAleatorio = r.nextInt(equipos.length);
			equipo = equipos[indiceAleatorio];

			if (equipo != null) {
				partidos[1][indicePartido] = equipo;
				equipos[indiceAleatorio] = null;
				indicePartido++;
			}
		}

		return partidos;

	}

	/**
	 * Gets the partidos Y resultados escogidos.
	 *
	 * @return the partidos Y resultados escogidos
	 */
	public String[][] getPartidosYResultadosEscogidos() {
		return partidosYResultadosEscogidos;
	}

	/**
	 * Sets the partidos Y resultados escogidos.
	 *
	 * @param partidosYResultadosEscogidos the new partidos Y resultados escogidos
	 */
	public void setPartidosYResultadosEscogidos(String[][] partidosYResultadosEscogidos) {
		this.partidosYResultadosEscogidos = partidosYResultadosEscogidos;
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
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
