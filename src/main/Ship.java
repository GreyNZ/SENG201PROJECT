package main;

/**
 * Ship
 * @author Grey Harris, Cameron Bodger
 *
 */
public class Ship {
	/**
	 * Name of the ship
	 */
	private String shipName;
	/**
	 * Current health of the ship hull
	 */
	private Double shipHealth = 100.0;
	/**
	 * Current ship shield level 
	 */
	private Double shipShields = 100.0;
	
	/**
	 * Ship constructor
	 * @param name     String name of the ship
	 */
	public Ship(String name) {
		this.shipName = name;
	}
	

	/**
	 * Increases shield level when a crew member repairs it.
	 * @param raiseValue      Double amount the shields are repaired
	 * @return the amount the shields are repaired
	 */
	public Double raiseShield(Double raiseValue) {
		if (this.shipShields + raiseValue > 100.0) {
			Double oldShieldValue = shipShields;
			this.shipShields = 100.0;
			return shipShields - oldShieldValue;
		}
		else {
			this.shipShields += raiseValue;
			return raiseValue;
		}
	}
	/**
	 * Decreases shield when taking asteroid damage
	 * @param lowerValue       Double amount of damage taken
	 */
	public void lowerShield(Double lowerValue) {
		if (this.shipShields - lowerValue <= 0.0) {
			this.shipShields = 0.0;
		}
		else {
			this.shipShields -= lowerValue;
		}
	}
	
	
	/**
	 * Ship takes shield and hull damage from asteroids. Shields take full damage, hull takes damage * (1 - shield %)
	 * @param damage      Double Amount of damage taken from asteroids
	 */
	public void takeDamage(Double damage) {
		Double shieldModifier = 1.2 - (this.shipShields / 100);
		this.shipHealth -=  damage * shieldModifier;
		this.lowerShield(damage);
		if (this.shipHealth <= 0.0) {
			
		}
	}
	
	/**
	 * Increases hull level when a crew member repairs it.
	 * @param repair     Double amount the shields are repaired
	 * @return the amount the hull is repaired
	 */
	public Double repairHull(Double repair) {
		Double repairResult = repair;
		Double previousHealth = shipHealth;
		if (shipHealth + repair >= 100.0) {
			shipHealth = 100.0;
			repairResult = shipHealth - previousHealth;
			return repairResult;
		}
		else {
			shipHealth += repair;
			return repairResult;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String status = String.format("Shipname: %s\nShip Health: %s\nShip Shield: %s", this.shipName, this.shipHealth, this.shipShields);
		return status;
	}
	
	/**
	 * Gets the health level of the ships hull
	 * @return ship hull health
	 */
	public Double getShipHealth() {
		return shipHealth;
	}
	/**
	 * Gets the health level of the ships shield
	 * @return ship shield level
	 */
	public Double getShipSheild() {
		return shipShields;
	}
}
