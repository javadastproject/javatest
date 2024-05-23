-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: airbnb
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `host`
--

DROP TABLE IF EXISTS `host`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `host` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first name` varchar(45) NOT NULL,
  `last name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  `filepath` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `host`
--

LOCK TABLES `host` WRITE;
/*!40000 ALTER TABLE `host` DISABLE KEYS */;
INSERT INTO `host` VALUES ('aggvour','1956','Aggelos','Vourdoumis','aggvour@gmail.com','6955623145','C:/IMG_20160816_223459.jpg'),('andlab','an1947','Andreas','Labropoulos','andlab@hotmail.com','691356704','C:/IMG_20160814_195747.jpg'),('annlov','1945','Anna','Loverdou','annlov@gmail.com','6974564182','C:/PC230212.JPG'),('antloud','1234','Antonis','Loudaros','antloud@gmail.com','698123677','C:/IMG_20160820_230721.jpg'),('apbal','ap1996','Apostolos','Baloumis','apbal@gmail.com','693407891','C:/IMG_20160817_215417.jpg'),('gravan','gravan1457','Giannis','Ravanis','gravan@hotmail.com','694302116','C:/IMG_20160816_223459.jpg'),('kostant','1984','Konstantinos','Antoniadis','kostant@gmail.com','6974584622','C:/IMG_20160820_230706.jpg'),('maran','1970','Maria','Anastasiou','maran@gmail.com','6954356182','C:/PC230208.JPG'),('nikger','1975','Nikolaos','Geralhs','nikger@hotmail.com','6988654152','C:/PC230203.JPG'),('petrpap','2017','Petros','Papadopoulos','petrpap@gmail.com','697781234','C:/IMG_20160816_223505.jpg'),('prep','25687','Panagiotis','Repanis','prep@hotmail.com','694514562','C:/IMG_20160820_230706.jpg'),('stavkef','1976','Stavros','Kefalopoulos','stavkef@gmail.com','6957684172','C:/PC230204.JPG');
/*!40000 ALTER TABLE `host` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house`
--

DROP TABLE IF EXISTS `house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `house` (
  `location` varchar(45) NOT NULL,
  `first date` date NOT NULL,
  `last date` date NOT NULL,
  `max number of persons` int(11) NOT NULL,
  `min value of tenancy` double NOT NULL,
  `additional cost per person` double NOT NULL,
  `type of rental space` varchar(45) NOT NULL,
  `smoking` int(11) NOT NULL,
  `pets` int(11) NOT NULL,
  `event` int(11) NOT NULL,
  `min number of days` int(11) NOT NULL,
  `description` varchar(45) NOT NULL,
  `number of beds` int(11) NOT NULL,
  `number of baths` int(11) NOT NULL,
  `number of bedrooms` int(11) NOT NULL,
  `living room` int(11) NOT NULL,
  `area` double NOT NULL,
  `filepath` varchar(45) NOT NULL,
  `stars` int(11) NOT NULL,
  `address` varchar(45) NOT NULL,
  `transport` varchar(45) NOT NULL,
  `filepaths` varchar(90) NOT NULL,
  `username host` varchar(45) NOT NULL,
  `reviews` int(11) NOT NULL,
  `reviews host` int(11) NOT NULL,
  `messages` varchar(120) NOT NULL,
  PRIMARY KEY (`location`,`first date`,`last date`,`max number of persons`,`min value of tenancy`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house`
--

LOCK TABLES `house` WRITE;
/*!40000 ALTER TABLE `house` DISABLE KEYS */;
INSERT INTO `house` VALUES ('Athens','2017-01-01','2017-01-14',3,5.3,5.5,'private room',0,1,1,2,'The room has 3 beds.',3,1,1,1,27.6,'C:/PC230213.JPG',4,'Patission St. 15','Bus','C:\\PC230214.JPG,C:\\PC230215.JPG','maran',0,0,' '),('Athens','2017-01-01','2017-01-16',3,4.6,4.5,'shared room',0,1,1,3,'The room has television.',3,1,1,1,27.6,'C:/IMG_20160814_195747.jpg',5,'Pericleous St. 23','Bus','C:\\IMG_20160820_230706.jpg,C:\\IMG_20160820_230721.jpg','petrpap',0,0,' '),('Athens','2017-01-01','2017-01-30',3,4.8,4.7,'shared room',0,1,1,3,'The room has 3 beds.',3,1,1,1,35.6,'C:/PC230202.JPG',5,'Aiolos St. 21','Bus','C:/PC230203.jpg,C:/PC230204.jpg','andlab',5,5,'I cannnot sleep./Why?'),('Athens','2017-01-02','2017-01-14',3,5.8,5.7,'shared room',0,1,1,3,'The room has heating.',3,1,1,1,30.4,'C:/PC280706.JPG',5,'Pericleous St. 10','Bus','C:\\PC280707.JPG,C:\\PC280709.JPG','stavkef',0,0,' '),('Athens','2017-01-02','2017-01-15',2,4.5,4.3,'private room',0,1,1,2,'The room has 2 beds.',2,1,1,1,28.6,'C:/PC280705.JPG',5,'Panepisthmioy 28','Bus','C:/PC280706.jpg,C:/PC280707.jpg,C:\\PC280709.JPG','andlab',5,5,'I have a problem./What problem?/I cannot sleep./Why?/Because neighbors are making noise./I will help you.'),('Athens','2017-01-02','2017-01-17',3,6.4,6.5,'shared room',0,1,1,3,'The room has television and heating.',3,1,1,1,32.5,'C:/IMG_20160820_230706.jpg',5,'Panepisthmioy 12','Taxi','C:\\IMG_20160820_230721.jpg,C:\\PC230202.JPG','petrpap',0,0,'I have a problem./What problem?'),('Athens','2017-01-03','2017-01-16',2,5.1,5.2,'private room',0,1,1,2,'The room has 2 beds.',2,1,1,1,29.7,'C:/PC280707.JPG',4,'Patission St. 23','Taxi','C:\\PC280709.JPG,C:\\PC280710.JPG','stavkef',0,0,' '),('Athens','2017-01-03','2017-01-19',6,6.3,6.4,'complete housing',0,1,1,3,'The house has kitchen and lift.',6,3,3,1,60.3,'C:/PC230211.JPG',4,'Heracleous St. 18','Taxi','C:\\PC230212.JPG,C:\\PC230213.JPG,C:\\PC230214.JPG','maran',4,4,'I want breakfast./I will bring it.'),('Athens','2017-01-04','2017-01-17',3,5.5,5.5,'shared room',0,1,1,3,'The room has heating.',3,1,1,1,23.6,'C:/PC230208.JPG',5,'Patission St. 13','Bus','C:\\PC230211.JPG,C:\\PC230212.JPG','petrpap',0,0,' '),('Athens','2017-01-04','2017-01-18',5,6.7,6.8,'complete housing',0,1,1,3,'The house has kitchen.',6,3,3,1,50.9,'C:/PC230215.JPG',5,'Aiolos St. 27','Taxi','C:\\PC230216.JPG,C:\\PC230217.JPG,C:/\\PC280705.JPG','stavkef',5,5,'I want breakfast./I will bring it./Thank you.'),('Athens','2017-01-05','2017-01-17',2,6.1,6.2,'shared room',0,1,1,2,'The room has air-condition.',2,1,1,1,34.2,'C:/PC230214.JPG',5,'Heracleous St. 14','Bus','C:\\PC230215.JPG,C:\\PC230216.JPG','maran',0,0,' '),('Athens','2017-01-05','2017-01-19',2,6.2,6.3,'private room',0,1,1,2,'The room has 2 beds.',2,1,1,1,32.1,'C:/PC230217.JPG',5,'Aiolos St. 17','Bus','C:\\PC280705.JPG,C:\\PC280706.JPG','petrpap',0,0,' '),('Athens','2017-03-12','2017-03-23',9,2.6,3.6,'shared room',0,1,1,2,'The house has 2 beds.',1,1,1,1,24.8,'C:/PC230202.jpg',4,'Pericleous St. 19','Bus','C:/PC230203.jpg,C:/PC230204.jpg','aggvour',4,4,'I want breakfast./I will bring it.'),('Athens','2017-03-12','2017-03-24',9,2.7,1.2,'shared room',0,1,1,3,'The room has 2 beds.',1,1,1,1,12.7,'C:/PC230203.jpg',4,'Aiolos St. 19','Bus','C:/PC230204.jpg,C:/PC230205.jpg','gravan',4,4,'I have dirty clothes./We will clean them up.'),('Athens','2017-05-01','2017-05-25',7,10.9,2.4,'shared room',0,1,1,4,'The room has 2 beds, windows and heating.',6,4,2,0,97.2,'C:/PC230204.jpg',5,'Heracleous St. 25','Taxi','C:/PC230205.jpg,C:/PC230206.jpg','aggvour',5,5,'I will go out./Have fun.'),('Athens','2017-06-08','2017-06-12',6,17.6,12.3,'private room',1,1,1,4,'The room has television and air-condition.',7,3,3,1,107.9,'C:/PC230205.jpg',3,'Heracleous St. 30','Taxi','C:/PC230206.jpg,C:/PC230208.jpg','antloud',3,3,'I do not have hot water./We will find the problem.'),('Crete','2015-04-09','2015-04-19',8,8.5,9.2,'private room',1,1,0,6,'The room has bathroom and 3 beds.',2,1,1,1,102.6,'C:/PC230206.jpg',4,'Eth. Venizelou 40','Taxi','C:/PC230208.jpg,C:/PC230211.jpg','antloud',4,4,'Neighbors are making noise./I will make them calm.'),('Crete','2017-02-05','2017-02-18',5,9.4,10.4,'complete housing',0,1,0,2,'The house has heating and many beds.',6,4,3,0,116.8,'C:/PC230208.jpg',3,'Arkadiou 1','Bus','C:/PC230211.jpg,C:/PC230212.jpg','andlab',3,3,'I am sick./I will call a doctor./Thank you.'),('Crete','2017-03-04','2017-03-15',3,5.7,5.6,'private room',0,1,1,3,'The room has heating.',3,1,1,1,32.7,'C:/PC230217.JPG',5,'Arkadiou 2','Taxi','C:/PC280705.JPG,C:/PC280706.JPG','maran',5,5,'I have a problem.'),('Lefkada','2016-07-10','2016-07-19',7,8.2,7.2,'private room',0,1,1,3,'The room has 3 beds and television.',3,1,1,0,120.8,'C:/PC230211.jpg',5,'Georgios Machairas 20','Bus','C:/PC230212.jpg,C:/PC230213.jpg,C:/PC230214.jpg','apbal',5,5,'I have no appetite to eat./Why?'),('Lefkada','2017-03-11','2017-03-23',2,6.7,6.8,'shared room',0,1,1,2,'The room has 2 beds.',2,1,1,1,45.3,'C:/PC230213.JPG',5,'Georgios Machairas 16','Taxi','C:\\PC230214.JPG,C:\\PC230215.JPG','annlov',0,0,' '),('Lefkada','2017-03-12','2017-03-22',5,7.4,8.1,'shared room',1,1,1,2,'The room has television and balcony.',4,2,2,1,104.9,'C:/PC230212.jpg',5,'Stratigou I. Mela St. 25','Taxi','C:/PC230213.jpg,C:/PC230214.jpg,C:/PC280706.jpg','apbal',5,5,'I have a problem./What problem?'),('London','2017-04-13','2017-04-19',9,2.8,2.4,'shared room',0,1,1,4,'The room has 2 beds.',2,1,1,1,23.5,'C:/PC280705.jpg',4,'Baker St. 17','Bus','C:/PC280706.jpg,C:/PC280707.jpg','andlab',4,4,'I cannot sleep./Why?/Because neighbors are making noise.'),('Naxos','2016-02-03','2016-02-13',4,9.6,5.7,'shared room',0,0,0,3,'The room has television and balcony.',8,5,5,1,94.2,'C:/PC280706.jpg',4,'Ioannis Dellarokas St. 31','Taxi','C:/PC280707.jpg,C:/PC280709.jpg','kostant',4,4,'My room is dirty./We will clean it up./Thank you.'),('Naxos','2016-03-01','2016-03-17',7,13.6,8.9,'complete housing',1,0,1,5,'The house has 2 floors.',6,3,3,0,89.2,'C:/PC280707.jpg',3,'Ioannis Dellarokas St. 20','Bus','C:/PC280709.jpg,C:/PC280710.jpg','prep',3,3,'I am cold./We will bring blankets./Thank you.'),('Naxos','2017-04-02','2017-04-15',5,6.8,6.7,'complete housing',0,1,1,3,'The house has heating and lift.',8,3,4,1,56.8,'C:/PC230203.JPG',5,'Ioannis Dellarokas St. 28','Bus','C:\\PC230204.JPG,C:\\PC230205.JPG,C:/\\PC230206.JPG,C:/\\PC230208.JPG','stavkef',5,5,'I have a problem./What problem?'),('Thessaloniki','2015-06-09','2015-06-27',9,11.6,6.9,'complete housing',0,1,0,6,'The house has kitchen, garden and 2 floors.',7,4,4,0,100.5,'C:/PC280709.jpg',3,'26 Oktovriou St. 24','Bus','C:/PC280710.jpg,C:/PC230202.jpg','petrpap',3,3,'I will go out./Have fun.'),('Thessaloniki','2017-04-05','2017-05-23',10,16.2,7.9,'shared room',1,0,1,3,'The room has television and heating.',3,2,2,1,90.8,'C:/PC280710.jpg',3,'Acheloou St. 26','Taxi','C:/PC230212.jpg,C:/PC230213.jpg','kostant',3,3,'My TV is not working./We will find the problem.'),('Thessaloniki','2017-07-08','2017-07-18',3,10.8,10.6,'shared room',0,1,1,3,'The room has 3 beds.',3,1,1,1,95.8,'C:/PC230212.JPG',5,'26 Oktovriou St. 19','Taxi','C:\\PC230213.JPG,C:\\PC230214.JPG','stavkef',5,5,'I have a problem./What problem? ');
/*!40000 ALTER TABLE `house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first name` varchar(45) NOT NULL,
  `last name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  `filepath` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES ('spkout','sp1936','Spyros','Koutakis','spkout@hotmail.com','698124678','C:/IMG_20160817_215846.jpg');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant`
--

DROP TABLE IF EXISTS `tenant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenant` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first name` varchar(45) NOT NULL,
  `last name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  `filepath` varchar(45) NOT NULL,
  `location house` varchar(45) NOT NULL,
  `first date house` date NOT NULL,
  `last date house` date NOT NULL,
  `max number of persons house` int(11) NOT NULL,
  `min value of tenancy house` double NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant`
--

LOCK TABLES `tenant` WRITE;
/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` VALUES ('alexavl','1946','Alexandra','Avloniti','alexavl@hotmail.com','6974624589','C:/PC230202.JPG','Athens','2017-01-02','2017-01-15',2,4.5),('alexdoum','alex1948','Alexis','Doumis','alexdoumis@gmail.com','698279861','C:/PC230213.jpg','Athens','2017-01-01','2017-01-30',3,4.8),('alexmav','1234','Alexis','Mavris','alexmav@gmail.com','6947548152','C:/PC230214.jpg','Athens','2017-01-02','2017-01-15',2,4.5),('antpap','1954','Antonis','Papandreou','antpap@gmail.com','6978455160','C:/PC230215.jpg','Lefkada','2016-07-10','2016-07-19',7,8.2),('antper','1958','Antonia','Peridi','antper@gmail.com','6947523145','C:/IMG_20160820_230721.jpg',' ','0002-11-30','0002-11-30',0,0),('chlam','1941','Christos','Lamnidis','chlam@hotmail.com','6974556183','C:/IMG_20160820_230706.jpg','Athens','2017-01-04','2017-01-18',5,6.7),('eirant','1952','Eirini','Antonopoulou','eirant@gmail.com','6987654075','C:/PC230204.JPG','Athens','2017-01-01','2017-01-30',3,4.8),('elkar','23041986','Eleni','Karousou','elkar@hotmail.com','694782548','C:/PC230216.jpg','Naxos','2016-02-03','2016-02-13',4,9.6),('emmand','1978','Emmanouil','Andreou','emmand@gmail.com','6949765482','C:/PC230202.JPG','Thessaloniki','2015-06-09','2015-06-27',9,11.6),('iasver','1980','Iason','Veronis','iasver@gmail.com','6975415382','C:/PC230203.JPG','Crete','2017-03-04','2017-03-15',3,5.7),('spdav','19021987','Spyros','Davlis','spdav@hotmail.com','695401234','C:/PC230217.jpg','Crete','2017-03-04','2017-03-15',3,5.7),('spevg','1940','Spyros','Eugeniou','spevg@gmail.com','6979834178','C:/IMG_20160816_223505.jpg','Naxos','2017-04-02','2017-04-15',5,6.8),('stamgav','1951','Stamatios','Gavras','stamgav@gmail.com','6975468432','C:/PC280709.JPG','Athens','2017-01-03','2017-01-19',6,6.3),('viciak','1949','Victor','Iakovou','viciak@gmail.com','6943215345','C:/PC280710.JPG',' ','0002-11-30','0002-11-30',0,0);
/*!40000 ALTER TABLE `tenant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-29 13:33:57
