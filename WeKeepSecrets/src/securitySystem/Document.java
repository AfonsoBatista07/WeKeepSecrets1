package securitySystem;

public interface Document {

	public void read(String userId);
	
	public String getLevel();
	
	public String getDescription();
	
	public String getManager();
	
	public String getDocName();
	
}
