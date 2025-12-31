package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.BetPlayDTO;

/**
 * The Class BetPlayDAO.
 */
public class BetPlayDAO {

	/** The apuestas bet play. */
	private ArrayList<BetPlayDTO> apuestasBetPlay;
	
	/** The apuesta bet play. */
	private BetPlayDTO apuestaBetPlay;
	
	/** The archivo. */
	private Archivo archivo;

	/**
	 * Instantiates a new bet play DAO.
	 */
	public BetPlayDAO() {
		archivo = new Archivo();

		// Obtener las apuestas de chance almacenadas en el archivo apuestas-chance.dat
		apuestasBetPlay = archivo.obtenerApuestasBetPlay();

		// Revisar si el archivo apuestas-betplay.dat existe o si no se han agregado
		// apuestas de tipo betplay
		apuestasBetPlay = (apuestasBetPlay != null) ? apuestasBetPlay : new ArrayList<BetPlayDTO>();

		apuestaBetPlay = new BetPlayDTO();
	}

	/**
	 * Agregar apuesta bet play.
	 *
	 * @param nombreSede                El nombre de la sede donde se realiza la apuesta.
     * @param cedulaApostador           La cedula del apostador que realiza la apuesta.
     * @param fecha                     La fecha en la que se realiza la apuesta.
     * @param valor                     El valor de la apuesta.
     * @param partidosYResultadosEscogidos Los partidos y sus resultados escogidos por el apostador.
	 */
	public void agregarApuestaBetPlay(String nombreSede, String cedulaApostador, String fecha, double valor,
			String[][] partidosYResultadosEscogidos) {
		apuestaBetPlay = new BetPlayDTO(nombreSede, cedulaApostador, fecha, valor, partidosYResultadosEscogidos);
		apuestasBetPlay.add(apuestaBetPlay);
	}

	/**
	 * Modificar apuesta bet play.
	 *
	 * @param indice                    El indice de la apuesta a modificar.
     * @param nombreSede                El nombre de la sede donde se realiza la apuesta.
     * @param cedulaApostador           La cédula del apostador que realiza la apuesta.
     * @param fecha                     La fecha en la que se realiza la apuesta.
     * @param valor                     El valor de la apuesta.
     * @param partidosYResultadosEscogidos Los partidos y sus resultados escogidos por el apostador.
	 */
	public void modificarApuestaBetPlay(int indice, String nombreSede, String cedulaApostador, String fecha, double valor,
			String[][] partidosYResultadosEscogidos) {
		apuestaBetPlay = new BetPlayDTO(nombreSede, cedulaApostador, fecha, valor,
				partidosYResultadosEscogidos);
		apuestasBetPlay.set(indice, apuestaBetPlay);
		registrarApuestasBetPlay();
	}

	/**
	 * Eliminar apuesta bet play.
	 *
	 * @param indice the indice
	 */
	public void eliminarApuestaBetPlay(int indice) {
		apuestasBetPlay.remove(indice);
		registrarApuestasBetPlay();
	}

	/**
	 * Obtener indice apuesta.
	 *
	 * @param cedulaApostador La cedula del apostador.
     * @param fechaApuesta     La fecha de la apuesta.
     * @return El indice de la apuesta en la lista, o -1 si no se encuentra.
	 */
	public int obtenerIndiceApuesta(String cedulaApostador, String fechaApuesta) {
		// Iterar por todas las apuestas para encontrar el índice del objeto por cédula
		// del apostador y fecha de la apuesta
		for (int i = 0; i < apuestasBetPlay.size(); i++)
			if (apuestasBetPlay.get(i).getCedulaApostador().equals(cedulaApostador)
					&& apuestasBetPlay.get(i).getFecha().equals(fechaApuesta))
				return i;
		return -1;
	}
	
	/**
	 * Obtener apuestas bet play por cliente.
	 *
	 * @param cedula La cedula del cliente.
     * @return Una lista con las apuestas de BetPlay realizadas por el cliente.
	 */
	public ArrayList<BetPlayDTO> obtenerApuestasBetPlayPorCliente(String cedula) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<BetPlayDTO> apuestasBetPlayPorCliente = new ArrayList<BetPlayDTO>();
		
		for (int i = 0; i < apuestasBetPlay.size(); i++) 
			if (apuestasBetPlay.get(i).getCedulaApostador().equals(cedula)) 
				apuestasBetPlayPorCliente.add(apuestasBetPlay.get(i));
			
		return apuestasBetPlayPorCliente;
	}
	
	/**
	 * Obtener numero apuestas bet play por sede.
	 *
	 * @param sede El nombre de la sede.
     * @return La cantidad de apuestas de BetPlay realizadas en la sede especificada.
	 */
	public int obtenerNumeroApuestasBetPlayPorSede(String sede) {
		
		int numeroApuestasBetPlay = 0;
		
		for (int i = 0; i < apuestasBetPlay.size(); i++)
			if (apuestasBetPlay.get(i).getNombreSede().equals(sede))
				numeroApuestasBetPlay++;
		
		return numeroApuestasBetPlay;
		
	}
	
	/**
	 * Obtener apuestas bet play por sede.
	 *
	 * @param sede El nombre de la sede.
     * @return Una lista con las apuestas de BetPlay realizadas en la sede especificada.
	 */
	public ArrayList<BetPlayDTO> obtenerApuestasBetPlayPorSede(String sede) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<BetPlayDTO> apuestasBetPlayPorCliente = new ArrayList<BetPlayDTO>();
		
		for (int i = 0; i < apuestasBetPlay.size(); i++) 
			if (apuestasBetPlay.get(i).getNombreSede().equals(sede)) 
				apuestasBetPlayPorCliente.add(apuestasBetPlay.get(i));
			
		return apuestasBetPlayPorCliente;
	}
	

	/**
	 * Registrar apuestas bet play.
	 */
	public void registrarApuestasBetPlay() {
		archivo.registrarApuestasBetPlay(apuestasBetPlay);
	}

	/**
	 * Gets the apuestas bet play.
	 *
	 * @return the apuestas bet play
	 */
	public ArrayList<BetPlayDTO> getApuestasBetPlay() {
		return apuestasBetPlay;
	}

	/**
	 * Sets the apuestas bet play.
	 *
	 * @param apuestasBetPlay the new apuestas bet play
	 */
	public void setApuestasBetPlay(ArrayList<BetPlayDTO> apuestasBetPlay) {
		this.apuestasBetPlay = apuestasBetPlay;
	}

	/**
	 * Gets the apuesta bet play.
	 *
	 * @return the apuesta bet play
	 */
	public BetPlayDTO getApuestaBetPlay() {
		return apuestaBetPlay;
	}

	/**
	 * Sets the apuesta bet play.
	 *
	 * @param apuestaBetPlay the new apuesta bet play
	 */
	public void setApuestaBetPlay(BetPlayDTO apuestaBetPlay) {
		this.apuestaBetPlay = apuestaBetPlay;
	}

	/**
	 * Gets the archivo.
	 *
	 * @return the archivo
	 */
	public Archivo getArchivo() {
		return archivo;
	}

	/**
	 * Sets the archivo.
	 *
	 * @param archivo the new archivo
	 */
	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}

}
