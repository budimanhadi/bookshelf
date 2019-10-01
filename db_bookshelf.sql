/*
SQLyog Ultimate v9.50 
MySQL - 5.5.5-10.1.38-MariaDB : Database - db_bookshelf
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_bookshelf` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_bookshelf`;

/*Table structure for table `tb_book` */

DROP TABLE IF EXISTS `tb_book`;

CREATE TABLE `tb_book` (
  `id_book` int(11) NOT NULL AUTO_INCREMENT,
  `slot_no` varchar(10) DEFAULT NULL,
  `book_title` varchar(100) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(20) DEFAULT NULL,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_book`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `tb_book` */

insert  into `tb_book`(`id_book`,`slot_no`,`book_title`,`author`,`create_date`,`create_by`,`update_date`,`update_by`) values (1,'1','Rich Dad Poor Dad','Robert Kiyosaki','2019-10-01 11:38:04','admin','0000-00-00 00:00:00',NULL),(4,'2','mari berbagi','santoso','2019-10-01 11:38:10',NULL,'0000-00-00 00:00:00',NULL),(5,'3','Janji Joni','Unknown','2019-10-01 11:36:15',NULL,'0000-00-00 00:00:00',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
