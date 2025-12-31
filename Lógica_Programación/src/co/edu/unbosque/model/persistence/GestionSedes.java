package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Sede;

// TODO: Auto-generated Javadoc
/**
 * The Class SedeDAO.
 */
public class GestionSedes {
	
	/** The sedes. */
	private ArrayList<Sede> sedes;
	
	/** The sede. */
	private Sede sede;
	
	/** The archivo. */
	private FileManager archivo;
	
	/**
	 * Instantiates a new sede DAO.
	 */
	public GestionSedes() {
		archivo = new FileManager();
		
		// Obtener las sedes almacenadas en el archivo sedes.dat
		sedes = archivo.obtenerSedes();
		
		// Revisar si el archivo sedes.dat existe o si no se han agregado sedes
		sedes = (sedes != null) ? sedes: new ArrayList<Sede>();
	}
	
	/**
	 * Agregar sede.
	 *
	 * @param ubicacionSede     La ubicacion de la sede a agregar.
     * @param numeroDeEmpleados El numero de empleados de la sede a agregar.
	 */
	public void agregarSede(String ubicacionSede, int numeroDeEmpleados) {
		sede = new Sede(ubicacionSede, numeroDeEmpleados);
		sedes.add(sede);
		registrarSedes();
	}
	
	/**
	 * Modificar sede.
	 *
	 * @param indice            El indice de la sede a modificar.
     * @param ubicacionSede     La nueva ubicacion de la sede.
     * @param numeroDeEmpleados El nuevo numero de empleados de la sede.
	 */
	public void modificarSede(int indice, String ubicacionSede, int numeroDeEmpleados) {
		sede = new Sede(ubicacionSede, numeroDeEmpleados);
		sedes.set(indice, sede);
		registrarSedes();
	}
	
	/**
	 * Eliminar sede.
	 *
	 * @param indice El índice de la sede a eliminar.
	 */
	public void eliminarSede(int indice) {
		sede = sedes.get(indice);
		sedes.remove(indice);
		registrarSedes();
	}
	
	/**
	 * Registrar sedes.
	 */
	public void registrarSedes() {
		archivo.registrarSedes(sedes);
	}
	
	/**
	 * Obtener sedes actuales.
	 *
	 * @return Un arreglo con las ubicaciones de las sedes actuales.
	 */
	public String[] obtenerSedesActuales() {
		String[] sedesActuales = new String[sedes.size()];
		
		for (int i = 0; i < sedes.size(); i++)
			sedesActuales[i] = sedes.get(i).getUbicacion();
		
		return sedesActuales;
	}
	
	/**
	 * Obtener numero empleados.
	 *
	 * @param ubicacion the ubicacion
	 * @return the int
	 */
	public int obtenerNumeroEmpleados(String ubicacion) {
		for (int i = 0; i < sedes.size(); i++)
			if (sedes.get(i).getUbicacion().equals(ubicacion))
				return sedes.get(i).getNumeroDeEmpleados();
		return -1;
	}
	
	/**
	 * Obtener indice sede.
	 *
	 * @param ubicacion the ubicacion
	 * @return the int
	 */
	public int obtenerIndiceSede(String ubicacion) {
		for (int i = 0; i < sedes.size(); i++)
			if (sedes.get(i).getUbicacion().equals(ubicacion))
				return i;
		return -1;
	}

	/**
	 * Gets the sedes.
	 *
	 * @return the sedes
	 */
	public ArrayList<Sede> getSedes() {
		return sedes;
	}

	/**
	 * Sets the sedes.
	 *
	 * @param sedes the new sedes
	 */
	public void setSedes(ArrayList<Sede> sedes) {
		this.sedes = sedes;
	}

	/**
	 * Gets the sede.
	 *
	 * @return the sede
	 */
	public Sede getSede() {
		return sede;
	}

	/**
	 * Sets the sede.
	 *
	 * @param sede the new sede
	 */
	public void setSede(Sede sede) {
		this.sede = sede;
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
