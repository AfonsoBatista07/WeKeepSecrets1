package securitySystem;

/**
 * 
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public enum Levels {

	OFFICIAL(0),
	CONFIDENTIAL(1),
	SECRET(2),
	TOPSECRET(3);
	
	private final int hierarchy;
	
	private Levels(int hierarchy) {
		this.hierarchy = hierarchy;
	}
	
	public int getIntLevel() {
		return hierarchy;
	}
	
	public boolean isGreaterThan(Levels other) {
		return this.hierarchy > other.hierarchy;
	}
}

