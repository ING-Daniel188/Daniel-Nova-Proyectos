package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Loteria;

// TODO: Auto-generated Javadoc
/**
 * The Class LoteriaDAO.
 */
public class GestionLoteria {

	/** The apuestas loteria. */
	private ArrayList<Loteria> apuestasLoteria;
	
	/** The apuesta loteria. */
	private Loteria apuestaLoteria;
	
	/** The archivo. */
	private FileManager archivo;

	/**
	 * Instantiates a new loteria DAO.
	 */
	public GestionLoteria() {
		archivo = new FileManager();

		// Obtener las apuestas de lotería almacenadas en el archivo
		// apuestas-loteria.dat
		apuestasLoteria = archivo.obtenerApuestasLoteria();

		// Revisar si el archivo apuestas-loteria.dat existe o si no se han agregado
		// apuestas de lotería
		apuestasLoteria = (apuestasLoteria != null) ? apuestasLoteria : new ArrayList<Loteria>();

		apuestaLoteria = new Loteria();

	}

	/**
	 * Agregar apuesta loteria.
	 *
	 * @param tipoDeApuesta   El tipo de apuesta.
     * @param nombreSede      El nombre de la sede.
     * @param cedulaApostador La cedula del apostador.
     * @param dia           El dia de la apuesta.
     * @param valor           El valor de la apuesta.
     * @param nombre          El nombre del apostador.
     * @param numeroLoteria   El numero de loteria.
     * @param serie           La serie de la apuesta.
	 */
	public void agregarApuestaLoteria(String tipoDeApuesta, String nombreSede, String cedulaApostador, String dia,
			double valor, String nombre, int numeroLoteria, int serie) {
		apuestaLoteria = new Loteria(tipoDeApuesta, nombreSede, cedulaApostador, dia, valor, nombre, numeroLoteria,
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
     * @param dia           El dia de la apuesta modificada.
     * @param valor           El valor de la apuesta modificado.
     * @param nombre          El nombre del apostador modificado.
     * @param numeroLoteria   El numero de loteria modificado.
     * @param serie           La serie de la apuesta modificada.
	 */
	public void modificarApuestaLoteria(int indice, String tipoDeApuesta, String nombreSede, String cedulaApostador,
			String dia, double valor, String nombre, int numeroLoteria, int serie) {
		apuestaLoteria = new Loteria(tipoDeApuesta, nombreSede, cedulaApostador, dia, valor, nombre, numeroLoteria,
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
	 * @param diaApuesta the dia apuesta
	 * @return El indice de la apuesta en la lista, o -1 si no se encuentra.
	 */
	public int obtenerIndiceApuesta(String cedulaApostador, String diaApuesta) {
		// Iterar por todas las apuestas para encontrar el índice del objeto por cédula
		// del apostador y fecha de la apuesta
		for (int i = 0; i < apuestasLoteria.size(); i++)
			if (apuestasLoteria.get(i).getCedulaApostador().equals(cedulaApostador)
					&& apuestasLoteria.get(i).getDia().equals(diaApuesta))
				return i;
		return -1;
	}
	
	/**
	 * Obtener apuestas loteria por cliente.
	 *
	 * @param cedula La cedula del cliente.
     * @return Una lista de las apuestas de loteria del cliente.
	 */
	public ArrayList<Loteria> obtenerApuestasLoteriaPorCliente(String cedula) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<Loteria> apuestasLoteriaPorCliente = new ArrayList<Loteria>();
		
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
	public ArrayList<Loteria> obtenerApuestasLoteriaPorSede(String sede) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<Loteria> apuestasLoteriaPorCliente = new ArrayList<Loteria>();
		
		for (int i = 0; i < apuestasLoteria.size(); i++) 
			if (apuestasLoteria.get(i).getNombreSede().equals(sede)) 
				apuestasLoteriaPorCliente.add(apuestasLoteria.get(i));
			
		return apuestasLoteriaPorCliente;
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
		for (Loteria apuestaLoteria: apuestasLoteria) {
			if (apuestaLoteria.getCedulaApostador().equals(cedula)
					&& apuestaLoteria.getDia().equals(dia)) {
				datosApuestas += ("Nombre de la sede: " + apuestaLoteria.getNombreSede() + "\n" +
						"Cedula del apostador: " + apuestaLoteria.getCedulaApostador() + "\n" +
						"Dia de la apuesta: " + apuestaLoteria.getDia() + "\n" +
						"Valor de la apuesta: " + apuestaLoteria.getValor() + "\n" +
						"Tipo de loteria: " + apuestaLoteria.getTipoDeApuesta() + "\n" +
						"Numero de loteria: " + apuestaLoteria.getNumeroLoteria() + "\n" +
						"Numero de serie: " + apuestaLoteria.getSerie() + "\n\n"
						);
			}
		}
		return datosApuestas;
	}
	
	/**
	 * Obtener datos apuestas.
	 *
	 * @param cedula the cedula
	 * @return the string
	 */
	public String obtenerDatosApuestas(String cedula) {
		
		String datosApuestas = "";
		for (Loteria apuestaLoteria: apuestasLoteria) {
			if (apuestaLoteria.getCedulaApostador().equals(cedula)) {
				datosApuestas += ("Nombre de la sede: " + apuestaLoteria.getNombreSede() + "\n" +
						"Cedula del apostador: " + apuestaLoteria.getCedulaApostador() + "\n" +
						"Dia de la apuesta: " + apuestaLoteria.getDia() + "\n" +
						"Valor de la apuesta: " + apuestaLoteria.getValor() + "\n" +
						"Tipo de loteria: " + apuestaLoteria.getTipoDeApuesta() + "\n" +
						"Numero de loteria: " + apuestaLoteria.getNumeroLoteria() + "\n" +
						"Numero de serie: " + apuestaLoteria.getSerie() + "\n\n"
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
		
		int numeroApuestas = 0;
		
		for (Loteria apuestaLoteria: apuestasLoteria) {
			if (apuestaLoteria.getCedulaApostador().equals(cedula)) {
				numeroApuestas++;
			}
		}
		return numeroApuestas;
	}
	
	/**
	 * Obtener valor total apuestas.
	 *
	 * @param cedula the cedula
	 * @return the double
	 */
	public double obtenerValorTotalApuestas(String cedula) {
		double valorTotal = 0;
		for (Loteria apuesta: apuestasLoteria) {
			if (apuesta.getCedulaApostador().equals(cedula)) {
				valorTotal += apuesta.getValor();
			}
		}
		return valorTotal;
	}

	
	/**
	 * Obtener datos apuestas por dia.
	 *
	 * @param dia the dia
	 * @return the string
	 */
	public String obtenerDatosApuestasPorDia(String dia) {
		
		String datosApuestas = "";
		for (Loteria apuestaLoteria: apuestasLoteria) {
			if (apuestaLoteria.getDia().equals(dia)) {
				datosApuestas += ("Nombre de la sede: " + apuestaLoteria.getNombreSede() + "\n" +
						"Cedula del apostador: " + apuestaLoteria.getCedulaApostador() + "\n" +
						"Dia de la apuesta: " + apuestaLoteria.getDia() + "\n" +
						"Valor de la apuesta: " + apuestaLoteria.getValor() + "\n" +
						"Tipo de loteria: " + apuestaLoteria.getTipoDeApuesta() + "\n" +
						"Numero de loteria: " + apuestaLoteria.getNumeroLoteria() + "\n" +
						"Numero de serie: " + apuestaLoteria.getSerie() + "\n\n"
						);
			}
		}
		return datosApuestas;
	}
	
	/**
	 * Obtener indice apuesta por sede cedula dia.
	 *
	 * @param sede the sede
	 * @param cedula the cedula
	 * @param dia the dia
	 * @return the int
	 */
	public int obtenerIndiceApuestaPorSedeCedulaDia(String sede, String cedula, String dia) {
		// Iterar por todas las apuestas para encontrar el índice del objeto por dia
		// del apostador y fecha de la apuesta
		for (int i = 0; i < apuestasLoteria.size(); i++)
			if (apuestasLoteria.get(i).getCedulaApostador().equals(cedula)
					&& apuestasLoteria.get(i).getNombreSede().equals(sede)
					&& apuestasLoteria.get(i).getCedulaApostador().equals(cedula))
				return i;
		return -1;
	}
	
	/**
	 * Obtener indice apuesta por dia.
	 *
	 * @param dia the dia
	 * @return the int
	 */
	public int obtenerIndiceApuestaPorDia(String dia) {
		// Iterar por todas las apuestas para encontrar el índice del objeto por dia
		// del apostador y fecha de la apuesta
		for (int i = 0; i < apuestasLoteria.size(); i++)
			if (apuestasLoteria.get(i).getDia().equals(dia))
				return i;
		return -1;
	}
	

	/**
	 * Gets the apuestas loteria.
	 *
	 * @return the apuestas loteria
	 */
	public ArrayList<Loteria> getApuestasLoteria() {
		return apuestasLoteria;
	}

	/**
	 * Sets the apuestas loteria.
	 *
	 * @param apuestasLoteria the new apuestas loteria
	 */
	public void setApuestasLoteria(ArrayList<Loteria> apuestasLoteria) {
		this.apuestasLoteria = apuestasLoteria;
	}

	/**
	 * Gets the apuesta loteria.
	 *
	 * @return the apuesta loteria
	 */
	public Loteria getApuestaLoteria() {
		return apuestaLoteria;
	}

	/**
	 * Sets the apuesta loteria.
	 *
	 * @param apuestaLoteria the new apuesta loteria
	 */
	public void setApuestaLoteria(Loteria apuestaLoteria) {
		this.apuestaLoteria = apuestaLoteria;
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
