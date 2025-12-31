package co.edu.unbosque.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class CiclistaRodador.
 */
public class CiclistaRodador extends Ciclista implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4573455344104187539L;

	/**
	 * Instantiates a new ciclista rodador.
	 */
	public CiclistaRodador() {
		this.tipo = "Rodador";
	}

	/**
	 * Instantiates a new ciclista rodador.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @param nombre the nombre
	 * @param conEspecialidad the con especialidad
	 * @param cadencia the cadencia
	 */
	public CiclistaRodador(String numeroDeDocumento, String nombre, boolean conEspecialidad, float cadencia) {
		super(numeroDeDocumento, nombre, "Pesado - Alta envergadura",
				conEspecialidad ? "Rodar a altas velocidades en terrenos llanos con curvas" : "", cadencia);
		this.tipo = "Rodador";
	}

}
