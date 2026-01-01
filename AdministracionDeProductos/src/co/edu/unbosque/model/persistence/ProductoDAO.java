package co.edu.unbosque.model.persistence;

/**
 * The Class ProductoDAO.
 */
public class ProductoDAO {
	
	/** The gestion carnes frias. */
	private CarneFriaDAO gestionCarnesFrias;
	
	/** The gestion productos lacteos. */
	private ProductoLacteoDAO gestionProductosLacteos;
	
	/** The gestion productos animales no lacteos. */
	private ProductoAnimalNoLacteoDAO gestionProductosAnimalesNoLacteos;
	
	/** The gestion frutas dulces. */
	private FrutaDulceDAO gestionFrutasDulces;
	
	/** The gestion frutas acidas. */
	private FrutaAcidaDAO gestionFrutasAcidas;
	
	/** The gestion verduras. */
	private VerduraDAO gestionVerduras;
	
	/** The gestion comidas chatarra. */
	private ComidaChatarraDAO gestionComidasChatarra;

	/**
	 * Instantiates a new producto DAO.
	 */
	public ProductoDAO() {
		gestionCarnesFrias = new CarneFriaDAO();
		gestionProductosLacteos = new ProductoLacteoDAO();
		gestionProductosAnimalesNoLacteos = new ProductoAnimalNoLacteoDAO();
		gestionFrutasDulces = new FrutaDulceDAO();
		gestionFrutasAcidas = new FrutaAcidaDAO();
		gestionVerduras = new VerduraDAO();
		gestionComidasChatarra = new ComidaChatarraDAO();
	}

	/**
	 * Gets the gestion carnes frias.
	 *
	 * @return the gestion carnes frias
	 */
	public CarneFriaDAO getGestionCarnesFrias() {
		return gestionCarnesFrias;
	}

	/**
	 * Gets the gestion productos lacteos.
	 *
	 * @return the gestion productos lacteos
	 */
	public ProductoLacteoDAO getGestionProductosLacteos() {
		return gestionProductosLacteos;
	}

	/**
	 * Gets the gestion productos animales no lacteos.
	 *
	 * @return the gestion productos animales no lacteos
	 */
	public ProductoAnimalNoLacteoDAO getGestionProductosAnimalesNoLacteos() {
		return gestionProductosAnimalesNoLacteos;
	}

	/**
	 * Gets the gestion frutas dulces.
	 *
	 * @return the gestion frutas dulces
	 */
	public FrutaDulceDAO getGestionFrutasDulces() {
		return gestionFrutasDulces;
	}

	/**
	 * Gets the gestion frutas acidas.
	 *
	 * @return the gestion frutas acidas
	 */
	public FrutaAcidaDAO getGestionFrutasAcidas() {
		return gestionFrutasAcidas;
	}

	/**
	 * Gets the gestion verduras.
	 *
	 * @return the gestion verduras
	 */
	public VerduraDAO getGestionVerduras() {
		return gestionVerduras;
	}

	/**
	 * Gets the gestion comidas chatarra.
	 *
	 * @return the gestion comidas chatarra
	 */
	public ComidaChatarraDAO getGestionComidasChatarra() {
		return gestionComidasChatarra;
	}
}
