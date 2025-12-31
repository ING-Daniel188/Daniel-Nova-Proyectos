package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.DirectorDeportivo;
import co.edu.unbosque.model.Escuadra;
import co.edu.unbosque.model.Masajista;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.border.TitledBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class TablasDePersonasYEscuadras.
 */
public class TablasDePersonasYEscuadras extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7077655959457137472L;
	
	/** The tabla masajistas. */
	private JTable tablaMasajistas;
	
	/** The tabla directores. */
	private JTable tablaDirectores;
	
	/** The tabla escuadras. */
	private JTable tablaEscuadras;
	
	/** The tabla escuadras personas. */
	private JTable tablaEscuadrasPersonas;
	
	/** The modelo tabla masajistas. */
	private DefaultTableModel modeloTablaMasajistas;
	
	/** The modelo tabla directores. */
	private DefaultTableModel modeloTablaDirectores;
	
	/** The modelo tabla escuadras. */
	private DefaultTableModel modeloTablaEscuadras;
	
	/** The modelo tabla escuadras personas. */
	private DefaultTableModel modeloTablaEscuadrasPersonas;

	/**
	 * Instantiates a new tablas de personas Y escuadras.
	 */
	public TablasDePersonasYEscuadras() {
		setLayout(new GridLayout(1, 2));

		JPanel panelTablasIndividuales = new JPanel(new GridLayout(3, 1));
		add(panelTablasIndividuales);

		modeloTablaMasajistas = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		modeloTablaMasajistas.addColumn("Número de Documento");
		modeloTablaMasajistas.addColumn("Nombre");
		tablaMasajistas = new JTable(modeloTablaMasajistas);
		tablaMasajistas.setRowSelectionAllowed(false);
		tablaMasajistas.setColumnSelectionAllowed(false);
		tablaMasajistas.setCellSelectionEnabled(false);
		tablaMasajistas.setFocusable(false);
		JScrollPane scrollMasajistas = new JScrollPane(tablaMasajistas);
		scrollMasajistas.setBorder(new TitledBorder("Masajistas"));
		panelTablasIndividuales.add(scrollMasajistas);

		modeloTablaDirectores = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		modeloTablaDirectores.addColumn("Número de Documento");
		modeloTablaDirectores.addColumn("Nombre");
		tablaDirectores = new JTable(modeloTablaDirectores);
		tablaDirectores.setRowSelectionAllowed(false);
		tablaDirectores.setColumnSelectionAllowed(false);
		tablaDirectores.setCellSelectionEnabled(false);
		tablaDirectores.setFocusable(false);
		JScrollPane scrollDirectores = new JScrollPane(tablaDirectores);
		scrollDirectores.setBorder(new TitledBorder("Directores"));
		panelTablasIndividuales.add(scrollDirectores);

		modeloTablaEscuadras = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		modeloTablaEscuadras.addColumn("Nombre de la Escuadra");
		modeloTablaEscuadras.addColumn("País de Origen");
		tablaEscuadras = new JTable(modeloTablaEscuadras);
		tablaEscuadras.setRowSelectionAllowed(false);
		tablaEscuadras.setColumnSelectionAllowed(false);
		tablaEscuadras.setCellSelectionEnabled(false);
		tablaEscuadras.setFocusable(false);
		JScrollPane scrollEscuadras = new JScrollPane(tablaEscuadras);
		scrollEscuadras.setBorder(new TitledBorder("Escuadras"));
		panelTablasIndividuales.add(scrollEscuadras);

		JPanel panelEscuadrasPersonas = new JPanel(new GridLayout(1, 1));
		add(panelEscuadrasPersonas);

		modeloTablaEscuadrasPersonas = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		modeloTablaEscuadrasPersonas.addColumn("Nombre de la Escuadra");
		modeloTablaEscuadrasPersonas.addColumn("Número de Documento Masajista");
		modeloTablaEscuadrasPersonas.addColumn("Número de Documento Director");
		tablaEscuadrasPersonas = new JTable(modeloTablaEscuadrasPersonas);
		tablaEscuadrasPersonas.setRowSelectionAllowed(false);
		tablaEscuadrasPersonas.setColumnSelectionAllowed(false);
		tablaEscuadrasPersonas.setCellSelectionEnabled(false);
		tablaEscuadrasPersonas.setFocusable(false);
		JScrollPane scrollEscuadrasPersonas = new JScrollPane(tablaEscuadrasPersonas);
		scrollEscuadrasPersonas.setBorder(new TitledBorder("Escuadras y Personas"));
		panelEscuadrasPersonas.add(scrollEscuadrasPersonas);
	}

	/**
	 * Agregar masajistas A tabla.
	 *
	 * @param listaDeMasajistas the lista de masajistas
	 */
	public void agregarMasajistasATabla(List<Masajista> listaDeMasajistas) {
		modeloTablaMasajistas.setRowCount(0);
		for (Masajista masajista : listaDeMasajistas) {
			Object[] fila = new Object[2];
			fila[0] = masajista.getNumeroDeDocumento();
			fila[1] = masajista.getNombre();
			modeloTablaMasajistas.addRow(fila);
		}
	}

	/**
	 * Agregar directores A tabla.
	 *
	 * @param listaDeDirectores the lista de directores
	 */
	public void agregarDirectoresATabla(List<DirectorDeportivo> listaDeDirectores) {
		modeloTablaDirectores.setRowCount(0);
		for (DirectorDeportivo director : listaDeDirectores) {
			Object[] fila = new Object[2];
			fila[0] = director.getNumeroDeDocumento();
			fila[1] = director.getNombre();
			modeloTablaDirectores.addRow(fila);
		}
	}

	/**
	 * Agregar escuadras A tabla.
	 *
	 * @param listaDeEscuadras the lista de escuadras
	 */
	public void agregarEscuadrasATabla(List<Escuadra> listaDeEscuadras) {
		modeloTablaEscuadras.setRowCount(0);
		for (Escuadra escuadra : listaDeEscuadras) {
			Object[] fila = new Object[2];
			fila[0] = escuadra.getNombre();
			fila[1] = escuadra.getPaisDeOrigen();
			modeloTablaEscuadras.addRow(fila);
		}
	}

	/**
	 * Actualizar tabla escuadras personas.
	 *
	 * @param listaDeEscuadras the lista de escuadras
	 */
	public void actualizarTablaEscuadrasPersonas(List<Escuadra> listaDeEscuadras) {
		modeloTablaEscuadrasPersonas.setRowCount(0);
		for (Escuadra escuadra : listaDeEscuadras) {
			Object[] fila = new Object[3];
			fila[0] = escuadra.getNombre();
			fila[1] = escuadra.getMasajista() == null ? "No Registra" : escuadra.getMasajista().getNumeroDeDocumento();
			fila[2] = escuadra.getDirectorDeportivo() == null ? "No Registra"
					: escuadra.getDirectorDeportivo().getNumeroDeDocumento();
			modeloTablaEscuadrasPersonas.addRow(fila);
		}
	}
}
