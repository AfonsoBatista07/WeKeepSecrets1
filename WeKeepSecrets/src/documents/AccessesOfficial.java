package documents;

import securitySystem.IteratorUser;
import users.User;

/**
 * 
 * @author Afonso Batista 57796
 * @author Jo�o Jorge 57994
 */
public interface AccessesOfficial {
	
	/**
	 * @return The number of accesses(Reads) an Official Document have.
	 */
	int getNumAccesses();
	
	/**
	 * Adds the last ten users to accesses array.
	 * @param user - The user reading.
	 */
	void read(User user);
	
	/**
	 * @return an iterator for accesses array.
	 */
	IteratorUser getIteratorAccesses();
	
	
}
