
CREATE DATABASE BDPRODUCCION;
USE BDPRODUCCION;

CREATE TABLE Empleado
(
	Cod_Empleado		CHAR(5)		NOT NULL,
    Des_Nombre			VARCHAR(20)	NOT NULL,
    Des_Apellido_Pat	VARCHAR(15)	NOT NULL,
    Des_Apellido_Mat	VARCHAR(15)	NOT NULL,
    Fecha_Nacimiento	DATE		NULL,
    Sexo				CHAR(1)		NOT NULL,
    Cod_Usuario			CHAR(5)		NULL
);

CREATE TABLE Usuario
(
	Cod_Usuario			CHAR(5)		NOT NULL,
    Nom_Usuario			VARCHAR(15)	NOT NULL,
    Pass_Usuario		VARCHAR(20)	NOT NULL,
    Tipo_Usuario		CHAR(1)		NOT NULL
);

CREATE TABLE Cliente
(
	Cod_Cliente			CHAR(6)		NOT NULL,
    Des_Nombre			VARCHAR(30)	NOT NULL,
    Cod_rubro			CHAR(3)		NOT NULL,
    Telefono			VARCHAR(15)	NOT NULL,
    Correo				VARCHAR(60)	NULL
);

CREATE TABLE Rubro
(
	Cod_Rubro			CHAR(3)		NOT NULL,
    Des_Nombre			VARCHAR(20)	NOT NULL
);

CREATE TABLE Actividad
(
	Cod_Actividad		CHAR(5)		NOT NULL,
    Cod_Empleado		CHAR(5)		NOT NULL,
    Cod_Cliente			CHAR(6)		NOT NULL,
    Fecha_Registro		DATETIME	NOT NULL,
    Estado				VARCHAR(20)	NOT NULL
);

CREATE TABLE Detalle_Actividad
(
	Cod_Det_Actividad	CHAR(6)		NOT NULL,
    Cod_Actividad		CHAR(5)		NOT NULL,
    Cod_Servicio		CHAR(3)		NOT NULL,
    Cod_Tipo_Com		CHAR(3)		NOT NULL,
    Nivel_Interes		VARCHAR(15)	NOT NULL,
    Fecha_Actividad		DATETIME	NOT NULL
);

CREATE TABLE Servicio
(
	Cod_Servicio		CHAR(3)		NOT NULL,
    Des_Nombre			VARCHAR(25)	NOT NULL
);

CREATE TABLE Tipo_Comunicacion
(
	Cod_Tipo_Com		CHAR(3)		NOT NULL,
    Des_Nombre			VARCHAR(20)	NOT NULL
);

/* PRIMARY KEY*/ 

ALTER TABLE Empleado
  ADD CONSTRAINT PK_Empleado
  PRIMARY KEY (Cod_Empleado);

ALTER TABLE Usuario
  ADD CONSTRAINT PK_Usuario
  PRIMARY KEY (Cod_Usuario);
  
ALTER TABLE Cliente
  ADD CONSTRAINT PK_Cliente
  PRIMARY KEY (Cod_Cliente);
  
ALTER TABLE Rubro
  ADD CONSTRAINT PK_Rubro
  PRIMARY KEY (Cod_Rubro);
  
ALTER TABLE Actividad
  ADD CONSTRAINT PK_Actividad
  PRIMARY KEY (Cod_Actividad);

ALTER TABLE Detalle_Actividad
  ADD CONSTRAINT PK_Detalle_Actividad
  PRIMARY KEY (Cod_Det_Actividad);

ALTER TABLE Servicio
  ADD CONSTRAINT PK_Servicio
  PRIMARY KEY (Cod_Servicio);

ALTER TABLE Tipo_Comunicacion
  ADD CONSTRAINT PK_Tipo_Comunicacion
  PRIMARY KEY (Cod_Tipo_Com);
  
/*FOREIGN KEY*/

ALTER TABLE Empleado
  ADD CONSTRAINT FK_Empleado_Usuario
  FOREIGN KEY (Cod_Usuario)
  REFERENCES Usuario (Cod_Usuario);

ALTER TABLE Cliente
  ADD CONSTRAINT FK_Cliente_Rubro
  FOREIGN KEY (Cod_Rubro)
  REFERENCES Rubro (Cod_Rubro);

ALTER TABLE Actividad
  ADD CONSTRAINT FK_Actividad_Empleado
  FOREIGN KEY (Cod_Empleado)
  REFERENCES Empleado (Cod_Empleado);

ALTER TABLE Actividad
  ADD CONSTRAINT FK_Actividad_Cliente
  FOREIGN KEY (Cod_Cliente)
  REFERENCES Cliente (Cod_Cliente);

ALTER TABLE Detalle_Actividad
  ADD CONSTRAINT FK_Detalle_Actividad_Actividad
  FOREIGN KEY (Cod_Actividad)
  REFERENCES Actividad (Cod_Actividad);

ALTER TABLE Detalle_Actividad
  ADD CONSTRAINT FK_Detalle_Actividad_Servicio
  FOREIGN KEY (Cod_Servicio)
  REFERENCES Servicio (Cod_Servicio);

ALTER TABLE Detalle_Actividad
  ADD CONSTRAINT FK_Detalle_Actividad_Tipo_Comunicacion
  FOREIGN KEY (Cod_Tipo_Com)
  REFERENCES Tipo_Comunicacion (Cod_Tipo_Com);
  
/*INSERTS*/

INSERT INTO Usuario VALUES			 ('U0001', 'kunars', 'kusankill14', 'A'),
									 ('U0002', 'aaron', '123456', 'U'),
									 ('U0003', 'crhistian', '123456', 'U'),
									 ('U0004', 'nicoll', '123456', 'U');

INSERT INTO Empleado VALUES 		 ('E0001', 'Lucho', 'Morales', 'Segovia', '1997-06-09', 'M', 'U0001'),
									 ('E0002', 'Aaron', 'Quiroz', 'Hostia', '1997-06-09', 'F', 'U0002'),
									 ('E0003', 'Crhistian', 'Huaynate', 'Frias', '1997-06-09', 'F', 'U0003'),
									 ('E0004', 'Nicolle', 'Ferro', 'Bernardo', '1997-06-09', 'F', 'U0004');

INSERT INTO Rubro VALUES			 ('R01', 'Tecnología'),
									 ('R02', 'Educación'),
									 ('R03', 'Alimentos'),
									 ('R04', 'Moda Textil'),
									 ('R05', 'Industrias'),
									 ('R06', 'Deportes'),
									 ('R07', 'Arte'),
									 ('R08', 'Comunicaciones'),
									 ('R09', 'Otros');

INSERT INTO Cliente VALUES			 ('C00001', 'Claro', 'R01', '+51 5689124', 'claro@gmail.com'),
									 ('C00002', 'Movistar', 'R01', '+51 5689124', 'movistar@gmail.com'),
									 ('C00003', 'KFC', 'R03', '+51 5689124', 'kfc@gmail.com'),
									 ('C00004', 'UTP', 'R02', '+51 5689124', 'utp@gmail.com'),
									 ('C00005', 'asa', 'R02', '+51 5689124', 'sp@gmail.com');
	
INSERT INTO Actividad VALUES 		 ('A0001', 'E0001', 'C00001', '2016-10-28 00:00:00', 'asdasd'),
									 ('A0002', 'E0002', 'C00002', '2016-10-27 00:00:00', 'asdasd'),
									 ('A0003', 'E0003', 'C00003', '2016-10-26 00:00:00', 'asdasd'),
									 ('A0004', 'E0004', 'C00004', '2016-10-25 00:00:00', 'asdasd'),
									 ('A0005', 'E0001', 'C00005', '2016-10-29 00:00:00', 'asdasd');

INSERT INTO Servicio VALUES 		 ('S01', 'Activaciones BTL'),
									 ('S02', 'Realizacióde video'),
									 ('S03', 'Merchandising'),
									 ('S04', 'Grabaciones'),
									 ('S05', 'Otros');

INSERT INTO Tipo_Comunicacion VALUES ('T01', 'Fono fijo'),
									 ('T02', 'Celular'),
									 ('T03', 'Whatsapp'),
									 ('T04', 'Correo'),
									 ('T05', 'Personal'),
									 ('T06', 'Redes Sociales');

INSERT INTO Detalle_Actividad VALUES ('D00001', 'A0001', 'S01', 'T01', 'Muy interesado', '2016-10-28 00:00:00'),
									 ('D00002', 'A0001', 'S03', 'T04', 'Muy interesado', '2016-10-29 00:00:00'),
									 ('D00003', 'A0002', 'S04', 'T05', 'Regular', '2016-10-27 00:00:00'),
									 ('D00004', 'A0003', 'S05', 'T06', 'Regular', '2016-10-26 00:00:00'),
									 ('D00005', 'A0005', 'S05', 'T06', 'Regular', '2016-10-29 00:00:00');
  