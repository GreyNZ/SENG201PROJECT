package test;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;

import items.Medkit;

class MedkitTest {
//	private HealingConsumeable kit;
	
	
//	@BeforeEach   //Doesn't like these tests for some reason
//	public void init() {
//		Medkit kit = new Medkit();
//	}
	
	@Test
	public void nameTest() {
		Medkit kit = new Medkit();
		assertEquals((String)"Medkit", (String)kit.getName());
	}
	
	@Test
	public void healingTest() {
		Medkit kit = new Medkit();
		assertEquals((int)75, (int)kit.getHealing());
	}
	
	@Test
	public void valueTest() {
		Medkit kit = new Medkit();
		assertEquals((int)100, (int)kit.getValue());
	}
	

}
