-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2016 at 10:19 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vaqpack`
--

<<<<<<< HEAD
-- --------------------------------------------------------
=======
DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `first` varchar(10) DEFAULT NULL,
  `last` varchar(15) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `salt` varchar(256) DEFAULT NULL,
  `pos` varchar(56) DEFAULT NULL,
  `permission` int(1) DEFAULT NULL,
  `pic` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-02 14:12:08
>>>>>>> 94e5316ce4566c325b600125155012859e852cf6

--
-- Table structure for table `courses`
--

<<<<<<< HEAD
CREATE TABLE `courses` (
  `prefix` varchar(4) DEFAULT NULL,
  `course_number` varchar(4) NOT NULL,
  `course_xml` longblob
=======
DROP TABLE IF EXISTS `Courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Courses` (
  `prefix` varchar(4) DEFAULT NULL,
  `course_number` varchar(4) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `course_xml` longblob,
  `abet_xml` longblob,
  `outcomes_xml` longblob,
  PRIMARY KEY (`course_number`)
>>>>>>> 94e5316ce4566c325b600125155012859e852cf6
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

<<<<<<< HEAD
-- --------------------------------------------------------
=======
--
-- Dumping data for table `courses`
--

LOCK TABLES `Courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;
>>>>>>> 94e5316ce4566c325b600125155012859e852cf6

--
-- Table structure for table `reminders`
--

<<<<<<< HEAD
CREATE TABLE `reminders` (
=======
DROP TABLE IF EXISTS `Reminders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reminders` (
>>>>>>> 94e5316ce4566c325b600125155012859e852cf6
  `reminder_id` int(11) DEFAULT NULL,
  `reminderName` varchar(20) NOT NULL,
  `message` varchar(256) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `TIME` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

<<<<<<< HEAD
-- --------------------------------------------------------
=======
--
-- Dumping data for table `reminders`
--

LOCK TABLES `Reminders` WRITE;
/*!40000 ALTER TABLE `reminders` DISABLE KEYS */;
/*!40000 ALTER TABLE `reminders` ENABLE KEYS */;
UNLOCK TABLES;
>>>>>>> 94e5316ce4566c325b600125155012859e852cf6

--
-- Table structure for table `style`
--

<<<<<<< HEAD
CREATE TABLE `style` (
=======
DROP TABLE IF EXISTS `Style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Style` (
>>>>>>> 94e5316ce4566c325b600125155012859e852cf6
  `name` varchar(56) NOT NULL,
  `style_sheet` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `style`
--

<<<<<<< HEAD
INSERT INTO `style` (`name`, `style_sheet`) VALUES
('', '');

-- --------------------------------------------------------

--
-- Table structure for table `testclob`
--

CREATE TABLE `testclob` (
  `XMLCLOB` longtext,
  `_id` int(255) NOT NULL,
  `XMLBLOB` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `testclob`
--

INSERT INTO `testclob` (`XMLCLOB`, `_id`, `XMLBLOB`) VALUES
('Department_Prefix_Number_Name_Description_Credit-hours_Lecture-hours_Lab-hours_Level_Schedule-type_Prerequisite_Co-requisite_Course-attributes_Legacy-number_Cross-lishted_Restrictions~Computer Science_CSCI_ 2388_Computer Science II HON_A second programming course includes problem solving by structured design. Provides an introduction to elementary data structures, including linked lists, stacks, queues, trees and graphs, and advanced programming techniques, including recursion, sorting and searching._3.000_ 3.000_0.000_ Undergraduate_Lecture_ Undergraduate level CSCI 1378 Minimum Grade of D or Undergraduate level CSCI 1370 Minimum Grade of D or Undergraduate level CMPE 1370 Minimum Grade of D _None_Degree Elective, CS Instruction Fee -LU_None_CMPE 2388_May not be enrolled in one of the following Programs: dnu MED in Educational Admin MPA in Public Administration Bus. Admin Accelerated online May not be enrolled in one of the following Levels: English Language Institute', 0, 0x3c3f786d6c2076657273696f6e3d22312e302220656e636f64696e673d225554462d3822207374616e64616c6f6e653d226e6f223f3e0d0a3c436f757273653e0d0a20203c4469766964653e546563686e6963616c20456c656374697665733c2f4469766964653e0d0a20203c4465706172746d656e743e436f6d707574657220536369656e63653c2f4465706172746d656e743e0d0a20203c5072656669783e435343493c2f5072656669783e0d0a20203c4e756d6265723e333334313c2f4e756d6265723e0d0a20203c4e616d653e536f66747761726520456e67696e656572696e672049493c2f4e616d653e0d0a20203c4465736372697074696f6e3e0d0a2020202054686520636f757273652077696c6c20636f7665722074686520616e616c79736973206f6620726571756972656d656e747320616e6420736f6674776172652061726368697465637475726520776974682061206d616a6f720d0a20202020656d706861736973206f6e206f626a6563742064657369676e2c20696d706c656d656e746174696f6e2c2074657374696e6720616e642076616c69646174696f6e2c206d61696e74656e616e636520616e6420736f66747761726520656e67696e656572696e672e204d6574686f647320666f72206576616c756174696e6720736f66747761726520666f7220636f72726563746e6573732c20616e642072656c696162696c6974792c2073797374656d2074657374696e670d0a20202020746563686e69717565732c2074657374696e6720746f6f6c7320616e64206c696d69746174696f6e73206f662074657374696e672c20416476616e636520536f66747761726520456e67696e656572696e6720746f7069637320737563680d0a2020202061732044657369676e205061747465726e732c20417370656374204f7269656e74656420456e67696e656572696e672c20496e7465726163746976652044657369676e204d6574686f64732c20616e6420466f726d616c0d0a2020202053706563696669636174696f6e20616e6420696e636c756465642e2053747564656e74732077696c6c20776f726b206f6e206c617267652067726f75702070726f6a656374732e0d0a20203c2f4465736372697074696f6e3e0d0a20203c4372656469742d686f7572733e332e3030302043726564697420686f7572733c2f4372656469742d686f7572733e0d0a20203c4c6563747572652d686f7572733e332e303030204c65637475726520686f7572733c2f4c6563747572652d686f7572733e0d0a20203c4c61622d686f7572733e302e303030204c616220686f7572733c2f4c61622d686f7572733e0d0a20203c4c6576656c3e556e64657267726164756174653c2f4c6576656c3e0d0a20203c5363686564756c652d747970653e4c6563747572653c2f5363686564756c652d747970653e0d0a20203c5072657265717569736974653e0d0a202020203c6974656d3e435343492d33333430206f7220434d50452d333334303c2f6974656d3e0d0a20203c2f5072657265717569736974653e0d0a20203c436f2d7265717569736974653e0d0a202020203c6974656d3e434d50452d333334313c2f6974656d3e0d0a20203c2f436f2d7265717569736974653e0d0a20203c4c65676163792d6e756d6265723e434f53432d343334363c2f4c65676163792d6e756d6265723e0d0a20203c43726f73732d6c69737465643e0d0a202020203c6974656d3e434d50452d333334313c2f6974656d3e0d0a20203c2f43726f73732d6c69737465643e0d0a20203c5265737472696374696f6e73313e0d0a0920203c6974656d3e646e752d4d454420696e20456475636174696f6e616c2041646d696e3c2f6974656d3e0d0a0920203c6974656d3e4d504120696e205075626c69632041646d696e697374726174696f6e3c2f6974656d3e0d0a0920203c6974656d3e4275732e2041646d696e202d416363656c657261746564206f6e6c696e653c2f6974656d3e0d0a093c2f5265737472696374696f6e73313e0d0a20203c5265737472696374696f6e73323e0d0a090920203c6974656d3e456e676c697368204c616e677561676520496e737469747574653c2f6974656d3e0d0a093c2f5265737472696374696f6e73323e0d0a20203c436f757273652d617474726962757465733e0d0a093c6974656d3e44656772656520456c6563746976653c2f6974656d3e0d0a093c6974656d3e435320496e737472756374696f6e20466565202d2048553c2f6974656d3e0d0a20203c2f436f757273652d617474726962757465733e0d0a3c2f436f757273653e);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `first` varchar(10) DEFAULT NULL,
  `last` varchar(15) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `salt` varchar(256) DEFAULT NULL,
  `pos` varchar(56) DEFAULT NULL,
  `permission` int(1) DEFAULT NULL,
  `pic` longblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------
=======
LOCK TABLES `Style` WRITE;
/*!40000 ALTER TABLE `style` DISABLE KEYS */;
/*!40000 ALTER TABLE `style` ENABLE KEYS */;
UNLOCK TABLES;
>>>>>>> 94e5316ce4566c325b600125155012859e852cf6

--
-- Table structure for table `user_courses`
--

<<<<<<< HEAD
CREATE TABLE `user_courses` (
=======
DROP TABLE IF EXISTS `User_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_courses` (
>>>>>>> 94e5316ce4566c325b600125155012859e852cf6
  `user_id` int(11) DEFAULT NULL,
  `course_prefix` varchar(4) DEFAULT NULL,
  `course_number` varchar(4) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `grade` varchar(1) DEFAULT NULL,
  `active` int(2) DEFAULT NULL,
  `hours` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

<<<<<<< HEAD
--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`course_number`);

--
-- Indexes for table `reminders`
--
ALTER TABLE `reminders`
  ADD PRIMARY KEY (`reminderName`),
  ADD KEY `reminder_id` (`reminder_id`);

--
-- Indexes for table `style`
--
ALTER TABLE `style`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `testclob`
--
ALTER TABLE `testclob`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);
=======
LOCK TABLES `User_courses` WRITE;
/*!40000 ALTER TABLE `user_courses` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_courses` ENABLE KEYS */;
UNLOCK TABLES;
>>>>>>> 94e5316ce4566c325b600125155012859e852cf6

--
-- Indexes for table `user_courses`
--
ALTER TABLE `user_courses`
  ADD KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `reminders`
--
ALTER TABLE `reminders`
  ADD CONSTRAINT `reminders_ibfk_1` FOREIGN KEY (`reminder_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `user_courses`
--
ALTER TABLE `user_courses`
  ADD CONSTRAINT `user_courses_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
