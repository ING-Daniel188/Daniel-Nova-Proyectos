package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * The Class PanelClientesPorSede.
 */
public class PanelClientesPorSede extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Lienzo del panel. */
	private CardLayout cardLayout;
	
	/** Seccion norte de la interfaz. */
	private JPanel seccionNorte;

	/** Etiqueta para la cantidad de clientes por sede. */
	private JLabel labelClientesPorSede;

	/** Seleccion de la sede. */
	private JComboBox<String> seleccionSede;

	/** Etiqueta para sedes no seleccionadas y sedes sin clientes. */
	private JLabel labelSedeSinSeleccionar, labelSedeSinClientes;

	/** Secciones de la interfaz: central, sur, este, oeste. */
	private JLabel seccionCentral, seccionSur, seccionEste, seccionOeste;

	/** Modelo de tabla para la informacion de clientes por sede. */
	private DefaultTableModel modeloTabla;

	/** Tabla que muestra los clientes por sede. */
	private JTable tablaClientesPorSede;
	
	/** The seleccionar sede. */
	public final String SELECCIONAR_SEDE = "Seleccionar Sede (consulta)";

	/**
	 * Instantiates a new panel clientes por sede.
	 */
	public PanelClientesPorSede() {
		setLayout(new BorderLayout());
		
		// Definir sección norte
		seccionNorte = new JPanel();
		seccionNorte.setLayout(new GridLayout(1, 2, 5, 5));
		seccionNorte.setPreferredSize(new Dimension(75, 75));
		seccionNorte.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		labelClientesPorSede = new JLabel();
		labelClientesPorSede.setText("Clientes por Sede");
		labelClientesPorSede.setFont(new Font("Concord", Font.BOLD, 20));
		labelClientesPorSede.setVerticalAlignment(JLabel.CENTER);
		labelClientesPorSede.setHorizontalAlignment(JLabel.CENTER);
		
		seleccionSede = new JComboBox<String>();
		seleccionSede.setActionCommand(SELECCIONAR_SEDE);
		
		seccionNorte.add(labelClientesPorSede);
		seccionNorte.add(seleccionSede);

		cardLayout = new CardLayout();
		
		// Definir sección central
		seccionCentral = new JLabel();
		seccionCentral.setLayout(cardLayout);
		
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Nombre Completo");
		modeloTabla.addColumn("Cédula");
		modeloTabla.addColumn("Dirección");
		modeloTabla.addColumn("Celular");
		
		tablaClientesPorSede = new JTable(modeloTabla);
		
		// Deshabilitar la tabla
		tablaClientesPorSede.setEnabled(false);
		
		// Deshabilitar la reordenación de las columnas de la tabla
		tablaClientesPorSede.getTableHeader().setReorderingAllowed(false);
		
		// Crear un renderizador de celdas que permitirá centrar el contenido de todas las celdas de la tabla de sedes
		DefaultTableCellRenderer renderizadorDeCeldas = new DefaultTableCellRenderer();
		renderizadorDeCeldas.setHorizontalAlignment(JLabel.CENTER);
		
		
		// Aplicar el renderizador de celdas a todas las columnas de la tabla
		for (int i = 0; i < tablaClientesPorSede.getColumnCount(); i++)
			tablaClientesPorSede.getColumnModel().getColumn(i).setCellRenderer(renderizadorDeCeldas);
		
		// Aumentar la altura de las filas de la tabla
		tablaClientesPorSede.setRowHeight(20);
		
		labelSedeSinSeleccionar = new JLabel();
		labelSedeSinSeleccionar.setText("El listado de clientes por Sede aparecerá aquí");
		labelSedeSinSeleccionar.setHorizontalAlignment(JLabel.CENTER);
		labelSedeSinSeleccionar.setVerticalAlignment(JLabel.CENTER);
		labelSedeSinSeleccionar.setFont(new Font(null, Font.ITALIC, 30));
		
		labelSedeSinClientes = new JLabel();
		labelSedeSinClientes.setText("La sede seleccionada aún no tiene clientes");
		labelSedeSinClientes.setHorizontalAlignment(JLabel.CENTER);
		labelSedeSinClientes.setVerticalAlignment(JLabel.CENTER);
		labelSedeSinClientes.setFont(new Font(null, Font.ITALIC, 30));
		
		seccionCentral.add(new JScrollPane(tablaClientesPorSede), "tablaClientesPorSede");
		seccionCentral.add(labelSedeSinSeleccionar, "labelSedeSinSeleccionar");
		seccionCentral.add(labelSedeSinClientes, "labelSedeSinClientes");
		
		
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
	 * Mostrar label sede sin seleccionar.
	 */
	public void mostrarLabelSedeSinSeleccionar() {
		cardLayout.show(seccionCentral, "labelSedeSinSeleccionar");
	}
	
	/**
	 * Mostrar label sede sin clientes.
	 */
	public void mostrarLabelSedeSinClientes() {
		cardLayout.show(seccionCentral, "labelSedeSinClientes");
	}
	
	/**
	 * Mostrar tabla clientes por sede.
	 */
	public void mostrarTablaClientesPorSede() {
		cardLayout.show(seccionCentral, "tablaClientesPorSede");
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
	 * Gets the label clientes por sede.
	 *
	 * @return the label clientes por sede
	 */
	public JLabel getLabelClientesPorSede() {
		return labelClientesPorSede;
	}

	/**
	 * Sets the label clientes por sede.
	 *
	 * @param labelClientesPorSede the new label clientes por sede
	 */
	public void setLabelClientesPorSede(JLabel labelClientesPorSede) {
		this.labelClientesPorSede = labelClientesPorSede;
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
	 * Gets the tabla clientes por sede.
	 *
	 * @return the tabla clientes por sede
	 */
	public JTable getTablaClientesPorSede() {
		return tablaClientesPorSede;
	}

	/**
	 * Sets the tabla clientes por sede.
	 *
	 * @param tablaClientesPorSede the new tabla clientes por sede
	 */
	public void setTablaClientesPorSede(JTable tablaClientesPorSede) {
		this.tablaClientesPorSede = tablaClientesPorSede;
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
	 * Gets the label sede sin seleccionar.
	 *
	 * @return the label sede sin seleccionar
	 */
	public JLabel getLabelSedeSinSeleccionar() {
		return labelSedeSinSeleccionar;
	}

	/**
	 * Sets the label sede sin seleccionar.
	 *
	 * @param labelSedeSinSeleccionar the new label sede sin seleccionar
	 */
	public void setLabelSedeSinSeleccionar(JLabel labelSedeSinSeleccionar) {
		this.labelSedeSinSeleccionar = labelSedeSinSeleccionar;
	}

	/**
	 * Gets the label sede sin clientes.
	 *
	 * @return the label sede sin clientes
	 */
	public JLabel getLabelSedeSinClientes() {
		return labelSedeSinClientes;
	}

	/**
	 * Sets the label sede sin clientes.
	 *
	 * @param labelSedeSinClientes the new label sede sin clientes
	 */
	public void setLabelSedeSinClientes(JLabel labelSedeSinClientes) {
		this.labelSedeSinClientes = labelSedeSinClientes;
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
