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

	private Properties prop = new Properties();
	private String archivoPropiedades = "./Archivos/config.properties";

	/**
	 * Escribir propiedades casa de apuestas.
	 *
	 * @param nombreCasaDeApuestas El nombre de la casa de apuestas.
     * @param numeroDeSedes        El numero de sedes de la casa de apuestas.
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
	
	public String obtenerNombreCasa() {
		// Cargar las propiedades actuales del archivo config.properties
		try {
			prop.load(new FileInputStream(archivoPropiedades));
		} catch (Exception e) { return ""; }
		if (prop.getProperty("casaDeApuestas") == null)
			return "";
		return prop.getProperty("casaDeApuestas");
	}
	
	public int obtenerNumeroSedes() {
		return Integer.parseInt(prop.getProperty("sedes"));
	}
	
	public double obtenerPresupuestoTotal() {
		return Double.parseDouble(prop.getProperty("presupuestoTotal"));
	}
	

	public String getArchivoPropiedades() {
		return archivoPropiedades;
	}

	public void setArchivoPropiedades(String archivoPropiedades) {
		this.archivoPropiedades = archivoPropiedades;
	}

}
