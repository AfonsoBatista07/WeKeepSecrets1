package securitySystem;

public class ClassifiedDocumentClass extends DocumentClass implements ClassifiedDocument{
	private String level;
	
	private String[] action, whoAccessed, grantsRevoked, grants;
	
	private int currentAccess, currentGrant, currentRevokedGrant;
	
	private boolean isGranted, isRevoked;
	
	private static final int MAX_GRANTS = 100;

	public ClassifiedDocumentClass(String manager, String name, String level, String description) {
		super(manager, name, description);
		this.level = level;
		currentAccess = 0;
		currentGrant = 0;
		currentRevokedGrant = 0;
		
		isGranted = false;
		isRevoked = false;
		
		whoAccessed = new String[MAX_GRANTS];
		action = new String[MAX_GRANTS];
		grants = new String[MAX_GRANTS];
		grantsRevoked = new String[MAX_GRANTS];
	}
	
	public void readClassified(String userId) {
		whoAccessed[currentAccess] = userId;
		action[currentAccess]= "read";
		currentAccess++;
	}
	
	public String getLevel() {
		return level;
	}
	
	public int getNumGrants() {
		return grants.length;
	}
	
	public void addGrant(String userId) {
		if(currentGrant == grants.length) {
			resize(grants, currentGrant);
		}
		grants[currentGrant++] = userId;
		isGranted = true;
		isRevoked = false;
	}
	
	public void revokeGrant(String userId) {
		for( int i = findUser(userId); i < currentGrant-1; i++ ) {
			grants[i]= grants[i+1];
		}
		if(currentRevokedGrant == grantsRevoked.length) {
			resize(grantsRevoked, currentRevokedGrant);
		}
		grantsRevoked[currentRevokedGrant++] = userId;
		isGranted = false;
		isRevoked = true;
	}
	
	public void write(String description, String userId) {
		super.description = description;
		whoAccessed[currentAccess] = userId;
		action[currentAccess]= "write";
		currentAccess++;
	}
	
	private int findUser(String userId) {
		int i = 0;
		while ((i < currentGrant)) {
			if (grants[i].equals(userId)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	private void resize(String[] list, int current) {
		String[] sl = new String[10 * list.length];
		for (int i = 0; i < current; i++)
			sl[i] = list[i];
		list = sl;

	}
	
	public boolean isGranted() {
		return isGranted;
	}
	
	public boolean isRevoked() {
		return isRevoked;
	}

}
