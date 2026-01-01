package co.edu.unbosque.view;

import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * The Class PanelCreacionCarneFria.
 */
public class PanelCreacionCarneFria extends PanelCreacionProducto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The label tipo. */
	private JLabel labelTipo;
	
	/** The seleccionable tipo. */
	private JComboBox<String> seleccionableTipo;

	/** The label origen. */
	private JLabel labelOrigen;
	
	/** The seleccionable origen. */
	private JComboBox<String> seleccionableOrigen;

	/**
	 * Instantiates a new panel creacion carne fria.
	 */
	public PanelCreacionCarneFria() {
		getLabelTitulo().setText("Crear Carne Fría");

		labelTipo = new JLabel("Tipo");
		labelTipo.setFont(super.getFuentePlana());
		labelTipo.setBounds(30, 360, 75, 50);
		add(labelTipo);

		seleccionableTipo = new JComboBox<String>();
		seleccionableTipo.addItem("Seleccionar");
		seleccionableTipo.addItem("Res");
		seleccionableTipo.addItem("Cerdo");
		seleccionableTipo.addItem("Pollo");
		seleccionableTipo.addItem("Cordero");
		seleccionableTipo.addItem("Pavo");
		seleccionableTipo.addItem("Pescado y Mariscos");
		seleccionableTipo.setFont(super.getFuentePlanaMediana());
		seleccionableTipo.setMaximumRowCount(4);
		seleccionableTipo.setBounds(180, 360, 350, 50);
		add(seleccionableTipo);

		labelOrigen = new JLabel("Origen");
		labelOrigen.setFont(super.getFuentePlana());
		labelOrigen.setBounds(30, 440, 100, 50);
		add(labelOrigen);

		seleccionableOrigen = new JComboBox<String>();
		seleccionableOrigen.addItem("Seleccionar");
		seleccionableOrigen.addItem("Argentina");
		seleccionableOrigen.addItem("Brasil");
		seleccionableOrigen.addItem("Estados Unidos");
		seleccionableOrigen.addItem("Australia");
		seleccionableOrigen.addItem("Uruguay");
		seleccionableOrigen.addItem("Nueva Zelanda");
		seleccionableOrigen.addItem("Canada");
		seleccionableOrigen.addItem("México");
		seleccionableOrigen.addItem("España");
		seleccionableOrigen.addItem("Japón");
		seleccionableOrigen.setFont(super.getFuentePlanaMediana());
		seleccionableOrigen.setMaximumRowCount(4);
		seleccionableOrigen.setBounds(180, 440, 350, 50);
		add(seleccionableOrigen);
	}

	/**
	 * Reiniciar entradas.
	 */
	public void reiniciarEntradas() {
		super.reiniciarEntradas();
		seleccionableTipo.setSelectedIndex(0);
		seleccionableOrigen.setSelectedIndex(0);
	}

	/**
	 * Validar entradas.
	 *
	 * @return true, if successful
	 */
	public boolean validarEntradas() {
		if (!super.validarEntradas()) {
			return false;
		}
		
		if (seleccionableTipo.getSelectedIndex() == 0 || seleccionableOrigen.getSelectedIndex() == 0) {
			super.mostrarMensajeError("El origen o el tipo de carne fría no han sido seleccionados");
			return false;
		}
		return true;
	}

	/**
	 * Gets the seleccionable tipo.
	 *
	 * @return the seleccionable tipo
	 */
	public JComboBox<String> getSeleccionableTipo() {
		return seleccionableTipo;
	}

	/**
	 * Gets the seleccionable origen.
	 *
	 * @return the seleccionable origen
	 */
	public JComboBox<String> getSeleccionableOrigen() {
		return seleccionableOrigen;
	}

}
