package co.edu.unbosque.view;

import co.edu.unbosque.controller.Controller;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaApuestas.
 */
public class VentanaApuestas extends JFrame {

    /** The chance button. */
    private JButton loteriaButton, superastroButton, balotoButton, betplayButton, chanceButton;

    /**
     * Instantiates a new ventana apuestas.
     *
     * @param controlador the controlador
     */
    public VentanaApuestas(Controller controlador) {
        setTitle("Seleccionar Apuesta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10)) {
        	@Override
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		Image fondo = new ImageIcon("fondo.jpg").getImage();
        		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        	}
        };
        setContentPane(panel);

        JLabel titleLabel = new JLabel("Seleccione una apuesta");
        titleLabel.setForeground(Color.white);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        loteriaButton = new JButton("Lotería");
        superastroButton = new JButton("Superastro");
        balotoButton = new JButton("Baloto");
        betplayButton = new JButton("Betplay");
        chanceButton = new JButton("Chance");

        panel.add(titleLabel);
        panel.add(loteriaButton);
        panel.add(superastroButton);
        panel.add(balotoButton);
        panel.add(betplayButton);
        panel.add(chanceButton);
        
        // Asignando controlador a los botones
        loteriaButton.addActionListener(controlador);
        superastroButton.addActionListener(controlador);
        balotoButton.addActionListener(controlador);
        betplayButton.addActionListener(controlador);
        chanceButton.addActionListener(controlador);
    }

    /**
     * Gets the loteria button.
     *
     * @return the loteria button
     */
    // Getters para los botones
    public JButton getLoteriaButton() {
        return loteriaButton;
    }

    /**
     * Gets the superastro button.
     *
     * @return the superastro button
     */
    public JButton getSuperastroButton() {
        return superastroButton;
    }

    /**
     * Gets the baloto button.
     *
     * @return the baloto button
     */
    public JButton getBalotoButton() {
        return balotoButton;
    }

    /**
     * Gets the betplay button.
     *
     * @return the betplay button
     */
    public JButton getBetplayButton() {
        return betplayButton;
    }

    /**
     * Gets the chance button.
     *
     * @return the chance button
     */
    public JButton getChanceButton() {
        return chanceButton;
    }
}

