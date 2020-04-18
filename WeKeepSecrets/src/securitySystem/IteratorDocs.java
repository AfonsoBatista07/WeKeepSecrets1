package securitySystem;

import documents.Document;

/**
 * 
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface IteratorDocs {

	/**
	 * @return True if there is a next element in the array.
	 */
	boolean hasNext();
	
	/**
	 * @return The next element from the array.
	 */
	Document next();
	
}
