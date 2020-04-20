package documents;

import users.User;

/**
 * 
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface Document {

	/**
	* Reads a Document.
	* @param user - The user reading.
	*/
	void read(User user);
	
	/**
	 * @return True if the Document is an Official Document.
	 */
	boolean isOfficial();
	
	/**
	 * @return The number of accesses(Writes and Reads) a Classified Document has.
	 */
	int getNumAccesses();
	
	/**
	 * @return The document Level.
	 */
	String getLevel();
	
	/**
	 * @return The document Description.
	 */
	String getDescription();
	
	/**
	 * @return The document Manager.
	 */
	String getManager();
	
	/**
	 * @return The document Name.
	 */
	String getDocName();
	
	/**
	 * @return The document Type (Official or Classified).
	 */
	String getType();
	
}
