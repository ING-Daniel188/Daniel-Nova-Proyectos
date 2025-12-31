package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * The Class SedeDTO.
 */
public class SedeDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The ubicacion. */
	private String ubicacion; // Localidad
	
	/** The numero de empleados. */
	private int numeroDeEmpleados;
	
	/**
	 * Instantiates a new sede DTO.
	 *
	 * @param ubicacion Ubicacion inicial en la cual estara ubicado el apostador
	 * @param numeroDeEmpleados Numero de empleados inicial que tendra la sede
	 */
	public SedeDTO(String ubicacion, int numeroDeEmpleados) {
		super();
		this.ubicacion = ubicacion;
		this.numeroDeEmpleados = numeroDeEmpleados;
	}

	/**
	 * Gets the ubicacion.
	 *
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * Sets the ubicacion.
	 *
	 * @param ubicacion the new ubicacion
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * Gets the numero de empleados.
	 *
	 * @return the numero de empleados
	 */
	public int getNumeroDeEmpleados() {
		return numeroDeEmpleados;
	}

	/**
	 * Sets the numero de empleados.
	 *
	 * @param numeroDeEmpleados the new numero de empleados
	 */
	public void setNumeroDeEmpleados(int numeroDeEmpleados) {
		this.numeroDeEmpleados = numeroDeEmpleados;
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
