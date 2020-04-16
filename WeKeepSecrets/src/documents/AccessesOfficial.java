package documents;

import securitySystem.IteratorUser;
import users.User;

/**
 * 
 * @author Afonso Batista 57796
 * @author João Jorge 57994
 */
public interface AccessesOfficial {
	
	void read(User user);
	IteratorUser getIteratorAccesses();
	int getNumAccesses();
}
