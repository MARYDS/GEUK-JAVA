-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: GEUK
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `constituency`
--

DROP TABLE IF EXISTS `constituency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `constituency` (
  `onsid` varchar(10) NOT NULL,
  `constituencyName` varchar(256) NOT NULL,
  `regionName` varchar(256) NOT NULL,
  `country` varchar(256) NOT NULL,
  `countyName` varchar(256) NOT NULL,
  PRIMARY KEY (`onsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `constituencylocauth`
--

DROP TABLE IF EXISTS `constituencylocauth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `constituencylocauth` (
  `onsid` varchar(20) NOT NULL,
  `areaCode` varchar(20) NOT NULL,
  `wardsCon` int(11) DEFAULT NULL,
  `wardsLA` int(11) DEFAULT NULL,
  PRIMARY KEY (`onsid`,`areaCode`),
  KEY `areaCode_idx` (`areaCode`),
  CONSTRAINT `areaCode` FOREIGN KEY (`areaCode`) REFERENCES `eureferendum` (`areacode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detail`
--

DROP TABLE IF EXISTS `detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detail` (
  `year` varchar(10) NOT NULL,
  `onsid` varchar(20) NOT NULL,
  `firstName` varchar(100) DEFAULT NULL,
  `surname` varchar(100) DEFAULT NULL,
  `fullName` varchar(256) NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `partyCode` varchar(100) NOT NULL,
  `votes` int(11) DEFAULT NULL,
  `share` double DEFAULT NULL,
  `change` double DEFAULT NULL,
  `wiki` varchar(256) DEFAULT NULL,
  `photo` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`year`,`onsid`,`fullName`,`partyCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `eureferendum`
--

DROP TABLE IF EXISTS `eureferendum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eureferendum` (
  `areaCode` varchar(10) NOT NULL,
  `areaName` varchar(256) DEFAULT NULL,
  `region` varchar(256) DEFAULT NULL,
  `electorate` int(11) DEFAULT NULL,
  `leavePercent` double DEFAULT NULL,
  `leaveVotes` int(11) DEFAULT NULL,
  `remainPercent` double DEFAULT NULL,
  `remainVotes` int(11) DEFAULT NULL,
  `turnoutPercent` double DEFAULT NULL,
  PRIMARY KEY (`areaCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `party`
--

DROP TABLE IF EXISTS `party`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party` (
  `partyCode` varchar(255) NOT NULL,
  `colour` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`partyCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `summary`
--

DROP TABLE IF EXISTS `summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `summary` (
  `year` varchar(10) NOT NULL,
  `onsid` varchar(20) NOT NULL,
  `electorate` int(11) DEFAULT NULL,
  `invalidVotes` int(11) DEFAULT NULL,
  `validVotes` int(11) DEFAULT NULL,
  `majority` int(11) DEFAULT NULL,
  `majorityPercent` double DEFAULT NULL,
  `partyCode` varchar(100) DEFAULT NULL,
  `firstName` varchar(100) DEFAULT NULL,
  `surname` varchar(100) DEFAULT NULL,
  `fullName` varchar(256) DEFAULT NULL,
  `partyChanged` varchar(10) DEFAULT NULL,
  `previousParty` varchar(100) DEFAULT NULL,
  `runnerUp` varchar(100) DEFAULT NULL,
  `narrative` varchar(100) DEFAULT NULL,
  `turnoutPercent` double DEFAULT NULL,
  PRIMARY KEY (`year`,`onsid`),
  KEY `onsid_idx` (`onsid`),
  KEY `partyCode_idx` (`partyCode`),
  KEY `previousParty_idx` (`previousParty`),
  KEY `runnerUp_idx` (`runnerUp`),
  CONSTRAINT `onsid` FOREIGN KEY (`onsid`) REFERENCES `constituency` (`onsid`),
  CONSTRAINT `partyCode` FOREIGN KEY (`partyCode`) REFERENCES `party` (`partycode`),
  CONSTRAINT `previousParty` FOREIGN KEY (`previousParty`) REFERENCES `party` (`partycode`),
  CONSTRAINT `runnerUp` FOREIGN KEY (`runnerUp`) REFERENCES `party` (`partycode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wardconlocauth`
--

DROP TABLE IF EXISTS `wardconlocauth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wardconlocauth` (
  `wardId` varchar(20) NOT NULL,
  `wardName` varchar(256) DEFAULT NULL,
  `onsid` varchar(20) NOT NULL,
  `constituencyName` varchar(256) DEFAULT NULL,
  `areaId` varchar(20) NOT NULL,
  `areaName` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`wardId`,`onsid`,`areaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-22 23:35:07
