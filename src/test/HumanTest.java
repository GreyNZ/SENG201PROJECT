package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import person.Human;
import person.Person;

class HumanTest {
	private Person earthling;
	
	
	@BeforeEach
	public void init() {
		earthling = new Human("Humie the Human", 1);
	}
	
	
	@Test
	public void nameTest() {
	    assertEquals("Humie the Human", earthling.getName());
	}
	
	@Test
	public void raceTest() {
	    assertEquals("Human", earthling.getRace());
	}
	
	@Test
	public void repairTest() {
	    assertEquals((double)1.0, (double)earthling.getRepairValue());
	}
	
	@Test
	public void seachTest() {
	    assertEquals((double)1.0, (double)earthling.getSearchValue());
	}
	
	@Test
	public void actionsTest() {
	    assertEquals(2, (int)earthling.getActions());
	    assertEquals(2, (int)earthling.getMaxActions());
	    earthling.attemptAction();
	    assertEquals(1, (int)earthling.getActions());
	    earthling.resetActions();
	    assertEquals(2, (int)earthling.getActions());
	}
	
	@Test
	public void damageTest() {
	    earthling.decreaseHealth(50);
	    assertEquals(50, (int)earthling.getHealth());
	}
	
	@Test
	public void plagueTest() {
		assertTrue(false == earthling.getPlagueValue());
		earthling.addPlague();
	    assertTrue(earthling.getPlagueValue());
	}
	
	@Test
	public void lowerVigour() {
		assertEquals(100, (int)earthling.getVigour());
		earthling.decreaseVigourAction(20);
	    assertEquals(80, (int)earthling.getVigour());
	    earthling.personSleep();
	    assertEquals(100, (int)earthling.getVigour());
	}
	
	@Test
	public void hungerTest() {
	    earthling.getHunger();
	    assertEquals(0, (int)earthling.getHunger());
	    assertEquals(100, (int)earthling.getMaxHunger());
	    earthling.increaseHungerEndDay();
	    assertEquals(10, (int)earthling.getHunger());
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testDamage(int argument ) {
		earthling.decreaseHealth(argument);
		assertTrue((int)earthling.getHealth() >= 0 && (int)earthling.getHealth() <= 100);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testHealing(int argument ) {
		earthling.increaseHealth(argument);
		assertTrue((int)earthling.getHealth() >= 0 && (int)earthling.getHealth() <= 100);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testFood(int argument ) {
		earthling.eatFood(argument);
		assertTrue((int)earthling.getHunger() >= 0);
	}
	
	
	
	
	

}
