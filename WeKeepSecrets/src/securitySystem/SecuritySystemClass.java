package securitySystem;

public class SecuritySystemClass implements SecuritySystem {

	User users[];
	int counterUsers;
	
	private static final int DEFAULT_SIZE = 50, GROW_FACTOR = 2;
	
	public SecuritySystemClass() {
		users = new User[DEFAULT_SIZE];
		counterUsers = 0;
		
	}
	
	public boolean idExist(String id) {
		return findUser(id)!=-1;
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
		if(kind.equals("officer"))
			users[counterUsers++] = new OfficerClass(id, level);
		else if(kind.equals("clerk"))
			users[counterUsers++] = new ClerkClass(id, level);
		if(fullUsers())
			resize();
	}

	
	public void newDocument(String docName, String id, String level, String description) {
		
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
	
	public boolean fullUsers() {
		return counterUsers==users.length;
	}
	
	private void resize() {
		User[] sl = new User[GROW_FACTOR * users.length];
		for (int i = 0; i < counterUsers; i++)
			sl[i] = users[i];
		users = sl;

	}
	
	private int findUser(String userId) {
        int i = 0;
        while ((i < counterUsers)) {
            if (users[i].getId().equals(userId)) {
                return i;
            }
            i++;
        }
        return -1;
    }

}
