package person;

/**
 * Rockman
 * @author Cameron Bodger, Grey Harris
 *
 */
public class Rockman extends Person{
	// example inputs (name, race, health, maxHealth, vigour, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague
	/**
	 * Rockman subclass of Person
	 * @param tempName          String name
	 * @param unique            int unique id
	 */
	public Rockman(String tempName, int unique) {
		super(tempName, "Rockman", 200, 200, 200, 200, 0, 150, 1, 1, 0.5, 1.0, false, unique);
	}
	

	/* (non-Javadoc)
	 * @see main.Person#addPlague()
	 */
	@Override
	public void addPlague() {
		this.has_plague = false;
	}
}
