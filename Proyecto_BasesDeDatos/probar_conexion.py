import os
import sys
import oracledb
from database_helper import ORACLE_CLIENT_PATH, initialize_oracle_client
from conexion_config import cargar_config

def probar_conexion():
    print("Iniciando prueba de conexión a Oracle")
    
    # Cargar configuración
    config = cargar_config()
    print(f"Configuración cargada: {config}")
    
    # Forzar credenciales para prueba
    username = "system"
    password = "oracle"
    host = "localhost"
    port = "1521"
    service_name = "XE"
    
    print(f"Usando credenciales: {username}/{password}@{host}:{port}/{service_name}")
    
    # Inicializar Oracle Client
    try:
        print(f"Intentando inicializar Oracle Client desde: {ORACLE_CLIENT_PATH}")
        oracledb.init_oracle_client(lib_dir=ORACLE_CLIENT_PATH)
        print("✅ Oracle Client inicializado correctamente")
    except Exception as e:
        print(f"❌ Error al inicializar Oracle Client: {e}")
        return
    
    # Intentar conexión
    try:
        # Crear cadena de conexión para logging
        conn_string = f"{username}/{password}@{host}:{port}/{service_name}"
        print(f"Intentando conectar con: {username}@{host}:{port}/{service_name}")
        
        # Intentar conexión
        connection = oracledb.connect(
            user=username,
            password=password,
            dsn=f"{host}:{port}/{service_name}"
        )
        
        # Verificar conexión con una consulta simple
        cursor = connection.cursor()
        cursor.execute("SELECT 'Conexión exitosa' FROM dual")
        result = cursor.fetchone()
        print(f"Resultado de prueba: {result[0]}")
        
        # Obtener información de la base de datos
        cursor.execute("SELECT BANNER FROM V$VERSION")
        version = cursor.fetchone()
        cursor.close()
        
        print(f"✅ Conexión exitosa. Versión: {version[0] if version else 'Desconocida'}")
        
        # Cerrar conexión
        connection.close()
        print("Conexión cerrada.")
        
    except Exception as e:
        print(f"❌ Error de conexión: {e}")
        
        # Sugerencias de solución
        if "ORA-01017" in str(e):
            print("\nℹ️ El error ORA-01017 indica usuario/contraseña incorrectos.")
            print("   Sugerencias:")
            print("   - Verifique las credenciales en db_config.json")
            print("   - Use oracle_instances.py para detectar instancias disponibles")
            print("   - La contraseña por defecto para el usuario system es 'oracle' o 'manager'")
        
        elif "DPY-3010" in str(e):
            print("\nℹ️ El error DPY-3010 indica incompatibilidad con el modo thin.")
            print("   Sugerencias:")
            print("   - Asegúrese de que Oracle Client esté correctamente instalado")
            print("   - Ejecute verificar_oracle.py para comprobar la instalación")

if __name__ == "__main__":
    probar_conexion() 