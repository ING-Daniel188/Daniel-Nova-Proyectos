package co.edu.unbosque.model;

/**
 * The Class Verdura.
 */
public class Verdura extends Producto {

	/**
	 * Instantiates a new verdura.
	 *
	 * @param nombre the nombre
	 * @param precio the precio
	 * @param cantidad the cantidad
	 * @param fechaCaducidad the fecha caducidad
	 * @param proveedor the proveedor
	 */
	public Verdura(String nombre, double precio, int cantidad, String fechaCaducidad, String proveedor) {
		super(nombre, "Verduras", precio, cantidad, fechaCaducidad, proveedor);
	}

}
