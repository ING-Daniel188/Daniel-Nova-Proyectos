package co.edu.unbosque.view;

import java.util.Date;

/**
 * The Class PanelActualizacionFrutaDulce.
 */
public class PanelActualizacionFrutaDulce extends PanelCreacionFrutaDulce {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new panel actualizacion fruta dulce.
	 */
	public PanelActualizacionFrutaDulce() {
		getLabelTitulo().setText("Actualizar Fruta Dulce");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX(), super.getLabelTitulo().getY(),
				super.getLabelTitulo().getWidth() + 60, super.getLabelTitulo().getHeight());
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
	 * @param esOrganica the es organica
	 * @param intensidadDulce the intensidad dulce
	 */
	public void llenarEntradas(String nombre, double precio, String proveedor, int cantidad,
			Date fechaCaducidadCalendario, boolean esOrganica, String intensidadDulce) {
		super.llenarEntradas(nombre, precio, proveedor, cantidad, fechaCaducidadCalendario);
		getSeleccionableIntensidad().setSelectedItem(intensidadDulce);
		getSeleccionableEsOrganica().setSelectedItem(esOrganica ? "Si" : "No");
	}

}
