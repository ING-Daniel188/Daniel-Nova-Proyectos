package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SimulacionDeCarrera extends JPanel {

	private static final long serialVersionUID = 8488741767363424782L;
	private JButton botonIniciarCarrera;
	private JProgressBar[] barrasProgresoCiclistas;
	private JLabel[] etiquetasCiclistas;
	private Timer temporizador;
	private CardLayout cardLayout;
	private RegistroDeCiclistas registroDeCiclistas;

	public SimulacionDeCarrera(ActionListener a) {
		cardLayout = new CardLayout();
		setLayout(cardLayout);

		JPanel panelCarrera = new JPanel(new GridLayout(0, 1));
		botonIniciarCarrera = new JButton("Iniciar Carrera");
		botonIniciarCarrera.addActionListener(a);
		panelCarrera.add(botonIniciarCarrera);

		int numCiclistas = 5;
		barrasProgresoCiclistas = new JProgressBar[numCiclistas];
		etiquetasCiclistas = new JLabel[numCiclistas];
		for (int i = 0; i < numCiclistas; i++) {
			etiquetasCiclistas[i] = new JLabel("Ciclista " + (i + 1));
			panelCarrera.add(etiquetasCiclistas[i]);

			barrasProgresoCiclistas[i] = new JProgressBar(0, 3600);
			panelCarrera.add(barrasProgresoCiclistas[i]);
		}

		temporizador = new Timer(100, a);
		add(panelCarrera, "Carrera");

		registroDeCiclistas = new RegistroDeCiclistas();
		add(registroDeCiclistas, "Registro");

		cardLayout.show(this, "Registro");
	}

	public void configurarCarrera(int numCiclistas) {
		barrasProgresoCiclistas = new JProgressBar[numCiclistas];
		etiquetasCiclistas = new JLabel[numCiclistas];
		for (int i = 0; i < numCiclistas; i++) {
			etiquetasCiclistas[i] = new JLabel("Ciclista " + (i + 1));
			add(etiquetasCiclistas[i]);

			barrasProgresoCiclistas[i] = new JProgressBar(0, 3600);
			add(barrasProgresoCiclistas[i]);
		}
	}

	public void mostrarSimulacionDeCarrera() {
		cardLayout.show(this, "Carrera");
	}

	public JProgressBar[] getBarrasProgresoCiclistas() {
		return barrasProgresoCiclistas;
	}

	public void setBarrasProgresoCiclistas(JProgressBar[] barrasProgresoCiclistas) {
		this.barrasProgresoCiclistas = barrasProgresoCiclistas;
	}

	public Timer getTemporizador() {
		return temporizador;
	}

	public void setTemporizador(Timer temporizador) {
		this.temporizador = temporizador;
	}

	public JButton getBotonIniciarCarrera() {
		return botonIniciarCarrera;
	}

	public void setBotonIniciarCarrera(JButton botonIniciarCarrera) {
		this.botonIniciarCarrera = botonIniciarCarrera;
	}

	public JLabel[] getEtiquetasCiclistas() {
		return etiquetasCiclistas;
	}

	public void setEtiquetasCiclistas(JLabel[] etiquetasCiclistas) {
		this.etiquetasCiclistas = etiquetasCiclistas;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public RegistroDeCiclistas getRegistroDeCiclistas() {
		return registroDeCiclistas;
	}

	public void setRegistroDeCiclistas(RegistroDeCiclistas registroDeCiclistas) {
		this.registroDeCiclistas = registroDeCiclistas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
