-- Script de inserción de datos para las tablas
-- Oracle 11g Express Edition

-- Insertar datos en la tabla Cliente
INSERT INTO Cliente VALUES (seq_cliente.NEXTVAL, 'Juan Perez', '555-1234', 'juan.perez@email.com', 1);
INSERT INTO Cliente VALUES (seq_cliente.NEXTVAL, 'Ana Garcia', '555-5678', 'ana.garcia@email.com', 1);
INSERT INTO Cliente VALUES (seq_cliente.NEXTVAL, 'Carlos Lopez', '555-9012', 'carlos.lopez@email.com', 0);
INSERT INTO Cliente VALUES (seq_cliente.NEXTVAL, 'Maria Rodriguez', '555-3456', 'maria.rodriguez@email.com', 1);
INSERT INTO Cliente VALUES (seq_cliente.NEXTVAL, 'Pedro Sanchez', '555-7890', 'pedro.sanchez@email.com', 1);

-- Insertar datos en la tabla Turno
INSERT INTO Turno VALUES (seq_turno.NEXTVAL, 8, '08:00', '16:00');
INSERT INTO Turno VALUES (seq_turno.NEXTVAL, 8, '16:00', '00:00');
INSERT INTO Turno VALUES (seq_turno.NEXTVAL, 8, '00:00', '08:00');
INSERT INTO Turno VALUES (seq_turno.NEXTVAL, 6, '12:00', '18:00');
INSERT INTO Turno VALUES (seq_turno.NEXTVAL, 4, '18:00', '22:00');

-- Insertar datos en la tabla Empleado
INSERT INTO Empleado VALUES (seq_empleado.NEXTVAL, 'Luis Martinez', 'Chef', TO_DATE('10-05-2020', 'DD-MM-YYYY'), 2500.00, 'Activo', 1, 1);
INSERT INTO Empleado VALUES (seq_empleado.NEXTVAL, 'Sofia Fernandez', 'Mesero', TO_DATE('15-06-2021', 'DD-MM-YYYY'), 1800.00, 'Activo', 2, 1);
INSERT INTO Empleado VALUES (seq_empleado.NEXTVAL, 'Roberto Gonzalez', 'Gerente', TO_DATE('20-01-2019', 'DD-MM-YYYY'), 3000.00, 'Activo', 1, 1);
INSERT INTO Empleado VALUES (seq_empleado.NEXTVAL, 'Laura Torres', 'Cajero', TO_DATE('05-03-2022', 'DD-MM-YYYY'), 1900.00, 'Activo', 2, 1);
INSERT INTO Empleado VALUES (seq_empleado.NEXTVAL, 'Miguel Diaz', 'Ayudante de cocina', TO_DATE('12-08-2021', 'DD-MM-YYYY'), 1700.00, 'Activo', 3, 1);

-- Insertar datos en la tabla Evaluacion
INSERT INTO Evaluacion VALUES (seq_evaluacion.NEXTVAL, TO_DATE('15-01-2023', 'DD-MM-YYYY'), 4.5, 1);
INSERT INTO Evaluacion VALUES (seq_evaluacion.NEXTVAL, TO_DATE('20-02-2023', 'DD-MM-YYYY'), 3.8, 2);
INSERT INTO Evaluacion VALUES (seq_evaluacion.NEXTVAL, TO_DATE('10-03-2023', 'DD-MM-YYYY'), 4.2, 3);
INSERT INTO Evaluacion VALUES (seq_evaluacion.NEXTVAL, TO_DATE('05-04-2023', 'DD-MM-YYYY'), 4.0, 4);
INSERT INTO Evaluacion VALUES (seq_evaluacion.NEXTVAL, TO_DATE('18-05-2023', 'DD-MM-YYYY'), 3.5, 5);

-- Insertar datos en la tabla Receta
INSERT INTO Receta VALUES (seq_receta.NEXTVAL, 'Pasta Carbonara', 8.50, 30, 'Pasta');
INSERT INTO Receta VALUES (seq_receta.NEXTVAL, 'Ensalada César', 6.20, 15, 'Ensalada');
INSERT INTO Receta VALUES (seq_receta.NEXTVAL, 'Pollo al Curry', 9.80, 45, 'Plato principal');
INSERT INTO Receta VALUES (seq_receta.NEXTVAL, 'Tarta de manzana', 7.30, 60, 'Postre');
INSERT INTO Receta VALUES (seq_receta.NEXTVAL, 'Sopa de pescado', 8.90, 40, 'Sopa');

-- Insertar datos en la tabla Ingredientes_Receta
INSERT INTO Ingredientes_Receta VALUES (seq_ingredientes.NEXTVAL, 200, 'gramos', 1);
INSERT INTO Ingredientes_Receta VALUES (seq_ingredientes.NEXTVAL, 100, 'mililitros', 1);
INSERT INTO Ingredientes_Receta VALUES (seq_ingredientes.NEXTVAL, 150, 'gramos', 2);
INSERT INTO Ingredientes_Receta VALUES (seq_ingredientes.NEXTVAL, 300, 'gramos', 3);
INSERT INTO Ingredientes_Receta VALUES (seq_ingredientes.NEXTVAL, 250, 'gramos', 4);

-- Insertar datos en la tabla Producto
INSERT INTO Producto VALUES (seq_producto.NEXTVAL, 'Pasta fresca', 'Pasta fresca artesanal', 3.50, TO_DATE('31-12-2023', 'DD-MM-YYYY'), 10, 50, TO_DATE('31-12-2023', 'DD-MM-YYYY'), 'LOT123', 1);
INSERT INTO Producto VALUES (seq_producto.NEXTVAL, 'Lechuga romana', 'Lechuga romana fresca', 1.20, TO_DATE('10-06-2023', 'DD-MM-YYYY'), 5, 20, TO_DATE('10-06-2023', 'DD-MM-YYYY'), 'LOT456', 2);
INSERT INTO Producto VALUES (seq_producto.NEXTVAL, 'Pollo', 'Pollo entero fresco', 5.90, TO_DATE('15-06-2023', 'DD-MM-YYYY'), 3, 15, TO_DATE('15-06-2023', 'DD-MM-YYYY'), 'LOT789', 3);
INSERT INTO Producto VALUES (seq_producto.NEXTVAL, 'Manzana', 'Manzanas Golden', 2.40, TO_DATE('20-06-2023', 'DD-MM-YYYY'), 10, 40, TO_DATE('20-06-2023', 'DD-MM-YYYY'), 'LOT012', 4);
INSERT INTO Producto VALUES (seq_producto.NEXTVAL, 'Pescado', 'Filetes de merluza', 8.75, TO_DATE('12-06-2023', 'DD-MM-YYYY'), 2, 10, TO_DATE('12-06-2023', 'DD-MM-YYYY'), 'LOT345', 5);

-- Insertar datos en la tabla Proveedor
INSERT INTO Proveedor VALUES (seq_proveedor.NEXTVAL, 'Pastas Italiano', '555-2468', 'info@pastasitaliano.com', 'Calle Italia 123', 'Pasta', 1, 1);
INSERT INTO Proveedor VALUES (seq_proveedor.NEXTVAL, 'Verduras Frescas', '555-1357', 'contacto@verdurasfrescas.com', 'Avenida Campo 456', 'Verduras', 1, 2);
INSERT INTO Proveedor VALUES (seq_proveedor.NEXTVAL, 'Carnicería Premium', '555-3690', 'ventas@carniceriapremium.com', 'Calle Mayor 789', 'Carnes', 1, 3);
INSERT INTO Proveedor VALUES (seq_proveedor.NEXTVAL, 'Frutas del Huerto', '555-4812', 'pedidos@frutasdelhuerto.com', 'Calle Manzana 321', 'Frutas', 1, 4);
INSERT INTO Proveedor VALUES (seq_proveedor.NEXTVAL, 'Pescados Frescos', '555-6024', 'info@pescadosfrescos.com', 'Avenida Mar 654', 'Pescados', 1, 5);

-- Insertar datos en la tabla Venta
INSERT INTO Venta VALUES (seq_venta.NEXTVAL, TO_DATE('05-06-2023', 'DD-MM-YYYY'), 28.50, 2, 1, 4, 1);
INSERT INTO Venta VALUES (seq_venta.NEXTVAL, TO_DATE('06-06-2023', 'DD-MM-YYYY'), 15.30, 1, 2, 4, 1);
INSERT INTO Venta VALUES (seq_venta.NEXTVAL, TO_DATE('07-06-2023', 'DD-MM-YYYY'), 42.80, 3, 3, 4, 1);
INSERT INTO Venta VALUES (seq_venta.NEXTVAL, TO_DATE('08-06-2023', 'DD-MM-YYYY'), 22.60, 2, 4, 4, 1);
INSERT INTO Venta VALUES (seq_venta.NEXTVAL, TO_DATE('09-06-2023', 'DD-MM-YYYY'), 35.90, 2, 5, 4, 1);

-- Insertar datos en la tabla Detalle_Venta
INSERT INTO Detalle_Venta VALUES (seq_detalle_venta.NEXTVAL, 2, 12.50, 25.00, 1, 1, 1);
INSERT INTO Detalle_Venta VALUES (seq_detalle_venta.NEXTVAL, 1, 8.50, 8.50, 2, 2, 2);
INSERT INTO Detalle_Venta VALUES (seq_detalle_venta.NEXTVAL, 3, 9.80, 29.40, 3, 3, 3);
INSERT INTO Detalle_Venta VALUES (seq_detalle_venta.NEXTVAL, 2, 7.30, 14.60, 4, 4, 4);
INSERT INTO Detalle_Venta VALUES (seq_detalle_venta.NEXTVAL, 2, 13.50, 27.00, 5, 5, 5);

-- Insertar datos en la tabla Encuesta_Satisfaccion
INSERT INTO Encuesta_Satisfaccion VALUES (seq_encuesta.NEXTVAL, TO_DATE('05-06-2023', 'DD-MM-YYYY'), 8, 'Buena comida, buen servicio', 1);
INSERT INTO Encuesta_Satisfaccion VALUES (seq_encuesta.NEXTVAL, TO_DATE('06-06-2023', 'DD-MM-YYYY'), 7, 'La comida estaba bien, pero tardó en llegar', 2);
INSERT INTO Encuesta_Satisfaccion VALUES (seq_encuesta.NEXTVAL, TO_DATE('07-06-2023', 'DD-MM-YYYY'), 9, 'Excelente atención, volveré pronto', 3);
INSERT INTO Encuesta_Satisfaccion VALUES (seq_encuesta.NEXTVAL, TO_DATE('08-06-2023', 'DD-MM-YYYY'), 6, 'La comida podría mejorar', 4);
INSERT INTO Encuesta_Satisfaccion VALUES (seq_encuesta.NEXTVAL, TO_DATE('09-06-2023', 'DD-MM-YYYY'), 8, 'Buen ambiente y buena comida', 5);

-- Insertar datos en la tabla Reserva
INSERT INTO Reserva VALUES (seq_reserva.NEXTVAL, '20:00', 4, 'Mesa cerca de la ventana', 1);
INSERT INTO Reserva VALUES (seq_reserva.NEXTVAL, '21:00', 2, 'Celebración de aniversario', 2);
INSERT INTO Reserva VALUES (seq_reserva.NEXTVAL, '19:30', 6, 'Reunión familiar', 3);
INSERT INTO Reserva VALUES (seq_reserva.NEXTVAL, '20:30', 3, 'Sin comentarios', 4);
INSERT INTO Reserva VALUES (seq_reserva.NEXTVAL, '19:00', 5, 'Cumpleaños', 5);

-- Insertar datos en la tabla Compra
INSERT INTO Compra VALUES (seq_compra.NEXTVAL, TO_DATE('01-06-2023', 'DD-MM-YYYY'), 520.80, 1);
INSERT INTO Compra VALUES (seq_compra.NEXTVAL, TO_DATE('02-06-2023', 'DD-MM-YYYY'), 350.40, 1);
INSERT INTO Compra VALUES (seq_compra.NEXTVAL, TO_DATE('03-06-2023', 'DD-MM-YYYY'), 680.25, 1);
INSERT INTO Compra VALUES (seq_compra.NEXTVAL, TO_DATE('04-06-2023', 'DD-MM-YYYY'), 420.60, 1);
INSERT INTO Compra VALUES (seq_compra.NEXTVAL, TO_DATE('05-06-2023', 'DD-MM-YYYY'), 590.75, 1);

-- Insertar datos en la tabla Detalle_Compra
INSERT INTO Detalle_Compra VALUES (seq_detalle_compra.NEXTVAL, 50, 2.80, 1, 1);
INSERT INTO Detalle_Compra VALUES (seq_detalle_compra.NEXTVAL, 40, 1.10, 2, 2);
INSERT INTO Detalle_Compra VALUES (seq_detalle_compra.NEXTVAL, 30, 5.50, 3, 3);
INSERT INTO Detalle_Compra VALUES (seq_detalle_compra.NEXTVAL, 60, 2.20, 4, 4);
INSERT INTO Detalle_Compra VALUES (seq_detalle_compra.NEXTVAL, 25, 8.50, 5, 5);

-- Insertar datos en la tabla Documento_Legal
INSERT INTO Documento_Legal VALUES (seq_documento.NEXTVAL, 'Licencia', TO_DATE('31-12-2025', 'DD-MM-YYYY'), 'Activo', EMPTY_BLOB(), NULL);
INSERT INTO Documento_Legal VALUES (seq_documento.NEXTVAL, 'Permiso sanitario', TO_DATE('30-06-2024', 'DD-MM-YYYY'), 'Activo', EMPTY_BLOB(), NULL);
INSERT INTO Documento_Legal VALUES (seq_documento.NEXTVAL, 'Contrato empleado', TO_DATE('31-12-2023', 'DD-MM-YYYY'), 'Activo', EMPTY_BLOB(), NULL);
INSERT INTO Documento_Legal VALUES (seq_documento.NEXTVAL, 'Seguro', TO_DATE('31-03-2024', 'DD-MM-YYYY'), 'Activo', EMPTY_BLOB(), NULL);
INSERT INTO Documento_Legal VALUES (seq_documento.NEXTVAL, 'Patente comercial', TO_DATE('31-12-2024', 'DD-MM-YYYY'), 'Activo', EMPTY_BLOB(), NULL);

-- Insertar datos en la tabla Nomina
INSERT INTO Nomina VALUES (seq_nomina.NEXTVAL, 'Mayo', 2023, 2500.00, 500.00, 2000.00, 1, 3);
INSERT INTO Nomina VALUES (seq_nomina.NEXTVAL, 'Mayo', 2023, 1800.00, 360.00, 1440.00, 2, 3);
INSERT INTO Nomina VALUES (seq_nomina.NEXTVAL, 'Mayo', 2023, 3000.00, 600.00, 2400.00, 3, 3);
INSERT INTO Nomina VALUES (seq_nomina.NEXTVAL, 'Mayo', 2023, 1900.00, 380.00, 1520.00, 4, 3);
INSERT INTO Nomina VALUES (seq_nomina.NEXTVAL, 'Mayo', 2023, 1700.00, 340.00, 1360.00, 5, 3);

-- Insertar datos en la tabla Establecimiento_Local
INSERT INTO Establecimiento_Local VALUES (seq_establecimiento.NEXTVAL, 'PAT12345', 150.00, 'Limpieza', 'Limpieza Express', 300.00, 5);
INSERT INTO Establecimiento_Local VALUES (seq_establecimiento.NEXTVAL, 'PAT12345', 150.00, 'Fumigación', 'Plagas Cero', 250.00, 5);
INSERT INTO Establecimiento_Local VALUES (seq_establecimiento.NEXTVAL, 'PAT12345', 150.00, 'Mantenimiento', 'Mantenimientos Pro', 450.00, 5);
INSERT INTO Establecimiento_Local VALUES (seq_establecimiento.NEXTVAL, 'PAT12345', 150.00, 'Electricidad', 'Electricistas 24h', 350.00, 5);
INSERT INTO Establecimiento_Local VALUES (seq_establecimiento.NEXTVAL, 'PAT12345', 150.00, 'Fontanería', 'Fontaneros Rápidos', 280.00, 5);

-- Insertar datos en la tabla Evento
INSERT INTO Evento VALUES (seq_evento.NEXTVAL, 'Noche de Tapas', TO_DATE('15-06-2023', 'DD-MM-YYYY'), 'Degustación de tapas españolas', 30, 1, NULL, 1);
INSERT INTO Evento VALUES (seq_evento.NEXTVAL, 'Cata de Vinos', TO_DATE('22-06-2023', 'DD-MM-YYYY'), 'Cata de vinos regionales', 20, 1, NULL, 1);
INSERT INTO Evento VALUES (seq_evento.NEXTVAL, 'Cooking Class', TO_DATE('29-06-2023', 'DD-MM-YYYY'), 'Aprende a cocinar pasta fresca', 15, 1, NULL, 1);
INSERT INTO Evento VALUES (seq_evento.NEXTVAL, 'Brunch dominical', TO_DATE('25-06-2023', 'DD-MM-YYYY'), 'Brunch especial de domingo', 40, 1, NULL, 1);
INSERT INTO Evento VALUES (seq_evento.NEXTVAL, 'Cena maridaje', TO_DATE('08-07-2023', 'DD-MM-YYYY'), 'Cena con maridaje de vinos', 25, 1, NULL, 1);

-- Insertar datos en la tabla Campaña_Marketing
INSERT INTO Campania_Marketing VALUES (seq_campania.NEXTVAL, 'Verano Refrescante', TO_DATE('01-06-2023', 'DD-MM-YYYY'), TO_DATE('31-08-2023', 'DD-MM-YYYY'), 'Digital', 1200.00, 2.5, 1, NULL);
INSERT INTO Campania_Marketing VALUES (seq_campania.NEXTVAL, 'Happy Hour', TO_DATE('15-06-2023', 'DD-MM-YYYY'), TO_DATE('15-09-2023', 'DD-MM-YYYY'), 'Flyers', 800.00, 1.8, 2, NULL);
INSERT INTO Campania_Marketing VALUES (seq_campania.NEXTVAL, 'Menú Degustación', TO_DATE('01-07-2023', 'DD-MM-YYYY'), TO_DATE('31-07-2023', 'DD-MM-YYYY'), 'Radio', 1500.00, 2.1, 3, NULL);
INSERT INTO Campania_Marketing VALUES (seq_campania.NEXTVAL, 'Domingos en Familia', TO_DATE('01-06-2023', 'DD-MM-YYYY'), TO_DATE('31-12-2023', 'DD-MM-YYYY'), 'Prensa', 900.00, 1.9, 4, NULL);
INSERT INTO Campania_Marketing VALUES (seq_campania.NEXTVAL, 'Noches Gourmet', TO_DATE('15-07-2023', 'DD-MM-YYYY'), TO_DATE('15-08-2023', 'DD-MM-YYYY'), 'Digital', 1100.00, 2.2, 5, NULL);

-- Insertar datos en la tabla Publicidad_Social
INSERT INTO Publicidad_Social VALUES (seq_post.NEXTVAL, TO_DATE('05-06-2023', 'DD-MM-YYYY'), 'Instagram', '¡Este verano refréscate con nuestras nuevas bebidas!', 1, 1);
INSERT INTO Publicidad_Social VALUES (seq_post.NEXTVAL, TO_DATE('10-06-2023', 'DD-MM-YYYY'), 'Facebook', '¡Happy Hour todos los jueves! 2x1 en cócteles de 18h a 20h', 1, 2);
INSERT INTO Publicidad_Social VALUES (seq_post.NEXTVAL, TO_DATE('15-06-2023', 'DD-MM-YYYY'), 'Twitter', 'Prueba nuestro nuevo menú degustación. ¡Reserva ya!', 1, 3);
INSERT INTO Publicidad_Social VALUES (seq_post.NEXTVAL, TO_DATE('20-06-2023', 'DD-MM-YYYY'), 'Instagram', 'Los domingos son para compartir. Menú especial para familias', 0, 4);
INSERT INTO Publicidad_Social VALUES (seq_post.NEXTVAL, TO_DATE('25-06-2023', 'DD-MM-YYYY'), 'Facebook', 'Noches Gourmet todos los sábados de julio y agosto', 1, 5);

COMMIT; 