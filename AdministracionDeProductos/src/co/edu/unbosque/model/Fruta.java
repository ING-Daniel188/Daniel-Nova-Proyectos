package co.edu.unbosque.model;

/**
 * The Class Fruta.
 */
public abstract class Fruta extends Producto {
	
	/** The es organica. */
	protected boolean esOrganica;

	/**
	 * Instantiates a new fruta.
	 *
	 * @param nombre the nombre
	 * @param categoria the categoria
	 * @param precio the precio
	 * @param cantidad the cantidad
	 * @param fechaCaducidad the fecha caducidad
	 * @param proveedor the proveedor
	 * @param esOrganica the es organica
	 */
	protected Fruta(String nombre, String categoria, double precio, int cantidad, String fechaCaducidad,
			String proveedor, boolean esOrganica) {
		super(nombre, categoria, precio, cantidad, fechaCaducidad, proveedor);
		this.esOrganica = esOrganica;
	}

	/**
	 * Checks if is es organica.
	 *
	 * @return true, if is es organica
	 */
	public boolean isEsOrganica() {
		return esOrganica;
	}

}
