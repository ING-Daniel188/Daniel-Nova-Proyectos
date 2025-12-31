package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.BalotoDTO;

/**
 * The Class BalotoDAO.
 */
public class BalotoDAO {

	/** The apuestas baloto. */
	private ArrayList<BalotoDTO> apuestasBaloto;
	
	/** The apuesta baloto. */
	private BalotoDTO apuestaBaloto;
	
	/** The archivo. */
	private Archivo archivo;

	/**
	 * Instantiates a new baloto DAO.
	 */
	public BalotoDAO() {
		archivo = new Archivo();

		// Obtener las apuestas de baloto almacenadas en el archivo apuestas-baloto.dat
		apuestasBaloto = archivo.obtenerApuestasBaloto();

		// Revisar si el archivo apuestas-baloto.dat existe o si no se han agregado
		// apuestas de tipo baloto
		apuestasBaloto = (apuestasBaloto != null) ? apuestasBaloto : new ArrayList<BalotoDTO>();
	}

	/**
	 * To string.
	 *
	 * @return Representacion en String de las apuestas actuales de baloto registradas
	 */
	public String toString() {
		String datosApuestasBaloto = "";
		int i = 1;
		for (BalotoDTO apuestaBaloto : apuestasBaloto) {
			datosApuestasBaloto += "Apuesta Baloto #" + i + "\n";
			datosApuestasBaloto += "Nombre de la Sede: " + apuestaBaloto.getNombreSede() + "\n";
			datosApuestasBaloto += "Cédula del Apostador: " + apuestaBaloto.getCedulaApostador() + "\n";
			datosApuestasBaloto += "Fecha de la Apuesta: " + apuestaBaloto.getFecha() + "\n";
			datosApuestasBaloto += "Valor de la Apuesta: " + apuestaBaloto.getValor() + "\n";
			datosApuestasBaloto += "Números seleccionados: ";
			for (int j = 0; j < apuestaBaloto.getNumerosSeleccionados().length; j++) {
				datosApuestasBaloto += apuestaBaloto.getNumerosSeleccionados()[j];
				if (j != apuestaBaloto.getNumerosSeleccionados().length - 1)
					datosApuestasBaloto += "-";
			}
			datosApuestasBaloto += "\n\n";
			i++;
		}
		return datosApuestasBaloto;
	}

	/**
	 * Agregar apuesta baloto.
	 *
	 * @param nombreSede Nombre de la sede en la que se realiza la apuesta de baloto a agregar
	 * @param cedulaApostador Cedula del apostador que realiza la apuesta de baloto a agregar
	 * @param fecha Fecha en la cual se realiza la apuesta de baloto a agregar
	 * @param valor Monto total de la apuesta de baloto a agregar
	 * @param numerosSeleccionados Numeros seleccionados por el apostador de la apuesta de baloto a agregar
	 */
	public void agregarApuestaBaloto(String nombreSede, String cedulaApostador, String fecha, double valor,
			int[] numerosSeleccionados) {
		apuestaBaloto = new BalotoDTO(nombreSede, cedulaApostador, fecha, valor, numerosSeleccionados);
		apuestasBaloto.add(apuestaBaloto);
	}

	/**
	 * Modificar apuesta baloto.
	 *
	 * @param indice Indice con la posicion del ArrayList de la apuesta de baloto a modificar
	 * @param nombreSede Nombre de la sede en la cual se realiza la apuesta de baloto a modificar
	 * @param cedulaApostador Cedula del apostador que realizo la apuesta de baloto a modificar
	 * @param fecha Fecha en la cual se realiza la apuesta de baloto a modificar
	 * @param valor Monto total de la apuesta de baloto a modificar
	 * @param numerosSeleccionados Numeros seleccionados por el apostador de la apuesta de baloto a modificar.
	 */
	public void modificarApuestaBaloto(int indice, String nombreSede, String cedulaApostador, String fecha, double valor,
			int[] numerosSeleccionados) {
		apuestaBaloto = new BalotoDTO(nombreSede, cedulaApostador, fecha, valor, numerosSeleccionados);
		apuestasBaloto.set(indice, apuestaBaloto);
		registrarApuestasBaloto();
	}

	/**
	 * Eliminar apuesta baloto.
	 *
	 * @param indice Indice de la ubicacion en el ArrayList de la apuesta de baloto a eliminar
	 */
	public void eliminarApuestaBaloto(int indice) {
		apuestaBaloto = apuestasBaloto.get(indice);
		apuestasBaloto.remove(indice);
		registrarApuestasBaloto();
	}

	/**
	 * Registrar apuestas baloto.
	 */
	public void registrarApuestasBaloto() {
		archivo.registrarApuestasBaloto(apuestasBaloto);
	}
	
	/**
	 * Obtener indice apuesta.
	 *
	 * @param cedulaApostador Cedula del apostador que realizo la apuesta
	 * @param fechaApuesta Fecha en la que el apostador realizo la apuesta
	 * @return Entero que indica si hubo una apuesta con la cedula y la fecha proveida
	 */
	public int obtenerIndiceApuesta(String cedulaApostador, String fechaApuesta) {
		// Iterar por todas las apuestas para encontrar el índice del objeto por cédula
		// del apostador y fecha de la apuesta
		for (int i = 0; i < apuestasBaloto.size(); i++)
			if (apuestasBaloto.get(i).getCedulaApostador().equals(cedulaApostador)
					&& apuestasBaloto.get(i).getFecha().equals(fechaApuesta))
				return i;
		return -1;
	}
	
	/**
	 * Obtener apuestas El número de identificación del cliente.
	 *
	 * @param cedula the cedula
	 * @return ArrayList de BalotoDTO con las apuestas realizadas por el cliente en baloto.
	 */
	public ArrayList<BalotoDTO> obtenerApuestasBalotoPorCliente(String cedula) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<BalotoDTO> apuestasBalotoPorCliente = new ArrayList<BalotoDTO>();
		
		for (int i = 0; i < apuestasBaloto.size(); i++) 
			if (apuestasBaloto.get(i).getCedulaApostador().equals(cedula)) 
				apuestasBalotoPorCliente.add(apuestasBaloto.get(i));
			
		return apuestasBalotoPorCliente;
	}
	
	/**
	 * Obtener numero apuestas baloto por sede.
	 *
	 * @param sede El nombre de la sede.
	 * @return El número de apuestas de baloto realizadas en la sede especificada.
	 */
	public int obtenerNumeroApuestasBalotoPorSede(String sede) {
		
		int numeroApuestasBaloto = 0;
		
		for (int i = 0; i < apuestasBaloto.size(); i++)
			if (apuestasBaloto.get(i).getNombreSede().equals(sede))
				numeroApuestasBaloto++;
		
		return numeroApuestasBaloto;
		
	}
	
	/**
	 * Obtener apuestas baloto por sede.
	 *
	 * @param sede El nombre de la sede.
	 * @return Una lista de apuestas de baloto realizadas en la sede especificada.
	 */
	public ArrayList<BalotoDTO> obtenerApuestasBalotoPorSede(String sede) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<BalotoDTO> apuestasBalotoPorCliente = new ArrayList<BalotoDTO>();
		
		for (int i = 0; i < apuestasBaloto.size(); i++) 
			if (apuestasBaloto.get(i).getNombreSede().equals(sede)) 
				apuestasBalotoPorCliente.add(apuestasBaloto.get(i));
			
		return apuestasBalotoPorCliente;
	}
	

	/**
	 * Gets the apuestas baloto.
	 *
	 * @return the apuestas baloto
	 */
	public ArrayList<BalotoDTO> getApuestasBaloto() {
		return apuestasBaloto;
	}

	/**
	 * Sets the apuestas baloto.
	 *
	 * @param apuestasBaloto the new apuestas baloto
	 */
	public void setApuestasBaloto(ArrayList<BalotoDTO> apuestasBaloto) {
		this.apuestasBaloto = apuestasBaloto;
	}

	/**
	 * Gets the apuesta baloto.
	 *
	 * @return the apuesta baloto
	 */
	public BalotoDTO getApuestaBaloto() {
		return apuestaBaloto;
	}

	/**
	 * Sets the apuesta baloto.
	 *
	 * @param apuestaBaloto the new apuesta baloto
	 */
	public void setApuestaBaloto(BalotoDTO apuestaBaloto) {
		this.apuestaBaloto = apuestaBaloto;
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
