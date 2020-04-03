package securitySystem;

import Documents.Document;
import Users.User;

public interface UserCollection {
	void addUser(String id, String level, String kind);
	User getUser(String id);
	boolean idExist(String id);
	void upload(String id, Document doc);
}
