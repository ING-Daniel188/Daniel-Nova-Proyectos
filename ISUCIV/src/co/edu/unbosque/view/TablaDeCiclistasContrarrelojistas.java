package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.List;
import co.edu.unbosque.model.CiclistaContrarrelojista;

// TODO: Auto-generated Javadoc
/**
 * The Class TablaDeCiclistasContrarrelojistas.
 */
public class TablaDeCiclistasContrarrelojistas extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5729915647478010267L;
	
	/** The tabla datos. */
	private JTable tablaDatos;
	
	/** The modelo tabla. */
	private DefaultTableModel modeloTabla;

	/**
	 * Instantiates a new tabla de ciclistas contrarrelojistas.
	 */
	public TablaDeCiclistasContrarrelojistas() {
		setBorder(new TitledBorder("Mostrar Datos de Ciclistas Contrarrelojistas"));
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
		modeloTabla.addColumn("Velocidad Máxima");

		tablaDatos = new JTable(modeloTabla);
		tablaDatos.setRowSelectionAllowed(false);
		tablaDatos.setColumnSelectionAllowed(false);
		tablaDatos.setCellSelectionEnabled(false);
		tablaDatos.setFocusable(false);
		JScrollPane panelDesplazamiento = new JScrollPane(tablaDatos);
		add(panelDesplazamiento, BorderLayout.CENTER);
	}

	/**
	 * Agregar ciclistas contrarrelojistas A tabla.
	 *
	 * @param listaCiclistasContrarrelojistas the lista ciclistas contrarrelojistas
	 */
	public void agregarCiclistasContrarrelojistasATabla(
			List<CiclistaContrarrelojista> listaCiclistasContrarrelojistas) {
		modeloTabla.setRowCount(0);
		for (CiclistaContrarrelojista ciclistaContrarrelojista : listaCiclistasContrarrelojistas) {
			Object[] datosCiclistaContrarrelojista = new Object[] { ciclistaContrarrelojista.getNumeroDeDocumento(),
					ciclistaContrarrelojista.getNombre(), ciclistaContrarrelojista.getCadencia(),
					ciclistaContrarrelojista.getEspecialidad(), ciclistaContrarrelojista.getVelocidadMaxima() };
			modeloTabla.addRow(datosCiclistaContrarrelojista);
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
