package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * The Class PanelDetalleApuestasRealizadas.
 */
public class PanelDetalleApuestasRealizadas extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Panel seccion superior.
	 */
	private JPanel seccionNorte;

	/**
	 * Label para mostrar detalles de apuestas.
	 */
	private JLabel labelDetalleApuestas;

	/**
	 * Label para la seccion de parametros.
	 */
	private JLabel seccionParametros;

	/**
	 * Seleccion de la sede para consultar.
	 */
	private JComboBox<String> seleccionSede;

	/**
	 * Etiqueta para la cedula.
	 */
	private JLabel labelCedula;

	/**
	 * Campo de texto para ingresar la cedula.
	 */
	private JTextField campoCedula;

	/**
	 * Boton para iniciar la consulta.
	 */
	private JButton btnConsultar;

	/**
	 * Seccion central del diseño.
	 */
	private JLabel seccionCentral;

	/**
	 * Modelo de tabla para la visualizacion de los detalles de las apuestas.
	 */
	private DefaultTableModel modeloTabla;

	/**
	 * Tabla para mostrar los detalles de las apuestas.
	 */
	private JTable tablaDetalleApuestas;
	
	
	/** The seleccionar sede. */
	public final String SELECCIONAR_SEDE = "Seleccionar detalle de apuesta por sede";
	
	/** The consultar. */
	public final String CONSULTAR = "Consultar cedula";
	

	/**
	 * Instantiates a new panel detalle apuestas realizadas.
	 */
	public PanelDetalleApuestasRealizadas() {
		setLayout(new BorderLayout());
		
		// Definir sección norte
		seccionNorte = new JPanel();
		seccionNorte.setLayout(new GridLayout(2, 1, 5, 20));
		seccionNorte.setPreferredSize(new Dimension(120, 120));
		seccionNorte.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		labelDetalleApuestas = new JLabel();
		labelDetalleApuestas.setText("Detalle de apuestas realizadas por Cliente y Sede");
		labelDetalleApuestas.setFont(new Font("Concord", Font.BOLD, 20));
		labelDetalleApuestas.setHorizontalAlignment(JLabel.CENTER);
		
		seccionParametros = new JLabel();
		seccionParametros.setLayout(new GridLayout(1, 4, 5, 5));
		
		seleccionSede = new JComboBox<String>();
		seleccionSede.setActionCommand(SELECCIONAR_SEDE);
		
		labelCedula = new JLabel();
		labelCedula.setText("Cédula");
		labelCedula.setHorizontalAlignment(JLabel.RIGHT);
		
		campoCedula = new JTextField();
		
		btnConsultar = new JButton();
		btnConsultar.setText("Consultar");
		btnConsultar.setActionCommand(CONSULTAR);
		
		seccionParametros.add(seleccionSede);
		seccionParametros.add(labelCedula);
		seccionParametros.add(campoCedula);
		seccionParametros.add(btnConsultar);
		
		seccionNorte.add(labelDetalleApuestas);
		seccionNorte.add(seccionParametros);
		
		
		// Definir sección central
		seccionCentral = new JLabel();
		seccionCentral.setLayout(new GridLayout(1, 1, 5, 5));
		
		// Definir tabla de apostadores
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Tipo de Apuesta");
		modeloTabla.addColumn("Nombre de la Sede");
		modeloTabla.addColumn("Cédula del Apostador");
		modeloTabla.addColumn("Fecha de la Apuesta");
		modeloTabla.addColumn("Valor de la Apuesta");
		
		tablaDetalleApuestas = new JTable(modeloTabla);
		tablaDetalleApuestas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Hacer que la tabla no sea editable
		tablaDetalleApuestas.setDefaultEditor(Object.class, null);
		
		// Deshabilitar la reordenación de las columnas de la tabla
		tablaDetalleApuestas.getTableHeader().setReorderingAllowed(false);
		
		// Crear un renderizador de celdas que permitirá centrar el contenido de todas las celdas de la tabla de sedes
		DefaultTableCellRenderer renderizadorDeCeldas = new DefaultTableCellRenderer();
		renderizadorDeCeldas.setHorizontalAlignment(JLabel.CENTER);
		
		// Aplicar el renderizador de celdas a todas las columnas de la tabla
		for (int i = 0; i < tablaDetalleApuestas.getColumnCount(); i++)
			tablaDetalleApuestas.getColumnModel().getColumn(i).setCellRenderer(renderizadorDeCeldas);
		
		// Aumentar la altura de las filas de la tabla
		tablaDetalleApuestas.setRowHeight(20);
		
		seccionCentral.add(new JScrollPane(tablaDetalleApuestas));
		
		add(seccionNorte, BorderLayout.NORTH);
		add(seccionCentral, BorderLayout.CENTER);
		
	}
	
	/**
	 * Reiniciar tabla.
	 */
	public void reiniciarTabla() {
		
		while (tablaDetalleApuestas.getRowCount() > 0)
			modeloTabla.removeRow(0);
		
	}
	
	/**
	 * Agregar sedes.
	 *
	 * @param sedes the sedes
	 */
	public void agregarSedes(String[] sedes) {
		
		while (seleccionSede.getItemCount() > 0)
			seleccionSede.removeItemAt(0);
		
		seleccionSede.addItem("Seleccionar Sede:");
		
		for (int i = 0; i < sedes.length; i++)
			seleccionSede.addItem(sedes[i]);
		
	}
	
	/**
	 * Agregar apuestas por sede.
	 *
	 * @param apuestasPorSede the apuestas por sede
	 */
	public void agregarApuestasPorSede(Object[][] apuestasPorSede) {
		
		while (tablaDetalleApuestas.getRowCount() > 0)
			modeloTabla.removeRow(0);
		
		for (int i = 0; i < apuestasPorSede.length; i++)
			modeloTabla.addRow(apuestasPorSede[i]);
	}
	
	/**
	 * Agregar apuestas por cliente.
	 *
	 * @param apuestasPorCliente the apuestas por cliente
	 */
	public void agregarApuestasPorCliente(Object[][] apuestasPorCliente) {
		
		while (tablaDetalleApuestas.getRowCount() > 0)
			modeloTabla.removeRow(0);
		
		for (int i = 0; i < apuestasPorCliente.length; i++)
			modeloTabla.addRow(apuestasPorCliente[i]);
	}
	

	/**
	 * Gets the seccion norte.
	 *
	 * @return the seccion norte
	 */
	public JPanel getSeccionNorte() {
		return seccionNorte;
	}

	/**
	 * Sets the seccion norte.
	 *
	 * @param seccionNorte the new seccion norte
	 */
	public void setSeccionNorte(JPanel seccionNorte) {
		this.seccionNorte = seccionNorte;
	}

	/**
	 * Gets the label detalle apuestas.
	 *
	 * @return the label detalle apuestas
	 */
	public JLabel getLabelDetalleApuestas() {
		return labelDetalleApuestas;
	}

	/**
	 * Sets the label detalle apuestas.
	 *
	 * @param labelDetalleApuestas the new label detalle apuestas
	 */
	public void setLabelDetalleApuestas(JLabel labelDetalleApuestas) {
		this.labelDetalleApuestas = labelDetalleApuestas;
	}

	/**
	 * Gets the seccion parametros.
	 *
	 * @return the seccion parametros
	 */
	public JLabel getSeccionParametros() {
		return seccionParametros;
	}

	/**
	 * Sets the seccion parametros.
	 *
	 * @param seccionParametros the new seccion parametros
	 */
	public void setSeccionParametros(JLabel seccionParametros) {
		this.seccionParametros = seccionParametros;
	}

	/**
	 * Gets the seleccion sede.
	 *
	 * @return the seleccion sede
	 */
	public JComboBox<String> getSeleccionSede() {
		return seleccionSede;
	}

	/**
	 * Sets the seleccion sede.
	 *
	 * @param seleccionSede the new seleccion sede
	 */
	public void setSeleccionSede(JComboBox<String> seleccionSede) {
		this.seleccionSede = seleccionSede;
	}

	/**
	 * Gets the label cedula.
	 *
	 * @return the label cedula
	 */
	public JLabel getLabelCedula() {
		return labelCedula;
	}

	/**
	 * Sets the label cedula.
	 *
	 * @param labelCedula the new label cedula
	 */
	public void setLabelCedula(JLabel labelCedula) {
		this.labelCedula = labelCedula;
	}

	/**
	 * Gets the campo cedula.
	 *
	 * @return the campo cedula
	 */
	public JTextField getCampoCedula() {
		return campoCedula;
	}

	/**
	 * Sets the campo cedula.
	 *
	 * @param campoCedula the new campo cedula
	 */
	public void setCampoCedula(JTextField campoCedula) {
		this.campoCedula = campoCedula;
	}

	/**
	 * Gets the btn consultar.
	 *
	 * @return the btn consultar
	 */
	public JButton getBtnConsultar() {
		return btnConsultar;
	}

	/**
	 * Sets the btn consultar.
	 *
	 * @param btnConsultar the new btn consultar
	 */
	public void setBtnConsultar(JButton btnConsultar) {
		this.btnConsultar = btnConsultar;
	}

	/**
	 * Gets the seccion central.
	 *
	 * @return the seccion central
	 */
	public JLabel getSeccionCentral() {
		return seccionCentral;
	}

	/**
	 * Sets the seccion central.
	 *
	 * @param seccionCentral the new seccion central
	 */
	public void setSeccionCentral(JLabel seccionCentral) {
		this.seccionCentral = seccionCentral;
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
	 * Gets the tabla detalle apuestas.
	 *
	 * @return the tabla detalle apuestas
	 */
	public JTable getTablaDetalleApuestas() {
		return tablaDetalleApuestas;
	}

	/**
	 * Sets the tabla detalle apuestas.
	 *
	 * @param tablaDetalleApuestas the new tabla detalle apuestas
	 */
	public void setTablaDetalleApuestas(JTable tablaDetalleApuestas) {
		this.tablaDetalleApuestas = tablaDetalleApuestas;
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
