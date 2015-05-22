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
	Precio decimal NOT NULL,
	Fecha date NOT NULL,
	DiaSemana varchar(15) NOT NULL,
	Hora varchar(20) NOT NULL,
	PRIMARY KEY (IDEvento)
);

CREATE TABLE entrada (
	IDEntrada integer NOT NULL,
	IDEvento integer NOT NULL,
	DNI varchar(10) NOT NULL,
	NombreEvento varchar(30) NOT NULL,
	Informacion varchar(300) DEFAULT NULL,
	TipoEntrada varchar(30) NOT NULL,
	Precio decimal NOT NULL,
	DatosClientes varchar(250) DEFAULT NULL,
	PRIMARY KEY (IDEntrada),
	CONSTRAINT entrada_IDEVENTO_FK FOREIGN KEY (IDEvento) REFERENCES eventos (IDEvento),
	CONSTRAINT entrada_DNI_FK FOREIGN KEY (DNI) REFERENCES clientes (DNI)
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
	PRIMARY KEY (IDCompra)
);
