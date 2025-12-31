package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The Class Propiedades.
 */
public class Propiedades {

	/** El objeto Properties para manejar las propiedades. */
	private Properties prop = new Properties();
	
	/** La ruta del archivo de propiedades. */
	private String archivoProp = "./Data/config.properties";

	/**
	 * Escribir propiedades casa de apuestas.
	 *
	 * @param nombreCasaDeApuestas El nombre de la casa de apuestas.
     * @param numeroDeSedes        El numero de sedes de la casa de apuestas.
     * @param presupuestoTotal     El presupuesto total disponible para la casa de apuestas.
     * @return 0 si se escriben correctamente las propiedades, -1 si hay algún error.
	 */
	public int escribirPropiedadesCasaDeApuestas(String nombreCasaDeApuestas, int numeroDeSedes,
			double presupuestoTotal) {

		try {
			prop.setProperty("nombreArchivo", "config.properties");
			prop.setProperty("nombreCasaDeApuestas", nombreCasaDeApuestas);
			prop.setProperty("numeroDeSedes", numeroDeSedes + "");
			prop.setProperty("presupuestoTotalDisponible", presupuestoTotal + "");
			prop.store(new FileOutputStream(archivoProp), null);
		} catch (IOException e) {
			return -1;
		}

		return 0;
	}

	/**
	 * Leer propiedades casa de apuestas.
	 */
	public void leerPropiedadesCasaDeApuestas() {
		try {
			prop.load(new FileInputStream(archivoProp));
			prop.list(System.out);
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}

	/**
	 * Gets the prop.
	 *
	 * @return the prop
	 */
	public Properties getProp() {
		return prop;
	}

	/**
	 * Sets the prop.
	 *
	 * @param prop the new prop
	 */
	public void setProp(Properties prop) {
		this.prop = prop;
	}

	/**
	 * Gets the archivo prop.
	 *
	 * @return the archivo prop
	 */
	public String getArchivoProp() {
		return archivoProp;
	}

	/**
	 * Sets the archivo prop.
	 *
	 * @param archivoProp the new archivo prop
	 */
	public void setArchivoProp(String archivoProp) {
		this.archivoProp = archivoProp;
	}

}
