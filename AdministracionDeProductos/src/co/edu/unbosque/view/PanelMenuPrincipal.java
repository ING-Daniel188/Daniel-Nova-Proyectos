package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * The Class PanelMenuPrincipal.
 */
public class PanelMenuPrincipal extends PanelBase {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The fondo. */
	private Image fondo;
	
	/** The titulo. */
	private JLabel titulo;
	
	/** The btn gestionar carnes frias. */
	private JButton btnGestionarCarnesFrias;
	
	/** The btn gestionar productos lacteos. */
	private JButton btnGestionarProductosLacteos;
	
	/** The btn gestionar productos animales no lacteos. */
	private JButton btnGestionarProductosAnimalesNoLacteos;
	
	/** The btn gestionar frutas dulces. */
	private JButton btnGestionarFrutasDulces;
	
	/** The btn gestionar frutas acidas. */
	private JButton btnGestionarFrutasAcidas;
	
	/** The btn gestionar verduras. */
	private JButton btnGestionarVerduras;
	
	/** The btn gestionar comida chatarra. */
	private JButton btnGestionarComidaChatarra;

	/**
	 * Instantiates a new panel menu principal.
	 */
	public PanelMenuPrincipal() {
		
		titulo = new JLabel("Administración de Productos");
		titulo.setBounds(270, 50, 420, 50);
		titulo.setOpaque(true);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(super.getFuenteNegrilla());
		titulo.setBackground(Color.green);
		titulo.setForeground(Color.black);
		add(titulo);
		
		btnGestionarCarnesFrias = new JButton("Gestionar Carnes Frías");
		btnGestionarCarnesFrias.setFont(super.getFuentePlana());
		btnGestionarCarnesFrias.setFocusable(false);
		btnGestionarCarnesFrias.setBackground(new Color(0, 128, 0));
		btnGestionarCarnesFrias.setForeground(Color.white);
		btnGestionarCarnesFrias.setIcon(new ImageIcon(new ImageIcon("Imagenes/carnesFrias.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnGestionarCarnesFrias.setBounds(30, 150, 400, 75);
		add(btnGestionarCarnesFrias);
		
		btnGestionarProductosLacteos = new JButton("Gestionar Productos Lácteos");
		btnGestionarProductosLacteos.setFont(super.getFuentePlana());
		btnGestionarProductosLacteos.setFocusable(false);
		btnGestionarProductosLacteos.setBackground(new Color(128, 0, 128));
		btnGestionarProductosLacteos.setForeground(Color.white);
		btnGestionarProductosLacteos.setIcon(new ImageIcon(new ImageIcon("Imagenes/productosLacteos.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnGestionarProductosLacteos.setBounds(480, 150, 470, 75);
		add(btnGestionarProductosLacteos);
		
		btnGestionarProductosAnimalesNoLacteos = new JButton("Gestionar Productos Animales No Lácteos");
		btnGestionarProductosAnimalesNoLacteos.setFont(super.getFuentePlana());
		btnGestionarProductosAnimalesNoLacteos.setFocusable(false);
		btnGestionarProductosAnimalesNoLacteos.setBackground(new Color(0, 35, 102));
		btnGestionarProductosAnimalesNoLacteos.setForeground(Color.white);
		btnGestionarProductosAnimalesNoLacteos.setIcon(new ImageIcon(new ImageIcon("Imagenes/productosAnimalesNoLacteos.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnGestionarProductosAnimalesNoLacteos.setBounds(160, 270, 650, 75);
		add(btnGestionarProductosAnimalesNoLacteos);
		
		btnGestionarFrutasDulces = new JButton("Gestionar Frutas Dulces");
		btnGestionarFrutasDulces.setFont(super.getFuentePlana());
		btnGestionarFrutasDulces.setFocusable(false);
		btnGestionarFrutasDulces.setBackground(new Color(204, 85, 37));
		btnGestionarFrutasDulces.setForeground(Color.white);
		btnGestionarFrutasDulces.setIcon(new ImageIcon(new ImageIcon("Imagenes/frutasDulces.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnGestionarFrutasDulces.setBounds(30, 390, 420, 75);
		add(btnGestionarFrutasDulces);
		
		btnGestionarFrutasAcidas = new JButton("Gestionar Frutas Ácidas");
		btnGestionarFrutasAcidas.setFont(super.getFuentePlana());
		btnGestionarFrutasAcidas.setFocusable(false);
		btnGestionarFrutasAcidas.setBackground(new Color(77, 77, 77));
		btnGestionarFrutasAcidas.setForeground(Color.white);
		btnGestionarFrutasAcidas.setIcon(new ImageIcon(new ImageIcon("Imagenes/frutasAcidas.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnGestionarFrutasAcidas.setBounds(525, 390, 420, 75);
		add(btnGestionarFrutasAcidas);
		
		btnGestionarVerduras = new JButton("Gestionar Verduras");
		btnGestionarVerduras.setFont(super.getFuentePlana());
		btnGestionarVerduras.setFocusable(false);
		btnGestionarVerduras.setBackground(new Color(220, 20, 60));
		btnGestionarVerduras.setForeground(Color.white);
		btnGestionarVerduras.setIcon(new ImageIcon(new ImageIcon("Imagenes/verduras.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnGestionarVerduras.setBounds(30, 510, 370, 75);
		add(btnGestionarVerduras);
		
		btnGestionarComidaChatarra = new JButton("Gestionar Comida Chatarra");
		btnGestionarComidaChatarra.setFont(super.getFuentePlana());
		btnGestionarComidaChatarra.setFocusable(false);
		btnGestionarComidaChatarra.setBackground(new Color(128, 0, 32));
		btnGestionarComidaChatarra.setForeground(Color.white);
		btnGestionarComidaChatarra.setIcon(new ImageIcon(new ImageIcon("Imagenes/comidasChatarra.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnGestionarComidaChatarra.setBounds(465, 510, 480, 75);
		add(btnGestionarComidaChatarra);
	}
	
	/**
	 * Paint component.
	 *
	 * @param g the g
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		fondo = new ImageIcon("Imagenes/tienda2.jpeg").getImage();
		g.drawImage(fondo, 0, 0, this);
	}

	/**
	 * Gets the btn gestionar carnes frias.
	 *
	 * @return the btn gestionar carnes frias
	 */
	public JButton getBtnGestionarCarnesFrias() {
		return btnGestionarCarnesFrias;
	}

	/**
	 * Gets the btn gestionar productos lacteos.
	 *
	 * @return the btn gestionar productos lacteos
	 */
	public JButton getBtnGestionarProductosLacteos() {
		return btnGestionarProductosLacteos;
	}

	/**
	 * Gets the btn gestionar productos animales no lacteos.
	 *
	 * @return the btn gestionar productos animales no lacteos
	 */
	public JButton getBtnGestionarProductosAnimalesNoLacteos() {
		return btnGestionarProductosAnimalesNoLacteos;
	}

	/**
	 * Gets the btn gestionar frutas dulces.
	 *
	 * @return the btn gestionar frutas dulces
	 */
	public JButton getBtnGestionarFrutasDulces() {
		return btnGestionarFrutasDulces;
	}

	/**
	 * Gets the btn gestionar frutas acidas.
	 *
	 * @return the btn gestionar frutas acidas
	 */
	public JButton getBtnGestionarFrutasAcidas() {
		return btnGestionarFrutasAcidas;
	}

	/**
	 * Gets the btn gestionar verduras.
	 *
	 * @return the btn gestionar verduras
	 */
	public JButton getBtnGestionarVerduras() {
		return btnGestionarVerduras;
	}

	/**
	 * Gets the btn gestionar comida chatarra.
	 *
	 * @return the btn gestionar comida chatarra
	 */
	public JButton getBtnGestionarComidaChatarra() {
		return btnGestionarComidaChatarra;
	}
	
}
