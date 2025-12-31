import os
import oracledb
import getpass
import subprocess
import time

# Ruta al cliente Oracle
ORACLE_CLIENT_PATH = r"C:\Oracle\instantclient_19_26"

def main():
    print("========================================")
    print("HERRAMIENTA PARA DESBLOQUEAR CUENTAS ORACLE")
    print("========================================")
    print("\nEste script intentará desbloquear las cuentas administrativas de Oracle")
    print("Se requieren privilegios de SYSDBA para continuar")
    
    # Inicializar Oracle Client
    try:
        print("\nInicializando Oracle Client...")
        oracledb.init_oracle_client(lib_dir=ORACLE_CLIENT_PATH)
        print("✅ Oracle Client inicializado correctamente")
    except Exception as e:
        print(f"❌ Error al inicializar Oracle Client: {e}")
        input("\nPresione Enter para salir...")
        return
    
    # Solicitar credenciales
    print("\n--- Introduzca las credenciales de SYSDBA ---")
    print("Por defecto en Oracle 11g XE, el usuario es 'SYS' y la contraseña podría ser 'oracle' o 'change_on_install'")
    sys_user = input("Usuario SYS [SYS]: ") or "SYS"
    sys_pwd = getpass.getpass("Contraseña SYS: ")
    
    host = "localhost"
    port = "1521"
    service = "XE"
    
    # Intentar conectar como SYSDBA
    print(f"\nIntentando conectar como {sys_user} con privilegios SYSDBA a {host}:{port}/{service}...")
    
    try:
        connection = oracledb.connect(
            user=sys_user,
            password=sys_pwd,
            dsn=f"{host}:{port}/{service}",
            mode=oracledb.AUTH_MODE_SYSDBA
        )
        
        print("✅ Conexión como SYSDBA establecida correctamente!")
        
        # Crear script temporal modificado
        script_path = os.path.join(os.getcwd(), "desbloquear_cuentas.sql")
        if not os.path.exists(script_path):
            print(f"❌ No se encontró el archivo {script_path}")
            connection.close()
            input("\nPresione Enter para salir...")
            return
            
        # Ejecutar script SQL
        print("\nEjecutando script para desbloquear cuentas...")
        cursor = connection.cursor()
        
        # Leer el script
        with open(script_path, 'r') as f:
            sql_script = f.read()
            
        # Dividir el script en comandos separados
        commands = sql_script.split(';')
        
        # Ejecutar cada comando
        for cmd in commands:
            if cmd.strip():
                try:
                    print(f"Ejecutando: {cmd.strip()}")
                    cursor.execute(cmd)
                    if cursor.description:
                        rows = cursor.fetchall()
                        for row in rows:
                            print(f"    {row}")
                except Exception as e:
                    print(f"❌ Error al ejecutar comando: {e}")
        
        # Confirmar cambios
        connection.commit()
        print("\n✅ Todas las operaciones completadas.")
        
        # Verificar si se puede conectar con SYSTEM
        try:
            print("\nVerificando conexión con usuario SYSTEM...")
            system_conn = oracledb.connect(
                user="SYSTEM",
                password="oracle",
                dsn=f"{host}:{port}/{service}"
            )
            print("✅ Conexión con SYSTEM exitosa!")
            
            # Crear archivo de configuración
            with open("db_config.json", "w") as f:
                f.write('''{
    "username": "SYSTEM",
    "password": "oracle",
    "host": "localhost",
    "port": "1521",
    "service_name": "XE"
}''')
            print("✅ Configuración guardada en db_config.json")
            
            system_conn.close()
        except Exception as e:
            print(f"❌ Error al verificar conexión con SYSTEM: {e}")
        
        # Cerrar conexiones
        cursor.close()
        connection.close()
        print("\nConexiones cerradas correctamente.")
        
    except Exception as e:
        print(f"❌ Error al conectar como SYSDBA: {e}")
        print("\nSugerencias:")
        print("1. Verifique que las credenciales sean correctas")
        print("2. Asegúrese de que la base de datos esté en ejecución")
        print("3. Utilice la herramienta sqlplus directamente desde la línea de comandos:")
        print("   > sqlplus sys/contraseña@XE as sysdba")
        print("   SQL> ALTER USER SYSTEM ACCOUNT UNLOCK;")
        print("   SQL> ALTER USER SYSTEM IDENTIFIED BY oracle;")
        print("   SQL> COMMIT;")
        print("   SQL> EXIT")
    
    input("\nPresione Enter para salir...")

if __name__ == "__main__":
    main() 