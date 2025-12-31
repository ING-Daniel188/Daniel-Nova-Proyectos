package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.BetPlay;

// TODO: Auto-generated Javadoc
/**
 * The Class BetPlayDAO.
 */
public class GestionBetPlay {

	/** The apuestas bet play. */
	private ArrayList<BetPlay> apuestasBetPlay;
	
	/** The apuesta bet play. */
	private BetPlay apuestaBetPlay;
	
	/** The archivo. */
	private FileManager archivo;

	
	/**
	 * Instantiates a new gestion bet play.
	 */
	public GestionBetPlay() {
		archivo = new FileManager();

		// Obtener las apuestas de chance almacenadas en el archivo apuestas-chance.dat
		apuestasBetPlay = archivo.obtenerApuestasBetPlay();

		// Revisar si el archivo apuestas-betplay.dat existe o si no se han agregado
		// apuestas de tipo betplay
		apuestasBetPlay = (apuestasBetPlay != null) ? apuestasBetPlay : new ArrayList<BetPlay>();

		apuestaBetPlay = new BetPlay();
	}

	/**
	 * Agregar apuesta bet play.
	 *
	 * @param nombreSede                El nombre de la sede donde se realiza la apuesta.
     * @param cedulaApostador           La cedula del apostador que realiza la apuesta.
     * @param dia                     El dia en la que se realiza la apuesta.
     * @param valor                     El valor de la apuesta.
     * @param partidosYResultadosEscogidos Los partidos y sus resultados escogidos por el apostador.
	 */
	public void agregarApuestaBetPlay(String nombreSede, String cedulaApostador, String dia, double valor,
			String[][] partidosYResultadosEscogidos) {
		apuestaBetPlay = new BetPlay(nombreSede, cedulaApostador, dia, valor, partidosYResultadosEscogidos);
		apuestasBetPlay.add(apuestaBetPlay);
		registrarApuestasBetPlay();
	}

	/**
	 * Modificar apuesta bet play.
	 *
	 * @param indice                    El indice de la apuesta a modificar.
     * @param nombreSede                El nombre de la sede donde se realiza la apuesta.
     * @param cedulaApostador           La cédula del apostador que realiza la apuesta.
     * @param dia                     El dia en la que se realiza la apuesta.
     * @param valor                     El valor de la apuesta.
     * @param partidosYResultadosEscogidos Los partidos y sus resultados escogidos por el apostador.
	 */
	public void modificarApuestaBetPlay(int indice, String nombreSede, String cedulaApostador, String dia, double valor,
			String[][] partidosYResultadosEscogidos) {
		apuestaBetPlay = new BetPlay(nombreSede, cedulaApostador, dia, valor,
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
     * @param diaApuesta     El dia de la apuesta.
     * @return El indice de la apuesta en la lista, o -1 si no se encuentra.
	 */
	public int obtenerIndiceApuesta(String cedulaApostador, String diaApuesta) {
		// Iterar por todas las apuestas para encontrar el índice del objeto por cédula
		// del apostador y fecha de la apuesta
		for (int i = 0; i < apuestasBetPlay.size(); i++)
			if (apuestasBetPlay.get(i).getCedulaApostador().equals(cedulaApostador)
					&& apuestasBetPlay.get(i).getDia().equals(diaApuesta))
				return i;
		return -1;
	}
	
	/**
	 * Obtener apuestas bet play por cliente.
	 *
	 * @param cedula La cedula del cliente.
     * @return Una lista con las apuestas de BetPlay realizadas por el cliente.
	 */
	public ArrayList<BetPlay> obtenerApuestasBetPlayPorCliente(String cedula) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<BetPlay> apuestasBetPlayPorCliente = new ArrayList<BetPlay>();
		
		for (int i = 0; i < apuestasBetPlay.size(); i++) 
			if (apuestasBetPlay.get(i).getCedulaApostador().equals(cedula)) 
				apuestasBetPlayPorCliente.add(apuestasBetPlay.get(i));
			
		return apuestasBetPlayPorCliente;
	}
	
	/**
	 * Obtener numero apuestas por cedula.
	 *
	 * @param cedula the cedula
	 * @return the int
	 */
	public int obtenerNumeroApuestasPorCedula(String cedula) {
		int numero = 0;
		
		for (int i = 0; i < apuestasBetPlay.size(); i++) 
			if (apuestasBetPlay.get(i).getCedulaApostador().equals(cedula)) 
				numero++;
			
		return numero;
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
	public ArrayList<BetPlay> obtenerApuestasBetPlayPorSede(String sede) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<BetPlay> apuestasBetPlayPorCliente = new ArrayList<BetPlay>();
		
		for (int i = 0; i < apuestasBetPlay.size(); i++) 
			if (apuestasBetPlay.get(i).getNombreSede().equals(sede)) 
				apuestasBetPlayPorCliente.add(apuestasBetPlay.get(i));
			
		return apuestasBetPlayPorCliente;
	}
	
	/**
	 * Obtener partidos Y resultados.
	 *
	 * @param indice the indice
	 * @return the string[][]
	 */
	public String[][] obtenerPartidosYResultados(int indice) {
		return (apuestasBetPlay.get(indice).getPartidosYResultadosEscogidos());
	}
	
	/**
	 * Obtener valor total apuestas.
	 *
	 * @param cedula the cedula
	 * @return the double
	 */
	public double obtenerValorTotalApuestas(String cedula) {
		double valorTotal = 0;
		for (BetPlay apuesta: apuestasBetPlay) {
			if (apuesta.getCedulaApostador().equals(cedula)) {
				valorTotal += apuesta.getValor();
			}
		}
		return valorTotal;
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
	public ArrayList<BetPlay> getApuestasBetPlay() {
		return apuestasBetPlay;
	}

	/**
	 * Sets the apuestas bet play.
	 *
	 * @param apuestasBetPlay the new apuestas bet play
	 */
	public void setApuestasBetPlay(ArrayList<BetPlay> apuestasBetPlay) {
		this.apuestasBetPlay = apuestasBetPlay;
	}

	/**
	 * Gets the apuesta bet play.
	 *
	 * @return the apuesta bet play
	 */
	public BetPlay getApuestaBetPlay() {
		return apuestaBetPlay;
	}

	/**
	 * Sets the apuesta bet play.
	 *
	 * @param apuestaBetPlay the new apuesta bet play
	 */
	public void setApuestaBetPlay(BetPlay apuestaBetPlay) {
		this.apuestaBetPlay = apuestaBetPlay;
	}

	/**
	 * Gets the archivo.
	 *
	 * @return the archivo
	 */
	public FileManager getArchivo() {
		return archivo;
	}

	/**
	 * Sets the archivo.
	 *
	 * @param archivo the new archivo
	 */
	public void setArchivo(FileManager archivo) {
		this.archivo = archivo;
	}

}
