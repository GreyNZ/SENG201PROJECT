package main;

public class Consumable {
	
	protected String consumableName;
	protected Integer consumableValue;
	protected Integer amountOwned = 0;
	
	public Consumable() {
		consumableName = "unnamed consumable";
		consumableValue = 100;
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
		return String.format("Name = %s\nValue= %s", this.getName(), this.getValue());
	}
	
	public String getName() {
		return consumableName;
	}
	
	public Integer getValue() {
		return consumableValue;
	}
	
	public static void main(String[] args) {
		Consumable defaultItem = new Consumable();
		System.out.println(defaultItem);
		
		Consumable basicItem = new Consumable("Silly item", 75);
		System.out.println(basicItem);
	}

}
