package hibernateIntro;

public class B4_FlushIntro {

	/*
	 * session Factory obj...
	 * 
	 * Session s=.... 
	 * Transcation tx=null;
	 *  boolean done=true;
	 *  
	 *  try
	 *  {
	 *  	//Entity obj create
	 *  	// data save
	 *  	// s.save()
	 *  	//s.flush();
	 *  }
	 *  
	 *  catch(Exception ex)
	 *  {
	 *  	SOP(ex)
	 *  	done=false  
	 *  }
	 *  
	 *  finally
	 *  {
	 *  
	 *  if(flag==true)
	 *  {
	 *   tx.commit()
	 *  }
	 *  
	 *  else
	 *  {
	 *   tx.rollback();
	 *  }
	 *  
	 *  
	 *  }
	 *  
	 */
	
	
}


/**
 * If we don’t call session.flush() and if we call transaction.commit() , then
 * internally commit() method executes the statement and commits.
 */
/*So commit()= flush+commit*/


/**
 * Without the call to the flush() method, our first-level cache might
 *  throw an OutOfMemoryException
 */

// For bulk operation, we should use flush()