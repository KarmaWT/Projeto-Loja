CREATE DATABASE  IF NOT EXISTS `banco` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `banco`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: banco
-- ------------------------------------------------------
-- Server version	9.0.1

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

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `idadministrador` int NOT NULL AUTO_INCREMENT,
  `nomeAdm` varchar(45) NOT NULL,
  `senhaAdm` varchar(45) NOT NULL,
  PRIMARY KEY (`idadministrador`),
  UNIQUE KEY `nomeAdm_UNIQUE` (`nomeAdm`),
  UNIQUE KEY `idadministrador_UNIQUE` (`idadministrador`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idcliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `telefone` varchar(18) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `rua` varchar(45) DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcliente`,`nome`),
  UNIQUE KEY `idcliente_UNIQUE` (`idcliente`),
  UNIQUE KEY `nome_UNIQUE` (`nome`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Matheus','senha','04040160223','69992362486','76861000','RO','Itapuã do Oeste','Centro','R. Senado Olavo Pires','1761'),(27,'Bia','napolitano','01010101010','','90810450','RS','Porto Alegre','Santa Tereza','Rua Pinheiro',''),(28,'Resky','1234','02020202020','','76820441','RO','Porto Velho','Flodoaldo Pontes Pinto','Avenida Calama',''),(29,'Joséfina','claudinhobochecha','15646515615','','27250220','RJ','Volta Redonda','Água Limpa','Rua Rio Tocantins','5645'),(30,'Nanah','2788','52197602896','','07097320',NULL,'Guarulhos','Jardim Santa Mena','Rua Dom Macedo da Costa',''),(31,'Klayton','aspas','40022128824','','37570000',NULL,'Ouro Fino','','',''),(34,'Teste','Teste','69999999999','69992282208','76861000','RO','Itapuã do Oeste','Teste','Teste','1234'),(35,'roberto carlos','musica','96666666666','','76861000',NULL,'Itapuã do Oeste','','','');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `idCompra` int NOT NULL AUTO_INCREMENT,
  `idCliente` int NOT NULL,
  `idProduto` int NOT NULL,
  `quantidade` int NOT NULL,
  `precoUnitario` decimal(10,2) NOT NULL,
  `valorTotal` decimal(10,2) NOT NULL,
  `dataHora` datetime NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `idCliente` (`idCliente`),
  KEY `idProduto` (`idProduto`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idproduto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,1,4,5,12.00,60.00,'2024-08-23 23:00:37'),(2,1,4,3,12.00,36.00,'2024-08-23 23:13:08'),(3,1,4,1,12.00,12.00,'2024-08-24 01:38:30'),(4,1,4,1,12.00,12.00,'2024-08-24 01:38:40');
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `idproduto` int NOT NULL AUTO_INCREMENT,
  `nomeProduto` varchar(255) NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `quantidade` int NOT NULL,
  `descricao` text,
  PRIMARY KEY (`idproduto`),
  UNIQUE KEY `idproduto_UNIQUE` (`idproduto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Camisas',60.00,5,'Camisas simples de  uma cor'),(2,'Calças',60.00,10,'Calças Jeans'),(3,'Colgate',7.00,25,'Pasta de dente colgate'),(4,'Leite',12.00,15,'Leite perfeito para um pai comprar e sumir');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-24  4:46:15
