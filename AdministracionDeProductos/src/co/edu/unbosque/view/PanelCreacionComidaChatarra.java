package co.edu.unbosque.view;

/**
 * The Class PanelCreacionComidaChatarra.
 */
public class PanelCreacionComidaChatarra extends PanelCreacionProducto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new panel creacion comida chatarra.
	 */
	public PanelCreacionComidaChatarra() {
		getLabelTitulo().setText("Crear Comida Chatarra");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX() - 40, super.getLabelTitulo().getY(),
				super.getLabelTitulo().getWidth() + 110, super.getLabelTitulo().getHeight());
	}

}
