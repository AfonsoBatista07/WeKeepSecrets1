package securitySystem;

import Documents.ClassifiedDocument;
import Documents.Document;

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
	
	public void grantUser(String userId, String docName) {
		((ClassifiedDocument) getDoc(docName)).addGrant(userId);
	}
	
	public void revokeUser(String userId, String docName) {
		((ClassifiedDocument) getDoc(docName)).revokeGrant(userId);
	}

	public boolean isGranted(String userId, String docName) {
		return ((ClassifiedDocument) getDoc(docName)).isGranted(userId);
	}
	
	public boolean isRevoked(String userId, String docName) {
		return ((ClassifiedDocument) getDoc(docName)).isRevoked(userId);
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
	
	public void write(String userId, String docName, String description) {
		((ClassifiedDocument) getDoc(docName)).write(description, userId);
	}
	
	public void read(String userId, String docName) {
		getDoc(docName).read(userId);
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
