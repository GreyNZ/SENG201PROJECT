package main;

public class SpaceCandy extends FoodConsumable {

	public SpaceCandy() {
		super("SpaceCandy", 50, 10);
		
	}
	
	public static void main(String[] args) {
		SpaceCandy candy = new SpaceCandy();
		System.out.println(candy);	
	}

}
