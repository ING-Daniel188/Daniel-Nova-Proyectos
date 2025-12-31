package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;

import co.edu.unbosque.model.PokemonDTO;

/**
 * Clase que representa el panel de visualización de un Pokémon en la interfaz gráfica.
 * Contiene componentes para mostrar la información detallada de un Pokémon, incluyendo
 * su imagen, estadísticas, y si es legendario o no. Permite la actualización de la
 * información mostrada a través de un botón.
 */
public class PanelVisualizacionPokemon extends JPanel {

    /**
     * Identificador único para la serialización
     */
    private static final long serialVersionUID = 1L;

    /**
     * Etiqueta para mostrar el ID del Pokémon.
     */
    private JLabel idLabel;
    /**
     * Etiqueta para mostrar el nombre del Pokémon.
     */
    private JLabel labelNombre;
    /**
     * Campo de texto para mostrar el tipo del Pokémon.
     */
    private JTextField tipoField;
    /**
     * Campo de texto para mostrar la altura del Pokémon.
     */
    private JTextField alturaField;
    /**
     * Campo de texto para mostrar el peso del Pokémon.
     */
    private JTextField pesoField;
    /**
     * Barra de progreso para mostrar la salud del Pokémon.
     */
    private JProgressBar saludBar;
    /**
     * Barra de progreso para mostrar el ataque del Pokémon.
     */
    private JProgressBar ataqueBar;
    /**
     * Barra de progreso para mostrar el ataque especial del Pokémon.
     */
    private JProgressBar ataqueEspecialBar;
    /**
     * Barra de progreso para mostrar la defensa del Pokémon.
     */
    private JProgressBar defensaBar;
    /**
     * Barra de progreso para mostrar la defensa especial del Pokémon.
     */
    private JProgressBar defensaEspecialBar;
    /**
     * Barra de progreso para mostrar la velocidad del Pokémon.
     */
    private JProgressBar velocidadBar;
    /**
     * Panel para agrupar los botones de selección de legendario.
     */
    private JPanel legendarioPanel;
    /**
     * Etiqueta para mostrar el texto "Ataques".
     */
    private JLabel ataquesLabel;
    /**
     * Campo de texto para mostrar los ataques del Pokémon.
     */
    private JTextField ataquesTextField;
    /**
     * Etiqueta para mostrar la imagen del Pokémon.
     */
    private JLabel imageLabel;
    /**
     * Etiqueta para mostrar el texto "Ataque".
     */
    private JLabel ataqueLabel;
    /**
     * Etiqueta para mostrar el texto "Ataque Especial".
     */
    private JLabel ataqueEspecialLabel;
    /**
     * Etiqueta para mostrar el texto "Defensa".
     */
    private JLabel defensaLabel;
    /**
     * Etiqueta para mostrar el texto "Defensa Especial".
     */
    private JLabel defensaEspecialLabel;
    /**
     * Etiqueta para mostrar el texto "Velocidad".
     */
    private JLabel velocidadLabel;
    /**
     * Etiqueta para mostrar el texto "Legendario".
     */
    private JLabel legendarioLabel;
    /**
     * Botón de radio para seleccionar si el Pokémon es legendario.
     */
    private JRadioButton legendarioSi;
    /**
     * Botón de radio para seleccionar si el Pokémon no es legendario.
     */
    private JRadioButton legendarioNo;
    /**
     * Grupo de botones para la selección de legendario.
     */
    private ButtonGroup legendarioGroup;
    /**
     * Etiqueta para mostrar la generación del Pokémon.
     */
    private JLabel generacionLabel;
    /**
     * Botón para actualizar la información del Pokémon.
     */
    private JButton actualizarButton;
    /**
     * Panel para contener el botón de actualización.
     */
    private JPanel botonActualizarPanel;

    /**
     * Temporizador para la animación de la barra de progreso de salud.
     */
    private Timer saludTimer;
    /**
     * Temporizador para la animación de la barra de progreso de ataque.
     */
    private Timer ataqueTimer;
    /**
     * Temporizador para la animación de la barra de progreso de ataque especial.
     */
    private Timer ataqueEspecialTimer;
    /**
     * Temporizador para la animación de la barra de progreso de defensa.
     */
    private Timer defensaTimer;
    /**
     * Temporizador para la animación de la barra de progreso de defensa especial.
     */
    private Timer defensaEspecialTimer;
    /**
     * Temporizador para la animación de la barra de progreso de velocidad.
     */
    private Timer velocidadTimer;

    /**
     * Constructor que inicializa los componentes de la interfaz gráfica y configura
     * el layout del panel.
     */
    public PanelVisualizacionPokemon() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(LEFT_ALIGNMENT);

        actualizarButton = new JButton("Actualizar");
        botonActualizarPanel = new JPanel();
        botonActualizarPanel.setLayout(new BoxLayout(botonActualizarPanel, BoxLayout.X_AXIS));
        botonActualizarPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        botonActualizarPanel.add(Box.createHorizontalGlue());
        botonActualizarPanel.add(actualizarButton);
        botonActualizarPanel.add(Box.createHorizontalGlue());
        botonActualizarPanel.setVisible(false);
        add(botonActualizarPanel);
    }

    /**
     * Actualiza la información mostrada en el panel con los datos de un Pokémon específico.
     * Detiene los temporizadores de animación y reinicia los componentes visuales.
     * 
     * @param pokemon Objeto PokemonDTO con la información del Pokémon a mostrar.
     */
    public void updatePokemon(PokemonDTO pokemon) {
        if (saludTimer != null) {
            saludTimer.stop();
        }
        
        if (ataqueTimer != null) {
            ataqueTimer.stop();
        }
        
        if (ataqueEspecialTimer != null) {
            ataqueEspecialTimer.stop();
        }
        
        if (defensaTimer != null) {
            defensaTimer.stop();
        }
        
        if (defensaEspecialTimer != null) {
            defensaEspecialTimer.stop();
        }
        
        if (velocidadTimer != null) {
            velocidadTimer.stop();
        }

        removeAll();

        String imagePath = "./Imagenes/" + pokemon.getNombre() + ".gif";
        ImageIcon originalIcon = new ImageIcon(imagePath);
        if (originalIcon.getIconWidth() > 400) {

            originalIcon = new ImageIcon(
                    new ImageIcon(imagePath).getImage().getScaledInstance(400, 280, Image.SCALE_DEFAULT));
        }
        
        imageLabel = new JLabel(originalIcon);
        imageLabel.setAlignmentX(LEFT_ALIGNMENT);
        add(imageLabel);

        addPokemonInfoFields(pokemon);

        revalidate();
        repaint();
    }

    /**
     * Añade los campos de información del Pokémon al panel.
     * Este método es llamado internamente por updatePokemon.
     * 
     * @param pokemon Objeto PokemonDTO con la información del Pokémon a mostrar.
     */
    public void addPokemonInfoFields(PokemonDTO pokemon) {
        idLabel = new JLabel("ID: " + pokemon.getId());
        idLabel.setAlignmentX(LEFT_ALIGNMENT);
        add(idLabel);
        
        labelNombre = new JLabel("Nombre: " + pokemon.getNombre());
        labelNombre.setAlignmentX(LEFT_ALIGNMENT);
        add(labelNombre);

        JLabel tipoLabel = new JLabel("Tipo:");
        tipoLabel.setAlignmentX(LEFT_ALIGNMENT);
        add(tipoLabel);
        tipoField = new JTextField(pokemon.getTipo());
        tipoField.setAlignmentX(LEFT_ALIGNMENT);
        add(tipoField);

        JLabel alturaLabel = new JLabel("Altura:");
        alturaLabel.setAlignmentX(LEFT_ALIGNMENT);
        add(alturaLabel);
        alturaField = new JTextField(pokemon.getAltura() + "");
        alturaField.setAlignmentX(LEFT_ALIGNMENT);
        add(alturaField);

        JLabel pesoLabel = new JLabel("Peso:");
        pesoLabel.setAlignmentX(LEFT_ALIGNMENT);
        add(pesoLabel);
        pesoField = new JTextField(pokemon.getPeso() + "");
        pesoField.setAlignmentX(LEFT_ALIGNMENT);
        add(pesoField);

        saludBar = new JProgressBar(0, 340);
        saludBar.setValue(0);
        saludTimer = new Timer(15, new ActionListener() {
            private int value = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (value < pokemon.getSalud()) {
                    value++;
                    saludBar.setValue(value);
                } else {
                    saludTimer.stop();
                }
            }
        });
        saludTimer.start();
        saludBar.setStringPainted(true);
        saludBar.setString(Integer.toString(pokemon.getSalud()));
        saludBar.setForeground(Color.RED);
        saludBar.setAlignmentX(LEFT_ALIGNMENT);
        add(new JLabel("Salud: "));
        add(saludBar);

        ataqueBar = new JProgressBar(0, 200);
        ataqueBar.setValue(0);
        ataqueTimer = new Timer(15, new ActionListener() {
            private int value = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (value < pokemon.getAtaque()) {
                    value++;
                    ataqueBar.setValue(value);
                } else {
                    ataqueTimer.stop();
                }
            }
        });
        ataqueTimer.start();
        ataqueBar.setStringPainted(true);
        ataqueBar.setString(Integer.toString(pokemon.getAtaque()));
        ataqueBar.setForeground(new Color(255, 165, 0));
        ataqueBar.setAlignmentX(LEFT_ALIGNMENT);
        ataqueLabel = new JLabel("Ataque: ");
        ataqueLabel.setAlignmentX(LEFT_ALIGNMENT);
        add(ataqueLabel);
        add(ataqueBar);

        ataqueEspecialBar = new JProgressBar(0, 200);
        ataqueEspecialBar.setValue(0);
        ataqueEspecialTimer = new Timer(15, new ActionListener() {
            private int value = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (value < pokemon.getAtaqueEspecial()) {
                    value++;
                    ataqueEspecialBar.setValue(value);
                } else {
                    ataqueEspecialTimer.stop();
                }
            }
        });
        ataqueEspecialTimer.start();
        ataqueEspecialBar.setStringPainted(true);
        ataqueEspecialBar.setString(Integer.toString(pokemon.getAtaqueEspecial()));
        ataqueEspecialBar.setForeground(new Color(153, 50, 204));
        ataqueEspecialBar.setAlignmentX(LEFT_ALIGNMENT);
        ataqueEspecialLabel = new JLabel("Ataque Especial: ");
        ataqueEspecialLabel.setAlignmentX(LEFT_ALIGNMENT);
        add(ataqueEspecialLabel);
        add(ataqueEspecialBar);

        defensaBar = new JProgressBar(0, 200);
        defensaBar.setValue(0);
        defensaTimer = new Timer(15, new ActionListener() {
            private int value = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (value < pokemon.getDefensa()) {
                    value++;
                    defensaBar.setValue(value);
                } else {
                    defensaTimer.stop();
                }
            }
        });
        defensaTimer.start();
        defensaBar.setStringPainted(true);
        defensaBar.setString(Integer.toString(pokemon.getDefensa()));
        defensaBar.setForeground(new Color(0, 191, 255));
        defensaBar.setAlignmentX(LEFT_ALIGNMENT);
        defensaLabel = new JLabel("Defensa: ");
        defensaLabel.setAlignmentX(LEFT_ALIGNMENT);
        add(defensaLabel);
        add(defensaBar);

        defensaEspecialBar = new JProgressBar(0, 200);
        defensaEspecialBar.setValue(0);
        defensaEspecialTimer = new Timer(15, new ActionListener() {
            private int value = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (value < pokemon.getDefensaEspecial()) {
                    value++;
                    defensaEspecialBar.setValue(value);
                } else {
                    defensaEspecialTimer.stop();
                }
            }
        });
        defensaEspecialTimer.start();
        defensaEspecialBar.setStringPainted(true);
        defensaEspecialBar.setString(Integer.toString(pokemon.getDefensaEspecial()));
        defensaEspecialBar.setForeground(new Color(34, 139, 34));
        defensaEspecialBar.setAlignmentX(LEFT_ALIGNMENT);
        defensaEspecialLabel = new JLabel("Defensa Especial: ");
        defensaEspecialLabel.setAlignmentX(LEFT_ALIGNMENT);
        add(defensaEspecialLabel);
        add(defensaEspecialBar);

        velocidadBar = new JProgressBar(0, 200);
        velocidadBar.setValue(0);
        velocidadTimer = new Timer(15, new ActionListener() {
            private int value = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (value < pokemon.getVelocidad()) {
                    value++;
                    velocidadBar.setValue(value);
                } else {
                    velocidadTimer.stop();
                }
            }
        });
        velocidadTimer.start();
        velocidadBar.setStringPainted(true);
        velocidadBar.setString(Integer.toString(pokemon.getVelocidad()));
        velocidadBar.setForeground(new Color(255, 69, 0));
        velocidadBar.setAlignmentX(LEFT_ALIGNMENT);
        velocidadLabel = new JLabel("Velocidad: ");
        velocidadLabel.setAlignmentX(LEFT_ALIGNMENT);
        add(velocidadLabel);
        add(velocidadBar);

        legendarioPanel = new JPanel();
        legendarioPanel.setLayout(new BoxLayout(legendarioPanel, BoxLayout.X_AXIS));
        legendarioPanel.setAlignmentX(LEFT_ALIGNMENT);
        legendarioLabel = new JLabel("Legendario: ");
        legendarioLabel.setAlignmentX(LEFT_ALIGNMENT);
        legendarioPanel.add(legendarioLabel);

        legendarioGroup = new ButtonGroup();
        legendarioSi = new JRadioButton("Sí");
        legendarioNo = new JRadioButton("No");
        legendarioSi.setEnabled(false);
        legendarioNo.setEnabled(false);
        legendarioGroup.add(legendarioSi);
        legendarioGroup.add(legendarioNo);
        if (pokemon.isLegendario()) {
            legendarioSi.setSelected(true);
        } else {
            legendarioNo.setSelected(true);
        }
        legendarioPanel.add(legendarioSi);
        legendarioPanel.add(legendarioNo);

        add(legendarioPanel);

        ataquesLabel = new JLabel("Ataques: ");
        ataquesLabel.setAlignmentX(LEFT_ALIGNMENT);
        add(ataquesLabel);
        ataquesTextField = new JTextField(String.join(", ", pokemon.getAtaques()));
        ataquesTextField.setAlignmentX(LEFT_ALIGNMENT);
        add(ataquesTextField);

        generacionLabel = new JLabel("Generación: " + pokemon.getGeneracion());
        generacionLabel.setAlignmentX(LEFT_ALIGNMENT);
        add(generacionLabel);

        add(botonActualizarPanel);

        deshabilitarEntradas();
    }

    /**
     * Habilita la edición de los campos de entrada para la actualización de la información del Pokémon.
     * Activa el botón de actualización y permite la edición de los campos de texto y la selección de si es legendario o no.
     */
    public void habilitarEntradas() {
        tipoField.setEditable(true);
        alturaField.setEditable(true);
        pesoField.setEditable(true);
        ataquesTextField.setEditable(true);
        legendarioSi.setEnabled(true);
        legendarioNo.setEnabled(true);
        botonActualizarPanel.setVisible(true);
        revalidate();
        repaint();
    }

    /**
     * Deshabilita la edición de los campos de entrada para evitar la modificación de la información del Pokémon.
     * Desactiva el botón de actualización y bloquea los campos de texto y la selección de si es legendario o no.
     */
    public void deshabilitarEntradas() {
        tipoField.setEditable(false);
        alturaField.setEditable(false);
        pesoField.setEditable(false);
        ataquesTextField.setEditable(false);
        legendarioSi.setEnabled(false);
        legendarioNo.setEnabled(false);
        botonActualizarPanel.setVisible(false);
    }
    
    /**
     * Valida los campos de entrada para asegurar que contienen información válida antes de actualizar la información del Pokémon.
     * Verifica que los campos de tipo, altura, peso y ataques no estén vacíos y que el número de ataques no exceda el máximo permitido.
     * 
     * @return true si todos los campos son válidos, false en caso contrario.
     */
    public boolean validarEntradas() {
        if (tipoField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de tipo está vacío.", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (alturaField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de altura está vacío.", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (pesoField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de peso está vacío.", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (ataquesTextField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de ataques está vacío.", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String ataques = ataquesTextField.getText().trim().replace("[", "").replace("]", "");
        String[] ataquesArray = ataques.split(",");
        if (ataquesArray.length > 4) {
            JOptionPane.showMessageDialog(this, "Un Pokémon puede aprender un máximo de 4 ataques.", "Error en cantidad de ataques", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    /**
     * Obtiene el JLabel asociado al ID del Pokémon.
     * @return JLabel que muestra el ID del Pokémon.
     */
    public JLabel getIdLabel() {
        return idLabel;
    }

    /**
     * Establece el JLabel asociado al ID del Pokémon.
     * @param idLabel JLabel que muestra el ID del Pokémon.
     */
    public void setIdLabel(JLabel idLabel) {
        this.idLabel = idLabel;
    }

    /**
     * Obtiene el JLabel asociado al nombre del Pokémon.
     * @return JLabel que muestra el nombre del Pokémon.
     */
    public JLabel getLabelNombre() {
        return labelNombre;
    }

    /**
     * Establece el JLabel asociado al nombre del Pokémon.
     * @param labelNombre JLabel que muestra el nombre del Pokémon.
     */
    public void setLabelNombre(JLabel labelNombre) {
        this.labelNombre = labelNombre;
    }

    /**
     * Obtiene el campo de texto para el tipo del Pokémon.
     * @return JTextField que permite la entrada del tipo del Pokémon.
     */
    public JTextField getTipoField() {
        return tipoField;
    }

    /**
     * Establece el campo de texto para el tipo del Pokémon.
     * @param tipoField JTextField que permite la entrada del tipo del Pokémon.
     */
    public void setTipoField(JTextField tipoField) {
        this.tipoField = tipoField;
    }

    /**
     * Obtiene el campo de texto para la altura del Pokémon.
     * @return JTextField que permite la entrada de la altura del Pokémon.
     */
    public JTextField getAlturaField() {
        return alturaField;
    }

    /**
     * Establece el campo de texto para la altura del Pokémon.
     * @param alturaField JTextField que permite la entrada de la altura del Pokémon.
     */
    public void setAlturaField(JTextField alturaField) {
        this.alturaField = alturaField;
    }

    /**
     * Obtiene el campo de texto para el peso del Pokémon.
     * @return JTextField que permite la entrada del peso del Pokémon.
     */
    public JTextField getPesoField() {
        return pesoField;
    }

    /**
     * Establece el campo de texto para el peso del Pokémon.
     * @param pesoField JTextField que permite la entrada del peso del Pokémon.
     */
    public void setPesoField(JTextField pesoField) {
        this.pesoField = pesoField;
    }

    /**
     * Obtiene la barra de progreso que muestra la salud del Pokémon.
     * @return JProgressBar que representa la salud del Pokémon.
     */
    public JProgressBar getSaludBar() {
        return saludBar;
    }

    /**
     * Establece la barra de progreso que muestra la salud del Pokémon.
     * @param saludBar JProgressBar que representa la salud del Pokémon.
     */
    public void setSaludBar(JProgressBar saludBar) {
        this.saludBar = saludBar;
    }

    /**
     * Obtiene la barra de progreso que muestra el ataque del Pokémon.
     * @return JProgressBar que representa el ataque del Pokémon.
     */
    public JProgressBar getAtaqueBar() {
        return ataqueBar;
    }

    /**
     * Establece la barra de progreso que muestra el ataque del Pokémon.
     * @param ataqueBar JProgressBar que representa el ataque del Pokémon.
     */
    public void setAtaqueBar(JProgressBar ataqueBar) {
        this.ataqueBar = ataqueBar;
    }

    /**
     * Obtiene la barra de progreso que muestra el ataque especial del Pokémon.
     * @return JProgressBar que representa el ataque especial del Pokémon.
     */
    public JProgressBar getAtaqueEspecialBar() {
        return ataqueEspecialBar;
    }

    /**
     * Establece la barra de progreso que muestra el ataque especial del Pokémon.
     * @param ataqueEspecialBar JProgressBar que representa el ataque especial del Pokémon.
     */
    public void setAtaqueEspecialBar(JProgressBar ataqueEspecialBar) {
        this.ataqueEspecialBar = ataqueEspecialBar;
    }

    /**
     * Obtiene la barra de progreso que muestra la defensa del Pokémon.
     * @return JProgressBar que representa la defensa del Pokémon.
     */
    public JProgressBar getDefensaBar() {
        return defensaBar;
    }

    /**
     * Establece la barra de progreso que muestra la defensa del Pokémon.
     * @param defensaBar JProgressBar que representa la defensa del Pokémon.
     */
    public void setDefensaBar(JProgressBar defensaBar) {
        this.defensaBar = defensaBar;
    }

    /**
     * Obtiene la barra de progreso que muestra la defensa especial del Pokémon.
     * @return JProgressBar que representa la defensa especial del Pokémon.
     */
    public JProgressBar getDefensaEspecialBar() {
        return defensaEspecialBar;
    }

    /**
     * Establece la barra de progreso que muestra la defensa especial del Pokémon.
     * @param defensaEspecialBar JProgressBar que representa la defensa especial del Pokémon.
     */
    public void setDefensaEspecialBar(JProgressBar defensaEspecialBar) {
        this.defensaEspecialBar = defensaEspecialBar;
    }

    /**
     * Obtiene la barra de progreso que muestra la velocidad del Pokémon.
     * @return JProgressBar que representa la velocidad del Pokémon.
     */
    public JProgressBar getVelocidadBar() {
        return velocidadBar;
    }

    /**
     * Establece la barra de progreso que muestra la velocidad del Pokémon.
     * @param velocidadBar JProgressBar que representa la velocidad del Pokémon.
     */
    public void setVelocidadBar(JProgressBar velocidadBar) {
        this.velocidadBar = velocidadBar;
    }

    /**
     * Obtiene el panel que contiene los botones de radio para seleccionar si el Pokémon es legendario o no.
     * @return JPanel que contiene los botones de radio para la selección.
     */
    public JPanel getLegendarioPanel() {
        return legendarioPanel;
    }

    /**
     * Establece el panel que contiene los botones de radio para seleccionar si el Pokémon es legendario o no.
     * @param legendarioPanel JPanel que contiene los botones de radio para la selección.
     */
    public void setLegendarioPanel(JPanel legendarioPanel) {
        this.legendarioPanel = legendarioPanel;
    }

    /**
     * Obtiene el campo de texto para los ataques del Pokémon.
     * @return JTextField que permite la entrada de los ataques del Pokémon.
     */
    public JTextField getAtaquesTextField() {
        return ataquesTextField;
    }

    /**
     * Establece el campo de texto para los ataques del Pokémon.
     * @param ataquesTextField JTextField que permite la entrada de los ataques del Pokémon.
     */
    public void setAtaquesTextField(JTextField ataquesTextField) {
        this.ataquesTextField = ataquesTextField;
    }

    /**
     * Obtiene el JLabel que muestra la imagen del Pokémon.
     * @return JLabel que contiene la imagen del Pokémon.
     */
    public JLabel getImageLabel() {
        return imageLabel;
    }

    /**
     * Establece el JLabel que muestra la imagen del Pokémon.
     * @param imageLabel JLabel que contiene la imagen del Pokémon.
     */
    public void setImageLabel(JLabel imageLabel) {
        this.imageLabel = imageLabel;
    }

    /**
     * Obtiene el JLabel que muestra el texto "Ataque".
     * @return JLabel que contiene el texto "Ataque".
     */
    public JLabel getAtaqueLabel() {
        return ataqueLabel;
    }

    /**
     * Establece el JLabel que muestra el texto "Ataque".
     * @param ataqueLabel JLabel que contiene el texto "Ataque".
     */
    public void setAtaqueLabel(JLabel ataqueLabel) {
        this.ataqueLabel = ataqueLabel;
    }

    /**
     * Obtiene el JLabel que muestra el texto "Ataque Especial".
     * @return JLabel que contiene el texto "Ataque Especial".
     */
    public JLabel getAtaqueEspecialLabel() {
        return ataqueEspecialLabel;
    }

    /**
     * Establece el JLabel que muestra el texto "Ataque Especial".
     * @param ataqueEspecialLabel JLabel que contiene el texto "Ataque Especial".
     */
    public void setAtaqueEspecialLabel(JLabel ataqueEspecialLabel) {
        this.ataqueEspecialLabel = ataqueEspecialLabel;
    }

    /**
     * Obtiene el JLabel que muestra el texto "Defensa".
     * @return JLabel que contiene el texto "Defensa".
     */
    public JLabel getDefensaLabel() {
        return defensaLabel;
    }

    /**
     * Establece el JLabel que muestra el texto "Defensa".
     * @param defensaLabel JLabel que contiene el texto "Defensa".
     */
    public void setDefensaLabel(JLabel defensaLabel) {
        this.defensaLabel = defensaLabel;
    }

    /**
     * Obtiene el JLabel que muestra el texto "Defensa Especial".
     * @return JLabel que contiene el texto "Defensa Especial".
     */
    public JLabel getDefensaEspecialLabel() {
        return defensaEspecialLabel;
    }

    /**
     * Establece el JLabel que muestra el texto "Defensa Especial".
     * @param defensaEspecialLabel JLabel que contiene el texto "Defensa Especial".
     */
    public void setDefensaEspecialLabel(JLabel defensaEspecialLabel) {
        this.defensaEspecialLabel = defensaEspecialLabel;
    }

    /**
     * Obtiene el JLabel que muestra el texto "Velocidad".
     * @return JLabel que contiene el texto "Velocidad".
     */
    public JLabel getVelocidadLabel() {
        return velocidadLabel;
    }

    /**
     * Establece el JLabel que muestra el texto "Velocidad".
     * @param velocidadLabel JLabel que contiene el texto "Velocidad".
     */
    public void setVelocidadLabel(JLabel velocidadLabel) {
        this.velocidadLabel = velocidadLabel;
    }

    /**
     * Obtiene el JLabel que muestra el texto "Legendario".
     * @return JLabel que contiene el texto "Legendario".
     */
    public JLabel getLegendarioLabel() {
        return legendarioLabel;
    }

    /**
     * Establece el JLabel que muestra el texto "Legendario".
     * @param legendarioLabel JLabel que contiene el texto "Legendario".
     */
    public void setLegendarioLabel(JLabel legendarioLabel) {
        this.legendarioLabel = legendarioLabel;
    }

    /**
     * Obtiene el JRadioButton para seleccionar si el Pokémon es legendario.
     * @return JRadioButton que permite seleccionar la opción "Sí".
     */
    public JRadioButton getLegendarioSi() {
        return legendarioSi;
    }

    /**
     * Establece el JRadioButton para seleccionar si el Pokémon es legendario.
     * @param legendarioSi JRadioButton que permite seleccionar la opción "Sí".
     */
    public void setLegendarioSi(JRadioButton legendarioSi) {
        this.legendarioSi = legendarioSi;
    }

    /**
     * Obtiene el JRadioButton para seleccionar si el Pokémon no es legendario.
     * @return JRadioButton que permite seleccionar la opción "No".
     */
    public JRadioButton getLegendarioNo() {
        return legendarioNo;
    }

    /**
     * Establece el JRadioButton para seleccionar si el Pokémon no es legendario.
     * @param legendarioNo JRadioButton que permite seleccionar la opción "No".
     */
    public void setLegendarioNo(JRadioButton legendarioNo) {
        this.legendarioNo = legendarioNo;
    }

    /**
     * Obtiene el grupo de botones que permite seleccionar si el Pokémon es legendario o no.
     * @return ButtonGroup que agrupa los botones de radio para la selección.
     */
    public ButtonGroup getLegendarioGroup() {
        return legendarioGroup;
    }

    /**
     * Establece el grupo de botones que permite seleccionar si el Pokémon es legendario o no.
     * @param legendarioGroup ButtonGroup que agrupa los botones de radio para la selección.
     */
    public void setLegendarioGroup(ButtonGroup legendarioGroup) {
        this.legendarioGroup = legendarioGroup;
    }

    /**
     * Obtiene el JLabel que muestra la generación del Pokémon.
     * @return JLabel que contiene la generación del Pokémon.
     */
    public JLabel getGeneracionLabel() {
        return generacionLabel;
    }

    /**
     * Establece el JLabel que muestra la generación del Pokémon.
     * @param generacionLabel JLabel que contiene la generación del Pokémon.
     */
    public void setGeneracionLabel(JLabel generacionLabel) {
        this.generacionLabel = generacionLabel;
    }

    /**
     * Obtiene el JButton que permite actualizar la información del Pokémon.
     * @return JButton que activa la actualización de la información.
     */
    public JButton getActualizarButton() {
        return actualizarButton;
    }

    /**
     * Establece el JButton que permite actualizar la información del Pokémon.
     * @param actualizarButton JButton que activa la actualización de la información.
     */
    public void setActualizarButton(JButton actualizarButton) {
        this.actualizarButton = actualizarButton;
    }

    /**
     * Obtiene el panel que contiene el botón de actualización.
     * @return JPanel que contiene el botón de actualización.
     */
    public JPanel getBotonActualizarPanel() {
        return botonActualizarPanel;
    }

    /**
     * Establece el panel que contiene el botón de actualización.
     * @param botonActualizarPanel JPanel que contiene el botón de actualización.
     */
    public void setBotonActualizarPanel(JPanel botonActualizarPanel) {
        this.botonActualizarPanel = botonActualizarPanel;
    }

    /**
     * Obtiene el temporizador para la animación de la barra de progreso de salud.
     * @return Timer que controla la animación de la barra de progreso de salud.
     */
    public Timer getSaludTimer() {
        return saludTimer;
    }

    /**
     * Establece el temporizador para la animación de la barra de progreso de salud.
     * @param saludTimer Timer que controla la animación de la barra de progreso de salud.
     */
    public void setSaludTimer(Timer saludTimer) {
        this.saludTimer = saludTimer;
    }

    /**
     * Obtiene el temporizador para la animación de la barra de progreso de ataque.
     * @return Timer que controla la animación de la barra de progreso de ataque.
     */
    public Timer getAtaqueTimer() {
        return ataqueTimer;
    }

    /**
     * Establece el temporizador para la animación de la barra de progreso de ataque.
     * @param ataqueTimer Timer que controla la animación de la barra de progreso de ataque.
     */
    public void setAtaqueTimer(Timer ataqueTimer) {
        this.ataqueTimer = ataqueTimer;
    }

    /**
     * Obtiene el temporizador para la animación de la barra de progreso de ataque especial.
     * @return Timer que controla la animación de la barra de progreso de ataque especial.
     */
    public Timer getAtaqueEspecialTimer() {
        return ataqueEspecialTimer;
    }

    /**
     * Establece el temporizador para la animación de la barra de progreso de ataque especial.
     * @param ataqueEspecialTimer Timer que controla la animación de la barra de progreso de ataque especial.
     */
    public void setAtaqueEspecialTimer(Timer ataqueEspecialTimer) {
        this.ataqueEspecialTimer = ataqueEspecialTimer;
    }

    /**
     * Obtiene el temporizador para la animación de la barra de progreso de defensa.
     * @return Timer que controla la animación de la barra de progreso de defensa.
     */
    public Timer getDefensaTimer() {
        return defensaTimer;
    }

    /**
     * Establece el temporizador para la animación de la barra de progreso de defensa.
     * @param defensaTimer Timer que controla la animación de la barra de progreso de defensa.
     */
    public void setDefensaTimer(Timer defensaTimer) {
        this.defensaTimer = defensaTimer;
    }

    /**
     * Obtiene el temporizador para la animación de la barra de progreso de defensa especial.
     * @return Timer que controla la animación de la barra de progreso de defensa especial.
     */
    public Timer getDefensaEspecialTimer() {
        return defensaEspecialTimer;
    }

    /**
     * Establece el temporizador para la animación de la barra de progreso de defensa especial.
     * @param defensaEspecialTimer Timer que controla la animación de la barra de progreso de defensa especial.
     */
    public void setDefensaEspecialTimer(Timer defensaEspecialTimer) {
        this.defensaEspecialTimer = defensaEspecialTimer;
    }

    /**
     * Obtiene el temporizador para la animación de la barra de progreso de velocidad.
     * @return Timer que controla la animación de la barra de progreso de velocidad.
     */
    public Timer getVelocidadTimer() {
        return velocidadTimer;
    }

    /**
     * Establece el temporizador para la animación de la barra de progreso de velocidad.
     * @param velocidadTimer Timer que controla la animación de la barra de progreso de velocidad.
     */
    public void setVelocidadTimer(Timer velocidadTimer) {
        this.velocidadTimer = velocidadTimer;
    }

    /**
     * Obtiene el identificador único para la serialización.
     * @return long que representa el identificador único para la serialización.
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
