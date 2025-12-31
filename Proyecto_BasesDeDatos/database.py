import os
import sys
import oracledb
from tkinter import messagebox
from database_helper import initialize_oracle_client, get_connection_params, get_connection_string, ORACLE_CLIENT_PATH

class DatabaseConnection:
    def __init__(self, username=None, password=None, host=None, port=None, service_name=None):
        """
        Inicializa la conexión a la base de datos Oracle 11g Express Edition.
        Si no se proporcionan credenciales, se solicitarán en una ventana.
        """
        self.username = username or "system"  # Usuario por defecto
        self.password = password or "oracle"  # Contraseña por defecto
        self.host = host or "localhost"       # Host por defecto
        self.port = port or "1521"           # Puerto por defecto
        self.service_name = service_name or "XE"  # Nombre de servicio por defecto
        self.connection = None
        self.thick_mode = False  # Indicador si estamos usando thick mode
        
    def connect(self):
        """
        Establece la conexión a la base de datos Oracle.
        Retorna la conexión si tiene éxito, None en caso contrario.
        """
        try:
            # Verificar que el cliente Oracle esté inicializado
            if not os.environ.get("ORACLE_HOME") and not os.path.exists(ORACLE_CLIENT_PATH):
                messagebox.showerror("Error", 
                                    f"No se encontró el Oracle Client en {ORACLE_CLIENT_PATH}.\n"
                                    "Por favor, siga las instrucciones de instalación en INSTALACION.md")
                print(f"No se encontró Oracle Client en {ORACLE_CLIENT_PATH}")
                return None
            
            # Forzar el uso del modo thick para Oracle 11g
            # Configurar antes de cualquier otra operación con oracledb
            oracledb.init_oracle_client(lib_dir=ORACLE_CLIENT_PATH)
            oracledb.defaults.config_dir = os.path.join(ORACLE_CLIENT_PATH, "network", "admin")
            oracledb.defaults.prefetchrows = 1000
            oracledb.defaults.stmtcachesize = 50
            oracledb.thin = False  # Forzar modo thick explícitamente
            
            self.thick_mode = True
            print("Modo thick inicializado correctamente")
            
            # Imprimir información detallada para depuración
            print(f"Oracle Client Path: {ORACLE_CLIENT_PATH}")
            print(f"Oracle Client existente: {os.path.exists(ORACLE_CLIENT_PATH)}")
            print(f"Archivos en carpeta client: {os.listdir(ORACLE_CLIENT_PATH) if os.path.exists(ORACLE_CLIENT_PATH) else 'N/A'}")
            
            # Obtener cadena de conexión para logging
            connection_string = get_connection_string(
                self.username, self.password, self.host, self.port, self.service_name
            )
            print(f"Intentando conectar con cadena: {connection_string}")
            
            # Parámetros de conexión
            connection_params = get_connection_params(
                self.username, self.password, self.host, self.port, self.service_name
            )
            
            # Intentar conexión con configuración explícita para thick mode
            print("Iniciando conexión en modo thick")
            self.connection = oracledb.connect(**connection_params)
            
            print("Conexión establecida correctamente.")
            version = self.connection.version
            print(f"Versión de la base de datos: {version}")
            return self.connection
            
        except oracledb.DatabaseError as e:
            error_msg = f"Error de Base de Datos Oracle: {str(e)}"
            print(error_msg)
            messagebox.showerror("Error de Conexión", error_msg)
            return None
            
        except oracledb.InterfaceError as e:
            if "DPI-1047" in str(e):
                error_msg = (
                    "Error DPI-1047: No se pudo localizar la biblioteca del cliente Oracle.\n\n"
                    f"Asegúrese de que Oracle Instant Client esté instalado correctamente en:\n{ORACLE_CLIENT_PATH}\n\n"
                    "Ejecute la aplicación nuevamente después de reiniciar su sistema."
                )
            else:
                error_msg = f"Error de Interfaz Oracle: {str(e)}"
            print(error_msg)
            messagebox.showerror("Error de Conexión", error_msg)
            return None
            
        except Exception as e:
            error_msg = f"Error inesperado: {str(e)}"
            print(error_msg)
            messagebox.showerror("Error", error_msg)
            return None

    def close(self):
        """
        Cierra la conexión a la base de datos.
        """
        if self.connection:
            self.connection.close()
            print("Conexión cerrada.")
            
    def execute_query(self, query, params=None):
        """
        Ejecuta una consulta SQL y retorna los resultados.
        Para consultas SELECT.
        """
        try:
            cursor = self.connection.cursor()
            if params:
                cursor.execute(query, params)
            else:
                cursor.execute(query)
            
            columns = [col[0] for col in cursor.description]
            results = cursor.fetchall()
            cursor.close()
            
            return columns, results
        except oracledb.Error as e:
            error_msg = f"Oracle Error: {str(e)}"
            print(error_msg)
            messagebox.showerror("Error de Consulta", error_msg)
            raise
        except Exception as e:
            error_msg = f"Error inesperado: {str(e)}"
            print(error_msg)
            messagebox.showerror("Error", error_msg)
            raise

    def execute_dml(self, query, params=None):
        """
        Ejecuta una operación DML (INSERT, UPDATE, DELETE) y realiza commit.
        Retorna el número de filas afectadas.
        """
        try:
            cursor = self.connection.cursor()
            if params:
                cursor.execute(query, params)
            else:
                cursor.execute(query)
            
            rowcount = cursor.rowcount
            self.connection.commit()
            cursor.close()
            
            return rowcount
        except oracledb.Error as e:
            self.connection.rollback()
            error_msg = f"Oracle Error: {str(e)}"
            print(error_msg)
            messagebox.showerror("Error de Operación", error_msg)
            raise
        except Exception as e:
            self.connection.rollback()
            error_msg = f"Error inesperado: {str(e)}"
            print(error_msg)
            messagebox.showerror("Error", error_msg)
            raise

    def get_sequence_nextval(self, sequence_name):
        """
        Obtiene el siguiente valor de una secuencia.
        """
        try:
            cursor = self.connection.cursor()
            cursor.execute(f"SELECT {sequence_name}.NEXTVAL FROM DUAL")
            nextval = cursor.fetchone()[0]
            cursor.close()
            return nextval
        except oracledb.Error as e:
            error_msg = f"Oracle Error: {str(e)}"
            print(error_msg)
            messagebox.showerror("Error de Secuencia", error_msg)
            return None
        except Exception as e:
            error_msg = f"Error inesperado: {str(e)}"
            print(error_msg)
            messagebox.showerror("Error", error_msg)
            return None

    def get_table_columns(self, table_name):
        """
        Obtiene los nombres de columnas de una tabla.
        """
        try:
            cursor = self.connection.cursor()
            cursor.execute(f"SELECT column_name FROM user_tab_columns WHERE table_name = '{table_name.upper()}'")
            columns = [row[0] for row in cursor.fetchall()]
            cursor.close()
            return columns
        except oracledb.Error as e:
            error_msg = f"Oracle Error: {str(e)}"
            print(error_msg)
            messagebox.showerror("Error", error_msg)
            return []
        except Exception as e:
            error_msg = f"Error inesperado: {str(e)}"
            print(error_msg)
            messagebox.showerror("Error", error_msg)
            return []

    def get_all_tables(self):
        """
        Obtiene todos los nombres de tablas en el esquema actual.
        """
        try:
            cursor = self.connection.cursor()
            cursor.execute("SELECT table_name FROM user_tables ORDER BY table_name")
            tables = [row[0] for row in cursor.fetchall()]
            cursor.close()
            return tables
        except oracledb.Error as e:
            error_msg = f"Oracle Error: {str(e)}"
            print(error_msg)
            messagebox.showerror("Error", error_msg)
            return []
        except Exception as e:
            error_msg = f"Error inesperado: {str(e)}"
            print(error_msg)
            messagebox.showerror("Error", error_msg)
            return [] 