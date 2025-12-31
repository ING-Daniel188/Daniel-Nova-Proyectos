package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import co.edu.unbosque.model.FachadaCasaDeApuestas;
import co.edu.unbosque.view.VentanaApostadores;
import co.edu.unbosque.view.VentanaApuestaBaloto;
import co.edu.unbosque.view.VentanaCreacionApuestaBetPlay;
import co.edu.unbosque.view.VentanaFactura;
import co.edu.unbosque.view.VentanaModificacionApuestaBetPlay;
import co.edu.unbosque.view.VentanaApuestaChance;
import co.edu.unbosque.view.VentanaApuestaLoteria;
import co.edu.unbosque.view.VentanaApuestaSuperastro;
import co.edu.unbosque.view.VentanaApuestas;
import co.edu.unbosque.view.VentanaConsultas;
import co.edu.unbosque.view.VentanaParametrizacion;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.VentanaSedes;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements ActionListener {
	
	/** The casa. */
	private FachadaCasaDeApuestas casa;
	
	/** The vp. */
	private VentanaPrincipal vp;
	
	/** The v parametrizacion. */
	private VentanaParametrizacion vParametrizacion;
	
	/** The ventana sedes. */
	private VentanaSedes ventanaSedes;
	
	/** The ventana apostadores. */
	private VentanaApostadores ventanaApostadores;
	
	/** The ventana apuestas. */
	private VentanaApuestas ventanaApuestas;
	
	/** The ventana apuesta loteria. */
	private VentanaApuestaLoteria ventanaApuestaLoteria;
	
	/** The ventana apuesta superastro. */
	private VentanaApuestaSuperastro ventanaApuestaSuperastro;
	
	/** The ventana apuesta baloto. */
	private VentanaApuestaBaloto ventanaApuestaBaloto;
	
	/** The ventana apuesta chance. */
	private VentanaApuestaChance ventanaApuestaChance;
	
	/** The ventana creacion apuesta bet play. */
	private VentanaCreacionApuestaBetPlay ventanaCreacionApuestaBetPlay;
	
	/** The ventana modificacion apuesta bet play. */
	private VentanaModificacionApuestaBetPlay ventanaModificacionApuestaBetPlay;
	
	/** The ventana factura. */
	private VentanaFactura ventanaFactura;
	
	/** The ventana consultas. */
	private VentanaConsultas ventanaConsultas;

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		casa = new FachadaCasaDeApuestas();
		
		vp = new VentanaPrincipal(this);
		vp.setVisible(true);
		
		vParametrizacion = new VentanaParametrizacion(this);
		ventanaSedes = new VentanaSedes(this);
		ventanaApostadores = new VentanaApostadores(this);
		ventanaApuestas = new VentanaApuestas(this);
		
		// Ventanas de cada una de las apuestas
		ventanaApuestaLoteria = new VentanaApuestaLoteria(this);
		ventanaApuestaSuperastro = new VentanaApuestaSuperastro(this);
		ventanaApuestaBaloto = new VentanaApuestaBaloto(this);
		ventanaApuestaChance = new VentanaApuestaChance(this);
		ventanaCreacionApuestaBetPlay = new VentanaCreacionApuestaBetPlay(this);
		ventanaCreacionApuestaBetPlay.agregarPartidos(casa.getGestionBaloto().getArchivo().leerEquipos());
		ventanaModificacionApuestaBetPlay = new VentanaModificacionApuestaBetPlay(this);
		ventanaConsultas = new VentanaConsultas(this);
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Parametros de la casa de apuestas
		if (e.getSource() == vp.getBtnGestionParametros()) {
			vParametrizacion.setVisible(true);
			var juegos = casa.getGestorDeJuegos().getJuegos();
			if (juegos != null) {
				vParametrizacion.mostrarJuegos(juegos);
			}
		}
		
		if (e.getSource() == vParametrizacion.getGuardarButton()) {
			String nombre = vParametrizacion.getNombreField().getText();
		    String sedesStr = vParametrizacion.getSedesField().getText();
		    String presupuestoStr = vParametrizacion.getPresupuestoField().getText();

		    if (!nombre.isEmpty() && !sedesStr.isEmpty() && !presupuestoStr.isEmpty()) {
		        try {
		            int sedes = Integer.parseInt(sedesStr);
		            double presupuestoTotal = Double.parseDouble(presupuestoStr);

		            Properties prop = new Properties();
		            prop.setProperty("casaDeApuestas", nombre);
		            prop.setProperty("sedes", String.valueOf(sedes));
		            prop.setProperty("presupuestoTotal", String.valueOf(presupuestoTotal));

		            prop.store(new FileOutputStream("config.properties"), null);

		            casa.getGestorDeJuegos().asignarPresupuestos(presupuestoTotal);
		            var juegos = casa.getGestorDeJuegos().getJuegos();
		            vParametrizacion.mostrarJuegos(juegos);
		            JOptionPane.showMessageDialog(null, "Datos guardados exitosamente en config.properties");
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Error en el formato de los números. Ingrese valores válidos.");
		        } catch (IOException ex) {
		            JOptionPane.showMessageDialog(null, "Error al guardar los datos en config.properties");
		        }
		    } else {
		        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
		    }
		}
		
		if (e.getSource() == vParametrizacion.getCargarButton()) {
		    Properties prop = new Properties();
		    try {
		        // Cargar las propiedades desde config.properties si existen
		        prop.load(new FileInputStream("config.properties"));

		        // Verificar si existen las propiedades en el archivo
		        if (prop.getProperty("casaDeApuestas") != null
		                && prop.getProperty("sedes") != null
		                && prop.getProperty("presupuestoTotal") != null) {
		            // Actualizar los campos con los valores leídos de config.properties
		            vParametrizacion.getNombreField().setText(prop.getProperty("casaDeApuestas"));
		            vParametrizacion.getSedesField().setText(prop.getProperty("sedes"));
		            vParametrizacion.getPresupuestoField().setText(prop.getProperty("presupuestoTotal"));
		            casa.getGestorDeJuegos().registrarJuegos();
		            var juegos = casa.getGestorDeJuegos().getJuegos();
		            vParametrizacion.mostrarJuegos(juegos);
		        } else {
		            JOptionPane.showMessageDialog(null, "Aún no se han creado las propiedades en config.properties");
		        }
		    } catch (FileNotFoundException ex) {
		        JOptionPane.showMessageDialog(null, "El archivo config.properties no existe");
		    } catch (IOException ex) {
		        JOptionPane.showMessageDialog(null, "Error al cargar los datos desde config.properties");
		    }
		}
		
		// Gestion de sedes de la casa de apuestas
		if (e.getSource() == vp.getBtnGestionSedes()) {
			ventanaSedes.actualizarSeleccionables(casa.getGestorDeSedes().obtenerSedesActuales());
			ventanaSedes.setVisible(true);
		}
		
		if (e.getSource() == ventanaSedes.getCrearButton()) {
		    String ubicacion = (String) ventanaSedes.getUbicacionComboBox().getSelectedItem();
		    String empleadosStr = ventanaSedes.getEmpleadosField().getText();

		    if (!ubicacion.isEmpty() && !empleadosStr.isEmpty()) {
		        try {
		            int numeroEmpleados = Integer.parseInt(empleadosStr);
		            int indiceSede = casa.getGestorDeSedes().obtenerIndiceSede(ubicacion);

		            if (indiceSede == -1) {
		                casa.agregarSede(ubicacion, numeroEmpleados);
		                ventanaSedes.actualizarSeleccionables(casa.getGestorDeSedes().obtenerSedesActuales());
		                JOptionPane.showMessageDialog(null, "La sede " + ubicacion + " ha sido agregada");
		            } else {
		                JOptionPane.showMessageDialog(null, "La sede " + ubicacion + " ya ha sido agregada");
		            }
		        } catch (NumberFormatException ex) {
		            // Manejo de la excepción si no se ingresa un número válido
		            JOptionPane.showMessageDialog(null, "Ingrese un número válido para empleados");
		        }
		    } else {
		        // Mensaje de error si falta algún dato por ingresar
		        JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
		    }
		}

		
		if (e.getSource() == ventanaSedes.getModificarButton()) {
		    if (ventanaSedes.getSedeAModificarComboBox().getSelectedIndex() != 0) {
		        String nuevaUbicacion = (String) ventanaSedes.getSedeAModificarComboBox().getSelectedItem();
		        String empleadosStr = ventanaSedes.getEmpleadosModField().getText();

		        if (!nuevaUbicacion.isEmpty() && !empleadosStr.isEmpty()) {
		            try {
		                int nuevosEmpleados = Integer.parseInt(empleadosStr);
		                int indiceSede = casa.getGestorDeSedes().obtenerIndiceSede(nuevaUbicacion);
		                casa.modificarSede(indiceSede, nuevaUbicacion, nuevosEmpleados);
		                ventanaSedes.actualizarSeleccionables(casa.getGestorDeSedes().obtenerSedesActuales());
		                JOptionPane.showMessageDialog(null, "La sede seleccionada ha sido modificada");
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "Ingrese un número válido para empleados");
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
		        }
		    } else {
		        JOptionPane.showMessageDialog(null, "Seleccione una sede para modificar");
		    }
		}

		if (e.getSource() == ventanaSedes.getEliminarButton()) {
		    String sedeAEliminar = (String) ventanaSedes.getSedeAEliminarComboBox().getSelectedItem();

		    if (!sedeAEliminar.equals("Selecciona Ubicación")) { // Verificar que se haya seleccionado una sede válida
		        int confirmarEliminar = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar la sede " + sedeAEliminar + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
		        if (confirmarEliminar == JOptionPane.YES_OPTION) {
		            int indiceSede = casa.getGestorDeSedes().obtenerIndiceSede(sedeAEliminar);
		            if (indiceSede != -1) {
		                casa.eliminarSede(indiceSede); // Llamar al método eliminarSede del gestor de sedes
		                ventanaSedes.actualizarSeleccionables(casa.getGestorDeSedes().obtenerSedesActuales());
		                JOptionPane.showMessageDialog(null, "La sede " + sedeAEliminar + " ha sido eliminada");
		            } else {
		                JOptionPane.showMessageDialog(null, "La sede seleccionada no existe");
		            }
		        }
		    } else {
		        JOptionPane.showMessageDialog(null, "Por favor, seleccione una sede para eliminar");
		    }
		}
		
		// Gestion de apostadores de la casa de apuestas
		if (e.getSource() == vp.getBtnGestionApostadores()) {
			ventanaApostadores.actualizarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
			ventanaApostadores.setVisible(true);
		}

		if (e.getSource() == ventanaApostadores.getAgregarButton()) {
		    String nombre = ventanaApostadores.getNombreField().getText();
		    String cedula = ventanaApostadores.getCedulaField().getText();
		    String sedeSeleccionada = (String) ventanaApostadores.getSedeField().getSelectedItem();
		    String direccion = ventanaApostadores.getDireccionField().getText();
		    String celular = ventanaApostadores.getCelularField().getText();

		    if (!nombre.isEmpty() && !cedula.isEmpty() && !sedeSeleccionada.isEmpty() && !direccion.isEmpty() && !celular.isEmpty()) {
		        try {
		            long celularNumber = Long.parseLong(celular);

		            // Validar que la cédula sea un número
		            try {
		                Long.parseLong(cedula);

		                int indiceApostador = casa.getGestorDeApostadores().obtenerIndiceApostador(cedula);
		                if (indiceApostador == -1) {
		                    casa.getGestorDeApostadores().agregarApostador(nombre, cedula, sedeSeleccionada, direccion, celularNumber);
		                    ventanaApostadores.actualizarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
		                    JOptionPane.showMessageDialog(null, "Apostador agregado correctamente");
		                } else {
		                    JOptionPane.showMessageDialog(null, "La cédula ya existe. Ingrese una cédula diferente.");
		                }
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "Por favor, ingrese una cédula válida");
		            }
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número de celular válido");
		        }
		    } else {
		        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
		    }
		}

		
		if (e.getSource() == ventanaApostadores.getModificarButton()) {
		    String nuevoNombre = ventanaApostadores.getNombreModField().getText();
		    String cedula = ventanaApostadores.getCedulaModField().getText();
		    String nuevaSedeSeleccionada = (String) ventanaApostadores.getSedeModField().getSelectedItem();
		    String nuevaDireccion = ventanaApostadores.getDireccionModField().getText();
		    String nuevoCelular = ventanaApostadores.getCelularModField().getText();

		    if (!nuevoNombre.isEmpty() && !cedula.isEmpty() && !nuevaSedeSeleccionada.isEmpty() && !nuevaDireccion.isEmpty() && !nuevoCelular.isEmpty()) {
		        try {
		        	// Validar que la cedula y el numero de celular ingresados sean numeros
		            Long.parseLong(cedula);
		            long nuevoCelularNum =Long.parseLong(nuevoCelular);

		            int indiceApostadorActual = casa.getGestorDeApostadores().obtenerIndiceApostador(cedula);
		            
		            // Validar que el apostador a modificar existe
		            if (indiceApostadorActual != -1) {
		            	// Validar que se haya seleccionado una sede a modificar
		            	if (ventanaApostadores.getSedeModField().getSelectedIndex() != 0) {
		            		casa.getGestorDeApostadores().modificarApostador(indiceApostadorActual, nuevaSedeSeleccionada, cedula, nuevoCelular, nuevaDireccion, nuevoCelularNum);
			            	JOptionPane.showMessageDialog(null, "Apostador modificado correctamente");
		            	} else {
		            		JOptionPane.showMessageDialog(null, "Seleccione una sede a modificar");
		            	}
		            } else {
		            	JOptionPane.showMessageDialog(null, "La cedula del apostador a modificar no existe");
		            }
		    
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para la cédula y el celular");
		        }
		    } else {
		        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
		    }
		}
		
		if (e.getSource() == ventanaApostadores.getBorrarButton()) {
		    String cedulaAEliminar = ventanaApostadores.getCedulaBorrarField().getText();

		    if (!cedulaAEliminar.isEmpty()) {
		        try {
		            // Validar que la cédula sea un número
		            Long.parseLong(cedulaAEliminar);

		            int indiceApostador = casa.getGestorDeApostadores().obtenerIndiceApostador(cedulaAEliminar);

		            // Verificar si el apostador a eliminar existe
		            if (indiceApostador != -1) {
		                // Lógica para eliminar el apostador utilizando la clase GestionApostadores
		                // Supongamos que tienes un método en GestionApostadores llamado eliminarApostador
		                // que toma como parámetro el índice del apostador a eliminar
		                casa.getGestorDeApostadores().eliminarApostador(indiceApostador);
		                JOptionPane.showMessageDialog(null, "Apostador eliminado correctamente");
		                ventanaApostadores.actualizarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
		            } else {
		                JOptionPane.showMessageDialog(null, "La cédula del apostador a eliminar no existe");
		            }
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Por favor, ingrese una cédula válida");
		        }
		    } else {
		        JOptionPane.showMessageDialog(null, "Por favor, ingrese la cédula del apostador a eliminar");
		    }
		}

		
		if (e.getSource() == ventanaApostadores.getLeerButton()) {
		    String cedulaALeer = ventanaApostadores.getCedulaLeerField().getText();

		    if (!cedulaALeer.isEmpty()) {
		        try {
		            // Validar que la cédula sea un número
		            Long.parseLong(cedulaALeer);

		            int indiceApostador = casa.getGestorDeApostadores().obtenerIndiceApostador(cedulaALeer);

		            // Verificar si el apostador existe
		            if (indiceApostador != -1) {
		                // Obtener los datos del apostador utilizando el índice obtenido
		                String datosApostador = casa.getGestorDeApostadores().obtenerDatosApostador(indiceApostador);
		                JOptionPane.showMessageDialog(null, "Datos del Apostador:\n\n" + datosApostador);
		            } else {
		                JOptionPane.showMessageDialog(null, "No se encontró un apostador con esa cédula");
		            }
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Por favor, ingrese una cédula válida");
		        }
		    } else {
		        JOptionPane.showMessageDialog(null, "Por favor, ingrese la cédula del apostador a buscar");
		    }
		}
		
		// Gestion de juegos de la casa de apuestas
		if (e.getSource() == vp.getBtnGestionApuestas()) {
			ventanaApuestas.setVisible(true);
		}
		
		if (e.getSource() == ventanaApuestas.getLoteriaButton()) {
			ventanaApuestaLoteria.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
			ventanaApuestaLoteria.setVisible(true);
		}
		
		if (e.getSource() == ventanaApuestas.getSuperastroButton()) {
			ventanaApuestaSuperastro.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
			ventanaApuestaSuperastro.setVisible(true);
		}
		
		if (e.getSource() == ventanaApuestas.getBalotoButton()) {
			ventanaApuestaBaloto.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
			ventanaApuestaBaloto.setVisible(true);
		}
		
		if (e.getSource() == ventanaApuestas.getBetplayButton()) {
			
			String[] opciones = {"Crear Apuesta BetPlay", "Modificar / Eliminar Apuesta BetPlay"};

	        int seleccion = JOptionPane.showOptionDialog(
	            null,
	            "Seleccione una opción:",
	            "Gestión de Apuestas",
	            JOptionPane.DEFAULT_OPTION,
	            JOptionPane.QUESTION_MESSAGE,
	            null,
	            opciones,
	            opciones[0]
	        );

	        // Verificar la opción seleccionada
	        if (seleccion == 0) {
	        	ventanaCreacionApuestaBetPlay.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
				ventanaCreacionApuestaBetPlay.agregarPartidos(casa.getGestionBaloto().getArchivo().leerEquipos());
				ventanaCreacionApuestaBetPlay.setVisible(true);
	        } else if (seleccion == 1) {
	        	ventanaModificacionApuestaBetPlay.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
				ventanaModificacionApuestaBetPlay.setVisible(true);
	        }
			
		}
		
		if (e.getSource() == ventanaApuestas.getChanceButton()) {
			ventanaApuestaChance.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
			ventanaApuestaChance.setVisible(true);
		}
		
		
		// Apuesta Loteria
		if (e.getSource() == ventanaApuestaLoteria.getCrearButton()) {
		    if (ventanaApuestaLoteria.getSede().getSelectedIndex() == 0 ||
		            ventanaApuestaLoteria.getCedula().getText().isEmpty() ||
		            ventanaApuestaLoteria.getDia().getSelectedItem().toString().equals("Seleccionar dia") ||
		            ventanaApuestaLoteria.getNumeroLoteria().getText().isEmpty() ||
		            ventanaApuestaLoteria.getTipoDeLoteria().getSelectedItem().toString().equals("Seleccionar loteria") ||
		            ventanaApuestaLoteria.getValorApuesta().getText().isEmpty() ||
		            ventanaApuestaLoteria.getSerieLoteria().getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
		    } 
		    // Validar que el numero de loteria contenga 3 digitos
		    else if (ventanaApuestaLoteria.getNumeroLoteria().getText().length() != 4) {
		    	JOptionPane.showMessageDialog(null, "El numero de la loteria debe contener 4 digitos");
		    }
		    
		    // Validar que la serie tenga 3 digitos
		    else if (ventanaApuestaLoteria.getSerieLoteria().getText().length() != 3) {
		    	JOptionPane.showMessageDialog(null, "La serie debe contener 3 digitos");
		    } else {
		        String sede = ventanaApuestaLoteria.getSede().getSelectedItem().toString();
		        String cedula = ventanaApuestaLoteria.getCedula().getText();
		        
		        // Validar que la cedula ya exista
		        if (casa.getGestorDeApostadores().obtenerIndiceApostador(cedula) == -1) {
		        	JOptionPane.showMessageDialog(null, "La cedula del apostador aun no ha sido registrada");
		        } else {
		        	String dia = ventanaApuestaLoteria.getDia().getSelectedItem().toString();
			        String numeroLoteriaStr = ventanaApuestaLoteria.getNumeroLoteria().getText();
			        String tipoLoteria = ventanaApuestaLoteria.getTipoDeLoteria().getSelectedItem().toString();
			        String valorApuestaStr = ventanaApuestaLoteria.getValorApuesta().getText();
			        String serieLoteriaStr = ventanaApuestaLoteria.getSerieLoteria().getText();
			        
			        int numeroLoteria = 0;
			        double valorApuesta = 0;
			        int serieLoteria = 0;
			        try {
						numeroLoteria = Integer.parseInt(numeroLoteriaStr);
						valorApuesta = Double.parseDouble(valorApuestaStr);
						serieLoteria = Integer.parseInt(serieLoteriaStr);
						
						String tipoDeApuesta = "Loteria";
						
				        casa.getGestionLoteria().agregarApuestaLoteria(tipoDeApuesta, sede, cedula, dia, valorApuesta, tipoLoteria, numeroLoteria, serieLoteria);
				        ventanaApuestaLoteria.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
				        JOptionPane.showMessageDialog(null, "La apuesta ha sido agregada exitosamente");
				        ventanaFactura = new VentanaFactura(sede, cedula, valorApuestaStr, valorApuesta, tipoDeApuesta);
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Digite valores numericos validos");
					}
		        }

		        
		    }
		}

		if (e.getSource() == ventanaApuestaLoteria.getModificarButton()) {
		    if (ventanaApuestaLoteria.getSedeModificar().getSelectedIndex() == 0 ||
		        ventanaApuestaLoteria.getCedulaModificar().getText().isEmpty() ||
		        ventanaApuestaLoteria.getDiaModificar().getSelectedItem().toString().equals("Seleccionar día") ||
		        ventanaApuestaLoteria.getNumeroLoteriaModificar().getText().isEmpty() ||
		        ventanaApuestaLoteria.getTipoDeLoteriaModificar().getSelectedItem().toString().equals("Seleccionar lotería") ||
		        ventanaApuestaLoteria.getValorApuestaModificar().getText().isEmpty() ||
		        ventanaApuestaLoteria.getSerieLoteriaModificar().getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
		    } 
		    // Validar que el numero de loteria contenga 4 digitos
		    else if (ventanaApuestaLoteria.getNumeroLoteriaModificar().getText().length() != 4) {
		        JOptionPane.showMessageDialog(null, "El número de la lotería debe contener 4 dígitos");
		    }
		    // Validar que la serie tenga 3 digitos
		    else if (ventanaApuestaLoteria.getSerieLoteriaModificar().getText().length() != 3) {
		        JOptionPane.showMessageDialog(null, "La serie debe contener 3 dígitos");
		    } else {
		        String sede = ventanaApuestaLoteria.getSedeModificar().getSelectedItem().toString();
		        String cedula = ventanaApuestaLoteria.getCedulaModificar().getText();
		        
		        // Validar que la cédula ya exista
		        if (casa.getGestorDeApostadores().obtenerIndiceApostador(cedula) == -1) {
		            JOptionPane.showMessageDialog(null, "La cédula del apostador aún no ha sido registrada");
		        } else {
		            String dia = ventanaApuestaLoteria.getDiaModificar().getSelectedItem().toString();
		            String numeroLoteriaStr = ventanaApuestaLoteria.getNumeroLoteriaModificar().getText();
		            String tipoLoteria = ventanaApuestaLoteria.getTipoDeLoteriaModificar().getSelectedItem().toString();
		            String valorApuestaStr = ventanaApuestaLoteria.getValorApuestaModificar().getText();
		            String serieLoteriaStr = ventanaApuestaLoteria.getSerieLoteriaModificar().getText();
		            
		            int numeroLoteria = 0;
		            double valorApuesta = 0;
		            int serieLoteria = 0;
		            try {
		                numeroLoteria = Integer.parseInt(numeroLoteriaStr);
		                valorApuesta = Double.parseDouble(valorApuestaStr);
		                serieLoteria = Integer.parseInt(serieLoteriaStr);
		                
		                int indiceLoteria = casa.getGestionLoteria().obtenerIndiceApuesta(cedula, dia);
		                
		                // Validar que la apuesta existe
		                if (indiceLoteria == -1) {
		                	JOptionPane.showMessageDialog(null, "La apuesta de loteria no ha sido creada");
		                } else {
		                	String tipoDeApuesta = "Loteria";
			                // Modificar la apuesta utilizando la clase GestorLoteria
			                casa.getGestionLoteria().modificarApuestaLoteria(indiceLoteria, tipoDeApuesta, sede, cedula, dia, valorApuesta, tipoLoteria, numeroLoteria, serieLoteria);
			                ventanaApuestaLoteria.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
			                JOptionPane.showMessageDialog(null, "La apuesta ha sido modificada exitosamente");
		                }
		                
		            
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos");
		            }
		        }
		    }
		}

		if (e.getSource() == ventanaApuestaLoteria.getLeerButton()) {
		    String cedula = ventanaApuestaLoteria.getCedulaLeer().getText();
		    String diaSeleccionado = (String) ventanaApuestaLoteria.getDiaLeer().getSelectedItem();

		    if (cedula.isEmpty() && diaSeleccionado.equals("Seleccionar día")) {
		        // Mensaje de error, indicando que los datos deben ser ingresados
		        JOptionPane.showMessageDialog(null, "Por favor ingrese uno o dos de los datos.", "Error", JOptionPane.ERROR_MESSAGE);
		    } else if (diaSeleccionado.equals("Seleccionar día")) {
		    	if (casa.getGestorDeApostadores().obtenerIndiceApostador(cedula) == -1) {
		        	JOptionPane.showMessageDialog(null, "La cedula del apostador no ha sido registrada");
		        } else {
		        	String datosApuestaLoteria = casa.getGestionLoteria().obtenerDatosApuestas(cedula);
			        if (datosApuestaLoteria != null) {
			        	JOptionPane.showMessageDialog(null, "Apuestas actuales:\n" + datosApuestaLoteria);
			        } else {
			        	JOptionPane.showMessageDialog(null, 
			        			"La apuesta no ha sido encontrada por cedula");
			        }
		        }
		    } else if (cedula.isEmpty()) {
		    	if (casa.getGestionLoteria().obtenerIndiceApuestaPorDia(diaSeleccionado) == -1) {
		        	JOptionPane.showMessageDialog(null, "No se han registrado apuestas realizadas el dia " + diaSeleccionado + ".");
		        } else {
		        	String datosApuestaLoteria = casa.getGestionLoteria().obtenerDatosApuestasPorDia(diaSeleccionado);
			        if (datosApuestaLoteria != null) {
			        	JOptionPane.showMessageDialog(null, "Apuestas actuales:\n" + datosApuestaLoteria);
			        } else {
			        	JOptionPane.showMessageDialog(null, 
			        			"La apuesta no ha sido encontrada por dia");
			        }
		        }
		    } else {
		        String datosApuestaLoteria = casa.getGestionLoteria().obtenerDatosApuestas(cedula, diaSeleccionado);
		        if (datosApuestaLoteria != null) {
		        	JOptionPane.showMessageDialog(null, "Apuestas actuales:\n" + datosApuestaLoteria);
		        } else {
		        	JOptionPane.showMessageDialog(null, 
		        			"La apuesta no ha sido encontrada");
		        }
		    }
		}
		
		if (e.getSource() == ventanaApuestaLoteria.getBorrarButton()) {
		    String cedula = ventanaApuestaLoteria.getCedulaEliminar().getText();
		    String sedeSeleccionada = (String) ventanaApuestaLoteria.getSedeEliminar().getSelectedItem();
		    String diaSeleccionado = (String) ventanaApuestaLoteria.getDiaEliminar().getSelectedItem();

		    if (cedula.isEmpty() || diaSeleccionado.equals("Seleccionar día") || sedeSeleccionada.equals("Seleccionar sede")) {
		        JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
		    } else {
		        int confirmarBorrado = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar la apuesta?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
		        if (confirmarBorrado == JOptionPane.YES_OPTION) {
		            // Lógica para buscar y eliminar la apuesta de lotería utilizando los datos ingresados
		        	int indiceApuestaAEliminar = casa.getGestionLoteria().obtenerIndiceApuestaPorSedeCedulaDia(sedeSeleccionada, cedula, diaSeleccionado);
		        	if (indiceApuestaAEliminar == -1) {
		        		JOptionPane.showMessageDialog(null, "La apuesta con los datos proveidos no existe");
		        	} else {
		        		casa.getGestionLoteria().eliminarApuestaLoteria(indiceApuestaAEliminar);
			            JOptionPane.showMessageDialog(null, "Apuesta eliminada correctamente.");
		                ventanaApuestaLoteria.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
		        	}
		        	
		        }
		    }
		}

		// Apuesta superastro
		if (e.getSource() == ventanaApuestaSuperastro.getCrearButton()) {
		    String sedeSeleccionada = (String) ventanaApuestaSuperastro.getSedeComboBoxCrear().getSelectedItem();
		    String cedula = ventanaApuestaSuperastro.getCedulaFieldCrear().getText();
		    String diaSeleccionado = (String) ventanaApuestaSuperastro.getDiaComboBoxCrear().getSelectedItem();
		    String valorApuesta = ventanaApuestaSuperastro.getValorApuestaFieldCrear().getText();
		    String numero1 = ventanaApuestaSuperastro.getNumero1Field().getText();
		    String numero2 = ventanaApuestaSuperastro.getNumero2Field().getText();
		    String numero3 = ventanaApuestaSuperastro.getNumero3Field().getText();
		    String numero4 = ventanaApuestaSuperastro.getNumero4Field().getText();
		    String signoZodiacoSeleccionado = (String) ventanaApuestaSuperastro.getSignoZodiacoComboBox().getSelectedItem();

		    if (sedeSeleccionada.equals("Seleccionar") || cedula.isEmpty() || diaSeleccionado.equals("Seleccionar") ||
		            valorApuesta.isEmpty() || numero1.isEmpty() || numero2.isEmpty() || numero3.isEmpty() ||
		            numero4.isEmpty() || signoZodiacoSeleccionado.equals("Seleccionar")) {
		        // Mostrar mensaje de error indicando que faltan datos por ingresar
		        JOptionPane.showMessageDialog(ventanaApuestaSuperastro, "Por favor complete todos los campos para crear la apuesta.",
		                "Datos incompletos", JOptionPane.ERROR_MESSAGE);
		    } else {
		        // Validar valores numéricos y guardarlos en variables
		        try {
		            int valorApuestaNumerico = Integer.parseInt(valorApuesta);
		            int[] numerosSeleccionados = new int[4];
		            numerosSeleccionados[0] = Integer.parseInt(numero1);
		            numerosSeleccionados[1] = Integer.parseInt(numero2);
		            numerosSeleccionados[2] = Integer.parseInt(numero3);
		            numerosSeleccionados[3] = Integer.parseInt(numero4);
		            
		            // Validar que la cedula del apostador exista
		            if (casa.getGestorDeApostadores().obtenerIndiceApostador(cedula) == -1) {
		            	JOptionPane.showMessageDialog(null, "La cedula digitada no ha sido registrada");
		            } else {
		            	casa.getGestionSuperAstro().agregarApuestaSuperAstro(sedeSeleccionada, cedula, diaSeleccionado, valorApuestaNumerico, numerosSeleccionados, signoZodiacoSeleccionado);
			            
		            	String tipoApuesta = "Superastro";
			            ventanaApuestaSuperastro.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
			            JOptionPane.showMessageDialog(null, "La apuesta de superastro ha sido agregada exitosamente");
			            ventanaFactura = new VentanaFactura(sedeSeleccionada, cedula, diaSeleccionado, valorApuestaNumerico, tipoApuesta);
		            }
		            

		        } catch (NumberFormatException ex) {
		            // Al menos uno de los campos numéricos no contiene un valor válido
		            JOptionPane.showMessageDialog(ventanaApuestaSuperastro, "Por favor ingrese valores numéricos válidos.",
		                    "Error en valores numéricos", JOptionPane.ERROR_MESSAGE);
		        }
		    }

		}

		if (e.getSource() == ventanaApuestaSuperastro.getModificarButton()) {
		    String sedeSeleccionadaModificar = (String) ventanaApuestaSuperastro.getSedeComboBoxModificar().getSelectedItem();
		    String cedulaModificar = ventanaApuestaSuperastro.getCedulaFieldModificar().getText();
		    String diaSeleccionadoModificar = (String) ventanaApuestaSuperastro.getDiaComboBoxModificar().getSelectedItem();
		    String valorApuestaModificar = ventanaApuestaSuperastro.getValorApuestaFieldModificar().getText();
		    String numero1Modificar = ventanaApuestaSuperastro.getNumero1FieldModificar().getText();
		    String numero2Modificar = ventanaApuestaSuperastro.getNumero2FieldModificar().getText();
		    String numero3Modificar = ventanaApuestaSuperastro.getNumero3FieldModificar().getText();
		    String numero4Modificar = ventanaApuestaSuperastro.getNumero4FieldModificar().getText();
		    String signoZodiacoSeleccionadoModificar = (String) ventanaApuestaSuperastro.getSignoZodiacoComboBoxModificar().getSelectedItem();

		    if (sedeSeleccionadaModificar.equals("Seleccionar") || cedulaModificar.isEmpty() || diaSeleccionadoModificar.equals("Seleccionar") ||
		            valorApuestaModificar.isEmpty() || numero1Modificar.isEmpty() || numero2Modificar.isEmpty() || numero3Modificar.isEmpty() ||
		            numero4Modificar.isEmpty() || signoZodiacoSeleccionadoModificar.equals("Seleccionar")) {
		        // Mostrar mensaje de error indicando que faltan datos por ingresar
		        JOptionPane.showMessageDialog(ventanaApuestaSuperastro, "Por favor complete todos los campos para modificar la apuesta.",
		                "Datos incompletos", JOptionPane.ERROR_MESSAGE);
		    } else {
		        // Validar valores numéricos y guardarlos en variables
		        try {
		            int valorApuestaNumericoModificar = Integer.parseInt(valorApuestaModificar);
		            int[] numerosSeleccionadosModificar = new int[4];
		            numerosSeleccionadosModificar[0] = Integer.parseInt(numero1Modificar);
		            numerosSeleccionadosModificar[1] = Integer.parseInt(numero2Modificar);
		            numerosSeleccionadosModificar[2] = Integer.parseInt(numero3Modificar);
		            numerosSeleccionadosModificar[3] = Integer.parseInt(numero4Modificar);

		            // Obtener indice a ver si la apuesta en cuestion existe
		            int indiceApuestaSuperastroAModificar = casa.getGestionSuperAstro().obtenerIndiceApuesta(cedulaModificar, diaSeleccionadoModificar);
		            
		            if (indiceApuestaSuperastroAModificar == -1) {
		            	JOptionPane.showMessageDialog(null, "La apuesta de superastro a modificar no existe");
		            } else {
		            	casa.getGestionSuperAstro().modificarApuestaSuperAstro(indiceApuestaSuperastroAModificar, sedeSeleccionadaModificar, cedulaModificar, diaSeleccionadoModificar, valorApuestaNumericoModificar, numerosSeleccionadosModificar, signoZodiacoSeleccionadoModificar);
		            	ventanaApuestaSuperastro.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
		            	JOptionPane.showMessageDialog(null, "La apuesta de superastro ha sido modificada exitosamente");
		            	ventanaApuestaSuperastro.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());

			            JOptionPane.showMessageDialog(null, "La apuesta de superastro ha sido modificada exitosamente");
		            }
		            
		            
		            
		        } catch (NumberFormatException ex) {
		            // Al menos uno de los campos numéricos no contiene un valor válido
		            JOptionPane.showMessageDialog(null, "Por favor ingrese valores numéricos válidos.",
		                    "Error en valores numéricos", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		}
		
		if (e.getSource() == ventanaApuestaSuperastro.getBuscarButton()) {
			if (e.getSource() == ventanaApuestaSuperastro.getBuscarButton()) {
			    String cedula = ventanaApuestaSuperastro.getCedulaFieldLeer().getText();
			    String diaSeleccionado = (String) ventanaApuestaSuperastro.getDiaComboBoxLeer().getSelectedItem();

			    if (cedula.isEmpty() || diaSeleccionado.equals("Seleccionar")) {
			        // Mostrar mensaje de error indicando que faltan datos por ingresar
			        JOptionPane.showMessageDialog(ventanaApuestaSuperastro, "Por favor complete todos los campos para realizar la búsqueda.",
			                "Datos incompletos", JOptionPane.ERROR_MESSAGE);
			    } else {
			        int indiceApuesta = casa.getGestionSuperAstro().obtenerIndiceApuesta(cedula, diaSeleccionado);
			        if (indiceApuesta == -1) {
			        	JOptionPane.showMessageDialog(null, "La apuesta con los datos ingresados no existe.",
				                "Datos incompletos", JOptionPane.ERROR_MESSAGE);

			        } else {
			        	String datosApuesta = casa.getGestionSuperAstro().obtenerDatosApuestas(cedula, diaSeleccionado);
			        	// Mostrar los datos en el JTextField correspondiente en la ventana
			            ventanaApuestaSuperastro.getResultadoTextArea().setText(datosApuesta);
			        }
			    }
			}

		}

		
		if (e.getSource() == ventanaApuestaSuperastro.getEliminarButton()) {
		    String cedulaEliminar = ventanaApuestaSuperastro.getCedulaApostadorFieldEliminar().getText();
		    String diaApuestaEliminar = ventanaApuestaSuperastro.getDiaComboBoxEliminar().getSelectedItem().toString();

		    if (!cedulaEliminar.isEmpty() && !diaApuestaEliminar.equals("Seleccionar")) {
		    	int indiceApuestaAEliminar = casa.getGestionSuperAstro().obtenerIndiceApuesta(cedulaEliminar, diaApuestaEliminar);
		    	if (indiceApuestaAEliminar == -1) {
		    		JOptionPane.showMessageDialog(null, "La apuesta ha eliminar no fue encontrada");
		    	} else {
		    		casa.getGestionSuperAstro().eliminarApuestaSuperAstro(indiceApuestaAEliminar);
			    	JOptionPane.showMessageDialog(null, "La apuesta ha sido eliminada exitosamente");
		    	}
		    	
		    } else {
		        // Muestra un mensaje de error indicando que faltan datos por ingresar
		        JOptionPane.showMessageDialog(null, "Por favor, ingresa todos los datos.");
		    }
		}

	
		// Apuesta Baloto
		if (e.getSource() == ventanaApuestaBaloto.getCrearButton()) {
		    // Verificar que todos los campos estén llenos antes de procesar la creación
		    if (ventanaApuestaBaloto.getSedeComboBoxCrear().getSelectedIndex() == 0 ||
		        ventanaApuestaBaloto.getCedulaFieldCrear().getText().isEmpty() ||
		        ventanaApuestaBaloto.getDiaComboBoxCrear().getSelectedIndex() == 0 ||
		        ventanaApuestaBaloto.getValorApuestaFieldCrear().getText().isEmpty() ||
		        ventanaApuestaBaloto.getNumero1Field().getText().isEmpty() ||
		        ventanaApuestaBaloto.getNumero2Field().getText().isEmpty() ||
		        ventanaApuestaBaloto.getNumero3Field().getText().isEmpty() ||
		        ventanaApuestaBaloto.getNumero4Field().getText().isEmpty() ||
		        ventanaApuestaBaloto.getNumero5Field().getText().isEmpty() ||
		        ventanaApuestaBaloto.getNumero6Field().getText().isEmpty()) {
		        
		        // Mostrar un mensaje indicando que todos los campos son obligatorios
		        JOptionPane.showMessageDialog(ventanaApuestaBaloto, "Todos los campos son obligatorios", "Datos no ingresados", JOptionPane.ERROR_MESSAGE);
		    } else {
		    	
		    	String sede = ventanaApuestaBaloto.getSedeComboBoxCrear().getSelectedItem().toString();
		    	String cedula = ventanaApuestaBaloto.getCedulaFieldCrear().getText();
		    	String dia = ventanaApuestaBaloto.getDiaComboBoxCrear().getSelectedItem().toString();
		    	String valorStr = ventanaApuestaBaloto.getValorApuestaFieldCrear().getText();
		    	
		    	 // Validar que los valores numéricos sean enteros y guardarlos en un arreglo
		        int[] numerosSeleccionados = new int[6];
		        try {
		            numerosSeleccionados[0] = Integer.parseInt(ventanaApuestaBaloto.getNumero1Field().getText());
		            numerosSeleccionados[1] = Integer.parseInt(ventanaApuestaBaloto.getNumero2Field().getText());
		            numerosSeleccionados[2] = Integer.parseInt(ventanaApuestaBaloto.getNumero3Field().getText());
		            numerosSeleccionados[3] = Integer.parseInt(ventanaApuestaBaloto.getNumero4Field().getText());
		            numerosSeleccionados[4] = Integer.parseInt(ventanaApuestaBaloto.getNumero5Field().getText());
		            numerosSeleccionados[5] = Integer.parseInt(ventanaApuestaBaloto.getNumero6Field().getText());
		            
		            double valorApuesta = Double.parseDouble(valorStr);
		            
		            
		            String tipoApuesta = "Baloto";
		            
		           casa.getGestionBaloto().agregarApuestaBaloto(sede, cedula, dia, valorApuesta, numerosSeleccionados);
		           ventanaApuestaBaloto.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
		           JOptionPane.showMessageDialog(null, "La apuesta ha sido agregada");
		           
		           ventanaFactura = new VentanaFactura(sede, cedula, dia, valorApuesta, tipoApuesta);
		        } catch (NumberFormatException ex) {
		            // Mostrar un mensaje de error si alguno de los campos numéricos no es un número entero válido
		            JOptionPane.showMessageDialog(ventanaApuestaBaloto, "Los números deben ser enteros", "Numeros no validos", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		}
		
		if (e.getSource() == ventanaApuestaBaloto.getModificarButton()) {
		    // Verificar que todos los campos estén llenos antes de procesar la modificación
		    if (ventanaApuestaBaloto.getSedeComboBoxModificar().getSelectedIndex() == 0 ||
		        ventanaApuestaBaloto.getCedulaFieldModificar().getText().isEmpty() ||
		        ventanaApuestaBaloto.getDiaComboBoxModificar().getSelectedIndex() == 0 ||
		        ventanaApuestaBaloto.getValorApuestaFieldModificar().getText().isEmpty() ||
		        ventanaApuestaBaloto.getNumero1FieldModificar().getText().isEmpty() ||
		        ventanaApuestaBaloto.getNumero2FieldModificar().getText().isEmpty() ||
		        ventanaApuestaBaloto.getNumero3FieldModificar().getText().isEmpty() ||
		        ventanaApuestaBaloto.getNumero4FieldModificar().getText().isEmpty() ||
		        ventanaApuestaBaloto.getNumero5FieldModificar().getText().isEmpty() ||
		        ventanaApuestaBaloto.getNumero6FieldModificar().getText().isEmpty()) {
		        
		        // Mostrar un mensaje indicando que todos los campos son obligatorios
		        JOptionPane.showMessageDialog(ventanaApuestaBaloto, "Todos los campos son obligatorios", "Datos no ingresados", JOptionPane.ERROR_MESSAGE);
		    } else {
		        String sede = ventanaApuestaBaloto.getSedeComboBoxModificar().getSelectedItem().toString();
		        String cedula = ventanaApuestaBaloto.getCedulaFieldModificar().getText();
		        String dia = ventanaApuestaBaloto.getDiaComboBoxModificar().getSelectedItem().toString();
		        String valorStr = ventanaApuestaBaloto.getValorApuestaFieldModificar().getText();
		        
		        // Validar que los valores numéricos sean enteros y guardarlos en un arreglo
		        int[] numerosSeleccionados = new int[6];
		        try {
		            numerosSeleccionados[0] = Integer.parseInt(ventanaApuestaBaloto.getNumero1FieldModificar().getText());
		            numerosSeleccionados[1] = Integer.parseInt(ventanaApuestaBaloto.getNumero2FieldModificar().getText());
		            numerosSeleccionados[2] = Integer.parseInt(ventanaApuestaBaloto.getNumero3FieldModificar().getText());
		            numerosSeleccionados[3] = Integer.parseInt(ventanaApuestaBaloto.getNumero4FieldModificar().getText());
		            numerosSeleccionados[4] = Integer.parseInt(ventanaApuestaBaloto.getNumero5FieldModificar().getText());
		            numerosSeleccionados[5] = Integer.parseInt(ventanaApuestaBaloto.getNumero6FieldModificar().getText());
		            
		            double valorApuesta = Double.parseDouble(valorStr);
		            int indice = casa.getGestionBaloto().obtenerIndiceApuesta(cedula, dia);
		            if (indice == -1) {
		            	JOptionPane.showMessageDialog(null, "La apuesta no ha sido encontrada");
		            } else {
		            	casa.getGestionBaloto().modificarApuestaBaloto(indice, sede, cedula, dia, valorApuesta, numerosSeleccionados);
		            	ventanaApuestaBaloto.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
		            	JOptionPane.showMessageDialog(null, "La apuesta ha sido modificada exitosamente");
		            }
		            
		            
		        } catch (NumberFormatException ex) {
		            // Mostrar un mensaje de error si algún campo numérico no es un número entero válido
		            JOptionPane.showMessageDialog(ventanaApuestaBaloto, "Los números deben ser enteros", "Numeros no validos", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		}

		
		if (e.getSource() == ventanaApuestaBaloto.getBuscarButton()) {
		    // Verificar que se haya ingresado la cédula y seleccionado un día
		    if (ventanaApuestaBaloto.getCedulaFieldLeer().getText().isEmpty() ||
		        ventanaApuestaBaloto.getDiaComboBoxLeer().getSelectedIndex() == 0) {
		        
		        // Mostrar un mensaje indicando que todos los campos son obligatorios
		        JOptionPane.showMessageDialog(ventanaApuestaBaloto, "Todos los campos son obligatorios", "Datos no ingresados", JOptionPane.ERROR_MESSAGE);
		    } else {
		        // Procesar la lógica para buscar la apuesta Superastro
		        String cedula = ventanaApuestaBaloto.getCedulaFieldLeer().getText();
		        String dia = ventanaApuestaBaloto.getDiaComboBoxLeer().getSelectedItem().toString();
		        
		        int indiceApuesta = casa.getGestionBaloto().obtenerIndiceApuesta(cedula, dia);
		        if (indiceApuesta == -1) {
		        	JOptionPane.showMessageDialog(null, "La apuesta no ha sido encontrada");
		        	
		        } else {
		        	String datosApuesta = casa.getGestionBaloto().obtenerDatosApuestas(cedula, dia);
		        	ventanaApuestaBaloto.getResultadoTextArea().setText(datosApuesta);
		        }
		    }
		}

		if (e.getSource() == ventanaApuestaBaloto.getEliminarButton()) {
		    // Verificar que se haya ingresado la cédula del apostador y seleccionado un día para eliminar la apuesta
		    if (ventanaApuestaBaloto.getCedulaApostadorFieldEliminar().getText().isEmpty() ||
		        ventanaApuestaBaloto.getDiaComboBoxEliminar().getSelectedIndex() == 0) {
		        
		        // Mostrar un mensaje indicando que todos los campos son obligatorios
		        JOptionPane.showMessageDialog(ventanaApuestaBaloto, "Todos los campos son obligatorios", "Datos no ingresados", JOptionPane.ERROR_MESSAGE);
		    } else {
		        // Procesar la lógica para eliminar la apuesta Superastro
		        String cedula = ventanaApuestaBaloto.getCedulaApostadorFieldEliminar().getText();
		        String dia = ventanaApuestaBaloto.getDiaComboBoxEliminar().getSelectedItem().toString();
		        
		        int indiceApuesta = casa.getGestionBaloto().obtenerIndiceApuesta(cedula, dia);
		        
		        if (indiceApuesta == -1) {
		        	JOptionPane.showMessageDialog(null, "La apuesta a eliminar no ha sido encontrada");
		        } else {
		        	casa.getGestionBaloto().eliminarApuestaBaloto(indiceApuesta);
		        	JOptionPane.showMessageDialog(null, "La apuesta ha sido eliminada exitosamente");
		        	
		        }
		    }
		}

		// Apuesta Chance
		if (e.getSource() == ventanaApuestaChance.getCrearButton()) {
		    // Obtener los valores ingresados en la sección de Crear Apuesta
		    String sedeSeleccionada = (String) ventanaApuestaChance.getSede().getSelectedItem();
		    String cedulaIngresada = ventanaApuestaChance.getCedula().getText();
		    String diaSeleccionado = (String) ventanaApuestaChance.getDia().getSelectedItem();
		    String tipoLoteriaSeleccionada = (String) ventanaApuestaChance.getTipoDeLoteria().getSelectedItem();
		    String valorApuestaIngresado = ventanaApuestaChance.getValorApuesta().getText();
		    String numero1 = ventanaApuestaChance.getNumero1Field().getText();
		    String numero2 = ventanaApuestaChance.getNumero2Field().getText();
		    String numero3 = ventanaApuestaChance.getNumero3Field().getText();
		    String numero4 = ventanaApuestaChance.getNumero4Field().getText();

		    // Validar si algún campo está vacío
		    if (sedeSeleccionada.isEmpty() || cedulaIngresada.isEmpty() || diaSeleccionado.equals("Seleccionar día") ||
		        tipoLoteriaSeleccionada.equals("Seleccionar lotería") || valorApuestaIngresado.isEmpty() ||
		        numero1.isEmpty() || numero2.isEmpty() || numero3.isEmpty() || numero4.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos para crear una apuesta de chance.");
		    } else {
		    	 try {
		             // Convertir los valores de la apuesta y números a los tipos de datos requeridos
		             long valorApuesta = Long.parseLong(valorApuestaIngresado);
		             int num1 = Integer.parseInt(numero1);
		             int num2 = Integer.parseInt(numero2);
		             int num3 = Integer.parseInt(numero3);
		             int num4 = Integer.parseInt(numero4);

		             // Guardar los números en un arreglo
		             int[] numerosSeleccionados = {num1, num2, num3, num4};
		             
		             String tipoApuesta = "Chance";

		             // Validar que la cedula del apostador exista
		             if (casa.getGestorDeApostadores().obtenerIndiceApostador(cedulaIngresada) == -1) {
		            	 JOptionPane.showMessageDialog(null, "La cedula ingresada no ha sido registrada");
		             } else {
		            	 casa.getGestionChance().agregarApuestaChance(sedeSeleccionada, cedulaIngresada, diaSeleccionado, valorApuesta, tipoLoteriaSeleccionada, numerosSeleccionados);
			             ventanaApuestaChance.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
			             JOptionPane.showMessageDialog(null, "La apuesta ha sido agregada exitosamente");
			             ventanaFactura = new VentanaFactura(sedeSeleccionada, cedulaIngresada, diaSeleccionado, valorApuesta, tipoApuesta);
		             }
		             
		             
		    	 } catch (NumberFormatException ex) {
		             // Manejar la excepción si alguno de los valores no es un número válido
		             JOptionPane.showMessageDialog(null, "Ingrese números válidos en los campos correspondientes.");
		         }
		    }
		}
		
		if (e.getSource() == ventanaApuestaChance.getModificarButton()) {
		    // Obtener los valores ingresados en la sección Modificar Apuesta
		    String sedeSeleccionadaModificar = (String) ventanaApuestaChance.getSedeModificar().getSelectedItem();
		    String cedulaIngresadaModificar = ventanaApuestaChance.getCedulaModificar().getText();
		    String diaSeleccionadoModificar = (String) ventanaApuestaChance.getDiaModificar().getSelectedItem();
		    String tipoLoteriaSeleccionadaModificar = (String) ventanaApuestaChance.getTipoDeLoteriaModificar().getSelectedItem();
		    String valorApuestaIngresadoModificar = ventanaApuestaChance.getValorApuestaModificar().getText();
		    String numero1Modificar = ventanaApuestaChance.getNumero1FieldModificar().getText();
		    String numero2Modificar = ventanaApuestaChance.getNumero2FieldModificar().getText();
		    String numero3Modificar = ventanaApuestaChance.getNumero3FieldModificar().getText();
		    String numero4Modificar = ventanaApuestaChance.getNumero4FieldModificar().getText();

		    // Validar si algún campo está vacío
		    if (sedeSeleccionadaModificar.isEmpty() || cedulaIngresadaModificar.isEmpty() || diaSeleccionadoModificar.equals("Seleccionar día") ||
		        tipoLoteriaSeleccionadaModificar.equals("Seleccionar lotería") || valorApuestaIngresadoModificar.isEmpty() ||
		        numero1Modificar.isEmpty() || numero2Modificar.isEmpty() || numero3Modificar.isEmpty() || numero4Modificar.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos para modificar la apuesta de chance.");
		    } else {
		        try {
		            // Convertir los valores de la apuesta y números a los tipos de datos requeridos
		            long valorApuestaModificar = Long.parseLong(valorApuestaIngresadoModificar);
		            int num1Modificar = Integer.parseInt(numero1Modificar);
		            int num2Modificar = Integer.parseInt(numero2Modificar);
		            int num3Modificar = Integer.parseInt(numero3Modificar);
		            int num4Modificar = Integer.parseInt(numero4Modificar);

		            // Guardar los números en un arreglo
		            int[] numerosSeleccionadosModificar = {num1Modificar, num2Modificar, num3Modificar, num4Modificar};
		            
		            int indiceApuestaAModificar = casa.getGestionBaloto().obtenerIndiceApuesta(cedulaIngresadaModificar, diaSeleccionadoModificar);

		            // Validar que la cedula del apostador exista
		            if (indiceApuestaAModificar == -1) {
		                JOptionPane.showMessageDialog(null, "La apuesta no ha sido encontrada");
		            } else {
		                casa.getGestionChance().modificarApuestaChance(indiceApuestaAModificar, sedeSeleccionadaModificar, cedulaIngresadaModificar, diaSeleccionadoModificar, valorApuestaModificar, tipoLoteriaSeleccionadaModificar, numerosSeleccionadosModificar);
		                ventanaApuestaChance.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
		                ventanaApuestaChance.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
		                JOptionPane.showMessageDialog(null, "La apuesta ha sido modificada exitosamente");
		            }

		        } catch (NumberFormatException ex) {
		            // Manejar la excepción si alguno de los valores no es un número válido
		            JOptionPane.showMessageDialog(null, "Ingrese números válidos en los campos correspondientes.");
		        }
		    }
		}

		if (e.getSource() == ventanaApuestaChance.getLeerButton()) {
		    // Obtener los valores ingresados en la sección de Leer Apuesta
		    String cedulaLeer = ventanaApuestaChance.getCedulaLeer().getText();
		    String diaSeleccionado = (String) ventanaApuestaChance.getDiaLeer().getSelectedItem();

		    // Validar si algún campo está vacío
		    if (cedulaLeer.isEmpty() || diaSeleccionado.equals("Seleccionar día")) {
		        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos para leer una apuesta.");
		    } else {
		    	String datosApuesta = casa.getGestionChance().obtenerDatosApuestas(cedulaLeer);
		        if (datosApuesta.isEmpty()) {
		        	JOptionPane.showMessageDialog(null, "La apuesta a eliminar no ha sido encontrada");
		        } else {
		        	JOptionPane.showMessageDialog(null, datosApuesta);
		        }
		    }
		}


		if (e.getSource() == ventanaApuestaChance.getBorrarButton()) {
		    // Verificar si se han ingresado datos en todos los campos requeridos para la eliminación
			
			String cedulaEliminar = ventanaApuestaChance.getCedulaEliminar().getText();
			String sedeEliminar = ventanaApuestaChance.getSedeEliminar().getSelectedItem().toString();
			String diaEliminar = ventanaApuestaChance.getDiaEliminar().getSelectedItem().toString();
			
		    if (cedulaEliminar.isEmpty() ||
		    		sedeEliminar.equals("Seleccionar sede") ||
		    		diaEliminar.equals("Seleccionar día")) {
		        // Mostrar un mensaje de advertencia al usuario o realizar alguna acción indicando que faltan datos
		        // Por ejemplo, mostrar un mensaje en una etiqueta JLabel o abrir un JOptionPane con un mensaje de error
		        // Ejemplo con JOptionPane:
		        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos para realizar la eliminación.", "Datos faltantes", JOptionPane.WARNING_MESSAGE);
		    } else {
		        int indiceApuestaAEliminar = casa.getGestionChance().obtenerIndiceApuesta(cedulaEliminar, sedeEliminar, diaEliminar);
		    
		        if (indiceApuestaAEliminar != -1) {
		        	casa.getGestionChance().eliminarApuestaChance(indiceApuestaAEliminar);
		        	ventanaApuestaChance.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
		        	JOptionPane.showMessageDialog(null, "La apuesta ha sido eliminada exitosamente");
		        } else {
		        	JOptionPane.showMessageDialog(null, "La apuesta a eliminar no existe");
		        }
		        
		    }
		}
		
		// Apuesta BetPlay
		if (e.getSource() == ventanaCreacionApuestaBetPlay.getCrearButton()) {
			
		    // Validar que todos los campos estén llenos
		    if (ventanaCreacionApuestaBetPlay.getSede().getSelectedIndex() == 0 ||
		        ventanaCreacionApuestaBetPlay.getCedula().getText().isEmpty() ||
		        ventanaCreacionApuestaBetPlay.getDia().getSelectedIndex() == 0 ||
		        ventanaCreacionApuestaBetPlay.getValorApuesta().getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
		    } else {
		        
		    	String sede = ventanaCreacionApuestaBetPlay.getSede().getSelectedItem().toString();
		    	String cedula = ventanaCreacionApuestaBetPlay.getCedula().getText();
		    	String dia = ventanaCreacionApuestaBetPlay.getDia().getSelectedItem().toString();
		    	String valor = ventanaCreacionApuestaBetPlay.getValorApuesta().getText();
		    	
		    	String tipoApuesta = "BetPlay";
		    	
		    	try {
					double valorApuesta = Double.parseDouble(valor);
					
					if (!ventanaCreacionApuestaBetPlay.resultadosSeleccionados()) {
			            JOptionPane.showMessageDialog(null, "Por favor, seleccione el resultado para todos los partidos.", "Resultados no seleccionados", JOptionPane.WARNING_MESSAGE);
			        } else {
			        	
			        	// Validar que la cedula ingresada exista
			        	if (casa.getGestorDeApostadores().obtenerIndiceApostador(cedula) == -1) {
			        		JOptionPane.showMessageDialog(null, "La cedula ingresada no ha sido registrada");
			        	} else {
			        		String partidosYResultadosEscogidos[][] = ventanaCreacionApuestaBetPlay.obtenerPartidosYResultadosEscogidos();
				            casa.getGestionBetPlay().agregarApuestaBetPlay(sede, cedula, dia, valorApuesta, partidosYResultadosEscogidos);
				            ventanaCreacionApuestaBetPlay.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
				            ventanaCreacionApuestaBetPlay.agregarPartidos(casa.getGestionBaloto().getArchivo().leerEquipos());
				            JOptionPane.showMessageDialog(null, "La apuesta ha sido agregada exitosamente");
				            ventanaFactura = new VentanaFactura(sede, cedula, dia, valorApuesta, tipoApuesta);
			        	}
			        	
			            
			        }
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "El valor de la apuesta no es valido");
				}
		    	
		    }
		}
		
		
		// Modificar apuesta betplay
		if (e.getSource() == ventanaModificacionApuestaBetPlay.getCargarButton()) {
			
			// Validar que se haya seleccionado una opcion de los JComboBox<>
			if (ventanaModificacionApuestaBetPlay.getSede().getSelectedIndex() == 0
					|| ventanaModificacionApuestaBetPlay.getDia().getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null, "La sede de la apuesta o el dia de la apuesta no han sido seleccionados");
			} else {
				String sedeSeleccionada = ventanaModificacionApuestaBetPlay.getSede().getSelectedItem().toString();
			    String cedulaIngresada = ventanaModificacionApuestaBetPlay.getCedula().getText();
			    String diaSeleccionado = ventanaModificacionApuestaBetPlay.getDia().getSelectedItem().toString();
			    
			    if (sedeSeleccionada.isEmpty() || cedulaIngresada.isEmpty() || diaSeleccionado.isEmpty()) {
			    	JOptionPane.showMessageDialog(null, "La sede de la apuesta y la cedula del apostador deben ser seleccionados ");
			    } else {
			    	int indiceApuesta = casa.getGestionBetPlay().obtenerIndiceApuesta(cedulaIngresada, diaSeleccionado);
			    	if (indiceApuesta == -1) {
			    		JOptionPane.showMessageDialog(null, "La apuesta no ha sido encontrada");
			    	} else {
			    		String[][] partidosYResultados = casa.getGestionBetPlay().obtenerPartidosYResultados(indiceApuesta);
			    		ventanaModificacionApuestaBetPlay.agregarPartidos(partidosYResultados);
			    	}
			    }
			}
			
		    
		}

		if (e.getSource() == ventanaModificacionApuestaBetPlay.getModificarButton()) {
			// Validar que todos los campos estén llenos
		    if (ventanaModificacionApuestaBetPlay.getSede().getSelectedIndex() == 0 ||
		    		ventanaModificacionApuestaBetPlay.getCedula().getText().isEmpty() ||
		    		ventanaModificacionApuestaBetPlay.getDia().getSelectedIndex() == 0 ||
		    		ventanaModificacionApuestaBetPlay.getValorApuesta().getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
		    } else {
		        
		    	String sede = ventanaModificacionApuestaBetPlay.getSede().getSelectedItem().toString();
		    	String cedula = ventanaModificacionApuestaBetPlay.getCedula().getText();
		    	String dia = ventanaModificacionApuestaBetPlay.getDia().getSelectedItem().toString();
		    	String valor = ventanaModificacionApuestaBetPlay.getValorApuesta().getText();
		    	
		    	try {
					double valorApuesta = Double.parseDouble(valor);
					
					if (ventanaCreacionApuestaBetPlay.resultadosSeleccionados()) {
			            JOptionPane.showMessageDialog(null, "Por favor, seleccione el resultado para todos los partidos.", "Resultados no seleccionados", JOptionPane.WARNING_MESSAGE);
			        } else {
			        	
			        	// Validar que la cedula ingresada exista
			        	if (casa.getGestorDeApostadores().obtenerIndiceApostador(cedula) == -1) {
			        		JOptionPane.showMessageDialog(null, "La cedula ingresada no ha sido registrada");
			        	} else {
			        		
			        		int indiceApuesta = casa.getGestionBetPlay().obtenerIndiceApuesta(cedula, dia);
			        		
			        		if (indiceApuesta == -1) {
			        			JOptionPane.showMessageDialog(null, "La apuesta a modificar no ha sido encontrada."
			        					+ "\nAsegurarse de que la cedula y el dia en el que se realizo la apuesta coinciden");
			        		} else {
			        			String partidosYResultadosEscogidos[][] = ventanaCreacionApuestaBetPlay.obtenerPartidosYResultadosEscogidos();
					            casa.getGestionBetPlay().modificarApuestaBetPlay(indiceApuesta, sede, cedula, dia, valorApuesta, partidosYResultadosEscogidos);
					            ventanaCreacionApuestaBetPlay.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
					            ventanaCreacionApuestaBetPlay.agregarPartidos(casa.getGestionBaloto().getArchivo().leerEquipos());
					            JOptionPane.showMessageDialog(null, "La apuesta ha sido modificada exitosamente");
			        		}
			        		
			        		
			        	}
			        	
			            
			        }
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "El valor de la apuesta no es valido");
				}
		    	
		    }
		}

		if (e.getSource() == ventanaModificacionApuestaBetPlay.getEliminarButton()) {
			// Validar que todos los campos estén llenos
		    if (ventanaModificacionApuestaBetPlay.getCedula().getText().isEmpty() ||
		    		ventanaModificacionApuestaBetPlay.getDia().getSelectedIndex() == 0) {
		        JOptionPane.showMessageDialog(null, "Por favor, complete los campos de cedula y dia.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
		    } else {
		        
		    	String cedula = ventanaModificacionApuestaBetPlay.getCedula().getText();
		    	String dia = ventanaModificacionApuestaBetPlay.getDia().getSelectedItem().toString();
		    	
		    	int indiceApuesta = casa.getGestionBetPlay().obtenerIndiceApuesta(cedula, dia);
		    	
		    	if (indiceApuesta == -1) {
		    		JOptionPane.showMessageDialog(null, "La apuesta no se ha registrado");
		    	} else {
		    		casa.getGestionBetPlay().eliminarApuestaBetPlay(indiceApuesta);
		    		ventanaModificacionApuestaBetPlay.reiniciarCampos(casa.getGestorDeSedes().obtenerSedesActuales());
			    	JOptionPane.showMessageDialog(null, "La apuesta ha sido eliminada exitosamente");
		    	}
		    	
		    }
		}
		
		// Realizacion de consultas
		if (e.getSource() == vp.getBtnConsultas()) {
			ventanaConsultas.setVisible(true);
		}
		
		if (e.getSource() == ventanaConsultas.getBtnListadoClientesSede()) {
			String datosClientes = casa.getGestorDeApostadores().obtenerApostadoresPorSede(casa.getGestorDeSedes().obtenerSedesActuales());
			if (!datosClientes.isEmpty())
				JOptionPane.showMessageDialog(null, datosClientes);
			else
				JOptionPane.showMessageDialog(null, "No se han agregado clientes hasta ahora");
		}
		
		if (e.getSource() == ventanaConsultas.getBtnValorTotalApuestasCliente()) {
			String datosApuestas = "";
			ArrayList<String> cedulas = casa.getGestorDeApostadores().obtenerCedulasApostadores();
			for (String cedula: cedulas) {
				double valorTotalApuestas = 0;
				datosApuestas += "Cedula del cliente: " + cedula + "\n";
				datosApuestas += "Valor total apuestas loteria: " + casa.getGestionLoteria().obtenerValorTotalApuestas(cedula) + "\n";
				datosApuestas += "Valor total apuestas superastro: " + casa.getGestionSuperAstro().obtenerValorTotalApuestas(cedula) + "\n";
				datosApuestas += "Valor total apuestas baloto: " + casa.getGestionBaloto().obtenerValorTotalApuestas(cedula) + "\n";
				datosApuestas += "Valor total apuestas betplay: " + casa.getGestionBetPlay().obtenerValorTotalApuestas(cedula) + "\n";
				datosApuestas += "Valor total apuestas chance: " + casa.getGestionChance().obtenerValorTotalApuestas(cedula) + "\n";
				valorTotalApuestas += casa.getGestionLoteria().obtenerValorTotalApuestas(cedula);
				valorTotalApuestas += casa.getGestionSuperAstro().obtenerValorTotalApuestas(cedula);
				valorTotalApuestas += casa.getGestionBaloto().obtenerValorTotalApuestas(cedula);
				valorTotalApuestas += casa.getGestionBetPlay().obtenerValorTotalApuestas(cedula);
				valorTotalApuestas += casa.getGestionChance().obtenerValorTotalApuestas(cedula);
				datosApuestas += "Valor total apuestas hechas por el cliente: " + valorTotalApuestas + "\n\n";
			}
			
			JOptionPane.showMessageDialog(null, datosApuestas);
 		}
		
		if (e.getSource() == ventanaConsultas.getBtnDetalleApuestasClienteSede()) {
			
			String[] opciones = {"Detalle de apuestas por cliente", "Detalle de apuestas por sede"};

	        int seleccion = JOptionPane.showOptionDialog(
	            null,
	            "Seleccione una opción:",
	            "Realizacion de consultas",
	            JOptionPane.DEFAULT_OPTION,
	            JOptionPane.QUESTION_MESSAGE,
	            null,
	            opciones,
	            opciones[0]
	        );

	        // Verificar la opción seleccionada
	        if (seleccion == 0) {
	        	ArrayList<String> cedulas = casa.getGestorDeApostadores().obtenerCedulasApostadores();
	        	String datos = "";
	        	for (String cedula: cedulas) {
	        		datos += "Cliente cedula: " + cedula + "\n";
	        		casa.getGestionLoteria().obtenerApuestasLoteriaPorCliente(cedula);
	        		datos += "Apuestas de loteria:\n";
	        		for (int i = 0; i < casa.getGestionLoteria().obtenerApuestasLoteriaPorCliente(cedula).size(); i++) {
	        			datos += "Dia: " + casa.getGestionLoteria().obtenerApuestasLoteriaPorCliente(cedula).get(i).getDia() + "\n";
	        			datos += "Sede: " + casa.getGestionLoteria().obtenerApuestasLoteriaPorCliente(cedula).get(i).getNombreSede() + "\n";
	        			datos += "Nombre de loteria: " + casa.getGestionLoteria().getApuestasLoteria().get(i).getNombre() + "\n";
	        			datos += "Numero de loteria: " + casa.getGestionLoteria().getApuestasLoteria().get(i).getNumeroLoteria() + "\n";
	        			datos += "Serie: " + casa.getGestionLoteria().getApuestasLoteria().get(i).getSerie() + "\n\n";	  
	        		}
	        		datos += "\nApuestas de Superastro:\n";
	        		
	        		for (int i = 0; i < casa.getGestionSuperAstro().obtenerApuestasSuperAstroPorCliente(cedula).size(); i++) {
	        			datos += "Dia: " + casa.getGestionSuperAstro().obtenerApuestasSuperAstroPorCliente(cedula).get(i).getDia() + "\n";
	        			datos += "Sede: " + casa.getGestionSuperAstro().obtenerApuestasSuperAstroPorCliente(cedula).get(i).getNombreSede() + "\n";
	        			datos += "Numeros seleccionados: " + Arrays.toString(casa.getGestionSuperAstro().obtenerApuestasSuperAstroPorCliente(cedula).get(i).getNumerosSeleccionados()) + "\n";
	        			datos += "Signo del zodiaco: " + casa.getGestionSuperAstro().obtenerApuestasSuperAstroPorCliente(cedula).get(i).getSignoDelZodiaco() + "\n\n";
	        		}
	        		
	        		datos += "\nApuestas de Baloto:\n";
	        		for (int i = 0; i < casa.getGestionBaloto().obtenerApuestasBalotoPorCliente(cedula).size(); i++) {
	        			datos += "Dia: " + casa.getGestionBaloto().getApuestasBaloto().get(i).getDia() + "\n";
	        			datos += "Sede: " + casa.getGestionBaloto().getApuestasBaloto().get(i).getNombreSede() + "\n";
	        			datos += "Numeros seleccionados" + Arrays.toString(casa.getGestionBaloto().getApuestasBaloto().get(i).getNumerosSeleccionados());
	        		}
	        		
	        		datos += "\nApuestas de betplay:\n";
	        		for (int i = 0; i < casa.getGestionBetPlay().obtenerApuestasBetPlayPorCliente(cedula).size(); i++) {
	        			datos += "Dia: " + casa.getGestionBetPlay().getApuestasBetPlay().get(i).getDia() + "\n";
	        			datos += "Sede: " + casa.getGestionBetPlay().getApuestasBetPlay().get(i).getNombreSede() + "\n";
	        			datos += "Valor: " + casa.getGestionBetPlay().getApuestasBetPlay().get(i).getValor() + "\n\n";
	        		}
	        		
	        		datos += "\nApuestas de chance:\n";
	        		for (int i = 0; i < casa.getGestionChance().obtenerApuestasChancePorCliente(cedula).size(); i++) {
	        			datos += "Dia: " + casa.getGestionChance().getApuestasChance().get(i).getDia() + "\n";
	        			datos += "Sede: " + casa.getGestionChance().getApuestasChance().get(i).getNombreSede() + "\n";
	        			datos += "Nombre de la loteria: " + casa.getGestionChance().getApuestasChance().get(i).getNombre() + "\n";
	        			datos += "Numeros seleccionados: " + casa.getGestionChance().getApuestasChance().get(i).getNumerosSeleccionados() + "\n\n";
	        		}
	        		datos += "\n\n";
	        	}
	        	
	        	// Crear un JTextArea para mostrar los datos
	            JTextArea textArea = new JTextArea(datos);
	            textArea.setEditable(false); // Para que el texto no sea editable
	            textArea.setRows(35); // Establecer el número de filas visible del JTextArea

	            // Crear un JScrollPane y agregar el JTextArea a él
	            JScrollPane scrollPane = new JScrollPane(textArea);

	            // Mostrar el JOptionPane con el JScrollPane como componente personalizado
	            JOptionPane.showMessageDialog(null, scrollPane);
	            
	        } else if (seleccion == 1) {
	            // Detalle de apuestas por sede
	        	String datos = "";
	        	String[] sedes = casa.getGestorDeSedes().obtenerSedesActuales();
	        	for (int i = 0; i < sedes.length; i++) {
	        		datos += "Apuestas por sede " + sedes[i] + "\n";
	        		datos += "Apuestas de loteria:\n";
	        		for (int j = 0; j < casa.getGestionLoteria().obtenerApuestasLoteriaPorSede(sedes[i]).size(); j++) {
	        			datos += "Dia: " + casa.getGestionLoteria().obtenerApuestasLoteriaPorSede(sedes[i]).get(j).getDia() + "\n";
	        			datos += "Sede: " + casa.getGestionLoteria().obtenerApuestasLoteriaPorSede(sedes[i]).get(j).getNombreSede() + "\n";
	        			datos += "Nombre de loteria: " + casa.getGestionLoteria().obtenerApuestasLoteriaPorSede(sedes[i]).get(j).getNombre() + "\n";
	        			datos += "Numero de loteria: " + casa.getGestionLoteria().obtenerApuestasLoteriaPorSede(sedes[i]).get(j).getNumeroLoteria() + "\n";
	        			datos += "Serie: " + casa.getGestionLoteria().obtenerApuestasLoteriaPorSede(sedes[i]).get(j).getSerie() + "\n\n";
	        		}
	        		
	        		datos += "\nApuestas de Superastro:\n";
	        		
	        		for (int j = 0; j < casa.getGestionSuperAstro().obtenerApuestasSuperAstroPorSede(sedes[i]).size(); j++) {
	        			datos += "Dia: " + casa.getGestionSuperAstro().obtenerApuestasSuperAstroPorSede(sedes[i]).get(j).getDia() + "\n";
	        			datos += "Sede: " + casa.getGestionSuperAstro().obtenerApuestasSuperAstroPorSede(sedes[i]).get(j).getNombreSede() + "\n";
	        			datos += "Numeros seleccionados: " + Arrays.toString(casa.getGestionSuperAstro().obtenerApuestasSuperAstroPorSede(sedes[i]).get(j).getNumerosSeleccionados()) + "\n";
	        			datos += "Signo del zodiaco: " + casa.getGestionSuperAstro().obtenerApuestasSuperAstroPorSede(sedes[i]).get(j).getSignoDelZodiaco() + "\n\n";
	        		}
	        		
	        		datos += "\nApuestas de Baloto:\n";
	        		for (int j = 0; j < casa.getGestionBaloto().obtenerApuestasBalotoPorSede(sedes[i]).size(); j++) {
	        			datos += "Dia: " + casa.getGestionBaloto().obtenerApuestasBalotoPorSede(sedes[i]).get(j).getDia() + "\n";
	        			datos += "Sede: " + casa.getGestionBaloto().obtenerApuestasBalotoPorSede(sedes[i]).get(j).getNombreSede() + "\n";
	        			datos += "Numeros seleccionados" + casa.getGestionBaloto().obtenerApuestasBalotoPorSede(sedes[i]).get(j).getNumerosSeleccionados();
	        		}
	        		
	        		datos += "\nApuestas de betplay:\n";
	        		for (int j = 0; j < casa.getGestionBetPlay().obtenerApuestasBetPlayPorSede(sedes[i]).size(); j++) {
	        			datos += "Dia: " + casa.getGestionBetPlay().obtenerApuestasBetPlayPorSede(sedes[i]).get(j).getDia() + "\n";
	        			datos += "Sede: " + casa.getGestionBetPlay().obtenerApuestasBetPlayPorSede(sedes[i]).get(j).getNombreSede() + "\n";
	        			datos += "Valor: " + casa.getGestionBetPlay().obtenerApuestasBetPlayPorSede(sedes[i]).get(j).getValor() + "\n\n";
	        		}
	        		
	        		datos += "\nApuestas de chance:\n";
	        		for (int j = 0; j < casa.getGestionChance().obtenerApuestasChancePorCliente(sedes[i]).size(); j++) {
	        			datos += "Dia: " + casa.getGestionChance().obtenerApuestasChancePorCliente(sedes[i]).get(j).getDia() + "\n";
	        			datos += "Sede: " + casa.getGestionChance().obtenerApuestasChancePorCliente(sedes[i]).get(j).getNombreSede() + "\n";
	        			datos += "Nombre de la loteria: " + casa.getGestionChance().obtenerApuestasChancePorCliente(sedes[i]).get(j).getNombre() + "\n";
	        			datos += "Numeros seleccionados: " + casa.getGestionChance().obtenerApuestasChancePorCliente(sedes[i]).get(j).getNumerosSeleccionados() + "\n\n";
	        		}
	        		datos += "\n\n";
	        	}
	        	// Crear un JTextArea para mostrar los datos
	            JTextArea textArea = new JTextArea(datos);
	            textArea.setEditable(false); // Para que el texto no sea editable
	            textArea.setRows(35); // Establecer el número de filas visible del JTextArea

	            // Crear un JScrollPane y agregar el JTextArea a él
	            JScrollPane scrollPane = new JScrollPane(textArea);

	            // Mostrar el JOptionPane con el JScrollPane como componente personalizado
	            JOptionPane.showMessageDialog(null, scrollPane);
	        }
			
			
		}
		
		if (e.getSource() == ventanaConsultas.getBtnTotalApuestasSedeTipoJuego()) {
			
			String[] opciones = {"Total de apuestas por sede", "Total de apuestas por tipo de juego"};

	        int seleccion = JOptionPane.showOptionDialog(
	            null,
	            "Seleccione una opción:",
	            "Realizacion de consultas",
	            JOptionPane.DEFAULT_OPTION,
	            JOptionPane.QUESTION_MESSAGE,
	            null,
	            opciones,
	            opciones[0]
	        );

	        // Verificar la opción seleccionada
	        if (seleccion == 0) {
	        	int totalApuestasPorSede = 0;
	        	String datos = "";
	        	for (int i = 0; i < casa.getGestorDeSedes().obtenerSedesActuales().length; i++) {
	        		
	        		totalApuestasPorSede += casa.getGestionLoteria().obtenerNumeroApuestasLoteriaPorSede(casa.getGestorDeSedes().obtenerSedesActuales()[i]);
	        		totalApuestasPorSede += casa.getGestionSuperAstro().obtenerNumeroApuestasSuperAstroPorSede(casa.getGestorDeSedes().obtenerSedesActuales()[i]);
	        		totalApuestasPorSede += casa.getGestionBaloto().obtenerNumeroApuestasBalotoPorSede(casa.getGestorDeSedes().obtenerSedesActuales()[i]);
	        		totalApuestasPorSede += casa.getGestionBetPlay().obtenerNumeroApuestasBetPlayPorSede(casa.getGestorDeSedes().obtenerSedesActuales()[i]);
	        		totalApuestasPorSede += casa.getGestionChance().obtenerNumeroApuestasChancePorSede(casa.getGestorDeSedes().obtenerSedesActuales()[i]);
	        		datos += "Total de apuestas en la sede " + casa.getGestorDeSedes().obtenerSedesActuales()[i] + ": " + totalApuestasPorSede + "\n\n";
	        	}
	        	JOptionPane.showMessageDialog(null, datos);
	        } else if (seleccion == 1) {
	            String datos = "";
	            datos += "Numero total de apuestas de loteria: " + casa.getGestionLoteria().getApuestasLoteria().size() + "\n";
	            datos += "Numero total de apuestas de superastro: " + casa.getGestionSuperAstro().getApuestasSuperAstro().size() + "\n";
	            datos += "Numero total de apuestas de baloto: " + casa.getGestionBaloto().getApuestasBaloto().size() + "\n";
	            datos += "Numero total de apuestas de betplay: " + casa.getGestionBetPlay().getApuestasBetPlay().size() + "\n";
	            datos += "Numero total de apuestas de chance: " + casa.getGestionChance().getApuestasChance().size() + "\n";
	            JOptionPane.showMessageDialog(null, datos);
	        }
	        
		}

	}
	
}
