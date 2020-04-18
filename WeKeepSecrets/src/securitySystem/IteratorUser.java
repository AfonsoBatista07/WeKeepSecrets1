package securitySystem;

import users.User;

/**
 * 
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface IteratorUser {

	/**
	 * @return True if there is a next element in the array.
	 */
	boolean hasNext();
	
	/**
	 * @return The next User from the array.
	 */
	User next();
}
