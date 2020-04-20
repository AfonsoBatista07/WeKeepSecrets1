package users;

/**
 * 
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class ClerkClass extends UserClass {

	/**
	 * Constructor of the ClerkClass, initialize variables.
	 * @param id - User ID.
	 * @param level - User Level
	 */
	public ClerkClass(String id, String level) {
		super(id, level, CLERK);
		
	}
}
