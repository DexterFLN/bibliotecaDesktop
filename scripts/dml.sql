INSERT INTO BIBLIOTECA (nome) VALUES ('Atlas');
INSERT INTO BIBLIOTECA (nome) VALUES ('Pergamum');
INSERT INTO BIBLIOTECA (nome) VALUES ('Barca dos Livros');
INSERT INTO BIBLIOTECA (nome) VALUES ('Publica');
INSERT INTO BIBLIOTECA (nome) VALUES ('Arte e Cultura');
INSERT INTO BIBLIOTECA (nome) VALUES ('Universitaria');

INSERT INTO SESSAO (nome, idBiblioteca) VALUES ('Ficcao Cientifica', 1);
INSERT INTO SESSAO (nome, idBiblioteca) VALUES ('Romance', 2);
INSERT INTO SESSAO (nome, idBiblioteca) VALUES ('Adulto', 3);
INSERT INTO SESSAO (nome, idBiblioteca) VALUES ('Infantil', 4);
INSERT INTO SESSAO (nome, idBiblioteca) VALUES ('Terror', 5);
INSERT INTO SESSAO (nome, idBiblioteca) VALUES ('Suspense', 6);

INSERT INTO ENDERECO (rua, numeroRua, bairro, cidade, uf, cep) VALUES ('rua um', '1', 'bairro numero 1', 'cidade numero 1', '48', '11111111');
INSERT INTO ENDERECO (rua, numeroRua, bairro, cidade, uf, cep) VALUES ('rua dois', '2', 'bairro numero 2', 'cidade numero 2', '48', '22222222');
INSERT INTO ENDERECO (rua, numeroRua, bairro, cidade, uf, cep) VALUES ('rua tres', '3', 'bairro numero 3', 'cidade numero 3', '48', '33333333');
INSERT INTO ENDERECO (rua, numeroRua, bairro, cidade, uf, cep) VALUES ('rua quatro', '4', 'bairro numero 4', 'cidade numero 4', '48', '44444444');
INSERT INTO ENDERECO (rua, numeroRua, bairro, cidade, uf, cep) VALUES ('rua cinco', '5', 'bairro numero 5', 'cidade numero 5', '48', '55555555');
INSERT INTO ENDERECO (rua, numeroRua, bairro, cidade, uf, cep) VALUES ('rua seis', '6', 'bairro numero 6', 'cidade numero 6', '48', '66666666');

INSERT INTO LIVRO (idSessao, nome, autor, editora, edicao, ano) VALUES (1, 'livro um', 'autor um', 'editora um', 1, '2001');
INSERT INTO LIVRO (idSessao, nome, autor, editora, edicao, ano) VALUES (2, 'livro dois', 'autor dois', 'editora dois', 2, '2002');
INSERT INTO LIVRO (idSessao, nome, autor, editora, edicao, ano) VALUES (3, 'livro tres', 'autor tres', 'editora tres', 3, '2003');
INSERT INTO LIVRO (idSessao, nome, autor, editora, edicao, ano) VALUES (4, 'livro quatro', 'autor quatro', 'editora quatro',4, '2004');
INSERT INTO LIVRO (idSessao, nome, autor, editora, edicao, ano) VALUES (5, 'livro cinco', 'autor cinco', 'editora cinco', 5, '2005');
INSERT INTO LIVRO (idSessao, nome, autor, editora, edicao, ano) VALUES (6, 'livro seis', 'autor seis', 'editora seis', 6, '2006');

INSERT INTO EXEMPLAR VALUES (1, 1, 1);
INSERT INTO EXEMPLAR VALUES (2, 2, 1);
INSERT INTO EXEMPLAR VALUES (3, 3, 1);
INSERT INTO EXEMPLAR VALUES (4, 4, 1);
INSERT INTO EXEMPLAR VALUES (5, 5, 1);
INSERT INTO EXEMPLAR VALUES (6, 6, 1);

INSERT INTO USUARIO VALUES (1, 1, 1, 'Arthur', 'Martins', 1, '2000-07-20', '1@gmail.com', '48', '32238857', '12345678901');
INSERT INTO USUARIO VALUES (2, 2, 2, 'Adriano', 'Rossetto', 2, '1987-03-10', '2@gmail.com', '48', '32348857', '12345678902');
INSERT INTO USUARIO VALUES (3, 3, 3, 'Gustavo', 'Rodriguez', 3, '1998-02-20', '3@gmail.com', '48', '33348857', '12345678903');
INSERT INTO USUARIO VALUES (4, 4, 4, 'Vitor', 'Ribeiro', 4, '2000-05-12', '4@gmail.com', '48', '33058857', '12345678904');
INSERT INTO USUARIO VALUES (5, 5, 5, 'Nelio', 'Alves', 5, '1980-07-10', '5@gmail.com', '48', '33028123', '12345678905');
INSERT INTO USUARIO VALUES (6, 6, 6, 'Sandro', 'Machado', 6, '1996-02-22', '5@gmail.com', '48', '32045657', '12345678906');

INSERT INTO ALUGUEL (idExemplar, idUsuario, dataLocacao, devolucaoPrevista) VALUES (1, 1, '2020-03-04', '2020-03-15');
INSERT INTO ALUGUEL (idExemplar, idUsuario, dataLocacao, devolucaoPrevista) VALUES (2, 2, '2020-04-05', '2020-05-15');
INSERT INTO ALUGUEL (idExemplar, idUsuario, dataLocacao, devolucaoPrevista) VALUES (3, 3, '2020-05-04', '2020-06-15');
INSERT INTO ALUGUEL (idExemplar, idUsuario, dataLocacao, devolucaoPrevista, devolucaoEfetiva) VALUES (4, 4, '2020-02-04', '2020-03-15', '2020-03-15');
INSERT INTO ALUGUEL (idExemplar, idUsuario, dataLocacao, devolucaoPrevista, devolucaoEfetiva) VALUES (5, 5, '2020-01-04', '2020-02-15', '2020-02-15');
INSERT INTO ALUGUEL (idExemplar, idUsuario, dataLocacao, devolucaoPrevista, devolucaoEfetiva) VALUES (6, 6, '2020-07-04', '2020-08-15', '2020-08-15');