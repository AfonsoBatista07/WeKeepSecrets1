package securitySystem;

public interface ClassifiedDocument {
	
	public void read(String userId);
	
	public String getLevel();
	
	public int getNumGrants();
	
	public void addGrant(String userId);
	
	public void revokeGrant(String userId);
	
	public void write(String description, String userId);
}
