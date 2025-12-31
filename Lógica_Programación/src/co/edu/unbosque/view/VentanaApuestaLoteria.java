package co.edu.unbosque.view;

import co.edu.unbosque.controller.Controller;

import javax.swing.*;
import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaApuestaLoteria.
 */
public class VentanaApuestaLoteria extends JFrame {

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
    
    /** The numero loteria. */
    private JTextField numeroLoteria;
    
    /** The serie loteria. */
    private JTextField serieLoteria;
    
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
    
    /** The numero loteria modificar. */
    private JTextField numeroLoteriaModificar;
    
    /** The serie loteria modificar. */
    private JTextField serieLoteriaModificar;
    
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
     * Instantiates a new ventana apuesta loteria.
     *
     * @param controlador the controlador
     */
    public VentanaApuestaLoteria(Controller controlador) {
        setTitle("Apuesta Lotería");
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
        crearApuestaPanel.setLayout(new GridLayout(8, 2, 10, 10));

        // Componente para Sede
        sede = new JComboBox<String>();
        crearApuestaPanel.add(new JLabel("Sede de la apuesta:"));
        crearApuestaPanel.add(sede);

        // Componente para Cédula
        cedula = new JTextField();
        crearApuestaPanel.add(new JLabel("Cédula del apostador:"));
        crearApuestaPanel.add(cedula);

        // Componente para Día
        String[] dias = {"Seleccionar día", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        dia = new JComboBox<>(dias);
        crearApuestaPanel.add(new JLabel("Día de la apuesta:"));
        crearApuestaPanel.add(dia);

        // Componente para Número de la Lotería
        numeroLoteria = new JTextField();
        crearApuestaPanel.add(new JLabel("Número de la Lotería:"));
        crearApuestaPanel.add(numeroLoteria);

        // Componente para Tipo de Lotería
        String[] tiposLoteria = {"Seleccionar lotería", "Lotería de Bogotá", "Lotería de Boyacá", "Lotería del Cauca", "Lotería Cruz Roja",
            "Lotería de Cundinamarca", "Lotería del Huila", "Lotería de Manizales", "Lotería de Medellín",
            "Lotería del Meta", "Lotería del Quindío", "Lotería de Risaralda", "Lotería de Santander",
            "Lotería del Tolima", "Lotería del Valle"};
        tipoDeLoteria = new JComboBox<>(tiposLoteria);
        crearApuestaPanel.add(new JLabel("Tipo de Lotería:"));
        crearApuestaPanel.add(tipoDeLoteria);

        // Componente para Valor de la Apuesta
        valorApuesta = new JTextField();
        crearApuestaPanel.add(new JLabel("Valor de la Apuesta:"));
        crearApuestaPanel.add(valorApuesta);

        // Componente para Serie de la Lotería
        serieLoteria = new JTextField();
        crearApuestaPanel.add(new JLabel("Serie de la Lotería:"));
        crearApuestaPanel.add(serieLoteria);

        // Componente para el botón "Crear"
        crearButton = new JButton("Crear apuesta");
        crearButton.addActionListener(controlador);
        crearApuestaPanel.add(new JLabel());
        crearApuestaPanel.add(crearButton);

        panel.add(crearApuestaPanel);




        modificarApuestaPanel = new JPanel();
        modificarApuestaPanel.setBorder(BorderFactory.createTitledBorder("Modificar Apuesta"));
        modificarApuestaPanel.setLayout(new GridLayout(8, 2, 10, 10)); // Ajusta el GridLayout según la cantidad de componentes que tengas

	
	     // Inicialización de componentes para la sección "Modificar Apuesta"
	     sedeModificar = new JComboBox<>();
	     modificarApuestaPanel.add(new JLabel("Sede de la apuesta:"));
	     modificarApuestaPanel.add(sedeModificar);
	
	     cedulaModificar = new JTextField();
	     modificarApuestaPanel.add(new JLabel("Cédula del apostador:"));
	     modificarApuestaPanel.add(cedulaModificar);
	
	     // Componente para Día (Modificar)
	     String[] diasModificar = {"Seleccionar día", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
	     diaModificar = new JComboBox<>(diasModificar);
	     modificarApuestaPanel.add(new JLabel("Día de la apuesta:"));
	     modificarApuestaPanel.add(diaModificar);
	
	     numeroLoteriaModificar = new JTextField();
	     modificarApuestaPanel.add(new JLabel("Número de la Lotería:"));
	     modificarApuestaPanel.add(numeroLoteriaModificar);
	
	     // Componente para Tipo de Lotería (Modificar)
	     String[] tiposLoteriaModificar = {"Seleccionar lotería", "Lotería de Bogotá", "Lotería de Boyacá", "Lotería del Cauca", "Lotería Cruz Roja",
	             "Lotería de Cundinamarca", "Lotería del Huila", "Lotería de Manizales", "Lotería de Medellín",
	             "Lotería del Meta", "Lotería del Quindío", "Lotería de Risaralda", "Lotería de Santander",
	             "Lotería del Tolima", "Lotería del Valle"};
	     tipoDeLoteriaModificar = new JComboBox<>(tiposLoteriaModificar);
	     modificarApuestaPanel.add(new JLabel("Tipo de Lotería:"));
	     modificarApuestaPanel.add(tipoDeLoteriaModificar);
	
	     valorApuestaModificar = new JTextField();
	     modificarApuestaPanel.add(new JLabel("Valor de la Apuesta:"));
	     modificarApuestaPanel.add(valorApuestaModificar);
	
	     serieLoteriaModificar = new JTextField();
	     modificarApuestaPanel.add(new JLabel("Serie de la Lotería:"));
	     modificarApuestaPanel.add(serieLoteriaModificar);
	
	     modificarButton = new JButton("Modificar apuesta");
	     modificarButton.addActionListener(controlador);
	     modificarApuestaPanel.add(new JLabel());
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
    		
    	
        cedula.setText(""); // Reiniciar campo cedula
        dia.setSelectedIndex(0); // Reiniciar JComboBox dia seleccionándolo en el primer item
        valorApuesta.setText(""); // Reiniciar campo valorApuesta
        tipoDeLoteria.setSelectedIndex(0); // Reiniciar JComboBox tipoDeLoteria seleccionándolo en el primer ítem
        numeroLoteria.setText(""); // Reiniciar campo numeroLoteria
        serieLoteria.setText(""); // Reiniciar campo serie
        
        
        // Reiniciar campos de la sección "Modificar Apuesta"
        cedulaModificar.setText(""); // Reiniciar campo cedulaModificar
        diaModificar.setSelectedIndex(0); // Reiniciar JComboBox diaModificar seleccionándolo en el primer item
        valorApuestaModificar.setText(""); // Reiniciar campo valorApuestaModificar
        tipoDeLoteriaModificar.setSelectedIndex(0); // Reiniciar JComboBox tipoDeLoteriaModificar seleccionándolo en el primer ítem
        numeroLoteriaModificar.setText(""); // Reiniciar campo numeroLoteriaModificar
        serieLoteriaModificar.setText(""); // Reiniciar campo serieLoteriaModificar
        
        // Reiniciar campos de la sección "Eliminar Apuesta"
        cedulaEliminar.setText("");
        sedeEliminar.setSelectedIndex(0);
        diaEliminar.setSelectedIndex(0);
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
	 * Gets the numero loteria.
	 *
	 * @return the numero loteria
	 */
	public JTextField getNumeroLoteria() {
		return numeroLoteria;
	}

	/**
	 * Sets the numero loteria.
	 *
	 * @param numeroLoteria the new numero loteria
	 */
	public void setNumeroLoteria(JTextField numeroLoteria) {
		this.numeroLoteria = numeroLoteria;
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
	 * Gets the serie loteria.
	 *
	 * @return the serie loteria
	 */
	public JTextField getSerieLoteria() {
		return serieLoteria;
	}


	/**
	 * Sets the serie loteria.
	 *
	 * @param serieLoteria the new serie loteria
	 */
	public void setSerieLoteria(JTextField serieLoteria) {
		this.serieLoteria = serieLoteria;
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
	 * Gets the numero loteria modificar.
	 *
	 * @return the numero loteria modificar
	 */
	public JTextField getNumeroLoteriaModificar() {
		return numeroLoteriaModificar;
	}


	/**
	 * Sets the numero loteria modificar.
	 *
	 * @param numeroLoteriaModificar the new numero loteria modificar
	 */
	public void setNumeroLoteriaModificar(JTextField numeroLoteriaModificar) {
		this.numeroLoteriaModificar = numeroLoteriaModificar;
	}


	/**
	 * Gets the serie loteria modificar.
	 *
	 * @return the serie loteria modificar
	 */
	public JTextField getSerieLoteriaModificar() {
		return serieLoteriaModificar;
	}


	/**
	 * Sets the serie loteria modificar.
	 *
	 * @param serieLoteriaModificar the new serie loteria modificar
	 */
	public void setSerieLoteriaModificar(JTextField serieLoteriaModificar) {
		this.serieLoteriaModificar = serieLoteriaModificar;
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
	
}
