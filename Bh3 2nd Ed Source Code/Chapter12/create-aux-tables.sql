# set character-set to utf8
SET NAMES 'utf8';

# create the database
CREATE DATABASE IF NOT EXISTS `geonames` ;

# use the database
USE `geonames`;

# drop the admin1codes table
DROP TABLE IF EXISTS `geonames`.`admin1codes`;

#create the admin1codes table
CREATE TABLE `geonames`.`admin1codes` (
`country_code` char(2) NOT NULL,
`admin1_code` varchar(20),
`name` varchar(200) NOT NULL default '',
PRIMARY KEY (`country_code`,`admin1_code`)
) CHARACTER SET utf8 ;

# drop the admin2codes table
DROP TABLE IF EXISTS `geonames`.`admin2codes`;

#create the admin2codes table
CREATE TABLE `geonames`.`admin2codes` (
`country_code` char(2) NOT NULL,
`admin1_code` varchar(20),
`admin2_code` varchar(20),
`name` varchar(200) NOT NULL default '',
`asciiname` varchar(200) NOT NULL default '',
`geonameid` int,
PRIMARY KEY (`country_code`,`admin1_code`,`admin2_code`)
) CHARACTER SET utf8 ;



# drop the featurecodes table
DROP TABLE IF EXISTS `geonames`.`featurecodes`;

#create the featurecodes table
CREATE TABLE `geonames`.`featurecodes` (
`feature_class` char(1) NOT NULL,
`feature_code` varchar(10) NOT NULL,
`name` varchar(200) NOT NULL default '',
`description` varchar(200) NOT NULL default '',
PRIMARY KEY (`feature_class`,`feature_code`)
) CHARACTER SET utf8 ;


#load data into the admin1codes table
LOAD DATA LOCAL INFILE '../admin1Codes.txt' INTO TABLE `geonames`.`admin1Codes` CHARACTER SET utf8 (@concatid,name) 
SET country_code=SUBSTRING_INDEX(@concatid,'.',1),
admin1_code=SUBSTRING_INDEX(@concatid,'.',-1);


#load data into the admin2codes table
LOAD DATA LOCAL INFILE '../admin2Codes.txt' INTO TABLE `geonames`.`admin2Codes` CHARACTER SET utf8 (@concatid,name,asciiname,geonameid) 
SET country_code=SUBSTRING_INDEX(@concatid,'.',1),
admin1_code=SUBSTRING_INDEX(SUBSTRING_INDEX(@concatid,'.',2),'.',-1),
admin2_code=SUBSTRING_INDEX(@concatid,'.',-1);


#load data into the featurecodes table
LOAD DATA LOCAL INFILE '../featureCodes_en.txt' INTO TABLE `geonames`.`featurecodes` CHARACTER SET utf8 (@concatid,name,description) 
SET feature_class=SUBSTRING_INDEX(@concatid,'.',1),
feature_code=SUBSTRING_INDEX(@concatid,'.',-1);



