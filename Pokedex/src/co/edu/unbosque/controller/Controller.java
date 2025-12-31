package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;
import co.edu.unbosque.model.PokemonDTO;

/**
 * La clase Controller se encarga de manejar las acciones realizadas por el
 * usuario en la interfaz gráfica y comunicarlas con el modelo de la aplicación.
 * Esta clase implementa la interfaz ActionListener para manejar eventos de
 * acción.
 */
public class Controller implements ActionListener {

	/**
	 * Instancia de ModelFacade que permite la interacción con el modelo de la
	 * aplicación.
	 */
	private ModelFacade mf;
	/**
	 * Instancia de ViewFacade que permite la interacción con la vista de la
	 * aplicación.
	 */
	private ViewFacade vf;

	/**
	 * Constructor de la clase Controller. Inicializa las fachadas del modelo y la
	 * vista, y configura los comandos de acción y los listeners para los botones de
	 * la interfaz gráfica.
	 */
	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();

		// Eventos del Panel Pokemones
		vf.getPanelPokemones().getBotonMostrarTodos().setActionCommand("btnMostrarTodos");
		vf.getPanelPokemones().getBotonMostrarTodos().addActionListener(this);

		vf.getPanelPokemones().getBotonBuscarPorID().setActionCommand("btnBuscarPorID");
		vf.getPanelPokemones().getBotonBuscarPorID().addActionListener(this);

		vf.getPanelPokemones().getBotonBuscarPorNombre().setActionCommand("btnBuscarPorNombre");
		vf.getPanelPokemones().getBotonBuscarPorNombre().addActionListener(this);

		vf.getPanelPokemones().getBotonFiltrarPorTipo().setActionCommand("btnFiltrarPorTipo");
		vf.getPanelPokemones().getBotonFiltrarPorTipo().addActionListener(this);

		vf.getPanelPokemones().getBotonAgregar().setActionCommand("btnAgregar");
		vf.getPanelPokemones().getBotonAgregar().addActionListener(this);

		// Eventos del Panel Pokemones Agregados
		vf.getPanelPokemonesAgregados().getBotonMostrarTodos().setActionCommand("btnMostrarTodosPnlPA");
		vf.getPanelPokemonesAgregados().getBotonMostrarTodos().addActionListener(this);

		vf.getPanelPokemonesAgregados().getBotonBuscarPorID().setActionCommand("btnBuscarPorIDPnlPA");
		vf.getPanelPokemonesAgregados().getBotonBuscarPorID().addActionListener(this);

		vf.getPanelPokemonesAgregados().getBotonBuscarPorNombre().setActionCommand("btnBuscarPorNombrePnlPA");
		vf.getPanelPokemonesAgregados().getBotonBuscarPorNombre().addActionListener(this);

		vf.getPanelPokemonesAgregados().getBotonFiltrarPorTipo().setActionCommand("btnFiltrarPorTipoPnlPA");
		vf.getPanelPokemonesAgregados().getBotonFiltrarPorTipo().addActionListener(this);

		vf.getPanelPokemonesAgregados().getBotonActualizar().setActionCommand("btnActualizar");
		vf.getPanelPokemonesAgregados().getBotonActualizar().addActionListener(this);

		vf.getPanelPokemonesAgregados().getBotonEliminar().setActionCommand("btnEliminar");
		vf.getPanelPokemonesAgregados().getBotonEliminar().addActionListener(this);

		// Eventos del Panel Visualizacion Pokemon
		vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().getActualizarButton()
				.setActionCommand("btnActualizarPnlVP");
		vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().getActualizarButton().addActionListener(this);
	}

	/**
	 * Inicia la ejecución del controlador, mostrando la interfaz gráfica y
	 * actualizando las tablas de pokemones.
	 */
	public void run() {
		vf.getPanelPokemones().actualizarTablaPokemones(mf.getGestorDePokemones().leerPokemonesDeCSV());
		vf.getPanelPokemonesAgregados()
				.actualizarTablaPokemones(mf.getGestorDePokemones().convertirListaActualObjetosAMatriz());
		vf.setVisible(true);
	}

	/**
	 * Maneja los eventos de acción generados por los componentes de la interfaz
	 * gráfica. Este método es llamado automáticamente cuando el usuario realiza una
	 * acción (como clic en un botón).
	 * 
	 * @param e El evento de acción generado.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Declaración de variables utilizadas
		int id;
		String nombre;
		String tipo;
		float altura;
		float peso;
		int ataque;
		int defensa;
		int ataqueEspecial;
		int defensaEspecial;
		int velocidad;
		int salud;
		boolean legendario;
		ArrayList<String> ataques;
		int generacion;
		PokemonDTO pokemonSeleccionado;

		switch (e.getActionCommand()) {
			// Comandos de acción del Panel Pokemones
			case "btnMostrarTodos" ->
				vf.getPanelPokemones().actualizarTablaPokemones(mf.getGestorDePokemones().leerPokemonesDeCSV());
			case "btnBuscarPorID" -> vf.getPanelPokemones().buscarPokemonPorID();
			case "btnBuscarPorNombre" -> vf.getPanelPokemones().buscarPokemonPorNombre();
			case "btnFiltrarPorTipo" -> {
				if (vf.getPanelPokemones().validarTipoSeleccionado()) {
					vf.getPanelPokemones()
							.actualizarTablaPokemonesFiltrada(mf.getGestorDePokemones().leerPokemonesDeCSVFiltrados(
									vf.getPanelPokemones().getSeleccionableFiltrarPorTipo().getSelectedItem().toString()));
				}
			}
			case "btnAgregar" -> {
				if (!vf.getPanelPokemones().validarFilaSeleccionada())
					return;
	
				id = vf.getPanelPokemones().obtenerIDPokemonSeleccionado();
				if (mf.getGestorDePokemones().encontrarPokemon(id)) {
					vf.mostrarMensajeError("El pokemon seleccionado ya ha sido agregado");
					return;
				}
	
				// Obtener todos los datos del pokemon seleccionado
				nombre = vf.getPanelPokemones().obtenerNombrePokemonSeleccionado();
				tipo = vf.getPanelPokemones().obtenerTipoPokemonSeleccionado();
				altura = vf.getPanelPokemones().obtenerAlturaPokemonSeleccionado();
				peso = vf.getPanelPokemones().obtenerPesoPokemonSeleccionado();
				salud = vf.getPanelPokemones().obtenerSaludPokemonSeleccionado();
				ataque = vf.getPanelPokemones().obtenerAtaquePokemonSeleccionado();
				ataqueEspecial = vf.getPanelPokemones().obtenerAtaqueEspecialPokemonSeleccionado();
				defensa = vf.getPanelPokemones().obtenerDefensaPokemonSeleccionado();
				defensaEspecial = vf.getPanelPokemones().obtenerDefensaEspecialPokemonSeleccionado();
				velocidad = vf.getPanelPokemones().obtenerVelocidadPokemonSeleccionado();
				legendario = vf.getPanelPokemones().obtenerLegendarioPokemonSeleccionado();
				ataques = vf.getPanelPokemones().obtenerAtaquesPokemonSeleccionado();
				generacion = vf.getPanelPokemones().obtenerGeneracionPokemonSeleccionado();
	
				// Crear el objeto PokemonDTO con los datos obtenidos
				pokemonSeleccionado = new PokemonDTO(id, nombre, tipo, altura, peso, salud, ataque, ataqueEspecial, defensa,
						defensaEspecial, velocidad, legendario, ataques, generacion);
	
				// Agregar el Pokemon
				mf.getGestorDePokemones().agregar(pokemonSeleccionado);
	
				vf.getTabbedPane().setSelectedIndex(1);
				vf.getPanelPokemonesAgregados()
						.actualizarTablaPokemones(mf.getGestorDePokemones().convertirListaActualObjetosAMatriz());
				vf.getPanelPokemonesAgregados().getCampoBuscarPorID().setText(id + "");
				vf.getPanelPokemonesAgregados().buscarPokemonPorID();
				vf.getPanelPokemonesAgregados().getCampoBuscarPorID().setText("");
				vf.mostrarMensaje("Pokemon agregado");
			}
	
			// Comandos de acción del Panel Pokemones Agregados
			case "btnMostrarTodosPnlPA" -> vf.getPanelPokemonesAgregados()
					.actualizarTablaPokemones(mf.getGestorDePokemones().convertirListaActualObjetosAMatriz());
			case "btnBuscarPorIDPnlPA" -> vf.getPanelPokemonesAgregados().buscarPokemonPorID();
			case "btnBuscarPorNombrePnlPA" -> vf.getPanelPokemonesAgregados().buscarPokemonPorNombre();
			case "btnFiltrarPorTipoPnlPA" -> {
				if (vf.getPanelPokemonesAgregados().validarTipoSeleccionado()) {
					vf.getPanelPokemonesAgregados().actualizarTablaPokemonesFiltrada(
							mf.getGestorDePokemones().obtenerMatrizPokemonesPorTipo(vf.getPanelPokemonesAgregados()
									.getSeleccionableFiltrarPorTipo().getSelectedItem().toString()));
				}
			}
			case "btnActualizar" -> {
				if (vf.getPanelPokemonesAgregados().validarFilaSeleccionada()) {
					vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().habilitarEntradas();
				}
			}
			case "btnEliminar" -> {
				if (vf.getPanelPokemonesAgregados().validarFilaSeleccionada()
						&& vf.getPanelPokemonesAgregados().confirmarEliminacionPokemon()) {
					id = vf.getPanelPokemonesAgregados().obtenerIDPokemonSeleccionado();
					mf.getGestorDePokemones().eliminarPokemon(id);
					vf.getPanelPokemonesAgregados()
							.actualizarTablaPokemones(mf.getGestorDePokemones().convertirListaActualObjetosAMatriz());
					vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().removeAll();
					vf.mostrarMensaje("El pokemon con ID: " + id + " ha sido eliminado correctamente");
				}
			}
	
			// Comandos de acción del Panel Visualización Pokemon
			case "btnActualizarPnlVP" -> {
	
				if (vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().validarEntradas()) {
					id = Integer.parseInt(vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().getIdLabel()
							.getText().replace("ID: ", ""));
					nombre = vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().getLabelNombre().getText()
							.replace("Nombre: ", "");
					tipo = vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().getTipoField().getText();
					altura = Float.parseFloat(
							vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().getAlturaField().getText());
					peso = Float.parseFloat(
							vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().getPesoField().getText());
					salud = vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().getSaludBar().getValue();
					ataque = vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().getAtaqueBar().getValue();
					ataqueEspecial = vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().getAtaqueEspecialBar()
							.getValue();
					defensa = vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().getDefensaBar().getValue();
					defensaEspecial = vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().getDefensaEspecialBar()
							.getValue();
					velocidad = vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().getVelocidadBar().getValue();
					legendario = vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon().getLegendarioSi()
							.isSelected();
					ataques = new ArrayList<>(Arrays.asList(vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon()
							.getAtaquesTextField().getText().replace("[", "").replace("]", "").split(", ")));
					generacion = Integer.parseInt(vf.getPanelPokemonesAgregados().getPanelVisualizacionPokemon()
							.getGeneracionLabel().getText().replace("Generación: ", ""));
	
					pokemonSeleccionado = new PokemonDTO(id, nombre, tipo, altura, peso, salud, ataque, ataqueEspecial,
							defensa, defensaEspecial, velocidad, legendario, ataques, generacion);
	
					mf.getGestorDePokemones().actualizarPokemon(id, pokemonSeleccionado);
					vf.getPanelPokemonesAgregados()
							.actualizarTablaPokemones(mf.getGestorDePokemones().convertirListaActualObjetosAMatriz());
					vf.getPanelPokemonesAgregados().getCampoBuscarPorID().setText(id + "");
					vf.getPanelPokemonesAgregados().buscarPokemonPorID();
					vf.getPanelPokemonesAgregados().getCampoBuscarPorID().setText("");
					vf.mostrarMensaje("El pokemon con ID: " + id + " ha sido actualizado correctamente");
				}
	
			}

		}
	}
}
