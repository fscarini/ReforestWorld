create database db_rwc;
use db_rwc;
create table users (
id int(9) auto_increment,
nome varchar(250) not null,
email varchar(250) not null,
senha varchar(250) not null,
primary key (id)
);
insert into users(id, nome, email, senha) values (null, 'admin', 'admin@reforestworld,com.br','admin');
select * from users;
update users set email= 'admin@reforestworld.com.br' where id = 1;