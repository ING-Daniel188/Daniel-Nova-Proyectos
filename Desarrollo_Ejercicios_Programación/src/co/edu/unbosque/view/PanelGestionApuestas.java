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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * The Class PanelGestionApuestas.
 */
public class PanelGestionApuestas extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Labels para las secciones del panel. */
	private JLabel seccionCentral, seccionNorte, seccionSur, seccionEste, seccionOeste;
	
	/**  Secciones pertenecientes al label seccionCentral. */
	private JLabel seccionTablaApostadores, seccionBotonesDeNavegacion;
	
	/** Botones de navegacion. */
	private JButton btnVolverAlMenuPrincipal, btnCrearApuesta, btnModificarApuesta, btnEliminarApuesta;
	
	/** Modelo de tabla para la visualizacion de las apuestas. */
	private DefaultTableModel modeloTabla;
	
	/** Tabla que muestra la informacion de las apuestas. */
	private JTable tablaApuestas;
	
	/** The volver al menu principal. */
	public final String VOLVER_AL_MENU_PRINCIPAL = "Volver al Menu Principal";
	
	/** The crear apuesta. */
	public final String CREAR_APUESTA = "Crear Apuesta";
	
	/** The modificar apuesta. */
	public final String MODIFICAR_APUESTA = "Modificar Apuesta";
	
	/** The eliminar apuesta. */
	public final String ELIMINAR_APUESTA = "Eliminar Apuesta";

	/**
	 * Instantiates a new panel gestion apuestas.
	 */
	public PanelGestionApuestas() {

		setLayout(new BorderLayout());

		// Definir sección norte
		seccionNorte = new JLabel();
		seccionNorte.setText("Gestionar Apuestas");
		seccionNorte.setFont(new Font("Concord", Font.BOLD, 30));
		seccionNorte.setVerticalAlignment(JLabel.CENTER);
		seccionNorte.setHorizontalAlignment(JLabel.CENTER);
		seccionNorte.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// Definir sección central
		seccionCentral = new JLabel();
		seccionCentral.setLayout(new GridLayout(2, 1, 25, 25));
		
		// Definir tabla de apostadores
		seccionTablaApostadores = new JLabel();
		seccionTablaApostadores.setLayout(new GridLayout(1, 1, 25, 5));
		
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Tipo de Apuesta");
		modeloTabla.addColumn("Nombre de la Sede");
		modeloTabla.addColumn("Cédula del Apostador");
		modeloTabla.addColumn("Fecha de la Apuesta");
		modeloTabla.addColumn("Valor de la Apuesta");
		
		tablaApuestas = new JTable(modeloTabla);
		tablaApuestas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Hacer que la tabla no sea editable
		tablaApuestas.setDefaultEditor(Object.class, null);
		
		// Deshabilitar la reordenación de las columnas de la tabla
		tablaApuestas.getTableHeader().setReorderingAllowed(false);
		
		// Crear un renderizador de celdas que permitirá centrar el contenido de todas las celdas de la tabla de sedes
		DefaultTableCellRenderer renderizadorDeCeldas = new DefaultTableCellRenderer();
		renderizadorDeCeldas.setHorizontalAlignment(JLabel.CENTER);
		
		// Aplicar el renderizador de celdas a todas las columnas de la tabla
		for (int i = 0; i < tablaApuestas.getColumnCount(); i++)
			tablaApuestas.getColumnModel().getColumn(i).setCellRenderer(renderizadorDeCeldas);
		
		// Aumentar la altura de las filas de la tabla
		tablaApuestas.setRowHeight(20);
		
		seccionTablaApostadores.add(new JScrollPane(tablaApuestas));
		
		
		// Definir botones de navegación
		seccionBotonesDeNavegacion = new JLabel();
		seccionBotonesDeNavegacion.setLayout(new GridLayout(1, 4, 25, 25));
		
		btnVolverAlMenuPrincipal = new JButton();
		btnVolverAlMenuPrincipal.setText(VOLVER_AL_MENU_PRINCIPAL);
		btnVolverAlMenuPrincipal.setActionCommand(VOLVER_AL_MENU_PRINCIPAL);
		
		btnModificarApuesta = new JButton();
		btnModificarApuesta.setText(MODIFICAR_APUESTA);
		btnModificarApuesta.setActionCommand(MODIFICAR_APUESTA);
		
		btnEliminarApuesta = new JButton();
		btnEliminarApuesta.setText(ELIMINAR_APUESTA);
		btnEliminarApuesta.setActionCommand(ELIMINAR_APUESTA);
		
		btnCrearApuesta = new JButton();
		btnCrearApuesta.setText(CREAR_APUESTA);
		btnCrearApuesta.setActionCommand(CREAR_APUESTA);
		
		
		seccionBotonesDeNavegacion.add(btnVolverAlMenuPrincipal);
		seccionBotonesDeNavegacion.add(btnModificarApuesta);
		seccionBotonesDeNavegacion.add(btnEliminarApuesta);
		seccionBotonesDeNavegacion.add(btnCrearApuesta);
		
		seccionCentral.add(seccionTablaApostadores);
		seccionCentral.add(seccionBotonesDeNavegacion);
		

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
	 * Gets the seccion tabla apostadores.
	 *
	 * @return the seccion tabla apostadores
	 */
	public JLabel getSeccionTablaApostadores() {
		return seccionTablaApostadores;
	}

	/**
	 * Sets the seccion tabla apostadores.
	 *
	 * @param seccionTablaApostadores the new seccion tabla apostadores
	 */
	public void setSeccionTablaApostadores(JLabel seccionTablaApostadores) {
		this.seccionTablaApostadores = seccionTablaApostadores;
	}

	/**
	 * Gets the seccion botones de navegacion.
	 *
	 * @return the seccion botones de navegacion
	 */
	public JLabel getSeccionBotonesDeNavegacion() {
		return seccionBotonesDeNavegacion;
	}

	/**
	 * Sets the seccion botones de navegacion.
	 *
	 * @param seccionBotonesDeNavegacion the new seccion botones de navegacion
	 */
	public void setSeccionBotonesDeNavegacion(JLabel seccionBotonesDeNavegacion) {
		this.seccionBotonesDeNavegacion = seccionBotonesDeNavegacion;
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
	 * Gets the btn crear apuesta.
	 *
	 * @return the btn crear apuesta
	 */
	public JButton getBtnCrearApuesta() {
		return btnCrearApuesta;
	}

	/**
	 * Sets the btn crear apuesta.
	 *
	 * @param btnCrearApuesta the new btn crear apuesta
	 */
	public void setBtnCrearApuesta(JButton btnCrearApuesta) {
		this.btnCrearApuesta = btnCrearApuesta;
	}

	/**
	 * Gets the btn modificar apuesta.
	 *
	 * @return the btn modificar apuesta
	 */
	public JButton getBtnModificarApuesta() {
		return btnModificarApuesta;
	}

	/**
	 * Sets the btn modificar apuesta.
	 *
	 * @param btnModificarApuesta the new btn modificar apuesta
	 */
	public void setBtnModificarApuesta(JButton btnModificarApuesta) {
		this.btnModificarApuesta = btnModificarApuesta;
	}

	/**
	 * Gets the btn eliminar apuesta.
	 *
	 * @return the btn eliminar apuesta
	 */
	public JButton getBtnEliminarApuesta() {
		return btnEliminarApuesta;
	}

	/**
	 * Sets the btn eliminar apuesta.
	 *
	 * @param btnEliminarApuesta the new btn eliminar apuesta
	 */
	public void setBtnEliminarApuesta(JButton btnEliminarApuesta) {
		this.btnEliminarApuesta = btnEliminarApuesta;
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
	 * Gets the tabla apuestas.
	 *
	 * @return the tabla apuestas
	 */
	public JTable getTablaApuestas() {
		return tablaApuestas;
	}

	/**
	 * Sets the tabla apuestas.
	 *
	 * @param tablaApuestas the new tabla apuestas
	 */
	public void setTablaApuestas(JTable tablaApuestas) {
		this.tablaApuestas = tablaApuestas;
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
