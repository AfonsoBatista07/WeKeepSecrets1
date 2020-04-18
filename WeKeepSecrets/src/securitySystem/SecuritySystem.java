package securitySystem;

/**
 * Falta fazer os pre requisitos
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface SecuritySystem {

	/**Verifies if the User with the Id given is registered in the system.
	 * @param userId - Id user.
	 * @return True if the user was already registered.
	 */
	boolean idExist(String userId);
	
	/**Verifies if the Document from the User exists in the Users Document array.
	 * @param userId - Id of the User.
	 * @param docName - Name of the Document.
	 * @return True if the Document exists.
	 */
	boolean docExist(String userId, String docName);
	
	/**Verifies if the User is able to access the Document.
	 * @param userId - Id of the User.
	 * @param docName - Name of the Document.
	 * @return True if the User can access the Document.
	 */
	boolean canManage(String userId, String docName);
	
	/**Verifies if the Users security level is lower than the security level given.
	 * @param userId - Id of the User.
	 * @param level - Security Level.
	 * @return True if the Users security level is lower then the security level given.
	 */
	boolean lowerSecurityLevel(String userId, String level);
	
	/**Verifies is a Document is an official Document.
	 * @param docName - Name of the Document.
	 * @return True if the Document is an official Document.
	 */
	boolean isOfficialDoc(String docName);
	
	/**Verifies if a given User is a Clerk.
	 * @param userId - Id of the User.
	 * @return True is the user is a Clerk.
	 */
	boolean isUserClerk(String userId);
	
	/**Verifies if the User is a Clerk and the type is classified.
	 * @param userId - Id of the User.
	 * @param type - Type ( Clerk or Officer).
	 * @return True if Users type matches the type given.
	 */
	boolean matchesType(String userId, String type);
	
	/**Verifies if the User has been granted access to the given Document.
	 * @param userId - Id of the User.
	 * @param docName - Name of the Document.
	 * @return True if the User has been granted access to the Document.
	 */
	boolean granted(String userId, String docName);
	
	/**Verifies if the User has been revoked access to the given Document.
	 * @param userId - Id of the User.
	 * @param docName - Name of the Document.
	 * @return True if the User has been revoked access to the Document.
	 */
	boolean revoked(String userId, String docName);
	
	/**
	 * @return Iterator of the users array;
	 */
	IteratorUser createIteratorUser();
	
	/**
	 * @return Iterator of the usersByGrants array;
	 */
	IteratorUser createIteratorUserByGrant();
	
	/**
	 * @return Iterator of the docsByGrants array;
	 */
	IteratorDocs createIteratorDocsByGrant();
	
	/**
	 * @param userId - Id of the User managing the Document.
	 * @param type - Type ( Official or Classified).
	 * @return Iterator of the Users Documents that match the type given.
	 */
	IteratorDocs createIteratorDocs(String userId, String type);
	
	/**
	 * @param docName - Name of the Document
	 * @return Iterator of the Documents accesses array.
	 */
	IteratorUser createIteratorAccessesOfficial(String docName);
	
	/**
	 * Registers the User into the System.
	 * @param kind - Kind ( Clerk or Officer).
	 * @param userId - Id of the User.
	 * @param level - Security Level of the User.
	 */
	void regist(String kind, String userId, String level);
	
	/**
	 * Registers the Document into the System.
	 * @param docName - Name of the Document.
	 * @param userId - Id of User managing of the Document.
	 * @param level - Security level of the Document.
	 * @param description - Description of the Document.
	 */
	void newDocument(String docName, String userId, String level, String description);
	
	/**
	 * Changes the description of the Document.
	 * @param userId - Id of the User managing the Document.
	 * @param docName - Name of the Document.
	 * @param description - New description.
	 */
	void write(String userId, String docName, String description);
	
	/**
	 * Grants the User access to the Document and increments teh variables regarding writing.
	 * @param userId - Id of the User.
	 * @param ManagerId - Id of the User Managing the Document.
	 * @param docName - Name of the Document.
	 */
	void grantUser(String userId, String ManagerId, String docName);
	
	/**
	 * Revokes Users access to the Document.
	 * @param userId - Id of the User.
	 * @param ManagerId - Id of the User managing the Document.
	 * @param docName - Name of the Document
	 */
	void revokeUser(String userId, String ManagerId,String docName);
	
	/**
	 * Increments the variables regarding reading.
	 * @param userId - Id the User.
	 * @param docName - Name of the Document.
	 */
	void read(String userId, String docName);
	
	/**
	 * @param docName - Name of the Document.
	 * @return Description of the Document with the given Name.
	 */
	String getDecription(String docName);
	
	/**
	 * @param userId - Id of the User.
	 * @return Users security level.
	 */
	String getUserLevel(String userId);
	
	/**
	 * @param docName - Name of the Document.
	 * @return Documents security levels.
	 */
	String getDocLevel(String docName);
	
	/**
	 * @param docName - Name of the Document.
	 * @return Iterator the Users that accessed the Classified Document given.
	 */
	IteratorUser createIteratorAccessesClassified(String docName);
	
	/**
	 * @param docName - Name of the Document.
	 * @return Iterator of the Users granted or revoked from the Classified Document given.
	 */
	IteratorUser createIteratorGrants(String docName);
	
	/**
	 * @param docName - Name of the Document.
	 * @return Iterator of the type of accesses ( write or read ) of the Classified Document given.
	 */
	IteratorString createIteratorStringAccesses(String docName);
	
	/**
	 * @param docName - Name of the Document.
	 * @return Iterator of the type of grant ( revoked or granted ) of the Classified Document given.
	 */
	IteratorString createIteratorStringGrants(String docName);
	
}
