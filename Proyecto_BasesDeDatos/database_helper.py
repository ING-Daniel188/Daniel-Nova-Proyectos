import os
import sys
import oracledb
from tkinter import messagebox

# Definir ruta explícita al Oracle Client
ORACLE_CLIENT_PATH = r"C:\Oracle\instantclient_19_26"

def initialize_oracle_client():
    """
    Intenta inicializar el cliente Oracle y maneja posibles errores.
    
    Returns:
        bool: True si la inicialización fue exitosa, False en caso contrario.
    """
    try:
        # Verificar si la carpeta del cliente existe
        if not os.path.exists(ORACLE_CLIENT_PATH):
            error_msg = f"No se encontró el Oracle Client en {ORACLE_CLIENT_PATH}"
            print(error_msg)
            messagebox.showerror("Error", error_msg)
            return False
        
        # Intentar inicializar el cliente Oracle con ruta explícita
        oracledb.init_oracle_client(lib_dir=ORACLE_CLIENT_PATH)
        print(f"Cliente Oracle inicializado correctamente desde {ORACLE_CLIENT_PATH} (modo thick)")
        return True
    except oracledb.ProgrammingError as e:
        # Error específico cuando no se puede encontrar el cliente Oracle
        error_msg = (
            f"Error al inicializar el cliente Oracle: {str(e)}\n\n"
            "Esto puede deberse a:\n"
            "1. El cliente Oracle no está instalado correctamente\n"
            "2. La ruta al cliente Oracle no es correcta\n"
            "3. Faltan algunos archivos DLL necesarios\n\n"
            "Por favor, verifique que todos los archivos de Instant Client estén en:\n"
            f"{ORACLE_CLIENT_PATH}\n\n"
            "La aplicación intentará usar el modo thin, pero puede no ser compatible con Oracle 11g."
        )
        print(error_msg)
        messagebox.showerror("Error de Oracle Client", error_msg)
        return False
    except Exception as e:
        # Otros errores
        error_msg = f"Error al inicializar el cliente Oracle: {str(e)}"
        print(error_msg)
        messagebox.showerror("Error", error_msg)
        return False

def get_connection_params(username, password, host, port, service_name):
    """
    Prepara los parámetros de conexión dependiendo de si se usa thick o thin mode.
    
    Args:
        username (str): Nombre de usuario
        password (str): Contraseña
        host (str): Host del servidor Oracle
        port (str): Puerto del servidor
        service_name (str): Nombre del servicio o SID
        
    Returns:
        dict: Parámetros para usar con oracledb.connect()
    """
    # Intentamos usar params que funcionan en cualquier modo
    return {
        "user": username,
        "password": password,
        "dsn": f"{host}:{port}/{service_name}"
    }

def get_connection_string(username, password, host, port, service_name):
    """
    Genera una cadena de conexión para Oracle.
    
    Returns:
        str: Cadena de conexión completa
    """
    return f"{username}/{password}@{host}:{port}/{service_name}" 