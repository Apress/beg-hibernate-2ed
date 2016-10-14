# set character-set to utf8
SET NAMES 'utf8';

# create the database
CREATE DATABASE IF NOT EXISTS `geonames` ;

# use the database
USE `geonames`;

# create the geonames indexes
CREATE INDEX elevation_index ON geonames (elevation);
CREATE INDEX admin1_code_index ON geonames (admin1_code);
CREATE INDEX admin2_code ON geonames (admin2_code);
