package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * The Class PanelMenuPrincipal.
 */
public class PanelMenuPrincipal extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Secciones principales del panel. */
	private JLabel seccionCentral, seccionNorte, seccionSur, seccionEste, seccionOeste;
	
	/** Botones de navegacion para redirigir a cada modulo. */
	private JButton btnGestionarSedes, btnGestionarApuestas, btnGestionarCasasDeApuestas, btnGestionarApostadores,
			btnRealizarConsultas;
	
	/** The parametrizar casa de apuestas. */
	public final String PARAMETRIZAR_CASA_DE_APUESTAS = "Parametrizar Casa de Apuestas";
	
	/** The gestionar sedes. */
	public final String GESTIONAR_SEDES = "Gestionar Sedes";
	
	/** The gestionar apostadores. */
	public final String GESTIONAR_APOSTADORES = "Gestionar Apostadores";
	
	/** The gestionar apuestas. */
	public final String GESTIONAR_APUESTAS = "Gestionar Apuestas";
	
	/** The realizar consultas. */
	public final String REALIZAR_CONSULTAS = "Realizar Consultas";

	/**
	 * Instantiates a new panel menu principal.
	 */
	public PanelMenuPrincipal() {
		setLayout(new BorderLayout());
		
		// Definir sección norte
		seccionNorte = new JLabel();
		seccionNorte.setText("Menú Principal");
		seccionNorte.setFont(new Font("Concord", Font.BOLD, 30));
		seccionNorte.setVerticalAlignment(JLabel.CENTER);
		seccionNorte.setHorizontalAlignment(JLabel.CENTER);
		seccionNorte.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		// Definir sección central
		seccionCentral = new JLabel();
		seccionCentral.setLayout(new GridLayout(3, 3));
		
		btnGestionarSedes = new JButton();
		btnGestionarSedes.setText(GESTIONAR_SEDES);
		btnGestionarSedes.setActionCommand(GESTIONAR_SEDES);
		btnGestionarSedes.setIcon(new ImageIcon(new ImageIcon("Recursos/Imagenes/sedes.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnGestionarSedes.setFocusable(false);
		
		btnGestionarApuestas = new JButton();
		btnGestionarApuestas.setText(GESTIONAR_APUESTAS);
		btnGestionarApuestas.setActionCommand(GESTIONAR_APUESTAS);
		btnGestionarApuestas.setIcon(new ImageIcon(new ImageIcon("Recursos/Imagenes/apuestas.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnGestionarApuestas.setFocusable(false);
		
		btnGestionarCasasDeApuestas = new JButton();
		btnGestionarCasasDeApuestas.setText(PARAMETRIZAR_CASA_DE_APUESTAS);
		btnGestionarCasasDeApuestas.setActionCommand(PARAMETRIZAR_CASA_DE_APUESTAS);
		btnGestionarCasasDeApuestas.setIcon(new ImageIcon(new ImageIcon("Recursos/Imagenes/casaDeApuestas.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnGestionarCasasDeApuestas.setFocusable(false);
		
		btnGestionarApostadores = new JButton();
		btnGestionarApostadores.setText(GESTIONAR_APOSTADORES);
		btnGestionarApostadores.setActionCommand(GESTIONAR_APOSTADORES);
		btnGestionarApostadores.setIcon(new ImageIcon(new ImageIcon("Recursos/Imagenes/apostadores.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnGestionarApostadores.setFocusable(false);
		
		btnRealizarConsultas = new JButton();
		btnRealizarConsultas.setText(REALIZAR_CONSULTAS);
		btnRealizarConsultas.setActionCommand(REALIZAR_CONSULTAS);
		btnRealizarConsultas.setIcon(new ImageIcon(new ImageIcon("Recursos/Imagenes/consultas.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnRealizarConsultas.setFocusable(false);
		
		seccionCentral.add(btnGestionarSedes);
		seccionCentral.add(new JLabel());
		seccionCentral.add(btnGestionarApuestas);
		seccionCentral.add(new JLabel());
		seccionCentral.add(btnGestionarCasasDeApuestas);
		seccionCentral.add(new JLabel());
		seccionCentral.add(btnGestionarApostadores);
		seccionCentral.add(new JLabel());
		seccionCentral.add(btnRealizarConsultas);
		
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
	 * Crear borde bajado.
	 *
	 * @return Un borde bajado
	 */
	public Border crearBordeBajado() {
		return BorderFactory.createLoweredBevelBorder();
	}
	
	/**
	 * Crear borde levantado.
	 *
	 * @return Un borde levantado
	 */
	public Border crearBordeLevantado() {
		return BorderFactory.createRaisedBevelBorder();
	}
	
	/**
	 * Obtener cursor por defecto.
	 *
	 * @return El cursor por defecto
	 */
	public Cursor obtenerCursorPorDefecto() {
		return Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
	}
	
	/**
	 * Obtener cursor activo.
	 *
	 * @return El cursor activo
	 */
	public Cursor obtenerCursorActivo() {
		return Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
	}
	
	/**
	 * Obtener botones menu principal.
	 *
	 * @return Arreglo con los botones del menu principal
	 */
	public JButton[] obtenerBotonesMenuPrincipal() {
		
		// Iterar por todos los componentes del panel sección central para obtener el número de botones
		int i = 0;
		for (Component component: seccionCentral.getComponents()) if (component instanceof JButton) i++;

		// Inicializar el arreglo botonesMenuPrincipal con el número de botones existentes
		JButton[] botonesMenuPrincipal = new JButton[i];
		i = 0;
		for (Component component: seccionCentral.getComponents()) {
			if (component instanceof JButton) {
				botonesMenuPrincipal[i] = (JButton) component;
				i++;
			}
		}
		
		return botonesMenuPrincipal;
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
	 * Gets the btn gestionar sedes.
	 *
	 * @return the btn gestionar sedes
	 */
	public JButton getBtnGestionarSedes() {
		return btnGestionarSedes;
	}

	/**
	 * Sets the btn gestionar sedes.
	 *
	 * @param btnGestionarSedes the new btn gestionar sedes
	 */
	public void setBtnGestionarSedes(JButton btnGestionarSedes) {
		this.btnGestionarSedes = btnGestionarSedes;
	}

	/**
	 * Gets the btn gestionar apuestas.
	 *
	 * @return the btn gestionar apuestas
	 */
	public JButton getBtnGestionarApuestas() {
		return btnGestionarApuestas;
	}

	/**
	 * Sets the btn gestionar apuestas.
	 *
	 * @param btnGestionarApuestas the new btn gestionar apuestas
	 */
	public void setBtnGestionarApuestas(JButton btnGestionarApuestas) {
		this.btnGestionarApuestas = btnGestionarApuestas;
	}

	/**
	 * Gets the btn gestionar casas de apuestas.
	 *
	 * @return the btn gestionar casas de apuestas
	 */
	public JButton getBtnGestionarCasasDeApuestas() {
		return btnGestionarCasasDeApuestas;
	}

	/**
	 * Sets the btn gestionar casas de apuestas.
	 *
	 * @param btnGestionarCasasDeApuestas the new btn gestionar casas de apuestas
	 */
	public void setBtnGestionarCasasDeApuestas(JButton btnGestionarCasasDeApuestas) {
		this.btnGestionarCasasDeApuestas = btnGestionarCasasDeApuestas;
	}

	/**
	 * Gets the btn gestionar apostadores.
	 *
	 * @return the btn gestionar apostadores
	 */
	public JButton getBtnGestionarApostadores() {
		return btnGestionarApostadores;
	}

	/**
	 * Sets the btn gestionar apostadores.
	 *
	 * @param btnGestionarApostadores the new btn gestionar apostadores
	 */
	public void setBtnGestionarApostadores(JButton btnGestionarApostadores) {
		this.btnGestionarApostadores = btnGestionarApostadores;
	}

	/**
	 * Gets the btn realizar consultas.
	 *
	 * @return the btn realizar consultas
	 */
	public JButton getBtnRealizarConsultas() {
		return btnRealizarConsultas;
	}

	/**
	 * Sets the btn realizar consultas.
	 *
	 * @param btnRealizarConsultas the new btn realizar consultas
	 */
	public void setBtnRealizarConsultas(JButton btnRealizarConsultas) {
		this.btnRealizarConsultas = btnRealizarConsultas;
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
