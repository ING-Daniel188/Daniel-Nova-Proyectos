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
 * The Class CreacionDeDirectorDeportivo.
 */
public class CreacionDeDirectorDeportivo extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8297013328289139450L;
	
	/** The campo numero de documento. */
	private JTextField campoNumeroDeDocumento;
	
	/** The campo nombre. */
	private JTextField campoNombre;
	
	/** The campo nacionalidad. */
	private JTextField campoNacionalidad;
	
	/** The boton crear. */
	private JButton botonCrear;

	/**
	 * Instantiates a new creacion de director deportivo.
	 */
	public CreacionDeDirectorDeportivo() {
		setBorder(new TitledBorder("Crear Director Deportivo"));
		setLayout(new GridLayout(4, 2, 5, 5));

		add(new JLabel("Número de Documento:"));
		campoNumeroDeDocumento = new JTextField();
		add(campoNumeroDeDocumento);

		add(new JLabel("Nombre:"));
		campoNombre = new JTextField();
		add(campoNombre);

		add(new JLabel("Nacionalidad:"));
		campoNacionalidad = new JTextField();
		add(campoNacionalidad);

		add(new JLabel());

		botonCrear = new JButton("Crear");
		add(botonCrear);
	}

	/**
	 * Mostrar mensaje numero de documento encontrado.
	 */
	public void mostrarMensajeNumeroDeDocumentoEncontrado() {
		JOptionPane.showMessageDialog(this, "El número de documento proporcionado ya existe.", "Documento Encontrado",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostrar mensaje director deportivo creado.
	 */
	public void mostrarMensajeDirectorDeportivoCreado() {
		JOptionPane.showMessageDialog(this, "Director Deportivo creado exitosamente.", "Director Deportivo Creado",
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
		if (campoNacionalidad.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de Nacionalidad.", "Campo Vacío",
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
		campoNacionalidad.setText("");
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
	 * @param boton the new boton crear
	 */
	public void setBotonCrear(JButton boton) {
		this.botonCrear = boton;
	}
}
