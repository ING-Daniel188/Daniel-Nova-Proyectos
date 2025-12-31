package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Class PanelApuestaLoteria.
 */
public class PanelApuestaLoteria extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Seccion de seleccion de Loteria y Serie. */
	private JLabel seccionSeleccionLoteria, seccionSerie;

	/** Label para un numero. */
	private JLabel labelNumero;

	/** Campo de texto para el numero de lotería. */
	private JTextField campoNumeroLoteria;

	/** Seleccion de Loteria y Serie. */
	private JComboBox<String> seleccionLoteria, seleccionSerie;
	
	/** The seleccionar serie. */
	public String SELECCIONAR_SERIE = "Seleccionar Serie";

	/**
	 * Instantiates a new panel apuesta loteria.
	 */
	public PanelApuestaLoteria() {
		
		setLayout(new GridLayout(2, 2, 25, 25));
		setBorder(BorderFactory.createTitledBorder("Apuesta Lotería"));

		seccionSeleccionLoteria = new JLabel();
		seccionSeleccionLoteria.setLayout(new GridLayout(1, 1, 5, 5));

		String[] loterias = { "Seleccionar Lotería:", "Lotería de Bogotá", "Lotería de Boyacá", "Lotería del Cauca", "Lotería Cruz Roja",
				"Lotería de Cundinamarca", "Lotería del Huila", "Lotería de Manizales", "Lotería de Medellín",
				"Lotería del Meta", "Lotería del Quindío", "Lotería de Risaralda", "Lotería de Santander",
				"Lotería del Tolima", "Lotería del Valle" };

		seleccionLoteria = new JComboBox<String>(loterias);

		seccionSeleccionLoteria.add(seleccionLoteria);

		
		labelNumero = new JLabel();
		labelNumero.setText("Número de Lotería");
		labelNumero.setVerticalAlignment(JLabel.CENTER);
		labelNumero.setHorizontalAlignment(JLabel.CENTER);
		
		
		seccionSerie = new JLabel();
		seccionSerie.setLayout(new GridLayout(1, 1, 5, 5));
		
		seleccionSerie = new JComboBox<String>();
		seleccionSerie.setActionCommand(SELECCIONAR_SERIE);

		seccionSerie.add(seleccionSerie);
		
		
		campoNumeroLoteria = new JTextField();
		campoNumeroLoteria.setEditable(false);
		campoNumeroLoteria.setHorizontalAlignment(JTextField.CENTER);
		
		add(seleccionLoteria);
		add(labelNumero);
		add(seleccionSerie);
		add(campoNumeroLoteria);
		
	}


	/**
	 * Gets the seccion seleccion loteria.
	 *
	 * @return the seccion seleccion loteria
	 */
	public JLabel getSeccionSeleccionLoteria() {
		return seccionSeleccionLoteria;
	}

	/**
	 * Sets the seccion seleccion loteria.
	 *
	 * @param seccionSeleccionLoteria the new seccion seleccion loteria
	 */
	public void setSeccionSeleccionLoteria(JLabel seccionSeleccionLoteria) {
		this.seccionSeleccionLoteria = seccionSeleccionLoteria;
	}

	/**
	 * Gets the seccion serie.
	 *
	 * @return the seccion serie
	 */
	public JLabel getSeccionSerie() {
		return seccionSerie;
	}

	/**
	 * Sets the seccion serie.
	 *
	 * @param seccionSerie the new seccion serie
	 */
	public void setSeccionSerie(JLabel seccionSerie) {
		this.seccionSerie = seccionSerie;
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
	 * Gets the seleccion serie.
	 *
	 * @return the seleccion serie
	 */
	public JComboBox<String> getSeleccionSerie() {
		return seleccionSerie;
	}

	/**
	 * Sets the seleccion serie.
	 *
	 * @param seleccionSerie the new seleccion serie
	 */
	public void setSeleccionSerie(JComboBox<String> seleccionSerie) {
		this.seleccionSerie = seleccionSerie;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * Gets the campo numero loteria.
	 *
	 * @return the campo numero loteria
	 */
	public JTextField getCampoNumeroLoteria() {
		return campoNumeroLoteria;
	}


	/**
	 * Sets the campo numero loteria.
	 *
	 * @param campoNumeroLoteria the new campo numero loteria
	 */
	public void setCampoNumeroLoteria(JTextField campoNumeroLoteria) {
		this.campoNumeroLoteria = campoNumeroLoteria;
	}
	
}
