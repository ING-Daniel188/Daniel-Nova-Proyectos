import os
import oracledb
import sys

# Ruta al cliente Oracle
ORACLE_CLIENT_PATH = r"C:\Oracle\instantclient_19_26"

def ejecutar_script_sql(script_file):
    """
    Ejecuta un script SQL usando Python y oracledb
    """
    print(f"Ejecutando script: {script_file}")
    
    # Verificar que el archivo existe
    if not os.path.exists(script_file):
        print(f"Error: El archivo {script_file} no existe")
        return False
    
    try:
        # Inicializar Oracle Client
        print(f"Inicializando Oracle Client desde: {ORACLE_CLIENT_PATH}")
        oracledb.init_oracle_client(lib_dir=ORACLE_CLIENT_PATH)
        print("Oracle Client inicializado correctamente")
        
        # Leer el script SQL
        with open(script_file, 'r') as f:
            sql_script = f.read()
        
        # Conectar a la base de datos
        print("Conectando a la base de datos...")
        connection = oracledb.connect(
            user="SYSTEM",
            password="oracle",
            dsn="localhost:1521/XE"
        )
        print("Conexión establecida correctamente")
        
        # Crear cursor
        cursor = connection.cursor()
        
        # Dividir el script en comandos SQL individuales
        # Los comandos SQL terminan con ';'
        commands = sql_script.split(';')
        
        # Ejecutar cada comando
        for cmd in commands:
            # Eliminar espacios en blanco y saltos de línea
            cmd = cmd.strip()
            
            # Ignorar líneas de comentario y bloques PL/SQL
            if cmd and not cmd.startswith('--'):
                try:
                    # Si es un bloque PL/SQL (comienza con BEGIN o DECLARE)
                    if cmd.upper().startswith('BEGIN') or cmd.upper().startswith('DECLARE'):
                        print(f"Ejecutando bloque PL/SQL...")
                        cursor.execute(cmd)
                    # Si es un comando SQL normal
                    elif cmd:
                        print(f"Ejecutando: {cmd[:50]}...")
                        cursor.execute(cmd)
                except Exception as e:
                    print(f"Error ejecutando: {cmd[:50]}...")
                    print(f"Error: {str(e)}")
        
        # Hacer commit de los cambios
        connection.commit()
        print("Cambios confirmados correctamente")
        
        # Cerrar cursor y conexión
        cursor.close()
        connection.close()
        print("Conexión cerrada")
        
        return True
        
    except Exception as e:
        print(f"Error: {str(e)}")
        return False

if __name__ == "__main__":
    # Verificar argumentos de línea de comando
    if len(sys.argv) > 1:
        script_file = sys.argv[1]
    else:
        script_file = "01_crear_esquema.sql"
    
    # Ejecutar el script
    ejecutar_script_sql(script_file) 