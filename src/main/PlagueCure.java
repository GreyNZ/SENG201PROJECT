package main;

public class PlagueCure extends PlagueConsumeable {

	public PlagueCure() {
		super("PlagueCure", 100, true);
		type = "plague";
	}

	public static void main(String[] args) {
		PlagueCure cure = new PlagueCure();
		System.out.println(cure);
	}
	
}
