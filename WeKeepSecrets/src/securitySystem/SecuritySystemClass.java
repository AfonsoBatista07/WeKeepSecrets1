package securitySystem;

public class SecuritySystemClass implements SecuritySystem {

	
	public boolean idExist(String id) {
		
		return false;
	}

	
	public boolean docExist(String id, String docName) {
		
		return false;
	}

	
	public boolean canManage(String id) {
		
		return false;
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
		

	}

	
	public void newDocument(String docName, String id, String level, String description) {
		

	}

	
	public void setDescription(String description) {
		

	}

	
	public void accessToDocument(String id, String docName) {
		

	}
	
	public void revokeUser(String id, String docName) {
		
	}

	
	public String getDecription(String docName) {
		
		return null;
	}

}
