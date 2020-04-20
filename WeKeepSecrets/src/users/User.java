package users;

import documents.Document;
import securitySystem.IteratorDocs;

/**
 * Interface of the UserClass that implements a User.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface User {
	
	/**
	 * Adds Document to the Users Document list.
	 * @param doc - Document uploaded.
	 */
	void upload(Document doc);
	
	/**
	 * @return True if the User is a Clerk.
	 */
	boolean isClerk();
	
	/**
	 * @return Users Id.
	 */
	String getId();
	
	/**
	 * @return Users Security Level.
	 */
	String getLevel();
	
	/**
	 * @return Kind of User(Officer or Clerk).
	 */
	String getKind();
	
	/**
	 * Verifies if the Document with the name docName already exists in the Users Document array.
	 * @param docName - Name of the Document.
	 * @return True if it exists, False if not.
	 */
	boolean docExist(String docName);
	
	/**
	 * @param type - Type of document(Official, Classified).
	 * @return Iterator with an array of the Users Documents with the desired type .
	 */
	IteratorDocs getIteratorDocs(String type);
	
	/**
	 * @return Number of Documents in the Users Document array.
	 */
	int getNumDocs();
}
