package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * The Class PanelValorTotalApuestas.
 */
public class PanelValorTotalApuestas extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** El lienzo que se usa para cambiar paneles dentro de este panel. */
	private CardLayout cardLayout;

	/** Seccion donde se realizaran las consultas. */
	private JPanel seccionNorte;

	/** Label donde se mostrara el valor total de apuestas por cliente. */
	private JLabel labelValorTotalApuestasPorCliente;

	/** Seccion en la cual se ingresara la cedula. */
	private JLabel seccionCedulaCliente;

	/** Label que pedira la cedula del apostador. */
	private JLabel labelCedula;

	/** Campo de texto donde se ingresara la cedula del apostador a buscar. */
	private JTextField campoCedula;

	/** Boton que realizara la consulta. */
	private JButton btnConsultar;

	/** Secciones principales del panel. */
	private JLabel seccionCentral, seccionSur, seccionEste, seccionOeste;

	/** Labels que se mostraran en los casos de que no se encuentre la cedula o esta no haya sido ingresada. */
	private JLabel labelCedulaSinIngresar, labelClienteSinEncontrar;

	/** Seccion donde se mostrara el valor total de las apuestas por cliente. */
	private JLabel seccionValorTotalApuestasPorCliente;

	/**  Modelo de la tabla para visualizar los valores totales de las apuestas. */
	private DefaultTableModel modeloTabla;

	/** Tabla que mostrara el valor total de las apuestas por cliente. */
	private JTable tablaValorTotalApuestasPorCliente;

	/** Seccion donde se mostrara el total de las apuestas. */
	private JLabel seccionTotalApuestas;

	/** Label para el campo total apuestas. */
	private JLabel labelTotalApuestas;

	/** Campo de texto que contendra el total de las apuestas. */
	private JTextField campoTotalApuestas;
	
	
	/** The consultar. */
	public final String CONSULTAR = "Consultar valor total apuestas por cliente";

	/**
	 * Instantiates a new panel valor total apuestas.
	 */
	public PanelValorTotalApuestas() {
		setLayout(new BorderLayout());
		
		// Definir sección norte
		seccionNorte = new JPanel();
		seccionNorte.setLayout(new GridLayout(1, 2, 5, 5));
		seccionNorte.setPreferredSize(new Dimension(75, 75));
		seccionNorte.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		labelValorTotalApuestasPorCliente = new JLabel();
		labelValorTotalApuestasPorCliente.setText("Valor Total de Apuestas por Cliente");
		labelValorTotalApuestasPorCliente.setFont(new Font("Concord", Font.BOLD, 20));
		labelValorTotalApuestasPorCliente.setVerticalAlignment(JLabel.CENTER);
		labelValorTotalApuestasPorCliente.setHorizontalAlignment(JLabel.CENTER);
		
		seccionCedulaCliente = new JLabel();
		seccionCedulaCliente.setLayout(new GridLayout(1, 3, 5, 5));
		
		labelCedula = new JLabel();
		labelCedula.setText("Cédula");
		labelCedula.setFont(new Font(null, Font.BOLD, 15));
		labelCedula.setVerticalAlignment(JLabel.CENTER);
		labelCedula.setHorizontalAlignment(JLabel.RIGHT);
		
		campoCedula = new JTextField();
		
		btnConsultar = new JButton();
		btnConsultar.setText("Consultar");
		btnConsultar.setActionCommand(CONSULTAR);
		
		
		seccionCedulaCliente.add(labelCedula);
		seccionCedulaCliente.add(campoCedula);
		seccionCedulaCliente.add(btnConsultar);
		
		
		seccionNorte.add(labelValorTotalApuestasPorCliente);
		seccionNorte.add(seccionCedulaCliente);

		cardLayout = new CardLayout();
		
		// Definir sección central
		seccionCentral = new JLabel();
		seccionCentral.setLayout(cardLayout);
		
		
		labelCedulaSinIngresar = new JLabel();
		labelCedulaSinIngresar.setText("El valor total de las apuestas aparecerá aquí");
		labelCedulaSinIngresar.setHorizontalAlignment(JLabel.CENTER);
		labelCedulaSinIngresar.setVerticalAlignment(JLabel.CENTER);
		labelCedulaSinIngresar.setFont(new Font(null, Font.ITALIC, 30));
		
		labelClienteSinEncontrar = new JLabel();
		labelClienteSinEncontrar.setText("La cédula del cliente no ha sido encontrada");
		labelClienteSinEncontrar.setHorizontalAlignment(JLabel.CENTER);
		labelClienteSinEncontrar.setVerticalAlignment(JLabel.CENTER);
		labelClienteSinEncontrar.setFont(new Font(null, Font.ITALIC, 30));
		
		
		seccionValorTotalApuestasPorCliente = new JLabel();
		seccionValorTotalApuestasPorCliente.setLayout(new BorderLayout());
		
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Tipo de Apuesta");
		modeloTabla.addColumn("Valor de la Apuesta");
		
		tablaValorTotalApuestasPorCliente = new JTable(modeloTabla);
		
		// Deshabilitar la tabla
		tablaValorTotalApuestasPorCliente.setEnabled(false);
		
		// Deshabilitar la reordenación de las columnas de la tabla
		tablaValorTotalApuestasPorCliente.getTableHeader().setReorderingAllowed(false);
		
		// Crear un renderizador de celdas que permitirá centrar el contenido de todas las celdas de la tabla de sedes
		DefaultTableCellRenderer renderizadorDeCeldas = new DefaultTableCellRenderer();
		renderizadorDeCeldas.setHorizontalAlignment(JLabel.CENTER);
		
		
		// Aplicar el renderizador de celdas a todas las columnas de la tabla
		for (int i = 0; i < tablaValorTotalApuestasPorCliente.getColumnCount(); i++)
			tablaValorTotalApuestasPorCliente.getColumnModel().getColumn(i).setCellRenderer(renderizadorDeCeldas);
		
		// Aumentar la altura de las filas de la tabla
		tablaValorTotalApuestasPorCliente.setRowHeight(20);
		
		seccionTotalApuestas = new JLabel();
		seccionTotalApuestas.setLayout(new GridLayout(1, 3, 5, 5));
		seccionTotalApuestas.setPreferredSize(new Dimension(75, 75));
		seccionTotalApuestas.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		labelTotalApuestas = new JLabel();
		labelTotalApuestas.setText("Total Apuestas");
		labelTotalApuestas.setFont(new Font(null, Font.BOLD, 15));
		
		campoTotalApuestas = new JTextField();
		campoTotalApuestas.setEditable(false);
		
		seccionTotalApuestas.add(new JLabel());
		seccionTotalApuestas.add(labelTotalApuestas);
		seccionTotalApuestas.add(campoTotalApuestas);
		
		
		seccionValorTotalApuestasPorCliente.add(new JScrollPane(tablaValorTotalApuestasPorCliente), BorderLayout.CENTER);
		seccionValorTotalApuestasPorCliente.add(seccionTotalApuestas, BorderLayout.SOUTH);
		
		seccionCentral.add(labelCedulaSinIngresar, "labelCedulaSinIngresar");
		seccionCentral.add(labelClienteSinEncontrar, "labelClienteSinEncontrar");
		seccionCentral.add(seccionValorTotalApuestasPorCliente, "seccionValorTotalApuestasPorCliente");
		
		
		// Definir sección sur
		seccionSur = new JLabel("    ");

		// Definir sección este
		seccionEste = new JLabel("    ");

		// Definir sección oeste
		seccionOeste = new JLabel("    ");

		add(seccionNorte, BorderLayout.NORTH);
		add(seccionCentral, BorderLayout.CENTER);
		add(seccionSur, BorderLayout.SOUTH);
		add(seccionEste, BorderLayout.EAST);
		add(seccionOeste, BorderLayout.WEST);
	}
	
	
	/**
	 * Agregar apuestas por cliente.
	 *
	 * @param apuestasPorCliente Arreglo bidimensional que contiene las apuestas por cliente a ser agregadas.
	 */
	public void agregarApuestasPorCliente(Object[][] apuestasPorCliente) {
		
		while (tablaValorTotalApuestasPorCliente.getRowCount() > 0)
			modeloTabla.removeRow(0);
		
		for (int i = 0; i < apuestasPorCliente.length; i++)
			modeloTabla.addRow(apuestasPorCliente[i]);
	}
	
	/**
	 * Agregar total apuestas por cliente.
	 */
	public void agregarTotalApuestasPorCliente() {
		
		// Sumar todas las apuestas del cliente. El índice 1 de la columna es el valor de cada apuesta
		double totalApuestas = 0;
		for (int i = 0; i < tablaValorTotalApuestasPorCliente.getRowCount(); i++)
			totalApuestas += Double.parseDouble(tablaValorTotalApuestasPorCliente.getValueAt(i, 1).toString());
		
		campoTotalApuestas.setText(totalApuestas + "");
	}
	
	
	/**
	 * Mostrar label cedula sin ingresar.
	 */
	public void mostrarLabelCedulaSinIngresar() {
		cardLayout.show(seccionCentral, "labelCedulaSinIngresar");
	}
	
	/**
	 * Mostrar label cliente sin encontrar.
	 */
	public void mostrarLabelClienteSinEncontrar() {
		cardLayout.show(seccionCentral, "labelClienteSinEncontrar");
	}
	
	/**
	 * Mostrar seccion valor total apuestas por cliente.
	 */
	public void mostrarSeccionValorTotalApuestasPorCliente() {
		cardLayout.show(seccionCentral, "seccionValorTotalApuestasPorCliente");
	}

	/**
	 * Gets the card layout.
	 *
	 * @return the card layout
	 */
	public CardLayout getCardLayout() {
		return cardLayout;
	}

	/**
	 * Sets the card layout.
	 *
	 * @param cardLayout the new card layout
	 */
	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
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
	 * Gets the label valor total apuestas por cliente.
	 *
	 * @return the label valor total apuestas por cliente
	 */
	public JLabel getLabelValorTotalApuestasPorCliente() {
		return labelValorTotalApuestasPorCliente;
	}

	/**
	 * Sets the label valor total apuestas por cliente.
	 *
	 * @param labelValorTotalApuestasPorCliente the new label valor total apuestas por cliente
	 */
	public void setLabelValorTotalApuestasPorCliente(JLabel labelValorTotalApuestasPorCliente) {
		this.labelValorTotalApuestasPorCliente = labelValorTotalApuestasPorCliente;
	}

	/**
	 * Gets the seccion cedula cliente.
	 *
	 * @return the seccion cedula cliente
	 */
	public JLabel getSeccionCedulaCliente() {
		return seccionCedulaCliente;
	}

	/**
	 * Sets the seccion cedula cliente.
	 *
	 * @param seccionCedulaCliente the new seccion cedula cliente
	 */
	public void setSeccionCedulaCliente(JLabel seccionCedulaCliente) {
		this.seccionCedulaCliente = seccionCedulaCliente;
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
	 * Gets the seccion sur.
	 *
	 * @return the seccion sur
	 */
	public JLabel getSeccionSur() {
		return seccionSur;
	}

	/**
	 * Sets the seccion sur.
	 *
	 * @param seccionSur the new seccion sur
	 */
	public void setSeccionSur(JLabel seccionSur) {
		this.seccionSur = seccionSur;
	}

	/**
	 * Gets the seccion este.
	 *
	 * @return the seccion este
	 */
	public JLabel getSeccionEste() {
		return seccionEste;
	}

	/**
	 * Sets the seccion este.
	 *
	 * @param seccionEste the new seccion este
	 */
	public void setSeccionEste(JLabel seccionEste) {
		this.seccionEste = seccionEste;
	}

	/**
	 * Gets the seccion oeste.
	 *
	 * @return the seccion oeste
	 */
	public JLabel getSeccionOeste() {
		return seccionOeste;
	}

	/**
	 * Sets the seccion oeste.
	 *
	 * @param seccionOeste the new seccion oeste
	 */
	public void setSeccionOeste(JLabel seccionOeste) {
		this.seccionOeste = seccionOeste;
	}

	/**
	 * Gets the label cedula sin ingresar.
	 *
	 * @return the label cedula sin ingresar
	 */
	public JLabel getLabelCedulaSinIngresar() {
		return labelCedulaSinIngresar;
	}

	/**
	 * Sets the label cedula sin ingresar.
	 *
	 * @param labelCedulaSinIngresar the new label cedula sin ingresar
	 */
	public void setLabelCedulaSinIngresar(JLabel labelCedulaSinIngresar) {
		this.labelCedulaSinIngresar = labelCedulaSinIngresar;
	}

	/**
	 * Gets the label cliente sin encontrar.
	 *
	 * @return the label cliente sin encontrar
	 */
	public JLabel getLabelClienteSinEncontrar() {
		return labelClienteSinEncontrar;
	}

	/**
	 * Sets the label cliente sin encontrar.
	 *
	 * @param labelClienteSinEncontrar the new label cliente sin encontrar
	 */
	public void setLabelClienteSinEncontrar(JLabel labelClienteSinEncontrar) {
		this.labelClienteSinEncontrar = labelClienteSinEncontrar;
	}

	/**
	 * Gets the seccion valor total apuestas por cliente.
	 *
	 * @return the seccion valor total apuestas por cliente
	 */
	public JLabel getSeccionValorTotalApuestasPorCliente() {
		return seccionValorTotalApuestasPorCliente;
	}

	/**
	 * Sets the seccion valor total apuestas por cliente.
	 *
	 * @param seccionValorTotalApuestasPorCliente the new seccion valor total apuestas por cliente
	 */
	public void setSeccionValorTotalApuestasPorCliente(JLabel seccionValorTotalApuestasPorCliente) {
		this.seccionValorTotalApuestasPorCliente = seccionValorTotalApuestasPorCliente;
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
	 * Gets the tabla valor total apuestas por cliente.
	 *
	 * @return the tabla valor total apuestas por cliente
	 */
	public JTable getTablaValorTotalApuestasPorCliente() {
		return tablaValorTotalApuestasPorCliente;
	}

	/**
	 * Sets the tabla valor total apuestas por cliente.
	 *
	 * @param tablaValorTotalApuestasPorCliente the new tabla valor total apuestas por cliente
	 */
	public void setTablaValorTotalApuestasPorCliente(JTable tablaValorTotalApuestasPorCliente) {
		this.tablaValorTotalApuestasPorCliente = tablaValorTotalApuestasPorCliente;
	}

	/**
	 * Gets the seccion total apuestas.
	 *
	 * @return the seccion total apuestas
	 */
	public JLabel getSeccionTotalApuestas() {
		return seccionTotalApuestas;
	}

	/**
	 * Sets the seccion total apuestas.
	 *
	 * @param seccionTotalApuestas the new seccion total apuestas
	 */
	public void setSeccionTotalApuestas(JLabel seccionTotalApuestas) {
		this.seccionTotalApuestas = seccionTotalApuestas;
	}

	/**
	 * Gets the label total apuestas.
	 *
	 * @return the label total apuestas
	 */
	public JLabel getLabelTotalApuestas() {
		return labelTotalApuestas;
	}

	/**
	 * Sets the label total apuestas.
	 *
	 * @param labelTotalApuestas the new label total apuestas
	 */
	public void setLabelTotalApuestas(JLabel labelTotalApuestas) {
		this.labelTotalApuestas = labelTotalApuestas;
	}

	/**
	 * Gets the campo total apuestas.
	 *
	 * @return the campo total apuestas
	 */
	public JTextField getCampoTotalApuestas() {
		return campoTotalApuestas;
	}

	/**
	 * Sets the campo total apuestas.
	 *
	 * @param campoTotalApuestas the new campo total apuestas
	 */
	public void setCampoTotalApuestas(JTextField campoTotalApuestas) {
		this.campoTotalApuestas = campoTotalApuestas;
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
