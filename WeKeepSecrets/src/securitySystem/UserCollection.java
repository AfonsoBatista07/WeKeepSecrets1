package securitySystem;

import documents.Document;
import users.User;

public interface UserCollection {
	void addUser(String id, String level, String kind);
	User getUser(String id);
	boolean idExist(String id);
	void upload(String id, Document doc);
	IteratorUser getIteratorUser();
	IteratorDocs getIteratorDocs(String userId, String type);
}
