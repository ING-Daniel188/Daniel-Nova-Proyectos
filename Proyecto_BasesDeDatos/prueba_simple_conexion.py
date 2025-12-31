import os
import oracledb

# Ruta al cliente Oracle
ORACLE_CLIENT_PATH = r"C:\Oracle\instantclient_19_26"

def probar_credenciales():
    print("Iniciando pruebas de conexión con diferentes credenciales")
    
    # Inicializar Cliente Oracle
    try:
        print(f"Intentando inicializar Oracle Client desde: {ORACLE_CLIENT_PATH}")
        oracledb.init_oracle_client(lib_dir=ORACLE_CLIENT_PATH)
        print("✅ Oracle Client inicializado correctamente")
    except Exception as e:
        print(f"❌ ERROR al inicializar Oracle Client: {e}")
        return False
    
    # Lista de combinaciones de servicios a probar
    servicios = ["XE", "XEPDB1", "ORCL"]
    
    # Lista de credenciales comunes para probar
    credenciales = [
        {"user": "system", "password": "oracle", "desc": "System/Oracle (default)"},
        {"user": "SYSTEM", "password": "ORACLE", "desc": "SYSTEM/ORACLE (mayúsculas)"},
        {"user": "system", "password": "manager", "desc": "System/Manager (common)"},
        {"user": "sys", "password": "oracle", "desc": "SYS/Oracle (as SYSDBA)"},
        {"user": "SYS", "password": "ORACLE", "desc": "SYS/ORACLE (mayúsculas)"},
        {"user": "sys", "password": "manager", "desc": "SYS/Manager (as SYSDBA)"},
        {"user": "system", "password": "password", "desc": "System/Password"},
        {"user": "system", "password": "sys", "desc": "System/Sys"},
        {"user": "sys", "password": "sys", "desc": "SYS/SYS"},
        {"user": "system", "password": "system", "desc": "System/System"},
        {"user": "SYSTEM", "password": "SYSTEM", "desc": "SYSTEM/SYSTEM (mayúsculas)"}
    ]
    
    # Configuración base
    host = "localhost"
    port = "1521"
    
    # Probar cada servicio
    for service in servicios:
        print(f"\n=== Probando con servicio: {service} ===")
        
        # Intentar conectar con cada combinación
        for cred in credenciales:
            user = cred["user"]
            password = cred["password"]
            desc = cred["desc"]
            
            print(f"\nIntentando conectar con: {desc} - {user}@{host}:{port}/{service}")
            
            try:
                # Si es SYS, debe usar modo privilegiado
                if user.lower() == "sys":
                    connection = oracledb.connect(
                        user=user, 
                        password=password, 
                        dsn=f"{host}:{port}/{service}",
                        mode=oracledb.AUTH_MODE_SYSDBA
                    )
                else:
                    connection = oracledb.connect(
                        user=user, 
                        password=password, 
                        dsn=f"{host}:{port}/{service}"
                    )
                
                print(f"✅ ¡CONEXIÓN EXITOSA con {desc}!")
                
                # Probar consulta
                cursor = connection.cursor()
                cursor.execute("SELECT 'CONEXIÓN EXITOSA DESDE PYTHON' FROM dual")
                result = cursor.fetchone()
                print(f"Resultado: {result[0]}")
                
                # Verificar versión
                cursor.execute("SELECT BANNER FROM V$VERSION WHERE ROWNUM=1")
                version = cursor.fetchone()
                print(f"Versión Oracle: {version[0] if version else 'Desconocida'}")
                
                # Cerrar recursos
                cursor.close()
                connection.close()
                print("Conexión cerrada correctamente.")
                
                # Si llegamos aquí, la conexión fue exitosa, guardar estas credenciales
                print("\n=== CREDENCIALES CORRECTAS ENCONTRADAS ===")
                print(f"Usuario: {user}")
                print(f"Contraseña: {password}")
                print(f"Host: {host}")
                print(f"Puerto: {port}")
                print(f"Servicio: {service}")
                print("=========================================")
                
                # Crear archivo de configuración
                try:
                    with open("db_config.json", "w") as f:
                        f.write(f'''{{
    "username": "{user}",
    "password": "{password}",
    "host": "{host}",
    "port": "{port}",
    "service_name": "{service}"
}}''')
                    print("✅ Configuración guardada en db_config.json")
                except Exception as e:
                    print(f"Error al guardar configuración: {e}")
                
                return True
                
            except Exception as e:
                print(f"❌ Error con {desc}: {e}")
    
    print("\n❌ No se pudo conectar con ninguna combinación de credenciales.")
    print("Por favor verifique:")
    print("1. Que el servidor Oracle esté en ejecución")
    print("2. Que las credenciales sean correctas")
    print("3. Los nombres de servicio disponibles (XE, XEPDB1, ORCL, etc)")
    
    return False

if __name__ == "__main__":
    probar_credenciales() 