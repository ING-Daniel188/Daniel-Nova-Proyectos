import tkinter as tk
from tkinter import messagebox
import sys
import os
from login import LoginWindow
from verificar_oracle import OracleVerifier, ORACLE_CLIENT_PATH

def ejecutar_verificador():
    """Ejecuta la herramienta de verificación de Oracle Client"""
    print("Ejecutando verificador de Oracle Client...")
    verificador_root = tk.Tk()
    verificador = OracleVerifier(verificador_root)
    verificador_root.mainloop()
    
    # Mostrar mensaje informando que se debe reiniciar la aplicación
    reiniciar = messagebox.askokcancel(
        "Reiniciar aplicación", 
        "Para aplicar los cambios en la configuración de Oracle Client, "
        "es recomendable reiniciar la aplicación. "
        "¿Desea reiniciar la aplicación ahora?"
    )
    
    if reiniciar:
        # Reiniciar la aplicación
        python = sys.executable
        os.execl(python, python, *sys.argv)
    
    return True

def check_oracle_client():
    """Verifica la disponibilidad de Oracle Client y ofrece instalar si no existe"""
    try:
        import oracledb
        try:
            # Intentar inicializar Oracle Client con ruta explícita
            if os.path.exists(ORACLE_CLIENT_PATH):
                oracledb.init_oracle_client(lib_dir=ORACLE_CLIENT_PATH)
                print(f"Oracle Client detectado correctamente en {ORACLE_CLIENT_PATH}")
                return True
            else:
                raise Exception(f"No se encontró Oracle Client en {ORACLE_CLIENT_PATH}")
        except Exception as e:
            print(f"Error al inicializar Oracle Client: {e}")
            
            # Ofrecer ejecutar el verificador
            if messagebox.askyesno(
                "Problema con Oracle Client", 
                f"Se detectó un problema con Oracle Client: {str(e)}\n\n"
                "¿Desea ejecutar la herramienta de verificación para solucionar el problema?"
            ):
                return ejecutar_verificador()
            return False
    except ImportError:
        messagebox.showerror("Error", "El módulo oracledb no está instalado. Ejecute 'pip install oracledb'.")
        return False

if __name__ == "__main__":
    # Iniciar la aplicación con la ventana de login
    root = tk.Tk()
    
    # Verificar argumentos de línea de comando
    if len(sys.argv) > 1 and sys.argv[1] == "--verificar":
        ejecutar_verificador()
        sys.exit(0)
    
    # Si hay problemas con el cliente, ejecutar verificador
    if "--noverify" not in sys.argv and not check_oracle_client():
        root.withdraw()  # Ocultar ventana principal
        ejecutar_verificador()
        root.destroy()
        sys.exit(0)
    
    app = LoginWindow(root)
    root.mainloop() 