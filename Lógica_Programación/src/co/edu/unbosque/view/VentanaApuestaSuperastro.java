package co.edu.unbosque.view;

import co.edu.unbosque.controller.Controller;

import javax.swing.*;
import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaApuestaSuperastro.
 */
public class VentanaApuestaSuperastro extends JFrame {

	/** The panel. */
	private JPanel panel;
    
    /** The label signo zodiaco. */
    private JLabel labelNumero1, labelNumero2, labelNumero3, labelNumero4, labelSignoZodiaco;
    
    /** The sede combo box crear. */
    private JComboBox<String> sedeComboBoxCrear;
    
    /** The cedula field crear. */
    private JTextField cedulaFieldCrear;
    
    /** The dia combo box crear. */
    private JComboBox<String> diaComboBoxCrear;
    
    /** The valor apuesta field crear. */
    private JTextField valorApuestaFieldCrear;
    
    /** The numero 4 field. */
    private JTextField numero1Field, numero2Field, numero3Field, numero4Field;
    
    /** The signo zodiaco combo box. */
    private JComboBox<String> signoZodiacoComboBox;
    
    /** The crear button. */
    private JButton crearButton;
    
    /** The label valor apuesta modificar. */
    private JLabel labelSedeModificar, labelCedulaModificar, labelDiaModificar, labelValorApuestaModificar;
    
    /** The label numero 4 modificar. */
    private JLabel labelNumero1Modificar, labelNumero2Modificar, labelNumero3Modificar, labelNumero4Modificar;
    
    /** The label signo zodiaco modificar. */
    private JLabel labelSignoZodiacoModificar;
    
    /** The valor apuesta field modificar. */
    private JTextField cedulaFieldModificar, valorApuestaFieldModificar;
    
    /** The numero 4 field modificar. */
    private JTextField numero1FieldModificar, numero2FieldModificar, numero3FieldModificar, numero4FieldModificar;
    
    /** The signo zodiaco combo box modificar. */
    private JComboBox<String> sedeComboBoxModificar, diaComboBoxModificar, signoZodiacoComboBoxModificar;
    
    /** The modificar button. */
    private JButton modificarButton;
    
    
    /** The cedula field leer. */
    private JTextField cedulaFieldLeer;
    
    /** The dia combo box leer. */
    private JComboBox<String> diaComboBoxLeer;
    
    /** The buscar button. */
    private JButton buscarButton;
    
    /** The resultado text area. */
    private JTextArea resultadoTextArea;
    
    /** The cedula apostador field eliminar. */
    private JTextField cedulaApostadorFieldEliminar;
    
    /** The dia combo box eliminar. */
    private JComboBox<String> diaComboBoxEliminar;
    
    /** The eliminar button. */
    private JButton eliminarButton;
    

    /** The crear apuesta superastro panel. */
    private JPanel crearApuestaSuperastroPanel;
    
    /** The modificar apuesta superastro panel. */
    private JPanel modificarApuestaSuperastroPanel;
    
    /** The leer apuesta superastro panel. */
    private JPanel leerApuestaSuperastroPanel;
    
    /** The eliminar apuesta superastro panel. */
    private JPanel eliminarApuestaSuperastroPanel;

    /**
     * Instantiates a new ventana apuesta superastro.
     *
     * @param controlador the controlador
     */
    public VentanaApuestaSuperastro(Controller controlador) {
        setTitle("Apuesta Superastro");
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

        crearApuestaSuperastroPanel = new JPanel();
        crearApuestaSuperastroPanel.setBorder(BorderFactory.createTitledBorder("Crear Apuesta Superastro"));
        crearApuestaSuperastroPanel.setLayout(null);

        JLabel labelSedeCrear = new JLabel("Sede:");
        labelSedeCrear.setBounds(20, 30, 60, 25);
        crearApuestaSuperastroPanel.add(labelSedeCrear);

        sedeComboBoxCrear = new JComboBox<>();
        sedeComboBoxCrear.setBounds(90, 30, 100, 25);
        crearApuestaSuperastroPanel.add(sedeComboBoxCrear);

        JLabel labelCedulaCrear = new JLabel("Cédula:");
        labelCedulaCrear.setBounds(20, 70, 60, 25);
        crearApuestaSuperastroPanel.add(labelCedulaCrear);

        cedulaFieldCrear = new JTextField();
        cedulaFieldCrear.setBounds(90, 70, 100, 25);
        crearApuestaSuperastroPanel.add(cedulaFieldCrear);

        JLabel labelDiaCrear = new JLabel("Día:");
        labelDiaCrear.setBounds(20, 110, 60, 25);
        crearApuestaSuperastroPanel.add(labelDiaCrear);

        String[] dias = {"Seleccionar", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        diaComboBoxCrear = new JComboBox<>(dias);
        diaComboBoxCrear.setBounds(90, 110, 100, 25);
        crearApuestaSuperastroPanel.add(diaComboBoxCrear);

        JLabel labelValorApuestaCrear = new JLabel("Valor:");
        labelValorApuestaCrear.setBounds(20, 150, 60, 25);
        crearApuestaSuperastroPanel.add(labelValorApuestaCrear);

        valorApuestaFieldCrear = new JTextField();
        valorApuestaFieldCrear.setBounds(90, 150, 100, 25);
        crearApuestaSuperastroPanel.add(valorApuestaFieldCrear);

        labelNumero1 = new JLabel("N1:");
        labelNumero1.setBounds(220, 30, 30, 25);
        crearApuestaSuperastroPanel.add(labelNumero1);

        numero1Field = new JTextField();
        numero1Field.setBounds(250, 30, 30, 25);
        crearApuestaSuperastroPanel.add(numero1Field);

        labelNumero2 = new JLabel("N2:");
        labelNumero2.setBounds(300, 30, 30, 25);
        crearApuestaSuperastroPanel.add(labelNumero2);

        numero2Field = new JTextField();
        numero2Field.setBounds(330, 30, 30, 25);
        crearApuestaSuperastroPanel.add(numero2Field);

        labelNumero3 = new JLabel("N3:");
        labelNumero3.setBounds(220, 70, 30, 25);
        crearApuestaSuperastroPanel.add(labelNumero3);

        numero3Field = new JTextField();
        numero3Field.setBounds(250, 70, 30, 25);
        crearApuestaSuperastroPanel.add(numero3Field);

        labelNumero4 = new JLabel("N4:");
        labelNumero4.setBounds(300, 70, 30, 25);
        crearApuestaSuperastroPanel.add(labelNumero4);

        numero4Field = new JTextField();
        numero4Field.setBounds(330, 70, 30, 25);
        crearApuestaSuperastroPanel.add(numero4Field);

        labelSignoZodiaco = new JLabel("Signo:");
        labelSignoZodiaco.setBounds(220, 110, 60, 25);
        crearApuestaSuperastroPanel.add(labelSignoZodiaco);

        String[] signosZodiaco = {"Seleccionar", "Aries", "Tauro", "Géminis", "Cáncer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis"};
        signoZodiacoComboBox = new JComboBox<>(signosZodiaco);
        signoZodiacoComboBox.setBounds(280, 110, 100, 25);
        crearApuestaSuperastroPanel.add(signoZodiacoComboBox);

        crearButton = new JButton("Crear");
        crearButton.setBounds(20, 200, 80, 30);
        crearButton.addActionListener(controlador);
        crearApuestaSuperastroPanel.add(crearButton);

        panel.add(crearApuestaSuperastroPanel);


        // Creación del panel para Modificar Apuesta Superastro
        modificarApuestaSuperastroPanel = new JPanel();
        modificarApuestaSuperastroPanel.setBorder(BorderFactory.createTitledBorder("Modificar Apuesta Superastro"));
        modificarApuestaSuperastroPanel.setLayout(null);

        labelSedeModificar = new JLabel("Sede:");
        labelSedeModificar.setBounds(20, 30, 60, 25);
        modificarApuestaSuperastroPanel.add(labelSedeModificar);

        sedeComboBoxModificar = new JComboBox<>();
        sedeComboBoxModificar.setBounds(90, 30, 100, 25);
        modificarApuestaSuperastroPanel.add(sedeComboBoxModificar);

        labelCedulaModificar = new JLabel("Cédula:");
        labelCedulaModificar.setBounds(20, 70, 60, 25);
        modificarApuestaSuperastroPanel.add(labelCedulaModificar);

        cedulaFieldModificar = new JTextField();
        cedulaFieldModificar.setBounds(90, 70, 100, 25);
        modificarApuestaSuperastroPanel.add(cedulaFieldModificar);

        labelDiaModificar = new JLabel("Día:");
        labelDiaModificar.setBounds(20, 110, 60, 25);
        modificarApuestaSuperastroPanel.add(labelDiaModificar);

        diaComboBoxModificar = new JComboBox<>(dias);
        diaComboBoxModificar.setBounds(90, 110, 100, 25);
        modificarApuestaSuperastroPanel.add(diaComboBoxModificar);

        labelValorApuestaModificar = new JLabel("Valor:");
        labelValorApuestaModificar.setBounds(20, 150, 60, 25);
        modificarApuestaSuperastroPanel.add(labelValorApuestaModificar);

        valorApuestaFieldModificar = new JTextField();
        valorApuestaFieldModificar.setBounds(90, 150, 100, 25);
        modificarApuestaSuperastroPanel.add(valorApuestaFieldModificar);

        labelNumero1Modificar = new JLabel("N1:");
        labelNumero1Modificar.setBounds(220, 30, 30, 25);
        modificarApuestaSuperastroPanel.add(labelNumero1Modificar);

        numero1FieldModificar = new JTextField();
        numero1FieldModificar.setBounds(250, 30, 30, 25);
        modificarApuestaSuperastroPanel.add(numero1FieldModificar);

        labelNumero2Modificar = new JLabel("N2:");
        labelNumero2Modificar.setBounds(300, 30, 30, 25);
        modificarApuestaSuperastroPanel.add(labelNumero2Modificar);

        numero2FieldModificar = new JTextField();
        numero2FieldModificar.setBounds(330, 30, 30, 25);
        modificarApuestaSuperastroPanel.add(numero2FieldModificar);

        labelNumero3Modificar = new JLabel("N3:");
        labelNumero3Modificar.setBounds(220, 70, 30, 25);
        modificarApuestaSuperastroPanel.add(labelNumero3Modificar);

        numero3FieldModificar = new JTextField();
        numero3FieldModificar.setBounds(250, 70, 30, 25);
        modificarApuestaSuperastroPanel.add(numero3FieldModificar);

        labelNumero4Modificar = new JLabel("N4:");
        labelNumero4Modificar.setBounds(300, 70, 30, 25);
        modificarApuestaSuperastroPanel.add(labelNumero4Modificar);

        numero4FieldModificar = new JTextField();
        numero4FieldModificar.setBounds(330, 70, 30, 25);
        modificarApuestaSuperastroPanel.add(numero4FieldModificar);

        labelSignoZodiacoModificar = new JLabel("Signo:");
        labelSignoZodiacoModificar.setBounds(220, 110, 60, 25);
        modificarApuestaSuperastroPanel.add(labelSignoZodiacoModificar);

     
        signoZodiacoComboBoxModificar = new JComboBox<>(signosZodiaco);
        signoZodiacoComboBoxModificar.setBounds(280, 110, 100, 25);
        modificarApuestaSuperastroPanel.add(signoZodiacoComboBoxModificar);

        modificarButton = new JButton("Modificar");
        modificarButton.setBounds(20, 200, 100, 30);
        modificarButton.addActionListener(controlador);
        modificarApuestaSuperastroPanel.add(modificarButton);

        panel.add(modificarApuestaSuperastroPanel);

        leerApuestaSuperastroPanel = new JPanel();
        leerApuestaSuperastroPanel.setBorder(BorderFactory.createTitledBorder("Leer Apuesta Superastro"));
        leerApuestaSuperastroPanel.setLayout(null);

        // Agregar componentes al panel de Leer Apuesta Superastro
        JLabel labelCedula = new JLabel("Cédula del Apostador:");
        labelCedula.setBounds(20, 30, 150, 25);
        leerApuestaSuperastroPanel.add(labelCedula);

        cedulaFieldLeer = new JTextField();
        cedulaFieldLeer.setBounds(180, 30, 100, 25);
        leerApuestaSuperastroPanel.add(cedulaFieldLeer);

        JLabel labelDiaApuesta = new JLabel("Día de la Apuesta:");
        labelDiaApuesta.setBounds(20, 70, 150, 25);
        leerApuestaSuperastroPanel.add(labelDiaApuesta);

      
        diaComboBoxLeer = new JComboBox<>(dias);
        diaComboBoxLeer.setBounds(180, 70, 100, 25);
        leerApuestaSuperastroPanel.add(diaComboBoxLeer);

        buscarButton = new JButton("Buscar");
        buscarButton.setBounds(290, 30, 80, 25);
        buscarButton.addActionListener(controlador);
        leerApuestaSuperastroPanel.add(buscarButton);

        resultadoTextArea = new JTextArea();
        resultadoTextArea.setEditable(false);
        resultadoTextArea.setBounds(20, 110, 350, 140);
        leerApuestaSuperastroPanel.add(resultadoTextArea);

        panel.add(leerApuestaSuperastroPanel);


        eliminarApuestaSuperastroPanel = new JPanel();
        eliminarApuestaSuperastroPanel.setBorder(BorderFactory.createTitledBorder("Eliminar Apuesta Superastro"));
        eliminarApuestaSuperastroPanel.setLayout(null);

        // Agregar componentes al panel de Eliminar Apuesta Superastro
        JLabel labelCedulaApostadorEliminar = new JLabel("Cédula del Apostador:");
        labelCedulaApostadorEliminar.setBounds(20, 30, 150, 25);
        eliminarApuestaSuperastroPanel.add(labelCedulaApostadorEliminar);

        cedulaApostadorFieldEliminar = new JTextField();
        cedulaApostadorFieldEliminar.setBounds(180, 30, 100, 25);
        eliminarApuestaSuperastroPanel.add(cedulaApostadorFieldEliminar);

        JLabel labelDiaApuestaEliminar = new JLabel("Día de la Apuesta:");
        labelDiaApuestaEliminar.setBounds(20, 70, 150, 25);
        eliminarApuestaSuperastroPanel.add(labelDiaApuestaEliminar);

        String[] diasEliminar = {"Seleccionar", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        diaComboBoxEliminar = new JComboBox<>(diasEliminar);
        diaComboBoxEliminar.setBounds(180, 70, 100, 25);
        eliminarApuestaSuperastroPanel.add(diaComboBoxEliminar);

        // Botón para eliminar apuesta
        eliminarButton = new JButton("Eliminar Apuesta");
        eliminarButton.setBounds(20, 110, 150, 30);
        eliminarButton.addActionListener(controlador);
        eliminarApuestaSuperastroPanel.add(eliminarButton);

        panel.add(eliminarApuestaSuperastroPanel);
    }

    /**
     * Gets the cedula apostador field eliminar.
     *
     * @return the cedula apostador field eliminar
     */
    public JTextField getCedulaApostadorFieldEliminar() {
		return cedulaApostadorFieldEliminar;
	}

	/**
	 * Sets the cedula apostador field eliminar.
	 *
	 * @param cedulaApostadorFieldEliminar the new cedula apostador field eliminar
	 */
	public void setCedulaApostadorFieldEliminar(JTextField cedulaApostadorFieldEliminar) {
		this.cedulaApostadorFieldEliminar = cedulaApostadorFieldEliminar;
	}

	/**
	 * Gets the dia combo box eliminar.
	 *
	 * @return the dia combo box eliminar
	 */
	public JComboBox<String> getDiaComboBoxEliminar() {
		return diaComboBoxEliminar;
	}

	/**
	 * Sets the dia combo box eliminar.
	 *
	 * @param diaComboBoxEliminar the new dia combo box eliminar
	 */
	public void setDiaComboBoxEliminar(JComboBox<String> diaComboBoxEliminar) {
		this.diaComboBoxEliminar = diaComboBoxEliminar;
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
	 * Gets the resultado text area.
	 *
	 * @return the resultado text area
	 */
	public JTextArea getResultadoTextArea() {
		return resultadoTextArea;
	}

	/**
	 * Sets the resultado text area.
	 *
	 * @param resultadoTextArea the new resultado text area
	 */
	public void setResultadoTextArea(JTextArea resultadoTextArea) {
		this.resultadoTextArea = resultadoTextArea;
	}

	/**
	 * Gets the cedula field leer.
	 *
	 * @return the cedula field leer
	 */
	public JTextField getCedulaFieldLeer() {
		return cedulaFieldLeer;
	}

	/**
	 * Sets the cedula field leer.
	 *
	 * @param cedulaFieldLeer the new cedula field leer
	 */
	public void setCedulaFieldLeer(JTextField cedulaFieldLeer) {
		this.cedulaFieldLeer = cedulaFieldLeer;
	}

	/**
	 * Gets the dia combo box leer.
	 *
	 * @return the dia combo box leer
	 */
	public JComboBox<String> getDiaComboBoxLeer() {
		return diaComboBoxLeer;
	}

	/**
	 * Sets the dia combo box leer.
	 *
	 * @param diaComboBoxLeer the new dia combo box leer
	 */
	public void setDiaComboBoxLeer(JComboBox<String> diaComboBoxLeer) {
		this.diaComboBoxLeer = diaComboBoxLeer;
	}

	/**
	 * Gets the buscar button.
	 *
	 * @return the buscar button
	 */
	public JButton getBuscarButton() {
		return buscarButton;
	}

	/**
	 * Sets the buscar button.
	 *
	 * @param buscarButton the new buscar button
	 */
	public void setBuscarButton(JButton buscarButton) {
		this.buscarButton = buscarButton;
	}

	/**
	 * Reiniciar campos.
	 *
	 * @param sedes the sedes
	 */
	public void reiniciarCampos(String[] sedes) {
        // Vaciar campos de texto de la sección de Crear
        cedulaFieldCrear.setText("");
        valorApuestaFieldCrear.setText("");
        numero1Field.setText("");
        numero2Field.setText("");
        numero3Field.setText("");
        numero4Field.setText("");

        // Reiniciar ComboBox de sedes de la sección de Crear
        sedeComboBoxCrear.removeAllItems();
        sedeComboBoxCrear.addItem("Seleccionar");
        for (int i = 0; i < sedes.length; i++) {
            sedeComboBoxCrear.addItem(sedes[i]);
        }

        // Reiniciar ComboBox de día y seleccionar "Seleccionar" de la sección de Crear
        diaComboBoxCrear.setSelectedItem("Seleccionar");

        // Reiniciar ComboBox de signos del zodiaco y seleccionar "Seleccionar" de la sección de Crear
        signoZodiacoComboBox.setSelectedItem("Seleccionar");

        // Limpiar campos de la sección de Modificar
        cedulaFieldModificar.setText("");
        valorApuestaFieldModificar.setText("");
        numero1FieldModificar.setText("");
        numero2FieldModificar.setText("");
        numero3FieldModificar.setText("");
        numero4FieldModificar.setText("");

        // Reiniciar ComboBox de sedes de la sección de Modificar
        sedeComboBoxModificar.removeAllItems();
        sedeComboBoxModificar.addItem("Seleccionar");
        for (int i = 0; i < sedes.length; i++) {
            sedeComboBoxModificar.addItem(sedes[i]);
        }

        // Reiniciar ComboBox de día y seleccionar "Seleccionar" de la sección de Modificar
        diaComboBoxModificar.setSelectedItem("Seleccionar");

        // Reiniciar ComboBox de signos del zodiaco y seleccionar "Seleccionar" de la sección de Modificar
        signoZodiacoComboBoxModificar.setSelectedItem("Seleccionar");
    }



	/**
	 * Gets the panel.
	 *
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * Sets the panel.
	 *
	 * @param panel the new panel
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * Gets the label numero 1.
	 *
	 * @return the label numero 1
	 */
	public JLabel getLabelNumero1() {
		return labelNumero1;
	}

	/**
	 * Sets the label numero 1.
	 *
	 * @param labelNumero1 the new label numero 1
	 */
	public void setLabelNumero1(JLabel labelNumero1) {
		this.labelNumero1 = labelNumero1;
	}

	/**
	 * Gets the label numero 2.
	 *
	 * @return the label numero 2
	 */
	public JLabel getLabelNumero2() {
		return labelNumero2;
	}

	/**
	 * Sets the label numero 2.
	 *
	 * @param labelNumero2 the new label numero 2
	 */
	public void setLabelNumero2(JLabel labelNumero2) {
		this.labelNumero2 = labelNumero2;
	}

	/**
	 * Gets the label numero 3.
	 *
	 * @return the label numero 3
	 */
	public JLabel getLabelNumero3() {
		return labelNumero3;
	}

	/**
	 * Sets the label numero 3.
	 *
	 * @param labelNumero3 the new label numero 3
	 */
	public void setLabelNumero3(JLabel labelNumero3) {
		this.labelNumero3 = labelNumero3;
	}

	/**
	 * Gets the label numero 4.
	 *
	 * @return the label numero 4
	 */
	public JLabel getLabelNumero4() {
		return labelNumero4;
	}

	/**
	 * Sets the label numero 4.
	 *
	 * @param labelNumero4 the new label numero 4
	 */
	public void setLabelNumero4(JLabel labelNumero4) {
		this.labelNumero4 = labelNumero4;
	}

	/**
	 * Gets the label signo zodiaco.
	 *
	 * @return the label signo zodiaco
	 */
	public JLabel getLabelSignoZodiaco() {
		return labelSignoZodiaco;
	}

	/**
	 * Sets the label signo zodiaco.
	 *
	 * @param labelSignoZodiaco the new label signo zodiaco
	 */
	public void setLabelSignoZodiaco(JLabel labelSignoZodiaco) {
		this.labelSignoZodiaco = labelSignoZodiaco;
	}

	/**
	 * Gets the sede combo box crear.
	 *
	 * @return the sede combo box crear
	 */
	public JComboBox<String> getSedeComboBoxCrear() {
		return sedeComboBoxCrear;
	}

	/**
	 * Sets the sede combo box crear.
	 *
	 * @param sedeComboBoxCrear the new sede combo box crear
	 */
	public void setSedeComboBoxCrear(JComboBox<String> sedeComboBoxCrear) {
		this.sedeComboBoxCrear = sedeComboBoxCrear;
	}

	/**
	 * Gets the cedula field crear.
	 *
	 * @return the cedula field crear
	 */
	public JTextField getCedulaFieldCrear() {
		return cedulaFieldCrear;
	}

	/**
	 * Sets the cedula field crear.
	 *
	 * @param cedulaFieldCrear the new cedula field crear
	 */
	public void setCedulaFieldCrear(JTextField cedulaFieldCrear) {
		this.cedulaFieldCrear = cedulaFieldCrear;
	}

	/**
	 * Gets the dia combo box crear.
	 *
	 * @return the dia combo box crear
	 */
	public JComboBox<String> getDiaComboBoxCrear() {
		return diaComboBoxCrear;
	}

	/**
	 * Sets the dia combo box crear.
	 *
	 * @param diaComboBoxCrear the new dia combo box crear
	 */
	public void setDiaComboBoxCrear(JComboBox<String> diaComboBoxCrear) {
		this.diaComboBoxCrear = diaComboBoxCrear;
	}

	/**
	 * Gets the valor apuesta field crear.
	 *
	 * @return the valor apuesta field crear
	 */
	public JTextField getValorApuestaFieldCrear() {
		return valorApuestaFieldCrear;
	}

	/**
	 * Sets the valor apuesta field crear.
	 *
	 * @param valorApuestaFieldCrear the new valor apuesta field crear
	 */
	public void setValorApuestaFieldCrear(JTextField valorApuestaFieldCrear) {
		this.valorApuestaFieldCrear = valorApuestaFieldCrear;
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
	 * Gets the signo zodiaco combo box.
	 *
	 * @return the signo zodiaco combo box
	 */
	public JComboBox<String> getSignoZodiacoComboBox() {
		return signoZodiacoComboBox;
	}

	/**
	 * Sets the signo zodiaco combo box.
	 *
	 * @param signoZodiacoComboBox the new signo zodiaco combo box
	 */
	public void setSignoZodiacoComboBox(JComboBox<String> signoZodiacoComboBox) {
		this.signoZodiacoComboBox = signoZodiacoComboBox;
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
	 * Gets the crear apuesta superastro panel.
	 *
	 * @return the crear apuesta superastro panel
	 */
	public JPanel getCrearApuestaSuperastroPanel() {
		return crearApuestaSuperastroPanel;
	}

	/**
	 * Sets the crear apuesta superastro panel.
	 *
	 * @param crearApuestaSuperastroPanel the new crear apuesta superastro panel
	 */
	public void setCrearApuestaSuperastroPanel(JPanel crearApuestaSuperastroPanel) {
		this.crearApuestaSuperastroPanel = crearApuestaSuperastroPanel;
	}

	/**
	 * Gets the modificar apuesta superastro panel.
	 *
	 * @return the modificar apuesta superastro panel
	 */
	public JPanel getModificarApuestaSuperastroPanel() {
		return modificarApuestaSuperastroPanel;
	}

	/**
	 * Sets the modificar apuesta superastro panel.
	 *
	 * @param modificarApuestaSuperastroPanel the new modificar apuesta superastro panel
	 */
	public void setModificarApuestaSuperastroPanel(JPanel modificarApuestaSuperastroPanel) {
		this.modificarApuestaSuperastroPanel = modificarApuestaSuperastroPanel;
	}

	/**
	 * Gets the leer apuesta superastro panel.
	 *
	 * @return the leer apuesta superastro panel
	 */
	public JPanel getLeerApuestaSuperastroPanel() {
		return leerApuestaSuperastroPanel;
	}

	/**
	 * Sets the leer apuesta superastro panel.
	 *
	 * @param leerApuestaSuperastroPanel the new leer apuesta superastro panel
	 */
	public void setLeerApuestaSuperastroPanel(JPanel leerApuestaSuperastroPanel) {
		this.leerApuestaSuperastroPanel = leerApuestaSuperastroPanel;
	}

	/**
	 * Gets the eliminar apuesta superastro panel.
	 *
	 * @return the eliminar apuesta superastro panel
	 */
	public JPanel getEliminarApuestaSuperastroPanel() {
		return eliminarApuestaSuperastroPanel;
	}

	/**
	 * Sets the eliminar apuesta superastro panel.
	 *
	 * @param eliminarApuestaSuperastroPanel the new eliminar apuesta superastro panel
	 */
	public void setEliminarApuestaSuperastroPanel(JPanel eliminarApuestaSuperastroPanel) {
		this.eliminarApuestaSuperastroPanel = eliminarApuestaSuperastroPanel;
	}

	/**
	 * Gets the label sede modificar.
	 *
	 * @return the label sede modificar
	 */
	public JLabel getLabelSedeModificar() {
		return labelSedeModificar;
	}

	/**
	 * Sets the label sede modificar.
	 *
	 * @param labelSedeModificar the new label sede modificar
	 */
	public void setLabelSedeModificar(JLabel labelSedeModificar) {
		this.labelSedeModificar = labelSedeModificar;
	}

	/**
	 * Gets the label cedula modificar.
	 *
	 * @return the label cedula modificar
	 */
	public JLabel getLabelCedulaModificar() {
		return labelCedulaModificar;
	}

	/**
	 * Sets the label cedula modificar.
	 *
	 * @param labelCedulaModificar the new label cedula modificar
	 */
	public void setLabelCedulaModificar(JLabel labelCedulaModificar) {
		this.labelCedulaModificar = labelCedulaModificar;
	}

	/**
	 * Gets the label dia modificar.
	 *
	 * @return the label dia modificar
	 */
	public JLabel getLabelDiaModificar() {
		return labelDiaModificar;
	}

	/**
	 * Sets the label dia modificar.
	 *
	 * @param labelDiaModificar the new label dia modificar
	 */
	public void setLabelDiaModificar(JLabel labelDiaModificar) {
		this.labelDiaModificar = labelDiaModificar;
	}

	/**
	 * Gets the label valor apuesta modificar.
	 *
	 * @return the label valor apuesta modificar
	 */
	public JLabel getLabelValorApuestaModificar() {
		return labelValorApuestaModificar;
	}

	/**
	 * Sets the label valor apuesta modificar.
	 *
	 * @param labelValorApuestaModificar the new label valor apuesta modificar
	 */
	public void setLabelValorApuestaModificar(JLabel labelValorApuestaModificar) {
		this.labelValorApuestaModificar = labelValorApuestaModificar;
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
	 * Gets the label signo zodiaco modificar.
	 *
	 * @return the label signo zodiaco modificar
	 */
	public JLabel getLabelSignoZodiacoModificar() {
		return labelSignoZodiacoModificar;
	}

	/**
	 * Sets the label signo zodiaco modificar.
	 *
	 * @param labelSignoZodiacoModificar the new label signo zodiaco modificar
	 */
	public void setLabelSignoZodiacoModificar(JLabel labelSignoZodiacoModificar) {
		this.labelSignoZodiacoModificar = labelSignoZodiacoModificar;
	}

	/**
	 * Gets the cedula field modificar.
	 *
	 * @return the cedula field modificar
	 */
	public JTextField getCedulaFieldModificar() {
		return cedulaFieldModificar;
	}

	/**
	 * Sets the cedula field modificar.
	 *
	 * @param cedulaFieldModificar the new cedula field modificar
	 */
	public void setCedulaFieldModificar(JTextField cedulaFieldModificar) {
		this.cedulaFieldModificar = cedulaFieldModificar;
	}

	/**
	 * Gets the valor apuesta field modificar.
	 *
	 * @return the valor apuesta field modificar
	 */
	public JTextField getValorApuestaFieldModificar() {
		return valorApuestaFieldModificar;
	}

	/**
	 * Sets the valor apuesta field modificar.
	 *
	 * @param valorApuestaFieldModificar the new valor apuesta field modificar
	 */
	public void setValorApuestaFieldModificar(JTextField valorApuestaFieldModificar) {
		this.valorApuestaFieldModificar = valorApuestaFieldModificar;
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

	/**
	 * Gets the sede combo box modificar.
	 *
	 * @return the sede combo box modificar
	 */
	public JComboBox<String> getSedeComboBoxModificar() {
		return sedeComboBoxModificar;
	}

	/**
	 * Sets the sede combo box modificar.
	 *
	 * @param sedeComboBoxModificar the new sede combo box modificar
	 */
	public void setSedeComboBoxModificar(JComboBox<String> sedeComboBoxModificar) {
		this.sedeComboBoxModificar = sedeComboBoxModificar;
	}

	/**
	 * Gets the dia combo box modificar.
	 *
	 * @return the dia combo box modificar
	 */
	public JComboBox<String> getDiaComboBoxModificar() {
		return diaComboBoxModificar;
	}

	/**
	 * Sets the dia combo box modificar.
	 *
	 * @param diaComboBoxModificar the new dia combo box modificar
	 */
	public void setDiaComboBoxModificar(JComboBox<String> diaComboBoxModificar) {
		this.diaComboBoxModificar = diaComboBoxModificar;
	}

	/**
	 * Gets the signo zodiaco combo box modificar.
	 *
	 * @return the signo zodiaco combo box modificar
	 */
	public JComboBox<String> getSignoZodiacoComboBoxModificar() {
		return signoZodiacoComboBoxModificar;
	}

	/**
	 * Sets the signo zodiaco combo box modificar.
	 *
	 * @param signoZodiacoComboBoxModificar the new signo zodiaco combo box modificar
	 */
	public void setSignoZodiacoComboBoxModificar(JComboBox<String> signoZodiacoComboBoxModificar) {
		this.signoZodiacoComboBoxModificar = signoZodiacoComboBoxModificar;
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
  
}
