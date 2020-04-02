
DROP TABLE if EXISTS ip_addresses;
DROP TABLE if EXISTS printers;
DROP TABLE if EXISTS addresses;
DROP TABLE if EXISTS extra;
DROP TABLE if EXISTS stores;

CREATE TABLE stores (
  id varchar(40) NOT NULL,
  supplyStartDate datetime DEFAULT NULL,
  openDate datetime DEFAULT NULL,
  closeDate datetime DEFAULT NULL,
  trigram varchar(4) DEFAULT NULL,
  soc decimal(22,0) DEFAULT NULL,
  label varchar(40) DEFAULT NULL,
  libRegion varchar(40) DEFAULT NULL,
  glnedi varchar(13) DEFAULT NULL,
  openingRank decimal(3,0) DEFAULT NULL,
  openingHours text,
  imagesGallery text,
  managerName varchar(255) DEFAULT NULL,
  phone varchar(255) DEFAULT NULL,
  geoLong float DEFAULT NULL,
  geoLat float DEFAULT NULL,
  hasWorkshop smallint(6) DEFAULT NULL,
  hasAcademy smallint(6) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  facebookDisplay tinyint(4) DEFAULT NULL,
  facebookUrl varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE ip_addresses (
  ip varchar(15) NOT NULL,
  idStore varchar(40) NOT NULL,
  type varchar(10) DEFAULT NULL,
  PRIMARY KEY (ip)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE printers (
  name varchar(50) NOT NULL,
  idStore varchar(40) NOT NULL,
  driver varchar(20) DEFAULT NULL,
  type varchar(25) DEFAULT NULL,
  address varchar(50) DEFAULT NULL,
  port int(11) DEFAULT NULL,
  PRIMARY KEY (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Drop table

-- DROP TABLE RES_STORES.dbo.addresses

CREATE TABLE addresses (
	typeAdr varchar(4) NOT NULL,
	cdMag varchar(4) NOT NULL,
	name varchar(50),
	adr1 varchar(50),
	adr2 varchar(50),
	adr3 varchar(50),
	zipCode varchar(10),
	city varchar(30),
	countryCode varchar(3),
	telephone varchar(20),
	fax varchar(20)
) ;

CREATE TABLE extra (
  trigram varchar(4) NOT NULL,
  code varchar(20) NOT NULL,
  information text,
  PRIMARY KEY (`trigram`,`code`)
) ;


INSERT INTO stores
(id, supplyStartDate, openDate, closeDate, trigram, soc, label, libRegion, glnedi, openingRank, openingHours, imagesGallery, managerName, phone, geoLong, geoLat, hasWorkshop, hasAcademy, email, facebookDisplay, facebookUrl)
VALUES('1', NULL, NULL, NULL, 'CME', NULL, 'MERIGNAC', 'OUEST', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO stores
(id, supplyStartDate, openDate, closeDate, trigram, soc, label, libRegion, glnedi, openingRank, openingHours, imagesGallery, managerName, phone, geoLong, geoLat, hasWorkshop, hasAcademy, email, facebookDisplay, facebookUrl)
VALUES('2', NULL, NULL, NULL, 'CEN', NULL, 'CENTRAL', 'SC', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO stores
(id, supplyStartDate, openDate, closeDate, trigram, soc, label, libRegion, glnedi, openingRank, openingHours, imagesGallery, managerName, phone, geoLong, geoLat, hasWorkshop, hasAcademy, email, facebookDisplay, facebookUrl)
VALUES('3', NULL, NULL, NULL, 'CBG', NULL, 'BEGLES', 'RH', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO stores
(id, supplyStartDate, openDate, closeDate, trigram, soc, label, libRegion, glnedi, openingRank, openingHours, imagesGallery, managerName, phone, geoLong, geoLat, hasWorkshop, hasAcademy, email, facebookDisplay, facebookUrl)
VALUES('4', NULL, NULL, NULL, 'CLA', NULL, 'LABEGE', 'OUEST', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO stores
(id, supplyStartDate, openDate, closeDate, trigram, soc, label, libRegion, glnedi, openingRank, openingHours, imagesGallery, managerName, phone, geoLong, geoLat, hasWorkshop, hasAcademy, email, facebookDisplay, facebookUrl)
VALUES('5', NULL, NULL, NULL, 'CLE', NULL, 'LESCAR', 'OUEST', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO stores
(id, supplyStartDate, openDate, closeDate, trigram, soc, label, libRegion, glnedi, openingRank, openingHours, imagesGallery, managerName, phone, geoLong, geoLat, hasWorkshop, hasAcademy, email, facebookDisplay, facebookUrl)
VALUES('6', NULL, NULL, NULL, 'ZAF', NULL, 'LABEL', 'SUD', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO stores
(id, supplyStartDate, openDate, closeDate, trigram, soc, label, libRegion, glnedi, openingRank, openingHours, imagesGallery, managerName, phone, geoLong, geoLat, hasWorkshop, hasAcademy, email, facebookDisplay, facebookUrl)
VALUES('7', NULL, NULL, NULL, 'TFO', NULL, 'LABEL2', 'OUEST', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


INSERT INTO ip_addresses
(ip, idStore, `type`)
VALUES('192.168.21.0', '1', 'STANDARD');

INSERT INTO extra
(trigram, code, information)
VALUES('CME', 'header1', 'text1');
INSERT INTO extra
(trigram, code, information)
VALUES('CME', 'header2', 'text2');
INSERT INTO extra
(trigram, code, information)
VALUES('CBG', 'header1', 'texxt1');

INSERT INTO addresses
(typeAdr, cdMag, name, adr1, adr2, adr3, zipCode, city, countryCode, telephone, fax)
VALUES('COM', 'CBG', 'Cultura Bègles', 'ZAC DE BEGLES - TARTIFUMES', 'RUE DENIS PAPIN', NULL, '33130', 'BEGLES', 'FR', '05-56-30-08-30', '05-56-30-08-49');

