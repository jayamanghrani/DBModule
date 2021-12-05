package hibernateIntro;

import javax.persistence.Cache;

public class B3_SaveObject
{
		
	/* Transaction tx= sess.beginTransaction() */
			
			
	
	
}

// jitne bhi DML(manipulation) operation hote h hibernate me, 
//vo transaction ke andar hone chaheye.

/** insert, update, delete are DML */



/*
 * ex. we have 2 account A1 and A2, we are transferring fund
 * suppose A1 se amount deduct hua but due to
 * some issue A2 account me nhi gya. 
 * now amount should go back to A1 account.In
 * sql words this is rollback and rollback ki facility milti h transaction se.
 */
//DML me ya to sare steps chle ya chl na chle



// How to save objects through hibernate ?

/*
 * 1. open transaction
 * 
 * 2. Entity object initialize and call session's save() method so that it gets
 * saved in session's cache
 * 
 * 3.Call flush() method of session object, which gen SQL stmt.
 * 
 * 4. call commit() of transaction so that the changes become permanent.
 * 
 * 5. If exception arises then make sure to rollback by calling rollback.
 */


//understand by diagram


/*
 * in our Application----
 * call beginTransaction()----open a transaction by session object
 * save(e)
 * flush()
 * commit()/ rollback()
 * 
 * 
 * 1. beginTransaction will set false in autocommit in DB.
 * 2. save will store in cache.
 * 
 * 3. flush will generate insert query based on data in cache. and it will store
 * query in DB buffer.
 * 
 * 4.when we will call commit(), then query will go to DB.
 * 
 * 5. if some issue arises during commit or before commit , then rollback will be called.
 */






