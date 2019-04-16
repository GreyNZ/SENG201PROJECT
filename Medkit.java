package main;

public class Medkit extends HealingConsumeable {

	public Medkit(String tempName, int tempvalue, int tempHealing) {
		super("Medkit", 100, 75);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Medkit meds = new Medkit("Silly item", 75, 10);
		System.out.println(meds);
	}
	
}
