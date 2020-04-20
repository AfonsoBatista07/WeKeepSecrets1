package documents;

import securitySystem.IteratorUser;
import users.User;

/**
 * Implements an Official Document.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class OfficialDocumentClass extends DocumentClass implements OfficialDocument{
	
	private AccessesOfficial accesses;
	private static final String OFFICIAL = "official";
	
	/**
	 * Constructor of the OfficialDocumentClass and initialization of variables.
	 * @param manager Name of the User Managing the Document.
	 * @param docName - Name of the Document.
	 * @param description - Description of the Document.
	 */
	public OfficialDocumentClass(String manager, String docName, String description) {
		super(manager, docName, description, OFFICIAL, OFFICIAL);
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
