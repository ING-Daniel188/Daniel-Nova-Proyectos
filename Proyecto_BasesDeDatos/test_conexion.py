import oracledb
import os
from database_helper import initialize_oracle_client

def test_conexion():
    print("Iniciando prueba de conexión a Oracle")
    
    # Inicializar Oracle Client
    initialize_oracle_client()
    
    # Credenciales de conexión
    username = "system"
    password = "oracle"
    host = "localhost"
    port = "1521"
    service_name = "XE"
    
    # Crear cadena de conexión para logging
    conn_string = f"{username}/{password}@{host}:{port}/{service_name}"
    print(f"Intentando conectar con: {username}@{host}:{port}/{service_name}")
    
    try:
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
        print(f"Resultado: {result[0]}")
        
        # Obtener información de la base de datos
        cursor.execute("SELECT BANNER FROM V$VERSION")
        version = cursor.fetchone()
        cursor.close()
        
        print(f"✅ Conexión exitosa. Versión: {version[0] if version else 'Desconocida'}")
        
        # Cerrar conexión
        connection.close()
        print("Conexión cerrada.")
        return True
        
    except Exception as e:
        print(f"❌ Error de conexión: {e}")
        return False

if __name__ == "__main__":
    test_conexion() 