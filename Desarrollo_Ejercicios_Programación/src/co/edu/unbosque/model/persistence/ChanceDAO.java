package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ChanceDTO;

/**
 * The Class ChanceDAO.
 */
public class ChanceDAO {

	/** The apuestas chance. */
	private ArrayList<ChanceDTO> apuestasChance;
	
	/** The apuesta chance. */
	private ChanceDTO apuestaChance;
	
	/** The archivo. */
	private Archivo archivo;

	/**
	 * Instantiates a new chance DAO.
	 */
	public ChanceDAO() {
		archivo = new Archivo();

		// Obtener las apuestas de chance almacenadas en el archivo apuestas-chance.dat
		apuestasChance = archivo.obtenerApuestasChance();

		// Revisar si el archivo apuestas-chance.dat existe o si no se han agregado
		// apuestas de tipo chance
		apuestasChance = (apuestasChance != null) ? apuestasChance : new ArrayList<ChanceDTO>();
		apuestaChance = new ChanceDTO();

	}

	/**
	 * To string.
	 *
	 * @return Representación del objeto en String
	 */
	public String toString() {
		String datosApuestasChance = "";
		int i = 1;
		for (ChanceDTO apuestaChance : apuestasChance) {
			datosApuestasChance += "Apuesta Chance #" + i + "\n";
			datosApuestasChance += "Nombre de la Sede: " + apuestaChance.getNombreSede() + "\n";
			datosApuestasChance += "Cédula del Apostador: " + apuestaChance.getCedulaApostador() + "\n";
			datosApuestasChance += "Fecha de la Apuesta: " + apuestaChance.getFecha() + "\n";
			datosApuestasChance += "Valor de la Apuesta: " + apuestaChance.getValor() + "\n";
			datosApuestasChance += "Nombre: " + apuestaChance.getNombre() + "\n";
			datosApuestasChance += "Números seleccionados: ";
			for (int j = 0; j < apuestaChance.getNumerosSeleccionados().length; j++) {
				datosApuestasChance += apuestaChance.getNumerosSeleccionados()[j];
				if (j != apuestaChance.getNumerosSeleccionados().length - 1)
					datosApuestasChance += "-";
			}
			datosApuestasChance += "\n\n";
			i++;
		}
		return datosApuestasChance;
	}

	/**
	 * Agregar apuesta chance.
	 *
	 * @param nombreSede         El nombre de la sede donde se realiza la apuesta.
     * @param cedulaApostador    La cedula del apostador que realiza la apuesta.
     * @param fecha              La fecha en la que se realiza la apuesta.
     * @param valor              El valor de la apuesta.
     * @param nombre             El nombre de la apuesta.
     * @param numerosSeleccionados Los números seleccionados para la apuesta de Chance.
	 */
	public void agregarApuestaChance(String nombreSede, String cedulaApostador, String fecha, double valor,
			String nombre, int[] numerosSeleccionados) {
		
		apuestaChance = new ChanceDTO(nombreSede, cedulaApostador, fecha, valor, nombre, numerosSeleccionados);
		apuestasChance.add(apuestaChance);
	}

	/**
	 * Modificar apuesta chance.
	 *
	 * @param indice                    El indice de la apuesta a modificar.
     * @param nombreSede                El nombre de la sede donde se realiza la apuesta.
     * @param cedulaApostador           La cedula del apostador que realiza la apuesta.
     * @param fecha                     La fecha en la que se realiza la apuesta.
     * @param valor                     El valor de la apuesta.
     * @param nombre                    El nombre de la apuesta.
     * @param numerosSeleccionados      Los numeros seleccionados para la apuesta de Chance.
	 */
	public void modificarApuestaChance(int indice, String nombreSede, String cedulaApostador, String fecha,
			double valor, String nombre, int[] numerosSeleccionados) {
		apuestaChance = new ChanceDTO(nombreSede, cedulaApostador, fecha, valor, nombre, numerosSeleccionados);
		apuestasChance.set(indice, apuestaChance);
		registrarApuestasChance();
	}

	/**
	 * Eliminar apuesta chance.
	 *
	 * @param indice El indice de la apuesta a eliminar.
	 */
	public void eliminarApuestaChance(int indice) {
		apuestaChance = apuestasChance.get(indice);
		apuestasChance.remove(indice);
		registrarApuestasChance();
	}

	/**
	 * Registrar apuestas chance.
	 */
	public void registrarApuestasChance() {
		archivo.registrarApuestasChance(apuestasChance);
	}
	
	/**
	 * Obtener indice apuesta.
	 *
	 * @param cedulaApostador La cédula del apostador.
     * @param fechaApuesta     La fecha de la apuesta.
     * @return El índice de la apuesta en la lista, o -1 si no se encuentra.
	 */
	public int obtenerIndiceApuesta(String cedulaApostador, String fechaApuesta) {
		// Iterar por todas las apuestas para encontrar el índice del objeto por cédula
		// del apostador y fecha de la apuesta
		for (int i = 0; i < apuestasChance.size(); i++)
			if (apuestasChance.get(i).getCedulaApostador().equals(cedulaApostador)
					&& apuestasChance.get(i).getFecha().equals(fechaApuesta))
				return i;
		return -1;
	}
	
	/**
	 * Obtener apuestas chance por cliente.
	 *
	 * @param cedula La cédula del cliente.
     * @return Una lista con las apuestas de Chance realizadas por el cliente.
	 */
	public ArrayList<ChanceDTO> obtenerApuestasChancePorCliente(String cedula) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<ChanceDTO> apuestasChancePorCliente = new ArrayList<ChanceDTO>();
		
		for (int i = 0; i < apuestasChance.size(); i++) 
			if (apuestasChance.get(i).getCedulaApostador().equals(cedula)) 
				apuestasChancePorCliente.add(apuestasChance.get(i));
			
		return apuestasChancePorCliente;
	}
	
	/**
	 * Obtener numero apuestas chance por sede.
	 *
	 * @param sede El nombre de la sede.
     * @return La cantidad de apuestas de Chance realizadas en la sede especificada.
	 */
	public int obtenerNumeroApuestasChancePorSede(String sede) {
		
		int numeroApuestasChance = 0;
		
		for (int i = 0; i < apuestasChance.size(); i++)
			if (apuestasChance.get(i).getNombreSede().equals(sede))
				numeroApuestasChance++;
		
		return numeroApuestasChance;
		
	}
	
	/**
	 * Obtener apuestas chance por sede.
	 *
	 * @param sede El nombre de la sede.
     * @return Una lista con las apuestas de Chance realizadas en la sede especificada.
	 */
	public ArrayList<ChanceDTO> obtenerApuestasChancePorSede(String sede) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<ChanceDTO> apuestasChancePorCliente = new ArrayList<ChanceDTO>();
		
		for (int i = 0; i < apuestasChance.size(); i++) 
			if (apuestasChance.get(i).getNombreSede().equals(sede)) 
				apuestasChancePorCliente.add(apuestasChance.get(i));
			
		return apuestasChancePorCliente;
	}
	

	/**
	 * Gets the apuestas chance.
	 *
	 * @return the apuestas chance
	 */
	public ArrayList<ChanceDTO> getApuestasChance() {
		return apuestasChance;
	}

	/**
	 * Sets the apuestas chance.
	 *
	 * @param apuestasChance the new apuestas chance
	 */
	public void setApuestasChance(ArrayList<ChanceDTO> apuestasChance) {
		this.apuestasChance = apuestasChance;
	}

	/**
	 * Gets the apuesta chance.
	 *
	 * @return the apuesta chance
	 */
	public ChanceDTO getApuestaChance() {
		return apuestaChance;
	}

	/**
	 * Sets the apuesta chance.
	 *
	 * @param apuestaChance the new apuesta chance
	 */
	public void setApuestaChance(ChanceDTO apuestaChance) {
		this.apuestaChance = apuestaChance;
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
