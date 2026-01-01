package co.edu.unbosque.view;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * The Class PanelBase.
 */
public abstract class PanelBase extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The fuente plana. */
	protected Font fuentePlana;
	
	/** The fuente negrilla. */
	protected Font fuenteNegrilla;
	
	/** The fuente plana mediana. */
	protected Font fuentePlanaMediana;

	/**
	 * Instantiates a new panel base.
	 */
	protected PanelBase() {
		setLayout(null);
		fuenteNegrilla = new Font("Concord", Font.BOLD, 30);
		fuentePlana = new Font("Concord", Font.PLAIN, 30);
		fuentePlanaMediana = new Font("Concord", Font.PLAIN, 25);
	}

	/**
	 * Mostrar mensaje.
	 *
	 * @param mensaje the mensaje
	 */
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Información", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Mostrar mensaje error.
	 *
	 * @param mensaje the mensaje
	 */
	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Confirmar mensaje.
	 *
	 * @param mensaje the mensaje
	 * @return true, if successful
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
	 * Gets the fuente negrilla.
	 *
	 * @return the fuente negrilla
	 */
	protected Font getFuenteNegrilla() {
		return fuenteNegrilla;
	}

	/**
	 * Gets the fuente plana.
	 *
	 * @return the fuente plana
	 */
	protected Font getFuentePlana() {
		return fuentePlana;
	}

	/**
	 * Gets the fuente plana mediana.
	 *
	 * @return the fuente plana mediana
	 */
	protected Font getFuentePlanaMediana() {
		return fuentePlanaMediana;
	}

}
