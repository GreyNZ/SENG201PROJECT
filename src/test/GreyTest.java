package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.Grey;
import main.Person;

class GreyTest {
	private Person abductor;
	
	
	@BeforeEach
	public void init() {
		abductor = new Grey("Greyzilla the Grey", 1);
	}
	
	
	@Test
	public void nameTest() {
	    assertEquals("Greyzilla the Grey", abductor.getName());
	}
	
	@Test
	public void raceTest() {
	    assertEquals("Grey", abductor.getRace());
	}
	
	@Test
	public void repairTest() {
	    assertEquals((double)2.0, (double)abductor.getRepairValue());
	}
	
	@Test
	public void seachTest() {
	    assertEquals((double)1.5, (double)abductor.getSearchValue());
	}
	
	@Test
	public void actionsTest() {
	    assertEquals(2, (int)abductor.getActions());
	    assertEquals(2, (int)abductor.getMaxActions());
	    abductor.attemptAction();
	    assertEquals(1, (int)abductor.getActions());
	    abductor.resetActions();
	    assertEquals(2, (int)abductor.getActions());
	}
	
	@Test
	public void damageTest() {
	    abductor.decreaseHealth(50);
	    assertEquals(0, (int)abductor.getHealth());
	}
	
	@Test
	public void plagueTest() {
		assertTrue(false == abductor.getPlagueValue());
		abductor.addPlague();
	    assertTrue(abductor.getPlagueValue());
	}
	
	@Test
	public void lowerVigour() {
		assertEquals(100, (int)abductor.getVigour());
		abductor.decreaseVigourAction(20);
	    assertEquals(80, (int)abductor.getVigour());
	    abductor.personSleep();
	    assertEquals(100, (int)abductor.getVigour());
	}
	
	@Test
	public void hungerTest() {
	    abductor.getHunger();
	    assertEquals(0, (int)abductor.getHunger());
	    assertEquals(100, (int)abductor.getMaxHunger());
	    abductor.increaseHungerEndDay();
	    assertEquals(10, (int)abductor.getHunger());
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testDamage(int argument ) {
		abductor.decreaseHealth(argument);
		assertTrue((int)abductor.getHealth() >= 0 && (int)abductor.getHealth() <= 100);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testHealing(int argument ) {
		abductor.increaseHealth(argument);
		assertTrue((int)abductor.getHealth() >= 0 && (int)abductor.getHealth() <= 100);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 50, 100, 9999 })
	void testFood(int argument ) {
		abductor.eatFood(argument);
		assertTrue((int)abductor.getHunger() >= 0);
	}
	
	
	
	
	

}
