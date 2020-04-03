package Documents;

public interface ClassifiedDocument extends Document {
	
	void read(String userId);
	
	int getNumGrants();
	
	void addGrant(String userId);
	
	void revokeGrant(String userId);
	
	void write(String description, String user);
	
	boolean isGranted(String userId);
	
	boolean isRevoked(String userId);
}
