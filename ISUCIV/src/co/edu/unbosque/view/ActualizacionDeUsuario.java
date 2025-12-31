package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class ActualizacionDeUsuario.
 */
public class ActualizacionDeUsuario extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1390649436124430687L;
	
	/** The campo nombre. */
	private JTextField campoNombre;
	
	/** The campo genero. */
	private JComboBox<String> campoGenero;
	
	/** The campo numero de documento. */
	private JTextField campoNumeroDeDocumento;
	
	/** The campo correo. */
	private JTextField campoCorreo;
	
	/** The campo clave. */
	private JPasswordField campoClave;
	
	/** The boton actualizar. */
	private JButton botonActualizar;
	
	/** The boton cargar datos. */
	private JButton botonCargarDatos;

	/**
	 * Instantiates a new actualizacion de usuario.
	 */
	public ActualizacionDeUsuario() {
		setBorder(new TitledBorder("Actualizar Usuario"));
		setLayout(new GridLayout(6, 2, 5, 5));

		JLabel etiquetaId = new JLabel("Número de Documento:");
		add(etiquetaId);

		campoNumeroDeDocumento = new JTextField();
		add(campoNumeroDeDocumento);

		JLabel etiquetaNombre = new JLabel("Nuevo Nombre:");
		add(etiquetaNombre);

		campoNombre = new JTextField();
		add(campoNombre);

		JLabel etiquetaGenero = new JLabel("Nuevo Género:");
		add(etiquetaGenero);

		campoGenero = new JComboBox<>(new String[] { "...", "Masculino", "Femenino", "Otro" });
		add(campoGenero);

		JLabel etiquetaCorreo = new JLabel("Nuevo Correo:");
		add(etiquetaCorreo);

		campoCorreo = new JTextField();
		add(campoCorreo);

		JLabel etiquetaClave = new JLabel("Nueva Clave:");
		add(etiquetaClave);

		campoClave = new JPasswordField();
		add(campoClave);

		botonCargarDatos = new JButton("Cargar Datos");
		add(botonCargarDatos);

		botonActualizar = new JButton("Actualizar");
		add(botonActualizar);

		deshabilitarEntradasYBotonActualizar();
	}

	/**
	 * Validar entradas.
	 *
	 * @return true, if successful
	 */
	public boolean validarEntradas() {
		if (campoNumeroDeDocumento.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de número de documento.", "Campo Vacío",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (campoNombre.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de Nombre.", "Campo Vacío",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (campoGenero.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Por favor, seleccione un género.", "Campo Vacío",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (campoCorreo.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de Correo.", "Campo Vacío",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (campoClave.getPassword().length == 0) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de Clave.", "Campo Vacío",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
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
	 * Habilitar entradas Y boton actualizar.
	 */
	public void habilitarEntradasYBotonActualizar() {
		campoNombre.setEnabled(true);
		campoGenero.setEnabled(true);
		campoCorreo.setEnabled(true);
		campoClave.setEnabled(true);
		botonActualizar.setEnabled(true);
	}

	/**
	 * Deshabilitar entradas Y boton actualizar.
	 */
	public void deshabilitarEntradasYBotonActualizar() {
		campoNombre.setEnabled(false);
		campoGenero.setEnabled(false);
		campoCorreo.setEnabled(false);
		campoClave.setEnabled(false);
		botonActualizar.setEnabled(false);
	}

	/**
	 * Reiniciar entradas.
	 */
	public void reiniciarEntradas() {
		campoNombre.setText("");
		campoGenero.setSelectedIndex(0);
		campoNumeroDeDocumento.setText("");
		campoCorreo.setText("");
		campoClave.setText("");
	}

	/**
	 * Mostrar mensaje numero de documento no encontrado.
	 */
	public void mostrarMensajeNumeroDeDocumentoNoEncontrado() {
		JOptionPane.showMessageDialog(this, "El número de documento proporcionado no ha sido encontrado.",
				"Número de documento No Encontrado", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostrar mensaje usuario actualizado.
	 */
	public void mostrarMensajeUsuarioActualizado() {
		JOptionPane.showMessageDialog(this, "Usuario actualizado exitosamente.", "Usuario Actualizado",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Obtener nombre.
	 *
	 * @return the string
	 */
	public String obtenerNombre() {
		return campoNombre.getText();
	}

	/**
	 * Establecer nombre.
	 *
	 * @param nombre the nombre
	 */
	public void establecerNombre(String nombre) {
		campoNombre.setText(nombre);
	}

	/**
	 * Obtener genero.
	 *
	 * @return the string
	 */
	public String obtenerGenero() {
		return campoGenero.getSelectedItem().toString();
	}

	/**
	 * Establecer genero.
	 *
	 * @param genero the genero
	 */
	public void establecerGenero(String genero) {
		campoGenero.setSelectedItem(genero);
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
	 * Obtener correo.
	 *
	 * @return the string
	 */
	public String obtenerCorreo() {
		return campoCorreo.getText();
	}

	/**
	 * Establecer correo.
	 *
	 * @param correo the correo
	 */
	public void establecerCorreo(String correo) {
		campoCorreo.setText(correo);
	}

	/**
	 * Obtener clave.
	 *
	 * @return the string
	 */
	public String obtenerClave() {
		return new String(campoClave.getPassword());
	}

	/**
	 * Establecer clave.
	 *
	 * @param clave the clave
	 */
	public void establecerClave(String clave) {
		campoClave.setText(clave);
	}

	/**
	 * Gets the boton actualizar.
	 *
	 * @return the boton actualizar
	 */
	public JButton getBotonActualizar() {
		return botonActualizar;
	}

	/**
	 * Sets the boton actualizar.
	 *
	 * @param botonActualizar the new boton actualizar
	 */
	public void setBotonActualizar(JButton botonActualizar) {
		this.botonActualizar = botonActualizar;
	}

	/**
	 * Gets the boton cargar datos.
	 *
	 * @return the boton cargar datos
	 */
	public JButton getBotonCargarDatos() {
		return botonCargarDatos;
	}

	/**
	 * Sets the boton cargar datos.
	 *
	 * @param botonCargarDatos the new boton cargar datos
	 */
	public void setBotonCargarDatos(JButton botonCargarDatos) {
		this.botonCargarDatos = botonCargarDatos;
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
