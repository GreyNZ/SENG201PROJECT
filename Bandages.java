package main;

public class Bandages extends HealingConsumeable {

	public Bandages(String tempName, int tempvalue, int tempHealing) {
		super("Bandages", 50, 20);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Bandages bandaid = new Bandages("Silly item", 75, 10);
		System.out.println(bandaid);
	}
	
}
