package main;

public class Bugman extends Person {
	// example inputs (name, race, health, maxHealth, vigour, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague
	public Bugman(String tempName, int unqiue) {
		super(tempName, "Bugman", 100, 100, 20, 20, 0, 200, 2, 2, 0.75, 0.5, false, unqiue);
	}
}
