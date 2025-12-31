package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa un Pokémon con todas sus características básicas y comportamientos.
 * Implementa la interfaz Serializable para permitir su serialización.
 */
public class PokemonDTO implements Serializable {

    /**
     * Identificador único para la serialización.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Identificador único para cada Pokémon.
     */
    private int id;
    /**
     * Nombre del Pokémon.
     */
    private String nombre;
    /**
     * Tipo del Pokémon, por ejemplo, agua, fuego, etc.
     */
    private String tipo;
    /**
     * Altura del Pokémon en metros.
     */
    private float altura;
    /**
     * Peso del Pokémon en kilogramos.
     */
    private float peso;
    /**
     * Puntos de salud del Pokémon.
     */
    private int salud;
    /**
     * Puntos de ataque físico del Pokémon.
     */
    private int ataque;
    /**
     * Puntos de ataque especial del Pokémon.
     */
    private int ataqueEspecial;
    /**
     * Puntos de defensa física del Pokémon.
     */
    private int defensa;
    /**
     * Puntos de defensa especial del Pokémon.
     */
    private int defensaEspecial;
    /**
     * Velocidad del Pokémon.
     */
    private int velocidad;
    /**
     * Indica si el Pokémon es legendario o no.
     */
    private boolean legendario;
    /**
     * Lista de ataques que el Pokémon puede realizar.
     */
    private ArrayList<String> ataques;
    /**
     * Generación a la que pertenece el Pokémon dentro del universo Pokémon.
     */
    private int generacion;

    /**
     * Constructor para crear una instancia de un Pokémon con todas sus propiedades.
     * 
     * @param id Identificador único del Pokémon.
     * @param nombre Nombre del Pokémon.
     * @param tipo Tipo del Pokémon.
     * @param altura Altura del Pokémon en metros.
     * @param peso Peso del Pokémon en kilogramos.
     * @param salud Puntos de salud del Pokémon.
     * @param ataque Puntos de ataque físico del Pokémon.
     * @param ataqueEspecial Puntos de ataque especial del Pokémon.
     * @param defensa Puntos de defensa física del Pokémon.
     * @param defensaEspecial Puntos de defensa especial del Pokémon.
     * @param velocidad Velocidad del Pokémon.
     * @param legendario Indica si el Pokémon es legendario.
     * @param ataques Lista de ataques que el Pokémon puede realizar.
     * @param generacion Generación a la que pertenece el Pokémon.
     */
    public PokemonDTO(int id, String nombre, String tipo, float altura, float peso, int salud, int ataque,
            int ataqueEspecial, int defensa, int defensaEspecial, int velocidad, boolean legendario,
            ArrayList<String> ataques, int generacion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.altura = altura;
        this.peso = peso;
        this.salud = salud;
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
        this.defensa = defensa;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.legendario = legendario;
        this.ataques = ataques;
        this.generacion = generacion;
    }

    /**
     * Obtiene el identificador único del Pokémon.
     * 
     * @return El identificador único del Pokémon.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del Pokémon.
     * 
     * @param id El nuevo identificador único del Pokémon.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del Pokémon.
     * 
     * @return El nombre del Pokémon.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del Pokémon.
     * 
     * @param nombre El nuevo nombre del Pokémon.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tipo del Pokémon.
     * 
     * @return El tipo del Pokémon.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo del Pokémon.
     * 
     * @param tipo El nuevo tipo del Pokémon.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la altura del Pokémon.
     * 
     * @return La altura del Pokémon en metros.
     */
    public float getAltura() {
        return altura;
    }

    /**
     * Establece la altura del Pokémon.
     * 
     * @param altura La nueva altura del Pokémon en metros.
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }

    /**
     * Obtiene el peso del Pokémon.
     * 
     * @return El peso del Pokémon en kilogramos.
     */
    public float getPeso() {
        return peso;
    }

    /**
     * Establece el peso del Pokémon.
     * 
     * @param peso El nuevo peso del Pokémon en kilogramos.
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * Obtiene los puntos de salud del Pokémon.
     * 
     * @return Los puntos de salud del Pokémon.
     */
    public int getSalud() {
        return salud;
    }

    /**
     * Establece los puntos de salud del Pokémon.
     * 
     * @param salud Los nuevos puntos de salud del Pokémon.
     */
    public void setSalud(int salud) {
        this.salud = salud;
    }

    /**
     * Obtiene los puntos de ataque físico del Pokémon.
     * 
     * @return Los puntos de ataque físico del Pokémon.
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Establece los puntos de ataque físico del Pokémon.
     * 
     * @param ataque Los nuevos puntos de ataque físico del Pokémon.
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    /**
     * Obtiene los puntos de ataque especial del Pokémon.
     * 
     * @return Los puntos de ataque especial del Pokémon.
     */
    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    /**
     * Establece los puntos de ataque especial del Pokémon.
     * 
     * @param ataqueEspecial Los nuevos puntos de ataque especial del Pokémon.
     */
    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    /**
     * Obtiene los puntos de defensa física del Pokémon.
     * 
     * @return Los puntos de defensa física del Pokémon.
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     * Establece los puntos de defensa física del Pokémon.
     * 
     * @param defensa Los nuevos puntos de defensa física del Pokémon.
     */
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    /**
     * Obtiene los puntos de defensa especial del Pokémon.
     * 
     * @return Los puntos de defensa especial del Pokémon.
     */
    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    /**
     * Establece los puntos de defensa especial del Pokémon.
     * 
     * @param defensaEspecial Los nuevos puntos de defensa especial del Pokémon.
     */
    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
    }

    /**
     * Obtiene la velocidad del Pokémon.
     * 
     * @return La velocidad del Pokémon.
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * Establece la velocidad del Pokémon.
     * 
     * @param velocidad La nueva velocidad del Pokémon.
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Determina si el Pokémon es legendario.
     * 
     * @return Verdadero si el Pokémon es legendario, falso en caso contrario.
     */
    public boolean isLegendario() {
        return legendario;
    }

    /**
     * Establece si el Pokémon es legendario.
     * 
     * @param legendario Verdadero para indicar que el Pokémon es legendario, falso en caso contrario.
     */
    public void setLegendario(boolean legendario) {
        this.legendario = legendario;
    }

    /**
     * Obtiene la lista de ataques que el Pokémon puede realizar.
     * 
     * @return La lista de ataques del Pokémon.
     */
    public ArrayList<String> getAtaques() {
        return ataques;
    }

    /**
     * Establece la lista de ataques que el Pokémon puede realizar.
     * 
     * @param ataques La nueva lista de ataques del Pokémon.
     */
    public void setAtaques(ArrayList<String> ataques) {
        this.ataques = ataques;
    }

    /**
     * Obtiene la generación a la que pertenece el Pokémon.
     * 
     * @return La generación del Pokémon.
     */
    public int getGeneracion() {
        return generacion;
    }

    /**
     * Establece la generación a la que pertenece el Pokémon.
     * 
     * @param generacion La nueva generación del Pokémon.
     */
    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    /**
     * Genera una representación en cadena de texto de un Pokémon con todas sus propiedades.
     * 
     * @return Una cadena de texto que representa al Pokémon.
     */
    @Override
    public String toString() {
        return "PokemonDTO [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", altura=" + altura + ", peso="
                + peso + ", salud=" + salud + ", ataque=" + ataque + ", ataqueEspecial=" + ataqueEspecial + ", defensa="
                + defensa + ", defensaEspecial=" + defensaEspecial + ", velocidad=" + velocidad + ", legendario="
                + legendario + ", ataques=" + ataques + ", generacion=" + generacion + "]";
    }

}
