package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.List;
import co.edu.unbosque.model.CiclistaRodador;

// TODO: Auto-generated Javadoc
/**
 * The Class TablaDeCiclistasRodadores.
 */
public class TablaDeCiclistasRodadores extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5014128054584782927L;
	
	/** The tabla datos. */
	private JTable tablaDatos;
	
	/** The modelo tabla. */
	private DefaultTableModel modeloTabla;

	/**
	 * Instantiates a new tabla de ciclistas rodadores.
	 */
	public TablaDeCiclistasRodadores() {
		setBorder(new TitledBorder("Mostrar Datos de Ciclistas Rodadores"));
		setLayout(new BorderLayout());

		modeloTabla = new DefaultTableModel() {
			private static final long serialVersionUID = 5579976641059589691L;

			@Override
			public boolean isCellEditable(int fila, int columna) {
				return false;
			}
		};

		modeloTabla.addColumn("Número de Documento");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Cadencia");
		modeloTabla.addColumn("Especialidad");

		tablaDatos = new JTable(modeloTabla);
		tablaDatos.setRowSelectionAllowed(false);
		tablaDatos.setColumnSelectionAllowed(false);
		tablaDatos.setCellSelectionEnabled(false);
		tablaDatos.setFocusable(false);
		JScrollPane panelDesplazamiento = new JScrollPane(tablaDatos);
		add(panelDesplazamiento, BorderLayout.CENTER);
	}

	/**
	 * Agregar ciclistas rodadores A tabla.
	 *
	 * @param listaCiclistasRodadores the lista ciclistas rodadores
	 */
	public void agregarCiclistasRodadoresATabla(List<CiclistaRodador> listaCiclistasRodadores) {
		modeloTabla.setRowCount(0);
		for (CiclistaRodador ciclistaRodador : listaCiclistasRodadores) {
			Object[] datosCiclistaRodador = new Object[] { ciclistaRodador.getNumeroDeDocumento(),
					ciclistaRodador.getNombre(), ciclistaRodador.getCadencia(), ciclistaRodador.getEspecialidad() };
			modeloTabla.addRow(datosCiclistaRodador);
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
