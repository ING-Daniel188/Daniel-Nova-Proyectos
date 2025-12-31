package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBetPlay extends JFrame {
	private int saldo = 20000000;
	private JTextField[] numeros;
	
	private JTextField cedula;
	private JComboBox<String> dias;
	private JTextField valor;
	private JComboBox<String> sedes;
	private JLabel equipo1Label[];
	private JLabel equipo2Label[];
	private JComboBox<String> resultadoComboBox[];
	
	private JButton apostar;
	private JButton modificar;
	private JButton eliminar;
	private JButton leer;
	private JButton regresar;
	
	private JLabel textoLabel;
    private JLabel resultadoLabel;
    private JLabel resultadoFinal;
    private JLabel resultadoDinero;
    private JPanel panel;
    
    /**
     * Instantiates a new super astro.
     */
    public PanelBetPlay() {
    	panel = new JPanel(null); 
   	    configurarVentana();
        agregarComponentes();
    }

    private void configurarVentana() {
        setSize(800, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        panel = new JPanel(null) { // Utiliza el JPanel de la clase
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image fondo = new ImageIcon("Imagenes\\BetPlay.jpeg").getImage();
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        setContentPane(panel);
	     JLabel label = new JLabel("Bet Master - BALOTO");
	     label.setFont(new Font("Comic Sans MS", Font.BOLD,35)); 
	     label.setBounds(25, 25, 500, 50); 
	     label.setForeground(Color.RED);
	     panel.add(label);
	     
	        Color blancoHueso = new Color(248, 236, 203);
			
			
			
			// Numero de loteria
	        textoLabel = new JLabel("<html>"
	        		+ "<head></head>"
	        		+ "<body>"
	        		+ "Escriba la cedula:"
	        		+ "</body>"
	        		+ "</html>");
	        textoLabel.setBounds(50, 30, 250, 100);
	        textoLabel.setForeground(blancoHueso);
	        textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));       
			panel.add(textoLabel);
			
			cedula = crearCajaTexto(50, 100, 200, 40);
			panel.add(cedula);
			
			
			// Dia de la apuesta
	        textoLabel = new JLabel("<html>"
	        		+ "<head></head>"
	        		+ "<body>"
	        		+ "Seleccione el dia de la apuesta:"
	        		+ "</body>"
	        		+ "</html>");
	        textoLabel.setBounds(270, 30, 300, 100);
	        textoLabel.setForeground(blancoHueso);
	        textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));       
			panel.add(textoLabel);
			
			
			
			String[] diasSemana = {"Seleccionar Dia:",
					"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
			
			dias = new JComboBox<String>(diasSemana);
			dias.setBackground(Color.white);
			dias.setBounds(300, 100, 200, 30);
			
			panel.add(dias);
			
			
			// Valor de la apuesta
	        textoLabel = new JLabel("<html>"
	        		+ "<head></head>"
	        		+ "<body>"
	        		+ "Seleccione la sede <br> de la apuesta:"
	        		+ "</body>"
	        		+ "</html>");
	        textoLabel.setBounds(560, 10, 250, 100);
	        textoLabel.setForeground(blancoHueso);
	        textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));       
			panel.add(textoLabel);
			
			
			sedes = new JComboBox<String>();
			sedes.setBackground(Color.white);
			sedes.setBounds(550, 100, 200, 30);
			
			panel.add(sedes);
			
			
			// Valor de la apuesta
	        textoLabel = new JLabel("Escriba el valor de la apuesta");
	        textoLabel.setBounds(50, 120, 400, 100);
	        textoLabel.setForeground(Color.black);
	        textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));       
			panel.add(textoLabel);
			
			
			valor = crearCajaTexto(450, 150, 200, 40);
			panel.add(valor);

        setContentPane(panel);
    }
  

   
    private void agregarComponentes() {
    	
    	resultadoComboBox = new JComboBox[14];
    	
    	String[] opciones = {"Seleccionar apuesta:", "Gana equipo 1", "Gana equipo 2", "Hay Empate"};
    	
    	int posicionY = 200;
    	for (int i = 0; i < resultadoComboBox.length; i++) {
    		resultadoComboBox[i] = new JComboBox<String>(opciones);
    		resultadoComboBox[i].setBounds(550, posicionY, 200, 25);
    		panel.add(resultadoComboBox[i]);
    		posicionY += 27;
    	}
    	
    	leer = crearBoton("Leer", 470, 590, 130, 50);
		
		apostar = crearBoton("Apostar", 610, 590, 140, 50);
		
		modificar = crearBoton("Modificar", 170, 590, 130, 50);
		
		eliminar = crearBoton("Eliminar", 310, 590, 150, 50);
		
		regresar = new JButton("regresar al menu");
		regresar.setBounds(25, 590, 140, 50);
		regresar.setEnabled(true);
	    Color amarillo = new Color(255, 220, 77);
	    regresar.setBackground(amarillo);
	    panel.add(regresar);
	    
	    addComponentes(apostar, leer, modificar, eliminar);
    	
    }
    


    private JTextField crearCajaTexto(int x, int y, int ancho, int alto) {
        JTextField cajaTexto = new JTextField();
        cajaTexto.setBounds(x, y, ancho, alto);
        cajaTexto.setFont(new Font("Arial", Font.PLAIN, 10));
        return cajaTexto;
    }

    private JButton crearBoton(String texto, int x, int y, int ancho, int alto) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, ancho, alto);
        boton.setFont(new Font("Arial", Font.BOLD, 20));
        return boton;
    }

    private JLabel crearLabel(String texto, int x, int y, int ancho, int alto, Color colorFondo, Color colorTexto) {
    	textoLabel = new JLabel(texto);
    	textoLabel.setBounds(x, y, ancho, alto);
    	textoLabel.setFont(new Font("Arial", Font.PLAIN, 15));
    	textoLabel.setHorizontalAlignment(JLabel.CENTER);
    	textoLabel.setOpaque(true);

        if (colorFondo != null) {
        	textoLabel.setBackground(colorFondo);
        }

        if (colorTexto != null) {
        	textoLabel.setForeground(colorTexto);
        }

        return textoLabel;
    }

    private void addComponentes(Component... componentes) {
        for (Component componente : componentes) {
            add(componente);
        }
    }
    
    public void desplegarSedesActuales(String[] sedes) {
    	// Reiniciar el JComboBox
		while (this.sedes.getItemCount() > 0)
			this.sedes.removeItemAt(0);
		
		this.sedes.addItem("Seleccionar Ubicación");
		for (int i = 0; i < sedes.length; i++)
			this.sedes.addItem(sedes[i]);
	}
    
    public void desplegarPartidos(String[][] partidos) {
    	int indicePartido = 0;
    	int posicionY = 200;
    	equipo1Label = new JLabel[14];
    	equipo2Label = new JLabel[14];
    	while (indicePartido < 14) {
    		equipo1Label[indicePartido] = crearLabel(partidos[0][indicePartido], 40, posicionY, 220, 25, Color.orange, Color.black);
    		equipo2Label[indicePartido] = crearLabel(partidos[1][indicePartido], 300, posicionY, 220, 25, Color.blue, Color.white);
    		panel.add(equipo1Label[indicePartido]);
    		panel.add(equipo2Label[indicePartido]);
    		posicionY += 27;
    		indicePartido++;
		}
    	
    }
    
    public String[][] obtenerPartidosYResultadosEscogidos() {
		String[][] partidosYResultadosEscogidos = new String[14][3];
		
		for (int i = 0; i < 14; i++) {
			partidosYResultadosEscogidos[i][0] = equipo1Label[i].getText();
			partidosYResultadosEscogidos[i][1] = equipo2Label[i].getText();
			partidosYResultadosEscogidos[i][2] = resultadoComboBox[i].getSelectedItem().toString();
		}
		
		return partidosYResultadosEscogidos;
	}
    
    
    public void actualizarCamposApuestaLeida(String cedula, String dia, String sede, double valorApuesta, String[][] partidosYResultadosEscogidos) {
    	
    	actualizarPartidosYApuestas(partidosYResultadosEscogidos);
    	
    	this.cedula.setText(cedula);
    	dias.setSelectedItem(dia);
    	sedes.setSelectedItem(sede);
    	valor.setText(valorApuesta + "");
    }
    
    public void actualizarPartidosYApuestas(String[][] partidosYResultadosEscogidos) {
    	for (int i = 0; i < partidosYResultadosEscogidos.length; i++) {
    		equipo1Label[i].setText(partidosYResultadosEscogidos[i][0]);
    		equipo2Label[i].setText(partidosYResultadosEscogidos[i][1]);
    		resultadoComboBox[i].setSelectedItem(partidosYResultadosEscogidos[i][2]);
    	}
    }
    
    
    public boolean validarApuesta() {
    	
    	
    	for (int i = 0; i < resultadoComboBox.length; i++) {
    		if (resultadoComboBox[i].getSelectedIndex() == 0) {
    			JOptionPane.showMessageDialog(
        				this,
        				"Uno o mas de las apuestas de los partidos no han sido seleccionados",
        				"Partidos no seleccionados",
        				JOptionPane.ERROR_MESSAGE);
    			return false;
    		}
    	}
    	 	
		
		// Validar la cedula
		if (cedula.getText().isEmpty()) {
			JOptionPane.showMessageDialog(
    				this,
    				"La cedula no ha sido ingresada",
    				"Cedula no ingresada",
    				JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		
		// Validar que se haya seleccionado un dia para la apuesta
		if (dias.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(
    				this,
    				"El día para la apuesta no ha sido seleccionado",
    				"Día no seleccionado",
    				JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		// Validar que se haya seleccionado una sede para la apuesta
		if (sedes.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(
    				this,
    				"La sede para la apuesta no ha sido seleccionada",
    				"Sede no seleccionada",
    				JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		
		// Validar el valor de la apuesta
		if (valor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(
    				this,
    				"El valor de la apuesta no ha sido ingresado",
    				"Valor no ingresado",
    				JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		// Validar que el valor de la apuesta sea un numero
		try {
			Double.parseDouble(valor.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
    				this,
    				"El valor de la apuesta no es válido",
    				"Valor de la apuesta inválido",
    				JOptionPane.ERROR_MESSAGE);
			return false;
		}
    	return true;
    }
    
    public boolean validarEliminacion() {
    	// Validar la que para eliminar una apuesta de betPlay se haya ingresado la cedula, la sede y el dia
		if (cedula.getText().isEmpty()) {
			JOptionPane.showMessageDialog(
    				this,
    				"La cedula no ha sido ingresada",
    				"Cedula no ingresada",
    				JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		
		// Validar que se haya seleccionado un dia para la apuesta
		if (dias.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(
    				this,
    				"El día para la apuesta no ha sido seleccionado",
    				"Día no seleccionado",
    				JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		// Validar que se haya seleccionado una sede para la apuesta
		if (sedes.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(
    				this,
    				"La sede para la apuesta no ha sido seleccionada",
    				"Sede no seleccionada",
    				JOptionPane.ERROR_MESSAGE);
			return false;
		}
    	return true;
    }
    
    public boolean validarIndiceApuestaALeer(int indice) {
		
		if (indice == -1) {
			JOptionPane.showMessageDialog(
					this,
					"La apuesta a leer no ha sido encontrada",
					"Apuesta no encontrada",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
    
    public boolean validarIndiceApuestaAEliminar(int indice) {
    	if (indice == -1) {
    		JOptionPane.showMessageDialog(
    				this,
    				"La apuesta de baloto a eliminar no ha sido encontrada con los datos ingresados",
    				"Apuesta no encontrada",
    				JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	JOptionPane.showMessageDialog(
				this,
				"La apuesta de baloto ha sido eliminada exitosamente",
				"Apuesta de baloto eliminada",
				JOptionPane.INFORMATION_MESSAGE);
    	return true;
    }
    
    public boolean validarCedula(int indiceApostador) {
    	
    	if (indiceApostador == -1) {
    		JOptionPane.showMessageDialog(
    				this,
    				"La cédula ingresada no está registrada",
    				"Cédula no encontrada",
    				JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
        
        JOptionPane.showMessageDialog(
				this,
				"La apuesta de betplay ha sido guardada exitosamente",
				"Apuesta de superastro agregada",
				JOptionPane.INFORMATION_MESSAGE);
        
    	return true;
    }
    
    public String obtenerSede() {
    	return sedes.getSelectedItem().toString();
    }
    
    public String obtenerCedula() {
    	return cedula.getText();
    }
    
    public String obtenerDia() {
    	return dias.getSelectedItem().toString();
    }
    
    public double obtenerValor() {
    	return Double.parseDouble(valor.getText());
    }
    
    
    public int[] obtenerNumeros() {
    	int[] numerosSeleccionados = new int[6];
    	for (int i = 0; i < numeros.length; i++)
    		numerosSeleccionados[i] = Integer.parseInt(numeros[i].getText());
    	
    	return numerosSeleccionados;
    }
    
    public void reiniciarCampos() {
    	
    	for (int i = 0; i < resultadoComboBox.length; i++) {
    		resultadoComboBox[i].setSelectedIndex(0);
    	}
    	
    	cedula.setText("");
    	dias.setSelectedIndex(0);
    	sedes.setSelectedIndex(0);
    	valor.setText("");
    }
    
    public boolean validarLeerBetPlay() {
    	
    	// Validar que para leer una apuesta de chance se haya digitado la cedula, la sede de la apuesta y dia
    	
    	// Validar la cedula
		if (cedula.getText().isEmpty()) {
			JOptionPane.showMessageDialog(
    				this,
    				"La cedula no ha sido ingresada",
    				"Cedula no ingresada",
    				JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		
		// Validar que se haya seleccionado un dia para la apuesta
		if (dias.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(
    				this,
    				"El día para la apuesta no ha sido seleccionado",
    				"Día no seleccionado",
    				JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		// Validar que se haya seleccionado una sede para la apuesta
		if (sedes.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(
    				this,
    				"La sede para la apuesta no ha sido seleccionada",
    				"Sede no seleccionada",
    				JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
    }

    
	public JButton getApostar() {
		return apostar;
	}

	public void setApostar(JButton apostar) {
		this.apostar = apostar;
	}

	public JButton getRegresar() {
		return regresar;
	}

	public void setRegresar(JButton regresar) {
		this.regresar = regresar;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public JTextField[] getNumeros() {
		return numeros;
	}

	public void setNumeros(JTextField[] numeros) {
		this.numeros = numeros;
	}

	public JTextField getCedula() {
		return cedula;
	}

	public void setCedula(JTextField cedula) {
		this.cedula = cedula;
	}

	public JComboBox<String> getDias() {
		return dias;
	}

	public void setDias(JComboBox<String> dias) {
		this.dias = dias;
	}

	public JTextField getValor() {
		return valor;
	}

	public void setValor(JTextField valor) {
		this.valor = valor;
	}

	public JComboBox<String> getSedes() {
		return sedes;
	}

	public void setSedes(JComboBox<String> sedes) {
		this.sedes = sedes;
	}

	public JButton getModificar() {
		return modificar;
	}

	public void setModificar(JButton modificar) {
		this.modificar = modificar;
	}

	public JButton getEliminar() {
		return eliminar;
	}

	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}

	public JButton getLeer() {
		return leer;
	}

	public void setLeer(JButton leer) {
		this.leer = leer;
	}

	public JLabel getTextoLabel() {
		return textoLabel;
	}

	public void setTextoLabel(JLabel textoLabel) {
		this.textoLabel = textoLabel;
	}

	public JLabel getResultadoLabel() {
		return resultadoLabel;
	}

	public void setResultadoLabel(JLabel resultadoLabel) {
		this.resultadoLabel = resultadoLabel;
	}

	public JLabel getResultadoFinal() {
		return resultadoFinal;
	}

	public void setResultadoFinal(JLabel resultadoFinal) {
		this.resultadoFinal = resultadoFinal;
	}

	public JLabel getResultadoDinero() {
		return resultadoDinero;
	}

	public void setResultadoDinero(JLabel resultadoDinero) {
		this.resultadoDinero = resultadoDinero;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}