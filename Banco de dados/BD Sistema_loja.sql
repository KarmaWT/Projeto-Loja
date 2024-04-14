-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.30 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para sistema_loja
CREATE DATABASE IF NOT EXISTS `sistema_loja` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sistema_loja`;

-- Copiando estrutura para tabela sistema_loja.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idcliente` int NOT NULL AUTO_INCREMENT,
  `cpf` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `forma_de_pagamento` enum('cartao de credito','debito','pix','boleto') DEFAULT NULL,
  `usuario_nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idcliente`),
  KEY `fk_cliente_usuario1_idx` (`usuario_nome`),
  CONSTRAINT `fk_cliente_usuario1` FOREIGN KEY (`usuario_nome`) REFERENCES `usuario` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sistema_loja.produto
CREATE TABLE IF NOT EXISTS `produto` (
  `idProduto` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `preco` float NOT NULL,
  `estoque` int NOT NULL,
  `cod. fabricante` varchar(45) DEFAULT NULL,
  `vendedor_idvendedor` int NOT NULL,
  `cliente_idcliente` int NOT NULL,
  PRIMARY KEY (`idProduto`),
  KEY `fk_produto_vendedor1_idx` (`vendedor_idvendedor`),
  KEY `fk_produto_cliente1_idx` (`cliente_idcliente`),
  CONSTRAINT `fk_produto_cliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `fk_produto_vendedor1` FOREIGN KEY (`vendedor_idvendedor`) REFERENCES `vendedor` (`idvendedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sistema_loja.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `nome` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sistema_loja.vendedor
CREATE TABLE IF NOT EXISTS `vendedor` (
  `idvendedor` int NOT NULL AUTO_INCREMENT,
  `usuario_nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idvendedor`),
  KEY `fk_vendedor_usuario_idx` (`usuario_nome`),
  CONSTRAINT `fk_vendedor_usuario` FOREIGN KEY (`usuario_nome`) REFERENCES `usuario` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Exportação de dados foi desmarcado.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
