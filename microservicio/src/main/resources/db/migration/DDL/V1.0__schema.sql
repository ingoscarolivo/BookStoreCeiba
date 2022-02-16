create table if not EXISTS usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 email varchar(100) not null,
 fecha_creacion datetime null,
 primary key (id)
);