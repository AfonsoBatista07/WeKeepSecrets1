package documents;

import securitySystem.IteratorUser;
import users.User;

/**
 * 
 * @author Afonso Batista 57796
 * @author João Jorge 57994
 */
public class OfficialDocumentClass extends DocumentClass implements OfficialDocument{
	
	private AccessesOfficial accesses;
	
	public OfficialDocumentClass(String manager, String docName, String description) {
		super(manager, docName, description, "official", "official");
		accesses = new AccessesOfficialClass();
	}
	
	public void read(User user) {
		accesses.read(user);
	}

	public int getNumAccesses() {
		return accesses.getNumAccesses();
	}
	
	public IteratorUser getIteratorAccesses() {
		return accesses.getIteratorAccesses();
	}
}
