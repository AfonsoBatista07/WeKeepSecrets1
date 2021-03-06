package documents;

import securitySystem.IteratorString;
import securitySystem.IteratorUser;
import users.User;

/**
 * Interface of the ClassifiedDocumentClass that implements a Classified Document.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface ClassifiedDocument extends Document {
	
	/**
	 * Reads a Classified Document.
	 * @param user - The user reading.
	 */
	void read(User user);
	
	/**
	 * @return The number of accesses(Writes and Reads) a Classified Document has.
	 */
	int getNumAccesses();
	
	/**
	 * @return The number of grants a Classified Document has.
	 */
	int getNumGrants();
	
	/**
	 * @return The number of revokes a Classified Document has.
	 */
	int getNumRevoked();
	
	/**
	 * Grant the user access to the document.
	 * @param user - The user granted.
	 */
	void addGrant(User user);
	
	/**
	 * Revoke a user access to the document.
	 * @param user - The user revoked.
	 */
	void revokeGrant(User user);
	
	/**
	 * Writes a new description on a document.
	 * @param description - New description you want to write on the document. 
	 * @param user - The user writing.
	 */
	void write(String description, User user);
	
	/**
	 * @param user - The user.
	 * @return True if the user has been granted access to the Classified Document.
	 */
	boolean isGranted(User user);
	
	/**
	 * @param user - The user.
	 * @return True if the user has been revoked access to the Classified Document.
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
