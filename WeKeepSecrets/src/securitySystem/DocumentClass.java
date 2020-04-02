package securitySystem;
public class DocumentClass implements Document{
	protected String manager, docName, level, description;
	private int current;
	private String[] lastRead;
	
	private static final int MAX_NAMES = 10;
	
	public DocumentClass(String manager, String docName, String description) {
		this.manager = manager;
		this.docName = docName;
		this.level = "official";
		this.description = description;
		
		current = 0;
		
		lastRead = new String[MAX_NAMES];
	}
	
	public void read(String userId) {
		if(current == MAX_NAMES) {
			current = 0;
		}
		lastRead[current++] = userId;
	}
	
	public String getLevel() {
		return level;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getManager() {
		return manager;
	}
	
	public String getDocName() {
		return docName;
	}
	
}
