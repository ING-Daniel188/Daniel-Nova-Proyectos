package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;

import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class CreacionDeUsuario.
 */
public class CreacionDeUsuario extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6819094191190438235L;
	
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
	
	/** The boton crear. */
	private JButton botonCrear;

	/**
	 * Instantiates a new creacion de usuario.
	 */
	public CreacionDeUsuario() {
		setBorder(new TitledBorder("Crear Usuario"));
		setLayout(new GridLayout(6, 2, 5, 5));

		JLabel etiquetaId = new JLabel("Número de Documento:");
		add(etiquetaId);

		campoNumeroDeDocumento = new JTextField();
		add(campoNumeroDeDocumento);

		JLabel etiquetaNombre = new JLabel("Nombre:");
		add(etiquetaNombre);

		campoNombre = new JTextField();
		add(campoNombre);

		JLabel etiquetaGenero = new JLabel("Género:");
		add(etiquetaGenero);

		campoGenero = new JComboBox<>(new String[] { "...", "Masculino", "Femenino", "Otro" });
		add(campoGenero);

		JLabel etiquetaCorreo = new JLabel("Correo:");
		add(etiquetaCorreo);

		campoCorreo = new JTextField();
		add(campoCorreo);

		JLabel etiquetaClave = new JLabel("Clave:");
		add(etiquetaClave);

		campoClave = new JPasswordField();
		add(campoClave);

		add(new JLabel());

		botonCrear = new JButton("Crear");
		add(botonCrear);
	}

	/**
	 * Mostrar mensaje numero de documento encontrado.
	 */
	public void mostrarMensajeNumeroDeDocumentoEncontrado() {
		JOptionPane.showMessageDialog(this, "El número de documento proporcionado ya existe.", "ID Encontrado",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostrar mensaje usuario creado.
	 */
	public void mostrarMensajeUsuarioCreado() {
		JOptionPane.showMessageDialog(this, "Usuario creado exitosamente.", "Usuario Creado",
				JOptionPane.INFORMATION_MESSAGE);
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
	 * Reiniciar entradas.
	 */
	public void reiniciarEntradas() {
		campoNumeroDeDocumento.setText("");
		campoNombre.setText("");
		campoGenero.setSelectedIndex(0);
		campoCorreo.setText("");
		campoClave.setText("");
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
	 * @param id the id
	 */
	public void establecerNumeroDeDocumento(String id) {
		campoNumeroDeDocumento.setText(id);
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
	 * Gets the boton crear.
	 *
	 * @return the boton crear
	 */
	public JButton getBotonCrear() {
		return botonCrear;
	}

	/**
	 * Sets the boton crear.
	 *
	 * @param botonCrear the new boton crear
	 */
	public void setBotonCrear(JButton botonCrear) {
		this.botonCrear = botonCrear;
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
