package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import person.Person;
import person.Rockman;

class RockmanTest {
	private Person rockie;
	
	
	@BeforeEach
	public void init() {
		rockie = new Rockman("Rocky the Rockman", 1);
	}
	
	
	@Test
	public void nameTest() {
	    assertEquals("Rocky the Rockman", rockie.getName());
	}
	
	@Test
	public void raceTest() {
	    assertEquals("Rockman", rockie.getRace());
	}
	
	@Test
	public void repairTest() {
	    assertEquals((double)0.5, (double)rockie.getRepairValue());
	}
	
	@Test
	public void seachTest() {
	    assertEquals((double)1.0, (double)rockie.getSearchValue());
	}
	
	@Test
	public void actionsTest() {
	    assertEquals(1, (int)rockie.getActions());
	    assertEquals(1, (int)rockie.getMaxActions());
	    rockie.attemptAction();
	    assertEquals(0, (int)rockie.getActions());
	    rockie.resetActions();
	    assertEquals(1, (int)rockie.getActions());
	}
	
	@Test
	public void damageTest() {
	    rockie.decreaseHealth(50);
	    assertEquals(150, (int)rockie.getHealth());
	}
	
	@Test
	public void plagueTest() {
		assertTrue(false == rockie.getPlagueValue());
		rockie.addPlague();
	    assertTrue(false == rockie.getPlagueValue());  //checking no plague as Rockmen can't get plague
	}
	
	@Test
	public void lowerVigour() {
		assertEquals(200, (int)rockie.getVigour());
		rockie.decreaseVigourAction(20);
	    assertEquals(180, (int)rockie.getVigour());
	    rockie.personSleep();
	    assertEquals(200, (int)rockie.getVigour());
	}
	
	@Test
	public void hungerTest() {
	    rockie.getHunger();
	    assertEquals(0, (int)rockie.getHunger());
	    assertEquals(150, (int)rockie.getMaxHunger());
	    rockie.increaseHungerEndDay();
	    assertEquals(10, (int)rockie.getHunger());
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testDamage(int argument ) {
		rockie.decreaseHealth(argument);
		assertTrue((int)rockie.getHealth() >= 0 && (int)rockie.getHealth() <= 200);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testHealing(int argument ) {
		rockie.increaseHealth(argument);
		assertTrue((int)rockie.getHealth() >= 0 && (int)rockie.getHealth() <= 200);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testFood(int argument ) {
		rockie.eatFood(argument);
		assertTrue((int)rockie.getHunger() >= 0);
	}
	
	
	
	
	

}
