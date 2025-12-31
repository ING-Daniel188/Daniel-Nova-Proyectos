package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import co.edu.unbosque.controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaPrincipal.
 */
public class VentanaPrincipal extends JFrame {

    /** The panel. */
    private JPanel panel;
    
    /** The btn gestion apostadores. */
    private JButton btnGestionApostadores;
    
    /** The btn gestion apuestas. */
    private JButton btnGestionApuestas;
    
    /** The btn gestion sedes. */
    private JButton btnGestionSedes;
    
    /** The btn gestion parametros. */
    private JButton btnGestionParametros;
    
    /** The btn consultas. */
    private JButton btnConsultas;

    /**
     * Instantiates a new ventana principal.
     *
     * @param controlador the controlador
     */
    public VentanaPrincipal(Controller controlador) {
        setTitle("Ventana Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        panel = new JPanel(null) {
        	@Override
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		Image fondo = new ImageIcon("fondo.jpg").getImage();
        		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        	}
        };
        setContentPane(panel);

        btnGestionParametros = new JButton("Gestión de Parámetros");
        btnGestionParametros.setBounds(290, 50, 200, 50);
        btnGestionParametros.addActionListener(controlador);
        panel.add(btnGestionParametros);

        btnGestionSedes = new JButton("Gestión de Sedes");
        btnGestionSedes.setBounds(290, 150, 200, 50);
        btnGestionSedes.addActionListener(controlador);
        panel.add(btnGestionSedes);

        btnGestionApostadores = new JButton("Gestión de Apostadores");
        btnGestionApostadores.setBounds(290, 250, 200, 50);
        btnGestionApostadores.addActionListener(controlador);
        panel.add(btnGestionApostadores);

        btnGestionApuestas = new JButton("Gestión de Apuestas");
        btnGestionApuestas.setBounds(290, 350, 200, 50);
        btnGestionApuestas.addActionListener(controlador);
        panel.add(btnGestionApuestas);

        btnConsultas = new JButton("Realización de Consultas");
        btnConsultas.setBounds(290, 450, 200, 50);
        btnConsultas.addActionListener(controlador);
        panel.add(btnConsultas);

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
	 * Gets the btn gestion apostadores.
	 *
	 * @return the btn gestion apostadores
	 */
	public JButton getBtnGestionApostadores() {
		return btnGestionApostadores;
	}

	/**
	 * Sets the btn gestion apostadores.
	 *
	 * @param btnGestionApostadores the new btn gestion apostadores
	 */
	public void setBtnGestionApostadores(JButton btnGestionApostadores) {
		this.btnGestionApostadores = btnGestionApostadores;
	}

	/**
	 * Gets the btn gestion apuestas.
	 *
	 * @return the btn gestion apuestas
	 */
	public JButton getBtnGestionApuestas() {
		return btnGestionApuestas;
	}

	/**
	 * Sets the btn gestion apuestas.
	 *
	 * @param btnGestionApuestas the new btn gestion apuestas
	 */
	public void setBtnGestionApuestas(JButton btnGestionApuestas) {
		this.btnGestionApuestas = btnGestionApuestas;
	}

	/**
	 * Gets the btn gestion sedes.
	 *
	 * @return the btn gestion sedes
	 */
	public JButton getBtnGestionSedes() {
		return btnGestionSedes;
	}

	/**
	 * Sets the btn gestion sedes.
	 *
	 * @param btnGestionSedes the new btn gestion sedes
	 */
	public void setBtnGestionSedes(JButton btnGestionSedes) {
		this.btnGestionSedes = btnGestionSedes;
	}

	/**
	 * Gets the btn gestion parametros.
	 *
	 * @return the btn gestion parametros
	 */
	public JButton getBtnGestionParametros() {
		return btnGestionParametros;
	}

	/**
	 * Sets the btn gestion parametros.
	 *
	 * @param btnGestionParametros the new btn gestion parametros
	 */
	public void setBtnGestionParametros(JButton btnGestionParametros) {
		this.btnGestionParametros = btnGestionParametros;
	}

	/**
	 * Gets the btn consultas.
	 *
	 * @return the btn consultas
	 */
	public JButton getBtnConsultas() {
		return btnConsultas;
	}

	/**
	 * Sets the btn consultas.
	 *
	 * @param btnConsultas the new btn consultas
	 */
	public void setBtnConsultas(JButton btnConsultas) {
		this.btnConsultas = btnConsultas;
	}

    
}
