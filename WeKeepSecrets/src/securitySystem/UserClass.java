package securitySystem;

public class UserClass implements User {

protected String id, level, kind;
	
	private Document[] docsUploaded;
	
	private int current;
	
	private static final int MAX_DOCS = 500, GROW_FACTOR = 2;
	
	public UserClass(String id, String level, String kind) {
		this.id = id;
		this.level = level;
		current = 0;
		
		docsUploaded= new Document[MAX_DOCS];
	}
	
	public void upload(Document doc) {
		
			docsUploaded[current++] = doc;
	
		if(fullUpload())
			resize();
	}
	
	public void write(String docName, String description, String userId) {
		docsUploaded[findDoc(docName)].write(description, userId);
	}
	
	public String getId() {
		return id;
	}
	
	public String getLevel() {
		return level;
	}
	
	public String getKind() {
		return kind;
	}
	
	private void resize() {
		Document[] sl = new Document[GROW_FACTOR * docsUploaded.length];
		for (int i = 0; i < current; i++)
			sl[i] = docsUploaded[i];
		docsUploaded = sl;

	}
	
	private boolean fullUpload() {
		return current == docsUploaded.length;
	}

	private int findDoc(String docName) {
        int i = 0;
        while ((i < current)) {
            if (docsUploaded[i].getName().equals(docName)) {
                return i;
            }
            i++;
        }
        return -1;
    }
	
	public boolean docExist(String docName) {
		return findDoc(docName)!=-1;
	}
	
	public boolean isGranted(String docName) {
		return docsUploaded[findDoc(docName)].isGranted();
	}
	
	public boolean isRevoked(String docName) {
		return docsUploaded[findDoc(docName)].isRevoked();
	}
	
}
