package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import co.edu.unbosque.model.CasaDeApuestas;
import co.edu.unbosque.view.ColoresAleatorios;
import co.edu.unbosque.view.View;

/**
 * The Class Controller.
 */
public class Controller implements ActionListener, MouseListener {

	/** The casa de apuestas. */
	private CasaDeApuestas casaDeApuestas;
	
	/** The gui. */
	private View gui;
	
	/** The colores aleatorios. */
	private ColoresAleatorios coloresAleatorios;
	
	/** The hilo colores aletarios menu principal. */
	private Thread hiloColoresAletariosMenuPrincipal;

	/**
	 * Instantiates a new Controller.
	 */
	public Controller() {

		casaDeApuestas = new CasaDeApuestas();

		gui = new View(this);
		gui.setVisible(true);

		coloresAleatorios = new ColoresAleatorios();
		inicializarHiloColoresAletariosMenuPrincipal();
		
	}
	
	/**
	 * Inicializar hilo colores aletarios menu principal.
	 */
	public void inicializarHiloColoresAletariosMenuPrincipal() {
		// Inicializar un hilo que se ejecuta para generar colores aleatorios cada segundo en el panel menú principal.
		hiloColoresAletariosMenuPrincipal = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					
					// Generar colores aleatorios para los botones del panel menú principal
					for (int i = 0; i < gui.getPanelMenuPrincipal().obtenerBotonesMenuPrincipal().length; i++)
						gui.getPanelMenuPrincipal().obtenerBotonesMenuPrincipal()[i].setBackground(coloresAleatorios.generarColorAleatorioClaro());
					
					// Pausar el hilo por 1 segundo (1000 milisegundos)
					try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
				}
			}
		});
		hiloColoresAletariosMenuPrincipal.start();
	}

	/**
	 * Action performed.
	 *
	 * @param evento Evento de accion
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		///////////////////////////////////////// EVENTOS PANEL MENÚ PRINCIPAL /////////////////////////////////////////
		
		if (evento.getActionCommand().equals(gui.getPanelMenuPrincipal().PARAMETRIZAR_CASA_DE_APUESTAS)) {
			
			// Revisar si la casa de apuestas ya ha sido parametrizada
			if (!casaDeApuestas.getNombre().isEmpty()) {
				// Actualizar los campos con las propiedades de la casa de apuestas, la cual ya ha sido previamente parametrizada
				gui.getPanelParametrizacionCasaDeApuestas().getCampoNombreCasaDeApuestas().setText(casaDeApuestas.getNombre());
				gui.getPanelParametrizacionCasaDeApuestas().getCampoNumeroDeSedes().setText(casaDeApuestas.getNumeroDeSedes() + "");
				gui.getPanelParametrizacionCasaDeApuestas().getCampoPresupuestoTotal().setText(casaDeApuestas.getPresupuestoTotalDisponible() + "");
			}
			
			actualizarTablaJuegosPanelParametrizacion();
			
			// Deseleccionar todas las filas y/o columnas de la tabla juegos
			gui.getPanelParametrizacionCasaDeApuestas().getTablaJuegos().clearSelection();
			
			gui.mostrarPanelParametrizacionCasaDeApuestas();
			
		} else if (evento.getActionCommand().equals(gui.getPanelMenuPrincipal().GESTIONAR_SEDES)) {
			
			actualizarTablaSedesPanelGestionSedes();
			
			gui.mostrarPanelGestionSedes();
			
		} else if (evento.getActionCommand().equals(gui.getPanelMenuPrincipal().GESTIONAR_APOSTADORES)) {
			
			actualizarTablaApostadoresPanelGestionApostadores();
			
			gui.mostrarPanelGestionApostadores();
			
		} else if (evento.getActionCommand().equals(gui.getPanelMenuPrincipal().GESTIONAR_APUESTAS)) {
			
			actualizarTablaApuestasPanelGestionApuestas();
			
			gui.mostrarPanelGestionApuestas();
			
		} else if (evento.getActionCommand().equals(gui.getPanelMenuPrincipal().REALIZAR_CONSULTAS)) {
			
			actualizarSeleccionablesPanelRealizacionConsultas();
			gui.mostrarPanelRealizacionConsultas();
			
		}

		///////////////////////////////////////// EVENTOS PANEL PARAMETRIZACIÓN CASA DE APUESTAS /////////////////////////////////////////
		
		else if (evento.getActionCommand().equals(gui.getPanelParametrizacionCasaDeApuestas().VOLVER_AL_MENU_PRINCIPAL)) {
			
			gui.mostrarPanelMenuPrincipal();
			
		} else if (evento.getActionCommand().equals(gui.getPanelParametrizacionCasaDeApuestas().CARGAR_PARAMETROS)) {
			
			// Obtener los párametros actuales de la casa de apuestas, y si existen, cargarlos
			gui.cargarParametrosCasaDeApuestas(casaDeApuestas.getNombre(),
											   casaDeApuestas.getNumeroDeSedes(), 
											   casaDeApuestas.getPresupuestoTotalDisponible());
			
		} else if (evento.getActionCommand().equals(gui.getPanelParametrizacionCasaDeApuestas().GUARDAR_PARAMETROS)) {
			
			if (casaDeApuestas.guardarParametros(
					gui.obtenerNombreCasaDeApuesta(),
					gui.obtenerNumeroDeSedes(),
					gui.obtenerPresupuestoTotalDisponible())) {
				actualizarTablaJuegosPanelParametrizacion();
				gui.mostrarMensaje("Los parámetros de la Casa de Apuestas han sido guardados", "Parámetros guardados");
			} else {
				gui.mostrarMensaje("Los parámetros de la casa de apuestas no han cambiado", "Parámetros no cambiados");
			}

		}
		
		///////////////////////////////////////// EVENTOS PANEL GESTIÓN SEDES /////////////////////////////////////////
		
		else if (evento.getActionCommand().equals(gui.getPanelGestionSedes().VOLVER_AL_MENU_PRINCIPAL)) {
			
			gui.mostrarPanelMenuPrincipal();
			
		} else if (evento.getActionCommand().equals(gui.getPanelGestionSedes().CREAR_SEDE)) {
			
			if (casaDeApuestas.agregarSede(
					gui.obtenerUbicacionSede(),
					gui.obtenerNumeroDeEmpleados())) {
			
				actualizarTablaSedesPanelGestionSedes();
				
				reiniciarCamposSedeACrearPanelGestionSedes();
				
				gui.mostrarMensaje("La sede ubicada en " + casaDeApuestas.getGestorDeSedes().getSede().getUbicacion() + " y con " + casaDeApuestas.getGestorDeSedes().getSede().getNumeroDeEmpleados() + " empleados ha sido agregada", "Sede agregada");
				
			}
			
		
		} else if (evento.getActionCommand().equals(gui.getPanelGestionSedes().MODIFICAR_SEDE)) {
			
			if (casaDeApuestas.modificarSede(
					gui.obtenerFilaSeleccionada(),
					gui.obtenerUbicacionAModificar(),
					gui.obtenerNumeroDeEmpleadosAModificar())) {
				
				actualizarTablaSedesPanelGestionSedes();
				gui.reiniciarCamposSedeAModificarPanelGestionSedes();
				
				gui.mostrarMensaje("La sede ha sido modificada exitosamente", "Sede modificada");
			}

			
		} else if (evento.getActionCommand().equals(gui.getPanelGestionSedes().ELIMINAR_SEDE)) {
			
			if (casaDeApuestas.eliminarSede(gui.obtenerIndiceSedeAEliminar())) {
				actualizarTablaSedesPanelGestionSedes();
				gui.reiniciarCamposSedeAModificarPanelGestionSedes();
				gui.mostrarMensaje("La sede previamente ubicada en " + casaDeApuestas.getGestorDeSedes().getSede().getUbicacion() + " y con " + casaDeApuestas.getGestorDeSedes().getSede().getNumeroDeEmpleados() + " empleados ha sido eliminada", "Sede eliminada");
			}
			
		}
		
		///////////////////////////////////////// EVENTOS PANEL GESTIÓN APOSTADORES /////////////////////////////////////////
		
		else if (evento.getActionCommand().equals(gui.getPanelGestionApostadores().VOLVER_AL_MENU_PRINCIPAL)) {
			
			gui.mostrarPanelMenuPrincipal();
			
		} else if (evento.getActionCommand().equals(gui.getPanelGestionApostadores().CREAR_APOSTADOR)) {
			
			actualizarSeleccionableDeSedesPanelCreacionApostador();
			
			gui.mostrarPanelCreacionApostador();
			
		} else if (evento.getActionCommand().equals(gui.getPanelGestionApostadores().MODIFICAR_APOSTADOR)) {
			
			// Verificar que el usuario haya seleccionado una fila de la tabla para modificar un apostador
			int filaSeleccionada = gui.getPanelGestionApostadores().getTablaApostadores().getSelectedRow();
			if (filaSeleccionada == -1) {
				gui.mostrarMensaje("Seleccione una fila con el apostador a modificar", "Seleccionar Fila");
				return;
			}
			
			actualizarSeleccionableDeSedesPanelModificacionApostador();
			
			// Obtener todos los datos del apostador a modificar
			String nombreActual = casaDeApuestas.getGestorDeApostadores().getApostadores().get(filaSeleccionada).getNombreCompleto();
			String direccionActual = casaDeApuestas.getGestorDeApostadores().getApostadores().get(filaSeleccionada).getDireccion();
			String cedulaActual = casaDeApuestas.getGestorDeApostadores().getApostadores().get(filaSeleccionada).getCedula();
			long celularActual = casaDeApuestas.getGestorDeApostadores().getApostadores().get(filaSeleccionada).getCelular();
			String sedeActual = casaDeApuestas.getGestorDeApostadores().getApostadores().get(filaSeleccionada).getSedeActual();
			
			// Actualizar los campos del apostador a modificar
			gui.getPanelModificacionApostador().getCampoNombreApostador().setText(nombreActual);
			gui.getPanelModificacionApostador().getCampoDireccionApostador().setText(direccionActual);
			gui.getPanelModificacionApostador().getCampoCedulaApostador().setText(cedulaActual);
			gui.getPanelModificacionApostador().getCampoNumeroApostador().setText(celularActual + "");
			gui.getPanelModificacionApostador().getSeleccionSedeApostador().setSelectedItem(sedeActual);
			
			gui.mostrarPanelModificacionApostador();
			
		} else if (evento.getActionCommand().equals(gui.getPanelGestionApostadores().ELIMINAR_APOSTADOR)) {

			// Verificar que el usuario haya seleccionado una fila de la tabla para eliminar un apostador
			int filaSeleccionada = gui.getPanelGestionApostadores().getTablaApostadores().getSelectedRow();
			if (filaSeleccionada == -1) {
				gui.mostrarMensaje("Seleccione una fila con el apostador a eliminar", "Seleccionar Fila");
				return;
			}
			
			// Confirmar con el usuario la eliminación del apostador seleccionado
			if (gui.confirmarDato("Está seguro de que desea eliminar el apostador seleccionado?", "Confirmación eliminación apostador")) {
				
				int indiceApostadorAEliminar = gui.getPanelGestionApostadores().getTablaApostadores().getSelectedRow();
				casaDeApuestas.getGestorDeApostadores().eliminarApostador(indiceApostadorAEliminar);
				casaDeApuestas.getGestorDeApostadores().registrarApostadores();
				
				actualizarTablaApostadoresPanelGestionApostadores();
				
				gui.mostrarMensaje("El apostador con cédula " + casaDeApuestas.getGestorDeApostadores().getApostador().getCedula() + " ha sido eliminado", "Apostador Eliminado");
			}
			
		}
		
		///////////////////////////////////////// EVENTOS PANEL CREACIÓN APOSTADOR /////////////////////////////////////////
		
		else if (evento.getActionCommand().equals(gui.getPanelCreacionApostador().VOLVER_A_GESTION_DE_APOSTADORES)) {
			
			gui.mostrarPanelGestionApostadores();
			
		} else if (evento.getActionCommand().equals(gui.getPanelCreacionApostador().CREAR_APOSTADOR)) {
			   
			String nombreCompleto = gui.getPanelCreacionApostador().getCampoNombreApostador().getText();
			
			// Revisar que se haya ingresado el nombre completo del apostador a crear
			if (nombreCompleto.isEmpty()) {
				gui.mostrarMensaje("El nombre del apostador no ha sido ingresado", "Dato no ingresado");
				return;
			}
			
			String direccion = gui.getPanelCreacionApostador().getCampoDireccionApostador().getText();
			
			// Revisar que se haya ingresado la dirección del apostador a crear
			if (direccion.isEmpty()) {
				gui.mostrarMensaje("La dirección del apostador no ha sido ingresada", "Dato no ingresado");
				return;
			}
			
			String cedula = gui.getPanelCreacionApostador().getCampoCedulaApostador().getText();
			
			// Revisar que se haya ingresado la cédula del apostador a crear
			if (cedula.isEmpty()) {
				gui.mostrarMensaje("La cédula del apostador no ha sido ingresada", "Dato no ingresado");
				return;
			}
			
			// Revisar que la cedula contenga solo digitos (números) o puntos
			for (char c: cedula.toCharArray()) {
				if (!Character.isDigit(c) && c != '.') {
					gui.mostrarMensaje("La cédula ingresada debe contener únicamente números o puntos", "Dato inválido");
					return;
				}
			}
			
			/* Validar que la cédula no haya sido registrada previamente.
			 * Si se encuentra el índice de un apostador por cédula en el ArrayList,
			 * quiere decir que ya se ha registrado un apostador con tal cédula */
			if (casaDeApuestas.getGestorDeApostadores().obtenerIndiceApostador(cedula) != -1) {
				gui.mostrarMensaje("El apostador con la cédula " + cedula + " ya existe", "Apostador existente");
				return;
			}
			
			String celularIngresado = gui.getPanelCreacionApostador().getCampoNumeroApostador().getText();
			// Revisar que se haya ingresado el celular del apostador a crear
			if (celularIngresado.isEmpty()) {
				gui.mostrarMensaje("El celular del apostador no ha sido ingresado", "Dato no ingresado");
				return;
			}
			
			long celular;
			
			// Manejar excepción al convertir el celular ingresado a entero
			try {
				celular = Long.parseLong(celularIngresado);
			} catch (NumberFormatException e) {
				gui.mostrarMensaje("El celular del apostador es inválido", "Dato inválido");
				return;
			}
			
			/* Verificar que se haya seleccionado la sede del apostador a crear del JComboBox (desplegable de opciones)
			 * Si el indice seleccionado es cero quiere decir que la opción del JComboBox es la primera ("Seleccionar Ubicación:") */
			if (gui.getPanelCreacionApostador().getSeleccionSedeApostador().getSelectedIndex() == 0) {
				gui.mostrarMensaje("La sede del apostador a crear no ha sido seleccionada", "Sede no seleccionada");
				return;
			}
			
			String sedeActual = gui.getPanelCreacionApostador().getSeleccionSedeApostador().getSelectedItem().toString();
			
			// Agregar nuevo apostador
			casaDeApuestas.getGestorDeApostadores().agregarApostador(nombreCompleto, cedula, sedeActual, direccion, celular);
			
			// Actualizar el archivo de apostadores con el apostador agregado
			casaDeApuestas.getGestorDeApostadores().registrarApostadores();
			
			actualizarTablaApostadoresPanelGestionApostadores();
			actualizarSeleccionableDeSedesPanelCreacionApostador();
			reiniciarCamposApostadorACrearPanelCreacionApostador();
			gui.mostrarPanelGestionApostadores();
			
			gui.mostrarMensaje("El apostador con cédula " + casaDeApuestas.getGestorDeApostadores().getApostador().getCedula() + " ha sido agregado", "Apostador agregado");
			
		}
		
		///////////////////////////////////////// EVENTOS PANEL MODIFICACIÓN APOSTADOR /////////////////////////////////////////
		
		else if (evento.getActionCommand().equals(gui.getPanelModificacionApostador().VOLVER_A_GESTION_DE_APOSTADORES)) {
			
			gui.mostrarPanelGestionApostadores();
			
		} else if (evento.getActionCommand().equals(gui.getPanelModificacionApostador().MODIFICAR_APOSTADOR)) {
			
			String nombreCompletoAModificar = gui.getPanelModificacionApostador().getCampoNombreApostador().getText();
			
			// Revisar que se haya ingresado el nombre completo del apostador a crear
			if (nombreCompletoAModificar.isEmpty()) {
				gui.mostrarMensaje("El nombre del apostador a modificar no ha sido ingresado", "Dato no ingresado");
				return;
			}
			
			String direccionAModificar = gui.getPanelModificacionApostador().getCampoDireccionApostador().getText();
			
			// Revisar que se haya ingresado la dirección del apostador a crear
			if (direccionAModificar.isEmpty()) {
				gui.mostrarMensaje("La dirección del apostador a modificar no ha sido ingresada", "Dato no ingresado");
				return;
			}
			
			String cedula = gui.getPanelModificacionApostador().getCampoCedulaApostador().getText();
			
			// Revisar que se haya ingresado la cédula del apostador a crear
			if (cedula.isEmpty()) {
				gui.mostrarMensaje("La cédula del apostador a modificar no ha sido ingresada", "Dato no ingresado");
				return;
			}
			
			// Revisar que la cedula contenga solo digitos (números) o puntos
			for (char c: cedula.toCharArray()) {
				if (!Character.isDigit(c) && c != '.') {
					gui.mostrarMensaje("La cédula ingresada debe contener únicamente números o puntos", "Dato inválido");
					return;
				}
			}
			
			String celularIngresado = gui.getPanelModificacionApostador().getCampoNumeroApostador().getText();
			// Revisar que se haya ingresado el celular del apostador a modificar
			if (celularIngresado.isEmpty()) {
				gui.mostrarMensaje("El celular del apostador a modificar no ha sido ingresado", "Dato no ingresado");
				return;
			}
			
			long celularAModificar;
			
			// Manejar excepción al convertir el celular ingresado a entero
			try {
				celularAModificar = Long.parseLong(celularIngresado);
			} catch (NumberFormatException e) {
				gui.mostrarMensaje("El celular del apostador a modificar es inválido", "Dato inválido");
				return;
			}
			
			/* Verificar que se haya seleccionado la sede del apostador a crear del JComboBox (desplegable de opciones)
			 * Si el indice seleccionado es cero quiere decir que la opción del JComboBox es la primera ("Seleccionar Ubicación:") */
			if (gui.getPanelModificacionApostador().getSeleccionSedeApostador().getSelectedIndex() == 0) {
				gui.mostrarMensaje("La sede del apostador a modificar no ha sido seleccionada", "Sede no seleccionada");
				return;
			}
			
			String sedeActualAModificar = gui.getPanelModificacionApostador().getSeleccionSedeApostador().getSelectedItem().toString();
			
			// Obtener el índice del apostador a modificar de la tabla
			int indiceApostadorAModificar = casaDeApuestas.getGestorDeApostadores().obtenerIndiceApostador(cedula);
			
			// Verificar si la ubicación actual y el número de empleados de la sede a modificar son los mismos
			if (casaDeApuestas.getGestorDeApostadores().apostadorSinModificar(indiceApostadorAModificar, nombreCompletoAModificar, cedula, sedeActualAModificar, direccionAModificar, celularAModificar)) {
				gui.mostrarMensaje("El apostador a actualizar no ha cambiado", "Apostador no modificado");
				return;
			}
			
			// Modificar el apostador actual
			casaDeApuestas.getGestorDeApostadores().modificarApostador(indiceApostadorAModificar, nombreCompletoAModificar, cedula, sedeActualAModificar, direccionAModificar, celularAModificar);
			
			// Actualizar el archivo de apostadores con el apostador modificado
			casaDeApuestas.getGestorDeApostadores().registrarApostadores();
			actualizarTablaApostadoresPanelGestionApostadores();
			
			gui.mostrarPanelGestionApostadores();
			gui.mostrarMensaje("El apostador con cédula " + casaDeApuestas.getGestorDeApostadores().getApostador().getCedula() + " ha sido modificado", "Apostador modificado");
			
		}
		
		///////////////////////////////////////// EVENTOS PANEL GESTIÓN APUESTAS /////////////////////////////////////////
		
		else if (evento.getActionCommand().equals(gui.getPanelGestionApuestas().VOLVER_AL_MENU_PRINCIPAL)) {
			
			gui.mostrarPanelMenuPrincipal();
			
		} else if (evento.getActionCommand().equals(gui.getPanelGestionApuestas().CREAR_APUESTA)) {
			
			actualizarSeleccionablesPanelCreacionApuesta();

			gui.mostrarPanelCreacionApuesta();
			
		} else if (evento.getActionCommand().equals(gui.getPanelGestionApuestas().MODIFICAR_APUESTA)) {
			
			// Verificar que el usuario haya seleccionado una fila de la tabla para modificar una apuesta
			int filaSeleccionadaTablaApuestas = gui.getPanelGestionApuestas().getTablaApuestas().getSelectedRow();
			if (filaSeleccionadaTablaApuestas == -1) {
				gui.mostrarMensaje("Seleccione una fila con la apuesta a modificar", "Seleccionar Apuesta");
				return;
			}
			
			// Obtener todos los datos de la apuesta a modificar
			String tipoDeApuesta = gui.getPanelGestionApuestas().getTablaApuestas().getValueAt(filaSeleccionadaTablaApuestas, 0).toString();
			String cedulaApostador = gui.getPanelGestionApuestas().getTablaApuestas().getValueAt(filaSeleccionadaTablaApuestas, 2).toString();
			String fechaApuesta = gui.getPanelGestionApuestas().getTablaApuestas().getValueAt(filaSeleccionadaTablaApuestas, 3).toString();
			
			actualizarSeleccionablesPanelModificacionSede();
			
			// Actualizar todos los campos con los datos actuales en el panel modificación apuesta
			gui.getPanelModificacionApuesta().getCampoCedulaApostador().setText(cedulaApostador);
			gui.getPanelModificacionApuesta().getCampoTipoDeApuesta().setText(tipoDeApuesta);
			
			switch (tipoDeApuesta) {
			
				case "Loteria":
					// Obtener datos actuales de la apuesta lotería
					int indiceApuestaLoteria = casaDeApuestas.getGestorDeApuestas().getGestorApuestasLoteria().obtenerIndiceApuesta(cedulaApostador, fechaApuesta);
					
					String sedeApuestaLoteria = casaDeApuestas.getGestorDeApuestas().getGestorApuestasLoteria().getApuestasLoteria().get(indiceApuestaLoteria).getNombreSede();
					double valorApuestaLoteria = casaDeApuestas.getGestorDeApuestas().getGestorApuestasLoteria().getApuestasLoteria().get(indiceApuestaLoteria).getValor();
					
					String nombreLoteria = casaDeApuestas.getGestorDeApuestas().getGestorApuestasLoteria().getApuestasLoteria().get(indiceApuestaLoteria).getNombre();
					int serie = casaDeApuestas.getGestorDeApuestas().getGestorApuestasLoteria().getApuestasLoteria().get(indiceApuestaLoteria).getSerie();
					int numeroLoteria = casaDeApuestas.getGestorDeApuestas().getGestorApuestasLoteria().getApuestasLoteria().get(indiceApuestaLoteria).getNumeroLoteria();
					
					// Desplegar los datos actuales de la apuesta lotería en el panel modificación apuesta
					gui.getPanelModificacionApuesta().getSeleccionSede().setSelectedItem(sedeApuestaLoteria);
					gui.getPanelModificacionApuesta().getCampoValorApuesta().setText(valorApuestaLoteria + "");
					
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaLoteria().getCampoLoteria().setText(nombreLoteria);
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaLoteria().getCampoSerie().setText(serie + "");
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaLoteria().getCampoNumero().setText(numeroLoteria + "");
					break;
				
				case "SuperAstro":
					// Obtener datos actuales de la apuesta superAstro
					int indiceApuestaSuperAstro = casaDeApuestas.getGestorDeApuestas().getGestorApuestasSuperAstro().obtenerIndiceApuesta(cedulaApostador, fechaApuesta);
					
					String sedeApuestaSuperAstro = casaDeApuestas.getGestorDeApuestas().getGestorApuestasSuperAstro().getApuestasSuperAstro().get(indiceApuestaSuperAstro).getNombreSede();
					double valorApuestaSuperAstro = casaDeApuestas.getGestorDeApuestas().getGestorApuestasSuperAstro().getApuestasSuperAstro().get(indiceApuestaSuperAstro).getValor();
					
					int[] numerosSuperAstro = casaDeApuestas.getGestorDeApuestas().getGestorApuestasSuperAstro().getApuestasSuperAstro().get(indiceApuestaSuperAstro).getNumerosSeleccionados();
					String signoDelZodiaco = casaDeApuestas.getGestorDeApuestas().getGestorApuestasSuperAstro().getApuestasSuperAstro().get(indiceApuestaSuperAstro).getSignoDelZodiaco();
					

					// Desplegar los datos actuales de la apuesta superAstro en el panel modificación apuesta
					gui.getPanelModificacionApuesta().getSeleccionSede().setSelectedItem(sedeApuestaSuperAstro);
					gui.getPanelModificacionApuesta().getCampoValorApuesta().setText(valorApuestaSuperAstro + "");
					
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaSuperAstro().getCampoNumero1().setText(numerosSuperAstro[0] + "");
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaSuperAstro().getCampoNumero2().setText(numerosSuperAstro[1] + "");
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaSuperAstro().getCampoNumero3().setText(numerosSuperAstro[2] + "");
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaSuperAstro().getCampoNumero4().setText(numerosSuperAstro[3] + "");
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaSuperAstro().getCampoSignoDelZodiaco().setText(signoDelZodiaco);
					
					break;
				
				case "Baloto":
					// Obtener datos actuales de la apuesta baloto
					int indiceApuestaBaloto = casaDeApuestas.getGestorDeApuestas().getGestorApuestasBaloto().obtenerIndiceApuesta(cedulaApostador, fechaApuesta);
					
					String sedeApuestaBaloto = casaDeApuestas.getGestorDeApuestas().getGestorApuestasBaloto().getApuestasBaloto().get(indiceApuestaBaloto).getNombreSede();
					double valorApuestaBaloto = casaDeApuestas.getGestorDeApuestas().getGestorApuestasBaloto().getApuestasBaloto().get(indiceApuestaBaloto).getValor();
					
					int[] numerosBaloto = casaDeApuestas.getGestorDeApuestas().getGestorApuestasBaloto().getApuestasBaloto().get(indiceApuestaBaloto).getNumerosSeleccionados();
					
					// Desplegar los datos actuales de la apuesta baloto en el panel modificación apuesta
					gui.getPanelModificacionApuesta().getSeleccionSede().setSelectedItem(sedeApuestaBaloto);
					gui.getPanelModificacionApuesta().getCampoValorApuesta().setText(valorApuestaBaloto + "");
					
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaBaloto().getCampoNumero1().setText(numerosBaloto[0] + "");
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaBaloto().getCampoNumero2().setText(numerosBaloto[1] + "");
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaBaloto().getCampoNumero3().setText(numerosBaloto[2] + "");
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaBaloto().getCampoNumero4().setText(numerosBaloto[3] + "");
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaBaloto().getCampoNumero5().setText(numerosBaloto[4] + "");
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaBaloto().getCampoNumero6().setText(numerosBaloto[5] + "");
					break;
				
				case "BetPlay":
					// Obtener datos actuales de la apuesta de BetPlay
					int indiceApuestaBetPlay = casaDeApuestas.getGestorDeApuestas().getGestorApuestasBetPlay().obtenerIndiceApuesta(cedulaApostador, fechaApuesta);
					
					String sedeApuestaBetPlay = casaDeApuestas.getGestorDeApuestas().getGestorApuestasBetPlay().getApuestasBetPlay().get(indiceApuestaBetPlay).getNombreSede();
					double valorApuestaBetPlay = casaDeApuestas.getGestorDeApuestas().getGestorApuestasBetPlay().getApuestasBetPlay().get(indiceApuestaBetPlay).getValor();
					
					String[][] partidosYResultadosEscogidos = casaDeApuestas.getGestorDeApuestas().getGestorApuestasBetPlay().getApuestasBetPlay().get(indiceApuestaBetPlay).getPartidosYResultadosEscogidos();
					
					// Desplegar los datos actuales de la apuesta betplay en el panel modificación apuesta
					gui.getPanelModificacionApuesta().getSeleccionSede().setSelectedItem(sedeApuestaBetPlay);
					gui.getPanelModificacionApuesta().getCampoValorApuesta().setText(valorApuestaBetPlay + "");
					
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaBetPlay().desplegarTablaInformacionApuesta(partidosYResultadosEscogidos);
					break;
				
				case "Chance":
					
					// Obtener datos actuales de la apuesta chance
					int indiceApuestaChance = casaDeApuestas.getGestorDeApuestas().getGestorApuestasChance().obtenerIndiceApuesta(cedulaApostador, fechaApuesta);
					
					String sedeApuestaChance = casaDeApuestas.getGestorDeApuestas().getGestorApuestasChance().getApuestasChance().get(indiceApuestaChance).getNombreSede();
					double valorApuestaChance = casaDeApuestas.getGestorDeApuestas().getGestorApuestasChance().getApuestasChance().get(indiceApuestaChance).getValor();
					
					String nombreChance = casaDeApuestas.getGestorDeApuestas().getGestorApuestasChance().getApuestasChance().get(indiceApuestaChance).getNombre();
					int[] numerosChance = casaDeApuestas.getGestorDeApuestas().getGestorApuestasChance().getApuestasChance().get(indiceApuestaChance).getNumerosSeleccionados();
					
					// Desplegar los datos actuales de la apuesta chance en el panel modificación apuesta
					gui.getPanelModificacionApuesta().getSeleccionSede().setSelectedItem(sedeApuestaChance);
					gui.getPanelModificacionApuesta().getCampoValorApuesta().setText(valorApuestaChance + "");
					
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaChance().getCampoNombreLoteria().setText(nombreChance);
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaChance().getCampoNumero1().setText(numerosChance[0] + "");
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaChance().getCampoNumero2().setText(numerosChance[1] + "");
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaChance().getCampoNumero3().setText(numerosChance[2] + "");
					gui.getPanelModificacionApuesta().getPanelInformacionApuestaChance().getCampoNumero4().setText(numerosChance[3] + "");	
					break;
			
			}
			
			gui.getPanelModificacionApuesta().mostrarPanelApuesta(tipoDeApuesta);
			gui.mostrarPanelModificacionApuesta();
			
		} else if (evento.getActionCommand().equals(gui.getPanelGestionApuestas().ELIMINAR_APUESTA)) {
			// Verificar que el usuario haya seleccionado una fila de la tabla para eliminar una apuesta
			int filaSeleccionadaTablaApuestas = gui.getPanelGestionApuestas().getTablaApuestas().getSelectedRow();
			if (filaSeleccionadaTablaApuestas == -1) {
				gui.mostrarMensaje("Seleccione una fila con la apuesta a eliminar", "Seleccionar Apuesta");
				return;
			}
			
			// Confirmar con el usuario la eliminación de la apuesta seleccionada
			if (gui.confirmarDato("Está seguro de que desea eliminar la apuesta seleccionada?", "Confirmación eliminación apuesta")) {
				
				// Obtener el tipo de la apuesta de la fila seleccionada de la tabla
				String tipoDeApuesta = gui.getPanelGestionApuestas().getTablaApuestas().getValueAt(filaSeleccionadaTablaApuestas, 0).toString();
				
				// Obtener la fecha en la que se realizó la apuesta de la fila seleccionada de la tabla
				String fechaDeLaApuesta = gui.getPanelGestionApuestas().getTablaApuestas().getValueAt(filaSeleccionadaTablaApuestas, 3).toString();
				
				// Obtener la cédula del apostador de la fila seleccionada de la tabla
				String cedulaApostador = gui.getPanelGestionApuestas().getTablaApuestas().getValueAt(filaSeleccionadaTablaApuestas, 2).toString();
				
				casaDeApuestas.getGestorDeApuestas().eliminarApuesta(tipoDeApuesta, cedulaApostador, fechaDeLaApuesta);
				
				actualizarTablaApuestasPanelGestionApuestas();
				
				gui.mostrarMensaje("La apuesta de tipo " + tipoDeApuesta + " ha sido eliminada", "Apuesta Eliminada");
			}
		}
		
		///////////////////////////////////////// EVENTOS PANEL CREACIÓN APUESTA /////////////////////////////////////////
		
		else if (evento.getActionCommand().equals(gui.getPanelModificacionApuesta().VOLVER_AL_MENU_PRINCIPAL)) {
			
			gui.mostrarPanelMenuPrincipal();
			
		} else if (evento.getActionCommand().equals(gui.getPanelCreacionApuesta().VOLVER_A_GESTION_APUESTAS)) {
			
			gui.mostrarPanelGestionApuestas();
			
		} else if (evento.getActionCommand().equals(gui.getPanelCreacionApuesta().SELECCIONAR_TIPO_DE_APUESTA)) {
			
			if (gui.getPanelCreacionApuesta().getSeleccionTipoDeApuesta().getSelectedItem() != null) {
				// Obtener tipo de apuesta seleccionada del desplegable de opciones (JComboBox)
				String tipoDeApuestaSeleccionada = gui.getPanelCreacionApuesta().getSeleccionTipoDeApuesta().getSelectedItem().toString();
				gui.getPanelCreacionApuesta().getPanelApuestaBetPlay().agregarPartidos(
						casaDeApuestas.getGestorDeApuestas().getGestorApuestasBetPlay().getApuestaBetPlay().obtenerPartidos(casaDeApuestas.getGestorDeApuestas().getGestorApuestasBetPlay().getArchivo().leerEquipos()));
				// Mostrar el panel con la apuesta seleccionada por el usuario
				gui.getPanelCreacionApuesta().mostrarPanelApuesta(tipoDeApuestaSeleccionada);
			}
		} else if (evento.getActionCommand().equals(gui.getPanelCreacionApuesta().REALIZAR_APUESTA)) {
			
			/* Validar que se haya seleccionado la sede de la apuesta a crear del desplegable de opciones (JComboBox) 
			 * Si el indice seleccionado es cero quiere decir que la opción del JComboBox es la primera ("Seleccionar Sede:") */
			if (gui.getPanelCreacionApuesta().getSeleccionSede().getSelectedIndex() == 0) {
				gui.mostrarMensaje("La sede de la apuesta a crear no ha sido seleccionada", "Sede no seleccionada");
				return;
			}
			
			String nombreSedeApuesta = gui.getPanelCreacionApuesta().getSeleccionSede().getSelectedItem().toString();
			
			String cedulaApostador = gui.getPanelCreacionApuesta().getCampoCedulaApostador().getText();
			
			// Validar que la cédula del apostador que está realizando la apuesta haya sido ingresada
			if (cedulaApostador.isEmpty()) {
				gui.mostrarMensaje("La cédula del apostador no ha sido ingresada", "Cédula no ingresada");
				return;
			}
			
			// Revisar que la cedula del apostador contenga solo digitos (números) o puntos
			for (char c: cedulaApostador.toCharArray()) {
				if (!Character.isDigit(c) && c != '.') {
					gui.mostrarMensaje("La cédula del apostador debe contener únicamente números o puntos", "Dato inválido");
					return;
				}
			}
			
			int indiceApostador = casaDeApuestas.getGestorDeApostadores().obtenerIndiceApostador(cedulaApostador);
			
			// Validar que la cédula del apostador exista al ser leída del archivo apostadores.dat
			if (indiceApostador == -1) {
				gui.mostrarMensaje("La cédula del apostador no fue encontrada", "Cédula no encontrada");
				return;
			}
			
			
			/* Validar que se haya seleccionado el tipo de la apuesta a crear del desplegable de opciones (JComboBox) 
			 * Si el indice seleccionado es cero quiere decir que la opción del JComboBox es la primera ("Seleccionar Tipo:") */
			if (gui.getPanelCreacionApuesta().getSeleccionTipoDeApuesta().getSelectedIndex() == 0) {
				gui.mostrarMensaje("El tipo de la apuesta a crear no ha sido seleccionado", "Tipo de apuesta no seleccionado");
				return;
			}
			
			String tipoDeApuesta = gui.getPanelCreacionApuesta().getSeleccionTipoDeApuesta().getSelectedItem().toString();
			
			String fechaDeLaApuesta = casaDeApuestas.obtenerFechaActual();
			
			String valorApuestaIngresado = gui.getPanelCreacionApuesta().getCampoValorApuesta().getText();
			// Validar que el valor de la apuesta haya sido ingresado
			if (valorApuestaIngresado.isEmpty()) {
				gui.mostrarMensaje("El valor de la apuesta a crear no ha sido ingresado", "Valor de la apuesta no ingresado");
				return;
			}
			
			// Validar que se haya ingresado un número
			double valorApuesta = 0;
			try {
				valorApuesta = Double.parseDouble(valorApuestaIngresado);
			} catch (NumberFormatException e) {
				gui.mostrarMensaje("El valor de la apuesta no es válido", "Valor no válido");
				return;
			}
			
			// Actualizar la sede en la que el apostador actual está jugando
			casaDeApuestas.getGestorDeApostadores().modificarSedeActualApostador(indiceApostador, nombreSedeApuesta);
			
			switch (tipoDeApuesta) {
			
				case "Loteria":
					/* Validar que se haya seleccionado el nombre de la lotería del desplegable de opciones (JComboBox) 
					 * Si el indice seleccionado es cero quiere decir que la opción del JComboBox es la primera ("Seleccionar Lotería:") */
					if (gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getSeleccionLoteria().getSelectedIndex() == 0) {
						gui.mostrarMensaje("El nombre de la lotería no ha sido seleccionado", "Nombre no seleccionado");
						return;
					}
					
					// Obtener el nombre de la lotería seleccionado (EJ: "Lotería de Bogotá")
					String nombreLoteria = gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getSeleccionLoteria().getSelectedItem().toString();
					
					/* Validar que se haya seleccionado el nombre de la serie del desplegable de opciones (JComboBox) 
					 * Si el indice seleccionado es cero quiere decir que la opción del JComboBox es la primera ("Seleccionar Serie:") */
					if (gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getSeleccionSerie().getSelectedIndex() == 0) {
						gui.mostrarMensaje("La serie no ha sido seleccionada", "Serie no seleccionada");
						return;
					}
					
					int serieSeleccionada = Integer.parseInt(gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getSeleccionSerie().getSelectedItem().toString());
					
					int numeroLoteria = Integer.parseInt(gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getCampoNumeroLoteria().getText());
					
					// Agregar y registrar la apuesta de lotería en el archivo apuestas-loteria.dat
					casaDeApuestas.getGestorDeApuestas().agregarApuestaLoteria(tipoDeApuesta, nombreSedeApuesta, cedulaApostador, fechaDeLaApuesta, valorApuesta, nombreLoteria, numeroLoteria, serieSeleccionada);
					
					actualizarTablaApuestasPanelGestionApuestas();
					
					String nombreDelClienteApuestaLoteria = casaDeApuestas.getGestorDeApostadores().obtenerNombreApostador(cedulaApostador);
					
					gui.generarFacturaApuestaLoteria(nombreDelClienteApuestaLoteria, fechaDeLaApuesta, nombreLoteria, serieSeleccionada, numeroLoteria, valorApuesta);
					gui.mostrarPanelFacturaApuestas();
					break;
					
				case "SuperAstro":
					
					/* Validar que se hayan seleccionado los cuatro (4) números y el signo del zodiaco del desplegable de opciones (JComboBox) 
					 * Si el indice seleccionado es cero quiere decir que la opción del JComboBox es la primera ("Seleccionar ...:") */
					if (gui.getPanelCreacionApuesta().getPanelApuestaSuperAstro().getSeleccionNumero1().getSelectedIndex() == 0) {
						gui.mostrarMensaje("El número 1 no ha sido seleccionado", "Número no seleccionado");
						return;
					} else if (gui.getPanelCreacionApuesta().getPanelApuestaSuperAstro().getSeleccionNumero2().getSelectedIndex() == 0) {
						gui.mostrarMensaje("El número 2 no ha sido seleccionado", "Número no seleccionado");
						return;
					} else if (gui.getPanelCreacionApuesta().getPanelApuestaSuperAstro().getSeleccionNumero3().getSelectedIndex() == 0) {
						gui.mostrarMensaje("El número 3 no ha sido seleccionado", "Número no seleccionado");
						return;
					} else if (gui.getPanelCreacionApuesta().getPanelApuestaSuperAstro().getSeleccionNumero4().getSelectedIndex() == 0) {
						gui.mostrarMensaje("El número 4 no ha sido seleccionado", "Número no seleccionado");
						return;
					} else if (gui.getPanelCreacionApuesta().getPanelApuestaSuperAstro().getSeleccionSignoDelZodiaco().getSelectedIndex() == 0) {
						gui.mostrarMensaje("El signo del zodiaco no ha sido seleccionado", "Signo del Zodiaco no seleccionado");
						return;
					}
					
					int[] numerosSeleccionados = new int[4];
					
					numerosSeleccionados[0] = Integer.parseInt(gui.getPanelCreacionApuesta().getPanelApuestaSuperAstro().getSeleccionNumero1().getSelectedItem().toString());
					numerosSeleccionados[1] = Integer.parseInt(gui.getPanelCreacionApuesta().getPanelApuestaSuperAstro().getSeleccionNumero2().getSelectedItem().toString());
					numerosSeleccionados[2] = Integer.parseInt(gui.getPanelCreacionApuesta().getPanelApuestaSuperAstro().getSeleccionNumero3().getSelectedItem().toString());
					numerosSeleccionados[3] = Integer.parseInt(gui.getPanelCreacionApuesta().getPanelApuestaSuperAstro().getSeleccionNumero4().getSelectedItem().toString());
					
					String signoDelZodiaco = gui.getPanelCreacionApuesta().getPanelApuestaSuperAstro().getSeleccionSignoDelZodiaco().getSelectedItem().toString();
					
					// Crear la apuesta de superAstro
					casaDeApuestas.getGestorDeApuestas().agregarApuestaSuperAstro(nombreSedeApuesta, cedulaApostador, fechaDeLaApuesta, valorApuesta, numerosSeleccionados, signoDelZodiaco);
					
					actualizarTablaApuestasPanelGestionApuestas();
					
					String nombreDelClienteApuestaSuperAstro = casaDeApuestas.getGestorDeApostadores().obtenerNombreApostador(cedulaApostador);
					
					gui.generarFacturaApuestaSuperAstro(nombreDelClienteApuestaSuperAstro, fechaDeLaApuesta, numerosSeleccionados, signoDelZodiaco, valorApuesta);
					gui.mostrarPanelFacturaApuestas();
					break;
					
				case "Baloto":
					
					int[] numerosSeleccionadosBaloto = new int[6];
					
					// Validar que se haya ingresado el número 1
					String numero1IngresadoBaloto = gui.getPanelCreacionApuesta().getPanelApuestaBaloto().getCampoNumero1().getText();
					if (numero1IngresadoBaloto.isEmpty()) {
						gui.mostrarMensaje("El número 1 no ha sido ingresado", "Número no ingresado");
						return;
					}
					
					// Validar que el número 1 ingresado sea un entero y convertirlo a entero
					try {
						numerosSeleccionadosBaloto[0] = Integer.parseInt(numero1IngresadoBaloto);
					} catch (NumberFormatException e) {
						gui.mostrarMensaje("El número 1 no es válido", "Número no válido");
						return;
					}
					
					// Validar que el número 1 esté en el rango entre 1 y 45
					if (numerosSeleccionadosBaloto[0] < 1 || numerosSeleccionadosBaloto[0] > 45) {
						gui.mostrarMensaje("El número 1 debe estar en el rango de 1 a 45", "Rango inválido");
						return;
					}
					
					// Validar que se haya ingresado el número 2
					String numero2IngresadoBaloto = gui.getPanelCreacionApuesta().getPanelApuestaBaloto().getCampoNumero2().getText();
					if (numero2IngresadoBaloto.isEmpty()) {
						gui.mostrarMensaje("El número 2 no ha sido ingresado", "Número no ingresado");
						return;
					}
					
					// Validar que el número 2 ingresado sea un entero y convertirlo a entero
					try {
						numerosSeleccionadosBaloto[1] = Integer.parseInt(numero2IngresadoBaloto);
					} catch (NumberFormatException e) {
						gui.mostrarMensaje("El número 2 no es válido", "Número no válido");
						return;
					}
					
					// Validar que el número 2 esté en el rango entre 1 y 45
					if (numerosSeleccionadosBaloto[1] < 1 || numerosSeleccionadosBaloto[1] > 45) {
						gui.mostrarMensaje("El número 2 debe estar en el rango de 1 a 45", "Rango inválido");
						return;
					}
					
					// Validar que se haya ingresado el número 3
					String numero3IngresadoBaloto = gui.getPanelCreacionApuesta().getPanelApuestaBaloto().getCampoNumero3().getText();
					if (numero3IngresadoBaloto.isEmpty()) {
						gui.mostrarMensaje("El número 3 no ha sido ingresado", "Número no ingresado");
						return;
					}
					
					// Validar que el número 3 ingresado sea un entero y convertirlo a entero
					try {
						numerosSeleccionadosBaloto[2] = Integer.parseInt(numero3IngresadoBaloto);
					} catch (NumberFormatException e) {
						gui.mostrarMensaje("El número 3 no es válido", "Número no válido");
						return;
					}
					
					// Validar que el número 3 esté en el rango entre 1 y 45
					if (numerosSeleccionadosBaloto[2] < 1 || numerosSeleccionadosBaloto[2] > 45) {
						gui.mostrarMensaje("El número 3 debe estar en el rango de 1 a 45", "Rango inválido");
						return;
					}
					
					// Validar que se haya ingresado el número 4
					String numero4IngresadoBaloto = gui.getPanelCreacionApuesta().getPanelApuestaBaloto().getCampoNumero4().getText();
					if (numero4IngresadoBaloto.isEmpty()) {
						gui.mostrarMensaje("El número 4 no ha sido ingresado", "Número no ingresado");
						return;
					}
					
					// Validar que el número 4 ingresado sea un entero y convertirlo a entero
					try {
						numerosSeleccionadosBaloto[3] = Integer.parseInt(numero4IngresadoBaloto);
					} catch (NumberFormatException e) {
						gui.mostrarMensaje("El número 4 no es válido", "Número no válido");
						return;
					}
					
					// Validar que el número 4 esté en el rango entre 1 y 45
					if (numerosSeleccionadosBaloto[3] < 1 || numerosSeleccionadosBaloto[3] > 45) {
						gui.mostrarMensaje("El número 4 debe estar en el rango de 1 a 45", "Rango inválido");
						return;
					}
					
					
					// Validar que se haya ingresado el número 5
					String numero5IngresadoBaloto = gui.getPanelCreacionApuesta().getPanelApuestaBaloto().getCampoNumero5().getText();
					if (numero5IngresadoBaloto.isEmpty()) {
						gui.mostrarMensaje("El número 5 no ha sido ingresado", "Número no ingresado");
						return;
					}
					
					// Validar que el número 5 ingresado sea un entero y convertirlo a entero
					try {
						numerosSeleccionadosBaloto[4] = Integer.parseInt(numero5IngresadoBaloto);
					} catch (NumberFormatException e) {
						gui.mostrarMensaje("El número 5 no es válido", "Número no válido");
						return;
					}
					
					// Validar que el número 5 esté en el rango entre 1 y 45
					if (numerosSeleccionadosBaloto[4] < 1 || numerosSeleccionadosBaloto[4] > 45) {
						gui.mostrarMensaje("El número 5 debe estar en el rango de 1 a 45", "Rango inválido");
						return;
					}
					
					
					// Validar que se haya ingresado el número 6
					String numero6IngresadoBaloto = gui.getPanelCreacionApuesta().getPanelApuestaBaloto().getCampoNumero6().getText();
					if (numero6IngresadoBaloto.isEmpty()) {
						gui.mostrarMensaje("El número 6 no ha sido ingresado", "Número no ingresado");
						return;
					}
					
					// Validar que el número 6 ingresado sea un entero y convertirlo a entero
					try {
						numerosSeleccionadosBaloto[5] = Integer.parseInt(numero6IngresadoBaloto);
					} catch (NumberFormatException e) {
						gui.mostrarMensaje("El número 6 no es válido", "Número no válido");
						return;
					}
					
					// Validar que el número 6 esté en el rango entre 1 y 45
					if (numerosSeleccionadosBaloto[5] < 1 || numerosSeleccionadosBaloto[5] > 45) {
						gui.mostrarMensaje("El número 6 debe estar en el rango de 1 a 45", "Rango inválido");
						return;
					}
					
					// Validar que los números ingresados no se repitan
					for (int i = 0; i < numerosSeleccionadosBaloto.length; i++) {
						for (int j = 0; j < numerosSeleccionadosBaloto.length; j++) {
							if (numerosSeleccionadosBaloto[i] == numerosSeleccionadosBaloto[j] && i != j) {
								gui.mostrarMensaje("Los números no pueden repetirse.\nNúmeros " + (i + 1) + " y " + (j + 1) + " repetidos.", "Números repetidos");
								return;
							}
						}
					}
					
					casaDeApuestas.getGestorDeApuestas().agregarApuestaBaloto(nombreSedeApuesta, cedulaApostador, fechaDeLaApuesta, valorApuesta, numerosSeleccionadosBaloto);
					
					actualizarTablaApuestasPanelGestionApuestas();
					
					String nombreDelClienteApuestaBaloto = casaDeApuestas.getGestorDeApostadores().obtenerNombreApostador(cedulaApostador);
					
					gui.generarFacturaApuestaBaloto(nombreDelClienteApuestaBaloto, fechaDeLaApuesta, numerosSeleccionadosBaloto, valorApuesta);
					gui.mostrarPanelFacturaApuestas();
					break;
				case "BetPlay":
					
					// Validar que en todos los partidos se haya escogido si gana el equipo 1, el equipo 2 o hay empate
					
					if (gui.getPanelCreacionApuesta().getPanelApuestaBetPlay().apuestaCompleta()) {
						
						String[][] apuestasYResultadosEscogidos = gui.getPanelCreacionApuesta().getPanelApuestaBetPlay().obtenerPartidosYResultadosEscogidos();
						
						casaDeApuestas.getGestorDeApuestas().agregarApuestaBetPlay(nombreSedeApuesta, cedulaApostador, fechaDeLaApuesta, valorApuesta, apuestasYResultadosEscogidos);
						
						actualizarTablaApuestasPanelGestionApuestas();
						
						String nombreDelClienteApuestaBetPlay = casaDeApuestas.getGestorDeApostadores().obtenerNombreApostador(cedulaApostador);
						
						gui.generarFacturaApuestaBetPlay(nombreDelClienteApuestaBetPlay, fechaDeLaApuesta, apuestasYResultadosEscogidos, valorApuesta);
						gui.mostrarPanelFacturaApuestas();
						
					} else {
						gui.mostrarMensaje("Revisar que para cada partido se haya seleccionado una opción", "Apuesta no completada");
					}
					
					break;
				case "Chance":
					
					/* Validar que se haya seleccionado el nombre de la lotería del desplegable de opciones (JComboBox) 
					 * Si el indice seleccionado es cero quiere decir que la opción del JComboBox es la primera ("Seleccionar Lotería:") */
					if (gui.getPanelCreacionApuesta().getPanelApuestaChance().getSeleccionLoteria().getSelectedIndex() == 0) {
						gui.mostrarMensaje("El nombre de la lotería no ha sido seleccionado", "Nombre no seleccionado");
						return;
					}
					
					// Obtener el nombre de lotería seleccionado (EJ: "Lotería de Bogotá")
					String nombreLoteriaChance = gui.getPanelCreacionApuesta().getPanelApuestaChance().getSeleccionLoteria().getSelectedItem().toString();
					
					// Obtener los números de chance
					
					int[] numerosSeleccionadosChance = new int[4];
					
					// Validar que se haya ingresado el número 1
					String numero1IngresadoChance = gui.getPanelCreacionApuesta().getPanelApuestaChance().getCampoNumero1().getText();
					if (numero1IngresadoChance.isEmpty()) {
						gui.mostrarMensaje("El número 1 no ha sido ingresado", "Número no ingresado");
						return;
					}
					
					// Validar que el número 1 ingresado sea un entero y convertirlo a entero
					try {
						numerosSeleccionadosChance[0] = Integer.parseInt(numero1IngresadoChance);
					} catch (NumberFormatException e) {
						gui.mostrarMensaje("El número 1 no es válido", "Número no válido");
						return;
					}
					
					// Validar que el número 1 ingresado esté en el rango de 0-9
					if (numerosSeleccionadosChance[0] < 0 || numerosSeleccionadosChance[0] > 9) {
						gui.mostrarMensaje("El número 1 debe estar en el rango de 0 - 9", "Rango inválido");
						return;
					}
					
					
					// Validar que se haya ingresado el número 2
					String numero2IngresadoChance = gui.getPanelCreacionApuesta().getPanelApuestaChance().getCampoNumero2().getText();
					if (numero2IngresadoChance.isEmpty()) {
						gui.mostrarMensaje("El número 2 no ha sido ingresado", "Número no ingresado");
						return;
					}
					
					// Validar que el número 2 ingresado sea un entero y convertirlo a entero
					try {
						numerosSeleccionadosChance[1] = Integer.parseInt(numero2IngresadoChance);
					} catch (NumberFormatException e) {
						gui.mostrarMensaje("El número 2 no es válido", "Número no válido");
						return;
					}
					
					// Validar que el número 2 ingresado esté en el rango de 0-9
					if (numerosSeleccionadosChance[1] < 0 || numerosSeleccionadosChance[1] > 9) {
						gui.mostrarMensaje("El número 2 debe estar en el rango de 0 - 9", "Rango inválido");
						return;
					}
					
					
					// Validar que se haya ingresado el número 3
					String numero3IngresadoChance = gui.getPanelCreacionApuesta().getPanelApuestaChance().getCampoNumero3().getText();
					if (numero3IngresadoChance.isEmpty()) {
						gui.mostrarMensaje("El número 3 no ha sido ingresado", "Número no ingresado");
						return;
					}
					
					// Validar que el número 3 ingresado sea un entero y convertirlo a entero
					try {
						numerosSeleccionadosChance[2] = Integer.parseInt(numero3IngresadoChance);
					} catch (NumberFormatException e) {
						gui.mostrarMensaje("El número 3 no es válido", "Número no válido");
						return;
					}
					
					// Validar que el número 3 ingresado esté en el rango de 0-9
					if (numerosSeleccionadosChance[2] < 0 || numerosSeleccionadosChance[2] > 9) {
						gui.mostrarMensaje("El número 3 debe estar en el rango de 0 - 9", "Rango inválido");
						return;
					}
					
					
					// Validar que se haya ingresado el número 4
					String numero4IngresadoChance = gui.getPanelCreacionApuesta().getPanelApuestaChance().getCampoNumero4().getText();
					if (numero4IngresadoChance.isEmpty()) {
						gui.mostrarMensaje("El número 4 no ha sido ingresado", "Número no ingresado");
						return;
					}
					
					// Validar que el número 4 ingresado sea un entero y convertirlo a entero
					try {
						numerosSeleccionadosChance[3] = Integer.parseInt(numero4IngresadoChance);
					} catch (NumberFormatException e) {
						gui.mostrarMensaje("El número 4 no es válido", "Número no válido");
						return;
					}
					
					
					// Validar que el número 4 ingresado esté en el rango de 0-9
					if (numerosSeleccionadosChance[3] < 0 || numerosSeleccionadosChance[3] > 9) {
						gui.mostrarMensaje("El número 4 debe estar en el rango de 0 - 9", "Rango inválido");
						return;
					}
					
					
					// Agregar y registrar la apuesta de chance en el archivo apuestas-chance.dat
					casaDeApuestas.getGestorDeApuestas().agregarApuestaChance(nombreSedeApuesta, cedulaApostador, fechaDeLaApuesta, valorApuesta, nombreLoteriaChance, numerosSeleccionadosChance);
				
					actualizarTablaApuestasPanelGestionApuestas();
					
					String nombreDelClienteApuestaChance = casaDeApuestas.getGestorDeApostadores().obtenerNombreApostador(cedulaApostador);
					
					gui.generarFacturaApuestaChance(nombreDelClienteApuestaChance, fechaDeLaApuesta, nombreLoteriaChance, numerosSeleccionadosChance, valorApuesta);
					gui.mostrarPanelFacturaApuestas();
					break;
			
			}
			
		}
		
		///////////////////////////////////////// EVENTOS PANEL CREACIÓN APUESTA -> PANEL APUESTA CHANCE /////////////////////////////////////////
		else if (evento.getActionCommand().equals(gui.getPanelCreacionApuesta().getPanelApuestaChance().SELECCIONAR_CHANCE_MANUAL)) {
			
			// Fija el cursor en el primer número
			gui.getPanelCreacionApuesta().getPanelApuestaChance().getCampoNumero1().requestFocus();
			gui.habilitarCamposNumerosChance();
			
		} else if (evento.getActionCommand().equals(gui.getPanelCreacionApuesta().getPanelApuestaChance().SELECCIONAR_CHANCE_AUTOMATICO)) {
			
			gui.desplegarNumerosChance(casaDeApuestas.obtenerNumerosChance());
			gui.deshabilitarCamposNumerosChance();
			
		}
		
		
		///////////////////////////////////////// EVENTOS PANEL MODIFICACIÓN APUESTA /////////////////////////////////////////
		
		else if (evento.getActionCommand().equals(gui.getPanelModificacionApuesta().VOLVER_AL_MENU_PRINCIPAL)) {
			
			gui.mostrarPanelMenuPrincipal();
			
		} else if (evento.getActionCommand().equals(gui.getPanelModificacionApuesta().VOLVER_A_GESTION_APUESTAS)) {
			
			gui.mostrarPanelGestionApuestas();
			
		} else if (evento.getActionCommand().equals(gui.getPanelModificacionApuesta().MODIFICAR_APUESTA)) {
			
			// Obtener todos los datos de la apuesta a modificar
			String tipoDeApuesta = gui.getPanelModificacionApuesta().getCampoTipoDeApuesta().getText();
			
			/* Validar que se haya seleccionado el nombre de la sede a modificar del desplegable de opciones (JComboBox) 
			 * Si el indice seleccionado es cero quiere decir que la opción del JComboBox es la primera ("Seleccionar Sede:") */
			if (gui.getPanelModificacionApuesta().getSeleccionSede().getSelectedIndex() == 0) {
				gui.mostrarMensaje("La sede a modificar no ha sido seleccionada", "Sede no seleccionada");
				return;
			}
			
			String nombreSede = gui.getPanelModificacionApuesta().getSeleccionSede().getSelectedItem().toString();
			String cedulaApostador = gui.getPanelModificacionApuesta().getCampoCedulaApostador().getText().toString();
			
			// Validar que el valor de la apuesta a modificar haya sido seleccionado
			String valorApuestaIngresado = gui.getPanelModificacionApuesta().getCampoValorApuesta().getText();
			if (valorApuestaIngresado.isEmpty()) {
				gui.mostrarMensaje("El valor de la apuesta a modificar no ha sido ingresado", "Valor no ingresado");
				return;
			}
			
			int filaSeleccionadaTablaApuestas = gui.getPanelGestionApuestas().getTablaApuestas().getSelectedRow();
			
			String fechaActualApuesta = gui.getPanelGestionApuestas().getTablaApuestas().getValueAt(filaSeleccionadaTablaApuestas, 3).toString();
			
			String fechaModificadaApuesta = casaDeApuestas.obtenerFechaActual();
			
			// Manejar la excepción al convertir el valor de la apuesta ingresado a decimal y validar que sea un número
			double valorApuesta;
			try {
				valorApuesta = Double.parseDouble(valorApuestaIngresado);
			} catch (NumberFormatException e) {
				gui.mostrarMensaje("El valor de la apuesta a modificar no es válido", "Valor no válido");
				return;
			}
			
			if (valorApuesta <= 0) {
				gui.mostrarMensaje("El valor de la apuesta debe ser mayor que 0", "Valor no válido");
				return;
			}
			
			switch (tipoDeApuesta) {
			
				case "Loteria":
					String nombreLoteria = gui.getPanelModificacionApuesta().getPanelInformacionApuestaLoteria().getCampoLoteria().getText();
					int numeroLoteria = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaLoteria().getCampoNumero().getText());
					int serie = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaLoteria().getCampoSerie().getText());

					int indiceApuestaLoteria = casaDeApuestas.getGestorDeApuestas().getGestorApuestasLoteria().obtenerIndiceApuesta(cedulaApostador, fechaActualApuesta);
					
					// Verificar si la sede y el valor de la apuesta a modificar son los mismos
					boolean mismaSedeLoteria = nombreSede.equals(casaDeApuestas.getGestorDeApuestas().getGestorApuestasLoteria().getApuestasLoteria().get(indiceApuestaLoteria).getNombreSede());
					boolean mismoValorApuestaLoteria = valorApuesta == casaDeApuestas.getGestorDeApuestas().getGestorApuestasLoteria().getApuestasLoteria().get(indiceApuestaLoteria).getValor();
					if (mismaSedeLoteria && mismoValorApuestaLoteria) {
						gui.mostrarMensaje("La apuesta de lotería a modificar no ha sido cambiada.", "Apuesta no modificada");
						return;
					}
					
					casaDeApuestas.getGestorDeApuestas().modificarApuestaLoteria(indiceApuestaLoteria, tipoDeApuesta, nombreSede, cedulaApostador, fechaModificadaApuesta, valorApuesta, nombreLoteria, numeroLoteria, serie);
					
					actualizarTablaApuestasPanelGestionApuestas();
					
					// Redirigir al usuario al panel gestión apuestas
					gui.mostrarPanelGestionApuestas();
					
					gui.mostrarMensaje("La apuesta de lotería ha sido modificada exitosamente", "Apuesta de lotería modificada");
					break;
					
				case "SuperAstro":
					
					int[] numerosSuperAstro = new int[4];
					numerosSuperAstro[0] = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaSuperAstro().getCampoNumero1().getText());
					numerosSuperAstro[1] = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaSuperAstro().getCampoNumero2().getText());
					numerosSuperAstro[2] = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaSuperAstro().getCampoNumero3().getText());
					numerosSuperAstro[3] = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaSuperAstro().getCampoNumero4().getText());
					
					String signoDelZodiaco = gui.getPanelModificacionApuesta().getPanelInformacionApuestaSuperAstro().getCampoSignoDelZodiaco().getText();
					
					int indiceApuestaSuperAstro = casaDeApuestas.getGestorDeApuestas().getGestorApuestasSuperAstro().obtenerIndiceApuesta(cedulaApostador, fechaActualApuesta);
					
					// Verificar si la sede y el valor de la apuesta a modificar son los mismos
					boolean mismaSedeSuperAstro = nombreSede.equals(casaDeApuestas.getGestorDeApuestas().getGestorApuestasSuperAstro().getApuestasSuperAstro().get(indiceApuestaSuperAstro).getNombreSede());
					boolean mismoValorApuestaSuperAstro = valorApuesta == casaDeApuestas.getGestorDeApuestas().getGestorApuestasSuperAstro().getApuestasSuperAstro().get(indiceApuestaSuperAstro).getValor();
					if (mismaSedeSuperAstro && mismoValorApuestaSuperAstro) {
						gui.mostrarMensaje("La apuesta de superAstro a modificar no ha sido cambiada.", "Apuesta no modificada");
						return;
					}
					
					casaDeApuestas.getGestorDeApuestas().modificarApuestaSuperAstro(indiceApuestaSuperAstro, nombreSede, cedulaApostador, fechaModificadaApuesta, valorApuesta, numerosSuperAstro, signoDelZodiaco);
					
					actualizarTablaApuestasPanelGestionApuestas();
					
					// Redirigir al usuario al panel gestión apuestas
					gui.mostrarPanelGestionApuestas();
					
					gui.mostrarMensaje("La apuesta de superAstro ha sido modificada exitosamente", "Apuesta de superAstro modificada");
					
					break;
					
				case "Baloto":
					
					int[] numerosBaloto = new int[6];
					numerosBaloto[0] = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaBaloto().getCampoNumero1().getText());
					numerosBaloto[1] = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaBaloto().getCampoNumero2().getText());
					numerosBaloto[2] = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaBaloto().getCampoNumero3().getText());
					numerosBaloto[3] = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaBaloto().getCampoNumero4().getText());
					numerosBaloto[4] = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaBaloto().getCampoNumero5().getText());
					numerosBaloto[5] = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaBaloto().getCampoNumero6().getText());
					
					int indiceApuestaBaloto = casaDeApuestas.getGestorDeApuestas().getGestorApuestasBaloto().obtenerIndiceApuesta(cedulaApostador, fechaActualApuesta);
					
					// Verificar si la sede y el valor de la apuesta a modificar son los mismos
					boolean mismaSedeBaloto = nombreSede.equals(casaDeApuestas.getGestorDeApuestas().getGestorApuestasBaloto().getApuestasBaloto().get(indiceApuestaBaloto).getNombreSede());
					boolean mismoValorApuestaBaloto = valorApuesta == casaDeApuestas.getGestorDeApuestas().getGestorApuestasBaloto().getApuestasBaloto().get(indiceApuestaBaloto).getValor();
					if (mismaSedeBaloto && mismoValorApuestaBaloto) {
						gui.mostrarMensaje("La apuesta de baloto a modificar no ha sido cambiada.", "Apuesta no modificada");
						return;
					}
					
					casaDeApuestas.getGestorDeApuestas().modificarApuestaBaloto(indiceApuestaBaloto, nombreSede, cedulaApostador, fechaModificadaApuesta, valorApuesta, numerosBaloto);
					
					actualizarTablaApuestasPanelGestionApuestas();
					
					// Redirigir al usuario al panel gestión apuestas
					gui.mostrarPanelGestionApuestas();
					
					gui.mostrarMensaje("La apuesta de baloto ha sido modificada exitosamente", "Apuesta de baloto modificada");
					
					break;
				case "BetPlay":
					
					String[][] partidosYResultadosEscogidos = gui.getPanelModificacionApuesta().getPanelInformacionApuestaBetPlay().obtenerPartidosYResultadosEscogidos();
					
					int indiceApuestaBetPlay = casaDeApuestas.getGestorDeApuestas().getGestorApuestasBetPlay().obtenerIndiceApuesta(cedulaApostador, fechaActualApuesta);
					
					// Verificar si la sede y el valor de la apuesta a modificar son los mismos
					boolean mismaSedeBetPlay = nombreSede.equals(casaDeApuestas.getGestorDeApuestas().getGestorApuestasBetPlay().getApuestasBetPlay().get(indiceApuestaBetPlay).getNombreSede());
					boolean mismoValorApuestaBetPlay = valorApuesta == casaDeApuestas.getGestorDeApuestas().getGestorApuestasBetPlay().getApuestasBetPlay().get(indiceApuestaBetPlay).getValor();
					if (mismaSedeBetPlay && mismoValorApuestaBetPlay) {
						gui.mostrarMensaje("La apuesta de betplay a modificar no ha sido cambiada.", "Apuesta no modificada");
						return;
					}
					
					casaDeApuestas.getGestorDeApuestas().modificarApuestaBetPlay(indiceApuestaBetPlay, nombreSede, cedulaApostador, fechaModificadaApuesta, valorApuesta, partidosYResultadosEscogidos);
					
					actualizarTablaApuestasPanelGestionApuestas();
					
					// Redirigir al usuario al panel gestión apuestas
					gui.mostrarPanelGestionApuestas();
					
					gui.mostrarMensaje("La apuesta de betplay ha sido modificada exitosamente", "Apuesta de betplay modificada");
					
					break; 
				case "Chance":
					
					String nombreLoteriaChance = gui.getPanelModificacionApuesta().getPanelInformacionApuestaChance().getCampoNombreLoteria().getText();
					
					int[] numerosChance = new int[4];
					numerosChance[0] = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaChance().getCampoNumero1().getText());
					numerosChance[1] = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaChance().getCampoNumero2().getText());
					numerosChance[2] = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaChance().getCampoNumero3().getText());
					numerosChance[3] = Integer.parseInt(gui.getPanelModificacionApuesta().getPanelInformacionApuestaChance().getCampoNumero4().getText());
					
					int indiceApuestaChance = casaDeApuestas.getGestorDeApuestas().getGestorApuestasChance().obtenerIndiceApuesta(cedulaApostador, fechaActualApuesta);
					
					// Verificar si la sede y el valor de la apuesta a modificar son los mismos
					boolean mismaSedeChance = nombreSede.equals(casaDeApuestas.getGestorDeApuestas().getGestorApuestasChance().getApuestasChance().get(indiceApuestaChance).getNombreSede());
					boolean mismoValorApuestaChance = valorApuesta == casaDeApuestas.getGestorDeApuestas().getGestorApuestasChance().getApuestasChance().get(indiceApuestaChance).getValor();
					if (mismaSedeChance && mismoValorApuestaChance) {
						gui.mostrarMensaje("La apuesta de chance a modificar no ha sido cambiada.", "Apuesta no modificada");
						return;
					}
					
					casaDeApuestas.getGestorDeApuestas().modificarApuestaChance(indiceApuestaChance, nombreSede, cedulaApostador, fechaModificadaApuesta, valorApuesta, nombreLoteriaChance, numerosChance);
					
					actualizarTablaApuestasPanelGestionApuestas();
					
					// Redirigir al usuario al panel gestión apuestas
					gui.mostrarPanelGestionApuestas();
					
					gui.mostrarMensaje("La apuesta de chance ha sido modificada exitosamente", "Apuesta de chance modificada");
					
					break;
		
			}
			
		}
		
		///////////////////////////////////////// EVENTOS PANEL CREACIÓN APUESTA DE LOTERIA /////////////////////////////////////////
		
		else if (evento.getActionCommand().equals(gui.getPanelCreacionApuesta().getPanelApuestaLoteria().SELECCIONAR_SERIE)) {
			
			// Validar que se haya seleccionado una serie y que el panel creación apuesta se esté mostrando
			if (gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getSeleccionSerie().getSelectedIndex() != 0 && gui.getPanelCreacionApuesta().isShowing()) {
				int serieSeleccionada = Integer.parseInt(gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getSeleccionSerie().getSelectedItem().toString());
				
				// Obtener todas la series del desplegable de opciones (JComboBox)
				int serie1 = Integer.parseInt(gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getSeleccionSerie().getItemAt(1).toString());
				int serie2 = Integer.parseInt(gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getSeleccionSerie().getItemAt(2).toString());
				int serie3 = Integer.parseInt(gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getSeleccionSerie().getItemAt(3).toString());
				int serie4 = Integer.parseInt(gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getSeleccionSerie().getItemAt(4).toString());
				
				if (serieSeleccionada == serie1) {
					
					// Generar un número en el rango 0001 - 2499
					int numeroSerie1 = casaDeApuestas.generarNumeroLoteriaSerie1();
					// Agregar ceros a la izquierda al número con hasta 4 cifras
					String numeroFormateado1 = String.format("%04d", numeroSerie1);
					gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getCampoNumeroLoteria().setText(numeroFormateado1);
					
				} else if (serieSeleccionada == serie2) {
					
					// Generar un número en el rango 2500 - 5000 
					int numeroSerie2 = casaDeApuestas.generarNumeroLoteriaSerie2();
					// Agregar ceros a la izquierda al número con hasta 4 cifras
					String numeroFormateado2 = String.format("%04d", numeroSerie2);
					gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getCampoNumeroLoteria().setText(numeroFormateado2);
					
				} else if (serieSeleccionada == serie3) {
					
					// Generar un número en el rango 5000 - 7500
					int numeroSerie3 = casaDeApuestas.generarNumeroLoteriaSerie3();
					// Agregar ceros a la izquierda al número con hasta 4 cifras 
					String numeroFormateado3 = String.format("%04d", numeroSerie3);
					gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getCampoNumeroLoteria().setText(numeroFormateado3);
				
				} else if (serieSeleccionada == serie4) {
					
					// Generar un número en el rango 7500 - 9999 
					int numeroSerie4 = casaDeApuestas.generarNumeroLoteriaSerie4();
					// Agregar ceros a la izquierda al número con hasta 4 cifras
					String numeroFormateado4 = String.format("%04d", numeroSerie4);
					gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getCampoNumeroLoteria().setText(numeroFormateado4);
				
				}
			} else {
				gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getCampoNumeroLoteria().setText("");
			}
		}
		
		///////////////////////////////////////// EVENTOS PANEL REALIZACIÓN CONSULTAS /////////////////////////////////////////
		
		else if (evento.getActionCommand().equals(gui.getPanelRealizacionConsultas().VOLVER_AL_MENU_PRINCIPAL)) {
			
			gui.mostrarPanelMenuPrincipal();
			
		} else if (evento.getActionCommand().equals(gui.getPanelRealizacionConsultas().MOSTRAR_CLIENTES_POR_SEDE)) {
			
			gui.getPanelRealizacionConsultas().mostrarPanelClientesPorSede();
			
		} else if (evento.getActionCommand().equals(gui.getPanelRealizacionConsultas().MOSTRAR_VALOR_TOTAL_APUESTAS)) {
			
			gui.getPanelRealizacionConsultas().getPanelValorTotalApuestas().mostrarLabelCedulaSinIngresar();
			gui.getPanelRealizacionConsultas().mostrarPanelValorTotalApuestas();
			
		} else if (evento.getActionCommand().equals(gui.getPanelRealizacionConsultas().MOSTRAR_APUESTAS_REALIZADAS)) {
			
			gui.getPanelRealizacionConsultas().getPanelDetalleApuestasRealizadas().agregarSedes(casaDeApuestas.getGestorDeSedes().obtenerSedesActuales());
			gui.getPanelRealizacionConsultas().mostrarPanelDetalleApuestasRealizadas();
			
		} else if (evento.getActionCommand().equals(gui.getPanelRealizacionConsultas().MOSTRAR_TOTAL_DE_APUESTAS)) {
			
			gui.getPanelRealizacionConsultas().getPanelTotalApuestas().agregarSedes(casaDeApuestas.getGestorDeSedes().obtenerSedesActuales());
			gui.getPanelRealizacionConsultas().getPanelTotalApuestas().agregarTiposDeJuegos(casaDeApuestas.getGestorDeJuegos().obtenerTiposDeJuegosActuales());
			gui.getPanelRealizacionConsultas().mostrarPanelTotalApuestas();
			
		}
		
		///////////////////////////////////////// EVENTOS PANEL REALIZACIÓN CONSULTAS -> PANEL CLIENTES POR SEDE /////////////////////////////////////////
		
		else if (evento.getActionCommand().equals(gui.getPanelRealizacionConsultas().getPanelClientesPorSede().SELECCIONAR_SEDE)) {
			
			// Revisar que el seleccionable no sea nulo
			if (gui.getPanelRealizacionConsultas().getPanelClientesPorSede().getSeleccionSede().getSelectedItem() == null)
				return;
			
			// Revisar si no se ha seleccionado ninguna sede
			if (gui.getPanelRealizacionConsultas().getPanelClientesPorSede().getSeleccionSede().getSelectedIndex() == 0) {
				gui.getPanelRealizacionConsultas().getPanelClientesPorSede().mostrarLabelSedeSinSeleccionar();
				return;
			}
			
			// Revisar si de la sede seleccionada aún no hay clientes
			String sedeSeleccionada = gui.getPanelRealizacionConsultas().getPanelClientesPorSede().getSeleccionSede().getSelectedItem().toString();
			
			if (casaDeApuestas.getGestorDeApostadores().obtenerClientesPorSede(sedeSeleccionada).size() == 0) {
				gui.getPanelRealizacionConsultas().getPanelClientesPorSede().mostrarLabelSedeSinClientes();
				return;
			}
			
			// Actualizar la tabla de clientes por sede con los clientes obtenidos
			actualizarTablaClientesPorSede(sedeSeleccionada);
			
			gui.getPanelRealizacionConsultas().getPanelClientesPorSede().mostrarTablaClientesPorSede();
			
		}
		
		///////////////////////////////////////// EVENTOS PANEL REALIZACIÓN CONSULTAS -> PANEL VALOR TOTAL APUESTAS /////////////////////////////////////////
		
		else if (evento.getActionCommand().equals(gui.getPanelRealizacionConsultas().getPanelValorTotalApuestas().CONSULTAR)) {
			
			String cedula = gui.getPanelRealizacionConsultas().getPanelValorTotalApuestas().getCampoCedula().getText();
			
			if (casaDeApuestas.getGestorDeApostadores().obtenerIndiceApostador(cedula) == -1) {
				gui.getPanelRealizacionConsultas().getPanelValorTotalApuestas().mostrarLabelClienteSinEncontrar();
				return;
			}
			
			gui.getPanelRealizacionConsultas().getPanelValorTotalApuestas().agregarApuestasPorCliente(casaDeApuestas.getGestorDeApuestas().obtenerApuestasPorCliente(cedula));
			gui.getPanelRealizacionConsultas().getPanelValorTotalApuestas().agregarTotalApuestasPorCliente();
			gui.getPanelRealizacionConsultas().getPanelValorTotalApuestas().mostrarSeccionValorTotalApuestasPorCliente();
			
		}
		
		///////////////////////////////////////// EVENTOS PANEL REALIZACIÓN CONSULTAS -> PANEL TOTAL APUESTAS /////////////////////////////////////////
		
		else if (evento.getActionCommand().equals(gui.getPanelRealizacionConsultas().getPanelTotalApuestas().SELECCIONAR_SEDE)) {
			
			// Revisar que el seleccionable no sea nulo
			if (gui.getPanelRealizacionConsultas().getPanelTotalApuestas().getSeleccionSede().getSelectedItem() == null)
				return;
			
			// Revisar si la primera opción está seleccionada
			if (gui.getPanelRealizacionConsultas().getPanelTotalApuestas().getSeleccionSede().getSelectedIndex() == 0) {
				gui.getPanelRealizacionConsultas().getPanelTotalApuestas().getCampoNumeroApuestasPorSede().setText("");
				return;
			}
			
			String sedeSeleccionada = gui.getPanelRealizacionConsultas().getPanelTotalApuestas().getSeleccionSede().getSelectedItem().toString();
			
			gui.getPanelRealizacionConsultas().getPanelTotalApuestas().getCampoNumeroApuestasPorSede().setText(
					casaDeApuestas.getGestorDeApuestas().obtenerNumeroDeApuestasPorSede(sedeSeleccionada) + "");
			
			
		} else if (evento.getActionCommand().equals(gui.getPanelRealizacionConsultas().getPanelTotalApuestas().SELECCIONAR_TIPO_DE_JUEGO)) {
			
			// Revisar que el seleccionable no sea nulo
			if (gui.getPanelRealizacionConsultas().getPanelTotalApuestas().getSeleccionTipoDeJuego().getSelectedItem() == null)
				return;
			
			// Revisar si la primera opción está seleccionada
			if (gui.getPanelRealizacionConsultas().getPanelTotalApuestas().getSeleccionTipoDeJuego().getSelectedIndex() == 0) {
				gui.getPanelRealizacionConsultas().getPanelTotalApuestas().getCampoNumeroApuestasPorTipoDeJuego().setText("");
				return;
			}
			
			String tipoDeJuegoSeleccionado = gui.getPanelRealizacionConsultas().getPanelTotalApuestas().getSeleccionTipoDeJuego().getSelectedItem().toString();
			
			switch (tipoDeJuegoSeleccionado) {
			
				case "Loteria":
					gui.getPanelRealizacionConsultas().getPanelTotalApuestas().getCampoNumeroApuestasPorTipoDeJuego().setText(
							casaDeApuestas.getGestorDeApuestas().obtenerNumeroDeApuestasLoteria() + "");
					break;
				
				case "SuperAstro":
					gui.getPanelRealizacionConsultas().getPanelTotalApuestas().getCampoNumeroApuestasPorTipoDeJuego().setText(
							casaDeApuestas.getGestorDeApuestas().obtenerNumeroDeApuestasSuperAstro() + "");
					break;
				
				case "Baloto":
					gui.getPanelRealizacionConsultas().getPanelTotalApuestas().getCampoNumeroApuestasPorTipoDeJuego().setText(
							casaDeApuestas.getGestorDeApuestas().obtenerNumeroDeApuestasBaloto() + "");
					break;
				
				case "BetPlay":
					gui.getPanelRealizacionConsultas().getPanelTotalApuestas().getCampoNumeroApuestasPorTipoDeJuego().setText(
							casaDeApuestas.getGestorDeApuestas().obtenerNumeroDeApuestasBetPlay() + "");
					break;
					
				case "Chance":
					gui.getPanelRealizacionConsultas().getPanelTotalApuestas().getCampoNumeroApuestasPorTipoDeJuego().setText(
							casaDeApuestas.getGestorDeApuestas().obtenerNumeroDeApuestasChance() + "");
					break;
			
			}
			
		}
		
		///////////////////////////////////////// EVENTOS PANEL REALIZACIÓN CONSULTAS -> PANEL DETALLE APUESTAS REALIZADAS /////////////////////////////////////////
		
		else if (evento.getActionCommand().equals(gui.getPanelRealizacionConsultas().getPanelDetalleApuestasRealizadas().SELECCIONAR_SEDE)) {
			
			// Revisar que el seleccionable no sea nulo
			if (gui.getPanelRealizacionConsultas().getPanelDetalleApuestasRealizadas().getSeleccionSede().getSelectedItem() == null)
				return;
			
			// Revisar si la primera opción está seleccionada
			if (gui.getPanelRealizacionConsultas().getPanelDetalleApuestasRealizadas().getSeleccionSede().getSelectedIndex() == 0) {
				gui.getPanelRealizacionConsultas().getPanelDetalleApuestasRealizadas().reiniciarTabla();
				return;
			}
			
			String sedeSeleccionada = gui.getPanelRealizacionConsultas().getPanelDetalleApuestasRealizadas().getSeleccionSede().getSelectedItem().toString();
			
			gui.getPanelRealizacionConsultas().getPanelDetalleApuestasRealizadas().agregarApuestasPorSede(casaDeApuestas.getGestorDeApuestas().obtenerApuestasPorSede(sedeSeleccionada));
			
		} else if (evento.getActionCommand().equals(gui.getPanelRealizacionConsultas().getPanelDetalleApuestasRealizadas().CONSULTAR)) {
			
			String cedula = gui.getPanelRealizacionConsultas().getPanelDetalleApuestasRealizadas().getCampoCedula().getText();
			
			if (casaDeApuestas.getGestorDeApuestas().obtenerApuestasCompletasPorCliente(cedula).length == 0)
				gui.mostrarMensaje("La cédula ingresada no ha sido encontrada", "Cédula no encontrada");
			
			gui.getPanelRealizacionConsultas().getPanelDetalleApuestasRealizadas().agregarApuestasPorCliente(casaDeApuestas.getGestorDeApuestas().obtenerApuestasCompletasPorCliente(cedula));
			
		}
		
	}
	
	/**
	 * Actualizar tabla juegos panel parametrizacion.
	 */
	public void actualizarTablaJuegosPanelParametrizacion() {
		// Crear variable que almacena la tabla juegos.
		var tabla = gui.getPanelParametrizacionCasaDeApuestas().getModeloTabla();
		
		// Eliminar todas las filas de la tabla
		while (tabla.getRowCount() > 0) tabla.removeRow(0);
		
		double presupuestoTotalDisponible = casaDeApuestas.getPresupuestoTotalDisponible();
		casaDeApuestas.getGestorDeJuegos().asignarPresupuestos(presupuestoTotalDisponible);
		
		// Agregar las filas a la tabla con los juegos extraídos del archivo juegos.dat
		for (int i = 0; i < casaDeApuestas.getGestorDeJuegos().getJuegos().size(); i++)
			tabla.addRow(new Object[] {casaDeApuestas.getGestorDeJuegos().getJuegos().get(i).getNombreDelJuego(), casaDeApuestas.getGestorDeJuegos().getJuegos().get(i).getTipoDeJuego(), casaDeApuestas.getGestorDeJuegos().getJuegos().get(i).getPresupuesto()});
	
	}
	
	/**
	 * Actualizar tabla sedes panel gestion sedes.
	 */
	public void actualizarTablaSedesPanelGestionSedes() {
		
		var tabla = gui.getPanelGestionSedes().getModeloTabla();
		
		// Eliminar todas las filas de la tabla
		while (tabla.getRowCount() > 0) tabla.removeRow(0);
		
		// Agregar las filas a la tabla con las sedes extraídas del archivo sedes.dat
		for (int i = 0; i < casaDeApuestas.getGestorDeSedes().getSedes().size(); i++)
			tabla.addRow(new Object[] {casaDeApuestas.getGestorDeSedes().getSedes().get(i).getUbicacion(), casaDeApuestas.getGestorDeSedes().getSedes().get(i).getNumeroDeEmpleados()});

	}
	
	/**
	 * Reiniciar campos sede A crear panel gestion sedes.
	 */
	public void reiniciarCamposSedeACrearPanelGestionSedes() {
		// Reiniciar el menú desplegable de localidades a la primera opción ("Seleccionar Ubicación:")
		gui.getPanelGestionSedes().getSeleccionLocalidad().setSelectedIndex(0);
					
		// Vaciar el campo número de empleados
		gui.getPanelGestionSedes().getCampoNumeroDeEmpleados().setText("");
	}
	
	
	/**
	 * Actualizar tabla apostadores panel gestion apostadores.
	 */
	public void actualizarTablaApostadoresPanelGestionApostadores() {
		
		// Crear variable que almacena la tabla gestión apostadores.
		var tabla = gui.getPanelGestionApostadores().getModeloTabla();
		
		// Eliminar todas las filas de la tabla
		while (tabla.getRowCount() > 0) tabla.removeRow(0);
		
		
		// Agregar las filas a la tabla con los apostadores extraídos del archivo apostadores.dat
		for (int i = 0; i < casaDeApuestas.getGestorDeApostadores().getApostadores().size(); i++)
			tabla.addRow(new Object[] {casaDeApuestas.getGestorDeApostadores().getApostadores().get(i).getNombreCompleto(), casaDeApuestas.getGestorDeApostadores().getApostadores().get(i).getCedula(), casaDeApuestas.getGestorDeApostadores().getApostadores().get(i).getSedeActual(), casaDeApuestas.getGestorDeApostadores().getApostadores().get(i).getDireccion(), casaDeApuestas.getGestorDeApostadores().getApostadores().get(i).getCelular()});
		
	}
	
	/**
	 * Reiniciar campos apostador A crear panel creacion apostador.
	 */
	public void reiniciarCamposApostadorACrearPanelCreacionApostador() {

		// Vaciar el campo nombre del apostador
		gui.getPanelCreacionApostador().getCampoNombreApostador().setText("");
		
		// Vaciar el campo dirección del apostador
		gui.getPanelCreacionApostador().getCampoDireccionApostador().setText("");
		
		// Vaciar el campo cédula del apostador
		gui.getPanelCreacionApostador().getCampoCedulaApostador().setText("");
		
		// Vaciar el campo número de celular del apostador
		gui.getPanelCreacionApostador().getCampoNumeroApostador().setText("");
		
		// Reiniciar el menú desplegable de localidades a la primera opción ("Seleccionar Ubicación:")
		gui.getPanelCreacionApostador().getSeleccionSedeApostador().setSelectedIndex(0);;
		gui.getPanelGestionSedes().getSeleccionLocalidad().setSelectedIndex(0);
				
	}
	
	/**
	 * Actualizar seleccionable de sedes panel creacion apostador.
	 */
	public void actualizarSeleccionableDeSedesPanelCreacionApostador() {
		// Reiniciar las sedes
		while (gui.getPanelCreacionApostador().getSeleccionSedeApostador().getItemCount() > 0)
			gui.getPanelCreacionApostador().getSeleccionSedeApostador().removeItemAt(0);
		gui.getPanelCreacionApostador().getSeleccionSedeApostador().addItem("Seleccionar Ubicación:");
		
		// Agregar las sedes actuales al JComboBox (desplegable de opciones)
		for (int i = 0; i < casaDeApuestas.getGestorDeSedes().getSedes().size(); i++)
			gui.getPanelCreacionApostador().getSeleccionSedeApostador().addItem(casaDeApuestas.getGestorDeSedes().getSedes().get(i).getUbicacion());
	
	}
	
	/**
	 * Actualizar seleccionable de sedes panel modificacion apostador.
	 */
	public void actualizarSeleccionableDeSedesPanelModificacionApostador() {
		// Reiniciar las sedes
		while (gui.getPanelModificacionApostador().getSeleccionSedeApostador().getItemCount() > 0)
			gui.getPanelModificacionApostador().getSeleccionSedeApostador().removeItemAt(0);
		gui.getPanelModificacionApostador().getSeleccionSedeApostador().addItem("Seleccionar Ubicación:");
		
		// Agregar las sedes actuales al JComboBox (desplegable de opciones)
		for (int i = 0; i < casaDeApuestas.getGestorDeSedes().getSedes().size(); i++)
			gui.getPanelModificacionApostador().getSeleccionSedeApostador().addItem(casaDeApuestas.getGestorDeSedes().getSedes().get(i).getUbicacion());
	
	}
	
	/**
	 * Actualizar seleccionables panel creacion apuesta.
	 */
	public void actualizarSeleccionablesPanelCreacionApuesta() {
		
		// Reiniciar las sedes
		while (gui.getPanelCreacionApuesta().getSeleccionSede().getItemCount() > 0)
			gui.getPanelCreacionApuesta().getSeleccionSede().removeItemAt(0);
		gui.getPanelCreacionApuesta().getSeleccionSede().addItem("Seleccionar Sede:");
		
		// Agregar las sedes actuales al JComboBox (desplegable de opciones)
		for (int i = 0; i < casaDeApuestas.getGestorDeSedes().getSedes().size(); i++)
			gui.getPanelCreacionApuesta().getSeleccionSede().addItem(casaDeApuestas.getGestorDeSedes().getSedes().get(i).getUbicacion());
		
		
		// Reiniciar los tipos de apuesta
		while (gui.getPanelCreacionApuesta().getSeleccionTipoDeApuesta().getItemCount() > 0)
			gui.getPanelCreacionApuesta().getSeleccionTipoDeApuesta().removeItemAt(0);
		gui.getPanelCreacionApuesta().getSeleccionTipoDeApuesta().addItem("Seleccionar Tipo:");
		
		// Agregar los tipos de apuesta actuales al JComboBox (desplegable de opciones)
		for (int i = 0; i < casaDeApuestas.getGestorDeJuegos().getJuegos().size(); i++)
			gui.getPanelCreacionApuesta().getSeleccionTipoDeApuesta().addItem(casaDeApuestas.getGestorDeJuegos().getJuegos().get(i).getNombreDelJuego());
		
		
		// Reiniciar las series de lotería
		while (gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getSeleccionSerie().getItemCount() > 0)
			gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getSeleccionSerie().removeItemAt(0);
		gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getSeleccionSerie().addItem("Seleccionar Serie:");
		
		// Agregar las series al JComboBox (desplegable de opciones)
		for (int i = 0; i < casaDeApuestas.generarSeriesLoteria().length; i++)
			gui.getPanelCreacionApuesta().getPanelApuestaLoteria().getSeleccionSerie().addItem(casaDeApuestas.generarSeriesLoteria()[i] + "");
	
	}
	
	/**
	 * Actualizar seleccionables panel modificacion sede.
	 */
	public void actualizarSeleccionablesPanelModificacionSede() {
		
		// Reiniciar las sedes
		while (gui.getPanelModificacionApuesta().getSeleccionSede().getItemCount() > 0)
			gui.getPanelModificacionApuesta().getSeleccionSede().removeItemAt(0);
		gui.getPanelModificacionApuesta().getSeleccionSede().addItem("Seleccionar Sede:");
		
		// Agregar las sedes actuales al JComboBox (desplegable de opciones)
		for (int i = 0; i < casaDeApuestas.getGestorDeSedes().getSedes().size(); i++)
			gui.getPanelModificacionApuesta().getSeleccionSede().addItem(casaDeApuestas.getGestorDeSedes().getSedes().get(i).getUbicacion());
		
	}
	
	/**
	 * Actualizar tabla apuestas panel gestion apuestas.
	 */
	public void actualizarTablaApuestasPanelGestionApuestas() {
		
		// Crear variable que almacena la tabla gestión apuestas.
		var tabla = gui.getPanelGestionApuestas().getModeloTabla();
		
		// Eliminar todas las filas de la tabla
		while (tabla.getRowCount() > 0) tabla.removeRow(0);
		
		
		/* Agregar las filas a la tabla con las apuestas extraídas de todos los archivos de apuestas: 
		 * apuestas-loteria.dat, apuestas-superastro.dat, apuestas-baloto.dat, apuestas-betplay.dat, apuestas-chance.dat */
		for (int i = 0; i < casaDeApuestas.getGestorDeApuestas().getGestorApuestasLoteria().getApuestasLoteria().size(); i++)
			tabla.addRow(casaDeApuestas.getGestorDeApuestas().obtenerApuestaLoteria(i));
		
		for (int i = 0; i < casaDeApuestas.getGestorDeApuestas().getGestorApuestasSuperAstro().getApuestasSuperAstro().size(); i++)
			tabla.addRow(casaDeApuestas.getGestorDeApuestas().obtenerApuestaSuperAstro(i));
		
		for (int i = 0; i < casaDeApuestas.getGestorDeApuestas().getGestorApuestasBaloto().getApuestasBaloto().size(); i++)
			tabla.addRow(casaDeApuestas.getGestorDeApuestas().obtenerApuestaBaloto(i));
		
		for (int i = 0; i < casaDeApuestas.getGestorDeApuestas().getGestorApuestasChance().getApuestasChance().size(); i++)
			tabla.addRow(casaDeApuestas.getGestorDeApuestas().obtenerApuestaChance(i));
		
		for (int i = 0; i < casaDeApuestas.getGestorDeApuestas().getGestorApuestasBetPlay().getApuestasBetPlay().size(); i++)
			tabla.addRow(casaDeApuestas.getGestorDeApuestas().obtenerApuestaBetPlay(i));
		
	}
	
	/**
	 * Actualizar seleccionables panel realizacion consultas.
	 */
	public void actualizarSeleccionablesPanelRealizacionConsultas() {
		
		// Reiniciar las sedes
		while (gui.getPanelRealizacionConsultas().getPanelClientesPorSede().getSeleccionSede().getItemCount() > 0)
			gui.getPanelRealizacionConsultas().getPanelClientesPorSede().getSeleccionSede().removeItemAt(0);
		gui.getPanelRealizacionConsultas().getPanelClientesPorSede().getSeleccionSede().addItem("Seleccionar Sede:");
		
		// Agregar las sedes actuales al JComboBox (desplegable de opciones)
		for (int i = 0; i < casaDeApuestas.getGestorDeSedes().getSedes().size(); i++)
			gui.getPanelRealizacionConsultas().getPanelClientesPorSede().getSeleccionSede().addItem(casaDeApuestas.getGestorDeSedes().getSedes().get(i).getUbicacion());
		
	}
	
	/**
	 * Actualizar tabla clientes por sede.
	 *
	 * @param sedeSeleccionada La sede seleccionada para mostrar los clientes correspondientes.
	 */
	public void actualizarTablaClientesPorSede(String sedeSeleccionada) {
		
		// Crear variable que almacena la tabla clientes por sede.
		var tabla = gui.getPanelRealizacionConsultas().getPanelClientesPorSede().getModeloTabla();
		
		// Eliminar todas las filas de la tabla
		while (tabla.getRowCount() > 0) tabla.removeRow(0);
		
		
		// Agregar las filas a la tabla con los clientes extraídos del archivo apostadores.dat
		for (int i = 0; i < casaDeApuestas.getGestorDeApostadores().obtenerClientesPorSede(sedeSeleccionada).size(); i++)
			tabla.addRow(new Object[] {casaDeApuestas.getGestorDeApostadores().obtenerClientesPorSede(sedeSeleccionada).get(i).getNombreCompleto(), casaDeApuestas.getGestorDeApostadores().obtenerClientesPorSede(sedeSeleccionada).get(i).getCedula(), casaDeApuestas.getGestorDeApostadores().obtenerClientesPorSede(sedeSeleccionada).get(i).getDireccion(), casaDeApuestas.getGestorDeApostadores().obtenerClientesPorSede(sedeSeleccionada).get(i).getCelular()});
		
	}


	/**
	 * Mouse clicked.
	 *
	 * @param e Evento de mouse
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	/**
	 * Mouse pressed.
	 *
	 * @param e Evento de mouse
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
		///////////////////////////////////////// EVENTOS PANEL GESTIÓN APUESTAS /////////////////////////////////////////
		
		if (e.getSource() == gui.getPanelCreacionApuesta().getPanelApuestaBetPlay().getTablaApuestasPartidos()) {
			
			var tablaApuestasPartidos = gui.getPanelCreacionApuesta().getPanelApuestaBetPlay().getTablaApuestasPartidos();
			
			int filaSeleccionada = tablaApuestasPartidos.getSelectedRow();
			
			boolean apuestaSeleccionada = (boolean) tablaApuestasPartidos.getValueAt(filaSeleccionada, 3)
					|| (boolean) tablaApuestasPartidos.getValueAt(filaSeleccionada, 4)
					|| (boolean) tablaApuestasPartidos.getValueAt(filaSeleccionada, 5);
			
			// Si la apuesta ya ha sido seleccionada, deseleccionar todas las demás selecciones
			if (apuestaSeleccionada) {
				tablaApuestasPartidos.setValueAt(false, filaSeleccionada, 3);
				tablaApuestasPartidos.setValueAt(false, filaSeleccionada, 4);
				tablaApuestasPartidos.setValueAt(false, filaSeleccionada, 5);
			}
		
		}

	}

	/**
	 * Mouse released.
	 *
	 * @param e Evento de mouse
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		
		///////////////////////////////////////// EVENTOS PANEL GESTIÓN SEDES /////////////////////////////////////////
		
		// Revisar si el evento proviene de la tabla gestión sedes
		if (e.getSource() == gui.getPanelGestionSedes().getTablaSedes()) {
			
			// Habilitar los campos de la sede a modificar con los datos de la fila seleccionada de la tabla
			int indiceFilaSeleccionadaTabla = gui.getPanelGestionSedes().getTablaSedes().getSelectedRow();
			String ubicacionSede = gui.getPanelGestionSedes().getModeloTabla().getValueAt(indiceFilaSeleccionadaTabla, 0).toString();
			int numeroDeEmpleados = Integer.parseInt(gui.getPanelGestionSedes().getModeloTabla().getValueAt(indiceFilaSeleccionadaTabla, 1).toString());
			gui.getPanelGestionSedes().getSeleccionLocalidadAModificar().setSelectedItem(ubicacionSede);
			gui.getPanelGestionSedes().getCampoNumeroDeEmpleadosAModificar().setText(numeroDeEmpleados + "");
			gui.getPanelGestionSedes().getSeleccionLocalidadAModificar().setEnabled(true);
			gui.getPanelGestionSedes().getCampoNumeroDeEmpleadosAModificar().setEditable(true);
			
		}

	}

	/**
	 * Mouse entered.
	 *
	 * @param e Evento de mouse
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		
		///////////////////////////////////////// EVENTOS PANEL MENÚ PRINCIPAL /////////////////////////////////////////
		
		// Buscar si el evento proviene de alguno de los botones del menú principal. 
		for (int i = 0; i < gui.getPanelMenuPrincipal().obtenerBotonesMenuPrincipal().length; i++) {
			// Si el usuario pasa el cursor sobre un botón del menú principal, el borde de éste se bajará y el cursor cambiará su estado
			if (e.getSource() == gui.getPanelMenuPrincipal().obtenerBotonesMenuPrincipal()[i]) {
				gui.getPanelMenuPrincipal().obtenerBotonesMenuPrincipal()[i].setBorder(gui.getPanelMenuPrincipal().crearBordeBajado());
				gui.getPanelMenuPrincipal().obtenerBotonesMenuPrincipal()[i].setCursor(gui.getPanelMenuPrincipal().obtenerCursorActivo());
			}
		}
	}

	/**
	 * Mouse exited.
	 *
	 * @param e Evento de mouse
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		
		///////////////////////////////////////// EVENTOS PANEL MENÚ PRINCIPAL /////////////////////////////////////////
		
		// Buscar si el evento proviene de alguno de los botones del menú principal. 
		for (int i = 0; i < gui.getPanelMenuPrincipal().obtenerBotonesMenuPrincipal().length; i++) {
			// Si el usuario saca el cursor de un botón del menú principal, el borde de éste se levantará y el cursor cambiará su estado
			if (e.getSource() == gui.getPanelMenuPrincipal().obtenerBotonesMenuPrincipal()[i]) {
				gui.getPanelMenuPrincipal().obtenerBotonesMenuPrincipal()[i].setBorder(gui.getPanelMenuPrincipal().crearBordeLevantado());
				gui.getPanelMenuPrincipal().obtenerBotonesMenuPrincipal()[i].setCursor(gui.getPanelMenuPrincipal().obtenerCursorPorDefecto());
			}
		}
	}
}
