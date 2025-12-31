package co.edu.unbosque.test;

import co.edu.unbosque.model.ApostadorDTO;
import co.edu.unbosque.model.persistence.ApostadorDAO;
import junit.framework.TestCase;

/**
 * The Class GestionApostadoresTest.
 */
public class GestionApostadoresTest extends TestCase {

	/**
	 * Test creacion apostador.
	 */
	public void testCreacionApostador() {
		
		ApostadorDAO gestorDeApostadores = new ApostadorDAO();
		String nombreCompleto = "Pepito Perez";
		String cedula = "123";
		String sedeActual = "Barrios Unidos";
		String direccion = "cra 13";
		long celular = 302244656;
		
		gestorDeApostadores.agregarApostador(nombreCompleto, cedula, sedeActual, direccion, celular);
		gestorDeApostadores.registrarApostadores();
		
		// Asegurarse de que al leer los apostadores del archivo esté el recién agregado
		assertTrue(gestorDeApostadores.getArchivo().obtenerApostadores().size() > 0);
		
	}
	
	/**
	 * Test modificacion apostador.
	 */
	public void testModificacionApostador() {
		
		ApostadorDAO gestorApostadores = new ApostadorDAO();
		
		if (gestorApostadores.getApostadores().size() > 0) {
			int indiceApostadorAModificar = 0;
			ApostadorDTO apostadorAModificar = gestorApostadores.getApostadores().get(indiceApostadorAModificar);
			
			String nombreCompletoApostador = apostadorAModificar.getNombreCompleto();
			String cedula = apostadorAModificar.getCedula();
			String direccion = apostadorAModificar.getDireccion();
			long celular = apostadorAModificar.getCelular();
			
			String ubicacionActual = gestorApostadores.getApostadores().get(indiceApostadorAModificar).getSedeActual();
			
			String nuevaUbicacion = "Usme";
			
			if (ubicacionActual.equals(nuevaUbicacion))
				nuevaUbicacion = "Usaquen";
			
			gestorApostadores.modificarApostador(indiceApostadorAModificar, nombreCompletoApostador, cedula, nuevaUbicacion, direccion, celular);
			gestorApostadores.registrarApostadores();
			
			
			// Asegurarse de que si se haya modificado el archivo y por lo tanto el arraylist con el apostador modificado
			assertTrue(gestorApostadores.getApostadores().get(indiceApostadorAModificar).getSedeActual().equals(nuevaUbicacion));
			
		}
		
	}
	
	/**
	 * Test eliminacion apostador.
	 */
	public void testEliminacionApostador() {
		
		ApostadorDAO gestorApostadores = new ApostadorDAO();
		
		int numeroInicialApostadores = gestorApostadores.getApostadores().size();
		
		// Asegurarse de que si se elimina una sede el tamaño del arraylist extraido del archivo esté reducido
		if (numeroInicialApostadores > 0) {
			
			gestorApostadores.eliminarApostador(0);
			gestorApostadores.registrarApostadores();
			int numeroActualApostadores = gestorApostadores.getApostadores().size();
			assertTrue(numeroInicialApostadores > numeroActualApostadores);
			
		} else {
			gestorApostadores.registrarApostadores();
			int numeroActualApostadores = gestorApostadores.getArchivo().obtenerApostadores().size();
			assertTrue(numeroInicialApostadores == numeroActualApostadores);
		}
		
		
	}
	
}
