package hibernateIntro;

public class A1_Intro {

}

//An Introduction To Hibernate

/*
 * Hibernate is one of the most popular ORM(Object/Relational Mapping) tool in
 * the world of Java.
 * 
 * It works on the principles of JPA, Java Persistence API (JPA)
 * 
 * JPA gives guidelines about how a developer can map, store, update and
 * retrieve data from relational databases to Java objects and vice versa.
 * 
 * 
 * JPA is a set of concepts that can be implemented by any tool or framework.
 * 
 */

//Problems With JDBC

/**
 * 1 JDBC makes Java code tightly coupled to the database schema i.e any change
 * in the database schema , like renaming a column effects JDBC written Java
 * code.
 */

/*
 * 2 Developer has to write a lot of code like opening the connection , creating
 * PreparedStatement , traversing through the records , closing the connection
 * etc.
 */

/**
 * 3 In JDBC , our code raises SQLException which is a Checked Exception and
 * thus it is compulsory for the programmer to either handle it or declare it to
 * be thrown, even though the programmer doesn’t want to.
 */

/*
 * 4 JDBC retrieves data in table format i.e in the row and column format and
 * not in the form of objects directly. The developer has to then traverse
 * through the ResultSet records and then set them into object attributes
 */

/**
 * 5 JDBC , retrieves the data from the database in the form of ResultSets , but
 * these ResultSet objects are not Serializable. That is , we cannot send them
 * over the network directly. So we need to convert them to other types before
 * transmitting them over the network .
 * 
 * ex. Amazon--(paymentdetails)----Paytm----SBI ----------(sending details
 * via.network)
 * 
 * Serializable means converting object into bits and bytes.
 * 
 * network pe to bit/byte hi bhej sakte h , but resultset serializable nhi h.
 */

/*
 * JDBC , doesn’t allow us to enjoy Inheritance , Polymorphism or Composition
 * support in our code because we cannot pass Java Objects directly to SQL
 * queries.
 */

// The solution to all these problems is an ORM tool i.e. Hibernate

//Top 12 Features Of Hibernate

/** 1.Free & Open Source */
/*
 * We can download and use Hibernate without paying any licensing fee . Moreover
 * we also can download the full source code of Hibernate while installing it
 */

/** 2.Light Weight */

/*
 * Hibernate software is distributed as a zip file and has a very small size
 * which is around 65 MB
 * 
 * To use Hibernate , we just need JDK/JVM and Hibernate libraries
 * 
 * It doesn’t require any heavy wieight containers or web/application servers
 */

/** 3. Portable */
/*
 * Hibernate allows us to develop persistence logic using Java objects and not
 * SQL queries , so we can easily migrate from one DB to another DB without
 * changing our Java code
 */

/** Supports Non Invasive Programming */
/*
 * Hibernate doesn’t force us to extend any technology specific class or
 * implement any specific interface while developing Persistence classes
 * 
 * So we can easily move our Java classes from one framework to another and this
 * is called Non Invasive programming
 * 
 * Frameworks which support this are Hibernate , Spring , Struts 2.x etc
 */

/**
 * Reduces Programmer’s Efforts */
/* 
 * Since Hibernate easily maps Java classes to
 * database tables and Java data types to SQL types, it reduces almost 95%
 * efforts of programmer.
 */


/**
 * Supports Inheritance, Association and Collections*/
/*
 * It supports relationships like One to One , One to Many etc
 * 
 * It supports Java Collections like List, Set, Map
 */


/**
 * No Checked Exceptions */
/*
 * In JDBC all exceptions are Checked Exceptions, so we must write code in try,
 * catch and throws, but in Hibernate we only have UnChecked exceptions, so no
 * need to compulsorily write try, catch or throws.  
 */

//Special Note:
/*
 * Actually in hibernate we have a translator which converts Checked Exceptions
 * to Un-checked Exceptions
 */


/**
 * Automatic Primary Key Generation*/
/*
 * Hibernate has capability to generate Primary Keys automatically while we are
 * storing the records into database
 */



/**
 * Database Independent Query Language*/

/*
 * Hibernate has its own query language called HQL, i.e Hibernate Query Language
 * which is database independent ,so if we change the database, then also our
 * application will work as HQL is database independent
 */


/**
 * Automatic Table Creation*/
/*
 * When we insert a record using JDBC and suppose the table is not present in
 * the database then JDBC will raise an error “table does not exist”, and will
 * throw exception. But in case of Hibernate, if table is not found then it will
 * create the table for us.
 */

/**
 * Supports Caching
 */
/*
 * Hibernate supports caching mechanism and due to this the number of round
 * trips between an application and the database will be reduced which will
 * automatically increase application performance
 */


/**
 * Supports Pagination*/
/*
 * Hibernate has built-in support for Pagination which is the process of
 * dividing a large amount of content to be presented on the UI in chunks.
 */


//Disadvantages Of Hibernate

/*
 * There is only 1 disadvantage of Hibernate as compared with JDBC which is that
 * it is slower than JDBC.
 * 
 * 
 * 
 * This is because when Hibernate loads ,it analyzes all entities and does a lot
 * of pre-caching .
 * 
 * 
 * 
 * This can take about 5-10-15 seconds for the application to start, once hibernate will up.then it will not take much time
 */


//History


/*
 * Created by Gavin King in 2001.
 * 
 * 
 * Later in 2003 , Red Hat hired lead hibernate developers and framed hibernate
 * community for it’s further development.
 * 
 * 
 * As of now it’s latest stable version is Hibernate 5.4.15 released on
 * 30th-April-2020 and
 * 
 *  preview release is Hibernate 6.0.0. ---testing chl rhi eski
 *  
 *  
 *  The official site for hibernate is hibernate.org.(.org--non commercial , .com--commercial)(
 */


/**
 * Alternates To Hibernate
 */

/*
 * Spring JDBC, --use JDBC 
 * Spring ORM , --use ORM tool 
 * Spring Data--- provide both facility
 * 
 */


