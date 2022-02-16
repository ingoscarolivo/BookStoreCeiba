/* Datos del Libro */
CREATE TABLE if not EXISTS libro (
id int(13) NOT NULL auto_increment,
titulo VARCHAR(60) NOT NULL,
unidades INT NOT NULL DEFAULT 0,
precio FLOAT DEFAULT 0,
PRIMARY KEY (id));

/* Datos del Venta */
CREATE TABLE if not EXISTS venta (
id int(13) NOT NULL auto_increment,
idLibro int(13) NOT NULL,
idUsuario int(11) NOT NULL,
unidad_venta INT NOT NULL DEFAULT 0,
precio_unidad FLOAT DEFAULT 0,
precio_venta FLOAT DEFAULT 0,
detalle_venta VARCHAR(50) NOT NULL,
fecha_venta datetime null,
PRIMARY KEY (id));
