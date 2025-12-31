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
 * The Class ControlSedes.
 */
public class VentanaAdmin extends JFrame{
	private JTextField cajaBlanca;
	private JPanel panel;
	private JComboBox<String> sedesComboBox;
	private JButton parametrizarBetMaster;
	
	private JButton agregarSede;
	private JButton modificarSede;
	private JButton eliminarSede;
	
	private JButton agregarApostador;
	private JButton leerModificarApostador;
	private JButton eliminarApostador;
	
	// Seccion consultas
	private JButton listarClientesPorSede;
	private JButton valorTotalApuestasPorCliente;
	private JButton detalleDeApuestasPorCliente;
	private JButton detalleDeApuestasPorSede;
	private JButton totalDeApuestasPorSede;
	private JButton totalDeApuestasPorTipoDeJuego;
	
	
	/**
	 * Instantiates a new control sedes.
	 */
	public VentanaAdmin() {
		 setSize(600 , 700);
	     setLocationRelativeTo(null);
	     panel = new JPanel(null) { // Cambié a un layout nulo (null) para usar setBounds
	         @Override
	         protected void paintComponent(Graphics g) {
	             super.paintComponent(g);
	             // Cargar y dibujar la imagen como fondo
	             Image fondo = new ImageIcon("Imagenes\\adminfondo.jpeg").getImage();
                 g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
	         }
	     };
	     
	     setContentPane(panel);
	     JLabel label = new JLabel("Bet Master");
	     label.setFont(new Font("Comic Sans MS", Font.BOLD,35)); 
	     label.setBounds(200, 25, 500, 50); 
	     label.setForeground(Color.RED);
	     panel.add(label);
	     
	     Color gris = new Color(128, 128, 128);
	     
	    // Boton parametrizarBetMaster
	    parametrizarBetMaster = new JButton("parametrizar betmaster");
	    parametrizarBetMaster.setBounds(20, 100, 200, 50);
	    parametrizarBetMaster.setEnabled(true);
	    parametrizarBetMaster.setBackground(gris);
	    parametrizarBetMaster.setForeground(Color.WHITE);
	    panel.add(parametrizarBetMaster);
	    
	    // Botón agregar sede
	    agregarSede = new JButton("Agregar sede");
	    agregarSede.setBounds(20, 200, 150, 50);
	    agregarSede.setEnabled(true);
	    agregarSede.setBackground(gris);
	    agregarSede.setForeground(Color.WHITE);
	    panel.add(agregarSede);
	    
	    // Botón modificar sede
	    modificarSede = new JButton("Modificar sede");
	    modificarSede.setBounds(210, 200, 150, 50);
	    modificarSede.setEnabled(true);
	    modificarSede.setBackground(gris);
	    modificarSede.setForeground(Color.WHITE);
	    panel.add(modificarSede);
	    
	    // Botón eliminar sede
	    eliminarSede = new JButton("Eliminar sede");
	    eliminarSede.setBounds(400, 200, 150, 50);
	    eliminarSede.setEnabled(true);
	    eliminarSede.setBackground(gris);
	    eliminarSede.setForeground(Color.WHITE);
	    panel.add(eliminarSede);
	    
	    
	    // Boton agregar apostador
	    agregarApostador = new JButton("agregar apostador");
	    agregarApostador.setBounds(20, 300, 150, 50);
	    agregarApostador.setEnabled(true);
	    agregarApostador.setBackground(gris);
	    agregarApostador.setForeground(Color.WHITE);
	    panel.add(agregarApostador);
	    
	    // Boton leer modificar apostador
	    leerModificarApostador = new JButton("leer/modificar apostador");
	    leerModificarApostador.setBounds(200, 300, 180, 50);
	    leerModificarApostador.setEnabled(true);
	    leerModificarApostador.setBackground(gris);
	    leerModificarApostador.setForeground(Color.WHITE);
	    panel.add(leerModificarApostador);
	    
	    // Boton eliminar apostador
	    eliminarApostador = new JButton("eliminar apostador");
	    eliminarApostador.setBounds(400, 300, 150, 50);
	    eliminarApostador.setEnabled(true);
	    eliminarApostador.setBackground(gris);
	    eliminarApostador.setForeground(Color.WHITE);
	    panel.add(eliminarApostador);
	    
	    // Seccion consultas casa de apuestas
	    listarClientesPorSede = new JButton("Listar clientes por sede");
	    listarClientesPorSede.setBounds(20, 400, 200, 50);
	    listarClientesPorSede.setEnabled(true);
	    listarClientesPorSede.setBackground(gris);
	    listarClientesPorSede.setForeground(Color.WHITE);
	    panel.add(listarClientesPorSede);
	    
	    valorTotalApuestasPorCliente = new JButton("Valor total apuestas por cliente");
	    valorTotalApuestasPorCliente.setBounds(280, 400, 250, 50);
	    valorTotalApuestasPorCliente.setEnabled(true);
	    valorTotalApuestasPorCliente.setBackground(gris);
	    valorTotalApuestasPorCliente.setForeground(Color.WHITE);
	    panel.add(valorTotalApuestasPorCliente);
	    
	    detalleDeApuestasPorCliente = new JButton("Detalle de apuestas por cliente");
	    detalleDeApuestasPorCliente.setBounds(20, 500, 250, 50);
	    detalleDeApuestasPorCliente.setEnabled(true);
	    detalleDeApuestasPorCliente.setBackground(gris);
	    detalleDeApuestasPorCliente.setForeground(Color.WHITE);
	    panel.add(detalleDeApuestasPorCliente);
	    
	    
	    detalleDeApuestasPorSede = new JButton("Detalle de apuestas por sede");
	    detalleDeApuestasPorSede.setBounds(280, 500, 250, 50);
	    detalleDeApuestasPorSede.setEnabled(true);
	    detalleDeApuestasPorSede.setBackground(gris);
	    detalleDeApuestasPorSede.setForeground(Color.WHITE);
	    panel.add(detalleDeApuestasPorSede);
	    
	    
	    totalDeApuestasPorSede = new JButton("Total de apuestas por sede");
	    totalDeApuestasPorSede.setBounds(20, 600, 250, 50);
	    totalDeApuestasPorSede.setEnabled(true);
	    totalDeApuestasPorSede.setBackground(gris);
	    totalDeApuestasPorSede.setForeground(Color.WHITE);
	    panel.add(totalDeApuestasPorSede);
	    
	    totalDeApuestasPorTipoDeJuego = new JButton("Total de apuestas por tipo de juego");
	    totalDeApuestasPorTipoDeJuego.setBounds(280, 600, 250, 50);
	    totalDeApuestasPorTipoDeJuego.setEnabled(true);
	    totalDeApuestasPorTipoDeJuego.setBackground(gris);
	    totalDeApuestasPorTipoDeJuego.setForeground(Color.WHITE);
	    panel.add(totalDeApuestasPorTipoDeJuego);
	    
	}


		public JTextField getCajaBlanca() {
			return cajaBlanca;
		}


		public void setCajaBlanca(JTextField cajaBlanca) {
			this.cajaBlanca = cajaBlanca;
		}


		public JPanel getPanel() {
			return panel;
		}


		public void setPanel(JPanel panel) {
			this.panel = panel;
		}


		public JComboBox<String> getSedesComboBox() {
			return sedesComboBox;
		}


		public void setSedesComboBox(JComboBox<String> sedesComboBox) {
			this.sedesComboBox = sedesComboBox;
		}


		public JButton getAgregarApostador() {
			return agregarApostador;
		}


		public void setAgregarApostador(JButton agregarApostador) {
			this.agregarApostador = agregarApostador;
		}


		public JButton getParametrizarBetMaster() {
			return parametrizarBetMaster;
		}


		public void setParametrizarBetMaster(JButton parametrizarBetMaster) {
			this.parametrizarBetMaster = parametrizarBetMaster;
		}


		public JButton getAgregarSede() {
			return agregarSede;
		}


		public void setAgregarSede(JButton agregarSede) {
			this.agregarSede = agregarSede;
		}


		public JButton getModificarSede() {
			return modificarSede;
		}


		public void setModificarSede(JButton modificarSede) {
			this.modificarSede = modificarSede;
		}


		public JButton getEliminarSede() {
			return eliminarSede;
		}


		public void setEliminarSede(JButton eliminarSede) {
			this.eliminarSede = eliminarSede;
		}


		public JButton getLeerModificarApostador() {
			return leerModificarApostador;
		}


		public void setLeerModificarApostador(JButton leerModificarApostador) {
			this.leerModificarApostador = leerModificarApostador;
		}


		public JButton getEliminarApostador() {
			return eliminarApostador;
		}


		public void setEliminarApostador(JButton eliminarApostador) {
			this.eliminarApostador = eliminarApostador;
		}


		public JButton getListarClientesPorSede() {
			return listarClientesPorSede;
		}


		public void setListarClientesPorSede(JButton listarClientesPorSede) {
			this.listarClientesPorSede = listarClientesPorSede;
		}


		public JButton getValorTotalApuestasPorCliente() {
			return valorTotalApuestasPorCliente;
		}


		public void setValorTotalApuestasPorCliente(JButton valorTotalApuestasPorCliente) {
			this.valorTotalApuestasPorCliente = valorTotalApuestasPorCliente;
		}


		public JButton getDetalleDeApuestasPorCliente() {
			return detalleDeApuestasPorCliente;
		}


		public void setDetalleDeApuestasPorCliente(JButton detalleDeApuestasPorCliente) {
			this.detalleDeApuestasPorCliente = detalleDeApuestasPorCliente;
		}


		public JButton getDetalleDeApuestasPorSede() {
			return detalleDeApuestasPorSede;
		}


		public void setDetalleDeApuestasPorSede(JButton detalleDeApuestasPorSede) {
			this.detalleDeApuestasPorSede = detalleDeApuestasPorSede;
		}


		public JButton getTotalDeApuestasPorSede() {
			return totalDeApuestasPorSede;
		}


		public void setTotalDeApuestasPorSede(JButton totalDeApuestasPorSede) {
			this.totalDeApuestasPorSede = totalDeApuestasPorSede;
		}


		public JButton getTotalDeApuestasPorTipoDeJuego() {
			return totalDeApuestasPorTipoDeJuego;
		}


		public void setTotalDeApuestasPorTipoDeJuego(JButton totalDeApuestasPorTipoDeJuego) {
			this.totalDeApuestasPorTipoDeJuego = totalDeApuestasPorTipoDeJuego;
		}


}