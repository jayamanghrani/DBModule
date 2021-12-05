package hibernateIntro;

public class B5_WithoutFlush {

	
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
	 *  	//tx.commit();
	 *  	SOP("Object saved")
	 *  }
	 *  
	 *  catch(Exception ex)
	 *  {
	 *  	SOP(ex)
	 *  	tx.rollback();
	 *  }*/
	
	
}

//What Exactly Does flush() Do ?

/*
 * When we call session.flush(), then Hibernate is forced to
 * issue INSERT INTO... against the database.
 * 
 * 
 * The entity is stored in the database, but not yet committed.
 * 
 * 
 * It won't be seen by other running transactions , but now the
 * database knows about the record.
 */