import os
import subprocess
import tempfile
import time
import sys

def try_sqlplus():
    print("Intentando usar SQL*Plus para desbloquear la cuenta SYSTEM...")
    
    # Verificar si sqlplus está instalado
    try:
        # Intentar encontrar sqlplus en el PATH
        proc = subprocess.run(
            ["where", "sqlplus"], 
            capture_output=True, 
            text=True
        )
        
        if proc.returncode != 0:
            print("❌ No se encontró SQL*Plus en el sistema.")
            print("Debe tener Oracle Client o Database instalado con SQL*Plus.")
            return False
        
        sqlplus_path = proc.stdout.strip().split("\n")[0]
        print(f"SQL*Plus encontrado en: {sqlplus_path}")
        
    except Exception as e:
        print(f"❌ Error verificando SQL*Plus: {e}")
        print("Asegúrese de tener Oracle Client o Database instalado.")
        return False
    
    # Crear archivo SQL temporal
    try:
        fd, sql_file = tempfile.mkstemp(suffix='.sql')
        os.close(fd)
        
        # Escribir comandos SQL para desbloquear cuenta
        with open(sql_file, 'w') as f:
            f.write("CONNECT / AS SYSDBA\n")
            f.write("ALTER USER SYSTEM ACCOUNT UNLOCK;\n")
            f.write("ALTER USER SYSTEM IDENTIFIED BY oracle;\n")
            f.write("COMMIT;\n")
            f.write("SELECT USERNAME, ACCOUNT_STATUS FROM DBA_USERS WHERE USERNAME = 'SYSTEM';\n")
            f.write("EXIT;\n")
        
        print(f"Script SQL creado en: {sql_file}")
        
        # Ejecutar SQL*Plus con el script
        print("\nEjecutando SQL*Plus...")
        cmd = ["sqlplus", "/nolog", "@" + sql_file]
        print(f"Comando: {' '.join(cmd)}")
        
        process = subprocess.run(
            cmd,
            capture_output=True,
            text=True
        )
        
        # Mostrar salida
        print("\nSalida de SQL*Plus:")
        print(process.stdout)
        
        if process.stderr:
            print("Errores:")
            print(process.stderr)
        
        # Limpiar archivo temporal
        os.unlink(sql_file)
        
        if "ORA-01031" in process.stdout:
            print("\n❌ ERROR: No tiene privilegios suficientes.")
            print("Debe ejecutar este script como un usuario con privilegios administrativos de Windows.")
            print("Pruebe abriendo una terminal como administrador.")
            return False
            
        # Verificar si tuvo éxito
        if "OPEN" in process.stdout or "ALTER USER" in process.stdout:
            print("\n✅ La cuenta SYSTEM ha sido desbloqueada con éxito.")
            return True
        else:
            print("\n❓ No se pudo confirmar si la cuenta fue desbloqueada.")
            print("Revise la salida de SQL*Plus para más detalles.")
            return False
            
    except Exception as e:
        print(f"\n❌ Error ejecutando SQL*Plus: {e}")
        return False

if __name__ == "__main__":
    try_sqlplus() 