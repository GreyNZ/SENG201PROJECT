package main;

public class PlagueCure extends PlagueConsumeable {

	public PlagueCure(String tempName, int tempvalue, boolean tempCure) {
		super("PlagueCure", 100, true);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		PlagueCure cure = new PlagueCure("Silly item", 75, true);
		System.out.println(cure);
	}
	
}
