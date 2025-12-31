package co.edu.unbosque.test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import co.edu.unbosque.model.BalotoDTO;
import co.edu.unbosque.model.persistence.BalotoDAO;
import junit.framework.TestCase;

/**
 * The Class ApuestaBalotoTest.
 */
public class ApuestaBalotoTest extends TestCase {

	/**
	 * Test crear baloto.
	 */
	public void testCrearBaloto() {
        BalotoDAO gestorBaloto = new BalotoDAO();

        String nombreSede = "Barrios Unidos";
        String cedulaApostador = "123";

        LocalDateTime fechaActual = LocalDateTime.now(ZoneId.systemDefault());

        DateTimeFormatter formateadorDeFechas = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String fechaApuesta = fechaActual.format(formateadorDeFechas);
        double valor = 1225;

        int[] numerosSeleccionados = {4, 5, 0, 6, 4, 3};

        int numeroActualBalotos = gestorBaloto.getApuestasBaloto().size();

        gestorBaloto.agregarApuestaBaloto(nombreSede, cedulaApostador, fechaApuesta, valor, numerosSeleccionados);
        gestorBaloto.registrarApuestasBaloto();

        int nuevoNumeroBalotos = gestorBaloto.getApuestasBaloto().size();

        // Asegurarse que se haya agregado la apuesta baloto
        assertTrue(numeroActualBalotos < nuevoNumeroBalotos);
    }

    /**
     * Test modificar baloto.
     */
    public void testModificarBaloto() {
        BalotoDAO gestorBaloto = new BalotoDAO();
        
        if (gestorBaloto.getApuestasBaloto().size() > 0) {
        	BalotoDTO balotoAModificar = gestorBaloto.getApuestasBaloto().get(0);

            String nombreSede = "Barrios Unidos";
            String cedulaApostador = "123";

            LocalDateTime fechaActual = LocalDateTime.now(ZoneId.systemDefault());

            DateTimeFormatter formateadorDeFechas = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String fechaApuesta = fechaActual.format(formateadorDeFechas);
            double valor = balotoAModificar.getValor();

            int[] nuevosNumerosSeleccionados = {3, 5, 2, 8, 0, 1};

            gestorBaloto.modificarApuestaBaloto(0, nombreSede, cedulaApostador, fechaApuesta, valor, nuevosNumerosSeleccionados);
            gestorBaloto.registrarApuestasBaloto();

            // Revisar que se hayan registrado los nuevos números seleccionados
            for (int i = 0; i < nuevosNumerosSeleccionados.length; i++) {
                assertEquals(nuevosNumerosSeleccionados[i], gestorBaloto.getApuestasBaloto().get(0).getNumerosSeleccionados()[i]);
            }
        }
    }

    /**
     * Test eliminar baloto.
     */
    public void testEliminarBaloto() {
        BalotoDAO gestorBaloto = new BalotoDAO();

        int numeroBalotos = gestorBaloto.getApuestasBaloto().size();

        if (gestorBaloto.getApuestasBaloto().size() > 0) {
            gestorBaloto.eliminarApuestaBaloto(0);
            gestorBaloto.registrarApuestasBaloto();
        }

        int numeroFinalBalotos = gestorBaloto.getApuestasBaloto().size();

        // Asegurarse de que se haya eliminado la apuesta baloto
        assertEquals(numeroBalotos - 1, numeroFinalBalotos);
    }
	
}
