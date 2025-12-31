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
import javax.swing.UIManager;

public class FormularioEliminarApostador extends JFrame {
	
	private JTextField cedulaABuscar;
	private JButton buscarApostador;
	
	private JTextField nombreCompleto;
	private JTextField cedula;
	private JTextField ubicacionSede;
	private JTextField direccion;
	private JTextField celular;
	private JButton eliminarApostador;
	private JPanel panel;
	
	/**
	 * Instantiates a new formulario nuevos participantes.
	 */
	public FormularioEliminarApostador() {
		
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
        
        // Labels y campos de texto para visualizar apostador
        
        setContentPane(panel);
        JLabel label = new JLabel("Bet Master");
        label.setFont(new Font("Comic Sans MS", Font.BOLD,50)); 
        label.setBounds(50, 50, 500, 50); 
        label.setForeground(Color.RED);
        panel.add(label);

        
        JLabel textoLabel = new JLabel("Digite la cedula del apostador");
		textoLabel.setBounds(10,115, 460, 30);
		Color blancoHueso = new Color(248, 236, 203);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		
		cedulaABuscar = new JTextField();
		cedulaABuscar.setBounds(300, 115, 100, 30);
		panel.add(cedulaABuscar);
		
		buscarApostador = new JButton("Buscar");
		buscarApostador.setBounds(410, 115, 90, 30);
		panel.add(buscarApostador);
		
		
		textoLabel = new JLabel("Nombre completo");
		textoLabel.setBounds(10,160, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("Cedula del apostador");
		textoLabel.setBounds(10,200, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("Direccion del apostador");
		textoLabel.setBounds(10,240, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("Sede en la que jugara");
		textoLabel.setBounds(10,280, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("Telefono celular");
		textoLabel.setBounds(10,320, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
        
		nombreCompleto = new JTextField();
		nombreCompleto.setBounds(300,160, 200, 30); // Ajusta la posición y el tamaño según tus necesidades
		nombreCompleto.setBackground(Color.WHITE);
		nombreCompleto.setEditable(false);
	    panel.add(nombreCompleto);
	    
	    cedula = new JTextField();
	    cedula.setBounds(300, 200, 200, 30); 
	    cedula.setEditable(false);
	    panel.add(cedula);
	
	    direccion = new JTextField();
	    direccion.setBounds(300, 240, 200, 30);
	    direccion.setEditable(false);
	    panel.add(direccion);
	    
	    ubicacionSede = new JTextField();
	    ubicacionSede.setBackground(Color.WHITE);
	    ubicacionSede.setBounds(300,280, 200, 30); // Ajusta la posición y el tamaño según tus necesidades
	    ubicacionSede.setEditable(false);
	    panel.add(ubicacionSede);
	    
	    celular = new JTextField();
	    celular.setBounds(300, 320, 200, 30); 
	    celular.setEditable(false);
	    panel.add(celular);
	    
	    
	    eliminarApostador = new JButton("Eliminar apostador");
	    eliminarApostador.setBounds(330, 380, 160, 50);
	    eliminarApostador.setEnabled(true);
	    Color gris = new Color(128, 128, 128);
	    eliminarApostador.setBackground(gris);
	    eliminarApostador.setForeground(Color.WHITE);
	    panel.add(eliminarApostador);
	
	}
	
	public void reiniciarCampos() {
		cedulaABuscar.setText("");
		nombreCompleto.setText("");
		cedula.setText("");
		ubicacionSede.setText("");
		direccion.setText("");
		celular.setText("");
	}
	
	public void llenarCamposApostador(String nombre, String cedula, String sede, String direccion, long celular) {
		nombreCompleto.setText(nombre);
		this.cedula.setText(cedula);
		this.direccion.setText(direccion);
		ubicacionSede.setText(sede);
		this.celular.setText(celular + "");
	}
	
	public String obtenerCedula() {
		return cedulaABuscar.getText();
	}
	
	public boolean apostadorEncontrado(int indiceApostador) {
		if (indiceApostador == -1) {
			JOptionPane.showMessageDialog(
					this,
					"La cédula ingresada no ha sido registrada",
					"Cédula no encontrada",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}
	
	
	public boolean validarCedula() {
		
		if (cedulaABuscar.getText().isEmpty()) {
			JOptionPane.showMessageDialog(
					this,
					"La cédula del apostador a eliminar no ha sido ingresada",
					"Cédula no ingresada",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	public boolean confirmarEliminacionApostador(String cedulaApostador) {
		UIManager.put("OptionPane.yesButtonText", "Si");
		UIManager.put("OptionPane.noButtonText", "No");
		int opcionElegida = JOptionPane.showConfirmDialog(
				this, 
				"Está seguro de que desea eliminar el apostador con cedula " + cedulaApostador + "?", 
				"Confirmación eliminación de apostador", 
				JOptionPane.QUESTION_MESSAGE);
		if (opcionElegida == 1 || opcionElegida == -1)
			return false;
		
		JOptionPane.showMessageDialog(
				this,
				"El apostador con cédula " + cedulaApostador + " ha sido eliminado exitosamente",
				"Apostador eliminado",
				JOptionPane.INFORMATION_MESSAGE);
		
		return true;
	}
	

	public JButton getBuscarApostador() {
		return buscarApostador;
	}

	public void setBuscarApostador(JButton buscarApostador) {
		this.buscarApostador = buscarApostador;
	}

	public JButton getEliminarApostador() {
		return eliminarApostador;
	}

	public void setEliminarApostador(JButton eliminarApostador) {
		this.eliminarApostador = eliminarApostador;
	}
	
}
