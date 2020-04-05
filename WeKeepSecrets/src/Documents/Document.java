package Documents;

public interface Document {

	void read(String userId);
	
	int getNumAccesses();
	
	String getLevel();
	
	String getDescription();
	
	String getManager();
	
	String getDocName();
	
	String getType();
	
}
