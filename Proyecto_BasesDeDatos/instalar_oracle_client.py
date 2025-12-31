import os
import sys
import platform
import subprocess
import tkinter as tk
from tkinter import ttk, messagebox, filedialog
from urllib.request import urlretrieve
import zipfile
import shutil
import winreg

class OracleClientInstaller:
    def __init__(self, root):
        self.root = root
        self.download_path = os.path.join(os.path.expanduser("~"), "Downloads")
        self.install_path = os.path.join(os.path.expanduser("~"), "Oracle", "instantclient")
        self.setup_ui()
        
    def setup_ui(self):
        self.root.title("Instalador de Oracle Instant Client")
        self.root.geometry("600x500")
        self.root.resizable(False, False)
        
        # Frame principal
        main_frame = ttk.Frame(self.root, padding="20")
        main_frame.pack(fill=tk.BOTH, expand=True)
        
        # Título
        title_label = ttk.Label(main_frame, text="Instalador de Oracle Instant Client", font=("Arial", 16, "bold"))
        title_label.pack(pady=(0, 20))
        
        # Instrucciones
        instructions = (
            "Este asistente le ayudará a instalar Oracle Instant Client, "
            "necesario para conectarse a Oracle 11g con python-oracledb.\n\n"
            "Proceso de instalación:\n"
            "1. Descarga de archivos necesarios\n"
            "2. Extracción de archivos\n"
            "3. Configuración de variables de entorno\n"
        )
        
        ttk.Label(main_frame, text=instructions, wraplength=550, justify="left").pack(pady=(0, 20))
        
        # Formulario de configuración
        form_frame = ttk.LabelFrame(main_frame, text="Configuración de la instalación")
        form_frame.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        # Ruta de descarga
        download_frame = ttk.Frame(form_frame)
        download_frame.pack(fill=tk.X, pady=5)
        
        ttk.Label(download_frame, text="Carpeta de descarga:", width=20).pack(side=tk.LEFT)
        self.download_entry = ttk.Entry(download_frame, width=40)
        self.download_entry.pack(side=tk.LEFT, padx=5, fill=tk.X, expand=True)
        self.download_entry.insert(0, self.download_path)
        
        browse_dl_btn = ttk.Button(download_frame, text="...", width=3, command=self.browse_download_path)
        browse_dl_btn.pack(side=tk.RIGHT)
        
        # Ruta de instalación
        install_frame = ttk.Frame(form_frame)
        install_frame.pack(fill=tk.X, pady=5)
        
        ttk.Label(install_frame, text="Carpeta de instalación:", width=20).pack(side=tk.LEFT)
        self.install_entry = ttk.Entry(install_frame, width=40)
        self.install_entry.pack(side=tk.LEFT, padx=5, fill=tk.X, expand=True)
        self.install_entry.insert(0, self.install_path)
        
        browse_inst_btn = ttk.Button(install_frame, text="...", width=3, command=self.browse_install_path)
        browse_inst_btn.pack(side=tk.RIGHT)
        
        # Progreso
        progress_frame = ttk.Frame(main_frame)
        progress_frame.pack(fill=tk.X, pady=10)
        
        self.progress = ttk.Progressbar(progress_frame, orient='horizontal', length=560, mode='determinate')
        self.progress.pack(pady=5)
        
        self.status_var = tk.StringVar()
        self.status_var.set("Listo para iniciar")
        status_label = ttk.Label(progress_frame, textvariable=self.status_var)
        status_label.pack(pady=5)
        
        # Botones de acción
        btn_frame = ttk.Frame(main_frame)
        btn_frame.pack(fill=tk.X, pady=(15, 0))
        
        self.install_btn = ttk.Button(btn_frame, text="Instalar", command=self.install)
        self.install_btn.pack(side=tk.RIGHT)
        
        self.cancel_btn = ttk.Button(btn_frame, text="Cancelar", command=self.root.destroy)
        self.cancel_btn.pack(side=tk.RIGHT, padx=10)
        
    def browse_download_path(self):
        path = filedialog.askdirectory()
        if path:
            self.download_path = path
            self.download_entry.delete(0, tk.END)
            self.download_entry.insert(0, path)
            
    def browse_install_path(self):
        path = filedialog.askdirectory()
        if path:
            self.install_path = path
            self.install_entry.delete(0, tk.END)
            self.install_entry.insert(0, path)
            
    def install(self):
        self.download_path = self.download_entry.get()
        self.install_path = self.install_entry.get()
        
        # Validar rutas
        if not os.path.isdir(self.download_path):
            messagebox.showerror("Error", "La carpeta de descarga no existe")
            return
            
        # Crear carpeta de instalación si no existe
        os.makedirs(self.install_path, exist_ok=True)
        
        # Deshabilitar botones durante la instalación
        self.install_btn.config(state="disabled")
        self.cancel_btn.config(state="disabled")
        
        # Iniciar instalación
        self.progress["value"] = 0
        self.status_var.set("Iniciando instalación...")
        self.root.update()
        
        try:
            # Descargar archivos
            self.progress["value"] = 10
            self.status_var.set("Descargando Oracle Instant Client Basic...")
            self.root.update()
            
            basic_url = "https://download.oracle.com/otn_software/nt/instantclient/219000/instantclient-basic-windows.x64-21.9.0.0.0dbru.zip"
            sdk_url = "https://download.oracle.com/otn_software/nt/instantclient/219000/instantclient-sdk-windows.x64-21.9.0.0.0dbru.zip"
            
            basic_zip = os.path.join(self.download_path, "instantclient-basic.zip")
            sdk_zip = os.path.join(self.download_path, "instantclient-sdk.zip")
            
            # Simular descarga (los enlaces directos de Oracle requieren login)
            self.status_var.set("Oracle requiere login para descargas directas. Por favor, descargue manualmente desde:\n" +
                               "https://www.oracle.com/database/technologies/instant-client/winx64-64-downloads.html")
            self.progress["value"] = 30
            self.root.update()
            
            # Preguntar si el usuario ya descargó los archivos
            if not messagebox.askyesno("Confirmar", 
                                      "¿Ya ha descargado los archivos 'instantclient-basic' y 'instantclient-sdk'?\n" +
                                      "Si es así, se le pedirá seleccionar los archivos ZIP."):
                messagebox.showinfo("Instalación cancelada", 
                                   "Por favor descargue los archivos y ejecute el instalador nuevamente.")
                self.install_btn.config(state="normal")
                self.cancel_btn.config(state="normal")
                return
            
            # Seleccionar archivos ZIP
            self.status_var.set("Seleccione el archivo 'instantclient-basic-*.zip'")
            self.root.update()
            basic_zip = filedialog.askopenfilename(
                title="Seleccione instantclient-basic-*.zip",
                filetypes=[("ZIP files", "*.zip")]
            )
            
            if not basic_zip:
                messagebox.showinfo("Instalación cancelada", "No se seleccionó el archivo basic.")
                self.install_btn.config(state="normal")
                self.cancel_btn.config(state="normal")
                return
                
            self.status_var.set("Seleccione el archivo 'instantclient-sdk-*.zip'")
            self.root.update()
            sdk_zip = filedialog.askopenfilename(
                title="Seleccione instantclient-sdk-*.zip",
                filetypes=[("ZIP files", "*.zip")]
            )
            
            if not sdk_zip:
                messagebox.showinfo("Instalación cancelada", "No se seleccionó el archivo SDK.")
                self.install_btn.config(state="normal")
                self.cancel_btn.config(state="normal")
                return
            
            # Extraer archivos
            self.progress["value"] = 50
            self.status_var.set("Extrayendo archivos...")
            self.root.update()
            
            # Limpiar carpeta de instalación si ya existe
            if os.path.exists(self.install_path):
                for item in os.listdir(self.install_path):
                    full_path = os.path.join(self.install_path, item)
                    if os.path.isdir(full_path):
                        shutil.rmtree(full_path)
                    else:
                        os.remove(full_path)
            
            # Extraer basic
            with zipfile.ZipFile(basic_zip, 'r') as zip_ref:
                zip_ref.extractall(self.download_path)
                
            # Encontrar carpeta extraída
            instantclient_dir = None
            for item in os.listdir(self.download_path):
                if item.startswith("instantclient"):
                    instantclient_dir = os.path.join(self.download_path, item)
                    break
            
            if not instantclient_dir:
                raise Exception("No se pudo encontrar la carpeta instantclient después de la extracción")
                
            # Copiar archivos a la carpeta de instalación
            self.progress["value"] = 70
            self.status_var.set("Copiando archivos...")
            self.root.update()
            
            for item in os.listdir(instantclient_dir):
                src_path = os.path.join(instantclient_dir, item)
                dst_path = os.path.join(self.install_path, item)
                if os.path.isdir(src_path):
                    shutil.copytree(src_path, dst_path)
                else:
                    shutil.copy2(src_path, dst_path)
            
            # Extraer SDK
            with zipfile.ZipFile(sdk_zip, 'r') as zip_ref:
                zip_ref.extractall(self.download_path)
                
            # Encontrar carpeta SDK extraída
            sdk_dir = None
            for item in os.listdir(self.download_path):
                if item.startswith("instantclient") and "sdk" in item.lower():
                    sdk_dir = os.path.join(self.download_path, item)
                    break
            
            if sdk_dir:
                # Copiar archivos SDK
                for item in os.listdir(sdk_dir):
                    src_path = os.path.join(sdk_dir, item)
                    dst_path = os.path.join(self.install_path, item)
                    if os.path.isdir(src_path):
                        if os.path.exists(dst_path):
                            # Si ya existe, combinar contenidos
                            for subitem in os.listdir(src_path):
                                src_subpath = os.path.join(src_path, subitem)
                                dst_subpath = os.path.join(dst_path, subitem)
                                if os.path.isdir(src_subpath):
                                    if os.path.exists(dst_subpath):
                                        shutil.rmtree(dst_subpath)
                                    shutil.copytree(src_subpath, dst_subpath)
                                else:
                                    shutil.copy2(src_subpath, dst_subpath)
                        else:
                            shutil.copytree(src_path, dst_path)
                    else:
                        shutil.copy2(src_path, dst_path)
            
            # Configurar variables de entorno
            self.progress["value"] = 90
            self.status_var.set("Configurando variables de entorno...")
            self.root.update()
            
            # Agregar a PATH
            try:
                # Abrir la clave del registro para PATH de usuario
                key = winreg.OpenKey(winreg.HKEY_CURRENT_USER, "Environment", 0, winreg.KEY_ALL_ACCESS)
                
                # Obtener el valor actual de PATH
                try:
                    path_value, _ = winreg.QueryValueEx(key, "PATH")
                except:
                    path_value = ""
                
                # Verificar si la ruta ya está en PATH
                paths = path_value.split(";")
                if self.install_path not in paths:
                    # Agregar la nueva ruta
                    if path_value and not path_value.endswith(";"):
                        path_value += ";"
                    path_value += self.install_path
                    
                    # Guardar el nuevo valor
                    winreg.SetValueEx(key, "PATH", 0, winreg.REG_EXPAND_SZ, path_value)
                
                winreg.CloseKey(key)
                
                # Notificar al sistema sobre el cambio
                subprocess.run(["setx", "PATH", path_value], capture_output=True)
            except Exception as e:
                messagebox.showwarning("Advertencia", 
                                      f"No se pudo actualizar automáticamente la variable PATH: {str(e)}\n"
                                      f"Por favor, agregue manualmente '{self.install_path}' a su variable PATH.")
            
            # Instalación completada
            self.progress["value"] = 100
            self.status_var.set("Instalación completada con éxito.")
            
            messagebox.showinfo("Instalación completa", 
                              f"Oracle Instant Client se ha instalado correctamente en:\n{self.install_path}\n\n"
                              "Es necesario reiniciar su sistema para que los cambios surtan efecto.")
            
        except Exception as e:
            messagebox.showerror("Error", f"Error durante la instalación: {str(e)}")
            self.status_var.set("Error en la instalación.")
        finally:
            # Restablecer botones
            self.install_btn.config(state="normal")
            self.cancel_btn.config(state="normal")

# Si se ejecuta directamente este archivo
if __name__ == "__main__":
    root = tk.Tk()
    app = OracleClientInstaller(root)
    root.mainloop() 