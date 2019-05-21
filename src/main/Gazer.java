package main;

/**
 * Gazer
 * 
 * @author Grey Harris, Cameron Bodger
 *
 */
public class Gazer extends Person {
	// example inputs (name, race, health, maxHealth, vigour, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague
	/**
	 * Gazer Person subclass.<p>
	 * @param tempName   String name 
	 * @param unique     unique int
	 */
	public Gazer(String tempName, int unique) {
		super(tempName, "Gazer", 100, 100, 100, 100, 0, 100, 1, 1, 1.0, 4.0, false, unique);
	}
}


