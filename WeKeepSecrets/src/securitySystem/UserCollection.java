package securitySystem;

import documents.Document;
import users.User;

/**
 * Interface of the UserCollectionClass Implements a array of users.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface UserCollection {
	
	/**
	 * Adds User to the users array.
	 * @param id - Id of the User.
	 * @param level - Level of the User.
	 * @param kind - Kind of User ( Clerk or Officer).
	 */
	void addUser(String id, String level, String kind);
	
	/**
	 * @param id - Id of the User
	 * @return User with the id given.
	 */
	User getUser(String id);
	
	/**
	 * Verifies if a User with the id given exists.
	 * @param id - Id of the User.
	 * @return
	 */
	boolean idExist(String id);
	
	/**
	 * @param id - Id of the user.
	 * @return True is the User is a Clerk.
	 */
	boolean isClerk(String id);
	
	/**
	 * Uploads Document to the Users Document array.
	 * @param id - Id of the user.
	 * @param doc - Document
	 */
	void upload(String id, Document doc);
	
	/**
	 * Increments the number of grants of the User with the given Id.
	 * @param id - User Id.
	 */
	void grant(String id);
	
	/**
	 * Increments the number of revokes of the User with the given Id.
	 * @param id - User Id.
	 */
	void revoke(String id);
	
	/**
	 * @return Iterator of the users array.
	 */
	IteratorUser getIteratorUser();
	
	/**
	 * @return Iterator of the users sorted by number of grants.
	 */
	IteratorUser getIteratorUserByGrant();
	
	/**
	 * @param userId - User Id
	 * @param type - Type of Document (Classified or Official)
	 * @return Iterator of the Users Documents with the type given.
	 */
	IteratorDocs getIteratorDocs(String userId, String type);
}
