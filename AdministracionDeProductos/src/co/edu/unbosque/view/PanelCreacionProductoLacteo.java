package co.edu.unbosque.view;

import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * The Class PanelCreacionProductoLacteo.
 */
public class PanelCreacionProductoLacteo extends PanelCreacionProducto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The label tipo. */
	private JLabel labelTipo;
	
	/** The seleccionable tipo. */
	private JComboBox<String> seleccionableTipo;

	/**
	 * Instantiates a new panel creacion producto lacteo.
	 */
	public PanelCreacionProductoLacteo() {
		getLabelTitulo().setText("Crear Producto Lácteo");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX() - 20, super.getLabelTitulo().getY(),
				super.getLabelTitulo().getWidth() + 75, super.getLabelTitulo().getHeight());

		labelTipo = new JLabel("Tipo");
		labelTipo.setFont(super.getFuentePlana());
		labelTipo.setBounds(30, 360, 75, 50);
		add(labelTipo);

		seleccionableTipo = new JComboBox<String>();
		seleccionableTipo.addItem("Seleccionar");
		seleccionableTipo.addItem("Leche");
		seleccionableTipo.addItem("Queso");
		seleccionableTipo.addItem("Yogur");
		seleccionableTipo.addItem("Mantequilla");
		seleccionableTipo.setFont(super.getFuentePlanaMediana());
		seleccionableTipo.setMaximumRowCount(4);
		seleccionableTipo.setBounds(180, 360, 350, 50);
		add(seleccionableTipo);
	}
	
	/**
	 * Reiniciar entradas.
	 */
	public void reiniciarEntradas() {
		super.reiniciarEntradas();
		seleccionableTipo.setSelectedIndex(0);
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
		
		if (seleccionableTipo.getSelectedIndex() == 0) {
			super.mostrarMensajeError("El origen del producto lácteo no ha sido seleccionado");
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

}
