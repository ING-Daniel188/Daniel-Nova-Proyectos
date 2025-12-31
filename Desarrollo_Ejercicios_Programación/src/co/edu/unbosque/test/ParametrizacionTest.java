package co.edu.unbosque.test;

import co.edu.unbosque.model.persistence.Propiedades;
import junit.framework.TestCase;

/**
 * The Class ParametrizacionTest.
 */
public class ParametrizacionTest extends TestCase {

	
	/**
	 * Test parametros asignados.
	 */
	public void testParametrosAsignados() {
		
		Propiedades prop = new Propiedades();
		
		prop.escribirPropiedadesCasaDeApuestas("Casa de apuestas Ej", 20, 1200000.0);
		
		// Probar que se hayan guardado correctamente los parámetros de la casa de apuestas
		assertEquals("Casa de apuestas Ej", prop.getProp().getProperty("nombreCasaDeApuestas"));
		assertEquals(20, Integer.parseInt(prop.getProp().getProperty("numeroDeSedes")));
		assertEquals(1200000.0, Double.parseDouble(prop.getProp().getProperty("presupuestoTotalDisponible")));
	}
	
}
