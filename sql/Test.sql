CREATE DATABASE `TEST`;
use TEST;

CREATE TABLE `TBL_ROL` (
`ROL` varchar(45) NOT NULL,
`DESCRIPCION` varchar(45) DEFAULT NULL,
PRIMARY KEY (`ROL`)
)

create table alumno(
id int primary key auto_increment,
nombre varchar(20),
edad int
);

select avg(edad) from alumno;
select count(id) from alumno;

SELECT nombre, edad FROM usuarios WHERE id = ?;

ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;