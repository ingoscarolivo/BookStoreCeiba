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
unidad_Venta INT NOT NULL DEFAULT 0,
precio_Unidad FLOAT DEFAULT 0,
precio_Venta FLOAT DEFAULT 0,
fecha_Venta datetime null,
PRIMARY KEY (id));
