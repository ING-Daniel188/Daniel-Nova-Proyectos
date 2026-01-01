package co.edu.unbosque.view;

import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * The Class PanelCreacionFrutaDulce.
 */
public class PanelCreacionFrutaDulce extends PanelCreacionProducto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The label intensidad. */
	private JLabel labelIntensidad;
	
	/** The seleccionable intensidad. */
	private JComboBox<String> seleccionableIntensidad;
	
	/** The label es organica. */
	private JLabel labelEsOrganica;
	
	/** The seleccionable es organica. */
	private JComboBox<String> seleccionableEsOrganica;

	/**
	 * Instantiates a new panel creacion fruta dulce.
	 */
	public PanelCreacionFrutaDulce() {
		getLabelTitulo().setText("Crear Fruta Dulce");
		getLabelTitulo().setBounds(super.getLabelTitulo().getX() - 20, super.getLabelTitulo().getY(),
				super.getLabelTitulo().getWidth() + 10, super.getLabelTitulo().getHeight());

		labelIntensidad = new JLabel("Intensidad del Dulce");
		labelIntensidad.setFont(super.getFuentePlana());
		labelIntensidad.setBounds(30, 360, 280, 50);
		add(labelIntensidad);

		seleccionableIntensidad = new JComboBox<String>();
		seleccionableIntensidad.addItem("Seleccionar");
		seleccionableIntensidad.addItem("Bajo");
		seleccionableIntensidad.addItem("Medio");
		seleccionableIntensidad.addItem("Alto");
		seleccionableIntensidad.setFont(super.getFuentePlanaMediana());
		seleccionableIntensidad.setMaximumRowCount(4);
		seleccionableIntensidad.setBounds(330, 360, 215, 50);
		add(seleccionableIntensidad);
		
		labelEsOrganica = new JLabel("Es Orgánica");
		labelEsOrganica.setFont(super.getFuentePlana());
		labelEsOrganica.setBounds(30, 440, 200, 50);
		add(labelEsOrganica);

		seleccionableEsOrganica = new JComboBox<String>();
		seleccionableEsOrganica.addItem("Seleccionar");
		seleccionableEsOrganica.addItem("Si");
		seleccionableEsOrganica.addItem("No");
		seleccionableEsOrganica.setFont(super.getFuentePlanaMediana());
		seleccionableEsOrganica.setMaximumRowCount(4);
		seleccionableEsOrganica.setBounds(250, 440, 295, 50);
		add(seleccionableEsOrganica);
	}
	
	/**
	 * Reiniciar entradas.
	 */
	public void reiniciarEntradas() {
		super.reiniciarEntradas();
		seleccionableIntensidad.setSelectedIndex(0);
		seleccionableEsOrganica.setSelectedIndex(0);
	}
	
	/**
	 * Validar entradas.
	 *
	 * @return true, if successful
	 */
	public boolean validarEntradas() {
		if (!super.validarEntradas()) {
			return false;
		}
		
		if (seleccionableIntensidad.getSelectedIndex() == 0) {
			super.mostrarMensajeError("La intensidad de la fruta dulce no ha sido seleccionada");
			return false;
		}
		
		if (seleccionableEsOrganica.getSelectedIndex() == 0) {
			super.mostrarMensajeError("No se ha seleccionado si la fruta dulce es orgánica o no");
			return false;
		}
		return true;
	}

	/**
	 * Gets the seleccionable intensidad.
	 *
	 * @return the seleccionable intensidad
	 */
	public JComboBox<String> getSeleccionableIntensidad() {
		return seleccionableIntensidad;
	}

	/**
	 * Gets the seleccionable es organica.
	 *
	 * @return the seleccionable es organica
	 */
	public JComboBox<String> getSeleccionableEsOrganica() {
		return seleccionableEsOrganica;
	}

}
