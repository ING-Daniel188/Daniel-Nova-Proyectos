package co.edu.unbosque.view;

import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * The Class PanelCreacionProductoAnimalNoLacteo.
 */
public class PanelCreacionProductoAnimalNoLacteo extends PanelCreacionProducto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The label tipo animal. */
	private JLabel labelTipoAnimal;
	
	/** The seleccionable tipo animal. */
	private JComboBox<String> seleccionableTipoAnimal;
	
	/** The label origen. */
	private JLabel labelOrigen;
	
	/** The seleccionable origen. */
	private JComboBox<String> seleccionableOrigen;
	
	/**
	 * Instantiates a new panel creacion producto animal no lacteo.
	 */
	public PanelCreacionProductoAnimalNoLacteo() {
		getLabelTitulo().setText("Crear Producto Animal No Lácteo");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX() - 100, super.getLabelTitulo().getY(),
				super.getLabelTitulo().getWidth() + 230, super.getLabelTitulo().getHeight());
		
		labelTipoAnimal = new JLabel("Tipo de Animal");
		labelTipoAnimal.setFont(super.getFuentePlana());
		labelTipoAnimal.setBounds(30, 360, 200, 50);
		add(labelTipoAnimal);

		seleccionableTipoAnimal = new JComboBox<String>();
		seleccionableTipoAnimal.addItem("Seleccionar");
		seleccionableTipoAnimal.addItem("Res");
		seleccionableTipoAnimal.addItem("Cerdo");
		seleccionableTipoAnimal.addItem("Pollo");
		seleccionableTipoAnimal.addItem("Pez");
		seleccionableTipoAnimal.addItem("Oveja");
		seleccionableTipoAnimal.addItem("Cabra");
		seleccionableTipoAnimal.addItem("Ave de Corral");
		seleccionableTipoAnimal.addItem("Conejo");
		seleccionableTipoAnimal.addItem("Animales Marinos");
		seleccionableTipoAnimal.setFont(super.getFuentePlanaMediana());
		seleccionableTipoAnimal.setMaximumRowCount(4);
		seleccionableTipoAnimal.setBounds(300, 360, 250, 50);
		add(seleccionableTipoAnimal);
		
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
		seleccionableOrigen.setBounds(180, 440, 370, 50);
		add(seleccionableOrigen);
	}
	
	/**
	 * Reiniciar entradas.
	 */
	public void reiniciarEntradas() {
		super.reiniciarEntradas();
		seleccionableTipoAnimal.setSelectedIndex(0);
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
		
		if (seleccionableTipoAnimal.getSelectedIndex() == 0) {
			super.mostrarMensajeError("El tipo de animal del producto animal no lácteo no ha sido seleccionado");
			return false;
		}
		
		if (seleccionableOrigen.getSelectedIndex() == 0) {
			super.mostrarMensajeError("El origen del animal del producto animal no lácteo no ha sido seleccionado");
			return false;
		}
		return true;
	}

	/**
	 * Gets the seleccionable tipo animal.
	 *
	 * @return the seleccionable tipo animal
	 */
	public JComboBox<String> getSeleccionableTipoAnimal() {
		return seleccionableTipoAnimal;
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
