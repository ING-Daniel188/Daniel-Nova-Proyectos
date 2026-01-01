package co.edu.unbosque.view;

import java.util.Date;

/**
 * The Class PanelActualizacionCarneFria.
 */
public class PanelActualizacionCarneFria extends PanelCreacionCarneFria {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new panel actualizacion carne fria.
	 */
	public PanelActualizacionCarneFria() {
		getLabelTitulo().setText("Actualizar Carne Fría");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX() - 100, super.getLabelTitulo().getY(),
				super.getLabelTitulo().getWidth() + 200, super.getLabelTitulo().getHeight());
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
	 * @param origen the origen
	 */
	public void llenarEntradas(String nombre, double precio, String proveedor, int cantidad,
			Date fechaCaducidadCalendario, String tipo, String origen) {
		super.llenarEntradas(nombre, precio, proveedor, cantidad, fechaCaducidadCalendario);
		getSeleccionableTipo().setSelectedItem(tipo);
		getSeleccionableOrigen().setSelectedItem(origen);
	}
}
