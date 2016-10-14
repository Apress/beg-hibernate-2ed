# set character-set to utf8
SET NAMES 'utf8';

# use the database
USE `geonames`;

LOAD DATA LOCAL INFILE '../US/US.txt' INTO TABLE `geonames`.`geonames` CHARACTER SET utf8 (geonameId,name,asciiname,alternatenames,latitude,longitude,feature_class,feature_code,country_code,cc2,admin1_code,admin2_code,admin3_code,admin4_code,population,elevation,gtopo30,timezone,modification_date);

