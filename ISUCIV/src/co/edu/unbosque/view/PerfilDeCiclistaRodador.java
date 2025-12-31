package co.edu.unbosque.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class PerfilDeCiclistaRodador.
 */
public class PerfilDeCiclistaRodador extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8176317986370221336L;
	
	/** The creacion de ciclista rodador. */
	private CreacionDeCiclistaRodador creacionDeCiclistaRodador;
	
	/** The actualizacion de ciclista rodador. */
	private ActualizacionDeCiclistaRodador actualizacionDeCiclistaRodador;
	
	/** The tabla de ciclistas rodadores. */
	private TablaDeCiclistasRodadores tablaDeCiclistasRodadores;
	
	/** The eliminacion de ciclista rodador. */
	private EliminacionDeCiclistaRodador eliminacionDeCiclistaRodador;

	/**
	 * Instantiates a new perfil de ciclista rodador.
	 */
	public PerfilDeCiclistaRodador() {
		setLayout(new BorderLayout());

		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new GridLayout(1, 2));
		creacionDeCiclistaRodador = new CreacionDeCiclistaRodador();
		panelNorte.add(creacionDeCiclistaRodador);

		actualizacionDeCiclistaRodador = new ActualizacionDeCiclistaRodador();
		panelNorte.add(actualizacionDeCiclistaRodador);

		add(panelNorte, BorderLayout.NORTH);

		tablaDeCiclistasRodadores = new TablaDeCiclistasRodadores();
		add(tablaDeCiclistasRodadores, BorderLayout.CENTER);

		eliminacionDeCiclistaRodador = new EliminacionDeCiclistaRodador();
		add(eliminacionDeCiclistaRodador, BorderLayout.SOUTH);
	}

	/**
	 * Gets the creacion de ciclista rodador.
	 *
	 * @return the creacion de ciclista rodador
	 */
	public CreacionDeCiclistaRodador getCreacionDeCiclistaRodador() {
		return creacionDeCiclistaRodador;
	}

	/**
	 * Sets the creacion de ciclista rodador.
	 *
	 * @param creacionDeCiclistaRodador the new creacion de ciclista rodador
	 */
	public void setCreacionDeCiclistaRodador(CreacionDeCiclistaRodador creacionDeCiclistaRodador) {
		this.creacionDeCiclistaRodador = creacionDeCiclistaRodador;
	}

	/**
	 * Gets the actualizacion de ciclista rodador.
	 *
	 * @return the actualizacion de ciclista rodador
	 */
	public ActualizacionDeCiclistaRodador getActualizacionDeCiclistaRodador() {
		return actualizacionDeCiclistaRodador;
	}

	/**
	 * Sets the actualizacion de ciclista rodador.
	 *
	 * @param actualizacionDeCiclistaRodador the new actualizacion de ciclista rodador
	 */
	public void setActualizacionDeCiclistaRodador(ActualizacionDeCiclistaRodador actualizacionDeCiclistaRodador) {
		this.actualizacionDeCiclistaRodador = actualizacionDeCiclistaRodador;
	}

	/**
	 * Gets the tabla de ciclistas rodadores.
	 *
	 * @return the tabla de ciclistas rodadores
	 */
	public TablaDeCiclistasRodadores getTablaDeCiclistasRodadores() {
		return tablaDeCiclistasRodadores;
	}

	/**
	 * Sets the tabla de ciclistas rodadores.
	 *
	 * @param tablaDeCiclistasRodadores the new tabla de ciclistas rodadores
	 */
	public void setTablaDeCiclistasRodadores(TablaDeCiclistasRodadores tablaDeCiclistasRodadores) {
		this.tablaDeCiclistasRodadores = tablaDeCiclistasRodadores;
	}

	/**
	 * Gets the eliminacion de ciclista rodador.
	 *
	 * @return the eliminacion de ciclista rodador
	 */
	public EliminacionDeCiclistaRodador getEliminacionDeCiclistaRodador() {
		return eliminacionDeCiclistaRodador;
	}

	/**
	 * Sets the eliminacion de ciclista rodador.
	 *
	 * @param eliminacionDeCiclistaRodador the new eliminacion de ciclista rodador
	 */
	public void setEliminacionDeCiclistaRodador(EliminacionDeCiclistaRodador eliminacionDeCiclistaRodador) {
		this.eliminacionDeCiclistaRodador = eliminacionDeCiclistaRodador;
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
