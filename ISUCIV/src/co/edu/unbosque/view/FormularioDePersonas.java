package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class FormularioDePersonas.
 */
public class FormularioDePersonas extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3922522831765872810L;
	
	/** The campo nombre escuadra director. */
	private JTextField campoNumeroDocumentoMasajista, campoNombreEscuadraMasajista, campoNumeroDocumentoDirector,
			campoNombreEscuadraDirector;
	
	/** The boton agregar director. */
	private JButton botonAgregarMasajista, botonAgregarDirector;

	/**
	 * Instantiates a new formulario de personas.
	 */
	public FormularioDePersonas() {
		setLayout(new GridLayout(1, 2));

		JPanel panelMasajista = new JPanel(new GridLayout(3, 2));
		panelMasajista.setBorder(new TitledBorder("Agregar Masajista a Escuadra"));
		panelMasajista.add(new JLabel("Número de Documento del Masajista:"));
		campoNumeroDocumentoMasajista = new JTextField();
		panelMasajista.add(campoNumeroDocumentoMasajista);

		panelMasajista.add(new JLabel("Nombre de la Escuadra:"));
		campoNombreEscuadraMasajista = new JTextField();
		panelMasajista.add(campoNombreEscuadraMasajista);

		panelMasajista.add(new JLabel());

		botonAgregarMasajista = new JButton("Agregar Masajista");
		panelMasajista.add(botonAgregarMasajista);

		JPanel panelDirector = new JPanel(new GridLayout(3, 2));
		panelDirector.setBorder(new TitledBorder("Agregar Director a Escuadra"));
		panelDirector.add(new JLabel("Número de Documento del Director:"));
		campoNumeroDocumentoDirector = new JTextField();
		panelDirector.add(campoNumeroDocumentoDirector);

		panelDirector.add(new JLabel("Nombre de la Escuadra:"));
		campoNombreEscuadraDirector = new JTextField();
		panelDirector.add(campoNombreEscuadraDirector);

		panelDirector.add(new JLabel());

		botonAgregarDirector = new JButton("Agregar Director");
		panelDirector.add(botonAgregarDirector);

		add(panelMasajista);
		add(panelDirector);
	}

	/**
	 * Validar entradas masajista.
	 *
	 * @return true, if successful
	 */
	public boolean validarEntradasMasajista() {
		if (campoNumeroDocumentoMasajista.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de número de documento del masajista.",
					"Campo Vacío", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (campoNombreEscuadraMasajista.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de nombre de la escuadra.", "Campo Vacío",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * Validar entradas director.
	 *
	 * @return true, if successful
	 */
	public boolean validarEntradasDirector() {
		if (campoNumeroDocumentoDirector.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de número de documento del director.",
					"Campo Vacío", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (campoNombreEscuadraDirector.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de nombre de la escuadra.", "Campo Vacío",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * Reiniciar entradas.
	 */
	public void reiniciarEntradas() {
		campoNumeroDocumentoMasajista.setText("");
		campoNombreEscuadraMasajista.setText("");
		campoNumeroDocumentoDirector.setText("");
		campoNombreEscuadraDirector.setText("");
	}

	/**
	 * Mostrar mensaje nombre de escuadra encontrado masajista.
	 */
	public void mostrarMensajeNombreDeEscuadraEncontradoMasajista() {
		JOptionPane.showMessageDialog(this, "El nombre de la escuadra proporcionado ya existe.", "Escuadra Encontrada",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostrar mensaje escuadra creada masajista.
	 */
	public void mostrarMensajeEscuadraCreadaMasajista() {
		JOptionPane.showMessageDialog(this, "Escuadra creada exitosamente.", "Escuadra Creada",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Mostrar mensaje nombre de escuadra no encontrado masajista.
	 */
	public void mostrarMensajeNombreDeEscuadraNoEncontradoMasajista() {
		JOptionPane.showMessageDialog(this, "El nombre de la escuadra proporcionado no existe.",
				"Escuadra No Encontrada", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostrar mensaje nombre de escuadra encontrado director.
	 */
	public void mostrarMensajeNombreDeEscuadraEncontradoDirector() {
		JOptionPane.showMessageDialog(this, "El nombre de la escuadra proporcionado ya existe.", "Escuadra Encontrada",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostrar mensaje escuadra creada director.
	 */
	public void mostrarMensajeEscuadraCreadaDirector() {
		JOptionPane.showMessageDialog(this, "Escuadra creada exitosamente.", "Escuadra Creada",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Mostrar mensaje nombre de escuadra no encontrado director.
	 */
	public void mostrarMensajeNombreDeEscuadraNoEncontradoDirector() {
		JOptionPane.showMessageDialog(this, "El nombre de la escuadra proporcionado no existe.",
				"Escuadra No Encontrada", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Mostrar mensaje numero de documento de masajista no encontrado.
	 */
	public void mostrarMensajeNumeroDeDocumentoDeMasajistaNoEncontrado() {
		JOptionPane.showMessageDialog(this, "El número de documento del masajista proporcionado no existe.",
				"Masajista No Encontrado", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Mostrar mensaje nombre de escuadra no encontrado.
	 */
	public void mostrarMensajeNombreDeEscuadraNoEncontrado() {
		JOptionPane.showMessageDialog(this, "El nombre de la escuadra proporcionado no existe.",
				"Nombre de Escuadra No Encontrado", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Mostrar mensaje masajista ya en escuadra.
	 */
	public void mostrarMensajeMasajistaYaEnEscuadra() {
		JOptionPane.showMessageDialog(this, "El masajista ya está en la escuadra.",
				"Masajista ya en Escuadra", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Mostrar mensaje masajista agregado A escuadra.
	 */
	public void mostrarMensajeMasajistaAgregadoAEscuadra() {
		JOptionPane.showMessageDialog(this, "El masajista ha sido agregado correctamente a la escuadra.",
				"Masajista Agregado", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Mostrar mensaje numero de documento de director no encontrado.
	 */
	public void mostrarMensajeNumeroDeDocumentoDeDirectorNoEncontrado() {
		JOptionPane.showMessageDialog(this, "El número de documento del director proporcionado no existe.",
				"Director No Encontrado", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Mostrar mensaje director ya en escuadra.
	 */
	public void mostrarMensajeDirectorYaEnEscuadra() {
		JOptionPane.showMessageDialog(this, "El director deportivo ya está en la escuadra.",
				"Director deportivo ya en Escuadra", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Mostrar mensaje director agregado A escuadra.
	 */
	public void mostrarMensajeDirectorAgregadoAEscuadra() {
		JOptionPane.showMessageDialog(this, "El director deportivo ha sido agregado correctamente a la escuadra.",
				"Director deportivo agregado", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Obtener numero documento masajista.
	 *
	 * @return the string
	 */
	public String obtenerNumeroDocumentoMasajista() {
		return campoNumeroDocumentoMasajista.getText();
	}

	/**
	 * Establecer numero documento masajista.
	 *
	 * @param numeroDocumentoMasajista the numero documento masajista
	 */
	public void establecerNumeroDocumentoMasajista(String numeroDocumentoMasajista) {
		campoNumeroDocumentoMasajista.setText(numeroDocumentoMasajista);
	}

	/**
	 * Obtener nombre escuadra masajista.
	 *
	 * @return the string
	 */
	public String obtenerNombreEscuadraMasajista() {
		return campoNombreEscuadraMasajista.getText();
	}

	/**
	 * Establecer nombre escuadra masajista.
	 *
	 * @param nombreEscuadraMasajista the nombre escuadra masajista
	 */
	public void establecerNombreEscuadraMasajista(String nombreEscuadraMasajista) {
		campoNombreEscuadraMasajista.setText(nombreEscuadraMasajista);
	}

	/**
	 * Obtener numero documento director.
	 *
	 * @return the string
	 */
	public String obtenerNumeroDocumentoDirector() {
		return campoNumeroDocumentoDirector.getText();
	}

	/**
	 * Establecer numero documento director.
	 *
	 * @param numeroDocumentoDirector the numero documento director
	 */
	public void establecerNumeroDocumentoDirector(String numeroDocumentoDirector) {
		campoNumeroDocumentoDirector.setText(numeroDocumentoDirector);
	}

	/**
	 * Obtener nombre escuadra director.
	 *
	 * @return the string
	 */
	public String obtenerNombreEscuadraDirector() {
		return campoNombreEscuadraDirector.getText();
	}

	/**
	 * Establecer nombre escuadra director.
	 *
	 * @param nombreEscuadraDirector the nombre escuadra director
	 */
	public void establecerNombreEscuadraDirector(String nombreEscuadraDirector) {
		campoNombreEscuadraDirector.setText(nombreEscuadraDirector);
	}

	/**
	 * Gets the boton agregar masajista.
	 *
	 * @return the boton agregar masajista
	 */
	public JButton getBotonAgregarMasajista() {
		return botonAgregarMasajista;
	}

	/**
	 * Sets the boton agregar masajista.
	 *
	 * @param botonAgregarMasajista the new boton agregar masajista
	 */
	public void setBotonAgregarMasajista(JButton botonAgregarMasajista) {
		this.botonAgregarMasajista = botonAgregarMasajista;
	}

	/**
	 * Gets the boton agregar director.
	 *
	 * @return the boton agregar director
	 */
	public JButton getBotonAgregarDirector() {
		return botonAgregarDirector;
	}

	/**
	 * Sets the boton agregar director.
	 *
	 * @param botonAgregarDirector the new boton agregar director
	 */
	public void setBotonAgregarDirector(JButton botonAgregarDirector) {
		this.botonAgregarDirector = botonAgregarDirector;
	}

}
