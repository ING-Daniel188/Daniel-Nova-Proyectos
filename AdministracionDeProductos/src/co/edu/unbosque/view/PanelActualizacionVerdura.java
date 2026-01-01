package co.edu.unbosque.view;

/**
 * The Class PanelActualizacionVerdura.
 */
public class PanelActualizacionVerdura extends PanelCreacionVerdura {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new panel actualizacion verdura.
	 */
	public PanelActualizacionVerdura() {
		getLabelTitulo().setText("Actualizar Verdura");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX() - 30, super.getLabelTitulo().getY(),
				super.getLabelTitulo().getWidth() + 80, super.getLabelTitulo().getHeight());
		getBtnAgregarProducto().setText("Modificar Producto");
	}

}
