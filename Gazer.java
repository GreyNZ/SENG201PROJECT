package main;

public class Gazer extends Person {

	public Gazer(String tempName, int unqiue) {
		super(tempName, "Gazer", 100, 100, 100, 100, 0, 100, 1, 1, 1.0, 4.0, false, unqiue);
	}
	
	public static void main(String[] args) {
		Person gazzie = new Gazer("Gazzy the Gazer", 1);
		System.out.println(gazzie);
		
		
		
	}
	
}


// example inputs (name, race, health, maxHealth, vigour, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague