package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Ciclista;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistroDeCiclistas.
 */
public class RegistroDeCiclistas extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The boton simular carrera. */
	private JButton botonSimularCarrera;
	
	/** The tabla ciclistas. */
	private JTable tablaCiclistas;
	
	/** The modelo tabla. */
	private DefaultTableModel modeloTabla;
	
	/** The tabla ciclistas agregados. */
	private JTable tablaCiclistasAgregados;
	
	/** The modelo ciclistas. */
	private DefaultTableModel modeloCiclistas;
	
	/** The seleccion tipo etapa. */
	private JComboBox<String> seleccionTipoEtapa;
	
	/** The campo numero documento ciclista. */
	private JTextField campoNumeroDocumentoCiclista;
	
	/** The boton agregar ciclista A carrera. */
	private JButton botonAgregarCiclistaACarrera;
	
	/** The boton quitar ciclista de carrera. */
	private JButton botonQuitarCiclistaDeCarrera;

	/**
	 * Instantiates a new registro de ciclistas.
	 */
	public RegistroDeCiclistas() {
		setLayout(new BorderLayout());
		setOpaque(false);

		JPanel panelNorte = new JPanel(new BorderLayout());
		panelNorte.setOpaque(false);

		JPanel panelAgregarQuitarCiclistaDeCarrera = new JPanel(new GridLayout(3, 2));
		panelAgregarQuitarCiclistaDeCarrera.setBorder(new TitledBorder("Agregar/Quitar Ciclista de Carrera"));

		JPanel panelTipoEtapa = new JPanel(new FlowLayout());
		panelTipoEtapa.setOpaque(false);
		JLabel etiquetaTipoEtapa = new JLabel("Tipo de Etapa:");
		seleccionTipoEtapa = new JComboBox<>();
		seleccionTipoEtapa.addItem("...");
		seleccionTipoEtapa.addItem("Montaña");
		seleccionTipoEtapa.addItem("Llano con curvas");
		seleccionTipoEtapa.addItem("Semi llano");
		seleccionTipoEtapa.addItem("De un solo día");
		seleccionTipoEtapa.addItem("Llano en recta");
		panelTipoEtapa.add(etiquetaTipoEtapa);
		panelTipoEtapa.add(seleccionTipoEtapa);
		panelAgregarQuitarCiclistaDeCarrera.add(panelTipoEtapa);

		panelAgregarQuitarCiclistaDeCarrera.add(new JLabel());

		JLabel etiquetaNumeroDocumento = new JLabel("Número de Documento del Ciclista:");
		campoNumeroDocumentoCiclista = new JTextField();
		botonAgregarCiclistaACarrera = new JButton("Agregar a Carrera");
		botonQuitarCiclistaDeCarrera = new JButton("Quitar de Carrera");
		panelAgregarQuitarCiclistaDeCarrera.add(etiquetaNumeroDocumento);
		panelAgregarQuitarCiclistaDeCarrera.add(campoNumeroDocumentoCiclista);
		panelAgregarQuitarCiclistaDeCarrera.add(botonAgregarCiclistaACarrera);
		panelAgregarQuitarCiclistaDeCarrera.add(botonQuitarCiclistaDeCarrera);
		panelNorte.add(panelAgregarQuitarCiclistaDeCarrera, BorderLayout.CENTER);

		add(panelNorte, BorderLayout.NORTH);

		botonSimularCarrera = new JButton("Simular Carrera");
		botonSimularCarrera.setPreferredSize(new Dimension(200, 60));

		JPanel panelSur = new JPanel(new GridLayout(1, 1, 10, 0));
		panelSur.setOpaque(false);
		panelSur.add(botonSimularCarrera);
		add(panelSur, BorderLayout.SOUTH);

		JPanel panelCentral = new JPanel(new GridLayout(1, 2));
		panelCentral.setOpaque(false);

		JPanel panelCiclistasActuales = new JPanel(new BorderLayout());
		TitledBorder bordeCiclistasActuales = BorderFactory.createTitledBorder("Ciclistas Actuales");
		panelCiclistasActuales.setBorder(bordeCiclistasActuales);
		panelCiclistasActuales.setOpaque(false);
		modeloTabla = new DefaultTableModel(new String[] { "Número de Documento", "Nombre del Ciclista",
				"Tipo de Ciclista", "Nombre de la Escuadra" }, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int fila, int columna) {
				return false;
			}
		};
		tablaCiclistas = new JTable(modeloTabla);
		tablaCiclistas.getTableHeader().setReorderingAllowed(false);
		tablaCiclistas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaCiclistas.setEnabled(false);
		DefaultTableCellRenderer centrarCeldas = new DefaultTableCellRenderer();
		centrarCeldas.setHorizontalAlignment(JLabel.CENTER);
		tablaCiclistas.setDefaultRenderer(Object.class, centrarCeldas);
		JScrollPane scrollPane = new JScrollPane(tablaCiclistas);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		panelCiclistasActuales.add(scrollPane);
		panelCentral.add(panelCiclistasActuales);

		JPanel panelCiclistasAgregados = new JPanel(new BorderLayout());
		TitledBorder bordeCiclistasAgregados = BorderFactory.createTitledBorder("Ciclistas Agregados");
		panelCiclistasAgregados.setBorder(bordeCiclistasAgregados);
		panelCiclistasAgregados.setOpaque(false);
		modeloCiclistas = new DefaultTableModel(new String[] { "Número de Documento", "Nombre del Ciclista",
				"Tipo de Ciclista", "Nombre de la Escuadra" }, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int fila, int columna) {
				return false;
			}
		};
		tablaCiclistasAgregados = new JTable(modeloCiclistas);
		tablaCiclistasAgregados.getTableHeader().setReorderingAllowed(false);
		tablaCiclistasAgregados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaCiclistasAgregados.setEnabled(false);
		tablaCiclistasAgregados.setDefaultRenderer(Object.class, centrarCeldas);
		JScrollPane scrollPaneCiclistas = new JScrollPane(tablaCiclistasAgregados);
		scrollPaneCiclistas.setOpaque(false);
		scrollPaneCiclistas.getViewport().setOpaque(false);
		panelCiclistasAgregados.add(scrollPaneCiclistas);
		panelCentral.add(panelCiclistasAgregados);

		add(panelCentral, BorderLayout.CENTER);
	}

	/**
	 * Agregar ciclista A ciclistas actuales.
	 *
	 * @param ciclistas the ciclistas
	 */
	public void agregarCiclistaACiclistasActuales(List<Ciclista> ciclistas) {
		modeloTabla.setRowCount(0);
		for (Ciclista ciclista : ciclistas) {
			modeloTabla.addRow(new Object[] { ciclista.getNumeroDeDocumento(), ciclista.getNombre(), ciclista.getTipo(),
					ciclista.getEspecialidad() });
		}
	}

	/**
	 * Agregar ciclista A ciclistas agregados.
	 *
	 * @param ciclistas the ciclistas
	 */
	public void agregarCiclistaACiclistasAgregados(List<Ciclista> ciclistas) {
		modeloCiclistas.setRowCount(0);
		for (Ciclista ciclista : ciclistas) {
			modeloCiclistas.addRow(new Object[] { ciclista.getNumeroDeDocumento(), ciclista.getNombre(),
					ciclista.getTipo(), ciclista.getEspecialidad() });
		}
	}

	/**
	 * Validar ingreso documento ciclista Y tipo etapa.
	 *
	 * @return true, if successful
	 */
	public boolean validarIngresoDocumentoCiclistaYTipoEtapa() {
		String numeroDocumento = campoNumeroDocumentoCiclista.getText().trim();
		String tipoEtapa = seleccionTipoEtapa.getSelectedItem().toString();
		return !numeroDocumento.isEmpty() && !tipoEtapa.equals("...");
	}

	/**
	 * Obtener tipo de etapa seleccionado.
	 *
	 * @return the string
	 */
	public String obtenerTipoDeEtapaSeleccionado() {
		return seleccionTipoEtapa.getSelectedItem().toString();
	}

	/**
	 * Obtener campo numero documento ciclista.
	 *
	 * @return the string
	 */
	public String obtenerCampoNumeroDocumentoCiclista() {
		return campoNumeroDocumentoCiclista.getText();
	}

	/**
	 * Gets the boton agregar ciclista A carrera.
	 *
	 * @return the boton agregar ciclista A carrera
	 */
	public JButton getBotonAgregarCiclistaACarrera() {
		return botonAgregarCiclistaACarrera;
	}

	/**
	 * Sets the boton agregar ciclista A carrera.
	 *
	 * @param botonAgregarCiclistaACarrera the new boton agregar ciclista A carrera
	 */
	public void setBotonAgregarCiclistaACarrera(JButton botonAgregarCiclistaACarrera) {
		this.botonAgregarCiclistaACarrera = botonAgregarCiclistaACarrera;
	}

	/**
	 * Gets the boton quitar ciclista de carrera.
	 *
	 * @return the boton quitar ciclista de carrera
	 */
	public JButton getBotonQuitarCiclistaDeCarrera() {
		return botonQuitarCiclistaDeCarrera;
	}

	/**
	 * Sets the boton quitar ciclista de carrera.
	 *
	 * @param botonQuitarCiclistaDeCarrera the new boton quitar ciclista de carrera
	 */
	public void setBotonQuitarCiclistaDeCarrera(JButton botonQuitarCiclistaDeCarrera) {
		this.botonQuitarCiclistaDeCarrera = botonQuitarCiclistaDeCarrera;
	}

	/**
	 * Gets the boton simular carrera.
	 *
	 * @return the boton simular carrera
	 */
	public JButton getBotonSimularCarrera() {
		return botonSimularCarrera;
	}

	/**
	 * Sets the boton simular carrera.
	 *
	 * @param botonSimularCarrera the new boton simular carrera
	 */
	public void setBotonSimularCarrera(JButton botonSimularCarrera) {
		this.botonSimularCarrera = botonSimularCarrera;
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
	 * Gets the tabla ciclistas agregados.
	 *
	 * @return the tabla ciclistas agregados
	 */
	public JTable getTablaCiclistasAgregados() {
		return tablaCiclistasAgregados;
	}

	/**
	 * Sets the tabla ciclistas agregados.
	 *
	 * @param tablaCiclistasAgregados the new tabla ciclistas agregados
	 */
	public void setTablaCiclistasAgregados(JTable tablaCiclistasAgregados) {
		this.tablaCiclistasAgregados = tablaCiclistasAgregados;
	}

	/**
	 * Gets the modelo ciclistas.
	 *
	 * @return the modelo ciclistas
	 */
	public DefaultTableModel getModeloCiclistas() {
		return modeloCiclistas;
	}

	/**
	 * Sets the modelo ciclistas.
	 *
	 * @param modeloCiclistas the new modelo ciclistas
	 */
	public void setModeloCiclistas(DefaultTableModel modeloCiclistas) {
		this.modeloCiclistas = modeloCiclistas;
	}

	/**
	 * Gets the seleccion tipo etapa.
	 *
	 * @return the seleccion tipo etapa
	 */
	public JComboBox<String> getSeleccionTipoEtapa() {
		return seleccionTipoEtapa;
	}

	/**
	 * Sets the seleccion tipo etapa.
	 *
	 * @param seleccionTipoEtapa the new seleccion tipo etapa
	 */
	public void setSeleccionTipoEtapa(JComboBox<String> seleccionTipoEtapa) {
		this.seleccionTipoEtapa = seleccionTipoEtapa;
	}

	/**
	 * Gets the campo numero documento ciclista.
	 *
	 * @return the campo numero documento ciclista
	 */
	public JTextField getCampoNumeroDocumentoCiclista() {
		return campoNumeroDocumentoCiclista;
	}

	/**
	 * Sets the campo numero documento ciclista.
	 *
	 * @param campoNumeroDocumentoCiclista the new campo numero documento ciclista
	 */
	public void setCampoNumeroDocumentoCiclista(JTextField campoNumeroDocumentoCiclista) {
		this.campoNumeroDocumentoCiclista = campoNumeroDocumentoCiclista;
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
