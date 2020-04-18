package securitySystem;

import documents.Document;

/**
 * 
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class IteratorDocsClass implements IteratorDocs {

	private String type;
	private Document[] docs;
	private int counterDocs, nextDoc; 
		
	public IteratorDocsClass(Document[] docs, int counterDocs, String type) {
		this.counterDocs = counterDocs; 
		this.docs = docs;
		initialize(type);
		
	}
	
	public void initialize(String type) {
		nextDoc=0;
		this.type = type;
		while (nextDoc < counterDocs && !docs[nextDoc].getType().equals(type)) {
			nextDoc++;
		}
	}
		
	public boolean hasNext() {
		return nextDoc < counterDocs;
	}
		
	public Document next() {
		Document res = docs[nextDoc++];
		while (nextDoc < counterDocs && !docs[nextDoc].getType().equals(type)) {
			nextDoc++;
		}
		return res;
	}
}
