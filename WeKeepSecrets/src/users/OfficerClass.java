package users;

public class OfficerClass extends UserClass implements Officer{
	
	int granted, revoked;
	
	public OfficerClass(String id, String level) {
		super(id, level, "officer");
		
		granted = 0;
		revoked = 0;
	}
	
	public void incGranted() {
		granted++;
	}
	
	public int getNumGrants() {
		return granted;
	}
	
	public void incRevoked() {
		revoked++;
	}
	
	public int getNumRevokes() {
		return revoked;
	}
	
}
