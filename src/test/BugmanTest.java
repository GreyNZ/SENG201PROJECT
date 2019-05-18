package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.Bugman;
import main.Person;

class BugmanTest {
	private Person buggie;
	
	
	@BeforeEach
	public void init() {
		buggie = new Bugman("Buggy the Bugman", 1);
	}
	
	
	@Test
	public void nameTest() {
	    assertEquals("Buggy the Bugman", buggie.getName());
	}
	
	@Test
	public void raceTest() {
	    assertEquals("Bugman", buggie.getRace());
	}
	
	@Test
	public void repairTest() {
	    assertEquals((double)0.75, (double)buggie.getRepairValue());
	}
	
	@Test
	public void seachTest() {
	    assertEquals((double)0.5, (double)buggie.getSearchValue());
	}
	
	@Test
	public void actionsTest() {
	    assertEquals(2, (int)buggie.getActions());
	    assertEquals(2, (int)buggie.getMaxActions());
	    buggie.attemptAction();
	    assertEquals(1, (int)buggie.getActions());
	    buggie.resetActions();
	    assertEquals(2, (int)buggie.getActions());
	}
	
	@Test
	public void damageTest() {
	    buggie.decreaseHealth(50);
	    assertEquals(50, (int)buggie.getHealth());
	}
	
	@Test
	public void plagueTest() {
		assertTrue(false == buggie.getPlagueValue());
		buggie.addPlague();
	    assertTrue(buggie.getPlagueValue());
	}
	
	@Test
	public void lowerVigour() {
		assertEquals(20, (int)buggie.getVigour());
		buggie.decreaseVigourAction(20);
	    assertEquals(0, (int)buggie.getVigour());
	    buggie.personSleep();
	    assertEquals(20, (int)buggie.getVigour());
	}
	
	@Test
	public void hungerTest() {
	    buggie.getHunger();
	    assertEquals(0, (int)buggie.getHunger());
	    assertEquals(200, (int)buggie.getMaxHunger());
	    buggie.increaseHungerEndDay();
	    assertEquals(10, (int)buggie.getHunger());
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testDamage(int argument ) {
		buggie.decreaseHealth(argument);
		assertTrue((int)buggie.getHealth() >= 0 && (int)buggie.getHealth() <= 100);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testHealing(int argument ) {
		buggie.increaseHealth(argument);
		assertTrue((int)buggie.getHealth() >= 0 && (int)buggie.getHealth() <= 100);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testFood(int argument ) {
		buggie.eatFood(argument);
		assertTrue((int)buggie.getHunger() >= 0);
	}
	
	
	
	
	

}
