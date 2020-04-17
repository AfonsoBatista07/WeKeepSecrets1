package users;

import documents.Document;
import securitySystem.IteratorDocs;
import securitySystem.IteratorDocsClass;

/**
 * 
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class UserClass implements User {

protected String id, level, kind;
	
	private Document[] docsUploaded;
	
	private int current;
	
	private static final int MAX_DOCS = 500, GROW_FACTOR = 2;
	
	public UserClass(String id, String level, String kind) {
		this.id = id;
		this.level = level;
		this.kind = kind;
		current = 0;
		
		docsUploaded = new Document[MAX_DOCS];
	}
	
	public void upload(Document doc) {
		
			docsUploaded[current++] = doc;
	
		if(fullUpload())
			resize();
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
	
	public int getNumDocs() {
		return current;
	}
	
	public boolean docExist(String docName) {
		return findDoc(docName)!=-1;
	}
	
	public IteratorDocs getIteratorDocs(String type) {
		IteratorDocs iteratorDocs = new IteratorDocsClass(docsUploaded, current, type);
		return iteratorDocs;

	}
	
	/**
	 * Resizes the Document array.
	 */
	private void resize() {
		Document[] sl = new Document[GROW_FACTOR * docsUploaded.length];
		for (int i = 0; i < current; i++)
			sl[i] = docsUploaded[i];
		docsUploaded = sl;

	}
	
	
	/**
	 * Verifies if the Document array is full.
	 * @return True if its full.
	 */
	private boolean fullUpload() {
		return current == docsUploaded.length;
	}

	
	/**
	 * Finds the position of the Document with the name docName in the Users Document array.
	 * @param docName - Name of the Document.
	 * @return Position of the Document in the array.
	 */
	private int findDoc(String docName) {
        int i = 0;
        while ((i < current)) {
            if (docsUploaded[i].getDocName().equals(docName)) {
                return i;
            }
            i++;
        }
        return -1;
    }
	
}
