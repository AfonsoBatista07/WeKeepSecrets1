package documents;

import users.User;
import securitySystem.IteratorUser;

public interface OfficialDocument {
	
	void read(User user);
	IteratorUser getIteratorAccesses();
}
