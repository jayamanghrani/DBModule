package com.jaya.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass1_get
{
	public static void main(String[] args) {
		
	
	// copy hibernate jar in build path, otherwise from lib it not available
	//once added in build path , we will get Referenced libraries folder.
	
	 Configuration cfg =new Configuration();  
	  System.out.println("conf created");
	 cfg=cfg.configure("hibernate.cfg.xml");	  
	 SessionFactory sf= cfg.buildSessionFactory();	 
	 System.out.println("sessionFactory obj created");
	 Session sess= sf.openSession();
	 System.out.println(" sessionFactory open the session");
	 Scanner kb= new Scanner(System.in);
	 System.out.println("enter empno");
	 int empnumber= kb.nextInt();

	 
	 
	 
	 System.out.println("fetching details from employee 1st time --it will take from DB");
	 // we can also check the query created by hibernate -using property showsql
	 
	 Employee e=(Employee)sess.get(com.jaya.hibernate.Employee.class, empnumber);// get ki return type Object h , to type casting hogi	 
	 if(e!=null)
	 {
	 System.out.println("Name:"+e.getEmpName() +"  Sal:"+e.getEmpSal());
	 }
	 else
	 {
		 System.out.println("Record not found in Db");
	 }

	 
	 
		System.out.println("------------------------------------"); 
	 
System.out.println("fetching same details from employee 2nd time --it will take data from DB cache and query will not print");
	 
	 Employee e1=(Employee)sess.get(com.jaya.hibernate.Employee.class, empnumber);// get ki return type Object h , to type casting hogi	 
	 if(e1!=null)
	 {
	 System.out.println("Name:"+e1.getEmpName() +"  Sal:"+e1.getEmpSal());
	 }
	 else
	 {
		 System.out.println("Record not found in Db");
	 }
	 
	System.out.println("------------------------------------"); 
System.out.println("fetching different details from employee 3rd time --it will take data from DB ");
	 
	 Employee e3=(Employee)sess.get(com.jaya.hibernate.Employee.class, empnumber+2);// get ki return type Object h , to type casting hogi	 
	 if(e3!=null)
	 {
	 System.out.println("Name:"+e3.getEmpName() +"  Sal:"+e3.getEmpSal());
	 }
	 else
	 {
		 System.out.println("Record not found in Db");
	 }
	 	 
		System.out.println("**************************************"); 
System.out.println("calling load details from employee ");
			 
			 Employee e4=(Employee)sess.load(com.jaya.hibernate.Employee.class, empnumber+3);// get ki return type Object h , to type casting hogi	 
			 if(e4!=null)
			 {
				 System.out.println(" it will fetch id from cache , and return proxy obj");
				 System.out.println("Id-"+e4.getEmpNo());
				 System.out.println("now it will fetch from DB-proff is query ");
			 System.out.println("Name:"+e4.getEmpName() +"  Sal:"+e4.getEmpSal());
			 }
			 else
			 {
				 System.out.println("Record not found in Db");
			 } 
	 sess.close();
	 sf.close();
	
	 
	 
	 
	 
		/*data inside our  DB
		 * 
		 * SQL> select * from employee;
		 * 
		 * EMP_NO EMP_NAME EMP_SAL
		 * 101 Amit 40000 
		 * 102 Sumit 20000 
		 * 103 Ravi 50000
		 * 104 lalit 35000
		 * 105 deepak 44000
		 */
	 
	 // If given id is not present in DB then?
		/*
		 * It will return null
		 */	 
	 
	 
	 
	}
	
}


//bydefault conf file name is hibernate.cfg.xml , if this is our conf file name , then we can skip
//And if inside src this file is not kept. Then we will have to give path.

//Step 1 -create configuration object 

/*
 * Conf obj will bootstrap the hibernate, It reads all jar files and unko
 * load/activate krta h.
 * 
 * conf obj ask conf file , in that file it get 2 details (db details and mapping detail)
 * 
 * conf obj check both xml file and validate it.
 * 
 * conf obj takes persistance class ka data and paste it in ram.
 * beacuse hmm persitance ke bohot bar obj bnate h, bar bar harddisk se data lana , its not good.
 * 
 * So conf obj create in memory structure of persistence object.which we call metadata.
 *  
 	When we will ask for sessionFactory obj, it will provide by method--- buildSessionFactory() 
 * */


// Step 2--SessionFactory

/**
 * SessionFactory contain multiple obj -
 *  caching 
 *  Transaction 
 *  Dialet 
 *  Connection pool---it is collection of connection obj
 *  
 *  
 *  For 1 database , only 1 sessionFactory object should be there , because it is heavy weight object.
 *  It's object is immutable.can't manipulate its obj.
 *  
 */


/*
 * it's resposibility to create session object for us .
 * 
 * buildSessionFactory--sessionFactotry will build session obj by builder session factory.
 * 
 * it provide db connection + it has methods for db operation.

it has services like, cashing, connection pooling , transaction manager , dialect.

ye chote chote session build krke sessionFactory ka obj bnata h.
 eske piche builder design pattern use hota h

 */

// Connection Pool

/*
 * In jdbc, we established connection using getConnection buildSessionFactory
 * 
 * It is slow when we use db on different server , in local system it is fast
 * 
 * using connection pool , need not to wait for connection to be established during the execution of code.
 * 
 * we will ask from sessionFactory, it will provide from connectionPool.
 * 
 * Multithreaded envi me agar hibernate use hota h to , connection pool ki size increase kr sakte h
 */


//Inshort,  Using configuration, sessionFactory we aill get session object

//why we called buildSessionFactory--beacuse it use 


//Session Object
/*
 * It maintain connection with DB. DB operation ye hi krta h.
 * 
 * Session have one method -openSession() which open connection with db.
 * 
 * It have some methods for db operation 
 */

// some methods for db operation ,

//drawbacks---
/**
 * these method provide 1 row record 
 * These method need id, that's why they perform only one row operation.
 */

/* 1. save()----- like insert command 
 * 
 * 2.update()----update command, existing me changes
 * 
 * 3.saveorUpdate()------first insert and then replace data
 * 
 * 4.persist----transient ko persitent krta h , ye hibernate ki state h
 * 
 * 5. get() --select (fetch record)
 * 
 * 6. load()--will read later
 * 
 * 7. refresh()--db me kuch change hua to hmm apna obj refresh krenge, changes update krne ke liye
 * 
 * 8. delete()--it delete row 
 * 
 * */



// But we might need to work upon multiple rows at a time .
//for ex. fetch all emp who work in dep 10

/*
 * For such operation hibernate provide 2 approach-
 * 
 * HQL 
 * Criteria API
 */



//sess.get(com.jaya.hibernate.Employee.class, empNo);

// It's 2nd argu is serializable , 

/**
 * Interger implement Number and Number implement Serializable
 * 
 * so , we can pass any primitive type ,Wrapper class 
 */










