package securitySystem;

public interface DocumentCollection {
	void addDocument(String docName, String id, String level, String description);
	Document getDocument(String docName);
	boolean docExist(String docName);
}
