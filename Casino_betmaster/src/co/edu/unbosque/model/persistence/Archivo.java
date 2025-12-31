package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;

import co.edu.unbosque.model.Apostador;
import co.edu.unbosque.model.Baloto;
import co.edu.unbosque.model.BetPlay;
import co.edu.unbosque.model.Chance;
import co.edu.unbosque.model.Juego;
import co.edu.unbosque.model.Loteria;
import co.edu.unbosque.model.Sede;
import co.edu.unbosque.model.SuperAstro;

// TODO: Auto-generated Javadoc
/**
 * The Class Archivo.
 */
public class Archivo {
	
	private String archivoSedes = "./Archivos/sedes.dat";
	private String archivoApostadores = "./Archivos/apostadores.dat";
	private String archivoJuegos = "./Archivos/juegos.dat";
	private String archivoLoteria = "./Archivos/apuestas-loteria.dat";
	private String archivoSuperAstro = "./Archivos/apuestas-superastro.dat";
	private String archivoBaloto = "./Archivos/apuestas-baloto.dat";
	private String archivoBetPlay = "./Archivos/apuestas-betplay.dat";
	private String archivoEquipos = "./Archivos/equipos.txt";
	private String archivoChance = "./Archivos/apuestas-chance.dat";
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private FileReader fr;
	private BufferedReader br;
	
	///////////////////////////////////////// SEDES /////////////////////////////////////////
	
	/**
	 * Registrar sedes.
	 *
	 * @param sedes the sedes
	 * @return Entero que indica si el registro fue exitoso o no
	 */
	public int registrarSedes(ArrayList<Sede> sedes) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(archivoSedes));
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
	public ArrayList<Sede> obtenerSedes() {
		
		ArrayList<Sede> sedes = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(archivoSedes));
			sedes = (ArrayList<Sede>)ois.readObject();
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
	public int registrarApostadores(ArrayList<Apostador> apostadores) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(archivoApostadores));
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
	public ArrayList<Apostador> obtenerApostadores() {
		
		ArrayList<Apostador> apostadores = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(archivoApostadores));
			apostadores = (ArrayList<Apostador>)ois.readObject();
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
	public int registrarJuegos(ArrayList<Juego> juegos) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(archivoJuegos));
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
	public ArrayList<Juego> obtenerJuegos() {
		
		ArrayList<Juego> juegos = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(archivoJuegos));
			juegos = (ArrayList<Juego>)ois.readObject();
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
	public int registrarApuestasLoteria(ArrayList<Loteria> apuestasLoteria) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(archivoLoteria));
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
	public ArrayList<Loteria> obtenerApuestasLoteria() {
		
		ArrayList<Loteria> apuestasLoteria = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(archivoLoteria));
			apuestasLoteria = (ArrayList<Loteria>)ois.readObject();
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
	public int registrarApuestasSuperAstro(ArrayList<SuperAstro> apuestasSuperAstro) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(archivoSuperAstro));
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
	public ArrayList<SuperAstro> obtenerApuestasSuperAstro() {
		
		ArrayList<SuperAstro> apuestasSuperAstro = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(archivoSuperAstro));
			apuestasSuperAstro = (ArrayList<SuperAstro>)ois.readObject();
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
	public int registrarApuestasBaloto(ArrayList<Baloto> apuestasBaloto) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(archivoBaloto));
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
	public ArrayList<Baloto> obtenerApuestasBaloto() {
		
		ArrayList<Baloto> apuestasBaloto = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(archivoBaloto));
			apuestasBaloto = (ArrayList<Baloto>)ois.readObject();
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
	public int registrarApuestasChance(ArrayList<Chance> apuestasChance) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(archivoChance));
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
	public ArrayList<Chance> obtenerApuestasChance() {
		
		ArrayList<Chance> apuestasChance = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(archivoChance));
			apuestasChance = (ArrayList<Chance>)ois.readObject();
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
	public int registrarApuestasBetPlay(ArrayList<BetPlay> apuestasBetPlay) {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(archivoBetPlay));
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
	public ArrayList<BetPlay> obtenerApuestasBetPlay() {
		
		ArrayList<BetPlay> apuestasBetPlay = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(archivoBetPlay));
			apuestasBetPlay = (ArrayList<BetPlay>)ois.readObject();
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
			fr = new FileReader(new File(archivoEquipos));
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
			fr = new FileReader(new File(archivoEquipos));
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
	
}
