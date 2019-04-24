package main;

public class Bandages extends HealingConsumeable {


	public Bandages() {
		super("Bandages", 50, 20);
	}
	

	public static void main(String[] args) {
		Bandages bandaid = new Bandages();
		System.out.println(bandaid);
	}
	
}
