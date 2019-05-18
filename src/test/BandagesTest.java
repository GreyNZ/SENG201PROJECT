package test;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;

import main.Bandages;
//import main.HealingConsumeable;

class BandagesTest {
//	private HealingConsumeable bandage;
	
	
//	@BeforeEach
//	public void init() {
//		Bandages bandage = new Bandages();
//	}
	
	@Test
	public void nameTest() {
		Bandages bandage = new Bandages();
		assertEquals((String)"Bandages", (String)bandage.getName());
	}
	
	@Test
	public void healingTest() {
		Bandages bandage = new Bandages();
		assertEquals((int)20, (int)bandage.getHealing());
	}
	
	@Test
	public void valueTest() {
		Bandages bandage = new Bandages();
		assertEquals((int)50, (int)bandage.getValue());
	}
	

}
