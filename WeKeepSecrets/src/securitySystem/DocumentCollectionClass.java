package securitySystem;

import documents.ClassifiedDocument;
import documents.Document;
import users.User;
import documents.OfficialDocument;

/**
 * Interface of the DocumentCollectionClass Implements a array of Documents.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class DocumentCollectionClass implements DocumentCollection {

	Document documents[], documentsByGrant[];
	int counterDoc, counterDocsByGrant;
	
	private static final int DEFAULT_SIZE=50, GROW_FACTOR=2;
	
	/**
	 * Constructor of the DocumentCollectionClass, initialize variables.
	 */
	public DocumentCollectionClass() {
		
		documents = new Document[DEFAULT_SIZE];
		documentsByGrant = new Document[DEFAULT_SIZE];
		counterDoc = 0;
		counterDocsByGrant = 0;
		
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
	
	public boolean isOfficial(String docName) {
		return getDoc(docName).isOfficial();
	}
	
	public Document getDoc(String docName) {
		return documents[findDoc(docName)];
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

	public boolean fullDocs() {
		return counterDoc==documents.length;
	}
	
	public IteratorUser getIteratorAccessesOfficial(String docName) {
		return ((OfficialDocument) getDoc(docName)).getIteratorAccesses();
	}
	
	public IteratorUser getIteratorAccessesClassified(String docName) {
		return ((ClassifiedDocument) getDoc(docName)).getIteratorAccesses();
	}
	
	public IteratorUser getIteratorGrants(String docName) {
		return ((ClassifiedDocument) getDoc(docName)).getIteratorGrants();
	}
	
	public IteratorString getIteratorStringAccesses(String docName) {
		return ((ClassifiedDocument) getDoc(docName)).getIteratorStringAccesses();
	}
	
	public IteratorString getIteratorStringGrants(String docName) {
		return ((ClassifiedDocument) getDoc(docName)).getIteratorStringGrants();
	}
	
	public IteratorDocs getIteratorDocsByGrants() {
		listOnlyDocumentsWithGrants();
		sortByName();
		sortByGrants();
		if(counterDocsByGrant > 10) counterDocsByGrant = 10;
		IteratorDocs iteratorDocs = new IteratorDocsClass(documentsByGrant, counterDocsByGrant, "classified");
		return iteratorDocs;

	}
	
	/**
	 * Resizes the documents array.
	 */
	private void resize() {
		Document[] sl = new Document[GROW_FACTOR * documents.length];
		for (int i = 0; i < counterDoc; i++)
			sl[i] = documents[i];
		documents = sl;
	}

	/**
	 * Finds the position of the Document with the given name in the documents array or returns -1 if the document doesnt exist.
	 * @param docName - Name of the Document.
	 * @return Position of the Document if it exists in the array, else returns -1.
	 */
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
	
	/**
	 * Organizes the docsByGrant array by decreasing number of grants of the classified Documents from the Documents array. 
	 */
	private void listOnlyDocumentsWithGrants() {
		counterDocsByGrant = 0;
		for(int i = 0; i < counterDoc; i++) {
			if(!documents[i].isOfficial()) {
				if(((ClassifiedDocument) documents[i]).getNumGrants() > 0) {
					documentsByGrant[counterDocsByGrant++] = documents[i];
				}
			}
		}
	}
	
	/**
	 * Sorts the docsByGrant by decreasing number of grants.
	 */
	private void sortByGrants() {
		for (int i = 1; i < counterDocsByGrant; i++) { 
			for (int j = counterDocsByGrant -1; j >= i; j--) {
				if (((ClassifiedDocument)documentsByGrant[j-1]).getNumGrants()<(((ClassifiedDocument)documentsByGrant[j]).getNumGrants())) { 
					
					Document temp = documentsByGrant[j - 1]; 
					documentsByGrant[j-1] = documentsByGrant[j]; 
					documentsByGrant[j] = temp; 
				}
			}
		}
	}
	
	/**
	 * Sorts the docsByGrant by alphabetical order.
	 */
	private void sortByName() {
		for (int i = 0; i < counterDocsByGrant; i++) { 
			for (int j = i+1; j < counterDocsByGrant; j++) {
				if (documentsByGrant[i].getDocName().compareTo(documentsByGrant[j].getDocName())>0) { 
					
					Document temp = documentsByGrant[i]; 
					documentsByGrant[i] = documentsByGrant[j]; 
					documentsByGrant[j] = temp; 
				}
			}
		}
	}

}
