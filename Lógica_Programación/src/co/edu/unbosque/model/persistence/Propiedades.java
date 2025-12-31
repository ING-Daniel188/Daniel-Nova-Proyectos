package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class Propiedades.
 */
public class Propiedades {

	/** The prop. */
	private Properties prop = new Properties();
	
	/** The archivo propiedades. */
	private String archivoPropiedades = "config.properties";

	/**
	 * Escribir propiedades casa de apuestas.
	 *
	 * @param casaDeApuestas the casa de apuestas
	 * @param sedes the sedes
	 * @param presupuestoTotal     El presupuesto total disponible para la casa de apuestas.
	 * @return 0 si se escriben correctamente las propiedades, -1 si hay algún error.
	 */
	public int escribirPropiedadesCasaDeApuestas(String casaDeApuestas, int sedes,
			double presupuestoTotal) {

		try {
			prop.setProperty("archivo", "config.properties");
			prop.setProperty("casaDeApuestas", casaDeApuestas);
			prop.setProperty("sedes", sedes + "");
			prop.setProperty("presupuestoTotal", presupuestoTotal + "");
			prop.store(new FileOutputStream(archivoPropiedades), null);
		} catch (IOException e) {
			return -1;
		}

		return 0;
	}
	
	/**
	 * Obtener nombre casa.
	 *
	 * @return the string
	 */
	public String obtenerNombreCasa() {
		// Cargar las propiedades actuales del archivo config.properties
		try {
			prop.load(new FileInputStream(archivoPropiedades));
		} catch (Exception e) { return ""; }
		if (prop.getProperty("casaDeApuestas") == null)
			return "";
		return prop.getProperty("casaDeApuestas");
	}
	
	/**
	 * Obtener numero sedes.
	 *
	 * @return the int
	 */
	public int obtenerNumeroSedes() {
		return Integer.parseInt(prop.getProperty("sedes"));
	}
	
	/**
	 * Obtener presupuesto total.
	 *
	 * @return the double
	 */
	public double obtenerPresupuestoTotal() {
		if (prop.getProperty("presupuestoTotal") == null) {
			return 0;
		}
		return Double.parseDouble(prop.getProperty("presupuestoTotal"));
	}
	

	/**
	 * Gets the archivo propiedades.
	 *
	 * @return the archivo propiedades
	 */
	public String getArchivoPropiedades() {
		return archivoPropiedades;
	}

	/**
	 * Sets the archivo propiedades.
	 *
	 * @param archivoPropiedades the new archivo propiedades
	 */
	public void setArchivoPropiedades(String archivoPropiedades) {
		this.archivoPropiedades = archivoPropiedades;
	}

}
