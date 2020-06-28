<<<<<<< HEAD:CREATE-DATABASE.sql
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
    numeroRua INT NOT NULL,
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

-- BIBLIOTECA, SESSAO, ENDERECO, LIVRO, EXEMPLAR, USUARIO, ALUGUEL

=======
>>>>>>> c3509e45ed61b286af1b45c983664e74ec2ff6ae:scripts/dml.sql
INSERT INTO BIBLIOTECA (nome) VALUES ('Atlas');
INSERT INTO BIBLIOTECA (nome) VALUES ('Pergamum');
INSERT INTO BIBLIOTECA (nome) VALUES ('Barca dos Livros');
INSERT INTO BIBLIOTECA (nome) VALUES ('Pública');
INSERT INTO BIBLIOTECA (nome) VALUES ('Arte e Cultura');
INSERT INTO BIBLIOTECA (nome) VALUES ('Universitária');

INSERT INTO SESSAO (nome, idBiblioteca) VALUES ('Ficção Ciêntífica', 1);
INSERT INTO SESSAO (nome, idBiblioteca) VALUES ('Romance', 2);
INSERT INTO SESSAO (nome, idBiblioteca) VALUES ('Adulto', 3);
INSERT INTO SESSAO (nome, idBiblioteca) VALUES ('Infantil', 4);
INSERT INTO SESSAO (nome, idBiblioteca) VALUES ('Terror', 5);
INSERT INTO SESSAO (nome, idBiblioteca) VALUES ('Suspense', 6);

INSERT INTO ENDERECO (rua, numeroRua, bairro, cidade, uf, cep) VALUES ('rua um', 1, 'bairro numero 1', 'cidade numero 1', '48', '11111111');
INSERT INTO ENDERECO (rua, numeroRua, bairro, cidade, uf, cep) VALUES ('rua dois', 2, 'bairro numero 2', 'cidade numero 2', '48', '22222222');
INSERT INTO ENDERECO (rua, numeroRua, bairro, cidade, uf, cep) VALUES ('rua três', 3, 'bairro numero 3', 'cidade numero 3', '48', '33333333');
INSERT INTO ENDERECO (rua, numeroRua, bairro, cidade, uf, cep) VALUES ('rua quatro', 4, 'bairro numero 4', 'cidade numero 4', '48', '44444444');
INSERT INTO ENDERECO (rua, numeroRua, bairro, cidade, uf, cep) VALUES ('rua cinco', 5, 'bairro numero 5', 'cidade numero 5', '48', '55555555');
INSERT INTO ENDERECO (rua, numeroRua, bairro, cidade, uf, cep) VALUES ('rua seis', 6, 'bairro numero 6', 'cidade numero 6', '48', '66666666');

INSERT INTO LIVRO (idSessao, nome, autor, editora, edicao, ano) VALUES (1, 'livro um', 'autor um', 'editora um', 1, '2001');
INSERT INTO LIVRO (idSessao, nome, autor, editora, edicao, ano) VALUES (2, 'livro dois', 'autor dois', 'editora dois', 2, '2002');
INSERT INTO LIVRO (idSessao, nome, autor, editora, edicao, ano) VALUES (3, 'livro três', 'autor três', 'editora três', 3, '2003');
INSERT INTO LIVRO (idSessao, nome, autor, editora, edicao, ano) VALUES (4, 'livro quatro', 'autor quatro', 'editora quatro',4, '2004');
INSERT INTO LIVRO (idSessao, nome, autor, editora, edicao, ano) VALUES (5, 'livro cinco', 'autor cinco', 'editora cinco', 5, '2005');
INSERT INTO LIVRO (idSessao, nome, autor, editora, edicao, ano) VALUES (6, 'livro seis', 'autor seis', 'editora seis', 6, '2006');

INSERT INTO EXEMPLAR VALUES (1, 1, 1);
INSERT INTO EXEMPLAR VALUES (2, 2, 1);
INSERT INTO EXEMPLAR VALUES (3, 3, 1);
INSERT INTO EXEMPLAR VALUES (4, 4, 1);
INSERT INTO EXEMPLAR VALUES (5, 5, 1);
INSERT INTO EXEMPLAR VALUES (6, 6, 1);

INSERT INTO USUARIO VALUES (1, 1, 1, 'Arthur', 'Martins', 1, '2000-07-20', '1@gmail.com', '48', '32238857');
INSERT INTO USUARIO VALUES (2, 2, 2, 'Adriano', 'Rossetto', 2, '1987-03-10', '2@gmail.com', '48', '32348857');
INSERT INTO USUARIO VALUES (3, 3, 3, 'Gustavo', 'Rodriguez', 3, '1998-02-20', '3@gmail.com', '48', '33348857');
INSERT INTO USUARIO VALUES (4, 4, 4, 'Vitor', 'Ribeiro', 4, '2000-05-12', '4@gmail.com', '48', '33058857');
INSERT INTO USUARIO VALUES (5, 5, 5, 'Nélio', 'Alves', 5, '1980-07-10', '5@gmail.com', '48', '33028123');
INSERT INTO USUARIO VALUES (6, 6, 6, 'Sandro', 'Machado', 6, '1996-02-22', '5@gmail.com', '48', '32045657');

INSERT INTO ALUGUEL (idExemplar, idUsuario, dataLocacao, devolucaoPrevista) VALUES (1, 1, '2020-03-04', '2020-03-15');
INSERT INTO ALUGUEL (idExemplar, idUsuario, dataLocacao, devolucaoPrevista) VALUES (2, 2, '2020-04-05', '2020-05-15');
INSERT INTO ALUGUEL (idExemplar, idUsuario, dataLocacao, devolucaoPrevista) VALUES (3, 3, '2020-05-04', '2020-06-15');
INSERT INTO ALUGUEL (idExemplar, idUsuario, dataLocacao, devolucaoPrevista, devolucaoEfetiva) VALUES (4, 4, '2020-02-04', '2020-03-15', '2020-03-15');
INSERT INTO ALUGUEL (idExemplar, idUsuario, dataLocacao, devolucaoPrevista, devolucaoEfetiva) VALUES (5, 5, '2020-01-04', '2020-02-15', '2020-02-15');
INSERT INTO ALUGUEL (idExemplar, idUsuario, dataLocacao, devolucaoPrevista, devolucaoEfetiva) VALUES (6, 6, '2020-07-04', '2020-08-15', '2020-08-15');