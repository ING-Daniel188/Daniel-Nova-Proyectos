package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Juego;

// TODO: Auto-generated Javadoc
/**
 * The Class JuegoDAO.
 */
public class GestionJuegos {

	/** The juegos. */
	private ArrayList<Juego> juegos;
	
	/** The juego. */
	private Juego juego;
	
	/** The archivo. */
	private FileManager archivo;

	/**
	 * Instantiates a new juego DAO.
	 */
	public GestionJuegos() {
		archivo = new FileManager();

		// Obtener los juegos almacenados en el archivo jugadores.dat
		juegos = archivo.obtenerJuegos();

		// Revisar que los juegos ya hayan sido agregados
		if (juegos == null) {
			juegos = new ArrayList<Juego>();
			agregarJuegos();
		}
	}
	
	/**
	 * Agregar juegos.
	 */
	public void agregarJuegos() {

		// Agregar Lotería
		agregarJuego("Loteria", "loteria", 0);

		// Agregar SuperAstro
		agregarJuego("SuperAstro", "loteria", 0);

		// Agregar Baloto
		agregarJuego("Baloto", "loteria", 0);

		// Agregar BetPlay
		agregarJuego("BetPlay", "deportivo", 0);

		// Agregar Chance
		agregarJuego("Chance", "chance", 0);

		registrarJuegos();
	}

	/**
	 * Agregar juego.
	 *
	 * @param nombreDelJuego El nombre del juego.
     * @param tipoDeJuego    El tipo de juego.
     * @param presupuesto     El presupuesto asignado al juego.
	 */
	public void agregarJuego(String nombreDelJuego, String tipoDeJuego, double presupuesto) {
		juego = new Juego(nombreDelJuego, tipoDeJuego, presupuesto);
		juegos.add(juego);
	}

	/**
	 * Modificar juego.
	 *
	 * @param indice         El índice del juego a modificar.
     * @param nombreDelJuego El nombre del juego modificado.
     * @param tipoDeJuego    El tipo de juego modificado.
     * @param presupuesto     El presupuesto modificado del juego.
	 */
	public void modificarJuego(int indice, String nombreDelJuego, String tipoDeJuego, double presupuesto) {
		juego = new Juego(nombreDelJuego, tipoDeJuego, presupuesto);
		juegos.set(indice, juego);
	}

	/**
	 * Eliminar juego.
	 *
	 * @param indice El índice del juego a eliminar.
	 */
	public void eliminarJuego(int indice) {
		juego = juegos.get(indice);
		juegos.remove(indice);
	}

	/**
	 * Registrar juegos.
	 */
	public void registrarJuegos() {
		archivo.registrarJuegos(juegos);
		juegos = archivo.obtenerJuegos();
	}

	/**
	 * Obtener indice juego.
	 *
	 * @param nombreDelJuego El nombre del juego.
     * @return El índice del juego en la lista, o -1 si no se encuentra.
	 */
	public int obtenerIndiceJuego(String nombreDelJuego) {
		// Iterar por todos los juegos existentes
		for (int i = 0; i < juegos.size(); i++)
			/*Si el nombre del juego pasado como argumento coincide con el nombre de alguno
			 * de los juegos actuales retornar el índice del juego */
			if (juegos.get(i).getNombreDelJuego().equals(nombreDelJuego))
				return i;
		return -1;
	}
	
	/**
	 * Asignar presupuestos.
	 *
	 * @param presupuestoTotalDisponible El presupuesto total disponible para asignar a los juegos.
	 */
	public void asignarPresupuestos(double presupuestoTotalDisponible) {
		
		// Validar que el presupuesto total disponible haya sido parametrizado
		if (presupuestoTotalDisponible > 0) {
			// Inicialmente asignar el presupuesto para cada uno de los juegos para que la suma de estos sea igual al presupuesto total disponible
			double presupuestoInicial = presupuestoTotalDisponible / juegos.size();
			for (Juego juego: juegos)
				juego.setPresupuesto(presupuestoInicial);
		} else {
			for (Juego juego: juegos)
				juego.setPresupuesto(0);
		}
		// Guardar los presupuestos asignados en el archivo juegos.dat
		registrarJuegos();
	}
	
	/**
	 * Obtener suma presupuestos asignados.
	 *
	 * @return La suma total de los presupuestos asignados a los juegos.
	 */
	public double obtenerSumaPresupuestosAsignados() {
		double suma = 0;
		for (Juego juego: juegos)
			suma += juego.getPresupuesto();
		return suma;
	}
	
	/**
	 * Obtener tipos de juegos actuales.
	 *
	 * @return Un array con los nombres de los juegos actuales.
	 */
	public String[] obtenerTiposDeJuegosActuales() {
		String[] juegosActuales = new String[juegos.size()];
		
		for (int i = 0; i < juegos.size(); i++)
			juegosActuales[i] = juegos.get(i).getNombreDelJuego();
		
		return juegosActuales;
	}
	

	/**
	 * Gets the juegos.
	 *
	 * @return the juegos
	 */
	public ArrayList<Juego> getJuegos() {
		return juegos;
	}

	/**
	 * Sets the juegos.
	 *
	 * @param juegos the new juegos
	 */
	public void setJuegos(ArrayList<Juego> juegos) {
		this.juegos = juegos;
	}

	/**
	 * Gets the juego.
	 *
	 * @return the juego
	 */
	public Juego getJuego() {
		return juego;
	}

	/**
	 * Sets the juego.
	 *
	 * @param juego the new juego
	 */
	public void setJuego(Juego juego) {
		this.juego = juego;
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
