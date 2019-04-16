package main;

public class MagicMushrooms extends FoodConsumable {

	public MagicMushrooms(String tempName, int tempvalue, int tempHunger) {
		super("MagicMushrooms", 200, 200);
		
	}
	
	public static void main(String[] args) {
		MagicMushrooms camsMusshies = new MagicMushrooms("not sure", 50, 20);
		System.out.println(camsMusshies);	
	}
}
