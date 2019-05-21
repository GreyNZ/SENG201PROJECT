package main;

/**
 * Human 
 * @author Grey Harris, Cameron Bodger
 *
 */
public class Human extends Person {

	// example inputs (name, race, health, maxHealth, vigour, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague
	/**
	 * Human {@code Person} subclass
	 * @param tempName            String name
	 * @param unqiue              int unique id
	 */
	public Human(String tempName, int unqiue) {
		super(tempName, "Human", 100, 100, 100, 100, 0, 100, 2, 2, 1.0, 1.0, false, unqiue);
	}
}
