package co.edu.unbosque.view;

/**
 * The Class PanelGestionCarnesFrias.
 */
public class PanelGestionCarnesFrias extends PanelGestionProducto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new panel gestion carnes frias.
	 */
	public PanelGestionCarnesFrias() {
		getLabelTitulo().setText("Gestionar Carnes Frías");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX() - 30, super.getLabelTitulo().getY(),
				super.getLabelTitulo().getWidth() + 70, super.getLabelTitulo().getHeight());
		
		getModeloTabla().addColumn("Tipo");
		getModeloTabla().addColumn("Origen");
		super.actualizarAnchoColumnas();
		getModeloColumnas().getColumn(6).setPreferredWidth(60);
		getModeloColumnas().getColumn(7).setPreferredWidth(40);
	}
	
}
