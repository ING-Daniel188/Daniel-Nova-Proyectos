package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class CreacionYActualizacionDeEscuadra.
 */
public class CreacionYActualizacionDeEscuadra extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1174057949583500921L;
	
	/** The campo nombre. */
	private JTextField campoNombre;
	
	/** The combo pais de origen. */
	private JComboBox<String> comboPaisDeOrigen;
	
	/** The boton crear escuadra. */
	private JButton botonCrearEscuadra;
	
	/** The campo numero de documento ciclista. */
	private JTextField campoNumeroDeDocumentoCiclista;
	
	/** The campo nombre escuadra. */
	private JTextField campoNombreEscuadra;
	
	/** The boton agregar ciclista. */
	private JButton botonAgregarCiclista;
	
	/** The boton eliminar ciclista. */
	private JButton botonEliminarCiclista;

	/**
	 * Instantiates a new creacion Y actualizacion de escuadra.
	 */
	public CreacionYActualizacionDeEscuadra() {
		setBorder(new TitledBorder("Crear y Actualizar Escuadra"));
		setLayout(new GridLayout(1, 2));

		JPanel panelFormulario = new JPanel(new GridLayout(1, 2));

		JPanel panelCreacionDeEscuadra = new JPanel(new GridLayout(3, 2, 5, 5));
		panelCreacionDeEscuadra.add(new JLabel("Nombre de la Escuadra:"));
		campoNombre = new JTextField();
		panelCreacionDeEscuadra.add(campoNombre);

		panelCreacionDeEscuadra.add(new JLabel("País de Origen:"));
		comboPaisDeOrigen = new JComboBox<>();
		comboPaisDeOrigen.addItem("...");
		comboPaisDeOrigen.addItem("Alemania");
		comboPaisDeOrigen.addItem("Australia");
		comboPaisDeOrigen.addItem("Bélgica");
		comboPaisDeOrigen.addItem("Brasil");
		comboPaisDeOrigen.addItem("Canadá");
		comboPaisDeOrigen.addItem("Colombia");
		comboPaisDeOrigen.addItem("Dinamarca");
		comboPaisDeOrigen.addItem("España");
		comboPaisDeOrigen.addItem("Estados Unidos");
		comboPaisDeOrigen.addItem("Francia");
		comboPaisDeOrigen.addItem("Italia");
		comboPaisDeOrigen.addItem("Noruega");
		comboPaisDeOrigen.addItem("Nueva Zelanda");
		comboPaisDeOrigen.addItem("Países Bajos");
		comboPaisDeOrigen.addItem("Reino Unido");
		comboPaisDeOrigen.addItem("Rusia");
		comboPaisDeOrigen.addItem("Suiza");
		panelCreacionDeEscuadra.add(comboPaisDeOrigen);

		panelCreacionDeEscuadra.add(new JLabel());
		botonCrearEscuadra = new JButton("Crear Escuadra");
		panelCreacionDeEscuadra.add(botonCrearEscuadra);

		panelFormulario.add(panelCreacionDeEscuadra);

		JPanel panelAgregarCiclista = new JPanel(new GridLayout(3, 2, 5, 5));
		panelAgregarCiclista.add(new JLabel("Número de Documento del Ciclista:"));
		campoNumeroDeDocumentoCiclista = new JTextField(20);
		panelAgregarCiclista.add(campoNumeroDeDocumentoCiclista);

		panelAgregarCiclista.add(new JLabel("Nombre de la Escuadra:"));
		campoNombreEscuadra = new JTextField();
		panelAgregarCiclista.add(campoNombreEscuadra);

		botonEliminarCiclista = new JButton("Eliminar Ciclista de Escuadra");
		panelAgregarCiclista.add(botonEliminarCiclista);
		botonAgregarCiclista = new JButton("Agregar Ciclista a Escuadra");
		panelAgregarCiclista.add(botonAgregarCiclista);

		panelFormulario.add(panelAgregarCiclista);

		add(panelFormulario);
	}

	/**
	 * Mostrar mensaje nombre de escuadra encontrado.
	 */
	public void mostrarMensajeNombreDeEscuadraEncontrado() {
		JOptionPane.showMessageDialog(this, "El nombre de la escuadra proporcionado ya existe.", "Escuadra Encontrada",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostrar mensaje escuadra creada.
	 */
	public void mostrarMensajeEscuadraCreada() {
		JOptionPane.showMessageDialog(this, "Escuadra creada exitosamente.", "Escuadra Creada",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Mostrar mensaje nombre de escuadra no encontrado.
	 */
	public void mostrarMensajeNombreDeEscuadraNoEncontrado() {
		JOptionPane.showMessageDialog(this, "El nombre de la escuadra proporcionado no existe.",
				"Escuadra No Encontrada", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostrar mensaje numero de documento de ciclista no encontrado.
	 */
	public void mostrarMensajeNumeroDeDocumentoDeCiclistaNoEncontrado() {
		JOptionPane.showMessageDialog(this, "El número de documento del ciclista proporcionado no existe.",
				"Ciclista No Encontrado", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostrar mensaje ciclista ya en escuadra.
	 */
	public void mostrarMensajeCiclistaYaEnEscuadra() {
		JOptionPane.showMessageDialog(this, "El ciclista ya ha sido agregado a la escuadra.", "Ciclista Ya En Escuadra",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostrar mensaje ciclista agregado A escuadra.
	 */
	public void mostrarMensajeCiclistaAgregadoAEscuadra() {
		JOptionPane.showMessageDialog(this, "El ciclista ha sido agregado a la escuadra.", "Ciclista Agregado",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Mostrar mensaje ciclista no en escuadra.
	 */
	public void mostrarMensajeCiclistaNoEnEscuadra() {
		JOptionPane.showMessageDialog(this, "El ciclista no está en la escuadra especificada.",
				"Ciclista No En Escuadra", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostrar mensaje ciclista eliminado de escuadra.
	 */
	public void mostrarMensajeCiclistaEliminadoDeEscuadra() {
		JOptionPane.showMessageDialog(this, "El ciclista ha sido eliminado de la escuadra exitosamente.",
				"Ciclista Eliminado De Escuadra", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Validar entradas.
	 *
	 * @return true, if successful
	 */
	public boolean validarEntradas() {
		if (campoNombre.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de nombre.", "Campo Vacío",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * Validar entradas agregar ciclista.
	 *
	 * @return true, if successful
	 */
	public boolean validarEntradasAgregarCiclista() {
		if (campoNumeroDeDocumentoCiclista.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, llene el campo de número de documento.", "Campo Vacío",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (campoNombreEscuadra.getText().trim().isEmpty()) {
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
		campoNombre.setText("");
		comboPaisDeOrigen.setSelectedIndex(0);
	}

	/**
	 * Obtener nombre de escuadra.
	 *
	 * @return the string
	 */
	public String obtenerNombreDeEscuadra() {
		return campoNombreEscuadra.getText();
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
	 * Obtener nombre.
	 *
	 * @return the string
	 */
	public String obtenerNombre() {
		return campoNombre.getText();
	}

	/**
	 * Establecer nombre de escuadra.
	 *
	 * @param nombreDeEscuadra the nombre de escuadra
	 */
	public void establecerNombreDeEscuadra(String nombreDeEscuadra) {
		campoNombreEscuadra.setText(nombreDeEscuadra);
	}

	/**
	 * Obtener numero de documento ciclista.
	 *
	 * @return the string
	 */
	public String obtenerNumeroDeDocumentoCiclista() {
		return campoNumeroDeDocumentoCiclista.getText();
	}

	/**
	 * Establecer numero de documento ciclista.
	 *
	 * @param numeroDeDocumentoCiclista the numero de documento ciclista
	 */
	public void establecerNumeroDeDocumentoCiclista(String numeroDeDocumentoCiclista) {
		campoNumeroDeDocumentoCiclista.setText(numeroDeDocumentoCiclista);
	}

	/**
	 * Gets the boton crear escuadra.
	 *
	 * @return the boton crear escuadra
	 */
	public JButton getBotonCrearEscuadra() {
		return botonCrearEscuadra;
	}

	/**
	 * Sets the boton crear escuadra.
	 *
	 * @param botonCrearEscuadra the new boton crear escuadra
	 */
	public void setBotonCrearEscuadra(JButton botonCrearEscuadra) {
		this.botonCrearEscuadra = botonCrearEscuadra;
	}

	/**
	 * Obtener pais de origen seleccionado.
	 *
	 * @return the string
	 */
	public String obtenerPaisDeOrigenSeleccionado() {
		if (comboPaisDeOrigen.getSelectedIndex() == 0) {
			return null;
		}
		return (String) comboPaisDeOrigen.getSelectedItem();
	}

	/**
	 * Gets the boton agregar ciclista.
	 *
	 * @return the boton agregar ciclista
	 */
	public JButton getBotonAgregarCiclista() {
		return botonAgregarCiclista;
	}

	/**
	 * Sets the boton agregar ciclista.
	 *
	 * @param botonAgregarCiclista the new boton agregar ciclista
	 */
	public void setBotonAgregarCiclista(JButton botonAgregarCiclista) {
		this.botonAgregarCiclista = botonAgregarCiclista;
	}

	/**
	 * Gets the boton eliminar ciclista.
	 *
	 * @return the boton eliminar ciclista
	 */
	public JButton getBotonEliminarCiclista() {
		return botonEliminarCiclista;
	}

	/**
	 * Sets the boton eliminar ciclista.
	 *
	 * @param botonEliminarCiclista the new boton eliminar ciclista
	 */
	public void setBotonEliminarCiclista(JButton botonEliminarCiclista) {
		this.botonEliminarCiclista = botonEliminarCiclista;
	}

}
