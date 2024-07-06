-- Criação das tabelas

CREATE TABLE convidados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    idade INT,
    genero VARCHAR(10)
);

CREATE TABLE locais (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100)
);

CREATE TABLE eventos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    local_id INT,
    hora TIME,
    FOREIGN KEY (local_id) REFERENCES locais(id)
);

CREATE TABLE testemunhos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    convidado_id INT,
    evento_id INT,
    testemunho TEXT,
    FOREIGN KEY (convidado_id) REFERENCES convidados(id),
    FOREIGN KEY (evento_id) REFERENCES eventos(id)
);

CREATE TABLE preferencias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    convidado_id INT,
    gosta_bolo BOOLEAN,
    FOREIGN KEY (convidado_id) REFERENCES convidados(id)
);

CREATE TABLE sabores_bolos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sabor VARCHAR(100)
);

CREATE TABLE preferencias_sabores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    convidado_id INT,
    sabor_id INT,
    FOREIGN KEY (convidado_id) REFERENCES convidados(id),
    FOREIGN KEY (sabor_id) REFERENCES sabores_bolos(id)
);

-- Inserções na tabela convidados
INSERT INTO convidados (nome, idade, genero) VALUES
('Alice', 25, 'Feminino'),
('Bruno', 30, 'Masculino'),
('Carla', 35, 'Feminino'),
('Daniel', 28, 'Masculino'),
('Eva', 22, 'Feminino'),
('Felipe', 26, 'Masculino'),
('Gabi', 29, 'Feminino'),
('Hugo', 27, 'Masculino');

-- Inserções na tabela locais
INSERT INTO locais (nome) VALUES
('Salao Principal'),
('Jardim'),
('Cozinha'),
('Sala de Estar'),
('Biblioteca');

-- Inserções na tabela eventos
INSERT INTO eventos (nome, local_id, hora) VALUES
('Inicio da Festa', 1, '18:00:00'),
('Conversas no Jardim', 2, '18:30:00'),
('Preparacao dos Petiscos', 3, '19:00:00'),
('Jogos na Sala de Estar', 4, '19:30:00'),
('Leitura na Biblioteca', 5, '20:00:00'),
('Desaparecimento do Bolo', 1, '20:30:00');

-- Inserções na tabela testemunhos
INSERT INTO testemunhos (convidado_id, evento_id, testemunho) VALUES
(2, 2, 'Eu estava conversando no jardim com a Carla.'),
(3, 2, 'Eu estava no jardim conversando com o Bruno.'),
(4, 3, 'Eu estava ajudando a preparar os petiscos na cozinha.'),
(6, 3, 'Eu estava na cozinha preparando os petiscos com o Daniel.'),
(5, 5, 'Eu estava na biblioteca lendo um livro.'),
(7, 5, 'Eu estava na biblioteca lendo um livro com a Eva.'),
(8, 4, 'Eu estava jogando na sala de estar.'),
(1, 4, 'Eu estava jogando na sala de estar com o Hugo.'),
(2, 6, 'Eu vi o bolo desaparecer no salão principal.'),
(5, 6, 'Eu estava no salão principal quando o bolo desapareceu.');

-- Inserções na tabela preferencias
INSERT INTO preferencias (convidado_id, gosta_bolo) VALUES
(1, TRUE),
(2, TRUE),
(3, FALSE),
(4, TRUE),
(5, FALSE),
(6, TRUE),
(7, TRUE),
(8, TRUE);

-- Inserções na tabela sabores_bolos
INSERT INTO sabores_bolos (sabor) VALUES
('Chocolate'),
('Baunilha'),
('Morango'),
('Coco'),
('Limão');

-- Inserções na tabela preferencias_sabores
INSERT INTO preferencias_sabores (convidado_id, sabor_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 1),
(4, 2),
(5, 3),
(6, 1),
(6, 5),
(7, 4),
(8, 2);


-- 1. Identificar o Evento "Desaparecimento do Bolo"
SELECT * FROM eventos;
SELECT * FROM eventos WHERE nome LIKE 'Desaparecimento do Bolo';

-- 2. Listar Testemunhos do Evento "Desaparecimento do Bolo"
SELECT t.convidado_id, t.testemunho FROM testemunhos t JOIN eventos e ON t.evento_id = e.id WHERE e.nome LIKE '%desaparecimento do bolo%';

-- 3. Identificar Convidados Presentes no Salão Principal Durante o Desaparecimento
SELECT c.nome FROM convidados c JOIN testemunhos t ON c.id = t.convidado_id JOIN eventos e ON t.evento_id = e.id
JOIN locais l ON e.local_id = l.id WHERE e.nome LIKE 'Desaparecimento do Bolo' 
AND l.nome = 'Salao Principal';

-- 4. Verificar Preferências dos Convidados Presentes
SELECT c.nome FROM convidados c JOIN preferencias p ON p.convidado_id = c.id WHERE p.gosta_bolo = true;

-- 5. Identificar Sabores de Bolo Preferidos
SELECT c.nome, s.sabor FROM convidados c JOIN preferencias p ON p.convidado_id = c.id JOIN preferencias_sabores ps ON ps.convidado_id = c.id JOIN sabores_bolos s ON ps.sabor_id = s.id
WHERE p.gosta_bolo = true;

-- 6. Analisar Álibis e Inconsistências
-- De acordo com a terceira query, apenas bruno e eva estavam no salão na hora do desaparecimento.
-- De acordo com a quarta query, eva não gosta de bolo.
-- De acordo com a quinta query, bruno gosta de dois sabores de bolo disponiveis na festa.

-- 7. Identificar o Culpado
-- Bruno é o culpado.
