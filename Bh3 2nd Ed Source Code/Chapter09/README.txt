README for Chapter 9

You will need to install

* Hibernate 3.5 or higher
* Hibernate Tools 3.2 or higher
* Apache Ant 1.8.1 or higher
* HSQLDB 2.0.0 or higher
* an SLF4J implementation (compatible with the SLF4J API version of Hibernate 3.5 being used - this can change). We used 1.5.11

You will need to edit build.properties to point to the installations of each of these projects. In particular, the Hibernate Tools paths for the jar and lib file will change if you are not using Hibernate Tools 3.2.4

Compile the classes in the directory with the ant compile task, or "ant compile" from the command line. 


Run the following tasks in order to carry out all of the operations and queries. You will need to run "ant populate" before any of the queries, otherwise the database will be empty and the queries won't give the expected results.

ant populate
ant SimpleHQL
ant CommentedHQL
ant FullyQualifiedHQL
ant ProjectionHQL
ant HQLForRestrictions
ant NamedParametersHQL
ant ObjectNamedParametersHQL
ant PagingHQL
ant UniqueResultHQL
ant OrderHQL
ant OrderTwoPropertiesHQL
ant AssociationsHQL
ant AssociationObjectsHQL
ant FetchAssociationsHQL
ant CountHQL
ant NamedQuery
ant ScalarSQL
ant SelectSQL
ant UpdateHQL
ant DeleteHQL

NOTE - the final ant task, DeleteHQL, will fail because there are integrity issues with using bulk deletes with objects in a relationship. We discuss this further in the chapter. 
