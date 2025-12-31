import os
import oracledb
import sys
import re

# Ruta al cliente Oracle
ORACLE_CLIENT_PATH = r"C:\Oracle\instantclient_19_26"

def ejecutar_script_sql(script_file):
    """
    Ejecuta un script SQL usando Python y oracledb con mejor manejo de bloques PL/SQL
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
        
        # Procesar el script para identificar bloques PL/SQL y comandos SQL
        sql_commands = []
        
        # Primero, eliminar comentarios de una línea
        sql_script = re.sub(r'--.*$', '', sql_script, flags=re.MULTILINE)
        
        # Identificar bloques PL/SQL (BEGIN...END;)
        blocks = []
        
        # Buscar bloques PL/SQL que terminan con una sola línea con / (forma común en scripts Oracle)
        pattern = r'BEGIN\s+.*?END;[\s\n]*/+'
        plsql_blocks = re.findall(pattern, sql_script, re.DOTALL)
        for block in plsql_blocks:
            blocks.append(block.strip())
            sql_script = sql_script.replace(block, '')
        
        # Buscar bloques PL/SQL que terminan con END;
        pattern = r'BEGIN\s+.*?END;'
        plsql_blocks = re.findall(pattern, sql_script, re.DOTALL)
        for block in plsql_blocks:
            blocks.append(block.strip())
            sql_script = sql_script.replace(block, '')
        
        # Lo que queda dividirlo por ;
        for cmd in sql_script.split(';'):
            cmd = cmd.strip()
            if cmd:
                sql_commands.append(cmd)
        
        # Combinar todos los comandos
        all_commands = blocks + sql_commands
        
        # Ejecutar cada comando
        for cmd in all_commands:
            cmd = cmd.strip()
            if not cmd:
                continue
                
            print(f"Ejecutando comando: {cmd[:50]}..." + ("..." if len(cmd) > 50 else ""))
            
            try:
                # Manejar el caso especial de / (terminador de PL/SQL en sqlplus)
                if cmd == '/':
                    continue
                    
                # Ejecutar el comando
                cursor.execute(cmd)
                
                # Si es un DML (INSERT, UPDATE, DELETE), mostrar filas afectadas
                if any(keyword in cmd.upper() for keyword in ['INSERT', 'UPDATE', 'DELETE']):
                    print(f"Filas afectadas: {cursor.rowcount}")
                    
            except oracledb.Error as e:
                print(f"Error de Oracle: {e}")
                
                # Si el error es sobre objeto que no existe en DROP, no es crítico
                if "ORA-00942" in str(e) and "DROP" in cmd.upper():
                    print("No es un error crítico, continuando...")
                else:
                    # Preguntar si desea continuar
                    respuesta = input("¿Desea continuar a pesar del error? (s/n): ").lower()
                    if respuesta != 's':
                        connection.close()
                        return False
        
        # Hacer commit de los cambios
        connection.commit()
        print("Cambios confirmados correctamente")
        
        # Cerrar cursor y conexión
        cursor.close()
        connection.close()
        print("Conexión cerrada")
        
        return True
        
    except Exception as e:
        print(f"Error general: {str(e)}")
        return False

if __name__ == "__main__":
    # Verificar argumentos de línea de comando
    if len(sys.argv) > 1:
        script_file = sys.argv[1]
    else:
        script_file = "01_crear_esquema.sql"
    
    # Ejecutar el script
    ejecutar_script_sql(script_file) 