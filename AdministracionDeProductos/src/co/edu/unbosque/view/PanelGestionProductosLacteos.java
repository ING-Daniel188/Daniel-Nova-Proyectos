package co.edu.unbosque.view;

/**
 * The Class PanelGestionProductosLacteos.
 */
public class PanelGestionProductosLacteos extends PanelGestionProducto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new panel gestion productos lacteos.
	 */
	public PanelGestionProductosLacteos() {
		getLabelTitulo().setText("Gestionar Productos Lácteos");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX() - 60, super.getLabelTitulo().getY(),
				super.getLabelTitulo().getWidth() + 140, super.getLabelTitulo().getHeight());

		getModeloTabla().addColumn("Tipo");
		super.actualizarAnchoColumnas();
		getModeloColumnas().getColumn(6).setPreferredWidth(60);
	}

}
