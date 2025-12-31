package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Class PanelModificacionApostador.
 */
public class PanelModificacionApostador extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Secciones principales para el panel. */
	private JLabel seccionCentral, seccionNorte, seccionSur, seccionEste, seccionOeste;
	
	/** Seccion especifica para mostrar informacion del apostador. */
	private JLabel seccionInformacionApostador;
	
	/** Labels que identifican los campos relacionados con la informacion del apostador. */
	private JLabel labelNombreApostador, labelDireccionApostador, labelCedulaApostador, labelNumeroApostador, labelSedeApostador;
	
	/** Campos de texto para ingresar o mostrar informacion del apostador. */
	private JTextField campoNombreApostador, campoDireccionApostador, campoCedulaApostador, campoNumeroApostador;
	
	/** Seleccion de la sede a la que pertenece el apostador. */
	private JComboBox<String> seleccionSedeApostador;
	
	/** Botones de navegacion. */
	private JButton btnVolverAGestionApostadores, btnModificarApostador;
	
	/** The volver a gestion de apostadores. */
	public final String VOLVER_A_GESTION_DE_APOSTADORES = "Volver a Gestion de Apostadores";
	
	/** The modificar apostador. */
	public final String MODIFICAR_APOSTADOR = "Modificar apostador";
	
	/**
	 * Instantiates a new panel modificacion apostador.
	 */
	public PanelModificacionApostador() {
		
		setLayout(new BorderLayout());
		
		// Definir sección norte
		seccionNorte = new JLabel();
		seccionNorte.setText("Modificar Apostador");
		seccionNorte.setFont(new Font("Concord", Font.BOLD, 30));
		seccionNorte.setVerticalAlignment(JLabel.CENTER);
		seccionNorte.setHorizontalAlignment(JLabel.CENTER);
		seccionNorte.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		// Definir sección central
		seccionCentral = new JLabel();
		seccionCentral.setLayout(new GridLayout(6, 2, 50, 50));
		
		
		// Definir label y campo de texto de la dirección del apostador
		seccionInformacionApostador = new JLabel();
		seccionInformacionApostador.setLayout(new GridLayout(6, 2, 25, 25));
		
		// Definir label y campo de texto del nombre del apostador
		labelNombreApostador = new JLabel();
		labelNombreApostador.setText("Nombre completo del Apostador");
		
		campoNombreApostador = new JTextField();
		
		labelDireccionApostador = new JLabel();
		labelDireccionApostador.setText("Dirección del apostador");
		
		campoDireccionApostador = new JTextField();
		
		// Definir label y campo de texto de la cédula del apostador
		labelCedulaApostador = new JLabel();
		labelCedulaApostador.setText("Cédula del apostador");
		
		campoCedulaApostador = new JTextField();
		campoCedulaApostador.setEditable(false);
		
		// Definir label y campo de texto del número de celular del apostador
		labelNumeroApostador = new JLabel();
		labelNumeroApostador.setText("Número de celular del apostador");
		
		campoNumeroApostador = new JTextField();
		
		// Definir label y campo de texto de la sede actual del apostador
		labelSedeApostador = new JLabel();
		labelSedeApostador.setText("Sede Actual del apostador");
		
		seleccionSedeApostador = new JComboBox<String>();
		
		btnVolverAGestionApostadores = new JButton();
		btnVolverAGestionApostadores.setText(VOLVER_A_GESTION_DE_APOSTADORES);
		btnVolverAGestionApostadores.setActionCommand(VOLVER_A_GESTION_DE_APOSTADORES);
		
		btnModificarApostador = new JButton();
		btnModificarApostador.setText("Modificar");
		btnModificarApostador.setActionCommand(MODIFICAR_APOSTADOR);
	
		
		seccionCentral.add(labelNombreApostador);
		seccionCentral.add(campoNombreApostador);
		seccionCentral.add(labelDireccionApostador);
		seccionCentral.add(labelCedulaApostador);
		seccionCentral.add(campoDireccionApostador);
		seccionCentral.add(campoCedulaApostador);
		seccionCentral.add(labelNumeroApostador);
		seccionCentral.add(labelSedeApostador);
		seccionCentral.add(campoNumeroApostador);
		seccionCentral.add(seleccionSedeApostador);
		seccionCentral.add(btnVolverAGestionApostadores);
		seccionCentral.add(btnModificarApostador);
		
		
		// Definir sección sur
		seccionSur = new JLabel("    ");
		
		
		// Definir sección este
		seccionEste = new JLabel("    ");
		
		// Definir sección oeste
		seccionOeste = new JLabel("    ");
		
		
		add(seccionNorte, BorderLayout.NORTH);
		add(seccionCentral, BorderLayout.CENTER);
		add(seccionSur, BorderLayout.SOUTH);
		add(seccionEste, BorderLayout.EAST);
		add(seccionOeste, BorderLayout.WEST);
		
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
	 * Gets the seccion sur.
	 *
	 * @return the seccion sur
	 */
	public JLabel getSeccionSur() {
		return seccionSur;
	}

	/**
	 * Sets the seccion sur.
	 *
	 * @param seccionSur the new seccion sur
	 */
	public void setSeccionSur(JLabel seccionSur) {
		this.seccionSur = seccionSur;
	}

	/**
	 * Gets the seccion este.
	 *
	 * @return the seccion este
	 */
	public JLabel getSeccionEste() {
		return seccionEste;
	}

	/**
	 * Sets the seccion este.
	 *
	 * @param seccionEste the new seccion este
	 */
	public void setSeccionEste(JLabel seccionEste) {
		this.seccionEste = seccionEste;
	}

	/**
	 * Gets the seccion oeste.
	 *
	 * @return the seccion oeste
	 */
	public JLabel getSeccionOeste() {
		return seccionOeste;
	}

	/**
	 * Sets the seccion oeste.
	 *
	 * @param seccionOeste the new seccion oeste
	 */
	public void setSeccionOeste(JLabel seccionOeste) {
		this.seccionOeste = seccionOeste;
	}

	/**
	 * Gets the seccion informacion apostador.
	 *
	 * @return the seccion informacion apostador
	 */
	public JLabel getSeccionInformacionApostador() {
		return seccionInformacionApostador;
	}

	/**
	 * Sets the seccion informacion apostador.
	 *
	 * @param seccionInformacionApostador the new seccion informacion apostador
	 */
	public void setSeccionInformacionApostador(JLabel seccionInformacionApostador) {
		this.seccionInformacionApostador = seccionInformacionApostador;
	}

	/**
	 * Gets the label nombre apostador.
	 *
	 * @return the label nombre apostador
	 */
	public JLabel getLabelNombreApostador() {
		return labelNombreApostador;
	}

	/**
	 * Sets the label nombre apostador.
	 *
	 * @param labelNombreApostador the new label nombre apostador
	 */
	public void setLabelNombreApostador(JLabel labelNombreApostador) {
		this.labelNombreApostador = labelNombreApostador;
	}

	/**
	 * Gets the label direccion apostador.
	 *
	 * @return the label direccion apostador
	 */
	public JLabel getLabelDireccionApostador() {
		return labelDireccionApostador;
	}

	/**
	 * Sets the label direccion apostador.
	 *
	 * @param labelDireccionApostador the new label direccion apostador
	 */
	public void setLabelDireccionApostador(JLabel labelDireccionApostador) {
		this.labelDireccionApostador = labelDireccionApostador;
	}

	/**
	 * Gets the label cedula apostador.
	 *
	 * @return the label cedula apostador
	 */
	public JLabel getLabelCedulaApostador() {
		return labelCedulaApostador;
	}

	/**
	 * Sets the label cedula apostador.
	 *
	 * @param labelCedulaApostador the new label cedula apostador
	 */
	public void setLabelCedulaApostador(JLabel labelCedulaApostador) {
		this.labelCedulaApostador = labelCedulaApostador;
	}

	/**
	 * Gets the label numero apostador.
	 *
	 * @return the label numero apostador
	 */
	public JLabel getLabelNumeroApostador() {
		return labelNumeroApostador;
	}

	/**
	 * Sets the label numero apostador.
	 *
	 * @param labelNumeroApostador the new label numero apostador
	 */
	public void setLabelNumeroApostador(JLabel labelNumeroApostador) {
		this.labelNumeroApostador = labelNumeroApostador;
	}

	/**
	 * Gets the label sede apostador.
	 *
	 * @return the label sede apostador
	 */
	public JLabel getLabelSedeApostador() {
		return labelSedeApostador;
	}

	/**
	 * Sets the label sede apostador.
	 *
	 * @param labelSedeApostador the new label sede apostador
	 */
	public void setLabelSedeApostador(JLabel labelSedeApostador) {
		this.labelSedeApostador = labelSedeApostador;
	}

	/**
	 * Gets the campo nombre apostador.
	 *
	 * @return the campo nombre apostador
	 */
	public JTextField getCampoNombreApostador() {
		return campoNombreApostador;
	}

	/**
	 * Sets the campo nombre apostador.
	 *
	 * @param campoNombreApostador the new campo nombre apostador
	 */
	public void setCampoNombreApostador(JTextField campoNombreApostador) {
		this.campoNombreApostador = campoNombreApostador;
	}

	/**
	 * Gets the campo direccion apostador.
	 *
	 * @return the campo direccion apostador
	 */
	public JTextField getCampoDireccionApostador() {
		return campoDireccionApostador;
	}

	/**
	 * Sets the campo direccion apostador.
	 *
	 * @param campoDireccionApostador the new campo direccion apostador
	 */
	public void setCampoDireccionApostador(JTextField campoDireccionApostador) {
		this.campoDireccionApostador = campoDireccionApostador;
	}

	/**
	 * Gets the campo cedula apostador.
	 *
	 * @return the campo cedula apostador
	 */
	public JTextField getCampoCedulaApostador() {
		return campoCedulaApostador;
	}

	/**
	 * Sets the campo cedula apostador.
	 *
	 * @param campoCedulaApostador the new campo cedula apostador
	 */
	public void setCampoCedulaApostador(JTextField campoCedulaApostador) {
		this.campoCedulaApostador = campoCedulaApostador;
	}

	/**
	 * Gets the campo numero apostador.
	 *
	 * @return the campo numero apostador
	 */
	public JTextField getCampoNumeroApostador() {
		return campoNumeroApostador;
	}

	/**
	 * Sets the campo numero apostador.
	 *
	 * @param campoNumeroApostador the new campo numero apostador
	 */
	public void setCampoNumeroApostador(JTextField campoNumeroApostador) {
		this.campoNumeroApostador = campoNumeroApostador;
	}

	/**
	 * Gets the seleccion sede apostador.
	 *
	 * @return the seleccion sede apostador
	 */
	public JComboBox<String> getSeleccionSedeApostador() {
		return seleccionSedeApostador;
	}

	/**
	 * Sets the seleccion sede apostador.
	 *
	 * @param seleccionSedeApostador the new seleccion sede apostador
	 */
	public void setSeleccionSedeApostador(JComboBox<String> seleccionSedeApostador) {
		this.seleccionSedeApostador = seleccionSedeApostador;
	}

	/**
	 * Gets the btn volver A gestion apostadores.
	 *
	 * @return the btn volver A gestion apostadores
	 */
	public JButton getBtnVolverAGestionApostadores() {
		return btnVolverAGestionApostadores;
	}

	/**
	 * Sets the btn volver A gestion apostadores.
	 *
	 * @param btnVolverAGestionApostadores the new btn volver A gestion apostadores
	 */
	public void setBtnVolverAGestionApostadores(JButton btnVolverAGestionApostadores) {
		this.btnVolverAGestionApostadores = btnVolverAGestionApostadores;
	}

	/**
	 * Gets the btn modificar apostador.
	 *
	 * @return the btn modificar apostador
	 */
	public JButton getBtnModificarApostador() {
		return btnModificarApostador;
	}

	/**
	 * Sets the btn modificar apostador.
	 *
	 * @param btnModificarApostador the new btn modificar apostador
	 */
	public void setBtnModificarApostador(JButton btnModificarApostador) {
		this.btnModificarApostador = btnModificarApostador;
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
