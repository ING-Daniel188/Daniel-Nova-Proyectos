package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

// TODO: Auto-generated Javadoc
/**
 * The Class EliminacionDeEscuadra.
 */
public class EliminacionDeEscuadra extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8221393021558768809L;
	
	/** The campo nombre de la escuadra. */
	private JTextField campoNombreDeLaEscuadra;
	
	/** The boton eliminar. */
	private JButton botonEliminar;

	/**
	 * Instantiates a new eliminacion de escuadra.
	 */
	public EliminacionDeEscuadra() {
		setBorder(new TitledBorder("Eliminar Escuadra"));
		setLayout(new GridBagLayout());
		GridBagConstraints restricciones = new GridBagConstraints();

		restricciones.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes

		restricciones.gridx = 0;
		restricciones.gridy = 0;
		JLabel etiquetaNombreDeLaEscuadra = new JLabel("Nombre de la Escuadra:");
		add(etiquetaNombreDeLaEscuadra, restricciones);

		restricciones.gridx = 1;
		campoNombreDeLaEscuadra = new JTextField(20);
		add(campoNombreDeLaEscuadra, restricciones);

		restricciones.gridx = 2;
		botonEliminar = new JButton("Eliminar");
		add(botonEliminar, restricciones);
	}

	/**
	 * Validar nombre de la escuadra.
	 *
	 * @return true, if successful
	 */
	public boolean validarNombreDeLaEscuadra() {
		if (campoNombreDeLaEscuadra.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de nombre de la escuadra.", "Campo Vacío",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * Mostrar mensaje escuadra eliminada.
	 */
	public void mostrarMensajeEscuadraEliminada() {
		JOptionPane.showMessageDialog(this, "La escuadra ha sido eliminada exitosamente.", "Escuadra Eliminada",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Mostrar mensaje nombre de la escuadra no encontrado.
	 */
	public void mostrarMensajeNombreDeLaEscuadraNoEncontrado() {
		JOptionPane.showMessageDialog(this, "El nombre de la escuadra proporcionado no ha sido encontrado.",
				"Nombre de la Escuadra No Encontrado", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Obtener nombre de la escuadra.
	 *
	 * @return the string
	 */
	public String obtenerNombreDeLaEscuadra() {
		return campoNombreDeLaEscuadra.getText();
	}

	/**
	 * Establecer nombre de la escuadra.
	 *
	 * @param nombreDeLaEscuadra the nombre de la escuadra
	 */
	public void establecerNombreDeLaEscuadra(String nombreDeLaEscuadra) {
		this.campoNombreDeLaEscuadra.setText(nombreDeLaEscuadra);
	}

	/**
	 * Gets the boton eliminar.
	 *
	 * @return the boton eliminar
	 */
	public JButton getBotonEliminar() {
		return botonEliminar;
	}

	/**
	 * Sets the boton eliminar.
	 *
	 * @param botonEliminar the new boton eliminar
	 */
	public void setBotonEliminar(JButton botonEliminar) {
		this.botonEliminar = botonEliminar;
	}
}
