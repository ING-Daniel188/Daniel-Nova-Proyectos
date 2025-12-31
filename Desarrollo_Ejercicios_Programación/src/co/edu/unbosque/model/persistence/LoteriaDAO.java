package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.LoteriaDTO;

/**
 * The Class LoteriaDAO.
 */
public class LoteriaDAO {

	/** The apuestas loteria. */
	private ArrayList<LoteriaDTO> apuestasLoteria;
	
	/** The apuesta loteria. */
	private LoteriaDTO apuestaLoteria;
	
	/** The archivo. */
	private Archivo archivo;

	/**
	 * Instantiates a new loteria DAO.
	 */
	public LoteriaDAO() {
		archivo = new Archivo();

		// Obtener las apuestas de lotería almacenadas en el archivo
		// apuestas-loteria.dat
		apuestasLoteria = archivo.obtenerApuestasLoteria();

		// Revisar si el archivo apuestas-loteria.dat existe o si no se han agregado
		// apuestas de lotería
		apuestasLoteria = (apuestasLoteria != null) ? apuestasLoteria : new ArrayList<LoteriaDTO>();

		apuestaLoteria = new LoteriaDTO();

	}

	/**
	 * To string.
	 *
	 * @return Representacion en String del objeto
	 */
	public String toString() {
		String datosApuestasLoteria = "";
		int i = 1;
		for (LoteriaDTO apuestaLoteria : apuestasLoteria) {
			datosApuestasLoteria += "Apuesta Lotería #" + i + "\n";
			datosApuestasLoteria += "Nombre de la Sede: " + apuestaLoteria.getNombreSede() + "\n";
			datosApuestasLoteria += "Cédula del Apostador: " + apuestaLoteria.getCedulaApostador() + "\n";
			datosApuestasLoteria += "Fecha de la Apuesta: " + apuestaLoteria.getFecha() + "\n";
			datosApuestasLoteria += "Valor de la Apuesta: " + apuestaLoteria.getValor() + "\n";
			datosApuestasLoteria += "Serie de la Apuesta: " + apuestaLoteria.getSerie() + "\n";
			datosApuestasLoteria += "\n\n";
			i++;
		}
		return datosApuestasLoteria;
	}

	/**
	 * Agregar apuesta loteria.
	 *
	 * @param tipoDeApuesta   El tipo de apuesta.
     * @param nombreSede      El nombre de la sede.
     * @param cedulaApostador La cedula del apostador.
     * @param fecha           La fecha de la apuesta.
     * @param valor           El valor de la apuesta.
     * @param nombre          El nombre del apostador.
     * @param numeroLoteria   El numero de loteria.
     * @param serie           La serie de la apuesta.
	 */
	public void agregarApuestaLoteria(String tipoDeApuesta, String nombreSede, String cedulaApostador, String fecha,
			double valor, String nombre, int numeroLoteria, int serie) {
		apuestaLoteria = new LoteriaDTO(tipoDeApuesta, nombreSede, cedulaApostador, fecha, valor, nombre, numeroLoteria,
				serie);
		apuestasLoteria.add(apuestaLoteria);
		registrarApuestasLoteria();
	}

	/**
	 * Modificar apuesta loteria.
	 *
	 * @param indice          El indice de la apuesta a modificar.
     * @param tipoDeApuesta   El tipo de apuesta modificado.
     * @param nombreSede      El nombre de la sede modificado.
     * @param cedulaApostador La cedula del apostador modificado.
     * @param fecha           La fecha de la apuesta modificada.
     * @param valor           El valor de la apuesta modificado.
     * @param nombre          El nombre del apostador modificado.
     * @param numeroLoteria   El numero de loteria modificado.
     * @param serie           La serie de la apuesta modificada.
	 */
	public void modificarApuestaLoteria(int indice, String tipoDeApuesta, String nombreSede, String cedulaApostador,
			String fecha, double valor, String nombre, int numeroLoteria, int serie) {
		apuestaLoteria = new LoteriaDTO(tipoDeApuesta, nombreSede, cedulaApostador, fecha, valor, nombre, numeroLoteria,
				serie);
		apuestasLoteria.set(indice, apuestaLoteria);
		registrarApuestasLoteria();
	}

	/**
	 * Eliminar apuesta loteria.
	 *
	 * @param indice El indice de la apuesta a eliminar.
	 */
	public void eliminarApuestaLoteria(int indice) {
		apuestaLoteria = apuestasLoteria.get(indice);
		apuestasLoteria.remove(indice);
		registrarApuestasLoteria();
	}

	/**
	 * Registrar apuestas loteria.
	 */
	public void registrarApuestasLoteria() {
		archivo.registrarApuestasLoteria(apuestasLoteria);
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
		for (int i = 0; i < apuestasLoteria.size(); i++)
			if (apuestasLoteria.get(i).getCedulaApostador().equals(cedulaApostador)
					&& apuestasLoteria.get(i).getFecha().equals(fechaApuesta))
				return i;
		return -1;
	}
	
	/**
	 * Obtener apuestas loteria por cliente.
	 *
	 * @param cedula La cedula del cliente.
     * @return Una lista de las apuestas de loteria del cliente.
	 */
	public ArrayList<LoteriaDTO> obtenerApuestasLoteriaPorCliente(String cedula) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<LoteriaDTO> apuestasLoteriaPorCliente = new ArrayList<LoteriaDTO>();
		
		for (int i = 0; i < apuestasLoteria.size(); i++) 
			if (apuestasLoteria.get(i).getCedulaApostador().equals(cedula)) 
				apuestasLoteriaPorCliente.add(apuestasLoteria.get(i));
			
		return apuestasLoteriaPorCliente;
	}
	
	/**
	 * Obtener numero apuestas loteria por sede.
	 *
	 * @param sede La sede.
     * @return El número de apuestas de loteria realizadas en la sede.
	 */
	public int obtenerNumeroApuestasLoteriaPorSede(String sede) {
		
		int numeroApuestasLoteria = 0;
		
		for (int i = 0; i < apuestasLoteria.size(); i++)
			if (apuestasLoteria.get(i).getNombreSede().equals(sede))
				numeroApuestasLoteria++;
		
		return numeroApuestasLoteria;
		
	}
	
	/**
	 * Obtener apuestas loteria por sede.
	 *
	 * @param sede La sede.
     * @return Una lista de las apuestas de loteria realizadas en la sede.
	 */
	public ArrayList<LoteriaDTO> obtenerApuestasLoteriaPorSede(String sede) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<LoteriaDTO> apuestasLoteriaPorCliente = new ArrayList<LoteriaDTO>();
		
		for (int i = 0; i < apuestasLoteria.size(); i++) 
			if (apuestasLoteria.get(i).getNombreSede().equals(sede)) 
				apuestasLoteriaPorCliente.add(apuestasLoteria.get(i));
			
		return apuestasLoteriaPorCliente;
	}
	

	/**
	 * Gets the apuestas loteria.
	 *
	 * @return the apuestas loteria
	 */
	public ArrayList<LoteriaDTO> getApuestasLoteria() {
		return apuestasLoteria;
	}

	/**
	 * Sets the apuestas loteria.
	 *
	 * @param apuestasLoteria the new apuestas loteria
	 */
	public void setApuestasLoteria(ArrayList<LoteriaDTO> apuestasLoteria) {
		this.apuestasLoteria = apuestasLoteria;
	}

	/**
	 * Gets the apuesta loteria.
	 *
	 * @return the apuesta loteria
	 */
	public LoteriaDTO getApuestaLoteria() {
		return apuestaLoteria;
	}

	/**
	 * Sets the apuesta loteria.
	 *
	 * @param apuestaLoteria the new apuesta loteria
	 */
	public void setApuestaLoteria(LoteriaDTO apuestaLoteria) {
		this.apuestaLoteria = apuestaLoteria;
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
