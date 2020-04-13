package securitySystem;

public interface SecuritySystem {

	boolean idExist(String userId);
	boolean docExist(String userId, String docName);
	boolean canManage(String userId, String docName);
	boolean lowerSecurityLevel(String userId, String level);
	boolean officialDoc(String docName);
	boolean userClerk(String userId);
	boolean matchesType(String userId, String type);
	boolean granted(String userId, String docName);
	boolean revoked(String userId, String docName);
	IteratorUser createIteratorUser();
	IteratorUser createIteratorUserByGrant();
	IteratorDocs createIteratorDocsByGrant();
	IteratorDocs createIteratorDocs(String userId, String type);
	IteratorUser createIteratorAccessesOfficial(String docName);
	void regist(String kind, String userId, String level);
	void newDocument(String docName, String userId, String level, String description);
	void write(String userId, String docName, String description);
	void grantUser(String userId, String ManagerId, String docName);
	void revokeUser(String userId, String ManagerId,String docName);
	void read(String userId, String docName);
	String getDecription(String docName);
	int getUserLevel(String userId);
	int getDocLevel(String docName);
	IteratorUser createIteratorAccessesClassified(String docName);
	IteratorUser createIteratorGrants(String docName);
	IteratorString createIteratorStringAccesses(String docName);
	IteratorString createIteratorStringGrants(String docName);
	
}
