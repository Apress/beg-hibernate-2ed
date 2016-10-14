README for Chapter 8

You will need to install

* Hibernate 3.5 or higher
* Hibernate Tools 3.2 or higher
* Apache Ant 1.8.1 or higher
* HSQLDB 2.0.0 or higher
* an SLF4J implementation (compatible with the SLF4J API version of Hibernate 3.5 being used - this can change). We used 1.5.11

You will need to edit build.properties to point to the installations of each of these projects. In particular, the Hibernate Tools paths for the jar and lib file will change if you are not using Hibernate Tools 3.2.4

Compile the classes in the directory with the ant compile task, or "ant compile" from the command line. 

To run the example, use "ant generateDeadlock" (which also will compile the classes).

After you run the generate deadlock example, the HSQL database will complain about database locking - that is what is being shown in the example.