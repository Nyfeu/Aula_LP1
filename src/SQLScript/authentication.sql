create database login_senha;

use login_senha;

create table usuario(
    nome VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL,
    senha_hash VARCHAR(128) NOT NULL,
    primary key(email)
);

create table notas(
    email VARCHAR(60) NOT NULL,
    nota FLOAT(4, 2) UNSIGNED
);

create table faltas(
    email VARCHAR(60) NOT NULL UNIQUE,
    quantidade SMALLINT UNSIGNED NOT NULL
);