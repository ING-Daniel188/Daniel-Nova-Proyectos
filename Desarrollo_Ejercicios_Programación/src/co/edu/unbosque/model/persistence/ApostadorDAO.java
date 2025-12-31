package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ApostadorDTO;

/**
 * The Class ApostadorDAO.
 * Clase que realizara la gestion de los apostadores
 */
public class ApostadorDAO {

	/** The apostadores. */
	private ArrayList<ApostadorDTO> apostadores;
	
	/** The apostador. */
	private ApostadorDTO apostador;
	
	/** The archivo. */
	private Archivo archivo;
	
	/**
	 * Instantiates a new apostador DAO.
	 */
	public ApostadorDAO() {
		archivo = new Archivo();
		
		// Obtener los apostadores almacenados en el archivo apostadores.dat
		apostadores = archivo.obtenerApostadores();
		
		// Revisar si el archivo apostadores.dat existe o si no se han agregado apostadores
		apostadores = (apostadores != null) ? apostadores: new ArrayList<ApostadorDTO>();
	}
	
	/**
	 * To string.
	 *
	 * @return Una representacion en forma de String de un objeto de apostador
	 */
	public String toString() {
		String datosApostadores = "";
		int i = 1;
		for (ApostadorDTO apostador: apostadores) {
			datosApostadores += "Apostador #" + i + "\n";
			datosApostadores += "Nombre Completo: " + apostador.getNombreCompleto() + "\n";
			datosApostadores += "Cédula: " + apostador.getCedula() + "\n";
			datosApostadores += "Sede Actual: " + apostador.getSedeActual() + "\n";
			datosApostadores += "Dirección: " + apostador.getDireccion() + "\n";
			datosApostadores += "Celular: " + apostador.getCelular() + "\n\n";
			i++;
		}
		return datosApostadores;
	}
	
	/**
	 * Agregar apostador.
	 *
	 * @param nombreCompleto Nombre completo del apostador a agregar
	 * @param cedula Cedula del apostador a agregar
	 * @param sedeActual Sede inicial en la que estara ubicado el apostador a agregar
	 * @param direccion Direccion inicial del apostador a agregar
	 * @param celular Telefono o celular del apostador a agregar
	 */
	public void agregarApostador(String nombreCompleto, String cedula, String sedeActual, String direccion, long celular) {
		apostador = new ApostadorDTO(nombreCompleto, cedula, sedeActual, direccion, celular);
		apostadores.add(apostador);
	}
	
	/**
	 * Modificar apostador.
	 *
	 * @param indice Indice del ArrayList (posicion) en la que esta ubicado el apostador a modificar
	 * @param nombreCompleto Nuevo nombre del apostador a modificar
	 * @param cedula Nueva cedula del apostador a modificar
	 * @param sedeActual Nueva sede del apostador a modificar
	 * @param direccion Nueva direccion del apostador a modificar
	 * @param celular Telefono o celular del apostador a modificar
	 */
	public void modificarApostador(int indice, String nombreCompleto, String cedula, String sedeActual, String direccion, long celular) {
		apostador = new ApostadorDTO(nombreCompleto, cedula, sedeActual, direccion, celular);
		apostadores.set(indice, apostador);
	}
	
	/**
	 * Eliminar apostador.
	 *
	 * @param indice Indice del ArrayList (posicion) en la que esta ubicado el apostador a eliminar
	 */
	public void eliminarApostador(int indice) {
		apostador = apostadores.get(indice);
		apostadores.remove(indice);
	}
	
	/**
	 * Registrar apostadores.
	 * Metodo para registrar todos los apostadores actuales del ArrayList al archivo
	 */
	public void registrarApostadores() {
		archivo.registrarApostadores(apostadores);
	}
	
	/**
	 * Obtener indice apostador.
	 *
	 * @param cedula Indice del ArrayList (posicion) en la que esta ubicado el apostador
	 * @return La posicion en el ArrayList en la que la cedula sea la misma.
	 * Se retorna -1 si el apostador con tal cedula no fue encontrado
	 */
	public int obtenerIndiceApostador(String cedula) {
		
		// Iterar por todos los apostadores para encontrar el índice del objeto por cédula
		for (int i = 0; i < apostadores.size(); i++)
			if (apostadores.get(i).getCedula().equals(cedula)) 
				return i;
		return -1;
		
	}
	
	/**
	 * Obtener nombre apostador.
	 *
	 * @param cedula La cedula del apostador para obtener el nombre del mismo
	 * @return El nombre del apostador obtenido dependiendo de la cedula
	 * Se retorna null para indicar que el nombre del apostador no existe con dicha cedula
	 */
	public String obtenerNombreApostador(String cedula) {
		
		// Iterar por todos los apostadores para encontrar el nombre del apostador por cédula
		for (int i = 0; i < apostadores.size(); i++)
			if (apostadores.get(i).getCedula().equals(cedula)) 
				return apostadores.get(i).getNombreCompleto();
		return null;
		
	}
	
	/**
	 * Apostador sin modificar.
	 *
	 * @param indice Indice del ArrayList (posicion) en la que esta ubicado el apostador a revisar
	 * @param nombreCompleto Nombre completo del apostador a revisar
	 * @param cedula Cedula del apostador a revisar
	 * @param sedeActual Sede actual del apostador a revisar
	 * @param direccion Direccion del apostador a revisar
	 * @param celular Celular del apostador a revisar
	 * @return true, si el apostador a revisar no ha sido modificado
	 */
	public boolean apostadorSinModificar(int indice, String nombreCompleto, String cedula, String sedeActual, String direccion, long celular) {
		apostador = new ApostadorDTO(nombreCompleto, cedula, sedeActual, direccion, celular);
		// Comparar el objeto actual y el modificado para revisar si son iguales
		return apostador.equals(apostadores.get(indice));
	}
	
	/**
	 * Modificar sede actual apostador.
	 *
	 * @param indiceApostador Indice del ArrayList (posicion) en la que esta ubicado el apostador
	 * @param sedeActual Sede en la cual esta ubicado el apostador actualmente
	 */
	public void modificarSedeActualApostador(int indiceApostador, String sedeActual) {
		// Obtener el apostador a modificar por el índice en el que está ubicado
		apostador = apostadores.get(indiceApostador);
		
		// Actualizar a la nueva sede
		apostador.setSedeActual(sedeActual);
		
		modificarApostador(
				indiceApostador, 
				apostador.getNombreCompleto(), 
				apostador.getCedula(), 
				apostador.getSedeActual(), 
				apostador.getDireccion(), 
				apostador.getCelular());
		registrarApostadores();
	}
	
	/**
	 * Obtener clientes por sede.
	 *
	 * @param ubicacionSede El nombre de la sede de de los clientes a buscar
	 * @return Arreglo con todos los apostadores ubicados en la sede proveida
	 */
	public ArrayList<ApostadorDTO> obtenerClientesPorSede(String ubicacionSede) {
		ArrayList<ApostadorDTO> apostadoresPorSede = new ArrayList<ApostadorDTO>();
		for (ApostadorDTO apostador: apostadores) 
			if (ubicacionSede.equals(apostador.getSedeActual()))
				apostadoresPorSede.add(apostador);
		return apostadoresPorSede;
	}

	/**
	 * Gets the apostadores.
	 *
	 * @return the apostadores
	 */
	public ArrayList<ApostadorDTO> getApostadores() {
		return apostadores;
	}

	/**
	 * Sets the apostadores.
	 *
	 * @param apostadores the new apostadores
	 */
	public void setApostadores(ArrayList<ApostadorDTO> apostadores) {
		this.apostadores = apostadores;
	}

	/**
	 * Gets the apostador.
	 *
	 * @return the apostador
	 */
	public ApostadorDTO getApostador() {
		return apostador;
	}

	/**
	 * Sets the apostador.
	 *
	 * @param apostador the new apostador
	 */
	public void setApostador(ApostadorDTO apostador) {
		this.apostador = apostador;
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
