package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.PokemonDAO;

/**
 * <b>ModelFacade - Facade del Modelo</b>
 * La clase ModelFacade actúa como una
 * fachada para el subsistema de gestión de Pokemones, proporcionando una
 * interfaz simplificada para interactuar con los objetos de acceso a datos
 * (DAO).
 * <p>
 * Esta clase encapsula la complejidad de las operaciones de acceso a datos,
 * ofreciendo métodos sencillos para realizar operaciones comunes, como obtener
 * el gestor de Pokemones.
 * </p>
 */
public class ModelFacade {
	/**
	 * Instancia de PokemonDAO que permite la gestión de Pokemones.
	 */
	private PokemonDAO gestorDePokemones;

	/**
	 * Constructor que inicializa el gestor de Pokemones.
	 * <p>
	 * Este constructor crea una nueva instancia de PokemonDAO, asignándola al
	 * atributo gestorDePokemones para su uso posterior en operaciones de acceso a
	 * datos.
	 * </p>
	 */
	public ModelFacade() {
		gestorDePokemones = new PokemonDAO();
	}

	/**
	 * Obtiene el gestor de Pokemones.
	 * <p>
	 * Este método permite acceder a la instancia de PokemonDAO utilizada para la
	 * gestión de Pokemones, facilitando la realización de operaciones de acceso a
	 * datos.
	 * </p>
	 * 
	 * @return Una instancia de PokemonDAO para la gestión de Pokemones.
	 */
	public PokemonDAO getGestorDePokemones() {
		return gestorDePokemones;
	}
}
