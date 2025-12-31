package co.edu.unbosque.view;

import co.edu.unbosque.controller.Controller;

import javax.swing.*;
import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaApuestaChance.
 */
public class VentanaApuestaChance extends JFrame {

    /** The crear apuesta panel. */
    // Componentes de la sección "Crear Apuesta"
	private JPanel crearApuestaPanel;
    
    /** The sede. */
    private JComboBox<String> sede;
    
    /** The cedula. */
    private JTextField cedula;
    
    /** The dia. */
    private JComboBox<String> dia;
    
    /** The valor apuesta. */
    private JTextField valorApuesta;
    
    /** The tipo de loteria. */
    private JComboBox<String> tipoDeLoteria;
    
    /** The numero 4 field. */
    private JTextField numero1Field, numero2Field, numero3Field, numero4Field;
    
    /** The crear button. */
    private JButton crearButton;

    /** The modificar apuesta panel. */
    // Componentes de la sección "Modificar Apuesta"
    private JPanel modificarApuestaPanel;
    
    /** The sede modificar. */
    private JComboBox<String> sedeModificar;
    
    /** The cedula modificar. */
    private JTextField cedulaModificar;
    
    /** The dia modificar. */
    private JComboBox<String> diaModificar;
    
    /** The valor apuesta modificar. */
    private JTextField valorApuestaModificar;
    
    /** The tipo de loteria modificar. */
    private JComboBox<String> tipoDeLoteriaModificar;
    
    /** The label numero 4 modificar. */
    private JLabel labelNumero1Modificar, labelNumero2Modificar, labelNumero3Modificar, labelNumero4Modificar;
    
    /** The numero 4 field modificar. */
    private JTextField numero1FieldModificar, numero2FieldModificar, numero3FieldModificar, numero4FieldModificar;
    
    /** The modificar button. */
    private JButton modificarButton;


	/** The leer apuesta panel. */
	// Componentes de la sección "Leer Apuesta"
    private JPanel leerApuestaPanel;
    
    /** The cedula leer. */
    private JTextField cedulaLeer;
    
    /** The dia leer. */
    private JComboBox<String> diaLeer;
    
    /** The leer button. */
    private JButton leerButton;
    

    /** The eliminar apuesta panel. */
    // Componentes de la sección "Eliminar Apuesta"
    private JPanel eliminarApuestaPanel;
    
    /** The label cedula eliminar. */
    private JLabel labelCedulaEliminar;
    
    /** The cedula eliminar. */
    private JTextField cedulaEliminar;
    
    /** The label dia eliminar. */
    private JLabel labelDiaEliminar;
    
    /** The dia eliminar. */
    private JComboBox<String> diaEliminar;
    
    /** The borrar button. */
    private JButton borrarButton;
    
    /** The label sede eliminar. */
    private JLabel labelSedeEliminar;
    
    /** The sede eliminar. */
    private JComboBox<String> sedeEliminar;
    

    /**
     * Instantiates a new ventana apuesta chance.
     *
     * @param controlador the controlador
     */
    public VentanaApuestaChance(Controller controlador) {
        setTitle("Apuesta Chance");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10)) {
        	@Override
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		Image fondo = new ImageIcon("fondo.jpg").getImage();
        		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        	}
        };
        setContentPane(panel);

        crearApuestaPanel = new JPanel();
        crearApuestaPanel.setBorder(BorderFactory.createTitledBorder("Crear Apuesta"));
        crearApuestaPanel.setLayout(null);

        // Componente para Sede
        sede = new JComboBox<String>();
        sede.setBounds(170, 20, 150, 25);
        crearApuestaPanel.add(new JLabel("Sede de la apuesta:"));
        crearApuestaPanel.add(sede);

        // Componente para Cédula
        cedula = new JTextField();
        cedula.setBounds(170, 50, 150, 25);
        crearApuestaPanel.add(new JLabel("Cédula del apostador:"));
        crearApuestaPanel.add(cedula);

        // Componente para Día
        String[] dias = {"Seleccionar día", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        dia = new JComboBox<>(dias);
        dia.setBounds(170, 80, 150, 25);
        crearApuestaPanel.add(new JLabel("Día de la apuesta:"));
        crearApuestaPanel.add(dia);

        // Componente para Tipo de Lotería
        String[] tiposLoteria = {"Seleccionar lotería", "Lotería de Bogotá", "Lotería de Boyacá", "Lotería del Cauca", "Lotería Cruz Roja",
            "Lotería de Cundinamarca", "Lotería del Huila", "Lotería de Manizales", "Lotería de Medellín",
            "Lotería del Meta", "Lotería del Quindío", "Lotería de Risaralda", "Lotería de Santander",
            "Lotería del Tolima", "Lotería del Valle"};
        tipoDeLoteria = new JComboBox<>(tiposLoteria);
        tipoDeLoteria.setBounds(170, 110, 150, 25);
        crearApuestaPanel.add(new JLabel("Tipo de Lotería:"));
        crearApuestaPanel.add(tipoDeLoteria);

        valorApuesta = new JTextField();
        valorApuesta.setBounds(170, 140, 150, 25);
        crearApuestaPanel.add(new JLabel("Valor de la Apuesta:"));
        crearApuestaPanel.add(valorApuesta);

        // Nuevos componentes para los 4 números de la apuesta
        numero1Field = new JTextField();
        numero1Field.setBounds(170, 200, 150, 25);
        crearApuestaPanel.add(new JLabel("Número 1:"));
        crearApuestaPanel.add(numero1Field);

        numero2Field = new JTextField();
        numero2Field.setBounds(170, 260, 150, 25);
        crearApuestaPanel.add(new JLabel("Número 2:"));
        crearApuestaPanel.add(numero2Field);

        numero3Field = new JTextField();
        numero3Field.setBounds(170, 320, 150, 25);
        crearApuestaPanel.add(new JLabel("Número 3:"));
        crearApuestaPanel.add(numero3Field);

        numero4Field = new JTextField();
        numero4Field.setBounds(170, 380, 150, 25);
        crearApuestaPanel.add(new JLabel("Número 4:"));
        crearApuestaPanel.add(numero4Field);

        // Componente para el botón "Crear"
        crearButton = new JButton("Crear apuesta");
        crearButton.setBounds(170, 410, 150, 30);
        crearButton.addActionListener(controlador);
        crearApuestaPanel.add(new JLabel());
        crearApuestaPanel.add(crearButton);

     // Componente para Sede
        sede.setBounds(170, 20, 150, 25);
        crearApuestaPanel.add(new JLabel("Sede de la apuesta:")).setBounds(20, 20, 150, 25);

        // Componente para Cédula
        cedula.setBounds(170, 50, 150, 25);
        crearApuestaPanel.add(new JLabel("Cédula del apostador:")).setBounds(20, 50, 150, 25);

        // Componente para Día
        dia.setBounds(170, 80, 150, 25);
        crearApuestaPanel.add(new JLabel("Día de la apuesta:")).setBounds(20, 80, 150, 25);

        // Componente para Tipo de Lotería
        tipoDeLoteria.setBounds(170, 110, 150, 25);
        crearApuestaPanel.add(new JLabel("Tipo de Lotería:")).setBounds(20, 110, 150, 25);

        // Componente para Valor de la Apuesta
        valorApuesta.setBounds(170, 140, 150, 25);
        crearApuestaPanel.add(new JLabel("Valor de la Apuesta:")).setBounds(20, 140, 150, 25);

        crearApuestaPanel.add(new JLabel("1:")).setBounds(20, 170, 20, 25);
        numero1Field.setBounds(45, 170, 80, 25);
        crearApuestaPanel.add(numero1Field);

        crearApuestaPanel.add(new JLabel("2:")).setBounds(130, 170, 20, 25);
        numero2Field.setBounds(155, 170, 80, 25);
        crearApuestaPanel.add(numero2Field);

        // Ubicar los campos de los números 3 y 4 centrados en la parte inferior
        crearApuestaPanel.add(new JLabel("3:")).setBounds(20, 210, 20, 25);
        numero3Field.setBounds(45, 210, 80, 25);
        crearApuestaPanel.add(numero3Field);

        crearApuestaPanel.add(new JLabel("4:")).setBounds(130, 210, 20, 25);
        numero4Field.setBounds(155, 210, 80, 25);
        crearApuestaPanel.add(numero4Field);

        // Componente para el botón "Crear"
        crearButton.setBounds(250, 180, 120, 30);
        crearApuestaPanel.add(crearButton);
        
        panel.add(crearApuestaPanel);



        modificarApuestaPanel = new JPanel();
        modificarApuestaPanel.setBorder(BorderFactory.createTitledBorder("Modificar Apuesta"));
        modificarApuestaPanel.setLayout(null);
        
        numero1FieldModificar = new JTextField();
        numero1FieldModificar.setBounds(45, 170, 80, 25);
        modificarApuestaPanel.add(numero1FieldModificar);

        numero2FieldModificar = new JTextField();
        numero2FieldModificar.setBounds(155, 170, 80, 25);
        modificarApuestaPanel.add(numero2FieldModificar);

        numero3FieldModificar = new JTextField();
        numero3FieldModificar.setBounds(45, 210, 80, 25);
        modificarApuestaPanel.add(numero3FieldModificar);

        numero4FieldModificar = new JTextField();
        numero4FieldModificar.setBounds(155, 210, 80, 25);
        modificarApuestaPanel.add(numero4FieldModificar);

        // Labels para los 4 números de la apuesta en Modificar Apuesta
        modificarApuestaPanel.add(new JLabel("1:")).setBounds(20, 170, 20, 25);
        modificarApuestaPanel.add(new JLabel("2:")).setBounds(130, 170, 20, 25);
        modificarApuestaPanel.add(new JLabel("3:")).setBounds(20, 210, 20, 25);
        modificarApuestaPanel.add(new JLabel("4:")).setBounds(130, 210, 20, 25);

        // Componente para Sede (Modificar)
        sedeModificar = new JComboBox<>();
        sedeModificar.setBounds(170, 20, 150, 25);
        modificarApuestaPanel.add(new JLabel("Sede de la apuesta:")).setBounds(20, 20, 150, 25);
        modificarApuestaPanel.add(sedeModificar);

        // Componente para Cédula (Modificar)
        cedulaModificar = new JTextField();
        cedulaModificar.setBounds(170, 50, 150, 25);
        modificarApuestaPanel.add(new JLabel("Cédula del apostador:")).setBounds(20, 50, 150, 25);
        modificarApuestaPanel.add(cedulaModificar);

        // Componente para Día (Modificar)
        String[] diasModificar = {"Seleccionar día", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        diaModificar = new JComboBox<>(diasModificar);
        diaModificar.setBounds(170, 80, 150, 25);
        modificarApuestaPanel.add(new JLabel("Día de la apuesta:")).setBounds(20, 80, 150, 25);
        modificarApuestaPanel.add(diaModificar);

        // Componente para Tipo de Lotería (Modificar)
        String[] tiposLoteriaModificar = {"Seleccionar lotería", "Lotería de Bogotá", "Lotería de Boyacá", "Lotería del Cauca", "Lotería Cruz Roja",
            "Lotería de Cundinamarca", "Lotería del Huila", "Lotería de Manizales", "Lotería de Medellín",
            "Lotería del Meta", "Lotería del Quindío", "Lotería de Risaralda", "Lotería de Santander",
            "Lotería del Tolima", "Lotería del Valle"};
        tipoDeLoteriaModificar = new JComboBox<>(tiposLoteriaModificar);
        tipoDeLoteriaModificar.setBounds(170, 110, 150, 25);
        modificarApuestaPanel.add(new JLabel("Tipo de Lotería:")).setBounds(20, 110, 150, 25);
        modificarApuestaPanel.add(tipoDeLoteriaModificar);

        valorApuestaModificar = new JTextField();
        valorApuestaModificar.setBounds(170, 140, 150, 25);
        modificarApuestaPanel.add(new JLabel("Valor de la Apuesta:")).setBounds(20, 140, 150, 25);
        modificarApuestaPanel.add(valorApuestaModificar);

        // Componente para el botón "Modificar"
        modificarButton = new JButton("Modificar apuesta");
        modificarButton.setBounds(240, 185, 140, 30);
        modificarButton.addActionListener(controlador);
        modificarApuestaPanel.add(modificarButton);

        panel.add(modificarApuestaPanel);


        leerApuestaPanel = new JPanel();
        leerApuestaPanel.setBorder(BorderFactory.createTitledBorder("Leer Apuesta"));
        leerApuestaPanel.setLayout(new GridLayout(4, 2, 10, 10)); // Ajustar el GridLayout según la cantidad de componentes

        // Componente para Cédula a Leer
        cedulaLeer = new JTextField();
        leerApuestaPanel.add(new JLabel("Ingrese la cédula del apostador:"));
        leerApuestaPanel.add(cedulaLeer);

        // Componente para Día a Leer
        String[] diasLeer = {"Seleccionar día", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        diaLeer = new JComboBox<>(diasLeer);
        leerApuestaPanel.add(new JLabel("Seleccione el día de la apuesta:"));
        leerApuestaPanel.add(diaLeer);

        // Componente para el botón "Leer"
        leerButton = new JButton("Leer apuesta");
        leerButton.addActionListener(controlador);
        leerApuestaPanel.add(new JLabel());
        leerApuestaPanel.add(leerButton);

        
        
        eliminarApuestaPanel = new JPanel();
        eliminarApuestaPanel.setBorder(BorderFactory.createTitledBorder("Eliminar Apuesta"));
        eliminarApuestaPanel.setLayout(null);

        labelCedulaEliminar = new JLabel("Cedula del apostador:");
        labelCedulaEliminar.setBounds(20, 20, 150, 25);
        eliminarApuestaPanel.add(labelCedulaEliminar);

        cedulaEliminar = new JTextField();
        cedulaEliminar.setBounds(170, 20, 150, 25);
        eliminarApuestaPanel.add(cedulaEliminar);

        labelSedeEliminar = new JLabel("Sede de la apuesta:");
        labelSedeEliminar.setBounds(20, 60, 150, 25);
        eliminarApuestaPanel.add(labelSedeEliminar);

        sedeEliminar = new JComboBox<>();
        sedeEliminar.setBounds(170, 60, 150, 25);
        eliminarApuestaPanel.add(sedeEliminar);

        // JLabel para "Dia de la Apuesta" - Nuevo componente
        labelDiaEliminar = new JLabel("Dia de la Apuesta:");
        labelDiaEliminar.setBounds(20, 100, 150, 25);
        eliminarApuestaPanel.add(labelDiaEliminar);

        String[] diasEliminar = {"Seleccionar día", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        diaEliminar = new JComboBox<>(diasEliminar);
        diaEliminar.setBounds(170, 100, 150, 25);
        eliminarApuestaPanel.add(diaEliminar);

        borrarButton = new JButton("Borrar apuesta");
        borrarButton.setBounds(20 , 140, 150, 30);
        borrarButton.addActionListener(controlador);
        eliminarApuestaPanel.add(borrarButton);

        panel.add(eliminarApuestaPanel);
        
        
        
        panel.add(leerApuestaPanel);
        panel.add(eliminarApuestaPanel);

    }
    
    
    /**
     * Reiniciar campos.
     *
     * @param sedesActuales the sedes actuales
     */
    public void reiniciarCampos(String[] sedesActuales) {
        
    	// Reiniciar seleccion apuesta a crear
    	while (sede.getItemCount() > 0)
    		sede.removeItemAt(0);
    	sede.addItem("Seleccione sede");
    	
    	// Reiniciar seleccion seccion apuesta a modificar
        while (sedeModificar.getItemCount() > 0)
        	sedeModificar.removeItemAt(0);
    	sedeModificar.addItem("Seleccionar sede");
        
        // Reiniciar seleccion seccion apuesta 
        while (sedeEliminar.getItemCount() > 0)
        	sedeEliminar.removeItemAt(0);
        sedeEliminar.addItem("Seleccionar sede");
        
    	for (int i = 0; i < sedesActuales.length; i++) {
    		sede.addItem(sedesActuales[i]);
    		sedeModificar.addItem(sedesActuales[i]);
    		sedeEliminar.addItem(sedesActuales[i]);
    	}
    		
    	
    	// Reiniciar campos de la sección "Crear Apuesta"
        cedula.setText(""); // Reiniciar campo cedula
        dia.setSelectedIndex(0); // Reiniciar JComboBox dia seleccionándolo en el primer item
        valorApuesta.setText(""); // Reiniciar campo valorApuesta
        tipoDeLoteria.setSelectedIndex(0); // Reiniciar JComboBox tipoDeLoteria seleccionándolo en el primer ítem
        numero1Field.setText("");
        numero2Field.setText("");
        numero3Field.setText("");
        numero4Field.setText("");
        
        
        // Reiniciar campos de la sección "Modificar Apuesta"
        cedulaModificar.setText(""); // Reiniciar campo cedulaModificar
        diaModificar.setSelectedIndex(0); // Reiniciar JComboBox diaModificar seleccionándolo en el primer item
        valorApuestaModificar.setText(""); // Reiniciar campo valorApuestaModificar
        tipoDeLoteriaModificar.setSelectedIndex(0); // Reiniciar JComboBox tipoDeLoteriaModificar seleccionándolo en el primer ítem
        sedeModificar.setSelectedIndex(0);
        cedulaModificar.setText("");
        diaModificar.setSelectedIndex(0);
        valorApuestaModificar.setText("");
        numero1FieldModificar.setText("");
        numero2FieldModificar.setText("");
        numero3FieldModificar.setText("");
        numero4FieldModificar.setText("");
        
        // Reiniciar campos de la sección "Leer Apuesta"
        cedulaLeer.setText("");
        diaLeer.setSelectedIndex(0);
        
        // Reiniciar campos de la sección "Eliminar Apuesta"
        cedulaEliminar.setText("");
        sedeEliminar.setSelectedIndex(0);
        diaEliminar.setSelectedIndex(0);
        
    }


	/**
	 * Gets the crear apuesta panel.
	 *
	 * @return the crear apuesta panel
	 */
	public JPanel getCrearApuestaPanel() {
		return crearApuestaPanel;
	}


	/**
	 * Sets the crear apuesta panel.
	 *
	 * @param crearApuestaPanel the new crear apuesta panel
	 */
	public void setCrearApuestaPanel(JPanel crearApuestaPanel) {
		this.crearApuestaPanel = crearApuestaPanel;
	}


	/**
	 * Gets the sede.
	 *
	 * @return the sede
	 */
	public JComboBox<String> getSede() {
		return sede;
	}


	/**
	 * Sets the sede.
	 *
	 * @param sede the new sede
	 */
	public void setSede(JComboBox<String> sede) {
		this.sede = sede;
	}


	/**
	 * Gets the cedula.
	 *
	 * @return the cedula
	 */
	public JTextField getCedula() {
		return cedula;
	}


	/**
	 * Sets the cedula.
	 *
	 * @param cedula the new cedula
	 */
	public void setCedula(JTextField cedula) {
		this.cedula = cedula;
	}


	/**
	 * Gets the dia.
	 *
	 * @return the dia
	 */
	public JComboBox<String> getDia() {
		return dia;
	}


	/**
	 * Sets the dia.
	 *
	 * @param dia the new dia
	 */
	public void setDia(JComboBox<String> dia) {
		this.dia = dia;
	}


	/**
	 * Gets the valor apuesta.
	 *
	 * @return the valor apuesta
	 */
	public JTextField getValorApuesta() {
		return valorApuesta;
	}


	/**
	 * Sets the valor apuesta.
	 *
	 * @param valorApuesta the new valor apuesta
	 */
	public void setValorApuesta(JTextField valorApuesta) {
		this.valorApuesta = valorApuesta;
	}


	/**
	 * Gets the tipo de loteria.
	 *
	 * @return the tipo de loteria
	 */
	public JComboBox<String> getTipoDeLoteria() {
		return tipoDeLoteria;
	}


	/**
	 * Sets the tipo de loteria.
	 *
	 * @param tipoDeLoteria the new tipo de loteria
	 */
	public void setTipoDeLoteria(JComboBox<String> tipoDeLoteria) {
		this.tipoDeLoteria = tipoDeLoteria;
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
	 * Gets the modificar apuesta panel.
	 *
	 * @return the modificar apuesta panel
	 */
	public JPanel getModificarApuestaPanel() {
		return modificarApuestaPanel;
	}


	/**
	 * Sets the modificar apuesta panel.
	 *
	 * @param modificarApuestaPanel the new modificar apuesta panel
	 */
	public void setModificarApuestaPanel(JPanel modificarApuestaPanel) {
		this.modificarApuestaPanel = modificarApuestaPanel;
	}


	/**
	 * Gets the sede modificar.
	 *
	 * @return the sede modificar
	 */
	public JComboBox<String> getSedeModificar() {
		return sedeModificar;
	}


	/**
	 * Sets the sede modificar.
	 *
	 * @param sedeModificar the new sede modificar
	 */
	public void setSedeModificar(JComboBox<String> sedeModificar) {
		this.sedeModificar = sedeModificar;
	}


	/**
	 * Gets the cedula modificar.
	 *
	 * @return the cedula modificar
	 */
	public JTextField getCedulaModificar() {
		return cedulaModificar;
	}


	/**
	 * Sets the cedula modificar.
	 *
	 * @param cedulaModificar the new cedula modificar
	 */
	public void setCedulaModificar(JTextField cedulaModificar) {
		this.cedulaModificar = cedulaModificar;
	}


	/**
	 * Gets the dia modificar.
	 *
	 * @return the dia modificar
	 */
	public JComboBox<String> getDiaModificar() {
		return diaModificar;
	}


	/**
	 * Sets the dia modificar.
	 *
	 * @param diaModificar the new dia modificar
	 */
	public void setDiaModificar(JComboBox<String> diaModificar) {
		this.diaModificar = diaModificar;
	}


	/**
	 * Gets the valor apuesta modificar.
	 *
	 * @return the valor apuesta modificar
	 */
	public JTextField getValorApuestaModificar() {
		return valorApuestaModificar;
	}


	/**
	 * Sets the valor apuesta modificar.
	 *
	 * @param valorApuestaModificar the new valor apuesta modificar
	 */
	public void setValorApuestaModificar(JTextField valorApuestaModificar) {
		this.valorApuestaModificar = valorApuestaModificar;
	}


	/**
	 * Gets the tipo de loteria modificar.
	 *
	 * @return the tipo de loteria modificar
	 */
	public JComboBox<String> getTipoDeLoteriaModificar() {
		return tipoDeLoteriaModificar;
	}


	/**
	 * Sets the tipo de loteria modificar.
	 *
	 * @param tipoDeLoteriaModificar the new tipo de loteria modificar
	 */
	public void setTipoDeLoteriaModificar(JComboBox<String> tipoDeLoteriaModificar) {
		this.tipoDeLoteriaModificar = tipoDeLoteriaModificar;
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
	 * Gets the leer apuesta panel.
	 *
	 * @return the leer apuesta panel
	 */
	public JPanel getLeerApuestaPanel() {
		return leerApuestaPanel;
	}


	/**
	 * Sets the leer apuesta panel.
	 *
	 * @param leerApuestaPanel the new leer apuesta panel
	 */
	public void setLeerApuestaPanel(JPanel leerApuestaPanel) {
		this.leerApuestaPanel = leerApuestaPanel;
	}


	/**
	 * Gets the cedula leer.
	 *
	 * @return the cedula leer
	 */
	public JTextField getCedulaLeer() {
		return cedulaLeer;
	}


	/**
	 * Sets the cedula leer.
	 *
	 * @param cedulaLeer the new cedula leer
	 */
	public void setCedulaLeer(JTextField cedulaLeer) {
		this.cedulaLeer = cedulaLeer;
	}


	/**
	 * Gets the dia leer.
	 *
	 * @return the dia leer
	 */
	public JComboBox<String> getDiaLeer() {
		return diaLeer;
	}


	/**
	 * Sets the dia leer.
	 *
	 * @param diaLeer the new dia leer
	 */
	public void setDiaLeer(JComboBox<String> diaLeer) {
		this.diaLeer = diaLeer;
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
	 * Gets the eliminar apuesta panel.
	 *
	 * @return the eliminar apuesta panel
	 */
	public JPanel getEliminarApuestaPanel() {
		return eliminarApuestaPanel;
	}


	/**
	 * Sets the eliminar apuesta panel.
	 *
	 * @param eliminarApuestaPanel the new eliminar apuesta panel
	 */
	public void setEliminarApuestaPanel(JPanel eliminarApuestaPanel) {
		this.eliminarApuestaPanel = eliminarApuestaPanel;
	}


	/**
	 * Gets the label cedula eliminar.
	 *
	 * @return the label cedula eliminar
	 */
	public JLabel getLabelCedulaEliminar() {
		return labelCedulaEliminar;
	}


	/**
	 * Sets the label cedula eliminar.
	 *
	 * @param labelCedulaEliminar the new label cedula eliminar
	 */
	public void setLabelCedulaEliminar(JLabel labelCedulaEliminar) {
		this.labelCedulaEliminar = labelCedulaEliminar;
	}


	/**
	 * Gets the cedula eliminar.
	 *
	 * @return the cedula eliminar
	 */
	public JTextField getCedulaEliminar() {
		return cedulaEliminar;
	}


	/**
	 * Sets the cedula eliminar.
	 *
	 * @param cedulaEliminar the new cedula eliminar
	 */
	public void setCedulaEliminar(JTextField cedulaEliminar) {
		this.cedulaEliminar = cedulaEliminar;
	}


	/**
	 * Gets the label dia eliminar.
	 *
	 * @return the label dia eliminar
	 */
	public JLabel getLabelDiaEliminar() {
		return labelDiaEliminar;
	}


	/**
	 * Sets the label dia eliminar.
	 *
	 * @param labelDiaEliminar the new label dia eliminar
	 */
	public void setLabelDiaEliminar(JLabel labelDiaEliminar) {
		this.labelDiaEliminar = labelDiaEliminar;
	}


	/**
	 * Gets the dia eliminar.
	 *
	 * @return the dia eliminar
	 */
	public JComboBox<String> getDiaEliminar() {
		return diaEliminar;
	}


	/**
	 * Sets the dia eliminar.
	 *
	 * @param diaEliminar the new dia eliminar
	 */
	public void setDiaEliminar(JComboBox<String> diaEliminar) {
		this.diaEliminar = diaEliminar;
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
	 * Gets the label sede eliminar.
	 *
	 * @return the label sede eliminar
	 */
	public JLabel getLabelSedeEliminar() {
		return labelSedeEliminar;
	}


	/**
	 * Sets the label sede eliminar.
	 *
	 * @param labelSedeEliminar the new label sede eliminar
	 */
	public void setLabelSedeEliminar(JLabel labelSedeEliminar) {
		this.labelSedeEliminar = labelSedeEliminar;
	}


	/**
	 * Gets the sede eliminar.
	 *
	 * @return the sede eliminar
	 */
	public JComboBox<String> getSedeEliminar() {
		return sedeEliminar;
	}


	/**
	 * Sets the sede eliminar.
	 *
	 * @param sedeEliminar the new sede eliminar
	 */
	public void setSedeEliminar(JComboBox<String> sedeEliminar) {
		this.sedeEliminar = sedeEliminar;
	}
	 
 	/**
 	 * Gets the numero 1 field.
 	 *
 	 * @return the numero 1 field
 	 */
 	public JTextField getNumero1Field() {
			return numero1Field;
		}


		/**
		 * Sets the numero 1 field.
		 *
		 * @param numero1Field the new numero 1 field
		 */
		public void setNumero1Field(JTextField numero1Field) {
			this.numero1Field = numero1Field;
		}


		/**
		 * Gets the numero 2 field.
		 *
		 * @return the numero 2 field
		 */
		public JTextField getNumero2Field() {
			return numero2Field;
		}


		/**
		 * Sets the numero 2 field.
		 *
		 * @param numero2Field the new numero 2 field
		 */
		public void setNumero2Field(JTextField numero2Field) {
			this.numero2Field = numero2Field;
		}


		/**
		 * Gets the numero 3 field.
		 *
		 * @return the numero 3 field
		 */
		public JTextField getNumero3Field() {
			return numero3Field;
		}


		/**
		 * Sets the numero 3 field.
		 *
		 * @param numero3Field the new numero 3 field
		 */
		public void setNumero3Field(JTextField numero3Field) {
			this.numero3Field = numero3Field;
		}


		/**
		 * Gets the numero 4 field.
		 *
		 * @return the numero 4 field
		 */
		public JTextField getNumero4Field() {
			return numero4Field;
		}


		/**
		 * Sets the numero 4 field.
		 *
		 * @param numero4Field the new numero 4 field
		 */
		public void setNumero4Field(JTextField numero4Field) {
			this.numero4Field = numero4Field;
		}


		/**
		 * Gets the label numero 1 modificar.
		 *
		 * @return the label numero 1 modificar
		 */
		public JLabel getLabelNumero1Modificar() {
			return labelNumero1Modificar;
		}


		/**
		 * Sets the label numero 1 modificar.
		 *
		 * @param labelNumero1Modificar the new label numero 1 modificar
		 */
		public void setLabelNumero1Modificar(JLabel labelNumero1Modificar) {
			this.labelNumero1Modificar = labelNumero1Modificar;
		}


		/**
		 * Gets the label numero 2 modificar.
		 *
		 * @return the label numero 2 modificar
		 */
		public JLabel getLabelNumero2Modificar() {
			return labelNumero2Modificar;
		}


		/**
		 * Sets the label numero 2 modificar.
		 *
		 * @param labelNumero2Modificar the new label numero 2 modificar
		 */
		public void setLabelNumero2Modificar(JLabel labelNumero2Modificar) {
			this.labelNumero2Modificar = labelNumero2Modificar;
		}


		/**
		 * Gets the label numero 3 modificar.
		 *
		 * @return the label numero 3 modificar
		 */
		public JLabel getLabelNumero3Modificar() {
			return labelNumero3Modificar;
		}


		/**
		 * Sets the label numero 3 modificar.
		 *
		 * @param labelNumero3Modificar the new label numero 3 modificar
		 */
		public void setLabelNumero3Modificar(JLabel labelNumero3Modificar) {
			this.labelNumero3Modificar = labelNumero3Modificar;
		}


		/**
		 * Gets the label numero 4 modificar.
		 *
		 * @return the label numero 4 modificar
		 */
		public JLabel getLabelNumero4Modificar() {
			return labelNumero4Modificar;
		}


		/**
		 * Sets the label numero 4 modificar.
		 *
		 * @param labelNumero4Modificar the new label numero 4 modificar
		 */
		public void setLabelNumero4Modificar(JLabel labelNumero4Modificar) {
			this.labelNumero4Modificar = labelNumero4Modificar;
		}


		/**
		 * Gets the numero 1 field modificar.
		 *
		 * @return the numero 1 field modificar
		 */
		public JTextField getNumero1FieldModificar() {
			return numero1FieldModificar;
		}


		/**
		 * Sets the numero 1 field modificar.
		 *
		 * @param numero1FieldModificar the new numero 1 field modificar
		 */
		public void setNumero1FieldModificar(JTextField numero1FieldModificar) {
			this.numero1FieldModificar = numero1FieldModificar;
		}


		/**
		 * Gets the numero 2 field modificar.
		 *
		 * @return the numero 2 field modificar
		 */
		public JTextField getNumero2FieldModificar() {
			return numero2FieldModificar;
		}


		/**
		 * Sets the numero 2 field modificar.
		 *
		 * @param numero2FieldModificar the new numero 2 field modificar
		 */
		public void setNumero2FieldModificar(JTextField numero2FieldModificar) {
			this.numero2FieldModificar = numero2FieldModificar;
		}


		/**
		 * Gets the numero 3 field modificar.
		 *
		 * @return the numero 3 field modificar
		 */
		public JTextField getNumero3FieldModificar() {
			return numero3FieldModificar;
		}


		/**
		 * Sets the numero 3 field modificar.
		 *
		 * @param numero3FieldModificar the new numero 3 field modificar
		 */
		public void setNumero3FieldModificar(JTextField numero3FieldModificar) {
			this.numero3FieldModificar = numero3FieldModificar;
		}


		/**
		 * Gets the numero 4 field modificar.
		 *
		 * @return the numero 4 field modificar
		 */
		public JTextField getNumero4FieldModificar() {
			return numero4FieldModificar;
		}


		/**
		 * Sets the numero 4 field modificar.
		 *
		 * @param numero4FieldModificar the new numero 4 field modificar
		 */
		public void setNumero4FieldModificar(JTextField numero4FieldModificar) {
			this.numero4FieldModificar = numero4FieldModificar;
		}

	
}
