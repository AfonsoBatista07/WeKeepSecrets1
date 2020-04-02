package securitySystem;

public interface User {
	void upload(Document doc);
	void write(String docName, String description, String userId);
	
	String getId();
	
	String getLevel();
	boolean docExist(String docName);
	boolean isGranted(String docName);
	boolean isRevoked(String docName);
	
}
