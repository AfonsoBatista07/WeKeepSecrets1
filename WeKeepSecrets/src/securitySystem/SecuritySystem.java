package securitySystem;

public interface SecuritySystem {

	boolean idExist(String id);
	boolean docExist(String id, String docName);
	boolean canManage(String id);
	boolean officialDoc(String docName);
	boolean userClerk(String id);
	boolean granted(String id, String docName);
	boolean revoked(String id, String docName);
	Iterator createIterator();
	void regist(String kind, String id, String level);
	void newDocument(String docName, String id, String level, String description);
	void write(String description);
	void accessToDocument(String id, String docName);
	void revokeUser(String id, String docName);
	String getDecription(String docName);
	
}
