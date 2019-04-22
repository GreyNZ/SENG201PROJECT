package main;

public class SpaceApple extends FoodConsumable {
	public SpaceApple(String tempName, int tempvalue, int tempHunger) {
		super("SpaceApple", 75, 25);
		
	}
	
	public static void main(String[] args) {
		SpaceApple apal = new SpaceApple("not sure", 50, 20);
		System.out.println(apal);	
	}

}
