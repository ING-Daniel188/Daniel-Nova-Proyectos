package co.edu.unbosque.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class PerfilDeCiclistaGregario.
 */
public class PerfilDeCiclistaGregario extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5012931435316384918L;
	
	/** The creacion de ciclista gregario. */
	private CreacionDeCiclistaGregario creacionDeCiclistaGregario;
	
	/** The actualizacion de ciclista gregario. */
	private ActualizacionDeCiclistaGregario actualizacionDeCiclistaGregario;
	
	/** The tabla de ciclistas gregarios. */
	private TablaDeCiclistasGregarios tablaDeCiclistasGregarios;
	
	/** The eliminacion de ciclista gregario. */
	private EliminacionDeCiclistaGregario eliminacionDeCiclistaGregario;

	/**
	 * Instantiates a new perfil de ciclista gregario.
	 */
	public PerfilDeCiclistaGregario() {
		setLayout(new BorderLayout());

		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new GridLayout(1, 2));
		creacionDeCiclistaGregario = new CreacionDeCiclistaGregario();
		panelNorte.add(creacionDeCiclistaGregario);

		actualizacionDeCiclistaGregario = new ActualizacionDeCiclistaGregario();
		panelNorte.add(actualizacionDeCiclistaGregario);

		add(panelNorte, BorderLayout.NORTH);

		tablaDeCiclistasGregarios = new TablaDeCiclistasGregarios();
		add(tablaDeCiclistasGregarios, BorderLayout.CENTER);

		eliminacionDeCiclistaGregario = new EliminacionDeCiclistaGregario();
		add(eliminacionDeCiclistaGregario, BorderLayout.SOUTH);
	}

	/**
	 * Gets the creacion de ciclista gregario.
	 *
	 * @return the creacion de ciclista gregario
	 */
	public CreacionDeCiclistaGregario getCreacionDeCiclistaGregario() {
		return creacionDeCiclistaGregario;
	}

	/**
	 * Sets the creacion de ciclista gregario.
	 *
	 * @param creacionDeCiclistaGregario the new creacion de ciclista gregario
	 */
	public void setCreacionDeCiclistaGregario(CreacionDeCiclistaGregario creacionDeCiclistaGregario) {
		this.creacionDeCiclistaGregario = creacionDeCiclistaGregario;
	}

	/**
	 * Gets the actualizacion de ciclista gregario.
	 *
	 * @return the actualizacion de ciclista gregario
	 */
	public ActualizacionDeCiclistaGregario getActualizacionDeCiclistaGregario() {
		return actualizacionDeCiclistaGregario;
	}

	/**
	 * Sets the actualizacion de ciclista gregario.
	 *
	 * @param actualizacionDeCiclistaGregario the new actualizacion de ciclista gregario
	 */
	public void setActualizacionDeCiclistaGregario(ActualizacionDeCiclistaGregario actualizacionDeCiclistaGregario) {
		this.actualizacionDeCiclistaGregario = actualizacionDeCiclistaGregario;
	}

	/**
	 * Gets the tabla de ciclistas gregarios.
	 *
	 * @return the tabla de ciclistas gregarios
	 */
	public TablaDeCiclistasGregarios getTablaDeCiclistasGregarios() {
		return tablaDeCiclistasGregarios;
	}

	/**
	 * Sets the tabla de ciclistas gregarios.
	 *
	 * @param tablaDeCiclistasGregarios the new tabla de ciclistas gregarios
	 */
	public void setTablaDeCiclistasGregarios(TablaDeCiclistasGregarios tablaDeCiclistasGregarios) {
		this.tablaDeCiclistasGregarios = tablaDeCiclistasGregarios;
	}

	/**
	 * Gets the eliminacion de ciclista gregario.
	 *
	 * @return the eliminacion de ciclista gregario
	 */
	public EliminacionDeCiclistaGregario getEliminacionDeCiclistaGregario() {
		return eliminacionDeCiclistaGregario;
	}

	/**
	 * Sets the eliminacion de ciclista gregario.
	 *
	 * @param eliminacionDeCiclistaGregario the new eliminacion de ciclista gregario
	 */
	public void setEliminacionDeCiclistaGregario(EliminacionDeCiclistaGregario eliminacionDeCiclistaGregario) {
		this.eliminacionDeCiclistaGregario = eliminacionDeCiclistaGregario;
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
