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
select * from eventos;
update users set status_verificacao= 'Verificado' where id = 1;
ALTER TABLE `db_rwc`.`users` 
ADD COLUMN `dt_nascimento` VARCHAR(10) NOT NULL AFTER `senha`,
ADD COLUMN `sexo` VARCHAR(1) NOT NULL AFTER `dt_nascimento`,
ADD COLUMN `cpf` VARCHAR(11) NOT NULL AFTER `sexo`;
ALTER TABLE `db_rwc`.`eventos` 
ADD COLUMN `local` VARCHAR(250) NOT NULL AFTER `nome`,
ADD COLUMN `data` DATETIME NOT NULL AFTER `local`,
ADD COLUMN `id_usuario` INT NOT NULL AFTER `descricao`,
CHANGE COLUMN `nome do evento` `nome` VARCHAR(250) NOT NULL ,
CHANGE COLUMN `data do evento` `descricao` VARCHAR(10) NOT NULL ,
CHANGE COLUMN `data do registro` `data_registro` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ;

SELECT * FROM eventos;
DESCRIBE eventos;
SELECT * FROM users WHERE email='raul.santosss@gmail.com' limit 1;
DELETE FROM users WHERE id NOT IN(1,26);
SELECT * FROM estado;
SELECT * FROM muda WHERE cod_muda = 146;
SELECT CURRENT_TIMESTAMP