package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Clase encargada de la gestión de archivos, permitiendo leer y escribir en ellos.
 * Utiliza la API de NIO para operaciones de archivo, lo que proporciona una manera eficiente y moderna
 * de manejo de archivos en Java.
 */
public class FileManager {
	
	/**
	 * Escribe el contenido proporcionado en un archivo especificado por su ruta.
	 * Si el archivo no existe, se crea. Si el archivo existe, su contenido será sobreescrito.
	 * 
	 * @param rutaArchivo La ruta del archivo donde se escribirá el contenido.
	 * @param contenido El contenido a escribir en el archivo.
	 * @return true si la escritura fue exitosa, false en caso contrario.
	 */
	public static boolean escribirArchivo(String rutaArchivo, String contenido) {
		try {
			Files.write(Paths.get(rutaArchivo), contenido.getBytes(), StandardOpenOption.CREATE);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	/**
	 * Lee el contenido de un archivo especificado por su ruta y lo retorna como una cadena de texto.
	 * 
	 * @param rutaArchivo La ruta del archivo a leer.
	 * @return El contenido del archivo como una cadena de texto, o null si ocurre un error al leer el archivo.
	 */
	public static String leerArchivo(String rutaArchivo) {
		try {
			return new String(Files.readAllBytes(Paths.get(rutaArchivo)));
		} catch (IOException e) {
			return null;
		}
	}
}
