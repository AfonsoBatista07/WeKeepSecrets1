package Documents;

public abstract class DocumentClass implements Document{
	
	protected String manager, docName, level, description, type;
	protected int numAccesses;
	
	public DocumentClass(String manager, String docName, String description, String level, String type) {
		this.manager = manager;
		this.docName = docName;
		this.description = description;
		this.level = level;
		this.type = type;
		numAccesses = 0;
	}
	
	public abstract void read(String userId);
	
	public int getNumAccesses() {
		return numAccesses;
	}
	
	public String getType() {
		return type;
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
