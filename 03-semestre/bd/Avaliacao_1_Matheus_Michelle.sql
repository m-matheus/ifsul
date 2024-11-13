CREATE database avaliacao_1;

USE avaliacao_1;

-- Criação da Tabela de Livros
CREATE TABLE Livros (
    ISBN VARCHAR(13) PRIMARY KEY,
    Titulo VARCHAR(100),
    Autor VARCHAR(50),
    Genero VARCHAR(50),
    AnoPublicacao INT,
    Preco DECIMAL(10,2),
    QuantidadeEstoque INT
    -- EditoraID INT,
    -- FOREIGN KEY (EditoraID) REFERENCES Editoras(EditoraID)
);

-- Alterando a tabela Livros
ALTER TABLE Livros ADD column EditoraID INT;
ALTER TABLE Livros ADD foreign key (EditoraID) REFERENCES Editoras(EditoraID);

-- Adicionando dados na tabela Livros
INSERT INTO Livros VALUES ('1', 'Guerra dos Tronos', 'George R. R. Martin', 'Ficção', 1996, 100.0, 1000, 2);

-- Atualizando valor da promo $$
UPDATE Livros SET Preco=89 WHERE ISBN='1'; 

-- Criação da Tabela de Usuários
CREATE TABLE Usuarios (
    UserID INT PRIMARY KEY,
    Nome VARCHAR(50),
    Email VARCHAR(100),
    DataNascimento DATE,
    Cidade VARCHAR(50),
    Estado VARCHAR(2),
    CEP VARCHAR(9)
    -- CidadeID INT,
    -- EstadoID INT,
    -- FOREIGN KEY (CidadeID) REFERENCES Cidade(CidadeID),
    -- FOREIGN KEY (EstadoID) REFERENCES Estado(EstadoID)
);

-- Alterando a tabela Usuários
ALTER TABLE Usuarios ADD column CidadeID INT;
ALTER TABLE Usuarios ADD column EstadoID INT;
ALTER TABLE Usuarios ADD foreign key (CidadeID) REFERENCES Cidade(CidadeID);
ALTER TABLE Usuarios ADD foreign key (EstadoID) REFERENCES Estado(EstadoID);

-- Adicionando dados na tabela Usuários
INSERT INTO Usuarios VALUES (1, 'Michelle', 'michelle@gmail.com', '2002-03-15', 'Sapucaia do Sul', 'RS', '93218-200', '1', '1');
INSERT INTO Usuarios VALUES (2, 'Matheus', 'matheus@gmail.com', '1999-09-16', 'Sapucaia do Sul', 'RS', '93218-200', '1', '1');
INSERT INTO Usuarios VALUES (3, 'Vitor', 'vitor@gmail.com', '2005-08-11', 'Sapucaia do Sul', 'RS', '93218-200', '1', '1');

-- Deletando Usuário e tudo relacionado a ele
DELETE FROM Compras WHERE UserID=1;
DELETE FROM Avaliacoes WHERE UserID=1;
DELETE FROM Usuarios WHERE UserID=1;

-- Criação da Tabela de Compras
CREATE TABLE Compras (
    CompraID INT PRIMARY KEY,
    UserID INT,
    ISBN VARCHAR(13),
    DataCompra DATE,
    Quantidade INT,
    ValorTotal DECIMAL(10,2),
    FOREIGN KEY (UserID) REFERENCES Usuarios(UserID),
    FOREIGN KEY (ISBN) REFERENCES Livros(ISBN)
);

-- Adicionando compras
INSERT INTO Compras VALUES (1, 2, 1, '2024-04-12', 2, 160);

-- Criação da Tabela de Avaliações
CREATE TABLE Avaliacoes (
    AvaliacaoID INT PRIMARY KEY,
    UserID INT,
    ISBN VARCHAR(13),
    Avaliacao INT,
    Comentario TEXT,
    FOREIGN KEY (UserID) REFERENCES Usuarios(UserID),
    FOREIGN KEY (ISBN) REFERENCES Livros(ISBN)
);

-- Adicionando avaliações
INSERT INTO Avaliacoes VALUES (1, 2, 1, 10, 'Muito bom!');

-- Criação da Tabela de Editoras
CREATE TABLE Editoras (
    EditoraID INT PRIMARY KEY,
	Nome VARCHAR(255),
    PaisOrigem VARCHAR(255)
);

-- Adicionando dados na tabela Editoras
INSERT INTO Editoras VALUES (1, 'Grupo Planeta', 'Espanha'), (2, 'LeYa', 'Brasil'), (3, 'Wish', 'Brasil'), (4, 'Rocco', 'Brasil'), (5, 'Draco', 'Brasil');

-- Criação da Tabela de Autores
CREATE TABLE Autores (
	AutorID INT PRIMARY KEY,
	Nome VARCHAR(255),
    Nacionalidade VARCHAR(255)
);

-- Adicionando dados na tabela Autores
INSERT INTO Autores VALUES (1, 'Sylvie Baussie', 'Brasileira'), (2, 'George R. R. Martin', 'Americano'), (3, 'Peter Christen Asbjornsen', 'Norueguês'), (4, 'J. K. Rowling', 'Britânica'), (5, 'Vilto Reis', 'Brasileiro');

-- Criação da Tabela de relações entre Livros e Autores
CREATE TABLE Livros_Autores(
ISBN VARCHAR(13),
AutorID INT,
PRIMARY KEY (ISBN, AutorID),
FOREIGN KEY (ISBN) REFERENCES Livros(ISBN),
FOREIGN KEY (AutorID) REFERENCES Autores(AutorID)
);

-- Criação da Tabela de Cidade
CREATE TABLE Cidade (
	CidadeID INT PRIMARY KEY,
	Nome VARCHAR(255)
);

-- Adicionando dados na tabela Cidade
INSERT INTO Cidade VALUES (1, 'Sapucaia do Sul'), (2, 'Campina'), (3, 'Niterói'), (4, 'Penha'), (5, 'Betim');

-- Criação da Tabela de Estado
CREATE TABLE Estado (
	EstadoID INT PRIMARY KEY,
	Sigla VARCHAR(255)
);

-- Adicionando dados na tabela Estados
INSERT INTO Estado VALUES (1, 'RS'), (2, 'SP'), (3, 'RJ'), (4, 'SC'), (5, 'MG');

-- Seleções
-- Selecionando todos livros da editora 2
SELECT * FROM Livros WHERE EditoraID = 2;

-- Atualizando o status da compra
ALTER TABLE Compras ADD COLUMN Status VARCHAR(255) DEFAULT 'Pendente';
UPDATE Compras SET Status = 'Concluída' WHERE CompraID = 2;

-- Selecionando todas avaliações de livros e ordenando pela data de publicação
SELECT Avaliacoes.*, Livros.AnoPublicacao FROM Avaliacoes JOIN Livros ON Avaliacoes.ISBN = Livros.ISBN WHERE Avaliacoes.ISBN = 1 ORDER BY Livros.AnoPublicacao;

-- Deletando todas compras pendentes de um usuário
DELETE FROM Compras WHERE UserID = 1 AND Status='Pendente';

-- Selecionando todos usuários que moram em uma cidade x e estado x
SELECT * FROM Usuarios WHERE CidadeID = 1 AND EstadoID = 1;