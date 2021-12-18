package com.jaya.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass3_persist 
{
 public static void main(String[] args)
 {
	
	 /** using persist method */
	 
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
			/** using persist method */
			session.persist(e);
// when we call persist , No guarantee , about when id will be generated (don't know commit ke bad hogi ki flush ke bad)
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
					System.out.println("can't save object");
				}
				
			}
			
			session.close();
			sf.close();
			s.close();
			
		}
		
		
	
}
}
