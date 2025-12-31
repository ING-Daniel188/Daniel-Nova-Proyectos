package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.List;
import co.edu.unbosque.model.CiclistaGregario;

// TODO: Auto-generated Javadoc
/**
 * The Class TablaDeCiclistasGregarios.
 */
public class TablaDeCiclistasGregarios extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7338507450573075873L;
	
	/** The tabla datos. */
	private JTable tablaDatos;
	
	/** The modelo tabla. */
	private DefaultTableModel modeloTabla;

	/**
	 * Instantiates a new tabla de ciclistas gregarios.
	 */
	public TablaDeCiclistasGregarios() {
		setBorder(new TitledBorder("Mostrar Datos de Ciclistas Gregarios"));
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
		modeloTabla.addColumn("Función en Pelotón");

		tablaDatos = new JTable(modeloTabla);
		tablaDatos.setRowSelectionAllowed(false);
		tablaDatos.setColumnSelectionAllowed(false);
		tablaDatos.setCellSelectionEnabled(false);
		tablaDatos.setFocusable(false);
		JScrollPane panelDesplazamiento = new JScrollPane(tablaDatos);
		add(panelDesplazamiento, BorderLayout.CENTER);
	}

	/**
	 * Agregar ciclistas gregarios A tabla.
	 *
	 * @param listaCiclistasGregarios the lista ciclistas gregarios
	 */
	public void agregarCiclistasGregariosATabla(List<CiclistaGregario> listaCiclistasGregarios) {
		modeloTabla.setRowCount(0);
		for (CiclistaGregario ciclistaGregario : listaCiclistasGregarios) {
			Object[] datosCiclistaGregario = new Object[] { ciclistaGregario.getNumeroDeDocumento(),
					ciclistaGregario.getNombre(), ciclistaGregario.getCadencia(), ciclistaGregario.getEspecialidad(),
					ciclistaGregario.getFuncionEnPeloton() };
			modeloTabla.addRow(datosCiclistaGregario);
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
