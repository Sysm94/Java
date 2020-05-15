create database Usuarios;

use Usuarios;

CREATE TABLE usuario (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(20) not null,
    senha varchar(50)not null,
    usuario varchar(20)not null
);

insert into usuario (nome,senha,usuario) values ("Felipe",'9535a859317ba7022b299b38f8ea4fb0','Fe94');
