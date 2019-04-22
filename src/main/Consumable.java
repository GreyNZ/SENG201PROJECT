package main;

public class Consumable {
	
	protected String consumableName;
	protected Integer consumableValue;
	
	public Consumable() {
		consumableName = "unnamed consumable";
		consumableValue = 100;
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
