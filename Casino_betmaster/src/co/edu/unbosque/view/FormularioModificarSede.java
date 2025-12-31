package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormularioModificarSede extends JFrame {

	private JPanel panel;
	private JTextField numeroEmpleados;
	private JComboBox<String> ubicacionSede;
	private String[] ubicaciones = { "Seleccionar Ubicación:", 
			"Antonio Narino", "Barrios Unidos", "Bosa", "Chapinero", "Ciudad Bolivar", 
		    "Engativa", "Fontibon", "Kennedy", "La Candelaria", "Los Martires", 
		    "Puente Aranda", "Rafael Uribe Uribe", "San Cristobal", "Santa Fe", 
		    "Suba", "Sumapaz", "Teusaquillo", "Tunjuelito", "Usaquen", "Usme" };
	
	private JTextField nuevoNumeroEmpleados;
	private JComboBox<String> nuevaUbicacionSede;
	
	private JButton modificarSede;
	
	/**
	 * Instantiates a new formulario nuevos participantes.
	 */
	public FormularioModificarSede() {
		
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

        
        JLabel textoLabel = new JLabel("Modificar sede actual");
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
		
		textoLabel = new JLabel("Número actual de empleados ");
		textoLabel.setBounds(10,190, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		
		textoLabel = new JLabel("Nueva ubicación de la sede ");
		textoLabel.setBounds(10,250, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("Nuevo número de empleados ");
		textoLabel.setBounds(10,290, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
        
		ubicacionSede = new JComboBox<String>();
		ubicacionSede.setBounds(300,150, 200, 30); // Ajusta la posición y el tamaño según tus necesidades
		ubicacionSede.setBackground(Color.WHITE);
		ubicacionSede.addItem("Ubicación a modificar");
	    panel.add(ubicacionSede);
	    
	    numeroEmpleados = new JTextField();
	    numeroEmpleados.setBounds(300, 190, 200, 30); 
	    numeroEmpleados.setEditable(false);
	    panel.add(numeroEmpleados);
	    
	    
	    nuevaUbicacionSede = new JComboBox<String>(ubicaciones);
	    nuevaUbicacionSede.setBounds(300,250, 200, 30); // Ajusta la posición y el tamaño según tus necesidades
	    nuevaUbicacionSede.setBackground(Color.WHITE);
	    panel.add(nuevaUbicacionSede);
	    
	    nuevoNumeroEmpleados = new JTextField();
	    nuevoNumeroEmpleados.setBounds(300, 290, 200, 30); 
	    nuevoNumeroEmpleados.setEditable(true);
	    panel.add(nuevoNumeroEmpleados);
	    
		
	    modificarSede = new JButton("modificar sede");
	    modificarSede.setBounds(260, 390, 170, 50);
	    modificarSede.setEnabled(true);
	    Color gris = new Color(128, 128, 128);
	    modificarSede.setBackground(gris);
	    modificarSede.setForeground(Color.WHITE);
	    panel.add(modificarSede);
	
	}
	
	
	public boolean validarCampos() {
		
		if (nuevaUbicacionSede.getSelectedIndex() == 0 || 
				nuevoNumeroEmpleados.getText().isEmpty()) {
			JOptionPane.showMessageDialog(
					this,
					"1 o más campos sin ingresar",
					"Datos sin ingresar",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		JOptionPane.showMessageDialog(
				null, "La sede ha sido modificada exitosamente",
				"Sede modificada",
				JOptionPane.INFORMATION_MESSAGE);
		
		return true;
	}
	
	public String obtenerUbicacionSede() {
		return ubicacionSede.getSelectedItem().toString();
	}
	
	

	public void desplegarSedesActuales(String[] sedes) {
		if (ubicacionSede.getSelectedItem() != null) {
			// Reiniciar el JComboBox
			while (ubicacionSede.getItemCount() > 0)
				ubicacionSede.removeItemAt(0);
			
			ubicacionSede.addItem("Ubicación a modificar");
			
			for (int i = 0; i < sedes.length; i++)
				ubicacionSede.addItem(sedes[i]);
		}
	}
	
	public void actualizarCampos(int numeroEmpleadosAActualizar) {
		
		if (ubicacionSede.getSelectedItem() != null
				&& ubicacionSede.getSelectedIndex() != 0) {
			
			if (numeroEmpleadosAActualizar != -1) {
				// Actualizar el número de empleados de la sede seleccionada
				numeroEmpleados.setText(numeroEmpleadosAActualizar + "");
			} else {
				numeroEmpleados.setText("La sede seleccionada no tiene empleados actualmente");
			}
		}
		
		if (ubicacionSede.getSelectedIndex() != 0) {
			habilitarCampos();
		} else {
			deshabilitarCampos();
		}
		
	}
	
	public void deshabilitarCampos() {
		nuevaUbicacionSede.setEnabled(false);
		nuevoNumeroEmpleados.setEditable(false);
	}
	
	public void habilitarCampos() {
		nuevaUbicacionSede.setEnabled(true);
		nuevoNumeroEmpleados.setEditable(true);
	}
	
	public void reiniciarCampos() {
		ubicacionSede.setSelectedIndex(0);
		numeroEmpleados.setText("");
		nuevaUbicacionSede.setSelectedIndex(0);
		nuevoNumeroEmpleados.setText("");
	}
	
	public String obtenerUbicacionSeleccionada() {
		if (ubicacionSede.getSelectedItem() == null)
			return "";
		return ubicacionSede.getSelectedItem().toString();
	}
	
	public String obtenerNuevaUbicacion() {
		return nuevaUbicacionSede.getSelectedItem().toString();
	}
	
	public int obtenerNuevoNumeroEmpleados() {
		return Integer.parseInt(nuevoNumeroEmpleados.getText());
	}
	
	
	public JPanel getPanel() {
		return panel;
	}


	public JTextField getNuevoNumeroEmpleados() {
		return nuevoNumeroEmpleados;
	}


	public void setNuevoNumeroEmpleados(JTextField nuevoNumeroEmpleados) {
		this.nuevoNumeroEmpleados = nuevoNumeroEmpleados;
	}


	public JComboBox<String> getNuevaUbicacionSede() {
		return nuevaUbicacionSede;
	}


	public void setNuevaUbicacionSede(JComboBox<String> nuevaUbicacionSede) {
		this.nuevaUbicacionSede = nuevaUbicacionSede;
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


	public JButton getModificarSede() {
		return modificarSede;
	}


	public void setModificarSede(JButton modificarSede) {
		this.modificarSede = modificarSede;
	}
	
}


