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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormularioAgregarSede extends JFrame {

	private JPanel panel;
	private JTextField numeroEmpleados;
	private JButton agregarSede;
	private JComboBox<String> ubicacionSede;
	
	/**
	 * Instantiates a new formulario nuevos participantes.
	 */
	public FormularioAgregarSede() {
		
		setSize(600 , 500);
        setLocationRelativeTo(null);
        panel = new JPanel(null) { // Cambié a un layout nulo (null) para usar setBounds
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar y dibujar la imagen como fondo
                Image fondo = new ImageIcon("Imagenes\\perfil.jpeg").getImage();
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        
        setContentPane(panel);
        JLabel label = new JLabel("Bet Master");
        label.setFont(new Font("Comic Sans MS", Font.BOLD,50)); 
        label.setBounds(50, 50, 500, 50); 
        label.setForeground(Color.RED);
        panel.add(label);

        
        JLabel textoLabel = new JLabel("Agregar nueva sede");
		textoLabel.setBounds(110,115, 460, 30);
		Color blancoHueso = new Color(248, 236, 203);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("seleccione la ubicación de la sede ");
		textoLabel.setBounds(10,150, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("escriba el número de empleados ");
		textoLabel.setBounds(10,190, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		
		String[] ubicaciones = { "Seleccionar Ubicación:", 
				"Antonio Narino", "Barrios Unidos", "Bosa", "Chapinero", "Ciudad Bolivar", 
			    "Engativa", "Fontibon", "Kennedy", "La Candelaria", "Los Martires", 
			    "Puente Aranda", "Rafael Uribe Uribe", "San Cristobal", "Santa Fe", 
			    "Suba", "Sumapaz", "Teusaquillo", "Tunjuelito", "Usaquen", "Usme" };
        
		ubicacionSede = new JComboBox<String>(ubicaciones);
		ubicacionSede.setBounds(300,150, 200, 30); // Ajusta la posición y el tamaño según tus necesidades
		ubicacionSede.setBackground(Color.WHITE);
	    panel.add(ubicacionSede);
	    
	    numeroEmpleados = new JTextField();
	    numeroEmpleados.setBounds(300, 190, 200, 30); 
	    panel.add(numeroEmpleados);
		
	    agregarSede = new JButton("guardar sede");
	    agregarSede.setBounds(260, 390, 170, 50);
	    agregarSede.setEnabled(true);
	    Color gris = new Color(128, 128, 128);
	    agregarSede.setBackground(gris);
	    agregarSede.setForeground(Color.WHITE);
	    panel.add(agregarSede);
	
	}
	
	
	public boolean validarCampos() {
		
		if (ubicacionSede.getSelectedIndex() == 0  || numeroEmpleados.getText().isEmpty()) {
			JOptionPane.showMessageDialog(
					this,
					"Todos los campos deben ser ingresados",
					"1 o más campos sin ingresar",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		try {
			Integer.parseInt(numeroEmpleados.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
					null,
					"El número de empleados debe ser un número entero",
					"Número de empleados no es un número",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		JOptionPane.showMessageDialog(
				null, "La sede ha sido agregada exitosamente",
				"Sede agregada",
				JOptionPane.INFORMATION_MESSAGE);
		
		return true;
	}
	
	public String obtenerUbicacionSede() {
		return ubicacionSede.getSelectedItem().toString();
	}
	
	public int obtenerNumeroEmpleados() {
		return Integer.parseInt(numeroEmpleados.getText());
	}

	public JPanel getPanel() {
		return panel;
	}


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	public JComboBox<String> getUbicacionSede() {
		return ubicacionSede;
	}


	public void setUbicacionSede(JComboBox<String> ubicacionSede) {
		this.ubicacionSede = ubicacionSede;
	}


	public JTextField getNumeroEmpleados() {
		return numeroEmpleados;
	}

	public void setNumeroEmpleados(JTextField numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	public JButton getAgregarSede() {
		return agregarSede;
	}

	public void setAgregarSede(JButton agregarSede) {
		this.agregarSede = agregarSede;
	}
	
}

