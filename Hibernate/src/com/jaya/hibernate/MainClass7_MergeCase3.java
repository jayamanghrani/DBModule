package com.jaya.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//Case3
/*Load the object from the database and store in cache

 session got closed--- which happens in real time
 

This will remove the object from session cache, --called detached , but heap me rhega obj beacuse obj to heap me rehte h

Now modify the object values

Open a new session and call the merge() method passing the object as argument

now merge will take obj data from db
then merge will override our value in db values.
*/


public class MainClass7_MergeCase3
{
public static void main(String[] args)
{
 
	Configuration conf= new Configuration();	
	conf.configure("hibernate.cfg.xml");
	System.out.println("config called");
	
	SessionFactory sf= conf.buildSessionFactory();
	System.out.println("session factory created");
	
	Session session =sf.openSession();
	System.out.println("session opened");
	
	Scanner s= new Scanner(System.in);
	Transaction tx=null;
	
	
	try
	{
		tx=session.beginTransaction();
		
		  System.out.println("enter emp id");	
		  int empid=s.nextInt();
		  
		  Employee emp= (Employee)session.get(Employee.class,empid);
		  
		  session.close(); // obj detached
		
		  emp.setEmpSal(emp.getEmpSal()+1000);		// we are increasing sal with 1000;
		System.out.println("merging ");
		
		session =sf.openSession();
		tx=session.beginTransaction();
		
		/** using merge method */
		Employee f=(Employee) session.merge(emp);		 
		System.out.println(emp==f);
		
		System.out.println("Updating  record");
		tx.commit();
		System.out.println(" commit done");
				
	}
	catch(Exception ex)
	{
		System.out.println("exception occured");
		ex.printStackTrace();
		if(tx!=null)
		{
			tx.rollback();
			System.out.println("Rollback done, can't save object");
		}	
	}
	
	finally
	{
		session.close();
		sf.close();
		s.close();
		
	}
	
}
		
}



/*
 * Merge sabse pehle cache me dekhega , jo ki use milega nhi 
 * then vo db se data la kr aayega.
 * 
 * and hmari values override kr deta.
 * 
 * 
 */


// output

//DB
/*SQL> select * from employee;

EMP_NO EMP_NAME                EMP_SAL
---------- -------------------- ----------
   101 Amit                      40000
   102 Sumit                     10000
     0 test                      10000
   103 jaya                      12000*/


/*session factory created
session opened
enter emp id
103
Hibernate: select employee0_.Emp_No as emp_no1_0_0_, employee0_.Emp_Name as emp_name2_0_0_, employee0_.Emp_Sal as emp_sal3_0_0_ from Employee employee0_ where employee0_.Emp_No=?
merging 
Hibernate: select employee0_.Emp_No as emp_no1_0_0_, employee0_.Emp_Name as emp_name2_0_0_, employee0_.Emp_Sal as emp_sal3_0_0_ from Employee employee0_ where employee0_.Emp_No=?
false
Updating  record
Hibernate: update Employee set Emp_Name=?, Emp_Sal=? where Emp_No=?
 commit done*/


/*SQL> select * from employee;

EMP_NO EMP_NAME                EMP_SAL
---------- -------------------- ----------
   101 Amit                      40000
   102 Sumit                     10000
     0 test                      10000
   103 jaya                      13000-----updated
*/


/*
 * so it is taking data from db keeping it in cache , then overriding/merging
 * our changes . That's why we are calling it merge
 */



