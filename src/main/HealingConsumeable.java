package main;

/**
 * @author c
 *
 */
public class HealingConsumeable extends Consumable {
	
	/**
	 * The amount of hp healed
	 */
	protected int Healing;
	
	/**
	 * Healing item constructor
	 * 
	 * @param tempName         String item name
	 * @param tempvalue        int price from shop
	 * @param tempHealing      int amount healed
	 */
	public HealingConsumeable(String tempName, int tempvalue, int tempHealing) {
		super(tempName, tempvalue);
		Healing = tempHealing;
		type = "healing";
	}
	
	/* (non-Javadoc)
	 * @see main.Consumable#getHealing()
	 */
	public int getHealing() {
		return this.Healing;
	}
	

	/**
	 * Returns a formatted String of item attributes
	 * 
	 * @return a formatted string with item name, price and heal amount 
	 */
	public String toLongString() {
		return String.format("Name = %s\nValue = %s\nHealing = %s", this.getName(), this.getValue(), getHealing());
	}
	
	/* (non-Javadoc)
	 * @see main.Consumable#toString()
	 */
	public String toString() {
		return getName();
	}
}
