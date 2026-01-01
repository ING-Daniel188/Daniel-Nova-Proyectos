package co.edu.unbosque.view;

/**
 * The Class PanelGestionComidaChatarra.
 */
public class PanelGestionComidaChatarra extends PanelGestionProducto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new panel gestion comida chatarra.
	 */
	public PanelGestionComidaChatarra() {
		getLabelTitulo().setText("Gestionar Comida Chatarra");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX() - 40, super.getLabelTitulo().getY(),
				super.getLabelTitulo().getWidth() + 110, super.getLabelTitulo().getHeight());
		super.actualizarAnchoColumnas();
	}

}
