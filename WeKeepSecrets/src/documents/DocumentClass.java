package documents;

import users.User;

/**
 * 
 * @author Afonso Batista 57796
 * @author João Jorge 57994
 */
public abstract class DocumentClass implements Document{
	
	protected String manager, docName, level, description, type;
	
	public DocumentClass(String manager, String docName, String description, String level, String type) {
		this.manager = manager;
		this.docName = docName;
		this.description = description;
		this.level = level;
		this.type = type;
	}
	
	public abstract void read(User user);
	
	public abstract int getNumAccesses();
	
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
