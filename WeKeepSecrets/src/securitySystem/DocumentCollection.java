package securitySystem;

import documents.Document;
import users.User;


public interface DocumentCollection {
	void addDocument(Document doc);
	Document getDoc(String docName);
	boolean docExist(String docName);
	void grantUser(User user, String docName);
	void revokeUser(User user, String docName);
	void read(User user, String docName);
	void write(User user, String docName, String description);
	boolean isGranted(User user, String docName);
	boolean isRevoked(User user, String docName);
	String getDescription(String docName);
	IteratorUser getIteratorAccesses(String docName);
}
