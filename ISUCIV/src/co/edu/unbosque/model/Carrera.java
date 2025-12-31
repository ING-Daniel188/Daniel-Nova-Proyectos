package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Carrera.
 */
public class Carrera implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8908324463190473534L;
	
	/** The tipo de etapa. */
	private String tipoDeEtapa;
	
	/** The ciclistas. */
	private List<Ciclista> ciclistas;

	/**
	 * Instantiates a new carrera.
	 */
	public Carrera() {
		this.ciclistas = new ArrayList<>();
	}

	/**
	 * Instantiates a new carrera.
	 *
	 * @param tipoDeEtapa the tipo de etapa
	 * @param ciclistas the ciclistas
	 */
	public Carrera(String tipoDeEtapa, List<Ciclista> ciclistas) {
		this.tipoDeEtapa = tipoDeEtapa;
		this.ciclistas = ciclistas;
	}

	/**
	 * Gets the tipo de etapa.
	 *
	 * @return the tipo de etapa
	 */
	public String getTipoDeEtapa() {
		return tipoDeEtapa;
	}

	/**
	 * Sets the tipo de etapa.
	 *
	 * @param tipoDeEtapa the new tipo de etapa
	 */
	public void setTipoDeEtapa(String tipoDeEtapa) {
		this.tipoDeEtapa = tipoDeEtapa;
	}

	/**
	 * Gets the ciclistas.
	 *
	 * @return the ciclistas
	 */
	public List<Ciclista> getCiclistas() {
		return ciclistas;
	}

	/**
	 * Sets the ciclistas.
	 *
	 * @param ciclistas the new ciclistas
	 */
	public void setCiclistas(List<Ciclista> ciclistas) {
		this.ciclistas = ciclistas;
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
