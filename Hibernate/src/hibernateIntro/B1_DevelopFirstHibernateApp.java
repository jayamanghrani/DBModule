package hibernateIntro;

public class B1_DevelopFirstHibernateApp {

}

// Develop First Hibernate App


//One-time steps
/** 1. Download hibernate jar--http://hibernate.org/orm/releases/ */ 



/** 2.UNzip it and extext at some location */
/*
 * ex-D:\Setup\hibernate-release-5.6.0.Final\hibernate-release-5.6.0.Final\lib\required-----all  jars are here
 */ 



/**  3. Create a new user in Oracle/MySql-- */
 /* 
 * 1)create user myhibernatebatch identified by mystudents
 *-2)create user myhibernatebatch identified by mystudents

*/



 /**
 * 4.Setup database/table*/ 
 /*connect myhibernatebatch/mystudents
 *create table Employee(emp_no number(3) constraint Emp_Eno_Pk primary key, emp_name varchar2(20), emp_sal number(5));
 */ 



 /**
 * 5. Insert data in table and commit.*/ 
 /* create table Employee(emp_no number(3) constraint Emp_Eno_Pk primary key, emp_name varchar2(20), emp_sal number(5));
	insert into employee values(101 ,'Amit',40000);
 */


 /** 
 * 6.|Download and install the IDE--Eclipse
 *  
 *  7.create a workspace
 *  
*/

// Repeating steps
/** 
 *  8.create a new project.
 *  
 *  9. create a folder "lib" inside project and copy all the hibernate jar files and database driver jar i.e. odjbc6
 *  
 *  10. Add these lib files to your build path
 *  
 *  11. Create proper directory structure
 */


 /**  12. CReate POJO/Entity/Persistence class, mapping file, cfg file and Main class */
   
	/*
	 * mapping file---Need to provide DTD also,otherwise XMLParser will not understand
	 * 
	 * We can refer sample file from hibernate folder-D:\Setup\hibernate-release-5.6.0.Final\hibernate-release-5.6.0.Final\project
	 * 
	 * search in searchbar-*.hbm.xml
	 * 
	 * open any sample file , copy dtd
	 * 
	 * <!DOCTYPE hibernate-mapping PUBLIC
	"-//Hibernate/Hibernate Mapping DTD 3.0//EN"
	"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
	 */
 
   
   
 /**  
 *  13.Code these files properly.
 *  
 *  14. Run the app
 *  
  
 *  */





//Genearlly  Java ke jitne bhi framework hote h, vo install software nhi hote, unki jar file milti h . Unko hmm classpath me setkrte h

// Enme ek main rehti h baki sab dependent rehti h 

//IN case of hibernate - Core is the main jar , but sabko bhi classpath me set krna pdta h





