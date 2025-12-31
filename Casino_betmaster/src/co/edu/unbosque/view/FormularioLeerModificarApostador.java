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

public class FormularioLeerModificarApostador extends JFrame {
	
	private JTextField cedulaABuscar;
	private JButton buscarApostador;
	
	private JTextField nombreCompleto;
	private JTextField cedula;
	private JTextField ubicacionSede;
	private JTextField direccion;
	private JTextField celular;
	private JButton modificarApostador;
	
	private JTextField nombreAModificar;
	private JTextField cedulaDelApostador;
	private JComboBox<String> ubicacionSedeAModificar;
	private JTextField direccionAModificar;
	private JTextField celularAModificar;
	private JPanel panel;
	
	/**
	 * Instantiates a new formulario nuevos participantes.
	 */
	public FormularioLeerModificarApostador() {
		
		setSize(600 , 700);
        setLocationRelativeTo(null);
        panel = new JPanel(null) { // Cambié a un layout nulo (null) para usar setBounds
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar y dibujar la imagen como fondo
                Image fondo = new ImageIcon("Imagenes\\perfil.jpeg").getImage();
 
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
                g.setColor(new Color(248, 236, 203).darker());
                // Dibuja un rectangulo que separa el area de visualizacion y modificacion del apostador
                g.drawRect(0, 360, getWidth(), 5);
                g.fillRect(0, 360, getWidth(), 5);
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
	    
	    
	    // Labels y areas de texto para modificar apostador
	    
	    textoLabel = new JLabel("Nombre completo a modificar");
		textoLabel.setBounds(10,380, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("Cedula del apostador");
		textoLabel.setBounds(10,420, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("Direccion a modificar");
		textoLabel.setBounds(10,460, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("Sede a modificar");
		textoLabel.setBounds(10,500, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("Telefono celular a modificar");
		textoLabel.setBounds(10,540, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
        
		nombreAModificar = new JTextField();
		nombreAModificar.setBounds(300,380, 200, 30); // Ajusta la posición y el tamaño según tus necesidades
		nombreAModificar.setBackground(Color.WHITE);
		nombreAModificar.setEditable(true);
	    panel.add(nombreAModificar);
	    
	    cedulaDelApostador = new JTextField();
	    cedulaDelApostador.setBounds(300, 420, 200, 30); 
	    cedulaDelApostador.setEditable(true);
	    panel.add(cedulaDelApostador);
	
	    direccionAModificar = new JTextField();
	    direccionAModificar.setBounds(300, 460, 200, 30);
	    direccionAModificar.setEditable(true);
	    panel.add(direccionAModificar);
	    
	    ubicacionSedeAModificar = new JComboBox<String>();
	    ubicacionSedeAModificar.setBackground(Color.WHITE);
	    ubicacionSedeAModificar.setBounds(300,500, 200, 30); // Ajusta la posición y el tamaño según tus necesidades
	    panel.add(ubicacionSedeAModificar);
	    
	    celularAModificar = new JTextField();
	    celularAModificar.setBounds(300, 540, 200, 30); 
	    celularAModificar.setEditable(true);
	    panel.add(celularAModificar);
	    
	    
	    modificarApostador = new JButton("Modificar apostador");
	    modificarApostador.setBounds(330, 600, 160, 50);
	    modificarApostador.setEnabled(true);
	    Color gris = new Color(128, 128, 128);
	    modificarApostador.setBackground(gris);
	    modificarApostador.setForeground(Color.WHITE);
	    panel.add(modificarApostador);
	
	}
	
	public void reiniciarCampos() {
		cedulaABuscar.setText("");
		
		nombreCompleto.setText("");
		cedula.setText("");
		ubicacionSede.setText("");
		direccion.setText("");
		celular.setText("");
		
		cedulaDelApostador.setText("");
		nombreAModificar.setText("");
		direccionAModificar.setText("");
		ubicacionSedeAModificar.setSelectedIndex(0);
		celularAModificar.setText("");
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
	
	public boolean apostadorAModificarEncontrado(int indiceApostador) {
		
		if (indiceApostador == -1) {
			JOptionPane.showMessageDialog(
					this,
					"La cédula del apostador a modificar no ha sido registrada",
					"Cédula no encontrada",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		JOptionPane.showMessageDialog(
				this,
				"El apostador ha sido modificado exitosamente",
				"Apostador modificado",
				JOptionPane.INFORMATION_MESSAGE);
		return true;
	}
	
	public boolean validarDatos() {
		// Validar que para modificar un apostador se hayan digitado todos los campos
		if (cedulaDelApostador.getText().isEmpty()
				|| nombreAModificar.getText().isEmpty()
				|| direccionAModificar.getText().isEmpty()
				|| ubicacionSedeAModificar.getSelectedIndex() == 0
				|| celularAModificar.getText().isEmpty()) {
			JOptionPane.showMessageDialog(
					this,
					"1 o más campos del apostador a modificar no han sido ingresados",
					"Campos sin ingresar",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		// Validar que el celular del apostador sea válido
		try {
			Long.parseLong(celularAModificar.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
					this,
					"El número de celular a modificar no es válido",
					"Celular a modificar no válido",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public void desplegarSedesActuales(String[] sedes) {
		// Reiniciar el JComboBox
		while (ubicacionSedeAModificar.getItemCount() > 0)
			ubicacionSedeAModificar.removeItemAt(0);
		
		ubicacionSedeAModificar.addItem("Seleccionar Ubicación");
		
		for (int i = 0; i < sedes.length; i++)
			ubicacionSedeAModificar.addItem(sedes[i]);
	}
	
	
	public String obtenerNombreAModificar() {
		return nombreAModificar.getText();
	}
	
	public String obtenerCedulaAModificar() {
		return cedulaDelApostador.getText();
	}
	
	public String obtenerDireccionAModificar() {
		return direccionAModificar.getText();
	}
	
	public String obtenerSedeAModificar() {
		return ubicacionSedeAModificar.getSelectedItem().toString();
	}
	
	public long obtenerCelularAModificar() {
		return Long.parseLong(celularAModificar.getText());
	}
	
	

	public JButton getBuscarApostador() {
		return buscarApostador;
	}

	public void setBuscarApostador(JButton buscarApostador) {
		this.buscarApostador = buscarApostador;
	}

	public JButton getModificarApostador() {
		return modificarApostador;
	}

	public void setModificarApostador(JButton modificarApostador) {
		this.modificarApostador = modificarApostador;
	}
	
}
