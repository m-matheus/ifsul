CREATE DATABASE bd_ex;

-- Criação da tabela Clientes
CREATE TABLE Clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- Criação da tabela Produtos
CREATE TABLE Produtos (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome_produto VARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL
);

-- Criação da tabela Pedidos
CREATE TABLE Pedidos (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    data_pedido DATE NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente) ON DELETE CASCADE
);

-- Criação da tabela Pedido_Produtos
CREATE TABLE Pedido_Produtos (
    id_pedido INT,
    id_produto INT,
    quantidade INT NOT NULL,
    PRIMARY KEY (id_pedido, id_produto),
    FOREIGN KEY (id_pedido) REFERENCES Pedidos(id_pedido) ON DELETE CASCADE,
    FOREIGN KEY (id_produto) REFERENCES Produtos(id_produto) ON DELETE CASCADE
);


INSERT INTO Clientes (nome, email) VALUES
('Matheus de Moraes', 'matheus@gmail.com'),
('Michelle', 'michelle@gmail.com'),
('Apollo', 'apollo@gmail.com'),
('Júpiter', 'jupiter@gmail.com'),
('Marte', 'marte@gmail.com');

INSERT INTO Produtos (nome_produto, preco) VALUES
('iPhone 11', 3000.00),
('Caneca', 60.00),
('Mouse', 250.00),
('Teclado', 300.00),
('Headset', 200.00);

INSERT INTO Pedidos (id_cliente, data_pedido) VALUES
(1, '2024-08-10'),
(2, '2024-08-10'),
(3, '2024-08-11'),
(4, '2024-08-11'),
(5, '2024-08-09');

INSERT INTO Pedido_Produtos (id_pedido, id_produto, quantidade) VALUES
(1, 3, 1),  
(1, 4, 1), 
(2, 1, 1), 
(2, 2, 5),  
(3, 4, 5),  
(3, 5, 2),  
(4, 1, 1),  
(4, 2, 1),  
(5, 2, 1),  
(5, 4, 2);

SELECT Pedidos.id_pedido, Clientes.nome, Produtos.nome_produto, Pedido_Produtos.quantidade
FROM Pedidos
INNER JOIN Clientes ON Pedidos.id_cliente = Clientes.id_cliente
INNER JOIN Pedido_Produtos ON Pedidos.id_pedido = Pedido_Produtos.id_pedido
INNER JOIN Produtos ON Pedido_Produtos.id_produto = Produtos.id_produto;

SELECT Clientes.nome, Pedidos.data_pedido
FROM Clientes
LEFT JOIN Pedidos ON Clientes.id_cliente = Pedidos.id_cliente;

SELECT Produtos.nome_produto, Pedido_Produtos.id_pedido
FROM Pedido_Produtos
RIGHT JOIN Produtos ON Pedido_Produtos.id_produto = Produtos.id_produto;

SELECT Clientes.nome, Pedidos.data_pedido, Produtos.nome_produto, Pedido_Produtos.quantidade
FROM Clientes
INNER JOIN Pedidos ON Clientes.id_cliente = Pedidos.id_cliente
INNER JOIN Pedido_Produtos ON Pedidos.id_pedido = Pedido_Produtos.id_pedido
INNER JOIN Produtos ON Pedido_Produtos.id_produto = Produtos.id_produto
WHERE Clientes.email LIKE '%@gmail.com';

SELECT Clientes.nome, SUM(Produtos.preco * Pedido_Produtos.quantidade) AS total
FROM Clientes
INNER JOIN Pedidos ON Clientes.id_cliente = Pedidos.id_cliente
INNER JOIN Pedido_Produtos ON Pedidos.id_pedido = Pedido_Produtos.id_pedido
INNER JOIN Produtos ON Pedido_Produtos.id_produto = Produtos.id_produto
GROUP BY Clientes.nome;


