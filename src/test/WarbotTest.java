package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.Warbot;
import main.Person;

class WarbotTest {
	private Person terminator;
	
	
	@BeforeEach
	public void init() {
		terminator = new Warbot("T-9000 the Warbot", 1);
	}
	
	
	@Test
	public void nameTest() {
	    assertEquals("T-9000 the Warbot", terminator.getName());
	}
	
	@Test
	public void raceTest() {
	    assertEquals("Warbot", terminator.getRace());
	}
	
	@Test
	public void repairTest() {
	    assertEquals((double)0.5, (double)terminator.getRepairValue());
	}
	
	@Test
	public void seachTest() {
	    assertEquals((double)0.25, (double)terminator.getSearchValue());
	}
	
	@Test
	public void actionsTest() {
	    assertEquals(2, (int)terminator.getActions());
	    assertEquals(2, (int)terminator.getMaxActions());
	    terminator.attemptAction();
	    assertEquals(1, (int)terminator.getActions());
	    terminator.resetActions();
	    assertEquals(2, (int)terminator.getActions());
	}
	
	@Test
	public void damageTest() {
	    terminator.decreaseHealth(50);
	    assertEquals(100, (int)terminator.getHealth());
	}
	
	@Test
	public void plagueTest() {
		assertTrue(false == terminator.getPlagueValue());
		terminator.addPlague();
	    assertTrue(false == terminator.getPlagueValue()); // checks no plague as immune
	}
	
	@Test
	public void lowerVigour() {
		assertEquals(100, (int)terminator.getVigour());
		terminator.decreaseVigourAction(20);
	    assertEquals(100, (int)terminator.getVigour());
	    terminator.personSleep();
	    assertEquals(100, (int)terminator.getVigour());
	}
	
	@Test
	public void hungerTest() {
	    terminator.getHunger();
	    assertEquals(0, (int)terminator.getHunger());
	    assertEquals(100, (int)terminator.getMaxHunger());
	    terminator.increaseHungerEndDay();
	    assertEquals(0, (int)terminator.getHunger());
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testDamage(int argument ) {
		terminator.decreaseHealth(argument);
		assertTrue((int)terminator.getHealth() >= 0 && (int)terminator.getHealth() <= 150);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testHealing(int argument ) {
		terminator.increaseHealth(argument);
		assertTrue((int)terminator.getHealth() >= 0 && (int)terminator.getHealth() <= 150);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testFood(int argument ) {
		terminator.eatFood(argument);
		assertTrue((int)terminator.getHunger() >= 0);
	}
	
	
	
	
	

}
