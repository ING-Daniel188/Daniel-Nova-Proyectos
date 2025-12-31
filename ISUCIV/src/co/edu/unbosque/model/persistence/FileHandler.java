/*
 * 
 */
package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class FileHandler.
 */
public class FileHandler {
	
	/**
	 * Escribir binario.
	 *
	 * @param <T> the generic type
	 * @param lista the lista
	 * @param nombreBinario the nombre binario
	 */
	public static <T> void escribirBinario(List<T> lista, String nombreBinario) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreBinario))) {
			oos.writeObject(lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Leer binario.
	 *
	 * @param <T> the generic type
	 * @param nombreBinario the nombre binario
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> leerBinario(String nombreBinario) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreBinario))) {
			return (List<T>) ois.readObject();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}
}
