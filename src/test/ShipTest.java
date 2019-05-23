package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Ship;
import person.Person;

class ShipTest {
	private Ship spaceShip;
	
//	@Before
//	public void init() {
//		Ship spaceShip = new Ship("lollipop");
//	}
	
	
	@Test
	public void nameTest() {
		Ship spaceShip = new Ship("lollipop");
		//System.out.println(spaceShip.toString());
		assertEquals("Shipname: lollipop\nShip Health: 100.0\nShip Shield: 100.0", (String)spaceShip.toString());
	}
	
	@Test
	public void getHealthTest() {
		Ship spaceShip = new Ship("lollipop");
		//System.out.println(spaceShip.toString());
		assertEquals((Double)100.0, (Double)spaceShip.getShipHealth());
	}	
	
	
	@Test
	public void getSheildTest() {
		Ship spaceShip = new Ship("lollipop");
		//System.out.println(spaceShip.toString());
		assertEquals((Double)100.0, (Double)spaceShip.getShipSheild());
	}	
	
	
	@Test
	public void repairTest() {
		Ship spaceShip = new Ship("lollipop");
		spaceShip.repairHull(20.0);
		assertEquals((Double)100.0, (Double)spaceShip.getShipSheild());
		spaceShip.repairHull(-10.0);
		spaceShip.repairHull(10.0);
		assertEquals((Double)100.0, (Double)spaceShip.getShipSheild());
	}	
	
	@Test
	public void damageTest() {
		Ship spaceShip = new Ship("lollipop");
		spaceShip.takeDamage(10.0);
		assertEquals((Double)90.0, (Double)spaceShip.getShipSheild());
		spaceShip.takeDamage(9000000.0);
		assertEquals((Double)0.0, (Double)spaceShip.getShipSheild());
	}	
	
	@Test
	public void sheildTest() {
		Ship spaceShip = new Ship("lollipop");
		spaceShip.lowerShield(10.0);
		assertEquals((Double)90.0, (Double)spaceShip.getShipSheild());
		spaceShip.raiseShield(9.0);
		assertEquals((Double)99.0, (Double)spaceShip.getShipSheild());
		spaceShip.raiseShield(9999.0);
		assertEquals((Double)100.0, (Double)spaceShip.getShipSheild());
	}	
	

}
