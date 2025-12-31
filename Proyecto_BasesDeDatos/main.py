import tkinter as tk
from tkinter import messagebox
from gui import MainApplication
from database import DatabaseConnection

def main():
    try:
        # Intentar establecer conexión con la base de datos
        db = DatabaseConnection()
        connection = db.connect()
        
        if connection:
            # Crear y ejecutar la aplicación
            root = tk.Tk()
            app = MainApplication(root, connection)
            root.mainloop()
            
            # Cerrar la conexión al cerrar la aplicación
            db.close()
        else:
            messagebox.showerror("Error de Conexión", "No se pudo establecer la conexión con la base de datos.")
    except Exception as e:
        messagebox.showerror("Error", f"Ha ocurrido un error: {str(e)}")

if __name__ == "__main__":
    main() 