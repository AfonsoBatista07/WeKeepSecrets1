package securitySystem;

import documents.*;


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
	
	public boolean docExist(String userId, String docName) {
		return users.getUser(userId).docExist(docName);
	}
	
	public boolean lowerSecurityLevel(String userId, String level) {
		return getUserLevel(userId)<levelToNum(level);
	}

	public boolean matchesType(String userId, String type) {
		return getUserLevel(userId)<1 && type.equalsIgnoreCase("classified");              // Quando tiverem com o cerebro menos derretido metam isto mais bonito :D
	}
	
	public boolean canManage(String userId, String docName) {
		return getUserLevel(userId)>=getDocLevel(docName) || granted(userId,docName);
	}
	
	public boolean officialDoc(String docName) {
		return getDocLevel(docName)==0;
	}

	
	public boolean userClerk(String userId) {
		return getUserLevel(userId)==0;
	}

	public boolean granted(String userId, String docName) {
		return docs.isGranted(userId, docName);	
	}
	
	public boolean revoked(String userId, String docName) {
		return docs.isRevoked(userId, docName);
	}

	public IteratorUser createIteratorUser() {
		return users.getIteratorUser();
	}
	
	public IteratorUser createIteratorUserByGrant() {
		return users.getIteratorUserByGrant();
	}
	
	public IteratorDocs createIteratorDocs(String userId, String type) {
		return users.getIteratorDocs(userId, type);
	}
	
	public IteratorUser createIteratorAccesses(String docName) {
		return docs.getIteratorAccesses(docName);
	}
	
	public void regist(String kind, String userId, String level) {
		users.addUser(userId, level, kind);
	}

	
	public void newDocument(String docName, String userId, String level, String description) {
		Document doc;
		if(level.equals("official"))
			doc = new OfficialDocumentClass(userId, docName, description); 
		else 
			doc = new ClassifiedDocumentClass(userId, docName, level, description);
		
		docs.addDocument(doc);
		users.upload(userId, doc);
	}

	
	public void write(String userId, String docName, String description) {
		docs.write(userId, docName, description);
	}
	
	public void read(String userId, String docName) {
		
		docs.read(users.getUser(userId), docName);
	}
	
	public void grantUser(String userId, String ManagerId, String docName) {
		docs.grantUser(userId, docName);
		users.grant(ManagerId);

	}
	
	public void revokeUser(String userId,String ManagerId, String docName) {
		docs.revokeUser(userId, docName);
		users.revoke(ManagerId);
	}

	
	public String getDecription(String docName) {
		return docs.getDescription(docName);
	}
	
	public int getUserLevel(String userId) {
		return levelToNum(users.getUser(userId).getLevel());
	}
	
	public int getDocLevel(String docName) {
		return levelToNum(docs.getDoc(docName).getLevel());
	}
	
	public int levelToNum(String level) {
		switch(Levels.valueOf(level.toUpperCase())) {
			case OFFICIAL:
				return Levels.OFFICIAL.getIntLevel();
			case CONFIDENTIAL:
				return Levels.CONFIDENTIAL.getIntLevel();
			case SECRET:
				return Levels.SECRET.getIntLevel();
			case TOPSECRET:
				return Levels.TOPSECRET.getIntLevel();
		}
		return -1;
	}

}
