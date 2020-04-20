package documents;

import securitySystem.IteratorUser;
import securitySystem.IteratorUserClass;
import users.User;

/**
 * Manages the accesses of the Official Document.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class AccessesOfficialClass implements AccessesOfficial{
	private User[] accesses;
	private int numAccesses, counter;
	private static final int DEFAULT_SIZE=10;
	
	/**
	 * Constructor of AccessesOfficialClass and initialization of variables.
	 */
	public AccessesOfficialClass() {
		accesses = new User[DEFAULT_SIZE];
		counter = 0;
		numAccesses = 0;
	}
	
	public void read(User user) {
		for(int i = 9; i >= 1; i--) {
			accesses[i] = accesses[i-1];
		}
		accesses[0] = user;
		if(counter < 10)
			counter++;
		numAccesses++;
	}
	
	public int getNumAccesses() {
		return numAccesses;
	}
	
	public IteratorUser getIteratorAccesses() {
		IteratorUser iteratorUser = new IteratorUserClass(accesses, counter);
		return iteratorUser;
	}

}
