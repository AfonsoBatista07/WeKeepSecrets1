package documents;

import users.User;

public interface Document {

	void read(User user);
	int getNumAccesses();
	String getLevel();
	String getDescription();
	String getManager();
	String getDocName();
	String getType();
	
}
