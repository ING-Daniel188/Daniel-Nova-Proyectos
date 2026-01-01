package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.CarneFria;
import co.edu.unbosque.model.ComidaChatarra;
import co.edu.unbosque.model.FrutaAcida;
import co.edu.unbosque.model.FrutaDulce;
import co.edu.unbosque.model.ProductoAnimalNoLacteo;
import co.edu.unbosque.model.ProductoLacteo;
import co.edu.unbosque.model.Verdura;
import co.edu.unbosque.model.persistence.ProductoDAO;
import co.edu.unbosque.view.VentanaPrincipal;

/**
 * The Class Controller.
 */
public class Controller implements ActionListener {

	/** The gestion productos. */
	private ProductoDAO gestionProductos;
	
	/** The vp. */
	private VentanaPrincipal vp;

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		gestionProductos = new ProductoDAO();
		vp = new VentanaPrincipal();
	}

	/**
	 * Run.
	 */
	public void run() {
		vp.setVisible(true);

		// Panel Menú Principal
		vp.getPanelMenuPrincipal().getBtnGestionarCarnesFrias().setActionCommand("btnGestionarCarnesFrias");
		vp.getPanelMenuPrincipal().getBtnGestionarProductosLacteos().setActionCommand("btnGestionarProductosLacteos");
		vp.getPanelMenuPrincipal().getBtnGestionarProductosAnimalesNoLacteos()
				.setActionCommand("btnGestionarProductosAnimalesNoLacteos");
		vp.getPanelMenuPrincipal().getBtnGestionarFrutasDulces().setActionCommand("btnGestionarFrutasDulces");
		vp.getPanelMenuPrincipal().getBtnGestionarFrutasAcidas().setActionCommand("btnGestionarFrutasAcidas");
		vp.getPanelMenuPrincipal().getBtnGestionarVerduras().setActionCommand("btnGestionarVerduras");
		vp.getPanelMenuPrincipal().getBtnGestionarComidaChatarra().setActionCommand("btnGestionarComidaChatarra");

		vp.getPanelMenuPrincipal().getBtnGestionarCarnesFrias().addActionListener(this);
		vp.getPanelMenuPrincipal().getBtnGestionarProductosLacteos().addActionListener(this);
		vp.getPanelMenuPrincipal().getBtnGestionarProductosAnimalesNoLacteos().addActionListener(this);
		vp.getPanelMenuPrincipal().getBtnGestionarFrutasDulces().addActionListener(this);
		vp.getPanelMenuPrincipal().getBtnGestionarFrutasAcidas().addActionListener(this);
		vp.getPanelMenuPrincipal().getBtnGestionarVerduras().addActionListener(this);
		vp.getPanelMenuPrincipal().getBtnGestionarComidaChatarra().addActionListener(this);

		// Panel Gestión Carnes Frías
		vp.getPanelGestionCarnesFrias().getBtnVolverMenuPrincipal().setActionCommand("btnVolverMenuPrincipal");
		vp.getPanelGestionCarnesFrias().getBtnCrearProducto().setActionCommand("btnCrearCarneFria");
		vp.getPanelGestionCarnesFrias().getBtnActualizarProducto().setActionCommand("btnActualizarCarneFria");
		vp.getPanelGestionCarnesFrias().getBtnEliminarProducto().setActionCommand("btnEliminarCarneFria");

		vp.getPanelGestionCarnesFrias().getBtnVolverMenuPrincipal().addActionListener(this);
		vp.getPanelGestionCarnesFrias().getBtnCrearProducto().addActionListener(this);
		vp.getPanelGestionCarnesFrias().getBtnActualizarProducto().addActionListener(this);
		vp.getPanelGestionCarnesFrias().getBtnEliminarProducto().addActionListener(this);

		// Panel Creación Carne Fría
		vp.getPanelCreacionCarneFria().getBtnVolverMenuGestion().setActionCommand("btnVolverMenuGestionCarnesFrias");
		vp.getPanelCreacionCarneFria().getBtnAgregarProducto().setActionCommand("btnAgregarCarneFria");

		vp.getPanelCreacionCarneFria().getBtnVolverMenuGestion().addActionListener(this);
		vp.getPanelCreacionCarneFria().getBtnAgregarProducto().addActionListener(this);

		// Panel Actualización Carne Fría
		vp.getPanelActualizacionCarneFria().getBtnVolverMenuGestion()
				.setActionCommand("btnVolverMenuGestionCarnesFrias");
		vp.getPanelActualizacionCarneFria().getBtnAgregarProducto().setActionCommand("btnModificarCarneFria");

		vp.getPanelActualizacionCarneFria().getBtnVolverMenuGestion().addActionListener(this);
		vp.getPanelActualizacionCarneFria().getBtnAgregarProducto().addActionListener(this);

		// Panel Gestión Productos Lácteos
		vp.getPanelGestionProductosLacteos().getBtnVolverMenuPrincipal().setActionCommand("btnVolverMenuPrincipal");
		vp.getPanelGestionProductosLacteos().getBtnCrearProducto().setActionCommand("btnCrearProductoLacteo");
		vp.getPanelGestionProductosLacteos().getBtnActualizarProducto().setActionCommand("btnActualizarProductoLacteo");
		vp.getPanelGestionProductosLacteos().getBtnEliminarProducto().setActionCommand("btnEliminarProductoLacteo");

		vp.getPanelGestionProductosLacteos().getBtnVolverMenuPrincipal().addActionListener(this);
		vp.getPanelGestionProductosLacteos().getBtnCrearProducto().addActionListener(this);
		vp.getPanelGestionProductosLacteos().getBtnActualizarProducto().addActionListener(this);
		vp.getPanelGestionProductosLacteos().getBtnEliminarProducto().addActionListener(this);

		// Panel Creación Producto Lácteo
		vp.getPanelCreacionProductoLacteo().getBtnVolverMenuGestion()
				.setActionCommand("btnVolverMenuGestionProductosLacteos");
		vp.getPanelCreacionProductoLacteo().getBtnAgregarProducto().setActionCommand("btnAgregarProductoLacteo");

		vp.getPanelCreacionProductoLacteo().getBtnVolverMenuGestion().addActionListener(this);
		vp.getPanelCreacionProductoLacteo().getBtnAgregarProducto().addActionListener(this);

		// Panel Actualización Producto Lácteo
		vp.getPanelActualizacionProductoLacteo().getBtnVolverMenuGestion()
				.setActionCommand("btnVolverMenuGestionProductosLacteos");
		vp.getPanelActualizacionProductoLacteo().getBtnAgregarProducto().setActionCommand("btnModificarProductoLacteo");

		vp.getPanelActualizacionProductoLacteo().getBtnVolverMenuGestion().addActionListener(this);
		vp.getPanelActualizacionProductoLacteo().getBtnAgregarProducto().addActionListener(this);

		// Panel Gestión Productos Animales No Lácteos
		vp.getPanelGestionProductosAnimalesNoLacteos().getBtnVolverMenuPrincipal()
				.setActionCommand("btnVolverMenuPrincipal");
		vp.getPanelGestionProductosAnimalesNoLacteos().getBtnCrearProducto()
				.setActionCommand("btnCrearProductoAnimalNoLacteo");
		vp.getPanelGestionProductosAnimalesNoLacteos().getBtnActualizarProducto()
				.setActionCommand("btnActualizarProductoAnimalNoLacteo");
		vp.getPanelGestionProductosAnimalesNoLacteos().getBtnEliminarProducto()
				.setActionCommand("btnEliminarProductoAnimalNoLacteo");

		vp.getPanelGestionProductosAnimalesNoLacteos().getBtnVolverMenuPrincipal().addActionListener(this);
		vp.getPanelGestionProductosAnimalesNoLacteos().getBtnCrearProducto().addActionListener(this);
		vp.getPanelGestionProductosAnimalesNoLacteos().getBtnActualizarProducto().addActionListener(this);
		vp.getPanelGestionProductosAnimalesNoLacteos().getBtnEliminarProducto().addActionListener(this);

		// Panel Creación Producto Animal No Lácteo
		vp.getPanelCreacionProductoAnimalNoLacteo().getBtnVolverMenuGestion()
				.setActionCommand("btnVolverMenuGestionProductosAnimalesNoLacteos");
		vp.getPanelCreacionProductoAnimalNoLacteo().getBtnAgregarProducto()
				.setActionCommand("btnAgregarProductoAnimalNoLacteo");

		vp.getPanelCreacionProductoAnimalNoLacteo().getBtnVolverMenuGestion().addActionListener(this);
		vp.getPanelCreacionProductoAnimalNoLacteo().getBtnAgregarProducto().addActionListener(this);

		// Panel Actualización Producto Animal No Lácteo
		vp.getPanelActualizacionProductoAnimalNoLacteo().getBtnVolverMenuGestion()
				.setActionCommand("btnVolverMenuGestionProductosAnimalesNoLacteos");
		vp.getPanelActualizacionProductoAnimalNoLacteo().getBtnAgregarProducto()
				.setActionCommand("btnModificarProductoAnimalNoLacteo");

		vp.getPanelActualizacionProductoAnimalNoLacteo().getBtnVolverMenuGestion().addActionListener(this);
		vp.getPanelActualizacionProductoAnimalNoLacteo().getBtnAgregarProducto().addActionListener(this);

		// Panel Gestión Frutas Dulces
		vp.getPanelGestionFrutasDulces().getBtnVolverMenuPrincipal().setActionCommand("btnVolverMenuPrincipal");
		vp.getPanelGestionFrutasDulces().getBtnCrearProducto().setActionCommand("btnCrearFrutaDulce");
		vp.getPanelGestionFrutasDulces().getBtnActualizarProducto().setActionCommand("btnActualizarFrutaDulce");
		vp.getPanelGestionFrutasDulces().getBtnEliminarProducto().setActionCommand("btnEliminarFrutaDulce");

		vp.getPanelGestionFrutasDulces().getBtnVolverMenuPrincipal().addActionListener(this);
		vp.getPanelGestionFrutasDulces().getBtnCrearProducto().addActionListener(this);
		vp.getPanelGestionFrutasDulces().getBtnActualizarProducto().addActionListener(this);
		vp.getPanelGestionFrutasDulces().getBtnEliminarProducto().addActionListener(this);

		// Panel Creación Fruta Dulce
		vp.getPanelCreacionFrutaDulce().getBtnVolverMenuGestion().setActionCommand("btnVolverMenuGestionFrutasDulces");
		vp.getPanelCreacionFrutaDulce().getBtnAgregarProducto().setActionCommand("btnAgregarFrutaDulce");

		vp.getPanelCreacionFrutaDulce().getBtnVolverMenuGestion().addActionListener(this);
		vp.getPanelCreacionFrutaDulce().getBtnAgregarProducto().addActionListener(this);

		// Panel Actualización Fruta Dulce
		vp.getPanelActualizacionFrutaDulce().getBtnVolverMenuGestion()
				.setActionCommand("btnVolverMenuGestionFrutasDulces");
		vp.getPanelActualizacionFrutaDulce().getBtnAgregarProducto().setActionCommand("btnModificarFrutaDulce");

		vp.getPanelActualizacionFrutaDulce().getBtnVolverMenuGestion().addActionListener(this);
		vp.getPanelActualizacionFrutaDulce().getBtnAgregarProducto().addActionListener(this);

		// Panel Gestión Frutas Ácidas
		vp.getPanelGestionFrutasAcidas().getBtnVolverMenuPrincipal().setActionCommand("btnVolverMenuPrincipal");
		vp.getPanelGestionFrutasAcidas().getBtnCrearProducto().setActionCommand("btnCrearFrutaAcida");
		vp.getPanelGestionFrutasAcidas().getBtnActualizarProducto().setActionCommand("btnActualizarFrutaAcida");
		vp.getPanelGestionFrutasAcidas().getBtnEliminarProducto().setActionCommand("btnEliminarFrutaAcida");

		vp.getPanelGestionFrutasAcidas().getBtnVolverMenuPrincipal().addActionListener(this);
		vp.getPanelGestionFrutasAcidas().getBtnCrearProducto().addActionListener(this);
		vp.getPanelGestionFrutasAcidas().getBtnActualizarProducto().addActionListener(this);
		vp.getPanelGestionFrutasAcidas().getBtnEliminarProducto().addActionListener(this);

		// Panel Creación Fruta Ácida
		vp.getPanelCreacionFrutaAcida().getBtnVolverMenuGestion().setActionCommand("btnVolverMenuGestionFrutasAcidas");
		vp.getPanelCreacionFrutaAcida().getBtnAgregarProducto().setActionCommand("btnAgregarFrutaAcida");

		vp.getPanelCreacionFrutaAcida().getBtnVolverMenuGestion().addActionListener(this);
		vp.getPanelCreacionFrutaAcida().getBtnAgregarProducto().addActionListener(this);

		// Panel Actualización Fruta Ácida
		vp.getPanelActualizacionFrutaAcida().getBtnVolverMenuGestion()
				.setActionCommand("btnVolverMenuGestionFrutasAcidas");
		vp.getPanelActualizacionFrutaAcida().getBtnAgregarProducto().setActionCommand("btnModificarFrutaAcida");

		vp.getPanelActualizacionFrutaAcida().getBtnVolverMenuGestion().addActionListener(this);
		vp.getPanelActualizacionFrutaAcida().getBtnAgregarProducto().addActionListener(this);

		// Panel Gestión Verduras
		vp.getPanelGestionVerduras().getBtnVolverMenuPrincipal().setActionCommand("btnVolverMenuPrincipal");
		vp.getPanelGestionVerduras().getBtnCrearProducto().setActionCommand("btnCrearVerdura");
		vp.getPanelGestionVerduras().getBtnActualizarProducto().setActionCommand("btnActualizarVerdura");
		vp.getPanelGestionVerduras().getBtnEliminarProducto().setActionCommand("btnEliminarVerdura");

		vp.getPanelGestionVerduras().getBtnVolverMenuPrincipal().addActionListener(this);
		vp.getPanelGestionVerduras().getBtnCrearProducto().addActionListener(this);
		vp.getPanelGestionVerduras().getBtnActualizarProducto().addActionListener(this);
		vp.getPanelGestionVerduras().getBtnEliminarProducto().addActionListener(this);

		// Panel Crear Verdura
		vp.getPanelCreacionVerdura().getBtnVolverMenuGestion().setActionCommand("btnVolverMenuGestionVerduras");
		vp.getPanelCreacionVerdura().getBtnAgregarProducto().setActionCommand("btnAgregarVerdura");

		vp.getPanelCreacionVerdura().getBtnVolverMenuGestion().addActionListener(this);
		vp.getPanelCreacionVerdura().getBtnAgregarProducto().addActionListener(this);

		// Panel Actualizar Verdura
		vp.getPanelActualizacionVerdura().getBtnVolverMenuGestion().setActionCommand("btnVolverMenuGestionVerduras");
		vp.getPanelActualizacionVerdura().getBtnAgregarProducto().setActionCommand("btnModificarVerdura");

		vp.getPanelActualizacionVerdura().getBtnVolverMenuGestion().addActionListener(this);
		vp.getPanelActualizacionVerdura().getBtnAgregarProducto().addActionListener(this);

		// Panel Gestión Comida Chatarra
		vp.getPanelGestionComidaChatarra().getBtnVolverMenuPrincipal().setActionCommand("btnVolverMenuPrincipal");
		vp.getPanelGestionComidaChatarra().getBtnCrearProducto().setActionCommand("btnCrearComidaChatarra");
		vp.getPanelGestionComidaChatarra().getBtnActualizarProducto().setActionCommand("btnActualizarComidaChatarra");
		vp.getPanelGestionComidaChatarra().getBtnEliminarProducto().setActionCommand("btnEliminarComidaChatarra");

		vp.getPanelGestionComidaChatarra().getBtnVolverMenuPrincipal().addActionListener(this);
		vp.getPanelGestionComidaChatarra().getBtnCrearProducto().addActionListener(this);
		vp.getPanelGestionComidaChatarra().getBtnActualizarProducto().addActionListener(this);
		vp.getPanelGestionComidaChatarra().getBtnEliminarProducto().addActionListener(this);

		// Panel Creación Comida Chatarra
		vp.getPanelCreacionComidaChatarra().getBtnVolverMenuGestion()
				.setActionCommand("btnVolverMenuGestionComidaChatarra");
		vp.getPanelCreacionComidaChatarra().getBtnAgregarProducto().setActionCommand("btnAgregarComidaChatarra");

		vp.getPanelCreacionComidaChatarra().getBtnVolverMenuGestion().addActionListener(this);
		vp.getPanelCreacionComidaChatarra().getBtnAgregarProducto().addActionListener(this);
		
		// Panel Actualización Comida Chatarra
		vp.getPanelActualizacionComidaChatarra().getBtnVolverMenuGestion().setActionCommand("btnVolverMenuGestionComidaChatarra");
		vp.getPanelActualizacionComidaChatarra().getBtnAgregarProducto().setActionCommand("btnModificarComidaChatarra");
		
		vp.getPanelActualizacionComidaChatarra().getBtnVolverMenuGestion().addActionListener(this);
		vp.getPanelActualizacionComidaChatarra().getBtnAgregarProducto().addActionListener(this);

	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();

		switch (comando) {

		// Panel Menú Principal
		case "btnGestionarCarnesFrias":
			vp.getPanelGestionCarnesFrias().actualizarTabla(gestionProductos.getGestionCarnesFrias().obtenerObjetos());
			vp.mostrarPanelGestionCarnesFrias();
			break;
		case "btnGestionarProductosLacteos":
			vp.mostrarPanelGestionProductosLacteos();
			break;
		case "btnGestionarProductosAnimalesNoLacteos":
			vp.mostrarPanelGestionProductosAnimalesNoLacteos();
			break;
		case "btnGestionarFrutasDulces":
			vp.mostrarPanelGestionFrutasDulces();
			break;
		case "btnGestionarFrutasAcidas":
			vp.mostrarPanelGestionFrutasAcidas();
			break;
		case "btnGestionarVerduras":
			vp.mostrarPanelGestionVerduras();
			break;
		case "btnGestionarComidaChatarra":
			vp.mostrarPanelGestionComidaChatarra();
			break;

		// Paneles de Gestión
		case "btnVolverMenuPrincipal":
			vp.mostrarPanelMenuPrincipal();
			break;

		// Panel Gestión Carnes Frías
		case "btnCrearCarneFria":
			vp.mostrarPanelCreacionCarneFria();
			break;
		case "btnActualizarCarneFria":
			if (vp.getPanelGestionCarnesFrias().validarFilaSeleccionadaTabla()) {
				CarneFria carneFria = gestionProductos.getGestionCarnesFrias().getListaObjetos()
						.get(vp.getPanelGestionCarnesFrias().obtenerFilaSeleccionadaTabla());
				vp.getPanelActualizacionCarneFria().llenarEntradas(carneFria.getNombre(), carneFria.getPrecio(),
						carneFria.getProveedor(), carneFria.getCantidad(), carneFria.obtenerFechaCaducidadCalendario(),
						carneFria.getTipo(), carneFria.getOrigen());
				gestionProductos.getGestionCarnesFrias().setIndiceAActualizar(carneFria);
				vp.mostrarPanelActualizacionCarneFria();
			}
			break;
		case "btnEliminarCarneFria":
			if (vp.getPanelGestionCarnesFrias().validarFilaSeleccionadaTabla()
					&& vp.getPanelGestionCarnesFrias().confirmarEliminacionFilaSeleccionada()) {
				gestionProductos.getGestionCarnesFrias()
						.eliminar(vp.getPanelGestionCarnesFrias().obtenerFilaSeleccionadaTabla());
				vp.getPanelGestionCarnesFrias()
						.actualizarTabla(gestionProductos.getGestionCarnesFrias().obtenerObjetos());
				vp.getPanelGestionCarnesFrias()
						.mostrarMensaje("El producto de carne fría ha sido eliminado exitosamente");
			}
			break;

		// Panel Creación Carne Fría o Panel Actualización Carne Fría
		case "btnVolverMenuGestionCarnesFrias":
			vp.mostrarPanelGestionCarnesFrias();
			break;

		// Panel Creación Carne Fría
		case "btnAgregarCarneFria":
			if (vp.getPanelCreacionCarneFria().validarEntradas()) {
				gestionProductos.getGestionCarnesFrias()
						.agregar(new CarneFria(vp.getPanelCreacionCarneFria().getTxtNombre().getText(),
								Double.parseDouble(vp.getPanelCreacionCarneFria().getTxtPrecio().getText()),
								Integer.parseInt(vp.getPanelCreacionCarneFria().getTxtCantidad().getText()),
								vp.getPanelCreacionCarneFria().obtenerFechaFormateada(),
								vp.getPanelCreacionCarneFria().getTxtProveedor().getText(),
								vp.getPanelCreacionCarneFria().getSeleccionableTipo().getSelectedItem().toString(),
								vp.getPanelCreacionCarneFria().getSeleccionableOrigen().getSelectedItem().toString()));
				vp.getPanelGestionCarnesFrias()
						.actualizarTabla(gestionProductos.getGestionCarnesFrias().obtenerObjetos());
				vp.mostrarPanelGestionCarnesFrias();
				vp.getPanelGestionCarnesFrias()
						.mostrarMensaje("El producto de carne fría ha sido agregado exitosamente");
			}
			break;

		// Panel Actualización Carne Fría
		case "btnModificarCarneFria":
			if (vp.getPanelActualizacionCarneFria().validarEntradas()) {
				gestionProductos.getGestionCarnesFrias().actualizar(
						gestionProductos.getGestionCarnesFrias().getIndiceAActualizar(),
						new CarneFria(vp.getPanelActualizacionCarneFria().getTxtNombre().getText(),
								Double.parseDouble(vp.getPanelActualizacionCarneFria().getTxtPrecio().getText()),
								Integer.parseInt(vp.getPanelActualizacionCarneFria().getTxtCantidad().getText()),
								vp.getPanelActualizacionCarneFria().obtenerFechaFormateada(),
								vp.getPanelActualizacionCarneFria().getTxtProveedor().getText(),
								vp.getPanelActualizacionCarneFria().getSeleccionableTipo().getSelectedItem().toString(),
								vp.getPanelActualizacionCarneFria().getSeleccionableOrigen().getSelectedItem()
										.toString()));
				vp.getPanelGestionCarnesFrias()
						.actualizarTabla(gestionProductos.getGestionCarnesFrias().obtenerObjetos());
				vp.mostrarPanelGestionCarnesFrias();
				vp.getPanelGestionCarnesFrias()
						.mostrarMensaje("El producto de carne fría ha sido actualizado exitosamente");
			}
			break;

		// Panel Gestión Productos Lácteos
		case "btnCrearProductoLacteo":
			vp.mostrarPanelCreacionProductoLacteo();
			break;
		case "btnActualizarProductoLacteo":
			if (vp.getPanelGestionProductosLacteos().validarFilaSeleccionadaTabla()) {
				ProductoLacteo productoLacteo = gestionProductos.getGestionProductosLacteos().getListaObjetos()
						.get(vp.getPanelGestionProductosLacteos().obtenerFilaSeleccionadaTabla());
				vp.getPanelActualizacionProductoLacteo().llenarEntradas(productoLacteo.getNombre(),
						productoLacteo.getPrecio(), productoLacteo.getProveedor(), productoLacteo.getCantidad(),
						productoLacteo.obtenerFechaCaducidadCalendario(), productoLacteo.getTipo());
				gestionProductos.getGestionProductosLacteos().setIndiceAActualizar(productoLacteo);
				vp.mostrarPanelActualizacionProductoLacteo();
			}
			break;
		case "btnEliminarProductoLacteo":
			if (vp.getPanelGestionProductosLacteos().validarFilaSeleccionadaTabla()
					&& vp.getPanelGestionProductosLacteos().confirmarEliminacionFilaSeleccionada()) {
				gestionProductos.getGestionProductosLacteos()
						.eliminar(vp.getPanelGestionProductosLacteos().obtenerFilaSeleccionadaTabla());
				vp.getPanelGestionProductosLacteos()
						.actualizarTabla(gestionProductos.getGestionProductosLacteos().obtenerObjetos());
				vp.getPanelGestionProductosLacteos()
						.mostrarMensaje("El producto lácteo ha sido eliminado exitosamente");
			}
			break;

		// Panel Creación Producto Lácteo o Panel Actualización Productos Lácteos
		case "btnVolverMenuGestionProductosLacteos":
			vp.mostrarPanelGestionProductosLacteos();
			break;

		// Panel Creación Producto Lácteo
		case "btnAgregarProductoLacteo":
			if (vp.getPanelCreacionProductoLacteo().validarEntradas()) {
				gestionProductos.getGestionProductosLacteos().agregar(new ProductoLacteo(
						vp.getPanelCreacionProductoLacteo().getTxtNombre().getText(),
						Double.parseDouble(vp.getPanelCreacionProductoLacteo().getTxtPrecio().getText()),
						Integer.parseInt(vp.getPanelCreacionProductoLacteo().getTxtCantidad().getText()),
						vp.getPanelCreacionProductoLacteo().obtenerFechaFormateada(),
						vp.getPanelCreacionProductoLacteo().getTxtProveedor().getText(),
						vp.getPanelCreacionProductoLacteo().getSeleccionableTipo().getSelectedItem().toString()));
				vp.getPanelGestionProductosLacteos()
						.actualizarTabla(gestionProductos.getGestionProductosLacteos().obtenerObjetos());
				vp.mostrarPanelGestionProductosLacteos();
				vp.getPanelGestionProductosLacteos().mostrarMensaje("El producto lácteo ha sido agregado exitosamente");
			}
			break;

		// Panel Actualización Producto Lácteo
		case "btnModificarProductoLacteo":
			if (vp.getPanelActualizacionProductoLacteo().validarEntradas()) {
				gestionProductos.getGestionProductosLacteos().actualizar(
						gestionProductos.getGestionProductosLacteos().getIndiceAActualizar(),
						new ProductoLacteo(vp.getPanelActualizacionProductoLacteo().getTxtNombre().getText(),
								Double.parseDouble(vp.getPanelActualizacionProductoLacteo().getTxtPrecio().getText()),
								Integer.parseInt(vp.getPanelActualizacionProductoLacteo().getTxtCantidad().getText()),
								vp.getPanelActualizacionProductoLacteo().obtenerFechaFormateada(),
								vp.getPanelActualizacionProductoLacteo().getTxtProveedor().getText(),
								vp.getPanelActualizacionProductoLacteo().getSeleccionableTipo().getSelectedItem()
										.toString()));
				vp.getPanelGestionProductosLacteos()
						.actualizarTabla(gestionProductos.getGestionProductosLacteos().obtenerObjetos());
				vp.mostrarPanelGestionProductosLacteos();
				vp.getPanelGestionProductosLacteos()
						.mostrarMensaje("El producto lácteo ha sido actualizado exitosamente");
			}
			break;

		// Panel Gestión Productos Animales No Lácteos
		case "btnCrearProductoAnimalNoLacteo":
			vp.mostrarPanelCreacionProductoAnimalNoLacteo();
			break;
		case "btnActualizarProductoAnimalNoLacteo":
			if (vp.getPanelGestionProductosAnimalesNoLacteos().validarFilaSeleccionadaTabla()) {
				ProductoAnimalNoLacteo productoAnimalNoLacteo = gestionProductos.getGestionProductosAnimalesNoLacteos()
						.getListaObjetos()
						.get(vp.getPanelGestionProductosAnimalesNoLacteos().obtenerFilaSeleccionadaTabla());
				vp.getPanelActualizacionProductoAnimalNoLacteo().llenarEntradas(productoAnimalNoLacteo.getNombre(),
						productoAnimalNoLacteo.getPrecio(), productoAnimalNoLacteo.getProveedor(),
						productoAnimalNoLacteo.getCantidad(), productoAnimalNoLacteo.obtenerFechaCaducidadCalendario(),
						productoAnimalNoLacteo.getTipoDeAnimal(), productoAnimalNoLacteo.getOrigen());
				gestionProductos.getGestionProductosAnimalesNoLacteos().setIndiceAActualizar(productoAnimalNoLacteo);
				vp.mostrarPanelActualizacionProductoAnimalNoLacteo();
			}
			break;
		case "btnEliminarProductoAnimalNoLacteo":
			if (vp.getPanelGestionProductosAnimalesNoLacteos().validarFilaSeleccionadaTabla()
					&& vp.getPanelGestionProductosAnimalesNoLacteos().confirmarEliminacionFilaSeleccionada()) {
				gestionProductos.getGestionProductosAnimalesNoLacteos()
						.eliminar(vp.getPanelGestionProductosAnimalesNoLacteos().obtenerFilaSeleccionadaTabla());
				vp.getPanelGestionProductosAnimalesNoLacteos()
						.actualizarTabla(gestionProductos.getGestionProductosAnimalesNoLacteos().obtenerObjetos());
				vp.getPanelGestionProductosAnimalesNoLacteos()
						.mostrarMensaje("El producto animal no lácteo ha sido eliminado exitosamente");
			}
			break;

		// Panel Creación Producto Animal No Lácteo o Panel Actualización Producto
		// Animal No Lácteo
		case "btnVolverMenuGestionProductosAnimalesNoLacteos":
			vp.mostrarPanelGestionProductosAnimalesNoLacteos();
			break;
		case "btnAgregarProductoAnimalNoLacteo":
			if (vp.getPanelCreacionProductoAnimalNoLacteo().validarEntradas()) {
				gestionProductos.getGestionProductosAnimalesNoLacteos().agregar(new ProductoAnimalNoLacteo(
						vp.getPanelCreacionProductoAnimalNoLacteo().getTxtNombre().getText(),
						Double.parseDouble(vp.getPanelCreacionProductoAnimalNoLacteo().getTxtPrecio().getText()),
						Integer.parseInt(vp.getPanelCreacionProductoAnimalNoLacteo().getTxtCantidad().getText()),
						vp.getPanelCreacionProductoAnimalNoLacteo().obtenerFechaFormateada(),
						vp.getPanelCreacionProductoAnimalNoLacteo().getTxtProveedor().getText(),
						vp.getPanelCreacionProductoAnimalNoLacteo().getSeleccionableTipoAnimal().getSelectedItem()
								.toString(),
						vp.getPanelCreacionProductoAnimalNoLacteo().getSeleccionableOrigen().getSelectedItem()
								.toString()));
				vp.getPanelGestionProductosAnimalesNoLacteos()
						.actualizarTabla(gestionProductos.getGestionProductosAnimalesNoLacteos().obtenerObjetos());
				vp.mostrarPanelGestionProductosAnimalesNoLacteos();
				vp.getPanelGestionProductosAnimalesNoLacteos()
						.mostrarMensaje("El producto animal no lácteo ha sido agregado exitosamente");
			}
			break;

		// Panel Actualización Producto Animal No Lácteo
		case "btnModificarProductoAnimalNoLacteo":
			if (vp.getPanelActualizacionProductoAnimalNoLacteo().validarEntradas()) {
				gestionProductos.getGestionProductosAnimalesNoLacteos().actualizar(
						gestionProductos.getGestionProductosAnimalesNoLacteos().getIndiceAActualizar(),
						new ProductoAnimalNoLacteo(
								vp.getPanelActualizacionProductoAnimalNoLacteo().getTxtNombre().getText(),
								Double.parseDouble(
										vp.getPanelActualizacionProductoAnimalNoLacteo().getTxtPrecio().getText()),
								Integer.parseInt(
										vp.getPanelActualizacionProductoAnimalNoLacteo().getTxtCantidad().getText()),
								vp.getPanelActualizacionProductoAnimalNoLacteo().obtenerFechaFormateada(),
								vp.getPanelActualizacionProductoAnimalNoLacteo().getTxtProveedor().getText(),
								vp.getPanelActualizacionProductoAnimalNoLacteo().getSeleccionableTipoAnimal()
										.getSelectedItem().toString(),
								vp.getPanelActualizacionProductoAnimalNoLacteo().getSeleccionableOrigen()
										.getSelectedItem().toString()));
				vp.getPanelGestionProductosAnimalesNoLacteos()
						.actualizarTabla(gestionProductos.getGestionProductosAnimalesNoLacteos().obtenerObjetos());
				vp.mostrarPanelGestionProductosAnimalesNoLacteos();
				vp.getPanelGestionProductosAnimalesNoLacteos()
						.mostrarMensaje("El producto animal no lácteo ha sido actualizado exitosamente");
			}
			break;

		// Panel Gestión Frutas Dulces
		case "btnCrearFrutaDulce":
			vp.mostrarPanelCreacionFrutaDulce();
			break;
		case "btnActualizarFrutaDulce":
			if (vp.getPanelGestionFrutasDulces().validarFilaSeleccionadaTabla()) {
				FrutaDulce frutaDulce = gestionProductos.getGestionFrutasDulces().getListaObjetos()
						.get(vp.getPanelGestionFrutasDulces().obtenerFilaSeleccionadaTabla());
				vp.getPanelActualizacionFrutaDulce().llenarEntradas(frutaDulce.getNombre(), frutaDulce.getPrecio(),
						frutaDulce.getProveedor(), frutaDulce.getCantidad(),
						frutaDulce.obtenerFechaCaducidadCalendario(), frutaDulce.isEsOrganica(),
						frutaDulce.getIntensidadDulce());
				gestionProductos.getGestionFrutasDulces().setIndiceAActualizar(frutaDulce);
				vp.mostrarPanelActualizacionFrutaDulce();
			}
			break;
		case "btnEliminarFrutaDulce":
			if (vp.getPanelGestionFrutasDulces().validarFilaSeleccionadaTabla()
					&& vp.getPanelGestionFrutasDulces().confirmarEliminacionFilaSeleccionada()) {
				gestionProductos.getGestionFrutasDulces()
						.eliminar(vp.getPanelGestionFrutasDulces().obtenerFilaSeleccionadaTabla());
				vp.getPanelGestionFrutasDulces()
						.actualizarTabla(gestionProductos.getGestionFrutasDulces().obtenerObjetos());
				vp.getPanelGestionFrutasDulces().mostrarMensaje("La fruta dulce ha sido eliminada exitosamente");
			}
			break;

		// Panel Creación Fruta Dulce
		case "btnVolverMenuGestionFrutasDulces":
			vp.mostrarPanelGestionFrutasDulces();
			break;
		case "btnAgregarFrutaDulce":
			if (vp.getPanelCreacionFrutaDulce().validarEntradas()) {
				gestionProductos.getGestionFrutasDulces().agregar(new FrutaDulce(
						vp.getPanelCreacionFrutaDulce().getTxtNombre().getText(),
						Double.parseDouble(vp.getPanelCreacionFrutaDulce().getTxtPrecio().getText()),
						Integer.parseInt(vp.getPanelCreacionFrutaDulce().getTxtCantidad().getText()),
						vp.getPanelCreacionFrutaDulce().obtenerFechaFormateada(),
						vp.getPanelCreacionFrutaDulce().getTxtProveedor().getText(),
						vp.getPanelCreacionFrutaDulce().getSeleccionableEsOrganica().getSelectedItem().toString()
								.equals("Si") ? true : false,
						vp.getPanelCreacionFrutaDulce().getSeleccionableIntensidad().getSelectedItem().toString()));
				vp.getPanelGestionFrutasDulces()
						.actualizarTabla(gestionProductos.getGestionFrutasDulces().obtenerObjetos());
				vp.mostrarPanelGestionFrutasDulces();
				vp.getPanelGestionFrutasDulces().mostrarMensaje("La fruta dulce ha sido agregada exitosamente");
			}
			break;

		// Panel Actualización Fruta Dulce
		case "btnModificarFrutaDulce":
			if (vp.getPanelActualizacionFrutaDulce().validarEntradas()) {
				gestionProductos.getGestionFrutasDulces().actualizar(
						gestionProductos.getGestionFrutasDulces().getIndiceAActualizar(),
						new FrutaDulce(vp.getPanelActualizacionFrutaDulce().getTxtNombre().getText(),
								Double.parseDouble(vp.getPanelActualizacionFrutaDulce().getTxtPrecio().getText()),
								Integer.parseInt(vp.getPanelActualizacionFrutaDulce().getTxtCantidad().getText()),
								vp.getPanelActualizacionFrutaDulce().obtenerFechaFormateada(),
								vp.getPanelActualizacionFrutaDulce().getTxtProveedor().getText(),
								vp.getPanelActualizacionFrutaDulce().getSeleccionableEsOrganica().getSelectedItem()
										.toString().equals("Si") ? true : false,
								vp.getPanelActualizacionFrutaDulce().getSeleccionableIntensidad().getSelectedItem()
										.toString()));
				vp.getPanelGestionFrutasDulces()
						.actualizarTabla(gestionProductos.getGestionFrutasDulces().obtenerObjetos());
				vp.mostrarPanelGestionFrutasDulces();
				vp.getPanelGestionFrutasDulces().mostrarMensaje("La fruta dulce ha sido actualizada exitosamente");
			}
			break;

		// Panel Gestión Frutas Ácidas
		case "btnCrearFrutaAcida":
			vp.mostrarPanelCreacionFrutaAcida();
			break;
		case "btnActualizarFrutaAcida":
			if (vp.getPanelGestionFrutasAcidas().validarFilaSeleccionadaTabla()) {
				FrutaAcida frutaAcida = gestionProductos.getGestionFrutasAcidas().getListaObjetos()
						.get(vp.getPanelGestionFrutasAcidas().obtenerFilaSeleccionadaTabla());
				vp.getPanelActualizacionFrutaAcida().llenarEntradas(frutaAcida.getNombre(), frutaAcida.getPrecio(),
						frutaAcida.getProveedor(), frutaAcida.getCantidad(),
						frutaAcida.obtenerFechaCaducidadCalendario(), frutaAcida.isEsOrganica(),
						frutaAcida.getIntensidadAcido());
				gestionProductos.getGestionFrutasAcidas().setIndiceAActualizar(frutaAcida);
				vp.mostrarPanelActualizacionFrutaAcida();
			}
			break;

		// Panel Creación Fruta Ácida
		case "btnVolverMenuGestionFrutasAcidas":
			vp.mostrarPanelGestionFrutasAcidas();
			break;
		case "btnAgregarFrutaAcida":
			if (vp.getPanelCreacionFrutaAcida().validarEntradas()) {
				gestionProductos.getGestionFrutasAcidas().agregar(new FrutaAcida(
						vp.getPanelCreacionFrutaAcida().getTxtNombre().getText(),
						Double.parseDouble(vp.getPanelCreacionFrutaAcida().getTxtPrecio().getText()),
						Integer.parseInt(vp.getPanelCreacionFrutaAcida().getTxtCantidad().getText()),
						vp.getPanelCreacionFrutaAcida().obtenerFechaFormateada(),
						vp.getPanelCreacionFrutaAcida().getTxtProveedor().getText(),
						vp.getPanelCreacionFrutaAcida().getSeleccionableEsOrganica().getSelectedItem().toString()
								.equals("Si") ? true : false,
						vp.getPanelCreacionFrutaAcida().getSeleccionableIntensidad().getSelectedItem().toString()));
				vp.getPanelGestionFrutasAcidas()
						.actualizarTabla(gestionProductos.getGestionFrutasAcidas().obtenerObjetos());
				vp.mostrarPanelGestionFrutasAcidas();
				vp.getPanelGestionFrutasAcidas().mostrarMensaje("La fruta ácida ha sido agregada exitosamente");
			}
			break;
		case "btnEliminarFrutaAcida":
			if (vp.getPanelGestionFrutasAcidas().validarFilaSeleccionadaTabla()
					&& vp.getPanelGestionFrutasAcidas().confirmarEliminacionFilaSeleccionada()) {
				gestionProductos.getGestionFrutasAcidas()
						.eliminar(vp.getPanelGestionFrutasAcidas().obtenerFilaSeleccionadaTabla());
				vp.getPanelGestionFrutasAcidas()
						.actualizarTabla(gestionProductos.getGestionFrutasAcidas().obtenerObjetos());
				vp.getPanelGestionFrutasAcidas().mostrarMensaje("La fruta ácida ha sido eliminada exitosamente");
			}
			break;

		// Panel Modificación Fruta Ácida
		case "btnModificarFrutaAcida":
			if (vp.getPanelActualizacionFrutaAcida().validarEntradas()) {
				gestionProductos.getGestionFrutasAcidas().actualizar(
						gestionProductos.getGestionFrutasAcidas().getIndiceAActualizar(),
						new FrutaAcida(vp.getPanelActualizacionFrutaAcida().getTxtNombre().getText(),
								Double.parseDouble(vp.getPanelActualizacionFrutaAcida().getTxtPrecio().getText()),
								Integer.parseInt(vp.getPanelActualizacionFrutaAcida().getTxtCantidad().getText()),
								vp.getPanelActualizacionFrutaAcida().obtenerFechaFormateada(),
								vp.getPanelActualizacionFrutaAcida().getTxtProveedor().getText(),
								vp.getPanelActualizacionFrutaAcida().getSeleccionableEsOrganica().getSelectedItem()
										.toString().equals("Si") ? true : false,
								vp.getPanelActualizacionFrutaAcida().getSeleccionableIntensidad().getSelectedItem()
										.toString()));
				vp.getPanelGestionFrutasAcidas()
						.actualizarTabla(gestionProductos.getGestionFrutasAcidas().obtenerObjetos());
				vp.mostrarPanelGestionFrutasAcidas();
				vp.getPanelGestionFrutasAcidas().mostrarMensaje("La fruta ácida ha sido actualizada exitosamente");
			}
			break;

		// Panel Gestión Verduras
		case "btnCrearVerdura":
			vp.mostrarPanelCreacionVerdura();
			break;
		case "btnActualizarVerdura":
			if (vp.getPanelGestionVerduras().validarFilaSeleccionadaTabla()) {
				Verdura verdura = gestionProductos.getGestionVerduras().getListaObjetos()
						.get(vp.getPanelGestionVerduras().obtenerFilaSeleccionadaTabla());
				vp.getPanelActualizacionVerdura().llenarEntradas(verdura.getNombre(), verdura.getPrecio(),
						verdura.getProveedor(), verdura.getCantidad(), verdura.obtenerFechaCaducidadCalendario());
				gestionProductos.getGestionVerduras().setIndiceAActualizar(verdura);
				vp.mostrarPanelActualizacionVerdura();
			}
			break;
		case "btnEliminarVerdura":
			if (vp.getPanelGestionVerduras().validarFilaSeleccionadaTabla()
					&& vp.getPanelGestionVerduras().confirmarEliminacionFilaSeleccionada()) {
				gestionProductos.getGestionVerduras()
						.eliminar(vp.getPanelGestionVerduras().obtenerFilaSeleccionadaTabla());
				vp.getPanelGestionVerduras().actualizarTabla(gestionProductos.getGestionVerduras().obtenerObjetos());
				vp.getPanelGestionVerduras().mostrarMensaje("La verdura ha sido eliminada exitosamente");
			}
			break;

		// Panel Creación Verdura
		case "btnVolverMenuGestionVerduras":
			vp.mostrarPanelGestionVerduras();
			break;
		case "btnAgregarVerdura":
			if (vp.getPanelCreacionVerdura().validarEntradas()) {
				gestionProductos.getGestionVerduras()
						.agregar(new Verdura(vp.getPanelCreacionVerdura().getTxtNombre().getText(),
								Double.parseDouble(vp.getPanelCreacionVerdura().getTxtPrecio().getText()),
								Integer.parseInt(vp.getPanelCreacionVerdura().getTxtCantidad().getText()),
								vp.getPanelCreacionVerdura().obtenerFechaFormateada(),
								vp.getPanelCreacionVerdura().getTxtProveedor().getText()));
				vp.getPanelGestionVerduras().actualizarTabla(gestionProductos.getGestionVerduras().obtenerObjetos());
				vp.mostrarPanelGestionVerduras();
				vp.getPanelGestionVerduras().mostrarMensaje("La verdura ha sido agregada exitosamente");
			}
			break;

		// Panel Actualización Verdura
		case "btnModificarVerdura":
			if (vp.getPanelActualizacionVerdura().validarEntradas()) {
				gestionProductos.getGestionVerduras().actualizar(
						gestionProductos.getGestionVerduras().getIndiceAActualizar(),
						new Verdura(vp.getPanelActualizacionVerdura().getTxtNombre().getText(),
								Double.parseDouble(vp.getPanelActualizacionVerdura().getTxtPrecio().getText()),
								Integer.parseInt(vp.getPanelActualizacionVerdura().getTxtCantidad().getText()),
								vp.getPanelActualizacionVerdura().obtenerFechaFormateada(),
								vp.getPanelActualizacionVerdura().getTxtProveedor().getText()));
				vp.getPanelGestionVerduras().actualizarTabla(gestionProductos.getGestionVerduras().obtenerObjetos());
				vp.mostrarPanelGestionVerduras();
				vp.getPanelGestionVerduras().mostrarMensaje("La verdura ha sido actualizada exitosamente");
			}
			break;

		// Panel Gestión Comida Chatarra
		case "btnCrearComidaChatarra":
			vp.mostrarPanelCreacionComidaChatarra();
			break;
		case "btnActualizarComidaChatarra":
			if (vp.getPanelGestionComidaChatarra().validarFilaSeleccionadaTabla()) {
				ComidaChatarra comidaChatarra = gestionProductos.getGestionComidasChatarra().getListaObjetos()
						.get(vp.getPanelGestionComidaChatarra().obtenerFilaSeleccionadaTabla());
				vp.getPanelActualizacionComidaChatarra().llenarEntradas(comidaChatarra.getNombre(), comidaChatarra.getPrecio(),
						comidaChatarra.getProveedor(), comidaChatarra.getCantidad(), comidaChatarra.obtenerFechaCaducidadCalendario());
				gestionProductos.getGestionComidasChatarra().setIndiceAActualizar(comidaChatarra);
				vp.mostrarPanelActualizacionComidaChatarra();
			}
			break;
		case "btnEliminarComidaChatarra":
			if (vp.getPanelGestionComidaChatarra().validarFilaSeleccionadaTabla()
					&& vp.getPanelGestionComidaChatarra().confirmarEliminacionFilaSeleccionada()) {
				gestionProductos.getGestionComidasChatarra()
						.eliminar(vp.getPanelGestionComidaChatarra().obtenerFilaSeleccionadaTabla());
				vp.getPanelGestionComidaChatarra().actualizarTabla(gestionProductos.getGestionComidasChatarra().obtenerObjetos());
				vp.getPanelGestionComidaChatarra().mostrarMensaje("La comida chatarra ha sido eliminada exitosamente");
			}
			break;

		// Panel Creación Comida Chatarra
		case "btnVolverMenuGestionComidaChatarra":
			vp.mostrarPanelGestionComidaChatarra();
			break;
		case "btnAgregarComidaChatarra":
			if (vp.getPanelCreacionComidaChatarra().validarEntradas()) {
				gestionProductos.getGestionComidasChatarra()
						.agregar(new ComidaChatarra(vp.getPanelCreacionComidaChatarra().getTxtNombre().getText(),
								Double.parseDouble(vp.getPanelCreacionComidaChatarra().getTxtPrecio().getText()),
								Integer.parseInt(vp.getPanelCreacionComidaChatarra().getTxtCantidad().getText()),
								vp.getPanelCreacionComidaChatarra().obtenerFechaFormateada(),
								vp.getPanelCreacionComidaChatarra().getTxtProveedor().getText()));
				vp.getPanelGestionComidaChatarra()
						.actualizarTabla(gestionProductos.getGestionComidasChatarra().obtenerObjetos());
				vp.mostrarPanelGestionComidaChatarra();
				vp.getPanelGestionComidaChatarra().mostrarMensaje("La comida chatarra ha sido agregada exitosamente");
			}
			break;
		
		// Panel Actualización Comida Chatarra
		case "btnModificarComidaChatarra":
			if (vp.getPanelActualizacionComidaChatarra().validarEntradas()) {
				gestionProductos.getGestionComidasChatarra().actualizar(
						gestionProductos.getGestionComidasChatarra().getIndiceAActualizar(),
						new ComidaChatarra(vp.getPanelActualizacionComidaChatarra().getTxtNombre().getText(),
								Double.parseDouble(vp.getPanelActualizacionComidaChatarra().getTxtPrecio().getText()),
								Integer.parseInt(vp.getPanelActualizacionComidaChatarra().getTxtCantidad().getText()),
								vp.getPanelActualizacionComidaChatarra().obtenerFechaFormateada(),
								vp.getPanelActualizacionComidaChatarra().getTxtProveedor().getText()));
				vp.getPanelGestionComidaChatarra().actualizarTabla(gestionProductos.getGestionComidasChatarra().obtenerObjetos());
				vp.mostrarPanelGestionComidaChatarra();
				vp.getPanelGestionComidaChatarra().mostrarMensaje("La comida chatarra ha sido actualizada exitosamente");
			}
			break;

		}

	}

}
