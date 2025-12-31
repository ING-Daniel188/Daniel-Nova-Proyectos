package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que implementa las interfaces {@link ICrud} y {@link IArchivo} para gestionar la persistencia
 * de objetos de cualquier tipo en archivos binarios utilizando un {@link ArrayList} como estructura de almacenamiento.
 * <p>
 * Esta clase permite realizar operaciones básicas de CRUD (Crear, Leer, Actualizar, Eliminar) sobre una colección
 * de objetos, así como leer y escribir esta colección en un archivo binario. La ruta del archivo se especifica
 * en el constructor de la clase o puede ser nula si solo se desea manejar la colección en memoria.
 * <p>
 * Los objetos gestionados por esta clase deben ser serializables ya que se utilizan flujos de objetos
 * para escribir y leer del archivo.
 * 
 * @param <T> El tipo de objeto que se manejará en las operaciones CRUD y de archivo. Este tipo debe
 *            ser serializable y extender de {@code Object}.
 */
public class Gestion<T extends Object> implements ICrud<T>, IArchivo<ArrayList<T>> {
	
	/*
	 * Colección de objetos de tipo T
	 */
	private ArrayList<T> listaObjetos;
	
	/*
	 * Ruta del archivo binario donde se persisten los objetos
	 */
	private String ruta;
	
	/**
	 * Constructor por defecto que inicializa la lista de objetos y establece la ruta del archivo a null.
	 * Esto significa que la gestión de objetos se realizará solo en memoria.
	 */
	public Gestion() {
		this.listaObjetos = new ArrayList<>();
		this.ruta = null;
	}
	
	/**
	 * Constructor que inicializa la clase con una ruta de archivo específica.
	 * La lista de objetos se carga desde el archivo especificado en la ruta.
	 * 
	 * @param ruta La ruta del archivo binario donde se persistirán los objetos.
	 */
	public Gestion(String ruta) {
		this.ruta = ruta;
		listaObjetos = leer();
	}

	/**
	 * Agrega un nuevo objeto a la lista de objetos y, si la ruta del archivo no es nula,
	 * persiste la lista actualizada en el archivo.
	 * 
	 * @param objeto el objeto de tipo T a agregar.
	 */
	@Override
	public void agregar(T objeto) {
		if (objeto != null) {
			listaObjetos.add(objeto);
			if (ruta != null) {
				escribir(listaObjetos);
			}
		}
	}

	/**
	 * Obtiene un objeto de la lista por su índice. Si la ruta del archivo no es nula,
	 * recarga la lista desde el archivo antes de obtener el objeto.
	 * 
	 * @param indice el índice del objeto a obtener.
	 * @return el objeto de tipo T en el índice especificado o null si el índice es inválido.
	 */
	@Override
	public T obtener(int indice) {
		if (indice >= 0 && indice < listaObjetos.size()) {
			if (ruta != null) {
				listaObjetos = leer();
			}
			return listaObjetos.get(indice);
		}
		return null;
	}

	/**
	 * Actualiza un objeto existente en un índice específico con un nuevo objeto.
	 * Si la ruta del archivo no es nula, persiste la lista actualizada en el archivo.
	 * 
	 * @param indice el índice del objeto a actualizar.
	 * @param objeto el nuevo objeto de tipo T que reemplazará al existente.
	 * @return true si el objeto fue actualizado exitosamente, false en caso contrario.
	 */
	@Override
	public boolean actualizar(int indice, T objeto) {
		if (indice >= 0 && indice < listaObjetos.size() && objeto != null) {
			listaObjetos.set(indice, objeto);
			if (ruta != null) {
				escribir(listaObjetos);
			}
			return true;
		}
		return false;
	}

	/**
	 * Elimina un objeto de la lista en un índice dado. Si la ruta del archivo no es nula,
	 * persiste la lista actualizada en el archivo.
	 * 
	 * @param indice el índice del objeto a eliminar.
	 * @return true si el objeto fue eliminado exitosamente, false en caso contrario.
	 */
	@Override
	public boolean eliminar(int indice) {
		if (indice >= 0 && indice < listaObjetos.size()) {
			listaObjetos.remove(indice);
			if (ruta != null) {
				escribir(listaObjetos);
			}
			return true;
		}
		return false;
	}

	/**
	 * Escribe la lista de objetos en el archivo especificado por la ruta.
	 * Antes de escribir, verifica y crea los directorios necesarios si no existen.
	 * 
	 * @param object La lista de objetos de tipo T a escribir en el archivo.
	 * @return 0 si la escritura fue exitosa, -1 en caso de error.
	 */
	@Override
	public int escribir(ArrayList<T> object) {
		crearDirectoriosSiNoExisten(ruta);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
			oos.writeObject(object);
			return 0;
		} catch (IOException e) {
			return -1;
		}
	}

	/**
	 * Lee la lista de objetos desde el archivo especificado por la ruta.
	 * 
	 * @return La lista de objetos de tipo T leída desde el archivo. Si ocurre un error,
	 * retorna una lista vacía.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<T> leer() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
			return (ArrayList<T>) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			return new ArrayList<T>();
		}
	}
	
	/**
	 * Verifica si los directorios de la ruta especificada existen, y si no, los crea.
	 * 
	 * @param ruta La ruta del archivo para verificar y crear directorios.
	 */
	public void crearDirectoriosSiNoExisten(String ruta) {
		File file = new File(ruta);
		if (file.getParentFile() != null && !file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
	}
	
	/**
	 * Convierte una lista de objetos de tipo T a una matriz bidimensional de objetos.
	 * Cada fila de la matriz representa un objeto de la lista, y cada columna dentro de esa fila
	 * representa un atributo del objeto. Los atributos se obtienen mediante reflexión, excluyendo
	 * explícitamente el atributo {@code serialVersionUID} para evitar su inclusión en la matriz.
	 * 
	 * Este método facilita la manipulación y visualización de los datos de los objetos, permitiendo
	 * representar la información de los objetos en estructuras como tablas o grillas en interfaces gráficas.
	 * 
	 * @param listaObjetos La lista de objetos de tipo T que se desea convertir a matriz.
	 * @return Una matriz de objetos que representa los atributos de cada objeto en la lista.
	 *         Cada fila corresponde a un objeto, y cada columna a uno de sus atributos.
	 *         Retorna {@code null} si se produce una excepción de acceso ilegal al intentar acceder a los atributos.
	 */
	public Object[][] convertirListaObjetosAMatriz(ArrayList<T> listaObjetos) {
	    int numeroObjetos = listaObjetos.size();
	    int numeroAtributos = 0;

	    if (numeroObjetos > 0) {
	        Field[] atributos = recopilarAtributosDeClase(listaObjetos.get(0).getClass());
	        for (Field campo : atributos) {
	            if (!campo.getName().equals("serialVersionUID")) {
	                numeroAtributos++;
	            }
	        }
	    }

	    Object[][] matrizObjetos = new Object[numeroObjetos][numeroAtributos];

	    for (int i = 0; i < numeroObjetos; i++) {
	        T objeto = listaObjetos.get(i);
	        Field[] atributos = recopilarAtributosDeClase(objeto.getClass());
	        int indiceAtributoValido = 0;
	        for (Field campo : atributos) {
	            try {
	                if (!campo.getName().equals("serialVersionUID")) {
	                    campo.setAccessible(true);
	                    matrizObjetos[i][indiceAtributoValido] = campo.get(objeto);
	                    indiceAtributoValido++;
	                }
	            } catch (IllegalAccessException e) {
	                return null;
	            }
	        }
	    }

	    return matrizObjetos;
	}

	/**
	 * Recopila todos los atributos de una clase, incluyendo los heredados de sus superclases.
	 * Esto es útil para obtener una vista completa de los atributos de un objeto, independientemente
	 * de su jerarquía de clases.
	 *
	 * @param clase La clase para la cual recopilar atributos.
	 * @return Un arreglo de {@link Field} que contiene todos los atributos de la clase especificada.
	 */
	public Field[] recopilarAtributosDeClase(Class<?> clase) {
		ArrayList<Field> atributos = new ArrayList<>();

		ArrayList<Class<?>> clases = new ArrayList<>();
		while (clase != null) {
			clases.add(clase);
			clase = clase.getSuperclass();
		}

		Collections.reverse(clases);

		for (Class<?> type : clases) {
			for (Field atributo : type.getDeclaredFields()) {
				if (!atributo.getName().equals("serialVersionUID")) {
					atributos.add(atributo);
				}
			}
		}

		return atributos.toArray(new Field[0]);
	}
	
	/**
	 * Convierte la lista actual de objetos almacenada en la clase a una matriz bidimensional de objetos.
	 * Este método actúa como un puente para {@code convertirListaObjetosAMatriz}, utilizando la lista actual
	 * de objetos gestionados por esta instancia de {@code Gestion}.
	 * 
	 * La conversión permite representar cada objeto de la lista como una fila en la matriz, y cada atributo
	 * de un objeto como una columna dentro de esa fila, facilitando así su manipulación y visualización en
	 * estructuras como tablas o grillas en interfaces gráficas.
	 * 
	 * @return Una matriz de objetos que representa los atributos de cada objeto en la lista actual.
	 *         Cada fila corresponde a un objeto, y cada columna a uno de sus atributos.
	 *         Retorna {@code null} si se produce una excepción de acceso ilegal al intentar acceder a los atributos.
	 */
	public Object[][] convertirListaActualObjetosAMatriz() {
		return convertirListaObjetosAMatriz(getListaObjetos());
	}
	
	
	/**
	 * Obtiene la lista actual de objetos. Si la ruta del archivo no es nula,
	 * recarga la lista desde el archivo antes de retornarla.
	 * 
	 * @return La lista actual de objetos de tipo T.
	 */
	public ArrayList<T> getListaObjetos() {
		if (ruta != null) {
			listaObjetos = leer();
		}
		return listaObjetos;
	}
	
	/**
	 * Establece una nueva lista de objetos y, si la ruta del archivo no es nula,
	 * persiste la nueva lista en el archivo.
	 * 
	 * @param listaObjetos La nueva lista de objetos de tipo T.
	 */
	public void setListaObjetos(ArrayList<T> listaObjetos) {
		this.listaObjetos = listaObjetos;
		if (ruta != null) {
			escribir(listaObjetos);
		}
	}

}
