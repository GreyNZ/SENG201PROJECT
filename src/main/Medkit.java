package main;

public class Medkit extends HealingConsumeable {

	public Medkit() {
		super("Medkit", 100, 75);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Medkit meds = new Medkit();
		System.out.println(meds);
	}
	
}
