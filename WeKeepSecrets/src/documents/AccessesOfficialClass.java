package documents;

import users.User;

public class AccessesOfficialClass implements AccessesOfficial{
	private User[] accesses;
	private int numAccesses, current;
	private static final int DEFAULT_SIZE=10, GROW_FACTOR=2;
	
	public AccessesOfficialClass() {
		accesses = new User[DEFAULT_SIZE];
		current = 0;
		numAccesses = 0;
	}
	
	public void read(User user) {
		if(current == 10) {
			for(int i = 0; i-1 < current; i++) {
				accesses[i] = accesses[i+1];
			}
			current = 9;
		}
		accesses[current++] = user;
		numAccesses++;
	}
	
	public int getNumAccesses() {
		return numAccesses;
	}

}
