/**
 * La clase AplMain es el punto de entrada al programa. Esta clase contiene el método main, que es el primer método que se ejecuta en cualquier aplicación de Java.
 * Su propósito es iniciar la ejecución del programa creando una instancia de la clase Controller y llamando al método run.
 * 
 * @author Desconocido
 * @version 1.0
 */
package co.edu.unbosque.controller;

public class AplMain {
	/**
	 * Método principal que se ejecuta al iniciar el programa. Crea una instancia de
	 * la clase Controller y llama al método run para iniciar el flujo de ejecución
	 * del programa.
	 * 
	 * @param args Argumentos de línea de comandos. No se utilizan en este programa.
	 */
	public static void main(String[] args) {
		Controller c = new Controller();
		c.run();
	}
}
