package documents;

import users.User;

/**
 * 
 * @author Afonso Batista 57796
 * @author João Jorge 57994
 */
public interface Document {

	void read(User user);
	int getNumAccesses();
	String getLevel();
	String getDescription();
	String getManager();
	String getDocName();
	String getType();
	
}
