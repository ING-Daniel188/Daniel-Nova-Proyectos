package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class CreacionDeCiclistaEmbalador.
 */
public class CreacionDeCiclistaEmbalador extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4993919110118463816L;
	
	/** The campo numero de documento. */
	private JTextField campoNumeroDeDocumento;
	
	/** The campo nombre. */
	private JTextField campoNombre;
	
	/** The campo cadencia. */
	private JSpinner campoCadencia;
	
	/** The campo con especialidad. */
	private JCheckBox campoConEspecialidad;
	
	/** The campo potencia promedio. */
	private JSpinner campoPotenciaPromedio;
	
	/** The campo velocidad promedio en sprint. */
	private JSpinner campoVelocidadPromedioEnSprint;
	
	/** The boton crear. */
	private JButton botonCrear;

	/**
	 * Instantiates a new creacion de ciclista embalador.
	 */
	public CreacionDeCiclistaEmbalador() {
		setBorder(new TitledBorder("Crear Ciclista Embalador"));
		setLayout(new GridLayout(7, 2, 5, 5));

		add(new JLabel("Número de Documento:"));
		campoNumeroDeDocumento = new JTextField();
		add(campoNumeroDeDocumento);

		add(new JLabel("Nombre:"));
		campoNombre = new JTextField();
		add(campoNombre);

		add(new JLabel("Cadencia:"));
		campoCadencia = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 100.0, 0.1));
		campoCadencia.setEditor(new JSpinner.NumberEditor(campoCadencia, "#.0"));
		((JSpinner.DefaultEditor) campoCadencia.getEditor()).getTextField().setEditable(false);
		add(campoCadencia);

		add(new JLabel("Con Especialidad:"));
		campoConEspecialidad = new JCheckBox();
		add(campoConEspecialidad);

		add(new JLabel("Potencia Promedio:"));
		campoPotenciaPromedio = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 1000.0, 1.0));
		campoPotenciaPromedio.setEditor(new JSpinner.NumberEditor(campoPotenciaPromedio, "#.0"));
		((JSpinner.DefaultEditor) campoPotenciaPromedio.getEditor()).getTextField().setEditable(false);
		add(campoPotenciaPromedio);

		add(new JLabel("Velocidad Promedio en Sprint:"));
		campoVelocidadPromedioEnSprint = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 100.0, 0.1));
		campoVelocidadPromedioEnSprint.setEditor(new JSpinner.NumberEditor(campoVelocidadPromedioEnSprint, "#.0"));
		((JSpinner.DefaultEditor) campoVelocidadPromedioEnSprint.getEditor()).getTextField().setEditable(false);
		add(campoVelocidadPromedioEnSprint);

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
	 * Mostrar mensaje ciclista embalador creado.
	 */
	public void mostrarMensajeCiclistaEmbaladorCreado() {
		JOptionPane.showMessageDialog(this, "Ciclista Embalador creado exitosamente.", "Ciclista Embalador Creado",
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
		return true;
	}

	/**
	 * Reiniciar entradas.
	 */
	public void reiniciarEntradas() {
		campoNumeroDeDocumento.setText("");
		campoNombre.setText("");
		campoCadencia.setValue(0.0);
		campoConEspecialidad.setSelected(false);
		campoPotenciaPromedio.setValue(0.0);
		campoVelocidadPromedioEnSprint.setValue(0.0);
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
	 * Obtener cadencia.
	 *
	 * @return the double
	 */
	public double obtenerCadencia() {
		return (Double) campoCadencia.getValue();
	}

	/**
	 * Establecer cadencia.
	 *
	 * @param cadencia the cadencia
	 */
	public void establecerCadencia(double cadencia) {
		campoCadencia.setValue(cadencia);
	}

	/**
	 * Obtener con especialidad.
	 *
	 * @return true, if successful
	 */
	public boolean obtenerConEspecialidad() {
		return campoConEspecialidad.isSelected();
	}

	/**
	 * Establecer con especialidad.
	 *
	 * @param conEspecialidad the con especialidad
	 */
	public void establecerConEspecialidad(boolean conEspecialidad) {
		campoConEspecialidad.setSelected(conEspecialidad);
	}

	/**
	 * Obtener potencia promedio.
	 *
	 * @return the double
	 */
	public double obtenerPotenciaPromedio() {
		return (Double) campoPotenciaPromedio.getValue();
	}

	/**
	 * Establecer potencia promedio.
	 *
	 * @param potenciaPromedio the potencia promedio
	 */
	public void establecerPotenciaPromedio(double potenciaPromedio) {
		campoPotenciaPromedio.setValue(potenciaPromedio);
	}

	/**
	 * Obtener velocidad promedio en sprint.
	 *
	 * @return the double
	 */
	public double obtenerVelocidadPromedioEnSprint() {
		return (Double) campoVelocidadPromedioEnSprint.getValue();
	}

	/**
	 * Establecer velocidad promedio en sprint.
	 *
	 * @param velocidadPromedioEnSprint the velocidad promedio en sprint
	 */
	public void establecerVelocidadPromedioEnSprint(double velocidadPromedioEnSprint) {
		campoVelocidadPromedioEnSprint.setValue(velocidadPromedioEnSprint);
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

}
