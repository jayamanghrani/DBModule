package com.hibernate.dao;

import com.hibernate.entity.Account;
import com.hibernate.exception.InsufficientFundsException;

public interface AccountDAO 
{

public abstract boolean createAccount(Account obj);

public abstract Account getAccountDetails(int accid);

public abstract boolean updateAccountDetails(int id ,double amt, char S)throws InsufficientFundsException;
	
public abstract boolean closeAccount(int accid);	

public abstract void closeResources();
	
	
	
	
}
