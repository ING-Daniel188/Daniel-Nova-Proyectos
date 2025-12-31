package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

/**
 * <b>ViewFacade - Fachada de la Vista</b>
 * La clase ViewFacade extiende de
 * JFrame y actúa como una fachada para la interfaz gráfica de la aplicación,
 * encapsulando la complejidad de la gestión de los paneles y componentes de la
 * interfaz.
 * <p>
 * Esta clase se encarga de inicializar y configurar la ventana principal de la
 * aplicación, incluyendo la creación y configuración de los paneles para
 * visualizar pokemones y pokemones agregados.
 * </p>
 */
public class ViewFacade extends JFrame {

	/**
	 * Identificador único para la serialización de la clase.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Componente que permite la navegación entre diferentes paneles mediante pestañas.
	 */
	private JTabbedPane tabbedPane;
	
	/**
	 * Panel que muestra la lista de pokemones disponibles.
	 */
	private PanelPokemones panelPokemones;
	
	/**
	 * Panel que muestra los pokemones que han sido agregados por el usuario.
	 */
	private PanelPokemonesAgregados panelPokemonesAgregados;

	/**
	 * Constructor de ViewFacade. Inicializa y configura la ventana principal de la
	 * aplicación, incluyendo la creación de los paneles para visualizar pokemones y
	 * pokemones agregados.
	 */
	public ViewFacade() {
		tabbedPane = new JTabbedPane();
		panelPokemones = new PanelPokemones();
		panelPokemonesAgregados = new PanelPokemonesAgregados();

		tabbedPane.addTab("Todos los pokemones", panelPokemones);
		tabbedPane.addTab("Pokemones Agregados", panelPokemonesAgregados);

		this.add(tabbedPane);
		this.setTitle("Pokedex");
		this.setSize(1350, 750);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
	}

	/**
	 * Muestra un mensaje informativo al usuario.
	 * 
	 * @param mensaje El mensaje a mostrar.
	 */
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Información", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Muestra un mensaje de error al usuario.
	 * 
	 * @param mensaje El mensaje de error a mostrar.
	 */
	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Muestra un mensaje de confirmación al usuario y retorna la respuesta.
	 * 
	 * @param mensaje El mensaje de confirmación a mostrar.
	 * @return true si el usuario confirma, false en caso contrario.
	 */
	public boolean confirmarMensaje(String mensaje) {
		UIManager.put("OptionPane.yesButtonText", "Si");
		UIManager.put("OptionPane.noButtonText", "No");
		int opcion = JOptionPane.showConfirmDialog(this, mensaje, "Mensaje de Confirmación", JOptionPane.YES_NO_OPTION);
		if (opcion == 1 || opcion == -1) {
			return false;
		}
		return true;
	}

	/**
	 * Obtiene el panel de pokemones.
	 * 
	 * @return El panel de pokemones.
	 */
	public PanelPokemones getPanelPokemones() {
		return panelPokemones;
	}

	/**
	 * Obtiene el panel de pokemones agregados.
	 * 
	 * @return El panel de pokemones agregados.
	 */
	public PanelPokemonesAgregados getPanelPokemonesAgregados() {
		return panelPokemonesAgregados;
	}

	/**
	 * Obtiene el componente JTabbedPane utilizado en la interfaz.
	 * 
	 * @return El componente JTabbedPane.
	 */
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
}
