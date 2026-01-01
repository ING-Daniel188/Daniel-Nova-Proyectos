package co.edu.unbosque.model;

/**
 * The Class ProductoAnimalNoLacteo.
 */
public class ProductoAnimalNoLacteo extends Producto {

	/** The tipo de animal. */
	private String tipoDeAnimal;
	
	/** The origen. */
	private String origen;

	/**
	 * Instantiates a new producto animal no lacteo.
	 *
	 * @param nombre the nombre
	 * @param precio the precio
	 * @param cantidad the cantidad
	 * @param fechaCaducidad the fecha caducidad
	 * @param proveedor the proveedor
	 * @param tipoDeAnimal the tipo de animal
	 * @param origen the origen
	 */
	public ProductoAnimalNoLacteo(String nombre, double precio, int cantidad, String fechaCaducidad, String proveedor,
			String tipoDeAnimal, String origen) {
		super(nombre, "Productos Animales No Lacteos", precio, cantidad, fechaCaducidad, proveedor);
		this.tipoDeAnimal = tipoDeAnimal;
		this.origen = origen;
	}

	/**
	 * Gets the tipo de animal.
	 *
	 * @return the tipo de animal
	 */
	public String getTipoDeAnimal() {
		return tipoDeAnimal;
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
