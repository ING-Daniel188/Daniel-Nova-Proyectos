package co.edu.unbosque.view;

import java.awt.Color;
import java.util.Random;

/**
 * The Class ColoresAleatorios.
 */
public class ColoresAleatorios {
	
	/** The r. */
	private Random r;
	
	/**
	 * Instantiates a new colores aleatorios.
	 */
	public ColoresAleatorios() {
		r = new Random();
	}

	/**
	 * Generar color aleatorio claro.
	 *
	 * @return Un objeto de tipo Color que representa un color aleatorio claro.
	 */
	public Color generarColorAleatorioClaro() {

		int rojo, verde, azul, sumaRgb;

		do {
			rojo = r.nextInt(256); 
			verde = r.nextInt(256); 
			azul = r.nextInt(256);

			sumaRgb = rojo + verde + azul;
		} while (sumaRgb < 500);

		return new Color(rojo, verde, azul);
	}
	
	/**
	 * Generar color aleatorio oscuro.
	 *
	 * @return Un objeto de tipo Color que representa un color aleatorio oscuro.
	 */
	public Color generarColorAleatorioOscuro() {

		int rojo, verde, azul, sumaRgb;

		do {
			rojo = r.nextInt(256);
			verde = r.nextInt(256);
			azul = r.nextInt(256);

			sumaRgb = rojo + verde + azul;
		} while (sumaRgb > 200);

		return new Color(rojo, verde, azul);
	}

	/**
	 * Gets the r.
	 *
	 * @return the r
	 */
	public Random getR() {
		return r;
	}

	/**
	 * Sets the r.
	 *
	 * @param r the new r
	 */
	public void setR(Random r) {
		this.r = r;
	}
	
}
