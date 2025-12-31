package co.edu.unbosque.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class PerfilDeCiclistaClasicomano.
 */
public class PerfilDeCiclistaClasicomano extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3057562731940917203L;
	
	/** The creacion de ciclista clasicomano. */
	private CreacionDeCiclistaClasicomano creacionDeCiclistaClasicomano;
	
	/** The actualizacion de ciclista clasicomano. */
	private ActualizacionDeCiclistaClasicomano actualizacionDeCiclistaClasicomano;
	
	/** The tabla de ciclistas clasicomanos. */
	private TablaDeCiclistasClasicomanos tablaDeCiclistasClasicomanos;
	
	/** The eliminacion de ciclista clasicomano. */
	private EliminacionDeCiclistaClasicomano eliminacionDeCiclistaClasicomano;

	/**
	 * Instantiates a new perfil de ciclista clasicomano.
	 */
	public PerfilDeCiclistaClasicomano() {
		setLayout(new BorderLayout());

		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new GridLayout(1, 2));
		creacionDeCiclistaClasicomano = new CreacionDeCiclistaClasicomano();
		panelNorte.add(creacionDeCiclistaClasicomano);

		actualizacionDeCiclistaClasicomano = new ActualizacionDeCiclistaClasicomano();
		panelNorte.add(actualizacionDeCiclistaClasicomano);

		add(panelNorte, BorderLayout.NORTH);

		tablaDeCiclistasClasicomanos = new TablaDeCiclistasClasicomanos();
		add(tablaDeCiclistasClasicomanos, BorderLayout.CENTER);

		eliminacionDeCiclistaClasicomano = new EliminacionDeCiclistaClasicomano();
		add(eliminacionDeCiclistaClasicomano, BorderLayout.SOUTH);
	}

	/**
	 * Gets the creacion de ciclista clasicomano.
	 *
	 * @return the creacion de ciclista clasicomano
	 */
	public CreacionDeCiclistaClasicomano getCreacionDeCiclistaClasicomano() {
		return creacionDeCiclistaClasicomano;
	}

	/**
	 * Sets the creacion de ciclista clasicomano.
	 *
	 * @param creacionDeCiclistaClasicomano the new creacion de ciclista clasicomano
	 */
	public void setCreacionDeCiclistaClasicomano(CreacionDeCiclistaClasicomano creacionDeCiclistaClasicomano) {
		this.creacionDeCiclistaClasicomano = creacionDeCiclistaClasicomano;
	}

	/**
	 * Gets the actualizacion de ciclista clasicomano.
	 *
	 * @return the actualizacion de ciclista clasicomano
	 */
	public ActualizacionDeCiclistaClasicomano getActualizacionDeCiclistaClasicomano() {
		return actualizacionDeCiclistaClasicomano;
	}

	/**
	 * Sets the actualizacion de ciclista clasicomano.
	 *
	 * @param actualizacionDeCiclistaClasicomano the new actualizacion de ciclista clasicomano
	 */
	public void setActualizacionDeCiclistaClasicomano(
			ActualizacionDeCiclistaClasicomano actualizacionDeCiclistaClasicomano) {
		this.actualizacionDeCiclistaClasicomano = actualizacionDeCiclistaClasicomano;
	}

	/**
	 * Gets the tabla de ciclistas clasicomanos.
	 *
	 * @return the tabla de ciclistas clasicomanos
	 */
	public TablaDeCiclistasClasicomanos getTablaDeCiclistasClasicomanos() {
		return tablaDeCiclistasClasicomanos;
	}

	/**
	 * Sets the tabla de ciclistas clasicomanos.
	 *
	 * @param tablaDeCiclistasClasicomanos the new tabla de ciclistas clasicomanos
	 */
	public void setTablaDeCiclistasClasicomanos(TablaDeCiclistasClasicomanos tablaDeCiclistasClasicomanos) {
		this.tablaDeCiclistasClasicomanos = tablaDeCiclistasClasicomanos;
	}

	/**
	 * Gets the eliminacion de ciclista clasicomano.
	 *
	 * @return the eliminacion de ciclista clasicomano
	 */
	public EliminacionDeCiclistaClasicomano getEliminacionDeCiclistaClasicomano() {
		return eliminacionDeCiclistaClasicomano;
	}

	/**
	 * Sets the eliminacion de ciclista clasicomano.
	 *
	 * @param eliminacionDeCiclistaClasicomano the new eliminacion de ciclista clasicomano
	 */
	public void setEliminacionDeCiclistaClasicomano(EliminacionDeCiclistaClasicomano eliminacionDeCiclistaClasicomano) {
		this.eliminacionDeCiclistaClasicomano = eliminacionDeCiclistaClasicomano;
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
