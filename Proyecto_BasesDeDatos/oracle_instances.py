import os
import sys
import subprocess
import re
import tkinter as tk
from tkinter import ttk, messagebox, scrolledtext
from verificar_oracle import ORACLE_CLIENT_PATH
from conexion_config import cargar_config, guardar_config

class OracleInstanceFinder:
    def __init__(self, root):
        self.root = root
        self.instances = []
        self.setup_ui()
        
    def setup_ui(self):
        self.root.title("Buscador de Instancias Oracle")
        self.root.geometry("650x500")  # Aumentar tamaño para log
        
        # Frame principal
        main_frame = ttk.Frame(self.root, padding="20")
        main_frame.pack(fill=tk.BOTH, expand=True)
        
        # Título
        title_label = ttk.Label(main_frame, text="Buscador de Instancias Oracle", font=("Arial", 14, "bold"))
        title_label.pack(pady=(0, 10))
        
        # Descripción
        desc_label = ttk.Label(main_frame, text="Esta herramienta busca instancias Oracle en su sistema "
                                             "y le ayuda a configurar la conexión correctamente.")
        desc_label.pack(pady=(0, 20))
        
        # Frame para la búsqueda
        search_frame = ttk.LabelFrame(main_frame, text="Búsqueda de instancias")
        search_frame.pack(fill=tk.BOTH, expand=True, padx=5, pady=5)
        
        # Botón de búsqueda
        btn_frame = ttk.Frame(search_frame)
        btn_frame.pack(fill=tk.X, pady=10)
        
        self.search_btn = ttk.Button(btn_frame, text="Buscar instancias Oracle", command=self.buscar_instancias)
        self.search_btn.pack(side=tk.LEFT, padx=5)
        
        self.manual_btn = ttk.Button(btn_frame, text="Agregar instancia manual", command=self.agregar_manual)
        self.manual_btn.pack(side=tk.RIGHT, padx=5)
        
        # Resultados
        self.result_frame = ttk.Frame(search_frame)
        self.result_frame.pack(fill=tk.BOTH, expand=True, padx=5, pady=5)
        
        columns = ('nombre', 'host', 'puerto', 'estado')
        self.tree = ttk.Treeview(self.result_frame, columns=columns, show='headings')
        
        # Definir encabezados
        self.tree.heading('nombre', text='Nombre')
        self.tree.heading('host', text='Host')
        self.tree.heading('puerto', text='Puerto')
        self.tree.heading('estado', text='Estado')
        
        # Definir anchura de columnas
        self.tree.column('nombre', width=100)
        self.tree.column('host', width=150)
        self.tree.column('puerto', width=80)
        self.tree.column('estado', width=120)
        
        # Scrollbar para la tabla
        scrollbar_y = ttk.Scrollbar(self.result_frame, orient=tk.VERTICAL, command=self.tree.yview)
        self.tree.configure(yscrollcommand=scrollbar_y.set)
        scrollbar_y.pack(side=tk.RIGHT, fill=tk.Y)
        self.tree.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        
        # Botón para usar la instancia seleccionada
        self.use_btn = ttk.Button(search_frame, text="Usar instancia seleccionada", 
                               command=self.usar_instancia_seleccionada, state=tk.DISABLED)
        self.use_btn.pack(pady=10)
        
        # Log de búsqueda (nuevo)
        log_frame = ttk.LabelFrame(main_frame, text="Log de búsqueda")
        log_frame.pack(fill=tk.BOTH, expand=True, padx=5, pady=5)
        
        self.log_text = scrolledtext.ScrolledText(log_frame, height=8, wrap=tk.WORD)
        self.log_text.pack(fill=tk.BOTH, expand=True, padx=5, pady=5)
        self.log_text.config(state=tk.DISABLED)
        
        # Status
        self.status_var = tk.StringVar()
        self.status_var.set("Haga clic en 'Buscar instancias Oracle' para comenzar")
        status_label = ttk.Label(main_frame, textvariable=self.status_var, foreground="blue")
        status_label.pack(pady=(10, 0))
        
        # Botones inferiores
        btn_frame = ttk.Frame(main_frame)
        btn_frame.pack(fill=tk.X, pady=(10, 0))
        
        self.close_btn = ttk.Button(btn_frame, text="Cerrar", command=self.root.destroy)
        self.close_btn.pack(side=tk.RIGHT)
        
    def log(self, message):
        """Añade un mensaje al log"""
        self.log_text.config(state=tk.NORMAL)
        self.log_text.insert(tk.END, f"{message}\n")
        self.log_text.see(tk.END)
        self.log_text.config(state=tk.DISABLED)
        self.root.update_idletasks()
    
    def buscar_instancias(self):
        """Busca instancias Oracle disponibles en el sistema"""
        self.instances = []
        self.tree.delete(*self.tree.get_children())
        self.use_btn.config(state=tk.DISABLED)
        self.status_var.set("Buscando instancias Oracle...")
        
        # Limpiar log
        self.log_text.config(state=tk.NORMAL)
        self.log_text.delete(1.0, tk.END)
        self.log_text.config(state=tk.DISABLED)
        
        self.log("Iniciando búsqueda de instancias Oracle...")
        self.root.update_idletasks()
        
        try:
            # Método 1: Buscar en tnsnames.ora
            self.log("Buscando en archivos tnsnames.ora...")
            self.buscar_en_tnsnames()
            
            # Método 2: Buscar servicios Oracle en el sistema (Windows)
            self.log("Buscando servicios Oracle en Windows...")
            self.buscar_servicios_oracle()
            
            # Método 3: Buscar instancias mediante listener
            self.log("Buscando con lsnrctl...")
            self.buscar_con_lsnrctl()
            
            # Método 4: Buscar en variables de entorno
            self.log("Buscando en variables de entorno...")
            self.buscar_en_variables_entorno()
            
            # Si no se encontró ninguna instancia, agregar una por defecto
            if not self.instances:
                self.log("No se encontraron instancias Oracle automáticamente.")
                self.log("Agregando instancia por defecto (XE en localhost)...")
                self.instances.append({
                    'nombre': 'XE',
                    'host': 'localhost',
                    'puerto': '1521',
                    'estado': 'Por defecto'
                })
            
            # Actualizar UI con los resultados
            for instance in self.instances:
                self.tree.insert('', tk.END, values=(
                    instance.get('nombre', 'N/A'),
                    instance.get('host', 'N/A'),
                    instance.get('puerto', 'N/A'),
                    instance.get('estado', 'N/A')
                ))
            
            if self.instances:
                self.status_var.set(f"Se encontraron {len(self.instances)} instancias Oracle")
                self.use_btn.config(state=tk.NORMAL)
                self.log(f"Búsqueda completada. Se encontraron {len(self.instances)} instancias.")
            else:
                self.status_var.set("No se encontraron instancias Oracle")
                self.log("No se encontraron instancias Oracle.")
        except Exception as e:
            error_msg = f"Error: {str(e)}"
            self.log(f"ERROR: {error_msg}")
            self.status_var.set(error_msg)
            messagebox.showerror("Error", f"Error al buscar instancias: {str(e)}")
    
    def buscar_en_variables_entorno(self):
        """Busca instancias Oracle en variables de entorno"""
        try:
            # Verificar ORACLE_SID
            oracle_sid = os.environ.get('ORACLE_SID')
            if oracle_sid:
                self.log(f"Encontrada variable ORACLE_SID = {oracle_sid}")
                # Verificar que no esté duplicada
                if not any(i.get('nombre') == oracle_sid for i in self.instances):
                    self.instances.append({
                        'nombre': oracle_sid,
                        'host': 'localhost',
                        'puerto': '1521',  # Puerto por defecto
                        'estado': 'Variable entorno'
                    })
            else:
                self.log("No se encontró variable ORACLE_SID")
                
            # Verificar TWO_TASK (usado en UNIX/Linux)
            two_task = os.environ.get('TWO_TASK')
            if two_task:
                self.log(f"Encontrada variable TWO_TASK = {two_task}")
                # Verificar que no esté duplicada
                if not any(i.get('nombre') == two_task for i in self.instances):
                    self.instances.append({
                        'nombre': two_task,
                        'host': 'localhost',
                        'puerto': '1521',  # Puerto por defecto
                        'estado': 'Variable entorno'
                    })
            else:
                self.log("No se encontró variable TWO_TASK")
        except Exception as e:
            self.log(f"Error al buscar en variables de entorno: {e}")
    
    def buscar_en_tnsnames(self):
        """Busca instancias Oracle en el archivo tnsnames.ora"""
        # Posibles ubicaciones de tnsnames.ora
        locations = [
            os.path.join(ORACLE_CLIENT_PATH, "network", "admin", "tnsnames.ora"),
            os.environ.get("TNS_ADMIN") and os.path.join(os.environ.get("TNS_ADMIN"), "tnsnames.ora"),
            os.environ.get("ORACLE_HOME") and os.path.join(os.environ.get("ORACLE_HOME"), "network", "admin", "tnsnames.ora")
        ]
        
        found = False
        for location in locations:
            if location and os.path.exists(location):
                self.log(f"Encontrado archivo tnsnames.ora en: {location}")
                try:
                    with open(location, 'r') as f:
                        content = f.read()
                    
                    # Buscar entradas en tnsnames.ora
                    # Este regex es muy básico, una implementación completa requeriría un parser
                    entries = re.findall(r'([a-zA-Z0-9_]+)\s*=\s*\(.*?HOST\s*=\s*([^)]+)\).*?PORT\s*=\s*(\d+)', 
                                       content, re.DOTALL | re.IGNORECASE)
                    
                    if entries:
                        self.log(f"Se encontraron {len(entries)} entradas en tnsnames.ora")
                        found = True
                        for name, host, port in entries:
                            self.log(f"Entrada encontrada: {name} en {host}:{port}")
                            # Verificar duplicados
                            if not any(i.get('nombre') == name for i in self.instances):
                                self.instances.append({
                                    'nombre': name,
                                    'host': host.strip(),
                                    'puerto': port.strip(),
                                    'estado': 'tnsnames.ora'
                                })
                    else:
                        self.log("No se encontraron entradas en tnsnames.ora")
                except Exception as e:
                    self.log(f"Error al leer tnsnames.ora: {e}")
        
        if not found:
            self.log("No se encontró ningún archivo tnsnames.ora")
    
    def buscar_servicios_oracle(self):
        """Busca servicios Oracle en el sistema (Windows)"""
        try:
            if sys.platform == 'win32':
                self.log("Ejecutando consulta de servicios Windows...")
                # Ejecutar sc query para listar servicios
                result = subprocess.run(['sc', 'query', 'state=', 'all'], 
                                      capture_output=True, text=True, check=False)
                
                services = result.stdout
                
                # Buscar servicios Oracle
                oracle_services = re.findall(r'SERVICE_NAME:\s+(\S+Oracle\S+|\S+OracleService\S+)', 
                                          services, re.IGNORECASE)
                
                if oracle_services:
                    self.log(f"Se encontraron {len(oracle_services)} servicios Oracle")
                    for service in oracle_services:
                        self.log(f"Servicio Oracle encontrado: {service}")
                        # Extraer el nombre de la instancia (normalmente OracleServiceXXX donde XXX es la SID)
                        match = re.search(r'OracleService(\w+)', service, re.IGNORECASE)
                        if match:
                            sid = match.group(1)
                            self.log(f"SID extraído: {sid}")
                            # Verificar duplicados
                            if not any(i.get('nombre') == sid for i in self.instances):
                                self.instances.append({
                                    'nombre': sid,
                                    'host': 'localhost',
                                    'puerto': '1521',  # Puerto por defecto
                                    'estado': 'Servicio Windows'
                                })
                else:
                    self.log("No se encontraron servicios Oracle")
        except Exception as e:
            self.log(f"Error al buscar servicios Oracle: {e}")
    
    def buscar_con_lsnrctl(self):
        """Busca instancias Oracle mediante lsnrctl"""
        try:
            # Buscar en rutas conocidas
            lsnrctl_paths = [
                os.path.join(ORACLE_CLIENT_PATH, "lsnrctl"),
                os.path.join(ORACLE_CLIENT_PATH, "lsnrctl.exe"),
                os.environ.get("ORACLE_HOME") and os.path.join(os.environ.get("ORACLE_HOME"), "bin", "lsnrctl"),
                os.environ.get("ORACLE_HOME") and os.path.join(os.environ.get("ORACLE_HOME"), "bin", "lsnrctl.exe")
            ]
            
            lsnrctl_exe = None
            for path in lsnrctl_paths:
                if path and os.path.exists(path):
                    lsnrctl_exe = path
                    self.log(f"Encontrado lsnrctl en: {path}")
                    break
            
            if lsnrctl_exe:
                self.log("Ejecutando lsnrctl status...")
                # Ejecutar lsnrctl status
                result = subprocess.run([lsnrctl_exe, "status"], 
                                      capture_output=True, text=True, check=False)
                
                output = result.stdout or result.stderr
                self.log(f"Resultado de lsnrctl: {output[:200]}... (truncado)")
                
                # Buscar servicios
                services = re.findall(r'Service "(\w+)" has \d+ instance\(s\)', output)
                
                if services:
                    self.log(f"Se encontraron {len(services)} servicios con lsnrctl")
                    for service in services:
                        self.log(f"Servicio encontrado: {service}")
                        # Verificar duplicados
                        if not any(i.get('nombre') == service for i in self.instances):
                            self.instances.append({
                                'nombre': service,
                                'host': 'localhost',
                                'puerto': '1521',  # Puerto por defecto
                                'estado': 'lsnrctl'
                            })
                else:
                    self.log("No se encontraron servicios con lsnrctl")
            else:
                self.log("No se encontró el ejecutable lsnrctl")
        except Exception as e:
            self.log(f"Error al ejecutar lsnrctl: {e}")

    def agregar_manual(self):
        """Abre un diálogo para agregar una instancia manualmente"""
        dialog = ManualInstanceDialog(self.root)
        self.root.wait_window(dialog.dialog)
        
        if dialog.nombre and dialog.host and dialog.puerto:
            # Verificar duplicados
            if not any(i.get('nombre') == dialog.nombre for i in self.instances):
                self.instances.append({
                    'nombre': dialog.nombre,
                    'host': dialog.host,
                    'puerto': dialog.puerto,
                    'estado': 'Manual'
                })
                
                # Actualizar la tabla
                self.tree.insert('', tk.END, values=(
                    dialog.nombre,
                    dialog.host,
                    dialog.puerto,
                    'Manual'
                ))
                
                self.use_btn.config(state=tk.NORMAL)
                self.log(f"Instancia agregada manualmente: {dialog.nombre} en {dialog.host}:{dialog.puerto}")
            else:
                messagebox.showinfo("Información", "Esta instancia ya existe en la lista.")
    
    def usar_instancia_seleccionada(self):
        """Usa la instancia Oracle seleccionada"""
        selection = self.tree.selection()
        if not selection:
            messagebox.showwarning("Advertencia", "Seleccione una instancia para usar")
            return
        
        # Obtener datos de la instancia seleccionada
        item = self.tree.item(selection[0])
        nombre = item['values'][0]
        host = item['values'][1]
        puerto = item['values'][2]
        
        # Solicitar usuario y contraseña
        user_dialog = UserPasswordDialog(self.root, nombre)
        self.root.wait_window(user_dialog.dialog)
        
        if user_dialog.username and user_dialog.password:
            # Cargar configuración actual
            config = cargar_config()
            
            # Actualizar configuración
            config['username'] = user_dialog.username
            config['password'] = user_dialog.password
            config['host'] = host
            config['port'] = str(puerto)
            config['service_name'] = nombre
            
            # Guardar configuración
            if guardar_config(config):
                messagebox.showinfo("Información", 
                                  f"Configuración para la instancia '{nombre}' guardada correctamente.")
                self.root.destroy()
            else:
                messagebox.showerror("Error", "No se pudo guardar la configuración.")

class ManualInstanceDialog:
    def __init__(self, parent):
        self.nombre = None
        self.host = None
        self.puerto = None
        
        # Crear diálogo
        self.dialog = tk.Toplevel(parent)
        self.dialog.title("Agregar instancia Oracle manualmente")
        self.dialog.geometry("400x200")
        self.dialog.resizable(False, False)
        self.dialog.transient(parent)
        self.dialog.grab_set()
        
        # Frame principal
        main_frame = ttk.Frame(self.dialog, padding="20")
        main_frame.pack(fill=tk.BOTH, expand=True)
        
        # Título
        ttk.Label(main_frame, text="Introduzca los datos de la instancia Oracle", 
               wraplength=350).pack(pady=(0, 20))
        
        # Nombre de servicio
        name_frame = ttk.Frame(main_frame)
        name_frame.pack(fill=tk.X, pady=5)
        ttk.Label(name_frame, text="Nombre:", width=12).pack(side=tk.LEFT)
        self.name_entry = ttk.Entry(name_frame, width=25)
        self.name_entry.pack(side=tk.LEFT, padx=5)
        self.name_entry.insert(0, "XE")  # Valor por defecto
        
        # Host
        host_frame = ttk.Frame(main_frame)
        host_frame.pack(fill=tk.X, pady=5)
        ttk.Label(host_frame, text="Host:", width=12).pack(side=tk.LEFT)
        self.host_entry = ttk.Entry(host_frame, width=25)
        self.host_entry.pack(side=tk.LEFT, padx=5)
        self.host_entry.insert(0, "localhost")  # Valor por defecto
        
        # Puerto
        port_frame = ttk.Frame(main_frame)
        port_frame.pack(fill=tk.X, pady=5)
        ttk.Label(port_frame, text="Puerto:", width=12).pack(side=tk.LEFT)
        self.port_entry = ttk.Entry(port_frame, width=25)
        self.port_entry.pack(side=tk.LEFT, padx=5)
        self.port_entry.insert(0, "1521")  # Valor por defecto
        
        # Botones
        btn_frame = ttk.Frame(main_frame)
        btn_frame.pack(fill=tk.X, pady=(20, 0))
        
        ttk.Button(btn_frame, text="Aceptar", command=self.aceptar).pack(side=tk.RIGHT, padx=5)
        ttk.Button(btn_frame, text="Cancelar", command=self.cancelar).pack(side=tk.RIGHT, padx=5)
        
        # Dar foco al campo de nombre
        self.name_entry.focus_set()
        
        # Configurar eventos de teclado
        self.dialog.bind("<Return>", lambda event: self.aceptar())
        self.dialog.bind("<Escape>", lambda event: self.cancelar())
    
    def aceptar(self):
        self.nombre = self.name_entry.get()
        self.host = self.host_entry.get()
        self.puerto = self.port_entry.get()
        
        if not self.nombre or not self.host or not self.puerto:
            messagebox.showwarning("Advertencia", "Todos los campos son obligatorios")
            return
        
        self.dialog.destroy()
    
    def cancelar(self):
        self.nombre = None
        self.host = None
        self.puerto = None
        self.dialog.destroy()

class UserPasswordDialog:
    def __init__(self, parent, database_name):
        self.username = None
        self.password = None
        
        # Crear diálogo
        self.dialog = tk.Toplevel(parent)
        self.dialog.title(f"Credenciales para {database_name}")
        self.dialog.geometry("400x200")
        self.dialog.resizable(False, False)
        self.dialog.transient(parent)
        self.dialog.grab_set()
        
        # Frame principal
        main_frame = ttk.Frame(self.dialog, padding="20")
        main_frame.pack(fill=tk.BOTH, expand=True)
        
        # Título
        ttk.Label(main_frame, text=f"Introduzca las credenciales para {database_name}", 
               wraplength=350).pack(pady=(0, 20))
        
        # Usuario
        user_frame = ttk.Frame(main_frame)
        user_frame.pack(fill=tk.X, pady=5)
        ttk.Label(user_frame, text="Usuario:", width=12).pack(side=tk.LEFT)
        self.user_entry = ttk.Entry(user_frame, width=25)
        self.user_entry.pack(side=tk.LEFT, padx=5)
        self.user_entry.insert(0, "system")  # Usuario por defecto
        
        # Contraseña
        pass_frame = ttk.Frame(main_frame)
        pass_frame.pack(fill=tk.X, pady=5)
        ttk.Label(pass_frame, text="Contraseña:", width=12).pack(side=tk.LEFT)
        self.pass_entry = ttk.Entry(pass_frame, width=25, show="*")
        self.pass_entry.pack(side=tk.LEFT, padx=5)
        
        # Botones
        btn_frame = ttk.Frame(main_frame)
        btn_frame.pack(fill=tk.X, pady=(20, 0))
        
        ttk.Button(btn_frame, text="Aceptar", command=self.aceptar).pack(side=tk.RIGHT, padx=5)
        ttk.Button(btn_frame, text="Cancelar", command=self.cancelar).pack(side=tk.RIGHT, padx=5)
        
        # Dar foco al campo de usuario
        self.user_entry.focus_set()
        
        # Configurar eventos de teclado
        self.dialog.bind("<Return>", lambda event: self.aceptar())
        self.dialog.bind("<Escape>", lambda event: self.cancelar())
    
    def aceptar(self):
        self.username = self.user_entry.get()
        self.password = self.pass_entry.get()
        
        if not self.username or not self.password:
            messagebox.showwarning("Advertencia", "Usuario y contraseña son obligatorios")
            return
        
        self.dialog.destroy()
    
    def cancelar(self):
        self.username = None
        self.password = None
        self.dialog.destroy()

# Si se ejecuta como script principal
if __name__ == "__main__":
    root = tk.Tk()
    app = OracleInstanceFinder(root)
    root.mainloop() 