package documents;

import users.User;

public interface AccessesOfficial {
	
	void read(User user);
	
	int getNumAccesses();
}
