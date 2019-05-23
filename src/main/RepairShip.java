package main;

import person.Person;

/**
 * Repair the ship
 * @author Cameron Bodger, Grey Harris
 *
 */
public class RepairShip {
	
	/**
	 * {@code Ship} object
	 */
	Ship ship;
	/**
	 * {@code Person} crew member object
	 */
	Person person;
	
	/**
	 * RepairShip constructor
	 * @param ship          {@code Ship} object
	 * @param person        {@code Person} crew member object
	 */
	public RepairShip(Ship ship, Person person) {
		this.ship = ship;
		this.person = person;
	}
	/**
	 * Repairs the ship hull
	 * @return        String representing the effects of the repair
	 */
	public String repairShipHull() {
		String s = "Ship hull repaired %.1f";
		Double repairAmount = 10.0;
		Double repairMod = person.getRepairValue();
		Double result = ship.repairHull(repairAmount * repairMod);
		return String.format(s, result) + "%";	
	}
	/**
	 * Repairs the ship shield
	 * @return        String representing the effects of the repair
	 */
	public String repairShipShield() {
		String s = "Ship Shield repaired %.1f";
		Double repairAmount = 40.0;
		Double repairMod = person.getRepairValue();
		Double result = ship.raiseShield(repairAmount * repairMod);
		return String.format(s, result) + "%";	
	}
	
	
}
