package documents;

import securitySystem.IteratorUser;
import users.User;

/**
 * Interface of the AccessesOfficialClass that manages the accesses of an Official Document.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface AccessesOfficial {
	
	/**
	 * @return The number of accesses(Reads) an Official Document have.
	 */
	int getNumAccesses();
	
	/**
	 * Adds user to accesses array.
	 * @param user - The user reading.
	 */
	void read(User user);
	
	/**
	 * @return an iterator for accesses array.
	 */
	IteratorUser getIteratorAccesses();
	
	
}
