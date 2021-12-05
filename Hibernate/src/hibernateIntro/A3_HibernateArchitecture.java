package hibernateIntro;

public class A3_HibernateArchitecture {

}


/**
 * Understanding Of Hibernate*/

/*
 * 1.Architecture Of Hibernate
 * 
 * 2.Layers In Hibernate
 * 
 * 3.Files Needed For An Hibernate Application
 * 
 * 4.Details Of These Files
 */


/** Hibernate based on 3 API-- */
/*
 * 1. JDBC--java database connectivity 
 * 2. JTA---java transaction API 
 * 3.JNDI---javanaming and directory interfaces.
 * 
 * 
 * We will only interact with hibernate , it will talk with these API's
 */



/*
 * Java Application------Persistent obj(obj which will map with DB tables)------Hibernate--------3API-------DB
 * 
 * 
 * 
 * if we have 4 tables in DB , then 4 persistent obj will be there.
 */



/** While using JDBC */
/* Java ---JDBC----DB */

/** In hibernate */
/* Java---Hibernate----JDBC+JTA+JNDI-----API */



//Files To Be Created For Hibernate
/*
 * Every Hibernate based application contains at least 4 files which must be
 * developed by the programmer to communicate with the database.
 */

/*
 * These 4 files are :
 * 
 * XML files------
 * Mapping File == this files will tell hibernate that on which table it has to connect
 * 
 * Configuration File---the file 
 * 
 * If we have 5 tables in DB then Mapping file(5) and configurationfile(1)
 * 
 * If we have 2database oracle, mysql then 2 configuration file bnegi
 * 
 * 
 * Java Files-------
 * 
 * Persistent class
 * 
 * Java class to hold logic
 */




