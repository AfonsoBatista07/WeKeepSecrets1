package documents;

import securitySystem.IteratorString;
import securitySystem.IteratorUser;
import users.User;

public interface AccessesClassified {
	int getNumAccesses();
	int getNumGrants();
	void read(User user);
	void write(User user);
	void grant(User user);
	void revoke(User user);
	boolean hasGrant(User user);
	boolean hasRevoke(User user);
	IteratorUser getIteratorAccesses();
	IteratorUser getIteratorGrants();
	IteratorString getIteratorStringAccesses();
	IteratorString getIteratorStringGrants();
}
