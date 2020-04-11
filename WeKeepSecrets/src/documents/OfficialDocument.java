package documents;

import users.User;
import securitySystem.IteratorUser;

public interface OfficialDocument extends Document{
	
	void read(User user);
	IteratorUser getIteratorAccesses();
}
