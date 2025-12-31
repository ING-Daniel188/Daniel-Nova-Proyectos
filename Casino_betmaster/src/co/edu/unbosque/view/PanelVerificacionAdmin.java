package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelVerificacionAdmin.
 */
public class PanelVerificacionAdmin extends JFrame {
	 private JTextField nombreField;
	 private JPanel panel;
	 private JButton validarCuenta;
	
	/**
	 * Instantiates a new panel verificacion admin.
	 */
	public PanelVerificacionAdmin() {
		setSize(400 , 500);
        setLocationRelativeTo(null);
        panel = new JPanel(null) { // Cambié a un layout nulo (null) para usar setBounds
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar y dibujar la imagen como fondo
                Image fondo = new ImageIcon("Imagenes\\adminfondo.jpeg").getImage();
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
	        
	        
        setContentPane(panel);
        JLabel label = new JLabel("Bet Master");
        label.setFont(new Font("Comic Sans MS", Font.BOLD,50)); 
        label.setBounds(50, 50, 500, 50); 
        label.setForeground(Color.RED);
        panel.add(label);

        iniciarComponentes();
	}
	private void iniciarComponentes() {
		ponerEtiqueta3();
		ponerCajaTexto();
		ponerEtiqueta1();
		ponerEtiqueta2();
		ponerCajaTexto1();
		botonverificar();
	}
	
	private void ponerEtiqueta1() {
		JLabel textoLabel = new JLabel("Nombre ");
		textoLabel.setBounds(10,180, 460, 30);
		Color blancoHueso = new Color(248, 236, 203);
        textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		panel.add(textoLabel);
		
    }	
	private void ponerCajaTexto() {
	    nombreField = new JTextField();
	    nombreField.setBounds(10, 215, 200, 30); 
	    panel.add(nombreField);
	}
	private void ponerEtiqueta2() {
		JLabel textoLabel = new JLabel("cedula ");
		textoLabel.setBounds(10,250, 460, 30);
		Color blancoHueso = new Color(248, 236, 203);
        textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		panel.add(textoLabel);
    }	
	private void ponerCajaTexto1() {
	    nombreField = new JTextField();
	    nombreField.setBounds(10, 290, 200, 30); 
	    panel.add(nombreField);
	}
	private void ponerEtiqueta3() {
		JLabel textoLabel = new JLabel("proceso de verificacion para cuenta admin ");
		textoLabel.setBounds(10,100, 460, 30);
		Color blancoHueso = new Color(248, 236, 203);
        textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		panel.add(textoLabel);
    }	
	private void botonverificar() {
		validarCuenta = new JButton("Validar Cuenta");
		validarCuenta.setBounds(85, 400, 200, 50);
		validarCuenta.setEnabled(true);

	    // Color amarillo para contrastar con el fondo negro
	    Color amarillo = new Color(255, 220, 77);
	    
	    validarCuenta.setBackground(amarillo);
	    panel.add(validarCuenta);
	}
	
	public JTextField getNombreField() {
		return nombreField;
	}
	public void setNombreField(JTextField nombreField) {
		this.nombreField = nombreField;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JButton getValidarCuenta() {
		return validarCuenta;
	}
	public void setValidarCuenta(JButton validarCuenta) {
		this.validarCuenta = validarCuenta;
	}
}
