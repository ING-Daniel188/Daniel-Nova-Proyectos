package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Class PanelCreacionApuesta.
 */
public class PanelCreacionApuesta extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Lienzo para el panel. */
	private CardLayout cardLayout;
	
	/** Panel para apuesta de loteria. */
	private PanelApuestaLoteria panelApuestaLoteria;
	
	/** Panel para apuesta de superastro. */
	private PanelApuestaSuperAstro panelApuestaSuperAstro;
	
	/** Panel para apuesta de baloto. */
	private PanelApuestaBaloto panelApuestaBaloto;
	
	/** Panel para apuesta de betplay. */
	private PanelApuestaBetPlay panelApuestaBetPlay;
	
	/** Panel para apuesta de chance. */
	private PanelApuestaChance panelApuestaChance;
	
	
	/** Seccion de botones para la navegacion y disposicion del panel. */
	private JPanel seccionBotonesNavegacion;
	
	/** Secciones del panel: central, norte, este, oeste. */
	private JLabel seccionCentral, seccionNorte, seccionEste, seccionOeste;
	
	/** Secciones especificas para la configuracion y realizacion de apuestas. */
	private JLabel seccionConfiguracionApuesta, seccionApuesta;
	
	/** Labels para la informacion de la apuesta: sede, cedula del apostador, tipo de apuesta, valor de la apuesta. */
	private JLabel labelSedeApuesta, labelcedulaApostador, labelTipoDeApuesta, labelValorApuesta;
	
	/** Selección de la sede y tipo de apuesta. */
	private JComboBox<String> seleccionSede, seleccionTipoDeApuesta;
	
	/** Campos para ingresar la cedula del apostador y el valor de la apuesta. */
	private JTextField campoCedulaApostador, campoValorApuesta;
	
	/** Botones para la navegacion y la realizacion de la apuesta. */
	private JButton btnVolverAlMenuPrincipal, btnVolverAGestionApuestas, btnRealizarApuesta;
	
	/** The seleccionar tipo de apuesta. */
	public final String SELECCIONAR_TIPO_DE_APUESTA = "Tipo de Apuesta";
	
	/** The volver al menu principal. */
	public final String VOLVER_AL_MENU_PRINCIPAL = "Volver al Menu Principal";
	
	/** The volver a gestion apuestas. */
	public final String VOLVER_A_GESTION_APUESTAS = "Volver a Gestión Apuestas";
	
	/** The realizar apuesta. */
	public final String REALIZAR_APUESTA = "Realizar Apuesta";
	
	/**
	 * Instantiates a new panel creacion apuesta.
	 */
	public PanelCreacionApuesta() {
		
		setLayout(new BorderLayout());
		
		// Definir sección norte
		seccionNorte = new JLabel();
		seccionNorte.setText("Crear Apuesta");
		seccionNorte.setFont(new Font("Concord", Font.BOLD, 30));
		seccionNorte.setVerticalAlignment(JLabel.CENTER);
		seccionNorte.setHorizontalAlignment(JLabel.CENTER);
		seccionNorte.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		// Definir sección central
		seccionCentral = new JLabel();
		seccionCentral.setLayout(new GridLayout(2, 1, 10, 10));
		
		seccionConfiguracionApuesta = new JLabel();
		seccionConfiguracionApuesta.setLayout(new GridLayout(2, 4, 10, 10));
		seccionConfiguracionApuesta.setBorder(BorderFactory.createTitledBorder("Configuración de la apuesta"));
		
		labelSedeApuesta = new JLabel();
		labelSedeApuesta.setText("Sede de la Apuesta");
		
		seleccionSede = new JComboBox<String>();
		
		labelcedulaApostador = new JLabel();
		labelcedulaApostador.setText("Cédula del Apostador");
		
		campoCedulaApostador = new JTextField();
		
		labelTipoDeApuesta = new JLabel();
		labelTipoDeApuesta.setText("Tipo de Apuesta");
		
		seleccionTipoDeApuesta = new JComboBox<String>();
		seleccionTipoDeApuesta.setActionCommand(SELECCIONAR_TIPO_DE_APUESTA);
		
		labelValorApuesta = new JLabel();
		labelValorApuesta.setText("Valor de la Apuesta");
		
		campoValorApuesta = new JTextField();
		
		
		seccionConfiguracionApuesta.add(labelSedeApuesta);
		seccionConfiguracionApuesta.add(seleccionSede);
		seccionConfiguracionApuesta.add(labelcedulaApostador);
		seccionConfiguracionApuesta.add(campoCedulaApostador);
		seccionConfiguracionApuesta.add(labelTipoDeApuesta);
		seccionConfiguracionApuesta.add(seleccionTipoDeApuesta);
		seccionConfiguracionApuesta.add(labelValorApuesta);
		seccionConfiguracionApuesta.add(campoValorApuesta);
		
		
		// Lienzo que permitirá visualizar los paneles dependiendo del tipo de apuesta seleccionada
		cardLayout = new CardLayout();
		
		seccionApuesta = new JLabel();
		seccionApuesta.setLayout(cardLayout);
		
		// Agregar el panel de lotería que se mostrará al seleccionar el tipo de apuesta Lotería
		panelApuestaLoteria = new PanelApuestaLoteria();
		seccionApuesta.add(panelApuestaLoteria, "panelApuestaLoteria");
		
		// Agregar el panel de superAstro que se mostrará al seleccionar el tipo de apuesta superAstro
		panelApuestaSuperAstro = new PanelApuestaSuperAstro();
		seccionApuesta.add(panelApuestaSuperAstro, "panelApuestaSuperAstro");
		
		// Agregar el panel de baloto que se mostrará al seleccionar el tipo de apuesta baloto
		panelApuestaBaloto = new PanelApuestaBaloto();
		seccionApuesta.add(panelApuestaBaloto, "panelApuestaBaloto");
		
		
		// Agregar el panel de baloto que se mostrará al seleccionar el tipo de apuesta betPlay
		panelApuestaBetPlay = new PanelApuestaBetPlay();
		seccionApuesta.add(panelApuestaBetPlay, "panelApuestaBetPlay");
		
		// Agregar el panel de baloto que se mostrará al seleccionar el tipo de apuesta chance
		panelApuestaChance = new PanelApuestaChance();
		seccionApuesta.add(panelApuestaChance, "panelApuestaChance");
		
		
		// Agregar un panel vacío para cuando no se haya seleccionado ninguna apuesta
		seccionApuesta.add(new JPanel(), "panelVacio");
		
		seccionCentral.add(seccionConfiguracionApuesta);
		seccionCentral.add(seccionApuesta);
		
		// Definir sección botones de navegación
		seccionBotonesNavegacion = new JPanel();
		seccionBotonesNavegacion.setLayout(new GridLayout(1, 3, 10, 10));
		seccionBotonesNavegacion.setPreferredSize(new Dimension(100, 100));
		seccionBotonesNavegacion.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		
		btnVolverAlMenuPrincipal = new JButton();
		btnVolverAlMenuPrincipal.setText(VOLVER_AL_MENU_PRINCIPAL);
		btnVolverAlMenuPrincipal.setActionCommand(VOLVER_AL_MENU_PRINCIPAL);
		
		btnVolverAGestionApuestas = new JButton();
		btnVolverAGestionApuestas.setText(VOLVER_A_GESTION_APUESTAS);
		btnVolverAGestionApuestas.setActionCommand(VOLVER_A_GESTION_APUESTAS);
		
		btnRealizarApuesta = new JButton();
		btnRealizarApuesta.setText(REALIZAR_APUESTA);
		btnRealizarApuesta.setActionCommand(REALIZAR_APUESTA);
		
		
		seccionBotonesNavegacion.add(btnVolverAlMenuPrincipal);
		seccionBotonesNavegacion.add(btnVolverAGestionApuestas);
		seccionBotonesNavegacion.add(btnRealizarApuesta);

		
		// Definir sección este
		seccionEste = new JLabel("    ");

		// Definir sección oeste
		seccionOeste = new JLabel("    ");

		add(seccionNorte, BorderLayout.NORTH);
		add(seccionCentral, BorderLayout.CENTER);
		add(seccionBotonesNavegacion, BorderLayout.SOUTH);
		add(seccionEste, BorderLayout.EAST);
		add(seccionOeste, BorderLayout.WEST);
		
	}
	
	/**
	 * Mostrar panel apuesta.
	 *
	 * @param tipoDeApuesta the tipo de apuesta
	 */
	public void mostrarPanelApuesta(String tipoDeApuesta) {
		// Obtener el comando agregado al lienzo seccionApuesta
		String comandoTipoDeApuesta;
		
		switch (tipoDeApuesta) {
		
			case "Loteria":
				comandoTipoDeApuesta = "panelApuestaLoteria";
				break;
			case "SuperAstro":
				comandoTipoDeApuesta = "panelApuestaSuperAstro";
				break;
			case "Baloto":
				comandoTipoDeApuesta = "panelApuestaBaloto";
				break;
			case "BetPlay":
				comandoTipoDeApuesta = "panelApuestaBetPlay";
				break;
			case "Chance":
				comandoTipoDeApuesta = "panelApuestaChance";
				break;
			default:
				comandoTipoDeApuesta = "panelVacio";
		
		}
		
		cardLayout.show(seccionApuesta, comandoTipoDeApuesta);
	}
	

	/**
	 * Gets the panel apuesta loteria.
	 *
	 * @return the panel apuesta loteria
	 */
	public PanelApuestaLoteria getPanelApuestaLoteria() {
		return panelApuestaLoteria;
	}

	/**
	 * Sets the panel apuesta loteria.
	 *
	 * @param panelApuestaLoteria the new panel apuesta loteria
	 */
	public void setPanelApuestaLoteria(PanelApuestaLoteria panelApuestaLoteria) {
		this.panelApuestaLoteria = panelApuestaLoteria;
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
	 * Gets the panel apuesta bet play.
	 *
	 * @return the panel apuesta bet play
	 */
	public PanelApuestaBetPlay getPanelApuestaBetPlay() {
		return panelApuestaBetPlay;
	}

	/**
	 * Sets the panel apuesta bet play.
	 *
	 * @param panelApuestaBetPlay the new panel apuesta bet play
	 */
	public void setPanelApuestaBetPlay(PanelApuestaBetPlay panelApuestaBetPlay) {
		this.panelApuestaBetPlay = panelApuestaBetPlay;
	}

	/**
	 * Sets the seccion botones navegacion.
	 *
	 * @param seccionBotonesNavegacion the new seccion botones navegacion
	 */
	public void setSeccionBotonesNavegacion(JPanel seccionBotonesNavegacion) {
		this.seccionBotonesNavegacion = seccionBotonesNavegacion;
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
	 * Gets the seccion configuracion apuesta.
	 *
	 * @return the seccion configuracion apuesta
	 */
	public JLabel getSeccionConfiguracionApuesta() {
		return seccionConfiguracionApuesta;
	}

	/**
	 * Sets the seccion configuracion apuesta.
	 *
	 * @param seccionConfiguracionApuesta the new seccion configuracion apuesta
	 */
	public void setSeccionConfiguracionApuesta(JLabel seccionConfiguracionApuesta) {
		this.seccionConfiguracionApuesta = seccionConfiguracionApuesta;
	}

	/**
	 * Gets the seccion apuesta.
	 *
	 * @return the seccion apuesta
	 */
	public JLabel getSeccionApuesta() {
		return seccionApuesta;
	}

	/**
	 * Sets the seccion apuesta.
	 *
	 * @param seccionApuesta the new seccion apuesta
	 */
	public void setSeccionApuesta(JLabel seccionApuesta) {
		this.seccionApuesta = seccionApuesta;
	}

	/**
	 * Gets the label sede apuesta.
	 *
	 * @return the label sede apuesta
	 */
	public JLabel getLabelSedeApuesta() {
		return labelSedeApuesta;
	}

	/**
	 * Sets the label sede apuesta.
	 *
	 * @param labelSedeApuesta the new label sede apuesta
	 */
	public void setLabelSedeApuesta(JLabel labelSedeApuesta) {
		this.labelSedeApuesta = labelSedeApuesta;
	}

	/**
	 * Gets the labelcedula apostador.
	 *
	 * @return the labelcedula apostador
	 */
	public JLabel getLabelcedulaApostador() {
		return labelcedulaApostador;
	}

	/**
	 * Sets the labelcedula apostador.
	 *
	 * @param labelcedulaApostador the new labelcedula apostador
	 */
	public void setLabelcedulaApostador(JLabel labelcedulaApostador) {
		this.labelcedulaApostador = labelcedulaApostador;
	}

	/**
	 * Gets the label tipo de apuesta.
	 *
	 * @return the label tipo de apuesta
	 */
	public JLabel getLabelTipoDeApuesta() {
		return labelTipoDeApuesta;
	}

	/**
	 * Sets the label tipo de apuesta.
	 *
	 * @param labelTipoDeApuesta the new label tipo de apuesta
	 */
	public void setLabelTipoDeApuesta(JLabel labelTipoDeApuesta) {
		this.labelTipoDeApuesta = labelTipoDeApuesta;
	}

	/**
	 * Gets the label valor apuesta.
	 *
	 * @return the label valor apuesta
	 */
	public JLabel getLabelValorApuesta() {
		return labelValorApuesta;
	}

	/**
	 * Sets the label valor apuesta.
	 *
	 * @param labelValorApuesta the new label valor apuesta
	 */
	public void setLabelValorApuesta(JLabel labelValorApuesta) {
		this.labelValorApuesta = labelValorApuesta;
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
	 * Gets the seleccion tipo de apuesta.
	 *
	 * @return the seleccion tipo de apuesta
	 */
	public JComboBox<String> getSeleccionTipoDeApuesta() {
		return seleccionTipoDeApuesta;
	}

	/**
	 * Sets the seleccion tipo de apuesta.
	 *
	 * @param seleccionTipoDeApuesta the new seleccion tipo de apuesta
	 */
	public void setSeleccionTipoDeApuesta(JComboBox<String> seleccionTipoDeApuesta) {
		this.seleccionTipoDeApuesta = seleccionTipoDeApuesta;
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
	 * Gets the campo valor apuesta.
	 *
	 * @return the campo valor apuesta
	 */
	public JTextField getCampoValorApuesta() {
		return campoValorApuesta;
	}

	/**
	 * Sets the campo valor apuesta.
	 *
	 * @param campoValorApuesta the new campo valor apuesta
	 */
	public void setCampoValorApuesta(JTextField campoValorApuesta) {
		this.campoValorApuesta = campoValorApuesta;
	}

	/**
	 * Gets the btn volver al menu principal.
	 *
	 * @return the btn volver al menu principal
	 */
	public JButton getBtnVolverAlMenuPrincipal() {
		return btnVolverAlMenuPrincipal;
	}

	/**
	 * Sets the btn volver al menu principal.
	 *
	 * @param btnVolverAlMenuPrincipal the new btn volver al menu principal
	 */
	public void setBtnVolverAlMenuPrincipal(JButton btnVolverAlMenuPrincipal) {
		this.btnVolverAlMenuPrincipal = btnVolverAlMenuPrincipal;
	}

	/**
	 * Gets the btn volver A gestion apuestas.
	 *
	 * @return the btn volver A gestion apuestas
	 */
	public JButton getBtnVolverAGestionApuestas() {
		return btnVolverAGestionApuestas;
	}

	/**
	 * Sets the btn volver A gestion apuestas.
	 *
	 * @param btnVolverAGestionApuestas the new btn volver A gestion apuestas
	 */
	public void setBtnVolverAGestionApuestas(JButton btnVolverAGestionApuestas) {
		this.btnVolverAGestionApuestas = btnVolverAGestionApuestas;
	}

	/**
	 * Gets the btn realizar apuesta.
	 *
	 * @return the btn realizar apuesta
	 */
	public JButton getBtnRealizarApuesta() {
		return btnRealizarApuesta;
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
	 * Gets the panel apuesta super astro.
	 *
	 * @return the panel apuesta super astro
	 */
	public PanelApuestaSuperAstro getPanelApuestaSuperAstro() {
		return panelApuestaSuperAstro;
	}

	/**
	 * Sets the panel apuesta super astro.
	 *
	 * @param panelApuestaSuperAstro the new panel apuesta super astro
	 */
	public void setPanelApuestaSuperAstro(PanelApuestaSuperAstro panelApuestaSuperAstro) {
		this.panelApuestaSuperAstro = panelApuestaSuperAstro;
	}

	/**
	 * Gets the panel apuesta baloto.
	 *
	 * @return the panel apuesta baloto
	 */
	public PanelApuestaBaloto getPanelApuestaBaloto() {
		return panelApuestaBaloto;
	}

	/**
	 * Sets the panel apuesta baloto.
	 *
	 * @param panelApuestaBaloto the new panel apuesta baloto
	 */
	public void setPanelApuestaBaloto(PanelApuestaBaloto panelApuestaBaloto) {
		this.panelApuestaBaloto = panelApuestaBaloto;
	}

	/**
	 * Gets the panel apuesta chance.
	 *
	 * @return the panel apuesta chance
	 */
	public PanelApuestaChance getPanelApuestaChance() {
		return panelApuestaChance;
	}

	/**
	 * Sets the panel apuesta chance.
	 *
	 * @param panelApuestaChance the new panel apuesta chance
	 */
	public void setPanelApuestaChance(PanelApuestaChance panelApuestaChance) {
		this.panelApuestaChance = panelApuestaChance;
	}

	/**
	 * Sets the btn realizar apuesta.
	 *
	 * @param btnRealizarApuesta the new btn realizar apuesta
	 */
	public void setBtnRealizarApuesta(JButton btnRealizarApuesta) {
		this.btnRealizarApuesta = btnRealizarApuesta;
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