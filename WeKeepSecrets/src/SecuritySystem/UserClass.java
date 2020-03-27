package SecuritySystem;
public class UserClass implements User {
	private String id, level;
	
	private String[] docsUploaded;
	
	private int current;
	
	private static final int MAX_DOCS = 500;
	private static final int GROW_FACTOR = 2;
	
	public UserClass(String id, String level) {
		this.id = id;
		this.level = level;
		current = 0;
		
		docsUploaded= new String[MAX_DOCS];
	}
	
	public void upload(String name) {
		if(current == docsUploaded.length) {
			resize();
		}
		docsUploaded[current++] = name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getLevel() {
		return level;
	}
	
	private void resize() {
		String[] sl = new String[GROW_FACTOR * docsUploaded.length];
		for (int i = 0; i < current; i++)
			sl[i] = docsUploaded[i];
		docsUploaded = sl;

	}
}
