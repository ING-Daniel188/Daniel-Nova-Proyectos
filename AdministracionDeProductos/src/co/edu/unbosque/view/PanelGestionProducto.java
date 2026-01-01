package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * The Class PanelGestionProducto.
 */
public abstract class PanelGestionProducto extends PanelBase {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The label titulo. */
	protected JLabel labelTitulo;
	
	/** The modelo tabla. */
	protected DefaultTableModel modeloTabla;
	
	/** The tabla productos. */
	protected JTable tablaProductos;
	
	/** The modelo columnas. */
	protected TableColumnModel modeloColumnas;
	
	/** The scroll pane. */
	protected JScrollPane scrollPane;
	
	/** The btn volver menu principal. */
	protected JButton btnVolverMenuPrincipal;
	
	/** The btn crear producto. */
	protected JButton btnCrearProducto;
	
	/** The btn actualizar producto. */
	protected JButton btnActualizarProducto;
	
	/** The btn eliminar producto. */
	protected JButton btnEliminarProducto;
	
	
	/**
	 * Instantiates a new panel gestion producto.
	 */
	protected PanelGestionProducto() {
		labelTitulo = new JLabel("Gestionar Producto");
		labelTitulo.setFont(super.getFuenteNegrilla());
		labelTitulo.setBounds(340, 40, 280, 25);
		add(labelTitulo);
		
		String[] columnas = {
				"Nombre",
				"Categoría",
				"Precio",
				"Cantidad",
				"Fecha Caducidad",
				"Proveedor"
		};
		
		modeloTabla = new DefaultTableModel(columnas, 0);
		
		tablaProductos = new JTable(modeloTabla);
		
		// Hacer que la tabla no sea editable
		tablaProductos.setDefaultEditor(Object.class, null);
		
		// Prohibir la reordenación de columnas
		tablaProductos.getTableHeader().setReorderingAllowed(false);
		
		modeloColumnas = tablaProductos.getColumnModel();
		
		scrollPane = new JScrollPane(tablaProductos);
		scrollPane.setBounds(30, 100, 922, 380);
		add(scrollPane);
		
		btnVolverMenuPrincipal = new JButton("Volver al Menú Principal");
		btnVolverMenuPrincipal.setFont(super.getFuentePlana());
		btnVolverMenuPrincipal.setFocusable(false);
		btnVolverMenuPrincipal.setBounds(30, 510, 400, 50);
		add(btnVolverMenuPrincipal);
		
		btnCrearProducto = new JButton("Crear Producto");
		btnCrearProducto.setFont(super.getFuentePlana());
		btnCrearProducto.setFocusable(false);
		btnCrearProducto.setBounds(550, 510, 400, 50);
		add(btnCrearProducto);
		
		btnActualizarProducto = new JButton("Actualizar Producto");
		btnActualizarProducto.setFont(super.getFuentePlana());
		btnActualizarProducto.setFocusable(false);
		btnActualizarProducto.setBounds(30, 580, 400, 50);
		add(btnActualizarProducto);
		
		btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setFont(super.getFuentePlana());
		btnEliminarProducto.setFocusable(false);
		btnEliminarProducto.setBounds(550, 580, 400, 50);
		add(btnEliminarProducto);
		
	}
	
	/**
	 * Actualizar tabla.
	 *
	 * @param objetos the objetos
	 */
	public void actualizarTabla(Object[][] objetos) {
		
		getTablaProductos().removeAll();
//		while (getTablaProductos().getRowCount() > 0) getModeloTabla().removeRow(0);
		
		for (int i = 0; i < objetos.length; i++) {
			getModeloTabla().addRow(objetos[i]);
		}
	}
	
	/**
	 * Validar fila seleccionada tabla.
	 *
	 * @return true, if successful
	 */
	public boolean validarFilaSeleccionadaTabla() {
		
		if (tablaProductos.getRowCount() == 0) {
			super.mostrarMensaje("No se han agregado productos");
			return false;
		}
		
		if (tablaProductos.getSelectedRow() == -1) {
			super.mostrarMensajeError("No se ha seleccionado la fila del producto a actualizar");
			return false;
		}
		return true;
	}
	
	/**
	 * Confirmar eliminacion fila seleccionada.
	 *
	 * @return true, if successful
	 */
	public boolean confirmarEliminacionFilaSeleccionada() {
		if (super.confirmarMensaje("Está seguro de que desea eliminar el producto seleccionado?")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Obtener fila seleccionada tabla.
	 *
	 * @return the int
	 */
	public int obtenerFilaSeleccionadaTabla() {
		return tablaProductos.getSelectedRow();
	}
	
	/**
	 * Actualizar ancho columnas.
	 */
	public void actualizarAnchoColumnas() {
		modeloColumnas.getColumn(2).setPreferredWidth(30);
		modeloColumnas.getColumn(3).setPreferredWidth(10);
		modeloColumnas.getColumn(4).setPreferredWidth(50);
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
	 * Gets the btn volver menu principal.
	 *
	 * @return the btn volver menu principal
	 */
	public JButton getBtnVolverMenuPrincipal() {
		return btnVolverMenuPrincipal;
	}

	/**
	 * Gets the btn crear producto.
	 *
	 * @return the btn crear producto
	 */
	public JButton getBtnCrearProducto() {
		return btnCrearProducto;
	}

	/**
	 * Gets the btn actualizar producto.
	 *
	 * @return the btn actualizar producto
	 */
	public JButton getBtnActualizarProducto() {
		return btnActualizarProducto;
	}

	/**
	 * Gets the btn eliminar producto.
	 *
	 * @return the btn eliminar producto
	 */
	public JButton getBtnEliminarProducto() {
		return btnEliminarProducto;
	}

	/**
	 * Gets the tabla productos.
	 *
	 * @return the tabla productos
	 */
	public JTable getTablaProductos() {
		return tablaProductos;
	}

	/**
	 * Gets the modelo tabla.
	 *
	 * @return the modelo tabla
	 */
	protected DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	/**
	 * Gets the modelo columnas.
	 *
	 * @return the modelo columnas
	 */
	protected TableColumnModel getModeloColumnas() {
		return modeloColumnas;
	}
	
}
