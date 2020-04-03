package securitySystem;

public enum Levels {

	OFFICIAL(0),
	CONFIDENCIAL(1),
	SECRET(2),
	TOPSECRET(3);
	
	private final int hierarchy;
	
	private Levels(int hierarchy) {
		this.hierarchy = hierarchy;
	}
	
	public int getIntLevel() {
		return hierarchy;
	}
}
