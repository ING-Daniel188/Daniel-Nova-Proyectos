package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Arrays;

import co.edu.unbosque.model.Baloto;

// TODO: Auto-generated Javadoc
/**
 * The Class BalotoDAO.
 */
public class GestionBaloto {

	/** The apuestas baloto. */
	private ArrayList<Baloto> apuestasBaloto;
	
	/** The apuesta baloto. */
	private Baloto apuestaBaloto;
	
	/** The archivo. */
	private FileManager archivo;

	/**
	 * Instantiates a new baloto DAO.
	 */
	public GestionBaloto() {
		archivo = new FileManager();

		// Obtener las apuestas de baloto almacenadas en el archivo apuestas-baloto.dat
		apuestasBaloto = archivo.obtenerApuestasBaloto();

		// Revisar si el archivo apuestas-baloto.dat existe o si no se han agregado
		// apuestas de tipo baloto
		apuestasBaloto = (apuestasBaloto != null) ? apuestasBaloto : new ArrayList<Baloto>();
	}

	/**
	 * Agregar apuesta baloto.
	 *
	 * @param nombreSede Nombre de la sede en la que se realiza la apuesta de baloto a agregar
	 * @param cedulaApostador Cedula del apostador que realiza la apuesta de baloto a agregar
	 * @param dia Dia en la cual se realiza la apuesta de baloto a agregar
	 * @param valor Monto total de la apuesta de baloto a agregar
	 * @param numerosSeleccionados Numeros seleccionados por el apostador de la apuesta de baloto a agregar
	 */
	public void agregarApuestaBaloto(String nombreSede, String cedulaApostador, String dia, double valor,
			int[] numerosSeleccionados) {
		apuestaBaloto = new Baloto(nombreSede, cedulaApostador, dia, valor, numerosSeleccionados);
		apuestasBaloto.add(apuestaBaloto);
		registrarApuestasBaloto();
	}

	/**
	 * Modificar apuesta baloto.
	 *
	 * @param indice Indice con la posicion del ArrayList de la apuesta de baloto a modificar
	 * @param nombreSede Nombre de la sede en la cual se realiza la apuesta de baloto a modificar
	 * @param cedulaApostador Cedula del apostador que realizo la apuesta de baloto a modificar
	 * @param dia Dia en la cual se realiza la apuesta de baloto a modificar
	 * @param valor Monto total de la apuesta de baloto a modificar
	 * @param numerosSeleccionados Numeros seleccionados por el apostador de la apuesta de baloto a modificar.
	 */
	public void modificarApuestaBaloto(int indice, String nombreSede, String cedulaApostador, String dia, double valor,
			int[] numerosSeleccionados) {
		apuestaBaloto = new Baloto(nombreSede, cedulaApostador, dia, valor, numerosSeleccionados);
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
	 * @param diaApuesta Dia en el que el apostador realizo la apuesta
	 * @return Entero que indica si hubo una apuesta con la cedula y la fecha proveida
	 */
	public int obtenerIndiceApuesta(String cedulaApostador, String diaApuesta) {
		// Iterar por todas las apuestas para encontrar el índice del objeto por cédula
		// del apostador y fecha de la apuesta
		for (int i = 0; i < apuestasBaloto.size(); i++)
			if (apuestasBaloto.get(i).getCedulaApostador().equals(cedulaApostador)
					&& apuestasBaloto.get(i).getDia().equals(diaApuesta))
				return i;
		return -1;
	}
	
	/**
	 * Obtener apuestas El número de identificación del cliente.
	 *
	 * @param cedula the cedula
	 * @return ArrayList de BalotoDTO con las apuestas realizadas por el cliente en baloto.
	 */
	public ArrayList<Baloto> obtenerApuestasBalotoPorCliente(String cedula) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<Baloto> apuestasBalotoPorCliente = new ArrayList<Baloto>();
		
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
	public ArrayList<Baloto> obtenerApuestasBalotoPorSede(String sede) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<Baloto> apuestasBalotoPorCliente = new ArrayList<Baloto>();
		
		for (int i = 0; i < apuestasBaloto.size(); i++) 
			if (apuestasBaloto.get(i).getNombreSede().equals(sede)) 
				apuestasBalotoPorCliente.add(apuestasBaloto.get(i));
			
		return apuestasBalotoPorCliente;
	}
	
	/**
	 * Obtener datos apuestas.
	 *
	 * @param cedula the cedula
	 * @param dia the dia
	 * @return the string
	 */
	public String obtenerDatosApuestas(String cedula, String dia) {
		
		String datosApuestas = "";
		for (Baloto apuestaBaloto: apuestasBaloto) {
			if (apuestaBaloto.getCedulaApostador().equals(cedula)
					&& apuestaBaloto.getDia().equals(dia)) {
				datosApuestas += ("Nombre de la sede: " + apuestaBaloto.getNombreSede() + "\n" +
						"Cedula del apostador: " + apuestaBaloto.getCedulaApostador() + "\n" +
						"Dia de la apuesta: " + apuestaBaloto.getDia() + "\n" +
						"Valor de la apuesta: " + apuestaBaloto.getValor() + "\n" +
						"Numero de baloto: " + Arrays.toString(apuestaBaloto.getNumerosSeleccionados()) + "\n\n"	
						);
			}
		}
		return datosApuestas;
	}
	
	/**
	 * Obtener numero apuestas por cedula.
	 *
	 * @param cedula the cedula
	 * @return the int
	 */
	public int obtenerNumeroApuestasPorCedula(String cedula) {
		
		int numero = 0;
		for (Baloto apuestaBaloto: apuestasBaloto) {
			if (apuestaBaloto.getCedulaApostador().equals(cedula)) {
				numero++;
			}
		}
		return numero;
	}
	
	/**
	 * Obtener valor total apuestas.
	 *
	 * @param cedula the cedula
	 * @return the double
	 */
	public double obtenerValorTotalApuestas(String cedula) {
		double valorTotal = 0;
		for (Baloto apuesta: apuestasBaloto) {
			if (apuesta.getCedulaApostador().equals(cedula)) {
				valorTotal += apuesta.getValor();
			}
			
		}
		return valorTotal;
	}
	

	/**
	 * Gets the apuestas baloto.
	 *
	 * @return the apuestas baloto
	 */
	public ArrayList<Baloto> getApuestasBaloto() {
		return apuestasBaloto;
	}

	/**
	 * Sets the apuestas baloto.
	 *
	 * @param apuestasBaloto the new apuestas baloto
	 */
	public void setApuestasBaloto(ArrayList<Baloto> apuestasBaloto) {
		this.apuestasBaloto = apuestasBaloto;
	}

	/**
	 * Gets the apuesta baloto.
	 *
	 * @return the apuesta baloto
	 */
	public Baloto getApuestaBaloto() {
		return apuestaBaloto;
	}

	/**
	 * Sets the apuesta baloto.
	 *
	 * @param apuestaBaloto the new apuesta baloto
	 */
	public void setApuestaBaloto(Baloto apuestaBaloto) {
		this.apuestaBaloto = apuestaBaloto;
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
