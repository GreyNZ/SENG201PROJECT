package main;

public class RepairShip {
	
	Ship ship;
	Person person;
	
	public RepairShip(Ship ship, Person person) {
		this.ship = ship;
		this.person = person;
	}
	public String repairShipHull() {
		String s = "Ship hull repaired %.1f";
		Double repairAmount = 10.0;
		Double repairMod = person.getRepairValue();
		Double result = ship.repairHull(repairAmount * repairMod);
		return String.format(s, result) + "%";	
	}
	public String repairShipShield() {
		String s = "Ship Shield repaired %.1f";
		Double repairAmount = 40.0;
		Double repairMod = person.getRepairValue();
		Double result = ship.raiseShield(repairAmount * repairMod);
		return String.format(s, result) + "%";	
	}
	
	
}
