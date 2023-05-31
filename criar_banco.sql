Create table usuario(
	username varchar(50),
	nome varchar(50),
	biografia varchar(200),
	primary key(username)	

);

create table post(
	id_post serial,
	descricao varchar(100),
	imagem varchar(100), --caminho imagem
	primary key(id_post)
);
create sequence id_post;

create table publicacoes(
	id_post int references post(id_post) on delete cascade,
	username varchar(50) references usuario(username) on delete cascade,
	primary key(id_post)
);

create table curtiu(
	id_post int references post(id_post) on delete cascade,
	username varchar(50) references usuario(username) on delete cascade,
	constraint post_username primary key(id_post, username)
);

create table seguindo(
	username1 varchar(50) references usuario(username) on delete cascade,
	username2 varchar(50) references usuario(username) on delete cascade,
	constraint segue primary key(username1, username2)
);

-- ver os NOT NULL


INSERT INTO usuario (username, nome, biografia) VALUES
('user1', 'João', 'Sou um entusiasta da tecnologia.'),
('user2', 'Maria', 'Amo viajar e descobrir novos lugares.'),
('user3', 'Pedro', 'Adoro cozinhar e experimentar novas receitas.'),
('user4', 'Ana', 'Música é a minha paixão.'),
('user5', 'Lucas', 'Sou um atleta amador.'),
('user6', 'Carla', 'Sou uma artista plástica.'),
('user7', 'Fernando', 'Viciado em livros e filmes.'),
('user8', 'Mariana', 'Sempre em busca de aventuras.'),
('user9', 'Gustavo', 'Amante da natureza e dos animais.'),
('user10', 'Isabela', 'Sou uma apaixonada por fotografia.');

INSERT INTO post (descricao, imagem) VALUES
('Lindo pôr do sol na praia.', 'imagem1.jpg'),
('Delicioso jantar em família.', 'imagem2.jpg'),
('Apreciando a vista da montanha.', 'imagem3.jpg'),
('Momento de relaxamento na piscina.', 'imagem4.jpg'),
('Show incrível da minha banda favorita.', 'imagem5.jpg'),
('Registro de um momento especial.', 'imagem6.jpg'),
('Passeio de bicicleta no parque.', 'imagem7.jpg'),
('Retrato de um lindo sorriso.', 'imagem8.jpg'),
('Aventura radical no rapel.', 'imagem9.jpg'),
('Registro de uma cidade encantadora.', 'imagem10.jpg');

INSERT INTO publicacoes (id_post, username) VALUES
(1, 'user1'),
(2, 'user2'),
(3, 'user3'),
(4, 'user4'),
(5, 'user5'),
(6, 'user6'),
(7, 'user7'),
(8, 'user8'),
(9, 'user9'),
(10, 'user10');

INSERT INTO curtiu (id_post, username) VALUES
(1, 'user2'),
(1, 'user3'),
(2, 'user1'),
(3, 'user4'),
(4, 'user5'),
(5, 'user6'),
(6, 'user7'),
(7, 'user8'),
(8, 'user9'),
(9, 'user10');
