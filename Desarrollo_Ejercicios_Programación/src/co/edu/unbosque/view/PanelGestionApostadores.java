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
 * The Class PanelGestionApostadores.
 */
public class PanelGestionApostadores extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Labels para las secciones del panel. */
	private JLabel seccionCentral, seccionNorte, seccionSur, seccionEste, seccionOeste;
	
	/** Secciones pertenecientes a la seccion central. */
	private JLabel seccionTablaApostadores, seccionBotonesDeNavegacion;
	
	/** Botones de navegacion. */
	private JButton btnVolverAlMenuPrincipal, btnCrearApostador, btnModificarApostador, btnEliminarApostador;
	
	/** Modelo de tabla para la visualizacion de apostadores. */
	private DefaultTableModel modeloTabla;
	
	/** abla que muestra la informacion de los apostadores. */
	private JTable tablaApostadores;
	
	/** The volver al menu principal. */
	public final String VOLVER_AL_MENU_PRINCIPAL = "Volver al Menu Principal";
	
	/** The crear apostador. */
	public final String CREAR_APOSTADOR = "Crear Apostador";
	
	/** The modificar apostador. */
	public final String MODIFICAR_APOSTADOR = "Modificar Apostador";
	
	/** The eliminar apostador. */
	public final String ELIMINAR_APOSTADOR = "Eliminar Apostador";

	/**
	 * Instantiates a new panel gestion apostadores.
	 */
	public PanelGestionApostadores() {

		setLayout(new BorderLayout());

		// Definir sección norte
		seccionNorte = new JLabel();
		seccionNorte.setText("Gestionar Apostadores");
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
		modeloTabla.addColumn("Nombre Completo");
		modeloTabla.addColumn("Cédula");
		modeloTabla.addColumn("Sede Actual");
		modeloTabla.addColumn("Dirección");
		modeloTabla.addColumn("Celular");
		
		tablaApostadores = new JTable(modeloTabla);
		tablaApostadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Hacer que la tabla no sea editable
		tablaApostadores.setDefaultEditor(Object.class, null);
		
		// Deshabilitar la reordenación de las columnas de la tabla
		tablaApostadores.getTableHeader().setReorderingAllowed(false);
		
		// Crear un renderizador de celdas que permitirá centrar el contenido de todas las celdas de la tabla de sedes
		DefaultTableCellRenderer renderizadorDeCeldas = new DefaultTableCellRenderer();
		renderizadorDeCeldas.setHorizontalAlignment(JLabel.CENTER);
		
		// Aplicar el renderizador de celdas a todas las columnas de la tabla
		for (int i = 0; i < tablaApostadores.getColumnCount(); i++)
			tablaApostadores.getColumnModel().getColumn(i).setCellRenderer(renderizadorDeCeldas);
		
		// Aumentar la altura de las filas de la tabla
		tablaApostadores.setRowHeight(20);
		
		seccionTablaApostadores.add(new JScrollPane(tablaApostadores));
		
		
		// Definir botones de navegación
		seccionBotonesDeNavegacion = new JLabel();
		seccionBotonesDeNavegacion.setLayout(new GridLayout(1, 4, 25, 25));
		
		btnVolverAlMenuPrincipal = new JButton();
		btnVolverAlMenuPrincipal.setText(VOLVER_AL_MENU_PRINCIPAL);
		btnVolverAlMenuPrincipal.setActionCommand(VOLVER_AL_MENU_PRINCIPAL);
		
		btnModificarApostador = new JButton();
		btnModificarApostador.setText(MODIFICAR_APOSTADOR);
		btnModificarApostador.setActionCommand(MODIFICAR_APOSTADOR);
		
		btnEliminarApostador = new JButton();
		btnEliminarApostador.setText(ELIMINAR_APOSTADOR);
		btnEliminarApostador.setActionCommand(ELIMINAR_APOSTADOR);
		
		btnCrearApostador = new JButton();
		btnCrearApostador.setText(CREAR_APOSTADOR);
		btnCrearApostador.setActionCommand(CREAR_APOSTADOR);
		
		
		seccionBotonesDeNavegacion.add(btnVolverAlMenuPrincipal);
		seccionBotonesDeNavegacion.add(btnModificarApostador);
		seccionBotonesDeNavegacion.add(btnEliminarApostador);
		seccionBotonesDeNavegacion.add(btnCrearApostador);
		
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
	 * Gets the btn crear apostador.
	 *
	 * @return the btn crear apostador
	 */
	public JButton getBtnCrearApostador() {
		return btnCrearApostador;
	}

	/**
	 * Sets the btn crear apostador.
	 *
	 * @param btnCrearApostador the new btn crear apostador
	 */
	public void setBtnCrearApostador(JButton btnCrearApostador) {
		this.btnCrearApostador = btnCrearApostador;
	}

	/**
	 * Gets the btn modificar apostador.
	 *
	 * @return the btn modificar apostador
	 */
	public JButton getBtnModificarApostador() {
		return btnModificarApostador;
	}

	/**
	 * Sets the btn modificar apostador.
	 *
	 * @param btnModificarApostador the new btn modificar apostador
	 */
	public void setBtnModificarApostador(JButton btnModificarApostador) {
		this.btnModificarApostador = btnModificarApostador;
	}

	/**
	 * Gets the btn eliminar apostador.
	 *
	 * @return the btn eliminar apostador
	 */
	public JButton getBtnEliminarApostador() {
		return btnEliminarApostador;
	}

	/**
	 * Sets the btn eliminar apostador.
	 *
	 * @param btnEliminarApostador the new btn eliminar apostador
	 */
	public void setBtnEliminarApostador(JButton btnEliminarApostador) {
		this.btnEliminarApostador = btnEliminarApostador;
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
	 * Gets the tabla apostadores.
	 *
	 * @return the tabla apostadores
	 */
	public JTable getTablaApostadores() {
		return tablaApostadores;
	}

	/**
	 * Sets the tabla apostadores.
	 *
	 * @param tablaApostadores the new tabla apostadores
	 */
	public void setTablaApostadores(JTable tablaApostadores) {
		this.tablaApostadores = tablaApostadores;
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
