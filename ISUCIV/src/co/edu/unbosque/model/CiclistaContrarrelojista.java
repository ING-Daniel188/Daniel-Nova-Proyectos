package co.edu.unbosque.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class CiclistaContrarrelojista.
 */
public class CiclistaContrarrelojista extends Ciclista implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5649620261751095954L;
	
	/** The velocidad maxima. */
	private float velocidadMaxima;

	/**
	 * Instantiates a new ciclista contrarrelojista.
	 */
	public CiclistaContrarrelojista() {
		this.tipo = "Contrarrelojista";
	}

	/**
	 * Instantiates a new ciclista contrarrelojista.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @param nombre the nombre
	 * @param conEspecialidad the con especialidad
	 * @param cadencia the cadencia
	 * @param velocidadMaxima the velocidad maxima
	 */
	public CiclistaContrarrelojista(String numeroDeDocumento, String nombre, boolean conEspecialidad, float cadencia,
			float velocidadMaxima) {
		super(numeroDeDocumento, nombre, "Delgada", conEspecialidad ? "Etapas llanas rectas" : "", cadencia);
		this.tipo = "Contrarrelojista";
	}

	/**
	 * Gets the velocidad maxima.
	 *
	 * @return the velocidad maxima
	 */
	public float getVelocidadMaxima() {
		return velocidadMaxima;
	}

	/**
	 * Sets the velocidad maxima.
	 *
	 * @param velocidadMaxima the new velocidad maxima
	 */
	public void setVelocidadMaxima(float velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
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
