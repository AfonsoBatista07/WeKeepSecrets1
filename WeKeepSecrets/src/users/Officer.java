package users;

public interface Officer extends User {
	void incGranted();
	
	int getNumGrants();
	
	void incRevoked();
	
	int getNumRevokes();
}
