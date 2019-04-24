package main;

public class SpaceApple extends FoodConsumable {
	public SpaceApple() {
		super("SpaceApple", 75, 25);
		
	}
	
	public static void main(String[] args) {
		SpaceApple apal = new SpaceApple();
		System.out.println(apal);	
	}

}
