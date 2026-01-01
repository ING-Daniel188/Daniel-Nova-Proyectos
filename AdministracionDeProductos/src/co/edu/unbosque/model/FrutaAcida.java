package co.edu.unbosque.model;

/**
 * The Class FrutaAcida.
 */
public class FrutaAcida extends Fruta {
	
	/** The intensidad acido. */
	private String intensidadAcido;

	/**
	 * Instantiates a new fruta acida.
	 *
	 * @param nombre the nombre
	 * @param precio the precio
	 * @param cantidad the cantidad
	 * @param fechaCaducidad the fecha caducidad
	 * @param proveedor the proveedor
	 * @param esOrganica the es organica
	 * @param intensidadAcido the intensidad acido
	 */
	public FrutaAcida(String nombre, double precio, int cantidad, String fechaCaducidad, String proveedor,
			boolean esOrganica, String intensidadAcido) {
		super(nombre, "Frutas Acidas", precio, cantidad, fechaCaducidad, proveedor, esOrganica);
		this.intensidadAcido = intensidadAcido;
	}

	/**
	 * Gets the intensidad acido.
	 *
	 * @return the intensidad acido
	 */
	public String getIntensidadAcido() {
		return intensidadAcido;
	}
}
