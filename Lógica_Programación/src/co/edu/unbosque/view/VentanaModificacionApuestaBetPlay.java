package co.edu.unbosque.view;

import javax.swing.*;
import co.edu.unbosque.controller.Controller;

import java.awt.*;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaModificacionApuestaBetPlay.
 */
public class VentanaModificacionApuestaBetPlay extends JFrame {
	
	/** The panel. */
	private JPanel panel;
	
	/** The cedula. */
	private JTextField cedula;
    
    /** The sede. */
    private JComboBox<String> sede;
    
    /** The dia. */
    private JComboBox<String> dia;
    
    /** The valor apuesta. */
    private JTextField valorApuesta;
    
    /** The cargar button. */
    private JButton cargarButton;
    
    /** The modificar button. */
    private JButton modificarButton;
    
    /** The eliminar button. */
    private JButton eliminarButton;
    
    /** The equipo 1 label. */
    private JLabel equipo1Label[];
    
    /** The equipo 2 label. */
    private JLabel equipo2Label[];
    
    /** The resultado combo box. */
    JComboBox<String> resultadoComboBox[];
    
    /** The partidos panel. */
    private JPanel partidosPanel;

    /**
     * Instantiates a new ventana modificacion apuesta bet play.
     *
     * @param controlador the controlador
     */
    public VentanaModificacionApuestaBetPlay(Controller controlador) {
        setTitle("Modificar Apuesta BetPlay");
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

        sede = new JComboBox<String>();
        sede.setBounds(200, 20, 150, 25);
        JLabel labelSede = new JLabel("Nombre de la sede:");
        labelSede.setForeground(Color.white);
        labelSede.setBounds(20, 20, 150, 25);
        panel.add(labelSede);
        panel.add(sede);

        cedula = new JTextField();
        cedula.setBounds(200, 60, 150, 25);
        JLabel labelCedula = new JLabel("Cédula del apostador:");
        labelCedula.setForeground(Color.white);
        labelCedula.setBounds(20, 60, 150, 25);
        panel.add(labelCedula);
        panel.add(cedula);

        dia = new JComboBox<>(new String[]{"Seleccione dia", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"});
        dia.setBounds(200, 100, 150, 25);
        JLabel labelDia = new JLabel("Día de la apuesta:");
        labelDia.setForeground(Color.white);
        labelDia.setBounds(20, 100, 150, 25);
        panel.add(labelDia);
        panel.add(dia);

        valorApuesta = new JTextField();
        valorApuesta.setBounds(200, 140, 150, 25);
        JLabel labelValor = new JLabel("Valor de la Apuesta:");
        labelValor.setForeground(Color.white);
        labelValor.setBounds(20, 140, 150, 25);
        panel.add(labelValor);
        panel.add(valorApuesta);
        
        cargarButton = new JButton("Cargar datos de apuesta");
        cargarButton.setBounds(450, 30, 190, 30);
        cargarButton.addActionListener(controlador);
        panel.add(cargarButton);

        modificarButton = new JButton("Modificar apuesta");
        modificarButton.setBounds(465, 75, 150, 30);
        modificarButton.addActionListener(controlador);
        panel.add(modificarButton);
        
        eliminarButton = new JButton("Eliminar apuesta");
        eliminarButton.setBounds(465, 120, 150, 30);
        eliminarButton.addActionListener(controlador);
        panel.add(eliminarButton);

        // Crear panel para los partidos con GridLayout
        partidosPanel = new JPanel();
        partidosPanel.setLayout(new GridLayout(14, 3));
       

        partidosPanel.setBounds(20, 170, 750, 390); // Ajusta la posición y tamaño del panel de partidos
        
        equipo1Label = new JLabel[14];
        equipo2Label = new JLabel[14];
        resultadoComboBox = new JComboBox[14];
        
        // Inicializar componentes para los partidos
        for (int i = 0; i < 14; i++) {
            equipo1Label[i] = new JLabel("");
            equipo1Label[i].setHorizontalAlignment(JLabel.CENTER);

            equipo2Label[i] = new JLabel("");
            equipo2Label[i].setHorizontalAlignment(JLabel.CENTER);

            resultadoComboBox[i] = new JComboBox<>(new String[]{
            		"Seleccione resultado", "Gana equipo 1", "Gana equipo 2", "Empate"
            		});
            resultadoComboBox[i].setSelectedItem(0);
            resultadoComboBox[i].setVisible(false);
        }
        
        // Agregar componentes para los partidos
        for (int i = 0; i < 14; i++) {
            partidosPanel.add(equipo1Label[i]);
            partidosPanel.add(equipo2Label[i]);
            partidosPanel.add(resultadoComboBox[i]);
        }
        

        panel.add(partidosPanel);
    }
 
    
    /**
     * Agregar partidos.
     *
     * @param partidosYResultados the partidos Y resultados
     */
    public void agregarPartidos(String[][] partidosYResultados) {
    	
    	
    	// Inicializar componentes para los partidos
        for (int i = 0; i < resultadoComboBox.length; i++) {
        	equipo1Label[i].setText(partidosYResultados[i][0]);
        	equipo2Label[i].setText(partidosYResultados[i][1]);

            resultadoComboBox[i].setSelectedItem(partidosYResultados[i][2]);
            resultadoComboBox[i].setVisible(true);
        }
 
    }
    
    /**
     * Resultados seleccionados.
     *
     * @return true, if successful
     */
    public boolean resultadosSeleccionados() {
    	// Validar que se hayan seleccionado los resultados de todos los partidos
        for (JComboBox<String> comboBox : resultadoComboBox) {
            if (comboBox.getSelectedIndex() == 0) { // Si no se ha seleccionado ningún resultado
                return false;
            }
        }
        return true;
    }

    
    
    /**
     * Reiniciar campos.
     *
     * @param sedesActuales the sedes actuales
     */
    public void reiniciarCampos(String[] sedesActuales) {
        
    	// Reiniciar seleccion apuesta a crear
    	sede.removeAllItems();
    	sede.addItem("Seleccione sede");
        
    	for (int i = 0; i < sedesActuales.length; i++) {
    		sede.addItem(sedesActuales[i]);
    	}
    	
    	// Reiniciar todos los partidos
    	for (int i = 0; i < resultadoComboBox.length; i++) {
    		resultadoComboBox[i].setSelectedIndex(0);
    	}
    }
    
    /**
     * Obtener partidos Y resultados escogidos.
     *
     * @return the string[][]
     */
    public String[][] obtenerPartidosYResultadosEscogidos() {
		String[][] partidosYResultadosEscogidos = new String[14][3];
		
		for (int i = 0; i < 14; i++) {
			partidosYResultadosEscogidos[i][0] = equipo1Label[i].getText();
			partidosYResultadosEscogidos[i][1] = equipo2Label[i].getText();
			partidosYResultadosEscogidos[i][2] = resultadoComboBox[i].getSelectedItem().toString();
		}
		
		return partidosYResultadosEscogidos;
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
	 * Gets the valor apuesta.
	 *
	 * @return the valor apuesta
	 */
	public JTextField getValorApuesta() {
		return valorApuesta;
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
	 * Gets the equipo 1 label.
	 *
	 * @return the equipo 1 label
	 */
	public JLabel[] getEquipo1Label() {
		return equipo1Label;
	}

	/**
	 * Sets the equipo 1 label.
	 *
	 * @param equipo1Label the new equipo 1 label
	 */
	public void setEquipo1Label(JLabel[] equipo1Label) {
		this.equipo1Label = equipo1Label;
	}

	/**
	 * Gets the equipo 2 label.
	 *
	 * @return the equipo 2 label
	 */
	public JLabel[] getEquipo2Label() {
		return equipo2Label;
	}

	/**
	 * Sets the equipo 2 label.
	 *
	 * @param equipo2Label the new equipo 2 label
	 */
	public void setEquipo2Label(JLabel[] equipo2Label) {
		this.equipo2Label = equipo2Label;
	}

	/**
	 * Gets the resultado combo box.
	 *
	 * @return the resultado combo box
	 */
	public JComboBox<String>[] getResultadoComboBox() {
		return resultadoComboBox;
	}

	/**
	 * Sets the resultado combo box.
	 *
	 * @param resultadoComboBox the new resultado combo box
	 */
	public void setResultadoComboBox(JComboBox<String>[] resultadoComboBox) {
		this.resultadoComboBox = resultadoComboBox;
	}

	/**
	 * Gets the partidos panel.
	 *
	 * @return the partidos panel
	 */
	public JPanel getPartidosPanel() {
		return partidosPanel;
	}

	/**
	 * Sets the partidos panel.
	 *
	 * @param partidosPanel the new partidos panel
	 */
	public void setPartidosPanel(JPanel partidosPanel) {
		this.partidosPanel = partidosPanel;
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
	 * Sets the valor apuesta.
	 *
	 * @param valorApuesta the new valor apuesta
	 */
	public void setValorApuesta(JTextField valorApuesta) {
		this.valorApuesta = valorApuesta;
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
	 * Gets the cargar button.
	 *
	 * @return the cargar button
	 */
	public JButton getCargarButton() {
		return cargarButton;
	}

	/**
	 * Sets the cargar button.
	 *
	 * @param cargarButton the new cargar button
	 */
	public void setCargarButton(JButton cargarButton) {
		this.cargarButton = cargarButton;
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
	
}
