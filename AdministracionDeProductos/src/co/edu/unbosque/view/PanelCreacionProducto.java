package co.edu.unbosque.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

/**
 * The Class PanelCreacionProducto.
 */
public abstract class PanelCreacionProducto extends PanelBase {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The label titulo. */
	protected JLabel labelTitulo;

	/** The label nombre. */
	protected JLabel labelNombre;
	
	/** The txt nombre. */
	protected JTextField txtNombre;

	/** The label precio. */
	protected JLabel labelPrecio;
	
	/** The txt precio. */
	protected JTextField txtPrecio;

	/** The label proveedor. */
	protected JLabel labelProveedor;
	
	/** The txt proveedor. */
	protected JTextField txtProveedor;

	/** The label cantidad. */
	protected JLabel labelCantidad;
	
	/** The txt cantidad. */
	protected JTextField txtCantidad;

	/** The label fecha caducidad. */
	protected JLabel labelFechaCaducidad;
	
	/** The fecha caducidad. */
	protected JCalendar fechaCaducidad;

	/** The btn volver menu gestion. */
	protected JButton btnVolverMenuGestion;
	
	/** The btn agregar producto. */
	protected JButton btnAgregarProducto;

	/**
	 * Instantiates a new panel creacion producto.
	 */
	protected PanelCreacionProducto() {
		labelTitulo = new JLabel("Crear Producto");
		labelTitulo.setFont(super.getFuenteNegrilla());
		labelTitulo.setHorizontalAlignment(JLabel.CENTER);
		labelTitulo.setBounds(350, 40, 250, 25);
		add(labelTitulo);

		labelNombre = new JLabel("Nombre");
		labelNombre.setFont(super.getFuentePlana());
		labelNombre.setBounds(30, 120, 150, 50);
		add(labelNombre);

		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(JTextField.CENTER);
		txtNombre.setFont(super.getFuentePlana());
		txtNombre.setBounds(180, 120, 370, 50);
		add(txtNombre);

		labelPrecio = new JLabel("Precio  $");
		labelPrecio.setFont(super.getFuentePlana());
		labelPrecio.setBounds(590, 120, 120, 50);
		add(labelPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setHorizontalAlignment(JTextField.CENTER);
		txtPrecio.setFont(super.getFuentePlana());
		txtPrecio.setBounds(720, 120, 200, 50);
		add(txtPrecio);

		labelProveedor = new JLabel("Proveedor");
		labelProveedor.setFont(super.getFuentePlana());
		labelProveedor.setBounds(30, 200, 150, 50);
		add(labelProveedor);

		txtProveedor = new JTextField();
		txtProveedor.setFont(super.getFuentePlana());
		txtProveedor.setHorizontalAlignment(JTextField.CENTER);
		txtProveedor.setBounds(180, 200, 370, 50);
		add(txtProveedor);

		labelCantidad = new JLabel("Cantidad");
		labelCantidad.setFont(super.getFuentePlana());
		labelCantidad.setBounds(30, 280, 150, 50);
		add(labelCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setFont(super.getFuentePlana());
		txtCantidad.setHorizontalAlignment(JTextField.CENTER);
		txtCantidad.setBounds(180, 280, 100, 50);
		add(txtCantidad);

		labelFechaCaducidad = new JLabel("Fecha de Caducidad");
		labelFechaCaducidad.setFont(super.getFuentePlana());
		labelFechaCaducidad.setBounds(590, 200, 320, 50);
		add(labelFechaCaducidad);

		fechaCaducidad = new JCalendar();
		Locale idioma = Locale.forLanguageTag("es-ES");
		fechaCaducidad.setLocale(idioma);
		fechaCaducidad.setBounds(590, 270, 330, 300);
		add(fechaCaducidad);

		btnVolverMenuGestion = new JButton("Volver al Menú Gestión");
		btnVolverMenuGestion.setFont(super.getFuentePlana());
		btnVolverMenuGestion.setFocusable(false);
		btnVolverMenuGestion.setBounds(30, 580, 400, 50);
		add(btnVolverMenuGestion);

		btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.setFont(super.getFuentePlana());
		btnAgregarProducto.setFocusable(false);
		btnAgregarProducto.setBounds(550, 580, 400, 50);
		add(btnAgregarProducto);
	}

	/**
	 * Reiniciar entradas.
	 */
	public void reiniciarEntradas() {
		txtNombre.setText("");
		txtPrecio.setText("");
		txtProveedor.setText("");
		txtCantidad.setText("");
		fechaCaducidad.setCalendar(Calendar.getInstance());
	}

	/**
	 * Validar entradas.
	 *
	 * @return true, if successful
	 */
	public boolean validarEntradas() {
		if (txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty() || txtProveedor.getText().isEmpty()
				|| txtCantidad.getText().isEmpty()) {
			super.mostrarMensaje("Todas las entradas deben ser llenadas");
			return false;
		}

		try {
			Double.parseDouble(txtPrecio.getText());
			Integer.parseInt(txtCantidad.getText());
		} catch (NumberFormatException e) {
			super.mostrarMensajeError("Las entradas numéricas no son válidas");
			return false;
		}

		return true;
	}

	/**
	 * Obtener fecha formateada.
	 *
	 * @return the string
	 */
	public String obtenerFechaFormateada() {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFormateada = formatoFecha.format(fechaCaducidad.getDate());
		return fechaFormateada;
	}

	/**
	 * Llenar entradas.
	 *
	 * @param nombre the nombre
	 * @param precio the precio
	 * @param proveedor the proveedor
	 * @param cantidad the cantidad
	 * @param fechaCaducidadCalendario the fecha caducidad calendario
	 */
	public void llenarEntradas(String nombre, double precio, String proveedor, int cantidad,
			Date fechaCaducidadCalendario) {
		txtNombre.setText(nombre);
		txtPrecio.setText(precio + "");
		txtProveedor.setText(proveedor);
		txtCantidad.setText(cantidad + "");
		fechaCaducidad.setDate(fechaCaducidadCalendario);
	}

	/**
	 * Gets the label titulo.
	 *
	 * @return the label titulo
	 */
	public JLabel getLabelTitulo() {
		return labelTitulo;
	}

	/**
	 * Gets the txt nombre.
	 *
	 * @return the txt nombre
	 */
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	/**
	 * Gets the txt precio.
	 *
	 * @return the txt precio
	 */
	public JTextField getTxtPrecio() {
		return txtPrecio;
	}

	/**
	 * Gets the txt proveedor.
	 *
	 * @return the txt proveedor
	 */
	public JTextField getTxtProveedor() {
		return txtProveedor;
	}

	/**
	 * Gets the txt cantidad.
	 *
	 * @return the txt cantidad
	 */
	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	/**
	 * Gets the btn volver menu gestion.
	 *
	 * @return the btn volver menu gestion
	 */
	public JButton getBtnVolverMenuGestion() {
		return btnVolverMenuGestion;
	}

	/**
	 * Gets the btn agregar producto.
	 *
	 * @return the btn agregar producto
	 */
	public JButton getBtnAgregarProducto() {
		return btnAgregarProducto;
	}

}
