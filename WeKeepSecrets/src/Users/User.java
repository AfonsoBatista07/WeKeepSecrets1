package Users;

import Documents.Document;

public interface User {
	void upload(Document doc);
	
	String getId();
	
	String getLevel();
	boolean docExist(String docName);
	
}
