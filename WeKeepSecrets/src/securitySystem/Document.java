package securitySystem;

public interface Document {

	void read(String userId);
	
	void write(String description, String userId);
	
	boolean isGranted(String userId);
	
	boolean isRevoked(String userId);
	
	String getLevel();
	
	String getDescription();
	
	String getManager();
	
	String getDocName();
	
}
