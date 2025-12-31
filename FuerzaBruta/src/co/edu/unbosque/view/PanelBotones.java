package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelBotones extends JPanel {

    private static final long serialVersionUID = 1L;

    private JButton botonCargar;
    private JButton botonLimpiar;
    private JButton botonSalir;

    public PanelBotones() {

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        setBorder(BorderFactory.createTitledBorder("Opciones del Archivo"));
        setBackground(new Color(255, 230, 200));

        botonCargar = new JButton("Cargar Archivo");
        botonLimpiar = new JButton("Limpiar");
        botonSalir = new JButton("Salir");

        estilizarBoton(botonCargar, new Color(255, 200, 100));
        estilizarBoton(botonLimpiar, new Color(180, 150, 250));
        estilizarBoton(botonSalir, new Color(255, 120, 120));

        add(botonCargar);
        add(botonLimpiar);
        add(botonSalir);
    }

    private void estilizarBoton(JButton boton, Color colorFondo) {
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.setPreferredSize(new Dimension(150, 40));
    }

    public JButton getBotonCargar() {
        return botonCargar;
    }

    public JButton getBotonLimpiar() {
        return botonLimpiar;
    }

    public JButton getBotonSalir() {
        return botonSalir;
    }
}