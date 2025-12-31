package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import co.edu.unbosque.controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaConsultas.
 */
public class VentanaConsultas extends JFrame {

    /** The panel. */
    private JPanel panel;
    
    /** The btn listado clientes sede. */
    private JButton btnListadoClientesSede;
    
    /** The btn valor total apuestas cliente. */
    private JButton btnValorTotalApuestasCliente;
    
    /** The btn detalle apuestas cliente sede. */
    private JButton btnDetalleApuestasClienteSede;
    
    /** The btn total apuestas sede tipo juego. */
    private JButton btnTotalApuestasSedeTipoJuego;

    /**
     * Instantiates a new ventana consultas.
     *
     * @param controlador the controlador
     */
    public VentanaConsultas(Controller controlador) {
        setTitle("Consultas");
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

        btnListadoClientesSede = new JButton("Listado de clientes por sede");
        btnListadoClientesSede.setBounds(50, 50, 300, 50);
        btnListadoClientesSede.addActionListener(controlador);
        panel.add(btnListadoClientesSede);

        btnValorTotalApuestasCliente = new JButton("Valor total de apuestas por cliente");
        btnValorTotalApuestasCliente.setBounds(50, 150, 300, 50);
        btnValorTotalApuestasCliente.addActionListener(controlador);
        panel.add(btnValorTotalApuestasCliente);

        btnDetalleApuestasClienteSede = new JButton("Detalle de apuestas por cliente y sede");
        btnDetalleApuestasClienteSede.setBounds(50, 250, 300, 50);
        btnDetalleApuestasClienteSede.addActionListener(controlador);
        panel.add(btnDetalleApuestasClienteSede);

        btnTotalApuestasSedeTipoJuego = new JButton("Total de apuestas por sede y tipo de juego");
        btnTotalApuestasSedeTipoJuego.setBounds(50, 350, 300, 50);
        btnTotalApuestasSedeTipoJuego.addActionListener(controlador);
        panel.add(btnTotalApuestasSedeTipoJuego);

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
	 * Gets the btn listado clientes sede.
	 *
	 * @return the btn listado clientes sede
	 */
	public JButton getBtnListadoClientesSede() {
		return btnListadoClientesSede;
	}

	/**
	 * Sets the btn listado clientes sede.
	 *
	 * @param btnListadoClientesSede the new btn listado clientes sede
	 */
	public void setBtnListadoClientesSede(JButton btnListadoClientesSede) {
		this.btnListadoClientesSede = btnListadoClientesSede;
	}

	/**
	 * Gets the btn valor total apuestas cliente.
	 *
	 * @return the btn valor total apuestas cliente
	 */
	public JButton getBtnValorTotalApuestasCliente() {
		return btnValorTotalApuestasCliente;
	}

	/**
	 * Sets the btn valor total apuestas cliente.
	 *
	 * @param btnValorTotalApuestasCliente the new btn valor total apuestas cliente
	 */
	public void setBtnValorTotalApuestasCliente(JButton btnValorTotalApuestasCliente) {
		this.btnValorTotalApuestasCliente = btnValorTotalApuestasCliente;
	}

	/**
	 * Gets the btn detalle apuestas cliente sede.
	 *
	 * @return the btn detalle apuestas cliente sede
	 */
	public JButton getBtnDetalleApuestasClienteSede() {
		return btnDetalleApuestasClienteSede;
	}

	/**
	 * Sets the btn detalle apuestas cliente sede.
	 *
	 * @param btnDetalleApuestasClienteSede the new btn detalle apuestas cliente sede
	 */
	public void setBtnDetalleApuestasClienteSede(JButton btnDetalleApuestasClienteSede) {
		this.btnDetalleApuestasClienteSede = btnDetalleApuestasClienteSede;
	}

	/**
	 * Gets the btn total apuestas sede tipo juego.
	 *
	 * @return the btn total apuestas sede tipo juego
	 */
	public JButton getBtnTotalApuestasSedeTipoJuego() {
		return btnTotalApuestasSedeTipoJuego;
	}

	/**
	 * Sets the btn total apuestas sede tipo juego.
	 *
	 * @param btnTotalApuestasSedeTipoJuego the new btn total apuestas sede tipo juego
	 */
	public void setBtnTotalApuestasSedeTipoJuego(JButton btnTotalApuestasSedeTipoJuego) {
		this.btnTotalApuestasSedeTipoJuego = btnTotalApuestasSedeTipoJuego;
	}

    
}
