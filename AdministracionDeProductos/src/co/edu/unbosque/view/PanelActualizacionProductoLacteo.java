package co.edu.unbosque.view;

import java.util.Date;

/**
 * The Class PanelActualizacionProductoLacteo.
 */
public class PanelActualizacionProductoLacteo extends PanelCreacionProductoLacteo {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new panel actualizacion producto lacteo.
	 */
	public PanelActualizacionProductoLacteo() {
		getLabelTitulo().setText("Actualizar Producto Lácteo");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX() - 35, super.getLabelTitulo().getY(),
				super.getLabelTitulo().getWidth() + 70, super.getLabelTitulo().getHeight());
		getBtnAgregarProducto().setText("Modificar Producto");
	}

	/**
	 * Llenar entradas.
	 *
	 * @param nombre the nombre
	 * @param precio the precio
	 * @param proveedor the proveedor
	 * @param cantidad the cantidad
	 * @param fechaCaducidadCalendario the fecha caducidad calendario
	 * @param tipo the tipo
	 */
	public void llenarEntradas(String nombre, double precio, String proveedor, int cantidad,
			Date fechaCaducidadCalendario, String tipo) {
		super.llenarEntradas(nombre, precio, proveedor, cantidad, fechaCaducidadCalendario);
		getSeleccionableTipo().setSelectedItem(tipo);
	}

}
