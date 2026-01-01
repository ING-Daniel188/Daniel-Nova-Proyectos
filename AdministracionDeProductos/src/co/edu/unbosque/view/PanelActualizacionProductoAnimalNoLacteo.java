package co.edu.unbosque.view;

import java.util.Date;

/**
 * The Class PanelActualizacionProductoAnimalNoLacteo.
 */
public class PanelActualizacionProductoAnimalNoLacteo extends PanelCreacionProductoAnimalNoLacteo {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new panel actualizacion producto animal no lacteo.
	 */
	public PanelActualizacionProductoAnimalNoLacteo() {
		getLabelTitulo().setText("Actualizar Producto Animal No Lácteo");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX() - 60, super.getLabelTitulo().getY(),
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
	 * @param tipoAnimal the tipo animal
	 * @param origen the origen
	 */
	public void llenarEntradas(String nombre, double precio, String proveedor, int cantidad,
			Date fechaCaducidadCalendario, String tipoAnimal, String origen) {
		super.llenarEntradas(nombre, precio, proveedor, cantidad, fechaCaducidadCalendario);
		getSeleccionableTipoAnimal().setSelectedItem(tipoAnimal);
		getSeleccionableOrigen().setSelectedItem(origen);
	}

}
