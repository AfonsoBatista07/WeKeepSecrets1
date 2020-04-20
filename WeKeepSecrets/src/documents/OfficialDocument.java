package documents;

import users.User;
import securitySystem.IteratorUser;

/**
 * Interface of the OfficialDocumentClass that implements an Official Document.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface OfficialDocument extends Document{
	
	/**
	* Reads an Official Document.
	* @param user - The user reading.
	*/
	void read(User user);
	
	/**
	 * @return The number of accesses(Reads) a Official Document have.
	 */
	int getNumAccesses();
	
	/**
	 * @return an iterator for accesses array.
	 */
	IteratorUser getIteratorAccesses();
}
