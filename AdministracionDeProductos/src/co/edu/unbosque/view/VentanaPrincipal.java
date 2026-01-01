package co.edu.unbosque.view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The Class VentanaPrincipal.
 */
public class VentanaPrincipal extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The card layout. */
	private CardLayout cardLayout;
	
	/** The card panel. */
	private JPanel cardPanel;
	
	/** The panel menu principal. */
	private PanelMenuPrincipal panelMenuPrincipal;
	
	/** The panel gestion carnes frias. */
	private PanelGestionCarnesFrias panelGestionCarnesFrias;
	
	/** The panel creacion carne fria. */
	private PanelCreacionCarneFria panelCreacionCarneFria;
	
	/** The panel actualizacion carne fria. */
	private PanelActualizacionCarneFria panelActualizacionCarneFria;
	
	/** The panel gestion productos lacteos. */
	private PanelGestionProductosLacteos panelGestionProductosLacteos;
	
	/** The panel creacion producto lacteo. */
	private PanelCreacionProductoLacteo panelCreacionProductoLacteo;
	
	/** The panel actualizacion producto lacteo. */
	private PanelActualizacionProductoLacteo panelActualizacionProductoLacteo;
	
	/** The panel gestion productos animales no lacteos. */
	private PanelGestionProductosAnimalesNoLacteos panelGestionProductosAnimalesNoLacteos;
	
	/** The panel creacion producto animal no lacteo. */
	private PanelCreacionProductoAnimalNoLacteo panelCreacionProductoAnimalNoLacteo;
	
	/** The panel actualizacion producto animal no lacteo. */
	private PanelActualizacionProductoAnimalNoLacteo panelActualizacionProductoAnimalNoLacteo;
	
	/** The panel gestion frutas dulces. */
	private PanelGestionFrutasDulces panelGestionFrutasDulces;
	
	/** The panel creacion fruta dulce. */
	private PanelCreacionFrutaDulce panelCreacionFrutaDulce;
	
	/** The panel actualizacion fruta dulce. */
	private PanelActualizacionFrutaDulce panelActualizacionFrutaDulce;
	
	/** The panel gestion frutas acidas. */
	private PanelGestionFrutasAcidas panelGestionFrutasAcidas;
	
	/** The panel creacion fruta acida. */
	private PanelCreacionFrutaAcida panelCreacionFrutaAcida;
	
	/** The panel actualizacion fruta acida. */
	private PanelActualizacionFrutaAcida panelActualizacionFrutaAcida;
	
	/** The panel gestion verduras. */
	private PanelGestionVerduras panelGestionVerduras;
	
	/** The panel creacion verdura. */
	private PanelCreacionVerdura panelCreacionVerdura;
	
	/** The panel actualizacion verdura. */
	private PanelActualizacionVerdura panelActualizacionVerdura;
	
	/** The panel gestion comida chatarra. */
	private PanelGestionComidaChatarra panelGestionComidaChatarra;
	
	/** The panel creacion comida chatarra. */
	private PanelCreacionComidaChatarra panelCreacionComidaChatarra;
	
	/** The panel actualizacion comida chatarra. */
	private PanelActualizacionComidaChatarra panelActualizacionComidaChatarra;

	/**
	 * Instantiates a new ventana principal.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1000, 700);
		centrarVentana();
		
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		
		panelMenuPrincipal = new PanelMenuPrincipal();
		panelGestionCarnesFrias = new PanelGestionCarnesFrias();
		panelCreacionCarneFria = new PanelCreacionCarneFria();
		panelActualizacionCarneFria = new PanelActualizacionCarneFria();
		panelGestionProductosLacteos = new PanelGestionProductosLacteos();
		panelCreacionProductoLacteo = new PanelCreacionProductoLacteo();
		panelActualizacionProductoLacteo = new PanelActualizacionProductoLacteo();
		panelGestionProductosAnimalesNoLacteos = new PanelGestionProductosAnimalesNoLacteos();
		panelCreacionProductoAnimalNoLacteo = new PanelCreacionProductoAnimalNoLacteo();
		panelActualizacionProductoAnimalNoLacteo = new PanelActualizacionProductoAnimalNoLacteo();
		panelGestionFrutasDulces = new PanelGestionFrutasDulces();
		panelCreacionFrutaDulce = new PanelCreacionFrutaDulce();
		panelActualizacionFrutaDulce = new PanelActualizacionFrutaDulce();
		panelGestionFrutasAcidas = new PanelGestionFrutasAcidas();
		panelCreacionFrutaAcida = new PanelCreacionFrutaAcida();
		panelActualizacionFrutaAcida = new PanelActualizacionFrutaAcida();
		panelGestionVerduras = new PanelGestionVerduras();
		panelCreacionVerdura = new PanelCreacionVerdura();
		panelActualizacionVerdura = new PanelActualizacionVerdura();
		panelGestionComidaChatarra = new PanelGestionComidaChatarra();
		panelCreacionComidaChatarra = new PanelCreacionComidaChatarra();
		panelActualizacionComidaChatarra = new PanelActualizacionComidaChatarra();
		
		cardPanel.add(panelMenuPrincipal, "panelMenuPrincipal");
		cardPanel.add(panelGestionCarnesFrias, "panelGestionCarnesFrias");
		cardPanel.add(panelCreacionCarneFria, "panelCreacionCarneFria");
		cardPanel.add(panelActualizacionCarneFria, "panelActualizacionCarneFria");
		cardPanel.add(panelGestionProductosLacteos, "panelGestionProductosLacteos");
		cardPanel.add(panelCreacionProductoLacteo, "panelCreacionProductoLacteo");
		cardPanel.add(panelActualizacionProductoLacteo, "panelActualizacionProductoLacteo");
		cardPanel.add(panelGestionProductosAnimalesNoLacteos, "panelGestionProductosAnimalesNoLacteos");
		cardPanel.add(panelCreacionProductoAnimalNoLacteo, "panelCreacionProductoAnimalNoLacteo");
		cardPanel.add(panelActualizacionProductoAnimalNoLacteo, "panelActualizacionProductoAnimalNoLacteo");
		cardPanel.add(panelGestionFrutasDulces, "panelGestionFrutasDulces");
		cardPanel.add(panelCreacionFrutaDulce, "panelCreacionFrutaDulce");
		cardPanel.add(panelActualizacionFrutaDulce, "panelActualizacionFrutaDulce");
		cardPanel.add(panelGestionFrutasAcidas, "panelGestionFrutasAcidas");
		cardPanel.add(panelCreacionFrutaAcida, "panelCreacionFrutaAcida");
		cardPanel.add(panelActualizacionFrutaAcida, "panelActualizacionFrutaAcida");
		cardPanel.add(panelGestionVerduras, "panelGestionVerduras");
		cardPanel.add(panelCreacionVerdura, "panelCreacionVerdura");
		cardPanel.add(panelActualizacionVerdura, "panelActualizacionVerdura");
		cardPanel.add(panelGestionComidaChatarra, "panelGestionComidaChatarra");
		cardPanel.add(panelCreacionComidaChatarra, "panelCreacionComidaChatarra");
		cardPanel.add(panelActualizacionComidaChatarra, "panelActualizacionComidaChatarra");
		
		add(cardPanel);
		
		mostrarPanelMenuPrincipal();
	}

	/**
	 * Centrar ventana.
	 */
	public void centrarVentana() {
		// Obtener el tamaño de la pantalla
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// Calcular la ubicación de la ventana
		int x = (screenSize.width - getSize().width) / 2;
		int y = (screenSize.height - getSize().height) / 2;

		// Colocar la nueva ubicación de la ventana
		setLocation(x, y);
	}
	
	/**
	 * Mostrar panel menu principal.
	 */
	public void mostrarPanelMenuPrincipal() {
		setTitle("Administración de Productos | Menú Principal");
		cardLayout.show(cardPanel, "panelMenuPrincipal");
	}
	
	
	/**
	 * Mostrar panel gestion carnes frias.
	 */
	public void mostrarPanelGestionCarnesFrias() {
		setTitle("Administración de Productos | Gestión Carnes Frías");
		cardLayout.show(cardPanel, "panelGestionCarnesFrias");
		if (panelGestionCarnesFrias.getTablaProductos().getRowCount() == 0) {
			panelGestionCarnesFrias.mostrarMensaje("No se han agregado carnes frías");
		}
	}
	
	/**
	 * Mostrar panel creacion carne fria.
	 */
	public void mostrarPanelCreacionCarneFria() {
		setTitle("Administración de Productos | Creación Carne Fría");
		panelCreacionCarneFria.reiniciarEntradas();
		cardLayout.show(cardPanel, "panelCreacionCarneFria");
	}
	
	/**
	 * Mostrar panel actualizacion carne fria.
	 */
	public void mostrarPanelActualizacionCarneFria() {
		setTitle("Administración de Productos | Actualización Carne Fría");
		cardLayout.show(cardPanel, "panelActualizacionCarneFria");
	}
	
	
	/**
	 * Mostrar panel gestion productos lacteos.
	 */
	public void mostrarPanelGestionProductosLacteos() {
		setTitle("Administración de Productos | Gestión Productos Lácteos");
		cardLayout.show(cardPanel, "panelGestionProductosLacteos");
		if (panelGestionProductosLacteos.getTablaProductos().getRowCount() == 0) {
			panelGestionProductosLacteos.mostrarMensaje("No se han agregado productos lácteos");
		}
	}
	
	/**
	 * Mostrar panel creacion producto lacteo.
	 */
	public void mostrarPanelCreacionProductoLacteo() {
		setTitle("Administración de Productos | Creación Producto Lácteo");
		panelCreacionProductoLacteo.reiniciarEntradas();
		cardLayout.show(cardPanel, "panelCreacionProductoLacteo");
	}
	
	/**
	 * Mostrar panel actualizacion producto lacteo.
	 */
	public void mostrarPanelActualizacionProductoLacteo() {
		setTitle("Administración de Productos | Actualización Producto Lácteo");
		cardLayout.show(cardPanel, "panelActualizacionProductoLacteo");
	}
	
	
	/**
	 * Mostrar panel gestion productos animales no lacteos.
	 */
	public void mostrarPanelGestionProductosAnimalesNoLacteos() {
		setTitle("Administración de Productos | Gestión de Productos Animales No Lácteos");
		cardLayout.show(cardPanel, "panelGestionProductosAnimalesNoLacteos");
		if (panelGestionProductosAnimalesNoLacteos.getTablaProductos().getRowCount() == 0) {
			panelGestionProductosAnimalesNoLacteos.mostrarMensaje("No se han agregado productos animales no lácteos");
		}
	}
	
	/**
	 * Mostrar panel creacion producto animal no lacteo.
	 */
	public void mostrarPanelCreacionProductoAnimalNoLacteo() {
		setTitle("Administración de Productos | Creación de Producto Animal No Lácteo");
		panelCreacionProductoAnimalNoLacteo.reiniciarEntradas();
		cardLayout.show(cardPanel, "panelCreacionProductoAnimalNoLacteo");
	}
	
	/**
	 * Mostrar panel actualizacion producto animal no lacteo.
	 */
	public void mostrarPanelActualizacionProductoAnimalNoLacteo() {
		setTitle("Administración de Productos | Actualización Producto Animal No Lácteo");
		cardLayout.show(cardPanel, "panelActualizacionProductoAnimalNoLacteo");
	}
	
	
	/**
	 * Mostrar panel gestion frutas dulces.
	 */
	public void mostrarPanelGestionFrutasDulces() {
		setTitle("Administración de Productos | Gestión de Frutas Dulces");
		cardLayout.show(cardPanel, "panelGestionFrutasDulces");
		if (panelGestionFrutasDulces.getTablaProductos().getRowCount() == 0) {
			panelGestionFrutasDulces.mostrarMensaje("No se han agregado frutas dulces");
		}
	}
	
	/**
	 * Mostrar panel creacion fruta dulce.
	 */
	public void mostrarPanelCreacionFrutaDulce() {
		setTitle("Administración de Productos | Creación de Fruta Dulce");
		panelCreacionFrutaDulce.reiniciarEntradas();
		cardLayout.show(cardPanel, "panelCreacionFrutaDulce");
	}
	
	/**
	 * Mostrar panel actualizacion fruta dulce.
	 */
	public void mostrarPanelActualizacionFrutaDulce() {
		setTitle("Administración de Productos | Actualización Fruta Dulce");
		cardLayout.show(cardPanel, "panelActualizacionFrutaDulce");
	}
	
	
	/**
	 * Mostrar panel gestion frutas acidas.
	 */
	public void mostrarPanelGestionFrutasAcidas() {
		setTitle("Administración de Productos | Gestión de Frutas Ácidas");
		cardLayout.show(cardPanel, "panelGestionFrutasAcidas");
		if (panelGestionFrutasAcidas.getTablaProductos().getRowCount() == 0) {
			panelGestionFrutasAcidas.mostrarMensaje("No se han agregado frutas ácidas");
		}
	}
	
	/**
	 * Mostrar panel creacion fruta acida.
	 */
	public void mostrarPanelCreacionFrutaAcida() {
		setTitle("Administración de Productos | Creación de Fruta Ácida");
		panelCreacionFrutaAcida.reiniciarEntradas();
		cardLayout.show(cardPanel, "panelCreacionFrutaAcida");
	}
	
	/**
	 * Mostrar panel actualizacion fruta acida.
	 */
	public void mostrarPanelActualizacionFrutaAcida() {
		setTitle("Administración de Productos | Actualización Fruta Ácida");
		cardLayout.show(cardPanel, "panelActualizacionFrutaAcida");
	}
	
	
	/**
	 * Mostrar panel gestion verduras.
	 */
	public void mostrarPanelGestionVerduras() {
		setTitle("Administración de Productos | Gestión de Verduras");
		cardLayout.show(cardPanel, "panelGestionVerduras");
		if (panelGestionVerduras.getTablaProductos().getRowCount() == 0) {
			panelGestionVerduras.mostrarMensaje("No se han agregado frutas ácidas");
		}
	}
	
	/**
	 * Mostrar panel creacion verdura.
	 */
	public void mostrarPanelCreacionVerdura() {
		setTitle("Administración de Productos | Creación de Verdura");
		panelCreacionVerdura.reiniciarEntradas();
		cardLayout.show(cardPanel, "panelCreacionVerdura");
	}
	
	/**
	 * Mostrar panel actualizacion verdura.
	 */
	public void mostrarPanelActualizacionVerdura() {
		setTitle("Administración de Productos | Actualización Verdura");
		cardLayout.show(cardPanel, "panelActualizacionVerdura");
	}
	
	
	/**
	 * Mostrar panel gestion comida chatarra.
	 */
	public void mostrarPanelGestionComidaChatarra() {
		setTitle("Administración de Productos | Creación de Comida Chatarra");
		cardLayout.show(cardPanel, "panelGestionComidaChatarra");
		if (panelGestionComidaChatarra.getTablaProductos().getRowCount() == 0) {
			panelGestionComidaChatarra.mostrarMensaje("No se han agregado comidas chatarra");
		}
	}
	
	/**
	 * Mostrar panel creacion comida chatarra.
	 */
	public void mostrarPanelCreacionComidaChatarra() {
		setTitle("Administración de Productos | Creación de Comida Chatarra");
		panelCreacionComidaChatarra.reiniciarEntradas();
		cardLayout.show(cardPanel, "panelCreacionComidaChatarra");
	}
	
	/**
	 * Mostrar panel actualizacion comida chatarra.
	 */
	public void mostrarPanelActualizacionComidaChatarra() {
		setTitle("Administración de Productos | Actualización Comida Chatarra");
		cardLayout.show(cardPanel, "panelActualizacionComidaChatarra");
	}

	/**
	 * Gets the panel menu principal.
	 *
	 * @return the panel menu principal
	 */
	public PanelMenuPrincipal getPanelMenuPrincipal() {
		return panelMenuPrincipal;
	}

	/**
	 * Gets the panel gestion carnes frias.
	 *
	 * @return the panel gestion carnes frias
	 */
	public PanelGestionCarnesFrias getPanelGestionCarnesFrias() {
		return panelGestionCarnesFrias;
	}

	/**
	 * Gets the panel creacion carne fria.
	 *
	 * @return the panel creacion carne fria
	 */
	public PanelCreacionCarneFria getPanelCreacionCarneFria() {
		return panelCreacionCarneFria;
	}

	/**
	 * Gets the panel actualizacion carne fria.
	 *
	 * @return the panel actualizacion carne fria
	 */
	public PanelActualizacionCarneFria getPanelActualizacionCarneFria() {
		return panelActualizacionCarneFria;
	}

	/**
	 * Gets the panel gestion productos lacteos.
	 *
	 * @return the panel gestion productos lacteos
	 */
	public PanelGestionProductosLacteos getPanelGestionProductosLacteos() {
		return panelGestionProductosLacteos;
	}

	/**
	 * Gets the panel creacion producto lacteo.
	 *
	 * @return the panel creacion producto lacteo
	 */
	public PanelCreacionProductoLacteo getPanelCreacionProductoLacteo() {
		return panelCreacionProductoLacteo;
	}

	/**
	 * Gets the panel actualizacion producto lacteo.
	 *
	 * @return the panel actualizacion producto lacteo
	 */
	public PanelActualizacionProductoLacteo getPanelActualizacionProductoLacteo() {
		return panelActualizacionProductoLacteo;
	}

	/**
	 * Gets the panel gestion productos animales no lacteos.
	 *
	 * @return the panel gestion productos animales no lacteos
	 */
	public PanelGestionProductosAnimalesNoLacteos getPanelGestionProductosAnimalesNoLacteos() {
		return panelGestionProductosAnimalesNoLacteos;
	}

	/**
	 * Gets the panel creacion producto animal no lacteo.
	 *
	 * @return the panel creacion producto animal no lacteo
	 */
	public PanelCreacionProductoAnimalNoLacteo getPanelCreacionProductoAnimalNoLacteo() {
		return panelCreacionProductoAnimalNoLacteo;
	}

	/**
	 * Gets the panel actualizacion producto animal no lacteo.
	 *
	 * @return the panel actualizacion producto animal no lacteo
	 */
	public PanelActualizacionProductoAnimalNoLacteo getPanelActualizacionProductoAnimalNoLacteo() {
		return panelActualizacionProductoAnimalNoLacteo;
	}

	/**
	 * Gets the panel gestion frutas dulces.
	 *
	 * @return the panel gestion frutas dulces
	 */
	public PanelGestionFrutasDulces getPanelGestionFrutasDulces() {
		return panelGestionFrutasDulces;
	}

	/**
	 * Gets the panel creacion fruta dulce.
	 *
	 * @return the panel creacion fruta dulce
	 */
	public PanelCreacionFrutaDulce getPanelCreacionFrutaDulce() {
		return panelCreacionFrutaDulce;
	}

	/**
	 * Gets the panel actualizacion fruta dulce.
	 *
	 * @return the panel actualizacion fruta dulce
	 */
	public PanelActualizacionFrutaDulce getPanelActualizacionFrutaDulce() {
		return panelActualizacionFrutaDulce;
	}

	/**
	 * Gets the panel gestion frutas acidas.
	 *
	 * @return the panel gestion frutas acidas
	 */
	public PanelGestionFrutasAcidas getPanelGestionFrutasAcidas() {
		return panelGestionFrutasAcidas;
	}

	/**
	 * Gets the panel creacion fruta acida.
	 *
	 * @return the panel creacion fruta acida
	 */
	public PanelCreacionFrutaAcida getPanelCreacionFrutaAcida() {
		return panelCreacionFrutaAcida;
	}

	/**
	 * Gets the panel actualizacion fruta acida.
	 *
	 * @return the panel actualizacion fruta acida
	 */
	public PanelActualizacionFrutaAcida getPanelActualizacionFrutaAcida() {
		return panelActualizacionFrutaAcida;
	}

	/**
	 * Gets the panel gestion verduras.
	 *
	 * @return the panel gestion verduras
	 */
	public PanelGestionVerduras getPanelGestionVerduras() {
		return panelGestionVerduras;
	}

	/**
	 * Gets the panel creacion verdura.
	 *
	 * @return the panel creacion verdura
	 */
	public PanelCreacionVerdura getPanelCreacionVerdura() {
		return panelCreacionVerdura;
	}

	/**
	 * Gets the panel actualizacion verdura.
	 *
	 * @return the panel actualizacion verdura
	 */
	public PanelActualizacionVerdura getPanelActualizacionVerdura() {
		return panelActualizacionVerdura;
	}

	/**
	 * Gets the panel gestion comida chatarra.
	 *
	 * @return the panel gestion comida chatarra
	 */
	public PanelGestionComidaChatarra getPanelGestionComidaChatarra() {
		return panelGestionComidaChatarra;
	}

	/**
	 * Gets the panel creacion comida chatarra.
	 *
	 * @return the panel creacion comida chatarra
	 */
	public PanelCreacionComidaChatarra getPanelCreacionComidaChatarra() {
		return panelCreacionComidaChatarra;
	}

	/**
	 * Gets the panel actualizacion comida chatarra.
	 *
	 * @return the panel actualizacion comida chatarra
	 */
	public PanelActualizacionComidaChatarra getPanelActualizacionComidaChatarra() {
		return panelActualizacionComidaChatarra;
	}
	
}
