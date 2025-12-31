package co.edu.unbosque.controller;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.model.ModeloTexto;
import co.edu.unbosque.view.PanelBotones;
import co.edu.unbosque.view.PanelBusqueda;
import co.edu.unbosque.view.VentanaPrincipal;

/**
 * Controlador principal que maneja la interacción entre la vista y el modelo.
 * Coordina las acciones del usuario con las operaciones del sistema.
 */
public class ControladorTexto {

	private ModeloTexto modelo;
	private VentanaPrincipal vista;

	public ControladorTexto() {
		new VentanaPrincipal().setVisible(true);
	}

	public ControladorTexto(VentanaPrincipal vista) {
		this.vista = vista;
		this.modelo = new ModeloTexto();
		configurarEventos();
	}

	private void configurarEventos() {
		PanelBotones panelBotones = vista.getPanelBotones();
		PanelBusqueda panelBusqueda = vista.getPanelBusqueda();

		panelBotones.getBotonCargar().addActionListener(e -> cargarArchivo());
		panelBotones.getBotonLimpiar().addActionListener(e -> limpiar());
		panelBotones.getBotonSalir().addActionListener(e -> salir());

		panelBusqueda.getBotonBuscar().addActionListener(e -> buscarTexto());
		panelBusqueda.getCampoBusqueda().addActionListener(e -> buscarTexto());
	}

	private void cargarArchivo() {
		// Configurar textos del sistema para JFileChooser
		javax.swing.UIManager.put("FileChooser.lookInLabelText", "Buscar en:");
		javax.swing.UIManager.put("FileChooser.fileNameLabelText", "Nombre del archivo:");
		javax.swing.UIManager.put("FileChooser.filesOfTypeLabelText", "Archivos de tipo:");
		javax.swing.UIManager.put("FileChooser.cancelButtonText", "Cancelar");
		javax.swing.UIManager.put("FileChooser.openButtonText", "Abrir");
		javax.swing.UIManager.put("FileChooser.saveButtonText", "Guardar");
		javax.swing.UIManager.put("FileChooser.newFolderButtonText", "Nueva carpeta");
		javax.swing.UIManager.put("FileChooser.upFolderToolTipText", "Subir un nivel");
		javax.swing.UIManager.put("FileChooser.homeFolderToolTipText", "Inicio");
		javax.swing.UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalles");
		javax.swing.UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Seleccionar archivo de texto");
		fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);

		// Cambiar texto del botón principal a español
		fileChooser.setApproveButtonText("Abrir");
		fileChooser.setApproveButtonToolTipText("Abrir archivo seleccionado");

		int resultado = fileChooser.showOpenDialog(vista);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			File archivo = fileChooser.getSelectedFile();

			if (modelo.cargarArchivo(archivo)) {
				vista.getPanelArchivo().mostrarContenido(modelo.getContenidoArchivo());
				JOptionPane.showMessageDialog(vista, "Archivo cargado correctamente:\n" + archivo.getName(),
						"Carga exitosa", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(vista,
						"No se pudo cargar el archivo.\nVerifique que el archivo existe y es accesible.",
						"Error de carga", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void buscarTexto() {
		String textoBuscar = vista.getPanelBusqueda().getCampoBusqueda().getText().trim();

		if (!modelo.tieneArchivoCargado()) {
			JOptionPane.showMessageDialog(vista, "Debe cargar un archivo primero.", "Sin archivo",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (textoBuscar.isEmpty()) {
			JOptionPane.showMessageDialog(vista, "Ingrese el texto a buscar.", "Campo vacío",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		// Limpiar resaltado anterior antes de buscar
		vista.getPanelArchivo().limpiarResaltado();

		int cantidadEncontrada = modelo.buscarTexto(textoBuscar);

		if (cantidadEncontrada > 0) {
			vista.getPanelArchivo().resaltarTexto(modelo.getPosicionesEncontradas(), modelo.getTextoBuscado());
		JOptionPane.showMessageDialog(vista,
				"Encontradas " + cantidadEncontrada + " coincidencia(s):\n\"" + textoBuscar + "\"",
				"Búsqueda completada", JOptionPane.INFORMATION_MESSAGE);

			vista.getPanelBusqueda().getCoincidencias().setText(cantidadEncontrada+"");
		} else {
			JOptionPane.showMessageDialog(vista, "No se encontró: \"" + textoBuscar + "\"", "Sin coincidencias",
					JOptionPane.INFORMATION_MESSAGE);
			vista.getPanelBusqueda().getCoincidencias().setText("No hay coincidencias");

		}
	}

	private void limpiar() {
		modelo.limpiar();
		vista.getPanelArchivo().limpiarContenido();
		vista.getPanelBusqueda().getCoincidencias().setText("");
		vista.getPanelBusqueda().getCampoBusqueda().setText("");
		JOptionPane.showMessageDialog(vista, "Limpieza completada.", "Limpieza", JOptionPane.INFORMATION_MESSAGE);
	}

	private void salir() {
		String[] opciones = { "Sí", "No" };
		int opcion = JOptionPane.showOptionDialog(vista, "¿Desea salir de la aplicación?", "Confirmar",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[1]);

		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
