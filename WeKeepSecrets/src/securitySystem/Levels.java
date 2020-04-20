package securitySystem;

/**
 * A enumeration for the Levels of the hierarchy.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public enum Levels {

	OFFICIAL(0),
	CONFIDENTIAL(1),
	SECRET(2),
	TOPSECRET(3);
	
	private final int hierarchy;
	
	/**
	 * Constructor of Levels, initialize variables.
	 * @param hierarchy - The level in hierarchy.
	 */
	private Levels(int hierarchy) {
		this.hierarchy = hierarchy;
	}
	
	/**
	 * @return The level in hierarchy.
	 */
	public int getIntLevel() {
		return hierarchy;
	}
	
	/**
	 * @param other - Other level.
	 * @return True if the level is higher in the hierarchy.
	 */
	public boolean isGreaterThan(Levels other) {
		return this.hierarchy > other.hierarchy;
	}
}

