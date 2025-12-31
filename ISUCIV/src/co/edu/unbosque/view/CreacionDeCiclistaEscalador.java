package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class CreacionDeCiclistaEscalador.
 */
public class CreacionDeCiclistaEscalador extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2707400973950321997L;
	
	/** The campo numero de documento. */
	private JTextField campoNumeroDeDocumento;
	
	/** The campo nombre. */
	private JTextField campoNombre;
	
	/** The campo cadencia. */
	private JSpinner campoCadencia;
	
	/** The campo con especialidad. */
	private JCheckBox campoConEspecialidad;
	
	/** The campo aceleracion promedio. */
	private JSpinner campoAceleracionPromedio;
	
	/** The campo grado rampa soportada. */
	private JSpinner campoGradoRampaSoportada;
	
	/** The boton crear. */
	private JButton botonCrear;

	/**
	 * Instantiates a new creacion de ciclista escalador.
	 */
	public CreacionDeCiclistaEscalador() {
		setBorder(new TitledBorder("Crear Ciclista Escalador"));
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

		add(new JLabel("Aceleración Promedio:"));
		campoAceleracionPromedio = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 100.0, 0.1));
		campoAceleracionPromedio.setEditor(new JSpinner.NumberEditor(campoAceleracionPromedio, "#.0"));
		((JSpinner.DefaultEditor) campoAceleracionPromedio.getEditor()).getTextField().setEditable(false);
		add(campoAceleracionPromedio);

		add(new JLabel("Grado Rampa Soportada:"));
		campoGradoRampaSoportada = new JSpinner(new SpinnerNumberModel(0, 0, 45, 1));
		campoGradoRampaSoportada.setEditor(new JSpinner.NumberEditor(campoGradoRampaSoportada, "#"));
		((JSpinner.DefaultEditor) campoGradoRampaSoportada.getEditor()).getTextField().setEditable(false);
		add(campoGradoRampaSoportada);

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
	 * Mostrar mensaje ciclista escalador creado.
	 */
	public void mostrarMensajeCiclistaEscaladorCreado() {
		JOptionPane.showMessageDialog(this, "Ciclista Escalador creado exitosamente.", "Ciclista Escalador Creado",
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
		campoAceleracionPromedio.setValue(0.0);
		campoGradoRampaSoportada.setValue(0);
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
	 * Obtener aceleracion promedio.
	 *
	 * @return the double
	 */
	public double obtenerAceleracionPromedio() {
		return (Double) campoAceleracionPromedio.getValue();
	}

	/**
	 * Establecer aceleracion promedio.
	 *
	 * @param aceleracionPromedio the aceleracion promedio
	 */
	public void establecerAceleracionPromedio(double aceleracionPromedio) {
		campoAceleracionPromedio.setValue(aceleracionPromedio);
	}

	/**
	 * Obtener grado rampa soportada.
	 *
	 * @return the int
	 */
	public int obtenerGradoRampaSoportada() {
		return (Integer) campoGradoRampaSoportada.getValue();
	}

	/**
	 * Establecer grado rampa soportada.
	 *
	 * @param gradoRampaSoportada the grado rampa soportada
	 */
	public void establecerGradoRampaSoportada(int gradoRampaSoportada) {
		campoGradoRampaSoportada.setValue(gradoRampaSoportada);
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
