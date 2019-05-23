package person;

/**
 * Bugman
 * @author Cameron Bodger, Grey Harris
 *
 */
public class Bugman extends Person {
	/**
	 * Bugman subclass of Person
	 * @param tempName         String name of bugman
	 * @param unique           unique int identifier
	 */
	public Bugman(String tempName, int unique) {
		super(tempName, "Bugman", 100, 100, 20, 20, 0, 200, 2, 2, 0.75, 0.5, false, unique);
	}
}
