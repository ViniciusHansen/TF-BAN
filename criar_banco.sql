Create table usuario(
	username varchar(50),
	nome varchar(50),
	biografia varchar(200),
	primary key(username)	

);

create table post(
	id_post int,
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