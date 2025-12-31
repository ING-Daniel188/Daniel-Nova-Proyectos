package co.edu.unbosque.test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import co.edu.unbosque.model.SuperAstroDTO;
import co.edu.unbosque.model.persistence.SuperAstroDAO;
import junit.framework.TestCase;

/**
 * The Class ApuestaSuperAstroTest.
 */
public class ApuestaSuperAstroTest extends TestCase {

	/**
	 * Test crear super astro.
	 */
	public void testCrearSuperAstro() {
		
		SuperAstroDAO gestorSuperAstro = new SuperAstroDAO();
		
		String nombreSede = "Barrios Unidos";
		String cedulaApostador = "123";
		
		LocalDateTime fechaActual = LocalDateTime.now(ZoneId.systemDefault());
		
		DateTimeFormatter formateadorDeFechas = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		String fechaApuesta = fechaActual.format(formateadorDeFechas);
		double valor = 1225;
		
		int[] numerosSeleccionados = {4, 5, 0, 6};
		
		String signoDelZodiaco = "Piscis";
		
		int numeroActualSuperAstros = gestorSuperAstro.getApuestasSuperAstro().size();
		
		gestorSuperAstro.agregarApuestaSuperAstro(nombreSede, cedulaApostador, fechaApuesta, valor, numerosSeleccionados, signoDelZodiaco);
		gestorSuperAstro.registrarApuestasSuperAstro();
		
		int nuevoNumeroSuperAstros = gestorSuperAstro.getApuestasSuperAstro().size();
		
		// Asegurarse que se haya agregado la apuesta superastro
		assertTrue(numeroActualSuperAstros < nuevoNumeroSuperAstros);
		
	}
	
	/**
	 * Test modificar super astro.
	 */
	public void testModificarSuperAstro() {
		
		SuperAstroDAO gestorSuperAstro = new SuperAstroDAO();
		
		// Revisar que se hayan agregado apuestas de superastro
		if (gestorSuperAstro.getApuestasSuperAstro().size() > 0) {
			SuperAstroDTO superAstroAModificar = gestorSuperAstro.getApuestasSuperAstro().get(0);
			 
			String nombreSede = "Barrios Unidos";
			String cedulaApostador = "123";
			
			LocalDateTime fechaActual = LocalDateTime.now(ZoneId.systemDefault());
			
			DateTimeFormatter formateadorDeFechas = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
			String fechaApuesta = fechaActual.format(formateadorDeFechas);
			
			double valor = superAstroAModificar.getValor();
			
			int[] nuevosNumerosSeleccionados = {3, 5, 2, 8};
			
			String signoDelZodiaco = superAstroAModificar.getSignoDelZodiaco();
			
			gestorSuperAstro.modificarApuestaSuperAstro(0, nombreSede, cedulaApostador, fechaApuesta, valor, nuevosNumerosSeleccionados, signoDelZodiaco);
			gestorSuperAstro.registrarApuestasSuperAstro();
			
			// Revisar que se hayan registrado los nuevos números seleccionados
			for (int i = 0; i < nuevosNumerosSeleccionados.length; i++)
				assertTrue(nuevosNumerosSeleccionados[i] == gestorSuperAstro.getApuestasSuperAstro().get(0).getNumerosSeleccionados()[i]);
		}
		
		
	}
	
	/**
	 * Test eliminar super astro.
	 */
	public void testEliminarSuperAstro() {
		
		SuperAstroDAO gestorSuperAstros = new SuperAstroDAO();
		
		int numeroSuperAstros = gestorSuperAstros.getApuestasSuperAstro().size();
		
		if (gestorSuperAstros.getApuestasSuperAstro().size() > 0) {
			
			gestorSuperAstros.eliminarApuestaSuperAstro(0);
			gestorSuperAstros.registrarApuestasSuperAstro();
			
		}
		
		int numeroFinalSuperAstros = gestorSuperAstros.getApuestasSuperAstro().size();
		
		// Asegurarse que se haya eliminado la apuesta superastro
		assertEquals(numeroSuperAstros - 1, numeroFinalSuperAstros);
		
	}
	
}
