package co.edu.unbosque.model;

/**
 * The Class ComidaChatarra.
 */
public class ComidaChatarra extends Producto {

	/**
	 * Instantiates a new comida chatarra.
	 *
	 * @param nombre the nombre
	 * @param precio the precio
	 * @param cantidad the cantidad
	 * @param fechaCaducidad the fecha caducidad
	 * @param proveedor the proveedor
	 */
	public ComidaChatarra(String nombre, double precio, int cantidad, String fechaCaducidad, String proveedor) {
		super(nombre, "Comidas Chatarra", precio, cantidad, fechaCaducidad, proveedor);
	}

}
