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
  `idAdministrador` int NOT NULL AUTO_INCREMENT,
  `nomeAdm` varchar(45) NOT NULL,
  `senhaAdm` varchar(45) NOT NULL,
  `cpfAdm` varchar(14) NOT NULL,
  `telefone` varchar(18) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `rua` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAdministrador`),
  UNIQUE KEY `nomeAdm_UNIQUE` (`nomeAdm`),
  UNIQUE KEY `idadministrador_UNIQUE` (`idAdministrador`),
  UNIQUE KEY `cpfAdm_UNIQUE` (`cpfAdm`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'adm','adm','04040160223','69992362486','76861000','RO','',NULL,NULL);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `idCompra` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int NOT NULL,
  `idProduto` int NOT NULL,
  `quantidade` int NOT NULL,
  `precoUnitario` decimal(10,2) NOT NULL,
  `valorTotal` decimal(10,2) NOT NULL,
  `dataHora` datetime NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `idProduto` (`idProduto`),
  KEY `compra_ibfk_1` (`idUsuario`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idproduto`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (7,37,7,1,0.00,0.00,'2024-08-25 04:29:26');
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
  `idUsuario` int NOT NULL,
  PRIMARY KEY (`idproduto`),
  UNIQUE KEY `idproduto_UNIQUE` (`idproduto`),
  KEY `fk_idUsuario` (`idUsuario`),
  CONSTRAINT `fk_idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (7,'Par de meias',0.00,0,'Meia cinza',37),(9,'Lapis',2.00,0,'Lapis',37),(10,'Par de Meia',6.00,75,'Par de meias cinzas',37),(11,'Bola de gude',0.25,125,'bolas de gude pequenas',37),(12,'Pitbull',5000.00,0,'Bravo.',37);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtoscomprados`
--

DROP TABLE IF EXISTS `produtoscomprados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtoscomprados` (
  `idCompra` int NOT NULL AUTO_INCREMENT,
  `idProduto` int DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  `cpfCliente` varchar(11) DEFAULT NULL,
  `dataCompra` datetime DEFAULT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `idProduto` (`idProduto`),
  CONSTRAINT `produtoscomprados_ibfk_1` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idproduto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtoscomprados`
--

LOCK TABLES `produtoscomprados` WRITE;
/*!40000 ALTER TABLE `produtoscomprados` DISABLE KEYS */;
INSERT INTO `produtoscomprados` VALUES (1,9,5,'11111111111','2024-08-25 04:57:20'),(2,9,70,'11111111111','2024-08-25 04:57:35'),(3,7,49,'11111111111','2024-08-25 05:06:12'),(4,11,25,'11111111111','2024-08-25 05:13:38'),(5,12,2,'11111111111','2024-08-25 05:13:46');
/*!40000 ALTER TABLE `produtoscomprados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
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
  `administrador` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `idcliente_UNIQUE` (`idUsuario`),
  UNIQUE KEY `nome_UNIQUE` (`nome`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Matheus','senha','04040160223','69992362486','76861000','RO','Itapuã do Oeste','Centro','R. Senado Olavo Pires','1761',0),(27,'Bia','napolitano','01010101010','','90810450','RS','Porto Alegre','Santa Tereza','Rua Pinheiro','',0),(28,'Resky','1234','02020202020','','76820441','RO','Porto Velho','Flodoaldo Pontes Pinto','Avenida Calama','',0),(29,'Joséfina','claudinhobochecha','15646515615','','27250220','RJ','Volta Redonda','Água Limpa','Rua Rio Tocantins','5645',0),(30,'Nanah','2788','52197602896','','07097320',NULL,'Guarulhos','Jardim Santa Mena','Rua Dom Macedo da Costa','',0),(31,'Klayton','aspas','40022128824','','37570000',NULL,'Ouro Fino','','','',0),(34,'Teste Texeira','Teste','69999999999','69992282208','76861000','RO','Itapuã do Oeste','Testelandia','Av. Testeira','1234',0),(35,'roberto carlos','musica','96666666666','','76861000',NULL,'Itapuã do Oeste','','','',0),(37,'adm','adm','11111111111','69992362486','76861000','RO','Admlandia','Centro','Rua','',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-25  5:14:34
