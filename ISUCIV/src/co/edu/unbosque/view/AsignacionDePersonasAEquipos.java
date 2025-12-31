package co.edu.unbosque.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class AsignacionDePersonasAEquipos.
 */
public class AsignacionDePersonasAEquipos extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6471863938735880792L;
	
	/** The formulario de personas. */
	private FormularioDePersonas formularioDePersonas;
	
	/** The tablas de personas Y escuadras. */
	private TablasDePersonasYEscuadras tablasDePersonasYEscuadras;

	/**
	 * Instantiates a new asignacion de personas A equipos.
	 */
	public AsignacionDePersonasAEquipos() {
		setLayout(new BorderLayout());

		formularioDePersonas = new FormularioDePersonas();
		add(formularioDePersonas, BorderLayout.NORTH);

		tablasDePersonasYEscuadras = new TablasDePersonasYEscuadras();
		add(tablasDePersonasYEscuadras, BorderLayout.CENTER);
	}

	/**
	 * Gets the formulario de personas.
	 *
	 * @return the formulario de personas
	 */
	public FormularioDePersonas getFormularioDePersonas() {
		return formularioDePersonas;
	}

	/**
	 * Sets the formulario de personas.
	 *
	 * @param formularioDePersonas the new formulario de personas
	 */
	public void setFormularioDePersonas(FormularioDePersonas formularioDePersonas) {
		this.formularioDePersonas = formularioDePersonas;
	}

	/**
	 * Gets the tablas de personas Y escuadras.
	 *
	 * @return the tablas de personas Y escuadras
	 */
	public TablasDePersonasYEscuadras getTablasDePersonasYEscuadras() {
		return tablasDePersonasYEscuadras;
	}

	/**
	 * Sets the tablas de personas Y escuadras.
	 *
	 * @param tablasDePersonasYEscuadras the new tablas de personas Y escuadras
	 */
	public void setTablasDePersonasYEscuadras(TablasDePersonasYEscuadras tablasDePersonasYEscuadras) {
		this.tablasDePersonasYEscuadras = tablasDePersonasYEscuadras;
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
