package co.edu.unbosque.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.DirectorDeportivo;

import java.awt.BorderLayout;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class TablaDeDirectoresDeportivos.
 */
public class TablaDeDirectoresDeportivos extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5984566166280562238L;
	
	/** The tabla datos. */
	private JTable tablaDatos;
	
	/** The modelo tabla. */
	private DefaultTableModel modeloTabla;

	/**
	 * Instantiates a new tabla de directores deportivos.
	 */
	public TablaDeDirectoresDeportivos() {
		setBorder(new TitledBorder("Mostrar Datos Directores Deportivos"));
		setLayout(new BorderLayout());

		modeloTabla = new DefaultTableModel() {
			private static final long serialVersionUID = 2745244361648606394L;

			@Override
			public boolean isCellEditable(int fila, int columna) {
				return false;
			}
		};
		modeloTabla.addColumn("Número de Documento");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Nacionalidad");

		tablaDatos = new JTable(modeloTabla);
		tablaDatos.setRowSelectionAllowed(false);
		tablaDatos.setColumnSelectionAllowed(false);
		tablaDatos.setCellSelectionEnabled(false);
		tablaDatos.setFocusable(false);
		JScrollPane panelDesplazamiento = new JScrollPane(tablaDatos);
		add(panelDesplazamiento, BorderLayout.CENTER);
	}

	/**
	 * Agregar directores deportivos A tabla.
	 *
	 * @param listaDirectoresDeportivos the lista directores deportivos
	 */
	public void agregarDirectoresDeportivosATabla(List<DirectorDeportivo> listaDirectoresDeportivos) {
		modeloTabla.setRowCount(0);
		for (DirectorDeportivo directorDeportivo : listaDirectoresDeportivos) {
			Object[] datosDirector = new Object[] {
				directorDeportivo.getNumeroDeDocumento(),
				directorDeportivo.getNombre(),
				directorDeportivo.getNacionalidad()
			};
			modeloTabla.addRow(datosDirector);
		}
	}

	/**
	 * Gets the tabla datos.
	 *
	 * @return the tabla datos
	 */
	public JTable getTablaDatos() {
		return tablaDatos;
	}

	/**
	 * Sets the tabla datos.
	 *
	 * @param tablaDatos the new tabla datos
	 */
	public void setTablaDatos(JTable tablaDatos) {
		this.tablaDatos = tablaDatos;
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
}
