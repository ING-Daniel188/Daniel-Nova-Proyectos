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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormularioParametros extends JFrame {

	private JLabel textoLabel;
	private JPanel panel;
	private Color blancoHueso;
	private JButton leerParametros;
	private JButton guardarParametros;
	private JTextField nombreCasa;
	private JTextField numeroSedes;
	private JTextField presupuestoDisponible;
	
	/**
	 * Instantiates a new formulario nuevos participantes.
	 */
	public FormularioParametros() {
		
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

        
        blancoHueso = new Color(248, 236, 203);
        
        textoLabel = new JLabel("escriba los parametros de la casa de apuestas");
		textoLabel.setBounds(110,115, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("escriba nombre de la casa de apuestas ");
		textoLabel.setBounds(10,150, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("escriba numero de sedes ");
		textoLabel.setBounds(10,190, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
		
		textoLabel = new JLabel("escriba presupuesto total disponible ");
		textoLabel.setBounds(10,230, 460, 30);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
        
		
		nombreCasa = new JTextField();
		nombreCasa.setBounds(350,150, 200, 30); // Ajusta la posición y el tamaño según tus necesidades
		nombreCasa.setBackground(Color.WHITE);
	    panel.add(nombreCasa);
	    
	    numeroSedes = new JTextField();
	    numeroSedes.setBounds(350, 190, 200, 30); 
	    panel.add(numeroSedes);
		
	    presupuestoDisponible = new JTextField();
	    presupuestoDisponible.setBounds(350, 230, 200, 30); 
	    panel.add(presupuestoDisponible);
	    
	    
	    Color gris = new Color(128, 128, 128);
	    
	    leerParametros = new JButton("leer parametros");
	    leerParametros.setBounds(50, 390, 180, 50);
	    leerParametros.setEnabled(true);
	    leerParametros.setBackground(gris);
	    leerParametros.setForeground(Color.WHITE);
	    panel.add(leerParametros);
	    
	    
	    guardarParametros = new JButton("guardar parametros");
	    guardarParametros.setBounds(250, 390, 180, 50);
	    guardarParametros.setEnabled(true);
	    guardarParametros.setBackground(gris);
	    guardarParametros.setForeground(Color.WHITE);
	    panel.add(guardarParametros);
	
	}
	
	
	public boolean validarParametros() {
		// Validar que todos los parametros hayan sido ingresados
		if (nombreCasa.getText().isEmpty() 
				|| numeroSedes.getText().isEmpty()
				|| presupuestoDisponible.getText().isEmpty()) {
			JOptionPane.showMessageDialog(
					this,
					"Todos los campos deben ser ingresados",
					"1 o mas campos vacios",
					JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		// Validar que el numero de sedes sea entero y el presupuesto decimal
		try {
			Integer.parseInt(numeroSedes.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(
					this,
					"El numero de sedes debe ser numero entero",
					"Numero de sedes no valido",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		// Validar que el numero de sedes sea entero y el presupuesto decimal
		try {
			Double.parseDouble(presupuestoDisponible.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(
					this,
					"El presupuesto disponible debe ser decimal",
					"Presupuesto disponible no valido",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		JOptionPane.showMessageDialog(
				this,
				"Los parametros han sido guardados correctamente",
				"Parametros guardados", 
				JOptionPane.INFORMATION_MESSAGE);
		
		return true;
	}
	
	
	public void cargarParametros(String nombreCasa, int numeroSedes, double presupuestoTotal) {
		
		boolean cargarParametros = false;
		
		// Revisar si la casa de apuestas ya ha sido parametrizada
		if (!nombreCasa.isEmpty()) {
			
			try {
				// Obtener los campos del panel parametrización casa de apuestas
				String campoNombreCasa = getNombreCasa().getText();
				int campoNumeroSedes = Integer.parseInt(getNumeroSedes().getText());
				double campoPresupuestoTotal = Double.parseDouble(getPresupuestoDisponible().getText());
				
				// Revisar si los parametros ya han sido agregados y si todos son iguales a los actuales
				if (!nombreCasa.equals(campoNombreCasa) 
						|| numeroSedes != campoNumeroSedes 
						|| presupuestoTotal != campoPresupuestoTotal) {
					cargarParametros = true;
				} else {
					JOptionPane.showMessageDialog(
							this, 
							"Los parámetros de la casa de apuestas ya han sido cargados",
							"Parámetros ya cargados",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (NumberFormatException e) { cargarParametros = true; }
			
		} else {
			JOptionPane.showMessageDialog(
					this, 
					"La casa de apuestas aun no ha sido parametrizada",
					"Casa de Apuestas no parametrizada",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (cargarParametros) {
			// Desplegar los parametros actuales de la casa de apuestas en los campos
			getNombreCasa().setText(nombreCasa);
			getNumeroSedes().setText(numeroSedes + "");
			getPresupuestoDisponible().setText(presupuestoTotal + "");
		}

	}
	
	
	public String obtenerNombreCasa() {
		return nombreCasa.getText();
	}
	
	public int obtenerNumeroSedes() {
		return Integer.parseInt(numeroSedes.getText());
	}
	
	public double obtenerPresupuestoDisponible() {
		return Double.parseDouble(presupuestoDisponible.getText());
	}
	

	public JButton getGuardarParametros() {
		return guardarParametros;
	}

	public void setGuardarParametros(JButton guardarParametros) {
		this.guardarParametros = guardarParametros;
	}

	public JTextField getNombreCasa() {
		return nombreCasa;
	}

	public void setNombreCasa(JTextField nombreCasa) {
		this.nombreCasa = nombreCasa;
	}

	public JTextField getNumeroSedes() {
		return numeroSedes;
	}

	public void setNumeroSedes(JTextField numeroSedes) {
		this.numeroSedes = numeroSedes;
	}

	public JTextField getPresupuestoDisponible() {
		return presupuestoDisponible;
	}

	public JButton getLeerParametros() {
		return leerParametros;
	}

	public void setLeerParametros(JButton leerParametros) {
		this.leerParametros = leerParametros;
	}

	public void setPresupuestoDisponible(JTextField presupuestoDisponible) {
		this.presupuestoDisponible = presupuestoDisponible;
	}
	
}

