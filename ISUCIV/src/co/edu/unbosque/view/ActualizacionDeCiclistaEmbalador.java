package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class ActualizacionDeCiclistaEmbalador.
 */
public class ActualizacionDeCiclistaEmbalador extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5795617061409939474L;
	
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
	
	/** The boton actualizar. */
	private JButton botonActualizar;
	
	/** The boton cargar datos. */
	private JButton botonCargarDatos;

	/**
	 * Instantiates a new actualizacion de ciclista embalador.
	 */
	public ActualizacionDeCiclistaEmbalador() {
		setBorder(new TitledBorder("Actualizar Ciclista Embalador"));
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

		add(new JLabel("Nueva Potencia Promedio:"));
		campoPotenciaPromedio = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 1000.0, 1.0));
		campoPotenciaPromedio.setEditor(new JSpinner.NumberEditor(campoPotenciaPromedio, "#.0"));
		((JSpinner.DefaultEditor) campoPotenciaPromedio.getEditor()).getTextField().setEditable(false);
		add(campoPotenciaPromedio);

		add(new JLabel("Nueva Velocidad Promedio en Sprint:"));
		campoVelocidadPromedioEnSprint = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 100.0, 0.1));
		campoVelocidadPromedioEnSprint.setEditor(new JSpinner.NumberEditor(campoVelocidadPromedioEnSprint, "#.0"));
		((JSpinner.DefaultEditor) campoVelocidadPromedioEnSprint.getEditor()).getTextField().setEditable(false);
		add(campoVelocidadPromedioEnSprint);

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
		if ((Double) campoPotenciaPromedio.getValue() == 0.0) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de Potencia Promedio.", "Campo Vacío",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if ((Double) campoVelocidadPromedioEnSprint.getValue() == 0.0) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de Velocidad Promedio en Sprint.",
					"Campo Vacío", JOptionPane.WARNING_MESSAGE);
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
		campoPotenciaPromedio.setEnabled(true);
		campoVelocidadPromedioEnSprint.setEnabled(true);
		botonActualizar.setEnabled(true);
	}

	/**
	 * Deshabilitar entradas Y boton actualizar.
	 */
	public void deshabilitarEntradasYBotonActualizar() {
		campoNombre.setEnabled(false);
		campoCadencia.setEnabled(false);
		campoConEspecialidad.setEnabled(false);
		campoPotenciaPromedio.setEnabled(false);
		campoVelocidadPromedioEnSprint.setEnabled(false);
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
		campoPotenciaPromedio.setValue(0.0);
		campoVelocidadPromedioEnSprint.setValue(0.0);
	}

	/**
	 * Mostrar mensaje numero de documento no encontrado.
	 */
	public void mostrarMensajeNumeroDeDocumentoNoEncontrado() {
		JOptionPane.showMessageDialog(this, "El número de documento proporcionado no ha sido encontrado.",
				"Número de documento No Encontrado", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostrar mensaje ciclista embalador actualizado.
	 */
	public void mostrarMensajeCiclistaEmbaladorActualizado() {
		JOptionPane.showMessageDialog(this, "Ciclista Embalador actualizado exitosamente.",
				"Ciclista Embalador Actualizado", JOptionPane.INFORMATION_MESSAGE);
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
