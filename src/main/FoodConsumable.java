package main;

public class FoodConsumable extends Consumable {
	
	protected int Hunger;
	
	public FoodConsumable(String tempName, int tempvalue, int tempHunger) {
		super(tempName, tempvalue);
		Hunger = tempHunger;
		type = "food";
	}
	
	public int getHunger() {
		return this.Hunger;
	}
	
	public String toLongString() {
		return String.format("Name = %s\nValue = %s\nHunger = %s", this.getName(), this.getValue(), getHunger());
	}
	
	public String toString() {
		return getName();
	}
	
	public static void main(String[] args) {
		FoodConsumable basicItem = new FoodConsumable("Silly item", 75, 50);
		System.out.println(basicItem);
	}
}
