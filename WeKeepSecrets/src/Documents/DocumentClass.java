package Documents;

public abstract class DocumentClass implements Document{
	
	protected String manager, docName, level, description, type;
	
	public DocumentClass(String manager, String docName, String description, String level, String type) {
		this.manager = manager;
		this.docName = docName;
		this.description = description;
		this.level = level;
		this.type = type;
	}
	
	public abstract void read(String userId);
	
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
