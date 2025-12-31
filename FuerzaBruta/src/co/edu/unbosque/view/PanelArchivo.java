package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.StyledDocument;

public class PanelArchivo extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextPane areaTexto;
    private JScrollPane scroll;
    private Highlighter highlighter;
    private java.util.List<Object> highlightTags;
    
    private final Color COLOR_FONDO = new Color(255, 200, 150, 200);
    private final Color COLOR_FONDO_SECUNDARIO = new Color(255, 245, 230);
    private final Color COLOR_TEXTO = new Color(100, 40, 20);
    private final Color COLOR_BORDE = new Color(240, 180, 140);
    private final Color COLOR_RESALTADO = new Color(255, 180, 80);
    private final Color COLOR_TITULO = new Color(140, 60, 30);

    public PanelArchivo() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(COLOR_BORDE, 3),
                "Contenido del Archivo",
                0, 0,
                new Font("Segoe UI", Font.BOLD, 14),
                COLOR_TITULO
            ),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        setBackground(new Color(0, 0, 0, 0));

        areaTexto = new JTextPane();
        areaTexto.setEditable(false);
        areaTexto.setBackground(COLOR_FONDO_SECUNDARIO);
        areaTexto.setForeground(COLOR_TEXTO);
        areaTexto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        areaTexto.setCaretColor(COLOR_TEXTO);
        areaTexto.setSelectionColor(COLOR_RESALTADO);
        areaTexto.setSelectedTextColor(COLOR_TEXTO);
        areaTexto.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE, 2),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        highlighter = areaTexto.getHighlighter();
        highlightTags = new java.util.ArrayList<>();

        scroll = new JScrollPane(areaTexto);
        scroll.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 2));
        scroll.getViewport().setBackground(COLOR_FONDO_SECUNDARIO);
        add(scroll, BorderLayout.CENTER);
    }

    public JTextPane getAreaTexto() {
        return areaTexto;
    }
    
    public void mostrarContenido(String contenido) {
        areaTexto.setText(contenido);
        limpiarResaltado();
    }
    
    public void limpiarContenido() {
        areaTexto.setText("");
        limpiarResaltado();
    }
    
    public void resaltarTexto(List<Integer> posiciones, String textoBuscado) {
        limpiarResaltado();
        
        if (posiciones.isEmpty() || textoBuscado.isEmpty()) {
            return;
        }
        
        try {
            StyledDocument doc = areaTexto.getStyledDocument();
            String contenido = doc.getText(0, doc.getLength());
            
            DefaultHighlighter.DefaultHighlightPainter painter = 
                new DefaultHighlighter.DefaultHighlightPainter(COLOR_RESALTADO);
            
            for (int posicion : posiciones) {
                int inicio = posicion;
                int fin = posicion + textoBuscado.length();
                
                if (fin <= contenido.length()) {
                    Object tag = highlighter.addHighlight(inicio, fin, painter);
                    highlightTags.add(tag);
                }
            }
            
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
    
    public void limpiarResaltado() {
        for (Object tag : highlightTags) {
            highlighter.removeHighlight(tag);
        }
        highlightTags.clear();
    }
}