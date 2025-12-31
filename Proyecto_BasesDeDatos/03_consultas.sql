-- Script de consultas SQL
-- Oracle 11g Express Edition

-- 1. CONSULTAS BÁSICAS (SELECT)

-- 1.1 Seleccionar todos los clientes
SELECT * FROM Cliente;

-- 1.2 Seleccionar nombres y teléfonos de clientes
SELECT Nombre, Telefono FROM Cliente;

-- 1.3 Seleccionar productos con precio mayor a 5
SELECT Nombre, Precio_Unitario FROM Producto WHERE Precio_Unitario > 5;

-- 1.4 Seleccionar recetas ordenadas por tiempo de preparación
SELECT Nombre_Plato, Tiempo_Preparacion FROM Receta ORDER BY Tiempo_Preparacion ASC;

-- 1.5 Seleccionar ventas realizadas en junio de 2023
SELECT ID_Venta, Fecha_Venta, Total FROM Venta 
WHERE Fecha_Venta BETWEEN TO_DATE('01-06-2023', 'DD-MM-YYYY') AND TO_DATE('30-06-2023', 'DD-MM-YYYY');

-- 2. INSERCIÓN DE DATOS (INSERT)

-- 2.1 Insertar un nuevo cliente
INSERT INTO Cliente (ID_Cliente, Nombre, Telefono, Correo_electronico, Puede_hacer)
VALUES (seq_cliente.NEXTVAL, 'Laura Mendez', '555-6543', 'laura.mendez@email.com', 1);

-- 2.2 Insertar un nuevo producto
INSERT INTO Producto (ID_Producto, Nombre, Descripcion, Precio_Unitario, Fecha_exp, Stock_Minimo, Stock_Maximo, Fecha_de_Caducidad, Lote, Tiene)
VALUES (seq_producto.NEXTVAL, 'Aceite de oliva', 'Aceite de oliva virgen extra', 7.50, TO_DATE('31-12-2024', 'DD-MM-YYYY'), 5, 30, TO_DATE('31-12-2024', 'DD-MM-YYYY'), 'LOT678', NULL);

-- 2.3 Insertar una nueva receta
INSERT INTO Receta (ID_Receta, Nombre_Plato, Costo_Total, Tiempo_Preparacion, Categoria)
VALUES (seq_receta.NEXTVAL, 'Risotto de champiñones', 10.80, 35, 'Arroz');

-- 2.4 Insertar un nuevo turno
INSERT INTO Turno (ID_Turno, Duracion, Hora_Entrada, Hora_Salida)
VALUES (seq_turno.NEXTVAL, 5, '17:00', '22:00');

-- 2.5 Insertar una nueva venta
INSERT INTO Venta (ID_Venta, Fecha_Venta, Total, Compraciones, Puede_hacer, Realizado_a, Tiene)
VALUES (seq_venta.NEXTVAL, SYSDATE, 45.20, 3, 1, 1, 1);

-- 3. ACTUALIZACIÓN DE DATOS (UPDATE)

-- 3.1 Actualizar el teléfono de un cliente
UPDATE Cliente SET Telefono = '555-9876' WHERE ID_Cliente = 1;

-- 3.2 Actualizar el precio de un producto
UPDATE Producto SET Precio_Unitario = Precio_Unitario * 1.05 WHERE ID_Producto = 3;

-- 3.3 Actualizar la categoría de una receta
UPDATE Receta SET Categoria = 'Plato principal' WHERE ID_Receta = 2;

-- 3.4 Actualizar el salario de los empleados con aumento del 10%
UPDATE Empleado SET Salario = Salario * 1.1 WHERE Rol = 'Mesero';

-- 3.5 Actualizar los stocks mínimos de todos los productos
UPDATE Producto SET Stock_Minimo = Stock_Minimo + 2;

-- 4. ELIMINACIÓN DE DATOS (DELETE)

-- 4.1 Eliminar una reserva específica
DELETE FROM Reserva WHERE ID_Reserva = 5;

-- 4.2 Eliminar publicaciones en redes sociales antiguas
DELETE FROM Publicidad_Social 
WHERE Fecha < TO_DATE('10-06-2023', 'DD-MM-YYYY');

-- 4.3 Eliminar evaluaciones con puntaje menor a 3.5
DELETE FROM Evaluacion WHERE Puntaje < 3.5;

-- 4.4 Eliminar detalles de compra específicos
DELETE FROM Detalle_Compra WHERE ID_Detalle_Compra = 2;

-- 4.5 Eliminar encuestas sin comentarios
DELETE FROM Encuesta_Satisfaccion WHERE Comentarios IS NULL OR Comentarios = '';

-- 5. CONSULTAS MULTITABLA (JOIN, SUBQUERIES, ETC.)

-- 5.1 Productos y sus proveedores
SELECT p.ID_Producto, p.Nombre AS "Producto", p.Precio_Unitario, pr.Nombre AS "Proveedor", pr.Telefono
FROM Producto p
JOIN Proveedor pr ON pr.Proviene_de = p.ID_Producto
ORDER BY p.Precio_Unitario DESC;

-- 5.2 Clientes, sus ventas y detalles de ventas
SELECT c.Nombre AS "Cliente", v.ID_Venta, v.Fecha_Venta, v.Total, 
       dv.Cantidad, dv.Precio_Unitario, dv.Subtotal,
       p.Nombre AS "Producto"
FROM Cliente c
JOIN Venta v ON v.Puede_hacer = c.ID_Cliente
JOIN Detalle_Venta dv ON dv.Hacia_parte_de = v.ID_Venta
JOIN Producto p ON p.ID_Producto = dv.Utiliza
ORDER BY v.Fecha_Venta DESC;

-- 5.3 Empleados y sus evaluaciones
SELECT e.ID_Empleado, e.Nombre AS "Empleado", e.Rol, t.Hora_Entrada, t.Hora_Salida,
       ev.Fecha AS "Fecha Evaluación", ev.Puntaje
FROM Empleado e
JOIN Turno t ON e.Pertenece_a = t.ID_Turno
LEFT JOIN Evaluacion ev ON ev.Tiene = e.ID_Empleado
ORDER BY ev.Puntaje DESC;

-- 5.4 Recetas y sus ingredientes
SELECT r.ID_Receta, r.Nombre_Plato, r.Categoria, r.Tiempo_Preparacion,
       i.Cantidad, i.Unidad
FROM Receta r
JOIN Ingredientes_Receta i ON i.Hace_parte_de = r.ID_Receta
ORDER BY r.Tiempo_Preparacion ASC;

-- 5.5 Eventos y campañas de marketing relacionadas
SELECT e.ID_Evento, e.Nombre AS "Evento", e.Fecha, e.Cupo,
       c.Nombre AS "Campaña", c.Canal, c.Costo_Total,
       ps.Red_Social, ps.Contenido
FROM Evento e
JOIN Campania_Marketing c ON c.Necesita = e.ID_Evento
LEFT JOIN Publicidad_Social ps ON ps.Necesita = c.ID_Campania
ORDER BY e.Fecha;

-- 5.6 Productos con stock bajo o crítico (usando subconsulta)
SELECT p.ID_Producto, p.Nombre, p.Stock_Minimo, p.Stock_Maximo, 
       (SELECT COUNT(*) FROM Detalle_Venta dv WHERE dv.Utiliza = p.ID_Producto) AS "Total Vendidos"
FROM Producto p
WHERE p.ID_Producto IN (
    SELECT dv.Utiliza 
    FROM Detalle_Venta dv 
    GROUP BY dv.Utiliza 
    HAVING COUNT(*) > 1
)
ORDER BY "Total Vendidos" DESC;

-- 5.7 Total de ventas por empleado
SELECT e.ID_Empleado, e.Nombre AS "Empleado", e.Rol,
       COUNT(v.ID_Venta) AS "Número de Ventas",
       SUM(v.Total) AS "Total Vendido"
FROM Empleado e
LEFT JOIN Venta v ON v.Realizado_a = e.ID_Empleado
GROUP BY e.ID_Empleado, e.Nombre, e.Rol
ORDER BY "Total Vendido" DESC;

-- 5.8 Clientes y sus encuestas con calificación alta
SELECT c.ID_Cliente, c.Nombre AS "Cliente",
       es.Calificacion, es.Comentarios,
       es.Fecha AS "Fecha Encuesta"
FROM Cliente c
JOIN Encuesta_Satisfaccion es ON es.Hecho_por = c.ID_Cliente
WHERE es.Calificacion > (SELECT AVG(Calificacion) FROM Encuesta_Satisfaccion)
ORDER BY es.Calificacion DESC;

-- 5.9 Productos más utilizados en recetas
SELECT p.ID_Producto, p.Nombre AS "Producto", 
       COUNT(r.ID_Receta) AS "Usado en Recetas",
       AVG(r.Tiempo_Preparacion) AS "Tiempo Promedio Preparación"
FROM Producto p
JOIN Receta r ON r.ID_Receta = p.Tiene
GROUP BY p.ID_Producto, p.Nombre
HAVING COUNT(r.ID_Receta) > 0
ORDER BY "Usado en Recetas" DESC;

-- 5.10 Ventas y compras realizadas en el mismo período
SELECT 'Venta' AS "Tipo", v.ID_Venta AS "ID", v.Fecha_Venta AS "Fecha", v.Total
FROM Venta v
WHERE v.Fecha_Venta BETWEEN TO_DATE('01-06-2023', 'DD-MM-YYYY') AND TO_DATE('05-06-2023', 'DD-MM-YYYY')
UNION
SELECT 'Compra' AS "Tipo", c.ID_Compra AS "ID", c.Fecha_Compra AS "Fecha", c.Total
FROM Compra c
WHERE c.Fecha_Compra BETWEEN TO_DATE('01-06-2023', 'DD-MM-YYYY') AND TO_DATE('05-06-2023', 'DD-MM-YYYY')
ORDER BY "Fecha";

-- 6. CONSULTAS AVANZADAS CON FUNCIONES ANALÍTICAS

-- 6.1 Ranking de productos por precio
SELECT ID_Producto, Nombre, Precio_Unitario,
       RANK() OVER (ORDER BY Precio_Unitario DESC) AS "Ranking por Precio"
FROM Producto;

-- 6.2 Promedio móvil de ventas
SELECT ID_Venta, Fecha_Venta, Total,
       ROUND(AVG(Total) OVER (ORDER BY Fecha_Venta ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING), 2) AS "Promedio Móvil"
FROM Venta;

-- 6.3 Acumulado de ventas por fecha
SELECT ID_Venta, Fecha_Venta, Total,
       SUM(Total) OVER (ORDER BY Fecha_Venta) AS "Total Acumulado"
FROM Venta;

-- 6.4 Particionado por categoría de recetas
SELECT ID_Receta, Nombre_Plato, Categoria, Costo_Total,
       AVG(Costo_Total) OVER (PARTITION BY Categoria) AS "Promedio por Categoría",
       MAX(Costo_Total) OVER (PARTITION BY Categoria) AS "Máximo por Categoría"
FROM Receta;

-- 6.5 Diferencia entre salarios consecutivos
SELECT ID_Empleado, Nombre, Rol, Salario,
       Salario - LAG(Salario, 1, 0) OVER (ORDER BY Salario) AS "Diferencia con anterior"
FROM Empleado
ORDER BY Salario; 