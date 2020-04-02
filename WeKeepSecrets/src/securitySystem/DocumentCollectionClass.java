package securitySystem;

public class DocumentCollectionClass implements DocumentCollection {

	Document documents[];
	int counterDoc;
	
	private static final int DEFAULT_SIZE=50, GROW_FACTOR=2;
	
	public DocumentCollectionClass() {
		
		documents = new Document[DEFAULT_SIZE];
		counterDoc = 0;
		
	}
	
	public void addDocument(Document doc) {
		
			documents[counterDoc++] = doc; 
		
		if(fullDocs())
			resize();
	}

	public boolean isGranted(String id, String docName) {
		return getDoc(docName).isGranted(id);
	}
	
	public boolean isRevoked(String id, String docName) {
		return getDoc(docName).isRevoked(id);
	}
	
	public Document getDoc(String docName) {
		return documents[findDoc(docName)];
	}
	
	public boolean docExist(String docName) {
		return findDoc(docName)!=-1;
	}
	
	public String getDescription(String docName) {
		return getDoc(docName).getDescription();
	}
	
	public void write(String id, String docName, String description) {
		getDoc(docName).write(description, id);
	}
	
	public void read(String id) {
			getDoc(id).read(id);
	}

	private void resize() {
		Document[] sl = new Document[GROW_FACTOR * documents.length];
		for (int i = 0; i < counterDoc; i++)
			sl[i] = documents[i];
		documents = sl;
	}
	
	public boolean fullDocs() {
		return counterDoc==documents.length;
	}
	
	private int findDoc(String docName) {
        int i = 0;
        while ((i < counterDoc)) {
            if (documents[i].getDocName().equals(docName)) {
                return i;
            }
            i++;
        }
        return -1;
    }
	
}
