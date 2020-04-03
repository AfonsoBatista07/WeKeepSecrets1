package Users;

public class OfficerClass extends UserClass {
	
	int granted, revoked;
	
	public OfficerClass(String id, String level) {
		super(id, level, "officer");
		
		granted = 0;
		revoked = 0;
	}
	
	public void incGranted() {
		granted++;
	}
	
	public int getGranted() {
		return granted;
	}
	
}
