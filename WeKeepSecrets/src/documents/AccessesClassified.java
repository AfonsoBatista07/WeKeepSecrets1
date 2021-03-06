package documents;

import securitySystem.IteratorString;
import securitySystem.IteratorUser;
import users.User;

/**
 * Interface of the AccessesClassifiedClass that manages the accesses of a Classified Document.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface AccessesClassified {
	
	/**
	 * @return The number of accesses(Writes and Reads) a Classified Document has.
	 */
	int getNumAccesses();
	
	/**
	 * @return The number of revokes a Classified Document has.
	 */
	int getNumRevoked();
	
	/**
	 * @return The number of grants a Classified Document has.
	 */
	int getNumGrants();
	
	/**
	 * Adds the user to accesses and the String "read" to accessesType arrays.
	 * @param user - The user reading.
	 */
	void read(User user);
	
	/**
	 * Adds the user to accesses and the String "write" to accessesType arrays.
	 * @param user - The user writing.
	 */
	void write(User user);
	
	/**
	 * Adds the user to grants and the String "grant" to grantType arrays.
	 * @param user - The user granted.
	 */
	void grant(User user);
	
	/**
	 * Adds the user to grants and the String "revoked" to grantType arrays.
	 * @param user - The user revoked.
	 */
	void revoke(User user);
	
	/**
	 * @param user - The user.
	 * @return True if the user has been granted access to the Classified Document.
	 */
	boolean isGranted(User user);
	
	/**
	 * @param user - The user.
	 * @return True if the users access has been revoked to the Classified Document.
	 */
	boolean isRevoked(User user);
	
	/**
	 * @return an iterator for accesses array.
	 */
	IteratorUser getIteratorAccesses();
	
	/**
	 * @return an iterator for grants array.
	 */
	IteratorUser getIteratorGrants();
	
	/**
	 * @return an iterator for the StringAccesses array.
	 */
	IteratorString getIteratorStringAccesses();
	
	/**
	 * @return an iterator for the StringGrants array.
	 */
	IteratorString getIteratorStringGrants();
}
