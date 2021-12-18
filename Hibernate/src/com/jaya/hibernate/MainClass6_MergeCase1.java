package com.jaya.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/** Case1 me we were giving obj details and calling merge*/

public class MainClass6_MergeCase1
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
			
			  System.out.println("enter empname");	
			  String Name=s.next();
			
			  System.out.println("enter empsal"); 
			  double Sal= s.nextDouble();
			 
			  Employee emp= new Employee();
			  emp.setEmpNo(empid);
			  emp.setEmpName(Name);
			  emp.setEmpSal(Sal);
			
			System.out.println("merging obj in session");
			/** using merge method */
			session.merge(emp);			
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



//Output
/*DB
SQL> select * from employee;

EMP_NO EMP_NAME                EMP_SAL
---------- -------------------- ----------
   101 Amit                      40000
   102 punnet                    10000
     0 test                      10000
   103 joy                       12000*/


/*session factory created
session opened
enter emp id
103
enter empname
jaya
enter empsal
12000
merging obj in session
Hibernate: select employee0_.Emp_No as emp_no1_0_0_, employee0_.Emp_Name as emp_name2_0_0_, employee0_.Emp_Sal as emp_sal3_0_0_ from Employee employee0_ where employee0_.Emp_No=?
calling commit
Hibernate: update Employee set Emp_Name=?, Emp_Sal=? where Emp_No=?
 commit done*/



//Merge is working as saveorUpdate , then what is diff b/w merge and saveorUpdate?
		
/*
 * 1. It's return type is Object
 * 2. saveorUpdate ki return type void h .
 */


// Merge ka kaam
/**
 * load obj from DB and save in the cache
 */