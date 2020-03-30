package securitySystem;

public interface User {
	public void upload(String docName, String id, String level, String description);
	
	public String getId();
	
	public String getLevel();
	public boolean docExist(String docName);
}
