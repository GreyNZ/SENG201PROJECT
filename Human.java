package main;

public class Human extends Person {

	// example inputs (name, race, health, maxHealth, vigour, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague
	public Human(String tempName, int unqiue) {
		super(tempName, "Human", 100, 100, 100, 100, 0, 100, 2, 2, 1.0, 1.0, false, unqiue);
	}
	
	public static void main(String[] args) {
		Person kirk = new Human("Captain Kirk", 2);
		System.out.println(kirk);
		
		
		
	}
}
