package securitySystem;

public interface User {
	void upload(Document doc);
	
	String getId();
	
	String getLevel();
	boolean docExist(String docName);
	
}
