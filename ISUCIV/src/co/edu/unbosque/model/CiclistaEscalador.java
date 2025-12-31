package co.edu.unbosque.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class CiclistaEscalador.
 */
public class CiclistaEscalador extends Ciclista implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4565510020368604493L;
	
	/** The aceleracion promedio. */
	private float aceleracionPromedio;
	
	/** The grado rampa soportada. */
	private float gradoRampaSoportada;

	/**
	 * Instantiates a new ciclista escalador.
	 */
	public CiclistaEscalador() {
		this.tipo = "Escalador";
	}

	/**
	 * Instantiates a new ciclista escalador.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @param nombre the nombre
	 * @param conEspecialidad the con especialidad
	 * @param cadencia the cadencia
	 * @param aceleracionPromedio the aceleracion promedio
	 * @param gradoRampaSoportada the grado rampa soportada
	 */
	public CiclistaEscalador(String numeroDeDocumento, String nombre, boolean conEspecialidad, float cadencia,
			float aceleracionPromedio, float gradoRampaSoportada) {
		super(numeroDeDocumento, nombre, "Muy delgada -> Poca envergadura",
				conEspecialidad ? "Bajo peso -> Relación peso-potencia" : "", cadencia);
		this.tipo = "Escalador";
		this.aceleracionPromedio = aceleracionPromedio;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	/**
	 * Gets the aceleracion promedio.
	 *
	 * @return the aceleracion promedio
	 */
	public float getAceleracionPromedio() {
		return aceleracionPromedio;
	}

	/**
	 * Sets the aceleracion promedio.
	 *
	 * @param aceleracionPromedio the new aceleracion promedio
	 */
	public void setAceleracionPromedio(float aceleracionPromedio) {
		this.aceleracionPromedio = aceleracionPromedio;
	}

	/**
	 * Gets the grado rampa soportada.
	 *
	 * @return the grado rampa soportada
	 */
	public float getGradoRampaSoportada() {
		return gradoRampaSoportada;
	}

	/**
	 * Sets the grado rampa soportada.
	 *
	 * @param gradoRampaSoportada the new grado rampa soportada
	 */
	public void setGradoRampaSoportada(float gradoRampaSoportada) {
		this.gradoRampaSoportada = gradoRampaSoportada;
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
