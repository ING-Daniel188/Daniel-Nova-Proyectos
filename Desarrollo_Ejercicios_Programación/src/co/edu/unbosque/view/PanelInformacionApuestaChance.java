package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Class PanelInformacionApuestaChance.
 */
public class PanelInformacionApuestaChance extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Secciones principales del panel. */
	private JLabel seccionNombreLoteria, seccionNumeros;
	
	/** Label para el nombre de la loteria. */
	private JLabel labelNombreLoteria;
	
	/** Campo de texto para el nombre de la loteria. */
	private JTextField campoNombreLoteria;
	
	/** Labels para los numeros de chance. */
	private JLabel labelNumero1, labelNumero2, labelNumero3, labelNumero4;
	
	/** Campos de texto para los numeros de chance. */
	private JTextField campoNumero1, campoNumero2, campoNumero3, campoNumero4;

	
	/**
	 * Instantiates a new panel informacion apuesta chance.
	 */
	public PanelInformacionApuestaChance() {
		setLayout(new GridLayout(2, 1, 10, 10));
		
		seccionNombreLoteria = new JLabel();
		seccionNombreLoteria.setLayout(new GridLayout(1, 2, 10, 10));
		
		labelNombreLoteria = new JLabel();
		labelNombreLoteria.setText("Nombre de la lotería");
		
		campoNombreLoteria = new JTextField();
		campoNombreLoteria.setEditable(false);
		
		seccionNombreLoteria.add(labelNombreLoteria);
		seccionNombreLoteria.add(campoNombreLoteria);
		
		
		seccionNumeros = new JLabel();
		seccionNumeros.setLayout(new GridLayout(2, 4, 10, 10));
		
		labelNumero1 = new JLabel();
		labelNumero1.setText("Número 1");
		
		labelNumero2 = new JLabel();
		labelNumero2.setText("Número 2");
		
		labelNumero3 = new JLabel();
		labelNumero3.setText("Número 3");
		
		labelNumero4 = new JLabel();
		labelNumero4.setText("Número 4");
		
		
		campoNumero1 = new JTextField();
		campoNumero1.setEditable(false);
		
		campoNumero2 = new JTextField();
		campoNumero2.setEditable(false);
		
		campoNumero3 = new JTextField();
		campoNumero3.setEditable(false);
		
		campoNumero4 = new JTextField();
		campoNumero4.setEditable(false);
		
		
		seccionNumeros.add(labelNumero1);
		seccionNumeros.add(labelNumero2);
		seccionNumeros.add(labelNumero3);
		seccionNumeros.add(labelNumero4);
		
		seccionNumeros.add(campoNumero1);
		seccionNumeros.add(campoNumero2);
		seccionNumeros.add(campoNumero3);
		seccionNumeros.add(campoNumero4);
		
		
		add(seccionNombreLoteria);
		add(seccionNumeros);
		
	}


	/**
	 * Gets the seccion nombre loteria.
	 *
	 * @return the seccion nombre loteria
	 */
	public JLabel getSeccionNombreLoteria() {
		return seccionNombreLoteria;
	}


	/**
	 * Sets the seccion nombre loteria.
	 *
	 * @param seccionNombreLoteria the new seccion nombre loteria
	 */
	public void setSeccionNombreLoteria(JLabel seccionNombreLoteria) {
		this.seccionNombreLoteria = seccionNombreLoteria;
	}


	/**
	 * Gets the seccion numeros.
	 *
	 * @return the seccion numeros
	 */
	public JLabel getSeccionNumeros() {
		return seccionNumeros;
	}


	/**
	 * Sets the seccion numeros.
	 *
	 * @param seccionNumeros the new seccion numeros
	 */
	public void setSeccionNumeros(JLabel seccionNumeros) {
		this.seccionNumeros = seccionNumeros;
	}


	/**
	 * Gets the label nombre loteria.
	 *
	 * @return the label nombre loteria
	 */
	public JLabel getLabelNombreLoteria() {
		return labelNombreLoteria;
	}


	/**
	 * Sets the label nombre loteria.
	 *
	 * @param labelNombreLoteria the new label nombre loteria
	 */
	public void setLabelNombreLoteria(JLabel labelNombreLoteria) {
		this.labelNombreLoteria = labelNombreLoteria;
	}


	/**
	 * Gets the campo nombre loteria.
	 *
	 * @return the campo nombre loteria
	 */
	public JTextField getCampoNombreLoteria() {
		return campoNombreLoteria;
	}


	/**
	 * Sets the campo nombre loteria.
	 *
	 * @param campoNombreLoteria the new campo nombre loteria
	 */
	public void setCampoNombreLoteria(JTextField campoNombreLoteria) {
		this.campoNombreLoteria = campoNombreLoteria;
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
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
