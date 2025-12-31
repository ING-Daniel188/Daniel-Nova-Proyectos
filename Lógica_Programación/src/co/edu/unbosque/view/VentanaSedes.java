package co.edu.unbosque.view;

import co.edu.unbosque.controller.Controller;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaSedes.
 */
public class VentanaSedes extends JFrame {

	/** The sede A modificar combo box. */
	private JComboBox<String> ubicacionComboBox, sedeAEliminarComboBox, sedeAModificarComboBox;
    
    /** The empleados mod field. */
    private JTextField empleadosField, empleadosModField;
    
    /** The eliminar button. */
    private JButton crearButton, modificarButton, eliminarButton;

    /**
     * Instantiates a new ventana sedes.
     *
     * @param controlador the controlador
     */
    public VentanaSedes(Controller controlador) {
        setTitle("Gestión de Sedes");
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

        // Sección para crear una sede
        JPanel crearSedePanel = new JPanel();
        crearSedePanel.setLayout(null);
        crearSedePanel.setBorder(BorderFactory.createTitledBorder("Crear Sede"));
        crearSedePanel.setBounds(20, 20, 750, 150);

        JLabel ubicacionLabel = new JLabel("Ubicación (Localidad) de la Sede:");
        ubicacionLabel.setBounds(50, 50, 250, 25);

        String[] localidades = {"Selecciona ubicación:", "Usaquén", "Chapinero", "Santa Fe", "San Cristóbal", "Usme", "Tunjuelito",
                "Bosa", "Kennedy", "Fontibón", "Engativá", "Suba", "Barrios Unidos",
                "Teusaquillo", "Los Mártires", "Antonio Nariño", "Puente Aranda",
                "La Candelaria", "Rafael Uribe Uribe", "Ciudad Bolívar", "Sumapaz"};

        ubicacionComboBox = new JComboBox<>(localidades);
        ubicacionComboBox.setBounds(300, 50, 180, 25);

        JLabel empleadosLabel = new JLabel("Número de Empleados:");
        empleadosLabel.setBounds(50, 100, 250, 25);
        empleadosField = new JTextField();
        empleadosField.setBounds(300, 100, 180, 25);

        crearButton = new JButton("Crear Sede");
        crearButton.setBounds(550, 70, 150, 40);
        crearButton.addActionListener(controlador);

        crearSedePanel.add(ubicacionLabel);
        crearSedePanel.add(ubicacionComboBox);
        crearSedePanel.add(empleadosLabel);
        crearSedePanel.add(empleadosField);
        crearSedePanel.add(crearButton);

        // Sección para modificar una sede
        JPanel modificarSedePanel = new JPanel();
        modificarSedePanel.setLayout(null);
        modificarSedePanel.setBorder(BorderFactory.createTitledBorder("Modificar Sede"));
        modificarSedePanel.setBounds(20, 180, 750, 150);

        JLabel ubicacionModLabel = new JLabel("Ubicación de la Sede a Modificar:");
        ubicacionModLabel.setBounds(50, 50, 250, 25);

        sedeAModificarComboBox = new JComboBox<>();
        sedeAModificarComboBox.setBounds(300, 50, 180, 25);

        JLabel empleadosModLabel = new JLabel("Nuevo Número de Empleados:");
        empleadosModLabel.setBounds(50, 100, 250, 25);
        empleadosModField = new JTextField();
        empleadosModField.setBounds(300, 100, 180, 25);

        modificarButton = new JButton("Modificar Sede");
        modificarButton.setBounds(550, 70, 150, 40);
        modificarButton.addActionListener(controlador);

        modificarSedePanel.add(ubicacionModLabel);
        modificarSedePanel.add(sedeAModificarComboBox);
        modificarSedePanel.add(empleadosModLabel);
        modificarSedePanel.add(empleadosModField);
        modificarSedePanel.add(modificarButton);

        // Sección para eliminar una sede
        JPanel eliminarSedePanel = new JPanel();
        eliminarSedePanel.setLayout(null);
        eliminarSedePanel.setBorder(BorderFactory.createTitledBorder("Eliminar Sede"));
        eliminarSedePanel.setBounds(20, 340, 750, 150);

        JLabel sedeAEliminarLabel = new JLabel("Selecciona la Sede a Eliminar:");
        sedeAEliminarLabel.setBounds(50, 30, 250, 25);

        sedeAEliminarComboBox = new JComboBox<>();
        sedeAEliminarComboBox.setBounds(300, 30, 180, 25);

        eliminarButton = new JButton("Eliminar Sede");
        eliminarButton.setBounds(100, 70, 200, 40);
        eliminarButton.addActionListener(controlador);

        eliminarSedePanel.add(sedeAEliminarLabel);
        eliminarSedePanel.add(sedeAEliminarComboBox);
        eliminarSedePanel.add(eliminarButton);

        panel.add(crearSedePanel);
        panel.add(modificarSedePanel);
        panel.add(eliminarSedePanel);
    }
    
    /**
     * Actualizar seleccionables.
     *
     * @param sedesActuales the sedes actuales
     */
    public void actualizarSeleccionables(String[] sedesActuales) {
    	
    	empleadosField.setText("");
    	empleadosModField.setText("");
    	
    	ubicacionComboBox.setSelectedIndex(0);
    	
    	while (sedeAModificarComboBox.getItemCount() > 0)
    		sedeAModificarComboBox.removeItemAt(0);
    	
    	sedeAModificarComboBox.addItem("Selecciona Ubicación");
    	sedeAModificarComboBox.setSelectedIndex(0);
    	
    	while (sedeAEliminarComboBox.getItemCount() > 0)
    		sedeAEliminarComboBox.removeItemAt(0);
    	
    	sedeAEliminarComboBox.addItem("Selecciona Ubicación");
    	sedeAEliminarComboBox.setSelectedIndex(0);
    	
    	 for (int i = 0; i < sedesActuales.length; i++) {
    		 sedeAModificarComboBox.addItem(sedesActuales[i]);
    		 sedeAEliminarComboBox.addItem(sedesActuales[i]);
    	 }
    }

	/**
	 * Gets the ubicacion combo box.
	 *
	 * @return the ubicacion combo box
	 */
	public JComboBox<String> getUbicacionComboBox() {
		return ubicacionComboBox;
	}

	/**
	 * Sets the ubicacion combo box.
	 *
	 * @param ubicacionComboBox the new ubicacion combo box
	 */
	public void setUbicacionComboBox(JComboBox<String> ubicacionComboBox) {
		this.ubicacionComboBox = ubicacionComboBox;
	}

	/**
	 * Gets the empleados field.
	 *
	 * @return the empleados field
	 */
	public JTextField getEmpleadosField() {
		return empleadosField;
	}

	/**
	 * Sets the empleados field.
	 *
	 * @param empleadosField the new empleados field
	 */
	public void setEmpleadosField(JTextField empleadosField) {
		this.empleadosField = empleadosField;
	}

	/**
	 * Gets the crear button.
	 *
	 * @return the crear button
	 */
	public JButton getCrearButton() {
		return crearButton;
	}

	/**
	 * Sets the crear button.
	 *
	 * @param crearButton the new crear button
	 */
	public void setCrearButton(JButton crearButton) {
		this.crearButton = crearButton;
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
	 * Gets the eliminar button.
	 *
	 * @return the eliminar button
	 */
	public JButton getEliminarButton() {
		return eliminarButton;
	}

	/**
	 * Sets the eliminar button.
	 *
	 * @param eliminarButton the new eliminar button
	 */
	public void setEliminarButton(JButton eliminarButton) {
		this.eliminarButton = eliminarButton;
	}

	/**
	 * Gets the sede A eliminar combo box.
	 *
	 * @return the sede A eliminar combo box
	 */
	public JComboBox<String> getSedeAEliminarComboBox() {
		return sedeAEliminarComboBox;
	}

	/**
	 * Sets the sede A eliminar combo box.
	 *
	 * @param sedeAEliminarComboBox the new sede A eliminar combo box
	 */
	public void setSedeAEliminarComboBox(JComboBox<String> sedeAEliminarComboBox) {
		this.sedeAEliminarComboBox = sedeAEliminarComboBox;
	}

	/**
	 * Gets the sede A modificar combo box.
	 *
	 * @return the sede A modificar combo box
	 */
	public JComboBox<String> getSedeAModificarComboBox() {
		return sedeAModificarComboBox;
	}

	/**
	 * Sets the sede A modificar combo box.
	 *
	 * @param sedeAModificarComboBox the new sede A modificar combo box
	 */
	public void setSedeAModificarComboBox(JComboBox<String> sedeAModificarComboBox) {
		this.sedeAModificarComboBox = sedeAModificarComboBox;
	}

	/**
	 * Gets the empleados mod field.
	 *
	 * @return the empleados mod field
	 */
	public JTextField getEmpleadosModField() {
		return empleadosModField;
	}

	/**
	 * Sets the empleados mod field.
	 *
	 * @param empleadosModField the new empleados mod field
	 */
	public void setEmpleadosModField(JTextField empleadosModField) {
		this.empleadosModField = empleadosModField;
	}

    
}
