package co.edu.unbosque.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class Producto.
 */
public abstract class Producto {

	/** The nombre. */
	protected String nombre;
	
	/** The categoria. */
	protected String categoria;
	
	/** The precio. */
	protected double precio;
	
	/** The cantidad. */
	protected int cantidad;
	
	/** The fecha caducidad. */
	protected String fechaCaducidad;
	
	/** The proveedor. */
	protected String proveedor;

	/**
	 * Instantiates a new producto.
	 *
	 * @param nombre the nombre
	 * @param categoria the categoria
	 * @param precio the precio
	 * @param cantidad the cantidad
	 * @param fechaCaducidad the fecha caducidad
	 * @param proveedor the proveedor
	 */
	protected Producto(String nombre, String categoria, double precio, int cantidad, String fechaCaducidad,
			String proveedor) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.cantidad = cantidad;
		this.fechaCaducidad = fechaCaducidad;
		this.proveedor = proveedor;
	}
	
	/**
	 * Obtener fecha caducidad calendario.
	 *
	 * @return the date
	 */
	public Date obtenerFechaCaducidadCalendario() {
		SimpleDateFormat formateadorFecha = new SimpleDateFormat("dd/MM/yyyy");
		
		Date fechaConvertida = null;
		try {
			fechaConvertida = formateadorFecha.parse(fechaCaducidad);
		} catch (ParseException e) {
			return null;
		}
		return fechaConvertida;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Gets the categoria.
	 *
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Gets the precio.
	 *
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Gets the cantidad.
	 *
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Gets the fecha caducidad.
	 *
	 * @return the fecha caducidad
	 */
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	/**
	 * Gets the proveedor.
	 *
	 * @return the proveedor
	 */
	public String getProveedor() {
		return proveedor;
	}

}
