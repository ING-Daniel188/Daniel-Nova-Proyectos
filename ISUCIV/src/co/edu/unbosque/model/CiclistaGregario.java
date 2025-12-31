package co.edu.unbosque.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class CiclistaGregario.
 */
public class CiclistaGregario extends Ciclista implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3606076909349378441L;
	
	/** The funcion en peloton. */
	private String funcionEnPeloton;

	/**
	 * Instantiates a new ciclista gregario.
	 */
	public CiclistaGregario() {
		this.tipo = "Gregario";
	}

	/**
	 * Instantiates a new ciclista gregario.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @param nombre the nombre
	 * @param conEspecialidad the con especialidad
	 * @param cadencia the cadencia
	 * @param funcionEnPeloton the funcion en peloton
	 */
	public CiclistaGregario(String numeroDeDocumento, String nombre, boolean conEspecialidad, float cadencia,
			String funcionEnPeloton) {
		super(numeroDeDocumento, nombre, "Media", conEspecialidad ? "Etapas de ruta" : "", cadencia);
		this.funcionEnPeloton = funcionEnPeloton;
		this.tipo = "Gregario";
	}

	/**
	 * Gets the funcion en peloton.
	 *
	 * @return the funcion en peloton
	 */
	public String getFuncionEnPeloton() {
		return funcionEnPeloton;
	}

	/**
	 * Sets the funcion en peloton.
	 *
	 * @param funcionEnPeloton the new funcion en peloton
	 */
	public void setFuncionEnPeloton(String funcionEnPeloton) {
		this.funcionEnPeloton = funcionEnPeloton;
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
