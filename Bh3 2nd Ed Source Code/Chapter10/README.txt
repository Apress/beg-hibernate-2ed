README for Chapter 10

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
ant SimpleCriteria
ant EqualsCriteria
ant NotEqualsCriteria
ant LikePatternCriteria
ant ILikeMatchModeCriteria
ant NullCriteria
ant GreaterThanCriteria
ant AndCriteria
ant OrCriteria
ant AndOrCriteria
ant DisjunctionCriteria
ant SQLCriteria
ant PagingCriteria
ant UniqueResultCriteria
ant UniqueResultExceptionCriteria
ant OrderCriteria
ant OneToManyAssociationsCriteria
ant AssociationsSortingCriteria
ant ManyToOneAssociationsCriteria
ant QBECriteria
ant NotNullOrZeroQBECriteria
ant QBEAdvancedCriteria
ant RowCountCriteria
ant AggregatesCriteria
ant ProjectionCriteria
ant GroupByCriteria
ant DistinctCriteria
