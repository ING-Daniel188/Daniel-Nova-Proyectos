package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * PanelPokemonesAgregados extiende de PanelPokemones y se encarga de la
 * visualización y manejo de eventos relacionados con los pokemones agregados,
 * como actualizar y eliminar pokemones.
 */
public class PanelPokemonesAgregados extends PanelPokemones {

	/**
	 * Identificador único para la serialización.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Botón para actualizar la información de un pokemon seleccionado.
	 */
	private JButton botonActualizar;

	/**
	 * Botón para eliminar un pokemon seleccionado.
	 */
	private JButton botonEliminar;

	/**
	 * Constructor que inicializa el panel, sus componentes y configura los botones
	 * de actualizar y eliminar.
	 */
	public PanelPokemonesAgregados() {
		panelBotones.removeAll();
		panelBotones.setLayout(new GridLayout(1, 2, 10, 0));

		botonActualizar = new JButton("Actualizar");
		botonEliminar = new JButton("Eliminar");

		Dimension tamanioBoton = new Dimension(150, 50);
		botonActualizar.setPreferredSize(tamanioBoton);
		botonEliminar.setPreferredSize(tamanioBoton);

		panelBotones.add(botonActualizar);
		panelBotones.add(botonEliminar);
	}

	/**
	 * Actualiza la tabla de pokemones con los datos proporcionados. Convierte el
	 * valor de la columna 'legendario' de booleano a "Sí" o "No".
	 * 
	 * @param pokemones Matriz de objetos con los datos de los pokemones a mostrar.
	 */
	@Override
	public void actualizarTablaPokemones(Object[][] pokemones) {
		for (Object[] fila : pokemones) {
			int columnaLegendario = 11;
			fila[columnaLegendario] = fila[columnaLegendario].equals(true) ? "Sí" : "No";
		}
		super.actualizarTablaPokemones(pokemones);
	}

	/**
	 * Muestra un diálogo de confirmación para la eliminación de un pokemon
	 * seleccionado.
	 * 
	 * @return true si el usuario confirma la eliminación, false en caso contrario.
	 */
	public boolean confirmarEliminacionPokemon() {
		UIManager.put("OptionPane.yesButtonText", "Si");
		UIManager.put("OptionPane.noButtonText", "No");
		int opcion = JOptionPane.showConfirmDialog(this,
				"Está seguro de que desea eliminar el pokemon con id " + obtenerIDPokemonSeleccionado(),
				"Mensaje de Confirmación", JOptionPane.YES_NO_OPTION);
		if (opcion == 1 || opcion == -1) {
			return false;
		}
		return true;
	}

	/**
	 * Obtiene el botón de actualizar.
	 * 
	 * @return El botón de actualizar.
	 */
	public JButton getBotonActualizar() {
		return botonActualizar;
	}

	/**
	 * Obtiene el botón de eliminar.
	 * 
	 * @return El botón de eliminar.
	 */
	public JButton getBotonEliminar() {
		return botonEliminar;
	}

}
