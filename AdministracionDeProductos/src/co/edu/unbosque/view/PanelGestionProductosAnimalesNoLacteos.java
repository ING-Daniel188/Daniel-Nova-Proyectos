package co.edu.unbosque.view;

/**
 * The Class PanelGestionProductosAnimalesNoLacteos.
 */
public class PanelGestionProductosAnimalesNoLacteos extends PanelGestionProducto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new panel gestion productos animales no lacteos.
	 */
	public PanelGestionProductosAnimalesNoLacteos() {
		getLabelTitulo().setText("Gestionar Productos Animales No Lácteos");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX() - 149, super.getLabelTitulo().getY(),
				super.getLabelTitulo().getWidth() + 330, super.getLabelTitulo().getHeight());

		getModeloTabla().addColumn("Tipo Animal");
		getModeloTabla().addColumn("Origen");
		super.actualizarAnchoColumnas();
	}

}
