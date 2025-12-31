package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.List;
import co.edu.unbosque.model.CiclistaClasicomano;

// TODO: Auto-generated Javadoc
/**
 * The Class TablaDeCiclistasClasicomanos.
 */
public class TablaDeCiclistasClasicomanos extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1183373536734564583L;
	
	/** The tabla datos. */
	private JTable tablaDatos;
	
	/** The modelo tabla. */
	private DefaultTableModel modeloTabla;

	/**
	 * Instantiates a new tabla de ciclistas clasicomanos.
	 */
	public TablaDeCiclistasClasicomanos() {
		setBorder(new TitledBorder("Mostrar Datos de Ciclistas Clasicómanos"));
		setLayout(new BorderLayout());

		modeloTabla = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int fila, int columna) {
				return false;
			}
		};

		modeloTabla.addColumn("Número de Documento");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Cadencia");
		modeloTabla.addColumn("Especialidad");
		modeloTabla.addColumn("Número de Clásicos Ganados");

		tablaDatos = new JTable(modeloTabla);
		tablaDatos.setRowSelectionAllowed(false);
		tablaDatos.setColumnSelectionAllowed(false);
		tablaDatos.setCellSelectionEnabled(false);
		tablaDatos.setFocusable(false);
		JScrollPane panelDesplazamiento = new JScrollPane(tablaDatos);
		add(panelDesplazamiento, BorderLayout.CENTER);
	}

	/**
	 * Agregar ciclistas clasicomanos A tabla.
	 *
	 * @param listaCiclistasClasicomanos the lista ciclistas clasicomanos
	 */
	public void agregarCiclistasClasicomanosATabla(List<CiclistaClasicomano> listaCiclistasClasicomanos) {
		modeloTabla.setRowCount(0);
		for (CiclistaClasicomano ciclistaClasicomano : listaCiclistasClasicomanos) {
			Object[] datosCiclistaClasicomano = new Object[] { ciclistaClasicomano.getNumeroDeDocumento(),
					ciclistaClasicomano.getNombre(), ciclistaClasicomano.getCadencia(),
					ciclistaClasicomano.getEspecialidad(), ciclistaClasicomano.getNumeroClasicosGanados() };
			modeloTabla.addRow(datosCiclistaClasicomano);
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

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
