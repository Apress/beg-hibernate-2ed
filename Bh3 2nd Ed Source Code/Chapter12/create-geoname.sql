DROP TABLE geonames IF EXISTS 

CREATE TABLE geonames ( 
geonameid integer PRIMARY KEY, 
name varchar(255) NOT NULL, 
asciiname varchar(255) NOT NULL, 
alternatenames varchar(2000) NOT NULL, 
latitude double NOT NULL, 
longitude double NOT NULL, 
feature_class char(1), 
feature_code varchar(10), 
country_code char(2), 
cc2 varchar(60), 
admin1_code varchar(20) default '', 
admin2_code varchar(80) default '', 
admin3_code varchar(20) default '', 
admin4_code varchar(20) default '', 
population bigint default '0', 
elevation integer default '0', 
gtopo30 integer default '0', 
timezone varchar(40), 
modification_date date
);