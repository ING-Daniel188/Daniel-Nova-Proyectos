package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import co.edu.unbosque.controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaPrincipal.
 */
public class VentanaPrincipal extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6117540591733912503L;
	
	/** The pestañas. */
	private JTabbedPane pestañas;
	
	/** The perfil de usuario. */
	private PerfilDeUsuario perfilDeUsuario;
	
	/** The perfil de masajista. */
	private PerfilDeMasajista perfilDeMasajista;
	
	/** The perfil de director deportivo. */
	private PerfilDeDirectorDeportivo perfilDeDirectorDeportivo;
	
	/** The perfil de ciclista. */
	private PerfilDeCiclista perfilDeCiclista;
	
	/** The registro de escuadras. */
	private RegistroDeEscuadra registroDeEscuadras;
	
	/** The asignacion de personas A equipos. */
	private AsignacionDePersonasAEquipos asignacionDePersonasAEquipos;
	
	/** The simulacion de carrera. */
	private SimulacionDeCarrera simulacionDeCarrera;

	/**
	 * Instantiates a new ventana principal.
	 *
	 * @param c the c
	 */
	public VentanaPrincipal(Controller c) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 800);
		setTitle("Sistema de Información de ISUCI");
		setLocationRelativeTo(null);

		pestañas = new JTabbedPane();
		perfilDeUsuario = new PerfilDeUsuario();
		perfilDeMasajista = new PerfilDeMasajista();
		perfilDeDirectorDeportivo = new PerfilDeDirectorDeportivo();
		perfilDeCiclista = new PerfilDeCiclista();
		registroDeEscuadras = new RegistroDeEscuadra();
		asignacionDePersonasAEquipos = new AsignacionDePersonasAEquipos();
		simulacionDeCarrera = new SimulacionDeCarrera(c);

		pestañas.addTab("REGISTRO DE USUARIOS", perfilDeUsuario);
		pestañas.addTab("PERFIL DE MASAJISTA", perfilDeMasajista);
		pestañas.addTab("PERFIL DE DIRECTOR DEPORTIVO", perfilDeDirectorDeportivo);
		pestañas.addTab("PERFIL DE CICLISTA", perfilDeCiclista);
		pestañas.addTab("REGISTRO DE ESCUADRAS O EQUIPOS", registroDeEscuadras);
		pestañas.addTab("ASIGNACIÓN DE PERSONAS A EQUIPOS", asignacionDePersonasAEquipos);
		pestañas.addTab("SIMULACION DE CARRERA", simulacionDeCarrera);
		pestañas.addTab("REPORTES ANALÍTICOS", null);

		add(pestañas);
	}

	/**
	 * Gets the pestañas.
	 *
	 * @return the pestañas
	 */
	public JTabbedPane getPestañas() {
		return pestañas;
	}

	/**
	 * Sets the pestañas.
	 *
	 * @param pestañas the new pestañas
	 */
	public void setPestañas(JTabbedPane pestañas) {
		this.pestañas = pestañas;
	}

	/**
	 * Gets the perfil de usuario.
	 *
	 * @return the perfil de usuario
	 */
	public PerfilDeUsuario getPerfilDeUsuario() {
		return perfilDeUsuario;
	}

	/**
	 * Sets the perfil de usuario.
	 *
	 * @param perfilDeUsuario the new perfil de usuario
	 */
	public void setPerfilDeUsuario(PerfilDeUsuario perfilDeUsuario) {
		this.perfilDeUsuario = perfilDeUsuario;
	}

	/**
	 * Gets the perfil de masajista.
	 *
	 * @return the perfil de masajista
	 */
	public PerfilDeMasajista getPerfilDeMasajista() {
		return perfilDeMasajista;
	}

	/**
	 * Sets the perfil de masajista.
	 *
	 * @param perfilDeMasajista the new perfil de masajista
	 */
	public void setPerfilDeMasajista(PerfilDeMasajista perfilDeMasajista) {
		this.perfilDeMasajista = perfilDeMasajista;
	}

	/**
	 * Gets the perfil de director deportivo.
	 *
	 * @return the perfil de director deportivo
	 */
	public PerfilDeDirectorDeportivo getPerfilDeDirectorDeportivo() {
		return perfilDeDirectorDeportivo;
	}

	/**
	 * Sets the perfil de director deportivo.
	 *
	 * @param perfilDeDirectorDeportivo the new perfil de director deportivo
	 */
	public void setPerfilDeDirectorDeportivo(PerfilDeDirectorDeportivo perfilDeDirectorDeportivo) {
		this.perfilDeDirectorDeportivo = perfilDeDirectorDeportivo;
	}

	/**
	 * Gets the perfil de ciclista.
	 *
	 * @return the perfil de ciclista
	 */
	public PerfilDeCiclista getPerfilDeCiclista() {
		return perfilDeCiclista;
	}

	/**
	 * Sets the perfil de ciclista.
	 *
	 * @param perfilDeCiclista the new perfil de ciclista
	 */
	public void setPerfilDeCiclista(PerfilDeCiclista perfilDeCiclista) {
		this.perfilDeCiclista = perfilDeCiclista;
	}

	/**
	 * Gets the registro de escuadras.
	 *
	 * @return the registro de escuadras
	 */
	public RegistroDeEscuadra getRegistroDeEscuadras() {
		return registroDeEscuadras;
	}

	/**
	 * Sets the registro de escuadras.
	 *
	 * @param registroDeEscuadras the new registro de escuadras
	 */
	public void setRegistroDeEscuadras(RegistroDeEscuadra registroDeEscuadras) {
		this.registroDeEscuadras = registroDeEscuadras;
	}

	/**
	 * Gets the asignacion de personas A equipos.
	 *
	 * @return the asignacion de personas A equipos
	 */
	public AsignacionDePersonasAEquipos getAsignacionDePersonasAEquipos() {
		return asignacionDePersonasAEquipos;
	}

	/**
	 * Sets the asignacion de personas A equipos.
	 *
	 * @param asignacionDePersonasAEquipos the new asignacion de personas A equipos
	 */
	public void setAsignacionDePersonasAEquipos(AsignacionDePersonasAEquipos asignacionDePersonasAEquipos) {
		this.asignacionDePersonasAEquipos = asignacionDePersonasAEquipos;
	}

	/**
	 * Gets the simulacion de carrera.
	 *
	 * @return the simulacion de carrera
	 */
	public SimulacionDeCarrera getSimulacionDeCarrera() {
		return simulacionDeCarrera;
	}

	/**
	 * Sets the simulacion de carrera.
	 *
	 * @param simulacionDeCarrera the new simulacion de carrera
	 */
	public void setSimulacionDeCarrera(SimulacionDeCarrera simulacionDeCarrera) {
		this.simulacionDeCarrera = simulacionDeCarrera;
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
