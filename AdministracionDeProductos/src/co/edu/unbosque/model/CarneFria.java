package co.edu.unbosque.model;

/**
 * The Class CarneFria.
 */
public class CarneFria extends Producto {

	/** The tipo. */
	private String tipo;
	
	/** The origen. */
	private String origen;

	/**
	 * Instantiates a new carne fria.
	 *
	 * @param nombre the nombre
	 * @param precio the precio
	 * @param cantidad the cantidad
	 * @param fechaCaducidad the fecha caducidad
	 * @param proveedor the proveedor
	 * @param tipo the tipo
	 * @param origen the origen
	 */
	public CarneFria(String nombre, double precio, int cantidad, String fechaCaducidad, String proveedor, String tipo,
			String origen) {
		super(nombre, "Carnes Frias", precio, cantidad, fechaCaducidad, proveedor);
		this.tipo = tipo;
		this.origen = origen;
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Gets the origen.
	 *
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}
}
