package users;

/**
 * Implements an Officer.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class OfficerClass extends UserClass implements Officer{
	
	int granted, revoked;
	
	/**
	 * Constructor of the OfficerClass, initialize variables.
	 * @param id - User ID.
	 * @param level - User level.
	 */
	public OfficerClass(String id, String level) {
		super(id, level, OFFICER);
		
		granted = 0;
		revoked = 0;
	}
	
	public void incGranted() {
		granted++;
	}
	
	public int getNumGrants() {
		return granted;
	}
	
	public void incRevoked() {
		revoked++;
	}
	
	public int getNumRevokes() {
		return revoked;
	}
}
