package main;

public class Ship {
	private String shipName;
	private Double shipHealth = 100.0;
	private Double shipShields = 100.0;
	
	public Ship(String name) {
		this.shipName = name;
	}
	
	public Double getShield() {
		return this.shipShields;
	}
	public void raiseShield(Double raiseValue) {
		if (this.shipShields + raiseValue > 100.0) {
			this.shipShields = 100.0;
		}
		else {
			this.shipShields += raiseValue;
		}
	}
	public void lowerShield(Double lowerValue) {
		if (this.shipShields - lowerValue <= 0.0) {
			this.shipShields = 0.0;
		}
		else {
			this.shipShields -= lowerValue;
		}
	}	
	
	//shields take full damage, hull takes damage * (1 - shield %)
	public void takeDamage(Double damage) {
		Double shieldModifier = 1 - (this.shipShields / 100);
		this.shipHealth -=  damage * shieldModifier;
		this.lowerShield(damage);
		if (this.shipHealth <= 0.0) {
			Game.gameOver();
		}
		

	}
	public String toString() {
		String status = String.format("Shipname: %s\nShip Health: %s\nShip Shield: %s", this.shipName, this.shipHealth, this.shipShields);
		return status;
	}
	
	public static void main(String[] args) {
		Ship newShip = new Ship("Betty");
		newShip.takeDamage(20.0);
		System.out.println(newShip);

		newShip.takeDamage(20.0);
		System.out.println(newShip);

		newShip.takeDamage(20.0);
		System.out.println(newShip);

		newShip.takeDamage(20.0);
		System.out.println(newShip);

		newShip.takeDamage(900.0);

		System.out.println(newShip);
	}
}
