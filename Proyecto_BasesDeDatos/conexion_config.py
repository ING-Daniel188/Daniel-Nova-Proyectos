import os
import json
import tkinter as tk
from tkinter import ttk, messagebox
import oracledb
from verificar_oracle import ORACLE_CLIENT_PATH

# Ruta del archivo de configuración
CONFIG_FILE = os.path.join(os.path.dirname(os.path.abspath(__file__)), "db_config.json")

# Configuración por defecto
DEFAULT_CONFIG = {
    "username": "system",
    "password": "oracle",
    "host": "localhost",
    "port": "1521",
    "service_name": "XE"
}

def cargar_config():
    """Carga la configuración de conexión desde el archivo"""
    if os.path.exists(CONFIG_FILE):
        try:
            with open(CONFIG_FILE, 'r') as f:
                return json.load(f)
        except:
            return DEFAULT_CONFIG
    return DEFAULT_CONFIG

def guardar_config(config):
    """Guarda la configuración de conexión en el archivo"""
    try:
        with open(CONFIG_FILE, 'w') as f:
            json.dump(config, f, indent=4)
        return True
    except:
        return False

class ProbarConexionDialog:
    def __init__(self, parent, config=None):
        self.parent = parent
        self.config = config or cargar_config()
        self.resultado = False
        
        # Crear ventana de diálogo
        self.dialog = tk.Toplevel(parent)
        self.dialog.title("Probar conexión a Oracle")
        self.dialog.geometry("500x300")
        self.dialog.resizable(False, False)
        self.dialog.transient(parent)
        self.dialog.grab_set()
        
        # Centrar en la pantalla
        self.center_window()
        
        # Configurar UI
        self.setup_ui()
        
    def center_window(self):
        """Centra la ventana en la pantalla"""
        self.dialog.update_idletasks()
        width = self.dialog.winfo_width()
        height = self.dialog.winfo_height()
        x = (self.dialog.winfo_screenwidth() // 2) - (width // 2)
        y = (self.dialog.winfo_screenheight() // 2) - (height // 2)
        self.dialog.geometry('{}x{}+{}+{}'.format(width, height, x, y))
        
    def setup_ui(self):
        # Frame principal
        main_frame = ttk.Frame(self.dialog, padding="20")
        main_frame.pack(fill=tk.BOTH, expand=True)
        
        # Título
        title_label = ttk.Label(main_frame, text="Probar conexión a Oracle", font=("Arial", 14, "bold"))
        title_label.pack(pady=(0, 20))
        
        # Frame de formulario
        form_frame = ttk.Frame(main_frame)
        form_frame.pack(fill=tk.BOTH, pady=10)
        
        # Usuario
        user_frame = ttk.Frame(form_frame)
        user_frame.pack(fill=tk.X, pady=5)
        ttk.Label(user_frame, text="Usuario:", width=15).pack(side=tk.LEFT)
        self.user_entry = ttk.Entry(user_frame, width=30)
        self.user_entry.pack(side=tk.LEFT, padx=5)
        self.user_entry.insert(0, self.config.get("username", "system"))
        
        # Contraseña
        pass_frame = ttk.Frame(form_frame)
        pass_frame.pack(fill=tk.X, pady=5)
        ttk.Label(pass_frame, text="Contraseña:", width=15).pack(side=tk.LEFT)
        self.pass_entry = ttk.Entry(pass_frame, width=30, show="*")
        self.pass_entry.pack(side=tk.LEFT, padx=5)
        self.pass_entry.insert(0, self.config.get("password", "oracle"))
        
        # Host
        host_frame = ttk.Frame(form_frame)
        host_frame.pack(fill=tk.X, pady=5)
        ttk.Label(host_frame, text="Host:", width=15).pack(side=tk.LEFT)
        self.host_entry = ttk.Entry(host_frame, width=30)
        self.host_entry.pack(side=tk.LEFT, padx=5)
        self.host_entry.insert(0, self.config.get("host", "localhost"))
        
        # Puerto
        port_frame = ttk.Frame(form_frame)
        port_frame.pack(fill=tk.X, pady=5)
        ttk.Label(port_frame, text="Puerto:", width=15).pack(side=tk.LEFT)
        self.port_entry = ttk.Entry(port_frame, width=30)
        self.port_entry.pack(side=tk.LEFT, padx=5)
        self.port_entry.insert(0, self.config.get("port", "1521"))
        
        # Servicio
        service_frame = ttk.Frame(form_frame)
        service_frame.pack(fill=tk.X, pady=5)
        ttk.Label(service_frame, text="Servicio:", width=15).pack(side=tk.LEFT)
        self.service_entry = ttk.Entry(service_frame, width=30)
        self.service_entry.pack(side=tk.LEFT, padx=5)
        self.service_entry.insert(0, self.config.get("service_name", "XE"))
        
        # Botones
        btn_frame = ttk.Frame(main_frame)
        btn_frame.pack(fill=tk.X, pady=(20, 0))
        
        self.probar_btn = ttk.Button(btn_frame, text="Probar conexión", command=self.probar_conexion)
        self.probar_btn.pack(side=tk.LEFT, padx=5)
        
        self.guardar_btn = ttk.Button(btn_frame, text="Guardar y cerrar", command=self.guardar_y_cerrar)
        self.guardar_btn.pack(side=tk.LEFT, padx=5)
        
        self.cancelar_btn = ttk.Button(btn_frame, text="Cancelar", command=self.dialog.destroy)
        self.cancelar_btn.pack(side=tk.RIGHT, padx=5)
        
        # Status
        self.status_var = tk.StringVar()
        self.status_var.set("Introduzca las credenciales y pulse 'Probar conexión'")
        self.status_label = ttk.Label(main_frame, textvariable=self.status_var, foreground="blue")
        self.status_label.pack(pady=(20, 0))
        
    def probar_conexion(self):
        """Prueba la conexión a Oracle con las credenciales proporcionadas"""
        # Obtener datos del formulario
        username = self.user_entry.get()
        password = self.pass_entry.get()
        host = self.host_entry.get()
        port = self.port_entry.get()
        service_name = self.service_entry.get()
        
        # Validar datos
        if not username or not password or not host or not port or not service_name:
            messagebox.showwarning("Advertencia", "Todos los campos son obligatorios.")
            return
        
        # Configurar indicadores visuales
        self.status_var.set("Probando conexión...")
        self.dialog.update_idletasks()
        self.probar_btn.config(state=tk.DISABLED)
        
        # Intentar conectar
        try:
            # Inicializar cliente Oracle
            oracledb.init_oracle_client(lib_dir=ORACLE_CLIENT_PATH)
            
            # Crear cadena de conexión
            conn_string = f"{username}/{password}@{host}:{port}/{service_name}"
            print(f"Probando conexión: {conn_string}")
            
            # Intentar conectar
            connection = oracledb.connect(user=username, password=password, dsn=f"{host}:{port}/{service_name}")
            
            # Obtener información de la base de datos
            cursor = connection.cursor()
            cursor.execute("SELECT BANNER FROM V$VERSION")
            version = cursor.fetchone()
            cursor.close()
            connection.close()
            
            # Mostrar resultado
            self.status_var.set(f"✅ Conexión exitosa. {version[0] if version else ''}")
            self.resultado = True
            
            # Actualizar configuración
            self.config = {
                "username": username,
                "password": password,
                "host": host,
                "port": port,
                "service_name": service_name
            }
            
            # Habilitar botón guardar
            self.guardar_btn.config(state=tk.NORMAL)
            
        except Exception as e:
            # Manejar error específicamente
            if "ORA-01017" in str(e):
                self.status_var.set("❌ Error: Usuario o contraseña incorrectos.")
            else:
                self.status_var.set(f"❌ Error: {str(e)}")
            self.resultado = False
        finally:
            self.probar_btn.config(state=tk.NORMAL)
    
    def guardar_y_cerrar(self):
        """Guarda la configuración y cierra el diálogo"""
        if not self.resultado:
            if not messagebox.askyesno("Advertencia", 
                               "No se ha probado correctamente la conexión. "
                               "¿Desea guardar esta configuración de todos modos?"):
                return
        
        # Guardar configuración
        self.config = {
            "username": self.user_entry.get(),
            "password": self.pass_entry.get(),
            "host": self.host_entry.get(),
            "port": self.port_entry.get(),
            "service_name": self.service_entry.get()
        }
        
        if guardar_config(self.config):
            messagebox.showinfo("Información", "Configuración guardada correctamente.")
            self.dialog.destroy()
        else:
            messagebox.showerror("Error", "No se pudo guardar la configuración.")

# Para ejecutar la herramienta de forma independiente
if __name__ == "__main__":
    root = tk.Tk()
    root.withdraw()
    app = ProbarConexionDialog(root)
    root.mainloop() 