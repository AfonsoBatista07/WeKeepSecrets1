package securitySystem;

public class OfficerClass extends UserClass {
	
	int granted;
	
	public OfficerClass(String id, String level) {
		super(id, level, "officer");
		
		granted = 0;
	}
	
	public void incGranted() {
		granted++;
	}
	
	public int getGranted() {
		return granted;
	}
	
}
