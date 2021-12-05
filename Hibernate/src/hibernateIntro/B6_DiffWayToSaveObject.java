package hibernateIntro;

public class B6_DiffWayToSaveObject {

}

//persist()
/*
 * Hibernate persist is similar to save() and it adds the entity object to
 * the persistent context.
 */


/* public void persist(Object object)throws HibernateException */

/*
 * However, persist() doesn’t return anything so we need to call the persisted
 * object’s getter method to get the generated identifier value
 */

/*
 * We just have to replace the call to session.save() with the call to
 * session.persist()
 */

// save() V/s persist()

//save
/*
 * It is only supported by Hibernate. 
 * It returns generated id and return type is Serializable 
 */

//persist
/*
 * It is also supported by other JPA implementations
 *  It does not return anything.  It has void return type.
 *   No guarantee , about when id will be generated . 
 *   It can generate id on commit or flush
 */

/** Special Note: */
/*	There are some more differences between the two , but  we will
discuss it during the topic “States of an object”.*/ 




