package securitySystem;

public interface Document {

	void read(String userId);
	
	String getLevel();
	
	String getDescription();
	
	String getManager();
	
	String getDocName();
	
}
