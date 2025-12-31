package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBusqueda extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField campoBusqueda;
	private JButton botonBuscar;
	private JLabel coincidencias;

	private final Color COLOR_FONDO = new Color(255, 200, 150, 200);
	private final Color COLOR_FONDO_SECUNDARIO = new Color(255, 245, 230);
	private final Color COLOR_TEXTO = new Color(100, 40, 20);
	private final Color COLOR_BOTON_BUSCAR = new Color(180, 220, 180);
	private final Color COLOR_BOTON_BUSCAR_HOVER = new Color(200, 240, 200);
	private final Color COLOR_BOTON_BUSCAR_ACTIVO = new Color(160, 200, 160);
	private final Color COLOR_BORDE = new Color(240, 180, 140);
	private final Color COLOR_TITULO = new Color(140, 60, 30);
	private final Dimension TAMANIO_BOTON_BUSQUEDA = new Dimension(120, 40);

	public PanelBusqueda() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(COLOR_BORDE, 3), "Busqueda de Texto", 0,
						0, new Font("Segoe UI", Font.BOLD, 14), COLOR_TITULO),
				BorderFactory.createEmptyBorder(12, 20, 12, 20)));
		setBackground(new Color(0, 0, 0, 0));

		campoBusqueda = new JTextField(30);
		stylizeTextField(campoBusqueda);

		botonBuscar = new JButton("Buscar");
		botonBuscar.addActionListener(this);
		stylizeSearchButton(botonBuscar);

		JLabel etiqueta = new JLabel("Texto a buscar: ");
		etiqueta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		etiqueta.setForeground(COLOR_TEXTO);
		
		coincidencias = new JLabel("");
		coincidencias.setFont(new Font("Segoe UI", Font.BOLD, 14));
		coincidencias.setForeground(COLOR_TEXTO);
		coincidencias.setBackground(COLOR_FONDO_SECUNDARIO);
		coincidencias.setOpaque(true);
		coincidencias.setHorizontalAlignment(JLabel.CENTER);
		coincidencias.setPreferredSize(new Dimension(130, 30));
		coincidencias.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));

	

		add(etiqueta);
		add(campoBusqueda);
		add(botonBuscar);
		add(coincidencias);

		
	}

	private void stylizeTextField(JTextField textField) {
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField.setBackground(COLOR_FONDO_SECUNDARIO);
		textField.setForeground(COLOR_TEXTO);
		textField.setCaretColor(COLOR_TEXTO);
		textField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1),
				BorderFactory.createEmptyBorder(10, 12, 10, 12)));
	}

	private void stylizeSearchButton(JButton button) {
		button.setFont(new Font("Segoe UI", Font.BOLD, 14));
		button.setBackground(COLOR_BOTON_BUSCAR);
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(100, 130, 50), 2),
				BorderFactory.createEmptyBorder(10, 15, 10, 15)));
		button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		button.setPreferredSize(TAMANIO_BOTON_BUSQUEDA);
		button.setMinimumSize(TAMANIO_BOTON_BUSQUEDA);
		button.setMaximumSize(TAMANIO_BOTON_BUSQUEDA);

		button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				button.setBackground(COLOR_BOTON_BUSCAR_HOVER);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				button.setBackground(COLOR_BOTON_BUSCAR);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				button.setBackground(COLOR_BOTON_BUSCAR_ACTIVO);
			}
		});
	}

	public JTextField getCampoBusqueda() {
		return campoBusqueda;
	}

	public JButton getBotonBuscar() {
		return botonBuscar;
	}

	public JLabel getCoincidencias() {
		return coincidencias;
	}

	public void setCoincidencias(JLabel coincidencias) {
		this.coincidencias = coincidencias;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}