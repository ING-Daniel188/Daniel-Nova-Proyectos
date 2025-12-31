package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

// TODO: Auto-generated Javadoc
/**
 * The Class EliminacionDeCiclistaGregario.
 */
public class EliminacionDeCiclistaGregario extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6763553263803399533L;
	
	/** The campo numero de documento. */
	private JTextField campoNumeroDeDocumento;
	
	/** The boton eliminar. */
	private JButton botonEliminar;

	/**
	 * Instantiates a new eliminacion de ciclista gregario.
	 */
	public EliminacionDeCiclistaGregario() {
		setBorder(new TitledBorder("Eliminar Ciclista Gregario"));
		setLayout(new GridBagLayout());
		GridBagConstraints restricciones = new GridBagConstraints();

		restricciones.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes

		restricciones.gridx = 0;
		restricciones.gridy = 0;
		JLabel etiquetaNumeroDeDocumento = new JLabel("Número de Documento:");
		add(etiquetaNumeroDeDocumento, restricciones);

		restricciones.gridx = 1;
		campoNumeroDeDocumento = new JTextField(20);
		add(campoNumeroDeDocumento, restricciones);

		restricciones.gridx = 2;
		botonEliminar = new JButton("Eliminar");
		add(botonEliminar, restricciones);
	}

	/**
	 * Validar numero de documento.
	 *
	 * @return true, if successful
	 */
	public boolean validarNumeroDeDocumento() {
		if (campoNumeroDeDocumento.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de número de documento.", "Campo Vacío",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * Mostrar mensaje ciclista gregario eliminado.
	 */
	public void mostrarMensajeCiclistaGregarioEliminado() {
		JOptionPane.showMessageDialog(this, "El ciclista gregario ha sido eliminado exitosamente.",
				"Ciclista Gregario Eliminado", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Mostrar mensaje numero de documento no encontrado.
	 */
	public void mostrarMensajeNumeroDeDocumentoNoEncontrado() {
		JOptionPane.showMessageDialog(this, "El número de documento proporcionado no ha sido encontrado.",
				"Número de documento No Encontrado", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Obtener numero de documento.
	 *
	 * @return the string
	 */
	public String obtenerNumeroDeDocumento() {
		return campoNumeroDeDocumento.getText();
	}

	/**
	 * Establecer numero de documento.
	 *
	 * @param numeroDeDocumento the numero de documento
	 */
	public void establecerNumeroDeDocumento(String numeroDeDocumento) {
		campoNumeroDeDocumento.setText(numeroDeDocumento);
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
