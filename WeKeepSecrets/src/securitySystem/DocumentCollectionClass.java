package securitySystem;

public class DocumentCollectionClass implements DocumentCollection {

	Document documents[];
	int counterDoc;
	
	private static final int DEFAULT_SIZE=50, GROW_FACTOR=2;
	
	public DocumentCollectionClass() {
		
		documents = new Document[DEFAULT_SIZE];
		counterDoc = 0;
		
	}
	
	public void addDocument(String docName, String id, String level, String description) {
		if(level.equals("official"))
			documents[counterDoc++] = new DocumentClass(id, docName,description); 
		else 
			documents[counterDoc++] = new ClassifiedDocumentClass( id, docName, level, description);
		if(fullDocs())
			resize();
	}

	
	public Document getDocument(String docName) {
		return documents[findDoc(docName)];
	}

	
	public boolean docExist(String docName) {
		return findDoc(docName)!=-1;
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
            if (documents[i].getName().equals(docName)) {
            	System.out.println(documents[i].getName());
            	System.out.println(docName);
                return i;
            }
            i++;
        }
        return -1;
    }
	
}
