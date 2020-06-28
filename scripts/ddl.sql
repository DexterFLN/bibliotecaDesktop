DROP DATABASE IF EXISTS ATLAS;
CREATE DATABASE ATLAS;
USE ATLAS;

CREATE TABLE BIBLIOTECA (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(40) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE SESSAO (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(40) NOT NULL,
    idBiblioteca INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(idBiblioteca) REFERENCES BIBLIOTECA(ID)
);

CREATE TABLE ENDERECO (
	id INT NOT NULL AUTO_INCREMENT,
	rua VARCHAR(40) NOT NULL,
    numeroRua VARCHAR(15) NOT NULL,
    bairro VARCHAR(25) NOT NULL,
    cidade VARCHAR(20) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    cep VARCHAR(8) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE LIVRO (
    id INT NOT NULL AUTO_INCREMENT,
    idSessao INT NOT NULL,
    nome VARCHAR(40) NOT NULL,
    autor VARCHAR(40) NOT NULL,
    editora VARCHAR(30) NOT NULL,
    edicao INT NOT NULL,
    ano INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(idSessao) REFERENCES SESSAO(id)
);

CREATE TABLE EXEMPLAR (
    id INT NOT NULL AUTO_INCREMENT,
    idLivro INT NOT NULL,
    status boolean,
    PRIMARY KEY(id, idLivro),
    FOREIGN KEY(idLivro) REFERENCES LIVRO(id)
);

CREATE TABLE USUARIO (
    id INT NOT NULL AUTO_INCREMENT,
    idBiblioteca INT NOT NULL,
    idEndereco INT NOT NULL,
    nome VARCHAR(30) NOT NULL,
    sobrenome VARCHAR(40) NOT NULL,
    tipo INT NOT NULL,
    dataNascimento DATE NOT NULL,
    email VARCHAR(40) NOT NULL,
    ddd VARCHAR(2),
    fone VARCHAR(8),
    cpf VARCHAR(11) UNIQUE NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(idBiblioteca) REFERENCES BIBLIOTECA(id),
    FOREIGN KEY(idEndereco) REFERENCES ENDERECO(id)
);

CREATE TABLE ALUGUEL (
    id INT NOT NULL AUTO_INCREMENT,
    idExemplar INT NOT NULL,
    idUsuario INT NOT NULL,
    dataLocacao DATE NOT NULL,
    devolucaoPrevista DATE NOT NULL,
    devolucaoEfetiva DATE,
    PRIMARY KEY(id),
    FOREIGN KEY (idUsuario) REFERENCES USUARIO(id),
    FOREIGN KEY (idExemplar) REFERENCES EXEMPLAR(id)
);