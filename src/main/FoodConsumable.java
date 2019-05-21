package main;

/**
 * Food item superclass. Extends {@code Consumable}
 * @author Cameron Bodger, Grey Harris
 *
 */
public class FoodConsumable extends Consumable {
	
	/**
	 * The amount of hunger that is healed
	 */
	protected int Hunger;
	
	/**
	 * Food item constructor
	 * 
	 * @param tempName        String item name
	 * @param tempvalue       int price from shop
	 * @param tempHunger      int amount of hunger satiated
	 */
	public FoodConsumable(String tempName, int tempvalue, int tempHunger) {
		super(tempName, tempvalue);
		Hunger = tempHunger;
		type = "food";
	}
	
	/* (non-Javadoc)
	 * @see main.Consumable#getHunger()
	 */
	public int getHunger() {
		return this.Hunger;
	}
	
	/**
	 * Returns a formatted String of item attributes
	 * @return a formatted string with item name, price and hunger 
	 */
	public String toLongString() {
		return String.format("Name = %s\nValue = %s\nHunger = %s", 
				this.getName(), this.getValue(), getHunger());
	}
	
	/* (non-Javadoc)
	 * @see main.Consumable#toString()
	 */
	public String toString() {
		return getName();
	}
	
}
