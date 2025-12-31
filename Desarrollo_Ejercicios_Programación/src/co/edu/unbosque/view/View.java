package co.edu.unbosque.view;

import java.awt.CardLayout;
import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import co.edu.unbosque.controller.Controller;

/**
 * The Class View.
 */
public class View extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  Lienzo principal que se utilizara para mostrar cada uno de los paneles. */
	private CardLayout cardLayout;
	
	/** The panel menu principal. */
	// Paneles que seran mostrados a traves del lienzo
	private PanelMenuPrincipal panelMenuPrincipal;
	
	/** The panel parametrizacion casa de apuestas. */
	private PanelParametrizacionCasaDeApuestas panelParametrizacionCasaDeApuestas;
	
	/** The panel gestion sedes. */
	private PanelGestionSedes panelGestionSedes;
	
	/** The panel gestion apostadores. */
	private PanelGestionApostadores panelGestionApostadores;
	
	/** The panel creacion apostador. */
	private PanelCreacionApostador panelCreacionApostador;
	
	/** The panel modificacion apostador. */
	private PanelModificacionApostador panelModificacionApostador;
	
	/** The panel gestion apuestas. */
	private PanelGestionApuestas panelGestionApuestas;
	
	/** The panel creacion apuesta. */
	private PanelCreacionApuesta panelCreacionApuesta;
	
	/** The panel modificacion apuesta. */
	private PanelModificacionApuesta panelModificacionApuesta;
	
	/** The panel factura apuesta. */
	private PanelFacturaApuesta panelFacturaApuesta;
	
	/** The panel realizacion consultas. */
	private PanelRealizacionConsultas panelRealizacionConsultas;
	
	/** The iconos. */
	private HashMap<String, Image> iconos;

	/**
	 * Instantiates a new view.
	 *
	 * @param controlador El controlador para agregar comandos y escuchadores de acciones
	 */
	public View(Controller controlador) {
		
		iconos = new HashMap<String, Image>();
		iconos.put("logo", new ImageIcon("Recursos/Imagenes/logo.png").getImage());
		iconos.put("sedes", new ImageIcon("Recursos/Imagenes/sedes.png").getImage());
		iconos.put("apuestas", new ImageIcon("Recursos/Imagenes/apuestas.png").getImage());
		iconos.put("casaDeApuestas", new ImageIcon("Recursos/Imagenes/casaDeApuestas.png").getImage());
		iconos.put("apostadores", new ImageIcon("Recursos/Imagenes/apostadores.png").getImage());
		iconos.put("consultas", new ImageIcon("Recursos/Imagenes/consultas.png").getImage());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 700);
		setLocationRelativeTo(null);
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		setTitle("Casa de Apuestas");
		setIconImage(iconos.get("logo"));
		
		///////////////////////////////////////// PANEL MENÚ PRINCIPAL /////////////////////////////////////////
		
		panelMenuPrincipal = new PanelMenuPrincipal();
		add(panelMenuPrincipal, "panelMenuPrincipal");
		
		// Agregar escuchadores de eventos panel menú principal
		panelMenuPrincipal.getBtnGestionarSedes().addActionListener(controlador);
		panelMenuPrincipal.getBtnGestionarSedes().addMouseListener(controlador);
		
		panelMenuPrincipal.getBtnGestionarApuestas().addActionListener(controlador);
		panelMenuPrincipal.getBtnGestionarApuestas().addMouseListener(controlador);
		
		panelMenuPrincipal.getBtnGestionarCasasDeApuestas().addActionListener(controlador);
		panelMenuPrincipal.getBtnGestionarCasasDeApuestas().addMouseListener(controlador);
		
		panelMenuPrincipal.getBtnGestionarApostadores().addActionListener(controlador);
		panelMenuPrincipal.getBtnGestionarApostadores().addMouseListener(controlador);
		
		panelMenuPrincipal.getBtnRealizarConsultas().addActionListener(controlador);
		panelMenuPrincipal.getBtnRealizarConsultas().addMouseListener(controlador);
		
		
		///////////////////////////////////////// PANEL PARAMETRIZACIÓN CASA DE APUESTAS /////////////////////////////////////////
		
		panelParametrizacionCasaDeApuestas = new PanelParametrizacionCasaDeApuestas();
		add(panelParametrizacionCasaDeApuestas, "panelParametrizacionCasaDeApuestas");
		
		// Agregar escuchadores de eventos panel parametrización casa de apuestas
		panelParametrizacionCasaDeApuestas.getBtnVolverAlMenuPrincipal().addActionListener(controlador);
		panelParametrizacionCasaDeApuestas.getBtnCargarParametros().addActionListener(controlador);
		panelParametrizacionCasaDeApuestas.getBtnGuardarParametros().addActionListener(controlador);
		
		
		///////////////////////////////////////// PANEL GESTIÓN SEDES /////////////////////////////////////////
		
		panelGestionSedes = new PanelGestionSedes();
		add(panelGestionSedes, "panelGestionSedes");
		
		// Agregar escuchadores de eventos panel gestión sedes
		panelGestionSedes.getSeleccionLocalidad().addActionListener(controlador);
		panelGestionSedes.getBtnVolverAlMenuPrincipal().addActionListener(controlador);
		panelGestionSedes.getBtnCrearSede().addActionListener(controlador);
		panelGestionSedes.getBtnModificarSede().addActionListener(controlador);
		panelGestionSedes.getBtnEliminarSede().addActionListener(controlador);
		panelGestionSedes.getSeleccionLocalidadAModificar().addActionListener(controlador);
		panelGestionSedes.getTablaSedes().addMouseListener(controlador);
		panelGestionSedes.getSeleccionLocalidadAModificar().addActionListener(controlador);
		
		
		///////////////////////////////////////// PANELES GESTIÓN APOSTADORES /////////////////////////////////////////
		
		panelGestionApostadores = new PanelGestionApostadores();
		add(panelGestionApostadores, "panelGestionApostadores");
		
		// Agregar escuchadores de eventos panel gestión apostadores
		panelGestionApostadores.getBtnVolverAlMenuPrincipal().addActionListener(controlador);
		panelGestionApostadores.getBtnModificarApostador().addActionListener(controlador);
		panelGestionApostadores.getBtnEliminarApostador().addActionListener(controlador);
		panelGestionApostadores.getBtnCrearApostador().addActionListener(controlador);
		panelGestionApostadores.getTablaApostadores().addMouseListener(controlador);
		
		
		panelCreacionApostador = new PanelCreacionApostador();
		add(panelCreacionApostador, "panelCreacionApostador");
		
		// Agregar escuchadores de eventos panel creación apostador
		panelCreacionApostador.getBtnVolverAGestionApostadores().addActionListener(controlador);
		panelCreacionApostador.getBtnCrearApostador().addActionListener(controlador);
		
		
		panelModificacionApostador = new PanelModificacionApostador();
		add(panelModificacionApostador, "panelModificacionApostador");
		
		// Agregar escuchadores de eventos panel modificación apostador
		panelModificacionApostador.getBtnVolverAGestionApostadores().addActionListener(controlador);
		panelModificacionApostador.getBtnModificarApostador().addActionListener(controlador);
		
		
		///////////////////////////////////////// PANELES GESTIÓN APUESTAS /////////////////////////////////////////
		
		panelGestionApuestas = new PanelGestionApuestas();
		add(panelGestionApuestas, "panelGestionApuestas");
		
		// Agregar escuchadores de eventos panel gestión apuestas
		panelGestionApuestas.getBtnVolverAlMenuPrincipal().addActionListener(controlador);
		panelGestionApuestas.getBtnModificarApuesta().addActionListener(controlador);
		panelGestionApuestas.getBtnEliminarApuesta().addActionListener(controlador);
		panelGestionApuestas.getBtnCrearApuesta().addActionListener(controlador);
		
		
		panelCreacionApuesta = new PanelCreacionApuesta();
		add(panelCreacionApuesta, "panelCreacionApuesta");
		
		// Agregar escuchadores de eventos panel creación apuesta
		panelCreacionApuesta.getSeleccionTipoDeApuesta().addActionListener(controlador);
		panelCreacionApuesta.getBtnVolverAlMenuPrincipal().addActionListener(controlador);
		panelCreacionApuesta.getBtnVolverAGestionApuestas().addActionListener(controlador);
		panelCreacionApuesta.getBtnRealizarApuesta().addActionListener(controlador);
		
		// Agregar escuchadores de eventos panel creación apuesta de lotería
		panelCreacionApuesta.getPanelApuestaLoteria().getSeleccionSerie().addActionListener(controlador);
		
		
		panelModificacionApuesta = new PanelModificacionApuesta();
		add(panelModificacionApuesta, "panelModificacionApuesta");
		
		// Agregar escuchadores de eventos panel modificación apuesta
		panelModificacionApuesta.getBtnVolverAlMenuPrincipal().addActionListener(controlador);
		panelModificacionApuesta.getBtnVolverAGestionApuestas().addActionListener(controlador);
		panelModificacionApuesta.getBtnModificarApuesta().addActionListener(controlador);
		
		
		panelFacturaApuesta = new PanelFacturaApuesta();
		add(panelFacturaApuesta, "panelFacturaApuesta");
		
		
		///////////////////////////////////////// PANELES GESTIÓN APUESTAS -> PANEL APUESTA CHANCE /////////////////////////////////////////
		panelCreacionApuesta.getPanelApuestaChance().getChanceManual().addActionListener(controlador);
		panelCreacionApuesta.getPanelApuestaChance().getChanceAutomatico().addActionListener(controlador);
		
		
		///////////////////////////////////////// PANELES GESTIÓN APUESTAS -> PANEL APUESTA BETPLAY /////////////////////////////////////////
		panelCreacionApuesta.getPanelApuestaBetPlay().getTablaApuestasPartidos().addMouseListener(controlador);
		
		
		///////////////////////////////////////// PANEL REALIZACIÓN CONSULTAS /////////////////////////////////////////
		
		panelRealizacionConsultas = new PanelRealizacionConsultas();
		add(panelRealizacionConsultas, "panelRealizacionConsultas");
		
		// Agregar escuchadores de eventos panel consultas
		panelRealizacionConsultas.getBtnVolverAlMenuPrincipal().addActionListener(controlador);
		panelRealizacionConsultas.getBtnMostrarClientesPorSede().addActionListener(controlador);
		panelRealizacionConsultas.getBtnMostrarValorTotalApuestas().addActionListener(controlador);
		panelRealizacionConsultas.getBtnMostrarApuestasRealizadas().addActionListener(controlador);
		panelRealizacionConsultas.getBtnMostrarTotalDeApuestas().addActionListener(controlador);
		
		///////////////////////////////////////// PANEL REALIZACIÓN CONSULTAS -> CLIENTES POR SEDE /////////////////////////////////////////
		panelRealizacionConsultas.getPanelClientesPorSede().getSeleccionSede().addActionListener(controlador);
		
		///////////////////////////////////////// PANEL REALIZACIÓN CONSULTAS -> VALOR TOTAL APUESTAS /////////////////////////////////////////
		panelRealizacionConsultas.getPanelValorTotalApuestas().getBtnConsultar().addActionListener(controlador);
		
		///////////////////////////////////////// PANEL REALIZACIÓN CONSULTAS -> TOTAL APUESTAS /////////////////////////////////////////
		panelRealizacionConsultas.getPanelTotalApuestas().getSeleccionSede().addActionListener(controlador);
		panelRealizacionConsultas.getPanelTotalApuestas().getSeleccionTipoDeJuego().addActionListener(controlador);
		
		///////////////////////////////////////// PANEL REALIZACIÓN CONSULTAS -> TOTAL APUESTAS /////////////////////////////////////////
		panelRealizacionConsultas.getPanelDetalleApuestasRealizadas().getSeleccionSede().addActionListener(controlador);
		panelRealizacionConsultas.getPanelDetalleApuestasRealizadas().getBtnConsultar().addActionListener(controlador);
		
		
		///////////////////////////////////////// PANEL FACTURA APUESTA /////////////////////////////////////////
		
		panelFacturaApuesta.getBtnCerrarYGuardar().addActionListener(e -> {
			// Redirigir al usuario al panel Gestión Apuestas
			mostrarPanelGestionApuestas();
			mostrarMensaje("La apuesta ha sido agregada", "Apuesta agregada");
		});
		
	}
	
	/**
	 * Mostrar panel menu principal.
	 */
	public void mostrarPanelMenuPrincipal() {
		getCardLayout().show(getContentPane(), "panelMenuPrincipal");
		setTitle("Casa de Apuestas");
		setIconImage(getIconos().get("logo"));
	}
	
	/**
	 * Mostrar panel parametrizacion casa de apuestas.
	 */
	public void mostrarPanelParametrizacionCasaDeApuestas() {
		getCardLayout().show(getContentPane(), "panelParametrizacionCasaDeApuestas");
		setTitle("Casa de Apuestas | Parametrización");
		setIconImage(getIconos().get("casaDeApuestas"));
	}
	
	/**
	 * Mostrar panel gestion sedes.
	 */
	public void mostrarPanelGestionSedes() {
		getCardLayout().show(getContentPane(), "panelGestionSedes");
		setTitle("Casa de Apuestas | Gestión Sedes");
		setIconImage(getIconos().get("sedes"));
	}
	
	/**
	 * Mostrar panel gestion apostadores.
	 */
	public void mostrarPanelGestionApostadores() {
		getCardLayout().show(getContentPane(), "panelGestionApostadores");
		setTitle("Casa de Apuestas | Gestión Apostadores");
		setIconImage(getIconos().get("apostadores"));
	}
	
	/**
	 * Mostrar panel creacion apostador.
	 */
	public void mostrarPanelCreacionApostador() {
		getCardLayout().show(getContentPane(), "panelCreacionApostador");
		setTitle("Casa de Apuestas | Creación Apostador");
		setIconImage(getIconos().get("apostadores"));
	}
	
	/**
	 * Mostrar panel modificacion apostador.
	 */
	public void mostrarPanelModificacionApostador() {
		getCardLayout().show(getContentPane(), "panelModificacionApostador");
		setTitle("Casa de Apuestas | Modificación Apostador");
		setIconImage(getIconos().get("apostadores"));
	}
	
	/**
	 * Mostrar panel gestion apuestas.
	 */
	public void mostrarPanelGestionApuestas() {
		getCardLayout().show(getContentPane(), "panelGestionApuestas");
		setTitle("Casa de Apuestas | Gestión Apuestas");
		setIconImage(getIconos().get("apuestas"));
	}
	
	/**
	 * Mostrar panel creacion apuesta.
	 */
	public void mostrarPanelCreacionApuesta() {
		getCardLayout().show(getContentPane(), "panelCreacionApuesta");
		setTitle("Casa de Apuestas | Creación Apuesta");
		setIconImage(getIconos().get("apuestas"));
	}
	
	/**
	 * Mostrar panel modificacion apuesta.
	 */
	public void mostrarPanelModificacionApuesta() {
		getCardLayout().show(getContentPane(), "panelModificacionApuesta");
		setTitle("Casa de Apuestas | Modificación Apuesta");
		setIconImage(getIconos().get("apuestas"));
	}
	
	/**
	 * Mostrar panel factura apuestas.
	 */
	public void mostrarPanelFacturaApuestas() {
		getCardLayout().show(getContentPane(), "panelFacturaApuesta");
		setTitle("Casa de Apuestas | Facturación Apuesta");
		setIconImage(getIconos().get("apuestas"));
	}
	
	/**
	 * Mostrar panel realizacion consultas.
	 */
	public void mostrarPanelRealizacionConsultas() {
		getCardLayout().show(getContentPane(), "panelRealizacionConsultas");
		setTitle("Casa de Apuestas | Consultas");
		setIconImage(getIconos().get("consultas"));
	}
	
	
	///////////////////////////////////////// PARAMETRIZACIÓN CASA DE APUESTAS /////////////////////////////////////////
	
	/**
	 * Cargar parametros casa de apuestas.
	 *
	 * @param nombreCasaDeApuestas El nombre de la Casa de Apuestas
	 * @param numeroDeSedes El numero de sedes de la Casa de Apuestas
	 * @param presupuestoTotalDisponible El presupuesto total disponible para la Casa de Apuestas
	 */
	public void cargarParametrosCasaDeApuestas(String nombreCasaDeApuestas, int numeroDeSedes, double presupuestoTotalDisponible) {
		
		boolean cargarParametros = false;
		
		// Revisar si la casa de apuestas ya ha sido parametrizada
		if (!nombreCasaDeApuestas.isEmpty()) {
			
			try {
				// Obtener los campos del panel parametrización casa de apuestas
				String campoNombreCasaDeApuestas = panelParametrizacionCasaDeApuestas.getCampoNombreCasaDeApuestas().getText();
				int campoNumeroDeSedes = Integer.parseInt(panelParametrizacionCasaDeApuestas.getCampoNumeroDeSedes().getText());
				double campoPresupuestoTotalDisponible = Double.parseDouble(panelParametrizacionCasaDeApuestas.getCampoPresupuestoTotal().getText());
				
				// Revisar si los parámetros ya han sido agregados y si todos son idénticos a los actuales
				if (!nombreCasaDeApuestas.equals(campoNombreCasaDeApuestas) 
						|| numeroDeSedes != campoNumeroDeSedes 
						|| presupuestoTotalDisponible != campoPresupuestoTotalDisponible) {
					cargarParametros = true;
				} else {
					mostrarMensaje("Los parámetros de la casa de apuestas ya han sido cargados", "Parámetros ya cargados");
				}
			} catch (NumberFormatException e) { cargarParametros = true; }
			
		} else {
			mostrarMensaje("La casa de apuestas aún no ha sido parametrizada", "Casa de Apuestas no parametrizada");
		}
		
		if (cargarParametros) {
			// Desplegar los parámetros actuales de la casa de apuestas en los campos del panel parametrización casa de apuestas
			panelParametrizacionCasaDeApuestas.getCampoNombreCasaDeApuestas().setText(nombreCasaDeApuestas);
			panelParametrizacionCasaDeApuestas.getCampoNumeroDeSedes().setText(numeroDeSedes + "");
			panelParametrizacionCasaDeApuestas.getCampoPresupuestoTotal().setText(presupuestoTotalDisponible + "");
		}

	}
	
	/**
	 * Obtener nombre casa de apuesta.
	 *
	 * @return El nombre de la casa de apuestas digitado
	 */
	public String obtenerNombreCasaDeApuesta() {
		String nombreCasaDeApuestas = panelParametrizacionCasaDeApuestas.getCampoNombreCasaDeApuestas().getText();
		
		// Revisar que se haya ingresado el nombre de la casa de apuestas
		if (nombreCasaDeApuestas.isEmpty()) {
			mostrarMensaje("El Nombre de la Casa de Apuestas no ha sido ingresado", "Dato no ingresado");
		}
		
		return nombreCasaDeApuestas;
	}
	
	/**
	 * Obtener numero de sedes.
	 *
	 * @return El numero de sedes de la casa de apuestas ingresado
	 */
	public int obtenerNumeroDeSedes() {
		String campoNumeroDeSedes = panelParametrizacionCasaDeApuestas.getCampoNumeroDeSedes().getText();

		// Revisar que se haya ingresado el número de sedes de la casa de apuestas
		if (campoNumeroDeSedes.isEmpty()) {
			mostrarMensaje("El Número de Sedes no ha sido ingresado", "Dato no ingresado");
			return -1;
		}

		int numeroDeSedes = 0;

		// Manejar excepción al convertir el número de sedes ingresado a entero
		try {
			numeroDeSedes = Integer.parseInt(campoNumeroDeSedes);
		} catch (NumberFormatException e) {
			mostrarMensaje("El Número de Sedes es inválido", "Dato inválido");
			return -1;
		}
		return numeroDeSedes;
	}
	
	/**
	 * Obtener presupuesto total disponible.
	 *
	 * @return El presupuesto total disponible para la Casa de Apuestas. Retorna -1 si el dato no ha sido ingresado o es invalido.
	 */
	public double obtenerPresupuestoTotalDisponible() {
		String campoPresupuestoTotalDisponible = panelParametrizacionCasaDeApuestas.getCampoPresupuestoTotal().getText();

		// Revisar que se haya ingresado el presupuesto total disponible de la casa de apuestas
		if (campoPresupuestoTotalDisponible.isEmpty()) {
			mostrarMensaje("El Presupuesto Total Disponible no ha sido ingresado", "Dato no ingresado");
			return -1;
		}

		double presupuestoTotalDisponible = 0;

		// Manejar excepción al convertir el presupuesto total disponible ingresado a decimal
		try {
			presupuestoTotalDisponible = Double.parseDouble(campoPresupuestoTotalDisponible);
		} catch (NumberFormatException e) {
			mostrarMensaje("El Presupuesto Total Disponible es inválido", "Dato inválido");
			return -1;
		}
		return presupuestoTotalDisponible;
	}
	
	
	///////////////////////////////////////// CREAR SEDE  /////////////////////////////////////////
	
	/**
	 * Obtener ubicacion sede.
	 *
	 * @return La ubicacion de la sede seleccionada. Devuelve una cadena vacía si la ubicacion no ha sido seleccionada.
	 */
	public String obtenerUbicacionSede() {
		/* Verificar que se haya seleccionado la ubicacion de la sede a crear del desplegable de opciones (JComboBox) 
		 * Si el indice seleccionado es cero quiere decir que la opción del JComboBox es la primera ("Seleccionar Ubicación:") */
		if (panelGestionSedes.getSeleccionLocalidad().getSelectedIndex() == 0) {
			mostrarMensaje("La ubicación de la sede a crear no ha sido seleccionada", "Ubicación no seleccionada");
			return "";
		}
		
		String ubicacionSede = panelGestionSedes.getSeleccionLocalidad().getSelectedItem().toString();
		
		return ubicacionSede;
	}
	
	/**
	 * Obtener numero de empleados.
	 *
	 * @return El numero de empleados de la sede. Devuelve -1 si el numero no ha sido ingresado o es invalido.
	 */
	public int obtenerNumeroDeEmpleados() {
		String campoNumeroDeEmpleados = panelGestionSedes.getCampoNumeroDeEmpleados().getText();
		
		// Revisar que se haya ingresado el número de empleados de la sede a crear
		if (campoNumeroDeEmpleados.isEmpty()) {
			mostrarMensaje("El número de empleados no ha sido ingresado", "Dato no ingresado");
			return -1;
		}
		
		int numeroDeEmpleados = 0;
		
		// Manejar excepción al convertir el número de empleados ingresado a entero
		try {
			numeroDeEmpleados = Integer.parseInt(panelGestionSedes.getCampoNumeroDeEmpleados().getText());
		} catch (NumberFormatException e) {
			mostrarMensaje("El número de empleados es inválido", "Dato inválido");
			return -1;
		}
		
		// Validar que el número de empleados de la sede a modificar no sea negativo
		if (numeroDeEmpleados < 0) {
			mostrarMensaje("El número de empleados no puede ser negativo", "Dato inválido");
			return -1;
		}
		
		return numeroDeEmpleados;
	}
	
	/**
	 * Obtener fila seleccionada tabla sedes.
	 *
	 * @return El numero de fila seleccionada en la tabla. Devuelve -1 si no se ha seleccionado ninguna fila.
	 */
	public int obtenerFilaSeleccionadaTablaSedes() {
		// Verificar que el usuario haya seleccionado una fila de la tabla para eliminar una sede
		int filaSeleccionada = panelGestionSedes.getTablaSedes().getSelectedRow();
		if (filaSeleccionada == -1) {
			mostrarMensaje("Seleccione una fila con la sede a eliminar", "Seleccionar Fila");
		}
		return filaSeleccionada;
	}
	
	/**
	 * Reiniciar campos sede A modificar panel gestion sedes.
	 */
	public void reiniciarCamposSedeAModificarPanelGestionSedes() {
		// Reiniciar y desabilitar los campos de la sede a modificar o eliminar
		panelGestionSedes.getSeleccionLocalidadAModificar().setSelectedItem(panelGestionSedes.getSeleccionLocalidadAModificar().getItemAt(0));
		panelGestionSedes.getCampoNumeroDeEmpleadosAModificar().setText("");
		panelGestionSedes.getSeleccionLocalidadAModificar().setEnabled(false);
		panelGestionSedes.getCampoNumeroDeEmpleadosAModificar().setEditable(false);
	}
	
	///////////////////////////////////////// MODIFICAR SEDE  /////////////////////////////////////////
	
	/**
	 * Obtener fila seleccionada.
	 *
	 * @return El numero de fila seleccionada en la tabla. Devuelve -1 si no se ha seleccionado ninguna fila.
	 */
	public int obtenerFilaSeleccionada() {
		// Verificar que el usuario haya seleccionado una fila de la tabla para modificar una sede
		int filaSeleccionada = panelGestionSedes.getTablaSedes().getSelectedRow();
		if (filaSeleccionada == -1) {
			mostrarMensaje("Seleccione una fila con la sede a modificar", "Seleccionar Fila");
		}
		return filaSeleccionada;
	}
	
	/**
	 * Obtener ubicacion A modificar.
	 *
	 * @return La ubicacion seleccionada para actualizar en la sede a modificar.
	 * 		   Devuelve una cadena vacia si no se ha seleccionado ninguna ubicacion 
	 * 		   o si no se ha seleccionado ninguna fila en la tabla de sedes.
	 */
	public String obtenerUbicacionAModificar() {
		
		// Revisar que una fila de la tabla con la sede a modificar haya sido seleccionada
		int filaSeleccionada = panelGestionSedes.getTablaSedes().getSelectedRow();
		if (filaSeleccionada != -1) {
			
			/* Verificar que se haya seleccionado la misma o nueva ubicacion de la sede a modificar del desplegable de opciones (JComboBox) 
			 * Si el indice seleccionado es cero quiere decir que la opción del JComboBox es la primera ("Seleccionar Ubicación:") */
			if (panelGestionSedes.getSeleccionLocalidadAModificar().getSelectedIndex() == 0) {
				mostrarMensaje("La nueva ubicación de la sede a modificar no ha sido seleccionada", "Ubicación no seleccionada");
				return "";
			}
			
			String ubicacionAActualizar = panelGestionSedes.getSeleccionLocalidadAModificar().getSelectedItem().toString();
			return ubicacionAActualizar;
		}
		return "";
	}
	
	///////////////////////////////////////// ELIMINAR SEDE  /////////////////////////////////////////
	
	/**
	 * Obtener indice sede A eliminar.
	 *
	 * @return El indice de la sede a eliminar.
	 * 		   Devuelve -1 si no se ha seleccionado ninguna fila en la tabla con la sede a eliminar 
	 * 		   o si el usuario no confirma la eliminacion.
	 */
	public int obtenerIndiceSedeAEliminar() {
		
		// Validar que se haya seleccionado una fila de la tabla con el número de empleados a modificar
		int filaSeleccionada = panelGestionSedes.getTablaSedes().getSelectedRow();
		if (filaSeleccionada == -1) {
			mostrarMensaje("Seleccione una Fila con la sede a eliminar", "Seleccionar fila");
			return -1;
		}
		
		// Obtener el índice de la sede a eliminar, el cual coincide con la posición del ArrayList en el cual dicha sede está almacenada
		int indiceSedeAEliminar = -1;
		
		// Confirmar con el usuario la eliminación de la sede seleccionada
		if (confirmarDato("Está seguro de que desea eliminar la sede seleccionada?", "Confirmación eliminación sede")) {		
			indiceSedeAEliminar = panelGestionSedes.getTablaSedes().getSelectedRow();
		}
		return indiceSedeAEliminar;
	}
	
	/**
	 * Obtener numero de empleados A modificar.
	 *
	 * @return El numero de empleados a modificar. 
	 * 		   Devuelve -1 en caso de no haber seleccionado una fila en la tabla, 
	 * 		   si la ubicacion de la sede a modificar no se ha seleccionado correctamente,
	 * 		   si el numero de empleados ingresado a modificar es invalido o negativo, 
	 *         o si la sede a modificar no ha sido alterada.
	 */
	public int obtenerNumeroDeEmpleadosAModificar() {
		
		// Validar que se haya seleccionado una fila de la tabla con el número de empleados a modificar
		int filaSeleccionada = panelGestionSedes.getTablaSedes().getSelectedRow();
		if (filaSeleccionada == -1) return -1;
		
		String ubicacionSeleccionadaTabla = panelGestionSedes.getModeloTabla().getValueAt(obtenerFilaSeleccionada(), 0).toString();
		int numeroDeEmpleadosTabla = Integer.parseInt(panelGestionSedes.getModeloTabla().getValueAt(obtenerFilaSeleccionada(), 1).toString());
		
		int numeroDeEmpleadosAModificar = 0;
		// Manejar excepción al convertir el número de empleados ingresado a modificar a entero
		try {
			numeroDeEmpleadosAModificar = Integer.parseInt(panelGestionSedes.getCampoNumeroDeEmpleadosAModificar().getText().toString());
		} catch (NumberFormatException e) {
			mostrarMensaje("El Número de empleados a actualizar de la sede " + ubicacionSeleccionadaTabla + " es inválido", "Dato inválido");
			return -1;
		}
		
		// Validar que el número de empleados de la sede a modificar no sea un número negativo
		if (numeroDeEmpleadosAModificar < 0) {
			mostrarMensaje("El número de empleados no puede ser negativo", "Dato inválido");
			return -1;
		}
		
		/* Verificar que se haya seleccionado la ubicación de la sede a modificar del JComboBox (desplegable de opciones)
		 * Si el indice seleccionado es cero quiere decir que la opción del JComboBox es la primera ("Seleccionar Ubicación:") */
		if (panelGestionSedes.getSeleccionLocalidadAModificar().getSelectedIndex() == 0) return -1;

		// Verificar si la ubicación actual y el número de empleados de la sede a modificar son los mismos
		if (ubicacionSeleccionadaTabla.equals(obtenerUbicacionAModificar()) && numeroDeEmpleadosTabla == numeroDeEmpleadosAModificar) {
			mostrarMensaje("La sede a actualizar no ha sido modificada", "Sede no modificada");
			return -1;
		}
		
		return numeroDeEmpleadosAModificar;
	}
	
	
	/**
	 * Habilitar campos numeros chance.
	 */
	public void habilitarCamposNumerosChance() {
		panelCreacionApuesta.getPanelApuestaChance().getCampoNumero1().setEditable(true);
		panelCreacionApuesta.getPanelApuestaChance().getCampoNumero2().setEditable(true);
		panelCreacionApuesta.getPanelApuestaChance().getCampoNumero3().setEditable(true);
		panelCreacionApuesta.getPanelApuestaChance().getCampoNumero4().setEditable(true);
	}
	
	/**
	 * Deshabilitar campos numeros chance.
	 */
	public void deshabilitarCamposNumerosChance() {
		panelCreacionApuesta.getPanelApuestaChance().getCampoNumero1().setEditable(false);
		panelCreacionApuesta.getPanelApuestaChance().getCampoNumero2().setEditable(false);
		panelCreacionApuesta.getPanelApuestaChance().getCampoNumero3().setEditable(false);
		panelCreacionApuesta.getPanelApuestaChance().getCampoNumero4().setEditable(false);
	}
	
	
	/**
	 * Desplegar numeros chance.
	 *
	 * @param numerosChance Arreglo con los numeros de chance que seran desplegados en los campos de texto
	 */
	public void desplegarNumerosChance(int[] numerosChance) {
		panelCreacionApuesta.getPanelApuestaChance().getCampoNumero1().setText(numerosChance[0] + "");
		panelCreacionApuesta.getPanelApuestaChance().getCampoNumero2().setText(numerosChance[1] + "");
		panelCreacionApuesta.getPanelApuestaChance().getCampoNumero3().setText(numerosChance[2] + "");
		panelCreacionApuesta.getPanelApuestaChance().getCampoNumero4().setText(numerosChance[3] + "");
	}
	
	
	/**
	 * Generar factura apuesta loteria.
	 *
	 * @param nombreDelCliente Nombre del cliente para la factura de la apuesta de loteria.
	 * @param fechaDeEmision Fecha de emision de la factura de la apuesta de loteria.
	 * @param nombreLoteria Nombre de la loteria en la apuesta.
	 * @param serie Numero de serie para la apuesta de loteria.
	 * @param numeroDeLoteria Numero de loteria de la apuesta.
	 * @param montoTotal Monto total de la apuesta de loteria.
	 */
	public void generarFacturaApuestaLoteria(String nombreDelCliente, String fechaDeEmision, String nombreLoteria, int serie, int numeroDeLoteria, double montoTotal) {
		panelFacturaApuesta.getCampoNombreCliente().setText(nombreDelCliente);
		panelFacturaApuesta.getCampoFechaDeEmision().setText(fechaDeEmision);
		panelFacturaApuesta.getCampoTipoDeJuego().setText("Lotería");
		
		panelFacturaApuesta.getPanelInformacionApuestaLoteria().getCampoLoteria().setText(nombreLoteria);
		panelFacturaApuesta.getPanelInformacionApuestaLoteria().getCampoSerie().setText(serie + "");
		panelFacturaApuesta.getPanelInformacionApuestaLoteria().getCampoNumero().setText(numeroDeLoteria + "");
		panelFacturaApuesta.mostrarPanelInformacionApuestaLoteria();
		
		panelFacturaApuesta.getCampoMontoTotal().setText(montoTotal + "");
		
	}
	
	/**
	 * Generar factura apuesta super astro.
	 *
	 * @param nombreDelCliente Nombre del cliente para la factura.
	 * @param fechaDeEmision Fecha de emision de la factura.
	 * @param numerosSeleccionados Numeros seleccionados para la apuesta de SuperAstro.
	 * @param signoDelZodiaco Signo del zodíaco seleccionado para la apuesta de SuperAstro.
	 * @param montoTotal Monto total de la apuesta de SuperAstro.
	 */
	public void generarFacturaApuestaSuperAstro(String nombreDelCliente, String fechaDeEmision, int[] numerosSeleccionados, String signoDelZodiaco, double montoTotal) {
		panelFacturaApuesta.getCampoNombreCliente().setText(nombreDelCliente);
		panelFacturaApuesta.getCampoFechaDeEmision().setText(fechaDeEmision);
		panelFacturaApuesta.getCampoTipoDeJuego().setText("SuperAstro");
		
		panelFacturaApuesta.getPanelInformacionApuestaSuperAstro().getCampoNumero1().setText(numerosSeleccionados[0] + "");
		panelFacturaApuesta.getPanelInformacionApuestaSuperAstro().getCampoNumero2().setText(numerosSeleccionados[1] + "");
		panelFacturaApuesta.getPanelInformacionApuestaSuperAstro().getCampoNumero3().setText(numerosSeleccionados[2] + "");
		panelFacturaApuesta.getPanelInformacionApuestaSuperAstro().getCampoNumero4().setText(numerosSeleccionados[3] + "");
		panelFacturaApuesta.getPanelInformacionApuestaSuperAstro().getCampoSignoDelZodiaco().setText(signoDelZodiaco);
		panelFacturaApuesta.mostrarPanelInformacionApuestaSuperAstro();
		
		panelFacturaApuesta.getCampoMontoTotal().setText(montoTotal + "");
	}
	
	/**
	 * Generar factura apuesta baloto.
	 *
	 * @param nombreDelCliente Nombre del cliente para la factura.
	 * @param fechaDeEmision Fecha de emision de la factura.
	 * @param numerosSeleccionados Numeros seleccionados para la apuesta de Baloto.
	 * @param montoTotal Monto total de la apuesta de Baloto.
	 */
	public void generarFacturaApuestaBaloto(String nombreDelCliente, String fechaDeEmision, int[] numerosSeleccionados, double montoTotal) {
		panelFacturaApuesta.getCampoNombreCliente().setText(nombreDelCliente);
		panelFacturaApuesta.getCampoFechaDeEmision().setText(fechaDeEmision);
		panelFacturaApuesta.getCampoTipoDeJuego().setText("Baloto");
		
		panelFacturaApuesta.getPanelInformacionApuestaBaloto().getCampoNumero1().setText(numerosSeleccionados[0] + "");
		panelFacturaApuesta.getPanelInformacionApuestaBaloto().getCampoNumero2().setText(numerosSeleccionados[1] + "");
		panelFacturaApuesta.getPanelInformacionApuestaBaloto().getCampoNumero3().setText(numerosSeleccionados[2] + "");
		panelFacturaApuesta.getPanelInformacionApuestaBaloto().getCampoNumero4().setText(numerosSeleccionados[3] + "");
		panelFacturaApuesta.getPanelInformacionApuestaBaloto().getCampoNumero5().setText(numerosSeleccionados[4] + "");
		panelFacturaApuesta.getPanelInformacionApuestaBaloto().getCampoNumero6().setText(numerosSeleccionados[5] + "");
		panelFacturaApuesta.mostrarPanelInformacionApuestaBaloto();
		
		panelFacturaApuesta.getCampoMontoTotal().setText(montoTotal + "");
	}
	
	/**
	 * Generar factura apuesta chance.
	 *
	 * @param nombreDelCliente Nombre del cliente para la factura.
	 * @param fechaDeEmision Fecha de emision de la factura.
	 * @param nombreLoteria Nombre de la loteria para la apuesta de Chance.
	 * @param numerosSeleccionados Numeros seleccionados para la apuesta de Chance.
	 * @param montoTotal Monto total de la apuesta de Chance.
	 */
	public void generarFacturaApuestaChance(String nombreDelCliente, String fechaDeEmision, String nombreLoteria, int[] numerosSeleccionados, double montoTotal) {
		panelFacturaApuesta.getCampoNombreCliente().setText(nombreDelCliente);
		panelFacturaApuesta.getCampoFechaDeEmision().setText(fechaDeEmision);
		panelFacturaApuesta.getCampoTipoDeJuego().setText("Baloto");
		
		panelFacturaApuesta.getPanelInformacionApuestaChance().getCampoNombreLoteria().setText(nombreLoteria);
		panelFacturaApuesta.getPanelInformacionApuestaChance().getCampoNumero1().setText(numerosSeleccionados[0] + "");
		panelFacturaApuesta.getPanelInformacionApuestaChance().getCampoNumero2().setText(numerosSeleccionados[1] + "");
		panelFacturaApuesta.getPanelInformacionApuestaChance().getCampoNumero3().setText(numerosSeleccionados[2] + "");
		panelFacturaApuesta.getPanelInformacionApuestaChance().getCampoNumero4().setText(numerosSeleccionados[3] + "");
		panelFacturaApuesta.mostrarPanelInformacionApuestaChance();
		
		panelFacturaApuesta.getCampoMontoTotal().setText(montoTotal + "");
	}
	
	/**
	 * Generar factura apuesta betplay.
	 *
	 * @param nombreDelCliente Nombre del cliente para la factura.
	 * @param fechaDeEmision Fecha de emision de la factura.
	 * @param partidosYResultadosEscogidos Matriz que contiene los partidos y resultados escogidos para la apuesta de BetPlay.
	 * @param montoTotal Monto total de la apuesta de BetPlay.
	 */
	public void generarFacturaApuestaBetPlay(String nombreDelCliente, String fechaDeEmision, String[][] partidosYResultadosEscogidos, double montoTotal) {
		panelFacturaApuesta.getCampoNombreCliente().setText(nombreDelCliente);
		panelFacturaApuesta.getCampoFechaDeEmision().setText(fechaDeEmision);
		panelFacturaApuesta.getCampoTipoDeJuego().setText("BetPlay");
		
		panelFacturaApuesta.getPanelInformacionApuestaBetPlay().desplegarTablaInformacionApuesta(partidosYResultadosEscogidos);
		panelFacturaApuesta.mostrarPanelInformacionApuestaBetPlay();
		
		panelFacturaApuesta.getCampoMontoTotal().setText(montoTotal + "");
	}
	
	/**
	 * Mostrar mensaje.
	 *
	 * @param dato   El mensaje a mostrar.
	 * @param titulo El titulo del cuadro de dialogo.
	 */
	public void mostrarMensaje(String dato, String titulo) {
		JOptionPane.showMessageDialog(null, dato, titulo, JOptionPane.INFORMATION_MESSAGE); 
	}
	
	/**
	 * Confirmar dato.
	 *
	 * @param dato   El mensaje a mostrar para la confirmacion.
	 * @param titulo El titulo del cuadro de confirmacion.
	 * @return true si se selecciona "Si", de lo contrario, false.
	 */
	public boolean confirmarDato(String dato, String titulo) {
		UIManager.put("OptionPane.yesButtonText", "Si");
		UIManager.put("OptionPane.noButtonText", "No");
		int opcion = JOptionPane.showConfirmDialog(null, dato, titulo, JOptionPane.YES_NO_OPTION);
		if (opcion == 1 || opcion == -1)
			return false;
		return true;
	}

	/**
	 * Gets the card layout.
	 *
	 * @return the card layout
	 */
	public CardLayout getCardLayout() {
		return cardLayout;
	}

	/**
	 * Sets the card layout.
	 *
	 * @param cardLayout the new card layout
	 */
	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	/**
	 * Gets the panel menu principal.
	 *
	 * @return the panel menu principal
	 */
	public PanelMenuPrincipal getPanelMenuPrincipal() {
		return panelMenuPrincipal;
	}

	/**
	 * Sets the panel menu principal.
	 *
	 * @param panelMenuPrincipal the new panel menu principal
	 */
	public void setPanelMenuPrincipal(PanelMenuPrincipal panelMenuPrincipal) {
		this.panelMenuPrincipal = panelMenuPrincipal;
	}

	/**
	 * Gets the panel parametrizacion casa de apuestas.
	 *
	 * @return the panel parametrizacion casa de apuestas
	 */
	public PanelParametrizacionCasaDeApuestas getPanelParametrizacionCasaDeApuestas() {
		return panelParametrizacionCasaDeApuestas;
	}

	/**
	 * Sets the panel parametrizacion casa de apuestas.
	 *
	 * @param panelParametrizacionCasaDeApuestas the new panel parametrizacion casa de apuestas
	 */
	public void setPanelParametrizacionCasaDeApuestas(
			PanelParametrizacionCasaDeApuestas panelParametrizacionCasaDeApuestas) {
		this.panelParametrizacionCasaDeApuestas = panelParametrizacionCasaDeApuestas;
	}

	/**
	 * Gets the panel gestion sedes.
	 *
	 * @return the panel gestion sedes
	 */
	public PanelGestionSedes getPanelGestionSedes() {
		return panelGestionSedes;
	}

	/**
	 * Sets the panel gestion sedes.
	 *
	 * @param panelGestionSedes the new panel gestion sedes
	 */
	public void setPanelGestionSedes(PanelGestionSedes panelGestionSedes) {
		this.panelGestionSedes = panelGestionSedes;
	}

	/**
	 * Gets the panel gestion apostadores.
	 *
	 * @return the panel gestion apostadores
	 */
	public PanelGestionApostadores getPanelGestionApostadores() {
		return panelGestionApostadores;
	}

	/**
	 * Gets the panel modificacion apuesta.
	 *
	 * @return the panel modificacion apuesta
	 */
	public PanelModificacionApuesta getPanelModificacionApuesta() {
		return panelModificacionApuesta;
	}

	/**
	 * Sets the panel modificacion apuesta.
	 *
	 * @param panelModificacionApuesta the new panel modificacion apuesta
	 */
	public void setPanelModificacionApuesta(PanelModificacionApuesta panelModificacionApuesta) {
		this.panelModificacionApuesta = panelModificacionApuesta;
	}

	/**
	 * Sets the panel gestion apostadores.
	 *
	 * @param panelGestionApostadores the new panel gestion apostadores
	 */
	public void setPanelGestionApostadores(PanelGestionApostadores panelGestionApostadores) {
		this.panelGestionApostadores = panelGestionApostadores;
	}

	/**
	 * Gets the panel creacion apostador.
	 *
	 * @return the panel creacion apostador
	 */
	public PanelCreacionApostador getPanelCreacionApostador() {
		return panelCreacionApostador;
	}

	/**
	 * Sets the panel creacion apostador.
	 *
	 * @param panelCreacionApostador the new panel creacion apostador
	 */
	public void setPanelCreacionApostador(PanelCreacionApostador panelCreacionApostador) {
		this.panelCreacionApostador = panelCreacionApostador;
	}

	/**
	 * Gets the panel modificacion apostador.
	 *
	 * @return the panel modificacion apostador
	 */
	public PanelModificacionApostador getPanelModificacionApostador() {
		return panelModificacionApostador;
	}
	
	/**
	 * Gets the panel realizacion consultas.
	 *
	 * @return the panel realizacion consultas
	 */
	public PanelRealizacionConsultas getPanelRealizacionConsultas() {
		return panelRealizacionConsultas;
	}

	/**
	 * Sets the panel realizacion consultas.
	 *
	 * @param panelRealizacionConsultas the new panel realizacion consultas
	 */
	public void setPanelRealizacionConsultas(PanelRealizacionConsultas panelRealizacionConsultas) {
		this.panelRealizacionConsultas = panelRealizacionConsultas;
	}

	/**
	 * Sets the panel modificacion apostador.
	 *
	 * @param panelModificacionApostador the new panel modificacion apostador
	 */
	public void setPanelModificacionApostador(PanelModificacionApostador panelModificacionApostador) {
		this.panelModificacionApostador = panelModificacionApostador;
	}

	/**
	 * Gets the panel gestion apuestas.
	 *
	 * @return the panel gestion apuestas
	 */
	public PanelGestionApuestas getPanelGestionApuestas() {
		return panelGestionApuestas;
	}

	/**
	 * Sets the panel gestion apuestas.
	 *
	 * @param panelGestionApuestas the new panel gestion apuestas
	 */
	public void setPanelGestionApuestas(PanelGestionApuestas panelGestionApuestas) {
		this.panelGestionApuestas = panelGestionApuestas;
	}

	/**
	 * Gets the panel creacion apuesta.
	 *
	 * @return the panel creacion apuesta
	 */
	public PanelCreacionApuesta getPanelCreacionApuesta() {
		return panelCreacionApuesta;
	}

	/**
	 * Sets the panel creacion apuesta.
	 *
	 * @param panelCreacionApuesta the new panel creacion apuesta
	 */
	public void setPanelCreacionApuesta(PanelCreacionApuesta panelCreacionApuesta) {
		this.panelCreacionApuesta = panelCreacionApuesta;
	}

	/**
	 * Gets the iconos.
	 *
	 * @return the iconos
	 */
	public HashMap<String, Image> getIconos() {
		return iconos;
	}

	/**
	 * Sets the iconos.
	 *
	 * @param iconos the iconos
	 */
	public void setIconos(HashMap<String, Image> iconos) {
		this.iconos = iconos;
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
