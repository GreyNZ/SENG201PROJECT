package main;

public class SpaceSausage extends FoodConsumable {

	public SpaceSausage() {
		super("SpaceSausage", 30, 20);
		
	}
	
	public static void main(String[] args) {
		SpaceSausage saussie = new SpaceSausage();
		System.out.println(saussie);	
	}
}
