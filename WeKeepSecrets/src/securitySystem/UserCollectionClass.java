package securitySystem;

import documents.ClassifiedDocument;
import documents.Document;
import users.*;

public class UserCollectionClass implements UserCollection {

	User users[], usersByGrants[];
	int counterUsers, counterUserByGrants;
	
	private static final int DEFAULT_SIZE=50, GROW_FACTOR=2;
	
	public UserCollectionClass() {
		users = new User[DEFAULT_SIZE];
		usersByGrants = new User[DEFAULT_SIZE];
		counterUsers = 0;
		counterUserByGrants = 0;
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
	
	public void grant(String id) {
		((Officer) getUser(id)).incGranted();
	}
	
	public void revoke(String id) {
		((Officer) getUser(id)).incRevoked();
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
	
	public IteratorUser getIteratorUser() {
		IteratorUser iteratorUser = new IteratorUserClass(users, counterUsers);
		return iteratorUser;

	}
	
	public IteratorDocs getIteratorDocs(String userId, String type) {
		return getUser(userId).getIteratorDocs(type);

	}
	
	public IteratorUser getIteratorUserByGrant() {
		listOnlyOfficers();
		sortByName();
		sortByGrants();
		IteratorUser iteratorUser = new IteratorUserClass(usersByGrants, counterUserByGrants);
		return iteratorUser;

	}
	
	private void listOnlyOfficers() {
		for(int i = 0; i < counterUsers; i++) {
			if(users[i].getKind().equalsIgnoreCase("officer")) {
				if(((Officer) users[i]).getNumGrants() > 0) {
					usersByGrants[counterUserByGrants++] = users[i];
				}
			}
		}
	}
	
	private void sortByGrants() {
		for (int i = 1; i < counterUserByGrants; i++) { 
			for (int j = counterUserByGrants -1; j >= i; j--) {
				if (((Officer)usersByGrants[j-1]).getNumGrants()<(((Officer)usersByGrants[j]).getNumGrants())) { 
					
					User temp = usersByGrants[j - 1]; 
					usersByGrants[j-1] = usersByGrants[j]; 
					usersByGrants[j] = temp; 
				}
			}
		}
	}
	
	private void sortByName() {
		for (int i = 0; i < counterUserByGrants; i++) { 
			for (int j = i+1; j < counterUserByGrants; j++) {
				if (usersByGrants[i].getId().compareTo(usersByGrants[j].getId())>0) { 
					
					User temp = usersByGrants[i]; 
					usersByGrants[i] = usersByGrants[j]; 
					usersByGrants[j] = temp; 
				}
			}
		}
	}
}
