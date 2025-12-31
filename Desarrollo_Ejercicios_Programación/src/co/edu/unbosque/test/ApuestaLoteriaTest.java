package co.edu.unbosque.test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import co.edu.unbosque.model.LoteriaDTO;
import co.edu.unbosque.model.persistence.LoteriaDAO;
import junit.framework.TestCase;

/**
 * The Class ApuestaLoteriaTest.
 */
public class ApuestaLoteriaTest extends TestCase {

	/**
	 * Test crear loteria.
	 */
	public void testCrearLoteria() {
		
		LoteriaDAO gestorLoteria = new LoteriaDAO();
		
		String tipoDeApuesta = "Loteria"; 
		String nombreSede = "Barrios Unidos";
		String cedulaApostador = "123";
		
		LocalDateTime fechaActual = LocalDateTime.now(ZoneId.systemDefault());
		
		DateTimeFormatter formateadorDeFechas = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		String fechaApuesta = fechaActual.format(formateadorDeFechas);
		double valor = 1225;
		String nombre = "Lotería de Bogotá";
		int numeroLoteria = 1245;
		int serie = 523;
		
		int numeroActualLoterias = gestorLoteria.getApuestasLoteria().size();
		
		gestorLoteria.agregarApuestaLoteria(tipoDeApuesta, nombreSede, cedulaApostador, fechaApuesta, valor, nombre, numeroLoteria, serie);
		gestorLoteria.registrarApuestasLoteria();
		
		int numeroNuevoLoterias = gestorLoteria.getApuestasLoteria().size();
		
		// Asegurarse que se haya agregado la apuesta de lotería
		assertTrue(numeroActualLoterias < numeroNuevoLoterias);
		
	}
	
	/**
	 * Test modificar loteria.
	 */
	public void testModificarLoteria() {
		
		LoteriaDAO gestorLoteria = new LoteriaDAO();
		
		LoteriaDTO loteriaAModificar = gestorLoteria.getApuestasLoteria().get(0);
		
		String tipoDeApuesta = "Loteria"; 
		String nombreSede = "Barrios Unidos";
		String cedulaApostador = "123";
		
		LocalDateTime fechaActual = LocalDateTime.now(ZoneId.systemDefault());
		
		DateTimeFormatter formateadorDeFechas = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		String fechaApuesta = fechaActual.format(formateadorDeFechas);
		String nombre = "Lotería de Bogotá";
		int numeroLoteria = 1245;
		int serie = 523;
		
		
		double valorActual = loteriaAModificar.getValor();
		
		double valorAModificar = loteriaAModificar.getValor() + 255;
		
		gestorLoteria.modificarApuestaLoteria(0, tipoDeApuesta, nombreSede, cedulaApostador, fechaApuesta, valorAModificar, nombre, numeroLoteria, serie);
		gestorLoteria.registrarApuestasLoteria();
		
		// Asegurarse que el valor de la apuesta haya sido modificado
		assertTrue(gestorLoteria.getArchivo().obtenerApuestasLoteria().get(0).getValor() > valorActual);
		
		
	}
	
	/**
	 * Test eliminar loteria.
	 */
	public void testEliminarLoteria() {
		
		LoteriaDAO gestorLoterias = new LoteriaDAO();
		
		int numeroLoterias = gestorLoterias.getApuestasLoteria().size();
		
		if (gestorLoterias.getApuestasLoteria().size() > 0) {
			
			gestorLoterias.eliminarApuestaLoteria(0);
			gestorLoterias.registrarApuestasLoteria();
			
		}
		
		int numeroFinalLoterias = gestorLoterias.getApuestasLoteria().size();
		
		// Asegurarse que la apuesta haya sido eliminada
		assertEquals(numeroLoterias - 1, numeroFinalLoterias);
		
	}
	
}
