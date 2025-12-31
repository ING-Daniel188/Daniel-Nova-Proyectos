package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * The Class PanelApuestaChance.
 */
public class PanelApuestaChance extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Sección de configuracion para Chance. */
	private JLabel seccionLabelsNumeros, seccionCamposNumeros, seccionConfiguracionChance;
	
	/** Labels para cuatro numeros. */
	private JLabel labelNumero1, labelNumero2, labelNumero3, labelNumero4;
	
	/** Campos de texto para cuatro numeros. */
	private JTextField campoNumero1, campoNumero2, campoNumero3, campoNumero4;
	
	/** Selección del tipo de lotería. */
	private JComboBox<String> seleccionLoteria;
	
	/** Grupo de botones para configuración de Chance. */
	private ButtonGroup configuracionChance;
	
	/** Opciones para configuración de Chance: Manual y Automático. */
	private JRadioButton chanceManual, chanceAutomatico;
	
	/** The seleccionar chance manual. */
	public final String SELECCIONAR_CHANCE_MANUAL = "Seleccionar Chance Manual";
	
	/** The seleccionar chance automatico. */
	public final String SELECCIONAR_CHANCE_AUTOMATICO = "Selecccionar Chance Automático";

	/**
	 * Instantiates a new panel apuesta chance.
	 */
	public PanelApuestaChance() {
		
		setLayout(new GridLayout(3, 1, 25, 25));
		setBorder(BorderFactory.createTitledBorder("Apuesta Chance"));

		seccionConfiguracionChance = new JLabel();
		seccionConfiguracionChance.setLayout(new GridLayout(1, 3, 5, 5));

		String[] loterias = { "Seleccionar Lotería:", "Lotería de Bogotá", "Lotería de Boyacá", "Lotería del Cauca", "Lotería Cruz Roja",
				"Lotería de Cundinamarca", "Lotería del Huila", "Lotería de Manizales", "Lotería de Medellín",
				"Lotería del Meta", "Lotería del Quindío", "Lotería de Risaralda", "Lotería de Santander",
				"Lotería del Tolima", "Lotería del Valle" };

		seleccionLoteria = new JComboBox<String>(loterias);
		
		
		configuracionChance = new ButtonGroup();
		
		chanceManual = new JRadioButton();
		chanceManual.setText("Chance Manual");
		chanceManual.setHorizontalAlignment(JRadioButton.CENTER);
		chanceManual.setActionCommand(SELECCIONAR_CHANCE_MANUAL);
		
		chanceAutomatico = new JRadioButton();
		chanceAutomatico.setText("Chance Automático");
		chanceAutomatico.setActionCommand(SELECCIONAR_CHANCE_AUTOMATICO);
		
		configuracionChance.add(chanceManual);
		configuracionChance.add(chanceAutomatico);
		

		seccionConfiguracionChance.add(seleccionLoteria);
		seccionConfiguracionChance.add(chanceManual);
		seccionConfiguracionChance.add(chanceAutomatico);
		
		seccionLabelsNumeros = new JLabel();
		seccionLabelsNumeros.setLayout(new GridLayout(1, 4, 10, 10));
		
		labelNumero1 = new JLabel();
		labelNumero1.setText("Número 1");
		labelNumero1.setVerticalAlignment(JLabel.CENTER);
		labelNumero1.setHorizontalAlignment(JLabel.CENTER);
		
		labelNumero2 = new JLabel();
		labelNumero2.setText("Número 2");
		labelNumero2.setVerticalAlignment(JLabel.CENTER);
		labelNumero2.setHorizontalAlignment(JLabel.CENTER);
		
		labelNumero3 = new JLabel();
		labelNumero3.setText("Número 3");
		labelNumero3.setVerticalAlignment(JLabel.CENTER);
		labelNumero3.setHorizontalAlignment(JLabel.CENTER);
		
		labelNumero4 = new JLabel();
		labelNumero4.setText("Número 4");
		labelNumero4.setVerticalAlignment(JLabel.CENTER);
		labelNumero4.setHorizontalAlignment(JLabel.CENTER);
		
		seccionLabelsNumeros.add(labelNumero1);
		seccionLabelsNumeros.add(labelNumero2);
		seccionLabelsNumeros.add(labelNumero3);
		seccionLabelsNumeros.add(labelNumero4);
		
		seccionCamposNumeros = new JLabel();
		seccionCamposNumeros.setLayout(new GridLayout(1, 4, 10, 10));
		
		campoNumero1 = new JTextField();
		campoNumero1.setHorizontalAlignment(JTextField.CENTER);
		campoNumero1.setEditable(false);
		
		campoNumero2 = new JTextField();
		campoNumero2.setHorizontalAlignment(JTextField.CENTER);
		campoNumero2.setEditable(false);
		
		campoNumero3 = new JTextField();
		campoNumero3.setHorizontalAlignment(JTextField.CENTER);
		campoNumero3.setEditable(false);
		
		campoNumero4 = new JTextField();
		campoNumero4.setHorizontalAlignment(JTextField.CENTER);
		campoNumero4.setEditable(false);
		
		seccionCamposNumeros.add(campoNumero1);
		seccionCamposNumeros.add(campoNumero2);
		seccionCamposNumeros.add(campoNumero3);
		seccionCamposNumeros.add(campoNumero4);
		
		
		add(seccionConfiguracionChance);
		add(seccionLabelsNumeros);
		add(seccionCamposNumeros);
		
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
	 * Gets the seccion configuracion chance.
	 *
	 * @return the seccion configuracion channce
	 */
	public JLabel getSeccionConfiguracionChance() {
		return seccionConfiguracionChance;
	}

	/**
	 * Sets the seccion configuracion chance.
	 *
	 * @param seccionConfiguracionBaloto the new seccion configuracion chance
	 */
	public void setSeccionConfiguracionChance(JLabel seccionConfiguracionChance) {
		this.seccionConfiguracionChance = seccionConfiguracionChance;
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
	 * Gets the seleccion loteria.
	 *
	 * @return the seleccion loteria
	 */
	public JComboBox<String> getSeleccionLoteria() {
		return seleccionLoteria;
	}

	/**
	 * Sets the seleccion loteria.
	 *
	 * @param seleccionLoteria the new seleccion loteria
	 */
	public void setSeleccionLoteria(JComboBox<String> seleccionLoteria) {
		this.seleccionLoteria = seleccionLoteria;
	}

	/**
	 * Gets the configuracion chance.
	 *
	 * @return the configuracion chance
	 */
	public ButtonGroup getConfiguracionChance() {
		return configuracionChance;
	}

	/**
	 * Sets the configuracion chance.
	 *
	 * @param configuracionChance the new configuracion chance
	 */
	public void setConfiguracionChance(ButtonGroup configuracionChance) {
		this.configuracionChance = configuracionChance;
	}

	/**
	 * Gets the chance manual.
	 *
	 * @return the chance manual
	 */
	public JRadioButton getChanceManual() {
		return chanceManual;
	}

	/**
	 * Sets the chance manual.
	 *
	 * @param chanceManual the new chance manual
	 */
	public void setChanceManual(JRadioButton chanceManual) {
		this.chanceManual = chanceManual;
	}

	/**
	 * Gets the chance automatico.
	 *
	 * @return the chance automatico
	 */
	public JRadioButton getChanceAutomatico() {
		return chanceAutomatico;
	}

	/**
	 * Sets the chance automatico.
	 *
	 * @param chanceAutomatico the new chance automatico
	 */
	public void setChanceAutomatico(JRadioButton chanceAutomatico) {
		this.chanceAutomatico = chanceAutomatico;
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
