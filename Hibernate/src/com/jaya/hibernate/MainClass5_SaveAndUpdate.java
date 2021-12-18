package com.jaya.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//1. will load data by select query for a given id
//2. If the data is present in the database, 
//then the update query is executed otherwise insert is executed


public class MainClass5_SaveAndUpdate 
{
public static void main(String[] args) 
{

	 /** using update method Approach 2 */
	 
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
			
			  System.out.println("enter empname");	
			  String Name=s.next();
			
			  System.out.println("enter empsal"); 
			  double Sal= s.nextDouble();
			 
			  Employee emp= new Employee();
			  emp.setEmpNo(empid);
			  emp.setEmpName(Name);
			  emp.setEmpSal(Sal);
			
			System.out.println("saving or updating obj in session");
			/** using saveorUpdate method */
			session.saveOrUpdate(emp);			
			System.out.println("calling commit");
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



// let's see o/p

/** below is db details- */

/*
 * SQL> select * from employee;
 * 
 * EMP_NO EMP_NAME EMP_SAL
 * 
 * ---- ----- --------
 * 
 * 101 	Amit 	40000
 * 
 * 102	summit 	20000
 * 
 * 0	 test 	10000
 */


// if id present, and we have given updated values for other column then hibernate will update 
/*session factory created
session opened
enter emp id
102
enter empname
punnet
enter empsal
10000
saving obj in session
Hibernate: select employee_.Emp_No, employee_.Emp_Name as emp_name2_0_, employee_.Emp_Sal as emp_sal3_0_ from Employee employee_ where employee_.Emp_No=?
calling flush
Hibernate: update Employee set Emp_Name=?, Emp_Sal=? where Emp_No=?		
calling commit
Record saved*/


//if id present, and we have given same values as in db for other column then hibernate will 
// not generate update query

/*session factory created
session opened
enter emp id
101
enter empname
Amit
enter empsal
40000
saving or updating obj in session
Hibernate: select employee_.Emp_No, employee_.Emp_Name as emp_name2_0_, employee_.Emp_Sal as emp_sal3_0_ from Employee employee_ where employee_.Emp_No=?
calling commit
 commit done*/



//if id not present , then save means insert
/*session factory created
session opened
enter emp id
103
enter empname
joy
enter empsal
12000
saving or updating obj in session
Hibernate: select employee_.Emp_No, employee_.Emp_Name as emp_name2_0_, employee_.Emp_Sal as emp_sal3_0_ from Employee employee_ where employee_.Emp_No=?
calling commit
Hibernate: insert into Employee (Emp_Name, Emp_Sal, Emp_No) values (?, ?, ?)
commit done*/


/*
 * Special Note: There are some more points regarding saveOrUpdate(), but we
 * will discuss it during the topic “States of an object”.
 */
