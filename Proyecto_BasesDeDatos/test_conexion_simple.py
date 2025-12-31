import oracledb
import os

ORACLE_CLIENT_PATH = r"C:\Oracle\instantclient_19_26"

def test_conexion():
    print("--- Test de conexión simplificado ---")
    
    try:
        print(f"Inicializando Oracle Client desde: {ORACLE_CLIENT_PATH}...")
        oracledb.init_oracle_client(lib_dir=ORACLE_CLIENT_PATH)
        print("✅ Cliente inicializado")
    except Exception as e:
        print(f"❌ Error inicializando cliente: {e}")
        return
    
    # Credenciales
    username = "SYSTEM"
    password = "oracle"
    host = "localhost"
    port = "1521"
    service = "XE"
    
    print(f"\nIntentando conectar con: {username}/{password}@{host}:{port}/{service}")
    try:
        connection = oracledb.connect(
            user=username,
            password=password,
            dsn=f"{host}:{port}/{service}"
        )
        
        print("✅ CONEXIÓN EXITOSA!")
        
        # Probar consulta simple
        cursor = connection.cursor()
        cursor.execute("SELECT 'Hola desde Oracle' FROM DUAL")
        result = cursor.fetchone()
        print(f"Resultado: {result[0]}")
        
        # Información de la base de datos
        cursor.execute("SELECT INSTANCE_NAME, VERSION, STATUS FROM V$INSTANCE")
        instance_info = cursor.fetchone()
        if instance_info:
            print(f"Instancia: {instance_info[0]}, Versión: {instance_info[1]}, Estado: {instance_info[2]}")
        
        # Información sobre cuentas bloqueadas
        print("\nCuentas bloqueadas:")
        try:
            cursor.execute("SELECT USERNAME, ACCOUNT_STATUS FROM DBA_USERS WHERE ACCOUNT_STATUS LIKE '%LOCKED%'")
            locked_accounts = cursor.fetchall()
            for account in locked_accounts:
                print(f"- {account[0]}: {account[1]}")
        except Exception as e:
            print(f"No se pudo obtener información de cuentas: {e}")
        
        cursor.close()
        connection.close()
        print("Conexión cerrada correctamente.")
        
    except oracledb.DatabaseError as e:
        error = str(e)
        print(f"❌ Error de base de datos: {error}")
        
        if "ORA-28000" in error:
            print("\nLa cuenta está bloqueada. Debe desbloquearla con una cuenta administrativa.")
            print("Ejecute: sqlplus / as sysdba")
            print("SQL> ALTER USER SYSTEM ACCOUNT UNLOCK;")
            print("SQL> ALTER USER SYSTEM IDENTIFIED BY oracle;")
            print("SQL> COMMIT;")
            print("SQL> EXIT")
        
        elif "ORA-01017" in error:
            print("\nCredenciales incorrectas.")
            print("Las contraseñas comunes para SYSTEM son: oracle, manager, password, admin")
            
    except Exception as e:
        print(f"❌ Error general: {e}")

if __name__ == "__main__":
    test_conexion() 