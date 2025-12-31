/*
 * 
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.model.Ciclista;

// TODO: Auto-generated Javadoc
/**
 * The Class FachadaISUCI.
 */
public class FachadaISUCI {
	
	/** The carrera DAO. */
	private CarreraDAO carreraDAO;
	
	/** The ciclista escalador DAO. */
	private CiclistaEscaladorDAO ciclistaEscaladorDAO;
	
	/** The ciclista rodador DAO. */
	private CiclistaRodadorDAO ciclistaRodadorDAO;
	
	/** The ciclista embalador DAO. */
	private CiclistaEmbaladorDAO ciclistaEmbaladorDAO;
	
	/** The ciclista gregario DAO. */
	private CiclistaGregarioDAO ciclistaGregarioDAO;
	
	/** The ciclista clasicomano DAO. */
	private CiclistaClasicomanoDAO ciclistaClasicomanoDAO;
	
	/** The ciclista contrarrelojista DAO. */
	private CiclistaContrarrelojistaDAO ciclistaContrarrelojistaDAO;
	
	/** The director deportivo DAO. */
	private DirectorDeportivoDAO directorDeportivoDAO;
	
	/** The escuadra DAO. */
	private EscuadraDAO escuadraDAO;
	
	/** The masajista DAO. */
	private MasajistaDAO masajistaDAO;
	
	/** The usuario DAO. */
	private UsuarioDAO usuarioDAO;

	/**
	 * Instantiates a new fachada ISUCI.
	 */
	public FachadaISUCI() {
		carreraDAO = new CarreraDAO();
		ciclistaEscaladorDAO = new CiclistaEscaladorDAO();
		ciclistaRodadorDAO = new CiclistaRodadorDAO();
		ciclistaEmbaladorDAO = new CiclistaEmbaladorDAO();
		ciclistaGregarioDAO = new CiclistaGregarioDAO();
		ciclistaClasicomanoDAO = new CiclistaClasicomanoDAO();
		ciclistaContrarrelojistaDAO = new CiclistaContrarrelojistaDAO();
		directorDeportivoDAO = new DirectorDeportivoDAO();
		escuadraDAO = new EscuadraDAO();
		masajistaDAO = new MasajistaDAO();
		usuarioDAO = new UsuarioDAO();
	}

	/**
	 * Obtener ciclista por numero de documento.
	 *
	 * @param numeroDeDocumento the numero de documento
	 * @return the ciclista
	 */
	public Ciclista obtenerCiclistaPorNumeroDeDocumento(String numeroDeDocumento) {
		List<Ciclista> ciclistas = obtenerTodosLosCiclistas();
		for (Ciclista ciclista : ciclistas) {
			if (ciclista.getNumeroDeDocumento().equals(numeroDeDocumento)) {
				return ciclista;
			}
		}
		return null;
	}

	/**
	 * Obtener todos los ciclistas.
	 *
	 * @return the list
	 */
	public List<Ciclista> obtenerTodosLosCiclistas() {
		List<Ciclista> ciclistas = new ArrayList<>();
		ciclistas.addAll(ciclistaEscaladorDAO.obtener());
		ciclistas.addAll(ciclistaRodadorDAO.obtener());
		ciclistas.addAll(ciclistaEmbaladorDAO.obtener());
		ciclistas.addAll(ciclistaGregarioDAO.obtener());
		ciclistas.addAll(ciclistaClasicomanoDAO.obtener());
		ciclistas.addAll(ciclistaContrarrelojistaDAO.obtener());
		return ciclistas;
	}

	/**
	 * Gets the carrera DAO.
	 *
	 * @return the carrera DAO
	 */
	public CarreraDAO getCarreraDAO() {
		return carreraDAO;
	}

	/**
	 * Sets the carrera DAO.
	 *
	 * @param carreraDAO the new carrera DAO
	 */
	public void setCarreraDAO(CarreraDAO carreraDAO) {
		this.carreraDAO = carreraDAO;
	}

	/**
	 * Gets the ciclista escalador DAO.
	 *
	 * @return the ciclista escalador DAO
	 */
	public CiclistaEscaladorDAO getCiclistaEscaladorDAO() {
		return ciclistaEscaladorDAO;
	}

	/**
	 * Sets the ciclista escalador DAO.
	 *
	 * @param ciclistaEscaladorDAO the new ciclista escalador DAO
	 */
	public void setCiclistaEscaladorDAO(CiclistaEscaladorDAO ciclistaEscaladorDAO) {
		this.ciclistaEscaladorDAO = ciclistaEscaladorDAO;
	}

	/**
	 * Gets the ciclista rodador DAO.
	 *
	 * @return the ciclista rodador DAO
	 */
	public CiclistaRodadorDAO getCiclistaRodadorDAO() {
		return ciclistaRodadorDAO;
	}

	/**
	 * Sets the ciclista rodador DAO.
	 *
	 * @param ciclistaRodadorDAO the new ciclista rodador DAO
	 */
	public void setCiclistaRodadorDAO(CiclistaRodadorDAO ciclistaRodadorDAO) {
		this.ciclistaRodadorDAO = ciclistaRodadorDAO;
	}

	/**
	 * Gets the ciclista embalador DAO.
	 *
	 * @return the ciclista embalador DAO
	 */
	public CiclistaEmbaladorDAO getCiclistaEmbaladorDAO() {
		return ciclistaEmbaladorDAO;
	}

	/**
	 * Sets the ciclista embalador DAO.
	 *
	 * @param ciclistaEmbaladorDAO the new ciclista embalador DAO
	 */
	public void setCiclistaEmbaladorDAO(CiclistaEmbaladorDAO ciclistaEmbaladorDAO) {
		this.ciclistaEmbaladorDAO = ciclistaEmbaladorDAO;
	}

	/**
	 * Gets the ciclista gregario DAO.
	 *
	 * @return the ciclista gregario DAO
	 */
	public CiclistaGregarioDAO getCiclistaGregarioDAO() {
		return ciclistaGregarioDAO;
	}

	/**
	 * Sets the ciclista gregario DAO.
	 *
	 * @param ciclistaGregarioDAO the new ciclista gregario DAO
	 */
	public void setCiclistaGregarioDAO(CiclistaGregarioDAO ciclistaGregarioDAO) {
		this.ciclistaGregarioDAO = ciclistaGregarioDAO;
	}

	/**
	 * Gets the ciclista clasicomano DAO.
	 *
	 * @return the ciclista clasicomano DAO
	 */
	public CiclistaClasicomanoDAO getCiclistaClasicomanoDAO() {
		return ciclistaClasicomanoDAO;
	}

	/**
	 * Sets the ciclista clasicomano DAO.
	 *
	 * @param ciclistaClasicomanoDAO the new ciclista clasicomano DAO
	 */
	public void setCiclistaClasicomanoDAO(CiclistaClasicomanoDAO ciclistaClasicomanoDAO) {
		this.ciclistaClasicomanoDAO = ciclistaClasicomanoDAO;
	}

	/**
	 * Gets the ciclista contrarrelojista DAO.
	 *
	 * @return the ciclista contrarrelojista DAO
	 */
	public CiclistaContrarrelojistaDAO getCiclistaContrarrelojistaDAO() {
		return ciclistaContrarrelojistaDAO;
	}

	/**
	 * Sets the ciclista contrarrelojista DAO.
	 *
	 * @param ciclistaContrarrelojistaDAO the new ciclista contrarrelojista DAO
	 */
	public void setCiclistaContrarrelojistaDAO(CiclistaContrarrelojistaDAO ciclistaContrarrelojistaDAO) {
		this.ciclistaContrarrelojistaDAO = ciclistaContrarrelojistaDAO;
	}

	/**
	 * Gets the director deportivo DAO.
	 *
	 * @return the director deportivo DAO
	 */
	public DirectorDeportivoDAO getDirectorDeportivoDAO() {
		return directorDeportivoDAO;
	}

	/**
	 * Sets the director deportivo DAO.
	 *
	 * @param directorDeportivoDAO the new director deportivo DAO
	 */
	public void setDirectorDeportivoDAO(DirectorDeportivoDAO directorDeportivoDAO) {
		this.directorDeportivoDAO = directorDeportivoDAO;
	}

	/**
	 * Gets the escuadra DAO.
	 *
	 * @return the escuadra DAO
	 */
	public EscuadraDAO getEscuadraDAO() {
		return escuadraDAO;
	}

	/**
	 * Sets the escuadra DAO.
	 *
	 * @param escuadraDAO the new escuadra DAO
	 */
	public void setEscuadraDAO(EscuadraDAO escuadraDAO) {
		this.escuadraDAO = escuadraDAO;
	}

	/**
	 * Gets the masajista DAO.
	 *
	 * @return the masajista DAO
	 */
	public MasajistaDAO getMasajistaDAO() {
		return masajistaDAO;
	}

	/**
	 * Sets the masajista DAO.
	 *
	 * @param masajistaDAO the new masajista DAO
	 */
	public void setMasajistaDAO(MasajistaDAO masajistaDAO) {
		this.masajistaDAO = masajistaDAO;
	}

	/**
	 * Gets the usuario DAO.
	 *
	 * @return the usuario DAO
	 */
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	/**
	 * Sets the usuario DAO.
	 *
	 * @param usuarioDAO the new usuario DAO
	 */
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
