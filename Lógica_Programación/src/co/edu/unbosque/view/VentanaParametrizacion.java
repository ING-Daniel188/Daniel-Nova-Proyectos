package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.unbosque.controller.Controller;
import co.edu.unbosque.model.Juego;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaParametrizacion.
 */
public class VentanaParametrizacion extends JFrame {

    /** The presupuesto field. */
    private JTextField nombreField, sedesField, presupuestoField;
    
    /** The lista juegos. */
    private JList<String> listaJuegos;
    
    /** The list model. */
    private DefaultListModel<String> listModel;
    
    /** The guardar button. */
    private JButton guardarButton;
    
    /** The cargar button. */
    private JButton cargarButton;

    /**
     * Instantiates a new ventana parametrizacion.
     *
     * @param controlador the controlador
     */
    public VentanaParametrizacion(Controller controlador) {
        setTitle("Parametrización de Casa de Apuestas");
        setResizable(false);

        JPanel panel = new JPanel(null) {
        	@Override
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		Image fondo = new ImageIcon("fondo.jpg").getImage();
        		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        	}
        };
        setContentPane(panel);

        JLabel nombreLabel = new JLabel("Nombre de la Casa de Apuestas:");
        nombreLabel.setForeground(Color.white);
        nombreLabel.setBounds(100, 100, 250, 25);
        nombreField = new JTextField();
        nombreField.setBounds(350, 100, 250, 25);

        JLabel sedesLabel = new JLabel("Número de Sedes:");
        sedesLabel.setForeground(Color.white);
        sedesLabel.setBounds(100, 150, 250, 25);
        sedesField = new JTextField();
        sedesField.setBounds(350, 150, 250, 25);

        JLabel presupuestoLabel = new JLabel("Presupuesto Total Disponible:");
        presupuestoLabel.setForeground(Color.white);
        presupuestoLabel.setBounds(100, 200, 250, 25);
        presupuestoField = new JTextField();
        presupuestoField.setBounds(350, 200, 250, 25);

        guardarButton = new JButton("Guardar");
        guardarButton.setBounds(350, 300, 150, 50);
        guardarButton.addActionListener(controlador);
        
        cargarButton = new JButton("Cargar");
        cargarButton.setBounds(200, 300, 150, 50);
        cargarButton.addActionListener(controlador);

        
        listModel = new DefaultListModel<>();
        listaJuegos = new JList<>(listModel);
        listaJuegos.setBounds(200, 400, 300, 100);
        panel.add(listaJuegos);
        
        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(sedesLabel);
        panel.add(sedesField);
        panel.add(presupuestoLabel);
        panel.add(presupuestoField);
        panel.add(guardarButton);
        panel.add(cargarButton);

        setResizable(false);
        
        setSize(800, 600); // Tamaño de la ventana redimensionado
        setLocationRelativeTo(null);
    }
    
    /**
     * Mostrar juegos.
     *
     * @param juegos the juegos
     */
    public void mostrarJuegos(ArrayList<Juego> juegos) {
        listModel.clear();
        for (Juego juego : juegos) {
            listModel.addElement(juego.getNombreDelJuego() + " - Presupuesto asignado: " + juego.getPresupuesto());
        }
    }


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
	 * Gets the sedes field.
	 *
	 * @return the sedes field
	 */
	public JTextField getSedesField() {
		return sedesField;
	}

	/**
	 * Sets the sedes field.
	 *
	 * @param sedesField the new sedes field
	 */
	public void setSedesField(JTextField sedesField) {
		this.sedesField = sedesField;
	}

	/**
	 * Gets the presupuesto field.
	 *
	 * @return the presupuesto field
	 */
	public JTextField getPresupuestoField() {
		return presupuestoField;
	}

	/**
	 * Sets the presupuesto field.
	 *
	 * @param presupuestoField the new presupuesto field
	 */
	public void setPresupuestoField(JTextField presupuestoField) {
		this.presupuestoField = presupuestoField;
	}

	/**
	 * Gets the guardar button.
	 *
	 * @return the guardar button
	 */
	public JButton getGuardarButton() {
		return guardarButton;
	}

	/**
	 * Sets the guardar button.
	 *
	 * @param guardarButton the new guardar button
	 */
	public void setGuardarButton(JButton guardarButton) {
		this.guardarButton = guardarButton;
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


	

}
