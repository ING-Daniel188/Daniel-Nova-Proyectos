package co.edu.unbosque.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class PerfilDeUsuario.
 */
public class PerfilDeUsuario extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2372413361737184122L;
	
	/** The creacion de usuario. */
	private CreacionDeUsuario creacionDeUsuario;
	
	/** The actualizacion de usuario. */
	private ActualizacionDeUsuario actualizacionDeUsuario;
	
	/** The tabla de usuarios. */
	private TablaDeUsuarios tablaDeUsuarios;
	
	/** The eliminacion de usuario. */
	private EliminacionDeUsuario eliminacionDeUsuario;

	/**
	 * Instantiates a new perfil de usuario.
	 */
	public PerfilDeUsuario() {
		setLayout(new BorderLayout());

		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new GridLayout(1, 2));
		creacionDeUsuario = new CreacionDeUsuario();
		panelNorte.add(creacionDeUsuario);

		actualizacionDeUsuario = new ActualizacionDeUsuario();
		panelNorte.add(actualizacionDeUsuario);

		add(panelNorte, BorderLayout.NORTH);

		tablaDeUsuarios = new TablaDeUsuarios();
		add(tablaDeUsuarios, BorderLayout.CENTER);

		eliminacionDeUsuario = new EliminacionDeUsuario();
		add(eliminacionDeUsuario, BorderLayout.SOUTH);
	}

	/**
	 * Gets the creacion de usuario.
	 *
	 * @return the creacion de usuario
	 */
	public CreacionDeUsuario getCreacionDeUsuario() {
		return creacionDeUsuario;
	}

	/**
	 * Sets the creacion de usuario.
	 *
	 * @param creacionDeUsuario the new creacion de usuario
	 */
	public void setCreacionDeUsuario(CreacionDeUsuario creacionDeUsuario) {
		this.creacionDeUsuario = creacionDeUsuario;
	}

	/**
	 * Gets the actualizacion de usuario.
	 *
	 * @return the actualizacion de usuario
	 */
	public ActualizacionDeUsuario getActualizacionDeUsuario() {
		return actualizacionDeUsuario;
	}

	/**
	 * Sets the actualizacion de usuario.
	 *
	 * @param actualizacionDeUsuario the new actualizacion de usuario
	 */
	public void setActualizacionDeUsuario(ActualizacionDeUsuario actualizacionDeUsuario) {
		this.actualizacionDeUsuario = actualizacionDeUsuario;
	}

	/**
	 * Gets the tabla de usuarios.
	 *
	 * @return the tabla de usuarios
	 */
	public TablaDeUsuarios getTablaDeUsuarios() {
		return tablaDeUsuarios;
	}

	/**
	 * Sets the tabla de usuarios.
	 *
	 * @param tablaDeUsuarios the new tabla de usuarios
	 */
	public void setTablaDeUsuarios(TablaDeUsuarios tablaDeUsuarios) {
		this.tablaDeUsuarios = tablaDeUsuarios;
	}

	/**
	 * Gets the eliminacion de usuario.
	 *
	 * @return the eliminacion de usuario
	 */
	public EliminacionDeUsuario getEliminacionDeUsuario() {
		return eliminacionDeUsuario;
	}

	/**
	 * Sets the eliminacion de usuario.
	 *
	 * @param eliminacionDeUsuario the new eliminacion de usuario
	 */
	public void setEliminacionDeUsuario(EliminacionDeUsuario eliminacionDeUsuario) {
		this.eliminacionDeUsuario = eliminacionDeUsuario;
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
