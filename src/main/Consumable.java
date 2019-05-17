package main;

public class Consumable implements Items{
	
	protected String consumableName;
	protected Integer consumableValue;
	protected Integer amountOwned = 0;
	protected String type;
	
	public Consumable() {
		consumableName = "unnamed consumable";
		consumableValue = 100;
	}
	
	//Over ride hashcode so can use as key in dictionary
//	public int HashCode() {
//		int HashCode = 0;
//	}
	public String getType() {
		return type;
	}
	
	public void increaseAmountOwned(int numToAdd) {
		this.amountOwned += numToAdd;
	}
	
	public void useItem() {				/// only subtracts from amount owned at the moment
		if (this.amountOwned > 0) {
			amountOwned -= 1;
		}
	}
	
	public Consumable(String tempName, int tempvalue) {
		consumableName = tempName;
		consumableValue = tempvalue;
	}
	
	public String toString() {
		return consumableName;
	}
	
	public String getName() {
		return consumableName;
	}
	
	public Integer getValue() {
		return consumableValue;
	}
	
	public int getHunger() {
		return -1;
	}
	public int getHealing() {
		return -1;
	}
	
	public static void main(String[] args) {
		Consumable defaultItem = new Consumable();
		System.out.println(defaultItem);
		
		Consumable basicItem = new Consumable("Silly item", 75);
		System.out.println(basicItem);
	}

}
