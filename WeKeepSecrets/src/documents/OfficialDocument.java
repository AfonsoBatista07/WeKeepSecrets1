package documents;

import users.User;
import securitySystem.IteratorUser;

/**
 * 
 * @author Afonso Batista 57796
 * @author Jo�o Jorge 57994
 */
public interface OfficialDocument extends Document{
	
	void read(User user);
	IteratorUser getIteratorAccesses();
}
