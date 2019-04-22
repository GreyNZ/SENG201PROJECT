package main;

public class SpaceCandy extends FoodConsumable {

	public SpaceCandy(String tempName, int tempvalue, int tempHunger) {
		super("SpaceCandy", 50, 10);
		
	}
	
	public static void main(String[] args) {
		SpaceCandy candy = new SpaceCandy("not sure", 50, 20);
		System.out.println(candy);	
	}

}
