-- Script de creación de tablas para el esquema de la base de datos
-- Oracle 11g Express Edition

-- Eliminar tablas si existen para evitar errores
BEGIN
   FOR cur_rec IN (SELECT object_name, object_type
                   FROM user_objects
                   WHERE object_type IN ('TABLE', 'VIEW', 'PACKAGE', 'PROCEDURE', 'FUNCTION', 'SEQUENCE', 'SYNONYM', 'TRIGGER')
                   ORDER BY object_type DESC)
   LOOP
      BEGIN
         IF cur_rec.object_type = 'TABLE' THEN
            EXECUTE IMMEDIATE 'DROP ' || cur_rec.object_type || ' "' || cur_rec.object_name || '" CASCADE CONSTRAINTS';
         ELSE
            EXECUTE IMMEDIATE 'DROP ' || cur_rec.object_type || ' "' || cur_rec.object_name || '"';
         END IF;
      EXCEPTION
         WHEN OTHERS THEN
            NULL;
      END;
   END LOOP;
END;
/

-- Crear tabla Cliente
CREATE TABLE Cliente (
    ID_Cliente NUMBER PRIMARY KEY,
    Nombre VARCHAR2(100),
    Telefono VARCHAR2(15),
    Correo_electronico VARCHAR2(100),
    Puede_hacer NUMBER(1)
);

-- Crear tabla Turno
CREATE TABLE Turno (
    ID_Turno NUMBER PRIMARY KEY,
    Duracion NUMBER,
    Hora_Entrada VARCHAR2(8),
    Hora_Salida VARCHAR2(8)
);

-- Crear tabla Empleado
CREATE TABLE Empleado (
    ID_Empleado NUMBER PRIMARY KEY,
    Nombre VARCHAR2(100),
    Rol VARCHAR2(50),
    Fecha_Contratacion DATE,
    Salario NUMBER(10,2),
    Estado VARCHAR2(20),
    Pertenece_a NUMBER REFERENCES Turno(ID_Turno),
    Es_parte NUMBER(1)
);

-- Crear tabla Evaluacion
CREATE TABLE Evaluacion (
    ID_Evaluacion NUMBER PRIMARY KEY,
    Fecha DATE,
    Puntaje NUMBER(3,1),
    Tiene NUMBER REFERENCES Empleado(ID_Empleado)
);

-- Crear tabla Receta
CREATE TABLE Receta (
    ID_Receta NUMBER PRIMARY KEY,
    Nombre_Plato VARCHAR2(100),
    Costo_Total NUMBER(10,2),
    Tiempo_Preparacion NUMBER,
    Categoria VARCHAR2(50)
);

-- Crear tabla Ingredientes_Receta
CREATE TABLE Ingredientes_Receta (
    ID_Ingredientes NUMBER PRIMARY KEY,
    Cantidad NUMBER(10,2),
    Unidad VARCHAR2(20),
    Hace_parte_de NUMBER REFERENCES Receta(ID_Receta)
);

-- Crear tabla Producto
CREATE TABLE Producto (
    ID_Producto NUMBER PRIMARY KEY,
    Nombre VARCHAR2(100),
    Descripcion VARCHAR2(200),
    Precio_Unitario NUMBER(10,2),
    Fecha_exp DATE,
    Stock_Minimo NUMBER,
    Stock_Maximo NUMBER,
    Fecha_de_Caducidad DATE,
    Lote VARCHAR2(50),
    Tiene NUMBER REFERENCES Receta(ID_Receta)
);

-- Crear tabla Proveedor
CREATE TABLE Proveedor (
    ID_Proveedor NUMBER PRIMARY KEY,
    Nombre VARCHAR2(100),
    Telefono VARCHAR2(15),
    Correo_electronico VARCHAR2(100),
    Direccion VARCHAR2(200),
    Tipo_Producto VARCHAR2(50),
    Se_hace_a NUMBER(1),
    Proviene_de NUMBER REFERENCES Producto(ID_Producto)
);

-- Crear tabla Venta
CREATE TABLE Venta (
    ID_Venta NUMBER PRIMARY KEY,
    Fecha_Venta DATE,
    Total NUMBER(10,2),
    Compraciones NUMBER,
    Puede_hacer NUMBER REFERENCES Cliente(ID_Cliente),
    Realizado_a NUMBER REFERENCES Empleado(ID_Empleado),
    Tiene NUMBER(1)
);

-- Crear tabla Detalle_Venta
CREATE TABLE Detalle_Venta (
    ID_Detalle NUMBER PRIMARY KEY,
    Cantidad NUMBER,
    Precio_Unitario NUMBER(10,2),
    Subtotal NUMBER(10,2),
    Hacia_parte_de NUMBER REFERENCES Venta(ID_Venta),
    Utiliza NUMBER REFERENCES Producto(ID_Producto),
    Hacia_parte NUMBER REFERENCES Receta(ID_Receta)
);

-- Crear tabla Encuesta_Satisfaccion
CREATE TABLE Encuesta_Satisfaccion (
    ID_Encuesta NUMBER PRIMARY KEY,
    Fecha DATE,
    Calificacion NUMBER(2),
    Comentarios VARCHAR2(500),
    Hecho_por NUMBER REFERENCES Cliente(ID_Cliente)
);

-- Crear tabla Reserva
CREATE TABLE Reserva (
    ID_Reserva NUMBER PRIMARY KEY,
    Hora VARCHAR2(8),
    Numero_Personas NUMBER,
    Comentarios VARCHAR2(500),
    Tiene_una NUMBER REFERENCES Cliente(ID_Cliente)
);

-- Crear tabla Compra
CREATE TABLE Compra (
    ID_Compra NUMBER PRIMARY KEY,
    Fecha_Compra DATE,
    Total NUMBER(10,2),
    Hacia_parte NUMBER(1)
);

-- Crear tabla Detalle_Compra
CREATE TABLE Detalle_Compra (
    ID_Detalle_Compra NUMBER PRIMARY KEY,
    Cantidad NUMBER,
    Precio_Unitario NUMBER(10,2),
    Tiene_un NUMBER REFERENCES Compra(ID_Compra),
    Puede_ser_comprado NUMBER REFERENCES Producto(ID_Producto)
);

-- Crear tabla Documento_Legal
CREATE TABLE Documento_Legal (
    ID_Documento NUMBER PRIMARY KEY,
    Tipo_Documento VARCHAR2(50),
    Fecha_Vencimiento DATE,
    Estado VARCHAR2(20),
    Archivo BLOB,
    Necesita NUMBER
);

-- Crear tabla Nomina
CREATE TABLE Nomina (
    ID_Nomina NUMBER PRIMARY KEY,
    Mes VARCHAR2(20),
    Anio NUMBER(4),
    Salario_Bruto NUMBER(10,2),
    Descuentos NUMBER(10,2),
    Salario_Neto NUMBER(10,2),
    Tiene NUMBER REFERENCES Empleado(ID_Empleado),
    Necesita NUMBER REFERENCES Documento_Legal(ID_Documento)
);

-- Crear tabla Establecimiento_Local
CREATE TABLE Establecimiento_Local (
    ID_Mantenimiento NUMBER PRIMARY KEY,
    Patente VARCHAR2(50),
    Area NUMBER(10,2),
    Tipo_Servicio VARCHAR2(50),
    Empresa_Servicio VARCHAR2(100),
    Costo NUMBER(10,2),
    Necesita NUMBER REFERENCES Documento_Legal(ID_Documento)
);

-- Crear tabla Evento
CREATE TABLE Evento (
    ID_Evento NUMBER PRIMARY KEY,
    Nombre VARCHAR2(100),
    Fecha DATE,
    Descripcion VARCHAR2(200),
    Cupo NUMBER,
    Promociones NUMBER(1),
    Hace_parte_de NUMBER,
    Puede_tener NUMBER(1)
);

-- Crear tabla Campaña_Marketing
CREATE TABLE Campania_Marketing (
    ID_Campania NUMBER PRIMARY KEY,
    Nombre VARCHAR2(100),
    Fecha_Inicio DATE,
    Fecha_Fin DATE,
    Canal VARCHAR2(50),
    Costo_Total NUMBER(10,2),
    Roi NUMBER(10,2),
    Necesita NUMBER REFERENCES Evento(ID_Evento),
    Hacia_parte_de NUMBER
);

-- Crear tabla Publicidad_Social
CREATE TABLE Publicidad_Social (
    ID_Post NUMBER PRIMARY KEY,
    Fecha DATE,
    Red_Social VARCHAR2(50),
    Contenido VARCHAR2(1000),
    Compartido NUMBER(1),
    Necesita NUMBER REFERENCES Campania_Marketing(ID_Campania)
);

-- Crear secuencias para las tablas
CREATE SEQUENCE seq_cliente START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_turno START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_empleado START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_evaluacion START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_receta START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_ingredientes START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_producto START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_proveedor START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_venta START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_detalle_venta START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_encuesta START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_reserva START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_compra START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_detalle_compra START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_documento START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_nomina START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_establecimiento START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_evento START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_campania START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_post START WITH 1 INCREMENT BY 1;

COMMIT; 