package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.List;
import co.edu.unbosque.model.CiclistaEmbalador;

// TODO: Auto-generated Javadoc
/**
 * The Class TablaDeCiclistasEmbaladores.
 */
public class TablaDeCiclistasEmbaladores extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2517135582473041556L;
	
	/** The tabla datos. */
	private JTable tablaDatos;
	
	/** The modelo tabla. */
	private DefaultTableModel modeloTabla;

	/**
	 * Instantiates a new tabla de ciclistas embaladores.
	 */
	public TablaDeCiclistasEmbaladores() {
		setBorder(new TitledBorder("Mostrar Datos de Ciclistas Embaladores"));
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
		modeloTabla.addColumn("Potencia Promedio");
		modeloTabla.addColumn("Velocidad Promedio en Sprint");

		tablaDatos = new JTable(modeloTabla);
		tablaDatos.setRowSelectionAllowed(false);
		tablaDatos.setColumnSelectionAllowed(false);
		tablaDatos.setCellSelectionEnabled(false);
		tablaDatos.setFocusable(false);
		JScrollPane panelDesplazamiento = new JScrollPane(tablaDatos);
		add(panelDesplazamiento, BorderLayout.CENTER);
	}

	/**
	 * Agregar ciclistas embaladores A tabla.
	 *
	 * @param listaCiclistasEmbaladores the lista ciclistas embaladores
	 */
	public void agregarCiclistasEmbaladoresATabla(List<CiclistaEmbalador> listaCiclistasEmbaladores) {
		modeloTabla.setRowCount(0);
		for (CiclistaEmbalador ciclistaEmbalador : listaCiclistasEmbaladores) {
			Object[] datosCiclistaEmbalador = new Object[] { ciclistaEmbalador.getNumeroDeDocumento(),
					ciclistaEmbalador.getNombre(), ciclistaEmbalador.getCadencia(), ciclistaEmbalador.getEspecialidad(),
					ciclistaEmbalador.getPotenciaPromedio(), ciclistaEmbalador.getVelocidadPromedioEnSprint() };
			modeloTabla.addRow(datosCiclistaEmbalador);
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
