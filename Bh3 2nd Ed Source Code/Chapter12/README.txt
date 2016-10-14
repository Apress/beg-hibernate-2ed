README for Chapter 12

You will need to install

* Hibernate 3.5 or higher
* Apache Ant 1.8.1 or higher
* an SLF4J implementation (compatible with the SLF4J API version of Hibernate 3.5 being used - this can change). We used 1.5.11

* MySQL - this is different from other chapters, but Chapter 12 is a case study chapter and is closely tied to MySQL because of some tricks we used to import data into MySQL. You will need to go to http://www.mysql.com and download and install the appropriate version of MySQL for your operating system, and then also download the Java JDBC Library for MySQL (also known as the MySQL Connector for Java)

You will need to edit build.properties to point to the installations of each of these projects. In particular, the Hibernate Tools paths for the jar and lib file will change if you are not using Hibernate Tools 3.2.4

Compile the classes in the directory with the ant compile task, or "ant compile" from the command line. 

You will also need to follow the directions in the chapter to import the bulk data from http://www.geonames.org to follow the case study. The SQL scripts are provided in the root directory.

You can run the highpoints application with:
ant showHighpoints