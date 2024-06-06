CREATE DATABASE  IF NOT EXISTS "db_rwc" /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_rwc`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: mysql-260935f7-dartvader.b.aivencloud.com    Database: db_rwc
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '539031b5-f84b-11ee-8852-de415b9b1808:1-685';

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidade` (
  `cod_cidade` int NOT NULL AUTO_INCREMENT,
  `nome_cidade` varchar(255) NOT NULL,
  `estado_cod` int DEFAULT NULL,
  PRIMARY KEY (`cod_cidade`),
  KEY `estado_cod` (`estado_cod`),
  CONSTRAINT `cidade_ibfk_1` FOREIGN KEY (`estado_cod`) REFERENCES `estado` (`cod_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `doacoes`
--

DROP TABLE IF EXISTS `doacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `cod_estado` int NOT NULL AUTO_INCREMENT,
  `nome_estado` varchar(19) NOT NULL,
  `sigla` varchar(2) NOT NULL,
  `capital` varchar(14) NOT NULL,
  PRIMARY KEY (`cod_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventos` (
  `cod_evento` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(250) NOT NULL,
  `inicio` varchar(10) NOT NULL,
  `descricao` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_usuario` int NOT NULL,
  `data_registro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `meta_doacao` double NOT NULL,
  `cod_estado` int DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `termino` varchar(10) NOT NULL,
  `foto` longblob,
  PRIMARY KEY (`cod_evento`),
  KEY `fk_estado` (`cod_estado`),
  KEY `fk_cidade` (`cidade`),
  CONSTRAINT `fk_estado` FOREIGN KEY (`cod_estado`) REFERENCES `estado` (`cod_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `local` (
  `cod_local` int NOT NULL AUTO_INCREMENT,
  `bairro` varchar(50) NOT NULL,
  `cod_estado` int NOT NULL,
  `cod_cidade` int NOT NULL,
  PRIMARY KEY (`cod_local`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logs` (
  `cod_log` int NOT NULL AUTO_INCREMENT,
  `log_date` datetime NOT NULL,
  `message` varchar(100) NOT NULL,
  PRIMARY KEY (`cod_log`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mensagens_suporte`
--

DROP TABLE IF EXISTS `mensagens_suporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensagens_suporte` (
  `cod_mensagem` int NOT NULL AUTO_INCREMENT,
  `assunto_mensagem` varchar(32) NOT NULL,
  `mensagens_suporte` varchar(300) NOT NULL,
  `cod_usuario` int NOT NULL,
  `data_alteracao` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cod_mensagem`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `muda`
--

DROP TABLE IF EXISTS `muda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `perfil_usuario`
--

DROP TABLE IF EXISTS `perfil_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil_usuario` (
  `cod_perfil` int NOT NULL AUTO_INCREMENT,
  `tipo_perfil` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `recuperacao_senha_log`
--

DROP TABLE IF EXISTS `recuperacao_senha_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recuperacao_senha_log` (
  `cod_recuperacao` int NOT NULL,
  `user_id` int NOT NULL,
  `dt_recuperacao` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cod_recuperacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `status_muda`
--

DROP TABLE IF EXISTS `status_muda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status_muda` (
  `cod_status_muda` int NOT NULL AUTO_INCREMENT,
  `status_muda` varchar(7) NOT NULL,
  PRIMARY KEY (`cod_status_muda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `tipo_pagamento` varchar(7) DEFAULT NULL,
  `numero_cartao` int DEFAULT NULL,
  `data_vencimento` varchar(10) DEFAULT NULL,
  `cvv_cartao` int DEFAULT NULL,
  `nome_titular` varchar(100) DEFAULT NULL,
  `cpf_cartao` int DEFAULT NULL,
  `dt_atualizacao` datetime DEFAULT CURRENT_TIMESTAMP,
  `status_usuario` varchar(10) NOT NULL,
  `foto_usuario` longblob NOT NULL,
  PRIMARY KEY (`cod_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-06 17:59:26
