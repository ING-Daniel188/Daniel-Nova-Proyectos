package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.SuperAstro;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperAstroDAO.
 */
public class GestionSuperAstro {

	/** The apuestas super astro. */
	private ArrayList<SuperAstro> apuestasSuperAstro;
	
	/** The apuesta super astro. */
	private SuperAstro apuestaSuperAstro;
	
	/** The archivo. */
	private Archivo archivo;
	
	/**
	 * Instantiates a new super astro DAO.
	 */
	public GestionSuperAstro() {
		archivo = new Archivo();
		
		// Obtener las apuestas de superastro almacenadas en el archivo apuestas-superastro.dat
		apuestasSuperAstro = archivo.obtenerApuestasSuperAstro();
		
		// Revisar si el archivo apuestas-superastro.dat existe o si no se han agregado apuestas de tipo superastro
		apuestasSuperAstro = (apuestasSuperAstro != null) ? apuestasSuperAstro: new ArrayList<SuperAstro>();
	}
	
	/**
	 * Agregar apuesta super astro.
	 *
	 * @param nombreSede         El nombre de la sede de la apuesta.
     * @param cedulaApostador    La cedula del apostador.
     * @param dia              El dia de la apuesta.
     * @param valor              El valor de la apuesta.
     * @param numerosSeleccionados  Los numeros seleccionados para la apuesta.
     * @param signoDelZodiaco    El signo del zodiaco seleccionado.
	 */
	public void agregarApuestaSuperAstro(String nombreSede, String cedulaApostador, String dia, double valor, int[] numerosSeleccionados, String signoDelZodiaco) {
		apuestaSuperAstro = new SuperAstro(nombreSede, cedulaApostador, dia, valor, numerosSeleccionados, signoDelZodiaco);
		apuestasSuperAstro.add(apuestaSuperAstro);
		registrarApuestasSuperAstro();
	}
	
	/**
	 * Modificar apuesta super astro.
	 *
	 * @param indice             El indice de la apuesta a modificar.
     * @param nombreSede         El nuevo nombre de la sede de la apuesta.
     * @param cedulaApostador    La nueva cedula del apostador.
     * @param dia              El nuevo dia de la apuesta.
     * @param valor              El nuevo valor de la apuesta.
     * @param numerosSeleccionados  Los nuevos numeros seleccionados para la apuesta.
     * @param signoDelZodiaco    El nuevo signo del zodiaco seleccionado.
	 */
	public void modificarApuestaSuperAstro(int indice, String nombreSede, String cedulaApostador, String dia, double valor,
			int[] numerosSeleccionados, String signoDelZodiaco) {
		apuestaSuperAstro = new SuperAstro(nombreSede, cedulaApostador, dia, valor, numerosSeleccionados, signoDelZodiaco);
		apuestasSuperAstro.set(indice, apuestaSuperAstro);
		registrarApuestasSuperAstro();
	}
	
	/**
	 * Eliminar apuesta super astro.
	 *
	 * @param indice El índice de la apuesta a eliminar.
	 */
	public void eliminarApuestaSuperAstro(int indice) {
		apuestaSuperAstro = apuestasSuperAstro.get(indice);
		apuestasSuperAstro.remove(indice);
		registrarApuestasSuperAstro();
	}
	
	/**
	 * Registrar apuestas super astro.
	 */
	public void registrarApuestasSuperAstro() {
		archivo.registrarApuestasSuperAstro(apuestasSuperAstro);
	}
	
	
	/**
	 * Obtener indice apuesta.
	 *
	 * @param cedulaApostador La cedula del apostador.
     * @param diaApuesta     El dia de la apuesta.
     * @return El indice de la apuesta encontrada o -1 si no se encontro ninguna.
	 */
	public int obtenerIndiceApuesta(String cedulaApostador, String sede, String diaApuesta) {
		// Iterar por todas las apuestas para encontrar el índice del objeto por cédula
		// del apostador y dia de la apuesta
		for (int i = 0; i < apuestasSuperAstro.size(); i++) {
			if (apuestasSuperAstro.get(i).getCedulaApostador().equals(cedulaApostador)
					&& apuestasSuperAstro.get(i).getNombreSede().equals(sede)
					&& apuestasSuperAstro.get(i).getDia().equals(diaApuesta)) {
				return i;
			}
				
		}
			
		return -1;
	}
	
	public int obtenerIndiceApuesta(String cedulaApostador, String diaApuesta) {
		// Iterar por todas las apuestas para encontrar el índice del objeto por cédula
		// del apostador y fecha de la apuesta
		for (int i = 0; i < apuestasSuperAstro.size(); i++)
			if (apuestasSuperAstro.get(i).getCedulaApostador().equals(cedulaApostador)
					&& apuestasSuperAstro.get(i).getDia().equals(diaApuesta))
				return i;
		return -1;
	}

	public double obtenerValorTotalApuestas(String cedula) {
		double valorTotal = 0;
		for (SuperAstro apuesta: apuestasSuperAstro) {
			if (apuesta.getCedulaApostador().equals(cedula)) {
				valorTotal += apuesta.getValor();
			}
		}
		return valorTotal;
	}
	
	
	/**
	 * Obtener apuestas super astro por cliente.
	 *
	 * @param cedula La cédula del cliente.
     * @return Una lista de apuestas de SuperAstro realizadas por el cliente.
	 */
	public ArrayList<SuperAstro> obtenerApuestasSuperAstroPorCliente(String cedula) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<SuperAstro> apuestasSuperAstroPorCliente = new ArrayList<SuperAstro>();
		
		for (int i = 0; i < apuestasSuperAstro.size(); i++) 
			if (apuestasSuperAstro.get(i).getCedulaApostador().equals(cedula)) 
				apuestasSuperAstroPorCliente.add(apuestasSuperAstro.get(i));
			
		return apuestasSuperAstroPorCliente;
	}
	
	/**
	 * Obtener numero apuestas super astro por sede.
	 *
	 * @param sede El nombre de la sede.
     * @return El número de apuestas de SuperAstro realizadas en la sede.
	 */
	public int obtenerNumeroApuestasSuperAstroPorSede(String sede) {
		
		int numeroApuestasSuperAstro = 0;
		
		for (int i = 0; i < apuestasSuperAstro.size(); i++)
			if (apuestasSuperAstro.get(i).getNombreSede().equals(sede))
				numeroApuestasSuperAstro++;
		
		return numeroApuestasSuperAstro;
		
	}
	
	/**
	 * Obtener apuestas super astro por sede.
	 *
	 * @param sede El nombre de la sede.
     * @return El número de apuestas de SuperAstro realizadas en la sede.
	 */
	public ArrayList<SuperAstro> obtenerApuestasSuperAstroPorSede(String sede) {
		// Iterar por todas las apuestas para encontrar el índice de las apuestas por cédula del apostador
		ArrayList<SuperAstro> apuestasSuperAstroPorCliente = new ArrayList<SuperAstro>();
		
		for (int i = 0; i < apuestasSuperAstro.size(); i++) 
			if (apuestasSuperAstro.get(i).getNombreSede().equals(sede)) 
				apuestasSuperAstroPorCliente.add(apuestasSuperAstro.get(i));
			
		return apuestasSuperAstroPorCliente;
	}
	

	/**
	 * Gets the apuestas super astro.
	 *
	 * @return the apuestas super astro
	 */
	public ArrayList<SuperAstro> getApuestasSuperAstro() {
		return apuestasSuperAstro;
	}

	/**
	 * Sets the apuestas super astro.
	 *
	 * @param apuestasSuperAstro the new apuestas super astro
	 */
	public void setApuestasSuperAstro(ArrayList<SuperAstro> apuestasSuperAstro) {
		this.apuestasSuperAstro = apuestasSuperAstro;
	}

	/**
	 * Gets the apuesta super astro.
	 *
	 * @return the apuesta super astro
	 */
	public SuperAstro getApuestaSuperAstro() {
		return apuestaSuperAstro;
	}

	/**
	 * Sets the apuesta super astro.
	 *
	 * @param apuestaSuperAstro the new apuesta super astro
	 */
	public void setApuestaSuperAstro(SuperAstro apuestaSuperAstro) {
		this.apuestaSuperAstro = apuestaSuperAstro;
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
