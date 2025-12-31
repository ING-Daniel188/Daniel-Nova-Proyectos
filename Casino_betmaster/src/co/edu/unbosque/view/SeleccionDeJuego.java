package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class SelccionDeJuego.
 */
public class SeleccionDeJuego extends JFrame  {
	
	private JPanel panel;
	private JLabel textoLabel;
	private JButton loteria;
	private JButton superastro;
	private JButton baloto;
	private JButton betplay;
	private JButton chance;

	private JTextField saldo;
	
	/**
	 * Instantiates a new selccion de juego.
	 */
	public SeleccionDeJuego() {
		setSize(700 , 700);

	    setLocationRelativeTo(null);
	    panel = new JPanel(null) { // Cambié a un layout nulo (null) para usar setBounds
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            // Cargar y dibujar la imagen como fondo
	            Image fondo = new ImageIcon("Imagenes\\selcciondejuego.jpeg").getImage();
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
	    
  	    setContentPane(panel);
  	    textoLabel = new JLabel("Bet Master");
  	    textoLabel.setFont(new Font("Comic Sans MS", Font.BOLD,35)); 
  	    textoLabel.setBounds(25, 25, 500, 50); 
  	    textoLabel.setForeground(Color.RED);
	    panel.add(textoLabel);

	     
	    textoLabel = new JLabel("seleccione su juego  ");
	 	textoLabel.setBounds(10,100, 460, 30);
	 	Color blancoHueso = new Color(248, 236, 203);
	    textoLabel.setForeground(blancoHueso);
	 	textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,30));
	 	panel.add(textoLabel);
	 	
	 	// Boton loteria
	 	loteria = new JButton("Loteria");
	 	loteria.setBounds(30, 200, 200, 50);
	 	loteria.setEnabled(true);

	    // Color amarillo para contrastar con el fondo negro
	    Color amarillo = new Color(255, 220, 77);
	    
	    loteria.setBackground(amarillo);
	    panel.add(loteria);
	    
	    // Boton superastro
	    superastro = new JButton("SuperAstro");
	    superastro.setBounds(30, 300, 200, 50);
	    superastro.setEnabled(true);

	    // Color amarillo para contrastar con el fondo negro
	    superastro.setBackground(amarillo);
	    panel.add(superastro);
	    
	    
	    // Boton baloto
	    baloto = new JButton("Baloto");
	    baloto.setBounds(30, 400, 200, 50);
	    baloto.setEnabled(true);

	    // Color amarillo para contrastar con el fondo negro
	    
	    baloto.setBackground(amarillo);
	    panel.add(baloto);
	    
	    
	    // Boton betplay
	    betplay = new JButton("BetPlay");
	    betplay.setBounds(350, 300, 200, 50);
	    betplay.setEnabled(true);

	    // Color amarillo para contrastar con el fondo negro
	    
	    betplay.setBackground(amarillo);
	    panel.add(betplay);
	    
	    // Boton chance
	    chance = new JButton("Chance");
	    chance.setBounds(350, 400, 200, 50);
	    chance.setEnabled(true);

	    // Color amarillo para contrastar con el fondo negro
	    
	    chance.setBackground(amarillo);
	    panel.add(chance);
	     
	    
	    saldo = new JTextField();
	    saldo.setBounds(350, 500, 130, 30); // Ajusta la posición y el tamaño según tus necesidades
	    saldo.setBackground(Color.WHITE);
	    saldo.setText("$20.000");
	    panel.add(saldo);
	    
	    
	    textoLabel = new JLabel("Su saldo es ");
    	textoLabel.setBounds(110,500, 460, 30);
        textoLabel.setForeground(blancoHueso);
    	textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,30));
    	panel.add(textoLabel);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getLoteria() {
		return loteria;
	}

	public void setLoteria(JButton loteria) {
		this.loteria = loteria;
	}

	public JButton getSuperastro() {
		return superastro;
	}

	public void setSuperastro(JButton superastro) {
		this.superastro = superastro;
	}

	public JButton getBaloto() {
		return baloto;
	}

	public void setBaloto(JButton baloto) {
		this.baloto = baloto;
	}

	public JButton getBetplay() {
		return betplay;
	}

	public void setBetplay(JButton betplay) {
		this.betplay = betplay;
	}

	public JButton getChance() {
		return chance;
	}

	public void setChance(JButton chance) {
		this.chance = chance;
	}

	public JTextField getSaldo() {
		return saldo;
	}

	public void setSaldo(JTextField saldo) {
		this.saldo = saldo;
	}
	
}

