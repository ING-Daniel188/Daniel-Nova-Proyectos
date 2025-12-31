package co.edu.unbosque.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistroDeEscuadra.
 */
public class RegistroDeEscuadra extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3557443667654394186L;
	
	/** The creacion Y actualizacion de escuadra. */
	private CreacionYActualizacionDeEscuadra creacionYActualizacionDeEscuadra;
	
	/** The tabla de ciclistas Y escuadras. */
	private TablasDeCiclistasYEscuadras tablaDeCiclistasYEscuadras;
	
	/** The eliminacion de escuadra. */
	private EliminacionDeEscuadra eliminacionDeEscuadra;

	/**
	 * Instantiates a new registro de escuadra.
	 */
	public RegistroDeEscuadra() {
		setLayout(new BorderLayout());

		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new GridLayout(1, 1));
		creacionYActualizacionDeEscuadra = new CreacionYActualizacionDeEscuadra();
		panelNorte.add(creacionYActualizacionDeEscuadra);

		add(panelNorte, BorderLayout.NORTH);

		tablaDeCiclistasYEscuadras = new TablasDeCiclistasYEscuadras();
		add(tablaDeCiclistasYEscuadras, BorderLayout.CENTER);

		eliminacionDeEscuadra = new EliminacionDeEscuadra();
		add(eliminacionDeEscuadra, BorderLayout.SOUTH);
	}

	/**
	 * Gets the creacion Y actualizacion de escuadra.
	 *
	 * @return the creacion Y actualizacion de escuadra
	 */
	public CreacionYActualizacionDeEscuadra getCreacionYActualizacionDeEscuadra() {
		return creacionYActualizacionDeEscuadra;
	}

	/**
	 * Sets the creacion Y actualizacion de escuadra.
	 *
	 * @param creacionYActualizacionDeEscuadra the new creacion Y actualizacion de escuadra
	 */
	public void setCreacionYActualizacionDeEscuadra(CreacionYActualizacionDeEscuadra creacionYActualizacionDeEscuadra) {
		this.creacionYActualizacionDeEscuadra = creacionYActualizacionDeEscuadra;
	}

	/**
	 * Gets the tabla de ciclistas Y escuadras.
	 *
	 * @return the tabla de ciclistas Y escuadras
	 */
	public TablasDeCiclistasYEscuadras getTablaDeCiclistasYEscuadras() {
		return tablaDeCiclistasYEscuadras;
	}

	/**
	 * Sets the tabla de ciclistas Y escuadras.
	 *
	 * @param tablaDeCiclistasYEscuadras the new tabla de ciclistas Y escuadras
	 */
	public void setTablaDeCiclistasYEscuadras(TablasDeCiclistasYEscuadras tablaDeCiclistasYEscuadras) {
		this.tablaDeCiclistasYEscuadras = tablaDeCiclistasYEscuadras;
	}

	/**
	 * Gets the eliminacion de escuadra.
	 *
	 * @return the eliminacion de escuadra
	 */
	public EliminacionDeEscuadra getEliminacionDeEscuadra() {
		return eliminacionDeEscuadra;
	}

	/**
	 * Sets the eliminacion de escuadra.
	 *
	 * @param eliminacionDeEscuadra the new eliminacion de escuadra
	 */
	public void setEliminacionDeEscuadra(EliminacionDeEscuadra eliminacionDeEscuadra) {
		this.eliminacionDeEscuadra = eliminacionDeEscuadra;
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
