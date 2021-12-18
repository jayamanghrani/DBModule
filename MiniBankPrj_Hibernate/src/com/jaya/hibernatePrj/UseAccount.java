package com.jaya.hibernatePrj;

import java.util.Scanner;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UseAccount 
{
	public static void main(String[] args)
	{
		Configuration cfg=new Configuration();		
		cfg.configure();
		SessionFactory sf= cfg.buildSessionFactory();
		Session sess= null;
		
		Account acc=null;
		int id;
		double bal;
		int choice;
		boolean result;
		Scanner kb = new Scanner(System.in);
		
	do
	{
		System.out.println("select an option");
		System.out.println("1. Create Account\n 2. Get ACcount detail\n 3.Withdraw amount\n 4. "
				+ "Deposit Amount\n 5.Close Account \n 6. Quit");
		choice=kb.nextInt();
		switch(choice)
		{
		case 1:
			acc = new Account();
			System.out.println("enter accid");
			acc.setAcctId(kb.nextInt());
			System.out.println("enter acc name");
			acc.setAcctName(kb.next());
			System.out.println("enter bal");
			acc.setAcctBal(kb.nextDouble());
			
			try
			{
				sess= sf.openSession();
				result=createAccount(acc, sess);
				if(result)
					System.out.println("Account created");
				
				
			}
			catch(Exception ex)
			{
				System.out.println("can't create account");
				ex.printStackTrace();
			}
			finally
			{
				sess.close();
				
			}
			break;
			
			

		case 2:
			System.out.println("enter accid");
			id=kb.nextInt();						
			try
			{
				sess= sf.openSession();
				acc=getAccountDetail(id, sess);
				if(acc==null)
					System.out.println("Account id not found");
				else
					System.out.println(acc);
				
			}
			catch(Exception ex)
			{
				System.out.println("can't get account details");
				ex.printStackTrace();
			}
			finally
			{
				sess.close();
				
			}
		break;
		
		case 3:
			System.out.println("enter accid");
			id= kb.nextInt();
			System.out.println("Enter amount to withdraw");
			bal=kb.nextDouble();
			
			try
			{
				sess= sf.openSession();
				result=updateAccountDetails(id,bal,'W', sess);
				if(result==true)
					System.out.println("Account updated");
				else
					System.out.println("can't withdraw");
				
			}
			catch(Exception ex)
			{
				System.out.println("can't update account");
				ex.printStackTrace();
			}
			finally
			{
				sess.close();
				
			}
			break;
		
		case 4:
			System.out.println("enter accid");
			id= kb.nextInt();
			System.out.println("Enter amount to deposit");
			bal=kb.nextDouble();
			
			try
			{
				sess= sf.openSession();
				result=updateAccountDetails(id,bal,'D', sess);
				if(result)
					System.out.println("Amount deposited");
				
				
			}
			catch(Exception ex)
			{
				System.out.println("can't deposit amount");
				ex.printStackTrace();
			}
			finally
			{
				sess.close();
				
			}
			break;
			
			
		case 5:
			System.out.println("enter accid");
			id= kb.nextInt();

			
			try
			{
				sess= sf.openSession();
				result=closeAccount(id,sess);
				if(result==true)
					System.out.println("Amount closed");
				else
					System.out.println("can't close account");
				
				
			}
			catch(Exception ex)
			{
				System.out.println("can't delete account");
				ex.printStackTrace();
			}
			finally
			{
				sess.close();
				
			}
			break;
			
		case 6:
			System.out.println("thank you for using the app!");
			System.exit(0);

		default:
		System.out.println("wrong choice!");
		
		}
		
	}while(true);
		
		
	}

	private static boolean closeAccount(int id, Session sess) {

		Transaction tx= sess.beginTransaction();
		
		Account acc=getAccountDetail(id, sess);
		if(acc==null)
		{
			tx.commit();
			return false;
		}
		sess.delete(acc);
		tx.commit();		
		return true;
	}

	private static boolean updateAccountDetails(int id, double bal, char c, Session sess) {

		Transaction tx=sess.beginTransaction();
		
		Account acc=getAccountDetail(id, sess);
		if(acc==null)
		{
			tx.commit();
			return false;
		}
		
		if(c=='W')
			acc.setAcctBal(acc.getAcctBal()-bal);
		
		else
			acc.setAcctBal(acc.getAcctBal()+bal);
		
		tx.commit();
		return true;
	}

	private static Account getAccountDetail(int id, Session sess) 
	{
		Account acc= sess.get(Account.class, id);
		return acc;
	}

	private static boolean createAccount(Account acc, Session sess) {

		Transaction tx= sess.beginTransaction();
		sess.save(acc);
		tx.commit();		
		return true;
			
	}
}
