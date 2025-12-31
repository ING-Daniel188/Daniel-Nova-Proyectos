package co.edu.unbosque.model.persistence;

/**
 * The Class ApuestaDAO.
 */
public class ApuestaDAO {

	/** The gestor apuestas loteria. */
	private LoteriaDAO gestorApuestasLoteria;
	
	/** The gestor apuestas super astro. */
	private SuperAstroDAO gestorApuestasSuperAstro;
	
	/** The gestor apuestas baloto. */
	private BalotoDAO gestorApuestasBaloto;
	
	/** The gestor apuestas bet play. */
	private BetPlayDAO gestorApuestasBetPlay;
	
	/** The gestor apuestas chance. */
	private ChanceDAO gestorApuestasChance;

	/**
	 * Instantiates a new apuesta DAO.
	 */
	public ApuestaDAO() {
		gestorApuestasLoteria = new LoteriaDAO();
		gestorApuestasSuperAstro = new SuperAstroDAO();
		gestorApuestasBaloto = new BalotoDAO();
		gestorApuestasBetPlay = new BetPlayDAO();
		gestorApuestasChance = new ChanceDAO();
	}

	/**
	 * Agregar apuesta loteria.
	 *
	 * @param tipoDeApuesta Tipo de apuesta a agregar
	 * @param nombreSede Nombre de la sede en la cual se realiza la apuesta a agregar
	 * @param cedulaApostador Cedula del apostador que realiza la apuesta a agregar
	 * @param fecha Fecha en la cual se realiza la apuesta
	 * @param valor Monto total de la apuesta
	 * @param nombre Nombre de la loteria de la apuesta de loteria a agregar
	 * @param numeroLoteria Numero de la loteria de la apuesta de loteria a agregar
	 * @param serie Numero de la serie de la loteria a agregar
	 */
	public void agregarApuestaLoteria(String tipoDeApuesta, String nombreSede, String cedulaApostador, String fecha,
			double valor, String nombre, int numeroLoteria, int serie) {

		// Agregar la apuesta de lotería al ArrayList
		gestorApuestasLoteria.agregarApuestaLoteria(tipoDeApuesta, nombreSede, cedulaApostador, fecha, valor, nombre,
				numeroLoteria, serie);

		// Guardar la apuesta en el archivo apuestas-loteria.dat
		gestorApuestasLoteria.registrarApuestasLoteria();
	}

	/**
	 * Agregar apuesta super astro.
	 *
	 * @param nombreSede Nombre de la sede en la que se realiza la apuesta de superastro
	 * @param cedulaApostador Cedula del apostador que realiza la apuesta de superastro
	 * @param fecha Fecha en la cual se realiza la apuesta a agregar
	 * @param valor Monto total de la apuesta de superastro a agregar
	 * @param numerosSeleccionados Numeros seleccionados por el apostador de la apuesta de superastro a agregar
	 * @param signoDelZodiaco Signo del zodiaco escogido por el apostador de la apuesta de superastro a agregar
	 */
	public void agregarApuestaSuperAstro(String nombreSede, String cedulaApostador, String fecha, double valor,
			int[] numerosSeleccionados, String signoDelZodiaco) {

		// Agregar la apuesta de superAstro al ArrayList
		gestorApuestasSuperAstro.agregarApuestaSuperAstro(nombreSede, cedulaApostador, fecha, valor,
				numerosSeleccionados, signoDelZodiaco);

		// Guardar la apuesta en el archivo apuestas-superastro.dat
		gestorApuestasSuperAstro.registrarApuestasSuperAstro();

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

		// Agregar la apuesta de Baloto al ArrayList
		gestorApuestasBaloto.agregarApuestaBaloto(nombreSede, cedulaApostador, fecha, valor, numerosSeleccionados);

		// Guardar la apuesta en el archivo apuestas-baloto.dat
		gestorApuestasBaloto.registrarApuestasBaloto();

	}

	/**
	 * Agregar apuesta chance.
	 *
	 * @param nombreSede Nombre de la sede en la que se realiza la apuesta de chance a agregar
	 * @param cedulaApostador Cedula del apostador que realiza la apuesta de chance a agregar
	 * @param fecha Fecha de la apuesta de chance a agregar
	 * @param valor Monto total de la apuesta de chance a agregar
	 * @param nombre Nombre de la loteria de la apuesta de chance a agregar
	 * @param numerosSeleccionados Numeros seleccionados por el apostador de la apuesta de chance a agregar
	 */
	public void agregarApuestaChance(String nombreSede, String cedulaApostador, String fecha, double valor,
			String nombre, int[] numerosSeleccionados) {

		// Agregar la apuesta de Chance al ArrayList
		gestorApuestasChance.agregarApuestaChance(nombreSede, cedulaApostador, fecha, valor, nombre,
				numerosSeleccionados);

		// Guardar la apuesta en el archivo apuestas-chance.dat
		gestorApuestasChance.registrarApuestasChance();

	}

	/**
	 * Agregar apuesta bet play.
	 *
	 * @param nombreSede Nombre de la sede en la que se realiza la apuesta de betplay a agregar
	 * @param cedulaApostador Cedula del apostador que realiza la apuesta de betplay a agregar
	 * @param fecha Fecha de la apuesta de betplay a agregar
	 * @param valor Monto total de la apuesta de betplay a agregar
	 * @param partidosYResultadosEscogidos Partidos y resultados seleccionados por el apostador de la apuesta de betplay a agregar
	 */
	public void agregarApuestaBetPlay(String nombreSede, String cedulaApostador, String fecha, double valor,
			String[][] partidosYResultadosEscogidos) {

		// Agregar la apuesta de BetPlay al ArrayList
		gestorApuestasBetPlay.agregarApuestaBetPlay(nombreSede, cedulaApostador, fecha, valor,
				partidosYResultadosEscogidos);

		// Guardar la apuesta en el archivo apuestas-betplay.dat
		gestorApuestasBetPlay.registrarApuestasBetPlay();

	}

	/**
	 * Modificar apuesta loteria.
	 *
	 * @param indice Indice de la ubicacion del ArrayList de la apuesta de loteria a modificar
	 * @param tipoDeApuesta Tipo de apuesta que se realiza (Juegos de azar, deportiva, etc...) a modificar
	 * @param nombreSede Nombre de la sede en la que se realiza la apuesta de loteria a modificar
	 * @param cedulaApostador Cedula del apostador que realiza la apuesta de loteria a modificar
	 * @param fecha Fecha en la que se realiza la apuesta de loteria a modificar
	 * @param valor Monto total de la apuesta de loteria a modificar
	 * @param nombre Nombre de la loteria de la apuesta de loteria a modificar
	 * @param numeroLoteria Numero de loteria de la apuesta de loteria a modificar
	 * @param serie Numero de serie de la apuesta de loteria a modificar
	 */
	public void modificarApuestaLoteria(int indice, String tipoDeApuesta, String nombreSede, String cedulaApostador,
			String fecha, double valor, String nombre, int numeroLoteria, int serie) {
		gestorApuestasLoteria.modificarApuestaLoteria(indice, tipoDeApuesta, nombreSede, cedulaApostador, fecha, valor,
				nombre, numeroLoteria, serie);
	}

	/**
	 * Modificar apuesta super astro.
	 *
	 * @param indice Indice de la ubicacion del ArrayList de la apuesta de superastro a modificar
	 * @param nombreSede Nombre de la sede de la apuesta de superastro a modificar
	 * @param cedulaApostador Cedula del apostador que realizo la apuesta de superastro a modificar
	 * @param fecha Fecha en la que se realiza la apuesta de superastro a modificar
	 * @param valor Monto total de la apuesta de superastro a modificar
	 * @param numerosSeleccionados Numeros seleccionados por el apostador de la apuesta de superastro a modificar
	 * @param signoDelZodiaco Signo del zodiaco escogido por el apostador de la apuesta de superastro a modificar
	 */
	public void modificarApuestaSuperAstro(int indice, String nombreSede, String cedulaApostador, String fecha,
			double valor, int[] numerosSeleccionados, String signoDelZodiaco) {
		gestorApuestasSuperAstro.modificarApuestaSuperAstro(indice, nombreSede, cedulaApostador, fecha, valor,
				numerosSeleccionados, signoDelZodiaco);
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
	public void modificarApuestaBaloto(int indice, String nombreSede, String cedulaApostador, String fecha,
			double valor, int[] numerosSeleccionados) {
		gestorApuestasBaloto.modificarApuestaBaloto(indice, nombreSede, cedulaApostador, fecha, valor,
				numerosSeleccionados);
	}

	/**
	 * Modificar apuesta bet play.
	 *
	 * @param indice Indice de la ubicacion en el ArrayList de la apuesta de betplay a modificar
	 * @param nombreSede Nombre de la sede en la que se realiza la apuesta de betplay
	 * @param cedulaApostador Cedula del apostador que realizo la apuesta de betplay a modificar
	 * @param fecha Fecha en la cual se realiza la apuesta de betplay a modificar
	 * @param valor Monto total de la apuesta de betplay a modificar
	 * @param partidosYResultadosEscogidos Partidos y resultados escogidos por el apostador de la apuesta de betplay a modificar.
	 */
	public void modificarApuestaBetPlay(int indice, String nombreSede, String cedulaApostador, String fecha,
			double valor, String[][] partidosYResultadosEscogidos) {
		gestorApuestasBetPlay.modificarApuestaBetPlay(indice, nombreSede, cedulaApostador, fecha, valor,
				partidosYResultadosEscogidos);
	}

	/**
	 * Modificar apuesta chance.
	 *
	 * @param indice Indice de la posicion en el ArrayList de la apuesta de chance a modificar
	 * @param nombreSede Nombre de la sede en la que se realiza la apuesta de chance a modificar
	 * @param cedulaApostador Cedula del apostador que realizo la apuesta de chance a modificar
	 * @param fecha Fecha en la cual se realiza la apuesta de chance a modificar
	 * @param valor Monto total de la apuesta de chance a modificar
	 * @param nombre Nombre de la loteria de la apuesta de chance a modificar
	 * @param numerosSeleccionados Numeros seleccionados por el apostador de la apuesta de chance a modificar
	 */
	public void modificarApuestaChance(int indice, String nombreSede, String cedulaApostador, String fecha,
			double valor, String nombre, int[] numerosSeleccionados) {
		gestorApuestasChance.modificarApuestaChance(indice, nombreSede, cedulaApostador, fecha, valor, nombre,
				numerosSeleccionados);
	}

	/**
	 * Eliminar apuesta.
	 *
	 * @param tipoDeApuesta El tipo de la apuesta a eliminar (Loteria, SuperAstro, Baloto, Betplay o Chance)
	 * @param cedulaApostador Cedula del apostador que realizo la apuesta a eliminar
	 * @param fecha Fecha en la que se realizo la apuesta a eliminar
	 */
	public void eliminarApuesta(String tipoDeApuesta, String cedulaApostador, String fecha) {

		switch (tipoDeApuesta) {

		case "Loteria":
			int indiceApuestaLoteria = gestorApuestasLoteria.obtenerIndiceApuesta(cedulaApostador, fecha);
			gestorApuestasLoteria.eliminarApuestaLoteria(indiceApuestaLoteria);
			break;
		case "SuperAstro":
			int indiceApuestaSuperAstro = gestorApuestasSuperAstro.obtenerIndiceApuesta(cedulaApostador, fecha);
			gestorApuestasSuperAstro.eliminarApuestaSuperAstro(indiceApuestaSuperAstro);
			break;
		case "Baloto":
			int indiceApuestaBaloto = gestorApuestasBaloto.obtenerIndiceApuesta(cedulaApostador, fecha);
			gestorApuestasBaloto.eliminarApuestaBaloto(indiceApuestaBaloto);
			break;

		case "BetPlay":
			int indiceApuestaBetPlay = gestorApuestasBetPlay.obtenerIndiceApuesta(cedulaApostador, fecha);
			gestorApuestasBetPlay.eliminarApuestaBetPlay(indiceApuestaBetPlay);
			break;

		case "Chance":
			int indiceApuestaChance = gestorApuestasChance.obtenerIndiceApuesta(cedulaApostador, fecha);
			gestorApuestasChance.eliminarApuestaChance(indiceApuestaChance);
			break;

		}

	}

	/**
	 * Obtener apuesta loteria.
	 *
	 * @param indice Indice de la ubicacion en el ArrayList de la apuesta de loteria a obtener
	 * @return Objeto de loteria
	 */
	public Object[] obtenerApuestaLoteria(int indice) {

		// Objeto creado para obtener los datos de las filas de la tabla apuestas
		Object[] apuestaLoteria = { gestorApuestasLoteria.getApuestasLoteria().get(indice).getTipoDeApuesta(),
				gestorApuestasLoteria.getApuestasLoteria().get(indice).getNombreSede(),
				gestorApuestasLoteria.getApuestasLoteria().get(indice).getCedulaApostador(),
				gestorApuestasLoteria.getApuestasLoteria().get(indice).getFecha(),
				gestorApuestasLoteria.getApuestasLoteria().get(indice).getValor() };
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
		Object[] apuestaSuperAstro = { gestorApuestasSuperAstro.getApuestasSuperAstro().get(indice).getTipoDeApuesta(),
				gestorApuestasSuperAstro.getApuestasSuperAstro().get(indice).getNombreSede(),
				gestorApuestasSuperAstro.getApuestasSuperAstro().get(indice).getCedulaApostador(),
				gestorApuestasSuperAstro.getApuestasSuperAstro().get(indice).getFecha(),
				gestorApuestasSuperAstro.getApuestasSuperAstro().get(indice).getValor() };
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
		Object[] apuestaBaloto = { gestorApuestasBaloto.getApuestasBaloto().get(indice).getTipoDeApuesta(),
				gestorApuestasBaloto.getApuestasBaloto().get(indice).getNombreSede(),
				gestorApuestasBaloto.getApuestasBaloto().get(indice).getCedulaApostador(),
				gestorApuestasBaloto.getApuestasBaloto().get(indice).getFecha(),
				gestorApuestasBaloto.getApuestasBaloto().get(indice).getValor() };
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
		Object[] apuestaChance = { gestorApuestasChance.getApuestasChance().get(indice).getTipoDeApuesta(),
				gestorApuestasChance.getApuestasChance().get(indice).getNombreSede(),
				gestorApuestasChance.getApuestasChance().get(indice).getCedulaApostador(),
				gestorApuestasChance.getApuestasChance().get(indice).getFecha(),
				gestorApuestasChance.getApuestasChance().get(indice).getValor() };
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
		Object[] apuestaBetPlay = { gestorApuestasBetPlay.getApuestasBetPlay().get(indice).getTipoDeApuesta(),
				gestorApuestasBetPlay.getApuestasBetPlay().get(indice).getNombreSede(),
				gestorApuestasBetPlay.getApuestasBetPlay().get(indice).getCedulaApostador(),
				gestorApuestasBetPlay.getApuestasBetPlay().get(indice).getFecha(),
				gestorApuestasBetPlay.getApuestasBetPlay().get(indice).getValor() };
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
		int numeroApuestasLoteria = gestorApuestasLoteria.obtenerApuestasLoteriaPorCliente(cedula).size();
		int numeroApuestasSuperAstro = gestorApuestasSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).size();
		int numeroApuestasBaloto = gestorApuestasBaloto.obtenerApuestasBalotoPorCliente(cedula).size();
		int numeroApuestasBetPlay = gestorApuestasBetPlay.obtenerApuestasBetPlayPorCliente(cedula).size();
		int numeroApuestasChance = gestorApuestasChance.obtenerApuestasChancePorCliente(cedula).size();

		int numeroTotalApuestas = numeroApuestasLoteria + numeroApuestasSuperAstro + numeroApuestasBaloto
				+ numeroApuestasBetPlay + numeroApuestasChance;

		Object[][] apuestasPorCliente = new Object[numeroTotalApuestas][2];
		
		int indiceApuesta = 0;
		
		// Obtener apuestas de lotería
		for (int i = 0; i < numeroApuestasLoteria; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestorApuestasLoteria.obtenerApuestasLoteriaPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestorApuestasLoteria.obtenerApuestasLoteriaPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de superastro
		for (int i = 0; i < numeroApuestasSuperAstro; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestorApuestasSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestorApuestasSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de baloto
		for (int i = 0; i < numeroApuestasBaloto; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestorApuestasBaloto.obtenerApuestasBalotoPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestorApuestasBaloto.obtenerApuestasBalotoPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de betplay
		for (int i = 0; i < numeroApuestasBetPlay; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestorApuestasBetPlay.obtenerApuestasBetPlayPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestorApuestasBetPlay.obtenerApuestasBetPlayPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de chance
		for (int i = 0; i < numeroApuestasChance; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestorApuestasChance.obtenerApuestasChancePorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestorApuestasChance.obtenerApuestasChancePorCliente(cedula).get(i).getValor();
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
		int numeroApuestasLoteria = gestorApuestasLoteria.obtenerNumeroApuestasLoteriaPorSede(sede);
		int numeroApuestasSuperAstro = gestorApuestasSuperAstro.obtenerNumeroApuestasSuperAstroPorSede(sede);
		int numeroApuestasBaloto = gestorApuestasBaloto.obtenerNumeroApuestasBalotoPorSede(sede);
		int numeroApuestasBetPlay = gestorApuestasBetPlay.obtenerNumeroApuestasBetPlayPorSede(sede);
		int numeroApuestasChance = gestorApuestasChance.obtenerNumeroApuestasChancePorSede(sede);

		int numeroTotalApuestas = numeroApuestasLoteria + numeroApuestasSuperAstro + numeroApuestasBaloto
				+ numeroApuestasBetPlay + numeroApuestasChance;
		
		Object[][] apuestasPorSede = new Object[numeroTotalApuestas][5];
		
		
		int indiceApuesta = 0;
		
		// Obtener apuestas de lotería
		for (int i = 0; i < numeroApuestasLoteria; i++) {
			apuestasPorSede[indiceApuesta][0] = gestorApuestasLoteria.obtenerApuestasLoteriaPorSede(sede).get(i).getTipoDeApuesta();
			apuestasPorSede[indiceApuesta][1] = gestorApuestasLoteria.obtenerApuestasLoteriaPorSede(sede).get(i).getNombreSede();
			apuestasPorSede[indiceApuesta][2] = gestorApuestasLoteria.obtenerApuestasLoteriaPorSede(sede).get(i).getCedulaApostador();
			apuestasPorSede[indiceApuesta][3] = gestorApuestasLoteria.obtenerApuestasLoteriaPorSede(sede).get(i).getFecha();
			apuestasPorSede[indiceApuesta][4] = gestorApuestasLoteria.obtenerApuestasLoteriaPorSede(sede).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de superastro
		for (int i = 0; i < numeroApuestasSuperAstro; i++) {
			apuestasPorSede[indiceApuesta][0] = gestorApuestasSuperAstro.obtenerApuestasSuperAstroPorSede(sede).get(i).getTipoDeApuesta();
			apuestasPorSede[indiceApuesta][1] = gestorApuestasSuperAstro.obtenerApuestasSuperAstroPorSede(sede).get(i).getNombreSede();
			apuestasPorSede[indiceApuesta][2] = gestorApuestasSuperAstro.obtenerApuestasSuperAstroPorSede(sede).get(i).getCedulaApostador();
			apuestasPorSede[indiceApuesta][3] = gestorApuestasSuperAstro.obtenerApuestasSuperAstroPorSede(sede).get(i).getFecha();
			apuestasPorSede[indiceApuesta][4] = gestorApuestasSuperAstro.obtenerApuestasSuperAstroPorSede(sede).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de baloto
		for (int i = 0; i < numeroApuestasBaloto; i++) {
			apuestasPorSede[indiceApuesta][0] = gestorApuestasBaloto.obtenerApuestasBalotoPorSede(sede).get(i).getTipoDeApuesta();
			apuestasPorSede[indiceApuesta][1] = gestorApuestasBaloto.obtenerApuestasBalotoPorSede(sede).get(i).getNombreSede();
			apuestasPorSede[indiceApuesta][2] = gestorApuestasBaloto.obtenerApuestasBalotoPorSede(sede).get(i).getCedulaApostador();
			apuestasPorSede[indiceApuesta][3] = gestorApuestasBaloto.obtenerApuestasBalotoPorSede(sede).get(i).getFecha();
			apuestasPorSede[indiceApuesta][4] = gestorApuestasBaloto.obtenerApuestasBalotoPorSede(sede).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de betplay
		for (int i = 0; i < numeroApuestasBetPlay; i++) {
			apuestasPorSede[indiceApuesta][0] = gestorApuestasBetPlay.obtenerApuestasBetPlayPorSede(sede).get(i).getTipoDeApuesta();
			apuestasPorSede[indiceApuesta][1] = gestorApuestasBetPlay.obtenerApuestasBetPlayPorSede(sede).get(i).getNombreSede();
			apuestasPorSede[indiceApuesta][2] = gestorApuestasBetPlay.obtenerApuestasBetPlayPorSede(sede).get(i).getCedulaApostador();
			apuestasPorSede[indiceApuesta][3] = gestorApuestasBetPlay.obtenerApuestasBetPlayPorSede(sede).get(i).getFecha();
			apuestasPorSede[indiceApuesta][4] = gestorApuestasBetPlay.obtenerApuestasBetPlayPorSede(sede).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de chance
		for (int i = 0; i < numeroApuestasChance; i++) {
			apuestasPorSede[indiceApuesta][0] = gestorApuestasChance.obtenerApuestasChancePorSede(sede).get(i).getTipoDeApuesta();
			apuestasPorSede[indiceApuesta][1] = gestorApuestasChance.obtenerApuestasChancePorSede(sede).get(i).getNombreSede();
			apuestasPorSede[indiceApuesta][2] = gestorApuestasChance.obtenerApuestasChancePorSede(sede).get(i).getCedulaApostador();
			apuestasPorSede[indiceApuesta][3] = gestorApuestasChance.obtenerApuestasChancePorSede(sede).get(i).getFecha();
			apuestasPorSede[indiceApuesta][4] = gestorApuestasChance.obtenerApuestasChancePorSede(sede).get(i).getValor();
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
		int numeroApuestasLoteria = gestorApuestasLoteria.obtenerApuestasLoteriaPorCliente(cedula).size();
		int numeroApuestasSuperAstro = gestorApuestasSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).size();
		int numeroApuestasBaloto = gestorApuestasBaloto.obtenerApuestasBalotoPorCliente(cedula).size();
		int numeroApuestasBetPlay = gestorApuestasBetPlay.obtenerApuestasBetPlayPorCliente(cedula).size();
		int numeroApuestasChance = gestorApuestasChance.obtenerApuestasChancePorCliente(cedula).size();

		int numeroTotalApuestas = numeroApuestasLoteria + numeroApuestasSuperAstro + numeroApuestasBaloto
				+ numeroApuestasBetPlay + numeroApuestasChance;

		Object[][] apuestasPorCliente = new Object[numeroTotalApuestas][5];
		
		int indiceApuesta = 0;
		
		// Obtener apuestas de lotería
		for (int i = 0; i < numeroApuestasLoteria; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestorApuestasLoteria.obtenerApuestasLoteriaPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestorApuestasLoteria.obtenerApuestasLoteriaPorCliente(cedula).get(i).getNombreSede();
			apuestasPorCliente[indiceApuesta][2] = gestorApuestasLoteria.obtenerApuestasLoteriaPorCliente(cedula).get(i).getCedulaApostador();
			apuestasPorCliente[indiceApuesta][3] = gestorApuestasLoteria.obtenerApuestasLoteriaPorCliente(cedula).get(i).getFecha();
			apuestasPorCliente[indiceApuesta][4] = gestorApuestasLoteria.obtenerApuestasLoteriaPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de superastro
		for (int i = 0; i < numeroApuestasSuperAstro; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestorApuestasSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestorApuestasSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).get(i).getNombreSede();
			apuestasPorCliente[indiceApuesta][2] = gestorApuestasSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).get(i).getCedulaApostador();
			apuestasPorCliente[indiceApuesta][3] = gestorApuestasSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).get(i).getFecha();
			apuestasPorCliente[indiceApuesta][4] = gestorApuestasSuperAstro.obtenerApuestasSuperAstroPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de baloto
		for (int i = 0; i < numeroApuestasBaloto; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestorApuestasBaloto.obtenerApuestasBalotoPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestorApuestasBaloto.obtenerApuestasBalotoPorCliente(cedula).get(i).getNombreSede();
			apuestasPorCliente[indiceApuesta][2] = gestorApuestasBaloto.obtenerApuestasBalotoPorCliente(cedula).get(i).getCedulaApostador();
			apuestasPorCliente[indiceApuesta][3] = gestorApuestasBaloto.obtenerApuestasBalotoPorCliente(cedula).get(i).getFecha();
			apuestasPorCliente[indiceApuesta][4] = gestorApuestasBaloto.obtenerApuestasBalotoPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de betplay
		for (int i = 0; i < numeroApuestasBetPlay; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestorApuestasBetPlay.obtenerApuestasBetPlayPorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestorApuestasBetPlay.obtenerApuestasBetPlayPorCliente(cedula).get(i).getNombreSede();
			apuestasPorCliente[indiceApuesta][2] = gestorApuestasBetPlay.obtenerApuestasBetPlayPorCliente(cedula).get(i).getCedulaApostador();
			apuestasPorCliente[indiceApuesta][3] = gestorApuestasBetPlay.obtenerApuestasBetPlayPorCliente(cedula).get(i).getFecha();
			apuestasPorCliente[indiceApuesta][4] = gestorApuestasBetPlay.obtenerApuestasBetPlayPorCliente(cedula).get(i).getValor();
			indiceApuesta++;
		}
		
		// Obtener apuestas de chance
		for (int i = 0; i < numeroApuestasChance; i++) {
			apuestasPorCliente[indiceApuesta][0] = gestorApuestasChance.obtenerApuestasChancePorCliente(cedula).get(i).getTipoDeApuesta();
			apuestasPorCliente[indiceApuesta][1] = gestorApuestasChance.obtenerApuestasChancePorCliente(cedula).get(i).getNombreSede();
			apuestasPorCliente[indiceApuesta][2] = gestorApuestasChance.obtenerApuestasChancePorCliente(cedula).get(i).getCedulaApostador();
			apuestasPorCliente[indiceApuesta][3] = gestorApuestasChance.obtenerApuestasChancePorCliente(cedula).get(i).getFecha();
			apuestasPorCliente[indiceApuesta][4] = gestorApuestasChance.obtenerApuestasChancePorCliente(cedula).get(i).getValor();
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
		return gestorApuestasLoteria.getApuestasLoteria().size();
	}
	
	/**
	 * Obtener numero de apuestas super astro.
	 *
	 * @return Entero con el numero de apuestas de superastro
	 */
	public int obtenerNumeroDeApuestasSuperAstro() {
		return gestorApuestasSuperAstro.getApuestasSuperAstro().size();
	}
	
	/**
	 * Obtener numero de apuestas baloto.
	 *
	 * @return Entero con el numero de apuestas de baloto
	 */
	public int obtenerNumeroDeApuestasBaloto() {
		return gestorApuestasBaloto.getApuestasBaloto().size();
	}
	
	/**
	 * Obtener numero de apuestas bet play.
	 *
	 * @return Entero con el numero de apuestas de betplay
	 */
	public int obtenerNumeroDeApuestasBetPlay() {
		return gestorApuestasBetPlay.getApuestasBetPlay().size();
	}
	
	/**
	 * Obtener numero de apuestas chance.
	 *
	 * @return Entero con el numero de apuestas de chance
	 */
	public int obtenerNumeroDeApuestasChance() {
		return gestorApuestasChance.getApuestasChance().size();
	}
	
	/**
	 * Obtener numero de apuestas por sede.
	 *
	 * @param sede Sede en la que se realizaron las apuestas
	 * @return Numero de apuestas sorteadas por la sede proveida
	 */
	public int obtenerNumeroDeApuestasPorSede(String sede) {
		int numeroApuestasPorSede = 0;
		
		numeroApuestasPorSede += gestorApuestasLoteria.obtenerNumeroApuestasLoteriaPorSede(sede);
		numeroApuestasPorSede += gestorApuestasSuperAstro.obtenerNumeroApuestasSuperAstroPorSede(sede);
		numeroApuestasPorSede += gestorApuestasBaloto.obtenerNumeroApuestasBalotoPorSede(sede);
		numeroApuestasPorSede += gestorApuestasBetPlay.obtenerNumeroApuestasBetPlayPorSede(sede);
		numeroApuestasPorSede += gestorApuestasChance.obtenerNumeroApuestasChancePorSede(sede);
		
		return numeroApuestasPorSede;
	}
	

	/**
	 * Gets the gestor apuestas bet play.
	 *
	 * @return the gestor apuestas bet play
	 */
	public BetPlayDAO getGestorApuestasBetPlay() {
		return gestorApuestasBetPlay;
	}

	/**
	 * Sets the gestor apuestas bet play.
	 *
	 * @param gestorApuestasBetPlay the new gestor apuestas bet play
	 */
	public void setGestorApuestasBetPlay(BetPlayDAO gestorApuestasBetPlay) {
		this.gestorApuestasBetPlay = gestorApuestasBetPlay;
	}

	/**
	 * Gets the gestor apuestas loteria.
	 *
	 * @return the gestor apuestas loteria
	 */
	public LoteriaDAO getGestorApuestasLoteria() {
		return gestorApuestasLoteria;
	}

	/**
	 * Sets the gestor apuestas loteria.
	 *
	 * @param gestorApuestasLoteria the new gestor apuestas loteria
	 */
	public void setGestorApuestasLoteria(LoteriaDAO gestorApuestasLoteria) {
		this.gestorApuestasLoteria = gestorApuestasLoteria;
	}

	/**
	 * Gets the gestor apuestas super astro.
	 *
	 * @return the gestor apuestas super astro
	 */
	public SuperAstroDAO getGestorApuestasSuperAstro() {
		return gestorApuestasSuperAstro;
	}

	/**
	 * Sets the gestor apuestas super astro.
	 *
	 * @param gestorApuestasSuperAstro the new gestor apuestas super astro
	 */
	public void setGestorApuestasSuperAstro(SuperAstroDAO gestorApuestasSuperAstro) {
		this.gestorApuestasSuperAstro = gestorApuestasSuperAstro;
	}

	/**
	 * Gets the gestor apuestas baloto.
	 *
	 * @return the gestor apuestas baloto
	 */
	public BalotoDAO getGestorApuestasBaloto() {
		return gestorApuestasBaloto;
	}

	/**
	 * Sets the gestor apuestas baloto.
	 *
	 * @param gestorApuestasBaloto the new gestor apuestas baloto
	 */
	public void setGestorApuestasBaloto(BalotoDAO gestorApuestasBaloto) {
		this.gestorApuestasBaloto = gestorApuestasBaloto;
	}

	/**
	 * Gets the gestor apuestas chance.
	 *
	 * @return the gestor apuestas chance
	 */
	public ChanceDAO getGestorApuestasChance() {
		return gestorApuestasChance;
	}

	/**
	 * Sets the gestor apuestas chance.
	 *
	 * @param gestorApuestasChance the new gestor apuestas chance
	 */
	public void setGestorApuestasChance(ChanceDAO gestorApuestasChance) {
		this.gestorApuestasChance = gestorApuestasChance;
	}

}
