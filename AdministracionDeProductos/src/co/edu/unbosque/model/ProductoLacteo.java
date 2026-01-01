package co.edu.unbosque.model;

/**
 * The Class ProductoLacteo.
 */
public class ProductoLacteo extends Producto {

	/** The tipo. */
	private String tipo;

	/**
	 * Instantiates a new producto lacteo.
	 *
	 * @param nombre the nombre
	 * @param precio the precio
	 * @param cantidad the cantidad
	 * @param fechaCaducidad the fecha caducidad
	 * @param proveedor the proveedor
	 * @param tipo the tipo
	 */
	public ProductoLacteo(String nombre, double precio, int cantidad, String fechaCaducidad, String proveedor,
			String tipo) {
		super(nombre, "Productos Lacteos", precio, cantidad, fechaCaducidad, proveedor);
		this.tipo = tipo;
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

}
