package co.edu.unbosque.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class CiclistaEmbalador.
 */
public class CiclistaEmbalador extends Ciclista implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1485969813586559002L;
	
	/** The potencia promedio. */
	private float potenciaPromedio;
	
	/** The velocidad promedio en sprint. */
	private float velocidadPromedioEnSprint;

	/**
	 * Instantiates a new ciclista embalador.
	 */
	public CiclistaEmbalador() {
		this.tipo = "Embalador";
	}

	/**
	 * Instantiates a new ciclista embalador.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @param nombre the nombre
	 * @param conEspecialidad the con especialidad
	 * @param cadencia the cadencia
	 * @param potenciaPromedio the potencia promedio
	 * @param velocidadPromedioEnSprint the velocidad promedio en sprint
	 */
	public CiclistaEmbalador(String numeroDeDocumento, String nombre, boolean conEspecialidad, float cadencia,
			float potenciaPromedio, float velocidadPromedioEnSprint) {
		super(numeroDeDocumento, nombre, "Corpulentos - Muy musculados",
				conEspecialidad ? "Etapas Semillanas - Esfuerzos muy intensos en periodos cortos de tiempo" : "",
				cadencia);
		this.potenciaPromedio = potenciaPromedio;
		this.velocidadPromedioEnSprint = velocidadPromedioEnSprint;
		this.tipo = "Embalador";
	}

	/**
	 * Gets the potencia promedio.
	 *
	 * @return the potencia promedio
	 */
	public float getPotenciaPromedio() {
		return potenciaPromedio;
	}

	/**
	 * Sets the potencia promedio.
	 *
	 * @param potenciaPromedio the new potencia promedio
	 */
	public void setPotenciaPromedio(float potenciaPromedio) {
		this.potenciaPromedio = potenciaPromedio;
	}

	/**
	 * Gets the velocidad promedio en sprint.
	 *
	 * @return the velocidad promedio en sprint
	 */
	public float getVelocidadPromedioEnSprint() {
		return velocidadPromedioEnSprint;
	}

	/**
	 * Sets the velocidad promedio en sprint.
	 *
	 * @param velocidadPromedioEnSprint the new velocidad promedio en sprint
	 */
	public void setVelocidadPromedioEnSprint(float velocidadPromedioEnSprint) {
		this.velocidadPromedioEnSprint = velocidadPromedioEnSprint;
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
