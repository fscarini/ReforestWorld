CREATE DATABASE  IF NOT EXISTS "db_rwc";
USE `db_rwc`;
DROP TABLE IF EXISTS `cidade`;
CREATE TABLE `cidade` (
  `cod_cidade` int NOT NULL AUTO_INCREMENT,
  `nome_cidade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_cidade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
DROP TABLE IF EXISTS `doacoes`;
CREATE TABLE `doacoes` (
  `cod_doacao` int NOT NULL AUTO_INCREMENT,
  `dt_doacao` datetime NOT NULL,
  `quantidade` int DEFAULT NULL,
  `cod_evento` int NOT NULL,
  `valor` double NOT NULL,
  `cod_metodo_pagamento` int NOT NULL,
  `cod_muda` int NOT NULL,
  PRIMARY KEY (`cod_doacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
DROP TABLE IF EXISTS `estado`;
CREATE TABLE `estado` (
  `cod_estado` int NOT NULL AUTO_INCREMENT,
  `nome_estado` varchar(19) NOT NULL,
  `sigla` varchar(2) NOT NULL,
  `capital` varchar(14) NOT NULL,
  PRIMARY KEY (`cod_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
DROP TABLE IF EXISTS `eventos`;
CREATE TABLE `eventos` (
  `cod_evento` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(250) NOT NULL,
  `local` varchar(250) NOT NULL,
  `data` varchar(10) NOT NULL,
  `descricao` varchar(10) NOT NULL,
  `id_usuario` int NOT NULL,
  `data_registro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `meta_doacao` double NOT NULL,
  PRIMARY KEY (`cod_evento`)
);
CREATE TABLE `formas_pagamento` (
  `cod_forma_pagamento` int NOT NULL AUTO_INCREMENT,
  `cod_usuario` int NOT NULL,
  `cod_tipo_pagamento` int NOT NULL,
  `numero_cartao` int DEFAULT NULL,
  `data_vencimento` date DEFAULT NULL,
  `cvv_cartao` int DEFAULT NULL,
  `nome_cartao` varchar(100) DEFAULT NULL,
  `cpf_cartao` int DEFAULT NULL,
  `bandeira_cartao` varchar(45) DEFAULT NULL,
  `banco` varchar(45) DEFAULT NULL,
  `numero_agencia` int DEFAULT NULL,
  `numero_conta` int DEFAULT NULL,
  `data_operacao` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cod_forma_pagamento`)
);
DROP TABLE IF EXISTS `local`;
CREATE TABLE `local` (
  `cod_local` int NOT NULL AUTO_INCREMENT,
  `bairro` varchar(50) NOT NULL,
  `cod_estado` int NOT NULL,
  `cod_cidade` int NOT NULL,
  PRIMARY KEY (`cod_local`)
);

DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `cod_log` int NOT NULL AUTO_INCREMENT,
  `log_date` datetime NOT NULL,
  `message` varchar(100) NOT NULL,
  PRIMARY KEY (`cod_log`)
);
DROP TABLE IF EXISTS `muda`;
CREATE TABLE `muda` (
  `cod_muda` int NOT NULL AUTO_INCREMENT,
  `nome_cientifico` varchar(45) NOT NULL,
  `nome_comercial` varchar(45) NOT NULL,
  `valor_muda` double NOT NULL,
  `cod_estado` int NOT NULL,
  `status_muda` int NOT NULL DEFAULT '1',
  `caracteristicas_gerais` varchar(160) NOT NULL,
  `usos_comuns` varchar(100) NOT NULL,
  `imagem_muda` longblob NOT NULL,
  `cod_usuario` varchar(10) NOT NULL,
  `dt_operacao` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cod_muda`)
);
DROP TABLE IF EXISTS `perfil_usuario`;
CREATE TABLE `perfil_usuario` (
  `cod_perfil` int NOT NULL AUTO_INCREMENT,
  `tipo_perfil` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_perfil`)
);
DROP TABLE IF EXISTS `recuperacao_senha_log`;
CREATE TABLE `recuperacao_senha_log` (
  `cod_recuperacao` int NOT NULL,
  `user_id` int NOT NULL,
  `dt_recuperacao` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cod_recuperacao`)
);
DROP TABLE IF EXISTS `status_muda`;
CREATE TABLE `status_muda` (
  `cod_status_muda` int NOT NULL AUTO_INCREMENT,
  `status_muda` varchar(7) NOT NULL,
  PRIMARY KEY (`cod_status_muda`)
);
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `cod_usuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `senha` varchar(250) NOT NULL,
  `dt_nascimento` varchar(10) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `dt_cadastro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cod_verificacao` varchar(6) DEFAULT NULL,
  `status_verificacao` varchar(14) NOT NULL DEFAULT 'Não Verificado',
  `cod_perfil` int NOT NULL DEFAULT '2',
  `dt_verificacao` date DEFAULT NULL,
  `foto_usuario` longblob,
  PRIMARY KEY (`cod_usuario`)
  );