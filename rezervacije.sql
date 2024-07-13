/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.4.32-MariaDB : Database - rezervacije
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rezervacije` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `rezervacije`;

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `korisnikID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  `datumRodjenja` date NOT NULL,
  `telefon` varchar(15) NOT NULL,
  PRIMARY KEY (`korisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `korisnik` */

insert  into `korisnik`(`korisnikID`,`ime`,`prezime`,`datumRodjenja`,`telefon`) values 
(1,'Ninko','Ninkovic','2000-09-29','0669409519'),
(4,'Pera','Peric','2004-02-04','0622255555'),
(6,'Misa','Kovac','2000-06-20','0669409519'),
(7,'Milos','Kovacevic','1996-06-20','0637262505');

/*Table structure for table `rezervacija` */

DROP TABLE IF EXISTS `rezervacija`;

CREATE TABLE `rezervacija` (
  `rezervacijaID` bigint(20) NOT NULL AUTO_INCREMENT,
  `datumOd` datetime NOT NULL,
  `komentar` varchar(255) NOT NULL,
  `brojLjudi` int(11) NOT NULL,
  `korisnikID` bigint(20) NOT NULL,
  `zaposleniID` bigint(20) NOT NULL,
  `brojRezervacije` int(20) NOT NULL,
  PRIMARY KEY (`rezervacijaID`),
  KEY `fk_rezervacija_korisnik` (`korisnikID`),
  CONSTRAINT `fk_rezervacija_korisnik` FOREIGN KEY (`korisnikID`) REFERENCES `korisnik` (`korisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `rezervacija` */

insert  into `rezervacija`(`rezervacijaID`,`datumOd`,`komentar`,`brojLjudi`,`korisnikID`,`zaposleniID`,`brojRezervacije`) values 
(7,'2024-04-20 13:30:00','izmenjen komentar',10,7,1,1),
(8,'2023-05-15 13:30:00','izmenjen komentar',5,4,1,2),
(9,'2024-07-20 13:30:00','sadsf',20,4,1,3),
(10,'2000-05-20 13:30:00','nova rez',10,1,1,4),
(11,'2023-05-20 20:00:00','izmeni ovo',2,6,1,20);

/*Table structure for table `stavkarezervacije` */

DROP TABLE IF EXISTS `stavkarezervacije`;

CREATE TABLE `stavkarezervacije` (
  `redniBroj` bigint(20) NOT NULL AUTO_INCREMENT,
  `datumRezervacije` date DEFAULT NULL,
  `rezervacijaID` bigint(20) NOT NULL,
  `stoID` bigint(20) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`redniBroj`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `stavkarezervacije` */

insert  into `stavkarezervacije`(`redniBroj`,`datumRezervacije`,`rezervacijaID`,`stoID`,`status`) values 
(1,'2023-07-20',7,3,'KREIRANA'),
(2,'2023-07-20',7,3,'KREIRANA'),
(3,'2024-07-12',7,3,'KREIRANA'),
(4,'2024-07-16',7,1,'KREIRANA'),
(19,'2023-05-19',11,3,'IZMENJENA'),
(20,'2023-05-19',11,3,'IZMENJENA');

/*Table structure for table `sto` */

DROP TABLE IF EXISTS `sto`;

CREATE TABLE `sto` (
  `stoID` bigint(20) NOT NULL AUTO_INCREMENT,
  `raspolozivostStola` varchar(255) DEFAULT NULL,
  `brojStola` int(11) DEFAULT NULL,
  `vrstaStola` varchar(255) DEFAULT NULL,
  `kapacitetStola` int(11) DEFAULT NULL,
  `rejonStola` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stoID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `sto` */

insert  into `sto`(`stoID`,`raspolozivostStola`,`brojStola`,`vrstaStola`,`kapacitetStola`,`rejonStola`) values 
(1,'SLOBODAN',4,'STANDARDNI',4,'PRIZEMLJE'),
(2,'SLOBODAN',6,'SANK',9,'PRVISPRAT'),
(3,'NIJE_ZA_UPOTREBU',13,'STANDARDNI',3,'BASTA'),
(4,'SLOBODAN',14,'SANK',6,'BASTA'),
(5,'SLOBODAN',1,'STANDARDNI',4,'BASTA'),
(7,'ZAUZET',2,'VISOKOSEDENJE',5,'BASTA'),
(8,'SLOBODAN',8,'STANDARDNI',2,'BASTA'),
(10,'ZAUZET',10,'SANK',2,'PRVISPRAT'),
(11,'ZAUZET',3,'SANK',6,'BASTA'),
(12,'SLOBODAN',5,'SANK',5,'BASTA');

/*Table structure for table `zaposleni` */

DROP TABLE IF EXISTS `zaposleni`;

CREATE TABLE `zaposleni` (
  `zaposleniID` bigint(20) NOT NULL AUTO_INCREMENT,
  `korisnickoIme` varchar(255) NOT NULL,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  `sifra` varchar(255) NOT NULL,
  `brojLK` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`zaposleniID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `zaposleni` */

insert  into `zaposleni`(`zaposleniID`,`korisnickoIme`,`ime`,`prezime`,`sifra`,`brojLK`) values 
(1,'pedja','Predrag','Paravinja','Pedja123','1234567891231'),
(2,'nedja','Nenad','Nenadovic','Nedja123','12435678421'),
(3,'pera','Pera','Peric','Pera123','1234567899871'),
(4,'jelena','Jelena','Jelic','Jelena','1234567891478');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
