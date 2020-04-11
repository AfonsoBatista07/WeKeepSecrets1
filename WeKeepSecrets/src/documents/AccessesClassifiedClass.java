package documents;

import securitySystem.IteratorUser;
import securitySystem.IteratorUserClass;
import users.User;

public class AccessesClassifiedClass implements AccessesClassified  {
	private String[] accessesType, grantType;
	private User[] accesses, grants;
	private static final int DEFAULT_SIZE=10, GROW_FACTOR = 2;
	private int counterGrants, counterAccesses;
	
	public AccessesClassifiedClass() {
		accessesType = new String[DEFAULT_SIZE];
		grantType = new String[DEFAULT_SIZE];
		grants = new User[DEFAULT_SIZE];
		accesses = new User[DEFAULT_SIZE];
		counterGrants = 0;
		counterAccesses = 0;
		
	}
	
	public int getNumAccesses() {
		return counterAccesses;
	}
	
	public int getNumGrants() {
		return counterGrants;
	}
	
	public void read(User user) {
		if(fullAccesses()) resizeBothArrays(accesses, counterAccesses, accessesType);
		accesses[counterAccesses] = user;
		accessesType[counterAccesses] = "read";
		counterAccesses++;
	}
	
	public void write(User user) {
		if(fullAccesses()) resizeBothArrays(accesses, counterAccesses, accessesType);
		accesses[counterAccesses] = user;
		accessesType[counterAccesses] = "write";
		counterAccesses++;
	}
	
	public void grant(User user) {
		if(fullGrants()) resizeBothArrays(grants, counterGrants, grantType);
		grants[counterGrants] = user;
		grantType[counterGrants] = "grant";
		counterGrants++;
	}
	
	public void revoke(User user) {
		if(fullGrants()) resizeBothArrays(grants, counterGrants, grantType);
		grants[counterGrants] = user;
		grantType[counterGrants] = "revoked";
		counterGrants++;
	}
	
	public boolean hasGrant(User user) {
		if(backwardsFindUser(user, grants, counterGrants) == -1)
			return false;
		if(grantType[backwardsFindUser(user, grants, counterGrants)].equals("grant")  )
			return true;
		else return false;
	}
	
	public boolean hasRevoke(User user) {
		if(backwardsFindUser(user, grants, counterGrants) == -1)
			return false;
		if(grantType[backwardsFindUser(user, grants, counterGrants)].equals("revoke")  )
			return true;
		else return false;
	}
	
	private int backwardsFindUser(User user, User[] userArray, int counterUser) {
		int i = counterUser -1;
        while (i >= 0) {
            if (userArray[i].equals(user)) {
                return i;
            }
            i--;
        }
        return -1;
	}

	
	private void resizeBothArrays(User[] userArray, int counter, String[] stringArray) {
		User[] ul = new User[GROW_FACTOR * userArray.length];
		for (int i = 0; i < counter; i++)
			ul[i] = userArray[i];
		userArray = ul;
		
		String[] sl = new String[GROW_FACTOR * stringArray.length];
		for (int i = 0; i < counter; i++)
			sl[i] = stringArray[i];
		stringArray = sl;
	}
	
	private boolean fullAccesses() {
		return counterAccesses==accesses.length;
	}
	
	private boolean fullGrants() {
		return counterGrants == grants.length;
	}
	
	public IteratorUser getIteratorAccesses() {
		IteratorUser iteratorUser = new IteratorUserClass(accesses, counterAccesses);
		return iteratorUser;
	}
	
	public IteratorUser getIteratorGrants() {
		IteratorUser iteratorUser = new IteratorUserClass(accesses, counterGrants);
		return iteratorUser;
	}
	
	//Falta Iterador De Strings
}