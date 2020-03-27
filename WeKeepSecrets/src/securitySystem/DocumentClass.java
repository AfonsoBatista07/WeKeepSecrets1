package securitySystem;
public class DocumentClass implements Document{
	private String manager, name, level, description;
	private int current;
	private String[] lastRead;
	
	private static final int MAX_NAMES = 10;
	
	public DocumentClass(String manager, String name, String description) {
		this.manager = manager;
		this.name = name;
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
	
	public void write(String description) {
		this.description = description;
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
	
	public String getName() {
		return name;
	}
	
	
}
