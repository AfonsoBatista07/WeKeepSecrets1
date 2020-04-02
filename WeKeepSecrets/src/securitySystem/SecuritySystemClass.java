package securitySystem;

public class SecuritySystemClass implements SecuritySystem {

	UserCollection users;
	DocumentCollection docs;
	
	private static final String OFFICIAL = "official", CONFIDENCIAL = "confidencial", SECRET = "secret", TOPSECRET = "topsecret"; 
	
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

	
	public boolean lowerSecurityLevel(String id, String level) {
		return getUserLevel(id)<levelToNum(level);
	}

	public boolean canManage(String id, String docName) {
		return getUserLevel(id)>=getDocLevel(docName) || granted(id,docName);
	}
	
	public boolean officialDoc(String docName) {
		return getDocLevel(docName)==0;
	}

	
	public boolean userClerk(String id) {
		return getUserLevel(id)==0;
	}


	public boolean granted(String id, String docName) {
		return docs.isGranted(id, docName);						// Pode ser private
	}

	
	public boolean revoked(String id, String docName) {
		return docs.isRevoked(id, docName);
	}

	
	public Iterator createIterator() {
		
		return null;
	}

	
	public void regist(String kind, String id, String level) {
		users.addUser(id, level, kind);
	}

	
	public void newDocument(String docName, String id, String level, String description) {
		Document doc;
		if(level.equals("official"))
			doc = new OfficialDocumentClass(id, docName, description); 
		else 
			doc = new ClassifiedDocumentClass( id, docName, level, description);
		
		docs.addDocument(doc);
		users.upload(id, doc);
	}

	
	public void write(String id, String docName, String description) {
		docs.write(id, docName, description);
	}
	
	public void read(String id) {
		docs.read(id);
	}
	
	public void grantUser(String id, String docName) {
		docs.grantUser(id, docName);

	}
	
	public void revokeUser(String id, String docName) {
		docs.revokeUser(id, docName);
	}

	
	public String getDecription(String docName) {
		return docs.getDescription(docName);
	}
	
	public int getUserLevel(String id) {
		return levelToNum(users.getUser(id).getLevel());
	}
	
	public int getDocLevel(String docName) {
		return levelToNum(docs.getDoc(docName).getLevel());
	}
	
	public int levelToNum(String level) {
		switch(level) {
			case OFFICIAL:
				return 0;
			case CONFIDENCIAL:
				return 1;
			case SECRET:
				return 2;
			case TOPSECRET:
				return 3;
		}
		return -1;
	}

}
