package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Clase que maneja la lógica de negocio para el análisis de texto. Se encarga
 * de cargar archivos, realizar búsquedas y mantener el estado de la aplicación.
 */
public class ModeloTexto {

	private String contenidoArchivo;
	private String rutaArchivo;
	private List<Integer> posicionesEncontradas;
	private String textoBuscado;

	public ModeloTexto() {
		contenidoArchivo = "";
		rutaArchivo = "";
		posicionesEncontradas = new ArrayList<>();
		textoBuscado = "";
	}

	public boolean cargarArchivo(File archivo) {
		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			StringBuilder contenido = new StringBuilder();
			String linea;

			while ((linea = reader.readLine()) != null) {
				contenido.append(linea).append("\n");
			}

			contenidoArchivo = contenido.toString();
			rutaArchivo = archivo.getAbsolutePath();
			posicionesEncontradas.clear();
			textoBuscado = "";

			return true;
		} catch (IOException e) {
			contenidoArchivo = "";
			rutaArchivo = "";
			return false;
		}
	}

	public int buscarTexto(String texto) {
		if (contenidoArchivo.isEmpty() || texto.isEmpty()) {
			posicionesEncontradas.clear();
			textoBuscado = "";
			return 0;
		}

		posicionesEncontradas.clear();
		textoBuscado = texto;

		String textoNormalizado = eliminarTildes(contenidoArchivo).toLowerCase();
		String patronNormalizado = eliminarTildes(texto).toLowerCase();

		List<Integer> posiciones = kmpSearch(textoNormalizado, patronNormalizado);
		posicionesEncontradas.addAll(posiciones);

		return posicionesEncontradas.size();
	}

	/**
	 * Algoritmo KMP (Knuth-Morris-Pratt) para búsqueda de patrones.
	 * 
	 * ¿Por qué KMP? - Evita comparaciones innecesarias al no retroceder
	 * completamente - Complejidad O(n+m) vs O(n*m) de búsqueda simple -
	 * Especialmente útil para textos largos y patrones repetitivos - Usa una tabla
	 * de fallos para optimizar el proceso
	 */
	private List<Integer> kmpSearch(String texto, String patron) {
		List<Integer> posiciones = new ArrayList<>();

		if (patron.isEmpty()) {
			return posiciones;
		}

		int[] fallos = construirTablaFallos(patron);

		int i = 0;
		int j = 0;

		while (i < texto.length()) {
			if (texto.charAt(i) == patron.charAt(j)) {
				i++;
				j++;

				if (j == patron.length()) {
					posiciones.add(i - j);
					j = fallos[j - 1];
				}
			} else {
				if (j != 0) {
					j = fallos[j - 1];
				} else {
					i++;
				}
			}
		}

		return posiciones;
	}

	/**
	 * Construye la tabla de fallos para KMP. Esta tabla precalcula cuántos
	 * caracteres se pueden omitir cuando hay una discrepancia, evitando
	 * comparaciones redundantes.
	 */
	private int[] construirTablaFallos(String patron) {
		int[] fallos = new int[patron.length()];
		fallos[0] = 0;

		int i = 1;
		int j = 0;

		while (i < patron.length()) {
			if (patron.charAt(i) == patron.charAt(j)) {
				fallos[i] = j + 1;
				i++;
				j++;
			} else {
				if (j != 0) {
					j = fallos[j - 1];
				} else {
					fallos[i] = 0;
					i++;
				}
			}
		}

		return fallos;
	}

	private String eliminarTildes(String texto) {
		String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
		Pattern patron = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return patron.matcher(normalizado).replaceAll("");
	}

	public String getContenidoArchivo() {
		return contenidoArchivo;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public List<Integer> getPosicionesEncontradas() {
		return new ArrayList<>(posicionesEncontradas);
	}

	public String getTextoBuscado() {
		return textoBuscado;
	}

	public boolean tieneArchivoCargado() {
		return !contenidoArchivo.isEmpty();
	}

	public void limpiar() {
		contenidoArchivo = "";
		rutaArchivo = "";
		posicionesEncontradas.clear();
		textoBuscado = "";
	}
}
