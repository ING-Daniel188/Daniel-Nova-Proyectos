package co.edu.unbosque.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class PerfilDeMasajista.
 */
public class PerfilDeMasajista extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7586065515338249045L;
	
	/** The creacion de masajista. */
	private CreacionDeMasajista creacionDeMasajista;
	
	/** The actualizacion de masajista. */
	private ActualizacionDeMasajista actualizacionDeMasajista;
	
	/** The tabla de masajistas. */
	private TablaDeMasajistas tablaDeMasajistas;
	
	/** The eliminacion de masajista. */
	private EliminacionDeMasajista eliminacionDeMasajista;

	/**
	 * Instantiates a new perfil de masajista.
	 */
	public PerfilDeMasajista() {
		setLayout(new BorderLayout());

		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new GridLayout(1, 2));
		creacionDeMasajista = new CreacionDeMasajista();
		panelNorte.add(creacionDeMasajista);

		actualizacionDeMasajista = new ActualizacionDeMasajista();
		panelNorte.add(actualizacionDeMasajista);

		add(panelNorte, BorderLayout.NORTH);

		tablaDeMasajistas = new TablaDeMasajistas();
		add(tablaDeMasajistas, BorderLayout.CENTER);

		eliminacionDeMasajista = new EliminacionDeMasajista();
		add(eliminacionDeMasajista, BorderLayout.SOUTH);
	}

	/**
	 * Gets the creacion de masajista.
	 *
	 * @return the creacion de masajista
	 */
	public CreacionDeMasajista getCreacionDeMasajista() {
		return creacionDeMasajista;
	}

	/**
	 * Sets the creacion de masajista.
	 *
	 * @param creacionDeMasajista the new creacion de masajista
	 */
	public void setCreacionDeMasajista(CreacionDeMasajista creacionDeMasajista) {
		this.creacionDeMasajista = creacionDeMasajista;
	}

	/**
	 * Gets the actualizacion de masajista.
	 *
	 * @return the actualizacion de masajista
	 */
	public ActualizacionDeMasajista getActualizacionDeMasajista() {
		return actualizacionDeMasajista;
	}

	/**
	 * Sets the actualizacion de masajista.
	 *
	 * @param actualizacionDeMasajista the new actualizacion de masajista
	 */
	public void setActualizacionDeMasajista(ActualizacionDeMasajista actualizacionDeMasajista) {
		this.actualizacionDeMasajista = actualizacionDeMasajista;
	}

	/**
	 * Gets the tabla de masajistas.
	 *
	 * @return the tabla de masajistas
	 */
	public TablaDeMasajistas getTablaDeMasajistas() {
		return tablaDeMasajistas;
	}

	/**
	 * Sets the tabla de masajistas.
	 *
	 * @param tablaDeMasajistas the new tabla de masajistas
	 */
	public void setTablaDeMasajistas(TablaDeMasajistas tablaDeMasajistas) {
		this.tablaDeMasajistas = tablaDeMasajistas;
	}

	/**
	 * Gets the eliminacion de masajista.
	 *
	 * @return the eliminacion de masajista
	 */
	public EliminacionDeMasajista getEliminacionDeMasajista() {
		return eliminacionDeMasajista;
	}

	/**
	 * Sets the eliminacion de masajista.
	 *
	 * @param eliminacionDeMasajista the new eliminacion de masajista
	 */
	public void setEliminacionDeMasajista(EliminacionDeMasajista eliminacionDeMasajista) {
		this.eliminacionDeMasajista = eliminacionDeMasajista;
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
