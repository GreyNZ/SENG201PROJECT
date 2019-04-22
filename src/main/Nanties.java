package main;

public class Nanties extends HealingConsumeable {

	public Nanties(String tempName, int tempvalue, int tempHealing) {
		super("Nanties", 150, 200);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Nanties medical = new Nanties("Silly item", 75, 10);
		System.out.println(medical);
	}
	
}
