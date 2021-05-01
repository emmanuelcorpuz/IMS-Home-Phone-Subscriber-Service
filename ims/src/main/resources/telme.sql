-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.11-MariaDB-log - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for telme
DROP DATABASE IF EXISTS `telme`;
CREATE DATABASE IF NOT EXISTS `telme` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `telme`;

-- Dumping structure for table telme.feature
DROP TABLE IF EXISTS `feature`;
CREATE TABLE IF NOT EXISTS `feature` (
  `featureid` int(11) NOT NULL AUTO_INCREMENT,
  `provisioned` varchar(50) NOT NULL DEFAULT '',
  `destination` varchar(50) NOT NULL DEFAULT ''
  PRIMARY KEY (`featureid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table telme.feature: ~2 rows (approximately)
/*!40000 ALTER TABLE `feature` DISABLE KEYS */;
INSERT INTO `feature` (`featureid`, `provisioned`, `destination`) VALUES
	(1, 'true', 'tel:+18675181010'),
	(2, 'true', 'tel:+18675181010');
/*!40000 ALTER TABLE `feature` ENABLE KEYS */;

-- Dumping structure for table telme.subscriber
DROP TABLE IF EXISTS `subscriber`;
CREATE TABLE IF NOT EXISTS `subscriber` (
  `phonenumber` bigint(20) NOT NULL,
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  `domain` varchar(50) NOT NULL DEFAULT '',
  `status` varchar(50) NOT NULL DEFAULT ''
  PRIMARY KEY (`phonenumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table telme.subscriber: ~1 rows (approximately)
/*!40000 ALTER TABLE `subscriber` DISABLE KEYS */;
INSERT INTO `subscriber` (`phonenumber`, `username`, `password`, `domain`, `status`) VALUES
	(18675181010, '18675181010', 'p@ssw0rd!', 'ims.mnc660.mcc302.3gppnetwork.org', 'ACTIVE'),
	(18675181012, '18675181012', 'p@ssw0rd!', 'ims.mnc660.mcc302.3gppnetwork.org', 'ACTIVE');
/*!40000 ALTER TABLE `subscriber` ENABLE KEYS */;

-- Dumping structure for table telme.subscriber_feature
DROP TABLE IF EXISTS `subscriber_feature`;
CREATE TABLE IF NOT EXISTS `subscriber_feature` (
  `phonenumber` bigint(20) DEFAULT NULL,
  `featureid` int(11) NOT NULL DEFAULT 0,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table telme.subscriber_feature: ~2 rows (approximately)
/*!40000 ALTER TABLE `subscriber_feature` DISABLE KEYS */;
INSERT INTO `subscriber_feature` (`phonenumber`, `featureid`, `id`) VALUES
	(18675181010, 1, 1),
	(18675181010, 2, 2),
	(18675181012, 2, 5);
/*!40000 ALTER TABLE `subscriber_feature` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
