package securitySystem;

/**
 * Iterates strings.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class IteratorStringClass implements IteratorString {

	private String[] accesses;
	private int counterAccesses, nextAccess; 
		
	/**
	 * Constructor of the IteratorStringClass, initialize variables.
	 * @param accesses - Array of Strings.
	 * @param counterAccesses - Array counter.
	 */
	public IteratorStringClass(String[] accesses, int counterAccesses) {
		this.counterAccesses = counterAccesses; 
		this.accesses = accesses;
		nextAccess=0;
	}
		
	public boolean hasNext() {
			return nextAccess < counterAccesses;
	}
		
	public String next() {
		return accesses[nextAccess++];
	}

}
