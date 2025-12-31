import tkinter as tk
from tkinter import ttk, messagebox, simpledialog
import oracledb
from datetime import datetime

class MainApplication:
    def __init__(self, root, connection):
        self.root = root
        self.connection = connection
        self.current_table = None
        
        # Inicializar status_var antes de cualquier método que pueda usarlo
        self.status_var = tk.StringVar()
        self.status_var.set("Listo")
        
        # Configurar la interfaz
        self.setup_ui()
        
    def setup_ui(self):
        """Configura la interfaz de usuario principal"""
        self.root.title("Gastrobar")
        self.root.geometry("1200x700")
        
        # Frame principal dividido en dos paneles
        main_frame = ttk.Frame(self.root)
        main_frame.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        # Panel izquierdo para la lista de tablas
        left_panel = ttk.LabelFrame(main_frame, text="Tablas de la Base de Datos")
        left_panel.pack(side=tk.LEFT, fill=tk.Y, padx=5, pady=5)
        
        # Crear treeview para mostrar las tablas
        self.tables_tree = ttk.Treeview(left_panel, columns=('table'), show='headings', height=30)
        self.tables_tree.heading('table', text='Nombre de la Tabla')
        self.tables_tree.column('table', width=200)
        self.tables_tree.pack(fill=tk.BOTH, expand=True, padx=5, pady=5)
        self.tables_tree.bind('<ButtonRelease-1>', self.on_table_select)
        
        # Cargar las tablas en el treeview
        self.load_tables()
        
        # Panel derecho para mostrar y editar registros
        self.right_panel = ttk.LabelFrame(main_frame, text="Datos de la Tabla")
        self.right_panel.pack(side=tk.RIGHT, fill=tk.BOTH, expand=True, padx=5, pady=5)
        
        # Frame para botones de acciones
        self.actions_frame = ttk.Frame(self.right_panel)
        self.actions_frame.pack(fill=tk.X, padx=5, pady=5)
        
        # Botones de acciones
        self.btn_refresh = ttk.Button(self.actions_frame, text="Actualizar", command=self.refresh_data)
        self.btn_refresh.pack(side=tk.LEFT, padx=2)
        
        self.btn_add = ttk.Button(self.actions_frame, text="Agregar", command=self.add_record)
        self.btn_add.pack(side=tk.LEFT, padx=2)
        
        self.btn_edit = ttk.Button(self.actions_frame, text="Editar", command=self.edit_record)
        self.btn_edit.pack(side=tk.LEFT, padx=2)
        
        self.btn_delete = ttk.Button(self.actions_frame, text="Eliminar", command=self.delete_record)
        self.btn_delete.pack(side=tk.LEFT, padx=2)
        
        # Frame para búsqueda
        self.search_frame = ttk.Frame(self.right_panel)
        self.search_frame.pack(fill=tk.X, padx=5, pady=5)
        
        ttk.Label(self.search_frame, text="Buscar:").pack(side=tk.LEFT, padx=2)
        self.search_entry = ttk.Entry(self.search_frame, width=30)
        self.search_entry.pack(side=tk.LEFT, padx=2)
        self.search_column = ttk.Combobox(self.search_frame, width=15)
        self.search_column.pack(side=tk.LEFT, padx=2)
        ttk.Button(self.search_frame, text="Buscar", command=self.search_records).pack(side=tk.LEFT, padx=2)
        ttk.Button(self.search_frame, text="Limpiar", command=self.clear_search).pack(side=tk.LEFT, padx=2)
        
        # Crear treeview para mostrar los datos de la tabla
        self.data_tree_frame = ttk.Frame(self.right_panel)
        self.data_tree_frame.pack(fill=tk.BOTH, expand=True, padx=5, pady=5)
        
        # Scrollbar para el treeview
        scrollbar_y = ttk.Scrollbar(self.data_tree_frame)
        scrollbar_y.pack(side=tk.RIGHT, fill=tk.Y)
        
        scrollbar_x = ttk.Scrollbar(self.data_tree_frame, orient=tk.HORIZONTAL)
        scrollbar_x.pack(side=tk.BOTTOM, fill=tk.X)
        
        # Treeview para mostrar los datos
        self.data_tree = ttk.Treeview(self.data_tree_frame, yscrollcommand=scrollbar_y.set, xscrollcommand=scrollbar_x.set)
        scrollbar_y.config(command=self.data_tree.yview)
        scrollbar_x.config(command=self.data_tree.xview)
        self.data_tree.pack(fill=tk.BOTH, expand=True)
        
        # Barra de estado - Ya no creamos status_var aquí, solo el widget
        self.status_bar = ttk.Label(self.root, textvariable=self.status_var, relief=tk.SUNKEN, anchor=tk.W)
        self.status_bar.pack(side=tk.BOTTOM, fill=tk.X)
    
    def load_tables(self):
        """Carga las tablas del esquema del restaurante en el treeview"""
        try:
            # Lista de tablas definidas en 01_crear_esquema.sql
            restaurant_tables = [
                "CLIENTE", 
                "TURNO", 
                "EMPLEADO", 
                "EVALUACION", 
                "RECETA", 
                "INGREDIENTES_RECETA", 
                "PRODUCTO", 
                "PROVEEDOR", 
                "VENTA", 
                "DETALLE_VENTA", 
                "ENCUESTA_SATISFACCION", 
                "RESERVA", 
                "COMPRA", 
                "DETALLE_COMPRA", 
                "DOCUMENTO_LEGAL", 
                "NOMINA", 
                "ESTABLECIMIENTO_LOCAL", 
                "EVENTO", 
                "CAMPANIA_MARKETING", 
                "PUBLICIDAD_SOCIAL"
            ]
            
            cursor = self.connection.cursor()
            # Consultar solo las tablas que existen en la base de datos
            cursor.execute("SELECT table_name FROM user_tables ORDER BY table_name")
            all_tables = cursor.fetchall()
            cursor.close()
            
            # Limpiar treeview
            for row in self.tables_tree.get_children():
                self.tables_tree.delete(row)
            
            # Filtrar y agregar solo las tablas del restaurante que existen
            existing_tables = []
            
            for table in all_tables:
                table_name = table[0]
                if table_name in restaurant_tables:
                    existing_tables.append(table_name)
                    self.tables_tree.insert('', tk.END, values=(table_name,))
            
            # Actualizar estado
            if existing_tables:
                self.status_var.set(f"Se encontraron {len(existing_tables)} tablas del esquema del restaurante")
            else:
                self.status_var.set("No se encontraron tablas del esquema del restaurante")
                messagebox.showwarning(
                    "Tablas no encontradas", 
                    "No se encontraron las tablas del restaurante.\n"
                    "Es posible que el script 01_crear_esquema.sql no haya sido ejecutado."
                )
            
        except oracledb.Error as e:
            error, = e.args
            messagebox.showerror("Error", f"Oracle Error: {error.message}")
        except Exception as e:
            messagebox.showerror("Error", f"Error inesperado: {str(e)}")
    
    def on_table_select(self, event):
        """Maneja la selección de una tabla del treeview"""
        selection = self.tables_tree.selection()
        if selection:
            item = self.tables_tree.item(selection[0])
            self.current_table = item['values'][0]
            self.status_var.set(f"Tabla seleccionada: {self.current_table}")
            self.load_table_data()
    
    def load_table_data(self):
        """Carga los datos de la tabla seleccionada"""
        if not self.current_table:
            return
        
        try:
            # Obtener columnas de la tabla
            cursor = self.connection.cursor()
            cursor.execute(f"SELECT column_name, data_type FROM user_tab_columns WHERE table_name = '{self.current_table}'")
            columns_info = cursor.fetchall()
            
            # Configurar el treeview con las columnas
            self.data_tree['columns'] = tuple(col[0] for col in columns_info)
            self.data_tree['show'] = 'headings'
            
            for col in columns_info:
                self.data_tree.heading(col[0], text=col[0])
                self.data_tree.column(col[0], width=100)
            
            # Actualizar combobox de búsqueda
            self.search_column['values'] = tuple(col[0] for col in columns_info)
            if self.search_column['values']:
                self.search_column.current(0)
            
            # Obtener datos de la tabla
            cursor.execute(f"SELECT * FROM {self.current_table}")
            rows = cursor.fetchall()
            
            # Limpiar treeview
            for row in self.data_tree.get_children():
                self.data_tree.delete(row)
            
            # Insertar datos en el treeview
            for row in rows:
                formatted_row = []
                for i, value in enumerate(row):
                    # Formatear fechas y otros tipos de datos si es necesario
                    if isinstance(value, datetime):
                        formatted_row.append(value.strftime('%Y-%m-%d %H:%M:%S'))
                    elif value is None:
                        formatted_row.append('')
                    else:
                        formatted_row.append(str(value))
                self.data_tree.insert('', tk.END, values=formatted_row)
            
            cursor.close()
        except oracledb.Error as e:
            error, = e.args
            messagebox.showerror("Error", f"Oracle Error: {error.message}")
        except Exception as e:
            messagebox.showerror("Error", f"Error inesperado: {str(e)}")
    
    def refresh_data(self):
        """Refresca los datos de la tabla actual"""
        self.load_table_data()
        self.status_var.set(f"Datos actualizados: {self.current_table}")
    
    def add_record(self):
        """Agrega un nuevo registro a la tabla actual"""
        if not self.current_table:
            messagebox.showwarning("Advertencia", "Primero seleccione una tabla.")
            return
        
        try:
            # Obtener información de columnas
            cursor = self.connection.cursor()
            cursor.execute(f"SELECT column_name, data_type FROM user_tab_columns WHERE table_name = '{self.current_table}' ORDER BY column_id")
            columns_info = cursor.fetchall()
            cursor.close()
            
            # Crear ventana de diálogo para ingresar datos
            add_dialog = RecordDialog(self.root, self.connection, self.current_table, columns_info)
            self.root.wait_window(add_dialog)
            
            # Refrescar datos si se agregó el registro
            if add_dialog.success:
                self.refresh_data()
        except oracledb.Error as e:
            error, = e.args
            messagebox.showerror("Error", f"Oracle Error: {error.message}")
        except Exception as e:
            messagebox.showerror("Error", f"Error inesperado: {str(e)}")
    
    def edit_record(self):
        """Edita un registro de la tabla actual"""
        if not self.current_table:
            messagebox.showwarning("Advertencia", "Primero seleccione una tabla.")
            return
        
        selection = self.data_tree.selection()
        if not selection:
            messagebox.showwarning("Advertencia", "Seleccione un registro para editar.")
            return
        
        try:
            # Obtener información de columnas
            cursor = self.connection.cursor()
            cursor.execute(f"SELECT column_name, data_type FROM user_tab_columns WHERE table_name = '{self.current_table}' ORDER BY column_id")
            columns_info = cursor.fetchall()
            
            # Obtener datos del registro seleccionado
            item = self.data_tree.item(selection[0])
            values = item['values']
            
            # Identificar la clave primaria
            cursor.execute(f"""
                SELECT cols.column_name
                FROM all_constraints cons, all_cons_columns cols
                WHERE cons.constraint_type = 'P'
                AND cons.constraint_name = cols.constraint_name
                AND cons.owner = cols.owner
                AND cols.table_name = '{self.current_table}'
            """)
            pk_columns = [row[0] for row in cursor.fetchall()]
            cursor.close()
            
            if not pk_columns:
                messagebox.showwarning("Advertencia", "No se pudo determinar la clave primaria de esta tabla.")
                return
            
            # Crear ventana de diálogo para editar datos
            pk_values = {}
            for i, col in enumerate(self.data_tree['columns']):
                if col in pk_columns:
                    pk_values[col] = values[i]
            
            edit_dialog = RecordDialog(self.root, self.connection, self.current_table, columns_info, values, pk_values)
            self.root.wait_window(edit_dialog)
            
            # Refrescar datos si se editó el registro
            if edit_dialog.success:
                self.refresh_data()
        except oracledb.Error as e:
            error, = e.args
            messagebox.showerror("Error", f"Oracle Error: {error.message}")
        except Exception as e:
            messagebox.showerror("Error", f"Error inesperado: {str(e)}")
    
    def delete_record(self):
        """Elimina un registro de la tabla actual"""
        if not self.current_table:
            messagebox.showwarning("Advertencia", "Primero seleccione una tabla.")
            return
        
        selection = self.data_tree.selection()
        if not selection:
            messagebox.showwarning("Advertencia", "Seleccione un registro para eliminar.")
            return
        
        # Confirmar eliminación
        if not messagebox.askyesno("Confirmar", "¿Está seguro que desea eliminar este registro?"):
            return
        
        try:
            # Obtener información de columnas
            cursor = self.connection.cursor()
            
            # Identificar la clave primaria
            cursor.execute(f"""
                SELECT cols.column_name
                FROM all_constraints cons, all_cons_columns cols
                WHERE cons.constraint_type = 'P'
                AND cons.constraint_name = cols.constraint_name
                AND cons.owner = cols.owner
                AND cols.table_name = '{self.current_table}'
            """)
            pk_columns = [row[0] for row in cursor.fetchall()]
            
            if not pk_columns:
                messagebox.showwarning("Advertencia", "No se pudo determinar la clave primaria de esta tabla.")
                return
            
            # Obtener datos del registro seleccionado
            item = self.data_tree.item(selection[0])
            values = item['values']
            
            # Construir consulta WHERE con clave primaria
            where_clause = []
            params = []
            
            for i, col in enumerate(self.data_tree['columns']):
                if col in pk_columns:
                    where_clause.append(f"{col} = :p{i}")
                    params.append(values[i])
            
            query = f"DELETE FROM {self.current_table} WHERE {' AND '.join(where_clause)}"
            
            # Ejecutar consulta
            cursor.execute(query, params)
            self.connection.commit()
            cursor.close()
            
            self.status_var.set(f"Registro eliminado de {self.current_table}")
            self.refresh_data()
        except oracledb.Error as e:
            error, = e.args
            messagebox.showerror("Error", f"Oracle Error: {error.message}")
        except Exception as e:
            messagebox.showerror("Error", f"Error inesperado: {str(e)}")
    
    def search_records(self):
        """Busca registros que coincidan con el criterio de búsqueda"""
        if not self.current_table:
            messagebox.showwarning("Advertencia", "Primero seleccione una tabla.")
            return
        
        search_text = self.search_entry.get().strip()
        if not search_text:
            messagebox.showwarning("Advertencia", "Ingrese un texto para buscar.")
            return
        
        search_column = self.search_column.get()
        if not search_column:
            messagebox.showwarning("Advertencia", "Seleccione una columna para buscar.")
            return
        
        try:
            # Ejecutar consulta de búsqueda
            cursor = self.connection.cursor()
            query = f"SELECT * FROM {self.current_table} WHERE UPPER({search_column}) LIKE UPPER('%{search_text}%')"
            cursor.execute(query)
            rows = cursor.fetchall()
            
            # Limpiar treeview
            for row in self.data_tree.get_children():
                self.data_tree.delete(row)
            
            # Insertar datos encontrados en el treeview
            for row in rows:
                formatted_row = []
                for i, value in enumerate(row):
                    # Formatear fechas y otros tipos de datos si es necesario
                    if isinstance(value, datetime):
                        formatted_row.append(value.strftime('%Y-%m-%d %H:%M:%S'))
                    elif value is None:
                        formatted_row.append('')
                    else:
                        formatted_row.append(str(value))
                self.data_tree.insert('', tk.END, values=formatted_row)
            
            cursor.close()
            self.status_var.set(f"Búsqueda completada: {len(rows)} registros encontrados")
        except oracledb.Error as e:
            error, = e.args
            messagebox.showerror("Error", f"Oracle Error: {error.message}")
        except Exception as e:
            messagebox.showerror("Error", f"Error inesperado: {str(e)}")
    
    def clear_search(self):
        """Limpia la búsqueda y muestra todos los registros"""
        self.search_entry.delete(0, tk.END)
        self.refresh_data()


class RecordDialog(tk.Toplevel):
    def __init__(self, parent, connection, table_name, columns_info, values=None, pk_values=None):
        super().__init__(parent)
        self.connection = connection
        self.table_name = table_name
        self.columns_info = columns_info
        self.values = values  # Valores existentes para edición
        self.pk_values = pk_values  # Valores de clave primaria para actualización
        self.entries = {}  # Diccionario para almacenar los widgets Entry
        self.success = False  # Indicador de operación exitosa
        
        self.title(f"{'Editar' if values else 'Agregar'} Registro - {table_name}")
        self.geometry("600x500")
        self.resizable(True, True)
        self.transient(parent)
        self.grab_set()
        
        self.setup_ui()
    
    def setup_ui(self):
        # Crear un frame con scrollbar
        main_frame = ttk.Frame(self)
        main_frame.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        # Canvas con scrollbar
        canvas = tk.Canvas(main_frame)
        scrollbar = ttk.Scrollbar(main_frame, orient="vertical", command=canvas.yview)
        self.scrollable_frame = ttk.Frame(canvas)
        
        self.scrollable_frame.bind(
            "<Configure>",
            lambda e: canvas.configure(scrollregion=canvas.bbox("all"))
        )
        
        canvas.create_window((0, 0), window=self.scrollable_frame, anchor="nw")
        canvas.configure(yscrollcommand=scrollbar.set)
        
        canvas.pack(side="left", fill="both", expand=True)
        scrollbar.pack(side="right", fill="y")
        
        # Crear campos para cada columna
        for i, (column_name, data_type) in enumerate(self.columns_info):
            frame = ttk.Frame(self.scrollable_frame)
            frame.pack(fill=tk.X, padx=5, pady=5)
            
            ttk.Label(frame, text=f"{column_name}:", width=20).pack(side=tk.LEFT)
            
            # Crear el widget adecuado según el tipo de dato
            if data_type in ('DATE', 'TIMESTAMP'):
                entry = DateEntry(frame)
            elif data_type == 'BLOB':
                entry = ttk.Label(frame, text="[BLOB - No editable]")
            elif data_type.startswith('NUMBER'):
                entry = NumericEntry(frame)
            else:
                entry = ttk.Entry(frame, width=40)
            
            entry.pack(side=tk.LEFT, fill=tk.X, expand=True, padx=5)
            self.entries[column_name] = entry
            
            # Si es edición, llenar con valores existentes
            if self.values and i < len(self.values):
                value = self.values[i]
                if value is not None:
                    if hasattr(entry, 'insert'):
                        entry.insert(0, str(value))
                    elif isinstance(entry, DateEntry):
                        if isinstance(value, str):
                            try:
                                entry.set_date(datetime.strptime(value, '%Y-%m-%d %H:%M:%S'))
                            except ValueError:
                                try:
                                    entry.set_date(datetime.strptime(value, '%Y-%m-%d'))
                                except ValueError:
                                    pass
                        elif isinstance(value, datetime):
                            entry.set_date(value)
            
            # Si es clave primaria y estamos editando, deshabilitar el campo
            if self.pk_values and column_name in self.pk_values:
                if hasattr(entry, 'configure'):
                    entry.configure(state='readonly')
        
        # Botones de acción
        btn_frame = ttk.Frame(self)
        btn_frame.pack(fill=tk.X, padx=10, pady=10)
        
        ttk.Button(btn_frame, text="Guardar", command=self.save_record).pack(side=tk.RIGHT, padx=5)
        ttk.Button(btn_frame, text="Cancelar", command=self.cancel).pack(side=tk.RIGHT, padx=5)
    
    def save_record(self):
        """Guarda o actualiza el registro en la base de datos"""
        try:
            cursor = self.connection.cursor()
            
            # Preparar los valores para inserción/actualización
            values = {}
            for column_name, entry in self.entries.items():
                if isinstance(entry, ttk.Label):  # BLOB u otro no editable
                    continue
                
                if isinstance(entry, DateEntry):
                    date_value = entry.get_date()
                    values[column_name] = date_value
                else:
                    value = entry.get()
                    if value == '':
                        values[column_name] = None
                    else:
                        values[column_name] = value
            
            if self.pk_values:  # Actualización (UPDATE)
                # Construir consulta UPDATE
                set_clause = []
                for column_name, value in values.items():
                    if column_name not in self.pk_values:  # No actualizar claves primarias
                        set_clause.append(f"{column_name} = :{column_name}")
                
                where_clause = []
                for pk_column, pk_value in self.pk_values.items():
                    where_clause.append(f"{pk_column} = :{pk_column}_pk")
                    values[f"{pk_column}_pk"] = pk_value
                
                query = f"UPDATE {self.table_name} SET {', '.join(set_clause)} WHERE {' AND '.join(where_clause)}"
            else:  # Inserción (INSERT)
                # Construir consulta INSERT
                columns = list(values.keys())
                placeholders = [f":{col}" for col in columns]
                query = f"INSERT INTO {self.table_name} ({', '.join(columns)}) VALUES ({', '.join(placeholders)})"
            
            # Ejecutar consulta
            cursor.execute(query, values)
            self.connection.commit()
            cursor.close()
            
            self.success = True
            self.destroy()
        except oracledb.Error as e:
            error, = e.args
            messagebox.showerror("Error", f"Oracle Error: {error.message}")
        except Exception as e:
            messagebox.showerror("Error", f"Error inesperado: {str(e)}")
    
    def cancel(self):
        self.destroy()


class DateEntry(ttk.Frame):
    """Widget personalizado para entrada de fechas"""
    def __init__(self, parent, *args, **kwargs):
        super().__init__(parent, *args, **kwargs)
        
        # Crear comboboxes para día, mes, año, hora, minuto, segundo
        self.day_var = tk.StringVar()
        self.month_var = tk.StringVar()
        self.year_var = tk.StringVar()
        
        days = [str(i).zfill(2) for i in range(1, 32)]
        months = [str(i).zfill(2) for i in range(1, 13)]
        current_year = datetime.now().year
        years = [str(i) for i in range(current_year - 50, current_year + 50)]
        
        ttk.Combobox(self, textvariable=self.day_var, values=days, width=3).pack(side=tk.LEFT)
        ttk.Label(self, text="/").pack(side=tk.LEFT)
        ttk.Combobox(self, textvariable=self.month_var, values=months, width=3).pack(side=tk.LEFT)
        ttk.Label(self, text="/").pack(side=tk.LEFT)
        ttk.Combobox(self, textvariable=self.year_var, values=years, width=5).pack(side=tk.LEFT)
        
        # Establecer valores predeterminados a la fecha actual
        today = datetime.now()
        self.day_var.set(str(today.day).zfill(2))
        self.month_var.set(str(today.month).zfill(2))
        self.year_var.set(str(today.year))
    
    def get_date(self):
        """Retorna la fecha como un objeto datetime"""
        try:
            day = int(self.day_var.get())
            month = int(self.month_var.get())
            year = int(self.year_var.get())
            return datetime(year, month, day)
        except (ValueError, TypeError):
            return None
    
    def set_date(self, date):
        """Establece la fecha desde un objeto datetime"""
        if isinstance(date, datetime):
            self.day_var.set(str(date.day).zfill(2))
            self.month_var.set(str(date.month).zfill(2))
            self.year_var.set(str(date.year))


class NumericEntry(ttk.Entry):
    """Widget personalizado para entrada de números"""
    def __init__(self, parent, *args, **kwargs):
        super().__init__(parent, *args, **kwargs)
        
        vcmd = (self.register(self.validate), '%P')
        self.configure(validate="key", validatecommand=vcmd)
    
    def validate(self, new_value):
        """Valida que el valor ingresado sea un número"""
        if new_value == "":
            return True
        
        try:
            float(new_value)
            return True
        except ValueError:
            return False 