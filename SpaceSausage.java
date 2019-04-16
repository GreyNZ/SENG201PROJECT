package main;

public class SpaceSausage extends FoodConsumable {

	public SpaceSausage(String tempName, int tempvalue, int tempHunger) {
		super("SpaceSausage", tempvalue, 20);
		
	}
	
	public static void main(String[] args) {
		SpaceSausage saussie = new SpaceSausage("not sure", 70, 20);
		System.out.println(saussie);	
	}
}
