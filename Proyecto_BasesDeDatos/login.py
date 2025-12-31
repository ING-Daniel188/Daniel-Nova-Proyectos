import tkinter as tk
from tkinter import ttk, messagebox
import sys
import oracledb
from database import DatabaseConnection
from gui import MainApplication
from conexion_config import cargar_config, ProbarConexionDialog
from oracle_instances import OracleInstanceFinder

class LoginWindow:
    def __init__(self, root):
        self.root = root
        self.connection = None
        
        # Cargar configuración de conexión
        self.config = cargar_config()
        
        self.setup_ui()
        
    def setup_ui(self):
        """Configura la interfaz de usuario para el login"""
        self.root.title("Conexión a Oracle 11g Express Edition")
        self.root.geometry("400x450")  # Más altura para nuevo botón
        self.root.resizable(False, False)
        
        # Frame principal
        main_frame = ttk.Frame(self.root, padding="20")
        main_frame.pack(fill=tk.BOTH, expand=True)
        
        # Título
        title_label = ttk.Label(main_frame, text="Gastrobar", font=("Arial", 14, "bold"))
        title_label.pack(pady=(0, 20))
        
        # Crear formulario de login
        form_frame = ttk.LabelFrame(main_frame, text="Conexión a la Base de Datos")
        form_frame.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        # Usuario
        username_frame = ttk.Frame(form_frame)
        username_frame.pack(fill=tk.X, pady=5)
        
        ttk.Label(username_frame, text="Usuario:", width=15).pack(side=tk.LEFT)
        self.username_entry = ttk.Entry(username_frame, width=25)
        self.username_entry.pack(side=tk.LEFT, padx=5)
        self.username_entry.insert(0, self.config.get("username", "system"))
        
        # Contraseña
        password_frame = ttk.Frame(form_frame)
        password_frame.pack(fill=tk.X, pady=5)
        
        ttk.Label(password_frame, text="Contraseña:", width=15).pack(side=tk.LEFT)
        self.password_entry = ttk.Entry(password_frame, width=25, show="*")
        self.password_entry.pack(side=tk.LEFT, padx=5)
        self.password_entry.insert(0, self.config.get("password", "oracle"))
        
        # Host
        host_frame = ttk.Frame(form_frame)
        host_frame.pack(fill=tk.X, pady=5)
        
        ttk.Label(host_frame, text="Host:", width=15).pack(side=tk.LEFT)
        self.host_entry = ttk.Entry(host_frame, width=25)
        self.host_entry.pack(side=tk.LEFT, padx=5)
        self.host_entry.insert(0, self.config.get("host", "localhost"))
        
        # Puerto
        port_frame = ttk.Frame(form_frame)
        port_frame.pack(fill=tk.X, pady=5)
        
        ttk.Label(port_frame, text="Puerto:", width=15).pack(side=tk.LEFT)
        self.port_entry = ttk.Entry(port_frame, width=25)
        self.port_entry.pack(side=tk.LEFT, padx=5)
        self.port_entry.insert(0, self.config.get("port", "1521"))
        
        # SID/Servicio
        sid_frame = ttk.Frame(form_frame)
        sid_frame.pack(fill=tk.X, pady=5)
        
        ttk.Label(sid_frame, text="Servicio:", width=15).pack(side=tk.LEFT)
        self.service_entry = ttk.Entry(sid_frame, width=25)
        self.service_entry.pack(side=tk.LEFT, padx=5)
        self.service_entry.insert(0, self.config.get("service_name", "XE"))
        
        # Botones de ayuda para conexión
        tools_frame = ttk.Frame(form_frame)
        tools_frame.pack(fill=tk.X, pady=5)
        
        # Botón para buscar instancias Oracle
        self.find_instances_btn = ttk.Button(tools_frame, text="Buscar instancias Oracle", command=self.buscar_instancias)
        self.find_instances_btn.pack(side=tk.LEFT, pady=5)
        
        # Botón para probar conexión
        self.test_btn = ttk.Button(tools_frame, text="Probar conexión", command=self.probar_conexion)
        self.test_btn.pack(side=tk.RIGHT, pady=5)
        
        # Status message
        self.status_var = tk.StringVar()
        self.status_var.set("Usando cliente Python-Oracle")
        status_label = ttk.Label(form_frame, textvariable=self.status_var, foreground="blue")
        status_label.pack(pady=(5, 0))
        
        try:
            client_version = oracledb.clientversion()
            self.status_var.set(f"Oracle Client v{'.'.join(map(str, client_version))}")
        except:
            self.status_var.set("Oracle Client no detectado - Usando modo thin")
        
        # Botones de acción
        btn_frame = ttk.Frame(main_frame)
        btn_frame.pack(fill=tk.X, pady=(15, 0))
        
        self.connect_btn = ttk.Button(btn_frame, text="Conectar", command=self.connect_to_db)
        self.connect_btn.pack(side=tk.RIGHT)
        
        # Botón para conexión de prueba (solo para depuración)
        self.debug_btn = ttk.Button(btn_frame, text="Depuración", command=self.debug_connection)
        self.debug_btn.pack(side=tk.LEFT)
        
        # Focus en el primer campo
        self.username_entry.focus()
        
    def buscar_instancias(self):
        """Abre el diálogo para buscar instancias Oracle"""
        finder_window = tk.Toplevel(self.root)
        finder = OracleInstanceFinder(finder_window)
        self.root.wait_window(finder_window)
        
        # Cargar configuración actualizada
        self.config = cargar_config()
        self.username_entry.delete(0, tk.END)
        self.username_entry.insert(0, self.config.get("username", "system"))
        self.password_entry.delete(0, tk.END)
        self.password_entry.insert(0, self.config.get("password", "oracle"))
        self.host_entry.delete(0, tk.END)
        self.host_entry.insert(0, self.config.get("host", "localhost"))
        self.port_entry.delete(0, tk.END)
        self.port_entry.insert(0, self.config.get("port", "1521"))
        self.service_entry.delete(0, tk.END)
        self.service_entry.insert(0, self.config.get("service_name", "XE"))
        
    def probar_conexion(self):
        """Abre el diálogo para probar la conexión"""
        config = {
            "username": self.username_entry.get(),
            "password": self.password_entry.get(),
            "host": self.host_entry.get(),
            "port": self.port_entry.get(),
            "service_name": self.service_entry.get()
        }
        
        dialog = ProbarConexionDialog(self.root, config)
        self.root.wait_window(dialog.dialog)
        
        # Si la ventana se cerró correctamente, actualizar campos
        self.config = cargar_config()
        self.username_entry.delete(0, tk.END)
        self.username_entry.insert(0, self.config.get("username", "system"))
        self.password_entry.delete(0, tk.END)
        self.password_entry.insert(0, self.config.get("password", "oracle"))
        self.host_entry.delete(0, tk.END)
        self.host_entry.insert(0, self.config.get("host", "localhost"))
        self.port_entry.delete(0, tk.END)
        self.port_entry.insert(0, self.config.get("port", "1521"))
        self.service_entry.delete(0, tk.END)
        self.service_entry.insert(0, self.config.get("service_name", "XE"))
        
    def debug_connection(self):
        """Modo de depuración para acceder a la aplicación sin conexión real a Oracle"""
        try:
            self.root.withdraw()  # Ocultar ventana de login
            app_window = tk.Toplevel(self.root)
            # Crear un objeto falso de conexión
            connection = type('obj', (object,), {
                'cursor': lambda: type('obj', (object,), {
                    'execute': lambda *args, **kwargs: None,
                    'fetchall': lambda: [],
                    'close': lambda: None,
                    'description': []
                }),
                'close': lambda: None,
                'commit': lambda: None,
                'rollback': lambda: None
            })
            app = MainApplication(app_window, connection)
            
            # Configurar cierre de ventanas
            def on_app_close():
                self.root.destroy()
            
            app_window.protocol("WM_DELETE_WINDOW", on_app_close)
            self.root.protocol("WM_DELETE_WINDOW", on_app_close)
        except Exception as e:
            print(f"Error en modo depuración: {str(e)}")
            messagebox.showerror("Error", f"Error inesperado: {str(e)}")
        
    def connect_to_db(self):
        """Intenta establecer la conexión con la base de datos"""
        username = self.username_entry.get()
        password = self.password_entry.get()
        host = self.host_entry.get()
        port = self.port_entry.get()
        service_name = self.service_entry.get()
        
        # Validaciones básicas
        if not username or not password or not host or not port or not service_name:
            messagebox.showerror("Error", "Todos los campos son obligatorios")
            return
        
        try:
            # Deshabilitar botón mientras se realiza la conexión
            self.connect_btn.configure(state='disabled', text="Conectando...")
            self.status_var.set("Conectando a Oracle...")
            self.root.update()
            
            # Intentar conectar
            db_connection = DatabaseConnection(username, password, host, port, service_name)
            connection = db_connection.connect()
            
            if connection:
                # Mostrar ventana principal
                self.root.withdraw()  # Ocultar ventana de login
                app_window = tk.Toplevel(self.root)
                app = MainApplication(app_window, connection)
                
                # Configurar cierre de ventanas
                def on_app_close():
                    db_connection.close()
                    self.root.destroy()
                
                app_window.protocol("WM_DELETE_WINDOW", on_app_close)
                self.root.protocol("WM_DELETE_WINDOW", on_app_close)
            else:
                self.connect_btn.configure(state='normal', text="Conectar")
                self.status_var.set("Error de conexión")
        except Exception as e:
            print(f"Error de conexión: {str(e)}")
            self.status_var.set(f"Error: {str(e).split('\n')[0]}")
            messagebox.showerror("Error", f"Error inesperado: {str(e)}")
            self.connect_btn.configure(state='normal', text="Conectar")

# Si se ejecuta directamente este archivo
if __name__ == "__main__":
    root = tk.Tk()
    app = LoginWindow(root)
    root.mainloop()