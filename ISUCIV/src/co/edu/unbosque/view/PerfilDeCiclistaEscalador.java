package co.edu.unbosque.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class PerfilDeCiclistaEscalador.
 */
public class PerfilDeCiclistaEscalador extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4071469642551749912L;
	
	/** The creacion de ciclista escalador. */
	private CreacionDeCiclistaEscalador creacionDeCiclistaEscalador;
	
	/** The actualizacion de ciclista escalador. */
	private ActualizacionDeCiclistaEscalador actualizacionDeCiclistaEscalador;
	
	/** The tabla de ciclistas escaladores. */
	private TablaDeCiclistasEscaladores tablaDeCiclistasEscaladores;
	
	/** The eliminacion de ciclista escalador. */
	private EliminacionDeCiclistaEscalador eliminacionDeCiclistaEscalador;

	/**
	 * Instantiates a new perfil de ciclista escalador.
	 */
	public PerfilDeCiclistaEscalador() {
		setLayout(new BorderLayout());

		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new GridLayout(1, 2));
		creacionDeCiclistaEscalador = new CreacionDeCiclistaEscalador();
		panelNorte.add(creacionDeCiclistaEscalador);

		actualizacionDeCiclistaEscalador = new ActualizacionDeCiclistaEscalador();
		panelNorte.add(actualizacionDeCiclistaEscalador);

		add(panelNorte, BorderLayout.NORTH);

		tablaDeCiclistasEscaladores = new TablaDeCiclistasEscaladores();
		add(tablaDeCiclistasEscaladores, BorderLayout.CENTER);

		eliminacionDeCiclistaEscalador = new EliminacionDeCiclistaEscalador();
		add(eliminacionDeCiclistaEscalador, BorderLayout.SOUTH);
	}

	/**
	 * Gets the creacion de ciclista escalador.
	 *
	 * @return the creacion de ciclista escalador
	 */
	public CreacionDeCiclistaEscalador getCreacionDeCiclistaEscalador() {
		return creacionDeCiclistaEscalador;
	}

	/**
	 * Sets the creacion de ciclista escalador.
	 *
	 * @param creacionDeCiclistaEscalador the new creacion de ciclista escalador
	 */
	public void setCreacionDeCiclistaEscalador(CreacionDeCiclistaEscalador creacionDeCiclistaEscalador) {
		this.creacionDeCiclistaEscalador = creacionDeCiclistaEscalador;
	}

	/**
	 * Gets the actualizacion de ciclista escalador.
	 *
	 * @return the actualizacion de ciclista escalador
	 */
	public ActualizacionDeCiclistaEscalador getActualizacionDeCiclistaEscalador() {
		return actualizacionDeCiclistaEscalador;
	}

	/**
	 * Sets the actualizacion de ciclista escalador.
	 *
	 * @param actualizacionDeCiclistaEscalador the new actualizacion de ciclista escalador
	 */
	public void setActualizacionDeCiclistaEscalador(ActualizacionDeCiclistaEscalador actualizacionDeCiclistaEscalador) {
		this.actualizacionDeCiclistaEscalador = actualizacionDeCiclistaEscalador;
	}

	/**
	 * Gets the tabla de ciclistas escaladores.
	 *
	 * @return the tabla de ciclistas escaladores
	 */
	public TablaDeCiclistasEscaladores getTablaDeCiclistasEscaladores() {
		return tablaDeCiclistasEscaladores;
	}

	/**
	 * Sets the tabla de ciclistas escaladores.
	 *
	 * @param tablaDeCiclistasEscaladores the new tabla de ciclistas escaladores
	 */
	public void setTablaDeCiclistasEscaladores(TablaDeCiclistasEscaladores tablaDeCiclistasEscaladores) {
		this.tablaDeCiclistasEscaladores = tablaDeCiclistasEscaladores;
	}

	/**
	 * Gets the eliminacion de ciclista escalador.
	 *
	 * @return the eliminacion de ciclista escalador
	 */
	public EliminacionDeCiclistaEscalador getEliminacionDeCiclistaEscalador() {
		return eliminacionDeCiclistaEscalador;
	}

	/**
	 * Sets the eliminacion de ciclista escalador.
	 *
	 * @param eliminacionDeCiclistaEscalador the new eliminacion de ciclista escalador
	 */
	public void setEliminacionDeCiclistaEscalador(EliminacionDeCiclistaEscalador eliminacionDeCiclistaEscalador) {
		this.eliminacionDeCiclistaEscalador = eliminacionDeCiclistaEscalador;
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
