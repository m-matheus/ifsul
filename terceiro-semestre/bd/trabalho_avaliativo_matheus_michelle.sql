-- Nome da dupla: Matheus Moraes e Michelle Gonçalves
create database tas_bd_spotify;
use tas_bd_spotify;


-- 1. ESCOLHA DO APLICATIVO
-- Aplicativo escolhido: Spotify.
-- Modelagem do Banco: Usuários, Artistas, Álbuns, Músicas, Playlists, Gêneros Musicais.


-- 2. CRIAÇÃO DAS TABELAS E INSERÇÃO DE DADOS PARA REALIZAR AS CONSULTAS
create table usuarios (
	id int auto_increment primary key,
    nome varchar(255),
    email varchar(255) unique,
    senha varchar(255),
    tipo_de_conta enum('gratuita', 'premium')
);

insert into usuarios (nome, email, senha, tipo_de_conta) values 
('matheus', 'matheus@gmail.com', 'root', 'premium'),
('michelle', 'michelle@gmail.com', 'amoomatheus', 'premium'),
('apollo', 'apollo@gmail.com', 'miau1', 'gratuita'),
('jupiter', 'jujuba@gmail.com', 'miau2', 'premium'),
('marte', 'yurimartins@gmail.com', 'miau3', 'gratuita');

create table artistas (
	id int auto_increment primary key,
    nome varchar(255),
    biografia text,
    genero varchar(255)
);

insert into artistas (nome, biografia, genero) values
('maroon 5', 'biografia top', 'pop'),
('justin bieber', 'biografia media', 'pop'),
('arctic monkeys', 'biografia top', 'rock indie'),
('pericles', 'biografia top', 'pagode'),
('eminem', 'biografia god like', 'rap');

create table albuns (
	id int auto_increment primary key,
    titulo varchar(255),
    data_de_lancamento date,
    id_artista int,
    foreign key (id_artista) references artistas(id)
);

insert into albuns (titulo, data_de_lancamento, id_artista) values
('v', '2014-08-29', 1),
('my world', '2009-11-17', 2),
('am', '2013-09-09', 3),
('nos arcos da lapa', '2013-07-26', 4),
('encore', '2004-11-12', 5);

create table musicas (
	id int auto_increment primary key,
    titulo varchar(255),
    duracao time,
    id_album int,
    id_artista int,
    foreign key (id_album) references albuns(id),
    foreign key (id_artista) references artistas(id)
);

insert into musicas (titulo, duracao, id_album, id_artista) values
('it was always you', '00:03:59', '1', '1'),
('baby', '00:03:34', '2', '2'),
('r u mine?', '00:03:21', '3', '3'),
('final de tarde', '00:03:57', '4', '4'),
('mockingbird', '00:04:10', '5', '5');



create table playlists (
	id int auto_increment primary key,
    nome varchar(255),
    id_usuario int,
    foreign key (id_usuario) references usuarios(id)
);

insert into playlists (nome, id_usuario) values
('as mais braba', 1),
('pop up', 2),
('miaaaaau', 3),
('miau miau', 4),
('miau', 5);

create table generos_musicais (
	id int auto_increment primary key,
    nome varchar(255)
);

insert into generos_musicais (nome) values
('pop'),
('rock indie'),
('pagode'),
('rap');


-- 3. RELACIONAMENTOS
create table playlist_musicas (
	id int auto_increment primary key,
    id_playlist int,
    id_musica int,
    foreign key (id_playlist) references playlists(id),
    foreign key (id_musica) references musicas(id)
);

insert into playlist_musicas (id_playlist, id_musica) values
(1, 1),
(1, 3),
(1, 4),
(1, 5),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(3, 2),
(4, 5),
(5, 4);

create table musica_generos (
	id int auto_increment primary key,
    id_musica int,
    id_genero int,
    foreign key (id_musica) references musicas(id),
    foreign key (id_genero) references generos_musicais(id)
);

insert into musica_generos (id_musica, id_genero) values
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(5, 4);


-- 4. CONSULTAS
-- 1) resultado: nome de todos usuarios premium
select nome from usuarios where tipo_de_conta = 'premium';
-- 2) nome e genero de todos artistas do genero pop
select nome, genero from artistas where genero = 'pop';
-- 3) nome dos artistas que possuem 'top' em sua biografia
select nome from artistas where biografia like '%top%';
-- 4) titulo dos albuns cuja data de lancamento seja maior que 2010-01-01
select titulo from albuns where data_de_lancamento > '2010-01-01';
-- 5) titulo das musicas cuja duracao seja menor que 4min
select titulo from musicas where duracao < '00:04:00';
-- 6) a media de duracao das musicas
select avg(time_to_sec(duracao)) / 60 as duracao_media from musicas;
-- 7) quantidade de musicas
select count(*) as total_musicas from musicas;
-- 8) todas as musicas que estao na playlist de id 3
select m.* from musicas m join playlist_musicas pm on m.id = pm.id_musica where pm.id_playlist = 3;
-- 9) titulo das musicas que comecam com a letra m
select titulo from musicas where titulo like 'm%';
-- 10) todas musicas junto do seu artista e album correspondente
select m.titulo as musica, a.nome as artista, al.titulo as album from musicas m
join artistas a on m.id_artista = a.id
join albuns al on m.id_album = al.id;
-- 11) lista as musicas e em quantas playslits elas aparecem
select m.titulo as musica, count(pm.id_playlist) as total_playlists from musicas m
join playlist_musicas pm on m.id = pm.id_musica group by m.titulo;
-- 12) lista a quantidade de musicas de cada playlist
select p.nome as playlists, count(pm.id_musica) as total_musicas from playlists p 
join playlist_musicas pm on p.id = pm.id_playlist group by p.nome;
-- 13) seleciona o nome dos usuarios por ordem alfabetica
select nome from usuarios order by nome asc;
-- 14) conta o numero total de artistas
select count(*) as total_artistas from artistas;
-- 15) seleciona a menor data de lancamento
select min(data_de_lancamento) from albuns;

