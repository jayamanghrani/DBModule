package com.jaya.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass4_UpdateApproach1 {

	public static void main(String[] args) {
		

		
		 /** using update method */
		 
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
			try
			{
				tx=session.beginTransaction();
				
				System.out.println("enter id");
				int No=s.nextInt();
				
				System.out.println("enter empname");	
				String Name=s.next();
				
			
				System.out.println("enter empsal");
				double Sal= s.nextDouble();
				
				Employee e= new Employee();
				e.setEmpNo(No);
				e.setEmpName(Name);
				e.setEmpSal(Sal);
				
				System.out.println("saving obj in session");
				/** using update method */
				session.update(e);
	
				System.out.println("calling flush");
				session.flush();
				
			}
			catch(Exception ex)
			{
				System.out.println("exception occured");
				ex.printStackTrace();
				done=false;
			}
			
			finally
			{
				if(tx!=null)
				{
					if(done==true)
					{
						tx.commit();
						System.out.println("object saved successfully");
					}
					else
					{
						tx.rollback();
						System.out.println("Rollback done, can't save object");
					}
					
				}
				
				session.close();
				sf.close();
				s.close();
				
			}
			
			
		

		
		
	}
	
	
	
	
}


//The update() Method

/*
 * To update a record which is already present in the database, we call the
 * update( ) method of session object.
 * 
 * 
 * This method has the following prototype:
 * 
 * public void update(Object object)throws HibernateException
 * 
 * 
 */

// There are 2 approach to update 

// approach 1
/**
 * Create a properly initialized the object
 * 
 * Keep the same id which we want to update
 * 
 * Open the transaction
 * 
 * Call the update( ) method
 * 
 * Finally commit the transaction---internally update query generate by hibernate
 * 		{{ Hibernate: update Employee set Emp_Name=?, Emp_Sal=? where Emp_No=? }}
 * 
 * Close the session and SessionFactory
 */



// drawbacks--

/*
 * 1.if that id which we are passing is not present in DB then ? 
 * It will give exception, org.hibernate.StaleObjectStateException 
 * 
 * if we are using this approach then we should confident enough  that in db that id is present
 * 
 * 
 * suppose ,if id is present, and we want to update only name,
 *  but with this approach we will have to provide all column name like name and sal also
 */

/**
 * If the id matches with a record in the DB then the DB record gets updated
 * with the Persistent object’s values
 * 
 * 
 * If id doesn’t match then hibernate will throw an exception called
 * StaleObjectStateException
 * 
 * This is a lengthy approach as we have to fill the complete object with all
 * the values
 */




