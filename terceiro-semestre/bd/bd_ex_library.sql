CREATE DATABASE library;

USE library;

-- Criação da tabela Livros
CREATE TABLE Livros (
    id_livro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    ano_publicacao INT NOT NULL
);

-- Criação da tabela Emprestimos
CREATE TABLE Emprestimos (
    id_emprestimo INT AUTO_INCREMENT PRIMARY KEY,
    id_livro INT,
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE,
    FOREIGN KEY (id_livro) REFERENCES Livros(id_livro)
);

-- Alguns dados para a tabela Livros
INSERT INTO Livros (titulo, autor, ano_publicacao) VALUES
('1984', 'George Orwell', 1949),
('O Senhor dos Anéis', 'J.R.R. Tolkien', 1954),
('Dom Casmurro', 'Machado de Assis', 1899),
('O Guia do Mochileiro das Galáxias', 'Douglas Adams', 1979),
('A Revolução dos Bichos', 'George Orwell', 1945);

-- Alguns dados para a tabela Emprestimos
INSERT INTO Emprestimos (id_livro, data_emprestimo, data_devolucao) VALUES
(1, '2024-01-10', '2024-02-10'),
(2, '2024-01-15', '2024-02-15'),
(1, '2024-02-20', NULL),
(3, '2024-03-01', '2024-03-15'),
(4, '2024-04-01', NULL),
(5, '2024-05-01', '2024-05-15'),
(2, '2024-06-01', '2024-06-15');

-- Titulo e data de emprestimo de todos emprestimos realizados
SELECT l.titulo, e.data_emprestimo FROM Emprestimos e JOIN Livros l ON e.id_livro = l.id_livro;

-- Devido a todos livros estarem emprestados, removi o emprestimo do 1 para poder visualizar melhor o resultado da questão
DELETE FROM emprestimos WHERE (id_livro = '1');
-- Titulo dos que ainda nao foram emprestados
SELECT l.titulo FROM Livros l LEFT JOIN Emprestimos e ON l.id_livro = e.id_livro WHERE e.id_livro IS NULL;

-- Titulo dos livros que foram emprestamos mais de uma vez e o numero de vezes que foram emprestados
SELECT l.titulo, COUNT(e.id_livro) AS total_emprestimos FROM Livros l JOIN Emprestimos e ON l.id_livro = e.id_livro GROUP BY l.titulo HAVING COUNT(e.id_livro) > 1;

-- Titulo dos livros que foram emprestados em determinado margem de data com a data do emprestimos
SELECT l.titulo, e.data_emprestimo FROM Livros l JOIN Emprestimos e ON l.id_livro = e.id_livro WHERE e.data_emprestimo BETWEEN '2024-01-09' AND '2024-03-10';

-- Titulo dos livros que estao atualmente emprestados com a data do emprestimo e o autor do livro
SELECT l.titulo, l.autor, e.data_emprestimo FROM Livros l JOIN Emprestimos e ON l.id_livro = e.id_livro WHERE e.data_devolucao IS NULL;
