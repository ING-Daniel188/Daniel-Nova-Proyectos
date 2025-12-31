package co.edu.unbosque.test;

import co.edu.unbosque.model.SedeDTO;
import co.edu.unbosque.model.persistence.SedeDAO;
import junit.framework.TestCase;

/**
 * The Class GestionSedesTest.
 */
public class GestionSedesTest extends TestCase {

	/**
	 * Test creacion sede.
	 */
	public void testCreacionSede() {
		
		SedeDAO gestorDeSedes = new SedeDAO();
		
		gestorDeSedes.agregarSede("Usaquen", 19);
		gestorDeSedes.registrarSedes();
		
		// Asegurarse de que al leer las sedes del archivo esté la recién agregada
		assertTrue(gestorDeSedes.obtenerSedesActuales().length > 0);
		assertTrue(gestorDeSedes.getArchivo().obtenerSedes() != null);
		
	}
	
	/**
	 * Test modificacion sede.
	 */
	public void testModificacionSede() {
		
		SedeDAO gestorDeSedes = new SedeDAO();
		
		if (gestorDeSedes.getSedes().size() > 0) {
			int indiceSedeAModificar = 0;
			SedeDTO sedeAModificar = gestorDeSedes.getSedes().get(indiceSedeAModificar);
			String ubicacion = sedeAModificar.getUbicacion();
			int numeroEmpleados = sedeAModificar.getNumeroDeEmpleados();
			
			// Revisar que al menos se hayan agregado 2 sedes para revisar que se hayan modificado
			if (gestorDeSedes.obtenerSedesActuales().length > 2) {
				String nuevaUbicacion = gestorDeSedes.obtenerSedesActuales()[1];
				if (ubicacion.equals(nuevaUbicacion))
					nuevaUbicacion = gestorDeSedes.obtenerSedesActuales()[2];
				
				int nuevoNumeroDeEmpleados = numeroEmpleados + 1;
				
				gestorDeSedes.modificarSede(indiceSedeAModificar, nuevaUbicacion, nuevoNumeroDeEmpleados);
				gestorDeSedes.registrarSedes();
				
				// Asegurarse de que si se haya modificado el archivo y por lo tanto el arraylist con la sede modificada
				assertTrue(gestorDeSedes.getSedes().get(indiceSedeAModificar).getUbicacion().equals(nuevaUbicacion));
				assertTrue(gestorDeSedes.getSedes().get(indiceSedeAModificar).getNumeroDeEmpleados() == nuevoNumeroDeEmpleados);
			}
			
			
		}
		
	}
	
	/**
	 * Test eliminacion sede.
	 */
	public void testEliminacionSede() {
		
		SedeDAO gestorDeSedes = new SedeDAO();
		
		int numeroInicialSedes = gestorDeSedes.getSedes().size();
		
		// Asegurarse de que si se elimina una sede el tamaño del arraylist extraido del archivo esté reducido
		if (numeroInicialSedes > 0) {
			
			gestorDeSedes.eliminarSede(0);
			gestorDeSedes.registrarSedes();
			int numeroActualSedes = gestorDeSedes.getArchivo().obtenerSedes().size();
			assertTrue(numeroInicialSedes > numeroActualSedes);
			
		} else {
			gestorDeSedes.registrarSedes();
			int numeroActualSedes = gestorDeSedes.getArchivo().obtenerSedes().size();
			assertTrue(numeroInicialSedes == numeroActualSedes);
		}
		
		
	}
	
}
