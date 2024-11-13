-- ex1:
-- a) apaga a coluna "salary" da tabela Actor
-- b) muda o nome da coluna gender para sex e para um varchar(6)
-- c) mantem o nome da coluna gender em gender e vira um varchar(255)

ALTER TABLE Actor CHANGE gender gender VARCHAR(100);

-- ex2:

UPDATE Actor SET name= "Matheus", birth_date="1999-09-16" WHERE id="003";

UPDATE Actor SET name="JULIANA PAES" WHERE id="003";

UPDATE Actor SET name="Juliana Paes" WHERE id="003";

UPDATE Actor SET name="",salary="", birth_date="", gender="" WHERE id="005";

-- ex3:

DELETE FROM Actor WHERE name="Fernanda Montenegro";

DELETE FROM Actor WHERE gender="male" AND salary="1000000";

-- ex4: 

SELECT MAX(salary) FROM Actor;

SELECT MIN(salary) FROM Actor WHERE gender="female";

SELECT COUNT(*) FROM Actor WHERE gender="female";

SELECT SUM(salary) FROM Actor;

-- ex5:

SELECT COUNT(*), gender
FROM Actor
GROUP BY gender;

-- a) Está contando o todas pessoas pelo gênero e separando elas pelo gênero

SELECT id, name FROM Actor ORDER BY name DESC;

SELECT * FROM Actor WHERE gender="male" ORDER BY salary ASC;

SELECT * FROM Actor WHERE gender="male" ORDER BY salary ASC LIMIT 3;

SELECT AVG(salary), gender FROM Actor GROUP BY gender;

-- ex6:

ALTER TABLE Movie ADD playing_limit_date DATE;

ALTER TABLE Movie CHANGE avaliacao avaliacao FLOAT;

UPDATE Movie SET playing_limit_date="2024-03-20" WHERE id="003";

UPDATE Movie SET playing_limit_date="2024-03-27" WHERE id="004";

DELETE FROM Movie WHERE id="004";

UPDATE Movie SET sinopse="Alguma coisa" WHERE id="004";

-- d) Não está dando erro, mesmo não existindo nenhum id 004

