package securitySystem;

public class UserCollectionClass implements UserCollection {

	User users[];
	int counterUsers;
	
	private static final int DEFAULT_SIZE=50, GROW_FACTOR=2;
	
	public UserCollectionClass() {
		users = new User[DEFAULT_SIZE];
		counterUsers = 0;
	}
	
	public void addUser(String id, String level, String kind) {
		if(kind.equals("officer"))
			users[counterUsers++] = new OfficerClass(id, level);
		else if(kind.equals("clerk"))
			users[counterUsers++] = new ClerkClass(id, level);
		if(fullUsers())
			resize();
	}

	public User getUser(String id) {
		return users[findUser(id)];
	}

	public boolean idExist(String id) {
		return findUser(id)!=-1;
	}
	
	public void upload(String id, Document doc) {
		getUser(id).upload(doc);
	}

	private void resize() {
		User[] sl = new User[GROW_FACTOR * users.length];
		for (int i = 0; i < counterUsers; i++)
			sl[i] = users[i];
		users = sl;
	}
	
	public boolean fullUsers() {
		return counterUsers==users.length;
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
