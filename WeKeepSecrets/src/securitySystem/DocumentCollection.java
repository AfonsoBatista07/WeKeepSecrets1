package securitySystem;

import documents.Document;
import users.User;

/**
 * 
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface DocumentCollection {
	
	/**
	 * Adds Document to the documents array.
	 * @param doc - Document.
	 */
	void addDocument(Document doc);
	
	/**
	 * @param docName - Name of the Document.
	 * @return Document with the given name.
	 */
	Document getDoc(String docName);
	
	/**
	 * Adds User to the Document granted users list.
	 * @param user - User.
	 * @param docName - Name of the Document.
	 */
	void grantUser(User user, String docName);
	
	/**
	 * Adds User to the Document revoked users list.
	 * @param user - User.
	 * @param docName - Name of the Document.
	 */
	void revokeUser(User user, String docName);
	
	/**
	 * Adds User to the access history.
	 * @param user - User.
	 * @param docName - Name of the Document.
	 */
	void read(User user, String docName);
	
	/**
	 * Adds User to the access history and changes the Documents description.
	 * @param user - User.
	 * @param docName - Name of the Document.
	 * @param description - Description.
	 */
	void write(User user, String docName, String description);
	
	/**
	 * Verifies if the User has been granted access to the Document.
	 * @param user - User.
	 * @param docName - Name of the Document.
	 * @return True if the User has been granted access to the Document.
	 */
	boolean isGranted(User user, String docName);
	
	/**
	 * Verifies if the Users access to the Document has been revoked.
	 * @param user - User.
	 * @param docName - Name of the Document.
	 * @return True if the Users access to the Document has been revoked.
	 */
	boolean isRevoked(User user, String docName);
	
	/**
	 * @param docName - Name of the Document.
	 * @return True if the Document is an Official Document.
	 */
	boolean isOfficial(String docName);
	
	/**
	 * @param docName - Name of the Document.
	 * @return Documents description.
	 */
	String getDescription(String docName);
	
	/**
	 * @return Iterator of the documentsByGrants array.
	 */
	IteratorDocs getIteratorDocsByGrants();
	
	/**
	 * @param docName - Name of the Document
	 * @return Iterator of the array of the Users that accessed the Official Document.
	 */
	IteratorUser getIteratorAccessesOfficial(String docName);
	
	/**
	 * @param docName - Name of the Document
	 * @return Iterator of the array of the Users that accessed the Classified Document.
	 */
	IteratorUser getIteratorAccessesClassified(String docName);
	
	/**
	 * @param docName - Name of the Document.
	 * @return Iterator of the array of Granted and Revoked Users from the Document.
	 */
	IteratorUser getIteratorGrants(String docName);
	
	/**
	 * @param docName - Name of the Document.
	 * @return Iterator of the type of accesses (read or write) of the Document.
	 */
	IteratorString getIteratorStringAccesses(String docName);
	
	/**
	 * @param docName - Name of the Document.
	 * @return Iterator of the type of grants (revoked or granted) of the Document.
	 */
	IteratorString getIteratorStringGrants(String docName);
}
