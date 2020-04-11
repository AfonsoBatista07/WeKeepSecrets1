package documents;

import users.User;

public interface ClassifiedDocument extends Document {
	
	void read(User user);
	
	int getNumGrants();
	
	int getNumAccesses();
	
	void addGrant(User user);
	
	void revokeGrant(User user);
	
	void write(String description, User user);
	
	boolean isGranted(User user);
	
	boolean isRevoked(User user);
}
