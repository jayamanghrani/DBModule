package com.hibernate.main;

import java.util.Scanner;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dao.AccountDAO;
import com.hibernate.dao.AccountDAOImpl;
import com.hibernate.entity.Account;

public class UseAccount 
{
	public static void main(String[] args)
	{

		Account acc=null;
		int id;
		double bal;
		int choice;
		boolean result;
		Scanner kb = new Scanner(System.in);
		AccountDAO dao = new AccountDAOImpl();
		
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
				result=dao.createAccount(acc);
				if(result)
					System.out.println("Account created");				
				
			}
			catch(Exception ex)
			{
				System.out.println("can't create account");
				ex.printStackTrace();
			}
			
			break;
			

			
			

		case 2:
			System.out.println("enter accid");
			id=kb.nextInt();						
			try
			{
				
				acc=dao.getAccountDetails(id);
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
			
		break;
		
		
		
		
		case 3:
			System.out.println("enter accid");
			id= kb.nextInt();
			System.out.println("Enter amount to withdraw");
			bal=kb.nextDouble();
			
			try
			{				
				result=dao.updateAccountDetails(id,bal,'W');
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
			
			break;
		
		case 4:
			System.out.println("enter accid");
			id= kb.nextInt();
			System.out.println("Enter amount to deposit");
			bal=kb.nextDouble();
			
			try
			{
				result=dao.updateAccountDetails(id,bal,'D');
				if(result)
					System.out.println("Amount deposited");
				else
					System.out.println("Account not found");
				
			}
			catch(Exception ex)
			{
				System.out.println("can't deposit amount");
				ex.printStackTrace();
			}
		
			break;
			
			
		case 5:
			System.out.println("enter accid");
			id= kb.nextInt();	
			try
			{
				result=dao.closeAccount(id);
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
			break;
			
			
		case 6:
			System.out.println("thank you for using the app!");
			dao.closeResources();
			System.exit(0);

		default:
		System.out.println("wrong choice!");
		
		}
		
	}while(true);	
	}

}
