package main;

public class SpaceRoast extends FoodConsumable {

	public SpaceRoast() {
		super("SpaceRoast", 130, 100);
		
	}
	
	public static void main(String[] args) {
		SpaceRoast roast = new SpaceRoast();
		System.out.println(roast);	
	}

}
