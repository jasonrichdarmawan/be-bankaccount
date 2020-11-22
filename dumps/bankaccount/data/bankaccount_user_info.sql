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
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `User_ID` char(12) NOT NULL,
  `Account_Number` char(17) NOT NULL,
  `Full_Name` varchar(35) NOT NULL,
  `ISO_4217` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `User_ID_UNIQUE` (`User_ID`),
  UNIQUE KEY `Account_Number_UNIQUE` (`Account_Number`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'jasonric3103','98993563492155716','Jason Rich Darmawan Onggo Putra',360),(2,'jasonria3103','98993563492155717','Jason Rich Darmawan Onggo Putra',360),(3,'jasonrib3103','98999794785058816','Jason Rich Darmawan Onggo Putra',360),(4,'jasonrid3103','98999794785058817','Jason Rich Darmawan Onggo Putra',360),(5,'jasonrie3103','98999794785058818','Jason Rich Darmawan Onggo Putra',360),(6,'jasonrif3103','98999794785058819','Jason Rich Darmawan Onggo Putra',360),(7,'jasonrig3103','98999794785058821','Jason Rich Darmawan Onggo Putra',360),(8,'jasonrih3103','98999794785058823','Jason Rich Darmawan Onggo Putra',360),(9,'jasonrii3103','98999794785058825','Jason Rich Darmawan Onggo Putra',360),(10,'jasonrij3103','98999794785058827','Jason Rich Darmawan Onggo Putra',360),(11,'jasonrik3103','98999794785058829','Jason Rich Darmawan Onggo Putra',360),(12,'jasonril3103','98999794785058831','Jason Rich Darmawan Onggo Putra',360),(13,'jasonrim3103','98999794785058833','Jason Rich Darmawan Onggo Putra',360),(14,'jasonrin3103','98999794785058835','Jason Rich Darmawan Onggo Putra',360),(15,'jasonrio3103','98999794785058837','Jason Rich Darmawan Onggo Putra',360),(16,'jasonrip3103','98999794785058839','Jason Rich Darmawan Onggo Putra',360),(17,'jasonriq3103','98999794785058841','Jason Rich Darmawan Onggo Putra',360),(18,'jasonrir3103','98999794785058843','Jason Rich Darmawan Onggo Putra',360),(19,'jasonris3103','98999794785058845','Jason Rich Darmawan Onggo Putra',360),(20,'jasonrit3103','98999794785058847','Jason Rich Darmawan Onggo Putra',360),(21,'jasonriu3103','98999794785058849','Jason Rich Darmawan Onggo Putra',360),(22,'jasonriv3103','98999794785058851','Jason Rich Darmawan Onggo Putra',360),(23,'jasonriw3103','98999794785058853','Jason Rich Darmawan Onggo Putra',360),(24,'jasonrix3103','98999794785058855','Jason Rich Darmawan Onggo Putra',360),(25,'jasonriy3103','98999794785058856','Jason Rich Darmawan Onggo Putra',360),(26,'jasonriz3103','98999794785058858','Jason Rich Darmawan Onggo Putra',360),(27,'jasonraz3103','98999794785058860','Jason Rich Darmawan Onggo Putra',360),(28,'jasonrbz3103','98999794785058862','Jason Rich Darmawan Onggo Putra',360),(29,'jasonrcz3103','98999794785058864','Jason Rich Darmawan Onggo Putra',360),(30,'jasonrdz3103','98999794785058866','Jason Rich Darmawan Onggo Putra',360),(31,'jasonrez3103','98999794785058868','Jason Rich Darmawan Onggo Putra',360),(32,'jasonrfz3103','98999794785058870','Jason Rich Darmawan Onggo Putra',360),(33,'jasonrgz3103','98999794785058872','Jason Rich Darmawan Onggo Putra',360),(34,'jasonrhz3103','98999794785058874','Jason Rich Darmawan Onggo Putra',360),(35,'jasonrjz3103','98999794785058876','Jason Rich Darmawan Onggo Putra',360),(36,'jasonrkz3103','98999794785058878','Jason Rich Darmawan Onggo Putra',360),(37,'jasonrlz3103','98999794785058880','Jason Rich Darmawan Onggo Putra',360),(38,'jasonrmz3103','98999794785058882','Jason Rich Darmawan Onggo Putra',360),(39,'jasonrnz3103','98999794785058884','Jason Rich Darmawan Onggo Putra',360),(40,'jasonroz3103','98999794785058886','Jason Rich Darmawan Onggo Putra',360),(41,'jasonrpz3103','98999794785058888','Jason Rich Darmawan Onggo Putra',360),(42,'jasonrqz3103','98999794785058890','Jason Rich Darmawan Onggo Putra',360),(43,'jasonrrz3103','98999794785058892','Jason Rich Darmawan Onggo Putra',360),(44,'jasonrsz3103','98999794785058894','Jason Rich Darmawan Onggo Putra',360),(45,'jasonrtz3103','98999794785058896','Jason Rich Darmawan Onggo Putra',360),(46,'jasonruz3103','98999794785058898','Jason Rich Darmawan Onggo Putra',360),(47,'jasonrvz3103','98999794785058900','Jason Rich Darmawan Onggo Putra',360),(48,'jasonrwz3103','98999794785058902','Jason Rich Darmawan Onggo Putra',360),(49,'jasonrxz3103','98999794785058904','Jason Rich Darmawan Onggo Putra',360),(50,'jasonryz3103','98999794785058906','Jason Rich Darmawan Onggo Putra',360),(51,'jasonrzz3103','98999794785058908','Jason Rich Darmawan Onggo Putra',360),(52,'jasonazz3103','98999794785058910','Jason Rich Darmawan Onggo Putra',360),(53,'jasonbzz3103','98999794785058912','Jason Rich Darmawan Onggo Putra',360),(54,'jasonczz3103','98999794785058914','Jason Rich Darmawan Onggo Putra',360);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-21 21:47:54
