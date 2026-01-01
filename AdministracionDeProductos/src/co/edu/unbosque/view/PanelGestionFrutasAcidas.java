package co.edu.unbosque.view;

/**
 * The Class PanelGestionFrutasAcidas.
 */
public class PanelGestionFrutasAcidas extends PanelGestionProducto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new panel gestion frutas acidas.
	 */
	public PanelGestionFrutasAcidas() {
		getLabelTitulo().setText("Gestionar Frutas Ácidas");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX() - 20, super.getLabelTitulo().getY(),
				super.getLabelTitulo().getWidth() + 70, super.getLabelTitulo().getHeight());

		getModeloTabla().addColumn("Es Orgánica");
		getModeloTabla().addColumn("Intensidad del Ácido");
		super.actualizarAnchoColumnas();
	}

}
