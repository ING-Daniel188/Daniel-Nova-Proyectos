package co.edu.unbosque.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import co.edu.unbosque.model.persistence.ApostadorDAO;
import co.edu.unbosque.model.persistence.ApuestaDAO;
import co.edu.unbosque.model.persistence.JuegoDAO;
import co.edu.unbosque.model.persistence.Propiedades;
import co.edu.unbosque.model.persistence.SedeDAO;

/**
 * The Class CasaDeApuestas.
 */
public class CasaDeApuestas {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The nombre. */
	private String nombre;
	
	/** The numero de sedes. */
	private int numeroDeSedes;
	
	/** The presupuesto total disponible. */
	private double presupuestoTotalDisponible;
	
	/** The propiedades. */
	private Propiedades propiedades;
	
	/** The gestor de sedes. */
	private SedeDAO gestorDeSedes;
	
	/** The gestor de apostadores. */
	private ApostadorDAO gestorDeApostadores;
	
	/** The gestor de juegos. */
	private JuegoDAO gestorDeJuegos;
	
	/** The gestor de apuestas. */
	private ApuestaDAO gestorDeApuestas;


	/**
	 * Instantiates a new casa de apuestas.
	 */
	public CasaDeApuestas() {
		
		propiedades = new Propiedades();
		propiedades.leerPropiedadesCasaDeApuestas();
		
		inicializarAtributos();
		
		gestorDeSedes = new SedeDAO();
		gestorDeApostadores = new ApostadorDAO();
		gestorDeJuegos = new JuegoDAO();
		gestorDeApuestas = new ApuestaDAO();
	}
	
	
	/**
	 * Inicializar atributos.
	 */
	public void inicializarAtributos() {
		// Revisar si ya existe el archivo .properties
		if (propiedades.getProp().get("nombreCasaDeApuestas") != null) {
			setNombre(propiedades.getProp().get("nombreCasaDeApuestas").toString());
			setNumeroDeSedes(Integer.parseInt(propiedades.getProp().get("numeroDeSedes").toString()));
			setPresupuestoTotalDisponible(Double.parseDouble(propiedades.getProp().get("presupuestoTotalDisponible").toString()));
		} else {
			setNombre("");
			setNumeroDeSedes(0);
			setPresupuestoTotalDisponible(0);
		}
	}
	
	///////////////////////////////////////// PARAMETRIZACIÓN CASA DE APUESTAS /////////////////////////////////////////
	
	/**
	 * Guardar parametros.
	 *
	 * @param nombre                     El nombre de la casa de apuestas.
     * @param numeroDeSedes              El numero de sedes de la casa de apuestas.
     * @param presupuestoTotalDisponible  El presupuesto total disponible para la casa de apuestas.
     * @return true, si los parametros se guardan correctamente, false en caso contrario.
	 */
	public boolean guardarParametros(String nombre, int numeroDeSedes, double presupuestoTotalDisponible) {
		
		// Validar los parámetros de la casa de apuestas validados por la vista
		if (!nombre.isEmpty() && numeroDeSedes != -1 && presupuestoTotalDisponible != -1) {
			
			// Validar que al actualizar los parámetros de la casa de apuestas, estos no sean los mismos a los ya existentes 
			if (!nombre.equals(getNombre())
					|| numeroDeSedes != getNumeroDeSedes()
					|| presupuestoTotalDisponible != getPresupuestoTotalDisponible()) {
				
				// Guardar los parámetros de la casa de apuestas
				setNombre(nombre);
				setNumeroDeSedes(numeroDeSedes);
				setPresupuestoTotalDisponible(presupuestoTotalDisponible);
				gestionarPropiedades();

				return true;
			} 
		}
		return false;
	}
	
	
	/**
	 * Gestionar propiedades.
	 */
	public void gestionarPropiedades() {
		propiedades.escribirPropiedadesCasaDeApuestas(nombre, numeroDeSedes, presupuestoTotalDisponible);
		propiedades.leerPropiedadesCasaDeApuestas();
	}
	
	///////////////////////////////////////// GESTIÓN SEDES /////////////////////////////////////////
	
	/**
	 * Agregar sede.
	 *
	 * @param ubicacionSede     Ubicacion de la sede a agregar.
	 * @param numeroDeEmpleados Numero de empleados de la sede.
	 * @return true si se agrega la sede exitosamente, false en caso contrario.
	 */
	public boolean agregarSede(String ubicacionSede, int numeroDeEmpleados) {
		
		// Validar que todos los datos fueron ingresados
		if (!ubicacionSede.isEmpty() && numeroDeEmpleados != -1) {
			// Agregar nueva sede
			gestorDeSedes.agregarSede(ubicacionSede, numeroDeEmpleados);
			
			// Actualizar el archivo de sedes con la sede agregada
			gestorDeSedes.registrarSedes();
			return true;
		}
		return false;
		
	}
	
	
	/**
	 * Obtener fecha actual.
	 *
	 * @return La fecha y hora actual en formato de cadena.
	 */
	public String obtenerFechaActual() {
		LocalDateTime fechaActual = LocalDateTime.now(ZoneId.systemDefault());
		
		DateTimeFormatter formateadorDeFechas = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		String fechaFormateada = fechaActual.format(formateadorDeFechas);
		
		return fechaFormateada;
	}

	/**
	 * Modificar sede.
	 *
	 * @param filaSeleccionada  Indice de la sede seleccionada.
	 * @param ubicacionSede     Nueva ubicacion de la sede.
	 * @param numeroDeEmpleados Nuevo numero de empleados de la sede.
	 * @return true si se modifica la sede exitosamente, false en caso contrario.
	 */
	public boolean modificarSede(int filaSeleccionada, String ubicacionSede, int numeroDeEmpleados) {
		
		// Validar que la ubicación de la sede y el número de empleados hayan sido ingresados y sean diferentes a los actuales
		if (filaSeleccionada != -1 && !ubicacionSede.isEmpty() && numeroDeEmpleados != -1) {
			// Modificar la sede
			gestorDeSedes.modificarSede(filaSeleccionada, ubicacionSede, numeroDeEmpleados);
			
			// Actualizar el archivo de sedes con la sede modificada
			gestorDeSedes.registrarSedes();
			return true;
		}
		return false;
	}
	
	/**
	 * Eliminar sede.
	 *
	 * @param indice Indice de la sede a eliminar.
	 * @return true si se elimina la sede exitosamente, false en caso contrario.
	 */
	public boolean eliminarSede(int indice) {
		// Validar que el usuario haya seleccionado una fila de la tabla de la sede a eliminar
		if (indice != -1) {
			gestorDeSedes.eliminarSede(indice);
			gestorDeSedes.registrarSedes();
			return true;
		}
		return false;
	}
	
	///////////////////////////////////////// GESTIÓN APUESTAS /////////////////////////////////////////
	
	// Métodos de Lotería
	
	/**
	 * Generar numero loteria serie 1.
	 *
	 * @return El numero de loteria de la serie 1 generado.
	 */
	public int generarNumeroLoteriaSerie1() {
		return gestorDeApuestas.getGestorApuestasLoteria().getApuestaLoteria().generarNumeroLoteriaSerie1();
	}
	
	/**
	 * Generar numero loteria serie 2.
	 *
	 * @return El numero de loteria de la serie 2 generado.
	 */
	public int generarNumeroLoteriaSerie2() {
		return gestorDeApuestas.getGestorApuestasLoteria().getApuestaLoteria().generarNumeroLoteriaSerie2();
	}
	
	/**
	 * Generar numero loteria serie 3.
	 *
	 * @return El numero de loteria de la serie 3 generado.
	 */
	public int generarNumeroLoteriaSerie3() {
		return gestorDeApuestas.getGestorApuestasLoteria().getApuestaLoteria().generarNumeroLoteriaSerie3();
	}
	
	/**
	 * Generar numero loteria serie 4.
	 *
	 * @return El numero de loteria de la serie 4 generado.
	 */
	public int generarNumeroLoteriaSerie4() {
		return gestorDeApuestas.getGestorApuestasLoteria().getApuestaLoteria().generarNumeroLoteriaSerie4();
	}
	
	/**
	 * Generar series loteria.
	 *
	 * @return Un arreglo de enteros con las series de loteria generadas.
	 */
	public int[] generarSeriesLoteria() {
		int[] series = new int[4];
		for (int i = 0; i < 4; i++)
			series[i] = gestorDeApuestas.getGestorApuestasLoteria().getApuestaLoteria().generarSerie();
		return series;
	}
	
	// Métodos de Chance
	
	/**
	 * Obtener numeros chance.
	 *
	 * @return Un arreglo de enteros con los numeros de chance generados.
	 */
	public int[] obtenerNumerosChance() {
		return gestorDeApuestas.getGestorApuestasChance().getApuestaChance().generarNumeros();
	}
	

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the numero de sedes.
	 *
	 * @return the numero de sedes
	 */
	public int getNumeroDeSedes() {
		return numeroDeSedes;
	}

	/**
	 * Sets the numero de sedes.
	 *
	 * @param numeroDeSedes the new numero de sedes
	 */
	public void setNumeroDeSedes(int numeroDeSedes) {
		this.numeroDeSedes = numeroDeSedes;
	}

	/**
	 * Gets the presupuesto total disponible.
	 *
	 * @return the presupuesto total disponible
	 */
	public double getPresupuestoTotalDisponible() {
		return presupuestoTotalDisponible;
	}

	/**
	 * Sets the presupuesto total disponible.
	 *
	 * @param presupuestoTotalDisponible the new presupuesto total disponible
	 */
	public void setPresupuestoTotalDisponible(double presupuestoTotalDisponible) {
		this.presupuestoTotalDisponible = presupuestoTotalDisponible;
	}

	/**
	 * Gets the gestor de sedes.
	 *
	 * @return the gestor de sedes
	 */
	public SedeDAO getGestorDeSedes() {
		return gestorDeSedes;
	}

	/**
	 * Sets the gestor de sedes.
	 *
	 * @param gestorDeSedes the new gestor de sedes
	 */
	public void setGestorDeSedes(SedeDAO gestorDeSedes) {
		this.gestorDeSedes = gestorDeSedes;
	}

	/**
	 * Gets the gestor de apostadores.
	 *
	 * @return the gestor de apostadores
	 */
	public ApostadorDAO getGestorDeApostadores() {
		return gestorDeApostadores;
	}

	/**
	 * Sets the gestor de apostadores.
	 *
	 * @param gestorDeApostadores the new gestor de apostadores
	 */
	public void setGestorDeApostadores(ApostadorDAO gestorDeApostadores) {
		this.gestorDeApostadores = gestorDeApostadores;
	}

	/**
	 * Gets the gestor de juegos.
	 *
	 * @return the gestor de juegos
	 */
	public JuegoDAO getGestorDeJuegos() {
		return gestorDeJuegos;
	}

	/**
	 * Sets the gestor de juegos.
	 *
	 * @param gestorDeJuegos the new gestor de juegos
	 */
	public void setGestorDeJuegos(JuegoDAO gestorDeJuegos) {
		this.gestorDeJuegos = gestorDeJuegos;
	}

	/**
	 * Gets the gestor de apuestas.
	 *
	 * @return the gestor de apuestas
	 */
	public ApuestaDAO getGestorDeApuestas() {
		return gestorDeApuestas;
	}

	/**
	 * Sets the gestor de apuestas.
	 *
	 * @param gestorDeApuestas the new gestor de apuestas
	 */
	public void setGestorDeApuestas(ApuestaDAO gestorDeApuestas) {
		this.gestorDeApuestas = gestorDeApuestas;
	}

	/**
	 * Gets the propiedades.
	 *
	 * @return the propiedades
	 */
	public Propiedades getPropiedades() {
		return propiedades;
	}

	/**
	 * Sets the propiedades.
	 *
	 * @param propiedades the new propiedades
	 */
	public void setPropiedades(Propiedades propiedades) {
		this.propiedades = propiedades;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
