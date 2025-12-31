package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Class PanelFacturaApuesta.
 */
public class PanelFacturaApuesta extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Panel de informacion para la apuesta de loteria. */
	private PanelInformacionApuestaLoteria panelInformacionApuestaLoteria;

	/** Panel de informacion para la apuesta de Super Astro. */
	private PanelInformacionApuestaSuperAstro panelInformacionApuestaSuperAstro;

	/** Panel de informacion para la apuesta de Baloto. */
	private PanelInformacionApuestaBaloto panelInformacionApuestaBaloto;

	/** Panel de informacion para la apuesta de Chance. */
	private PanelInformacionApuestaChance panelInformacionApuestaChance;

	/** Panel de informacion para la apuesta de Bet Play. */
	private PanelInformacionApuestaBetPlay panelInformacionApuestaBetPlay;

	/** Labels de secciones del panel. */
	private JLabel seccionCentral, seccionNorte, seccionSur, seccionEste, seccionOeste;

	/** Subsecciones del panel. */
	private JLabel subseccion1, subseccion2, subseccion3;

	/** Label para el nombre del cliente. */
	private JLabel labelNombreCliente;

	/** Label para la fecha de emision. */
	private JLabel labelFechaDeEmision;

	/** Label para el tipo de juego. */
	private JLabel labelTipoDeJuego;

	/** Campo de texto para el nombre del cliente. */
	private JTextField campoNombreCliente;

	/** Campo de texto para la fecha de emision de la apuesta. */
	private JTextField campoFechaDeEmision;

	/** Campo de texto para el tipo de juego. */
	private JTextField campoTipoDeJuego;

	/** Lienzo para desplegar elementos en el panel. */
	private CardLayout cardLayout;

	/** Seccion para mostrar el monto total. */
	private JLabel seccionMontoTotal;

	/** Label para mostrar el monto total. */
	private JLabel labelMontoTotal;

	/** Campo de texto para ingresar el monto total. */
	private JTextField campoMontoTotal;

	/** Boton para cerrar y guardar la apuesta. */
	private JButton btnCerrarYGuardar;
	
	
	/** The cerrar y guardar. */
	public final String CERRAR_Y_GUARDAR = "Cerrar y Guardar";

	/**
	 * Instantiates a new panel factura apuesta.
	 */
	public PanelFacturaApuesta() {
		setLayout(new BorderLayout());

		// Definir sección norte
		seccionNorte = new JLabel();
		seccionNorte.setText("Factura Apuesta");
		seccionNorte.setFont(new Font("Concord", Font.BOLD, 30));
		seccionNorte.setVerticalAlignment(JLabel.CENTER);
		seccionNorte.setHorizontalAlignment(JLabel.CENTER);
		seccionNorte.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// Definir sección central
		seccionCentral = new JLabel();
		seccionCentral.setLayout(new GridLayout(3, 1, 10, 10));
		
		subseccion1 = new JLabel();
		subseccion1.setLayout(new GridLayout(3, 2, 10, 10));
		
		labelNombreCliente = new JLabel();
		labelNombreCliente.setText("Nombre del Cliente");
		
		campoNombreCliente = new JTextField();
		campoNombreCliente.setEditable(false);
		
		labelFechaDeEmision = new JLabel();
		labelFechaDeEmision.setText("Fecha de Emisión");
		
		campoFechaDeEmision = new JTextField();
		campoFechaDeEmision.setEditable(false);
		
		labelTipoDeJuego = new JLabel();
		labelTipoDeJuego.setText("Tipo de Juego");
		
		campoTipoDeJuego = new JTextField();
		campoTipoDeJuego.setEditable(false);
		
		
		subseccion1.add(labelNombreCliente);
		subseccion1.add(campoNombreCliente);
		subseccion1.add(labelFechaDeEmision);
		subseccion1.add(campoFechaDeEmision);
		subseccion1.add(labelTipoDeJuego);
		subseccion1.add(campoTipoDeJuego);
		
		// Lienzo que permitirá visualizar la información de la apuesta como por ejemplo los números seleccionados
		cardLayout = new CardLayout();
		
		subseccion2 = new JLabel();
		subseccion2.setLayout(cardLayout);
		
		panelInformacionApuestaLoteria = new PanelInformacionApuestaLoteria();
		subseccion2.add(panelInformacionApuestaLoteria, "panelInformacionApuestaLoteria");
		
		panelInformacionApuestaSuperAstro = new PanelInformacionApuestaSuperAstro();
		subseccion2.add(panelInformacionApuestaSuperAstro, "panelInformacionApuestaSuperAstro");
		
		panelInformacionApuestaBaloto = new PanelInformacionApuestaBaloto();
		subseccion2.add(panelInformacionApuestaBaloto, "panelInformacionApuestaBaloto");
		
		panelInformacionApuestaChance = new PanelInformacionApuestaChance();
		subseccion2.add(panelInformacionApuestaChance, "panelInformacionApuestaChance");
		
		panelInformacionApuestaBetPlay = new PanelInformacionApuestaBetPlay();
		subseccion2.add(panelInformacionApuestaBetPlay, "panelInformacionApuestaBetPlay");
		
		
		subseccion3 = new JLabel();
		subseccion3.setLayout(new GridLayout(2, 1, 5, 5));
		
		seccionMontoTotal = new JLabel();
		seccionMontoTotal.setLayout(new GridLayout(1, 3, 10, 10));
		
		labelMontoTotal = new JLabel();
		labelMontoTotal.setText("Monto Total");
		labelMontoTotal.setHorizontalAlignment(JLabel.RIGHT);
		
		campoMontoTotal = new JTextField();
		campoMontoTotal.setEditable(false);
		
		seccionMontoTotal.add(new JLabel(""));
		seccionMontoTotal.add(labelMontoTotal);
		seccionMontoTotal.add(campoMontoTotal);
		
		btnCerrarYGuardar = new JButton();
		btnCerrarYGuardar.setText(CERRAR_Y_GUARDAR);
		btnCerrarYGuardar.setActionCommand(CERRAR_Y_GUARDAR);
		
		subseccion3.add(seccionMontoTotal);
		subseccion3.add(btnCerrarYGuardar);
		
		
		seccionCentral.add(subseccion1);
		seccionCentral.add(subseccion2);
		seccionCentral.add(subseccion3);
		

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
	 * Mostrar panel informacion apuesta loteria.
	 */
	public void mostrarPanelInformacionApuestaLoteria() {
		cardLayout.show(subseccion2, "panelInformacionApuestaLoteria");
	}
	
	/**
	 * Mostrar panel informacion apuesta super astro.
	 */
	public void mostrarPanelInformacionApuestaSuperAstro() {
		cardLayout.show(subseccion2, "panelInformacionApuestaSuperAstro");
	}
	
	/**
	 * Mostrar panel informacion apuesta baloto.
	 */
	public void mostrarPanelInformacionApuestaBaloto() {
		cardLayout.show(subseccion2, "panelInformacionApuestaBaloto");
	}
	
	/**
	 * Mostrar panel informacion apuesta chance.
	 */
	public void mostrarPanelInformacionApuestaChance() {
		cardLayout.show(subseccion2, "panelInformacionApuestaChance");
	}
	
	/**
	 * Mostrar panel informacion apuesta bet play.
	 */
	public void mostrarPanelInformacionApuestaBetPlay() {
		cardLayout.show(subseccion2, "panelInformacionApuestaBetPlay");
	}
	

	/**
	 * Gets the panel informacion apuesta loteria.
	 *
	 * @return the panel informacion apuesta loteria
	 */
	public PanelInformacionApuestaLoteria getPanelInformacionApuestaLoteria() {
		return panelInformacionApuestaLoteria;
	}

	/**
	 * Sets the panel informacion apuesta loteria.
	 *
	 * @param panelInformacionApuestaLoteria the new panel informacion apuesta loteria
	 */
	public void setPanelInformacionApuestaLoteria(PanelInformacionApuestaLoteria panelInformacionApuestaLoteria) {
		this.panelInformacionApuestaLoteria = panelInformacionApuestaLoteria;
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
	 * Gets the subseccion 1.
	 *
	 * @return the subseccion 1
	 */
	public JLabel getSubseccion1() {
		return subseccion1;
	}

	/**
	 * Sets the subseccion 1.
	 *
	 * @param subseccion1 the new subseccion 1
	 */
	public void setSubseccion1(JLabel subseccion1) {
		this.subseccion1 = subseccion1;
	}

	/**
	 * Gets the subseccion 2.
	 *
	 * @return the subseccion 2
	 */
	public JLabel getSubseccion2() {
		return subseccion2;
	}

	/**
	 * Sets the subseccion 2.
	 *
	 * @param subseccion2 the new subseccion 2
	 */
	public void setSubseccion2(JLabel subseccion2) {
		this.subseccion2 = subseccion2;
	}

	/**
	 * Gets the subseccion 3.
	 *
	 * @return the subseccion 3
	 */
	public JLabel getSubseccion3() {
		return subseccion3;
	}

	/**
	 * Sets the subseccion 3.
	 *
	 * @param subseccion3 the new subseccion 3
	 */
	public void setSubseccion3(JLabel subseccion3) {
		this.subseccion3 = subseccion3;
	}

	/**
	 * Gets the label nombre cliente.
	 *
	 * @return the label nombre cliente
	 */
	public JLabel getLabelNombreCliente() {
		return labelNombreCliente;
	}

	/**
	 * Sets the label nombre cliente.
	 *
	 * @param labelNombreCliente the new label nombre cliente
	 */
	public void setLabelNombreCliente(JLabel labelNombreCliente) {
		this.labelNombreCliente = labelNombreCliente;
	}

	/**
	 * Gets the label fecha de emision.
	 *
	 * @return the label fecha de emision
	 */
	public JLabel getLabelFechaDeEmision() {
		return labelFechaDeEmision;
	}

	/**
	 * Sets the label fecha de emision.
	 *
	 * @param labelFechaDeEmision the new label fecha de emision
	 */
	public void setLabelFechaDeEmision(JLabel labelFechaDeEmision) {
		this.labelFechaDeEmision = labelFechaDeEmision;
	}

	/**
	 * Gets the label tipo de juego.
	 *
	 * @return the label tipo de juego
	 */
	public JLabel getLabelTipoDeJuego() {
		return labelTipoDeJuego;
	}

	/**
	 * Sets the label tipo de juego.
	 *
	 * @param labelTipoDeJuego the new label tipo de juego
	 */
	public void setLabelTipoDeJuego(JLabel labelTipoDeJuego) {
		this.labelTipoDeJuego = labelTipoDeJuego;
	}

	/**
	 * Gets the campo nombre cliente.
	 *
	 * @return the campo nombre cliente
	 */
	public JTextField getCampoNombreCliente() {
		return campoNombreCliente;
	}

	/**
	 * Sets the campo nombre cliente.
	 *
	 * @param campoNombreCliente the new campo nombre cliente
	 */
	public void setCampoNombreCliente(JTextField campoNombreCliente) {
		this.campoNombreCliente = campoNombreCliente;
	}

	/**
	 * Gets the campo fecha de emision.
	 *
	 * @return the campo fecha de emision
	 */
	public JTextField getCampoFechaDeEmision() {
		return campoFechaDeEmision;
	}

	/**
	 * Sets the campo fecha de emision.
	 *
	 * @param campoFechaDeEmision the new campo fecha de emision
	 */
	public void setCampoFechaDeEmision(JTextField campoFechaDeEmision) {
		this.campoFechaDeEmision = campoFechaDeEmision;
	}

	/**
	 * Gets the campo tipo de juego.
	 *
	 * @return the campo tipo de juego
	 */
	public JTextField getCampoTipoDeJuego() {
		return campoTipoDeJuego;
	}

	/**
	 * Sets the campo tipo de juego.
	 *
	 * @param campoTipoDeJuego the new campo tipo de juego
	 */
	public void setCampoTipoDeJuego(JTextField campoTipoDeJuego) {
		this.campoTipoDeJuego = campoTipoDeJuego;
	}

	/**
	 * Gets the card layout.
	 *
	 * @return the card layout
	 */
	public CardLayout getCardLayout() {
		return cardLayout;
	}

	/**
	 * Sets the card layout.
	 *
	 * @param cardLayout the new card layout
	 */
	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	/**
	 * Gets the seccion monto total.
	 *
	 * @return the seccion monto total
	 */
	public JLabel getSeccionMontoTotal() {
		return seccionMontoTotal;
	}

	/**
	 * Sets the seccion monto total.
	 *
	 * @param seccionMontoTotal the new seccion monto total
	 */
	public void setSeccionMontoTotal(JLabel seccionMontoTotal) {
		this.seccionMontoTotal = seccionMontoTotal;
	}

	/**
	 * Gets the label monto total.
	 *
	 * @return the label monto total
	 */
	public JLabel getLabelMontoTotal() {
		return labelMontoTotal;
	}

	/**
	 * Sets the label monto total.
	 *
	 * @param labelMontoTotal the new label monto total
	 */
	public void setLabelMontoTotal(JLabel labelMontoTotal) {
		this.labelMontoTotal = labelMontoTotal;
	}

	/**
	 * Gets the campo monto total.
	 *
	 * @return the campo monto total
	 */
	public JTextField getCampoMontoTotal() {
		return campoMontoTotal;
	}

	/**
	 * Sets the campo monto total.
	 *
	 * @param campoMontoTotal the new campo monto total
	 */
	public void setCampoMontoTotal(JTextField campoMontoTotal) {
		this.campoMontoTotal = campoMontoTotal;
	}

	/**
	 * Gets the btn cerrar Y guardar.
	 *
	 * @return the btn cerrar Y guardar
	 */
	public JButton getBtnCerrarYGuardar() {
		return btnCerrarYGuardar;
	}

	/**
	 * Sets the btn cerrar Y guardar.
	 *
	 * @param btnCerrarYGuardar the new btn cerrar Y guardar
	 */
	public void setBtnCerrarYGuardar(JButton btnCerrarYGuardar) {
		this.btnCerrarYGuardar = btnCerrarYGuardar;
	}

	/**
	 * Gets the panel informacion apuesta super astro.
	 *
	 * @return the panel informacion apuesta super astro
	 */
	public PanelInformacionApuestaSuperAstro getPanelInformacionApuestaSuperAstro() {
		return panelInformacionApuestaSuperAstro;
	}

	/**
	 * Sets the panel informacion apuesta super astro.
	 *
	 * @param panelInformacionApuestaSuperAstro the new panel informacion apuesta super astro
	 */
	public void setPanelInformacionApuestaSuperAstro(PanelInformacionApuestaSuperAstro panelInformacionApuestaSuperAstro) {
		this.panelInformacionApuestaSuperAstro = panelInformacionApuestaSuperAstro;
	}

	/**
	 * Gets the panel informacion apuesta baloto.
	 *
	 * @return the panel informacion apuesta baloto
	 */
	public PanelInformacionApuestaBaloto getPanelInformacionApuestaBaloto() {
		return panelInformacionApuestaBaloto;
	}

	/**
	 * Sets the panel informacion apuesta baloto.
	 *
	 * @param panelInformacionApuestaBaloto the new panel informacion apuesta baloto
	 */
	public void setPanelInformacionApuestaBaloto(PanelInformacionApuestaBaloto panelInformacionApuestaBaloto) {
		this.panelInformacionApuestaBaloto = panelInformacionApuestaBaloto;
	}

	/**
	 * Gets the panel informacion apuesta chance.
	 *
	 * @return the panel informacion apuesta chance
	 */
	public PanelInformacionApuestaChance getPanelInformacionApuestaChance() {
		return panelInformacionApuestaChance;
	}

	/**
	 * Sets the panel informacion apuesta chance.
	 *
	 * @param panelInformacionApuestaChance the new panel informacion apuesta chance
	 */
	public void setPanelInformacionApuestaChance(PanelInformacionApuestaChance panelInformacionApuestaChance) {
		this.panelInformacionApuestaChance = panelInformacionApuestaChance;
	}

	/**
	 * Gets the panel informacion apuesta bet play.
	 *
	 * @return the panel informacion apuesta bet play
	 */
	public PanelInformacionApuestaBetPlay getPanelInformacionApuestaBetPlay() {
		return panelInformacionApuestaBetPlay;
	}

	/**
	 * Sets the panel informacion apuesta bet play.
	 *
	 * @param panelInformacionApuestaBetPlay the new panel informacion apuesta bet play
	 */
	public void setPanelInformacionApuestaBetPlay(PanelInformacionApuestaBetPlay panelInformacionApuestaBetPlay) {
		this.panelInformacionApuestaBetPlay = panelInformacionApuestaBetPlay;
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
