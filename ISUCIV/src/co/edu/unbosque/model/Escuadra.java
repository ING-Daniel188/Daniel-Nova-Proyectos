package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Escuadra.
 */
public class Escuadra implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8135251295968321774L;
	
	/** The nombre. */
	private String nombre;
	
	/** The suma tiempos acumulados. */
	private int sumaTiemposAcumulados;
	
	/** The pais de origen. */
	private String paisDeOrigen;
	
	/** The ciclistas. */
	private List<Ciclista> ciclistas;
	
	/** The masajista. */
	private Masajista masajista;
	
	/** The director deportivo. */
	private DirectorDeportivo directorDeportivo;

	/**
	 * Instantiates a new escuadra.
	 */
	public Escuadra() {

	}

	/**
	 * Instantiates a new escuadra.
	 *
	 * @param nombre the nombre
	 * @param paisDeOrigen the pais de origen
	 */
	public Escuadra(String nombre, String paisDeOrigen) {
		this.nombre = nombre;
		this.sumaTiemposAcumulados = 0;
		this.paisDeOrigen = paisDeOrigen;
		this.ciclistas = new ArrayList<>();
	}

	/**
	 * Instantiates a new escuadra.
	 *
	 * @param nombre the nombre
	 */
	public Escuadra(String nombre) {
		this.nombre = nombre;
		this.sumaTiemposAcumulados = 0;
		this.paisDeOrigen = "";
		this.ciclistas = new ArrayList<>();
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the suma tiempos acumulados.
	 *
	 * @return the suma tiempos acumulados
	 */
	public int getSumaTiemposAcumulados() {
		return sumaTiemposAcumulados;
	}

	/**
	 * Sets the suma tiempos acumulados.
	 *
	 * @param sumaTiemposAcumulados the new suma tiempos acumulados
	 */
	public void setSumaTiemposAcumulados(int sumaTiemposAcumulados) {
		this.sumaTiemposAcumulados = sumaTiemposAcumulados;
	}

	/**
	 * Gets the pais de origen.
	 *
	 * @return the pais de origen
	 */
	public String getPaisDeOrigen() {
		return paisDeOrigen;
	}

	/**
	 * Sets the pais de origen.
	 *
	 * @param paisDeOrigen the new pais de origen
	 */
	public void setPaisDeOrigen(String paisDeOrigen) {
		this.paisDeOrigen = paisDeOrigen;
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
	 * Gets the masajista.
	 *
	 * @return the masajista
	 */
	public Masajista getMasajista() {
		return masajista;
	}

	/**
	 * Sets the masajista.
	 *
	 * @param masajista the new masajista
	 */
	public void setMasajista(Masajista masajista) {
		this.masajista = masajista;
	}

	/**
	 * Gets the director deportivo.
	 *
	 * @return the director deportivo
	 */
	public DirectorDeportivo getDirectorDeportivo() {
		return directorDeportivo;
	}

	/**
	 * Sets the director deportivo.
	 *
	 * @param directorDeportivo the new director deportivo
	 */
	public void setDirectorDeportivo(DirectorDeportivo directorDeportivo) {
		this.directorDeportivo = directorDeportivo;
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
