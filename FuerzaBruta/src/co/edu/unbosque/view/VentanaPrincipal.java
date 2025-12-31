package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import co.edu.unbosque.controller.ControladorTexto;

/**
 * Ventana principal de la aplicación.
 * Maneja la interfaz gráfica y coordina los diferentes paneles.
 */
public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelArchivo panelArchivo;
	private PanelBusqueda panelBusqueda;
	private PanelBotones panelBotones;

	private final Color COLOR_FONDO_UNIFORME = new Color(200, 220, 180);

	public VentanaPrincipal() {
		configurarApariencia();
		inicializarComponentes();
		configurarVentana();
		configurarControlador();
	}

	private void configurarApariencia() {
		UIManager.put("OptionPane.background", COLOR_FONDO_UNIFORME);
		UIManager.put("Panel.background", COLOR_FONDO_UNIFORME);
		UIManager.put("OptionPane.messageForeground", new Color(80, 60, 40));
		UIManager.put("Button.background", new Color(220, 160, 100));
		UIManager.put("Button.foreground", Color.WHITE);
		UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 12));
		UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 13));
	}

	private void inicializarComponentes() {
		panelArchivo = new PanelArchivo();
		panelBusqueda = new PanelBusqueda();
		panelBotones = new PanelBotones();
	}

	private void configurarVentana() {
		setTitle("Analizador de Texto - Universidad del Bosque");
		setSize(950, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Crear panel con fondo uniforme
		JPanel panelFondo = new JPanel();
		panelFondo.setBackground(COLOR_FONDO_UNIFORME);
		panelFondo.setLayout(new BorderLayout());

		setResizable(true);
		setMinimumSize(new java.awt.Dimension(800, 600));

		panelFondo.add(panelBusqueda, BorderLayout.NORTH);
		panelFondo.add(panelArchivo, BorderLayout.CENTER);
		panelFondo.add(panelBotones, BorderLayout.SOUTH);

		add(panelFondo);
	}

	private void configurarControlador() {
		new ControladorTexto(this);
	}

	public PanelArchivo getPanelArchivo() {
		return panelArchivo;
	}

	public PanelBusqueda getPanelBusqueda() {
		return panelBusqueda;
	}

	public PanelBotones getPanelBotones() {
		return panelBotones;
	}

	
}