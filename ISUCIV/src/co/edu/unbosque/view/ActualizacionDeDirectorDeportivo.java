package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class ActualizacionDeDirectorDeportivo.
 */
public class ActualizacionDeDirectorDeportivo extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -729374115891949437L;
	
	/** The campo numero de documento. */
	private JTextField campoNumeroDeDocumento;
	
	/** The campo nombre. */
	private JTextField campoNombre;
	
	/** The campo nacionalidad. */
	private JTextField campoNacionalidad;
	
	/** The boton actualizar. */
	private JButton botonActualizar;
	
	/** The boton cargar datos. */
	private JButton botonCargarDatos;

	/**
	 * Instantiates a new actualizacion de director deportivo.
	 */
	public ActualizacionDeDirectorDeportivo() {
		setBorder(new TitledBorder("Actualizar Director Deportivo"));
		setLayout(new GridLayout(4, 2, 5, 5));

		add(new JLabel("Número de Documento:"));
		campoNumeroDeDocumento = new JTextField();
		add(campoNumeroDeDocumento);

		add(new JLabel("Nuevo Nombre:"));
		campoNombre = new JTextField();
		add(campoNombre);

		add(new JLabel("Nueva Nacionalidad:"));
		campoNacionalidad = new JTextField();
		add(campoNacionalidad);

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
		if (campoNacionalidad.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de Nacionalidad.", "Campo Vacío",
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
		campoNacionalidad.setEnabled(true);
		botonActualizar.setEnabled(true);
	}

	/**
	 * Deshabilitar entradas Y boton actualizar.
	 */
	public void deshabilitarEntradasYBotonActualizar() {
		campoNombre.setEnabled(false);
		campoNacionalidad.setEnabled(false);
		botonActualizar.setEnabled(false);
	}

	/**
	 * Reiniciar entradas.
	 */
	public void reiniciarEntradas() {
		campoNumeroDeDocumento.setText("");
		campoNombre.setText("");
		campoNacionalidad.setText("");
	}

	/**
	 * Mostrar mensaje numero de documento no encontrado.
	 */
	public void mostrarMensajeNumeroDeDocumentoNoEncontrado() {
		JOptionPane.showMessageDialog(this, "El número de documento proporcionado no ha sido encontrado.",
				"ID No Encontrado", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostrar mensaje director deportivo actualizado.
	 */
	public void mostrarMensajeDirectorDeportivoActualizado() {
		JOptionPane.showMessageDialog(this, "Director Deportivo actualizado exitosamente.",
				"Director Deportivo Actualizado", JOptionPane.INFORMATION_MESSAGE);
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
	 * Obtener nacionalidad.
	 *
	 * @return the string
	 */
	public String obtenerNacionalidad() {
		return campoNacionalidad.getText();
	}

	/**
	 * Establecer nacionalidad.
	 *
	 * @param nacionalidad the nacionalidad
	 */
	public void establecerNacionalidad(String nacionalidad) {
		campoNacionalidad.setText(nacionalidad);
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
	 * @param boton the new boton actualizar
	 */
	public void setBotonActualizar(JButton boton) {
		this.botonActualizar = boton;
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
	 * @param boton the new boton cargar datos
	 */
	public void setBotonCargarDatos(JButton boton) {
		this.botonCargarDatos = boton;
	}
}
