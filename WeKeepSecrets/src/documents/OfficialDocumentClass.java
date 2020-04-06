package documents;

import users.User;

public class OfficialDocumentClass extends DocumentClass implements OfficialDocument{
	
	private static final int MAX_NAMES = 10;
	private AccessesOfficial accesses;
	
	public OfficialDocumentClass(String manager, String docName, String description) {
		super(manager, docName, description, "official", "official");
		accesses = new AccessesOfficialClass();
	}
	
	public void read(User user) {
		accesses.read(user);
	}

	@Override
	public int getNumAccesses() {
		return accesses.getNumAccesses();
	}
}
