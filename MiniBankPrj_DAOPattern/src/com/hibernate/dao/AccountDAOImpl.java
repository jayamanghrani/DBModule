package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Account;
import com.hibernate.exception.InsufficientFundsException;
import com.hibernate.util.HibernateUtils;

public class AccountDAOImpl implements AccountDAO
{

	@Override
	public boolean createAccount(Account obj) {
	
		System.out.println("Inside DAO");
		Session sess= HibernateUtils.getSessionFactory().openSession();
		
		//For DML we need Transaction, 
		Transaction tx= sess.beginTransaction();
		sess.save(obj);
		tx.commit();
		
		return false;
	}
	
	
	

	@Override
	public Account getAccountDetails(int accid) {

		Session sess= HibernateUtils.getSessionFactory().openSession();		
		Account acc= sess.get(Account.class, accid);	
		return acc;
	
	}
	
	
	
	

	@Override
	public boolean updateAccountDetails(int id, double bal,char S) throws InsufficientFundsException {
	
		Session sess= HibernateUtils.getSessionFactory().openSession();
		
		//For DML we need Transaction, 
		Transaction tx= sess.beginTransaction();
		Account acc=getAccountDetails(id);
		if(acc==null)
		{
			tx.commit();
			return false;
		}
		
		if(S=='W')
		{
			if(acc.getAcctBal()<bal)
			{
				tx.commit();
				throw new InsufficientFundsException("Balance too low");
			}
			acc.setAcctBal(acc.getAcctBal()-bal);
		}
		else
			acc.setAcctBal(acc.getAcctBal()+bal);
		
		sess.update(acc); // update will regain detached obj
		tx.commit();
		sess.close();
		return true;
		
		
	}

	@Override
	public boolean closeAccount(int accid)
	{
		Session sess= HibernateUtils.getSessionFactory().openSession();		
		//For DML we need Transaction, 
		Transaction tx= sess.beginTransaction();
		
		Account acc=getAccountDetails(accid);
		if(acc==null)
		{
			tx.commit();
			return false;
		}
		sess.delete(acc);
		tx.commit();		
		return true;
	}




	@Override
	public void closeResources() {
		HibernateUtils.closeSessionFactory();
		
	}

}
