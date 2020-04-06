package documents;

import securitySystem.IteratorUser;
import users.User;

public interface AccessesOfficial {
	
	void read(User user);
	IteratorUser getIteratorAccesses();
	int getNumAccesses();
}
