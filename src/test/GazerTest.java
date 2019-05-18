package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.Gazer;
import main.Person;

class GazerTest {
	private Person gazzie;
	
	
	@BeforeEach
	public void init() {
		gazzie = new Gazer("Gazzy the Gazer", 1);
	}
	
	
	@Test
	public void nameTest() {
	    assertEquals("Gazzy the Gazer", gazzie.getName());
	}
	
	@Test
	public void raceTest() {
	    assertEquals("Gazer", gazzie.getRace());
	}
	
	@Test
	public void repairTest() {
	    assertEquals((double)1.0, (double)gazzie.getRepairValue());
	}
	
	@Test
	public void seachTest() {
	    assertEquals((double)4.0, (double)gazzie.getSearchValue());
	}
	
	@Test
	public void actionsTest() {
	    assertEquals(1, (int)gazzie.getActions());
	    assertEquals(1, (int)gazzie.getMaxActions());
	    gazzie.attemptAction();
	    assertEquals(0, (int)gazzie.getActions());
	    gazzie.resetActions();
	    assertEquals(1, (int)gazzie.getActions());
	}
	
	@Test
	public void damageTest() {
	    gazzie.decreaseHealth(50);
	    assertEquals(50, (int)gazzie.getHealth());
	}
	
	@Test
	public void plagueTest() {
		assertTrue(false == gazzie.getPlagueValue());
		gazzie.addPlague();
	    assertTrue(gazzie.getPlagueValue());
	}
	
	@Test
	public void lowerVigour() {
		assertEquals(100, (int)gazzie.getVigour());
		gazzie.decreaseVigourAction(20);
	    assertEquals(80, (int)gazzie.getVigour());
	    gazzie.personSleep();
	    assertEquals(100, (int)gazzie.getVigour());
	}
	
	@Test
	public void hungerTest() {
	    gazzie.getHunger();
	    assertEquals(0, (int)gazzie.getHunger());
	    assertEquals(100, (int)gazzie.getMaxHunger());
	    gazzie.increaseHungerEndDay();
	    assertEquals(10, (int)gazzie.getHunger());
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testDamage(int argument ) {
		gazzie.decreaseHealth(argument);
		assertTrue((int)gazzie.getHealth() >= 0 && (int)gazzie.getHealth() <= 100);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testHealing(int argument ) {
		gazzie.increaseHealth(argument);
		assertTrue((int)gazzie.getHealth() >= 0 && (int)gazzie.getHealth() <= 100);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testFood(int argument ) {
		gazzie.eatFood(argument);
		assertTrue((int)gazzie.getHunger() >= 0);
	}
	
	
	
	
	

}
