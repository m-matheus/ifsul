CREATE DATABASE tas_bd;

USE tas_bd;

CREATE TABLE Actor(
	id VARCHAR(255) PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   salary FLOAT NOT NULL,
   birth_date DATE NOT NULL,
   gender VARCHAR(6) NOT NULL
);

SHOW DATABASES;

SHOW TABLES;

DESCRIBE Actor;

INSERT INTO Actor 
   (id, name, salary, birth_date, gender) 
VALUES 
   ('001','Tony Ramos',400000,'1948-08-25','male'),
   ('002','Camila Pitanga',320000,'1977-06-14','female'),
   ('003','Antônio Fagundes',230000,'1949-04-10','male'),
   ('004','Fernanda Montenegro',400000,'1929-10-16','female'),
   ('005','Moacyr Franco',719333,'1936-10-05','female');
   
SELECT * FROM Actor;

UPDATE Actor SET salary=1200000 WHERE id=006;

INSERT INTO Actor (id, name, salary, birth_date, gender) VALUES
	('006', 'Glória Pires', 1200, '1963-08-23', 'female');

SELECT id,salary FROM Actor;

SELECT salary FROM Actor WHERE name='Tony Ramos';

SELECT id,name,salary FROM Actor WHERE salary<500000;

SELECT id,name FROM Actor WHERE gender='male';

SELECT * FROM Actor WHERE gender='female';

SELECT * FROM Actor WHERE name LIKE "A%" OR name LIKE "J%" AND salary>300000;

SELECT * FROM Actor WHERE name NOT LIKE "A%" AND salary>35000000;

SELECT * FROM Actor WHERE name LIKE "%g%" OR name LIKE "%G%";

SELECT * FROM Actor WHERE name LIKE "%g%" OR name LIKE "%G%" OR name LIKE "%A%" OR name LIKE "%a%" AND salary>35000000 AND salary<90000000;

CREATE TABLE Filmes(
	id VARCHAR(255) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sinopse TEXT NOT NULL,
    data_lancamento DATE NOT NULL,
    avaliacao INT NOT NULL
);

INSERT INTO Filmes
	(id, nome, sinopse, data_lancamento, avaliacao) 
VALUES
	("001", "Se Eu Fosse Você", "Cláudio e Helena são casados há muitos anos e enfrentam a rotina do casamento. Um dia eles são atingidos por um fenômeno inexplicável e trocam de corpos", "2006-01-06", 7),
    ("002", "Doce de mãe", "Dona Picucha, uma animada senhora de 85 anos, sempre causa grandes confusões. A vida dela e dos seus quatro filhos sofre uma reviravolta depois que Zaida, empregada e amiga de Dona Picucha, anuncia que vai se casar e não poderá mais morar com ela", "2012-12-27", 10),
    ("003", "Dona Flor e Seus Dois Maridos", "Dona Flor é uma sedutora professora de culinária casada com Vadinho, que só quer saber de farras e jogatina nas boates. A vida de abusos acaba por acarretar sua morte precoce.", "2017-11-02", 8),
    ("004", "Cidade de Deus", "Buscapé é um jovem pobre, negro e sensível, que cresce em um universo de muita violência. Ele vive na Cidade de Deus, favela carioca conhecida por ser um dos locais mais violentos do Rio.", "2002-08-30", 10);
    
SELECT id,nome,avaliacao FROM Filmes WHERE id=004;

SELECT * FROM Filmes WHERE nome="Cidade de Deus";

SELECT id,nome,sinopse FROM Filmes WHERE avaliacao>=7;

SELECT * FROM Filmes WHERE nome LIKE "%vida%";

SELECT * FROM Movie WHERE title LIKE "%TERMO DE BUSCA%" OR synopsis LIKE "%TERMO DE BUSCA%";
      
SELECT * FROM Filmes WHERE data_lancamento < DATE(NOW());

SELECT * FROM MOVIE WHERE release_date < "2020-05-04" AND (title LIKE "%TERMO DE BUSCA%" OR synopsis LIKE "%TERMO DE BUSCA%") AND rating > 7;
    