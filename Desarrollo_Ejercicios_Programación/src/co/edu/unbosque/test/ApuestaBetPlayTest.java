package co.edu.unbosque.test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import co.edu.unbosque.model.BetPlayDTO;
import co.edu.unbosque.model.persistence.BetPlayDAO;
import junit.framework.TestCase;

/**
 * The Class ApuestaBetPlayTest.
 */
public class ApuestaBetPlayTest extends TestCase {

	 /**
 	 * Test crear bet play.
 	 */
 	public void testCrearBetPlay() {
	        BetPlayDAO gestorBetPlay = new BetPlayDAO();

	        String nombreSede = "Barrios Unidos";
	        String cedulaApostador = "123";

	        LocalDateTime fechaActual = LocalDateTime.now(ZoneId.systemDefault());

	        DateTimeFormatter formateadorDeFechas = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	        String fechaApuesta = fechaActual.format(formateadorDeFechas);
	        double valor = 1225;

	        String[][] partidosYResultadosEscogidos = {{"Equipo1", "Empate", "Equipo2"}};

	        int numeroActualBetPlays = gestorBetPlay.getApuestasBetPlay().size();

	        gestorBetPlay.agregarApuestaBetPlay(nombreSede, cedulaApostador, fechaApuesta, valor, partidosYResultadosEscogidos);
	        gestorBetPlay.registrarApuestasBetPlay();

	        int nuevoNumeroBetPlays = gestorBetPlay.getApuestasBetPlay().size();

	        // Asegurarse que se haya agregado la apuesta de betplay
	        assertTrue(numeroActualBetPlays < nuevoNumeroBetPlays);
	    }

	    /**
    	 * Test modificar bet play.
    	 */
    	public void testModificarBetPlay() {
	        BetPlayDAO gestorBetPlay = new BetPlayDAO();

	        BetPlayDTO betPlayAModificar = gestorBetPlay.getApuestasBetPlay().get(0);

	        String nombreSede = "Barrios Unidos";
	        String cedulaApostador = "123";

	        LocalDateTime fechaActual = LocalDateTime.now(ZoneId.systemDefault());

	        DateTimeFormatter formateadorDeFechas = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	        String fechaApuesta = fechaActual.format(formateadorDeFechas);
	        double valor = betPlayAModificar.getValor();

	        String[][] nuevosPartidosYResultadosEscogidos = {{"Equipo3", "Empate", "Equipo4"}};

	        gestorBetPlay.modificarApuestaBetPlay(0, nombreSede, cedulaApostador, fechaApuesta, valor, nuevosPartidosYResultadosEscogidos);
	        gestorBetPlay.registrarApuestasBetPlay();

	        // Revisar que se hayan registrado los nuevos partidos y resultados
	        for (int i = 0; i < nuevosPartidosYResultadosEscogidos.length; i++) {
	            assertEquals(nuevosPartidosYResultadosEscogidos[i][0], gestorBetPlay.getApuestasBetPlay().get(0).getPartidosYResultadosEscogidos()[i][0]);
	            assertEquals(nuevosPartidosYResultadosEscogidos[i][1], gestorBetPlay.getApuestasBetPlay().get(0).getPartidosYResultadosEscogidos()[i][1]);
	            assertEquals(nuevosPartidosYResultadosEscogidos[i][2], gestorBetPlay.getApuestasBetPlay().get(0).getPartidosYResultadosEscogidos()[i][2]);
	        }
	    }

	    /**
    	 * Test eliminar bet play.
    	 */
    	public void testEliminarBetPlay() {
	        BetPlayDAO gestorBetPlay = new BetPlayDAO();

	        int numeroBetPlays = gestorBetPlay.getApuestasBetPlay().size();

	        if (gestorBetPlay.getApuestasBetPlay().size() > 0) {
	            gestorBetPlay.eliminarApuestaBetPlay(0);
	            gestorBetPlay.registrarApuestasBetPlay();
	        }

	        int numeroFinalBetPlays = gestorBetPlay.getApuestasBetPlay().size();

	        // Asegurarse que se haya eliminado la apuesta betplay
	        assertEquals(numeroBetPlays - 1, numeroFinalBetPlays);
	    }
	
}
