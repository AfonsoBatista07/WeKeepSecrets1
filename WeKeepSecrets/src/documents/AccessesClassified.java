package documents;

import securitySystem.IteratorString;
import securitySystem.IteratorUser;
import users.User;

/**
 * 
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface AccessesClassified {
	
	/**
	 * @return
	 */
	int getNumAccesses();
	/**
	 * @return
	 */
	int getNumRevoked();
	/**
	 * @return
	 */
	int getNumGrants();
	/**
	 * @param user
	 */
	void read(User user);
	/**
	 * @param user
	 */
	void write(User user);
	/**
	 * @param user
	 */
	void grant(User user);
	/**
	 * @param user
	 */
	void revoke(User user);
	/**
	 * @param user
	 * @return
	 */
	boolean hasGrant(User user);
	/**
	 * @param user
	 * @return
	 */
	boolean hasRevoke(User user);
	/**
	 * @return
	 */
	IteratorUser getIteratorAccesses();
	IteratorUser getIteratorGrants();
	IteratorString getIteratorStringAccesses();
	IteratorString getIteratorStringGrants();
}
