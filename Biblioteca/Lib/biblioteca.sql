-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: biblioteca
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `cuotasocio`
--

DROP TABLE IF EXISTS `cuotasocio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuotasocio` (
  `idcuotasocio` int(11) NOT NULL AUTO_INCREMENT,
  `monto` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`idcuotasocio`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuotasocio`
--

LOCK TABLES `cuotasocio` WRITE;
/*!40000 ALTER TABLE `cuotasocio` DISABLE KEYS */;
INSERT INTO `cuotasocio` VALUES (1,23,'2019-09-07'),(2,25,'2019-09-08'),(3,30,'2019-10-07'),(4,50,'2019-09-09'),(5,0,'2019-09-09'),(6,50,'2019-09-09'),(7,50,'2019-09-09'),(8,25,'2019-09-09');
/*!40000 ALTER TABLE `cuotasocio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresoegreso`
--

DROP TABLE IF EXISTS `ingresoegreso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingresoegreso` (
  `IDBalance` int(100) NOT NULL AUTO_INCREMENT,
  `Monto` float NOT NULL,
  `Tipo` varchar(45) DEFAULT NULL,
  `Fecha` date NOT NULL,
  `Clase` varchar(45) DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IDBalance`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresoegreso`
--

LOCK TABLES `ingresoegreso` WRITE;
/*!40000 ALTER TABLE `ingresoegreso` DISABLE KEYS */;
INSERT INTO `ingresoegreso` VALUES (1,123,'Otro','2019-09-08','ingreso','saumerio'),(2,1231,'Feria','2019-09-08','ingreso','123'),(3,123,NULL,'2019-09-08','egreso','asd'),(4,50,'Otro','2019-09-08','ingreso','galletitoa'),(5,123,'Feria','2019-09-08','ingreso','asd'),(6,123,'Feria','2019-09-08','ingreso','123'),(7,123,'Feria','2019-09-08','ingreso','123'),(8,0,'Feria','2019-09-08','ingreso','asd'),(9,0,'Feria','2019-09-08','ingreso','asd'),(10,0,'Otro','2019-09-08','ingreso','asd'),(11,0,'Feria','2019-09-09','egreso',''),(12,0,'Otro','2019-09-09','egreso',''),(13,0,'Otro','2019-09-09','egreso',''),(14,0,'Otro','2019-09-09','egreso',''),(15,15,'Otro','2019-09-09','egreso',''),(16,10000,'Otro','2019-09-09','egreso','Prueba'),(17,50,'Cuota','2019-09-10','ingreso',NULL),(18,1,'Cuota','2019-09-11','ingreso',NULL),(19,250,'Taller','2019-09-11','ingreso','prueba'),(20,300,'Otro','2019-09-11','egreso','test'),(21,30,'Cuota','2019-09-11','ingreso',NULL),(22,2000,'Feria','2019-09-11','ingreso','ibnj'),(23,2000,'Taller','2019-09-11','ingreso',''),(24,3000,'Otro','2019-09-11','ingreso',''),(25,7000,'Egreso','2019-09-11','egreso',''),(26,2000,'Egreso','2019-09-11','egreso',''),(27,2000,'Feria','2019-09-11','ingreso',''),(28,32132,'Egreso','2019-09-11','egreso',''),(29,123,'Egreso','2019-09-10','egreso',NULL),(30,50,'Cuota','2019-09-13','ingreso',NULL),(31,2,'Egreso','2019-09-13','egreso',''),(32,-50,'Cuota','2019-09-13','ingreso',NULL),(33,0,'Cuota','2019-09-13','ingreso',NULL),(34,-20,'Feria','2019-09-13','ingreso','');
/*!40000 ALTER TABLE `ingresoegreso` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-14 13:28:21
