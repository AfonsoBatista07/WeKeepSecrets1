package securitySystem;

public class SecuritySystemClass implements SecuritySystem {

	UserCollection users;
	DocumentCollection docs;
	
	public SecuritySystemClass() {
		users = new UserCollectionClass();
		docs = new DocumentCollectionClass();
		
	}
	
	public boolean idExist(String id) {
		return users.idExist(id);
	}

	
	public boolean docExist(String id, String docName) {
		return users.getUser(id).docExist(docName);
	}

	
	public boolean canManage(String id, String level) {
		return levelToNum(users.getUser(id).getLevel())>=levelToNum(level);
	}

	
	public boolean officialDoc(String docName) {
		
		return false;
	}

	
	public boolean userClerk(String id) {
	
		return false;
	}


	public boolean granted(String id, String docName) {
	
		return false;
	}

	
	public boolean revoked(String id, String docName) {

		return false;
	}

	
	public Iterator createIterator() {
		
		return null;
	}

	
	public void regist(String kind, String id, String level) {
		users.addUser(id, level, kind);
	}

	
	public void newDocument(String docName, String id, String level, String description) {
		docs.addDocument(id, docName, level, description);
		users.getUser(id).upload(id, docName, level, description);
	}

	
	public void write(String description) {
		

	}

	
	public void accessToDocument(String id, String docName) {
		

	}
	
	public void revokeUser(String id, String docName) {
		
	}

	
	public String getDecription(String docName) {
		
		return null;
	}
	
	public int levelToNum(String level) {
		switch(level) {
			case "official":
				return 0;
			case "confidencial":
				return 1;
			case "secret":
				return 2;
			case "topsecret":
				return 3;
		}
		return -1;
	}

}
