package documents;

import users.User;

public class ClassifiedDocumentClass extends DocumentClass implements ClassifiedDocument{
	
	private AccessesClassified accesses;

	public ClassifiedDocumentClass(String manager, String name, String level, String description) {
		super(manager, name, description, level, "classified");
		accesses = new AccessesClassifiedClass();
	}
	
	public void read(User user) {
		accesses.read(user);
	}
	
	public int getNumGrants() {
		return accesses.getNumGrants();
	}
	
	public int getNumAccesses() {
		return accesses.getNumAccesses();
	}
	
	public void addGrant(User user) {
		accesses.grant(user);
	}
	
	public void revokeGrant(User user) {
		accesses.revoke(user);
	}
	
	public void write(String description,User user) {
		super.description = description;
		accesses.write(user);
	}
	
	public boolean isGranted(User user) {
		return accesses.hasGrant(user);
	}
	
	public boolean isRevoked(User user) {
		return accesses.hasRevoke(user);
	}

}
