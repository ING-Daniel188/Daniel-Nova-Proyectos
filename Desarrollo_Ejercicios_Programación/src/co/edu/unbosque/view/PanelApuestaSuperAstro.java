package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Class PanelApuestaSuperAstro.
 */
public class PanelApuestaSuperAstro extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Seccion de seleccion de numeros. */
	private JLabel seccionLabelsNumeros, seccionCamposNumeros, seccionSeleccionSigno;

	/** Labels para numeros 1, 2, 3 y 4. */
	private JLabel labelNumero1, labelNumero2, labelNumero3, labelNumero4;

	/** Label para la seleccion del signo del zodiaco. */
	private JLabel labelSeleccionSignoDelZodiaco;

	/** Selecciones para numeros 1, 2, 3 y 4. */
	private JComboBox<String> seleccionNumero1, seleccionNumero2, seleccionNumero3, seleccionNumero4;

	/** Seleccion del signo del zodiaco. */
	private JComboBox<String> seleccionSignoDelZodiaco;
	
	/** The seleccionar signo del zodiaco. */
	public final String SELECCIONAR_SIGNO_DEL_ZODIACO = "Seleccionar Signo del Zodiaco";
	
	/**
	 * Instantiates a new panel apuesta super astro.
	 */
	public PanelApuestaSuperAstro() {
		
		setLayout(new GridLayout(3, 4, 10, 10));
		setBorder(BorderFactory.createTitledBorder("Apuesta SuperAstro"));
		
		seccionLabelsNumeros = new JLabel();
		seccionLabelsNumeros.setLayout(new GridLayout(1, 4, 5, 5));
		
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
		
		labelNumero4 = new JLabel();
		labelNumero4.setText("Número 4");
		labelNumero4.setHorizontalAlignment(JLabel.CENTER);
		labelNumero4.setVerticalAlignment(JLabel.CENTER);
		
		seccionLabelsNumeros.add(labelNumero1);
		seccionLabelsNumeros.add(labelNumero2);
		seccionLabelsNumeros.add(labelNumero3);
		seccionLabelsNumeros.add(labelNumero4);
		
		seccionCamposNumeros = new JLabel();
		seccionCamposNumeros.setLayout(new GridLayout(1, 4, 5, 5));
		
		String[] numerosPermitidos = {"Seleccionar Número", "0", "1", "2", "3", "5", "6", "7", "8", "9"};
		
		seleccionNumero1 = new JComboBox<String>(numerosPermitidos);
		seleccionNumero2 = new JComboBox<String>(numerosPermitidos);
		seleccionNumero3 = new JComboBox<String>(numerosPermitidos);
		seleccionNumero4 = new JComboBox<String>(numerosPermitidos);
		
		seccionCamposNumeros.add(seleccionNumero1);
		seccionCamposNumeros.add(seleccionNumero2);
		seccionCamposNumeros.add(seleccionNumero3);
		seccionCamposNumeros.add(seleccionNumero4);
		
		seccionSeleccionSigno = new JLabel();
		seccionSeleccionSigno.setLayout(new GridLayout(1, 2, 5, 5));
		
		labelSeleccionSignoDelZodiaco = new JLabel();
		labelSeleccionSignoDelZodiaco.setText("Signo del Zodiaco");
		labelSeleccionSignoDelZodiaco.setHorizontalAlignment(JLabel.CENTER);
		
		String[] signosDelZodiaco = {"Seleccionar Signo", "Acuario", "Piscis", "Aries", "Tauro", "Geminis", "Cancer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio"};
		
		seleccionSignoDelZodiaco = new JComboBox<String>(signosDelZodiaco);
		seleccionSignoDelZodiaco.setActionCommand(SELECCIONAR_SIGNO_DEL_ZODIACO);
		
		seccionSeleccionSigno.add(labelSeleccionSignoDelZodiaco);
		seccionSeleccionSigno.add(seleccionSignoDelZodiaco);
		
		add(seccionLabelsNumeros);
		add(seccionCamposNumeros);
		add(seccionSeleccionSigno);
		
	}

	/**
	 * Gets the seccion labels numeros.
	 *
	 * @return the seccion labels numeros
	 */
	public JLabel getSeccionLabelsNumeros() {
		return seccionLabelsNumeros;
	}

	/**
	 * Sets the seccion labels numeros.
	 *
	 * @param seccionLabelsNumeros the new seccion labels numeros
	 */
	public void setSeccionLabelsNumeros(JLabel seccionLabelsNumeros) {
		this.seccionLabelsNumeros = seccionLabelsNumeros;
	}

	/**
	 * Gets the seccion campos numeros.
	 *
	 * @return the seccion campos numeros
	 */
	public JLabel getSeccionCamposNumeros() {
		return seccionCamposNumeros;
	}

	/**
	 * Sets the seccion campos numeros.
	 *
	 * @param seccionCamposNumeros the new seccion campos numeros
	 */
	public void setSeccionCamposNumeros(JLabel seccionCamposNumeros) {
		this.seccionCamposNumeros = seccionCamposNumeros;
	}

	/**
	 * Gets the seccion seleccion signo.
	 *
	 * @return the seccion seleccion signo
	 */
	public JLabel getSeccionSeleccionSigno() {
		return seccionSeleccionSigno;
	}

	/**
	 * Sets the seccion seleccion signo.
	 *
	 * @param seccionSeleccionSigno the new seccion seleccion signo
	 */
	public void setSeccionSeleccionSigno(JLabel seccionSeleccionSigno) {
		this.seccionSeleccionSigno = seccionSeleccionSigno;
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
	 * Gets the label seleccion signo del zodiaco.
	 *
	 * @return the label seleccion signo del zodiaco
	 */
	public JLabel getLabelSeleccionSignoDelZodiaco() {
		return labelSeleccionSignoDelZodiaco;
	}

	/**
	 * Sets the label seleccion signo del zodiaco.
	 *
	 * @param labelSeleccionSignoDelZodiaco the new label seleccion signo del zodiaco
	 */
	public void setLabelSeleccionSignoDelZodiaco(JLabel labelSeleccionSignoDelZodiaco) {
		this.labelSeleccionSignoDelZodiaco = labelSeleccionSignoDelZodiaco;
	}

	/**
	 * Gets the seleccion numero 1.
	 *
	 * @return the seleccion numero 1
	 */
	public JComboBox<String> getSeleccionNumero1() {
		return seleccionNumero1;
	}

	/**
	 * Sets the seleccion numero 1.
	 *
	 * @param seleccionNumero1 the new seleccion numero 1
	 */
	public void setSeleccionNumero1(JComboBox<String> seleccionNumero1) {
		this.seleccionNumero1 = seleccionNumero1;
	}

	/**
	 * Gets the seleccion numero 2.
	 *
	 * @return the seleccion numero 2
	 */
	public JComboBox<String> getSeleccionNumero2() {
		return seleccionNumero2;
	}

	/**
	 * Sets the seleccion numero 2.
	 *
	 * @param seleccionNumero2 the new seleccion numero 2
	 */
	public void setSeleccionNumero2(JComboBox<String> seleccionNumero2) {
		this.seleccionNumero2 = seleccionNumero2;
	}

	/**
	 * Gets the seleccion numero 3.
	 *
	 * @return the seleccion numero 3
	 */
	public JComboBox<String> getSeleccionNumero3() {
		return seleccionNumero3;
	}

	/**
	 * Sets the seleccion numero 3.
	 *
	 * @param seleccionNumero3 the new seleccion numero 3
	 */
	public void setSeleccionNumero3(JComboBox<String> seleccionNumero3) {
		this.seleccionNumero3 = seleccionNumero3;
	}

	/**
	 * Gets the seleccion numero 4.
	 *
	 * @return the seleccion numero 4
	 */
	public JComboBox<String> getSeleccionNumero4() {
		return seleccionNumero4;
	}

	/**
	 * Sets the seleccion numero 4.
	 *
	 * @param seleccionNumero4 the new seleccion numero 4
	 */
	public void setSeleccionNumero4(JComboBox<String> seleccionNumero4) {
		this.seleccionNumero4 = seleccionNumero4;
	}

	/**
	 * Gets the seleccion signo del zodiaco.
	 *
	 * @return the seleccion signo del zodiaco
	 */
	public JComboBox<String> getSeleccionSignoDelZodiaco() {
		return seleccionSignoDelZodiaco;
	}

	/**
	 * Sets the seleccion signo del zodiaco.
	 *
	 * @param seleccionSignoDelZodiaco the new seleccion signo del zodiaco
	 */
	public void setSeleccionSignoDelZodiaco(JComboBox<String> seleccionSignoDelZodiaco) {
		this.seleccionSignoDelZodiaco = seleccionSignoDelZodiaco;
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
