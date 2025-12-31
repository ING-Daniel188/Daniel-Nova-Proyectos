package co.edu.unbosque.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class PerfilDeDirectorDeportivo.
 */
public class PerfilDeDirectorDeportivo extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4092251363504307310L;
	
	/** The creacion de director deportivo. */
	private CreacionDeDirectorDeportivo creacionDeDirectorDeportivo;
	
	/** The actualizacion de director deportivo. */
	private ActualizacionDeDirectorDeportivo actualizacionDeDirectorDeportivo;
	
	/** The tabla de directores deportivos. */
	private TablaDeDirectoresDeportivos tablaDeDirectoresDeportivos;
	
	/** The eliminacion de director deportivo. */
	private EliminacionDeDirectorDeportivo eliminacionDeDirectorDeportivo;

	/**
	 * Instantiates a new perfil de director deportivo.
	 */
	public PerfilDeDirectorDeportivo() {
		setLayout(new BorderLayout());

		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new GridLayout(1, 2));
		creacionDeDirectorDeportivo = new CreacionDeDirectorDeportivo();
		panelNorte.add(creacionDeDirectorDeportivo);

		actualizacionDeDirectorDeportivo = new ActualizacionDeDirectorDeportivo();
		panelNorte.add(actualizacionDeDirectorDeportivo);

		add(panelNorte, BorderLayout.NORTH);

		tablaDeDirectoresDeportivos = new TablaDeDirectoresDeportivos();
		add(tablaDeDirectoresDeportivos, BorderLayout.CENTER);

		eliminacionDeDirectorDeportivo = new EliminacionDeDirectorDeportivo();
		add(eliminacionDeDirectorDeportivo, BorderLayout.SOUTH);
	}

	/**
	 * Gets the creacion de director deportivo.
	 *
	 * @return the creacion de director deportivo
	 */
	public CreacionDeDirectorDeportivo getCreacionDeDirectorDeportivo() {
		return creacionDeDirectorDeportivo;
	}

	/**
	 * Sets the creacion de director deportivo.
	 *
	 * @param creacionDeDirectorDeportivo the new creacion de director deportivo
	 */
	public void setCreacionDeDirectorDeportivo(CreacionDeDirectorDeportivo creacionDeDirectorDeportivo) {
		this.creacionDeDirectorDeportivo = creacionDeDirectorDeportivo;
	}

	/**
	 * Gets the actualizacion de director deportivo.
	 *
	 * @return the actualizacion de director deportivo
	 */
	public ActualizacionDeDirectorDeportivo getActualizacionDeDirectorDeportivo() {
		return actualizacionDeDirectorDeportivo;
	}

	/**
	 * Sets the actualizacion de director deportivo.
	 *
	 * @param actualizacionDeDirectorDeportivo the new actualizacion de director deportivo
	 */
	public void setActualizacionDeDirectorDeportivo(ActualizacionDeDirectorDeportivo actualizacionDeDirectorDeportivo) {
		this.actualizacionDeDirectorDeportivo = actualizacionDeDirectorDeportivo;
	}

	/**
	 * Gets the tabla de directores deportivos.
	 *
	 * @return the tabla de directores deportivos
	 */
	public TablaDeDirectoresDeportivos getTablaDeDirectoresDeportivos() {
		return tablaDeDirectoresDeportivos;
	}

	/**
	 * Sets the tabla de directores deportivos.
	 *
	 * @param tablaDeDirectoresDeportivos the new tabla de directores deportivos
	 */
	public void setTablaDeDirectoresDeportivos(TablaDeDirectoresDeportivos tablaDeDirectoresDeportivos) {
		this.tablaDeDirectoresDeportivos = tablaDeDirectoresDeportivos;
	}

	/**
	 * Gets the eliminacion de director deportivo.
	 *
	 * @return the eliminacion de director deportivo
	 */
	public EliminacionDeDirectorDeportivo getEliminacionDeDirectorDeportivo() {
		return eliminacionDeDirectorDeportivo;
	}

	/**
	 * Sets the eliminacion de director deportivo.
	 *
	 * @param eliminacionDeDirectorDeportivo the new eliminacion de director deportivo
	 */
	public void setEliminacionDeDirectorDeportivo(EliminacionDeDirectorDeportivo eliminacionDeDirectorDeportivo) {
		this.eliminacionDeDirectorDeportivo = eliminacionDeDirectorDeportivo;
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
