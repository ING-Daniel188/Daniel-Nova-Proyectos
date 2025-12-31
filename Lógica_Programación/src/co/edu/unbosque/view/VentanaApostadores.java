package co.edu.unbosque.view;

import co.edu.unbosque.controller.Controller;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaApostadores.
 */
public class VentanaApostadores extends JFrame {

	 /** The celular field. */
 	private JTextField nombreField, cedulaField, direccionField, celularField;
     
     /** The sede field. */
     private JComboBox<String> sedeField;
     
     /** The leer button. */
     private JButton agregarButton, modificarButton, borrarButton, leerButton;

     /** The celular mod field. */
     // Atributos para los campos de modificación, borrado y lectura
     private JTextField nombreModField, cedulaModField, direccionModField, celularModField;
     
     /** The sede mod field. */
     private JComboBox<String> sedeModField;
     
     /** The leer confirm button. */
     private JButton leerConfirmButton;
     
  /** The cedula borrar field. */
  // Atributo para la sección de borrado
     private JTextField cedulaBorrarField;
     
  /** The cedula leer field. */
  // Atributos para la sección de lectura
     private JTextField cedulaLeerField;
     
    /**
     * Instantiates a new ventana apostadores.
     *
     * @param controlador the controlador
     */
    public VentanaApostadores(Controller controlador) {
        setTitle("Gestión de Apostadores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null) {
        	@Override
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		Image fondo = new ImageIcon("fondo.jpg").getImage();
        		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        	}
        };
        
        setContentPane(panel);
        

        // Sección para agregar un apostador
        JPanel agregarApostadorPanel = new JPanel();
        agregarApostadorPanel.setLayout(null);
        agregarApostadorPanel.setBorder(BorderFactory.createTitledBorder("Agregar Apostador"));
        agregarApostadorPanel.setBounds(20, 20, 750, 150);

        // Sección para agregar un apostador
        JLabel nombreLabel = new JLabel("Nombre Completo:");
        nombreLabel.setBounds(50, 30, 150, 25);
        nombreField = new JTextField();
        nombreField.setBounds(200, 30, 180, 25);

        JLabel cedulaLabel = new JLabel("Cédula:");
        cedulaLabel.setBounds(50, 60, 150, 25);
        cedulaField = new JTextField();
        cedulaField.setBounds(200, 60, 180, 25);

        JLabel sedeLabel = new JLabel("Sede:");
        sedeLabel.setBounds(50, 90, 150, 25);
        sedeField = new JComboBox<>();
        sedeField.setBounds(200, 90, 180, 25);

        JLabel direccionLabel = new JLabel("Dirección:");
        direccionLabel.setBounds(400, 30, 150, 25);
        direccionField = new JTextField();
        direccionField.setBounds(550, 30, 180, 25);

        JLabel celularLabel = new JLabel("Celular:");
        celularLabel.setBounds(400, 60, 150, 25);
        celularField = new JTextField();
        celularField.setBounds(550, 60, 180, 25);

        agregarButton = new JButton("Agregar Apostador");
        agregarButton.setBounds(550, 100, 180, 30);
        agregarButton.addActionListener(controlador);

        agregarApostadorPanel.add(nombreLabel);
        agregarApostadorPanel.add(nombreField);
        agregarApostadorPanel.add(cedulaLabel);
        agregarApostadorPanel.add(cedulaField);
        agregarApostadorPanel.add(sedeLabel);
        agregarApostadorPanel.add(sedeField);
        agregarApostadorPanel.add(direccionLabel);
        agregarApostadorPanel.add(direccionField);
        agregarApostadorPanel.add(celularLabel);
        agregarApostadorPanel.add(celularField);
        agregarApostadorPanel.add(agregarButton);

        panel.add(agregarApostadorPanel);

        
  
        
        agregarApostadorPanel.add(nombreLabel);
        agregarApostadorPanel.add(nombreField);
        agregarApostadorPanel.add(cedulaLabel);
        agregarApostadorPanel.add(cedulaField);

        // Sección para modificar un apostador
        JPanel modificarApostadorPanel = new JPanel();
        modificarApostadorPanel.setLayout(null);
        modificarApostadorPanel.setBorder(BorderFactory.createTitledBorder("Modificar Apostador"));
        modificarApostadorPanel.setBounds(20, 180, 750, 150);

        JLabel nombreModLabel = new JLabel("Nuevo Nombre:");
        nombreModLabel.setBounds(50, 30, 150, 25);
        nombreModField = new JTextField();
        nombreModField.setBounds(200, 30, 180, 25);

        JLabel cedulaModLabel = new JLabel("Nueva Cédula:");
        cedulaModLabel.setBounds(50, 60, 150, 25);
        cedulaModField = new JTextField();
        cedulaModField.setBounds(200, 60, 180, 25);

        JLabel sedeModLabel = new JLabel("Nueva Sede:");
        sedeModLabel.setBounds(50, 90, 150, 25);
        String[] sedesMod = {"Sede 1", "Sede 2", "Sede 3"};
        sedeModField = new JComboBox<>(sedesMod);
        sedeModField.setBounds(200, 90, 180, 25);

        JLabel direccionModLabel = new JLabel("Nueva Dirección:");
        direccionModLabel.setBounds(400, 30, 150, 25);
        direccionModField = new JTextField();
        direccionModField.setBounds(550, 30, 180, 25);

        JLabel celularModLabel = new JLabel("Nuevo Celular:");
        celularModLabel.setBounds(400, 60, 150, 25);
        celularModField = new JTextField();
        celularModField.setBounds(550, 60, 180, 25);

        modificarButton = new JButton("Modificar"); // Botón para confirmar modificación
        modificarButton.setBounds(550, 100, 180, 30);
        modificarButton.addActionListener(controlador);

        modificarApostadorPanel.add(nombreModLabel);
        modificarApostadorPanel.add(nombreModField);
        modificarApostadorPanel.add(cedulaModLabel);
        modificarApostadorPanel.add(cedulaModField);
        modificarApostadorPanel.add(sedeModLabel);
        modificarApostadorPanel.add(sedeModField);
        modificarApostadorPanel.add(direccionModLabel);
        modificarApostadorPanel.add(direccionModField);
        modificarApostadorPanel.add(celularModLabel);
        modificarApostadorPanel.add(celularModField);
        modificarApostadorPanel.add(modificarButton);


     // Sección para borrar un apostador
        JPanel borrarApostadorPanel = new JPanel();
        borrarApostadorPanel.setLayout(null);
        borrarApostadorPanel.setBorder(BorderFactory.createTitledBorder("Borrar Apostador"));
        borrarApostadorPanel.setBounds(20, 340, 750, 120);

        JLabel cedulaBorrarLabel = new JLabel("Cédula del Apostador a Borrar:");
        cedulaBorrarLabel.setBounds(50, 30, 250, 25); 

        cedulaBorrarField = new JTextField();
        cedulaBorrarField.setBounds(300, 30, 180, 25); 

        borrarButton = new JButton("Borrar");
        borrarButton.setBounds(500, 30, 120, 25);
        borrarButton.addActionListener(controlador);

        borrarApostadorPanel.add(cedulaBorrarLabel);
        borrarApostadorPanel.add(cedulaBorrarField);
        borrarApostadorPanel.add(borrarButton);


        
     // Sección para leer un apostador
        JPanel leerApostadorPanel = new JPanel();
        leerApostadorPanel.setLayout(null);
        leerApostadorPanel.setBorder(BorderFactory.createTitledBorder("Leer Apostador"));
        leerApostadorPanel.setBounds(20, 470, 750, 120); // Ajuste en los bounds

        JLabel cedulaLeerLabel = new JLabel("Cédula del Apostador:");
        cedulaLeerLabel.setBounds(50, 30, 200, 25);

        cedulaLeerField = new JTextField();
        cedulaLeerField.setBounds(250, 30, 180, 25);

        leerButton = new JButton("Leer");
        leerButton.setBounds(440, 30, 100, 25);
        leerButton.addActionListener(controlador);

        leerApostadorPanel.add(cedulaLeerLabel);
        leerApostadorPanel.add(cedulaLeerField);
        leerApostadorPanel.add(leerButton);

        

        panel.add(agregarApostadorPanel);
        panel.add(modificarApostadorPanel);
        panel.add(borrarApostadorPanel);
        panel.add(leerApostadorPanel);

    }
    
    /**
     * Actualizar campos.
     *
     * @param sedesActuales the sedes actuales
     */
    public void actualizarCampos(String[] sedesActuales) {
        // Limpiar campos de la sección "Agregar Apostador"
        nombreField.setText("");
        cedulaField.setText("");
        direccionField.setText("");
        celularField.setText("");
        sedeField.removeAllItems();

        // Limpiar campos de la sección "Modificar Apostador"
        nombreModField.setText("");
        cedulaModField.setText("");
        direccionModField.setText("");
        celularModField.setText("");
        sedeModField.removeAllItems();

        // Limpiar campos de la sección "Borrar Apostador"
        cedulaBorrarField.setText("");

        // Limpiar campos de la sección "Leer Apostador"
        cedulaLeerField.setText("");

        // Actualizar JComboBox de sedes en las secciones "Agregar Apostador" y "Modificar Apostador"
        while (sedeField.getItemCount() > 0)
        	sedeField.removeItemAt(0);
        
        sedeField.addItem("Seleccione sede");
        
        while (sedeModField.getItemCount() > 0)
        	sedeModField.removeItemAt(0);
        
        sedeModField.addItem("Seleccione sede");
        
        for (String sede : sedesActuales) {
            sedeField.addItem(sede);
            sedeModField.addItem(sede);
        }
    }


    // Métodos getters y setters para acceder a los campos de texto y botones
    
	/**
     * Gets the nombre field.
     *
     * @return the nombre field
     */
    public JTextField getNombreField() {
		return nombreField;
	}

	/**
	 * Sets the nombre field.
	 *
	 * @param nombreField the new nombre field
	 */
	public void setNombreField(JTextField nombreField) {
		this.nombreField = nombreField;
	}

	/**
	 * Gets the cedula field.
	 *
	 * @return the cedula field
	 */
	public JTextField getCedulaField() {
		return cedulaField;
	}

	/**
	 * Sets the cedula field.
	 *
	 * @param cedulaField the new cedula field
	 */
	public void setCedulaField(JTextField cedulaField) {
		this.cedulaField = cedulaField;
	}

	/**
	 * Gets the direccion field.
	 *
	 * @return the direccion field
	 */
	public JTextField getDireccionField() {
		return direccionField;
	}

	/**
	 * Sets the direccion field.
	 *
	 * @param direccionField the new direccion field
	 */
	public void setDireccionField(JTextField direccionField) {
		this.direccionField = direccionField;
	}

	/**
	 * Gets the celular field.
	 *
	 * @return the celular field
	 */
	public JTextField getCelularField() {
		return celularField;
	}

	/**
	 * Sets the celular field.
	 *
	 * @param celularField the new celular field
	 */
	public void setCelularField(JTextField celularField) {
		this.celularField = celularField;
	}

	/**
	 * Gets the sede field.
	 *
	 * @return the sede field
	 */
	public JComboBox<String> getSedeField() {
		return sedeField;
	}

	/**
	 * Sets the sede field.
	 *
	 * @param sedeField the new sede field
	 */
	public void setSedeField(JComboBox<String> sedeField) {
		this.sedeField = sedeField;
	}

	/**
	 * Gets the agregar button.
	 *
	 * @return the agregar button
	 */
	public JButton getAgregarButton() {
		return agregarButton;
	}

	/**
	 * Sets the agregar button.
	 *
	 * @param agregarButton the new agregar button
	 */
	public void setAgregarButton(JButton agregarButton) {
		this.agregarButton = agregarButton;
	}

	/**
	 * Gets the modificar button.
	 *
	 * @return the modificar button
	 */
	public JButton getModificarButton() {
		return modificarButton;
	}

	/**
	 * Sets the modificar button.
	 *
	 * @param modificarButton the new modificar button
	 */
	public void setModificarButton(JButton modificarButton) {
		this.modificarButton = modificarButton;
	}

	/**
	 * Gets the borrar button.
	 *
	 * @return the borrar button
	 */
	public JButton getBorrarButton() {
		return borrarButton;
	}

	/**
	 * Sets the borrar button.
	 *
	 * @param borrarButton the new borrar button
	 */
	public void setBorrarButton(JButton borrarButton) {
		this.borrarButton = borrarButton;
	}

	/**
	 * Gets the leer button.
	 *
	 * @return the leer button
	 */
	public JButton getLeerButton() {
		return leerButton;
	}

	/**
	 * Sets the leer button.
	 *
	 * @param leerButton the new leer button
	 */
	public void setLeerButton(JButton leerButton) {
		this.leerButton = leerButton;
	}

	/**
	 * Gets the nombre mod field.
	 *
	 * @return the nombre mod field
	 */
	public JTextField getNombreModField() {
		return nombreModField;
	}

	/**
	 * Sets the nombre mod field.
	 *
	 * @param nombreModField the new nombre mod field
	 */
	public void setNombreModField(JTextField nombreModField) {
		this.nombreModField = nombreModField;
	}

	/**
	 * Gets the cedula mod field.
	 *
	 * @return the cedula mod field
	 */
	public JTextField getCedulaModField() {
		return cedulaModField;
	}

	/**
	 * Sets the cedula mod field.
	 *
	 * @param cedulaModField the new cedula mod field
	 */
	public void setCedulaModField(JTextField cedulaModField) {
		this.cedulaModField = cedulaModField;
	}

	/**
	 * Gets the direccion mod field.
	 *
	 * @return the direccion mod field
	 */
	public JTextField getDireccionModField() {
		return direccionModField;
	}

	/**
	 * Sets the direccion mod field.
	 *
	 * @param direccionModField the new direccion mod field
	 */
	public void setDireccionModField(JTextField direccionModField) {
		this.direccionModField = direccionModField;
	}

	/**
	 * Gets the celular mod field.
	 *
	 * @return the celular mod field
	 */
	public JTextField getCelularModField() {
		return celularModField;
	}

	/**
	 * Sets the celular mod field.
	 *
	 * @param celularModField the new celular mod field
	 */
	public void setCelularModField(JTextField celularModField) {
		this.celularModField = celularModField;
	}

	/**
	 * Gets the sede mod field.
	 *
	 * @return the sede mod field
	 */
	public JComboBox<String> getSedeModField() {
		return sedeModField;
	}

	/**
	 * Sets the sede mod field.
	 *
	 * @param sedeModField the new sede mod field
	 */
	public void setSedeModField(JComboBox<String> sedeModField) {
		this.sedeModField = sedeModField;
	}

	/**
	 * Gets the leer confirm button.
	 *
	 * @return the leer confirm button
	 */
	public JButton getLeerConfirmButton() {
		return leerConfirmButton;
	}

	/**
	 * Sets the leer confirm button.
	 *
	 * @param leerConfirmButton the new leer confirm button
	 */
	public void setLeerConfirmButton(JButton leerConfirmButton) {
		this.leerConfirmButton = leerConfirmButton;
	}

	/**
	 * Gets the cedula borrar field.
	 *
	 * @return the cedula borrar field
	 */
	public JTextField getCedulaBorrarField() {
		return cedulaBorrarField;
	}

	/**
	 * Sets the cedula borrar field.
	 *
	 * @param cedulaBorrarField the new cedula borrar field
	 */
	public void setCedulaBorrarField(JTextField cedulaBorrarField) {
		this.cedulaBorrarField = cedulaBorrarField;
	}

	/**
	 * Gets the cedula leer field.
	 *
	 * @return the cedula leer field
	 */
	public JTextField getCedulaLeerField() {
		return cedulaLeerField;
	}

	/**
	 * Sets the cedula leer field.
	 *
	 * @param cedulaLeerField the new cedula leer field
	 */
	public void setCedulaLeerField(JTextField cedulaLeerField) {
		this.cedulaLeerField = cedulaLeerField;
	}
   
}
