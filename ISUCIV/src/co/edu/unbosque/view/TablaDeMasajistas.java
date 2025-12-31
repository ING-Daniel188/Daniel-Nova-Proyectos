package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Masajista;

// TODO: Auto-generated Javadoc
/**
 * The Class TablaDeMasajistas.
 */
public class TablaDeMasajistas extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2849746514463221702L;
	
	/** The tabla datos. */
	private JTable tablaDatos;
	
	/** The modelo tabla. */
	private DefaultTableModel modeloTabla;

	/**
	 * Instantiates a new tabla de masajistas.
	 */
	public TablaDeMasajistas() {
		setBorder(new TitledBorder("Mostrar Datos Masajistas"));
		setLayout(new BorderLayout());

		modeloTabla = new DefaultTableModel() {
			private static final long serialVersionUID = 5452488232229945482L;

			@Override
			public boolean isCellEditable(int fila, int columna) {
				return false;
			}
		};
		modeloTabla.addColumn("Número de Documento");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Años de Experiencia");

		tablaDatos = new JTable(modeloTabla);
		tablaDatos.setRowSelectionAllowed(false);
		tablaDatos.setColumnSelectionAllowed(false);
		tablaDatos.setCellSelectionEnabled(false);
		tablaDatos.setFocusable(false);
		JScrollPane panelDesplazamiento = new JScrollPane(tablaDatos);
		add(panelDesplazamiento, BorderLayout.CENTER);
	}

	/**
	 * Agregar masajistas A tabla.
	 *
	 * @param listaMasajistas the lista masajistas
	 */
	public void agregarMasajistasATabla(List<Masajista> listaMasajistas) {
		modeloTabla.setRowCount(0);
		for (Masajista masajista : listaMasajistas) {
			Object[] datosMasajista = new Object[] {
				masajista.getNumeroDeDocumento(),
				masajista.getNombre(),
				masajista.getAniosExperiencia()
			};
			modeloTabla.addRow(datosMasajista);
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
