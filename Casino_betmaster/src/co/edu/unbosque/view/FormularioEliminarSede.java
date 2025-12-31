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

public class FormularioEliminarSede extends JFrame {

	private JPanel panel;
	private JTextField numeroEmpleados;
	private JComboBox<String> ubicacionSede;
	private JButton eliminarSede;
	
	/**
	 * Instantiates a new formulario nuevos participantes.
	 */
	public FormularioEliminarSede() {
		
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

        
        JLabel textoLabel = new JLabel("Eliminar sede actual");
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
		
        
		ubicacionSede = new JComboBox<String>();
		ubicacionSede.setBounds(300,150, 200, 30); // Ajusta la posición y el tamaño según tus necesidades
		ubicacionSede.setBackground(Color.WHITE);
		ubicacionSede.addItem("Ubicación a eliminar");
	    panel.add(ubicacionSede);
	    
	    numeroEmpleados = new JTextField();
	    numeroEmpleados.setBounds(300, 190, 200, 30); 
	    numeroEmpleados.setEditable(false);
	    panel.add(numeroEmpleados);
	    
		
	    eliminarSede = new JButton("eliminar sede");
	    eliminarSede.setBounds(260, 390, 170, 50);
	    eliminarSede.setEnabled(true);
	    Color gris = new Color(128, 128, 128);
	    eliminarSede.setBackground(gris);
	    eliminarSede.setForeground(Color.WHITE);
	    panel.add(eliminarSede);
	
	}
	
	public boolean validarSeleccion() {
		if (ubicacionSede.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(
					this, 
					"La ubicación de la sede a eliminar no ha sido seleccionada",
					"ubicación no seleccionada",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		JOptionPane.showMessageDialog(this, 
				"La sede seleccionada ha sido eliminada exitosamente",
				"Sede eliminada",
				JOptionPane.INFORMATION_MESSAGE);
		return true;
	}

	public void desplegarSedesActuales(String[] sedes) {
		if (ubicacionSede.getSelectedItem() != null) {
			// Reiniciar el JComboBox
			while (ubicacionSede.getItemCount() > 0)
				ubicacionSede.removeItemAt(0);
			
			ubicacionSede.addItem("Ubicación a eliminar");
			
			for (int i = 0; i < sedes.length; i++)
				ubicacionSede.addItem(sedes[i]);
		}
	}
	
	public void actualizarNumeroDeEmpleados(int numeroEmpleadosAActualizar) {
		
		if (ubicacionSede.getSelectedItem() != null
				&& ubicacionSede.getSelectedIndex() != 0) {
			
			numeroEmpleados.setText(numeroEmpleadosAActualizar + "");
			
		} else if (ubicacionSede.getSelectedIndex() == 0) {
			numeroEmpleados.setText("");
		}
		
	}
	
	public String obtenerUbicacionSeleccionada() {
		if (ubicacionSede.getSelectedItem() == null)
			return "";
		return ubicacionSede.getSelectedItem().toString();
	}
	
	public void reiniciarCampos() {
		ubicacionSede.setSelectedIndex(0);
		numeroEmpleados.setText("");
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


	public JButton getEliminarSede() {
		return eliminarSede;
	}


	public void setEliminarSede(JButton eliminarSede) {
		this.eliminarSede = eliminarSede;
	}
	
}