package co.edu.unbosque.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import co.edu.unbosque.model.Betmaster;
import co.edu.unbosque.view.FormularioAgregarSede;
import co.edu.unbosque.view.FormularioEliminarApostador;
import co.edu.unbosque.view.FormularioEliminarSede;
import co.edu.unbosque.view.FormularioLeerModificarApostador;
import co.edu.unbosque.view.FormularioModificarSede;
import co.edu.unbosque.view.FormularioAgregarApostador;
import co.edu.unbosque.view.FormularioParametros;
import co.edu.unbosque.view.PaginaPrincipal;
import co.edu.unbosque.view.PanelBaloto;
import co.edu.unbosque.view.PanelBetPlay;
import co.edu.unbosque.view.PanelChance;
import co.edu.unbosque.view.PanelLoteria;
import co.edu.unbosque.view.PanelSuperAstro;
import co.edu.unbosque.view.PanelVerificacionAdmin;
import co.edu.unbosque.view.PanelVerificacionUsuario;
import co.edu.unbosque.view.SeleccionDeJuego;
import co.edu.unbosque.view.VentanaAdmin;
import co.edu.unbosque.view.VentanaFactura;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements ActionListener {
	
	private Betmaster betmaster;
	
	private PaginaPrincipal paginaPrincipal;
	private VentanaAdmin ventanaAdmin;
	
	private PanelVerificacionAdmin panelVerificacionAdmin;
	
	private FormularioParametros formularioParametros;
	
	private FormularioAgregarSede formularioAgregarSede;
	private FormularioModificarSede formularioModificarSede;
	private FormularioEliminarSede formularioEliminarSede;
	
	private FormularioAgregarApostador formularioAgregarApostador;
	private FormularioLeerModificarApostador formularioLeerModificarApostador;
	private FormularioEliminarApostador formularioEliminarApostador;
	
	
	private PanelVerificacionUsuario panelVerificacionUsuario;
	
	private SeleccionDeJuego seleccionJuego;
	private PanelLoteria panelLoteria;
	private PanelSuperAstro panelSuperAstro;
	private PanelBaloto panelBaloto;
	private PanelBetPlay panelBetplay;
	private PanelChance panelChance;
	private VentanaFactura ventanaFactura;

    /**
     * Instantiates a new controller.
     */
    public Controller() {
    	
    	betmaster = new Betmaster();
   
    	paginaPrincipal = new PaginaPrincipal();
    	paginaPrincipal.setVisible(true);
    	
    	// Action listeners y escuchadores de eventos
    	
    	// Sección administrativa de la casa de apuestas
    	paginaPrincipal.getAdmin().setActionCommand("admin");
    	paginaPrincipal.getAdmin().addActionListener(this);
    	
    	paginaPrincipal.getClientes().setActionCommand("clientes");
    	paginaPrincipal.getClientes().addActionListener(this);
    	
    	
    	panelVerificacionAdmin = new PanelVerificacionAdmin();
    	panelVerificacionAdmin.getValidarCuenta().setActionCommand("validarCuenta");
    	panelVerificacionAdmin.getValidarCuenta().addActionListener(this);
    	
    	// Módulo parametrización Casa de Apuestas
    	ventanaAdmin = new VentanaAdmin();
    	ventanaAdmin.getParametrizarBetMaster().setActionCommand("parametrizarBetmaster");
    	ventanaAdmin.getParametrizarBetMaster().addActionListener(this);
    	
    	formularioParametros = new FormularioParametros();
    	formularioParametros.getGuardarParametros().setActionCommand("guardarParametros");
    	formularioParametros.getGuardarParametros().addActionListener(this);
    	
    	formularioParametros.getLeerParametros().setActionCommand("leerParametros");
    	formularioParametros.getLeerParametros().addActionListener(this);
    	
    	// Módulo gestión de sedes
    	ventanaAdmin.getAgregarSede().setActionCommand("agregarSede");
    	ventanaAdmin.getAgregarSede().addActionListener(this);
    	
    	ventanaAdmin.getModificarSede().setActionCommand("modificarSede");
    	ventanaAdmin.getModificarSede().addActionListener(this);
    	
    	ventanaAdmin.getEliminarSede().setActionCommand("eliminarSede");
    	ventanaAdmin.getEliminarSede().addActionListener(this);
    	
    	// Módulo gestión de apostadores
    	ventanaAdmin.getAgregarApostador().setActionCommand("agregarApostador");
    	ventanaAdmin.getAgregarApostador().addActionListener(this);
    	
    	ventanaAdmin.getLeerModificarApostador().setActionCommand("leerModificarApostador");
    	ventanaAdmin.getLeerModificarApostador().addActionListener(this);
    	
    	ventanaAdmin.getEliminarApostador().setActionCommand("eliminarApostador");
    	ventanaAdmin.getEliminarApostador().addActionListener(this);
    	
    	// Modulo de realizacion de consultas
    	ventanaAdmin.getListarClientesPorSede().setActionCommand("listarClientesPorSede");
    	ventanaAdmin.getListarClientesPorSede().addActionListener(this);
    	ventanaAdmin.getValorTotalApuestasPorCliente().setActionCommand("valorTotalApuestasPorCliente");
    	ventanaAdmin.getValorTotalApuestasPorCliente().addActionListener(this);
    	ventanaAdmin.getDetalleDeApuestasPorCliente().setActionCommand("Detalle de apuestas por cliente");
    	ventanaAdmin.getDetalleDeApuestasPorCliente().addActionListener(this);
    	ventanaAdmin.getDetalleDeApuestasPorSede().setActionCommand("Detalle de apuestas por sede");
    	ventanaAdmin.getDetalleDeApuestasPorSede().addActionListener(this);
    	ventanaAdmin.getTotalDeApuestasPorSede().setActionCommand("Total de apuestas por sede");
    	ventanaAdmin.getTotalDeApuestasPorSede().addActionListener(this);
    	ventanaAdmin.getTotalDeApuestasPorTipoDeJuego().setActionCommand("Total de apuestas por tipo de juego");
    	ventanaAdmin.getTotalDeApuestasPorTipoDeJuego().addActionListener(this);
    	
    	// Formularios de gestión de sedes
    	formularioAgregarSede = new FormularioAgregarSede();
    	formularioAgregarSede.getAgregarSede().setActionCommand("agregarNuevaSede");
    	formularioAgregarSede.getAgregarSede().addActionListener(this);
    	
    	formularioModificarSede = new FormularioModificarSede();
    	formularioModificarSede.getModificarSede().setActionCommand("modificarSedeActual");
    	formularioModificarSede.getModificarSede().addActionListener(this);
    	
    	formularioModificarSede.getUbicacionSede().setActionCommand("ubicacionSede");
    	formularioModificarSede.getUbicacionSede().addActionListener(this);
    	
    	formularioEliminarSede = new FormularioEliminarSede();
    	formularioEliminarSede.getEliminarSede().setActionCommand("eliminarSedeActual");
    	formularioEliminarSede.getEliminarSede().addActionListener(this);
    	formularioEliminarSede.getUbicacionSede().setActionCommand("ubicacionSedeAEliminar");
    	formularioEliminarSede.getUbicacionSede().addActionListener(this);
    	
    	
    	// Formularios de gestión de apostadores
    	formularioAgregarApostador = new FormularioAgregarApostador();
    	formularioAgregarApostador.getAgregarApostador().setActionCommand("agregarNuevoApostador");
    	formularioAgregarApostador.getAgregarApostador().addActionListener(this);
    	
    	formularioLeerModificarApostador = new FormularioLeerModificarApostador();
    	formularioLeerModificarApostador.getBuscarApostador().setActionCommand("buscarApostador");
    	formularioLeerModificarApostador.getBuscarApostador().addActionListener(this);
    	formularioLeerModificarApostador.getModificarApostador().setActionCommand("modificarApostador");
    	formularioLeerModificarApostador.getModificarApostador().addActionListener(this);
    	
    	formularioEliminarApostador = new FormularioEliminarApostador();
    	formularioEliminarApostador.getBuscarApostador().setActionCommand("buscarApostadorAEliminar");
    	formularioEliminarApostador.getBuscarApostador().addActionListener(this);
    	formularioEliminarApostador.getEliminarApostador().setActionCommand("eliminarApostadorActual");
    	formularioEliminarApostador.getEliminarApostador().addActionListener(this);
    	
    	
    	// Sección de juegos de la casa de apuestas
    	panelVerificacionUsuario = new PanelVerificacionUsuario();
    	panelVerificacionUsuario.getValidarCuenta().setActionCommand("validarCuentaCliente");
    	panelVerificacionUsuario.getValidarCuenta().addActionListener(this);
    	
    	seleccionJuego = new SeleccionDeJuego();
    	seleccionJuego.getLoteria().setActionCommand("loteria");
    	seleccionJuego.getLoteria().addActionListener(this);
    	
    	panelLoteria = new PanelLoteria();
    	panelLoteria.getApostar().setActionCommand("apostarLoteria");
    	panelLoteria.getApostar().addActionListener(this);
    	panelLoteria.getModificar().setActionCommand("modificarLoteria");
    	panelLoteria.getModificar().addActionListener(this);
    	panelLoteria.getRegresar().setActionCommand("regresarDeLoteria");
    	panelLoteria.getRegresar().addActionListener(this);
    	panelLoteria.getLeer().setActionCommand("leerLoteria");
    	panelLoteria.getLeer().addActionListener(this);
    	panelLoteria.getEliminar().setActionCommand("eliminarLoteria");
    	panelLoteria.getEliminar().addActionListener(this);
    	
    	seleccionJuego.getSuperastro().setActionCommand("superastro");
    	seleccionJuego.getSuperastro().addActionListener(this);
    	
    	panelSuperAstro = new PanelSuperAstro();
    	panelSuperAstro.getApostar().setActionCommand("apostarSuperAstro");
    	panelSuperAstro.getApostar().addActionListener(this);
    	panelSuperAstro.getRegresar().setActionCommand("regresarDeSuperAstro");
    	panelSuperAstro.getRegresar().addActionListener(this);
    	panelSuperAstro.getLeer().setActionCommand("leerSuperAstro");
    	panelSuperAstro.getLeer().addActionListener(this);
    	panelSuperAstro.getModificar().setActionCommand("modificarSuperAstro");
    	panelSuperAstro.getModificar().addActionListener(this);
    	panelSuperAstro.getEliminar().setActionCommand("eliminarSuperAstro");
    	panelSuperAstro.getEliminar().addActionListener(this);
    	
    	
    	seleccionJuego.getBaloto().setActionCommand("baloto");
    	seleccionJuego.getBaloto().addActionListener(this);
    	
    	panelBaloto = new PanelBaloto();
    	panelBaloto.getRegresar().setActionCommand("regresarDeBaloto");
    	panelBaloto.getRegresar().addActionListener(this);
    	panelBaloto.getApostar().setActionCommand("apostarBaloto");
    	panelBaloto.getApostar().addActionListener(this);
    	panelBaloto.getLeer().setActionCommand("leerBaloto");
    	panelBaloto.getLeer().addActionListener(this);
    	panelBaloto.getModificar().setActionCommand("modificarBaloto");
    	panelBaloto.getModificar().addActionListener(this);
    	panelBaloto.getEliminar().setActionCommand("eliminarBaloto");
    	panelBaloto.getEliminar().addActionListener(this);
    	
    	seleccionJuego.getBetplay().setActionCommand("betplay");
    	seleccionJuego.getBetplay().addActionListener(this);
    	
    	panelBetplay = new PanelBetPlay();
    	panelBetplay.getRegresar().setActionCommand("regresarDeBetPlay");
    	panelBetplay.getRegresar().addActionListener(this);
    	panelBetplay.getApostar().setActionCommand("apostarBetPlay");
    	panelBetplay.getApostar().addActionListener(this);
    	panelBetplay.getLeer().setActionCommand("leerBetPlay");
    	panelBetplay.getLeer().addActionListener(this);
    	panelBetplay.getModificar().setActionCommand("modificarBetPlay");
    	panelBetplay.getModificar().addActionListener(this);
    	panelBetplay.getEliminar().setActionCommand("eliminarBetPlay");
    	panelBetplay.getEliminar().addActionListener(this);
    	
    	seleccionJuego.getChance().setActionCommand("chance");
    	seleccionJuego.getChance().addActionListener(this);
    	
    	panelChance = new PanelChance();
    	panelChance.getRegresar().setActionCommand("regresarDeChance");
    	panelChance.getRegresar().addActionListener(this);
    	panelChance.getApostar().setActionCommand("apostarChance");
    	panelChance.getApostar().addActionListener(this);
    	panelChance.getLeer().setActionCommand("leerChance");
    	panelChance.getLeer().addActionListener(this);
    	panelChance.getModificar().setActionCommand("modificarChance");
    	panelChance.getModificar().addActionListener(this);
    	panelChance.getEliminar().setActionCommand("eliminarChance");
    	panelChance.getEliminar().addActionListener(this);
    	
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		
		switch (comando) {
		
			// Eventos pagina principal
			case "admin":
				panelVerificacionAdmin.setVisible(true);
				break;
			case "clientes":
				panelVerificacionUsuario.setVisible(true);
				break;
			
			case "validarCuenta":
				ventanaAdmin.setVisible(true);
				break;
				
			// Eventos ventana admin
			case "parametrizarBetmaster":
				formularioParametros.setVisible(true);
				break;
			case "agregarSede":
				formularioAgregarSede.setVisible(true);
				break;
			case "modificarSede":
				formularioModificarSede.desplegarSedesActuales(
						betmaster.getGestorDeSedes().obtenerSedesActuales());
				formularioModificarSede.deshabilitarCampos();
				formularioModificarSede.setVisible(true);
				break;
			case "eliminarSede":
				formularioEliminarSede.desplegarSedesActuales(
						betmaster.getGestorDeSedes().obtenerSedesActuales());
				formularioEliminarSede.setVisible(true);
				break;
			case "agregarApostador":
				formularioAgregarApostador.desplegarSedesActuales(
						betmaster.getGestorDeSedes().obtenerSedesActuales());
				formularioAgregarApostador.setVisible(true);
				break;
			case "leerModificarApostador":
				formularioLeerModificarApostador.desplegarSedesActuales(
						betmaster.getGestorDeSedes().obtenerSedesActuales());
				formularioLeerModificarApostador.reiniciarCampos();
				formularioLeerModificarApostador.setVisible(true);
				break;
			case "eliminarApostador":
				formularioEliminarApostador.setVisible(true);
				break;
		
				
			// Eventos formulario parametros
			case "guardarParametros":
				if (formularioParametros.validarParametros()) {
					betmaster.guardarParametros(
							formularioParametros.obtenerNombreCasa(),
							formularioParametros.obtenerNumeroSedes(),
							formularioParametros.obtenerPresupuestoDisponible());
					betmaster.asignarPresupuestosAJuegos();
				}
				break;
			case "leerParametros":
				formularioParametros.cargarParametros(
						betmaster.getNombre(),
						betmaster.getNumeroDeSedes(),
						betmaster.getPresupuestoTotalDisponible());
				break;
				
			// Eventos formulario agregar sede
			case "agregarNuevaSede":
				if (formularioAgregarSede.validarCampos()) {
					betmaster.agregarSede(
							formularioAgregarSede.obtenerUbicacionSede(),
							formularioAgregarSede.obtenerNumeroEmpleados());
					
				}
				break;
				
			// Eventos formulario modificar sede
			case "ubicacionSede":
				formularioModificarSede.actualizarCampos(
						betmaster.getGestorDeSedes().obtenerNumeroEmpleados(
								formularioModificarSede.obtenerUbicacionSeleccionada()));
				break;
			case "modificarSedeActual":
				if (formularioModificarSede.validarCampos()) {
					betmaster.getGestorDeSedes().obtenerSedesActuales();
					String ubicacionActual = formularioModificarSede.obtenerUbicacionSeleccionada();
					int indiceAModificar = betmaster.getGestorDeSedes().obtenerIndiceSede(ubicacionActual);
					betmaster.modificarSede(
							indiceAModificar, 
							formularioModificarSede.obtenerNuevaUbicacion(),
							formularioModificarSede.obtenerNuevoNumeroEmpleados());
					formularioModificarSede.desplegarSedesActuales(
							betmaster.getGestorDeSedes().obtenerSedesActuales());
					formularioModificarSede.reiniciarCampos();
					formularioModificarSede.deshabilitarCampos();
				}
				break;
			
			// Eventos formulario eliminar sede
			case "ubicacionSedeAEliminar":
				formularioEliminarSede.actualizarNumeroDeEmpleados(
						betmaster.getGestorDeSedes().obtenerNumeroEmpleados(
								formularioEliminarSede.obtenerUbicacionSeleccionada()));
				break;
			
			case "eliminarSedeActual":
				if (formularioEliminarSede.validarSeleccion()) {
					betmaster.eliminarSede(
							betmaster.getGestorDeSedes().obtenerIndiceSede(
									formularioEliminarSede.obtenerUbicacionSeleccionada()));
					formularioEliminarSede.desplegarSedesActuales(
							betmaster.getGestorDeSedes().obtenerSedesActuales());
					formularioEliminarSede.reiniciarCampos();
				}
				break;
				
			// Eventos formulario agregar apostador
			case "agregarNuevoApostador":
				if (formularioAgregarApostador.validarDatos()) {
					betmaster.getGestorDeApostadores().agregarApostador(
							formularioAgregarApostador.obtenerNombreCompleto(),
							formularioAgregarApostador.obtenerCedula(),
							formularioAgregarApostador.obtenerSede(),
							formularioAgregarApostador.obtenerDireccion(),
							formularioAgregarApostador.obtenerCelular());
					formularioAgregarApostador.reiniciarCampos();
					formularioAgregarApostador.desplegarSedesActuales(
							betmaster.getGestorDeSedes().obtenerSedesActuales());
				}
				break;
			
			// Eventos formulario modificar apostador
			case "buscarApostador":
				int indiceApostador = betmaster.getGestorDeApostadores().obtenerIndiceApostador(
						formularioLeerModificarApostador.obtenerCedula());
				if (formularioLeerModificarApostador.apostadorEncontrado(indiceApostador)) {
					var apostador = betmaster.getGestorDeApostadores().getApostadores().get(indiceApostador);
					formularioLeerModificarApostador.llenarCamposApostador(
							apostador.getNombreCompleto(),
							apostador.getCedula(),
							apostador.getSedeActual(),
							apostador.getDireccion(),
							apostador.getCelular());
				}
				break;
			case "modificarApostador":
				if (formularioLeerModificarApostador.validarDatos()) {
					int indiceApostadorAModificar = betmaster.getGestorDeApostadores().obtenerIndiceApostador(
							formularioLeerModificarApostador.obtenerCedulaAModificar());
					if (formularioLeerModificarApostador.apostadorAModificarEncontrado(indiceApostadorAModificar)) {
						betmaster.getGestorDeApostadores().modificarApostador(
								indiceApostadorAModificar,
								formularioLeerModificarApostador.obtenerNombreAModificar(),
								formularioLeerModificarApostador.obtenerCedulaAModificar(),
								formularioLeerModificarApostador.obtenerSedeAModificar(),
								formularioLeerModificarApostador.obtenerDireccionAModificar(),
								formularioLeerModificarApostador.obtenerCelularAModificar());
						formularioLeerModificarApostador.reiniciarCampos();
					}
				}
				break;
				
			// Eventos formulario eliminar apostador
			case "buscarApostadorAEliminar":
				int indiceApostadorBuscado = betmaster.getGestorDeApostadores().obtenerIndiceApostador(
						formularioEliminarApostador.obtenerCedula());
				if (formularioEliminarApostador.apostadorEncontrado(indiceApostadorBuscado)) {
					var apostador = betmaster.getGestorDeApostadores().getApostadores().get(indiceApostadorBuscado);
					formularioEliminarApostador.llenarCamposApostador(
							apostador.getNombreCompleto(),
							apostador.getCedula(),
							apostador.getSedeActual(),
							apostador.getDireccion(),
							apostador.getCelular());
				}
				break;
			case "eliminarApostadorActual":
				if (formularioEliminarApostador.validarCedula()) {
					int indiceApostadorAEliminar = betmaster.getGestorDeApostadores().obtenerIndiceApostador(
							formularioEliminarApostador.obtenerCedula());
					if (formularioEliminarApostador.apostadorEncontrado(indiceApostadorAEliminar)) {
						var apostador = betmaster.getGestorDeApostadores().getApostadores().get(indiceApostadorAEliminar);
						if (formularioEliminarApostador.confirmarEliminacionApostador(apostador.getCedula()))
							formularioEliminarApostador.reiniciarCampos();
					}
				}
				break;
				
				
			case "validarCuentaCliente":
				seleccionJuego.setVisible(true);
				break;
			
				
			// Eventos de selección de juego
			case "loteria":
				panelLoteria.desplegarSedesActuales(
						betmaster.getGestorDeSedes().obtenerSedesActuales());
				panelLoteria.reiniciarCampos();
				panelLoteria.setVisible(true);
				break;
			case "superastro":
				panelSuperAstro.desplegarSedesActuales(
						betmaster.getGestorDeSedes().obtenerSedesActuales());
				panelSuperAstro.reiniciarCampos();
				panelSuperAstro.setVisible(true);
				break;
			case "baloto":
				panelBaloto.desplegarSedesActuales(
						betmaster.getGestorDeSedes().obtenerSedesActuales());
				panelBaloto.reiniciarCampos();
				panelBaloto.setVisible(true);
				break;
			case "betplay":
				panelBetplay.desplegarSedesActuales(betmaster.getGestorDeSedes().obtenerSedesActuales());
				panelBetplay.desplegarPartidos(
						betmaster.getGestionBetPlay().getApuestaBetPlay().obtenerPartidos(
								betmaster.getGestionBetPlay().getArchivo().leerEquipos()));
				panelBetplay.setVisible(true);
				break;
			case "chance":
				panelChance.desplegarSedesActuales(
						betmaster.getGestorDeSedes().obtenerSedesActuales());
				panelChance.reiniciarCampos();
				panelChance.setVisible(true);
				break;
				
			
			// Eventos del juego de loteria
			case "apostarLoteria":
				if (panelLoteria.validarApuesta()) {
					int indiceApostadorLoteria = betmaster.getGestorDeApostadores().obtenerIndiceApostador(
							panelLoteria.obtenerCedula());
					if (panelLoteria.validarCedula(indiceApostadorLoteria)) {
						betmaster.agregarApuestaLoteria("loteria",
								panelLoteria.obtenerSede(),
								panelLoteria.obtenerCedula(),
								panelLoteria.obtenerDia(),
								panelLoteria.obtenerValor(),
								panelLoteria.obtenerNombre(),
								panelLoteria.obtenerNumero(),
								panelLoteria.obtenerSerie());
						
						ventanaFactura = new VentanaFactura(
								panelLoteria.obtenerSede(),
								panelLoteria.obtenerCedula(),
								panelLoteria.obtenerDia(),
								panelLoteria.obtenerValor(),
								"Loteria");
						panelLoteria.reiniciarCampos();
					}
					
				}
				break;
			case "modificarLoteria":
				if (panelLoteria.validarModificacionApuesta()) {
					int indiceApuestaLoteria = betmaster.getGestionLoteria().obtenerIndiceApuesta(
							panelLoteria.obtenerCedula(),
							panelLoteria.obtenerDia());
					
					if (panelLoteria.validarIndiceApuestaAModificar(indiceApuestaLoteria)) {
						betmaster.getGestionLoteria().modificarApuestaLoteria(
								indiceApuestaLoteria, 
								"Loteria", 
								panelLoteria.obtenerSede(),
								panelLoteria.obtenerCedula(),
								panelLoteria.obtenerDia(),
								panelLoteria.obtenerValor(),
								panelLoteria.obtenerNombre(),
								panelLoteria.obtenerNumero(),
								panelLoteria.obtenerSerie());
						panelLoteria.reiniciarCampos();
						
					}
				}
				break;
			case "leerLoteria":
				if (panelLoteria.validarLeerLoteria()) {
					int indiceApuestaALeer = betmaster.getGestionLoteria().obtenerIndiceApuesta(
							panelLoteria.obtenerCedula(), 
							panelLoteria.obtenerSede(),
							panelLoteria.obtenerDia());
					
					if (indiceApuestaALeer != -1) {
						var apuesta = betmaster.getGestionLoteria().getApuestasLoteria().get(indiceApuestaALeer);
						panelLoteria.actualizarCamposApuestaLeida(
								apuesta.getNumeroLoteria(),
								apuesta.getSerie(),
								apuesta.getNombre(),
								apuesta.getCedulaApostador(),
								apuesta.getDia(),
								apuesta.getNombreSede(),
								apuesta.getValor());
					}
				}
				break;
			case "eliminarLoteria":
				if (panelLoteria.validarEliminacion()) {
					int indiceApuestaAEliminar = betmaster.getGestionLoteria().obtenerIndiceApuesta(
							panelLoteria.obtenerCedula(),
							panelLoteria.obtenerSede(),
							panelLoteria.obtenerDia());
					if (panelLoteria.validarIndiceApuestaAEliminar(indiceApuestaAEliminar)) {
						betmaster.getGestionLoteria().eliminarApuestaLoteria(indiceApuestaAEliminar);
						panelLoteria.reiniciarCampos();
					}
					
				}
				
				break;
				
			case "regresarDeLoteria":
				panelLoteria.dispose();
				seleccionJuego.setVisible(true);
				break;
				
			// Eventos del juego de superastro
			case "apostarSuperAstro":
				if (panelSuperAstro.validarApuesta()) {
					int indiceApostadorSuperAstro = betmaster.getGestorDeApostadores().obtenerIndiceApostador(
							panelSuperAstro.obtenerCedula());
					if (panelSuperAstro.validarCedula(indiceApostadorSuperAstro)) {
						betmaster.agregarApuestaSuperAstro(
								panelSuperAstro.obtenerSede(),
								panelSuperAstro.obtenerCedula(),
								panelSuperAstro.obtenerDia(),
								panelSuperAstro.obtenerValor(),
								panelSuperAstro.obtenerNumeros(),
								panelSuperAstro.obtenerSigno());
						ventanaFactura = new VentanaFactura(
								panelSuperAstro.obtenerSede(),
								panelSuperAstro.obtenerCedula(),
								panelSuperAstro.obtenerDia(),
								panelSuperAstro.obtenerValor(),
								"SuperAstro");
						panelSuperAstro.reiniciarCampos();
						
					}
				}
				break;
			case "leerSuperAstro":
				if (panelSuperAstro.validarLeerSuperAstro()) {
					int indiceApuestaALeer = betmaster.getGestionSuperAstro().obtenerIndiceApuesta(
							panelSuperAstro.obtenerCedula(), 
							panelSuperAstro.obtenerSede(),
							panelSuperAstro.obtenerDia());
					if (panelSuperAstro.validarIndiceApuestaALeer(indiceApuestaALeer)) {
						var apuesta = betmaster.getGestionSuperAstro().getApuestasSuperAstro().get(indiceApuestaALeer);
						panelSuperAstro.actualizarCamposApuestaLeida(
								apuesta.getNumerosSeleccionados(),
								apuesta.getSignoDelZodiaco(),
								apuesta.getCedulaApostador(),
								apuesta.getDia(),
								apuesta.getNombreSede(),
								apuesta.getValor());
					}
				}
				break;
			case "modificarSuperAstro":
				if (panelSuperAstro.validarApuesta()) {
					int indiceApostadorSuperAstro = betmaster.getGestorDeApostadores().obtenerIndiceApostador(
							panelSuperAstro.obtenerCedula());
					if (panelSuperAstro.validarCedula(indiceApostadorSuperAstro)) {
						betmaster.modificarApuestaSuperAstro(indiceApostadorSuperAstro, panelSuperAstro.obtenerSede(),
								panelSuperAstro.obtenerCedula(),
								panelSuperAstro.obtenerDia(),
								panelSuperAstro.obtenerValor(),
								panelSuperAstro.obtenerNumeros(),
								panelSuperAstro.obtenerSigno());
						panelSuperAstro.reiniciarCampos();
					}
				}
				break;
			case "eliminarSuperAstro":
				if (panelSuperAstro.validarEliminacion()) {
					int indiceApuestaAEliminar = betmaster.getGestionSuperAstro().obtenerIndiceApuesta(
							panelSuperAstro.obtenerCedula(),
							panelSuperAstro.obtenerSede(),
							panelSuperAstro.obtenerDia());
					if (panelSuperAstro.validarIndiceApuestaAEliminar(indiceApuestaAEliminar)) {
						betmaster.getGestionSuperAstro().eliminarApuestaSuperAstro(indiceApuestaAEliminar);
						panelSuperAstro.reiniciarCampos();
					}
					
				}
				break;
			case "regresarDeSuperAstro":
				panelSuperAstro.dispose();
				seleccionJuego.setVisible(true);
				break;
				
			// Eventos del juego de baloto
			case "regresarDeBaloto":
				panelBaloto.dispose();
				seleccionJuego.setVisible(true);
				break;
			case "apostarBaloto":
				if (panelBaloto.validarApuesta()) {
					int indiceApostadorBaloto = betmaster.getGestorDeApostadores().obtenerIndiceApostador(
							panelBaloto.obtenerCedula());
					if (panelBaloto.validarCedula(indiceApostadorBaloto)) {
						betmaster.agregarApuestaBaloto(
								panelBaloto.obtenerSede(),
								panelBaloto.obtenerCedula(),
								panelBaloto.obtenerDia(),
								panelBaloto.obtenerValor(),
								panelBaloto.obtenerNumeros());
						ventanaFactura = new VentanaFactura(
								panelBaloto.obtenerSede(),
								panelBaloto.obtenerCedula(),
								panelBaloto.obtenerDia(),
								panelBaloto.obtenerValor(),
								"Baloto");
						panelBaloto.reiniciarCampos();
						
					}
				}
				break;
			case "leerBaloto":
				if (panelBaloto.validarLeerBaloto()) {
					int indiceApuestaALeer = betmaster.getGestionBaloto().obtenerIndiceApuesta(
							panelBaloto.obtenerCedula(), 
							panelBaloto.obtenerSede(),
							panelBaloto.obtenerDia());
					if (panelBaloto.validarIndiceApuestaALeer(indiceApuestaALeer)) {
						var apuesta = betmaster.getGestionBaloto().getApuestasBaloto().get(indiceApuestaALeer);
						panelBaloto.actualizarCamposApuestaLeida(
								apuesta.getNumerosSeleccionados(),
								apuesta.getCedulaApostador(),
								apuesta.getDia(),
								apuesta.getNombreSede(),
								apuesta.getValor());
					}
				}
				break;
			case "modificarBaloto":
				if (panelBaloto.validarApuesta()) {
					int indiceApostadorBaloto = betmaster.getGestorDeApostadores().obtenerIndiceApostador(
							panelBaloto.obtenerCedula());
					if (panelBaloto.validarCedula(indiceApostadorBaloto)) {
						betmaster.modificarApuestaBaloto(indiceApostadorBaloto, panelBaloto.obtenerSede(),
								panelBaloto.obtenerCedula(),
								panelBaloto.obtenerDia(),
								panelBaloto.obtenerValor(),
								panelBaloto.obtenerNumeros());
						panelBaloto.reiniciarCampos();
					}
				}
				break;
			case "eliminarBaloto":
				if (panelBaloto.validarEliminacion()) {
					int indiceApuestaAEliminar = betmaster.getGestionBaloto().obtenerIndiceApuesta(
							panelBaloto.obtenerCedula(),
							panelBaloto.obtenerSede(),
							panelBaloto.obtenerDia());
					if (panelBaloto.validarIndiceApuestaAEliminar(indiceApuestaAEliminar)) {
						betmaster.getGestionBaloto().eliminarApuestaBaloto(indiceApuestaAEliminar);
						panelBaloto.reiniciarCampos();
					}
					
				}
				break;
				
			// Eventos del juego de chance
			case "regresarDeChance":
				panelChance.dispose();
				seleccionJuego.setVisible(true);
				break;
			case "apostarChance":
				if (panelChance.validarApuesta()) {
					int indiceApostadorChance = betmaster.getGestorDeApostadores().obtenerIndiceApostador(
							panelChance.obtenerCedula());
					if (panelChance.validarCedula(indiceApostadorChance)) {
						betmaster.agregarApuestaChance(
								panelChance.obtenerSede(), 
								panelChance.obtenerCedula(),
								panelChance.obtenerDia(),
								panelChance.obtenerValor(),
								panelChance.obtenerSede(),
								panelChance.obtenerNumero());
						ventanaFactura = new VentanaFactura(
								panelChance.obtenerSede(),
								panelChance.obtenerCedula(),
								panelChance.obtenerDia(),
								panelChance.obtenerValor(),
								"Chance");
						panelChance.reiniciarCampos();
						
					}
				}
				break;
			
			case "leerChance":
				if (panelChance.validarLeerChance()) {
					int indiceApuestaALeer = betmaster.getGestionChance().obtenerIndiceApuesta(
							panelChance.obtenerCedula(), 
							panelChance.obtenerSede(),
							panelChance.obtenerDia());
					if (panelChance.validarIndiceApuestaALeer(indiceApuestaALeer)) {
						var apuesta = betmaster.getGestionChance().getApuestasChance().get(indiceApuestaALeer);
						
						panelChance.actualizarCamposApuestaLeida(
								apuesta.getNumerosSeleccionados(),
								apuesta.getNombre(),
								apuesta.getCedulaApostador(),
								apuesta.getDia(),
								apuesta.getNombreSede(),
								apuesta.getValor());
					}
				}
				break;
			case "modificarChance":
				
				if (panelChance.validarApuesta()) {
					int indiceApostadorBaloto = betmaster.getGestorDeApostadores().obtenerIndiceApostador(
							panelChance.obtenerCedula());
					if (panelChance.validarCedula(indiceApostadorBaloto)) {
						betmaster.modificarApuestaChance(
								indiceApostadorBaloto,
								panelChance.obtenerSede(),
								panelChance.obtenerCedula(),
								panelChance.obtenerDia(),
								panelChance.obtenerValor(),
								panelChance.getTipoLoteria().getSelectedItem().toString(),
								panelChance.obtenerNumero());
						panelChance.reiniciarCampos();
					}
				}
				break;
				
			case "eliminarChance":
				
				if (panelChance.validarEliminacion()) {
					int indiceApuestaAEliminar = betmaster.getGestionChance().obtenerIndiceApuesta(
							panelChance.obtenerCedula(),
							panelChance.obtenerSede(),
							panelChance.obtenerDia());
					if (panelChance.validarIndiceApuestaAEliminar(indiceApuestaAEliminar)) {
						betmaster.getGestionChance().eliminarApuestaChance(indiceApuestaAEliminar);
						panelChance.reiniciarCampos();
					}
					
				}
				
				break;
				
			// Eventos del juego de betplay
			case "regresarDeBetPlay":
				panelBetplay.dispose();
				seleccionJuego.setVisible(true);
				break;
				
			case "apostarBetPlay":
				if (panelBetplay.validarApuesta()) {
					int indiceApostadorChance = betmaster.getGestorDeApostadores().obtenerIndiceApostador(
							panelBetplay.obtenerCedula());
					if (panelBetplay.validarCedula(indiceApostadorChance)) {
						betmaster.agregarApuestaBetPlay(
								panelBetplay.obtenerSede(), 
								panelBetplay.obtenerCedula(),
								panelBetplay.obtenerDia(),
								panelBetplay.obtenerValor(),
								panelBetplay.obtenerPartidosYResultadosEscogidos());
						ventanaFactura = new VentanaFactura(
								panelBetplay.obtenerSede(),
								panelBetplay.obtenerCedula(),
								panelBetplay.obtenerDia(),
								panelBetplay.obtenerValor(),
								"BetPlay");
						panelBetplay.reiniciarCampos();
					}
				}
				break;
			case "leerBetPlay":
				if (panelBetplay.validarLeerBetPlay()) {
					int indiceApuestaALeer = betmaster.getGestionBetPlay().obtenerIndiceApuesta(
							panelBetplay.obtenerCedula(), 
							panelBetplay.obtenerSede(),
							panelBetplay.obtenerDia());
					if (panelBetplay.validarIndiceApuestaALeer(indiceApuestaALeer)) {
						var apuesta = betmaster.getGestionBetPlay().getApuestasBetPlay().get(indiceApuestaALeer);
						
						
						panelBetplay.actualizarCamposApuestaLeida(
								apuesta.getCedulaApostador(),
								apuesta.getDia(),
								apuesta.getNombreSede(),
								apuesta.getValor(),
								apuesta.getPartidosYResultadosEscogidos());
					}
				}
				break;
			case "modificarBetPlay":
				
				if (panelBetplay.validarApuesta()) {
					int indiceApostadorBetPlay = betmaster.getGestorDeApostadores().obtenerIndiceApostador(
							panelBetplay.obtenerCedula());
					if (panelBetplay.validarCedula(indiceApostadorBetPlay)) {
						betmaster.modificarApuestaBetPlay(
								indiceApostadorBetPlay,
								panelBetplay.obtenerSede(),
								panelBetplay.obtenerCedula(),
								panelBetplay.obtenerDia(),
								panelBetplay.obtenerValor(), 
								panelBetplay.obtenerPartidosYResultadosEscogidos());
						
						panelBetplay.reiniciarCampos();
					}
				}
				
				break;
			case "eliminarBetPlay":
				
				if (panelBetplay.validarEliminacion()) {
					int indiceApuestaAEliminar = betmaster.getGestionBetPlay().obtenerIndiceApuesta(
							panelBetplay.obtenerCedula(),
							panelBetplay.obtenerSede(),
							panelBetplay.obtenerDia());
					if (panelBetplay.validarIndiceApuestaAEliminar(indiceApuestaAEliminar)) {
						betmaster.getGestionBetPlay().eliminarApuestaBetPlay(indiceApuestaAEliminar);
						panelBetplay.reiniciarCampos();
					}
					
				}
				
				break;
				
			// Eventos para el modulo gestion de consultas
			case "listarClientesPorSede":
				String datosClientes = betmaster.getGestorDeApostadores().obtenerApostadoresPorSede(betmaster.getGestorDeSedes().obtenerSedesActuales());
				if (!datosClientes.isEmpty())
					JOptionPane.showMessageDialog(null, datosClientes);
				else
					JOptionPane.showMessageDialog(null, "No se han agregado clientes hasta ahora");
				break;
			case "valorTotalApuestasPorCliente":
				String datosApuestas = "";
				ArrayList<String> cedulas = betmaster.getGestorDeApostadores().obtenerCedulasApostadores();
				for (String cedula: cedulas) {
					double valorTotalApuestas = 0;
					datosApuestas += "Cedula del cliente: " + cedula + "\n";
					datosApuestas += "Valor total apuestas loteria: " + betmaster.getGestionLoteria().obtenerValorTotalApuestas(cedula) + "\n";
					datosApuestas += "Valor total apuestas superastro: " + betmaster.getGestionSuperAstro().obtenerValorTotalApuestas(cedula) + "\n";
					datosApuestas += "Valor total apuestas baloto: " + betmaster.getGestionBaloto().obtenerValorTotalApuestas(cedula) + "\n";
					datosApuestas += "Valor total apuestas betplay: " + betmaster.getGestionBetPlay().obtenerValorTotalApuestas(cedula) + "\n";
					datosApuestas += "Valor total apuestas chance: " + betmaster.getGestionChance().obtenerValorTotalApuestas(cedula) + "\n";
					valorTotalApuestas += betmaster.getGestionLoteria().obtenerValorTotalApuestas(cedula);
					valorTotalApuestas += betmaster.getGestionSuperAstro().obtenerValorTotalApuestas(cedula);
					valorTotalApuestas += betmaster.getGestionBaloto().obtenerValorTotalApuestas(cedula);
					valorTotalApuestas += betmaster.getGestionBetPlay().obtenerValorTotalApuestas(cedula);
					valorTotalApuestas += betmaster.getGestionChance().obtenerValorTotalApuestas(cedula);
					datosApuestas += "Valor total apuestas hechas por el cliente: " + valorTotalApuestas + "\n\n";
				}
				
				JOptionPane.showMessageDialog(null, datosApuestas);
				break;
				
			case "Detalle de apuestas por cliente":
				
				ArrayList<String> cedulasCliente = betmaster.getGestorDeApostadores().obtenerCedulasApostadores();
	        	String datos = "";
	        	for (String cedula: cedulasCliente) {
	        		datos += "Cliente cedula: " + cedula + "\n";
	        		betmaster.getGestionLoteria().obtenerApuestasLoteriaPorCliente(cedula);
	        		datos += "Apuestas de loteria:\n";
	        		for (int i = 0; i < betmaster.getGestionLoteria().obtenerApuestasLoteriaPorCliente(cedula).size(); i++) {
	        			datos += "Dia: " + betmaster.getGestionLoteria().obtenerApuestasLoteriaPorCliente(cedula).get(i).getDia() + "\n";
	        			datos += "Sede: " + betmaster.getGestionLoteria().obtenerApuestasLoteriaPorCliente(cedula).get(i).getNombreSede() + "\n";
	        			datos += "Nombre de loteria: " + betmaster.getGestionLoteria().getApuestasLoteria().get(i).getNombre() + "\n";
	        			datos += "Numero de loteria: " + betmaster.getGestionLoteria().getApuestasLoteria().get(i).getNumeroLoteria() + "\n";
	        			datos += "Serie: " + betmaster.getGestionLoteria().getApuestasLoteria().get(i).getSerie() + "\n\n";	  
	        		}
	        		datos += "\nApuestas de Superastro:\n";
	        		
	        		for (int i = 0; i < betmaster.getGestionSuperAstro().obtenerApuestasSuperAstroPorCliente(cedula).size(); i++) {
	        			datos += "Dia: " + betmaster.getGestionSuperAstro().obtenerApuestasSuperAstroPorCliente(cedula).get(i).getDia() + "\n";
	        			datos += "Sede: " + betmaster.getGestionSuperAstro().obtenerApuestasSuperAstroPorCliente(cedula).get(i).getNombreSede() + "\n";
	        			datos += "Numeros seleccionados: " + Arrays.toString(betmaster.getGestionSuperAstro().obtenerApuestasSuperAstroPorCliente(cedula).get(i).getNumerosSeleccionados()) + "\n";
	        			datos += "Signo del zodiaco: " + betmaster.getGestionSuperAstro().obtenerApuestasSuperAstroPorCliente(cedula).get(i).getSignoDelZodiaco() + "\n\n";
	        		}
	        		
	        		datos += "\nApuestas de Baloto:\n";
	        		for (int i = 0; i < betmaster.getGestionBaloto().obtenerApuestasBalotoPorCliente(cedula).size(); i++) {
	        			datos += "Dia: " + betmaster.getGestionBaloto().getApuestasBaloto().get(i).getDia() + "\n";
	        			datos += "Sede: " + betmaster.getGestionBaloto().getApuestasBaloto().get(i).getNombreSede() + "\n";
	        			datos += "Numeros seleccionados" + Arrays.toString(betmaster.getGestionBaloto().getApuestasBaloto().get(i).getNumerosSeleccionados());
	        		}
	        		
	        		datos += "\nApuestas de betplay:\n";
	        		for (int i = 0; i < betmaster.getGestionBetPlay().obtenerApuestasBetPlayPorCliente(cedula).size(); i++) {
	        			datos += "Dia: " + betmaster.getGestionBetPlay().getApuestasBetPlay().get(i).getDia() + "\n";
	        			datos += "Sede: " + betmaster.getGestionBetPlay().getApuestasBetPlay().get(i).getNombreSede() + "\n";
	        			datos += "Valor: " + betmaster.getGestionBetPlay().getApuestasBetPlay().get(i).getValor() + "\n\n";
	        		}
	        		
	        		datos += "\nApuestas de chance:\n";
	        		for (int i = 0; i < betmaster.getGestionChance().obtenerApuestasChancePorCliente(cedula).size(); i++) {
	        			datos += "Dia: " + betmaster.getGestionChance().getApuestasChance().get(i).getDia() + "\n";
	        			datos += "Sede: " + betmaster.getGestionChance().getApuestasChance().get(i).getNombreSede() + "\n";
	        			datos += "Nombre de la loteria: " + betmaster.getGestionChance().getApuestasChance().get(i).getNombre() + "\n";
	        			datos += "Numeros seleccionados: " + betmaster.getGestionChance().getApuestasChance().get(i).getNumerosSeleccionados() + "\n\n";
	        		}
	        		datos += "\n\n";
	        	}
	        	
	        	// Crear un JTextArea para mostrar los datos
	            JTextArea textArea = new JTextArea(datos);
	            textArea.setEditable(false); // Para que el texto no sea editable
	            textArea.setRows(35); // Establecer el número de filas visible del JTextArea

	            // Crear un JScrollPane y agregar el JTextArea a él
	            JScrollPane scrollPane = new JScrollPane(textArea);

	            // Mostrar el JOptionPane con el JScrollPane como componente personalizado
	            JOptionPane.showMessageDialog(null, scrollPane);
				
				
				break;
			
			case "Detalle de apuestas por sede":
				
				// Detalle de apuestas por sede
	        	String datosApuestasPorSede = "";
	        	String[] sedes = betmaster.getGestorDeSedes().obtenerSedesActuales();
	        	for (int i = 0; i < sedes.length; i++) {
	        		datosApuestasPorSede += "Apuestas por sede " + sedes[i] + "\n";
	        		datosApuestasPorSede += "Apuestas de loteria:\n";
	        		for (int j = 0; j < betmaster.getGestionLoteria().obtenerApuestasLoteriaPorSede(sedes[i]).size(); j++) {
	        			datosApuestasPorSede += "Dia: " + betmaster.getGestionLoteria().obtenerApuestasLoteriaPorSede(sedes[i]).get(j).getDia() + "\n";
	        			datosApuestasPorSede += "Sede: " + betmaster.getGestionLoteria().obtenerApuestasLoteriaPorSede(sedes[i]).get(j).getNombreSede() + "\n";
	        			datosApuestasPorSede += "Nombre de loteria: " + betmaster.getGestionLoteria().obtenerApuestasLoteriaPorSede(sedes[i]).get(j).getNombre() + "\n";
	        			datosApuestasPorSede += "Numero de loteria: " + betmaster.getGestionLoteria().obtenerApuestasLoteriaPorSede(sedes[i]).get(j).getNumeroLoteria() + "\n";
	        			datosApuestasPorSede += "Serie: " + betmaster.getGestionLoteria().obtenerApuestasLoteriaPorSede(sedes[i]).get(j).getSerie() + "\n\n";
	        		}
	        		
	        		datosApuestasPorSede += "\nApuestas de Superastro:\n";
	        		
	        		for (int j = 0; j < betmaster.getGestionSuperAstro().obtenerApuestasSuperAstroPorSede(sedes[i]).size(); j++) {
	        			datosApuestasPorSede += "Dia: " + betmaster.getGestionSuperAstro().obtenerApuestasSuperAstroPorSede(sedes[i]).get(j).getDia() + "\n";
	        			datosApuestasPorSede += "Sede: " + betmaster.getGestionSuperAstro().obtenerApuestasSuperAstroPorSede(sedes[i]).get(j).getNombreSede() + "\n";
	        			datosApuestasPorSede += "Numeros seleccionados: " + Arrays.toString(betmaster.getGestionSuperAstro().obtenerApuestasSuperAstroPorSede(sedes[i]).get(j).getNumerosSeleccionados()) + "\n";
	        			datosApuestasPorSede += "Signo del zodiaco: " + betmaster.getGestionSuperAstro().obtenerApuestasSuperAstroPorSede(sedes[i]).get(j).getSignoDelZodiaco() + "\n\n";
	        		}
	        		
	        		datosApuestasPorSede += "\nApuestas de Baloto:\n";
	        		for (int j = 0; j < betmaster.getGestionBaloto().obtenerApuestasBalotoPorSede(sedes[i]).size(); j++) {
	        			datosApuestasPorSede += "Dia: " + betmaster.getGestionBaloto().obtenerApuestasBalotoPorSede(sedes[i]).get(j).getDia() + "\n";
	        			datosApuestasPorSede += "Sede: " + betmaster.getGestionBaloto().obtenerApuestasBalotoPorSede(sedes[i]).get(j).getNombreSede() + "\n";
	        			datosApuestasPorSede += "Numeros seleccionados" + betmaster.getGestionBaloto().obtenerApuestasBalotoPorSede(sedes[i]).get(j).getNumerosSeleccionados();
	        		}
	        		
	        		datosApuestasPorSede += "\nApuestas de betplay:\n";
	        		for (int j = 0; j < betmaster.getGestionBetPlay().obtenerApuestasBetPlayPorSede(sedes[i]).size(); j++) {
	        			datosApuestasPorSede += "Dia: " + betmaster.getGestionBetPlay().obtenerApuestasBetPlayPorSede(sedes[i]).get(j).getDia() + "\n";
	        			datosApuestasPorSede += "Sede: " + betmaster.getGestionBetPlay().obtenerApuestasBetPlayPorSede(sedes[i]).get(j).getNombreSede() + "\n";
	        			datosApuestasPorSede += "Valor: " + betmaster.getGestionBetPlay().obtenerApuestasBetPlayPorSede(sedes[i]).get(j).getValor() + "\n\n";
	        		}
	        		
	        		datosApuestasPorSede += "\nApuestas de chance:\n";
	        		for (int j = 0; j < betmaster.getGestionChance().obtenerApuestasChancePorCliente(sedes[i]).size(); j++) {
	        			datosApuestasPorSede += "Dia: " + betmaster.getGestionChance().obtenerApuestasChancePorCliente(sedes[i]).get(j).getDia() + "\n";
	        			datosApuestasPorSede += "Sede: " + betmaster.getGestionChance().obtenerApuestasChancePorCliente(sedes[i]).get(j).getNombreSede() + "\n";
	        			datosApuestasPorSede += "Nombre de la loteria: " + betmaster.getGestionChance().obtenerApuestasChancePorCliente(sedes[i]).get(j).getNombre() + "\n";
	        			datosApuestasPorSede += "Numeros seleccionados: " + betmaster.getGestionChance().obtenerApuestasChancePorCliente(sedes[i]).get(j).getNumerosSeleccionados() + "\n\n";
	        		}
	        		datosApuestasPorSede += "\n\n";
	        	}
	        	// Crear un JTextArea para mostrar los datos
	            JTextArea textArea2 = new JTextArea(datosApuestasPorSede);
	            textArea2.setEditable(false); // Para que el texto no sea editable
	            textArea2.setRows(35); // Establecer el número de filas visible del JTextArea

	            // Crear un JScrollPane y agregar el JTextArea a él
	            JScrollPane scrollPane2 = new JScrollPane(textArea2);

	            // Mostrar el JOptionPane con el JScrollPane como componente personalizado
	            JOptionPane.showMessageDialog(null, scrollPane2);
				
				break;
				
			case "Total de apuestas por sede":
				
				int totalApuestasPorSede = 0;
	        	String datosApPorSede = "";
	        	for (int i = 0; i < betmaster.getGestorDeSedes().obtenerSedesActuales().length; i++) {
	        		
	        		totalApuestasPorSede += betmaster.getGestionLoteria().obtenerNumeroApuestasLoteriaPorSede(betmaster.getGestorDeSedes().obtenerSedesActuales()[i]);
	        		totalApuestasPorSede += betmaster.getGestionSuperAstro().obtenerNumeroApuestasSuperAstroPorSede(betmaster.getGestorDeSedes().obtenerSedesActuales()[i]);
	        		totalApuestasPorSede += betmaster.getGestionBaloto().obtenerNumeroApuestasBalotoPorSede(betmaster.getGestorDeSedes().obtenerSedesActuales()[i]);
	        		totalApuestasPorSede += betmaster.getGestionBetPlay().obtenerNumeroApuestasBetPlayPorSede(betmaster.getGestorDeSedes().obtenerSedesActuales()[i]);
	        		totalApuestasPorSede += betmaster.getGestionChance().obtenerNumeroApuestasChancePorSede(betmaster.getGestorDeSedes().obtenerSedesActuales()[i]);
	        		datosApPorSede += "Total de apuestas en la sede " + betmaster.getGestorDeSedes().obtenerSedesActuales()[i] + ": " + totalApuestasPorSede + "\n\n";
	        	}
	        	JOptionPane.showMessageDialog(null, datosApPorSede);
				
				break;
			case "Total de apuestas por tipo de juego":
				
				String datosApPorJuego = "";
				datosApPorJuego += "Numero total de apuestas de loteria: " + betmaster.getGestionLoteria().getApuestasLoteria().size() + "\n";
	            datosApPorJuego += "Numero total de apuestas de superastro: " + betmaster.getGestionSuperAstro().getApuestasSuperAstro().size() + "\n";
	            datosApPorJuego += "Numero total de apuestas de baloto: " + betmaster.getGestionBaloto().getApuestasBaloto().size() + "\n";
	            datosApPorJuego += "Numero total de apuestas de betplay: " + betmaster.getGestionBetPlay().getApuestasBetPlay().size() + "\n";
	            datosApPorJuego += "Numero total de apuestas de chance: " + betmaster.getGestionChance().getApuestasChance().size() + "\n";
	            JOptionPane.showMessageDialog(null, datosApPorJuego);
				
				break;
		}
		
		
	}
}
