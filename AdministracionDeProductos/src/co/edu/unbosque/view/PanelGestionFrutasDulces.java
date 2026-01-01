package co.edu.unbosque.view;

/**
 * The Class PanelGestionFrutasDulces.
 */
public class PanelGestionFrutasDulces extends PanelGestionProducto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new panel gestion frutas dulces.
	 */
	public PanelGestionFrutasDulces() {
		getLabelTitulo().setText("Gestionar Frutas Dulces");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX() - 20, super.getLabelTitulo().getY(),
				super.getLabelTitulo().getWidth() + 70, super.getLabelTitulo().getHeight());

		getModeloTabla().addColumn("Es Orgánica");
		getModeloTabla().addColumn("Intensidad del Dulce");
		super.actualizarAnchoColumnas();
	}

}
