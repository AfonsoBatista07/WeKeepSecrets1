package securitySystem;

import documents.Document;
import users.User;

public interface DocumentCollection {
	void addDocument(Document doc);
	Document getDoc(String docName);
	boolean docExist(String docName);
	void grantUser(String id, String docName);
	void revokeUser(String id, String docName);
	void read(User user, String docName);
	void write(String id, String docName, String description);
	boolean isGranted(String userId, String docName);
	boolean isRevoked(String userId, String docName);
	String getDescription(String docName);
}
