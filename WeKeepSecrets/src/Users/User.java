package Users;

import Documents.Document;
import securitySystem.IteratorDocs;

public interface User {
	void upload(Document doc);
	
	String getId();
	
	String getLevel();
	
	String getKind();
	boolean docExist(String docName);
	IteratorDocs getIteratorDocs(String type);
}
