import oracledb

# Ruta al cliente Oracle
ORACLE_CLIENT_PATH = r"C:\Oracle\instantclient_19_26"

def probar_sys():
    print("Probando conexión con usuario SYS...")
    
    try:
        # Inicializar Cliente Oracle
        oracledb.init_oracle_client(lib_dir=ORACLE_CLIENT_PATH)
        
        # Configuración de conexión
        user = "SYS"
        passwords = ["oracle", "change_on_install", "sys", "manager", "password", "Oracle123"]
        host = "localhost"
        port = "1521"
        service = "XE"
        
        # Probar cada contraseña
        for password in passwords:
            try:
                print(f"\nIntentando conectar con SYS/{password}@{host}:{port}/{service} como SYSDBA...")
                
                # Conectar como SYSDBA
                connection = oracledb.connect(
                    user=user,
                    password=password,
                    dsn=f"{host}:{port}/{service}",
                    mode=oracledb.AUTH_MODE_SYSDBA
                )
                
                print(f"✅ ¡CONEXIÓN EXITOSA con {user}/{password}!")
                
                # Verificar estado del usuario SYSTEM
                print("\nVerificando estado del usuario SYSTEM...")
                cursor = connection.cursor()
                cursor.execute("SELECT USERNAME, ACCOUNT_STATUS FROM DBA_USERS WHERE USERNAME = 'SYSTEM'")
                result = cursor.fetchone()
                if result:
                    print(f"Usuario: {result[0]}, Estado: {result[1]}")
                    
                    # Si la cuenta está bloqueada, desbloquearla
                    if "LOCKED" in result[1]:
                        print("Desbloqueando cuenta SYSTEM...")
                        cursor.execute("ALTER USER SYSTEM ACCOUNT UNLOCK")
                        cursor.execute("ALTER USER SYSTEM IDENTIFIED BY oracle")
                        connection.commit()
                        print("✅ Cuenta SYSTEM desbloqueada y contraseña cambiada a 'oracle'")
                
                # Cerrar recursos
                cursor.close()
                connection.close()
                
                # Actualizar archivo de configuración
                with open("db_config.json", "w") as f:
                    f.write(f'''{{
    "username": "SYSTEM",
    "password": "oracle",
    "host": "localhost",
    "port": "1521",
    "service_name": "XE"
}}''')
                print("✅ Configuración guardada en db_config.json")
                
                # Probar conexión con SYSTEM
                try:
                    print("\nProbando conexión con SYSTEM/oracle...")
                    system_conn = oracledb.connect(
                        user="SYSTEM",
                        password="oracle",
                        dsn=f"{host}:{port}/{service}"
                    )
                    print("✅ Conexión con SYSTEM exitosa!")
                    system_conn.close()
                except Exception as e:
                    print(f"❌ Error al conectar con SYSTEM: {e}")
                
                return True
                
            except Exception as e:
                print(f"❌ Error: {e}")
        
        print("\n❌ No se pudo conectar con ninguna contraseña.")
        return False
        
    except Exception as e:
        print(f"❌ Error al inicializar Oracle Client: {e}")
        return False

if __name__ == "__main__":
    probar_sys() 