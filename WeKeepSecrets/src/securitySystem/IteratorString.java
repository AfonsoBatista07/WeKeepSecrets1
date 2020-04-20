package securitySystem;

/**
 * Interface of the IteratorString that iterates strings.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface IteratorString {
		
	
	/**
	 * @return True if there is a next element in the array.
	 */
	public boolean hasNext();
	
	/**
	 * @return The next element from the array.
	 */
	public String next();
	
}
