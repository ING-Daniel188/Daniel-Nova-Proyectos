package co.edu.unbosque.view;

/**
 * The Class PanelActualizacionComidaChatarra.
 */
public class PanelActualizacionComidaChatarra extends PanelCreacionComidaChatarra {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new panel actualizacion comida chatarra.
	 */
	public PanelActualizacionComidaChatarra() {
		getLabelTitulo().setText("Actualizar Comida Chatarra");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX() - 30, super.getLabelTitulo().getY(),
				super.getLabelTitulo().getWidth() + 80, super.getLabelTitulo().getHeight());
		getBtnAgregarProducto().setText("Modificar Producto");
	}

}
