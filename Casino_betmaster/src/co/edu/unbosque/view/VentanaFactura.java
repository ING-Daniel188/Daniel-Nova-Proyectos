package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaFactura.
 */
public class VentanaFactura extends JFrame {

    /** The sede label. */
    private JLabel sedeLabel;
    
    /** The cedula label. */
    private JLabel cedulaLabel;
    
    /** The dia label. */
    private JLabel diaLabel;
    
    /** The valor apuesta label. */
    private JLabel valorApuestaLabel;
    
    /** The tipo apuesta label. */
    private JLabel tipoApuestaLabel;

    /** The sede field. */
    private JTextField sedeField;
    
    /** The cedula field. */
    private JTextField cedulaField;
    
    /** The dia field. */
    private JTextField diaField;
    
    /** The valor apuesta field. */
    private JTextField valorApuestaField;
    
    /** The tipo apuesta field. */
    private JTextField tipoApuestaField;
    
    /** The cerrar guardar button. */
    private JButton cerrarGuardarButton;

    /**
     * Instantiates a new ventana factura.
     *
     * @param nombreSede the nombre sede
     * @param numCedula the num cedula
     * @param diaApuesta the dia apuesta
     * @param valor the valor
     * @param tipo the tipo
     */
    public VentanaFactura(String nombreSede, String numCedula, String diaApuesta, double valor, String tipo) {
    	setTitle("Factura");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        sedeLabel = new JLabel("Nombre de la sede:");
        cedulaLabel = new JLabel("Cédula del apostador:");
        diaLabel = new JLabel("Día de la apuesta:");
        valorApuestaLabel = new JLabel("Valor de la Apuesta:");
        tipoApuestaLabel = new JLabel("Tipo de Apuesta:");

        sedeField = new JTextField(nombreSede);
        cedulaField = new JTextField(numCedula);
        diaField = new JTextField(diaApuesta);
        valorApuestaField = new JTextField(String.valueOf(valor));
        tipoApuestaField = new JTextField(tipo);

        // Hacer los campos no editables
        sedeField.setEditable(false);
        cedulaField.setEditable(false);
        diaField.setEditable(false);
        valorApuestaField.setEditable(false);
        tipoApuestaField.setEditable(false);

        cerrarGuardarButton = new JButton("Cerrar y Guardar");
        cerrarGuardarButton.addActionListener(e -> dispose());
        
        add(sedeLabel);
        add(sedeField);
        add(cedulaLabel);
        add(cedulaField);
        add(diaLabel);
        add(diaField);
        add(valorApuestaLabel);
        add(valorApuestaField);
        add(tipoApuestaLabel);
        add(tipoApuestaField);
        add(new JLabel()); // Espacio vacío
        add(cerrarGuardarButton); // Botón de cerrar y guardar

        setVisible(true);
    }
    
    
}
