package securitySystem;
public abstract class DocumentClass implements Document{
	
	protected String manager, docName, level, description;
	
	public DocumentClass(String manager, String docName, String description, String level) {
		this.manager = manager;
		this.docName = docName;
		this.description = description;
		this.level = level;
		
	}
	
	public abstract void read(String userId);
	
	public abstract void write(String description, String userId);
	
	public abstract boolean isGranted(String userId);
	
	public abstract boolean isRevoked(String userId);
	
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
