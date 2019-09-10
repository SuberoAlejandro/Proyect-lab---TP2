# Proyect-lab---TP2
Seleccion de jugadores WeB

Seleccionado Argentino de Basquetbol.

Selección de los jugadores que integraran el Seleccionado Nacional de Basquetbol.

El proyecto requiere de una base de datos en MySQL a continuación se dan las características:

Nombre de la base de datos: seleccion
Tablas que debe de contener: tabla para usuarios ("register") y tabla para la carga de jugadores ("Jugadores").

Para tal fin a continuación se facilita el Query para la creación de las tablas:

1) create database  seleccion;

2) use database seleccion;

3) CREATE TABLE `seleccion`.`register` ( `id` INT NOT NULL AUTO_INCREMENT,`email` VARCHAR(45) NOT NULL,`password` VARCHAR(45) NOT NULL, 
`tipo` VARCHAR(45) NOT NULL,  PRIMARY KEY (`id`));

4) CREATE TABLE `seleccion`.`Jugadores` (`id` INT NOT NULL AUTO_INCREMENT,`nombre` VARCHAR(45) NOT NULL,`apellido` VARCHAR(45) NOT NULL,`edad` INT NOT NULL,
  `peso` DOUBLE NOT NULL,  `altura` DOUBLE NOT NULL,  `posicion` VARCHAR(45) NOT NULL,  `calificacion` INT NOT NULL,  PRIMARY KEY (`id`));

NOTA: se recomienda tener la base de datos en el horario del país donde se almacena los datos, para evitar que le de algún tipo de error, para ello puede usar el Query para argentina (SET global time_zone ='-3:00';).

