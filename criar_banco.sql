Create table usuario(
	username varchar(50),
	nome varchar(50),
	biografia varchar(200),
	primary key(username)	

);

create table post(
	id_post int,
	descricao varchar(100),
	imagem bytea,
	primary key(id_post)
);
create sequence id_post;

create table publicacoes(
	id_post int references post(id_post) on delete cascade,
	username varchar(50) references usuario(username) on delete cascade
);


