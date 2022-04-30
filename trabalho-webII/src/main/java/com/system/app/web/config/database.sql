-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: localhost    Database: webii
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu4

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `att`
--

DROP TABLE IF EXISTS `att`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `att` (
  `at_id` int NOT NULL AUTO_INCREMENT,
  `data` timestamp NULL DEFAULT NULL,
  `client` int NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `product` int NOT NULL,
  `type` int DEFAULT NULL,
  `description` text,
  `solution` text,
  PRIMARY KEY (`at_id`),
  KEY `type` (`type`),
  CONSTRAINT `att_ibfk_1` FOREIGN KEY (`type`) REFERENCES `attType` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `att`
--

LOCK TABLES `att` WRITE;
/*!40000 ALTER TABLE `att` DISABLE KEYS */;
INSERT INTO `att` VALUES (1,'2022-04-30 19:46:01',6,'em andamento',1,1,'descricao',NULL);
/*!40000 ALTER TABLE `att` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attType`
--

DROP TABLE IF EXISTS `attType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attType` (
  `type_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`type_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attType`
--

LOCK TABLES `attType` WRITE;
/*!40000 ALTER TABLE `attType` DISABLE KEYS */;
INSERT INTO `attType` VALUES (1,'tipo');
/*!40000 ALTER TABLE `attType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `category` int DEFAULT NULL,
  `description` text,
  `weight` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `name` (`name`),
  KEY `category` (`category`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category`) REFERENCES `productCategory` (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'nome',1,'descricao',50.00);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productCategory`
--

DROP TABLE IF EXISTS `productCategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productCategory` (
  `cat_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cat_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productCategory`
--

LOCK TABLES `productCategory` WRITE;
/*!40000 ALTER TABLE `productCategory` DISABLE KEYS */;
INSERT INTO `productCategory` VALUES (1,'beleza');
/*!40000 ALTER TABLE `productCategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `user_id` int NOT NULL,
  `ROLE_CLIENTE` tinyint(1) DEFAULT '1',
  `ROLE_FUNC` tinyint(1) DEFAULT '0',
  `ROLE_GERENTE` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`user_id`),
  CONSTRAINT `role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,1,0,1),(6,1,0,0),(7,1,1,0);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'gerente@test.com','123'),(6,'cliente@test.com','123'),(7,'funcionario@test.com','123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userData`
--

DROP TABLE IF EXISTS `userData`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userData` (
  `user_id` int NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `cpf` varchar(11) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `cep` varchar(8) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `addressNumber` varchar(10) DEFAULT NULL,
  `complement` varchar(100) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cpf`),
  UNIQUE KEY `cpf` (`cpf`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `userData_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userData`
--

LOCK TABLES `userData` WRITE;
/*!40000 ALTER TABLE `userData` DISABLE KEYS */;
/*!40000 ALTER TABLE `userData` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-30 16:52:37
