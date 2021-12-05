package hibernateIntro;

public class B2_GetVsLoad {

}


//Difference between get and load in Hibernate

/** 1.Database hit */
/*Get method always hit the database 
while load() method may not always hit the database,
depending upon which method is called.*/




/** 2. Proxy */
/*
 * Get method never returns a proxy, it either returns null or fully initialized
 * Object, while load() method may return proxy, 
 * which is the object with ID but
 * without initializing other properties, which is lazily initialized.
 */

/*
 * ex. hmare ex pe , if we call load method , it will return
 * Employee(persistence class) obj with id , other property (name and sal) will
 * not return . and if we will call getter setter for name and sal , then load
 * method will call database and retrive other details.
 * 
 * Means it will call DB when required
 */


/** 3. Behavior when Object is not found in Session Cache or DB*/
 /*Apart from performance, this is another difference between get 
and load which is worth remembering. 
						get method of Hibernate Session class returns null
if an object is not found in the cache as well as on database 
while load() method throws ObjectNotFoundException 
if the object is not found on the cache as well as on database but never return null.*/


/** 4. Performance */
/*
 * By far the most important difference between get and load in my opinion. get
 * method will return a completely initialized object if Object is not on the
 * cache but exists on Database, which may involve multiple round-trips to the
 * database based upon object-relational mappings while load() method of
 * Hibernate can return a proxy which can be initialized on demand (lazy
 * initialization) when a non-identifier method is accessed.
 */

/*
 * Due to the above reason use of the load method will result in slightly better
 * performance, but there is a caveat that proxy objects will throw
 * ObjectNotFoundException later if the corresponding row doesn’t exist in the
 * database, instead of failing immediately so not a fail fast behavior.
 */