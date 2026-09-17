CREATE DATABASE `TEST`;
use TEST;

CREATE TABLE `TBL_ROL` (
                           `ROL` varchar(45) NOT NULL,
                           `DESCRIPCION` varchar(45) DEFAULT NULL,
                           PRIMARY KEY (`ROL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;