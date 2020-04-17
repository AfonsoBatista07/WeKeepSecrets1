package documents;

import securitySystem.IteratorString;
import securitySystem.IteratorUser;
import users.User;

/**
 * 
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
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
	
	public int getNumRevoked() {
		return accesses.getNumRevoked();
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
		return accesses.isGranted(user);
	}
	
	public boolean isRevoked(User user) {
		return accesses.isRevoked(user);
	}
	
	public IteratorUser getIteratorAccesses() {
		return accesses.getIteratorAccesses();
	}
	public IteratorUser getIteratorGrants() {
		return accesses.getIteratorGrants();
	}
	public IteratorString getIteratorStringAccesses() {
		return accesses.getIteratorStringAccesses();
	}
	public IteratorString getIteratorStringGrants() {
		return accesses.getIteratorStringGrants();
	}
	
	

}
