package co.edu.unbosque.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class PerfilDeCiclistaContrarrelojista.
 */
public class PerfilDeCiclistaContrarrelojista extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4550704184720520961L;
	
	/** The creacion de ciclista contrarrelojista. */
	private CreacionDeCiclistaContrarrelojista creacionDeCiclistaContrarrelojista;
	
	/** The actualizacion de ciclista contrarrelojista. */
	private ActualizacionDeCiclistaContrarrelojista actualizacionDeCiclistaContrarrelojista;
	
	/** The tabla de ciclistas contrarrelojistas. */
	private TablaDeCiclistasContrarrelojistas tablaDeCiclistasContrarrelojistas;
	
	/** The eliminacion de ciclista contrarrelojista. */
	private EliminacionDeCiclistaContrarrelojista eliminacionDeCiclistaContrarrelojista;

	/**
	 * Instantiates a new perfil de ciclista contrarrelojista.
	 */
	public PerfilDeCiclistaContrarrelojista() {
		setLayout(new BorderLayout());

		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new GridLayout(1, 2));
		creacionDeCiclistaContrarrelojista = new CreacionDeCiclistaContrarrelojista();
		panelNorte.add(creacionDeCiclistaContrarrelojista);

		actualizacionDeCiclistaContrarrelojista = new ActualizacionDeCiclistaContrarrelojista();
		panelNorte.add(actualizacionDeCiclistaContrarrelojista);

		add(panelNorte, BorderLayout.NORTH);

		tablaDeCiclistasContrarrelojistas = new TablaDeCiclistasContrarrelojistas();
		add(tablaDeCiclistasContrarrelojistas, BorderLayout.CENTER);

		eliminacionDeCiclistaContrarrelojista = new EliminacionDeCiclistaContrarrelojista();
		add(eliminacionDeCiclistaContrarrelojista, BorderLayout.SOUTH);
	}

	/**
	 * Gets the creacion de ciclista contrarrelojista.
	 *
	 * @return the creacion de ciclista contrarrelojista
	 */
	public CreacionDeCiclistaContrarrelojista getCreacionDeCiclistaContrarrelojista() {
		return creacionDeCiclistaContrarrelojista;
	}

	/**
	 * Sets the creacion de ciclista contrarrelojista.
	 *
	 * @param creacionDeCiclistaContrarrelojista the new creacion de ciclista contrarrelojista
	 */
	public void setCreacionDeCiclistaContrarrelojista(
			CreacionDeCiclistaContrarrelojista creacionDeCiclistaContrarrelojista) {
		this.creacionDeCiclistaContrarrelojista = creacionDeCiclistaContrarrelojista;
	}

	/**
	 * Gets the actualizacion de ciclista contrarrelojista.
	 *
	 * @return the actualizacion de ciclista contrarrelojista
	 */
	public ActualizacionDeCiclistaContrarrelojista getActualizacionDeCiclistaContrarrelojista() {
		return actualizacionDeCiclistaContrarrelojista;
	}

	/**
	 * Sets the actualizacion de ciclista contrarrelojista.
	 *
	 * @param actualizacionDeCiclistaContrarrelojista the new actualizacion de ciclista contrarrelojista
	 */
	public void setActualizacionDeCiclistaContrarrelojista(
			ActualizacionDeCiclistaContrarrelojista actualizacionDeCiclistaContrarrelojista) {
		this.actualizacionDeCiclistaContrarrelojista = actualizacionDeCiclistaContrarrelojista;
	}

	/**
	 * Gets the tabla de ciclistas contrarrelojistas.
	 *
	 * @return the tabla de ciclistas contrarrelojistas
	 */
	public TablaDeCiclistasContrarrelojistas getTablaDeCiclistasContrarrelojistas() {
		return tablaDeCiclistasContrarrelojistas;
	}

	/**
	 * Sets the tabla de ciclistas contrarrelojistas.
	 *
	 * @param tablaDeCiclistasContrarrelojistas the new tabla de ciclistas contrarrelojistas
	 */
	public void setTablaDeCiclistasContrarrelojistas(
			TablaDeCiclistasContrarrelojistas tablaDeCiclistasContrarrelojistas) {
		this.tablaDeCiclistasContrarrelojistas = tablaDeCiclistasContrarrelojistas;
	}

	/**
	 * Gets the eliminacion de ciclista contrarrelojista.
	 *
	 * @return the eliminacion de ciclista contrarrelojista
	 */
	public EliminacionDeCiclistaContrarrelojista getEliminacionDeCiclistaContrarrelojista() {
		return eliminacionDeCiclistaContrarrelojista;
	}

	/**
	 * Sets the eliminacion de ciclista contrarrelojista.
	 *
	 * @param eliminacionDeCiclistaContrarrelojista the new eliminacion de ciclista contrarrelojista
	 */
	public void setEliminacionDeCiclistaContrarrelojista(
			EliminacionDeCiclistaContrarrelojista eliminacionDeCiclistaContrarrelojista) {
		this.eliminacionDeCiclistaContrarrelojista = eliminacionDeCiclistaContrarrelojista;
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
