CREATE DATABASE  IF NOT EXISTS `forex_directory`;
USE `forex_directory`;

--
-- Table structure for table `forex_query`
--

DROP TABLE IF EXISTS `forex_query`;

CREATE TABLE `forex_query` (
  `query_number` int NOT NULL AUTO_INCREMENT,
  `input_currency` varchar(3) DEFAULT NULL,
  `output_currency` varchar(3) DEFAULT NULL,
  `exchange_rate` float(10) DEFAULT NULL,
  `query_date` varchar(10) DEFAULT NULL,
  `query_time` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`query_number`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



-- populate with example data

-- INSERT INTO `forex_query` 
-- VALUES 
-- (1, 'php','usd', 3.145, 'Thur', '10');

