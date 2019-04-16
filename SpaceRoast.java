package main;

public class SpaceRoast extends FoodConsumable {

	public SpaceRoast(String tempName, int tempvalue, int tempHunger) {
		super("SpaceRoast", 130, 100);
		
	}
	
	public static void main(String[] args) {
		SpaceRoast roast = new SpaceRoast("not sure", 50, 20);
		System.out.println(roast);	
	}

}
