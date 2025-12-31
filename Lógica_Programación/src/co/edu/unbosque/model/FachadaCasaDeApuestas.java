package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.GestionApostadores;
import co.edu.unbosque.model.persistence.GestionBaloto;
import co.edu.unbosque.model.persistence.GestionBetPlay;
import co.edu.unbosque.model.persistence.GestionChance;
import co.edu.unbosque.model.persistence.GestionJuegos;
import co.edu.unbosque.model.persistence.GestionLoteria;
import co.edu.unbosque.model.persistence.Propiedades;
import co.edu.unbosque.model.persistence.GestionSedes;
import co.edu.unbosque.model.persistence.GestionSuperAstro;

// TODO: Auto-generated Javadoc
/**
 * The Class CasaDeApuestas.
 */
public class FachadaCasaDeApuestas {

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
	private GestionSedes gestorDeSedes;
	
	/** The gestor de apostadores. */
	private GestionApostadores gestorDeApostadores;
	
	/** The gestor de juegos. */
	private GestionJuegos gestorDeJuegos;
	
	/** The gestion loteria. */
	private GestionLoteria gestionLoteria;
	
	/** The gestion super astro. */
	private GestionSuperAstro gestionSuperAstro;
	
	/** The gestion baloto. */
	private GestionBaloto gestionBaloto;
	
	/** The gestion bet play. */
	private GestionBetPlay gestionBetPlay;
	
	/** The gestion chance. */
	private GestionChance gestionChance;


	/**
	 * Instantiates a new casa de apuestas.
	 */
	public FachadaCasaDeApuestas() {
		
		propiedades = new Propiedades();
		
		// Revisar si ya existe el archivo .properties
		if (!propiedades.obtenerNombreCasa().isEmpty()) {
			setNombre(propiedades.obtenerNombreCasa());
			setNumeroDeSedes(propiedades.obtenerNumeroSedes());
			setPresupuestoTotalDisponible(propiedades.obtenerPresupuestoTotal());
		} else {
			setNombre("");
			setNumeroDeSedes(0);
			setPresupuestoTotalDisponible(0);
		}
		
		gestorDeSedes = new GestionSedes();
		gestorDeApostadores = new GestionApostadores();
		gestorDeJuegos = new GestionJuegos();
		asignarPresupuestosAJuegos();
		
		gestionLoteria = new GestionLoteria();
		gestionSuperAstro = new GestionSuperAstro();
		gestionBaloto = new GestionBaloto();
		gestionBetPlay = new GestionBetPlay();
		gestionChance = new GestionChance();
	}
	
	///////////////////////////////////////// PARAMETRIZACIÓN CASA DE APUESTAS /////////////////////////////////////////
	
	/**
	 * Guardar parametros.
	 *
	 * @param nombre                     El nombre de la casa de apuestas.
	 * @param numeroDeSedes              El numero de sedes de la casa de apuestas.
	 * @param presupuestoTotal the presupuesto total
	 * @return true, si los parametros se guardan correctamente, false en caso contrario.
	 */
	public boolean guardarParametros(String nombre, int numeroDeSedes, double presupuestoTotal) {
		
		// Validar los parámetros de la casa de apuestas validados por la vista
		if (!nombre.isEmpty() && numeroDeSedes != -1 && presupuestoTotal != -1) {
			
			// Validar que al actualizar los parámetros de la casa de apuestas, estos no sean los mismos a los ya existentes 
			if (!nombre.equals(getNombre())
					|| numeroDeSedes != getNumeroDeSedes()
					|| presupuestoTotal != getPresupuestoTotalDisponible()) {
				
				// Guardar los parámetros de la casa de apuestas
				setNombre(nombre);
				setNumeroDeSedes(numeroDeSedes);
				setPresupuestoTotalDisponible(presupuestoTotal);
				propiedades.escribirPropiedadesCasaDeApuestas(nombre, numeroDeSedes, presupuestoTotal);

				return true;
			} 
		}
		return false;
	}
	
	/**
	 * Asignar presupuestos A juegos.
	 */
	public void asignarPresupuestosAJuegos() {
		gestorDeJuegos.asignarPresupuestos(this.presupuestoTotalDisponible);
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
	
	
	/**
	 * Agregar apuesta loteria.
	 *
	 * @param tipoDeApuesta Tipo de apuesta a agregar
	 * @param nombreSede Nombre de la sede en la cual se realiza la apuesta a agregar
	 * @param cedulaApostador Cedula del apostador que realiza la apuesta a agregar
	 * @param dia Dia en la cual se realiza la apuesta
	 * @param valor Monto total de la apuesta
	 * @param nombre Nombre de la loteria de la apuesta de loteria a agregar
	 * @param numeroLoteria Numero de la loteria de la apuesta de loteria a agregar
	 * @param serie Numero de la serie de la loteria a agregar
	 */
	public void agregarApuestaLoteria(String tipoDeApuesta, String nombreSede, String cedulaApostador, String dia,
			double valor, String nombre, int numeroLoteria, int serie) {

		// Agregar la apuesta de lotería al ArrayList
		gestionLoteria.agregarApuestaLoteria(tipoDeApuesta, nombreSede, cedulaApostador, dia, valor, nombre,
				numeroLoteria, serie);

		// Guardar la apuesta en el archivo apuestas-loteria.dat
		gestionLoteria.registrarApuestasLoteria();
	}

	/**
	 * Agregar apuesta super astro.
	 *
	 * @param nombreSede Nombre de la sede en la que se realiza la apuesta de superastro
	 * @param cedulaApostador Cedula del apostador que realiza la apuesta de superastro
	 * @param dia Dia en la cual se realiza la apuesta a agregar
	 * @param valor Monto total de la apuesta de superastro a agregar
	 * @param numerosSeleccionados Numeros seleccionados por el apostador de la apuesta de superastro a agregar
	 * @param signoDelZodiaco Signo del zodiaco escogido por el apostador de la apuesta de superastro a agregar
	 */
	public void agregarApuestaSuperAstro(String nombreSede, String cedulaApostador, String dia, double valor,
			int[] numerosSeleccionados, String signoDelZodiaco) {

		// Agregar la apuesta de superAstro al ArrayList
		gestionSuperAstro.agregarApuestaSuperAstro(nombreSede, cedulaApostador, dia, valor,
				numerosSeleccionados, signoDelZodiaco);

		// Guardar la apuesta en el archivo apuestas-superastro.dat
		gestionSuperAstro.registrarApuestasSuperAstro();

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

		// Agregar la apuesta de Baloto al ArrayList
		gestionBaloto.agregarApuestaBaloto(nombreSede, cedulaApostador, dia, valor, numerosSeleccionados);

		// Guardar la apuesta en el archivo apuestas-baloto.dat
		gestionBaloto.registrarApuestasBaloto();

	}

	/**
	 * Agregar apuesta chance.
	 *
	 * @param nombreSede Nombre de la sede en la que se realiza la apuesta de chance a agregar
	 * @param cedulaApostador Cedula del apostador que realiza la apuesta de chance a agregar
	 * @param dia Dia de la apuesta de chance a agregar
	 * @param valor Monto total de la apuesta de chance a agregar
	 * @param nombre Nombre de la loteria de la apuesta de chance a agregar
	 * @param numerosSeleccionados Numeros seleccionados por el apostador de la apuesta de chance a agregar
	 */
	public void agregarApuestaChance(String nombreSede, String cedulaApostador, String dia, double valor,
			String nombre, int[] numerosSeleccionados) {

		// Agregar la apuesta de Chance al ArrayList
		gestionChance.agregarApuestaChance(nombreSede, cedulaApostador, dia, valor, nombre,
				numerosSeleccionados);

		// Guardar la apuesta en el archivo apuestas-chance.dat
		gestionChance.registrarApuestasChance();

	}

	/**
	 * Agregar apuesta bet play.
	 *
	 * @param nombreSede Nombre de la sede en la que se realiza la apuesta de betplay a agregar
	 * @param cedulaApostador Cedula del apostador que realiza la apuesta de betplay a agregar
	 * @param dia Dia de la apuesta de betplay a agregar
	 * @param valor Monto total de la apuesta de betplay a agregar
	 * @param partidosYResultadosEscogidos Partidos y resultados seleccionados por el apostador de la apuesta de betplay a agregar
	 */
	public void agregarApuestaBetPlay(String nombreSede, String cedulaApostador, String dia, double valor,
			String[][] partidosYResultadosEscogidos) {

		// Agregar la apuesta de BetPlay al ArrayList
		gestionBetPlay.agregarApuestaBetPlay(nombreSede, cedulaApostador, dia, valor,
				partidosYResultadosEscogidos);

		// Guardar la apuesta en el archivo apuestas-betplay.dat
		gestionBetPlay.registrarApuestasBetPlay();

	}

	/**
	 * Modificar apuesta loteria.
	 *
	 * @param indice Indice de la ubicacion del ArrayList de la apuesta de loteria a modificar
	 * @param tipoDeApuesta Tipo de apuesta que se realiza (Juegos de azar, deportiva, etc...) a modificar
	 * @param nombreSede Nombre de la sede en la que se realiza la apuesta de loteria a modificar
	 * @param cedulaApostador Cedula del apostador que realiza la apuesta de loteria a modificar
	 * @param dia Dia en la que se realiza la apuesta de loteria a modificar
	 * @param valor Monto total de la apuesta de loteria a modificar
	 * @param nombre Nombre de la loteria de la apuesta de loteria a modificar
	 * @param numeroLoteria Numero de loteria de la apuesta de loteria a modificar
	 * @param serie Numero de serie de la apuesta de loteria a modificar
	 */
	public void modificarApuestaLoteria(int indice, String tipoDeApuesta, String nombreSede, String cedulaApostador,
			String dia, double valor, String nombre, int numeroLoteria, int serie) {
		gestionLoteria.modificarApuestaLoteria(indice, tipoDeApuesta, nombreSede, cedulaApostador, dia, valor,
				nombre, numeroLoteria, serie);
	}

	/**
	 * Modificar apuesta super astro.
	 *
	 * @param indice Indice de la ubicacion del ArrayList de la apuesta de superastro a modificar
	 * @param nombreSede Nombre de la sede de la apuesta de superastro a modificar
	 * @param cedulaApostador Cedula del apostador que realizo la apuesta de superastro a modificar
	 * @param dia Dia en la que se realiza la apuesta de superastro a modificar
	 * @param valor Monto total de la apuesta de superastro a modificar
	 * @param numerosSeleccionados Numeros seleccionados por el apostador de la apuesta de superastro a modificar
	 * @param signoDelZodiaco Signo del zodiaco escogido por el apostador de la apuesta de superastro a modificar
	 */
	public void modificarApuestaSuperAstro(int indice, String nombreSede, String cedulaApostador, String dia,
			double valor, int[] numerosSeleccionados, String signoDelZodiaco) {
		gestionSuperAstro.modificarApuestaSuperAstro(indice, nombreSede, cedulaApostador, dia, valor,
				numerosSeleccionados, signoDelZodiaco);
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
	public void modificarApuestaBaloto(int indice, String nombreSede, String cedulaApostador, String dia,
			double valor, int[] numerosSeleccionados) {
		gestionBaloto.modificarApuestaBaloto(indice, nombreSede, cedulaApostador, dia, valor,
				numerosSeleccionados);
	}

	/**
	 * Modificar apuesta bet play.
	 *
	 * @param indice Indice de la ubicacion en el ArrayList de la apuesta de betplay a modificar
	 * @param nombreSede Nombre de la sede en la que se realiza la apuesta de betplay
	 * @param cedulaApostador Cedula del apostador que realizo la apuesta de betplay a modificar
	 * @param dia Dia en la cual se realiza la apuesta de betplay a modificar
	 * @param valor Monto total de la apuesta de betplay a modificar
	 * @param partidosYResultadosEscogidos Partidos y resultados escogidos por el apostador de la apuesta de betplay a modificar.
	 */
	public void modificarApuestaBetPlay(int indice, String nombreSede, String cedulaApostador, String dia,
			double valor, String[][] partidosYResultadosEscogidos) {
		gestionBetPlay.modificarApuestaBetPlay(indice, nombreSede, cedulaApostador, dia, valor,
				partidosYResultadosEscogidos);
	}

	/**
	 * Modificar apuesta chance.
	 *
	 * @param indice Indice de la posicion en el ArrayList de la apuesta de chance a modificar
	 * @param nombreSede Nombre de la sede en la que se realiza la apuesta de chance a modificar
	 * @param cedulaApostador Cedula del apostador que realizo la apuesta de chance a modificar
	 * @param dia Dia en la cual se realiza la apuesta de chance a modificar
	 * @param valor Monto total de la apuesta de chance a modificar
	 * @param nombre Nombre de la loteria de la apuesta de chance a modificar
	 * @param numerosSeleccionados Numeros seleccionados por el apostador de la apuesta de chance a modificar
	 */
	public void modificarApuestaChance(int indice, String nombreSede, String cedulaApostador, String dia,
			double valor, String nombre, int[] numerosSeleccionados) {
		gestionChance.modificarApuestaChance(indice, nombreSede, cedulaApostador, dia, valor, nombre,
				numerosSeleccionados);
	}

	/**
	 * Eliminar apuesta.
	 *
	 * @param tipoDeApuesta El tipo de la apuesta a eliminar (Loteria, SuperAstro, Baloto, Betplay o Chance)
	 * @param cedulaApostador Cedula del apostador que realizo la apuesta a eliminar
	 * @param dia Dia en la que se realizo la apuesta a eliminar
	 */
	public void eliminarApuesta(String tipoDeApuesta, String cedulaApostador, String dia) {

		switch (tipoDeApuesta) {

		case "Loteria":
			int indiceApuestaLoteria = gestionLoteria.obtenerIndiceApuesta(cedulaApostador, dia);
			gestionLoteria.eliminarApuestaLoteria(indiceApuestaLoteria);
			break;
		case "SuperAstro":
			int indiceApuestaSuperAstro = gestionSuperAstro.obtenerIndiceApuesta(cedulaApostador, dia);
			gestionSuperAstro.eliminarApuestaSuperAstro(indiceApuestaSuperAstro);
			break;
		case "Baloto":
			int indiceApuestaBaloto = gestionBaloto.obtenerIndiceApuesta(cedulaApostador, dia);
			gestionBaloto.eliminarApuestaBaloto(indiceApuestaBaloto);
			break;

		case "BetPlay":
			int indiceApuestaBetPlay = gestionBetPlay.obtenerIndiceApuesta(cedulaApostador, dia);
			gestionBetPlay.eliminarApuestaBetPlay(indiceApuestaBetPlay);
			break;

		case "Chance":
			int indiceApuestaChance = gestionChance.obtenerIndiceApuesta(cedulaApostador, dia);
			gestionChance.eliminarApuestaChance(indiceApuestaChance);
			break;

		}

	}
	
	
	// Métodos de Chance
	
	
	/**
	 * Obtener apuesta loteria.
	 *
	 * @param indice Indice de la ubicacion en el ArrayList de la apuesta de loteria a obtener
	 * @return Objeto de loteria
	 */
	public Object[] obtenerApuestaLoteria(int indice) {

		// Objeto creado para obtener los datos de las filas de la tabla apuestas
		Object[] apuestaLoteria = { gestionLoteria.getApuestasLoteria().get(indice).getTipoDeApuesta(),
				gestionLoteria.getApuestasLoteria().get(indice).getNombreSede(),
				gestionLoteria.getApuestasLoteria().get(indice).getCedulaApostador(),
				gestionLoteria.getApuestasLoteria().get(indice).getDia(),
				gestionLoteria.getApuestasLoteria().get(indice).getValor() };
		return apuestaLoteria;
	}

	/**
	 * Obtener apuesta super astro.
	 *
	 * @param indice Indice de la ubicacion en el ArrayList de la apuesta de superastro a obtener
	 * @return Objeto de superastro
	 */
	public Object[] obtenerApuestaSuperAstro(int indice) {

		// Objeto creado para obtener los datos de las filas de la tabla apuestas
		Object[] apuestaSuperAstro = { gestionSuperAstro.getApuestasSuperAstro().get(indice).getTipoDeApuesta(),
				gestionSuperAstro.getApuestasSuperAstro().get(indice).getNombreSede(),
				gestionSuperAstro.getApuestasSuperAstro().get(indice).getCedulaApostador(),
				gestionSuperAstro.getApuestasSuperAstro().get(indice).getDia(),
				gestionSuperAstro.getApuestasSuperAstro().get(indice).getValor() };
		return apuestaSuperAstro;
	}

	/**
	 * Obtener apuesta baloto.
	 *
	 * @param indice Indice de la ubicacion en el ArrayList de la apuesta de baloto a obtener
	 * @return Objeto de baloto
	 */
	public Object[] obtenerApuestaBaloto(int indice) {

		// Objeto creado para obtener los datos de las filas de la tabla apuestas
		Object[] apuestaBaloto = { gestionBaloto.getApuestasBaloto().get(indice).getTipoDeApuesta(),
				gestionBaloto.getApuestasBaloto().get(indice).getNombreSede(),
				gestionBaloto.getApuestasBaloto().get(indice).getCedulaApostador(),
				gestionBaloto.getApuestasBaloto().get(indice).getDia(),
				gestionBaloto.getApuestasBaloto().get(indice).getValor() };
		return apuestaBaloto;
	}

	/**
	 * Obtener apuesta chance.
	 *
	 * @param indice Indice de la ubicacion en el ArrayList de la apuesta de chance a obtener
	 * @return Objeto de chance
	 */
	public Object[] obtenerApuestaChance(int indice) {

		// Objeto creado para obtener los datos de las filas de la tabla apuestas
		Object[] apuestaChance = { gestionChance.getApuestasChance().get(indice).getTipoDeApuesta(),
				gestionChance.getApuestasChance().get(indice).getNombreSede(),
				gestionChance.getApuestasChance().get(indice).getCedulaApostador(),
				gestionChance.getApuestasChance().get(indice).getDia(),
				gestionChance.getApuestasChance().get(indice).getValor() };
		return apuestaChance;
	}

	/**
	 * Obtener apuesta bet play.
	 *
	 * @param indice Indice de la ubicacion en el ArrayList de la apuesta de betplay a obtener
	 * @return Objeto de betplay
	 */
	public Object[] obtenerApuestaBetPlay(int indice) {

		// Objeto creado para obtener los datos de las filas de la tabla apuestas
		Object[] apuestaBetPlay = { gestionBetPlay.getApuestasBetPlay().get(indice).getTipoDeApuesta(),
				gestionBetPlay.getApuestasBetPlay().get(indice).getNombreSede(),
				gestionBetPlay.getApuestasBetPlay().get(indice).getCedulaApostador(),
				gestionBetPlay.getApuestasBetPlay().get(indice).getDia(),
				gestionBetPlay.getApuestasBetPlay().get(indice).getValor() };
		return apuestaBetPlay;
	}

	/**
	 * Obtener apuestas por cliente.
	 *
	 * @param cedula the cedula
	 * @return Matriz con todas las apuestas realizadas por el apostador
	 */
	public Object[][] obtenerApuestasPorCliente(String cedula) {

		// Obtener el número de apuestas de cada tipo para obtener el número total de apuestas
		int numeroApuestasLoteria = gestionLoteria.obtenerApuestasLoteriaPorCliente(cedula).size();
		int numeroApuestasSuperAstro = gestionSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).size();
		int numeroApuestasBaloto = gestionBaloto.obtenerApuestasBalotoPorCliente(cedula).size();
		int numeroApuestasBetPlay = gestionBetPlay.obtenerApuestasBetPlayPorCliente(cedula).size();
		int numeroApuestasChance = gestionChance.obtenerApuestasChancePorCliente(cedula).size();

		int numeroTotalApuestas = numeroApuestasLoteria + numeroApuestasSuperAstro + numeroApuestasBaloto
				+ numeroApuestasBetPlay + numeroApuestasChance;

		Object[][] apuestasPorCliente = new Object[numeroTotalApuestas][2];
		
		int indiceApuesta = 0;
		
		// Obtener apuestas de lotería
		for (int i = 0; i < numeroApuestasLoteria; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestionLoteria.obtenerApuestasLoteriaPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestionLoteria.obtenerApuestasLoteriaPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de superastro
		for (int i = 0; i < numeroApuestasSuperAstro; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestionSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestionSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de baloto
		for (int i = 0; i < numeroApuestasBaloto; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestionBaloto.obtenerApuestasBalotoPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestionBaloto.obtenerApuestasBalotoPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de betplay
		for (int i = 0; i < numeroApuestasBetPlay; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestionBetPlay.obtenerApuestasBetPlayPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestionBetPlay.obtenerApuestasBetPlayPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de chance
		for (int i = 0; i < numeroApuestasChance; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestionChance.obtenerApuestasChancePorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestionChance.obtenerApuestasChancePorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		return apuestasPorCliente;
	}
	
	/**
	 * Obtener apuestas por sede.
	 *
	 * @param sede Sede en la cual se realizaron las apuestas
	 * @return Objeto con todas las apuestas ubicadas en la sede proveida
	 */
	public Object[][] obtenerApuestasPorSede(String sede) {
		
		// Obtener el número de apuestas de cada tipo para obtener el número total de apuestas
		int numeroApuestasLoteria = gestionLoteria.obtenerNumeroApuestasLoteriaPorSede(sede);
		int numeroApuestasSuperAstro = gestionSuperAstro.obtenerNumeroApuestasSuperAstroPorSede(sede);
		int numeroApuestasBaloto = gestionBaloto.obtenerNumeroApuestasBalotoPorSede(sede);
		int numeroApuestasBetPlay = gestionBetPlay.obtenerNumeroApuestasBetPlayPorSede(sede);
		int numeroApuestasChance = gestionChance.obtenerNumeroApuestasChancePorSede(sede);

		int numeroTotalApuestas = numeroApuestasLoteria + numeroApuestasSuperAstro + numeroApuestasBaloto
				+ numeroApuestasBetPlay + numeroApuestasChance;
		
		Object[][] apuestasPorSede = new Object[numeroTotalApuestas][5];
		
		
		int indiceApuesta = 0;
		
		// Obtener apuestas de lotería
		for (int i = 0; i < numeroApuestasLoteria; i++) {
			apuestasPorSede[indiceApuesta][0] = gestionLoteria.obtenerApuestasLoteriaPorSede(sede).get(i).getTipoDeApuesta();
			apuestasPorSede[indiceApuesta][1] = gestionLoteria.obtenerApuestasLoteriaPorSede(sede).get(i).getNombreSede();
			apuestasPorSede[indiceApuesta][2] = gestionLoteria.obtenerApuestasLoteriaPorSede(sede).get(i).getCedulaApostador();
			apuestasPorSede[indiceApuesta][3] = gestionLoteria.obtenerApuestasLoteriaPorSede(sede).get(i).getDia();
			apuestasPorSede[indiceApuesta][4] = gestionLoteria.obtenerApuestasLoteriaPorSede(sede).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de superastro
		for (int i = 0; i < numeroApuestasSuperAstro; i++) {
			apuestasPorSede[indiceApuesta][0] = gestionSuperAstro.obtenerApuestasSuperAstroPorSede(sede).get(i).getTipoDeApuesta();
			apuestasPorSede[indiceApuesta][1] = gestionSuperAstro.obtenerApuestasSuperAstroPorSede(sede).get(i).getNombreSede();
			apuestasPorSede[indiceApuesta][2] = gestionSuperAstro.obtenerApuestasSuperAstroPorSede(sede).get(i).getCedulaApostador();
			apuestasPorSede[indiceApuesta][3] = gestionSuperAstro.obtenerApuestasSuperAstroPorSede(sede).get(i).getDia();
			apuestasPorSede[indiceApuesta][4] = gestionSuperAstro.obtenerApuestasSuperAstroPorSede(sede).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de baloto
		for (int i = 0; i < numeroApuestasBaloto; i++) {
			apuestasPorSede[indiceApuesta][0] = gestionBaloto.obtenerApuestasBalotoPorSede(sede).get(i).getTipoDeApuesta();
			apuestasPorSede[indiceApuesta][1] = gestionBaloto.obtenerApuestasBalotoPorSede(sede).get(i).getNombreSede();
			apuestasPorSede[indiceApuesta][2] = gestionBaloto.obtenerApuestasBalotoPorSede(sede).get(i).getCedulaApostador();
			apuestasPorSede[indiceApuesta][3] = gestionBaloto.obtenerApuestasBalotoPorSede(sede).get(i).getDia();
			apuestasPorSede[indiceApuesta][4] = gestionBaloto.obtenerApuestasBalotoPorSede(sede).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de betplay
		for (int i = 0; i < numeroApuestasBetPlay; i++) {
			apuestasPorSede[indiceApuesta][0] = gestionBetPlay.obtenerApuestasBetPlayPorSede(sede).get(i).getTipoDeApuesta();
			apuestasPorSede[indiceApuesta][1] = gestionBetPlay.obtenerApuestasBetPlayPorSede(sede).get(i).getNombreSede();
			apuestasPorSede[indiceApuesta][2] = gestionBetPlay.obtenerApuestasBetPlayPorSede(sede).get(i).getCedulaApostador();
			apuestasPorSede[indiceApuesta][3] = gestionBetPlay.obtenerApuestasBetPlayPorSede(sede).get(i).getDia();
			apuestasPorSede[indiceApuesta][4] = gestionBetPlay.obtenerApuestasBetPlayPorSede(sede).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de chance
		for (int i = 0; i < numeroApuestasChance; i++) {
			apuestasPorSede[indiceApuesta][0] = gestionChance.obtenerApuestasChancePorSede(sede).get(i).getTipoDeApuesta();
			apuestasPorSede[indiceApuesta][1] = gestionChance.obtenerApuestasChancePorSede(sede).get(i).getNombreSede();
			apuestasPorSede[indiceApuesta][2] = gestionChance.obtenerApuestasChancePorSede(sede).get(i).getCedulaApostador();
			apuestasPorSede[indiceApuesta][3] = gestionChance.obtenerApuestasChancePorSede(sede).get(i).getDia();
			apuestasPorSede[indiceApuesta][4] = gestionChance.obtenerApuestasChancePorSede(sede).get(i).getValor();
			indiceApuesta++;
		}
		
		
		return apuestasPorSede;
		
	}
	
	/**
	 * Obtener apuestas completas por cliente.
	 *
	 * @param cedula Cedula del apostador
	 * @return Objeto con todas las apuestas realizadas por el apostador
	 */
	public Object[][] obtenerApuestasCompletasPorCliente(String cedula) {

		// Obtener el número de apuestas de cada tipo para obtener el número total de apuestas
		int numeroApuestasLoteria = gestionLoteria.obtenerApuestasLoteriaPorCliente(cedula).size();
		int numeroApuestasSuperAstro = gestionSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).size();
		int numeroApuestasBaloto = gestionBaloto.obtenerApuestasBalotoPorCliente(cedula).size();
		int numeroApuestasBetPlay = gestionBetPlay.obtenerApuestasBetPlayPorCliente(cedula).size();
		int numeroApuestasChance = gestionChance.obtenerApuestasChancePorCliente(cedula).size();

		int numeroTotalApuestas = numeroApuestasLoteria + numeroApuestasSuperAstro + numeroApuestasBaloto
				+ numeroApuestasBetPlay + numeroApuestasChance;

		Object[][] apuestasPorCliente = new Object[numeroTotalApuestas][5];
		
		int indiceApuesta = 0;
		
		// Obtener apuestas de lotería
		for (int i = 0; i < numeroApuestasLoteria; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestionLoteria.obtenerApuestasLoteriaPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestionLoteria.obtenerApuestasLoteriaPorCliente(cedula).get(i).getNombreSede();
			apuestasPorCliente[indiceApuesta][2] = gestionLoteria.obtenerApuestasLoteriaPorCliente(cedula).get(i).getCedulaApostador();
			apuestasPorCliente[indiceApuesta][3] = gestionLoteria.obtenerApuestasLoteriaPorCliente(cedula).get(i).getDia();
			apuestasPorCliente[indiceApuesta][4] = gestionLoteria.obtenerApuestasLoteriaPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de superastro
		for (int i = 0; i < numeroApuestasSuperAstro; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestionSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestionSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).get(i).getNombreSede();
			apuestasPorCliente[indiceApuesta][2] = gestionSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).get(i).getCedulaApostador();
			apuestasPorCliente[indiceApuesta][3] = gestionSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).get(i).getDia();
			apuestasPorCliente[indiceApuesta][4] = gestionSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de baloto
		for (int i = 0; i < numeroApuestasBaloto; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestionBaloto.obtenerApuestasBalotoPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestionBaloto.obtenerApuestasBalotoPorCliente(cedula).get(i).getNombreSede();
			apuestasPorCliente[indiceApuesta][2] = gestionBaloto.obtenerApuestasBalotoPorCliente(cedula).get(i).getCedulaApostador();
			apuestasPorCliente[indiceApuesta][3] = gestionBaloto.obtenerApuestasBalotoPorCliente(cedula).get(i).getDia();
			apuestasPorCliente[indiceApuesta][4] = gestionBaloto.obtenerApuestasBalotoPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de betplay
		for (int i = 0; i < numeroApuestasBetPlay; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestionBetPlay.obtenerApuestasBetPlayPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestionBetPlay.obtenerApuestasBetPlayPorCliente(cedula).get(i).getNombreSede();
			apuestasPorCliente[indiceApuesta][2] = gestionBetPlay.obtenerApuestasBetPlayPorCliente(cedula).get(i).getCedulaApostador();
			apuestasPorCliente[indiceApuesta][3] = gestionBetPlay.obtenerApuestasBetPlayPorCliente(cedula).get(i).getDia();
			apuestasPorCliente[indiceApuesta][4] = gestionBetPlay.obtenerApuestasBetPlayPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de chance
		for (int i = 0; i < numeroApuestasChance; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestionChance.obtenerApuestasChancePorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestionChance.obtenerApuestasChancePorCliente(cedula).get(i).getNombreSede();
			apuestasPorCliente[indiceApuesta][2] = gestionChance.obtenerApuestasChancePorCliente(cedula).get(i).getCedulaApostador();
			apuestasPorCliente[indiceApuesta][3] = gestionChance.obtenerApuestasChancePorCliente(cedula).get(i).getDia();
			apuestasPorCliente[indiceApuesta][4] = gestionChance.obtenerApuestasChancePorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		return apuestasPorCliente;
	}
	
	/**
	 * Obtener numero de apuestas loteria.
	 *
	 * @return Entero con el numero de apuestas de loteria
	 */
	public int obtenerNumeroDeApuestasLoteria() {
		return gestionLoteria.getApuestasLoteria().size();
	}
	
	/**
	 * Obtener numero de apuestas super astro.
	 *
	 * @return Entero con el numero de apuestas de superastro
	 */
	public int obtenerNumeroDeApuestasSuperAstro() {
		return gestionSuperAstro.getApuestasSuperAstro().size();
	}
	
	/**
	 * Obtener numero de apuestas baloto.
	 *
	 * @return Entero con el numero de apuestas de baloto
	 */
	public int obtenerNumeroDeApuestasBaloto() {
		return gestionBaloto.getApuestasBaloto().size();
	}
	
	/**
	 * Obtener numero de apuestas bet play.
	 *
	 * @return Entero con el numero de apuestas de betplay
	 */
	public int obtenerNumeroDeApuestasBetPlay() {
		return gestionBetPlay.getApuestasBetPlay().size();
	}
	
	/**
	 * Obtener numero de apuestas chance.
	 *
	 * @return Entero con el numero de apuestas de chance
	 */
	public int obtenerNumeroDeApuestasChance() {
		return gestionChance.getApuestasChance().size();
	}
	
	/**
	 * Obtener numero de apuestas por sede.
	 *
	 * @param sede Sede en la que se realizaron las apuestas
	 * @return Numero de apuestas sorteadas por la sede proveida
	 */
	public int obtenerNumeroDeApuestasPorSede(String sede) {
		int numeroApuestasPorSede = 0;
		
		numeroApuestasPorSede += gestionLoteria.obtenerNumeroApuestasLoteriaPorSede(sede);
		numeroApuestasPorSede += gestionSuperAstro.obtenerNumeroApuestasSuperAstroPorSede(sede);
		numeroApuestasPorSede += gestionBaloto.obtenerNumeroApuestasBalotoPorSede(sede);
		numeroApuestasPorSede += gestionBetPlay.obtenerNumeroApuestasBetPlayPorSede(sede);
		numeroApuestasPorSede += gestionChance.obtenerNumeroApuestasChancePorSede(sede);
		
		return numeroApuestasPorSede;
	}
	
	/**
	 * Obtener numeros chance.
	 *
	 * @return Un arreglo de enteros con los numeros de chance generados.
	 */
	public int[] obtenerNumerosChance() {
		return gestionChance.getApuestaChance().generarNumeros();
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
	 * Gets the gestor de sedes.
	 *
	 * @return the gestor de sedes
	 */
	public GestionSedes getGestorDeSedes() {
		return gestorDeSedes;
	}

	/**
	 * Sets the gestor de sedes.
	 *
	 * @param gestorDeSedes the new gestor de sedes
	 */
	public void setGestorDeSedes(GestionSedes gestorDeSedes) {
		this.gestorDeSedes = gestorDeSedes;
	}

	/**
	 * Gets the gestor de apostadores.
	 *
	 * @return the gestor de apostadores
	 */
	public GestionApostadores getGestorDeApostadores() {
		return gestorDeApostadores;
	}

	/**
	 * Sets the gestor de apostadores.
	 *
	 * @param gestorDeApostadores the new gestor de apostadores
	 */
	public void setGestorDeApostadores(GestionApostadores gestorDeApostadores) {
		this.gestorDeApostadores = gestorDeApostadores;
	}

	/**
	 * Gets the gestor de juegos.
	 *
	 * @return the gestor de juegos
	 */
	public GestionJuegos getGestorDeJuegos() {
		return gestorDeJuegos;
	}

	/**
	 * Sets the gestor de juegos.
	 *
	 * @param gestorDeJuegos the new gestor de juegos
	 */
	public void setGestorDeJuegos(GestionJuegos gestorDeJuegos) {
		this.gestorDeJuegos = gestorDeJuegos;
	}

	/**
	 * Gets the gestion loteria.
	 *
	 * @return the gestion loteria
	 */
	public GestionLoteria getGestionLoteria() {
		return gestionLoteria;
	}

	/**
	 * Sets the gestion loteria.
	 *
	 * @param gestionLoteria the new gestion loteria
	 */
	public void setGestionLoteria(GestionLoteria gestionLoteria) {
		this.gestionLoteria = gestionLoteria;
	}

	/**
	 * Gets the gestion super astro.
	 *
	 * @return the gestion super astro
	 */
	public GestionSuperAstro getGestionSuperAstro() {
		return gestionSuperAstro;
	}

	/**
	 * Sets the gestion super astro.
	 *
	 * @param gestionSuperAstro the new gestion super astro
	 */
	public void setGestionSuperAstro(GestionSuperAstro gestionSuperAstro) {
		this.gestionSuperAstro = gestionSuperAstro;
	}

	/**
	 * Gets the gestion baloto.
	 *
	 * @return the gestion baloto
	 */
	public GestionBaloto getGestionBaloto() {
		return gestionBaloto;
	}

	/**
	 * Sets the gestion baloto.
	 *
	 * @param gestionBaloto the new gestion baloto
	 */
	public void setGestionBaloto(GestionBaloto gestionBaloto) {
		this.gestionBaloto = gestionBaloto;
	}

	/**
	 * Gets the gestion bet play.
	 *
	 * @return the gestion bet play
	 */
	public GestionBetPlay getGestionBetPlay() {
		return gestionBetPlay;
	}

	/**
	 * Sets the gestion bet play.
	 *
	 * @param gestionBetPlay the new gestion bet play
	 */
	public void setGestionBetPlay(GestionBetPlay gestionBetPlay) {
		this.gestionBetPlay = gestionBetPlay;
	}

	/**
	 * Gets the gestion chance.
	 *
	 * @return the gestion chance
	 */
	public GestionChance getGestionChance() {
		return gestionChance;
	}

	/**
	 * Sets the gestion chance.
	 *
	 * @param gestionChance the new gestion chance
	 */
	public void setGestionChance(GestionChance gestionChance) {
		this.gestionChance = gestionChance;
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
