package co.edu.unbosque.model;

/**
 * The Class FrutaDulce.
 */
public class FrutaDulce extends Fruta {
	
	/** The intensidad dulce. */
	private String intensidadDulce;

	/**
	 * Instantiates a new fruta dulce.
	 *
	 * @param nombre the nombre
	 * @param precio the precio
	 * @param cantidad the cantidad
	 * @param fechaCaducidad the fecha caducidad
	 * @param proveedor the proveedor
	 * @param esOrganica the es organica
	 * @param intensidadDulce the intensidad dulce
	 */
	public FrutaDulce(String nombre, double precio, int cantidad, String fechaCaducidad, String proveedor,
			boolean esOrganica, String intensidadDulce) {
		super(nombre, "Frutas Dulces", precio, cantidad, fechaCaducidad, proveedor, esOrganica);
		this.intensidadDulce = intensidadDulce;
	}

	/**
	 * Gets the intensidad dulce.
	 *
	 * @return the intensidad dulce
	 */
	public String getIntensidadDulce() {
		return intensidadDulce;
	}
}
