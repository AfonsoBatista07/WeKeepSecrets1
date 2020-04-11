package securitySystem;

import documents.ClassifiedDocument;

import documents.Document;
import users.User;
import documents.OfficialDocument;


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
	
	public void grantUser(User user, String docName) {
		((ClassifiedDocument) getDoc(docName)).addGrant(user);
	}
	
	public void revokeUser(User user, String docName) {
		((ClassifiedDocument) getDoc(docName)).revokeGrant(user);
	}

	public boolean isGranted(User user, String docName) {
		return ((ClassifiedDocument) getDoc(docName)).isGranted(user);
	}
	
	public boolean isRevoked(User user, String docName) {
		return ((ClassifiedDocument) getDoc(docName)).isRevoked(user);
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
	
	public void write(User user, String docName, String description) {
		((ClassifiedDocument) getDoc(docName)).write(description, user);
	}
	
	public void read(User user, String docName) {
		getDoc(docName).read(user);
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
	
	public IteratorUser getIteratorAccesses(String docName) {
		return ((OfficialDocument) getDoc(docName)).getIteratorAccesses();
	}
}
