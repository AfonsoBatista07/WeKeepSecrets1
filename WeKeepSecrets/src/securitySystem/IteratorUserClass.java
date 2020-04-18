package securitySystem;
import users.User;

/**
 * 
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class IteratorUserClass implements IteratorUser {

	private User[] user;
	private int counterUsers, nextUser; 
		
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
