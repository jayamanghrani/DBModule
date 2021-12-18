package com.jaya.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass4_UpdateApproach2 {

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
			boolean done=true;
			
			Transaction tx=null;
			
			System.out.println("enter empid to update");
			int empid=s.nextInt();
			
			try
			{
				
				System.out.println("getting user entered id from session ");				
				Employee emp=(Employee)session.get(com.jaya.hibernate.Employee.class, empid);
				
				tx=session.beginTransaction();
				
				if(emp!=null)
				{
				System.out.println("enter empname");	
				String Name=s.next();
				
			
				/*
				 * System.out.println("enter empsal"); 
				 * double Sal= s.nextDouble();
				 */
				
			
				emp.setEmpNo(empid+1);
				emp.setEmpName(Name);
				/* emp.setEmpSal(Sal); */
				
				System.out.println("saving obj in session");
				/** using update method */
				session.update(emp);
	
				System.out.println("calling flush");
				session.flush();
				
				System.out.println("calling flush");
				tx.commit();
				}
				else
				{
					System.out.println("Record not found");
				}
				
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

// Approach 2

/*
 * Load the object with the id 
 * 
 * Update the  fields by calling setters
 * 
 * Open the transaction
 * 
 * Call the update( ) method
 * 
 * Finally commit the transaction
 * 
 * Close the session and SessionFactory
 */

//output  when given Id not present

// In approach 1 we were getting exception.in 2nd approach proper error msg
/**
 * session factory created
 * 
 * session opened
 * 
 * enter empid to update
 * 
 * 109
 * 
 * getting user entered id from session
 * 
 * Hibernate: select employee0_.Emp_No as emp_no1_0_0_, employee0_.Emp_Name as
 * emp_name2_0_0_, employee0_.Emp_Sal as emp_sal3_0_0_ from Employee employee0_
 * where employee0_.Emp_No=?
 * 
 * Record not found
 */

// If we are updating record, and giving same data in all columns, 
//then update query doesn't generate by hibernate

/**
 * hibernate is very smart, update method db ka photo/data leta h and user ka
 * data bhi leta h and dono ko match krta h, if diff rehta h to hi update krta h
 */


//Points to remember

/* 
 * Whenever an object is loaded from the database then hibernate stores the
 * loaded object in cache-memory maintained by session object
 */

/*
 * If we modify the key attribute(Id) then Hibernate throws the HibernateException
 * 
 * ex. empid=104
 * Employee emp=(Employee)session.get(com.jaya.hibernate.Employee.class, empid);
 * emp.setEmpNo(empid+1); --and in setter we are changing id+1
 * update(emp)
 *  
 * exception org.hibernate.HibernateException: 
 * identifier of an instance of com.jaya.hibernate.Employee was altered from 104 to 105
 * 
 */


// Interesting point---

/**
 * 1. we used get() to get data for give id
 * 
 * 2. by get , hibernate stored data in cache
 * 
 * 3. then we updated data by setter methods
 * 
 * 4. then we will call update(), but we can skip this point
 * 
 * 5. directly we can write commit. hibernate is smart and will update record
 */
