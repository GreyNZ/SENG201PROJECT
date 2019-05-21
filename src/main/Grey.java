package main;

/**
 * Grey Person subclass
 * @author Cameron Bodger, Grey Harris
 *
 */
public class Grey extends Person {
	// example inputs (name, race, health, maxHealth, vigour, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague
	/**
	 * Grey constructor
	 * @param tempName      String name
	 * @param unqiue        int unique id
	 */
	public Grey(String tempName, int unqiue) {
		super(tempName, "Grey", 50, 50, 100, 100, 0, 100, 2, 2, 2.0, 1.5, false, unqiue);
	}
}
