package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Class PanelApuestaBaloto.
 */
public class PanelApuestaBaloto extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Labels y campos de numeros en dos secciones. */
	private JLabel seccionLabelsNumeros1, seccionLabelsNumeros2, seccionCamposNumeros1, seccionCamposNumeros2;
	
	/** Etiquetas para seis numeros. */
	private JLabel labelNumero1, labelNumero2, labelNumero3, labelNumero4, labelNumero5, labelNumero6;
	
	/** Campos de texto para seis numeros. */
	private JTextField campoNumero1, campoNumero2, campoNumero3, campoNumero4, campoNumero5, campoNumero6;

	/**
	 * Instantiates a new panel apuesta baloto.
	 */
	public PanelApuestaBaloto() {
		setLayout(new GridLayout(4, 1, 10, 10));
		setBorder(BorderFactory.createTitledBorder("Apuesta Baloto"));
		
		seccionLabelsNumeros1 = new JLabel();
		seccionLabelsNumeros1.setLayout(new GridLayout(1, 3, 5, 5));
		
		labelNumero1 = new JLabel();
		labelNumero1.setText("Número 1");
		labelNumero1.setHorizontalAlignment(JLabel.CENTER);
		labelNumero1.setVerticalAlignment(JLabel.CENTER);
		
		labelNumero2 = new JLabel();
		labelNumero2.setText("Número 2");
		labelNumero2.setHorizontalAlignment(JLabel.CENTER);
		labelNumero2.setVerticalAlignment(JLabel.CENTER);
		
		labelNumero3 = new JLabel();
		labelNumero3.setText("Número 3");
		labelNumero3.setHorizontalAlignment(JLabel.CENTER);
		labelNumero3.setVerticalAlignment(JLabel.CENTER);
		
		seccionLabelsNumeros1.add(labelNumero1);
		seccionLabelsNumeros1.add(labelNumero2);
		seccionLabelsNumeros1.add(labelNumero3);
		
		
		seccionCamposNumeros1 = new JLabel();
		seccionCamposNumeros1.setLayout(new GridLayout(1, 3, 5, 5));
		
		campoNumero1 = new JTextField();
		campoNumero1.setHorizontalAlignment(JTextField.CENTER);
		
		campoNumero2 = new JTextField();
		campoNumero2.setHorizontalAlignment(JTextField.CENTER);
	
		campoNumero3 = new JTextField();
		campoNumero3.setHorizontalAlignment(JTextField.CENTER);
		
		seccionCamposNumeros1.add(campoNumero1);
		seccionCamposNumeros1.add(campoNumero2);
		seccionCamposNumeros1.add(campoNumero3);
		
		
		
		seccionLabelsNumeros2 = new JLabel();
		seccionLabelsNumeros2.setLayout(new GridLayout(1, 3, 5, 5));
		
		labelNumero4 = new JLabel();
		labelNumero4.setText("Número 4");
		labelNumero4.setHorizontalAlignment(JLabel.CENTER);
		labelNumero4.setVerticalAlignment(JLabel.CENTER);
		
		labelNumero5 = new JLabel();
		labelNumero5.setText("Número 5");
		labelNumero5.setHorizontalAlignment(JLabel.CENTER);
		labelNumero5.setVerticalAlignment(JLabel.CENTER);
		
		labelNumero6 = new JLabel();
		labelNumero6.setText("Número 6");
		labelNumero6.setHorizontalAlignment(JLabel.CENTER);
		labelNumero6.setVerticalAlignment(JLabel.CENTER);
		
		seccionLabelsNumeros2.add(labelNumero4);
		seccionLabelsNumeros2.add(labelNumero5);
		seccionLabelsNumeros2.add(labelNumero6);
		
		
		seccionCamposNumeros2 = new JLabel();
		seccionCamposNumeros2.setLayout(new GridLayout(1, 3, 5, 5));
		
		campoNumero4 = new JTextField();
		campoNumero4.setHorizontalAlignment(JTextField.CENTER);
		
		campoNumero5 = new JTextField();
		campoNumero5.setHorizontalAlignment(JTextField.CENTER);

		campoNumero6 = new JTextField();
		campoNumero6.setHorizontalAlignment(JTextField.CENTER);
		
		seccionCamposNumeros2.add(campoNumero4);
		seccionCamposNumeros2.add(campoNumero5);
		seccionCamposNumeros2.add(campoNumero6);
		
		
		add(seccionLabelsNumeros1);
		add(seccionCamposNumeros1);
		add(seccionLabelsNumeros2);
		add(seccionCamposNumeros2);
		
	}

	/**
	 * Gets the seccion labels numeros 1.
	 *
	 * @return the seccion labels numeros 1
	 */
	public JLabel getSeccionLabelsNumeros1() {
		return seccionLabelsNumeros1;
	}

	/**
	 * Sets the seccion labels numeros 1.
	 *
	 * @param seccionLabelsNumeros1 the new seccion labels numeros 1
	 */
	public void setSeccionLabelsNumeros1(JLabel seccionLabelsNumeros1) {
		this.seccionLabelsNumeros1 = seccionLabelsNumeros1;
	}

	/**
	 * Gets the seccion labels numeros 2.
	 *
	 * @return the seccion labels numeros 2
	 */
	public JLabel getSeccionLabelsNumeros2() {
		return seccionLabelsNumeros2;
	}

	/**
	 * Sets the seccion labels numeros 2.
	 *
	 * @param seccionLabelsNumeros2 the new seccion labels numeros 2
	 */
	public void setSeccionLabelsNumeros2(JLabel seccionLabelsNumeros2) {
		this.seccionLabelsNumeros2 = seccionLabelsNumeros2;
	}

	/**
	 * Gets the seccion campos numeros 1.
	 *
	 * @return the seccion campos numeros 1
	 */
	public JLabel getSeccionCamposNumeros1() {
		return seccionCamposNumeros1;
	}

	/**
	 * Sets the seccion campos numeros 1.
	 *
	 * @param seccionCamposNumeros1 the new seccion campos numeros 1
	 */
	public void setSeccionCamposNumeros1(JLabel seccionCamposNumeros1) {
		this.seccionCamposNumeros1 = seccionCamposNumeros1;
	}

	/**
	 * Gets the seccion campos numeros 2.
	 *
	 * @return the seccion campos numeros 2
	 */
	public JLabel getSeccionCamposNumeros2() {
		return seccionCamposNumeros2;
	}

	/**
	 * Sets the seccion campos numeros 2.
	 *
	 * @param seccionCamposNumeros2 the new seccion campos numeros 2
	 */
	public void setSeccionCamposNumeros2(JLabel seccionCamposNumeros2) {
		this.seccionCamposNumeros2 = seccionCamposNumeros2;
	}

	/**
	 * Gets the label numero 1.
	 *
	 * @return the label numero 1
	 */
	public JLabel getLabelNumero1() {
		return labelNumero1;
	}

	/**
	 * Sets the label numero 1.
	 *
	 * @param labelNumero1 the new label numero 1
	 */
	public void setLabelNumero1(JLabel labelNumero1) {
		this.labelNumero1 = labelNumero1;
	}

	/**
	 * Gets the label numero 2.
	 *
	 * @return the label numero 2
	 */
	public JLabel getLabelNumero2() {
		return labelNumero2;
	}

	/**
	 * Sets the label numero 2.
	 *
	 * @param labelNumero2 the new label numero 2
	 */
	public void setLabelNumero2(JLabel labelNumero2) {
		this.labelNumero2 = labelNumero2;
	}

	/**
	 * Gets the label numero 3.
	 *
	 * @return the label numero 3
	 */
	public JLabel getLabelNumero3() {
		return labelNumero3;
	}

	/**
	 * Sets the label numero 3.
	 *
	 * @param labelNumero3 the new label numero 3
	 */
	public void setLabelNumero3(JLabel labelNumero3) {
		this.labelNumero3 = labelNumero3;
	}

	/**
	 * Gets the label numero 4.
	 *
	 * @return the label numero 4
	 */
	public JLabel getLabelNumero4() {
		return labelNumero4;
	}

	/**
	 * Sets the label numero 4.
	 *
	 * @param labelNumero4 the new label numero 4
	 */
	public void setLabelNumero4(JLabel labelNumero4) {
		this.labelNumero4 = labelNumero4;
	}

	/**
	 * Gets the label numero 5.
	 *
	 * @return the label numero 5
	 */
	public JLabel getLabelNumero5() {
		return labelNumero5;
	}

	/**
	 * Sets the label numero 5.
	 *
	 * @param labelNumero5 the new label numero 5
	 */
	public void setLabelNumero5(JLabel labelNumero5) {
		this.labelNumero5 = labelNumero5;
	}

	/**
	 * Gets the label numero 6.
	 *
	 * @return the label numero 6
	 */
	public JLabel getLabelNumero6() {
		return labelNumero6;
	}

	/**
	 * Sets the label numero 6.
	 *
	 * @param labelNumero6 the new label numero 6
	 */
	public void setLabelNumero6(JLabel labelNumero6) {
		this.labelNumero6 = labelNumero6;
	}

	/**
	 * Gets the campo numero 1.
	 *
	 * @return the campo numero 1
	 */
	public JTextField getCampoNumero1() {
		return campoNumero1;
	}

	/**
	 * Sets the campo numero 1.
	 *
	 * @param campoNumero1 the new campo numero 1
	 */
	public void setCampoNumero1(JTextField campoNumero1) {
		this.campoNumero1 = campoNumero1;
	}

	/**
	 * Gets the campo numero 2.
	 *
	 * @return the campo numero 2
	 */
	public JTextField getCampoNumero2() {
		return campoNumero2;
	}

	/**
	 * Sets the campo numero 2.
	 *
	 * @param campoNumero2 the new campo numero 2
	 */
	public void setCampoNumero2(JTextField campoNumero2) {
		this.campoNumero2 = campoNumero2;
	}

	/**
	 * Gets the campo numero 3.
	 *
	 * @return the campo numero 3
	 */
	public JTextField getCampoNumero3() {
		return campoNumero3;
	}

	/**
	 * Sets the campo numero 3.
	 *
	 * @param campoNumero3 the new campo numero 3
	 */
	public void setCampoNumero3(JTextField campoNumero3) {
		this.campoNumero3 = campoNumero3;
	}

	/**
	 * Gets the campo numero 4.
	 *
	 * @return the campo numero 4
	 */
	public JTextField getCampoNumero4() {
		return campoNumero4;
	}

	/**
	 * Sets the campo numero 4.
	 *
	 * @param campoNumero4 the new campo numero 4
	 */
	public void setCampoNumero4(JTextField campoNumero4) {
		this.campoNumero4 = campoNumero4;
	}

	/**
	 * Gets the campo numero 5.
	 *
	 * @return the campo numero 5
	 */
	public JTextField getCampoNumero5() {
		return campoNumero5;
	}

	/**
	 * Sets the campo numero 5.
	 *
	 * @param campoNumero5 the new campo numero 5
	 */
	public void setCampoNumero5(JTextField campoNumero5) {
		this.campoNumero5 = campoNumero5;
	}

	/**
	 * Gets the campo numero 6.
	 *
	 * @return the campo numero 6
	 */
	public JTextField getCampoNumero6() {
		return campoNumero6;
	}

	/**
	 * Sets the campo numero 6.
	 *
	 * @param campoNumero6 the new campo numero 6
	 */
	public void setCampoNumero6(JTextField campoNumero6) {
		this.campoNumero6 = campoNumero6;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
