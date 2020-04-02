package securitySystem;

public interface UserCollection {
	void addUser(String id, String level, String kind);
	User getUser(String id);
	boolean idExist(String id);
	boolean isGranted(String id, String docName);
	boolean isRevoked(String id, String docName);
	void upload(String id, Document doc);
	void write(String id, String docName, String description);
}
