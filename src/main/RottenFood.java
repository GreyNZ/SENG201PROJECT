package main;

public class RottenFood extends FoodConsumable {


	public RottenFood() {
		super("RottenFood", 5, 2);
		
	}
	

	
	public static void main(String[] args) {
		RottenFood rottie = new RottenFood();
		System.out.println(rottie);	
	}
}
