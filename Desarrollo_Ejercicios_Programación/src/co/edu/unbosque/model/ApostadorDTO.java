package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * The Class ApostadorDTO.
 */
public class ApostadorDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The nombre completo. */
	private String nombreCompleto;
	
	/** The cedula. */
	private String cedula;
	
	/** The sede actual. */
	private String sedeActual;
	
	/** The direccion. */
	private String direccion;
	
	/** The celular. */
	private long celular;

	/**
	 * Instantiates a new apostador DTO.
	 *
	 * @param nombreCompleto Nombre completo del apostador de tipo String
	 * @param cedula Cédula del apostador de tipo String
	 * @param sedeActual Sede actual del apostador recibida como String
	 * @param direccion Direccion del apostador recibida como String
	 * @param celular Celular del apostador recibido de tipo long
	 */
	public ApostadorDTO(String nombreCompleto, String cedula, String sedeActual, String direccion, long celular) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.cedula = cedula;
		this.sedeActual = sedeActual;
		this.direccion = direccion;
		this.celular = celular;
	}

	/**
	 * Equals.
	 *
	 * @param objeto Acepta otro objeto a comparar
	 * @return true, si al comparar ambos objetos son de la misma clase y los valores de los atributos son los mismos.
	 */
	@Override
	public boolean equals(Object objeto) {

		// Revisar si este objeto al compararlo con otro son iguales
		if (this == objeto) {
			return true;
		}

		// Revisar si el objeto es nulo o si el otro objeto es de diferente clase
		if (objeto == null || getClass() != objeto.getClass()) {
			return false;
		}

		ApostadorDTO otroJugador = (ApostadorDTO) objeto;

		// Comparar atributo por atributo para ver si todos son iguales
		return this.nombreCompleto.equals(otroJugador.nombreCompleto) && this.cedula.equals(otroJugador.cedula)
				&& this.sedeActual.equals(otroJugador.sedeActual) && this.direccion.equals(otroJugador.direccion)
				&& this.celular == otroJugador.celular;
	}

	/**
	 * Gets the nombre completo.
	 *
	 * @return the nombre completo
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * Sets the nombre completo.
	 *
	 * @param nombreCompleto the new nombre completo
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * Gets the cedula.
	 *
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * Sets the cedula.
	 *
	 * @param cedula the new cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * Gets the sede actual.
	 *
	 * @return the sede actual
	 */
	public String getSedeActual() {
		return sedeActual;
	}

	/**
	 * Sets the sede actual.
	 *
	 * @param sedeActual the new sede actual
	 */
	public void setSedeActual(String sedeActual) {
		this.sedeActual = sedeActual;
	}

	/**
	 * Gets the direccion.
	 *
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Sets the direccion.
	 *
	 * @param direccion the new direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Gets the celular.
	 *
	 * @return the celular
	 */
	public long getCelular() {
		return celular;
	}

	/**
	 * Sets the celular.
	 *
	 * @param celular the new celular
	 */
	public void setCelular(long celular) {
		this.celular = celular;
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
	 * Verificar invariante.
	 * Verificar que todos los atributos del apostador sean validos
	 * cuando estos se inicializan en el constructor
	 */
	public void verificarInvariante() {
		assert this.nombreCompleto != null: "El nombre completo del apostador no puede ser nulo";
		assert this.cedula != null: "La cedula del apostador no puede ser nula";
		assert this.sedeActual != null: "La sede actual del apostador no puede ser nula";
		assert this.direccion != null: "La dirección del apostador no puede ser nula";
		assert this.celular >= 0: "El número de celular del apostador no puede ser negativo";
	}

}
