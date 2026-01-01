package co.edu.unbosque.view;

/**
 * The Class PanelGestionVerduras.
 */
public class PanelGestionVerduras extends PanelGestionProducto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new panel gestion verduras.
	 */
	public PanelGestionVerduras() {
		getLabelTitulo().setText("Gestionar Verduras");
		super.actualizarAnchoColumnas();
	}

}
