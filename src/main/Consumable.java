package main;

/**
 * Item to be consumed
 * 
 * @author Grey Harris, Cameron Bodger
 *
 */
public class Consumable {
	
	/**
	 * Item name
	 */
	protected String consumableName;
	/**
	 * Cost to buy
	 */
	protected Integer consumableValue;
	/**
	 * Type of item, can be food, healing or plague cure
	 */
	protected String type;
	
	/**
	 * Consumable constructor
	 */
//	public Consumable() {
//		consumableName = "unnamed consumable";
//		consumableValue = 100;
//	}

	/**
	 * get type of consumable. Can be food, healing or plague cure
	 * 
	 * @return String type of consumable
	 */
	public String getType() {
		return type;
	}
	
	
	/**
	 * Consumable constructor. Set's name and shop value
	 * 
	 * @param tempName       String item name
	 * @param tempvalue      int cost to buy from shop
	 */
	public Consumable(String tempName, int tempvalue) {
		consumableName = tempName;
		consumableValue = tempvalue;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.object#toString()
	 */
	public String toString() {
		return consumableName;
	}
	
	/**
	 * Gets the name of the item
	 * 
	 * @return consumable name
	 */
	public String getName() {
		return consumableName;
	}
	
	/**
	 * Gets the price of the item
	 * 
	 * @return the price of the item
	 */
	public Integer getValue() {
		return consumableValue;
	}
	
	/**
	 * Gets the amount of hunger the item satiates
	 * @return
	 */
	public int getHunger() {
		return -1;
	}
	/**
	 * Gets the amount the item heals
	 * 
	 * @return
	 */
	public int getHealing() {
		return -1;
	}

}
