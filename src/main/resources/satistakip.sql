/*
SQLyog Community Edition- MySQL GUI v6.13
MySQL - 5.0.24-community-nt : Database - satistakip
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `satistakip`;

USE `satistakip`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Data for the table `firma_odeme_table` */

insert  into `firma_odeme_table`(`id`,`odeme_tutari`,`odeme_yapan_kisi`,`odeme_tarihi`,`firma_kodu`) values (0000000001,'100.00','resul','2013-06-30','1'),(0000000002,'1000.00','resul','2013-06-30','1'),(0000000003,'1000.00','resul','2013-06-30','1'),(0000000004,'500.00','resul','2013-06-30','1'),(0000000005,'500.00','resul','2013-06-30','1'),(0000000006,'60.00','resul','2013-06-30','10'),(0000000007,'0.00','','2013-06-30','10'),(0000000008,'100.00','resul','2013-06-30','10');

/*Data for the table `firma_tanim_table` */

insert  into `firma_tanim_table`(`FIRMA_ID`,`FIRMA_ADI`,`TARIH`,`ADRES`,`gsm`,`email`) values (1,'akçay','2012-01-11',NULL,NULL,NULL),(2,'obaçay','2012-01-11',NULL,NULL,NULL),(3,'poli','2013-01-27','karagümrük caddesi\nkaraköy',NULL,NULL),(4,'çaykur','2013-01-27','rize',NULL,NULL),(5,'ferda pazarlama','2013-06-30','aasdasd',NULL,NULL),(10,'orçun','2013-06-30','gelgeç caddesi',1234567890,NULL),(11,'kemaliye','2013-06-30','sadasdas',1212121212,NULL);

/*Data for the table `kullanici_table` */

/*Data for the table `musteri_satis_table` */

insert  into `musteri_satis_table`(`SATIS_ID`,`MUSTERI_KODU`,`SATICI_KODU`,`URUN_KODU`,`ADET`,`SATIS_TARIHI`,`TUTAR`,`SATIS_FIYATI`,`ETKIN`) values (148,2,2,20,'4','2013-04-03 00:00:00','10.00','0.00','1'),(149,2,2,16,'1','2013-04-03 00:00:00','12.00','0.00','1'),(150,2,2,17,'12','2013-04-03 00:00:00','4.00','0.00','1'),(151,2,3,1,'1','2013-04-23 00:00:00','20.00','0.00','1'),(152,2,3,5,'1','2013-04-23 00:00:00','8.00','0.00','1'),(153,2,3,20,'1','2013-04-23 00:00:00','3.00','0.00','1');

/*Data for the table `musteri_tanim_table` */

insert  into `musteri_tanim_table`(`MUSTERI_ID`,`MUSTERI_ADI`,`MUSTERI_SOYADI`,`GSM`,`EMAIL`,`TARIH`,`MUSTERI_ADRES`,`AKTIF`) values (1,'çağdaş','kemal tuğcu','212121212','2313123','2013-01-13','çiçek kafe sdasdasd ',1),(2,'zerafettin','dağcı','12121212','ahmet@ttnet.net','2013-01-08','cumhuriyet mah, doruk sok, no:3A\nd:28',1),(3,'mehmet','dağcı','423423423','mehmet@gmail.com','2013-01-08','bağarası köyü - polateli / Kilis',1),(4,'çicek','cafe','312312312','cicek@face.net','2013-01-08','malatya',1),(5,'fatma','dağcı','34323423','fatma@fatma.net','2013-01-08','cengin',1),(6,'kemal','serin','1121212','213123','2013-01-08','afdgadfg',1),(10,'ahmet','murat eli maşalı','232312312','',NULL,'sfasmdklasmdasdas',0),(11,'kemalettin','tuğcu',NULL,'',NULL,'sdfdlasmdklasmda',0),(12,'resul','dağcı','121212','resul@resul.net','2013-01-11','fşgakdfgkad',1),(13,'osman','çıldırmış',NULL,'','2013-02-09','sadmasdm asdasd',1),(19,'ahmet','kemal','121212','sadas','2013-01-08','asasdas',1),(50,'cengiz','dal','1233','','2013-02-10','bagcı',1),(89,'ismail','acar','23112312','','2013-01-14','dfljadlfv adfgöaşdfkfgop',1),(111,'ahmet','ahamet',NULL,'','2013-02-10','',1),(120,'kenan','çosşun','555555555','','2013-01-13','dffldksmf sfsdmflsmdf fmasklfmaklsd',1),(123,'ahmet','urgancı','2312312','wedd','2013-02-10','ZXCZSDCASDASD',1),(211,'keafd','asdasdas',NULL,'asdasdas','2013-02-10','',1),(300,'menderes','caycı',NULL,'','2013-02-10','bağcılar falanca yeri',1),(777,'ASDASDAS','ASDASD',NULL,'','2013-02-10','SADASDA',1),(1999,'ASDASDAS','ASDASDA',NULL,'','2013-02-10','SAASDAS',1),(2121,'sdasd','dasdas',NULL,'','2013-02-10','',1),(2332,'asda','asdas','2312','asda@ttnet.tc','2013-02-23','asdasd',1),(9999,'agafgadl','asfdasdkj',NULL,'','2013-02-10','',1),(12345,'sef','sene',NULL,'','2013-04-07','sdhztfjzytrtj',1),(21212,'asdas','sasdas',NULL,'','2013-02-10','',1),(43534,'leman','caycı','23213213','ahmet@net.tc','2013-02-23','asdasd',1),(99932,'SDASD','ASDASDAS',NULL,'','2013-02-10','SDFMASDJKAIOS',1),(121212,'ahmet','kemal serin','21312312','tereci@nt.com','2013-02-23','dssddfasd',1),(342423,'sdasda','CVDFS',NULL,'','2013-02-10','SDFASLPDASKP',1),(450349,'fsdfsd','sdfasdas',NULL,'','2013-02-10','sdfsdfsd',1),(534543,'dasdsa','dasdasd',NULL,'','2013-02-10','',1),(645896,'dsadas','sadasd',NULL,'sadas','2013-02-10','',1),(659756,'dasdas','asdlaskl',NULL,'sadas','2013-02-10','sdasd',1),(433485834,'SADDASD','ASDAS',NULL,'','2013-02-10','SADFKLASMDLASM',1);

/*Data for the table `satici_tanim_table` */

insert  into `satici_tanim_table`(`SATICI_ID`,`SATICI_ADI`,`SATICI_SOYADI`,`PLAKA`,`TARIH`,`AKTIF`,`GSM`,`EMAIL`) values (1,'TÜLAY','DAĞCI','34UUV 95','2012-01-01','1','5555555555','ahmet@ahmet.net'),(2,'AHMET','DAĞCI','25 THH 134','2012-03-01','1','22222222','mehmet@mehmet.net'),(3,'RESUL','DAĞCI','23 TGB 345','2012-02-27','1','1212121212','resul@ttnet.net');

/*Data for the table `satis_table` */

insert  into `satis_table`(`SATIS_ID`,`SATICI_KODU`,`URUN_KODU`,`ADET`,`SATIS_TARIH`) values (82,1,17,'10','2013-04-23 00:00:00'),(83,1,16,'10','2013-04-23 00:00:00'),(84,1,20,'10','2013-04-23 00:00:00');

/*Data for the table `tahsilat_table` */

insert  into `tahsilat_table`(`TAHSILAT_ID`,`MUSTERI_ID`,`TUTAR`,`KULLANICI`,`TARIH`) values (37,'2','10.00','RESUL','2013-04-04');

/*Data for the table `urun_iade_table` */

insert  into `urun_iade_table`(`iade_id`,`urun_kodu`,`satici_kodu`,`iade_tarihi`,`iade_nedeni`,`tarih`,`musteri_kodu`,`adet`) values (1,22,3,'2013-02-10',NULL,NULL,1,1),(2,6,3,'2013-02-10',NULL,NULL,1,1),(3,6,3,'2013-02-10',NULL,NULL,1,1),(4,22,3,'2013-02-10',NULL,NULL,1,1),(5,16,2,'2013-02-10',NULL,NULL,2,1),(6,20,2,'2013-02-10',NULL,NULL,2,1),(7,17,3,'2013-02-10',NULL,NULL,1,1),(8,20,3,'2013-02-10',NULL,NULL,1,1),(9,17,2,'2013-02-09',NULL,NULL,2,1),(10,1,2,'2013-02-10',NULL,NULL,1,1),(11,20,2,'2013-04-07',NULL,NULL,12345,1),(12,16,2,'2013-04-07',NULL,NULL,12345,1),(13,20,2,'2013-04-07',NULL,NULL,12345,1),(14,17,2,'2013-04-07',NULL,NULL,12345,1),(15,17,2,'2013-04-07',NULL,NULL,12345,1),(16,16,2,'2013-04-07',NULL,NULL,12345,1),(17,20,2,'2013-04-07',NULL,NULL,12345,1);

/*Data for the table `urun_stock_table` */

insert  into `urun_stock_table`(`STOCK_ID`,`FIRMA_ADI`,`URUN_ADI`,`KOLI_ADET`,`ADET`,`BIRIM_FIYATI`,`TARIH`,`URUN_KODU`,`FIRMA_KODU`) values (4,NULL,'sadas',12,12,200,'2013-01-21',1,NULL),(5,NULL,'keloğlan',21,12,20,'2013-01-22',1,NULL),(6,NULL,NULL,20,10,40,'2013-01-27',1,'1'),(7,NULL,NULL,12,12,24,'2013-01-27',1,'1'),(8,NULL,NULL,12,12,25,'2013-01-27',1,'1'),(9,NULL,NULL,45,12,12,'2013-01-27',1,'1'),(10,NULL,NULL,121,12,54,'2013-01-27',1,'1'),(11,NULL,NULL,78,90,30,'2013-01-27',2,'1'),(12,NULL,NULL,60,50,20,'2013-01-27',5,'1'),(13,NULL,NULL,50,10,28,'2013-01-27',2,'2'),(14,NULL,NULL,89,12,5,'2013-01-27',14,'1'),(15,NULL,NULL,10,10,30,'2013-01-27',1,'1'),(16,NULL,NULL,50,10,34,'2013-01-27',3,'1'),(17,NULL,NULL,10,20,35,'2013-01-27',1,'1'),(18,NULL,NULL,10,10,1,'2013-01-27',13,'2'),(19,NULL,NULL,1,100,10,'2013-06-30',16,'10');

/*Data for the table `urun_tanim_table` */

insert  into `urun_tanim_table`(`urun_kodu`,`urun_adi`,`urun_aciklama`,`fiyat`,`image`,`type`,`alis_fiyati`,`tutar`) values (1,'Karaali Çay','Karaali Çay',50,'karali_cay.jpg','CAY',40,NULL),(2,'Çayder Çay','Çayder Çay',48,'cayder_cay.jpg','CAY',40,NULL),(3,'Reşat Çay','Reşat Çay',18,'resat_cay.jpg','CAY',12.5,NULL),(4,'Seylan Çay','Seylan Çay',18,'seylan_cay.jpg','CAY',12.5,NULL),(5,'Akbar Çay','Akbar Çay',20,'akbar_cay.jpg','CAY',15,NULL),(6,'Mehmet Efendi Türk Kahvesi','Mehmet Efendi Türk Kahvesi',3,'kuru_kahveci_mehmet_efendi.jpg','TURKKAHVESI',1.5,NULL),(7,'Kükel Kahve','Kükel Kahve',10,'kukel_kahve.jpg','KUKELKAHVE',6,NULL),(8,'Kükel Kahve','Kükel Kahve',8,'kukel_kahve_big.jpg','KUKELKAHVEBUYUK',5,NULL),(9,'Differ Kahve Beyazlatıcı','Differ Kahve Beyazlatıcı',10,'differ_kahve_beyazlatici.jpg','DIFFERKAHVEBEYAZLATICI',5,NULL),(10,'Poli Kahve Beyazlatıcı','Poli Kahve Beyazlatıcı',8,'poli_kahve_beyazlatici.jpg','DIFFERKAHVEBEYAZLATICI',4,NULL),(11,'Ori Portakal Toz İçecek','Ori Portakal Toz İçecek',2,'ori_portakal.jpg','ORIPORTAKAL',1.3,NULL),(12,'Ori Soğuk İçecek','Ori Soğuk İçecek',2.5,'ori_icecek_soguk.jpg','ORISOGUKICECEK',1.6,NULL),(13,'Meyve Suyu','Meyve Suyu',1.5,'meyoz_seftali_nektari.jpg','MEYOZSEFTALI',1,NULL),(14,'Poli Limonlu','Poli Limonlu',1.8,'poli_limon.jpg','POLILIMON',1.25,NULL),(15,'Çay Bardağı','Çay Bardağı',3,'cay_bardagi.jpg','CAYBARDAGI',2,NULL),(16,'Angora Oyun Kağıdı','Angora Oyun Kağıdı',18,'angora_oyun_kagidi.jpg','ANGORAKAGIT',12,NULL),(17,'Bardak Su','Bardak Su',1.5,'bardak_su.jpg','BARDAKSU',1,NULL),(18,'Şişe Su','Şişe Su',3,'sise_su.jpg','SISESU',2,NULL),(19,'Sütiş Ayran','Sütiş Ayran',3,'sutis_ayran.jpg','SUTISAYRAN',2.5,NULL),(20,'Balküpü Şeker','Balküpü Şeker',2.5,'bal_kupu_seker.jpg','BALKUPUSEKER',2,NULL),(21,'Sütsüz Oralet','Sütsüz Oralet',1.8,'ori_icecek_soguk.jpg','STSZ_ORA',1.3,NULL),(22,'Sütlü Oralet','Sütlü Oralet',2,'ori_icecek_soguk.jpg','STLU_ORA',1.5,NULL),(23,'Dayan Okey Takımı','Dayan Okey Takımı',10,'dayan_okey.jpg','DAYANOKEY',7,NULL),(24,'Masa Örtüsü','Masa Örtüsü',12,'masa_ortusu.jpg','MASA_ORTUSU',10,NULL),(27,'kaşık','çay kaşığı',1,NULL,'DIGER',NULL,NULL),(28,'soda','meyve',55,NULL,'SODA',NULL,NULL),(29,'osmanc?k çay','osmanc?k cay?',1,NULL,'CAY',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
