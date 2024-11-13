create database BibliotecaXYZ;

use BibliotecaXYZ;

create table Livros(
	id int auto_increment primary key,
    titulo varchar(255) not null,
    autor varchar(255) not null,
    ano_publicacao int not null
);

create table Autores(
	id int auto_increment primary key,
    nome varchar(255) not null,
    nacionalidade varchar(255) not null
);

create table Usuarios(
	id int auto_increment primary key,
    nome varchar(255) not null,
    email varchar(255) not null,
    idade int not null
);

create table Emprestimos(
	id int auto_increment primary key,
    data_emprestimo date,
    data_devolucao date,
    id_usuario int,
    id_livro int,
    foreign key (id_usuario) references usuarios(id),
    foreign key (id_livro) references livros(id)
);

insert into Livros 
	(titulo, autor, ano_publicacao) 
values 
('A guerra dos tronos', 'George R. R. Martin', '1996'), 
('O nome do vento', 'Patrick Rothfuss', '2009'),
('Nightflyers', 'George R. R. Martin', '1980'),
('Mitologia Nórdica', 'Neil Gaiman', '2017'),
('A máquina do tempo', 'H. G. Wells', '1895');

insert into Autores 
	(nome, nacionalidade) 
values 
('Geroge R. R. Martin', 'Americano'), 
('Patrick Rothfuss', 'Americano'),
('Neil Gaiman', 'Britânico'),
('H. G. Wells', 'Britânico'),
('Rick Riordan', 'Americano');

insert into Usuarios 
	(nome, email, idade) 
values 
('Matheus', 'matheus@gmail.com', '24'), 
('Michelle', 'michelle@gmail.com', '22'),
('Vitor', 'vitor@gmail.com', '18'),
('Guilherme', 'guilherme@gmail.com', '25'),
('Tonico', 'tonico@gmail.com', '21');

insert into Emprestimos 
	(id_usuario, id_livro, data_emprestimo, data_devolucao) 
values 
(1, 1, '2024-04-10', '2024-04-12'), 
(2, 2, '2024-04-10', '2024-04-12'),
(3, 3, '2024-04-12', '2024-04-14'),
(4, 4, '2024-04-12', '2024-04-14'),
(5, 5, '2024-04-14', '2024-04-16');

alter table Livros add column id_autor int;

alter table Livros add foreign key (id_autor) references autores(id);

select * from livros where id_autor=1;

select Usuarios.nome, count(Emprestimos.id_usuario) as emprestimos from Usuarios join Emprestimos on usuarios.id = emprestimos.id_usuario group by Usuarios.nome limit 1;

select avg(idade) from Usuarios;

select livros.titulo, usuarios.nome from Emprestimos join Livros on emprestimos.id_livro = Livros.id join Usuarios on Emprestimos.id_usuario = Usuarios.id;

select titulo from livros join autores on livros.id_autor = autores.id where autores.nacionalidade = 'Britânico';

delete from emprestimos where id_usuario = 1 and id_livro = 1;

select * from emprestimos;