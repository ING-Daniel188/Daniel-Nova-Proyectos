package co.edu.unbosque.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class FormularioNuevosParticipantes.
 */
public class FormularioAgregarApostador extends JFrame {
	private JTextField nombreCompleto;
	private JTextField cedula;
	private JComboBox<String> ubicacionSede;
	private JTextField direccion;
	private JTextField celular;
	private JButton agregarApostador;
	private JPanel panel;
	
	/**
	 * Instantiates a new formulario nuevos participantes.
	 */
	public FormularioAgregarApostador() {
		
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

        
        JLabel textoLabel = new JLabel("escriba datos del apostador ");
		textoLabel.setBounds(110,115, 460, 30);
		Color blancoHueso = new Color(248, 236, 203);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("escriba nombre completo");
		textoLabel.setBounds(10,150, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("escriba cedula del apostador");
		textoLabel.setBounds(10,190, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("escriba direccion del apostador");
		textoLabel.setBounds(10,230, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("escriba sede en la que jugara");
		textoLabel.setBounds(10,270, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("escriba el telefono celular");
		textoLabel.setBounds(10,310, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
        
		nombreCompleto = new JTextField();
		nombreCompleto.setBounds(300,150, 200, 30); // Ajusta la posición y el tamaño según tus necesidades
		nombreCompleto.setBackground(Color.WHITE);
	    panel.add(nombreCompleto);
	    
	    cedula = new JTextField();
	    cedula.setBounds(300, 190, 200, 30); 
	    panel.add(cedula);
		
	    direccion = new JTextField();
	    direccion.setBounds(300, 230, 200, 30); 
	    panel.add(direccion);
	    
	    celular = new JTextField();
	    celular.setBounds(300, 310, 200, 30); 
	    panel.add(celular);
	    
	    
	    ubicacionSede = new JComboBox<>();
	    ubicacionSede.setBackground(Color.WHITE);
	    ubicacionSede.setBounds(300,270, 200, 30); // Ajusta la posición y el tamaño según tus necesidades
	    ubicacionSede.addItem("Seleccionar Ubicación");
	    panel.add(ubicacionSede);
	    
	    agregarApostador = new JButton("Agregar apostador");
	    agregarApostador.setBounds(260, 390, 170, 50);
	    agregarApostador.setEnabled(true);
	    Color gris = new Color(128, 128, 128);
	    agregarApostador.setBackground(gris);
	    agregarApostador.setForeground(Color.WHITE);
	    panel.add(agregarApostador);
	
	}
	
	public void desplegarSedesActuales(String[] sedes) {
		if (ubicacionSede.getSelectedItem() != null) {
			// Reiniciar el JComboBox
			while (ubicacionSede.getItemCount() > 0)
				ubicacionSede.removeItemAt(0);
			
			ubicacionSede.addItem("Seleccionar Ubicación");
			
			for (int i = 0; i < sedes.length; i++)
				ubicacionSede.addItem(sedes[i]);
		}
	}
	
	public boolean validarDatos() {
		// Validar que todos los campos hayan sido ingresados
		if (nombreCompleto.getText().isEmpty()
				|| cedula.getText().isEmpty()
				|| ubicacionSede.getSelectedIndex() == 0
				|| direccion.getText().isEmpty()
				|| celular.getText().isEmpty()) {
			JOptionPane.showMessageDialog(
					this,
					"Hay campos vacíos",
					"1 o más campos no han sido ingresados",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		// Validar que el celular ingresado sea valido
		try {
			Long.parseLong(celular.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
					this,
					"El celular debe contener únicamente números",
					"El celular ingresado no es válido",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		JOptionPane.showMessageDialog(
				this,
				"El apostador ha sido agregado exitosamente",
				"Apostador agregado",
				JOptionPane.INFORMATION_MESSAGE);
		return true;
			
	}
	
	public void reiniciarCampos() {
		nombreCompleto.setText("");
		cedula.setText("");
		ubicacionSede.setSelectedIndex(0);
		direccion.setText("");
		celular.setText("");
	}
	
	public String obtenerNombreCompleto() {
		return nombreCompleto.getText();
	}
	
	public String obtenerCedula() {
		return cedula.getText();
	}
	
	public String obtenerSede() {
		return ubicacionSede.getSelectedItem().toString();
	}
	
	public String obtenerDireccion() {
		return direccion.getText();
	}
	
	public long obtenerCelular() {
		return Long.parseLong(celular.getText());
	}

	
	public JButton getAgregarApostador() {
		return agregarApostador;
	}

	public void setAgregarApostador(JButton agregarApostador) {
		this.agregarApostador = agregarApostador;
	}
	
}

