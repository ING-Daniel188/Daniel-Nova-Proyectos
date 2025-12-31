package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.List;
import co.edu.unbosque.model.CiclistaEscalador;

// TODO: Auto-generated Javadoc
/**
 * The Class TablaDeCiclistasEscaladores.
 */
public class TablaDeCiclistasEscaladores extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2038409523682831174L;
    
    /** The tabla datos. */
    private JTable tablaDatos;
    
    /** The modelo tabla. */
    private DefaultTableModel modeloTabla;

    /**
     * Instantiates a new tabla de ciclistas escaladores.
     */
    public TablaDeCiclistasEscaladores() {
        setBorder(new TitledBorder("Mostrar Datos de Ciclistas Escaladores"));
        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel() {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        modeloTabla.addColumn("Número de Documento");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Cadencia");
        modeloTabla.addColumn("Especialidad");
        modeloTabla.addColumn("Aceleración Promedio");
        modeloTabla.addColumn("Grado Rampa Soportada");

        tablaDatos = new JTable(modeloTabla);
        tablaDatos.setRowSelectionAllowed(false);
        tablaDatos.setColumnSelectionAllowed(false);
        tablaDatos.setCellSelectionEnabled(false);
        tablaDatos.setFocusable(false);
        JScrollPane panelDesplazamiento = new JScrollPane(tablaDatos);
        add(panelDesplazamiento, BorderLayout.CENTER);
    }

    /**
     * Agregar ciclistas escaladores A tabla.
     *
     * @param listaCiclistasEscaladores the lista ciclistas escaladores
     */
    public void agregarCiclistasEscaladoresATabla(List<CiclistaEscalador> listaCiclistasEscaladores) {
        modeloTabla.setRowCount(0);
        for (CiclistaEscalador ciclistaEscalador : listaCiclistasEscaladores) {
            Object[] datosCiclistaEscalador = new Object[]{
                ciclistaEscalador.getNumeroDeDocumento(),
                ciclistaEscalador.getNombre(),
                ciclistaEscalador.getCadencia(),
                ciclistaEscalador.getEspecialidad(),
                ciclistaEscalador.getAceleracionPromedio(),
                ciclistaEscalador.getGradoRampaSoportada()
            };
            modeloTabla.addRow(datosCiclistaEscalador);
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
}
