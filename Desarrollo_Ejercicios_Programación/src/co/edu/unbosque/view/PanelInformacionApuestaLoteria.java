package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Class PanelInformacionApuestaLoteria.
 */
public class PanelInformacionApuestaLoteria extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Secciones principales del panel. */
	private JLabel seccion1, seccion2;
	
	/** Etiquetas para la loteria, la serie y el numero de loteria. */
	private JLabel labelLoteria, labelSerie, labelNumero;
	
	/** Campos de texto para la loteria, la serie y el numero de loteria. */
	private JTextField campoLoteria, campoSerie, campoNumero;

	/**
	 * Instantiates a new panel informacion apuesta loteria.
	 */
	public PanelInformacionApuestaLoteria() {
		setLayout(new GridLayout(2, 1, 10, 10));
		
		seccion1 = new JLabel();
		seccion1.setLayout(new GridLayout(1, 4, 5, 5));
		
		labelLoteria = new JLabel();
		labelLoteria.setText("Tipo de Lotería");
		
		campoLoteria = new JTextField();
		campoLoteria.setEditable(false);
		
		labelSerie = new JLabel();
		labelSerie.setText("Serie");
		
		campoSerie = new JTextField();
		campoSerie.setEditable(false);
		
		seccion1.add(labelLoteria);
		seccion1.add(campoLoteria);
		seccion1.add(labelSerie);
		seccion1.add(campoSerie);
		
		
		seccion2 = new JLabel();
		seccion2.setLayout(new GridLayout(1, 2, 10, 10));
		
		labelNumero = new JLabel();
		labelNumero.setText("Número de Lotería");
		
		campoNumero = new JTextField();
		campoNumero.setEditable(false);
		
		seccion2.add(labelNumero);
		seccion2.add(campoNumero);
		
		
		add(seccion1);
		add(seccion2);
		
	}

	/**
	 * Gets the seccion 1.
	 *
	 * @return the seccion 1
	 */
	public JLabel getSeccion1() {
		return seccion1;
	}

	/**
	 * Sets the seccion 1.
	 *
	 * @param seccion1 the new seccion 1
	 */
	public void setSeccion1(JLabel seccion1) {
		this.seccion1 = seccion1;
	}

	/**
	 * Gets the seccion 2.
	 *
	 * @return the seccion 2
	 */
	public JLabel getSeccion2() {
		return seccion2;
	}

	/**
	 * Sets the seccion 2.
	 *
	 * @param seccion2 the new seccion 2
	 */
	public void setSeccion2(JLabel seccion2) {
		this.seccion2 = seccion2;
	}

	/**
	 * Gets the label loteria.
	 *
	 * @return the label loteria
	 */
	public JLabel getLabelLoteria() {
		return labelLoteria;
	}

	/**
	 * Sets the label loteria.
	 *
	 * @param labelLoteria the new label loteria
	 */
	public void setLabelLoteria(JLabel labelLoteria) {
		this.labelLoteria = labelLoteria;
	}

	/**
	 * Gets the label serie.
	 *
	 * @return the label serie
	 */
	public JLabel getLabelSerie() {
		return labelSerie;
	}

	/**
	 * Sets the label serie.
	 *
	 * @param labelSerie the new label serie
	 */
	public void setLabelSerie(JLabel labelSerie) {
		this.labelSerie = labelSerie;
	}

	/**
	 * Gets the label numero.
	 *
	 * @return the label numero
	 */
	public JLabel getLabelNumero() {
		return labelNumero;
	}

	/**
	 * Sets the label numero.
	 *
	 * @param labelNumero the new label numero
	 */
	public void setLabelNumero(JLabel labelNumero) {
		this.labelNumero = labelNumero;
	}

	/**
	 * Gets the campo loteria.
	 *
	 * @return the campo loteria
	 */
	public JTextField getCampoLoteria() {
		return campoLoteria;
	}

	/**
	 * Sets the campo loteria.
	 *
	 * @param campoLoteria the new campo loteria
	 */
	public void setCampoLoteria(JTextField campoLoteria) {
		this.campoLoteria = campoLoteria;
	}

	/**
	 * Gets the campo serie.
	 *
	 * @return the campo serie
	 */
	public JTextField getCampoSerie() {
		return campoSerie;
	}

	/**
	 * Sets the campo serie.
	 *
	 * @param campoSerie the new campo serie
	 */
	public void setCampoSerie(JTextField campoSerie) {
		this.campoSerie = campoSerie;
	}

	/**
	 * Gets the campo numero.
	 *
	 * @return the campo numero
	 */
	public JTextField getCampoNumero() {
		return campoNumero;
	}

	/**
	 * Sets the campo numero.
	 *
	 * @param campoNumero the new campo numero
	 */
	public void setCampoNumero(JTextField campoNumero) {
		this.campoNumero = campoNumero;
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
