-- criando o banco de dados
CREATE DATABASE bd_aluguel_veiculos_2a;

-- selecionando o banco de dados que será utilizado
USE bd_aluguel_veiculos_2a;

-- criando a tabela usuario
CREATE TABLE usuario(
id_usuario BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL,
email VARCHAR(50) UNIQUE NOT NULL,
senha VARCHAR(20) NOT NULL,
PRIMARY KEY(id_usuario)
);

-- criando a tabela veiculo
CREATE TABLE veiculo(
id_veiculo BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
modelo VARCHAR(40) NOT NULL,
placa VARCHAR(8) UNIQUE NOT NULL,
id_usuario BIGINT NOT NULL,
PRIMARY KEY(id_veiculo),
FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario)
);

-- inserindo um registro dentro da tabela usuario
INSERT INTO usuario VALUES(null, 'Elyel', 'Ely@gmail.com', '978537');



-- Exemplo de uma busca por email e senha
SELECT * FROM usuario WHERE email='bru@gmail.com' AND senha='7675455756';



