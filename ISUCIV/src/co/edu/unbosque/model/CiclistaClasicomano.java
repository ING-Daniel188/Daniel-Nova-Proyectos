package co.edu.unbosque.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class CiclistaClasicomano.
 */
public class CiclistaClasicomano extends Ciclista implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6336597168579395786L;
	
	/** The numero clasicos ganados. */
	private int numeroClasicosGanados;

	/**
	 * Instantiates a new ciclista clasicomano.
	 */
	public CiclistaClasicomano() {
		this.tipo = "Clasicomano";
	}

	/**
	 * Instantiates a new ciclista clasicomano.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @param nombre the nombre
	 * @param conEspecialidad the con especialidad
	 * @param cadencia the cadencia
	 * @param numeroClasicosGanados the numero clasicos ganados
	 */
	public CiclistaClasicomano(String numeroDeDocumento, String nombre, boolean conEspecialidad, float cadencia,
			int numeroClasicosGanados) {
		super(numeroDeDocumento, nombre, "Media - Poca envergadura",
				conEspecialidad ? "Competiciones de un solo día - Terrenos montañosos" : "", cadencia);
		this.numeroClasicosGanados = numeroClasicosGanados;
		this.tipo = "Clasicomano";
	}

	/**
	 * Gets the numero clasicos ganados.
	 *
	 * @return the numero clasicos ganados
	 */
	public int getNumeroClasicosGanados() {
		return numeroClasicosGanados;
	}

	/**
	 * Sets the numero clasicos ganados.
	 *
	 * @param numeroClasicosGanados the new numero clasicos ganados
	 */
	public void setNumeroClasicosGanados(int numeroClasicosGanados) {
		this.numeroClasicosGanados = numeroClasicosGanados;
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
