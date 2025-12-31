package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * The Class PanelInformacionApuestaBetPlay.
 */
public class PanelInformacionApuestaBetPlay extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Modelo de la tabla para mostrar visualizar partidos. */
	private DefaultTableModel modeloTabla;

	/** Tabla de apuestas para los partidos. */
	private JTable tablaApuestasPartidos;
	
	/**
	 * Instantiates a new panel informacion apuesta bet play.
	 */
	public PanelInformacionApuestaBetPlay() {
		setLayout(new GridLayout(1, 1, 25, 25));
		setBorder(BorderFactory.createTitledBorder("Apuesta BetPlay"));

		// Definir el modelo de las columnas de la tabla para que aparezca JCheckBox en las columnas 3, 4 y 5 
		modeloTabla = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int columna) {
				switch (columna) {
				case 0:
				case 1:
				case 2:
					return String.class;
				case 3:
				case 4:
				case 5:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		
		modeloTabla.addColumn("#");
		modeloTabla.addColumn("Equipo 1");
		modeloTabla.addColumn("Equipo 2");
		modeloTabla.addColumn("Ganador 1");
		modeloTabla.addColumn("Ganador 2");
		modeloTabla.addColumn("Empate");

		tablaApuestasPartidos = new JTable(modeloTabla);

		// Deshabilitar la tabla
		tablaApuestasPartidos.setEnabled(false);
		
		// Deshabilitar la reordenación de las columnas de la tabla
		tablaApuestasPartidos.getTableHeader().setReorderingAllowed(false);

		// Crear un renderizador de celdas que permitirá centrar el contenido de todas
		// las celdas de la tabla de sedes
		DefaultTableCellRenderer renderizadorDeCeldas = new DefaultTableCellRenderer();
		renderizadorDeCeldas.setHorizontalAlignment(JLabel.CENTER);

		// Aplicar el renderizador de celdas a todas las columnas de la tabla partidos
		for (int i = 0; i < tablaApuestasPartidos.getColumnCount(); i++)
			if (i < 3)
				tablaApuestasPartidos.getColumnModel().getColumn(i).setCellRenderer(renderizadorDeCeldas);

		// Aumentar la altura de las filas de la tabla partidos
		tablaApuestasPartidos.setRowHeight(40);

		// Ajustar la primera columna para ocupar menos espacio
		tablaApuestasPartidos.getColumnModel().getColumn(0).setPreferredWidth(20);

		add(new JScrollPane(tablaApuestasPartidos));
	}

	/**
	 * Desplegar tabla informacion apuesta.
	 *
	 * @param partidosYResultadosEscogidos La informacion de los partidos y resultados seleccionados.
	 */
	public void desplegarTablaInformacionApuesta(String[][] partidosYResultadosEscogidos) {
		
		// Eliminar todas las filas de la tabla
		while (tablaApuestasPartidos.getRowCount() > 0) modeloTabla.removeRow(0);
		
		for (int i = 0; i < partidosYResultadosEscogidos.length; i++) {
			modeloTabla.addRow(new Object[0]);
			for (int j = 0; j < partidosYResultadosEscogidos[i].length; j++) {
				if (j <= 2)
					modeloTabla.setValueAt(partidosYResultadosEscogidos[i][j], i, j);
				else
					modeloTabla.setValueAt(Boolean.parseBoolean(partidosYResultadosEscogidos[i][j]), i, j);
			}
		}
	}
	
	/**
	 * Obtener partidos Y resultados escogidos.
	 *
	 * @return Una matriz con los partidos y resultados seleccionados.
	 */
	public String[][] obtenerPartidosYResultadosEscogidos() {
		String[][] partidosYResultadosEscogidos = new String[14][6];
		
		// Iterar por toda la tabla para obtener la información de la apuesta
		for (int i = 0; i < tablaApuestasPartidos.getRowCount(); i++)
			for (int j = 0; j < tablaApuestasPartidos.getColumnCount(); j++)
				partidosYResultadosEscogidos[i][j] = tablaApuestasPartidos.getValueAt(i, j).toString();
		
		return partidosYResultadosEscogidos;
	}
	
	
	/**
	 * Gets the modelo tabla.
	 *
	 * @return the modelo tabla
	 */
	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	/**
	 * Sets the modelo tabla.
	 *
	 * @param modeloTabla the new modelo tabla
	 */
	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	/**
	 * Gets the tabla apuestas partidos.
	 *
	 * @return the tabla apuestas partidos
	 */
	public JTable getTablaApuestasPartidos() {
		return tablaApuestasPartidos;
	}

	/**
	 * Sets the tabla apuestas partidos.
	 *
	 * @param tablaApuestasPartidos the new tabla apuestas partidos
	 */
	public void setTablaApuestasPartidos(JTable tablaApuestasPartidos) {
		this.tablaApuestasPartidos = tablaApuestasPartidos;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
