package securitySystem;

import documents.Document;
import users.*;

/**
 * Implements a array of users.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class UserCollectionClass implements UserCollection {

	User users[], usersByGrants[];
	int counterUsers, counterUserByGrants;
	
	private static final int DEFAULT_SIZE=50, GROW_FACTOR=2;
	private static final String CLERK = "clerk";
	
	/**
	 * Constructor of the UserCollectionClass, initialize variables.
	 */
	public UserCollectionClass() {
		users = new User[DEFAULT_SIZE];
		usersByGrants = new User[DEFAULT_SIZE];
		counterUsers = 0;
		counterUserByGrants = 0;
	}
	
	public void addUser(String id, String level, String kind) {
		if(isKindClerk(kind))
			users[counterUsers++] = new ClerkClass(id, level);
		else users[counterUsers++] = new OfficerClass(id, level);
		if(fullUsers())
			resize();
	}
	
	private boolean isKindClerk(String kind) {
		return kind.equalsIgnoreCase(CLERK);
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
	
	public boolean isClerk(String id) {
		return getUser(id).isClerk();
	}
	
	public void upload(String id, Document doc) {
		getUser(id).upload(doc);
	}
	
	public boolean fullUsers() {
		return counterUsers==users.length;
	}
	
	public IteratorUser getIteratorUser() {
		IteratorUser iteratorUser = new IteratorUserClass(users, counterUsers);
		return iteratorUser;

	}
	
	public IteratorDocs getIteratorDocs(String userId, String type) {
		return getUser(userId).getIteratorDocs(type);

	}
	
	public IteratorUser getIteratorUserByGrant() {
		listOnlyOfficersWithGrants();
		sortByName();
		sortByGrants();
		if(counterUserByGrants > 10) counterUserByGrants = 10;
		IteratorUser iteratorUser = new IteratorUserClass(usersByGrants, counterUserByGrants);
		return iteratorUser;

	}
	
	/**
	 * Resizes the users array.
	 */
	private void resize() {
		User[] sl = new User[GROW_FACTOR * users.length];
		for (int i = 0; i < counterUsers; i++)
			sl[i] = users[i];
		users = sl;
	}
	
	/**
	 * Organizes the userByGrants array with the officers with grants from the users array.
	 */
	private void listOnlyOfficersWithGrants() {
		counterUserByGrants = 0;
		for(int i = 0; i < counterUsers; i++) {
			if(!users[i].isClerk()) {
				if(((Officer) users[i]).getNumGrants() > 0) {
					usersByGrants[counterUserByGrants++] = users[i];
				}
			}
		}
	}
	
	
	/**
	 * Sorts the userByGrants array by decreasing number of grants.
	 */
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
	
	/**
	 * Sorts userByGrants array by alphabetical order.
	 */
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
	
	
	/**
	 * @param userId - User id.
	 * @return Position of the User with the Id given in the users array.
	 */
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
