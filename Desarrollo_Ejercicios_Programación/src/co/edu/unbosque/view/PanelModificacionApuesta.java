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
 * The Class PanelModificacionApuesta.
 */
public class PanelModificacionApuesta extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Lienzo para mostrar los paneles de las apuestas. */
	private CardLayout cardLayout;
	
	/** Paneles para mostrar informacion detallada de una apuesta de loteria. */
	private PanelInformacionApuestaLoteria panelInformacionApuestaLoteria;
	
	/** Paneles para mostrar informacion detallada de una apuesta de superastro. */
	private PanelInformacionApuestaSuperAstro panelInformacionApuestaSuperAstro;
	
	/** Paneles para mostrar informacion detallada de una apuesta de baloto. */
	private PanelInformacionApuestaBaloto panelInformacionApuestaBaloto;
	
	/** Paneles para mostrar informacion detallada de una apuesta de betplay. */
	private PanelInformacionApuestaBetPlay panelInformacionApuestaBetPlay;
	
	/** Paneles para mostrar informacion detallada de una apuesta de chance. */
	private PanelInformacionApuestaChance panelInformacionApuestaChance;
	
	/** Seccion en la cual se ubican los botones de navegacion. */
	private JPanel seccionBotonesNavegacion;
	
	/** Secciones principales del panel. */
	private JLabel seccionCentral, seccionNorte, seccionEste, seccionOeste;
	
	/** Secciones relacionadas con la configuracion y presentacion de apuestas. */
	private JLabel seccionConfiguracionApuesta, seccionApuesta;
	
	/** Labels que identifican los campos de entrada de datos relacionados con la apuesta. */
	private JLabel labelSedeApuesta, labelcedulaApostador, labelTipoDeApuesta, labelValorApuesta;
	
	/**  Selección de las sedes actuales en las cuales se puede realizar la apuesta. */
	private JComboBox<String> seleccionSede;
	
	/** Campos de texto para la cedula del apostador, el tipo y valor de la apuesta. */
	private JTextField campoCedulaApostador, campoTipoDeApuesta, campoValorApuesta;
	
	/**  Botones de navegacion. */
	private JButton btnVolverAlMenuPrincipal, btnVolverAGestionApuestas, btnModificarApuesta;
	
	/** The seleccionar tipo de apuesta. */
	public final String SELECCIONAR_TIPO_DE_APUESTA = "Tipo de Apuesta";
	
	/** The volver al menu principal. */
	public final String VOLVER_AL_MENU_PRINCIPAL = "Volver al Menu Principal";
	
	/** The volver a gestion apuestas. */
	public final String VOLVER_A_GESTION_APUESTAS = "Volver a Gestión Apuestas";
	
	/** The modificar apuesta. */
	public final String MODIFICAR_APUESTA = "Modificar apuesta";
	
	/**
	 * Instantiates a new panel modificacion apuesta.
	 */
	public PanelModificacionApuesta() {
		
		setLayout(new BorderLayout());
		
		// Definir sección norte
		seccionNorte = new JLabel();
		seccionNorte.setText("Modificar Apuesta");
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
		campoCedulaApostador.setEditable(false);
		
		labelTipoDeApuesta = new JLabel();
		labelTipoDeApuesta.setText("Tipo de Apuesta");
		
		campoTipoDeApuesta = new JTextField();
		campoTipoDeApuesta.setEditable(false);
		
		labelValorApuesta = new JLabel();
		labelValorApuesta.setText("Valor de la Apuesta");
		
		campoValorApuesta = new JTextField();
		
		
		seccionConfiguracionApuesta.add(labelSedeApuesta);
		seccionConfiguracionApuesta.add(seleccionSede);
		seccionConfiguracionApuesta.add(labelcedulaApostador);
		seccionConfiguracionApuesta.add(campoCedulaApostador);
		seccionConfiguracionApuesta.add(labelTipoDeApuesta);
		seccionConfiguracionApuesta.add(campoTipoDeApuesta);
		seccionConfiguracionApuesta.add(labelValorApuesta);
		seccionConfiguracionApuesta.add(campoValorApuesta);
		
		
		// Lienzo que permitirá visualizar los paneles dependiendo del tipo de apuesta seleccionada
		cardLayout = new CardLayout();
		
		seccionApuesta = new JLabel();
		seccionApuesta.setLayout(cardLayout);
		
		// Agregar el panel de lotería que se mostrará al seleccionar el tipo de apuesta Lotería
		panelInformacionApuestaLoteria = new PanelInformacionApuestaLoteria();
		panelInformacionApuestaLoteria.setBorder(BorderFactory.createTitledBorder("Información Apuesta Lotería"));
		seccionApuesta.add(panelInformacionApuestaLoteria, "panelInformacionApuestaLoteria");
		
		// Agregar el panel de superAstro que se mostrará al seleccionar el tipo de apuesta superAstro
		panelInformacionApuestaSuperAstro = new PanelInformacionApuestaSuperAstro();
		panelInformacionApuestaSuperAstro.setBorder(BorderFactory.createTitledBorder("Información Apuesta SuperAstro"));
		seccionApuesta.add(panelInformacionApuestaSuperAstro, "panelInformacionApuestaSuperAstro");
		
		// Agregar el panel de baloto que se mostrará al seleccionar el tipo de apuesta baloto
		panelInformacionApuestaBaloto = new PanelInformacionApuestaBaloto();
		panelInformacionApuestaBaloto.setBorder(BorderFactory.createTitledBorder("Información Apuesta Baloto"));
		seccionApuesta.add(panelInformacionApuestaBaloto, "panelInformacionApuestaBaloto");
		
		// Agregar el panel de betplay que se mostrará al seleccionar el tipo de apuesta betplay
		panelInformacionApuestaBetPlay = new PanelInformacionApuestaBetPlay();
		panelInformacionApuestaBetPlay.setBorder(BorderFactory.createTitledBorder("Información Apuesta BetPlay"));
		seccionApuesta.add(panelInformacionApuestaBetPlay, "panelInformacionApuestaBetPlay");
		
		// Agregar el panel de chance que se mostrará al seleccionar el tipo de apuesta chance
		panelInformacionApuestaChance = new PanelInformacionApuestaChance();
		panelInformacionApuestaChance.setBorder(BorderFactory.createTitledBorder("Información Apuesta Chance"));
		seccionApuesta.add(panelInformacionApuestaChance, "panelInformacionApuestaChance");
		
		// Agregar un panel vacío para cuando no se haya seleccionado ninguna apuesta
		seccionApuesta.add(new JPanel(), "");
		
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
		
		btnModificarApuesta = new JButton();
		btnModificarApuesta.setText(MODIFICAR_APUESTA);
		btnModificarApuesta.setActionCommand(MODIFICAR_APUESTA);
		
		seccionBotonesNavegacion.add(btnVolverAlMenuPrincipal);
		seccionBotonesNavegacion.add(btnVolverAGestionApuestas);
		seccionBotonesNavegacion.add(btnModificarApuesta);

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
	 * @param tipoDeApuesta Tipo de apuesta a mostrar
	 */
	public void mostrarPanelApuesta(String tipoDeApuesta) {
		// Obtener el comando agregado al lienzo seccionApuesta
		String comandoTipoDeApuesta = "";
		
		switch (tipoDeApuesta) {
		
			case "Loteria":
				comandoTipoDeApuesta = "panelInformacionApuestaLoteria";
				break;
			case "SuperAstro":
				comandoTipoDeApuesta = "panelInformacionApuestaSuperAstro";
				break;
			case "Baloto":
				comandoTipoDeApuesta = "panelInformacionApuestaBaloto";
				break;
			case "BetPlay":
				comandoTipoDeApuesta = "panelInformacionApuestaBetPlay";
				break;
			case "Chance":
				comandoTipoDeApuesta = "panelInformacionApuestaChance";
				break;
		
		}
		
		cardLayout.show(seccionApuesta, comandoTipoDeApuesta);
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
	 * Gets the seccion botones navegacion.
	 *
	 * @return the seccion botones navegacion
	 */
	public JPanel getSeccionBotonesNavegacion() {
		return seccionBotonesNavegacion;
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
	 * Gets the labelcedula apostador.
	 *
	 * @return the labelcedula apostador
	 */
	public JLabel getLabelcedulaApostador() {
		return labelcedulaApostador;
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
	 * Gets the campo tipo de apuesta.
	 *
	 * @return the campo tipo de apuesta
	 */
	public JTextField getCampoTipoDeApuesta() {
		return campoTipoDeApuesta;
	}

	/**
	 * Sets the campo tipo de apuesta.
	 *
	 * @param campoTipoDeApuesta the new campo tipo de apuesta
	 */
	public void setCampoTipoDeApuesta(JTextField campoTipoDeApuesta) {
		this.campoTipoDeApuesta = campoTipoDeApuesta;
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
	 * Gets the btn modificar apuesta.
	 *
	 * @return the btn modificar apuesta
	 */
	public JButton getBtnModificarApuesta() {
		return btnModificarApuesta;
	}

	/**
	 * Sets the btn modificar apuesta.
	 *
	 * @param btnModificarApuesta the new btn modificar apuesta
	 */
	public void setBtnModificarApuesta(JButton btnModificarApuesta) {
		this.btnModificarApuesta = btnModificarApuesta;
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
