import os
import sys
import shutil
import platform
import subprocess
import tkinter as tk
from tkinter import ttk, messagebox, filedialog, simpledialog
import zipfile
import winreg
from pathlib import Path

# Ruta del Oracle Client
ORACLE_CLIENT_PATH = r"C:\Oracle\instantclient_19_26"

class OracleVerifier:
    def __init__(self, root):
        self.root = root
        self.resultado = False
        self.setup_ui()
        
    def setup_ui(self):
        self.root.title("Verificación de Oracle Client")
        self.root.geometry("700x500")
        
        # Frame principal
        main_frame = ttk.Frame(self.root, padding="20")
        main_frame.pack(fill=tk.BOTH, expand=True)
        
        # Título
        title_label = ttk.Label(main_frame, text="Verificación de Oracle Instant Client", font=("Arial", 16, "bold"))
        title_label.pack(pady=(0, 20))
        
        # Marco de información
        info_frame = ttk.LabelFrame(main_frame, text="Información del sistema")
        info_frame.pack(fill=tk.X, pady=10)
        
        # Texto de información
        self.info_text = tk.Text(info_frame, height=15, wrap=tk.WORD)
        self.info_text.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        self.info_text.config(state=tk.NORMAL)
        
        # Añadir una barra de desplazamiento
        scrollbar = ttk.Scrollbar(self.info_text, orient="vertical", command=self.info_text.yview)
        scrollbar.pack(side=tk.RIGHT, fill=tk.Y)
        self.info_text.configure(yscrollcommand=scrollbar.set)
        
        # Botones
        btn_frame = ttk.Frame(main_frame)
        btn_frame.pack(fill=tk.X, pady=15)
        
        self.verificar_btn = ttk.Button(btn_frame, text="Verificar instalación", command=self.verificar_instalacion)
        self.verificar_btn.pack(side=tk.LEFT, padx=5)
        
        self.reparar_btn = ttk.Button(btn_frame, text="Reparar instalación", command=self.reparar_instalacion)
        self.reparar_btn.pack(side=tk.LEFT, padx=5)
        
        self.config_path_btn = ttk.Button(btn_frame, text="Configurar PATH", command=self.configurar_path)
        self.config_path_btn.pack(side=tk.LEFT, padx=5)
        
        self.seleccionar_client_btn = ttk.Button(btn_frame, text="Seleccionar otra carpeta de Client", command=self.seleccionar_otra_carpeta)
        self.seleccionar_client_btn.pack(side=tk.LEFT, padx=5)
        
        self.cerrar_btn = ttk.Button(btn_frame, text="Cerrar", command=self.cerrar)
        self.cerrar_btn.pack(side=tk.RIGHT, padx=5)
        
        # Información inicial
        self.agregar_texto("Herramienta de verificación de Oracle Instant Client\n")
        self.agregar_texto(f"Ruta configurada: {ORACLE_CLIENT_PATH}\n")
        self.agregar_texto(f"Sistema operativo: {platform.system()} {platform.version()}\n")
        self.agregar_texto(f"Python: {sys.version}\n")
        self.agregar_texto("\nHaga clic en 'Verificar instalación' para comenzar.\n")
        
    def agregar_texto(self, texto):
        """Agrega texto al widget de información"""
        self.info_text.config(state=tk.NORMAL)
        self.info_text.insert(tk.END, texto)
        self.info_text.see(tk.END)
        self.info_text.config(state=tk.DISABLED)
        self.root.update_idletasks()
        
    def limpiar_texto(self):
        """Limpia el widget de información"""
        self.info_text.config(state=tk.NORMAL)
        self.info_text.delete(1.0, tk.END)
        self.info_text.config(state=tk.DISABLED)
        
    def verificar_instalacion(self):
        """Verifica la instalación de Oracle Client"""
        self.limpiar_texto()
        self.agregar_texto("Iniciando verificación de Oracle Instant Client...\n\n")
        
        # Verificar si la carpeta existe
        if not os.path.exists(ORACLE_CLIENT_PATH):
            self.agregar_texto(f"❌ ERROR: La carpeta {ORACLE_CLIENT_PATH} no existe.\n")
            return False
        else:
            self.agregar_texto(f"✅ La carpeta {ORACLE_CLIENT_PATH} existe.\n")
        
        # Verificar archivos esenciales
        archivos_esenciales = [
            "oci.dll",
            "oraocci19.dll",
            "oraociei19.dll",
            "oraons.dll"
        ]
        
        archivos_faltantes = []
        for archivo in archivos_esenciales:
            ruta_completa = os.path.join(ORACLE_CLIENT_PATH, archivo)
            if os.path.exists(ruta_completa):
                self.agregar_texto(f"✅ {archivo} encontrado.\n")
            else:
                self.agregar_texto(f"❌ ERROR: {archivo} no encontrado.\n")
                archivos_faltantes.append(archivo)
        
        if archivos_faltantes:
            self.agregar_texto("\n⚠️ Faltan archivos esenciales. La instalación no es completa.\n")
        else:
            self.agregar_texto("\n✅ Todos los archivos esenciales están presentes.\n")
        
        # Verificar PATH
        try:
            path_usuario = self.obtener_path_usuario()
            if ORACLE_CLIENT_PATH in path_usuario:
                self.agregar_texto(f"✅ La carpeta {ORACLE_CLIENT_PATH} está en el PATH del usuario.\n")
            else:
                self.agregar_texto(f"❌ ERROR: La carpeta {ORACLE_CLIENT_PATH} no está en el PATH del usuario.\n")
                
            path_sistema = self.obtener_path_sistema()
            if ORACLE_CLIENT_PATH in path_sistema:
                self.agregar_texto(f"✅ La carpeta {ORACLE_CLIENT_PATH} está en el PATH del sistema.\n")
            else:
                self.agregar_texto(f"ℹ️ La carpeta {ORACLE_CLIENT_PATH} no está en el PATH del sistema (no es crítico si está en PATH de usuario).\n")
        except Exception as e:
            self.agregar_texto(f"❌ ERROR al verificar PATH: {str(e)}\n")
        
        # Verificar si podemos cargar el cliente
        try:
            # Intentar importar oracledb y inicializar el cliente
            import oracledb
            
            try:
                oracledb.init_oracle_client(lib_dir=ORACLE_CLIENT_PATH)
                self.agregar_texto("\n✅ Éxito al inicializar el cliente Oracle.\n")
                cliente_version = oracledb.clientversion()
                self.agregar_texto(f"✅ Versión del cliente Oracle: {'.'.join(map(str, cliente_version))}\n")
                self.resultado = True
            except Exception as e:
                self.agregar_texto(f"\n❌ ERROR al inicializar el cliente Oracle: {str(e)}\n")
                self.resultado = False
        except ImportError:
            self.agregar_texto("\n❌ ERROR: No se pudo importar el módulo oracledb. Ejecute 'pip install oracledb'.\n")
            self.resultado = False
        
        # Resultado final
        if self.resultado:
            self.agregar_texto("\n✅ VERIFICACIÓN EXITOSA: Oracle Client está correctamente instalado y configurado.\n")
        else:
            self.agregar_texto("\n❌ VERIFICACIÓN FALLIDA: Oracle Client no está correctamente instalado o configurado.\n")
            self.agregar_texto("   Utilice la opción 'Reparar instalación' para intentar solucionar los problemas.\n")
        
        return self.resultado
    
    def obtener_path_usuario(self):
        """Obtiene el PATH del usuario como una lista"""
        key = winreg.OpenKey(winreg.HKEY_CURRENT_USER, "Environment")
        try:
            value, _ = winreg.QueryValueEx(key, "PATH")
            return value.split(";")
        except:
            return []
        finally:
            winreg.CloseKey(key)
    
    def obtener_path_sistema(self):
        """Obtiene el PATH del sistema como una lista"""
        key = winreg.OpenKey(winreg.HKEY_LOCAL_MACHINE, "SYSTEM\\CurrentControlSet\\Control\\Session Manager\\Environment")
        try:
            value, _ = winreg.QueryValueEx(key, "PATH")
            return value.split(";")
        except:
            return []
        finally:
            winreg.CloseKey(key)
    
    def reparar_instalacion(self):
        """Intenta reparar problemas comunes de la instalación"""
        self.agregar_texto("\n\nIniciando reparación de la instalación...\n")
        
        # Verificar si la carpeta existe, crearla si no
        if not os.path.exists(ORACLE_CLIENT_PATH):
            try:
                os.makedirs(ORACLE_CLIENT_PATH, exist_ok=True)
                self.agregar_texto(f"✅ Se creó la carpeta {ORACLE_CLIENT_PATH}.\n")
            except Exception as e:
                self.agregar_texto(f"❌ ERROR al crear la carpeta: {str(e)}\n")
                return False
        
        # Pedir al usuario que seleccione el ZIP de Oracle Instant Client
        self.agregar_texto("Seleccione el archivo ZIP de Oracle Instant Client Basic...\n")
        basic_zip = filedialog.askopenfilename(
            title="Seleccione instantclient-basic-*.zip",
            filetypes=[("ZIP files", "*.zip")]
        )
        
        if not basic_zip:
            self.agregar_texto("❌ Cancelado: No se seleccionó el archivo ZIP.\n")
            return False
        
        # Extraer archivos
        try:
            # Limpiar carpeta destino
            for item in os.listdir(ORACLE_CLIENT_PATH):
                item_path = os.path.join(ORACLE_CLIENT_PATH, item)
                if os.path.isfile(item_path):
                    os.remove(item_path)
                elif os.path.isdir(item_path):
                    shutil.rmtree(item_path)
            
            self.agregar_texto("Extrayendo archivos...\n")
            with zipfile.ZipFile(basic_zip, 'r') as zip_ref:
                # La mayoría de los ZIPs de Oracle tienen una carpeta raíz instantclient_XX_YY
                names = zip_ref.namelist()
                # Buscar el prefijo común
                if all('/' in name for name in names if name != names[0]):
                    common_prefix = names[0].split('/')[0] + '/'
                    self.agregar_texto(f"Extrayendo desde carpeta raíz: {common_prefix}\n")
                    
                    # Extraer a una carpeta temporal
                    temp_dir = os.path.join(os.path.dirname(ORACLE_CLIENT_PATH), "temp_extract")
                    os.makedirs(temp_dir, exist_ok=True)
                    zip_ref.extractall(temp_dir)
                    
                    # Copiar archivos desde la subcarpeta
                    source_dir = os.path.join(temp_dir, common_prefix.rstrip('/'))
                    if os.path.exists(source_dir):
                        for item in os.listdir(source_dir):
                            s = os.path.join(source_dir, item)
                            d = os.path.join(ORACLE_CLIENT_PATH, item)
                            if os.path.isfile(s):
                                shutil.copy2(s, d)
                            else:
                                shutil.copytree(s, d)
                        shutil.rmtree(temp_dir)
                    else:
                        zip_ref.extractall(ORACLE_CLIENT_PATH)
                else:
                    zip_ref.extractall(ORACLE_CLIENT_PATH)
            
            self.agregar_texto("✅ Archivos extraídos correctamente.\n")
            
            # Configurar PATH
            self.configurar_path()
            
            # Verificar la instalación nuevamente
            self.agregar_texto("\nVerificando la instalación después de la reparación...\n")
            return self.verificar_instalacion()
            
        except Exception as e:
            self.agregar_texto(f"❌ ERROR durante la extracción: {str(e)}\n")
            return False
    
    def configurar_path(self):
        """Configura el PATH del usuario para incluir la carpeta de Oracle Client"""
        try:
            # Obtener PATH actual
            key = winreg.OpenKey(winreg.HKEY_CURRENT_USER, "Environment", 0, winreg.KEY_ALL_ACCESS)
            try:
                path_value, _ = winreg.QueryValueEx(key, "PATH")
            except:
                path_value = ""
            
            # Separar el PATH en componentes
            paths = path_value.split(";")
            paths = [p for p in paths if p and p.strip()]  # Eliminar entradas vacías
            
            # Verificar si la carpeta ya está en el PATH
            if ORACLE_CLIENT_PATH not in paths:
                paths.append(ORACLE_CLIENT_PATH)
                new_path = ";".join(paths)
                
                # Guardar el PATH actualizado
                winreg.SetValueEx(key, "PATH", 0, winreg.REG_EXPAND_SZ, new_path)
                winreg.CloseKey(key)
                
                # Notificar al sistema sobre el cambio
                subprocess.run(["setx", "PATH", new_path], capture_output=True)
                
                self.agregar_texto(f"✅ Se agregó {ORACLE_CLIENT_PATH} al PATH del usuario.\n")
                self.agregar_texto("ℹ️ Es recomendable reiniciar el sistema para que los cambios surtan efecto.\n")
            else:
                self.agregar_texto(f"ℹ️ {ORACLE_CLIENT_PATH} ya está en el PATH del usuario.\n")
                winreg.CloseKey(key)
            
            return True
        except Exception as e:
            self.agregar_texto(f"❌ ERROR al configurar PATH: {str(e)}\n")
            return False
    
    def seleccionar_otra_carpeta(self):
        """Permite al usuario seleccionar otra carpeta de Oracle Client"""
        carpeta = filedialog.askdirectory(title="Seleccione la carpeta de Oracle Instant Client")
        if carpeta:
            global ORACLE_CLIENT_PATH
            ORACLE_CLIENT_PATH = carpeta
            self.agregar_texto(f"\nSe ha seleccionado una nueva carpeta: {ORACLE_CLIENT_PATH}\n")
            
            # Verificar la nueva carpeta
            self.verificar_instalacion()
    
    def cerrar(self):
        """Cierra la ventana y retorna el resultado"""
        self.root.destroy()

# Si se ejecuta como script principal
if __name__ == "__main__":
    root = tk.Tk()
    app = OracleVerifier(root)
    root.mainloop() 