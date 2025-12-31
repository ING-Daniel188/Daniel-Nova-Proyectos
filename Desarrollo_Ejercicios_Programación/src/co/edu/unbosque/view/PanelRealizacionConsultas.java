package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Class PanelRealizacionConsultas.
 */
public class PanelRealizacionConsultas extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Paneles principales del panel. */
	private JPanel seccionNorte, seccionSur;
	
	/** Secciones principales del panel. */
	private JLabel seccionCentral, seccionEste, seccionOeste;
	
	/** Label para realizar consultas. */
	private JLabel labelRealizarConsultas;

	/** Filas para organizar botones de consulta. */
	private JLabel fila1BotonesConsulta, fila2BotonesConsulta;

	/** Botones para navegar y realizar consultas. */
	private JButton btnVolverAlMenuPrincipal;
	
	/** The btn mostrar clientes por sede. */
	private JButton btnMostrarClientesPorSede;
	
	/** The btn mostrar valor total apuestas. */
	private JButton btnMostrarValorTotalApuestas;
	
	/** The btn mostrar apuestas realizadas. */
	private JButton btnMostrarApuestasRealizadas;
	
	/** The btn mostrar total de apuestas. */
	private JButton btnMostrarTotalDeApuestas;

	/** Distribucion del lienzo y paneles relacionados con las consultas. */
	private CardLayout cardLayout;
	
	/** The panel clientes por sede. */
	private PanelClientesPorSede panelClientesPorSede;
	
	/** The panel valor total apuestas. */
	private PanelValorTotalApuestas panelValorTotalApuestas;
	
	/** The panel total apuestas. */
	private PanelTotalApuestas panelTotalApuestas;
	
	/** The panel detalle apuestas realizadas. */
	private PanelDetalleApuestasRealizadas panelDetalleApuestasRealizadas;
	
	
	/** The volver al menu principal. */
	public final String VOLVER_AL_MENU_PRINCIPAL = "Volver Al Menu Principal";
	
	/** The mostrar clientes por sede. */
	public final String MOSTRAR_CLIENTES_POR_SEDE = "Listado de Clientes por Sede";
	
	/** The mostrar valor total apuestas. */
	public final String MOSTRAR_VALOR_TOTAL_APUESTAS = "Valor total de Apuestas por Cliente";
	
	/** The mostrar apuestas realizadas. */
	public final String MOSTRAR_APUESTAS_REALIZADAS = "Apuestas Realizadas";
	
	/** The mostrar total de apuestas. */
	public final String MOSTRAR_TOTAL_DE_APUESTAS = "Total de Apuestas";
	
	
	/**
	 * Instantiates a new panel realizacion consultas.
	 */
	public PanelRealizacionConsultas() {
		
		setLayout(new BorderLayout());
		
		// Definir sección norte
		seccionNorte = new JPanel();
		seccionNorte.setLayout(new GridLayout(3, 1, 10, 10));
		seccionNorte.setPreferredSize(new Dimension(200, 200));
		seccionNorte.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		labelRealizarConsultas = new JLabel();
		labelRealizarConsultas.setText("Realizar Consultas");
		labelRealizarConsultas.setFont(new Font("Concord", Font.BOLD, 30));
		labelRealizarConsultas.setVerticalAlignment(JLabel.CENTER);
		labelRealizarConsultas.setHorizontalAlignment(JLabel.CENTER);
		
		
		fila1BotonesConsulta = new JLabel();
		fila1BotonesConsulta.setLayout(new GridLayout(1, 2, 10, 10));
		
		btnMostrarClientesPorSede = new JButton();
		btnMostrarClientesPorSede.setText(MOSTRAR_CLIENTES_POR_SEDE);
		btnMostrarClientesPorSede.setActionCommand(MOSTRAR_CLIENTES_POR_SEDE);
		
		btnMostrarValorTotalApuestas = new JButton();
		btnMostrarValorTotalApuestas.setText(MOSTRAR_VALOR_TOTAL_APUESTAS);
		btnMostrarValorTotalApuestas.setActionCommand(MOSTRAR_VALOR_TOTAL_APUESTAS);
		
		fila1BotonesConsulta.add(btnMostrarClientesPorSede);
		fila1BotonesConsulta.add(btnMostrarValorTotalApuestas);
		
		
		fila2BotonesConsulta = new JLabel();
		fila2BotonesConsulta.setLayout(new GridLayout(1, 2, 10, 10));
		
		btnMostrarApuestasRealizadas = new JButton();
		btnMostrarApuestasRealizadas.setText(MOSTRAR_APUESTAS_REALIZADAS);
		btnMostrarApuestasRealizadas.setActionCommand(MOSTRAR_APUESTAS_REALIZADAS);
		
		btnMostrarTotalDeApuestas = new JButton();
		btnMostrarTotalDeApuestas.setText(MOSTRAR_TOTAL_DE_APUESTAS);
		btnMostrarTotalDeApuestas.setActionCommand(MOSTRAR_TOTAL_DE_APUESTAS);
		
		fila2BotonesConsulta.add(btnMostrarApuestasRealizadas);
		fila2BotonesConsulta.add(btnMostrarTotalDeApuestas);
		
		
		seccionNorte.add(labelRealizarConsultas);
		seccionNorte.add(fila1BotonesConsulta);
		seccionNorte.add(fila2BotonesConsulta);
		
		
		// Definir sección central
		seccionCentral = new JLabel();
		
		// Lienzo que permitirá visualizar los paneles dependiendo del tipo de la consulta seleccionada
		cardLayout = new CardLayout();
		seccionCentral.setLayout(cardLayout);
		
		// Agregar el panel de clientes por sede
		panelClientesPorSede = new PanelClientesPorSede();
		seccionCentral.add(panelClientesPorSede, "panelClientesPorSede");
		
		// Agregar el panel de valor total apuestas por cliente
		panelValorTotalApuestas = new PanelValorTotalApuestas();
		seccionCentral.add(panelValorTotalApuestas, "panelValorTotalApuestas");
		
		// Agregar el panel de total de apuestas por sede y tipo de juego
		panelTotalApuestas = new PanelTotalApuestas();
		seccionCentral.add(panelTotalApuestas, "panelTotalApuestas");
		
		// Agregar el panel de total de detalle de apuestas realizadas por cliente y sede
		panelDetalleApuestasRealizadas = new PanelDetalleApuestasRealizadas();
		seccionCentral.add(panelDetalleApuestasRealizadas, "panelDetalleApuestasRealizadas");
		
		
		// Definir sección sur
		seccionSur = new JPanel();
		
		seccionSur.setPreferredSize(new Dimension(100, 100));
		seccionSur.setLayout(new GridLayout(1, 1));
		seccionSur.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		btnVolverAlMenuPrincipal = new JButton();
		btnVolverAlMenuPrincipal.setText(VOLVER_AL_MENU_PRINCIPAL);
		btnVolverAlMenuPrincipal.setActionCommand(VOLVER_AL_MENU_PRINCIPAL);
		
		seccionSur.add(btnVolverAlMenuPrincipal);
		
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
	 * Mostrar panel clientes por sede.
	 */
	public void mostrarPanelClientesPorSede() {
		cardLayout.show(seccionCentral, "panelClientesPorSede");
	}
	
	/**
	 * Mostrar panel valor total apuestas.
	 */
	public void mostrarPanelValorTotalApuestas() {
		cardLayout.show(seccionCentral, "panelValorTotalApuestas");
	}
	
	/**
	 * Mostrar panel total apuestas.
	 */
	public void mostrarPanelTotalApuestas() {
		cardLayout.show(seccionCentral, "panelTotalApuestas");
	}
	
	/**
	 * Mostrar panel detalle apuestas realizadas.
	 */
	public void mostrarPanelDetalleApuestasRealizadas() {
		cardLayout.show(seccionCentral, "panelDetalleApuestasRealizadas");
	}
	

	/**
	 * Gets the seccion norte.
	 *
	 * @return the seccion norte
	 */
	public JPanel getSeccionNorte() {
		return seccionNorte;
	}

	/**
	 * Sets the seccion norte.
	 *
	 * @param seccionNorte the new seccion norte
	 */
	public void setSeccionNorte(JPanel seccionNorte) {
		this.seccionNorte = seccionNorte;
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
	 * Gets the panel valor total apuestas.
	 *
	 * @return the panel valor total apuestas
	 */
	public PanelValorTotalApuestas getPanelValorTotalApuestas() {
		return panelValorTotalApuestas;
	}

	/**
	 * Sets the panel valor total apuestas.
	 *
	 * @param panelValorTotalApuestas the new panel valor total apuestas
	 */
	public void setPanelValorTotalApuestas(PanelValorTotalApuestas panelValorTotalApuestas) {
		this.panelValorTotalApuestas = panelValorTotalApuestas;
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
	 * Gets the label realizar consultas.
	 *
	 * @return the label realizar consultas
	 */
	public JLabel getLabelRealizarConsultas() {
		return labelRealizarConsultas;
	}

	/**
	 * Sets the label realizar consultas.
	 *
	 * @param labelRealizarConsultas the new label realizar consultas
	 */
	public void setLabelRealizarConsultas(JLabel labelRealizarConsultas) {
		this.labelRealizarConsultas = labelRealizarConsultas;
	}

	/**
	 * Gets the fila 1 botones consulta.
	 *
	 * @return the fila 1 botones consulta
	 */
	public JLabel getFila1BotonesConsulta() {
		return fila1BotonesConsulta;
	}

	/**
	 * Gets the panel detalle apuestas realizadas.
	 *
	 * @return the panel detalle apuestas realizadas
	 */
	public PanelDetalleApuestasRealizadas getPanelDetalleApuestasRealizadas() {
		return panelDetalleApuestasRealizadas;
	}

	/**
	 * Sets the panel detalle apuestas realizadas.
	 *
	 * @param panelDetalleApuestasRealizadas the new panel detalle apuestas realizadas
	 */
	public void setPanelDetalleApuestasRealizadas(PanelDetalleApuestasRealizadas panelDetalleApuestasRealizadas) {
		this.panelDetalleApuestasRealizadas = panelDetalleApuestasRealizadas;
	}

	/**
	 * Sets the fila 1 botones consulta.
	 *
	 * @param fila1BotonesConsulta the new fila 1 botones consulta
	 */
	public void setFila1BotonesConsulta(JLabel fila1BotonesConsulta) {
		this.fila1BotonesConsulta = fila1BotonesConsulta;
	}

	/**
	 * Gets the fila 2 botones consulta.
	 *
	 * @return the fila 2 botones consulta
	 */
	public JLabel getFila2BotonesConsulta() {
		return fila2BotonesConsulta;
	}

	/**
	 * Sets the fila 2 botones consulta.
	 *
	 * @param fila2BotonesConsulta the new fila 2 botones consulta
	 */
	public void setFila2BotonesConsulta(JLabel fila2BotonesConsulta) {
		this.fila2BotonesConsulta = fila2BotonesConsulta;
	}

	/**
	 * Gets the btn mostrar clientes por sede.
	 *
	 * @return the btn mostrar clientes por sede
	 */
	public JButton getBtnMostrarClientesPorSede() {
		return btnMostrarClientesPorSede;
	}

	/**
	 * Sets the btn mostrar clientes por sede.
	 *
	 * @param btnMostrarClientesPorSede the new btn mostrar clientes por sede
	 */
	public void setBtnMostrarClientesPorSede(JButton btnMostrarClientesPorSede) {
		this.btnMostrarClientesPorSede = btnMostrarClientesPorSede;
	}

	/**
	 * Gets the btn mostrar valor total apuestas.
	 *
	 * @return the btn mostrar valor total apuestas
	 */
	public JButton getBtnMostrarValorTotalApuestas() {
		return btnMostrarValorTotalApuestas;
	}

	/**
	 * Sets the btn mostrar valor total apuestas.
	 *
	 * @param btnMostrarValorTotalApuestas the new btn mostrar valor total apuestas
	 */
	public void setBtnMostrarValorTotalApuestas(JButton btnMostrarValorTotalApuestas) {
		this.btnMostrarValorTotalApuestas = btnMostrarValorTotalApuestas;
	}

	/**
	 * Gets the btn mostrar apuestas realizadas.
	 *
	 * @return the btn mostrar apuestas realizadas
	 */
	public JButton getBtnMostrarApuestasRealizadas() {
		return btnMostrarApuestasRealizadas;
	}

	/**
	 * Sets the btn mostrar apuestas realizadas.
	 *
	 * @param btnMostrarApuestasRealizadas the new btn mostrar apuestas realizadas
	 */
	public void setBtnMostrarApuestasRealizadas(JButton btnMostrarApuestasRealizadas) {
		this.btnMostrarApuestasRealizadas = btnMostrarApuestasRealizadas;
	}

	/**
	 * Gets the btn mostrar total de apuestas.
	 *
	 * @return the btn mostrar total de apuestas
	 */
	public JButton getBtnMostrarTotalDeApuestas() {
		return btnMostrarTotalDeApuestas;
	}

	/**
	 * Sets the btn mostrar total de apuestas.
	 *
	 * @param btnMostrarTotalDeApuestas the new btn mostrar total de apuestas
	 */
	public void setBtnMostrarTotalDeApuestas(JButton btnMostrarTotalDeApuestas) {
		this.btnMostrarTotalDeApuestas = btnMostrarTotalDeApuestas;
	}

	/**
	 * Gets the seccion sur.
	 *
	 * @return the seccion sur
	 */
	public JPanel getSeccionSur() {
		return seccionSur;
	}

	/**
	 * Sets the seccion sur.
	 *
	 * @param seccionSur the new seccion sur
	 */
	public void setSeccionSur(JPanel seccionSur) {
		this.seccionSur = seccionSur;
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
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * Gets the panel total apuestas.
	 *
	 * @return the panel total apuestas
	 */
	public PanelTotalApuestas getPanelTotalApuestas() {
		return panelTotalApuestas;
	}

	/**
	 * Sets the panel total apuestas.
	 *
	 * @param panelTotalApuestas the new panel total apuestas
	 */
	public void setPanelTotalApuestas(PanelTotalApuestas panelTotalApuestas) {
		this.panelTotalApuestas = panelTotalApuestas;
	}

	/**
	 * Gets the panel clientes por sede.
	 *
	 * @return the panel clientes por sede
	 */
	public PanelClientesPorSede getPanelClientesPorSede() {
		return panelClientesPorSede;
	}

	/**
	 * Sets the panel clientes por sede.
	 *
	 * @param panelClientesPorSede the new panel clientes por sede
	 */
	public void setPanelClientesPorSede(PanelClientesPorSede panelClientesPorSede) {
		this.panelClientesPorSede = panelClientesPorSede;
	}
	
}
