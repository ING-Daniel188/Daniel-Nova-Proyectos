package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * The Class PaginaPrincipal.
 */
public class PaginaPrincipal extends JFrame {
    private JPanel panel;
    private JButton admin;
    private JButton clientes;
    private Color rojoMenosIntenso;

    /**
     * Instantiates a new pagina principal.
     */
    public PaginaPrincipal() {
        setSize(900, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un JPanel para el contenido
        panel = new JPanel(null) { // Cambié a un layout nulo (null) para usar setBounds
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                	Image fondo = new ImageIcon("Imagenes\\Fondocasino.jpeg").getImage();
                    g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        setContentPane(panel);
        JLabel label = new JLabel("Bet Master");
        label.setFont(new Font("Comic Sans MS", Font.BOLD,50)); 
        label.setBounds(300, 50, 500, 50); 
        label.setForeground(Color.RED);
        panel.add(label);

        
        // Iniciar componentes
        admin = new JButton("Admin");
    	admin.setBounds(600, 550, 150, 125);
    	admin.setEnabled(true);
        rojoMenosIntenso = new Color(255, 150, 150);
        admin.setBackground(rojoMenosIntenso);
        panel.add(admin);
    	
        clientes = new JButton("clientes");
        clientes.setBounds(150, 550, 150, 125);
        clientes.setEnabled(true);
        rojoMenosIntenso = new Color(255, 150, 150);       
        clientes.setBackground(rojoMenosIntenso);
        panel.add(clientes);
        
        
        // Poner etiqueta 3
        JLabel textoLabel = new JLabel("Seleccione uno para para abrir su repectiva interfaz");
		textoLabel.setBounds(120,190, 700, 30);
		Color blancoHueso = new Color(248, 236, 203);
        textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		panel.add(textoLabel);
    }


	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getAdmin() {
		return admin;
	}

	public void setAdmin(JButton admin) {
		this.admin = admin;
	}

	public JButton getClientes() {
		return clientes;
	}

	public void setClientes(JButton clientes) {
		this.clientes = clientes;
	}

	public Color getRojoMenosIntenso() {
		return rojoMenosIntenso;
	}

	public void setRojoMenosIntenso(Color rojoMenosIntenso) {
		this.rojoMenosIntenso = rojoMenosIntenso;
	}	

}

