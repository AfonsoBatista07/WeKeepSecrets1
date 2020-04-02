package securitySystem;

public class OfficialDocumentClass extends DocumentClass implements OfficialDocument{

	private String[] lastRead;
	private int current;
	
	private static final int MAX_NAMES = 10;
	
	public OfficialDocumentClass(String manager, String docName, String description) {
		super(manager, docName, description,"Official");
		
		
		current = 0;
		lastRead = new String[MAX_NAMES];
	}
	
	public void read(String userId) {
		if(current == MAX_NAMES)
			current = 0;
		lastRead[current++] = userId;
	}
	
	public void write(String description, String userId) {       
		       																// ?????????????????????????????????
	}
	
	public boolean isGranted(String userId) {
		return false;
	}
	
	public boolean isRevoked(String userId) {
		return false;
	}
	
}
