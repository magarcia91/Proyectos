CREATE TABLE email1 (id BIGINT PRIMARY KEY AUTO_INCREMENT,
    to VARCHAR(30), email VARCHAR(30), nombre VARCHAR(30), mensaje VARCHAR(30));
    
CREATE TABLE usuario (idUsuario BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30), password VARCHAR(100), enabled boolean);

CREATE TABLE rol (idRol BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30), descripcion VARCHAR(30));



    
