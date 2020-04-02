package securitySystem;

public interface SecuritySystem {

	boolean idExist(String id);
	boolean docExist(String id, String docName);
	boolean canManage(String id, String docName);
	boolean lowerSecurityLevel(String id, String level);
	boolean officialDoc(String docName);
	boolean userClerk(String id);
	boolean granted(String id, String docName);
	boolean revoked(String id, String docName);
	Iterator createIterator();
	void regist(String kind, String id, String level);
	void newDocument(String docName, String id, String level, String description);
	void write(String id, String docName, String description);
	void grantUser(String id, String docName);
	void revokeUser(String id, String docName);
	void read(String id);
	String getDecription(String docName);
	int getUserLevel(String id);
	int getDocLevel(String docName);
	
	
}
