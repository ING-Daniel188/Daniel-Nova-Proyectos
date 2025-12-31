package co.edu.unbosque.model.persistence;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import co.edu.unbosque.model.PokemonDTO;

/**
 * Clase encargada de gestionar las operaciones de persistencia para los objetos Pokémon, incluyendo la lectura y escritura en archivos CSV y binarios.
 * Extiende de la clase abstracta Gestion, especializándose en el manejo de objetos de tipo PokemonDTO.
 * 
 * @see Gestion
 * @see PokemonDTO
 */
public class PokemonDAO extends Gestion<PokemonDTO> {

    /**
     * Ruta del archivo binario donde se almacenan los pokemones.
     */
    private final static String rutaBinarioPokemones = "pokemones.dat";
    /**
     * Ruta del archivo CSV de donde se leen los datos de los pokemones.
     */
    private final static String rutaCSVPokemones = "pokemon.csv";

    /**
     * Constructor que inicializa la ruta del archivo binario a utilizar por la clase padre Gestion.
     */
    public PokemonDAO() {
        super(rutaBinarioPokemones);
    }

    /**
     * Lee los datos de pokemones desde un archivo CSV y los convierte en una matriz de String para su uso en la aplicación.
     * 
     * @return Una matriz de String con los datos de los pokemones leídos del archivo CSV.
     * @throws Exception Si ocurre un error al leer el archivo.
     */
    public String[][] leerPokemonesDeCSV() {
        List<String[]> data = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(rutaCSVPokemones))) {
            String[] fila;
            
            // Saltar el encabezado
            csvReader.readNext();
            while ((fila = csvReader.readNext()) != null) {
                fila[11] = (Integer.parseInt(fila[11]) != 0)? "Si" : "No";
                data.add(fila);
            }
        } catch (Exception e) {
            return null;
        }
              
        // Convertir la lista a una matriz de String para su uso en la tabla, se omite el header
        String[][] datos = new String[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            datos[i] = data.get(i);
        }
        
        return datos;
    }

    /**
     * Lee los datos de pokemones desde un archivo CSV filtrados por tipo y los convierte en una matriz de String.
     * 
     * @param tipo El tipo de pokemon por el cual filtrar.
     * @return Una matriz de String con los datos de los pokemones filtrados por tipo.
     * @throws Exception Si ocurre un error al leer el archivo.
     */
    public String[][] leerPokemonesDeCSVFiltrados(String tipo) {
        List<String[]> data = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(rutaCSVPokemones))) {
            String[] fila;
            
            // Saltar el encabezado
            csvReader.readNext();
            while ((fila = csvReader.readNext()) != null) {
                if (tipo.equalsIgnoreCase(fila[2])) {                    
                    fila[11] = (Integer.parseInt(fila[11]) != 0)? "Si" : "No";
                    data.add(fila);
                }
            }
        } catch (Exception e) {
            return null;
        }
              
        // Convertir la lista a una matriz de String para su uso en la tabla, se omite el header
        String[][] datos = new String[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            datos[i] = data.get(i);
        }
        
        return datos;
    }

    /**
     * Busca un pokemon por su identificador único en la lista de pokemones gestionada.
     * 
     * @param id El identificador único del pokemon a buscar.
     * @return true si el pokemon es encontrado, false en caso contrario.
     */
    public boolean encontrarPokemon(int id) {
        return getListaObjetos().stream().filter(pokemon -> pokemon.getId() == id).findFirst().orElse(null) != null;
    }

    /**
     * Obtiene una matriz de objetos representando los pokemones filtrados por tipo.
     * 
     * @param tipo El tipo de pokemon por el cual filtrar.
     * @return Una matriz de objetos con los pokemones filtrados por tipo.
     */
    public Object[][] obtenerMatrizPokemonesPorTipo(String tipo) {
        return convertirListaObjetosAMatriz(new ArrayList<>(getListaObjetos().stream().filter(pokemon -> pokemon.getTipo().equals(tipo)).toList()));
    }

    /**
     * Actualiza la información de un pokemon en la lista de pokemones gestionada.
     * 
     * @param id El identificador único del pokemon a actualizar.
     * @param pokemon El objeto PokemonDTO con la información actualizada del pokemon.
     */
    public void actualizarPokemon(int id, PokemonDTO pokemon) {
        for (int i = 0; i < getListaObjetos().size(); i++) {
            if (getListaObjetos().get(i).getId() == id) {
                actualizar(i, pokemon);
                return;
            }
        }
    }

    /**
     * Elimina un pokemon de la lista de pokemones gestionada por su identificador único.
     * 
     * @param id El identificador único del pokemon a eliminar.
     */
    public void eliminarPokemon(int id) {
        for (int i = 0; i < getListaObjetos().size(); i++) {
            if (getListaObjetos().get(i).getId() == id) {
                eliminar(i);
                return;
            }
        }
    }

}
