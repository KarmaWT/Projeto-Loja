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
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (7,'Par de meias',0.00,0,'Meia cinza',37),(9,'Lapis',2.00,0,'Lapis',37),(10,'Par de Meia',6.00,70,'Par de meias cinzas',37),(11,'Bola de gude',0.25,64,'bolas de gude pequenas',37),(12,'Pitbull',5000.00,0,'Bravo.',37),(13,'Almofada',20.00,45,'Fofa',37),(67,'Camiseta Algodão',29.90,100,'Camiseta branca, tamanho único.',37),(68,'Notebook Acer Aspire',2999.99,10,'Notebook Intel i5, 8GB RAM, SSD 256GB.',37),(69,'Sofá 3 Lugares',1299.99,5,'Sofá cinza de 3 lugares.',37),(70,'Geladeira Brastemp',3199.00,7,'Geladeira Frost Free 400L inox.',37),(71,'Tênis Nike Air',399.99,50,'Tênis Nike para corrida, preto e branco.',37),(72,'Smartphone Samsung S22',4999.00,20,'Samsung Galaxy S22, 128GB, 5G.',37),(73,'Livro - A Culpa das Estrelas',39.90,150,'Best-seller de John Green.',37),(74,'Micro-ondas Electrolux',799.99,25,'Micro-ondas 30L, cor branca.',37),(75,'Mesa de Jantar 6 Cadeiras',1899.00,8,'Mesa de madeira com 6 cadeiras.',37),(76,'Fone Bluetooth JBL',199.99,60,'Fone JBL com cancelamento de ruído.',37),(77,'Mochila Escolar Feminina',149.90,40,'Mochila feminina para notebook, rosa.',37),(78,'Cafeteira Expresso Philips',499.99,30,'Cafeteira compatível com Nespresso.',37),(79,'Relógio Xiaomi Mi Band 6',299.99,75,'Smartwatch resistente à água.',37),(80,'Ar-condicionado LG 12000 BTUs',2299.00,15,'Ar-condicionado com controle remoto.',37),(81,'Bicicleta Mountain Bike',1499.00,10,'Mountain Bike aro 29, freio a disco.',37),(82,'Cadeira Gamer DXRacer',899.99,12,'Cadeira gamer ajustável, cor preta.',37),(83,'TV LED Samsung 50\"',2499.99,18,'Smart TV 50\" Ultra HD 4K.',37),(84,'Whey Protein 900g',149.90,200,'Whey Protein concentrado, chocolate.',37),(85,'Teclado Gamer Corsair',699.99,40,'Teclado mecânico com RGB.',37),(86,'Máquina de Lavar 11kg',1899.00,14,'Máquina Brastemp, função rápida.',37),(87,'Tênis Vans Old Skool',349.99,35,'Tênis Vans, clássico preto e branco.',37),(88,'Jogo de Cama 4 Peças',249.90,60,'Jogo de cama 100% algodão, branca.',37),(89,'PlayStation 5',4999.00,25,'Console PS5, 1 controle.',37),(90,'Chinelo Havaianas',29.90,300,'Chinelo tradicional, azul.',37),(91,'Mesa Escritório',399.99,25,'Mesa com 2 gavetas.',37),(92,'Cortina Blackout 2x1.8m',119.99,80,'Cortina cinza, 2x1.8m.',37),(93,'Luminária Mesa LED',89.90,55,'Luminária ajustável, cor preta.',37),(94,'JBL Boombox 2',1599.99,10,'Caixa JBL à prova d\'água.',37),(95,'Tablet Apple iPad Air',3999.99,15,'iPad Air, 64GB, Wi-Fi.',37),(96,'Aspirador Electrolux',399.99,50,'Aspirador com filtro HEPA.',37),(97,'Câmera Canon EOS T7',2599.99,8,'Câmera digital com lente 18-55mm.',37),(98,'Cooktop 4 Bocas',799.99,22,'Cooktop a gás, acendimento automático.',37),(99,'Cadeira de Praia',99.90,70,'Cadeira dobrável em alumínio.',37),(100,'Monitor Dell 27\"',1499.00,30,'Monitor Full HD, ajuste de altura.',37),(101,'Chaleira Elétrica',159.99,45,'Chaleira inox, 1,7L.',37),(102,'Jogo de Panelas Tramontina',499.99,18,'5 peças, antiaderente, preta.',37),(103,'Tapete Shaggy 2x2.5m',299.99,10,'Tapete felpudo, bege.',37),(104,'Caixa Organizadora',29.90,150,'Caixa plástica, 15L, transparente.',37),(105,'Churrasqueira Elétrica',199.99,20,'Churrasqueira com grelha antiaderente.',37),(106,'Liquidificador Arno',249.99,35,'Liquidificador 1000W, cor preta.',37),(107,'Tênis Adidas Ultraboost',699.99,50,'Tênis para corrida, azul.',37),(108,'Ventilador Mondial',199.99,45,'Ventilador de coluna, 3 velocidades.',37),(109,'Guitarra Fender Stratocaster',7999.00,5,'Guitarra clássica sunburst.',37),(110,'Frigobar Consul 120L',899.99,12,'Frigobar 120 litros, branca.',37),(111,'Carrinho de Bebê',699.99,25,'Carrinho Burigotto, azul.',37),(112,'Quadro Decorativo',199.99,20,'Quadro com moldura, imagem abstrata.',37),(113,'Caixa de Ferramentas',299.99,50,'Caixa completa com 100 peças.',37),(114,'Almofada Decorativa',59.90,100,'Almofada 45x45cm, estampa geométrica.',37);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtoscomprados`
--

DROP TABLE IF EXISTS `produtoscomprados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtoscomprados` (
  `idProdutoComprado` int NOT NULL AUTO_INCREMENT,
  `idProduto` int NOT NULL,
  `idUsuario` int NOT NULL,
  `nomeProduto` varchar(255) NOT NULL,
  `descricao` text NOT NULL,
  `precoUnitario` decimal(10,2) NOT NULL,
  `quantidade` int NOT NULL,
  `valorTotal` decimal(10,2) NOT NULL,
  `dataHoraCompra` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idProdutoComprado`),
  KEY `produtoscomprados_ibfk_1` (`idProduto`),
  KEY `produtoscomprados_ibfk_2` (`idUsuario`),
  CONSTRAINT `produtoscomprados_ibfk_1` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idproduto`),
  CONSTRAINT `produtoscomprados_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtoscomprados`
--

LOCK TABLES `produtoscomprados` WRITE;
/*!40000 ALTER TABLE `produtoscomprados` DISABLE KEYS */;
INSERT INTO `produtoscomprados` VALUES (1,11,1,'Bola de gude','bolas de gude pequenas',0.25,5,1.25,'2024-08-26 01:08:36'),(2,10,37,'Par de Meia','Par de meias cinzas',6.00,4,24.00,'2024-08-26 01:10:40'),(3,11,31,'Bola de gude','bolas de gude pequenas',0.25,50,12.50,'2024-08-26 05:52:13'),(4,10,30,'Par de Meia','Par de meias cinzas',6.00,1,6.00,'2024-08-26 05:53:59'),(5,13,37,'Almofada','Fofa',20.00,5,100.00,'2024-08-26 05:55:32');
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
INSERT INTO `usuario` VALUES (1,'Matheus','senha','04040160223','69992362486','76861000','RO','Itapuã do Oeste','Centro','R. Senado Olavo Pires','1761',0),(27,'Bia','napolitano','01010101010','','90810450','RS','Porto Alegre','Santa Tereza','Rua Pinheiro','',0),(28,'Resky','1234','02020202020','','76820441','RO','Porto Velho','Flodoaldo Pontes Pinto','Avenida Calama','',0),(29,'Joséfina','claudinhobochecha','15646515615','','27250220','RJ','Volta Redonda','Água Limpa','Rua Rio Tocantins','5645',0),(30,'Nanah','2788','52197602896','','07097320','','Guarulhos','Jardim Santa Mena','Rua Dom Macedo da Costa','',0),(31,'Klayton','aspas','40022128824','','37570000',NULL,'Ouro Fino','','','',0),(34,'Teste Texeira','Teste','69999999999','69992282208','76861000','RO','Itapuã do Oeste','Testelandia','Av. Testeira','1234',0),(35,'roberto carlos','musica','96666666666','','76861000',NULL,'Itapuã do Oeste','','','',0),(37,'adm','adm','11111111111','69992362486','76861000','RO','Admlandia','Centro','Rua','',1);
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

-- Dump completed on 2024-08-26  5:48:48
