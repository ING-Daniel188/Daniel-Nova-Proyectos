package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import co.edu.unbosque.model.PokemonDTO;

/**
 * Clase que representa el panel de visualización de pokemones en la interfaz
 * gráfica. Permite mostrar una lista de pokemones, buscar por diferentes
 * criterios y seleccionar un pokemon para ver sus detalles.
 */
public class PanelPokemones extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Etiqueta para el título del panel.
	 */
	private JLabel etiquetaTitulo;

	/**
	 * Modelo de tabla para los pokemones.
	 */
	private DefaultTableModel modeloTablaPokemones;

	/**
	 * Tabla para mostrar los pokemones.
	 */
	private JTable tablaPokemones;

	/**
	 * Panel de desplazamiento para la tabla de pokemones.
	 */
	private JScrollPane panelDesplazamiento;

	/**
	 * Panel para contener los botones de acción.
	 */
	protected JPanel panelBotones;

	/**
	 * Botón para buscar pokemones por ID.
	 */
	private JButton botonBuscarPorID;

	/**
	 * Botón para buscar pokemones por nombre.
	 */
	private JButton botonBuscarPorNombre;

	/**
	 * Botón para agregar un nuevo pokemon.
	 */
	private JButton botonAgregar;

	/**
	 * Panel de desplazamiento para el panel de visualización de pokemon.
	 */
	private JScrollPane scrollPaneVisualizacion;

	/**
	 * Panel para visualizar los detalles de un pokemon seleccionado.
	 */
	private PanelVisualizacionPokemon panelVisualizacionPokemon;

	/**
	 * Campo de texto para la búsqueda de pokemones por ID.
	 */
	private JTextField campoBuscarPorID;

	/**
	 * Campo de texto para la búsqueda de pokemones por nombre.
	 */
	private JTextField campoBuscarPorNombre;

	/**
	 * Componente seleccionable para filtrar pokemones por tipo.
	 */
	private JComboBox<String> seleccionableFiltrarPorTipo;

	/**
	 * Botón para filtrar pokemones por tipo.
	 */
	private JButton botonFiltrarPorTipo;

	/**
	 * Botón para mostrar todos los pokemones.
	 */
	private JButton botonMostrarTodos;

	/**
	 * Constructor que inicializa el panel de pokemones, configurando los
	 * componentes gráficos y sus respectivos eventos.
	 */
	public PanelPokemones() {
		setLayout(new BorderLayout());
		etiquetaTitulo = new JLabel("Pokedex", JLabel.CENTER);

		modeloTablaPokemones = new DefaultTableModel(
				new String[] { "ID", "Nombre", "Tipo", "Altura", "Peso", "Salud", "Ataque", "Ataque Especial",
						"Defensa", "Defensa Especial", "Velocidad", "Legendario", "Ataques", "Generacion" },
				0);

		tablaPokemones = new JTable(modeloTablaPokemones);

		// Hacer que la tabla no sea editable
		tablaPokemones.setDefaultEditor(Object.class, null);

		// Prohibir la reordenación de columnas
		tablaPokemones.getTableHeader().setReorderingAllowed(false);

		// Ajustar anchos de las columnas
		tablaPokemones.getColumnModel().getColumn(0).setPreferredWidth(30);
		tablaPokemones.getColumnModel().getColumn(0).setMinWidth(10);
		tablaPokemones.getColumnModel().getColumn(0).setMaxWidth(100);

		// Asegurar que solo se pueda seleccionar una fila a la vez
		tablaPokemones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		centerRenderer.setBackground(new Color(230, 240, 250));

		for (int i = 0; i < tablaPokemones.getColumnCount(); i++) {
			tablaPokemones.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		JTableHeader header = tablaPokemones.getTableHeader();

		tablaPokemones.setRowHeight(25);

		tablaPokemones.setFont(new Font("SansSerif", Font.PLAIN, 12));
		header.setFont(new Font("SansSerif", Font.BOLD, 12));

		tablaPokemones.setGridColor(Color.GRAY);

		panelDesplazamiento = new JScrollPane(tablaPokemones);

		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 2, 10, 0));
		botonAgregar = new JButton("Agregar");

		Dimension tamanoBoton = new Dimension(150, 50);
		botonAgregar.setPreferredSize(tamanoBoton);

		panelBotones.add(botonAgregar);

		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setLayout(new GridLayout(1, 7, 10, 0));

		botonMostrarTodos = new JButton("Mostrar Todos");
		panelBusqueda.add(botonMostrarTodos);
		campoBuscarPorID = new JTextField();
		botonBuscarPorID = new JButton("Buscar por ID");
		campoBuscarPorNombre = new JTextField();
		botonBuscarPorNombre = new JButton("Buscar por Nombre");
		seleccionableFiltrarPorTipo = new JComboBox<>(new String[] { "Seleccionar Tipo" });
		botonFiltrarPorTipo = new JButton("Filtrar por Tipo");
		panelBusqueda.add(campoBuscarPorID);
		panelBusqueda.add(botonBuscarPorID);
		panelBusqueda.add(campoBuscarPorNombre);
		panelBusqueda.add(botonBuscarPorNombre);
		panelBusqueda.add(seleccionableFiltrarPorTipo);
		panelBusqueda.add(botonFiltrarPorTipo);

		JPanel panelTitulo = new JPanel(new BorderLayout());
		panelTitulo.add(etiquetaTitulo, BorderLayout.NORTH);
		panelTitulo.add(panelBusqueda, BorderLayout.CENTER);
		add(panelTitulo, BorderLayout.NORTH);

		add(panelDesplazamiento, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.SOUTH);

		panelVisualizacionPokemon = new PanelVisualizacionPokemon();
		scrollPaneVisualizacion = new JScrollPane(panelVisualizacionPokemon);
		scrollPaneVisualizacion.setPreferredSize(new Dimension(400, 300));

		add(scrollPaneVisualizacion, BorderLayout.EAST);

		tablaPokemones.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting() && tablaPokemones.getSelectedRow() != -1) {
				int fila = tablaPokemones.getSelectedRow();
				PokemonDTO pokemonSeleccionado = convertirFilaAPokemonDTO(fila);
				panelVisualizacionPokemon.updatePokemon(pokemonSeleccionado);
			}
		});

	}

	/**
	 * Actualiza la tabla de pokemones con los datos proporcionados.
	 * 
	 * @param pokemones Matriz de objetos con los datos de los pokemones a mostrar.
	 */
	public void actualizarTablaPokemones(Object[][] pokemones) {
		modeloTablaPokemones.setRowCount(0);
		HashSet<String> tiposUnicos = new HashSet<>();

		for (Object[] pokemon : pokemones) {
			modeloTablaPokemones.addRow(pokemon);
			tiposUnicos.add(pokemon[2].toString());
		}

		seleccionableFiltrarPorTipo.removeAllItems();
		seleccionableFiltrarPorTipo.addItem("Seleccionar Tipo");
		for (String tipo : tiposUnicos) {
			seleccionableFiltrarPorTipo.addItem(tipo);
		}
	}

	/**
	 * Actualiza la tabla de pokemones con los datos filtrados proporcionados.
	 * 
	 * @param pokemones Matriz de objetos con los datos de los pokemones filtrados a
	 *                  mostrar.
	 */
	public void actualizarTablaPokemonesFiltrada(Object[][] pokemones) {
		modeloTablaPokemones.setRowCount(0);
		for (Object[] pokemon : pokemones) {
			modeloTablaPokemones.addRow(pokemon);
		}
	}

	/**
	 * Busca un pokemon por su ID y muestra sus detalles si es encontrado.
	 */
	public void buscarPokemonPorID() {
		String textoID = campoBuscarPorID.getText();
		boolean encontrado = false; // Bandera para verificar si se encontró un Pokémon
		try {
			int id = Integer.parseInt(textoID); // Validar si la entrada es un número
			for (int fila = 0; fila < tablaPokemones.getRowCount(); fila++) {
				int idTabla = Integer.parseInt(tablaPokemones.getValueAt(fila, 0).toString());
				if (idTabla == id) {
					tablaPokemones.setRowSelectionInterval(fila, fila); // Seleccionar la fila
					tablaPokemones.scrollRectToVisible(tablaPokemones.getCellRect(fila, 0, true));
					PokemonDTO pokemonSeleccionado = convertirFilaAPokemonDTO(fila);
					panelVisualizacionPokemon.updatePokemon(pokemonSeleccionado);
					encontrado = true;
				}
			}
			if (!encontrado) {
				JOptionPane.showMessageDialog(this, "No se ha encontrado el Pokémon con el ID: " + id,
						"Pokémon no encontrado", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido para el ID.", "Error de Búsqueda",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Busca un pokemon por su nombre y muestra sus detalles si es encontrado.
	 */
	public void buscarPokemonPorNombre() {
		String textoNombre = campoBuscarPorNombre.getText().trim();
		boolean encontrado = false; // Bandera para verificar si se encontró un Pokémon
		if (!textoNombre.isEmpty()) {
			for (int fila = 0; fila < tablaPokemones.getRowCount(); fila++) {
				String nombreTabla = tablaPokemones.getValueAt(fila, 1).toString();
				if (nombreTabla.equalsIgnoreCase(textoNombre)) {
					tablaPokemones.setRowSelectionInterval(fila, fila); // Seleccionar la fila
					tablaPokemones.scrollRectToVisible(tablaPokemones.getCellRect(fila, 0, true));
					PokemonDTO pokemonSeleccionado = convertirFilaAPokemonDTO(fila);
					panelVisualizacionPokemon.updatePokemon(pokemonSeleccionado);
					encontrado = true;
					break;
				}
			}
			if (!encontrado) {
				JOptionPane.showMessageDialog(this, "No se ha encontrado el Pokémon con el nombre: " + textoNombre,
						"Pokémon no encontrado", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre válido.", "Error de Búsqueda",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Convierte los datos de una fila seleccionada en la tabla a un objeto
	 * PokemonDTO.
	 * 
	 * @param fila Índice de la fila seleccionada.
	 * @return Un objeto PokemonDTO con los datos del pokemon seleccionado.
	 */
	private PokemonDTO convertirFilaAPokemonDTO(int fila) {

		int id = Integer.parseInt(modeloTablaPokemones.getValueAt(fila, 0).toString());
		String nombre = modeloTablaPokemones.getValueAt(fila, 1).toString();
		String tipo = modeloTablaPokemones.getValueAt(fila, 2).toString();
		float altura = Float.parseFloat(modeloTablaPokemones.getValueAt(fila, 3).toString());
		float peso = Float.parseFloat(modeloTablaPokemones.getValueAt(fila, 4).toString());
		int salud = Integer.parseInt(modeloTablaPokemones.getValueAt(fila, 5).toString());
		int ataque = Integer.parseInt(modeloTablaPokemones.getValueAt(fila, 6).toString());
		int ataqueEspecial = Integer.parseInt(modeloTablaPokemones.getValueAt(fila, 7).toString());
		int defensa = Integer.parseInt(modeloTablaPokemones.getValueAt(fila, 8).toString());
		int defensaEspecial = Integer.parseInt(modeloTablaPokemones.getValueAt(fila, 9).toString());
		int velocidad = Integer.parseInt(modeloTablaPokemones.getValueAt(fila, 10).toString());
		boolean legendario = modeloTablaPokemones.getValueAt(fila, 11).toString().equals("Si");
		ArrayList<String> ataques = new ArrayList<>();
		int generacion = Integer.parseInt(modeloTablaPokemones.getValueAt(fila, 13).toString());
		ataques.add(modeloTablaPokemones.getValueAt(fila, 12).toString());

		return new PokemonDTO(id, nombre, tipo, altura, peso, salud, ataque, ataqueEspecial, defensa, defensaEspecial,
				velocidad, legendario, ataques, generacion);
	}

	/**
	 * Valida si se ha seleccionado un tipo de pokemon para filtrar.
	 * 
	 * @return true si se ha seleccionado un tipo, false en caso contrario.
	 */
	public boolean validarTipoSeleccionado() {
		if (modeloTablaPokemones.getRowCount() == 0) {
			JOptionPane.showMessageDialog(this, "Actualmente no hay pokemones.", "Tabla vacía",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (seleccionableFiltrarPorTipo.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Por favor, seleccione un tipo de pokemon.", "Error de Búsqueda",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * Valida si se ha seleccionado una fila en la tabla de pokemones.
	 * 
	 * @return true si se ha seleccionado una fila, false en caso contrario.
	 */
	public boolean validarFilaSeleccionada() {
		if (tablaPokemones.getRowCount() == 0) {
			JOptionPane.showMessageDialog(this, "Actualmente no hay pokemones.", "Tabla vacía",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (tablaPokemones.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila.", "Error de Búsqueda",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	/**
	 * Obtiene el ID del pokemon seleccionado en la tabla.
	 * 
	 * @return El ID del pokemon seleccionado.
	 */
	public int obtenerIDPokemonSeleccionado() {
		return Integer.parseInt(modeloTablaPokemones.getValueAt(tablaPokemones.getSelectedRow(), 0).toString());
	}

	/**
	 * Obtiene el nombre del pokemon seleccionado en la tabla.
	 * 
	 * @return El nombre del pokemon seleccionado.
	 */
	public String obtenerNombrePokemonSeleccionado() {
		return modeloTablaPokemones.getValueAt(tablaPokemones.getSelectedRow(), 1).toString();
	}

	/**
	 * Obtiene el tipo del pokemon seleccionado en la tabla.
	 * 
	 * @return El tipo del pokemon seleccionado.
	 */
	public String obtenerTipoPokemonSeleccionado() {
		return modeloTablaPokemones.getValueAt(tablaPokemones.getSelectedRow(), 2).toString();
	}

	/**
	 * Obtiene la altura del pokemon seleccionado en la tabla.
	 * 
	 * @return La altura del pokemon seleccionado.
	 */
	public float obtenerAlturaPokemonSeleccionado() {
		return Float.parseFloat(modeloTablaPokemones.getValueAt(tablaPokemones.getSelectedRow(), 3).toString());
	}

	/**
	 * Obtiene el peso del pokemon seleccionado en la tabla.
	 * 
	 * @return El peso del pokemon seleccionado.
	 */
	public float obtenerPesoPokemonSeleccionado() {

		return Float.parseFloat(modeloTablaPokemones.getValueAt(tablaPokemones.getSelectedRow(), 4).toString());
	}

	/**
	 * Obtiene los puntos de salud del pokemon seleccionado en la tabla.
	 * 
	 * @return Los puntos de salud del pokemon seleccionado.
	 */
	public int obtenerSaludPokemonSeleccionado() {
		return Integer.parseInt(modeloTablaPokemones.getValueAt(tablaPokemones.getSelectedRow(), 5).toString());
	}

	/**
	 * Obtiene los puntos de ataque del pokemon seleccionado en la tabla.
	 * 
	 * @return Los puntos de ataque del pokemon seleccionado.
	 */
	public int obtenerAtaquePokemonSeleccionado() {
		return Integer.parseInt(modeloTablaPokemones.getValueAt(tablaPokemones.getSelectedRow(), 6).toString());
	}

	/**
	 * Obtiene los puntos de ataque especial del pokemon seleccionado en la tabla.
	 * 
	 * @return Los puntos de ataque especial del pokemon seleccionado.
	 */
	public int obtenerAtaqueEspecialPokemonSeleccionado() {
		return Integer.parseInt(modeloTablaPokemones.getValueAt(tablaPokemones.getSelectedRow(), 7).toString());
	}

	/**
	 * Obtiene los puntos de defensa del pokemon seleccionado en la tabla.
	 * 
	 * @return Los puntos de defensa del pokemon seleccionado.
	 */
	public int obtenerDefensaPokemonSeleccionado() {
		return Integer.parseInt(modeloTablaPokemones.getValueAt(tablaPokemones.getSelectedRow(), 8).toString());
	}

	/**
	 * Obtiene los puntos de defensa especial del pokemon seleccionado en la tabla.
	 * 
	 * @return Los puntos de defensa especial del pokemon seleccionado.
	 */
	public int obtenerDefensaEspecialPokemonSeleccionado() {
		return Integer.parseInt(modeloTablaPokemones.getValueAt(tablaPokemones.getSelectedRow(), 9).toString());
	}

	/**
	 * Obtiene la velocidad del pokemon seleccionado en la tabla.
	 * 
	 * @return La velocidad del pokemon seleccionado.
	 */
	public int obtenerVelocidadPokemonSeleccionado() {
		return Integer.parseInt(modeloTablaPokemones.getValueAt(tablaPokemones.getSelectedRow(), 10).toString());
	}

	/**
	 * Determina si el pokemon seleccionado en la tabla es legendario.
	 * 
	 * @return true si el pokemon es legendario, false en caso contrario.
	 */
	public boolean obtenerLegendarioPokemonSeleccionado() {
		return modeloTablaPokemones.getValueAt(tablaPokemones.getSelectedRow(), 11).toString().equals("Si");
	}

	/**
	 * Obtiene la lista de ataques del pokemon seleccionado en la tabla.
	 * 
	 * @return Una lista de strings con los ataques del pokemon seleccionado.
	 */
	public ArrayList<String> obtenerAtaquesPokemonSeleccionado() {
		return convertirAtaquesALista(modeloTablaPokemones.getValueAt(tablaPokemones.getSelectedRow(), 12).toString());
	}

	/**
	 * Obtiene la generación del pokemon seleccionado en la tabla.
	 * 
	 * @return La generación del pokemon seleccionado.
	 */
	public int obtenerGeneracionPokemonSeleccionado() {
		return Integer.parseInt(modeloTablaPokemones.getValueAt(tablaPokemones.getSelectedRow(), 13).toString());
	}

	/**
	 * Convierte una cadena de texto con ataques separados por comas en una lista de
	 * ataques.
	 * 
	 * @param ataques Cadena de texto con los ataques.
	 * @return Una lista de strings con los ataques.
	 */
	public ArrayList<String> convertirAtaquesALista(String ataques) {
		ataques = ataques.replace("[", "").replace("]", "").replace("'", "");
		String[] ataquesArray = ataques.split(", ");
		return new ArrayList<>(Arrays.asList(ataquesArray));
	}

	/**
	 * Obtiene el botón para buscar pokemones por ID.
	 * 
	 * @return El botón buscar por ID.
	 */
	public JButton getBotonBuscarPorID() {
		return botonBuscarPorID;
	}

	/**
	 * Obtiene el botón para buscar pokemones por nombre.
	 * 
	 * @return El botón buscar por nombre.
	 */
	public JButton getBotonBuscarPorNombre() {
		return botonBuscarPorNombre;
	}

	/**
	 * Obtiene el campo de texto para la búsqueda de pokemones por ID.
	 * 
	 * @return El campo de texto para buscar por ID.
	 */
	public JTextField getCampoBuscarPorID() {
		return campoBuscarPorID;
	}

	/**
	 * Obtiene el campo de texto para la búsqueda de pokemones por nombre.
	 * 
	 * @return El campo de texto para buscar por nombre.
	 */
	public JTextField getCampoBuscarPorNombre() {
		return campoBuscarPorNombre;
	}

	/**
	 * Obtiene el componente seleccionable para filtrar pokemones por tipo.
	 * 
	 * @return El componente JComboBox para seleccionar el tipo de pokemon.
	 */
	public JComboBox<String> getSeleccionableFiltrarPorTipo() {
		return seleccionableFiltrarPorTipo;
	}

	/**
	 * Obtiene el botón para filtrar pokemones por tipo.
	 * 
	 * @return El botón filtrar por tipo.
	 */
	public JButton getBotonFiltrarPorTipo() {
		return botonFiltrarPorTipo;
	}

	/**
	 * Obtiene el botón para mostrar todos los pokemones.
	 * 
	 * @return El botón mostrar todos.
	 */
	public JButton getBotonMostrarTodos() {
		return botonMostrarTodos;
	}

	/**
	 * Obtiene el botón para agregar un nuevo pokemon.
	 * 
	 * @return El botón agregar.
	 */
	public JButton getBotonAgregar() {
		return botonAgregar;
	}

	/**
	 * Obtiene el panel de visualización de detalles de un pokemon seleccionado.
	 * 
	 * @return El panel de visualización de pokemon.
	 */
	public PanelVisualizacionPokemon getPanelVisualizacionPokemon() {
		return panelVisualizacionPokemon;
	}

}
