package co.edu.unbosque.test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import co.edu.unbosque.model.ChanceDTO;
import co.edu.unbosque.model.persistence.ChanceDAO;
import junit.framework.TestCase;

/**
 * The Class ApuestaChanceTest.
 */
public class ApuestaChanceTest extends TestCase {

	/**
	 * Test crear chance.
	 */
	public void testCrearChance() {
        ChanceDAO gestorChance = new ChanceDAO();

        String nombreSede = "Barrios Unidos";
        String cedulaApostador = "123";

        LocalDateTime fechaActual = LocalDateTime.now(ZoneId.systemDefault());

        DateTimeFormatter formateadorDeFechas = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String fechaApuesta = fechaActual.format(formateadorDeFechas);
        double valor = 1225;
        String nombre = "Nombre";
        int[] numerosSeleccionados = {1, 2, 3, 4, 5};

        int numeroActualChances = gestorChance.getApuestasChance().size();

        gestorChance.agregarApuestaChance(nombreSede, cedulaApostador, fechaApuesta, valor, nombre, numerosSeleccionados);
        gestorChance.registrarApuestasChance();

        int nuevoNumeroChances = gestorChance.getApuestasChance().size();

        // Asegurarse que se haya agregado la apuesta chance
        assertTrue(numeroActualChances < nuevoNumeroChances);
    }

    /**
     * Test modificar chance.
     */
    public void testModificarChance() {
        ChanceDAO gestorChance = new ChanceDAO();

        // Revisar que se hayan agregado apuestas de chance
        if (gestorChance.getApuestasChance().size() > 0) {
        	ChanceDTO chanceAModificar = gestorChance.getApuestasChance().get(0);

            String nombreSede = "Barrios Unidos";
            String cedulaApostador = "123";

            LocalDateTime fechaActual = LocalDateTime.now(ZoneId.systemDefault());

            DateTimeFormatter formateadorDeFechas = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String fechaApuesta = fechaActual.format(formateadorDeFechas);
            double valor = chanceAModificar.getValor();
            String nombre = "NuevoNombre";
            int[] nuevosNumerosSeleccionados = {5, 4, 3, 2, 1};

            gestorChance.modificarApuestaChance(0, nombreSede, cedulaApostador, fechaApuesta, valor, nombre, nuevosNumerosSeleccionados);
            gestorChance.registrarApuestasChance();

            // Revisar que se hayan registrado los nuevos datos de la apuesta modificada
            assertEquals(nombre, gestorChance.getApuestasChance().get(0).getNombre());
            for (int i = 0; i < nuevosNumerosSeleccionados.length; i++) {
                assertEquals(nuevosNumerosSeleccionados[i], gestorChance.getApuestasChance().get(0).getNumerosSeleccionados()[i]);
            }
        }
        
    }

    /**
     * Test eliminar chance.
     */
    public void testEliminarChance() {
        ChanceDAO gestorChance = new ChanceDAO();

        int numeroChances = gestorChance.getApuestasChance().size();

        if (gestorChance.getApuestasChance().size() > 0) {
            gestorChance.eliminarApuestaChance(0);
            gestorChance.registrarApuestasChance();
        }

        int numeroFinalChances = gestorChance.getApuestasChance().size();

        // Asegurarse que se haya eliminado la apuesta chance
        assertEquals(numeroChances - 1, numeroFinalChances);
    }
	
}
