package securitySystem;
import users.User;

/**
 * Iterates Users.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class IteratorUserClass implements IteratorUser {

	private User[] user;
	private int counterUsers, nextUser; 
		
	/**
	 * Constructor of the IteratorUserClass, initialize variables.
	 * @param user - Array of users.
	 * @param counterUsers - Counter of the array.
	 */
	public IteratorUserClass(User[] user, int counterUsers) {
		this.counterUsers = counterUsers; 
		this.user = user;
		nextUser=0;
	}
		
	public boolean hasNext() {
			return nextUser < counterUsers;
	}
		
	public User next() {
		return user[nextUser++];
	}
}
