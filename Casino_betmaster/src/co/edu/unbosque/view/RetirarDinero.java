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
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class RetirarDinero.
 */
public class RetirarDinero extends JFrame {
private JTextField cajaBlanca1;
private JTextField cajaBlanca2;
private JPanel panel;
private JComboBox<String> sedesComboBox;	


	/**
	 * Instantiates a new retirar dinero.
	 */
	public RetirarDinero() {
		 setSize(400 , 600);

	     setLocationRelativeTo(null);
	     panel = new JPanel(null) { // Cambié a un layout nulo (null) para usar setBounds
	         @Override
	         protected void paintComponent(Graphics g) {
	             super.paintComponent(g);
	             // Cargar y dibujar la imagen como fondo
	             Image fondo = new ImageIcon("Imagenes\\ATM.jpeg").getImage();
                 g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
	         }
	     };
	     
	     setContentPane(panel);
	     JLabel label = new JLabel("Bet Master");
	     label.setFont(new Font("Comic Sans MS", Font.BOLD,35)); 
	     label.setBounds(25, 25, 500, 50); 
	     label.setForeground(Color.RED);
	     panel.add(label);

	     iniciarComponentes();
		
	}

	private void iniciarComponentes() {
		ponerMenuDesplegable();
		ponerEtiqueta();
		botonbuscarsedeyimprimirsaldo();
		ponerCajaBlanca1();
		ponerCajaBlanca2();
		botonRetirar();
		ponerEtiqueta2();
		ponerEtiqueta3();	
		ponerEtiqueta4();
		ponerCajaBlanca3();	
}
	private void ponerCajaBlanca1() {
	    cajaBlanca1 = new JTextField();
	    cajaBlanca1.setBounds(150, 270, 130, 30); // Ajusta la posición y el tamaño según tus necesidades
	    cajaBlanca1.setBackground(Color.WHITE);
	    panel.add(cajaBlanca1);
	}
	private void ponerEtiqueta3() {
		JLabel textoLabel = new JLabel("su saldo es ");
		textoLabel.setBounds(110,230, 460, 30);
		Color blancoHueso = new Color(248, 236, 203);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
	}	

	private void ponerCajaBlanca2() {
	    cajaBlanca2 = new JTextField();
	    cajaBlanca2.setBounds(150, 350, 130, 30); // Ajusta la posición y el tamaño según tus necesidades
	    cajaBlanca2.setBackground(Color.WHITE);
	    panel.add(cajaBlanca2);
	}
	private void ponerCajaBlanca3() {
	    cajaBlanca2 = new JTextField();
	    cajaBlanca2.setBounds(150, 470, 130, 30); // Ajusta la posición y el tamaño según tus necesidades
	    cajaBlanca2.setBackground(Color.WHITE);
	    panel.add(cajaBlanca2);
	}
	private void ponerEtiqueta() {
		JLabel textoLabel = new JLabel("seleccione la sede: ");
		textoLabel.setBounds(110,75, 460, 30);
		Color blancoHueso = new Color(248, 236, 203);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
	}	
	private void ponerEtiqueta4() {
		JLabel textoLabel = new JLabel("su saldo es  ");
		textoLabel.setBounds(30,470, 460, 30);
		Color blancoHueso = new Color(248, 236, 203);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
	}	
	private void ponerEtiqueta2() {
		JLabel textoLabel = new JLabel("cuanto va a retirar");
		textoLabel.setBounds(110,320, 460, 30);
		Color blancoHueso = new Color(248, 236, 203);
	    textoLabel.setForeground(blancoHueso);
		textoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
		panel.add(textoLabel);
	}	
	
	private void ponerMenuDesplegable() {
	    String[] sedes = {"Sede 1", "Sede 2", "Sede 3"}; // Reemplaza esto con tus sedes
	    sedesComboBox = new JComboBox<>(sedes);
	    sedesComboBox.setBackground(Color.BLACK);
	    sedesComboBox.setForeground(Color.WHITE);
	    sedesComboBox.setBounds(110, 110, 200, 30); // Ajusta la posición y el tamaño según tus necesidades
	    panel.add(sedesComboBox);
	}
	private void botonbuscarsedeyimprimirsaldo() {
	    JButton boton1 = new JButton("Buscar sede");
	    boton1.setBounds(150, 150, 130, 50);
	    boton1.setEnabled(true);
	    Color gris = new Color(128, 128, 128);
	    boton1.setBackground(gris);
	    boton1.setForeground(Color.WHITE);
	    panel.add(boton1);
	    //action 
	    boton1.addActionListener(e -> {
	        
	    	 String sedeSeleccionada = (String) sedesComboBox.getSelectedItem();

	    	    // Imprimir un número en la caja blanca 1 según la sede seleccionada
	    	    if (sedeSeleccionada.equals("Sede 1")) {
	    	        cajaBlanca1.setText("1");
	    	    } else if (sedeSeleccionada.equals("Sede 2")) {
	    	        cajaBlanca1.setText("2");
	    	    } else if (sedeSeleccionada.equals("Sede 3")) {
	    	        cajaBlanca1.setText("3");
	    	    }

	    });
	}
	private void botonRetirar() {
	    JButton boton1 = new JButton("retirar");
	    boton1.setBounds(150, 400, 130, 50);
	    boton1.setEnabled(true);
	    Color gris = new Color(128, 128, 128);
	    boton1.setBackground(gris);
	    boton1.setForeground(Color.WHITE);
	    panel.add(boton1);
	    //action 
	    boton1.addActionListener(e -> {
	        
	    	 String sedeSeleccionada = (String) sedesComboBox.getSelectedItem();

	    	 int numero1 = Integer.parseInt(cajaBlanca1.getText());
	    	    int numero2 = Integer.parseInt(cajaBlanca2.getText());
	    	    int resultado = numero1 - numero2;
	    	    cajaBlanca1.setText(String.valueOf(resultado));
	    });
	}

}
