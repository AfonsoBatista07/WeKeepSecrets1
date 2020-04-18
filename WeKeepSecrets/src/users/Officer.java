package users;

/**
 * 
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface Officer extends User {
	
	
	/**
	 * Increments the number of grants the User has given.
	 */
	void incGranted();
	
	/**
	 * @return Number of grants the User has given.
	 */
	int getNumGrants();
	
	
	/**
	 * Increments the number of revokes the User has given.
	 */
	void incRevoked();
	
	
	/**
	 * @return Number of revoke the User has given.
	 */
	int getNumRevokes();
}
