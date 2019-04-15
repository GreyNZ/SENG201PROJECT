package main;

public class Warbot extends Person {
	// example inputs (name, race, health, maxHealth, vigour, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague
	public Warbot(String tempName, int unqiue) {
		super(tempName, "Warbot", 150, 150, 100, 100, 0, 100, 2, 2, 0.5, 0.25, false, unqiue);
	}
	
//	public void addPlague() {
//		this.has_plague = false;
//	}
	
	public static void main(String[] args) {
		Person terminator = new Warbot("T-800", 6);
		System.out.println(terminator);
		
	}
}
