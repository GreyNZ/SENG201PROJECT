package test;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;

import items.Nanites;

class NanitesTest {
//	private HealingConsumeable greyGoo;
	
	
//	@BeforeEach
//	public void init() {
//		Nanites greyGoo = new Nanites();
//	}
	
	@Test
	public void nameTest() {
		Nanites greyGoo = new Nanites();
		assertEquals((String)"Nanites", (String)greyGoo.getName());
	}
	
	@Test
	public void healingTest() {
		Nanites greyGoo = new Nanites();
		assertEquals((int)200, (int)greyGoo.getHealing());
	}
	
	@Test
	public void valueTest() {
		Nanites greyGoo = new Nanites();
		assertEquals((int)150, (int)greyGoo.getValue());
	}
	

}
