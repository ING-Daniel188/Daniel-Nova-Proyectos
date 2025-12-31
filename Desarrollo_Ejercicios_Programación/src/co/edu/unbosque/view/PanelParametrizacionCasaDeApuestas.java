package co.edu.unbosque.view;

import java.awt.BorderLayout;
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
 * The Class PanelParametrizacionCasaDeApuestas.
 */
public class PanelParametrizacionCasaDeApuestas extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Secciones principales del panel. */
	private JLabel seccionCentral, seccionNorte, seccionSur, seccionEste, seccionOeste;
	
	/** Label para la seccion de parametros y la seccion de juegos de la casa de apuestas. */
	private JLabel seccionParametrosCasaDeApuestas, seccionJuegosCasaDeApuestas;

	/** Secciones de labels, campos y botones para los parámetros de la casa de apuestas. */
	private JLabel seccionLabelsParametros, seccionCamposParametros, seccionBotonesParametros;

	/** Campos para ingresar el nombre de la casa de apuestas, numero de sedes y presupuesto total. */
	private JTextField campoNombreCasaDeApuestas, campoNumeroDeSedes, campoPresupuestoTotal;

	/** Botones para cargar, guardar y volver al menu principal. */
	private JButton btnCargarParametros, btnGuardarParametros, btnVolverAlMenuPrincipal;

	/** Labels para visualizar el nombre de la casa de apuestas, número de sedes y presupuesto total. */
	private JLabel labelNombreCasaDeApuestas, labelNumeroDeSedes, labelPresupuestoTotal;
	
	/**  Modelo de la tabla para visualizar los juegos actuales. */
	private DefaultTableModel modeloTabla;
	
	/**  Tabla para los juegos de la casa de apuestas con los presupuestos asignados. */
	private JTable tablaJuegos;
	
	/** The volver al menu principal. */
	public final String VOLVER_AL_MENU_PRINCIPAL = "Volver al Menu Principal";
	
	/** The cargar parametros. */
	public final String CARGAR_PARAMETROS = "Cargar Parámetros";
	
	/** The guardar parametros. */
	public final String GUARDAR_PARAMETROS = "Guardar Parámetros";
	
	/** The seleccionar juego. */
	public final String SELECCIONAR_JUEGO = "Seleccionar Juego";
	
	/** The modificar presupuesto juego. */
	public final String MODIFICAR_PRESUPUESTO_JUEGO = "Modificar Presupuesto Juego";
	
	/**
	 * Instantiates a new panel parametrizacion casa de apuestas.
	 */
	public PanelParametrizacionCasaDeApuestas() {
		
		setLayout(new BorderLayout());
		
		// Definir sección norte
		seccionNorte = new JLabel();
		seccionNorte.setText("Parametrizar Casa de Apuestas");
		seccionNorte.setFont(new Font("Concord", Font.BOLD, 30));
		seccionNorte.setVerticalAlignment(JLabel.CENTER);
		seccionNorte.setHorizontalAlignment(JLabel.CENTER);
		seccionNorte.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		// Definir sección central
		seccionCentral = new JLabel();
		seccionCentral.setLayout(new GridLayout(2, 1, 5, 10));
		
		seccionParametrosCasaDeApuestas = new JLabel();
		seccionParametrosCasaDeApuestas.setLayout(new GridLayout(1, 3, 10, 0));
		seccionParametrosCasaDeApuestas.setBorder(BorderFactory.createTitledBorder("Casa de Apuestas"));
		
		// Definir sección labels parámetros
		seccionLabelsParametros = new JLabel();
		seccionLabelsParametros.setLayout(new GridLayout(3, 1, 10, 10));
		
		labelNombreCasaDeApuestas = new JLabel("Nombre de la Casa de Apuestas");
		labelNumeroDeSedes = new JLabel("Número de Sedes");
		labelPresupuestoTotal = new JLabel("Presupuesto Total Disponible");
		
		seccionLabelsParametros.add(labelNombreCasaDeApuestas);
		seccionLabelsParametros.add(labelNumeroDeSedes);
		seccionLabelsParametros.add(labelPresupuestoTotal);
		
		// Definir sección campos parámetros
		seccionCamposParametros = new JLabel();
		seccionCamposParametros.setLayout(new GridLayout(3, 1, 10, 10));
		
		campoNombreCasaDeApuestas = new JTextField();
		campoNumeroDeSedes = new JTextField();
		campoPresupuestoTotal = new JTextField();
		
		seccionCamposParametros.add(campoNombreCasaDeApuestas);
		seccionCamposParametros.add(campoNumeroDeSedes);
		seccionCamposParametros.add(campoPresupuestoTotal);
		
		// Definir sección botones parámetros
		seccionBotonesParametros = new JLabel();
		seccionBotonesParametros.setLayout(new GridLayout(3, 1, 10, 10));
		
		btnCargarParametros = new JButton();
		btnCargarParametros.setText(CARGAR_PARAMETROS);
		btnCargarParametros.setActionCommand(CARGAR_PARAMETROS);
		
		btnGuardarParametros = new JButton();
		btnGuardarParametros.setText(GUARDAR_PARAMETROS);
		btnGuardarParametros.setActionCommand(GUARDAR_PARAMETROS);
		
		btnVolverAlMenuPrincipal = new JButton();
		btnVolverAlMenuPrincipal.setText(VOLVER_AL_MENU_PRINCIPAL);
		btnVolverAlMenuPrincipal.setActionCommand(VOLVER_AL_MENU_PRINCIPAL);
		
		seccionBotonesParametros.add(btnCargarParametros);
		seccionBotonesParametros.add(btnGuardarParametros);
		seccionBotonesParametros.add(btnVolverAlMenuPrincipal);
		
		seccionParametrosCasaDeApuestas.add(seccionLabelsParametros);
		seccionParametrosCasaDeApuestas.add(seccionCamposParametros);
		seccionParametrosCasaDeApuestas.add(seccionBotonesParametros);
		
		seccionJuegosCasaDeApuestas = new JLabel();
		seccionJuegosCasaDeApuestas.setLayout(new GridLayout(1, 1));
		seccionJuegosCasaDeApuestas.setBorder(BorderFactory.createTitledBorder("Juegos"));
		
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Nombre del Juego");
		modeloTabla.addColumn("Tipo de Juego");
		modeloTabla.addColumn("Presupuesto asignado");
		
		tablaJuegos = new JTable(modeloTabla);
		
		// Deshabilitar la tabla de juegos para que no sea editable
		tablaJuegos.setEnabled(false);
		
		// Deshabilitar la reordenación de las columnas de la tabla
		tablaJuegos.getTableHeader().setReorderingAllowed(false);
		
		// Crear un renderizador de celdas que permitirá centrar el contenido de todas las celdas de la tabla de juegos
		DefaultTableCellRenderer renderizadorDeCeldas = new DefaultTableCellRenderer();
		renderizadorDeCeldas.setHorizontalAlignment(JLabel.CENTER);
		
		// Aplicar el renderizador de celdas a todas las columnas de la tabla
		for (int i = 0; i < tablaJuegos.getColumnCount(); i++)
			tablaJuegos.getColumnModel().getColumn(i).setCellRenderer(renderizadorDeCeldas);
		
		// Aumentar la altura de las filas de la tabla
		tablaJuegos.setRowHeight(40);
		
		// Hacer que la fuente (letra) de la tabla sea más grande
		tablaJuegos.setFont(new Font(null, Font.PLAIN, 16));
		
		seccionJuegosCasaDeApuestas.add(new JScrollPane(tablaJuegos));
		
		
		seccionCentral.add(seccionParametrosCasaDeApuestas);
		seccionCentral.add(seccionJuegosCasaDeApuestas);
		
		
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
	 * Gets the seccion norte.
	 *
	 * @return the seccion norte
	 */
	public JLabel getSeccionNorte() {
		return seccionNorte;
	}

	/**
	 * Sets the seccion norte.
	 *
	 * @param seccionNorte the new seccion norte
	 */
	public void setSeccionNorte(JLabel seccionNorte) {
		this.seccionNorte = seccionNorte;
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
	 * Gets the label nombre casa de apuestas.
	 *
	 * @return the label nombre casa de apuestas
	 */
	public JLabel getLabelNombreCasaDeApuestas() {
		return labelNombreCasaDeApuestas;
	}

	/**
	 * Sets the label nombre casa de apuestas.
	 *
	 * @param labelNombreCasaDeApuestas the new label nombre casa de apuestas
	 */
	public void setLabelNombreCasaDeApuestas(JLabel labelNombreCasaDeApuestas) {
		this.labelNombreCasaDeApuestas = labelNombreCasaDeApuestas;
	}

	/**
	 * Gets the label numero de sedes.
	 *
	 * @return the label numero de sedes
	 */
	public JLabel getLabelNumeroDeSedes() {
		return labelNumeroDeSedes;
	}

	/**
	 * Sets the label numero de sedes.
	 *
	 * @param labelNumeroDeSedes the new label numero de sedes
	 */
	public void setLabelNumeroDeSedes(JLabel labelNumeroDeSedes) {
		this.labelNumeroDeSedes = labelNumeroDeSedes;
	}

	/**
	 * Gets the label presupuesto total.
	 *
	 * @return the label presupuesto total
	 */
	public JLabel getLabelPresupuestoTotal() {
		return labelPresupuestoTotal;
	}

	/**
	 * Sets the label presupuesto total.
	 *
	 * @param labelPresupuestoTotal the new label presupuesto total
	 */
	public void setLabelPresupuestoTotal(JLabel labelPresupuestoTotal) {
		this.labelPresupuestoTotal = labelPresupuestoTotal;
	}

	/**
	 * Gets the campo nombre casa de apuestas.
	 *
	 * @return the campo nombre casa de apuestas
	 */
	public JTextField getCampoNombreCasaDeApuestas() {
		return campoNombreCasaDeApuestas;
	}

	/**
	 * Sets the campo nombre casa de apuestas.
	 *
	 * @param campoNombreCasaDeApuestas the new campo nombre casa de apuestas
	 */
	public void setCampoNombreCasaDeApuestas(JTextField campoNombreCasaDeApuestas) {
		this.campoNombreCasaDeApuestas = campoNombreCasaDeApuestas;
	}

	/**
	 * Gets the campo numero de sedes.
	 *
	 * @return the campo numero de sedes
	 */
	public JTextField getCampoNumeroDeSedes() {
		return campoNumeroDeSedes;
	}

	/**
	 * Sets the campo numero de sedes.
	 *
	 * @param campoNumeroDeSedes the new campo numero de sedes
	 */
	public void setCampoNumeroDeSedes(JTextField campoNumeroDeSedes) {
		this.campoNumeroDeSedes = campoNumeroDeSedes;
	}

	/**
	 * Gets the campo presupuesto total.
	 *
	 * @return the campo presupuesto total
	 */
	public JTextField getCampoPresupuestoTotal() {
		return campoPresupuestoTotal;
	}

	/**
	 * Sets the campo presupuesto total.
	 *
	 * @param campoPresupuestoTotal the new campo presupuesto total
	 */
	public void setCampoPresupuestoTotal(JTextField campoPresupuestoTotal) {
		this.campoPresupuestoTotal = campoPresupuestoTotal;
	}

	/**
	 * Gets the btn volver al menu principal.
	 *
	 * @return the btn volver al menu principal
	 */
	public JButton getBtnVolverAlMenuPrincipal() {
		return btnVolverAlMenuPrincipal;
	}

	/**
	 * Sets the btn volver al menu principal.
	 *
	 * @param btnVolverAlMenuPrincipal the new btn volver al menu principal
	 */
	public void setBtnVolverAlMenuPrincipal(JButton btnVolverAlMenuPrincipal) {
		this.btnVolverAlMenuPrincipal = btnVolverAlMenuPrincipal;
	}

	/**
	 * Gets the btn cargar parametros.
	 *
	 * @return the btn cargar parametros
	 */
	public JButton getBtnCargarParametros() {
		return btnCargarParametros;
	}

	/**
	 * Sets the btn cargar parametros.
	 *
	 * @param btnCargarParametros the new btn cargar parametros
	 */
	public void setBtnCargarParametros(JButton btnCargarParametros) {
		this.btnCargarParametros = btnCargarParametros;
	}

	/**
	 * Gets the btn guardar parametros.
	 *
	 * @return the btn guardar parametros
	 */
	public JButton getBtnGuardarParametros() {
		return btnGuardarParametros;
	}

	/**
	 * Sets the btn guardar parametros.
	 *
	 * @param btnGuardarParametros the new btn guardar parametros
	 */
	public void setBtnGuardarParametros(JButton btnGuardarParametros) {
		this.btnGuardarParametros = btnGuardarParametros;
	}

	/**
	 * Gets the seccion parametros casa de apuestas.
	 *
	 * @return the seccion parametros casa de apuestas
	 */
	public JLabel getSeccionParametrosCasaDeApuestas() {
		return seccionParametrosCasaDeApuestas;
	}

	/**
	 * Sets the seccion parametros casa de apuestas.
	 *
	 * @param seccionParametrosCasaDeApuestas the new seccion parametros casa de apuestas
	 */
	public void setSeccionParametrosCasaDeApuestas(JLabel seccionParametrosCasaDeApuestas) {
		this.seccionParametrosCasaDeApuestas = seccionParametrosCasaDeApuestas;
	}

	/**
	 * Gets the seccion juegos casa de apuestas.
	 *
	 * @return the seccion juegos casa de apuestas
	 */
	public JLabel getSeccionJuegosCasaDeApuestas() {
		return seccionJuegosCasaDeApuestas;
	}

	/**
	 * Sets the seccion juegos casa de apuestas.
	 *
	 * @param seccionJuegosCasaDeApuestas the new seccion juegos casa de apuestas
	 */
	public void setSeccionJuegosCasaDeApuestas(JLabel seccionJuegosCasaDeApuestas) {
		this.seccionJuegosCasaDeApuestas = seccionJuegosCasaDeApuestas;
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
	 * Gets the tabla juegos.
	 *
	 * @return the tabla juegos
	 */
	public JTable getTablaJuegos() {
		return tablaJuegos;
	}

	/**
	 * Sets the tabla juegos.
	 *
	 * @param tablaJuegos the new tabla juegos
	 */
	public void setTablaJuegos(JTable tablaJuegos) {
		this.tablaJuegos = tablaJuegos;
	}

	/**
	 * Gets the seccion labels parametros.
	 *
	 * @return the seccion labels parametros
	 */
	public JLabel getSeccionLabelsParametros() {
		return seccionLabelsParametros;
	}

	/**
	 * Sets the seccion labels parametros.
	 *
	 * @param seccionLabelsParametros the new seccion labels parametros
	 */
	public void setSeccionLabelsParametros(JLabel seccionLabelsParametros) {
		this.seccionLabelsParametros = seccionLabelsParametros;
	}

	/**
	 * Gets the seccion campos parametros.
	 *
	 * @return the seccion campos parametros
	 */
	public JLabel getSeccionCamposParametros() {
		return seccionCamposParametros;
	}

	/**
	 * Sets the seccion campos parametros.
	 *
	 * @param seccionCamposParametros the new seccion campos parametros
	 */
	public void setSeccionCamposParametros(JLabel seccionCamposParametros) {
		this.seccionCamposParametros = seccionCamposParametros;
	}

	/**
	 * Gets the seccion botones parametros.
	 *
	 * @return the seccion botones parametros
	 */
	public JLabel getSeccionBotonesParametros() {
		return seccionBotonesParametros;
	}

	/**
	 * Sets the seccion botones parametros.
	 *
	 * @param seccionBotonesParametros the new seccion botones parametros
	 */
	public void setSeccionBotonesParametros(JLabel seccionBotonesParametros) {
		this.seccionBotonesParametros = seccionBotonesParametros;
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
