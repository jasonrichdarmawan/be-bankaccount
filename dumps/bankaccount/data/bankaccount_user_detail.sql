CREATE DATABASE  IF NOT EXISTS `bankaccount` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bankaccount`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: bankaccount
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `user_detail`
--

DROP TABLE IF EXISTS `user_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_detail` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Account_Number` char(17) NOT NULL,
  `Birth_Date` date NOT NULL,
  `Address_3` varchar(45) NOT NULL,
  `Address_4` varchar(45) NOT NULL,
  `Address_1` varchar(45) NOT NULL,
  `Address_2` varchar(45) NOT NULL,
  `Zip_Code` int NOT NULL,
  `ISO_3166_1` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Account_Number_UNIQUE` (`Account_Number`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_detail`
--

LOCK TABLES `user_detail` WRITE;
/*!40000 ALTER TABLE `user_detail` DISABLE KEYS */;
INSERT INTO `user_detail` VALUES (1,'98993563492155716','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(2,'98993563492155717','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(3,'98999794785058816','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(4,'98999794785058817','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(5,'98999794785058818','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(6,'98999794785058819','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(7,'98999794785058821','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(8,'98999794785058823','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(9,'98999794785058825','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(10,'98999794785058827','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(11,'98999794785058829','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(12,'98999794785058831','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(13,'98999794785058833','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(14,'98999794785058835','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(15,'98999794785058837','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(16,'98999794785058839','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(17,'98999794785058841','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(18,'98999794785058843','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(19,'98999794785058845','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(20,'98999794785058847','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(21,'98999794785058849','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(22,'98999794785058851','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(23,'98999794785058853','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(24,'98999794785058855','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(25,'98999794785058856','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(26,'98999794785058858','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(27,'98999794785058860','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(28,'98999794785058862','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(29,'98999794785058864','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(30,'98999794785058866','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(31,'98999794785058868','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(32,'98999794785058870','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(33,'98999794785058872','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(34,'98999794785058874','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(35,'98999794785058876','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(36,'98999794785058878','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(37,'98999794785058880','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(38,'98999794785058882','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(39,'98999794785058884','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(40,'98999794785058886','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(41,'98999794785058888','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(42,'98999794785058890','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(43,'98999794785058892','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(44,'98999794785058894','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(45,'98999794785058896','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(46,'98999794785058898','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(47,'98999794785058900','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(48,'98999794785058902','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(49,'98999794785058904','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(50,'98999794785058906','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(51,'98999794785058908','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(52,'98999794785058910','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(53,'98999794785058912','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360),(54,'98999794785058914','1999-03-31','Gunung Putri','Nagrak','Kota Wisata Cibubur','Bogor',16967,360);
/*!40000 ALTER TABLE `user_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-21 21:47:53
