# set character-set to utf8
SET NAMES 'utf8';

# create the database
CREATE DATABASE IF NOT EXISTS `geonames` ;

# use the database
USE `geonames`;

# drop the geonames table
DROP TABLE IF EXISTS `geonames`.`geonames`;

# create the geonames table
CREATE TABLE `geonames`.`geonames` (
`geonameId` int(10) unsigned NOT NULL default '0',
`name` varchar(200) NOT NULL default '',
`asciiname` varchar(200) NOT NULL default '',
`alternatenames` varchar(5000) NOT NULL default '',
`latitude` double NOT NULL default '0',
`longitude` double NOT NULL default '0',
`feature_class` char(1) ,
`feature_code` varchar(10) ,
`country_code` char(2),
`cc2` varchar(60),
`admin1_code` varchar(20),
`admin2_code` varchar(80),
`admin3_code` varchar(20),
`admin4_code` varchar(20),
`population` bigint(11),
`elevation` int(11),
`gtopo30` int(11),
`timezone` varchar(40),
`modification_date` date,
PRIMARY KEY (`geonameid`)
) CHARACTER SET utf8 ;

# create the geonames indexes
CREATE INDEX elevation_index ON geonames (elevation);
CREATE INDEX admin1_code_index ON geonames (admin1_code);
CREATE INDEX admin2_code ON geonames (admin2_code);

