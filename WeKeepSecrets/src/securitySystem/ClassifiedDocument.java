package securitySystem;

public interface ClassifiedDocument extends Document {
	
	void read(String userId);
	
	String getLevel();
	
	int getNumGrants();
	
	void addGrant(String userId);
	
	void revokeGrant(String userId);
	
	void write(String description, String user);
	
	boolean isGranted(String userId);
	
	boolean isRevoked(String userId);
}
