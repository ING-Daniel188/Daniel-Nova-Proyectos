package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class ActualizacionDeCiclistaEscalador.
 */
public class ActualizacionDeCiclistaEscalador extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -340361543925162132L;
	
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
	
	/** The boton actualizar. */
	private JButton botonActualizar;
	
	/** The boton cargar datos. */
	private JButton botonCargarDatos;

	/**
	 * Instantiates a new actualizacion de ciclista escalador.
	 */
	public ActualizacionDeCiclistaEscalador() {
		setBorder(new TitledBorder("Actualizar Ciclista Escalador"));
		setLayout(new GridLayout(7, 2, 5, 5));

		add(new JLabel("Número de Documento:"));
		campoNumeroDeDocumento = new JTextField();
		add(campoNumeroDeDocumento);

		add(new JLabel("Nuevo Nombre:"));
		campoNombre = new JTextField();
		add(campoNombre);

		add(new JLabel("Nueva Cadencia:"));
		campoCadencia = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 100.0, 0.1));
		campoCadencia.setEditor(new JSpinner.NumberEditor(campoCadencia, "#.0"));
		((JSpinner.DefaultEditor) campoCadencia.getEditor()).getTextField().setEditable(false);
		add(campoCadencia);

		add(new JLabel("Con Especialidad:"));
		campoConEspecialidad = new JCheckBox();
		add(campoConEspecialidad);

		add(new JLabel("Nueva Aceleración Promedio:"));
		campoAceleracionPromedio = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 100.0, 0.1));
		campoAceleracionPromedio.setEditor(new JSpinner.NumberEditor(campoAceleracionPromedio, "#.0"));
		((JSpinner.DefaultEditor) campoAceleracionPromedio.getEditor()).getTextField().setEditable(false);
		add(campoAceleracionPromedio);

		add(new JLabel("Nuevo Grado Rampa Soportada:"));
		campoGradoRampaSoportada = new JSpinner(new SpinnerNumberModel(0, 0, 45, 1));
		campoGradoRampaSoportada.setEditor(new JSpinner.NumberEditor(campoGradoRampaSoportada, "#"));
		((JSpinner.DefaultEditor) campoGradoRampaSoportada.getEditor()).getTextField().setEditable(false);
		add(campoGradoRampaSoportada);

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
		if ((Double) campoCadencia.getValue() == 0.0) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de Cadencia.", "Campo Vacío",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if ((Double) campoAceleracionPromedio.getValue() == 0.0) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de Aceleración Promedio.", "Campo Vacío",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if ((Integer) campoGradoRampaSoportada.getValue() == 0) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de Grado de Rampa Soportada.", "Campo Vacío",
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
		campoCadencia.setEnabled(true);
		campoConEspecialidad.setEnabled(true);
		campoAceleracionPromedio.setEnabled(true);
		campoGradoRampaSoportada.setEnabled(true);
		botonActualizar.setEnabled(true);
	}

	/**
	 * Deshabilitar entradas Y boton actualizar.
	 */
	public void deshabilitarEntradasYBotonActualizar() {
		campoNombre.setEnabled(false);
		campoCadencia.setEnabled(false);
		campoConEspecialidad.setEnabled(false);
		campoAceleracionPromedio.setEnabled(false);
		campoGradoRampaSoportada.setEnabled(false);
		botonActualizar.setEnabled(false);
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
	 * Mostrar mensaje numero de documento no encontrado.
	 */
	public void mostrarMensajeNumeroDeDocumentoNoEncontrado() {
		JOptionPane.showMessageDialog(this, "El número de documento proporcionado no ha sido encontrado.",
				"Número de documento No Encontrado", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostrar mensaje ciclista escalador actualizado.
	 */
	public void mostrarMensajeCiclistaEscaladorActualizado() {
		JOptionPane.showMessageDialog(this, "Ciclista Escalador actualizado exitosamente.",
				"Ciclista Escalador Actualizado", JOptionPane.INFORMATION_MESSAGE);
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

}
