package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Class PanelTotalApuestas.
 */
public class PanelTotalApuestas extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Secciones principales del panel. */
	private JLabel seccionNorte, seccionCentral;
	
	/** Seccion para seleccionar parametros. */
	private JLabel seccionSeleccionParametros;

	/** Label para mostrar el numero de apuestas por sede. */
	private JLabel labelApuestasPorSede;

	/** Seleccion de sede para obtener el numero total de apuestas. */
	private JComboBox<String> seleccionSede;

	/** Label para mostrar el numero de apuestas por tipo de juego. */
	private JLabel labelApuestasPorTipoDeJuego;

	/** Seleccion del tipo de juego para obtener el numero total de apuestas. */
	private JComboBox<String> seleccionTipoDeJuego;

	/** Seccion para mostrar campos de numeros de apuestas. */
	private JLabel seccionCamposNumerosDeApuestas;

	/** Campo para mostrar el numero de apuestas por sede. */
	private JTextField campoNumeroApuestasPorSede;

	/** Campo para mostrar el numero de apuestas por tipo de juego. */
	private JTextField campoNumeroApuestasPorTipoDeJuego;
	
	
	/** The seleccionar sede. */
	public final String SELECCIONAR_SEDE = "Seleccionar total apuestas por sede";
	
	/** The seleccionar tipo de juego. */
	public final String SELECCIONAR_TIPO_DE_JUEGO = "Seleccionar tipo de juego";
	

	/**
	 * Instantiates a new panel total apuestas.
	 */
	public PanelTotalApuestas() {
		setLayout(new BorderLayout());
		
		// Definir sección norte
		seccionNorte = new JLabel();
		seccionNorte.setText("Total de Apuestas por Sede y Tipo de Juego");
		seccionNorte.setFont(new Font(null, Font.BOLD, 20));
		seccionNorte.setVerticalAlignment(JLabel.CENTER);
		seccionNorte.setHorizontalAlignment(JLabel.CENTER);
		seccionNorte.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		
		seccionCentral = new JLabel();
		seccionCentral.setLayout(new GridLayout(1, 2, 10, 10));
		
		seccionSeleccionParametros = new JLabel();
		seccionSeleccionParametros.setLayout(new GridLayout(4, 1, 5, 5));
		
		labelApuestasPorSede = new JLabel();
		labelApuestasPorSede.setText("Total de Apuestas por Sede");
		labelApuestasPorSede.setHorizontalAlignment(JLabel.CENTER);
		
		seleccionSede = new JComboBox<String>();
		seleccionSede.setActionCommand(SELECCIONAR_SEDE);
		
		labelApuestasPorTipoDeJuego = new JLabel();
		labelApuestasPorTipoDeJuego.setText("Total de Apuestas por Tipo de Juego");
		labelApuestasPorTipoDeJuego.setHorizontalAlignment(JLabel.CENTER);
		
		seleccionTipoDeJuego = new JComboBox<String>();
		seleccionTipoDeJuego.setActionCommand(SELECCIONAR_TIPO_DE_JUEGO);
		
		seccionSeleccionParametros.add(labelApuestasPorSede);
		seccionSeleccionParametros.add(seleccionSede);
		seccionSeleccionParametros.add(labelApuestasPorTipoDeJuego);
		seccionSeleccionParametros.add(seleccionTipoDeJuego);
		
		
		seccionCamposNumerosDeApuestas = new JLabel();
		seccionCamposNumerosDeApuestas.setLayout(new GridLayout(2, 1, 5, 5));
		
		campoNumeroApuestasPorSede = new JTextField();
		campoNumeroApuestasPorSede.setEditable(false);
		campoNumeroApuestasPorSede.setHorizontalAlignment(JTextField.CENTER);
		
		campoNumeroApuestasPorTipoDeJuego = new JTextField();
		campoNumeroApuestasPorTipoDeJuego.setEditable(false);
		campoNumeroApuestasPorTipoDeJuego.setHorizontalAlignment(JTextField.CENTER);
		
		seccionCamposNumerosDeApuestas.add(campoNumeroApuestasPorSede);
		seccionCamposNumerosDeApuestas.add(campoNumeroApuestasPorTipoDeJuego);
		
		
		seccionCentral.add(seccionSeleccionParametros);
		seccionCentral.add(seccionCamposNumerosDeApuestas);
		
		
		add(seccionNorte, BorderLayout.NORTH);
		add(seccionCentral, BorderLayout.CENTER);
	}
	
	/**
	 * Agregar sedes.
	 *
	 * @param sedes Arreglo de sedes a ser agregadas.
	 */
	public void agregarSedes(String[] sedes) {
		
		while (seleccionSede.getItemCount() > 0)
			seleccionSede.removeItemAt(0);
		
		seleccionSede.addItem("Seleccionar Sede:");
		
		for (int i = 0; i < sedes.length; i++)
			seleccionSede.addItem(sedes[i]);
		
	}
	
	/**
	 * Agregar tipos de juegos.
	 *
	 * @param juegos Arreglo de tipos de juegos a ser agregados.
	 */
	public void agregarTiposDeJuegos(String[] juegos) {
		
		while (seleccionTipoDeJuego.getItemCount() > 0)
			seleccionTipoDeJuego.removeItemAt(0);
		
		seleccionTipoDeJuego.addItem("Seleccionar Tipo De Juego");
		
		for (int i = 0; i < juegos.length; i++)
			seleccionTipoDeJuego.addItem(juegos[i]);
		
	}

	
	/**
	 * Gets the seccion norte.
	 *
	 * @return the seccion norte
	 */
	public JLabel getSeccionNorte() {
		return seccionNorte;
	}

	/**
	 * Sets the seccion norte.
	 *
	 * @param seccionNorte the new seccion norte
	 */
	public void setSeccionNorte(JLabel seccionNorte) {
		this.seccionNorte = seccionNorte;
	}

	/**
	 * Gets the seccion central.
	 *
	 * @return the seccion central
	 */
	public JLabel getSeccionCentral() {
		return seccionCentral;
	}

	/**
	 * Sets the seccion central.
	 *
	 * @param seccionCentral the new seccion central
	 */
	public void setSeccionCentral(JLabel seccionCentral) {
		this.seccionCentral = seccionCentral;
	}

	/**
	 * Gets the seccion seleccion parametros.
	 *
	 * @return the seccion seleccion parametros
	 */
	public JLabel getSeccionSeleccionParametros() {
		return seccionSeleccionParametros;
	}

	/**
	 * Sets the seccion seleccion parametros.
	 *
	 * @param seccionSeleccionParametros the new seccion seleccion parametros
	 */
	public void setSeccionSeleccionParametros(JLabel seccionSeleccionParametros) {
		this.seccionSeleccionParametros = seccionSeleccionParametros;
	}

	/**
	 * Gets the label apuestas por sede.
	 *
	 * @return the label apuestas por sede
	 */
	public JLabel getLabelApuestasPorSede() {
		return labelApuestasPorSede;
	}

	/**
	 * Sets the label apuestas por sede.
	 *
	 * @param labelApuestasPorSede the new label apuestas por sede
	 */
	public void setLabelApuestasPorSede(JLabel labelApuestasPorSede) {
		this.labelApuestasPorSede = labelApuestasPorSede;
	}

	/**
	 * Gets the seleccion sede.
	 *
	 * @return the seleccion sede
	 */
	public JComboBox<String> getSeleccionSede() {
		return seleccionSede;
	}

	/**
	 * Sets the seleccion sede.
	 *
	 * @param seleccionSede the new seleccion sede
	 */
	public void setSeleccionSede(JComboBox<String> seleccionSede) {
		this.seleccionSede = seleccionSede;
	}

	/**
	 * Gets the label apuestas por tipo de juego.
	 *
	 * @return the label apuestas por tipo de juego
	 */
	public JLabel getLabelApuestasPorTipoDeJuego() {
		return labelApuestasPorTipoDeJuego;
	}

	/**
	 * Sets the label apuestas por tipo de juego.
	 *
	 * @param labelApuestasPorTipoDeJuego the new label apuestas por tipo de juego
	 */
	public void setLabelApuestasPorTipoDeJuego(JLabel labelApuestasPorTipoDeJuego) {
		this.labelApuestasPorTipoDeJuego = labelApuestasPorTipoDeJuego;
	}

	/**
	 * Gets the seleccion tipo de juego.
	 *
	 * @return the seleccion tipo de juego
	 */
	public JComboBox<String> getSeleccionTipoDeJuego() {
		return seleccionTipoDeJuego;
	}

	/**
	 * Sets the seleccion tipo de juego.
	 *
	 * @param seleccionTipoDeJuego the new seleccion tipo de juego
	 */
	public void setSeleccionTipoDeJuego(JComboBox<String> seleccionTipoDeJuego) {
		this.seleccionTipoDeJuego = seleccionTipoDeJuego;
	}

	/**
	 * Gets the seccion campos numeros de apuestas.
	 *
	 * @return the seccion campos numeros de apuestas
	 */
	public JLabel getSeccionCamposNumerosDeApuestas() {
		return seccionCamposNumerosDeApuestas;
	}

	/**
	 * Sets the seccion campos numeros de apuestas.
	 *
	 * @param seccionCamposNumerosDeApuestas the new seccion campos numeros de apuestas
	 */
	public void setSeccionCamposNumerosDeApuestas(JLabel seccionCamposNumerosDeApuestas) {
		this.seccionCamposNumerosDeApuestas = seccionCamposNumerosDeApuestas;
	}

	/**
	 * Gets the campo numero apuestas por sede.
	 *
	 * @return the campo numero apuestas por sede
	 */
	public JTextField getCampoNumeroApuestasPorSede() {
		return campoNumeroApuestasPorSede;
	}

	/**
	 * Sets the campo numero apuestas por sede.
	 *
	 * @param campoNumeroApuestasPorSede the new campo numero apuestas por sede
	 */
	public void setCampoNumeroApuestasPorSede(JTextField campoNumeroApuestasPorSede) {
		this.campoNumeroApuestasPorSede = campoNumeroApuestasPorSede;
	}

	/**
	 * Gets the campo numero apuestas por tipo de juego.
	 *
	 * @return the campo numero apuestas por tipo de juego
	 */
	public JTextField getCampoNumeroApuestasPorTipoDeJuego() {
		return campoNumeroApuestasPorTipoDeJuego;
	}

	/**
	 * Sets the campo numero apuestas por tipo de juego.
	 *
	 * @param campoNumeroApuestasPorTipoDeJuego the new campo numero apuestas por tipo de juego
	 */
	public void setCampoNumeroApuestasPorTipoDeJuego(JTextField campoNumeroApuestasPorTipoDeJuego) {
		this.campoNumeroApuestasPorTipoDeJuego = campoNumeroApuestasPorTipoDeJuego;
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
