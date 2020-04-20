package securitySystem;

import documents.*;

/**
 * Processes all the information from the other classes.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class SecuritySystemClass implements SecuritySystem {

	UserCollection users;
	DocumentCollection docs;
	
	private static final String OFFICIAL = "official";
	
	/**
	 * Constructor of the SecuritySystemClass, initialize classes.
	 */
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
		return Levels.valueOf(level.toUpperCase()).isGreaterThan(Levels.valueOf(getUserLevel(userId).toUpperCase()));
	}

	public boolean matchesType(String userId, String type) {
		return isUserClerk(userId) && !isOfficialLevel(type);              
	}
	
	public boolean canManage(String userId, String docName) {
		return !lowerSecurityLevel(userId, getDocLevel(docName)) || granted(userId,docName);
	}
	
	public boolean isOfficialDoc(String docName) {
		return docs.isOfficial(docName);
	}
	
	public boolean isUserClerk(String userId) {
		return users.isClerk(userId);
	}

	public boolean granted(String userId, String docName) {
		return docs.isGranted(users.getUser(userId), docName);	
	}
	
	public boolean revoked(String userId, String docName) {
		return docs.isRevoked(users.getUser(userId), docName);
	}

	public IteratorUser createIteratorUser() {
		return users.getIteratorUser();
	}
	
	public IteratorUser createIteratorUserByGrant() {
		return users.getIteratorUserByGrant();
	}
	
	public IteratorDocs createIteratorDocsByGrant() {
		return docs.getIteratorDocsByGrants();
	}
	
	public IteratorDocs createIteratorDocs(String userId, String type) {
		return users.getIteratorDocs(userId, type);
	}
	
	public IteratorUser createIteratorAccessesOfficial(String docName) {
		return docs.getIteratorAccessesOfficial(docName);
	}
	
	public IteratorUser createIteratorAccessesClassified(String docName) {
		return docs.getIteratorAccessesClassified(docName);
	}
	
	public IteratorUser createIteratorGrants(String docName) {
		return docs.getIteratorGrants(docName);
	}
	
	public IteratorString createIteratorStringAccesses(String docName) {
		return docs.getIteratorStringAccesses(docName);
	}
	
	public IteratorString createIteratorStringGrants(String docName) {
		return docs.getIteratorStringGrants(docName);
	}
	
	public void regist(String kind, String userId, String level) {
		users.addUser(userId, level, kind);
	}

	public void newDocument(String docName, String userId, String level, String description) {
		Document doc;
		if(isOfficialLevel(level))
			doc = new OfficialDocumentClass(userId, docName, description); 
		else 
			doc = new ClassifiedDocumentClass(userId, docName, level, description);
		
		docs.addDocument(doc);
		users.upload(userId, doc);
	}

	
	public void write(String userId, String docName, String description) {
		docs.write(users.getUser(userId), docName, description);
	}
	
	public void read(String userId, String docName) {
		
		docs.read(users.getUser(userId), docName);
	}
	
	public void grantUser(String userId, String ManagerId, String docName) {
		docs.grantUser(users.getUser(userId), docName);
		users.grant(ManagerId);

	}
	
	public void revokeUser(String userId,String ManagerId, String docName) {
		docs.revokeUser(users.getUser(userId), docName);
		users.revoke(ManagerId);
	}

	
	public String getDecription(String docName) {
		return docs.getDescription(docName);
	}
	
	/**
	 * @param level - Document Level.
	 * @return True if level equals Official.
	 */
	private boolean isOfficialLevel(String level) {
		return level.equalsIgnoreCase(OFFICIAL);
	}
	
	/**
	 * @param userId - Id of the User.
	 * @return Users security level.
	 * @pre idExists().
	 */
	private String getUserLevel(String userId) {
		return users.getUser(userId).getLevel();
	}
	
	/**
	 * @param docName - Name of the Document.
	 * @return Documents security levels.
	 * @pre docExists().
	 */
	private String getDocLevel(String docName) {
		return docs.getDoc(docName).getLevel();
	}
}
