package main;

public class Nanites extends HealingConsumeable {

	public Nanites() {
		super("Nanites", 150, 200);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Nanites medical = new Nanites();
		System.out.println(medical);
	}
	
}
