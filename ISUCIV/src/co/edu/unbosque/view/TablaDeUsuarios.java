package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Usuario;

// TODO: Auto-generated Javadoc
/**
 * The Class TablaDeUsuarios.
 */
public class TablaDeUsuarios extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5033905453082934198L;
	
	/** The tabla datos. */
	private JTable tablaDatos;
	
	/** The modelo tabla. */
	private DefaultTableModel modeloTabla;

	/**
	 * Instantiates a new tabla de usuarios.
	 */
	public TablaDeUsuarios() {
		setBorder(new TitledBorder("Mostrar Datos Usuarios"));
		setLayout(new BorderLayout());

		modeloTabla = new DefaultTableModel() {
			private static final long serialVersionUID = 3140886987162105608L;

			@Override
			public boolean isCellEditable(int fila, int columna) {
				return false;
			}
		};
		modeloTabla.addColumn("Número de Documento");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Género");
		modeloTabla.addColumn("Correo");
		modeloTabla.addColumn("Clave");

		tablaDatos = new JTable(modeloTabla);
		tablaDatos.setRowSelectionAllowed(false);
		tablaDatos.setColumnSelectionAllowed(false);
		tablaDatos.setCellSelectionEnabled(false);
		tablaDatos.setFocusable(false);
		tablaDatos.setRowSelectionAllowed(false);
		tablaDatos.setCellSelectionEnabled(false);
		JScrollPane panelDesplazamiento = new JScrollPane(tablaDatos);
		add(panelDesplazamiento, BorderLayout.CENTER);
	}
	
	/**
	 * Agregar usuarios A tabla.
	 *
	 * @param listaUsuarios the lista usuarios
	 */
	public void agregarUsuariosATabla(List<Usuario> listaUsuarios) {
		modeloTabla.setRowCount(0);
		for (Usuario usuario : listaUsuarios) {
			char ultimoCaracter = usuario.getClave().charAt(usuario.getClave().length() - 1);
			String claveOculta = "*".repeat(usuario.getClave().length() - 1) + ultimoCaracter;
			Object[] datosUsuario = new Object[] {
				usuario.getNumeroDeDocumento(),
				usuario.getNombre(),
				usuario.getGenero(),
				usuario.getCorreo(),
				claveOculta
			};
			modeloTabla.addRow(datosUsuario);
		}
	}

	/**
	 * Gets the tabla datos.
	 *
	 * @return the tabla datos
	 */
	public JTable getTablaDatos() {
		return tablaDatos;
	}

	/**
	 * Sets the tabla datos.
	 *
	 * @param tablaDatos the new tabla datos
	 */
	public void setTablaDatos(JTable tablaDatos) {
		this.tablaDatos = tablaDatos;
	}

	/**
	 * Gets the modelo tabla.
	 *
	 * @return the modelo tabla
	 */
	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	/**
	 * Sets the modelo tabla.
	 *
	 * @param modeloTabla the new modelo tabla
	 */
	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
