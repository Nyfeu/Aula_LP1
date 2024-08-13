create database authentication;
use authentication;
create table usuario(
    nome VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL,
    senha_hash VARCHAR(128) NOT NULL,
    primary key(email)
);