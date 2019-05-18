package main;

public class PlagueConsumeable extends Consumable {
	
	protected boolean curePlague;
	
	public PlagueConsumeable(String tempName, int tempvalue, boolean tempCure) {
		super(tempName, tempvalue);
		curePlague = tempCure;
	}
	
	public boolean getCurePlague() {
		return this.curePlague;
	}
	
	public String toLongString() {
		return String.format("Name = %s\nValue = %s\nCures Plague = %s", this.getName(), this.getValue(), getCurePlague());
	}
	public String toString() {
		return getName();
	}
	
	public static void main(String[] args) {
		PlagueConsumeable basicItem = new PlagueConsumeable("Silly item", 75, true);
		System.out.println(basicItem);
	}
}
