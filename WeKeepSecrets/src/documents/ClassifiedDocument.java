package documents;

import securitySystem.IteratorString;
import securitySystem.IteratorUser;
import users.User;

public interface ClassifiedDocument extends Document {
	
	void read(User user);
	int getNumAccesses();
	int getNumGrants();
	int getNumRevoked();
	void addGrant(User user);
	void revokeGrant(User user);
	void write(String description, User user);
	boolean isGranted(User user);
	boolean isRevoked(User user);
	IteratorUser getIteratorAccesses();
	IteratorUser getIteratorGrants();
	IteratorString getIteratorStringAccesses();
	IteratorString getIteratorStringGrants();
}
