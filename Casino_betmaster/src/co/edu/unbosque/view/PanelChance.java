package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelChance extends JFrame {
	private int saldo = 10000000;
	
	private JTextField numeroChance;
	private JComboBox<String> tipoLoteria;
	
	private JTextField cedula;
	private JComboBox<String> dias;
	private JTextField valor;
	private JComboBox<String> sedes;
	
	private JButton apostar;
	private JButton modificar;
	private JButton leer;
	private JButton eliminar;
	private JButton regresar;
	
	private JLabel textoLabel;
    private JLabel resultadoLabel;
    private JLabel resultadoFinal;
    private JLabel resultadoDinero;
    private JPanel panel;
    
    /**
     * Instantiates a new loteria.
     */
    public PanelChance() {
    	panel = new JPanel(null); 
    	 configurarVentana();
         agregarComponentes();
    }

    private void configurarVentana() {
        setSize(800, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        panel = new JPanel(null) { // Utiliza el JPanel de la clase
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image fondo = new ImageIcon("Imagenes\\chance.jpg").getImage();
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        setContentPane(panel);
        textoLabel = new JLabel("Bet Master - CHANCE");
        textoLabel.setFont(new Font("Comic Sans MS", Font.BOLD,35)); 
        textoLabel.setBounds(25, 25, 500, 50); 
        textoLabel.setForeground(Color.RED);
	    panel.add(textoLabel);

        setContentPane(panel);
    }
  

   
    private void agregarComponentes() {
        resultadoLabel = crearLabel("", 80, 480, 600, 30, Color.yellow, Color.black);
        resultadoFinal = crearLabel("", 80, 530, 600, 30, Color.white, Color.black);
        resultadoDinero = crearLabel(" SU SALDO ES ", 50, 500, 600, 30, Color.green, Color.black);

        
        // Numero de loteria
//        textoLabel = new JLabel("<html>"
//        		+ "<head></head>"
//        		+ "<body>"
//        		+ "Escriba el número que va a apostar:"
//        		+ "</body>"
//        		+ "</html>");
        textoLabel = new JLabel("Escriba el número que va a apostar:");
        textoLabel.setBounds(50, 80, 500, 100);
        Color blancoHueso = new Color(248, 236, 203);
        textoLabel.setForeground(blancoHueso);
        textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));       
		panel.add(textoLabel);
		
		numeroChance = crearCajaTexto(50, 200, 200, 30);
		
		textoLabel = new JLabel("<html>"
        		+ "<head></head>"
        		+ "<body>"
        		+ "Seleccione tipo de loteria a apostar:"
        		+ "</body>"
        		+ "</html>");
    	textoLabel.setBounds(550, 80, 250, 100);
        textoLabel.setForeground(blancoHueso);
        textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));       
		panel.add(textoLabel);
		
		
		String[] tiposDeloteria = { "Seleccionar Lotería:", "Lotería de Bogotá", "Lotería de Boyacá", "Lotería del Cauca", "Lotería Cruz Roja",
				"Lotería de Cundinamarca", "Lotería del Huila", "Lotería de Manizales", "Lotería de Medellín",
				"Lotería del Meta", "Lotería del Quindío", "Lotería de Risaralda", "Lotería de Santander",
				"Lotería del Tolima", "Lotería del Valle" };
		
		
		// Tipo de loteria
		tipoLoteria = new JComboBox<String>(tiposDeloteria);
		tipoLoteria.setBounds(550, 200, 200, 30);
		tipoLoteria.setBackground(Color.white);
		panel.add(tipoLoteria);
		
		
		// Numero de loteria
        textoLabel = new JLabel("<html>"
        		+ "<head></head>"
        		+ "<body>"
        		+ "Escriba la cedula:"
        		+ "</body>"
        		+ "</html>");
        textoLabel.setBounds(50, 230, 250, 100);
        textoLabel.setForeground(blancoHueso);
        textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));       
		panel.add(textoLabel);
		
		cedula = crearCajaTexto(50, 330, 200, 40);
		panel.add(cedula);
		
		
		// Dia de la apuesta
        textoLabel = new JLabel("<html>"
        		+ "<head></head>"
        		+ "<body>"
        		+ "Seleccione el dia <br> de la apuesta:"
        		+ "</body>"
        		+ "</html>");
        textoLabel.setBounds(300, 230, 250, 100);
        textoLabel.setForeground(blancoHueso);
        textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));       
		panel.add(textoLabel);
		
		
		
		String[] diasSemana = {"Seleccionar Dia:",
				"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
		
		dias = new JComboBox<String>(diasSemana);
		dias.setBackground(Color.white);
		dias.setBounds(300, 330, 200, 30);
		
		panel.add(dias);
		
		
		// Valor de la apuesta
        textoLabel = new JLabel("<html>"
        		+ "<head></head>"
        		+ "<body>"
        		+ "Seleccione la sede <br> de la apuesta:"
        		+ "</body>"
        		+ "</html>");
        textoLabel.setBounds(550, 230, 250, 100);
        textoLabel.setForeground(blancoHueso);
        textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));       
		panel.add(textoLabel);
		
		
		sedes = new JComboBox<String>();
		sedes.setBackground(Color.white);
		sedes.setBounds(550, 330, 200, 30);
		
		panel.add(sedes);
		
		
		// Valor de la apuesta
        textoLabel = new JLabel("Escriba el valor de la apuesta");
        textoLabel.setBounds(70, 380, 400, 100);
        textoLabel.setForeground(blancoHueso);
        textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));       
		panel.add(textoLabel);
		
		
		valor = crearCajaTexto(430, 410, 200, 40);
		panel.add(valor);
		
		
		leer = crearBoton("Leer", 590, 25, 140, 50);
		
		apostar = crearBoton("Apostar", 590, 590, 140, 50);
		
		modificar = crearBoton("Modificar", 260, 590, 130, 50);
		
		eliminar = crearBoton("Eliminar", 410, 590, 150, 50);
		
		regresar = new JButton("regresar al menu");
		regresar.setBounds(80, 590, 140, 50);
		regresar.setEnabled(true);
	    Color amarillo = new Color(255, 220, 77);
	    regresar.setBackground(amarillo);
	    panel.add(regresar);
        
        addComponentes(numeroChance, apostar, leer, modificar, eliminar, resultadoLabel, resultadoFinal);
    }

    private JTextField crearCajaTexto(int x, int y, int ancho, int alto) {
        JTextField cajaTexto = new JTextField();
        cajaTexto.setBounds(x, y, ancho, alto);
        cajaTexto.setFont(new Font("Arial", Font.PLAIN, 20));
        return cajaTexto;
    }

    private JButton crearBoton(String texto, int x, int y, int ancho, int alto) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, ancho, alto);
        boton.setFont(new Font("Arial", Font.BOLD, 20));
        return boton;
    }

    private JLabel crearLabel(String texto, int x, int y, int ancho, int alto, Color colorFondo, Color colorTexto) {
        JLabel label = new JLabel(texto);
        label.setBounds(x, y, ancho, alto);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);

        if (colorFondo != null) {
            label.setBackground(colorFondo);
        }

        if (colorTexto != null) {
            label.setForeground(colorTexto);
        }

        return label;
    }

    private void addComponentes(Component... componentes) {
        for (Component componente : componentes) {
            add(componente);
        }
    }
    

    private int[] generarNumerosAleatorios() {
        int[] numerosAleatorios = new int[4];
        Random random = new Random();
        for (int i = 0; i < numerosAleatorios.length; i++) {
            numerosAleatorios[i] = random.nextInt(10); // Números aleatorios del 0 al 9
        }
        return numerosAleatorios;
    }

    private boolean sonIguales(String numerosIngresados, int[] numerosAleatorios) {
        for (int i = 0; i < numerosAleatorios.length; i++) {
            int digito = Character.getNumericValue(numerosIngresados.charAt(i));
            if (digito != numerosAleatorios[i]) {
                return false;
            }
        }
        return true;
    }

    
    
    public boolean validarApuesta() {
    	
    	
    	// Obtener los números ingresados por el usuario
        String numerosIngresados = numeroChance.getText();
        if (numerosIngresados.length() != 4) {
            JOptionPane.showMessageDialog(
            		this, 
            		"Ingrese exactamente 4 números.", 
            		"Número de lotería no válido", 
            		JOptionPane.ERROR_MESSAGE);
            return false;
        }
    	
		
		// Validar que el tipo de loteria haya sido seleccionado
		if (tipoLoteria.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(
    				this,
    				"El tipo de loteria no ha sido seleccionado",
    				"Tipo de loteria no seleccionado",
    				JOptionPane.ERROR_MESSAGE);
			return false;
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
    
    public void actualizarCamposApuestaLeida(int[] numeros, String tipoLoteria, String cedula, String dia, String sede, double valorApuesta) {
    	
    	String numerosStr = "";
    	for (int i = 0; i < numeros.length; i++) {
    		numerosStr += numeros[i] + "";
    	}
    	int numero = Integer.parseInt(numerosStr);
    	this.numeroChance.setText(numero + "");
    	
    	this.tipoLoteria.setSelectedItem(tipoLoteria);
    	
    	this.cedula.setText(cedula);
    	dias.setSelectedItem(dia);
    	sedes.setSelectedItem(sede);
    	valor.setText(valorApuesta + "");
    }

    public void desplegarSedesActuales(String[] sedes) {
    	// Reiniciar el JComboBox
		while (this.sedes.getItemCount() > 0)
			this.sedes.removeItemAt(0);
		
		this.sedes.addItem("Seleccionar Ubicación");
		
		for (int i = 0; i < sedes.length; i++)
			this.sedes.addItem(sedes[i]);
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
    	
    	String numerosIngresados = numeroChance.getText();
    	
    	// Generar números aleatorios
        int[] numerosAleatorios = generarNumerosAleatorios();

        // Mostrar los números generados aleatoriamente
        resultadoFinal.setText("Números ganadores son  " + Arrays.toString(numerosAleatorios));

        // Comparar los números y mostrar el resultado
        if (sonIguales(numerosIngresados, numerosAleatorios)) {
        	saldo += Double.parseDouble(valor.getText()); // El jugador gana su apuesta
            resultadoLabel.setText("¡Felicidades! Ganó.su nuevo saldo es"+saldo);
        } else {
        	saldo -= Double.parseDouble(valor.getText()); // El jugador pierde su apuesta
            resultadoLabel.setText("Lo siento, perdió. su nuevo saldo es "+saldo);
        }
        resultadoDinero.setText("Su saldo es: " + saldo);
    	
    	JOptionPane.showMessageDialog(
				this,
				"La apuesta de lotería ha sido guardada exitosamente",
				"Apuesta de lotería agregada",
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
    
    public String obtenerNombre() {
    	return tipoLoteria.getSelectedItem().toString();
    }
    
    public int[] obtenerNumero() {
    	int[] numerosChance = new int[4];
    	for (int i = 0; i < numeroChance.getText().length(); i++) {
    		numerosChance[i] = Integer.parseInt(numeroChance.getText().toCharArray()[i] + "");
    	}
    	return numerosChance;
    }
    
    public boolean validarLeerChance() {
    	
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
				"La apuesta de chance a eliminar no ha sido encontrada con los datos ingresados",
				"Apuesta no encontrada",
				JOptionPane.ERROR_MESSAGE);
		return false;
	}
	JOptionPane.showMessageDialog(
			this,
			"La apuesta de chance ha sido eliminada exitosamente",
			"Apuesta de baloto eliminada",
			JOptionPane.INFORMATION_MESSAGE);
	return true;
}
	
	public boolean validarEliminacion() {
    	// Validar la que para eliminar una apuesta de chance se haya ingresado la cedula, la sede y el dia
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
    
    
    public void reiniciarCampos() {
    	numeroChance.setText("");
    	tipoLoteria.setSelectedIndex(0);
    	cedula.setText("");
    	dias.setSelectedIndex(0);
    	sedes.setSelectedIndex(0);
    	valor.setText("");
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

	public JTextField getNumeroChance() {
		return numeroChance;
	}

	public void setNumeroChance(JTextField numeroChance) {
		this.numeroChance = numeroChance;
	}

	public JComboBox<String> getTipoLoteria() {
		return tipoLoteria;
	}

	public void setTipoLoteria(JComboBox<String> tipoLoteria) {
		this.tipoLoteria = tipoLoteria;
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

	public JButton getLeer() {
		return leer;
	}

	public void setLeer(JButton leer) {
		this.leer = leer;
	}

	public JButton getEliminar() {
		return eliminar;
	}

	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
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
