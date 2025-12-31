package co.edu.unbosque.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;

import co.edu.unbosque.model.Ciclista;
import co.edu.unbosque.model.Escuadra;

// TODO: Auto-generated Javadoc
/**
 * The Class TablasDeCiclistasYEscuadras.
 */
public class TablasDeCiclistasYEscuadras extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4768528614790139829L;
	
	/** The tabla ciclistas. */
	private JTable tablaCiclistas;
	
	/** The tabla escuadras. */
	private JTable tablaEscuadras;
	
	/** The tabla detalles. */
	private JTable tablaDetalles;
	
	/** The modelo tabla ciclistas. */
	private DefaultTableModel modeloTablaCiclistas;
	
	/** The modelo tabla escuadras. */
	private DefaultTableModel modeloTablaEscuadras;
	
	/** The modelo tabla detalles. */
	private DefaultTableModel modeloTablaDetalles;

	/**
	 * Instantiates a new tablas de ciclistas Y escuadras.
	 */
	public TablasDeCiclistasYEscuadras() {
		setBorder(new TitledBorder("Ciclistas y Escuadras"));
		setLayout(new GridLayout(2, 1));

		JPanel panelTablasIndividuales = new JPanel(new GridLayout(1, 2));
		add(panelTablasIndividuales);

		modeloTablaEscuadras = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modeloTablaEscuadras.addColumn("Nombre de la Escuadra");
		modeloTablaEscuadras.addColumn("Suma de Tiempos");
		modeloTablaEscuadras.addColumn("País de Origen");

		tablaEscuadras = new JTable(modeloTablaEscuadras);
		tablaEscuadras.setRowSelectionAllowed(false);
		tablaEscuadras.setColumnSelectionAllowed(false);
		tablaEscuadras.setCellSelectionEnabled(false);
		tablaEscuadras.setFocusable(false);
		JScrollPane panelDesplazamientoEscuadras = new JScrollPane(tablaEscuadras);
		panelDesplazamientoEscuadras.setBorder(new TitledBorder("Escuadras Agregadas"));
		panelTablasIndividuales.add(panelDesplazamientoEscuadras);

		modeloTablaCiclistas = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modeloTablaCiclistas.addColumn("Número de Documento");
		modeloTablaCiclistas.addColumn("Nombre del Ciclista");
		modeloTablaCiclistas.addColumn("Tipo de Ciclista");

		tablaCiclistas = new JTable(modeloTablaCiclistas);
		tablaCiclistas.setRowSelectionAllowed(false);
		tablaCiclistas.setColumnSelectionAllowed(false);
		tablaCiclistas.setCellSelectionEnabled(false);
		tablaCiclistas.setFocusable(false);
		JScrollPane panelDesplazamientoCiclistas = new JScrollPane(tablaCiclistas);
		panelDesplazamientoCiclistas.setBorder(new TitledBorder("Ciclistas Disponibles"));
		panelTablasIndividuales.add(panelDesplazamientoCiclistas);

		JPanel panelTablaDetalles = new JPanel(new GridLayout(1, 1));
		add(panelTablaDetalles);

		modeloTablaDetalles = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modeloTablaDetalles.addColumn("Nombre de la Escuadra");
		modeloTablaDetalles.addColumn("Número de Documento del Ciclista");
		modeloTablaDetalles.addColumn("Nombre del Ciclista");
		modeloTablaDetalles.addColumn("Tipo de Ciclista");

		tablaDetalles = new JTable(modeloTablaDetalles);
		tablaDetalles.setRowSelectionAllowed(false);
		tablaDetalles.setColumnSelectionAllowed(false);
		tablaDetalles.setCellSelectionEnabled(false);
		tablaDetalles.setFocusable(false);
		JScrollPane panelDesplazamientoDetalles = new JScrollPane(tablaDetalles);
		panelDesplazamientoDetalles.setBorder(new TitledBorder("Escuadras con Ciclistas"));
		panelTablaDetalles.add(panelDesplazamientoDetalles);
	}

	/**
	 * Agregar escuadras A tabla.
	 *
	 * @param listaDeEscuadras the lista de escuadras
	 */
	public void agregarEscuadrasATabla(List<Escuadra> listaDeEscuadras) {
		modeloTablaEscuadras.setRowCount(0);
		for (Escuadra escuadra : listaDeEscuadras) {
			Object[] fila = new Object[3];
			fila[0] = escuadra.getNombre();
			fila[1] = escuadra.getSumaTiemposAcumulados();
			fila[2] = !escuadra.getPaisDeOrigen().equals("") ? escuadra.getPaisDeOrigen() : "No Registra";
			modeloTablaEscuadras.addRow(fila);
		}
	}

	/**
	 * Agregar ciclistas A tabla.
	 *
	 * @param listaDeCiclistas the lista de ciclistas
	 */
	public void agregarCiclistasATabla(List<Ciclista> listaDeCiclistas) {
		modeloTablaCiclistas.setRowCount(0);
		for (Ciclista ciclista : listaDeCiclistas) {
			Object[] fila = new Object[3];
			fila[0] = ciclista.getNumeroDeDocumento();
			fila[1] = ciclista.getNombre();
			fila[2] = ciclista.getTipo();
			modeloTablaCiclistas.addRow(fila);
		}
	}

	/**
	 * Agregar escuadras con ciclistas A tabla.
	 *
	 * @param listaDeEscuadras the lista de escuadras
	 */
	public void agregarEscuadrasConCiclistasATabla(List<Escuadra> listaDeEscuadras) {
		modeloTablaDetalles.setRowCount(0);
		for (Escuadra escuadra : listaDeEscuadras) {
			for (Ciclista ciclista : escuadra.getCiclistas()) {
				Object[] fila = new Object[4];
				fila[0] = escuadra.getNombre();
				fila[1] = ciclista.getNumeroDeDocumento();
				fila[2] = ciclista.getNombre();
				fila[3] = ciclista.getTipo();
				modeloTablaDetalles.addRow(fila);
			}
		}
	}

	/**
	 * Gets the tabla ciclistas.
	 *
	 * @return the tabla ciclistas
	 */
	public JTable getTablaCiclistas() {
		return tablaCiclistas;
	}

	/**
	 * Sets the tabla ciclistas.
	 *
	 * @param tablaCiclistas the new tabla ciclistas
	 */
	public void setTablaCiclistas(JTable tablaCiclistas) {
		this.tablaCiclistas = tablaCiclistas;
	}

	/**
	 * Gets the tabla escuadras.
	 *
	 * @return the tabla escuadras
	 */
	public JTable getTablaEscuadras() {
		return tablaEscuadras;
	}

	/**
	 * Sets the tabla escuadras.
	 *
	 * @param tablaEscuadras the new tabla escuadras
	 */
	public void setTablaEscuadras(JTable tablaEscuadras) {
		this.tablaEscuadras = tablaEscuadras;
	}

	/**
	 * Gets the tabla detalles.
	 *
	 * @return the tabla detalles
	 */
	public JTable getTablaDetalles() {
		return tablaDetalles;
	}

	/**
	 * Sets the tabla detalles.
	 *
	 * @param tablaDetalles the new tabla detalles
	 */
	public void setTablaDetalles(JTable tablaDetalles) {
		this.tablaDetalles = tablaDetalles;
	}

	/**
	 * Gets the modelo tabla ciclistas.
	 *
	 * @return the modelo tabla ciclistas
	 */
	public DefaultTableModel getModeloTablaCiclistas() {
		return modeloTablaCiclistas;
	}

	/**
	 * Sets the modelo tabla ciclistas.
	 *
	 * @param modeloTablaCiclistas the new modelo tabla ciclistas
	 */
	public void setModeloTablaCiclistas(DefaultTableModel modeloTablaCiclistas) {
		this.modeloTablaCiclistas = modeloTablaCiclistas;
	}

	/**
	 * Gets the modelo tabla escuadras.
	 *
	 * @return the modelo tabla escuadras
	 */
	public DefaultTableModel getModeloTablaEscuadras() {
		return modeloTablaEscuadras;
	}

	/**
	 * Sets the modelo tabla escuadras.
	 *
	 * @param modeloTablaEscuadras the new modelo tabla escuadras
	 */
	public void setModeloTablaEscuadras(DefaultTableModel modeloTablaEscuadras) {
		this.modeloTablaEscuadras = modeloTablaEscuadras;
	}

	/**
	 * Gets the modelo tabla detalles.
	 *
	 * @return the modelo tabla detalles
	 */
	public DefaultTableModel getModeloTablaDetalles() {
		return modeloTablaDetalles;
	}

	/**
	 * Sets the modelo tabla detalles.
	 *
	 * @param modeloTablaDetalles the new modelo tabla detalles
	 */
	public void setModeloTablaDetalles(DefaultTableModel modeloTablaDetalles) {
		this.modeloTablaDetalles = modeloTablaDetalles;
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
