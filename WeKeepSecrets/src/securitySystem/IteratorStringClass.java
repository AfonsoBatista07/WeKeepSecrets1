package securitySystem;

public class IteratorStringClass implements IteratorString {

	private String[] accesses;
	private int counterAccesses, nextAccess; 
		
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
