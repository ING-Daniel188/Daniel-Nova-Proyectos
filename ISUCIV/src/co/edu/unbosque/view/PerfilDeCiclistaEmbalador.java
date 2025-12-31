package co.edu.unbosque.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class PerfilDeCiclistaEmbalador.
 */
public class PerfilDeCiclistaEmbalador extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6613974587849255969L;
	
	/** The creacion de ciclista embalador. */
	private CreacionDeCiclistaEmbalador creacionDeCiclistaEmbalador;
	
	/** The actualizacion de ciclista embalador. */
	private ActualizacionDeCiclistaEmbalador actualizacionDeCiclistaEmbalador;
	
	/** The tabla de ciclistas embaladores. */
	private TablaDeCiclistasEmbaladores tablaDeCiclistasEmbaladores;
	
	/** The eliminacion de ciclista embalador. */
	private EliminacionDeCiclistaEmbalador eliminacionDeCiclistaEmbalador;

	/**
	 * Instantiates a new perfil de ciclista embalador.
	 */
	public PerfilDeCiclistaEmbalador() {
		setLayout(new BorderLayout());

		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new GridLayout(1, 2));
		creacionDeCiclistaEmbalador = new CreacionDeCiclistaEmbalador();
		panelNorte.add(creacionDeCiclistaEmbalador);

		actualizacionDeCiclistaEmbalador = new ActualizacionDeCiclistaEmbalador();
		panelNorte.add(actualizacionDeCiclistaEmbalador);

		add(panelNorte, BorderLayout.NORTH);

		tablaDeCiclistasEmbaladores = new TablaDeCiclistasEmbaladores();
		add(tablaDeCiclistasEmbaladores, BorderLayout.CENTER);

		eliminacionDeCiclistaEmbalador = new EliminacionDeCiclistaEmbalador();
		add(eliminacionDeCiclistaEmbalador, BorderLayout.SOUTH);
	}

	/**
	 * Gets the creacion de ciclista embalador.
	 *
	 * @return the creacion de ciclista embalador
	 */
	public CreacionDeCiclistaEmbalador getCreacionDeCiclistaEmbalador() {
		return creacionDeCiclistaEmbalador;
	}

	/**
	 * Sets the creacion de ciclista embalador.
	 *
	 * @param creacionDeCiclistaEmbalador the new creacion de ciclista embalador
	 */
	public void setCreacionDeCiclistaEmbalador(CreacionDeCiclistaEmbalador creacionDeCiclistaEmbalador) {
		this.creacionDeCiclistaEmbalador = creacionDeCiclistaEmbalador;
	}

	/**
	 * Gets the actualizacion de ciclista embalador.
	 *
	 * @return the actualizacion de ciclista embalador
	 */
	public ActualizacionDeCiclistaEmbalador getActualizacionDeCiclistaEmbalador() {
		return actualizacionDeCiclistaEmbalador;
	}

	/**
	 * Sets the actualizacion de ciclista embalador.
	 *
	 * @param actualizacionDeCiclistaEmbalador the new actualizacion de ciclista embalador
	 */
	public void setActualizacionDeCiclistaEmbalador(ActualizacionDeCiclistaEmbalador actualizacionDeCiclistaEmbalador) {
		this.actualizacionDeCiclistaEmbalador = actualizacionDeCiclistaEmbalador;
	}

	/**
	 * Gets the tabla de ciclistas embaladores.
	 *
	 * @return the tabla de ciclistas embaladores
	 */
	public TablaDeCiclistasEmbaladores getTablaDeCiclistasEmbaladores() {
		return tablaDeCiclistasEmbaladores;
	}

	/**
	 * Sets the tabla de ciclistas embaladores.
	 *
	 * @param tablaDeCiclistasEmbaladores the new tabla de ciclistas embaladores
	 */
	public void setTablaDeCiclistasEmbaladores(TablaDeCiclistasEmbaladores tablaDeCiclistasEmbaladores) {
		this.tablaDeCiclistasEmbaladores = tablaDeCiclistasEmbaladores;
	}

	/**
	 * Gets the eliminacion de ciclista embalador.
	 *
	 * @return the eliminacion de ciclista embalador
	 */
	public EliminacionDeCiclistaEmbalador getEliminacionDeCiclistaEmbalador() {
		return eliminacionDeCiclistaEmbalador;
	}

	/**
	 * Sets the eliminacion de ciclista embalador.
	 *
	 * @param eliminacionDeCiclistaEmbalador the new eliminacion de ciclista embalador
	 */
	public void setEliminacionDeCiclistaEmbalador(EliminacionDeCiclistaEmbalador eliminacionDeCiclistaEmbalador) {
		this.eliminacionDeCiclistaEmbalador = eliminacionDeCiclistaEmbalador;
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
