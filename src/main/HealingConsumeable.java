package main;

public class HealingConsumeable extends Consumable {
	
	protected int Healing;
	
	public HealingConsumeable(String tempName, int tempvalue, int tempHealing) {
		super(tempName, tempvalue);
		Healing = tempHealing;
		type = "healing";
	}
	
	public int getHealing() {
		return this.Healing;
	}
	

	public String toLongString() {
		return String.format("Name = %s\nValue = %s\nHealing = %s", this.getName(), this.getValue(), getHealing());
	}
	public String toString() {
		return getName();
	}
	
	public static void main(String[] args) {
		HealingConsumeable basicItem = new HealingConsumeable("Silly item", 75, 50);
		System.out.println(basicItem);
	}
}
