package main;

public class Rockman extends Person{
	// example inputs (name, race, health, maxHealth, vigour, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague
	public Rockman(String tempName, int unqiue) {
		super(tempName, "Rockman", 200, 200, 200, 200, 0, 150, 1, 1, 0.5, 1.0, false, unqiue);
	}
	
	public void addPlague() {
		this.has_plague = false;
	}
}
