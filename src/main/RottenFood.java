package main;

public class RottenFood extends FoodConsumable {

	public RottenFood(String tempName, int tempvalue, int tempHunger) {
		super("RottenFood", 5, 2);
		
	}
	
	public static void main(String[] args) {
		RottenFood rottie = new RottenFood("not sure", 50, 20);
		System.out.println(rottie);	
	}
}
