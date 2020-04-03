package securitySystem;

import Documents.*;


public class SecuritySystemClass implements SecuritySystem {

	UserCollection users;
	DocumentCollection docs;
	
	public SecuritySystemClass() {
		users = new UserCollectionClass();
		docs = new DocumentCollectionClass();
		
	}
	
	public boolean idExist(String UserId) {
		return users.idExist(UserId);
	}

	
	public boolean docExist(String UserId, String docName) {
		return users.getUser(UserId).docExist(docName);
	}

	
	public boolean lowerSecurityLevel(String UserId, String level) {
		return getUserLevel(UserId)<levelToNum(level);
	}

	public boolean canManage(String UserId, String docName) {
		return getUserLevel(UserId)>=getDocLevel(docName) || granted(UserId,docName);
	}
	
	public boolean officialDoc(String docName) {
		return getDocLevel(docName)==0;
	}

	
	public boolean userClerk(String UserId) {
		return getUserLevel(UserId)==0;
	}


	public boolean granted(String UserId, String docName) {
		return docs.isGranted(UserId, docName);						// Pode ser private
	}

	
	public boolean revoked(String UserId, String docName) {
		return docs.isRevoked(UserId, docName);
	}

	
	public Iterator createIterator() {
		
		return null;
	}

	
	public void regist(String kind, String UserId, String level) {
		users.addUser(UserId, level, kind);
	}

	
	public void newDocument(String docName, String UserId, String level, String description) {
		Document doc;
		if(level.equals("OFFICIAL"))
			doc = new OfficialDocumentClass(UserId, docName, description); 
		else 
			doc = new ClassifiedDocumentClass(UserId, docName, level, description);
		
		docs.addDocument(doc);
		users.upload(UserId, doc);
	}

	
	public void write(String UserId, String docName, String description) {
		docs.write(UserId, docName, description);
	}
	
	public void read(String UserId) {
		docs.read(UserId);
	}
	
	public void grantUser(String UserId, String docName) {
		docs.grantUser(UserId, docName);

	}
	
	public void revokeUser(String UserId, String docName) {
		docs.revokeUser(UserId, docName);
	}

	
	public String getDecription(String docName) {
		return docs.getDescription(docName);
	}
	
	public int getUserLevel(String UserId) {
		return levelToNum(users.getUser(UserId).getLevel());
	}
	
	public int getDocLevel(String docName) {
		return levelToNum(docs.getDoc(docName).getLevel());
	}
	
	public int levelToNum(String level) {
		switch(Levels.valueOf(level)) {
			case OFFICIAL:
				return Levels.OFFICIAL.getIntLevel();
			case CONFIDENCIAL:
				return Levels.CONFIDENCIAL.getIntLevel();
			case SECRET:
				return Levels.SECRET.getIntLevel();
			case TOPSECRET:
				return Levels.TOPSECRET.getIntLevel();
		}
		return -1;
	}

}
