-- Schema: clickntick

-- DROP SCHEMA clickntick cascade;

CREATE SCHEMA clickntick
  AUTHORIZATION postgres;

set search_path to 'clickntick';

CREATE TABLE clientes (
	DNI varchar(10) NOT NULL,
	Usuario varchar(15) NOT NULL,
	Password varchar(10) NOT NULL,
	Puntos integer NOT NULL,
	Nombre varchar(30) NOT NULL,
	Apellido varchar(30) NOT NULL,
	Edad integer NOT NULL,
	Direccion varchar(50) NOT NULL,
	Poblacion varchar(50) NOT NULL,
	Provincia varchar(50) NOT NULL,
	CodPostal varchar(50) NOT NULL,
	Pais varchar(20) NOT NULL,
	Telefono integer NOT NULL,
	Email varchar(30) NOT NULL,
	PRIMARY KEY (DNI)
);

CREATE TABLE gestores (
	DNI varchar(10) NOT NULL,
	Nombre varchar(30) NOT NULL,
	Usuario varchar(15) NOT NULL,
	Password varchar(10) NOT NULL,
	PRIMARY KEY (DNI)
);

CREATE TABLE eventos (
	IDEvento SERIAL,
	NombreEvento varchar(30) NOT NULL,
	TipoEvento varchar(20) NOT NULL,
	Locales varchar(20) NOT NULL,
	Ciudad varchar(20) NOT NULL,
	NumEntradas integer NOT NULL,
	EntradasReservadas integer default NULL,
	Descripcion varchar(100) default NULL,
	Precio integer NOT NULL,
	Fecha date NOT NULL,
	DiaSemana varchar(15) NOT NULL,
	Hora varchar(20) NOT NULL,
	PRIMARY KEY (IDEvento)
);

CREATE TABLE ofertas (
	IDOfertas SERIAL,
	Puntos integer NOT NULL,
	Descripcion varchar(30) NOT NULL,
	Descuento decimal DEFAULT NULL,
	PRIMARY KEY (IDOfertas)
);

CREATE TABLE compras (
	IDCompra SERIAL,
	NombreEvento varchar(30) NOT NULL,
	DNI varchar(10) NULL,
	NumTarjeta varchar(20) NOT NULL,
	FormaPago varchar(20) NOT NULL,
	NumEntradas integer NOT NULL,
	PRIMARY KEY (IDCompra),
	CONSTRAINT compra_DNI_FK FOREIGN KEY (DNI) REFERENCES clientes (DNI)
);

--Añadiendo eventos
INSERT INTO clickntick.eventos (nombreevento, tipoevento, locales, ciudad, numentradas, entradasreservadas, descripcion, precio, fecha, diasemana, hora) VALUES ('Julio Iglesias','Concierto','Las Ventas','Madrid',600,0,'Julio Iglesias en Madrid, y lo sabes',30,'2015-07-11','Sábado','21:00');
INSERT INTO clickntick.eventos (nombreevento, tipoevento, locales, ciudad, numentradas, entradasreservadas, descripcion, precio, fecha, diasemana, hora) VALUES ('Gigatrón','Concierto','Rock City','Valencia',50,0,'Metal in your body',10,'2015-03-10','Sábado','22:00');
INSERT INTO clickntick.eventos (nombreevento, tipoevento, locales, ciudad, numentradas, entradasreservadas, descripcion, precio, fecha, diasemana, hora) VALUES ('Leyendas del Rock','Festival','Villena','Alicante',600,0,'Festival de rock con muchos grupos, como siempre, Rosendo asistirá',66,'2015-11-10','Jueves','08:00');
INSERT INTO clickntick.eventos (nombreevento, tipoevento, locales, ciudad, numentradas, entradasreservadas, descripcion, precio, fecha, diasemana, hora) VALUES ('El barbero de Sevilla','Opera','Teatro Real','Madrid',100,0,'Ver gente cantando es divertido',45,'2015-12-06','Martes','21:00');

--Añadiendo gestores
INSERT INTO clickntick.gestores VALUES ('36521452X', 'Paco', 'admin', 123);

--Añadiendo clientes
INSERT INTO clickntick.clientes VALUES ('23632143Z', 'hejuso', 123, 10, 'Hector', 'Juan Soria', 21, 'C/ Falsa 123', 'Alzira', 'Valencia', 46600, 'España', 66666666, 'hector151293@gmail.com');
INSERT INTO clickntick.clientes VALUES ('32145235V', 'mmarin', 123, 0, 'Miquel', 'Marin', 20, 'C/ Falsa 124', 'Sumacarcer', 'Valencia', 46623, 'España', 66666665, 'mmarin@gmail.com');
INSERT INTO clickntick.clientes VALUES ('12355333G', 'boribes', 123, 60, 'Borja', 'Ribes', 22, 'C/ Falsa 134', 'Carcaixent', 'Valencia', 46223, 'España', 63666665, 'boribes@gmail.com');

--Añadiendo ofertas
INSERT INTO clickntick.ofertas VALUES (1,20,'Gran descuento',10);
INSERT INTO clickntick.ofertas VALUES (2,30,'Gran descuento 2',20);
INSERT INTO clickntick.ofertas VALUES (3,40,'Gran descuento 3',50);