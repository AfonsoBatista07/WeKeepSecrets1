package securitySystem;

public interface DocumentCollection {
	void addDocument(Document doc);
	Document getDoc(String docName);
	boolean docExist(String docName);
	void read(String id);
	void write(String id, String docName, String description);
	String getDescription(String docName);
}
