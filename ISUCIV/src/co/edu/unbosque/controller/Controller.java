package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import co.edu.unbosque.model.Carrera;
import co.edu.unbosque.model.Ciclista;
import co.edu.unbosque.model.CiclistaClasicomano;
import co.edu.unbosque.model.CiclistaContrarrelojista;
import co.edu.unbosque.model.CiclistaEmbalador;
import co.edu.unbosque.model.CiclistaEscalador;
import co.edu.unbosque.model.CiclistaGregario;
import co.edu.unbosque.model.CiclistaRodador;
import co.edu.unbosque.model.DirectorDeportivo;
import co.edu.unbosque.model.Escuadra;
import co.edu.unbosque.model.Masajista;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.persistence.FachadaISUCI;
import co.edu.unbosque.view.VentanaPrincipal;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements ActionListener {

	/** The fi. */
	private FachadaISUCI fi;
	
	/** The vp. */
	private VentanaPrincipal vp;

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		fi = new FachadaISUCI();
		vp = new VentanaPrincipal(this);
		vp.getPerfilDeUsuario().getTablaDeUsuarios().agregarUsuariosATabla(fi.getUsuarioDAO().obtener());
		vp.getPerfilDeMasajista().getTablaDeMasajistas().agregarMasajistasATabla(fi.getMasajistaDAO().obtener());
		vp.getPerfilDeDirectorDeportivo().getTablaDeDirectoresDeportivos()
				.agregarDirectoresDeportivosATabla(fi.getDirectorDeportivoDAO().obtener());
		vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getTablaDeCiclistasEscaladores()
				.agregarCiclistasEscaladoresATabla(fi.getCiclistaEscaladorDAO().obtener());
		vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getTablaDeCiclistasRodadores()
				.agregarCiclistasRodadoresATabla(fi.getCiclistaRodadorDAO().obtener());
		vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getTablaDeCiclistasEmbaladores()
				.agregarCiclistasEmbaladoresATabla(fi.getCiclistaEmbaladorDAO().obtener());
		vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getTablaDeCiclistasGregarios()
				.agregarCiclistasGregariosATabla(fi.getCiclistaGregarioDAO().obtener());
		vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getTablaDeCiclistasClasicomanos()
				.agregarCiclistasClasicomanosATabla(fi.getCiclistaClasicomanoDAO().obtener());
		vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getTablaDeCiclistasContrarrelojistas()
				.agregarCiclistasContrarrelojistasATabla(fi.getCiclistaContrarrelojistaDAO().obtener());
		vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
				.agregarEscuadrasATabla(fi.getEscuadraDAO().obtener());
		vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
				.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
		vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
				.agregarEscuadrasConCiclistasATabla(fi.getEscuadraDAO().obtener());
		vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
				.agregarMasajistasATabla(fi.getMasajistaDAO().obtener());
		vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
				.agregarDirectoresATabla(fi.getDirectorDeportivoDAO().obtener());
		vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
				.agregarEscuadrasATabla(fi.getEscuadraDAO().obtener());
		vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
				.actualizarTablaEscuadrasPersonas(fi.getEscuadraDAO().obtener());
		vp.getSimulacionDeCarrera().getTemporizador().addActionListener(this);
		vp.getSimulacionDeCarrera().getRegistroDeCiclistas()
				.agregarCiclistaACiclistasActuales(fi.obtenerTodosLosCiclistas());
		vp.setVisible(true);
	}

	/**
	 * Run.
	 */
	public void run() {
		vp.getPerfilDeUsuario().getCreacionDeUsuario().getBotonCrear().addActionListener(this);
		vp.getPerfilDeUsuario().getActualizacionDeUsuario().getBotonCargarDatos().addActionListener(this);
		vp.getPerfilDeUsuario().getActualizacionDeUsuario().getBotonActualizar().addActionListener(this);
		vp.getPerfilDeUsuario().getEliminacionDeUsuario().getBotonEliminar().addActionListener(this);

		vp.getPerfilDeMasajista().getCreacionDeMasajista().getBotonCrear().addActionListener(this);
		vp.getPerfilDeMasajista().getActualizacionDeMasajista().getBotonCargarDatos().addActionListener(this);
		vp.getPerfilDeMasajista().getActualizacionDeMasajista().getBotonActualizar().addActionListener(this);
		vp.getPerfilDeMasajista().getEliminacionDeMasajista().getBotonEliminar().addActionListener(this);

		vp.getPerfilDeDirectorDeportivo().getCreacionDeDirectorDeportivo().getBotonCrear().addActionListener(this);
		vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo().getBotonCargarDatos()
				.addActionListener(this);
		vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo().getBotonActualizar()
				.addActionListener(this);
		vp.getPerfilDeDirectorDeportivo().getEliminacionDeDirectorDeportivo().getBotonEliminar()
				.addActionListener(this);

		vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getCreacionDeCiclistaEscalador().getBotonCrear()
				.addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
				.getBotonCargarDatos().addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
				.getBotonActualizar().addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getEliminacionDeCiclistaEscalador().getBotonEliminar()
				.addActionListener(this);

		vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getCreacionDeCiclistaRodador().getBotonCrear()
				.addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getActualizacionDeCiclistaRodador().getBotonCargarDatos()
				.addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getActualizacionDeCiclistaRodador().getBotonActualizar()
				.addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getEliminacionDeCiclistaRodador().getBotonEliminar()
				.addActionListener(this);

		vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getCreacionDeCiclistaEmbalador().getBotonCrear()
				.addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getActualizacionDeCiclistaEmbalador()
				.getBotonCargarDatos().addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getActualizacionDeCiclistaEmbalador()
				.getBotonActualizar().addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getEliminacionDeCiclistaEmbalador().getBotonEliminar()
				.addActionListener(this);

		vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getCreacionDeCiclistaGregario().getBotonCrear()
				.addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getActualizacionDeCiclistaGregario()
				.getBotonCargarDatos().addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getActualizacionDeCiclistaGregario().getBotonActualizar()
				.addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getEliminacionDeCiclistaGregario().getBotonEliminar()
				.addActionListener(this);

		vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getCreacionDeCiclistaClasicomano().getBotonCrear()
				.addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getActualizacionDeCiclistaClasicomano()
				.getBotonCargarDatos().addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getActualizacionDeCiclistaClasicomano()
				.getBotonActualizar().addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getEliminacionDeCiclistaClasicomano()
				.getBotonEliminar().addActionListener(this);

		vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getCreacionDeCiclistaContrarrelojista()
				.getBotonCrear().addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getActualizacionDeCiclistaContrarrelojista()
				.getBotonCargarDatos().addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getActualizacionDeCiclistaContrarrelojista()
				.getBotonActualizar().addActionListener(this);
		vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getEliminacionDeCiclistaContrarrelojista()
				.getBotonEliminar().addActionListener(this);

		vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra().getBotonCrearEscuadra()
				.addActionListener(this);
		vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra().getBotonAgregarCiclista()
				.addActionListener(this);
		vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra().getBotonEliminarCiclista()
				.addActionListener(this);
		vp.getRegistroDeEscuadras().getEliminacionDeEscuadra().getBotonEliminar().addActionListener(this);

		vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas().getBotonAgregarMasajista()
				.addActionListener(this);
		vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas().getBotonAgregarDirector()
				.addActionListener(this);

		vp.getSimulacionDeCarrera().getBotonIniciarCarrera().addActionListener(this);

		vp.getSimulacionDeCarrera().getRegistroDeCiclistas().getBotonAgregarCiclistaACarrera().addActionListener(this);
		vp.getSimulacionDeCarrera().getRegistroDeCiclistas().getBotonQuitarCiclistaDeCarrera().addActionListener(this);
		vp.getSimulacionDeCarrera().getRegistroDeCiclistas().getBotonSimularCarrera().addActionListener(this);
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		eventosPerfilDeUsuario(e);
		eventosPerfilDeMasajista(e);
		eventosPerfilDeDirectorDeportivo(e);
		eventosPerfilDeCiclistaEscalador(e);
		eventosPerfilDeCiclistaRodador(e);
		eventosPerfilDeCiclistaEmbalador(e);
		eventosPerfilDeCiclistaGregario(e);
		eventosPerfilDeCiclistaClasicomano(e);
		eventosPerfilDeCiclistaContrarrelojista(e);
		eventosRegistroDeEscuadra(e);
		eventosAsignacionDePersonasAEquipos(e);
		eventosSimulacionDeCarrera(e);
	}

	/**
	 * Eventos perfil de usuario.
	 *
	 * @param e the e
	 */
	public void eventosPerfilDeUsuario(ActionEvent e) {
		if (e.getSource().equals(vp.getPerfilDeUsuario().getCreacionDeUsuario().getBotonCrear())) {
			if (vp.getPerfilDeUsuario().getCreacionDeUsuario().validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeUsuario().getCreacionDeUsuario().obtenerNumeroDeDocumento();
				Usuario usuarioExistente = fi.getUsuarioDAO().obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (usuarioExistente != null) {
					vp.getPerfilDeUsuario().getCreacionDeUsuario().mostrarMensajeNumeroDeDocumentoEncontrado();
					return;
				}
				String nombre = vp.getPerfilDeUsuario().getCreacionDeUsuario().obtenerNombre();
				String genero = vp.getPerfilDeUsuario().getCreacionDeUsuario().obtenerGenero();
				String correo = vp.getPerfilDeUsuario().getCreacionDeUsuario().obtenerCorreo();
				String clave = vp.getPerfilDeUsuario().getCreacionDeUsuario().obtenerClave();
				fi.getUsuarioDAO().agregar(new Usuario(numeroDeDocumento, nombre, genero, correo, clave));
				vp.getPerfilDeUsuario().getTablaDeUsuarios().agregarUsuariosATabla(fi.getUsuarioDAO().obtener());
				vp.getPerfilDeUsuario().getCreacionDeUsuario().reiniciarEntradas();
				vp.getPerfilDeUsuario().getCreacionDeUsuario().mostrarMensajeUsuarioCreado();
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeUsuario().getActualizacionDeUsuario().getBotonCargarDatos())) {
			if (vp.getPerfilDeUsuario().getActualizacionDeUsuario().validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeUsuario().getActualizacionDeUsuario()
						.obtenerNumeroDeDocumento();
				Usuario usuarioExistente = fi.getUsuarioDAO().obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (usuarioExistente == null) {
					vp.getPerfilDeUsuario().getActualizacionDeUsuario().mostrarMensajeNumeroDeDocumentoNoEncontrado();
					return;
				}
				vp.getPerfilDeUsuario().getActualizacionDeUsuario().establecerNombre(usuarioExistente.getNombre());
				vp.getPerfilDeUsuario().getActualizacionDeUsuario().establecerGenero(usuarioExistente.getGenero());
				vp.getPerfilDeUsuario().getActualizacionDeUsuario().establecerCorreo(usuarioExistente.getCorreo());
				vp.getPerfilDeUsuario().getActualizacionDeUsuario().establecerClave(usuarioExistente.getClave());
				vp.getPerfilDeUsuario().getActualizacionDeUsuario().habilitarEntradasYBotonActualizar();
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeUsuario().getActualizacionDeUsuario().getBotonActualizar())) {
			if (vp.getPerfilDeUsuario().getActualizacionDeUsuario().validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeUsuario().getActualizacionDeUsuario()
						.obtenerNumeroDeDocumento();
				Usuario usuarioExistente = fi.getUsuarioDAO().obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (usuarioExistente == null) {
					vp.getPerfilDeUsuario().getActualizacionDeUsuario().mostrarMensajeNumeroDeDocumentoNoEncontrado();
					return;
				}
				Usuario nuevoUsuario = new Usuario();
				nuevoUsuario.setNumeroDeDocumento(numeroDeDocumento);
				nuevoUsuario.setNombre(vp.getPerfilDeUsuario().getActualizacionDeUsuario().obtenerNombre());
				nuevoUsuario.setGenero(vp.getPerfilDeUsuario().getActualizacionDeUsuario().obtenerGenero());
				nuevoUsuario.setCorreo(vp.getPerfilDeUsuario().getActualizacionDeUsuario().obtenerCorreo());
				nuevoUsuario.setClave(vp.getPerfilDeUsuario().getActualizacionDeUsuario().obtenerClave());
				fi.getUsuarioDAO().actualizar(fi.getUsuarioDAO().getListaDeUsuarios().indexOf(usuarioExistente),
						nuevoUsuario);
				vp.getPerfilDeUsuario().getTablaDeUsuarios().agregarUsuariosATabla(fi.getUsuarioDAO().obtener());
				vp.getPerfilDeUsuario().getActualizacionDeUsuario().reiniciarEntradas();
				vp.getPerfilDeUsuario().getActualizacionDeUsuario().deshabilitarEntradasYBotonActualizar();
				vp.getPerfilDeUsuario().getActualizacionDeUsuario().mostrarMensajeUsuarioActualizado();
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeUsuario().getEliminacionDeUsuario().getBotonEliminar())) {
			if (vp.getPerfilDeUsuario().getEliminacionDeUsuario().validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeUsuario().getEliminacionDeUsuario().obtenerNumeroDeDocumento();
				Usuario usuarioExistente = fi.getUsuarioDAO().obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (usuarioExistente == null) {
					vp.getPerfilDeUsuario().getEliminacionDeUsuario().mostrarMensajeNumeroDeDocumentoNoEncontrado();
					return;
				}
				fi.getUsuarioDAO().eliminar(fi.getUsuarioDAO().getListaDeUsuarios().indexOf(usuarioExistente));
				vp.getPerfilDeUsuario().getTablaDeUsuarios().agregarUsuariosATabla(fi.getUsuarioDAO().obtener());
				vp.getPerfilDeUsuario().getEliminacionDeUsuario().establecerNumeroDeDocumento("");
				vp.getPerfilDeUsuario().getEliminacionDeUsuario().mostrarMensajeUsuarioEliminado();
			}
			return;
		}
	}

	/**
	 * Eventos perfil de masajista.
	 *
	 * @param e the e
	 */
	public void eventosPerfilDeMasajista(ActionEvent e) {
		if (e.getSource().equals(vp.getPerfilDeMasajista().getCreacionDeMasajista().getBotonCrear())) {
			if (vp.getPerfilDeMasajista().getCreacionDeMasajista().validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeMasajista().getCreacionDeMasajista()
						.obtenerNumeroDeDocumento();
				Masajista masajistaExistente = fi.getMasajistaDAO().obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (masajistaExistente != null) {
					vp.getPerfilDeMasajista().getCreacionDeMasajista().mostrarMensajeNumeroDeDocumentoEncontrado();
					return;
				}
				String nombre = vp.getPerfilDeMasajista().getCreacionDeMasajista().obtenerNombre();
				int aniosExperiencia = vp.getPerfilDeMasajista().getCreacionDeMasajista().obtenerAniosExperiencia();
				fi.getMasajistaDAO().agregar(new Masajista(numeroDeDocumento, nombre, aniosExperiencia));
				vp.getPerfilDeMasajista().getTablaDeMasajistas()
						.agregarMasajistasATabla(fi.getMasajistaDAO().obtener());
				vp.getPerfilDeMasajista().getCreacionDeMasajista().reiniciarEntradas();
				vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
						.agregarMasajistasATabla(fi.getMasajistaDAO().obtener());
				vp.getPerfilDeMasajista().getCreacionDeMasajista().mostrarMensajeMasajistaCreado();
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeMasajista().getActualizacionDeMasajista().getBotonCargarDatos())) {
			if (vp.getPerfilDeMasajista().getActualizacionDeMasajista().validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeMasajista().getActualizacionDeMasajista()
						.obtenerNumeroDeDocumento();
				Masajista masajistaExistente = fi.getMasajistaDAO().obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (masajistaExistente == null) {
					vp.getPerfilDeMasajista().getActualizacionDeMasajista()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
					return;
				}
				vp.getPerfilDeMasajista().getActualizacionDeMasajista()
						.establecerNombre(masajistaExistente.getNombre());
				vp.getPerfilDeMasajista().getActualizacionDeMasajista()
						.establecerAniosExperiencia(masajistaExistente.getAniosExperiencia());
				vp.getPerfilDeMasajista().getActualizacionDeMasajista().habilitarEntradasYBotonActualizar();
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeMasajista().getActualizacionDeMasajista().getBotonActualizar())) {
			if (vp.getPerfilDeMasajista().getActualizacionDeMasajista().validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeMasajista().getActualizacionDeMasajista()
						.obtenerNumeroDeDocumento();
				Masajista masajistaExistente = fi.getMasajistaDAO().obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (masajistaExistente == null) {
					vp.getPerfilDeMasajista().getActualizacionDeMasajista()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
					return;
				}
				Masajista nuevoMasajista = new Masajista();
				nuevoMasajista.setNumeroDeDocumento(numeroDeDocumento);
				nuevoMasajista.setNombre(vp.getPerfilDeMasajista().getActualizacionDeMasajista().obtenerNombre());
				nuevoMasajista.setAniosExperiencia(
						vp.getPerfilDeMasajista().getActualizacionDeMasajista().obtenerAniosExperiencia());
				fi.getMasajistaDAO().actualizar(fi.getMasajistaDAO().getListaDeMasajistas().indexOf(masajistaExistente),
						nuevoMasajista);
				vp.getPerfilDeMasajista().getTablaDeMasajistas()
						.agregarMasajistasATabla(fi.getMasajistaDAO().obtener());
				vp.getPerfilDeMasajista().getActualizacionDeMasajista().reiniciarEntradas();
				vp.getPerfilDeMasajista().getActualizacionDeMasajista().deshabilitarEntradasYBotonActualizar();
				vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
						.agregarMasajistasATabla(fi.getMasajistaDAO().obtener());
				vp.getPerfilDeMasajista().getActualizacionDeMasajista().mostrarMensajeMasajistaActualizado();
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeMasajista().getEliminacionDeMasajista().getBotonEliminar())) {
			if (vp.getPerfilDeMasajista().getEliminacionDeMasajista().validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeMasajista().getEliminacionDeMasajista()
						.obtenerNumeroDeDocumento();
				Masajista masajistaExistente = fi.getMasajistaDAO().obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (masajistaExistente == null) {
					vp.getPerfilDeMasajista().getEliminacionDeMasajista().mostrarMensajeNumeroDeDocumentoNoEncontrado();
					return;
				}
				fi.getMasajistaDAO().eliminar(fi.getMasajistaDAO().getListaDeMasajistas().indexOf(masajistaExistente));
				vp.getPerfilDeMasajista().getTablaDeMasajistas()
						.agregarMasajistasATabla(fi.getMasajistaDAO().obtener());
				vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
						.agregarMasajistasATabla(fi.getMasajistaDAO().obtener());
				vp.getPerfilDeMasajista().getEliminacionDeMasajista().establecerNumeroDeDocumento("");
				vp.getPerfilDeMasajista().getEliminacionDeMasajista().mostrarMensajeMasajistaEliminado();
			}
			return;
		}
	}

	/**
	 * Eventos perfil de director deportivo.
	 *
	 * @param e the e
	 */
	public void eventosPerfilDeDirectorDeportivo(ActionEvent e) {
		if (e.getSource().equals(vp.getPerfilDeDirectorDeportivo().getCreacionDeDirectorDeportivo().getBotonCrear())) {
			if (vp.getPerfilDeDirectorDeportivo().getCreacionDeDirectorDeportivo().validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeDirectorDeportivo().getCreacionDeDirectorDeportivo()
						.obtenerNumeroDeDocumento();
				DirectorDeportivo directorExistente = fi.getDirectorDeportivoDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (directorExistente != null) {
					vp.getPerfilDeDirectorDeportivo().getCreacionDeDirectorDeportivo()
							.mostrarMensajeNumeroDeDocumentoEncontrado();
					return;
				}
				String nombre = vp.getPerfilDeDirectorDeportivo().getCreacionDeDirectorDeportivo().obtenerNombre();
				String nacionalidad = vp.getPerfilDeDirectorDeportivo().getCreacionDeDirectorDeportivo()
						.obtenerNacionalidad();
				fi.getDirectorDeportivoDAO().agregar(new DirectorDeportivo(numeroDeDocumento, nombre, nacionalidad));
				vp.getPerfilDeDirectorDeportivo().getTablaDeDirectoresDeportivos()
						.agregarDirectoresDeportivosATabla(fi.getDirectorDeportivoDAO().obtener());
				vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
						.agregarDirectoresATabla(fi.getDirectorDeportivoDAO().obtener());
				vp.getPerfilDeDirectorDeportivo().getCreacionDeDirectorDeportivo().reiniciarEntradas();
				vp.getPerfilDeDirectorDeportivo().getCreacionDeDirectorDeportivo()
						.mostrarMensajeDirectorDeportivoCreado();
			}
			return;
		}

		if (e.getSource().equals(
				vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo().getBotonCargarDatos())) {
			if (vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo().validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo()
						.obtenerNumeroDeDocumento();
				DirectorDeportivo directorExistente = fi.getDirectorDeportivoDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (directorExistente == null) {
					vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
					return;
				}
				vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo()
						.establecerNombre(directorExistente.getNombre());
				vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo()
						.establecerNacionalidad(directorExistente.getNacionalidad());
				vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo()
						.habilitarEntradasYBotonActualizar();
			}
			return;
		}

		if (e.getSource()
				.equals(vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo().getBotonActualizar())) {
			if (vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo().validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo()
						.obtenerNumeroDeDocumento();
				DirectorDeportivo directorExistente = fi.getDirectorDeportivoDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (directorExistente == null) {
					vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
					return;
				}
				DirectorDeportivo nuevoDirector = new DirectorDeportivo();
				nuevoDirector.setNumeroDeDocumento(numeroDeDocumento);
				nuevoDirector.setNombre(
						vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo().obtenerNombre());
				nuevoDirector.setNacionalidad(
						vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo().obtenerNacionalidad());
				fi.getDirectorDeportivoDAO().actualizar(
						fi.getDirectorDeportivoDAO().getListaDeDirectoresDeportivos().indexOf(directorExistente),
						nuevoDirector);
				vp.getPerfilDeDirectorDeportivo().getTablaDeDirectoresDeportivos()
						.agregarDirectoresDeportivosATabla(fi.getDirectorDeportivoDAO().obtener());
				vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo().reiniciarEntradas();
				vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo()
						.deshabilitarEntradasYBotonActualizar();
				vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
						.agregarDirectoresATabla(fi.getDirectorDeportivoDAO().obtener());
				vp.getPerfilDeDirectorDeportivo().getActualizacionDeDirectorDeportivo()
						.mostrarMensajeDirectorDeportivoActualizado();
			}
			return;
		}

		if (e.getSource()
				.equals(vp.getPerfilDeDirectorDeportivo().getEliminacionDeDirectorDeportivo().getBotonEliminar())) {
			if (vp.getPerfilDeDirectorDeportivo().getEliminacionDeDirectorDeportivo().validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeDirectorDeportivo().getEliminacionDeDirectorDeportivo()
						.obtenerNumeroDeDocumento();
				DirectorDeportivo directorExistente = fi.getDirectorDeportivoDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (directorExistente == null) {
					vp.getPerfilDeDirectorDeportivo().getEliminacionDeDirectorDeportivo()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
					return;
				}
				fi.getDirectorDeportivoDAO().eliminar(
						fi.getDirectorDeportivoDAO().getListaDeDirectoresDeportivos().indexOf(directorExistente));
				vp.getPerfilDeDirectorDeportivo().getTablaDeDirectoresDeportivos()
						.agregarDirectoresDeportivosATabla(fi.getDirectorDeportivoDAO().obtener());
				vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
						.agregarDirectoresATabla(fi.getDirectorDeportivoDAO().obtener());
				vp.getPerfilDeDirectorDeportivo().getEliminacionDeDirectorDeportivo().establecerNumeroDeDocumento("");
				vp.getPerfilDeDirectorDeportivo().getEliminacionDeDirectorDeportivo()
						.mostrarMensajeDirectorDeportivoEliminado();
			}
			return;
		}
	}

	/**
	 * Eventos perfil de ciclista escalador.
	 *
	 * @param e the e
	 */
	public void eventosPerfilDeCiclistaEscalador(ActionEvent e) {
		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador()
				.getCreacionDeCiclistaEscalador().getBotonCrear())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getCreacionDeCiclistaEscalador()
					.validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador()
						.getCreacionDeCiclistaEscalador().obtenerNumeroDeDocumento();
				CiclistaEscalador ciclistaExistente = fi.getCiclistaEscaladorDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente != null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getCreacionDeCiclistaEscalador()
							.mostrarMensajeNumeroDeDocumentoEncontrado();
					return;
				}
				CiclistaEscalador nuevoCiclista = new CiclistaEscalador(numeroDeDocumento,
						vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getCreacionDeCiclistaEscalador()
								.obtenerNombre(),
						vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getCreacionDeCiclistaEscalador()
								.obtenerConEspecialidad(),
						(float) vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getCreacionDeCiclistaEscalador()
								.obtenerCadencia(),
						(float) vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getCreacionDeCiclistaEscalador()
								.obtenerAceleracionPromedio(),
						(float) vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getCreacionDeCiclistaEscalador()
								.obtenerGradoRampaSoportada());
				fi.getCiclistaEscaladorDAO().agregar(nuevoCiclista);
				vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getTablaDeCiclistasEscaladores()
						.agregarCiclistasEscaladoresATabla(fi.getCiclistaEscaladorDAO().obtener());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getCreacionDeCiclistaEscalador()
						.reiniciarEntradas();
				vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
						.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getCreacionDeCiclistaEscalador()
						.mostrarMensajeCiclistaEscaladorCreado();
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador()
				.getActualizacionDeCiclistaEscalador().getBotonCargarDatos())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
					.validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador()
						.getActualizacionDeCiclistaEscalador().obtenerNumeroDeDocumento();
				CiclistaEscalador ciclistaExistente = fi.getCiclistaEscaladorDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente == null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
				} else {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
							.establecerNombre(ciclistaExistente.getNombre());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
							.establecerCadencia(ciclistaExistente.getCadencia());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
							.establecerConEspecialidad(!ciclistaExistente.getEspecialidad().equals(""));
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
							.establecerAceleracionPromedio(ciclistaExistente.getAceleracionPromedio());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
							.establecerGradoRampaSoportada((int) ciclistaExistente.getGradoRampaSoportada());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
							.habilitarEntradasYBotonActualizar();
				}
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador()
				.getActualizacionDeCiclistaEscalador().getBotonActualizar())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
					.validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador()
						.getActualizacionDeCiclistaEscalador().obtenerNumeroDeDocumento();
				CiclistaEscalador ciclistaExistente = fi.getCiclistaEscaladorDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente == null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
					return;
				}
				CiclistaEscalador ciclistaActualizado = new CiclistaEscalador(numeroDeDocumento,
						vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
								.obtenerNombre(),
						vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
								.obtenerConEspecialidad(),
						(float) vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador()
								.getActualizacionDeCiclistaEscalador().obtenerCadencia(),
						(float) vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador()
								.getActualizacionDeCiclistaEscalador().obtenerAceleracionPromedio(),
						(float) vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador()
								.getActualizacionDeCiclistaEscalador().obtenerGradoRampaSoportada());
				fi.getCiclistaEscaladorDAO().actualizar(
						fi.getCiclistaEscaladorDAO().getListaDeCiclistasEscaladores().indexOf(ciclistaExistente),
						ciclistaActualizado);
				vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getTablaDeCiclistasEscaladores()
						.agregarCiclistasEscaladoresATabla(fi.getCiclistaEscaladorDAO().obtener());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
						.reiniciarEntradas();
				vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
						.deshabilitarEntradasYBotonActualizar();
				vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
						.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getActualizacionDeCiclistaEscalador()
						.mostrarMensajeCiclistaEscaladorActualizado();
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador()
				.getEliminacionDeCiclistaEscalador().getBotonEliminar())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getEliminacionDeCiclistaEscalador()
					.validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador()
						.getEliminacionDeCiclistaEscalador().obtenerNumeroDeDocumento();
				CiclistaEscalador ciclistaExistente = fi.getCiclistaEscaladorDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente == null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getEliminacionDeCiclistaEscalador()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
				} else {
					fi.getCiclistaEscaladorDAO().eliminar(
							fi.getCiclistaEscaladorDAO().getListaDeCiclistasEscaladores().indexOf(ciclistaExistente));
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getTablaDeCiclistasEscaladores()
							.agregarCiclistasEscaladoresATabla(fi.getCiclistaEscaladorDAO().obtener());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getEliminacionDeCiclistaRodador()
							.establecerNumeroDeDocumento("");
					vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
							.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEscalador().getEliminacionDeCiclistaEscalador()
							.mostrarMensajeCiclistaEscaladorEliminado();
				}
			}
			return;
		}
	}

	/**
	 * Eventos perfil de ciclista rodador.
	 *
	 * @param e the e
	 */
	public void eventosPerfilDeCiclistaRodador(ActionEvent e) {
		if (e.getSource().equals(
				vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getCreacionDeCiclistaRodador().getBotonCrear())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getCreacionDeCiclistaRodador()
					.validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador()
						.getCreacionDeCiclistaRodador().obtenerNumeroDeDocumento();
				CiclistaRodador ciclistaExistente = fi.getCiclistaRodadorDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente != null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getCreacionDeCiclistaRodador()
							.mostrarMensajeNumeroDeDocumentoEncontrado();
					return;
				}
				String nombre = vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getCreacionDeCiclistaRodador()
						.obtenerNombre();
				boolean conEspecialidad = vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador()
						.getCreacionDeCiclistaRodador().obtenerConEspecialidad();
				float cadencia = (float) vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador()
						.getCreacionDeCiclistaRodador().obtenerCadencia();
				CiclistaRodador nuevoCiclistaRodador = new CiclistaRodador(numeroDeDocumento, nombre, conEspecialidad,
						cadencia);
				fi.getCiclistaRodadorDAO().agregar(nuevoCiclistaRodador);
				vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getTablaDeCiclistasRodadores()
						.agregarCiclistasRodadoresATabla(fi.getCiclistaRodadorDAO().obtener());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getCreacionDeCiclistaRodador()
						.reiniciarEntradas();
				vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
						.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getCreacionDeCiclistaRodador()
						.mostrarMensajeCiclistaRodadorCreado();
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador()
				.getActualizacionDeCiclistaRodador().getBotonCargarDatos())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getActualizacionDeCiclistaRodador()
					.validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador()
						.getActualizacionDeCiclistaRodador().obtenerNumeroDeDocumento();
				CiclistaRodador ciclistaExistente = fi.getCiclistaRodadorDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente == null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getActualizacionDeCiclistaRodador()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
				} else {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getActualizacionDeCiclistaRodador()
							.establecerNombre(ciclistaExistente.getNombre());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getActualizacionDeCiclistaRodador()
							.establecerCadencia(ciclistaExistente.getCadencia());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getActualizacionDeCiclistaRodador()
							.establecerConEspecialidad(!ciclistaExistente.getEspecialidad().equals(""));
					vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getActualizacionDeCiclistaRodador()
							.habilitarEntradasYBotonActualizar();
				}
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador()
				.getActualizacionDeCiclistaRodador().getBotonActualizar())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getActualizacionDeCiclistaRodador()
					.validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador()
						.getActualizacionDeCiclistaRodador().obtenerNumeroDeDocumento();
				CiclistaRodador ciclistaExistente = fi.getCiclistaRodadorDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente != null) {
					String nombre = vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador()
							.getActualizacionDeCiclistaRodador().obtenerNombre();
					float cadencia = (float) vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador()
							.getActualizacionDeCiclistaRodador().obtenerCadencia();
					boolean conEspecialidad = vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador()
							.getActualizacionDeCiclistaRodador().obtenerConEspecialidad();
					CiclistaRodador ciclistaActualizado = new CiclistaRodador(numeroDeDocumento, nombre,
							conEspecialidad, cadencia);
					fi.getCiclistaRodadorDAO().actualizar(
							fi.getCiclistaRodadorDAO().getListaDeCiclistasRodadores().indexOf(ciclistaExistente),
							ciclistaActualizado);
					vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getTablaDeCiclistasRodadores()
							.agregarCiclistasRodadoresATabla(fi.getCiclistaRodadorDAO().obtener());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getActualizacionDeCiclistaRodador()
							.reiniciarEntradas();
					vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getActualizacionDeCiclistaRodador()
							.deshabilitarEntradasYBotonActualizar();
					vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
							.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getActualizacionDeCiclistaRodador()
							.mostrarMensajeCiclistaRodadorActualizado();
				}
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getEliminacionDeCiclistaRodador()
				.obtenerBotonEliminar())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getEliminacionDeCiclistaRodador()
					.validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador()
						.getEliminacionDeCiclistaRodador().obtenerNumeroDeDocumento();
				CiclistaRodador ciclistaExistente = fi.getCiclistaRodadorDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente == null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getEliminacionDeCiclistaRodador()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
				} else {
					fi.getCiclistaRodadorDAO().eliminar(
							fi.getCiclistaRodadorDAO().getListaDeCiclistasRodadores().indexOf(ciclistaExistente));
					vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getTablaDeCiclistasRodadores()
							.agregarCiclistasRodadoresATabla(fi.getCiclistaRodadorDAO().obtener());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getEliminacionDeCiclistaRodador()
							.establecerNumeroDeDocumento("");
					vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
							.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaRodador().getEliminacionDeCiclistaRodador()
							.mostrarMensajeCiclistaRodadorEliminado();
				}
			}
			return;
		}
	}

	/**
	 * Eventos perfil de ciclista embalador.
	 *
	 * @param e the e
	 */
	public void eventosPerfilDeCiclistaEmbalador(ActionEvent e) {
		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
				.getCreacionDeCiclistaEmbalador().getBotonCrear())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getCreacionDeCiclistaEmbalador()
					.validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
						.getCreacionDeCiclistaEmbalador().obtenerNumeroDeDocumento();
				CiclistaEmbalador ciclistaExistente = fi.getCiclistaEmbaladorDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente != null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getCreacionDeCiclistaEmbalador()
							.mostrarMensajeNumeroDeDocumentoEncontrado();
					return;
				}
				String nombre = vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getCreacionDeCiclistaEmbalador()
						.obtenerNombre();
				boolean conEspecialidad = vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
						.getCreacionDeCiclistaEmbalador().obtenerConEspecialidad();
				float cadencia = (float) vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
						.getCreacionDeCiclistaEmbalador().obtenerCadencia();
				float potenciaPromedio = (float) vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
						.getCreacionDeCiclistaEmbalador().obtenerPotenciaPromedio();
				float velocidadPromedioEnSprint = (float) vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
						.getCreacionDeCiclistaEmbalador().obtenerVelocidadPromedioEnSprint();
				CiclistaEmbalador nuevoCiclistaEmbalador = new CiclistaEmbalador(numeroDeDocumento, nombre,
						conEspecialidad, cadencia, potenciaPromedio, velocidadPromedioEnSprint);
				fi.getCiclistaEmbaladorDAO().agregar(nuevoCiclistaEmbalador);
				vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getTablaDeCiclistasEmbaladores()
						.agregarCiclistasEmbaladoresATabla(fi.getCiclistaEmbaladorDAO().obtener());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getCreacionDeCiclistaEmbalador()
						.reiniciarEntradas();
				vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
						.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getCreacionDeCiclistaEmbalador()
						.mostrarMensajeCiclistaEmbaladorCreado();
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
				.getActualizacionDeCiclistaEmbalador().getBotonCargarDatos())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getActualizacionDeCiclistaEmbalador()
					.validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
						.getActualizacionDeCiclistaEmbalador().obtenerNumeroDeDocumento();
				CiclistaEmbalador ciclistaExistente = fi.getCiclistaEmbaladorDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente == null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getActualizacionDeCiclistaEmbalador()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
				} else {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getActualizacionDeCiclistaEmbalador()
							.establecerNombre(ciclistaExistente.getNombre());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getActualizacionDeCiclistaEmbalador()
							.establecerCadencia(ciclistaExistente.getCadencia());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getActualizacionDeCiclistaEmbalador()
							.establecerConEspecialidad(!ciclistaExistente.getEspecialidad().equals(""));
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getActualizacionDeCiclistaEmbalador()
							.establecerPotenciaPromedio(ciclistaExistente.getPotenciaPromedio());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getActualizacionDeCiclistaEmbalador()
							.establecerVelocidadPromedioEnSprint(ciclistaExistente.getVelocidadPromedioEnSprint());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getActualizacionDeCiclistaEmbalador()
							.habilitarEntradasYBotonActualizar();
				}
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
				.getActualizacionDeCiclistaEmbalador().getBotonActualizar())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getActualizacionDeCiclistaEmbalador()
					.validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
						.getActualizacionDeCiclistaEmbalador().obtenerNumeroDeDocumento();
				CiclistaEmbalador ciclistaExistente = fi.getCiclistaEmbaladorDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente != null) {
					CiclistaEmbalador ciclistaActualizado = new CiclistaEmbalador(numeroDeDocumento,
							vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
									.getActualizacionDeCiclistaEmbalador().obtenerNombre(),
							vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
									.getActualizacionDeCiclistaEmbalador().obtenerConEspecialidad(),
							(float) vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
									.getActualizacionDeCiclistaEmbalador().obtenerCadencia(),
							(float) vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
									.getActualizacionDeCiclistaEmbalador().obtenerPotenciaPromedio(),
							(float) vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
									.getActualizacionDeCiclistaEmbalador().obtenerVelocidadPromedioEnSprint());
					fi.getCiclistaEmbaladorDAO().actualizar(
							fi.getCiclistaEmbaladorDAO().getListaDeCiclistasEmbaladores().indexOf(ciclistaExistente),
							ciclistaActualizado);
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getTablaDeCiclistasEmbaladores()
							.agregarCiclistasEmbaladoresATabla(fi.getCiclistaEmbaladorDAO().obtener());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getActualizacionDeCiclistaEmbalador()
							.reiniciarEntradas();
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getActualizacionDeCiclistaEmbalador()
							.deshabilitarEntradasYBotonActualizar();
					vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
							.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getActualizacionDeCiclistaEmbalador()
							.mostrarMensajeCiclistaEmbaladorActualizado();
				}
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
				.getEliminacionDeCiclistaEmbalador().getBotonEliminar())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getEliminacionDeCiclistaEmbalador()
					.validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador()
						.getEliminacionDeCiclistaEmbalador().obtenerNumeroDeDocumento();
				CiclistaEmbalador ciclistaExistente = fi.getCiclistaEmbaladorDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente == null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getEliminacionDeCiclistaEmbalador()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
				} else {
					fi.getCiclistaEmbaladorDAO().eliminar(
							fi.getCiclistaEmbaladorDAO().getListaDeCiclistasEmbaladores().indexOf(ciclistaExistente));
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getTablaDeCiclistasEmbaladores()
							.agregarCiclistasEmbaladoresATabla(fi.getCiclistaEmbaladorDAO().obtener());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getEliminacionDeCiclistaEmbalador()
							.establecerNumeroDeDocumento("");
					vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
							.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaEmbalador().getEliminacionDeCiclistaEmbalador()
							.mostrarMensajeCiclistaEmbaladorEliminado();
				}
			}
			return;
		}
	}

	/**
	 * Eventos perfil de ciclista gregario.
	 *
	 * @param e the e
	 */
	public void eventosPerfilDeCiclistaGregario(ActionEvent e) {
		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getCreacionDeCiclistaGregario()
				.getBotonCrear())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getCreacionDeCiclistaGregario()
					.validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario()
						.getCreacionDeCiclistaGregario().obtenerNumeroDeDocumento();
				CiclistaGregario ciclistaExistente = fi.getCiclistaGregarioDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente != null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getCreacionDeCiclistaGregario()
							.mostrarMensajeNumeroDeDocumentoEncontrado();
					return;
				}
				String nombre = vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getCreacionDeCiclistaGregario()
						.obtenerNombre();
				boolean conEspecialidad = vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario()
						.getCreacionDeCiclistaGregario().obtenerConEspecialidad();
				float cadencia = (float) vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario()
						.getCreacionDeCiclistaGregario().obtenerCadencia();
				String funcionEnPeloton = vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario()
						.getCreacionDeCiclistaGregario().obtenerFuncionEnPeloton();
				CiclistaGregario nuevoCiclistaGregario = new CiclistaGregario(numeroDeDocumento, nombre,
						conEspecialidad, cadencia, funcionEnPeloton);
				fi.getCiclistaGregarioDAO().agregar(nuevoCiclistaGregario);
				vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getTablaDeCiclistasGregarios()
						.agregarCiclistasGregariosATabla(fi.getCiclistaGregarioDAO().obtener());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getCreacionDeCiclistaGregario()
						.reiniciarEntradas();
				vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
						.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getCreacionDeCiclistaGregario()
						.mostrarMensajeCiclistaGregarioCreado();
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario()
				.getActualizacionDeCiclistaGregario().getBotonCargarDatos())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getActualizacionDeCiclistaGregario()
					.validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario()
						.getActualizacionDeCiclistaGregario().obtenerNumeroDeDocumento();
				CiclistaGregario ciclistaExistente = fi.getCiclistaGregarioDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente == null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getActualizacionDeCiclistaGregario()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
				} else {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getActualizacionDeCiclistaGregario()
							.establecerNombre(ciclistaExistente.getNombre());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getActualizacionDeCiclistaGregario()
							.establecerCadencia(ciclistaExistente.getCadencia());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getActualizacionDeCiclistaGregario()
							.establecerConEspecialidad(!ciclistaExistente.getEspecialidad().equals(""));
					vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getActualizacionDeCiclistaGregario()
							.establecerFuncionEnPeloton(ciclistaExistente.getFuncionEnPeloton());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getActualizacionDeCiclistaGregario()
							.habilitarEntradasYBotonActualizar();
				}
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario()
				.getActualizacionDeCiclistaGregario().getBotonActualizar())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getActualizacionDeCiclistaGregario()
					.validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario()
						.getActualizacionDeCiclistaGregario().obtenerNumeroDeDocumento();
				CiclistaGregario ciclistaExistente = fi.getCiclistaGregarioDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente != null) {
					String nombre = vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario()
							.getActualizacionDeCiclistaGregario().obtenerNombre();
					float cadencia = (float) vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario()
							.getActualizacionDeCiclistaGregario().obtenerCadencia();
					boolean conEspecialidad = vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario()
							.getActualizacionDeCiclistaGregario().obtenerConEspecialidad();
					String funcionEnPeloton = vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario()
							.getActualizacionDeCiclistaGregario().obtenerFuncionEnPeloton();
					CiclistaGregario ciclistaActualizado = new CiclistaGregario(numeroDeDocumento, nombre,
							conEspecialidad, cadencia, funcionEnPeloton);
					fi.getCiclistaGregarioDAO().actualizar(
							fi.getCiclistaGregarioDAO().getListaDeCiclistasGregarios().indexOf(ciclistaExistente),
							ciclistaActualizado);
					vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getTablaDeCiclistasGregarios()
							.agregarCiclistasGregariosATabla(fi.getCiclistaGregarioDAO().obtener());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getActualizacionDeCiclistaGregario()
							.reiniciarEntradas();
					vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getActualizacionDeCiclistaGregario()
							.deshabilitarEntradasYBotonActualizar();
					vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
							.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getActualizacionDeCiclistaGregario()
							.mostrarMensajeCiclistaGregarioActualizado();
				}
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario()
				.getEliminacionDeCiclistaGregario().getBotonEliminar())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getEliminacionDeCiclistaGregario()
					.validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario()
						.getEliminacionDeCiclistaGregario().obtenerNumeroDeDocumento();
				CiclistaGregario ciclistaExistente = fi.getCiclistaGregarioDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente == null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getEliminacionDeCiclistaGregario()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
				} else {
					fi.getCiclistaGregarioDAO().eliminar(
							fi.getCiclistaGregarioDAO().getListaDeCiclistasGregarios().indexOf(ciclistaExistente));
					vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getTablaDeCiclistasGregarios()
							.agregarCiclistasGregariosATabla(fi.getCiclistaGregarioDAO().obtener());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getEliminacionDeCiclistaGregario()
							.establecerNumeroDeDocumento("");
					vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
							.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaGregario().getEliminacionDeCiclistaGregario()
							.mostrarMensajeCiclistaGregarioEliminado();
				}
			}
			return;
		}
	}

	/**
	 * Eventos perfil de ciclista clasicomano.
	 *
	 * @param e the e
	 */
	public void eventosPerfilDeCiclistaClasicomano(ActionEvent e) {
		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
				.getCreacionDeCiclistaClasicomano().getBotonCrear())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getCreacionDeCiclistaClasicomano()
					.validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
						.getCreacionDeCiclistaClasicomano().obtenerNumeroDeDocumento();
				CiclistaClasicomano ciclistaExistente = fi.getCiclistaClasicomanoDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente != null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getCreacionDeCiclistaClasicomano()
							.mostrarMensajeNumeroDeDocumentoEncontrado();
					return;
				}
				String nombre = vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
						.getCreacionDeCiclistaClasicomano().obtenerNombre();
				boolean conEspecialidad = vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
						.getCreacionDeCiclistaClasicomano().obtenerConEspecialidad();
				double cadencia = vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
						.getCreacionDeCiclistaClasicomano().obtenerCadencia();
				int numeroClasicosGanados = vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
						.getCreacionDeCiclistaClasicomano().obtenerNumeroClasicosGanados();
				CiclistaClasicomano nuevoCiclista = new CiclistaClasicomano(numeroDeDocumento, nombre, conEspecialidad,
						(float) cadencia, numeroClasicosGanados);
				fi.getCiclistaClasicomanoDAO().agregar(nuevoCiclista);
				vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getTablaDeCiclistasClasicomanos()
						.agregarCiclistasClasicomanosATabla(fi.getCiclistaClasicomanoDAO().obtener());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getCreacionDeCiclistaClasicomano()
						.reiniciarEntradas();
				vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
						.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getCreacionDeCiclistaClasicomano()
						.mostrarMensajeCiclistaClasicomanoCreado();
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
				.getActualizacionDeCiclistaClasicomano().getBotonCargarDatos())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getActualizacionDeCiclistaClasicomano()
					.validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
						.getActualizacionDeCiclistaClasicomano().obtenerNumeroDeDocumento();
				CiclistaClasicomano ciclistaExistente = fi.getCiclistaClasicomanoDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente == null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getActualizacionDeCiclistaClasicomano()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
				} else {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getActualizacionDeCiclistaClasicomano()
							.establecerNombre(ciclistaExistente.getNombre());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getActualizacionDeCiclistaClasicomano()
							.establecerCadencia(ciclistaExistente.getCadencia());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getActualizacionDeCiclistaClasicomano()
							.establecerConEspecialidad(!ciclistaExistente.getEspecialidad().equals(""));
					vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getActualizacionDeCiclistaClasicomano()
							.establecerNumeroClasicosGanados(ciclistaExistente.getNumeroClasicosGanados());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getActualizacionDeCiclistaClasicomano()
							.habilitarEntradasYBotonActualizar();
				}
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
				.getActualizacionDeCiclistaClasicomano().getBotonActualizar())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getActualizacionDeCiclistaClasicomano()
					.validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
						.getActualizacionDeCiclistaClasicomano().obtenerNumeroDeDocumento();
				CiclistaClasicomano ciclistaExistente = fi.getCiclistaClasicomanoDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente == null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getActualizacionDeCiclistaClasicomano()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
					return;
				}
				CiclistaClasicomano ciclistaActualizado = new CiclistaClasicomano(numeroDeDocumento,
						vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
								.getActualizacionDeCiclistaClasicomano().obtenerNombre(),
						vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
								.getActualizacionDeCiclistaClasicomano().obtenerConEspecialidad(),
						(float) vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
								.getActualizacionDeCiclistaClasicomano().obtenerCadencia(),
						vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
								.getActualizacionDeCiclistaClasicomano().obtenerNumeroClasicosGanados());
				fi.getCiclistaClasicomanoDAO().actualizar(
						fi.getCiclistaClasicomanoDAO().getListaDeCiclistasClasicomanos().indexOf(ciclistaExistente),
						ciclistaActualizado);
				vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getTablaDeCiclistasClasicomanos()
						.agregarCiclistasClasicomanosATabla(fi.getCiclistaClasicomanoDAO().obtener());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getActualizacionDeCiclistaClasicomano()
						.reiniciarEntradas();
				vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getActualizacionDeCiclistaClasicomano()
						.deshabilitarEntradasYBotonActualizar();
				vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
						.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getActualizacionDeCiclistaClasicomano()
						.mostrarMensajeCiclistaClasicomanoActualizado();
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
				.getEliminacionDeCiclistaClasicomano().getBotonEliminar())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getEliminacionDeCiclistaClasicomano()
					.validarNumeroDeDocumento()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano()
						.getEliminacionDeCiclistaClasicomano().obtenerNumeroDeDocumento();
				CiclistaClasicomano ciclistaExistente = fi.getCiclistaClasicomanoDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente == null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getEliminacionDeCiclistaClasicomano()
							.mostrarMensajeNumeroDeDocumentoNoEncontrado();
				} else {
					fi.getCiclistaClasicomanoDAO().eliminar(fi.getCiclistaClasicomanoDAO()
							.getListaDeCiclistasClasicomanos().indexOf(ciclistaExistente));
					vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getTablaDeCiclistasClasicomanos()
							.agregarCiclistasClasicomanosATabla(fi.getCiclistaClasicomanoDAO().obtener());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getEliminacionDeCiclistaClasicomano()
							.establecerNumeroDeDocumento("");
					vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
							.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
					vp.getPerfilDeCiclista().getPerfilDeCiclistaClasicomano().getEliminacionDeCiclistaClasicomano()
							.mostrarMensajeCiclistaClasicomanoEliminado();
				}
			}
			return;
		}
	}

	/**
	 * Eventos perfil de ciclista contrarrelojista.
	 *
	 * @param e the e
	 */
	public void eventosPerfilDeCiclistaContrarrelojista(ActionEvent e) {
		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
				.getCreacionDeCiclistaContrarrelojista().getBotonCrear())) {
			if (vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getCreacionDeCiclistaContrarrelojista()
					.validarEntradas()) {
				String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
						.getCreacionDeCiclistaContrarrelojista().obtenerNumeroDeDocumento();
				CiclistaContrarrelojista ciclistaExistente = fi.getCiclistaContrarrelojistaDAO()
						.obtenerPorNumeroDeDocumento(numeroDeDocumento);
				if (ciclistaExistente != null) {
					vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
							.getCreacionDeCiclistaContrarrelojista().mostrarMensajeNumeroDeDocumentoEncontrado();
					return;
				}
				String nombre = vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
						.getCreacionDeCiclistaContrarrelojista().obtenerNombre();
				boolean conEspecialidad = vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
						.getCreacionDeCiclistaContrarrelojista().obtenerConEspecialidad();
				float cadencia = (float) vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
						.getCreacionDeCiclistaContrarrelojista().obtenerCadencia();
				float velocidadMaxima = (float) vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
						.getCreacionDeCiclistaContrarrelojista().obtenerVelocidadMaxima();
				CiclistaContrarrelojista nuevoCiclista = new CiclistaContrarrelojista(numeroDeDocumento, nombre,
						conEspecialidad, cadencia, velocidadMaxima);
				fi.getCiclistaContrarrelojistaDAO().agregar(nuevoCiclista);
				vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getTablaDeCiclistasContrarrelojistas()
						.agregarCiclistasContrarrelojistasATabla(fi.getCiclistaContrarrelojistaDAO().obtener());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getCreacionDeCiclistaContrarrelojista()
						.reiniciarEntradas();
				vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
						.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getCreacionDeCiclistaContrarrelojista()
						.mostrarMensajeCiclistaContrarrelojistaCreado();
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
				.getActualizacionDeCiclistaContrarrelojista().getBotonCargarDatos())) {
			String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
					.getActualizacionDeCiclistaContrarrelojista().obtenerNumeroDeDocumento();
			if (!vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
					.getActualizacionDeCiclistaContrarrelojista().validarNumeroDeDocumento()) {
				return;
			}
			CiclistaContrarrelojista ciclista = fi.getCiclistaContrarrelojistaDAO()
					.obtenerPorNumeroDeDocumento(numeroDeDocumento);
			if (ciclista == null) {
				vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
						.getActualizacionDeCiclistaContrarrelojista().mostrarMensajeNumeroDeDocumentoNoEncontrado();
			} else {
				vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
						.getActualizacionDeCiclistaContrarrelojista().establecerNombre(ciclista.getNombre());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
						.getActualizacionDeCiclistaContrarrelojista().establecerCadencia(ciclista.getCadencia());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
						.getActualizacionDeCiclistaContrarrelojista()
						.establecerConEspecialidad(!ciclista.getEspecialidad().equals(""));
				vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
						.getActualizacionDeCiclistaContrarrelojista()
						.establecerVelocidadMaxima(ciclista.getVelocidadMaxima());
				vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
						.getActualizacionDeCiclistaContrarrelojista().habilitarEntradasYBotonActualizar();
			}
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
				.getActualizacionDeCiclistaContrarrelojista().getBotonActualizar())) {
			if (!vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
					.getActualizacionDeCiclistaContrarrelojista().validarEntradas()) {
				return;
			}
			String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
					.getActualizacionDeCiclistaContrarrelojista().obtenerNumeroDeDocumento();
			CiclistaContrarrelojista ciclista = fi.getCiclistaContrarrelojistaDAO()
					.obtenerPorNumeroDeDocumento(numeroDeDocumento);
			if (ciclista == null) {
				vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
						.getActualizacionDeCiclistaContrarrelojista().mostrarMensajeNumeroDeDocumentoNoEncontrado();
				return;
			}
			String nombre = vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
					.getActualizacionDeCiclistaContrarrelojista().obtenerNombre();
			float cadencia = (float) vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
					.getActualizacionDeCiclistaContrarrelojista().obtenerCadencia();
			boolean conEspecialidad = vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
					.getActualizacionDeCiclistaContrarrelojista().obtenerConEspecialidad();
			float velocidadMaxima = (float) vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
					.getActualizacionDeCiclistaContrarrelojista().obtenerVelocidadMaxima();
			CiclistaContrarrelojista ciclistaActualizado = new CiclistaContrarrelojista(numeroDeDocumento, nombre,
					conEspecialidad, cadencia, velocidadMaxima);
			fi.getCiclistaContrarrelojistaDAO().actualizar(
					fi.getCiclistaContrarrelojistaDAO().getListaDeCiclistasContrarrelojistas().indexOf(ciclista),
					ciclistaActualizado);
			vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getTablaDeCiclistasContrarrelojistas()
					.agregarCiclistasContrarrelojistasATabla(fi.getCiclistaContrarrelojistaDAO().obtener());
			vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getActualizacionDeCiclistaContrarrelojista()
					.reiniciarEntradas();
			vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getActualizacionDeCiclistaContrarrelojista()
					.deshabilitarEntradasYBotonActualizar();
			vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
					.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
			vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getActualizacionDeCiclistaContrarrelojista()
					.mostrarMensajeCiclistaContrarrelojistaActualizado();
			return;
		}

		if (e.getSource().equals(vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
				.getEliminacionDeCiclistaContrarrelojista().getBotonEliminar())) {
			if (!vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
					.getEliminacionDeCiclistaContrarrelojista().validarNumeroDeDocumento()) {
				return;
			}
			String numeroDeDocumento = vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
					.getEliminacionDeCiclistaContrarrelojista().obtenerNumeroDeDocumento();
			CiclistaContrarrelojista ciclista = fi.getCiclistaContrarrelojistaDAO()
					.obtenerPorNumeroDeDocumento(numeroDeDocumento);
			if (ciclista == null) {
				vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista()
						.getEliminacionDeCiclistaContrarrelojista().mostrarMensajeNumeroDeDocumentoNoEncontrado();
				return;
			}
			fi.getCiclistaContrarrelojistaDAO().eliminar(
					fi.getCiclistaContrarrelojistaDAO().getListaDeCiclistasContrarrelojistas().indexOf(ciclista));
			vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getTablaDeCiclistasContrarrelojistas()
					.agregarCiclistasContrarrelojistasATabla(fi.getCiclistaContrarrelojistaDAO().obtener());
			vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getEliminacionDeCiclistaContrarrelojista()
					.establecerNumeroDeDocumento("");
			vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
					.agregarCiclistasATabla(fi.obtenerTodosLosCiclistas());
			vp.getPerfilDeCiclista().getPerfilDeCiclistaContrarrelojista().getEliminacionDeCiclistaContrarrelojista()
					.mostrarMensajeCiclistaContrarrelojistaEliminado();
		}
	}

	/**
	 * Eventos registro de escuadra.
	 *
	 * @param e the e
	 */
	public void eventosRegistroDeEscuadra(ActionEvent e) {
		if (e.getSource()
				.equals(vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra().getBotonCrearEscuadra())) {
			if (!vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra().validarEntradas()) {
				return;
			}
			String nombreDeEscuadra = vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra().obtenerNombre();
			if (fi.getEscuadraDAO().obtenerPorNombre(nombreDeEscuadra) != null) {
				vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra()
						.mostrarMensajeNombreDeEscuadraEncontrado();
				return;
			}
			String paisDeOrigen = (String) vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra()
					.obtenerPaisDeOrigenSeleccionado();
			Escuadra nuevaEscuadra = null;
			if (paisDeOrigen == null) {
				nuevaEscuadra = new Escuadra(nombreDeEscuadra);
			} else {
				nuevaEscuadra = new Escuadra(nombreDeEscuadra, paisDeOrigen);
			}
			fi.getEscuadraDAO().agregar(nuevaEscuadra);
			vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
					.agregarEscuadrasATabla(fi.getEscuadraDAO().obtener());
			vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
					.agregarEscuadrasConCiclistasATabla(fi.getEscuadraDAO().obtener());
			vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra().reiniciarEntradas();
			vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
					.agregarEscuadrasATabla(fi.getEscuadraDAO().obtener());
			vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra().mostrarMensajeEscuadraCreada();
			return;
		}

		if (e.getSource().equals(vp.getRegistroDeEscuadras().getEliminacionDeEscuadra().getBotonEliminar())) {
			if (!vp.getRegistroDeEscuadras().getEliminacionDeEscuadra().validarNombreDeLaEscuadra()) {
				return;
			}
			String nombreDeLaEscuadra = vp.getRegistroDeEscuadras().getEliminacionDeEscuadra()
					.obtenerNombreDeLaEscuadra();
			Escuadra escuadra = fi.getEscuadraDAO().obtenerPorNombre(nombreDeLaEscuadra);
			if (escuadra == null) {
				vp.getRegistroDeEscuadras().getEliminacionDeEscuadra().mostrarMensajeNombreDeLaEscuadraNoEncontrado();
				return;
			}
			fi.getEscuadraDAO().eliminar(fi.getEscuadraDAO().getListaDeEscuadras().indexOf(escuadra));
			vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
					.agregarEscuadrasATabla(fi.getEscuadraDAO().obtener());
			vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
					.agregarEscuadrasConCiclistasATabla(fi.getEscuadraDAO().obtener());
			vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
					.agregarEscuadrasATabla(fi.getEscuadraDAO().obtener());
			vp.getRegistroDeEscuadras().getEliminacionDeEscuadra().establecerNombreDeLaEscuadra("");
			vp.getRegistroDeEscuadras().getEliminacionDeEscuadra().mostrarMensajeEscuadraEliminada();
			return;
		}

		if (e.getSource()
				.equals(vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra().getBotonAgregarCiclista())) {
			if (!vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra().validarEntradasAgregarCiclista()) {
				return;
			}
			String numeroDeDocumentoCiclista = vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra()
					.obtenerNumeroDeDocumentoCiclista();
			String nombreDeEscuadra = vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra()
					.obtenerNombreDeEscuadra();
			Ciclista ciclista = fi.obtenerCiclistaPorNumeroDeDocumento(numeroDeDocumentoCiclista);
			Escuadra escuadra = fi.getEscuadraDAO().obtenerPorNombre(nombreDeEscuadra);

			if (ciclista == null) {
				vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra()
						.mostrarMensajeNumeroDeDocumentoDeCiclistaNoEncontrado();
				return;
			}

			if (escuadra == null) {
				vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra()
						.mostrarMensajeNombreDeEscuadraNoEncontrado();
				return;
			}

			if (fi.getEscuadraDAO().ciclistaYaEnEscuadra(ciclista, escuadra)) {
				vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra().mostrarMensajeCiclistaYaEnEscuadra();
				return;
			}

			fi.getEscuadraDAO().agregarCiclistaAEscuadra(ciclista, escuadra);
			vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
					.agregarEscuadrasConCiclistasATabla(fi.getEscuadraDAO().obtener());
			vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
					.agregarEscuadrasATabla(fi.getEscuadraDAO().obtener());
			vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra().mostrarMensajeCiclistaAgregadoAEscuadra();
			return;
		}

		if (e.getSource()
				.equals(vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra().getBotonEliminarCiclista())) {
			if (!vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra().validarEntradasAgregarCiclista()) {
				return;
			}
			String numeroDeDocumentoCiclista = vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra()
					.obtenerNumeroDeDocumentoCiclista();
			String nombreDeEscuadra = vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra()
					.obtenerNombreDeEscuadra();
			Ciclista ciclista = fi.obtenerCiclistaPorNumeroDeDocumento(numeroDeDocumentoCiclista);
			Escuadra escuadra = fi.getEscuadraDAO().obtenerPorNombre(nombreDeEscuadra);

			if (ciclista == null) {
				vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra()
						.mostrarMensajeNumeroDeDocumentoDeCiclistaNoEncontrado();
				return;
			}

			if (escuadra == null) {
				vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra()
						.mostrarMensajeNombreDeEscuadraNoEncontrado();
				return;
			}

			if (!fi.getEscuadraDAO().ciclistaYaEnEscuadra(ciclista, escuadra)) {
				vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra().mostrarMensajeCiclistaNoEnEscuadra();
				return;
			}

			fi.getEscuadraDAO().eliminarCiclistaDeEscuadra(ciclista, escuadra);
			vp.getRegistroDeEscuadras().getTablaDeCiclistasYEscuadras()
					.agregarEscuadrasConCiclistasATabla(fi.getEscuadraDAO().obtener());
			vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
					.agregarEscuadrasATabla(fi.getEscuadraDAO().obtener());
			vp.getRegistroDeEscuadras().getCreacionYActualizacionDeEscuadra()
					.mostrarMensajeCiclistaEliminadoDeEscuadra();
		}
	}

	/**
	 * Eventos asignacion de personas A equipos.
	 *
	 * @param e the e
	 */
	public void eventosAsignacionDePersonasAEquipos(ActionEvent e) {
		if (e.getSource()
				.equals(vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas().getBotonAgregarMasajista())) {
			if (!vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas().validarEntradasMasajista()) {
				return;
			}
			String numeroDeDocumentoMasajista = vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas()
					.obtenerNumeroDocumentoMasajista();
			String nombreDeEscuadra = vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas()
					.obtenerNombreEscuadraMasajista();
			Masajista masajista = fi.getMasajistaDAO().obtenerPorNumeroDeDocumento(numeroDeDocumentoMasajista);
			Escuadra escuadra = fi.getEscuadraDAO().obtenerPorNombre(nombreDeEscuadra);

			if (masajista == null) {
				vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas()
						.mostrarMensajeNumeroDeDocumentoDeMasajistaNoEncontrado();
				return;
			}

			if (escuadra == null) {
				vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas()
						.mostrarMensajeNombreDeEscuadraNoEncontrado();
				return;
			}

			if (fi.getEscuadraDAO().masajistaYaEnEscuadra(masajista, escuadra)) {
				vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas().mostrarMensajeMasajistaYaEnEscuadra();
				return;
			}

			fi.getEscuadraDAO().agregarMasajistaAEscuadra(masajista, escuadra);
			vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
					.agregarMasajistasATabla(fi.getMasajistaDAO().obtener());
			vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
					.agregarEscuadrasATabla(fi.getEscuadraDAO().obtener());
			vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
					.actualizarTablaEscuadrasPersonas(fi.getEscuadraDAO().obtener());
			vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas().mostrarMensajeMasajistaAgregadoAEscuadra();
			return;
		}

		if (e.getSource()
				.equals(vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas().getBotonAgregarDirector())) {
			if (!vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas().validarEntradasDirector()) {
				return;
			}
			String numeroDeDocumentoDirector = vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas()
					.obtenerNumeroDocumentoDirector();
			String nombreDeEscuadra = vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas()
					.obtenerNombreEscuadraDirector();
			DirectorDeportivo director = fi.getDirectorDeportivoDAO()
					.obtenerPorNumeroDeDocumento(numeroDeDocumentoDirector);
			Escuadra escuadra = fi.getEscuadraDAO().obtenerPorNombre(nombreDeEscuadra);

			if (director == null) {
				vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas()
						.mostrarMensajeNumeroDeDocumentoDeDirectorNoEncontrado();
				return;
			}

			if (escuadra == null) {
				vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas()
						.mostrarMensajeNombreDeEscuadraNoEncontrado();
				return;
			}

			if (fi.getEscuadraDAO().directorYaEnEscuadra(director, escuadra)) {
				vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas().mostrarMensajeDirectorYaEnEscuadra();
				return;
			}

			fi.getEscuadraDAO().agregarDirectorAEscuadra(director, escuadra);
			vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
					.agregarDirectoresATabla(fi.getDirectorDeportivoDAO().obtener());
			vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
					.agregarEscuadrasATabla(fi.getEscuadraDAO().obtener());
			vp.getAsignacionDePersonasAEquipos().getTablasDePersonasYEscuadras()
					.actualizarTablaEscuadrasPersonas(fi.getEscuadraDAO().obtener());
			vp.getAsignacionDePersonasAEquipos().getFormularioDePersonas().mostrarMensajeDirectorAgregadoAEscuadra();
		}
	}

	/**
	 * Eventos simulacion de carrera.
	 *
	 * @param e the e
	 */
	public void eventosSimulacionDeCarrera(ActionEvent e) {
		if (e.getSource().equals(vp.getSimulacionDeCarrera().getBotonIniciarCarrera())) {

			return;
		}

		if (e.getSource().equals(vp.getSimulacionDeCarrera().getTemporizador())) {
			boolean carreraTerminada = true;
			Random random = new Random();
			for (JProgressBar barra : vp.getSimulacionDeCarrera().getBarrasProgresoCiclistas()) {
				if (barra.getValue() < barra.getMaximum()) {
					barra.setValue(barra.getValue() + random.nextInt(100));
					carreraTerminada = false;
				}
			}
			if (carreraTerminada) {
				vp.getSimulacionDeCarrera().getTemporizador().stop();
				JOptionPane.showMessageDialog(null, "Carrera Finalizada. Ganador: Ciclista X");
			}
			return;
		}

		if (e.getSource()
				.equals(vp.getSimulacionDeCarrera().getRegistroDeCiclistas().getBotonAgregarCiclistaACarrera())) {
			if (vp.getSimulacionDeCarrera().getRegistroDeCiclistas().validarIngresoDocumentoCiclistaYTipoEtapa()) {
				String numeroDocumento = vp.getSimulacionDeCarrera().getRegistroDeCiclistas()
						.obtenerCampoNumeroDocumentoCiclista();
				Ciclista ciclista = fi.obtenerCiclistaPorNumeroDeDocumento(numeroDocumento);
				if (ciclista != null) {
					String tipoDeEtapa = vp.getSimulacionDeCarrera().getRegistroDeCiclistas()
							.obtenerTipoDeEtapaSeleccionado();
					Carrera nuevaCarrera = null;
					if (fi.getCarreraDAO().obtener().size() > 0) {
						nuevaCarrera = fi.getCarreraDAO().obtener().get(0);
						nuevaCarrera.setTipoDeEtapa(tipoDeEtapa);
						nuevaCarrera.getCiclistas().add(ciclista);
						fi.getCarreraDAO().actualizar(0, nuevaCarrera);
					} else {
						nuevaCarrera = new Carrera();
						fi.getCarreraDAO().agregar(nuevaCarrera);
						nuevaCarrera.setTipoDeEtapa(tipoDeEtapa);
						nuevaCarrera.getCiclistas().add(ciclista);
					}
					vp.getSimulacionDeCarrera().getRegistroDeCiclistas()
							.agregarCiclistaACiclistasAgregados(nuevaCarrera.getCiclistas());
				} else {
					JOptionPane.showMessageDialog(null, "Número de documento no encontrado.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Todas las entradas deben ser llenadas.");
			}
			return;
		}
		
		if (e.getSource().equals(vp.getSimulacionDeCarrera().getRegistroDeCiclistas().getBotonSimularCarrera())) {
			if (fi.getCarreraDAO().obtener().size() > 0) {				
				if (fi.getCarreraDAO().obtener().get(0).getCiclistas().size() > 0) {				
					vp.getSimulacionDeCarrera().mostrarSimulacionDeCarrera();
				} else {
					JOptionPane.showMessageDialog(null, "No se han agregado ciclistas.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "No se han registrado carreras.");
			}
			return;
		}

	}
}
