package co.edu.unbosque.view;

import java.awt.BorderLayout;
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
 * The Class PanelGestionSedes.
 */
public class PanelGestionSedes extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Labels para las secciones del panel. */
	private JLabel seccionCentral, seccionNorte, seccionSur, seccionEste, seccionOeste;
	
	/** Secciones especificas para la creacion, modificacion y eliminacion de sedes en el panel. */
	private JLabel seccionCentralInferior, seccionCentralSuperior, seccionModificarEliminar;
	
	/** Labels para la ubicacion y numero de empleados. */
	private JLabel labelUbicacion, labelNumeroDeEmpleados;
	
	/** Seleccion de localidad a crear y a modificar. */
	private JComboBox<String> seleccionLocalidad, seleccionLocalidadAModificar;
	
	/** Campos de número de empleados a crear y a modificar. */
	private JTextField campoNumeroDeEmpleados, campoNumeroDeEmpleadosAModificar;
	
	/** Botones de navegacion. */
	private JButton btnVolverAlMenuPrincipal, btnCrearSede, btnModificarSede, btnEliminarSede;
	
	/** Modelo de tabla para la visualizacion de las sedes. */
	private DefaultTableModel modeloTabla;
	
	/** Tabla que muestra la informacion de las sedes. */
	private JTable tablaSedes;
	
	/** The modificar sede. */
	public final String MODIFICAR_SEDE = "Modificar Sede";
	
	/** The eliminar sede. */
	public final String ELIMINAR_SEDE = "Eliminar Sede";
	
	/** The seleccionar localidad a actualizar. */
	public final String SELECCIONAR_LOCALIDAD_A_ACTUALIZAR = "Seleccionar Localidad a Actualizar";
	
	/** The seleccionar localidad. */
	public final String SELECCIONAR_LOCALIDAD = "Seleccionar Localidad";
	
	/** The volver al menu principal. */
	public final String VOLVER_AL_MENU_PRINCIPAL = "Volver al Menu Principal";
	
	/** The crear sede. */
	public final String CREAR_SEDE = "Crear Sede";

	/**
	 * Instantiates a new panel gestion sedes.
	 */
	public PanelGestionSedes() {

		setLayout(new BorderLayout());

		// Definir sección norte
		seccionNorte = new JLabel();
		seccionNorte.setText("Gestionar Sedes");
		seccionNorte.setFont(new Font("Concord", Font.BOLD, 30));
		seccionNorte.setVerticalAlignment(JLabel.CENTER);
		seccionNorte.setHorizontalAlignment(JLabel.CENTER);
		seccionNorte.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// Definir sección central
		seccionCentral = new JLabel();
		seccionCentral.setLayout(new GridLayout(2, 1, 10, 5));

		seccionCentralInferior = new JLabel();
		seccionCentralInferior.setLayout(new GridLayout(3, 2, 25, 5));
		seccionCentralInferior.setBorder(BorderFactory.createTitledBorder("Crear Sede Casa de Apuestas"));
		
		seccionCentralSuperior = new JLabel();
		seccionCentralSuperior.setLayout(new GridLayout(1, 2, 25, 5));
		
		
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Ubicación");
		modeloTabla.addColumn("Número de empleados");
		
		tablaSedes = new JTable(modeloTabla);
		tablaSedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Hacer que la tabla no sea editable
		tablaSedes.setDefaultEditor(Object.class, null);
		
		// Deshabilitar la reordenación de las columnas de la tabla
		tablaSedes.getTableHeader().setReorderingAllowed(false);		
		
		// Crear un renderizador de celdas que permitirá centrar el contenido de todas las celdas de la tabla de sedes
		DefaultTableCellRenderer renderizadorDeCeldas = new DefaultTableCellRenderer();
		renderizadorDeCeldas.setHorizontalAlignment(JLabel.CENTER);
		
		// Aplicar el renderizador de celdas a todas las columnas de la tabla
		for (int i = 0; i < tablaSedes.getColumnCount(); i++)
			tablaSedes.getColumnModel().getColumn(i).setCellRenderer(renderizadorDeCeldas);
		
		// Aumentar la altura de las filas de la tabla
		tablaSedes.setRowHeight(20);
		
		String[] localidades = { "Seleccionar Ubicación:", 
				"Antonio Narino", "Barrios Unidos", "Bosa", "Chapinero", "Ciudad Bolivar", 
			    "Engativa", "Fontibon", "Kennedy", "La Candelaria", "Los Martires", 
			    "Puente Aranda", "Rafael Uribe Uribe", "San Cristobal", "Santa Fe", 
			    "Suba", "Sumapaz", "Teusaquillo", "Tunjuelito", "Usaquen", "Usme" };
		
		seleccionLocalidadAModificar = new JComboBox<String>(localidades);
		seleccionLocalidadAModificar.setEnabled(false);
		seleccionLocalidadAModificar.setActionCommand(SELECCIONAR_LOCALIDAD_A_ACTUALIZAR);
		
		campoNumeroDeEmpleadosAModificar = new JTextField();
		campoNumeroDeEmpleadosAModificar.setEditable(false);
		
		btnModificarSede = new JButton();
		btnModificarSede.setText(MODIFICAR_SEDE);
		btnModificarSede.setActionCommand(MODIFICAR_SEDE);
		
		btnEliminarSede = new JButton();
		btnEliminarSede.setText(ELIMINAR_SEDE);
		btnEliminarSede.setActionCommand(ELIMINAR_SEDE);
		
		seccionModificarEliminar = new JLabel();
		seccionModificarEliminar.setBorder(BorderFactory.createTitledBorder("Modificar / Eliminar Sede Casa de Apuestas"));
		seccionModificarEliminar.setLayout(new GridLayout(3, 2, 25, 5));
		seccionModificarEliminar.add(new JLabel("Ubicacion"));
		seccionModificarEliminar.add(seleccionLocalidadAModificar);
		seccionModificarEliminar.add(new JLabel("Empleados"));
		seccionModificarEliminar.add(campoNumeroDeEmpleadosAModificar);
		seccionModificarEliminar.add(btnModificarSede);
		seccionModificarEliminar.add(btnEliminarSede);
		
		seccionCentralSuperior.add(new JScrollPane(tablaSedes));
		seccionCentralSuperior.add(seccionModificarEliminar);
		
		labelUbicacion = new JLabel();
		labelUbicacion.setText("Ubicación de la Casa de Apuestas");
		
		seleccionLocalidad = new JComboBox<>(localidades);
		seleccionLocalidad.setActionCommand(SELECCIONAR_LOCALIDAD);
		
		labelNumeroDeEmpleados = new JLabel();
		labelNumeroDeEmpleados.setText("Número de Empleados de la Casa de Apuestas");
		
		campoNumeroDeEmpleados = new JTextField();
		
		btnVolverAlMenuPrincipal = new JButton();
		btnVolverAlMenuPrincipal.setText(VOLVER_AL_MENU_PRINCIPAL);
		btnVolverAlMenuPrincipal.setActionCommand(VOLVER_AL_MENU_PRINCIPAL);
		
		btnCrearSede = new JButton();
		btnCrearSede.setText(CREAR_SEDE);
		btnCrearSede.setActionCommand(CREAR_SEDE);

		
		seccionCentralInferior.add(labelUbicacion);
		seccionCentralInferior.add(seleccionLocalidad);
		seccionCentralInferior.add(labelNumeroDeEmpleados);
		seccionCentralInferior.add(campoNumeroDeEmpleados);
		seccionCentralInferior.add(btnVolverAlMenuPrincipal);
		seccionCentralInferior.add(btnCrearSede);
		
		seccionCentral.add(seccionCentralSuperior);
		seccionCentral.add(seccionCentralInferior);
		

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
	 * Gets the seccion central inferior.
	 *
	 * @return the seccion central inferior
	 */
	public JLabel getSeccionCentralInferior() {
		return seccionCentralInferior;
	}

	/**
	 * Sets the seccion central inferior.
	 *
	 * @param seccionCentralInferior the new seccion central inferior
	 */
	public void setSeccionCentralInferior(JLabel seccionCentralInferior) {
		this.seccionCentralInferior = seccionCentralInferior;
	}

	/**
	 * Gets the seccion central superior.
	 *
	 * @return the seccion central superior
	 */
	public JLabel getSeccionCentralSuperior() {
		return seccionCentralSuperior;
	}

	/**
	 * Sets the seccion central superior.
	 *
	 * @param seccionCentralSuperior the new seccion central superior
	 */
	public void setSeccionCentralSuperior(JLabel seccionCentralSuperior) {
		this.seccionCentralSuperior = seccionCentralSuperior;
	}

	/**
	 * Gets the seccion modificar eliminar.
	 *
	 * @return the seccion modificar eliminar
	 */
	public JLabel getSeccionModificarEliminar() {
		return seccionModificarEliminar;
	}

	/**
	 * Sets the seccion modificar eliminar.
	 *
	 * @param seccionModificarEliminar the new seccion modificar eliminar
	 */
	public void setSeccionModificarEliminar(JLabel seccionModificarEliminar) {
		this.seccionModificarEliminar = seccionModificarEliminar;
	}

	/**
	 * Gets the label ubicacion.
	 *
	 * @return the label ubicacion
	 */
	public JLabel getLabelUbicacion() {
		return labelUbicacion;
	}

	/**
	 * Sets the label ubicacion.
	 *
	 * @param labelUbicacion the new label ubicacion
	 */
	public void setLabelUbicacion(JLabel labelUbicacion) {
		this.labelUbicacion = labelUbicacion;
	}

	/**
	 * Gets the label numero de empleados.
	 *
	 * @return the label numero de empleados
	 */
	public JLabel getLabelNumeroDeEmpleados() {
		return labelNumeroDeEmpleados;
	}

	/**
	 * Sets the label numero de empleados.
	 *
	 * @param labelNumeroDeEmpleados the new label numero de empleados
	 */
	public void setLabelNumeroDeEmpleados(JLabel labelNumeroDeEmpleados) {
		this.labelNumeroDeEmpleados = labelNumeroDeEmpleados;
	}

	/**
	 * Gets the seleccion localidad.
	 *
	 * @return the seleccion localidad
	 */
	public JComboBox<String> getSeleccionLocalidad() {
		return seleccionLocalidad;
	}

	/**
	 * Sets the seleccion localidad.
	 *
	 * @param seleccionLocalidad the new seleccion localidad
	 */
	public void setSeleccionLocalidad(JComboBox<String> seleccionLocalidad) {
		this.seleccionLocalidad = seleccionLocalidad;
	}

	/**
	 * Gets the seleccion localidad A modificar.
	 *
	 * @return the seleccion localidad A modificar
	 */
	public JComboBox<String> getSeleccionLocalidadAModificar() {
		return seleccionLocalidadAModificar;
	}

	/**
	 * Sets the seleccion localidad A modificar.
	 *
	 * @param seleccionLocalidadAModificar the new seleccion localidad A modificar
	 */
	public void setSeleccionLocalidadAModificar(JComboBox<String> seleccionLocalidadAModificar) {
		this.seleccionLocalidadAModificar = seleccionLocalidadAModificar;
	}

	/**
	 * Gets the campo numero de empleados.
	 *
	 * @return the campo numero de empleados
	 */
	public JTextField getCampoNumeroDeEmpleados() {
		return campoNumeroDeEmpleados;
	}

	/**
	 * Sets the campo numero de empleados.
	 *
	 * @param campoNumeroDeEmpleados the new campo numero de empleados
	 */
	public void setCampoNumeroDeEmpleados(JTextField campoNumeroDeEmpleados) {
		this.campoNumeroDeEmpleados = campoNumeroDeEmpleados;
	}

	/**
	 * Gets the campo numero de empleados A modificar.
	 *
	 * @return the campo numero de empleados A modificar
	 */
	public JTextField getCampoNumeroDeEmpleadosAModificar() {
		return campoNumeroDeEmpleadosAModificar;
	}

	/**
	 * Sets the campo numero de empleados A modificar.
	 *
	 * @param campoNumeroDeEmpleadosAModificar the new campo numero de empleados A modificar
	 */
	public void setCampoNumeroDeEmpleadosAModificar(JTextField campoNumeroDeEmpleadosAModificar) {
		this.campoNumeroDeEmpleadosAModificar = campoNumeroDeEmpleadosAModificar;
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
	 * Gets the btn crear sede.
	 *
	 * @return the btn crear sede
	 */
	public JButton getBtnCrearSede() {
		return btnCrearSede;
	}

	/**
	 * Sets the btn crear sede.
	 *
	 * @param btnCrearSede the new btn crear sede
	 */
	public void setBtnCrearSede(JButton btnCrearSede) {
		this.btnCrearSede = btnCrearSede;
	}

	/**
	 * Gets the btn modificar sede.
	 *
	 * @return the btn modificar sede
	 */
	public JButton getBtnModificarSede() {
		return btnModificarSede;
	}

	/**
	 * Sets the btn modificar sede.
	 *
	 * @param btnModificarSede the new btn modificar sede
	 */
	public void setBtnModificarSede(JButton btnModificarSede) {
		this.btnModificarSede = btnModificarSede;
	}

	/**
	 * Gets the btn eliminar sede.
	 *
	 * @return the btn eliminar sede
	 */
	public JButton getBtnEliminarSede() {
		return btnEliminarSede;
	}

	/**
	 * Sets the btn eliminar sede.
	 *
	 * @param btnEliminarSede the new btn eliminar sede
	 */
	public void setBtnEliminarSede(JButton btnEliminarSede) {
		this.btnEliminarSede = btnEliminarSede;
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
	 * Gets the tabla sedes.
	 *
	 * @return the tabla sedes
	 */
	public JTable getTablaSedes() {
		return tablaSedes;
	}

	/**
	 * Sets the tabla sedes.
	 *
	 * @param tablaSedes the new tabla sedes
	 */
	public void setTablaSedes(JTable tablaSedes) {
		this.tablaSedes = tablaSedes;
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
