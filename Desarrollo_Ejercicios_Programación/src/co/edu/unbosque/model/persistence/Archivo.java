package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;

import co.edu.unbosque.model.ApostadorDTO;
import co.edu.unbosque.model.BalotoDTO;
import co.edu.unbosque.model.BetPlayDTO;
import co.edu.unbosque.model.ChanceDTO;
import co.edu.unbosque.model.JuegoDTO;
import co.edu.unbosque.model.LoteriaDTO;
import co.edu.unbosque.model.SedeDTO;
import co.edu.unbosque.model.SuperAstroDTO;

/**
 * The Class Archivo.
 */
public class Archivo {
	
	/** The ruta sedes. */
	private String rutaSedes = "./Data/sedes.dat";
	
	/** The ruta apostadores. */
	private String rutaApostadores = "./Data/apostadores.dat";
	
	/** The ruta juegos. */
	private String rutaJuegos = "./Data/juegos.dat";
	
	/** The ruta apuestas loteria. */
	private String rutaApuestasLoteria = "./Data/apuestas-loteria.dat";
	
	/** The ruta apuestas super astro. */
	private String rutaApuestasSuperAstro = "./Data/apuestas-superastro.dat";
	
	/** The ruta apuestas baloto. */
	private String rutaApuestasBaloto = "./Data/apuestas-baloto.dat";
	
	/** The ruta apuestas bet play. */
	private String rutaApuestasBetPlay = "./Data/apuestas-betplay.dat";
	
	/** The ruta apuestas chance. */
	private String rutaApuestasChance = "./Data/apuestas-chance.dat";
	
	/** The ois. */
	private ObjectInputStream ois;
	
	/** The oos. */
	private ObjectOutputStream oos;
	
	/** The ruta partidos. */
	private String rutaPartidos = "./Data/equipos.txt";
	
	/** The fr. */
	private FileReader fr;
	
	/** The br. */
	private BufferedReader br;
	
	///////////////////////////////////////// SEDES /////////////////////////////////////////
	
	/**
	 * Registrar sedes.
	 *
	 * @param sedes the sedes
	 * @return Entero que indica si el registro fue exitoso o no
	 */
	public int registrarSedes(ArrayList<SedeDTO> sedes) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(rutaSedes));
			oos.writeObject(sedes);
			oos.close();
		} catch (IOException e) { return -1; }
		
		return 0;
	}
	
	/**
	 * Obtener sedes.
	 *
	 * @return ArrayList con las sedes obtenidas del archivo binario
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<SedeDTO> obtenerSedes() {
		
		ArrayList<SedeDTO> sedes = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(rutaSedes));
			sedes = (ArrayList<SedeDTO>)ois.readObject();
			ois.close();
		} catch (ClassNotFoundException | IOException e) { return null; }
		
		return sedes;
	}
	
	///////////////////////////////////////// APOSTADORES /////////////////////////////////////////
	
	/**
	 * Registrar apostadores.
	 *
	 * @param apostadores the apostadores
	 * @return Entero que indica si el registro fue exitoso o no
	 */
	public int registrarApostadores(ArrayList<ApostadorDTO> apostadores) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(rutaApostadores));
			oos.writeObject(apostadores);
			oos.close();
		} catch (IOException e) { return -1; }
		
		return 0;
	}
	
	/**
	 * Obtener apostadores.
	 *
	 * @return ArrayList con los apostadores obtenidos del archivo binario
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<ApostadorDTO> obtenerApostadores() {
		
		ArrayList<ApostadorDTO> apostadores = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(rutaApostadores));
			apostadores = (ArrayList<ApostadorDTO>)ois.readObject();
			ois.close();
		} catch (ClassNotFoundException | IOException e) { return null; }
		
		return apostadores;
	}
	
	///////////////////////////////////////// JUEGOS /////////////////////////////////////////
	
	/**
	 * Registrar juegos.
	 *
	 * @param juegos the juegos
	 * @return Entero que indica si el registro fue exitoso o no
	 */
	public int registrarJuegos(ArrayList<JuegoDTO> juegos) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(rutaJuegos));
			oos.writeObject(juegos);
			oos.close();
		} catch (IOException e) { return -1; }
		
		return 0;
	}
	
	/**
	 * Obtener juegos.
	 *
	 * @return ArrayList con los juegos obtenidos del archivo binario
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<JuegoDTO> obtenerJuegos() {
		
		ArrayList<JuegoDTO> juegos = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(rutaJuegos));
			juegos = (ArrayList<JuegoDTO>)ois.readObject();
			ois.close();
		} catch (ClassNotFoundException | IOException e) { return null; }
		
		return juegos;
	}
	
	///////////////////////////////////////// APUESTAS /////////////////////////////////////////
	
	///////////////////////////////////////// APUESTAS -> LOTERIA /////////////////////////////////////////
	
	/**
	 * Registrar apuestas loteria.
	 *
	 * @param apuestasLoteria the apuestas loteria
	 * @return Entero que indica si el registro fue exitoso o no
	 */
	public int registrarApuestasLoteria(ArrayList<LoteriaDTO> apuestasLoteria) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(rutaApuestasLoteria));
			oos.writeObject(apuestasLoteria);
			oos.close();
		} catch (IOException e) { return -1; }
		
		return 0;
	}
	
	/**
	 * Obtener apuestas loteria.
	 *
	 * @return ArrayList con las apuestas de loteria obtenidas del archivo binario
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<LoteriaDTO> obtenerApuestasLoteria() {
		
		ArrayList<LoteriaDTO> apuestasLoteria = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(rutaApuestasLoteria));
			apuestasLoteria = (ArrayList<LoteriaDTO>)ois.readObject();
			ois.close();
		} catch (ClassNotFoundException | IOException e) { return null; }
		
		return apuestasLoteria;
	}
	
	///////////////////////////////////////// APUESTAS -> SUPERASTRO /////////////////////////////////////////
	
	/**
	 * Registrar apuestas super astro.
	 *
	 * @param apuestasSuperAstro the apuestas super astro
	 * @return Entero que indica si el registro fue exitoso o no
	 */
	public int registrarApuestasSuperAstro(ArrayList<SuperAstroDTO> apuestasSuperAstro) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(rutaApuestasSuperAstro));
			oos.writeObject(apuestasSuperAstro);
			oos.close();
		} catch (IOException e) { return -1; }
		
		return 0;
	}
	
	/**
	 * Obtener apuestas super astro.
	 *
	 * @return ArrayList con las apuestas de superastro obtenidas del archivo binario
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<SuperAstroDTO> obtenerApuestasSuperAstro() {
		
		ArrayList<SuperAstroDTO> apuestasSuperAstro = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(rutaApuestasSuperAstro));
			apuestasSuperAstro = (ArrayList<SuperAstroDTO>)ois.readObject();
			ois.close();
		} catch (ClassNotFoundException | IOException e) { return null; }
		
		return apuestasSuperAstro;
	}
	
	///////////////////////////////////////// APUESTAS -> BALOTO /////////////////////////////////////////
	
	/**
	 * Registrar apuestas baloto.
	 *
	 * @param apuestasBaloto the apuestas baloto
	 * @return Entero que indica si el registro fue exitoso o no
	 */
	public int registrarApuestasBaloto(ArrayList<BalotoDTO> apuestasBaloto) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(rutaApuestasBaloto));
			oos.writeObject(apuestasBaloto);
			oos.close();
		} catch (IOException e) { return -1; }
		
		return 0;
	}
	
	/**
	 * Obtener apuestas baloto.
	 *
	 * @return ArrayList con las apuestas de baloto obtenidas del archivo binario
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<BalotoDTO> obtenerApuestasBaloto() {
		
		ArrayList<BalotoDTO> apuestasBaloto = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(rutaApuestasBaloto));
			apuestasBaloto = (ArrayList<BalotoDTO>)ois.readObject();
			ois.close();
		} catch (ClassNotFoundException | IOException e) { return null; }
		
		return apuestasBaloto;
	}
	
	///////////////////////////////////////// APUESTAS -> CHANCE /////////////////////////////////////////
	
	/**
	 * Registrar apuestas chance.
	 *
	 * @param apuestasChance the apuestas chance
	 * @return Entero que indica si el registro fue exitoso o no
	 */
	public int registrarApuestasChance(ArrayList<ChanceDTO> apuestasChance) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(rutaApuestasChance));
			oos.writeObject(apuestasChance);
			oos.close();
		} catch (IOException e) { return -1; }
		
		return 0;
	}
	
	/**
	 * Obtener apuestas chance.
	 *
	 * @return the array list
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<ChanceDTO> obtenerApuestasChance() {
		
		ArrayList<ChanceDTO> apuestasChance = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(rutaApuestasChance));
			apuestasChance = (ArrayList<ChanceDTO>)ois.readObject();
			ois.close();
		} catch (ClassNotFoundException | IOException e) { return null; }
		
		return apuestasChance;
	}
	
	///////////////////////////////////////// APUESTAS -> BETPLAY /////////////////////////////////////////
	
	/**
	 * Registrar apuestas bet play.
	 *
	 * @param apuestasBetPlay the apuestas bet play
	 * @return Entero que indica si el registro fue exitoso o no
	 */
	public int registrarApuestasBetPlay(ArrayList<BetPlayDTO> apuestasBetPlay) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(rutaApuestasBetPlay));
			oos.writeObject(apuestasBetPlay);
			oos.close();
		} catch (IOException e) { return -1; }
		
		return 0;
	}
	
	/**
	 * Obtener apuestas bet play.
	 *
	 * @return ArrayList con las apuestas de betplay obtenidas del archivo binario
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<BetPlayDTO> obtenerApuestasBetPlay() {
		
		ArrayList<BetPlayDTO> apuestasBetPlay = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(rutaApuestasBetPlay));
			apuestasBetPlay = (ArrayList<BetPlayDTO>)ois.readObject();
			ois.close();
		} catch (ClassNotFoundException | IOException e) { return null; }
		
		return apuestasBetPlay;
	}
	
	
	/**
	 * Leer equipos.
	 *
	 * @return Arreglo con todos los equipos extraidos del archivo
	 */
	public String[] leerEquipos() {
		String[] equipos = null;
		
		String linea = "";
		try {
			fr = new FileReader(new File(rutaPartidos));
			br = new BufferedReader(fr);
			
			
			// Contar el número de partidos del archivo equipos.txt
			int numeroDePartidos = 0;
			linea = br.readLine();
			while (linea != null) {
				linea = br.readLine();
				numeroDePartidos++;
			}
			
			// Inicializar el arreglo de equipos con el número de equipos
			equipos = new String[numeroDePartidos];
			
			fr.close();
			
			
			// Agregar los partidos al arreglo de partidos
			fr = new FileReader(new File(rutaPartidos));
			br = new BufferedReader(fr);
			
			int i = 0;
			linea = br.readLine();
			while (linea != null) {
				equipos[i] = linea;
				linea = br.readLine();
				i++;
			}
	
			fr.close();
		} catch (IOException e) { return null; }
		
		return equipos;
	}


	/**
	 * Gets the ruta sedes.
	 *
	 * @return the ruta sedes
	 */
	public String getRutaSedes() {
		return rutaSedes;
	}

	/**
	 * Sets the ruta sedes.
	 *
	 * @param rutaSedes the new ruta sedes
	 */
	public void setRutaSedes(String rutaSedes) {
		this.rutaSedes = rutaSedes;
	}

	/**
	 * Gets the ruta apostadores.
	 *
	 * @return the ruta apostadores
	 */
	public String getRutaApostadores() {
		return rutaApostadores;
	}

	/**
	 * Sets the ruta apostadores.
	 *
	 * @param rutaApostadores the new ruta apostadores
	 */
	public void setRutaApostadores(String rutaApostadores) {
		this.rutaApostadores = rutaApostadores;
	}

	/**
	 * Gets the ruta juegos.
	 *
	 * @return the ruta juegos
	 */
	public String getRutaJuegos() {
		return rutaJuegos;
	}

	/**
	 * Sets the ruta juegos.
	 *
	 * @param rutaJuegos the new ruta juegos
	 */
	public void setRutaJuegos(String rutaJuegos) {
		this.rutaJuegos = rutaJuegos;
	}

	/**
	 * Gets the ruta apuestas loteria.
	 *
	 * @return the ruta apuestas loteria
	 */
	public String getRutaApuestasLoteria() {
		return rutaApuestasLoteria;
	}

	/**
	 * Sets the ruta apuestas loteria.
	 *
	 * @param rutaApuestasLoteria the new ruta apuestas loteria
	 */
	public void setRutaApuestasLoteria(String rutaApuestasLoteria) {
		this.rutaApuestasLoteria = rutaApuestasLoteria;
	}

	/**
	 * Gets the ruta apuestas super astro.
	 *
	 * @return the ruta apuestas super astro
	 */
	public String getRutaApuestasSuperAstro() {
		return rutaApuestasSuperAstro;
	}

	/**
	 * Sets the ruta apuestas super astro.
	 *
	 * @param rutaApuestasSuperAstro the new ruta apuestas super astro
	 */
	public void setRutaApuestasSuperAstro(String rutaApuestasSuperAstro) {
		this.rutaApuestasSuperAstro = rutaApuestasSuperAstro;
	}

	/**
	 * Gets the ruta apuestas baloto.
	 *
	 * @return the ruta apuestas baloto
	 */
	public String getRutaApuestasBaloto() {
		return rutaApuestasBaloto;
	}

	/**
	 * Sets the ruta apuestas baloto.
	 *
	 * @param rutaApuestasBaloto the new ruta apuestas baloto
	 */
	public void setRutaApuestasBaloto(String rutaApuestasBaloto) {
		this.rutaApuestasBaloto = rutaApuestasBaloto;
	}

	/**
	 * Gets the ruta apuestas bet play.
	 *
	 * @return the ruta apuestas bet play
	 */
	public String getRutaApuestasBetPlay() {
		return rutaApuestasBetPlay;
	}

	/**
	 * Sets the ruta apuestas bet play.
	 *
	 * @param rutaApuestasBetPlay the new ruta apuestas bet play
	 */
	public void setRutaApuestasBetPlay(String rutaApuestasBetPlay) {
		this.rutaApuestasBetPlay = rutaApuestasBetPlay;
	}

	/**
	 * Gets the ruta apuestas chance.
	 *
	 * @return the ruta apuestas chance
	 */
	public String getRutaApuestasChance() {
		return rutaApuestasChance;
	}

	/**
	 * Sets the ruta apuestas chance.
	 *
	 * @param rutaApuestasChance the new ruta apuestas chance
	 */
	public void setRutaApuestasChance(String rutaApuestasChance) {
		this.rutaApuestasChance = rutaApuestasChance;
	}

	/**
	 * Gets the ois.
	 *
	 * @return the ois
	 */
	public ObjectInputStream getOis() {
		return ois;
	}

	/**
	 * Sets the ois.
	 *
	 * @param ois the new ois
	 */
	public void setOis(ObjectInputStream ois) {
		this.ois = ois;
	}

	/**
	 * Gets the oos.
	 *
	 * @return the oos
	 */
	public ObjectOutputStream getOos() {
		return oos;
	}

	/**
	 * Sets the oos.
	 *
	 * @param oos the new oos
	 */
	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}
	
}
