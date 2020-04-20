package documents;

import users.User;

/**
 * Implements a Document.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public abstract class DocumentClass implements Document{
	
	protected String manager, docName, level, description, type;
	private static final String OFFICIAL = "official";
	
	/**
	 * Constructor of the DocumentClass and initialization of variables.
	 * @param manager - Name of the User managing the Document.
	 * @param docName - Name of the Document.
	 * @param description - Description of the Document.
	 * @param level - Security level of the Document.
	 * @param type - Type of the Document (official or classified).
	 */
	public DocumentClass(String manager, String docName, String description, String level, String type) {
		this.manager = manager;
		this.docName = docName;
		this.description = description;
		this.level = level;
		this.type = type;
	}
	
	public abstract void read(User user);
	
	public abstract int getNumAccesses();
	
	public boolean isOfficial() {
		return type.equalsIgnoreCase(OFFICIAL);
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
